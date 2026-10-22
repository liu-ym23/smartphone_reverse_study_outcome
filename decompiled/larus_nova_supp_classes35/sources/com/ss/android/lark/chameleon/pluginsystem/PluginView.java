package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.ActivityResultHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginListProvider;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginRuntime;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleUIContainer;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PluginView extends FrameLayout implements LifecycleObserver, BackPressHandler, ActivityResultHandler {
    private static final String TAG = "PluginView";
    private boolean inited;
    private LifecycleOwner lifecycleOwner;
    private FragmentManager pluginFragmentsContainer;
    private PluginHost pluginHost;
    private PluginHostDelegate pluginHostDelegate;
    private PluginHost.Factory pluginHostFactory;
    private PluginListProvider pluginListProvider;
    private PluginRuntime pluginRuntime;
    private UIContainer uiContainer;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.PluginView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class PluginHostDelegate implements PluginHost.Delegate {
        final /* synthetic */ PluginView this$0;

        @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
        public final /* synthetic */ Fragment getHostFragment() {
            return PluginHost.Delegate.CC.$default$getHostFragment(this);
        }

        @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
        public FragmentActivity getActivity() {
            return PluginView.access$100(this.this$0);
        }

        @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
        public LifecycleOwner getLifecycleOwner() {
            return PluginView.access$200(this.this$0);
        }

        @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost.Delegate
        public PluginListProvider getPluginListProvider() {
            return PluginView.access$300(this.this$0);
        }

        private PluginHostDelegate(PluginView r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ PluginHostDelegate(PluginView r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static /* synthetic */ PluginHost a(PluginView r0) {
        return r0.lambda$onCreate$0();
    }

    private void attachPluginUI() {
        StringBuilder r0 = new StringBuilder("attachPluginUI created?");
        if (this.uiContainer == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Log.i(TAG, r0.toString());
        if (this.uiContainer != null) goto L10;
        UIContainer r2 = onCreateUIContainer(this);
        this.uiContainer = r2;
        this.pluginRuntime.dispatchUIAttach(this.pluginHostDelegate, r2);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    private boolean checkInited() {
        if (this.inited == true) goto L6;
        Log.w(TAG, "Not init yet");
        return false;
    L6:
        return true;
    }

    public UIContainer getUIContainer() {
        if (this.uiContainer != null) goto L6;
        Log.e(TAG, new IllegalStateException("getUIContainer while not created yet !").toString());
    L6:
        return this.uiContainer;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BackPressHandler
    public boolean onBackPressed() {
        Log.i(TAG, "onBackPressed");
        if (checkInited() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.pluginHost.onDispatchBackPressed() == false) goto L7;
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.i(TAG, "onCreate");
        if (checkInited() == false) goto L8;
        this.pluginRuntime.createHost(new a(this), this.pluginHostDelegate);
        if (isAttachedToWindow() == false) goto L9;
        attachPluginUI();
        return;
    L9:
        return;
    }

    public PluginHost onCreatePluginHost() {
        PluginHost.Factory r0 = this.pluginHostFactory;
        if (r0 == null) goto L6;
        return r0.createPluginHost();
    L6:
        return new PluginHost();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (checkInited() == false) goto L6;
        this.pluginRuntime.destroyHost(this.pluginHostDelegate);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.pluginRuntime.dispatchOnPause(this.pluginHostDelegate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.pluginRuntime.dispatchOnResume(this.pluginHostDelegate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.pluginRuntime.dispatchOnStart(this.pluginHostDelegate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.pluginRuntime.dispatchOnStop(this.pluginHostDelegate);
    }

    private void baseInit() {
        if ((getContext() instanceof FragmentActivity) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can only used in a FragmentActivity");
    }

    private FragmentActivity getFragmentActivity() {
        return getContext();
    }

    private /* synthetic */ PluginHost lambda$onCreate$0() {
        PluginHost r0 = onCreatePluginHost();
        this.pluginHost = r0;
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "onAttachedToWindow");
        if (checkInited() == false) goto L6;
        attachPluginUI();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, "onDetachedFromWindow");
        if (checkInited() == false) goto L6;
        this.pluginRuntime.dispatchUIDetach(this.pluginHostDelegate, this.uiContainer);
        this.uiContainer = null;
        return;
    }

    public PluginHost getPluginHost() {
        return this.pluginHost;
    }

    public PluginView(Context r1) {
        super(r1);
        baseInit();
    }

    public static /* synthetic */ FragmentActivity access$100(PluginView r0) {
        return r0.getFragmentActivity();
    }

    public static /* synthetic */ LifecycleOwner access$200(PluginView r0) {
        return r0.lifecycleOwner;
    }

    public static /* synthetic */ PluginListProvider access$300(PluginView r0) {
        return r0.pluginListProvider;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        if (checkInited() == false) goto L6;
        this.pluginRuntime.dispatchConfigurationChanged(this.pluginHostDelegate, r3);
        return;
    }

    public UIContainer onCreateUIContainer(View r5) {
        return new SimpleUIContainer(getContext(), r5, this.pluginFragmentsContainer, null);
    }

    public PluginView(Context r1, AttributeSet r2) {
        super(r1, r2);
        baseInit();
    }

    public PluginView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        baseInit();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.ActivityResultHandler
    public void onActivityResult(int r3, int r4, Intent r5) {
        Log.i(TAG, "onActivityResult");
        if (checkInited() == false) goto L6;
        this.pluginHost.onDispatchActivityResult(r3, r4, r5);
        return;
    }

    public PluginView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        baseInit();
    }

    public void init(LifecycleOwner r3, PluginHost.Factory r4, FragmentManager r5, PluginListProvider r6) {
        Log.i(TAG, "init");
        setId(2131382479);
        this.lifecycleOwner = r3;
        this.pluginHostFactory = r4;
        this.pluginListProvider = r6;
        if (r5 != null) goto L5;
        r5 = getFragmentActivity().getSupportFragmentManager();
    L5:
        this.pluginFragmentsContainer = r5;
        this.pluginHostDelegate = new PluginHostDelegate(this, null);
        this.pluginRuntime = PluginRuntime.getInstance();
        this.inited = true;
        r3.getLifecycle().addObserver(this);
    }
}
