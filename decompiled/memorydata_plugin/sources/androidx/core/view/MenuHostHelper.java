package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        LifecycleContainer(Lifecycle r3, LifecycleEventObserver r4) {
            LifecycleEventObserver r5 = (LifecycleEventObserver) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
            this.mLifecycle = r3;
            this.mObserver = r5;
            r3.addObserver(r5);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    public MenuHostHelper(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r4;
    }

    public void addMenuProvider(MenuProvider r3) {
        MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        this.mMenuProviders.add(r4);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(MenuProvider r4, LifecycleOwner r5) {
        final MenuProvider r6 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r4, MenuProvider.class, "com.obric.memorydata.plugin");
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
        addMenuProvider(r6);
        Lifecycle r8 = r7.getLifecycle();
        LifecycleContainer r0 = (LifecycleContainer) ZeusTransformUtils.preCheckCast(this.mProviderToLifecycleContainers.remove(r6), LifecycleContainer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new $$Lambda$MenuHostHelper$yJLrCbQs1VMDQObUI1XiFiSaTs(this, r6);
        this.mProviderToLifecycleContainers.put(r6, new LifecycleContainer(r8, r1));
    }

    public void addMenuProvider(MenuProvider r4, LifecycleOwner r5, final Lifecycle.State r6) {
        final MenuProvider r7 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r4, MenuProvider.class, "com.obric.memorydata.plugin");
        Lifecycle r8 = ((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle();
        LifecycleContainer r0 = (LifecycleContainer) ZeusTransformUtils.preCheckCast(this.mProviderToLifecycleContainers.remove(r7), LifecycleContainer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new $$Lambda$MenuHostHelper$VnUJXnvHt4N_mEoh2slqiieT0pg(this, r6, r7);
        this.mProviderToLifecycleContainers.put(r7, new LifecycleContainer(r8, r1));
    }

    public /* synthetic */ void lambda$addMenuProvider$0$MenuHostHelper(MenuProvider r3, LifecycleOwner r4, Lifecycle.Event r5) {
        MenuProvider r6 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        LifecycleOwner r7 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin");
        if (r5 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r6);
        return;
    }

    public /* synthetic */ void lambda$addMenuProvider$1$MenuHostHelper(Lifecycle.State r3, MenuProvider r4, LifecycleOwner r5, Lifecycle.Event r6) {
        MenuProvider r7 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r4, MenuProvider.class, "com.obric.memorydata.plugin");
        LifecycleOwner r8 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
        if (r6 != Lifecycle.Event.upTo(r3)) goto L6;
        addMenuProvider(r7);
        return;
    L6:
        if (r6 != Lifecycle.Event.ON_DESTROY) goto L9;
        removeMenuProvider(r7);
        return;
    L9:
        if (r6 != Lifecycle.Event.downFrom(r3)) goto L14;
        this.mMenuProviders.remove(r7);
        this.mOnInvalidateMenuCallback.run();
        return;
    }

    public void onCreateMenu(Menu r4, MenuInflater r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        Iterator<MenuProvider> r3 = this.mMenuProviders.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MenuProvider) ZeusTransformUtils.preCheckCast(r3.next(), MenuProvider.class, "com.obric.memorydata.plugin")).onCreateMenu(r6, r5);
        goto L4
    }

    public void onMenuClosed(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        Iterator<MenuProvider> r3 = this.mMenuProviders.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MenuProvider) ZeusTransformUtils.preCheckCast(r3.next(), MenuProvider.class, "com.obric.memorydata.plugin")).onMenuClosed(r5);
        goto L4
    }

    public boolean onMenuItemSelected(MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        Iterator<MenuProvider> r3 = this.mMenuProviders.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((MenuProvider) ZeusTransformUtils.preCheckCast(r3.next(), MenuProvider.class, "com.obric.memorydata.plugin")).onMenuItemSelected(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onPrepareMenu(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        Iterator<MenuProvider> r3 = this.mMenuProviders.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((MenuProvider) ZeusTransformUtils.preCheckCast(r3.next(), MenuProvider.class, "com.obric.memorydata.plugin")).onPrepareMenu(r5);
        goto L4
    }

    public void removeMenuProvider(MenuProvider r3) {
        MenuProvider r4 = (MenuProvider) ZeusTransformUtils.wrapperContextForParams(r3, MenuProvider.class, "com.obric.memorydata.plugin");
        this.mMenuProviders.remove(r4);
        LifecycleContainer r5 = (LifecycleContainer) ZeusTransformUtils.preCheckCast(this.mProviderToLifecycleContainers.remove(r4), LifecycleContainer.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        r5.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }
}
