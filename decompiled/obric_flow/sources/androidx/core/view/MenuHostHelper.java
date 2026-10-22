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

    public static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        public LifecycleContainer(@NonNull Lifecycle r5, @NonNull LifecycleEventObserver r10) {
            this.mLifecycle = r5;
            this.mObserver = r10;
            r5.addObserver(r10);
        }

        public void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable r5) {
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r5;
    }

    public static /* synthetic */ void a(MenuHostHelper r5, Lifecycle.State r10, MenuProvider r11, LifecycleOwner r12, Lifecycle.Event r13) {
        r5.lambda$addMenuProvider$1(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(MenuHostHelper r5, MenuProvider r10, LifecycleOwner r11, Lifecycle.Event r12) {
        r5.lambda$addMenuProvider$0(r10, r11, r12);
    }

    private /* synthetic */ void lambda$addMenuProvider$0(MenuProvider r5, LifecycleOwner r10, Lifecycle.Event r11) {
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r5);
        return;
    }

    private /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State r5, MenuProvider r10, LifecycleOwner r11, Lifecycle.Event r12) {
        if (r12 != Lifecycle.Event.upTo(r5)) goto L6;
        addMenuProvider(r10);
        return;
    L6:
        if (r12 != Lifecycle.Event.ON_DESTROY) goto L9;
        removeMenuProvider(r10);
        return;
    L9:
        if (r12 != Lifecycle.Event.downFrom(r5)) goto L14;
        this.mMenuProviders.remove(r10);
        this.mOnInvalidateMenuCallback.run();
        return;
    }

    public void addMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuProviders.add(r5);
        this.mOnInvalidateMenuCallback.run();
    }

    public void onCreateMenu(@NonNull Menu r5, @NonNull MenuInflater r10) {
        Iterator<MenuProvider> r11 = this.mMenuProviders.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCreateMenu(r5, r10);
        goto L4
    }

    public void onMenuClosed(@NonNull Menu r5) {
        Iterator<MenuProvider> r10 = this.mMenuProviders.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onMenuClosed(r5);
        goto L4
    }

    public boolean onMenuItemSelected(@NonNull MenuItem r5) {
        Iterator<MenuProvider> r10 = this.mMenuProviders.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().onMenuItemSelected(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onPrepareMenu(@NonNull Menu r5) {
        Iterator<MenuProvider> r10 = this.mMenuProviders.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onPrepareMenu(r5);
        goto L4
    }

    public void removeMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuProviders.remove(r5);
        LifecycleContainer r10 = this.mProviderToLifecycleContainers.remove(r5);
        if (r10 == null) goto L5;
        r10.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(@NonNull final MenuProvider r5, @NonNull LifecycleOwner r10) {
        addMenuProvider(r5);
        Lifecycle r11 = r10.getLifecycle();
        LifecycleContainer r12 = this.mProviderToLifecycleContainers.remove(r5);
        if (r12 == null) goto L5;
        r12.clearObservers();
    L5:
        LifecycleEventObserver r13 = new f(this, r5);
        this.mProviderToLifecycleContainers.put(r5, new LifecycleContainer(r11, r13));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final MenuProvider r5, @NonNull LifecycleOwner r10, @NonNull final Lifecycle.State r11) {
        Lifecycle r12 = r10.getLifecycle();
        LifecycleContainer r13 = this.mProviderToLifecycleContainers.remove(r5);
        if (r13 == null) goto L5;
        r13.clearObservers();
    L5:
        LifecycleEventObserver r14 = new e(this, r11, r5);
        this.mProviderToLifecycleContainers.put(r5, new LifecycleContainer(r12, r14));
    }
}
