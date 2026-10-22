package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuHostHelper {
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders;
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<MenuProvider, LifecycleContainer> mProviderToLifecycleContainers;

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        LifecycleContainer(@NonNull Lifecycle r10, @NonNull LifecycleEventObserver r11) {
            this.mLifecycle = r10;
            this.mObserver = r11;
            r10.addObserver(r11);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable r10) {
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r10;
    }

    public static /* synthetic */ void a(MenuHostHelper r10, Lifecycle.State r11, MenuProvider r12, LifecycleOwner r13, Lifecycle.Event r14) {
        r10.lambda$addMenuProvider$1(r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(MenuHostHelper r10, MenuProvider r11, LifecycleOwner r12, Lifecycle.Event r13) {
        r10.lambda$addMenuProvider$0(r11, r12, r13);
    }

    private /* synthetic */ void lambda$addMenuProvider$0(MenuProvider r10, LifecycleOwner r11, Lifecycle.Event r12) {
        if (r12 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r10);
        return;
    }

    private /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State r10, MenuProvider r11, LifecycleOwner r12, Lifecycle.Event r13) {
        if (r13 != Lifecycle.Event.upTo(r10)) goto L6;
        addMenuProvider(r11);
        return;
    L6:
        if (r13 != Lifecycle.Event.ON_DESTROY) goto L9;
        removeMenuProvider(r11);
        return;
    L9:
        if (r13 != Lifecycle.Event.downFrom(r10)) goto L14;
        this.mMenuProviders.remove(r11);
        this.mOnInvalidateMenuCallback.run();
        return;
    }

    public void addMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuProviders.add(r10);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(@NonNull final MenuProvider r10, @NonNull LifecycleOwner r11) {
        addMenuProvider(r10);
        Lifecycle r12 = r11.getLifecycle();
        LifecycleContainer r13 = this.mProviderToLifecycleContainers.remove(r10);
        if (r13 == null) goto L5;
        r13.clearObservers();
    L5:
        LifecycleEventObserver r14 = new d(this, r10);
        this.mProviderToLifecycleContainers.put(r10, new LifecycleContainer(r12, r14));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull final Lifecycle.State r12) {
        Lifecycle r13 = r11.getLifecycle();
        LifecycleContainer r14 = this.mProviderToLifecycleContainers.remove(r10);
        if (r14 == null) goto L5;
        r14.clearObservers();
    L5:
        LifecycleEventObserver r15 = new e(this, r12, r10);
        this.mProviderToLifecycleContainers.put(r10, new LifecycleContainer(r13, r15));
    }

    public void onCreateMenu(@NonNull Menu r10, @NonNull MenuInflater r11) {
        Iterator<MenuProvider> r12 = this.mMenuProviders.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onCreateMenu(r10, r11);
        goto L4
    }

    public void onMenuClosed(@NonNull Menu r10) {
        Iterator<MenuProvider> r11 = this.mMenuProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onMenuClosed(r10);
        goto L4
    }

    public boolean onMenuItemSelected(@NonNull MenuItem r10) {
        Iterator<MenuProvider> r11 = this.mMenuProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r11.next().onMenuItemSelected(r10) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onPrepareMenu(@NonNull Menu r10) {
        Iterator<MenuProvider> r11 = this.mMenuProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onPrepareMenu(r10);
        goto L4
    }

    public void removeMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuProviders.remove(r10);
        LifecycleContainer r11 = this.mProviderToLifecycleContainers.remove(r10);
        if (r11 == null) goto L5;
        r11.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }
}
