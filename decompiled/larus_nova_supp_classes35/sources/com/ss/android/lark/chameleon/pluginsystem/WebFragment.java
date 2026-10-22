package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.ActivityResultHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginRuntime;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleUIContainer;
import com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class WebFragment extends Fragment implements PluginHost.Delegate, ActivityResultHandler, BackPressHandler {
    private static final String TAG = "WebFragment";
    private WebPluginHost pluginHost;
    private PluginRuntime pluginRuntime;
    private TitleBar titleBar;
    private UIContainer uiContainer;

    public static /* synthetic */ PluginHost S90(WebFragment r0) {
        return r0.lambda$onCreate$0();
    }

    public void ensureInitUiContainer(View r1) {
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
    public Fragment getHostFragment() {
        return this;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public abstract WebPluginHost onCreatePluginHost();

    public abstract TitleBar onCreateTitleBar();

    public final TitleBar getTitleBar() {
        TitleBar r0 = this.titleBar;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("getTitleBar before onViewCreated");
    }

    public UIContainer getUIContainer() {
        if (this.uiContainer != null) goto L6;
        Log.e(TAG, new IllegalStateException("getUIContainer while not created yet !").toString());
    L6:
        return this.uiContainer;
    }

    private /* synthetic */ PluginHost lambda$onCreate$0() {
        WebPluginHost r0 = onCreatePluginHost();
        this.pluginHost = r0;
        return r0;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler
    public boolean onBackPressed() {
        List r0 = getChildFragmentManager().getFragments();
        if (r0 == null) goto L14;
        int r1 = r0.size() - 1;
    L5:
        if (r1 < 0) goto L14;
        BackPressHandler r3 = (Fragment) ListProtector.get(r0, r1);
        if ((r3 instanceof BackPressHandler) == false) goto L12;
        if (r3.onBackPressed() == false) goto L12;
        Log.i(TAG, "Back press consumed by :" + r3);
        return true;
    L12:
        r1 = r1 - 1;
    L14:
        return this.pluginHost.onDispatchBackPressed();
    }

    public void onDestroy() {
        super.onDestroy();
        this.pluginRuntime.destroyHost(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.pluginRuntime.dispatchUIDetach(this, this.uiContainer);
    }

    public void onPause() {
        super.onPause();
        this.pluginRuntime.dispatchOnPause(this);
    }

    public void onResume() {
        super.onResume();
        Web r0 = this.pluginHost.getWeb();
        if (r0 == null) goto L7;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L7;
        r1.resumeTimers();
    L7:
        this.pluginRuntime.dispatchOnResume(this);
    }

    public void onStart() {
        super.onStart();
        this.pluginRuntime.dispatchOnStart(this);
    }

    public void onStop() {
        super.onStop();
        this.pluginRuntime.dispatchOnStop(this);
    }

    public WebFragment() {
    }

    public WebPluginHost getPluginHost() {
        return this.pluginHost;
    }

    public void hideTitleBar(boolean r2) {
        UIContainer r0 = getUIContainer();
        if (r0 == null) goto L6;
        r0.getTitleBar().hide(r2);
        return;
    }

    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        this.pluginRuntime.dispatchConfigurationChanged(this, r2);
    }

    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        PluginReport.mWebFragmentOnCreate = System.currentTimeMillis();
        this.pluginRuntime = PluginRuntime.getInstance();
        this.pluginRuntime.createHost(new b(this), this);
        final boolean r1 = true;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this, r1));
    }

    public UIContainer onCreateUIContainer(View r5) {
        Context r1 = getContext();
        Objects.requireNonNull(r1);
        return new SimpleUIContainer(r1, r5, getChildFragmentManager(), getTitleBar());
    }

    public void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        PluginRuntime r0 = this.pluginRuntime;
        if (r0 == null) goto L6;
        r0.dispatchUserVisibleHint(this, r2);
        return;
    }

    public void showTitleBar(boolean r2) {
        UIContainer r0 = getUIContainer();
        if (r0 == null) goto L6;
        r0.getTitleBar().show(r2);
        return;
    }

    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.titleBar != null) goto L6;
        this.titleBar = onCreateTitleBar();
    L6:
        if (this.uiContainer != null) goto L8;
        this.uiContainer = onCreateUIContainer(r1);
    L8:
        this.pluginRuntime.dispatchUIAttach(this, this.uiContainer);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.ActivityResultHandler
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.pluginHost.onDispatchActivityResult(r2, r3, r4);
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return new View(getContext());
    }
}
