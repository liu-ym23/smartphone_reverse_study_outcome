package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PluginHost implements ViewModelStoreOwner {
    private static final String ARGS_PLUGIN_HOST_HASH = "Browser#PluginHostHash";
    private static final String TAG_CLASS = "PluginHost";
    protected final String TAG;
    private FragmentActivity activity;
    private final List<Plugin> attachedPlugins;
    private WeakReference<Delegate> delegateRef;
    private boolean destroyed;
    private final List<PluginHostAbility> hostAbilities;
    private PluginMounter pluginMounter;
    private PluginList pluginsWithMetaData;
    private UIState savedUIState;
    private UIContainer uiContainer;
    private final ViewModelStore viewModelStore;

    public interface Delegate {

        /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost$Delegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Fragment $default$getHostFragment(Delegate r0) {
                return null;
            }
        }

        FragmentActivity getActivity();

        Fragment getHostFragment();

        LifecycleOwner getLifecycleOwner();

        PluginListProvider getPluginListProvider();
    }

    public interface Factory {
        PluginHost createPluginHost();
    }

    private void checkState() {
        if (this.destroyed == false) goto L6;
        Log.e(this.TAG, new IllegalStateException("getViewModelStore after destroyed !").toString());
        return;
    }

    public Delegate getDelegate() {
        return this.delegateRef.get();
    }

    public Fragment getHostFragment() {
        WeakReference<Delegate> r0 = this.delegateRef;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.get() == null) goto L7;
        return this.delegateRef.get().getHostFragment();
    }

    public LifecycleOwner getLifecycleOwner() {
        Delegate r0 = this.delegateRef.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLifecycleOwner();
    }

    public PluginMounter getPluginMounter() {
        PluginMounter r0 = this.pluginMounter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new DefaultPluginMounter(this);
    }

    public List<Plugin> getPluginsReadOnly() {
        return Collections.unmodifiableList(this.attachedPlugins);
    }

    public void onDestroy() {
        Log.i(this.TAG, "onDestroy");
    L4:
        if (this.attachedPlugins.isEmpty() == true) goto L6;
        detachPlugin((Plugin) ListProtector.get(this.attachedPlugins, 0));
        goto L4
    L6:
        getViewModelStore().clear();
        getPluginMounter().release();
        this.activity = null;
        this.uiContainer = null;
        this.destroyed = true;
    }

    public boolean onDispatchBackPressed() {
        Log.i(this.TAG, "onDispatchBackPressed");
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Plugin r1 = r0.next();
        if ((r1 instanceof BackPressHandler) == false) goto L4;
        if (((BackPressHandler) r1).onBackPressed() == false) goto L4;
        Log.i(this.TAG, "Back press consumed by plugin:" + r1);
        return true;
    L11:
        return false;
    }

    public void onDispatchOnPause() {
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPause(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(null);
    }

    public void onDispatchOnResume() {
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onResume(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(this);
    }

    public void onDispatchOnStart() {
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStart(this);
        goto L4
    }

    public void onDispatchOnStop() {
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStop(this);
        goto L4
    }

    public PluginHost() {
        this.TAG = "PluginHost#" + Integer.toHexString(hashCode());
        this.attachedPlugins = new CopyOnWriteArrayList();
        this.viewModelStore = new ViewModelStore();
        this.hostAbilities = new ArrayList();
    }

    public Context getContext() {
        return getActivity();
    }

    public ViewModelStore getViewModelStore() {
        checkState();
        return this.viewModelStore;
    }

    public FragmentActivity getActivity() {
        return this.activity;
    }

    public UIContainer getUIContainer() {
        return this.uiContainer;
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public static PluginHost fromFragment(Fragment r5) throws PluginInfoExtractException {
        Bundle r0 = r5.getArguments();
        if (r0 == null) goto L5;
        int r1 = r0.getInt(ARGS_PLUGIN_HOST_HASH, PluginList.LEVEL_NOT_SET);
    L7:
        if (r1 == Integer.MIN_VALUE) goto L17;
        Iterator<PluginHost> r2 = PluginRuntime.getInstance().allPluginHost().iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        PluginHost r3 = r2.next();
        if (r3.hashCode() != r1) goto L10;
        return r3;
    L15:
        throw new PluginInfoExtractException("No matched plugin host found :" + r1 + "," + r5);
    L17:
        throw new PluginInfoExtractException("No plugin info found :" + r1 + "," + r5);
    L5:
        r1 = PluginList.LEVEL_NOT_SET;
        goto L7
    }

    public final void addPlugins(PluginList r2) {
        this.pluginsWithMetaData = PluginList.merge(this.pluginsWithMetaData, r2);
        UIContainer r3 = this.uiContainer;
        if (r3 == null) goto L5;
        r3.getLayoutStrategy().updateLayoutStrategy(this.pluginsWithMetaData);
    L5:
        getPluginMounter().mountPlugins(this.pluginsWithMetaData);
    }

    public void attachPlugin(Plugin r2) {
        if (isPluginAttached(r2) == true) goto L8;
        this.attachedPlugins.add(r2);
        r2.onAttachToHost(this);
        if (this.uiContainer == null) goto L9;
        attachPluginUIContainer(r2);
        return;
    L9:
        return;
    }

    public void attachPluginUIContainer(Plugin r2) {
        r2.onAttachToUIContainer(this, this.uiContainer);
    }

    public void detachPlugin(Plugin r2) {
        if (this.attachedPlugins.contains(r2) == false) goto L9;
        this.attachedPlugins.remove(r2);
        if (this.uiContainer == null) goto L7;
        detachPluginUIContainer(r2);
    L7:
        r2.onDetachFromHost(this);
        return;
    }

    public void detachPluginUIContainer(Plugin r2) {
        r2.onDetachFromUIContainer(this, this.uiContainer);
    }

    public <P extends Plugin<?>> P findPlugin(Class<P> r5) {
        if (r5 == null) goto L4;
        P r0 = (P) this.pluginsWithMetaData.findPlugin(r5);
    L5:
        if (r0 == null) goto L7;
        getPluginMounter().onFindPlugin(r0);
    L8:
        return r0;
    L7:
        Log.w(this.TAG, "Plugin not found with type:" + r5);
        goto L8
    L4:
        r0 = null;
        goto L5
    }

    public Plugin findPluginByInterface(Class<?> r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.pluginsWithMetaData.findPluginByInterface(r2);
    }

    public <T extends PluginHostAbility> T getHostAbility(Class<T> r4) {
        T r0 = (T) getHostAbilityOrNull(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("No host ability:" + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends PluginHostAbility> T getHostAbilityOrNull(Class<T> r4) {
        Iterator<PluginHostAbility> r0 = this.hostAbilities.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T r1 = (T) r0.next();
        if (r4.isInstance(r1) == false) goto L4;
        getPluginMounter().onFindAbility(r1);
        return r1;
    L10:
        if (r4.isInstance(this) == true) goto L12;
        return null;
    L12:
        return (T) this;
    }

    public boolean isPluginAttached(Plugin r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.attachedPlugins.contains(r2) == false) goto L6;
        return true;
    }

    public void onCreate(Delegate r3) {
        Log.i(this.TAG, "onCreate");
        setDelegate(r3);
        this.activity = r3.getActivity();
        this.destroyed = false;
        this.pluginsWithMetaData = PluginList.newList(new PluginList.Metadata[0]);
    }

    public void onDispatchConfigurationChanged(Configuration r3) {
        Log.i(this.TAG, "onDispatchConfigurationChanged");
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onConfigurationChanged(r3);
        goto L4
    }

    public void onDispatchUIAttach(UIContainer r3) {
        Log.i(this.TAG, "onDispatchUIAttach");
        this.uiContainer = r3;
        r3.restoreUIState(this.savedUIState);
        r3.getLayoutStrategy().updateLayoutStrategy(this.pluginsWithMetaData);
        Iterator<Plugin> r4 = this.attachedPlugins.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        attachPluginUIContainer(r4.next());
        goto L4
    }

    public void onDispatchUIDetach(UIContainer r3) {
        Log.i(this.TAG, "onDispatchUIDetach");
        this.savedUIState = r3.saveUIState();
        Iterator<Plugin> r4 = this.attachedPlugins.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        detachPluginUIContainer(r4.next());
        goto L4
    L6:
        this.uiContainer = null;
    }

    public void onDispatchUserVisibleHint(boolean r4) {
        Log.i(this.TAG, "onDispatchUserVisibleHint:" + r4);
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setUserVisibleHint(r4);
        goto L4
    }

    public void registerHostAbility(PluginHostAbility r2) {
        if (this.hostAbilities.contains(r2) == true) goto L6;
        this.hostAbilities.add(r2);
        return;
    }

    public void setDelegate(Delegate r2) {
        this.delegateRef = new WeakReference(r2);
    }

    public void setPluginMounter(PluginMounter r4) {
        Log.i(this.TAG, "setPluginMounter:" + r4);
        this.pluginMounter = r4;
    }

    public void unregisterHostAbility(PluginHostAbility r2) {
        this.hostAbilities.remove(r2);
    }

    public static <Host> Host fromFragment(Fragment r1, Class<Host> r2) throws PluginInfoExtractException {
        Host r3 = (Host) fromFragment(r1);
        if (r3.getClass().isAssignableFrom(r2) == false) goto L6;
        return r3;
    L6:
        throw new PluginInfoExtractException("fromFragment");
    }

    public static void writePluginHostToBundle(Fragment r0, Bundle r1) {
        writePluginHostToBundle(r1, fromFragment(r0));     // Catch: PluginInfoExtractException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG_CLASS, e.toString());
    }

    public <P extends Plugin<?>> void findPluginToDo(Class<P> r1, PluginFindAction<P> r2) {
        Plugin r3 = findPlugin(r1);
        if (r3 == null) goto L7;
        if (r2 == null) goto L8;
        r2.onPluginFound(r3);
        return;
    L8:
        return;
    }

    public static void writePluginHostToBundle(Bundle r1, PluginHost r2) {
        r1.putInt(ARGS_PLUGIN_HOST_HASH, r2.hashCode());
    }

    public static void writePluginHostToBundle(Bundle r0, Plugin r1) {
        writePluginHostToBundle(r0, r1.getHost());
    }

    public void onDispatchActivityResult(int r4, int r5, Intent r6) {
        Log.i(this.TAG, "onDispatchActivityResult:" + r4 + "," + r5);
        Iterator<Plugin> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Plugin r1 = r0.next();
        if ((r1 instanceof ActivityResultHandler) == false) goto L4;
        ((ActivityResultHandler) r1).onActivityResult(r4, r5, r6);
        goto L4
    }
}
