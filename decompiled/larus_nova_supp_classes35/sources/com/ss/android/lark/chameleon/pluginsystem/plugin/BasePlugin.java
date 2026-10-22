package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BasePlugin<H extends PluginHost> implements Plugin<H> {
    private static final String TAG = "BasePlugin";
    private H host;

    public BasePlugin() {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public boolean isViewImmersive() {
        return false;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onAttachToUIContainer(H r1, UIContainer r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onDetachFromHost(H r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onDetachFromUIContainer(H r1, UIContainer r2) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public final /* synthetic */ void onPause(PluginHost r1) {
        Plugin.CC.$default$onPause(this, r1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onResume(H r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onStart(H r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onStop(H r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void setUserVisibleHint(boolean r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public H getHost() {
        if (this.host != null) goto L6;
        Log.e(TAG, new IllegalStateException("getHost when plugin not attached or already detached !").toString());
    L6:
        return this.host;
    }

    public UIContainer getUIContainer() throws IllegalStateException {
        UIContainer r0 = this.host.getUIContainer();
        if (r0 != null) goto L5;
        Log.e(TAG, new IllegalStateException("GetUiContainer when plugin not attached to UI or already detached from UI! Call isUIContainerAttached first.").toString());
    L5:
        return r0;
    }

    public boolean isUIContainerAttached() {
        H r0 = this.host;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getUIContainer() == null) goto L7;
        return true;
    }

    public boolean isUIContainerDetached() {
        H r0 = this.host;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.getUIContainer() == null) goto L8;
        return false;
    }

    public boolean isVisibleToUser() {
        H r0 = this.host;
        if (r0 != null) goto L5;
        return false;
    L5:
        FragmentActivity r1 = r0.getActivity();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L12;
        return true;
    L12:
        return false;
    }

    public FragmentActivity getActivity() {
        return getHost().getActivity();
    }

    public Context getContext() {
        return getActivity();
    }

    public FragmentManager getFragmentManager() {
        return getUIContainer().getFragmentManager();
    }

    public LifecycleOwner getLifecycleOwner() {
        return getHost().getLifecycleOwner();
    }

    public Resources getResources() {
        return getContext().getResources();
    }

    public TitleBar getTitleBar() {
        if (isUIContainerAttached() == true) goto L5;
        return null;
    L5:
        return getUIContainer().getTitleBar();
    }

    public void removeFragment() {
        getUIContainer().removeFragment(this);
    }

    public void addOrReplaceFragment(Class<? extends Fragment> r2) {
        addOrReplaceFragment(r2, null);
    }

    public <P extends Plugin> P findPlugin(Class<P> r2) {
        return (P) getHost().findPlugin(r2);
    }

    public <T extends PluginHostAbility> T getHostAbility(Class<T> r2) {
        return (T) getHost().getHostAbility(r2);
    }

    public <T extends PluginHostAbility> T getHostAbilityOrNull(Class<T> r2) {
        return (T) getHost().getHostAbilityOrNull(r2);
    }

    public String getString(int r2) {
        return getContext().getString(r2);
    }

    public <F extends Fragment> F instantiateFragment(Class<F> r2) {
        return (F) instantiateFragment(r2, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public void onAttachToHost(H r1) {
        setHost(r1);
    }

    public final void setHost(H r1) {
        this.host = r1;
    }

    public <T extends ViewModel> T viewModel(Class<T> r1) {
        return (T) PluginViewModelProviders.viewModel(this, r1);
    }

    public void addOrReplaceFragment(Class<? extends Fragment> r2, Bundle r3) {
        addOrReplaceFragment(r2, r3, null);
    }

    public <F extends Fragment> F instantiateFragment(Class<F> r2, Bundle r3) {
        if (r3 != null) goto L4;
        r3 = new Bundle();
    L4:
        PluginHost.writePluginHostToBundle(r3, this);
        return (F) Fragment.instantiate(getContext(), r2.getName(), r3);
    }

    public <T extends ViewModel> T viewModel(Class<T> r1, ViewModelProvider.Factory r2) {
        return (T) PluginViewModelProviders.viewModel(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addOrReplaceFragment(Class<? extends Fragment> r3, Bundle r4, TransactionParams r5) {
        UIContainer r0 = getUIContainer();
        if (r0.findFragment(this) != null) goto L6;
        r0.addOrReplaceFragment(this, instantiateFragment(r3, r4), r5);
        return;
    }
}
