package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0017J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0015J\b\u0010 \u001a\u00020\u0013H\u0015J\b\u0010!\u001a\u00020\u0013H\u0015J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0007H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "()V", "addContentView", "", "view", "Landroid/view/View;", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getOnBackPressedDispatcher", "initViewTreeOwners", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setContentView", "layoutResID", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ComponentDialog extends Dialog implements OnBackPressedDispatcherOwner, LifecycleOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    public ComponentDialog(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, 0, 2, null);
    }

    public ComponentDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r4);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new $$Lambda$ComponentDialog$3VrmmHeIN9Sasz9FquQXdvV7x_o(this));
    }

    public /* synthetic */ ComponentDialog(Context r2, int r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        this(r6, r3);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry r0 = this._lifecycleRegistry;
        if (r0 != null) goto L6;
        LifecycleRegistry r1 = new LifecycleRegistry((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"));
        this._lifecycleRegistry = r1;
        return r1;
    L6:
        return r0;
    }

    private static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private final void initViewTreeOwners() {
        Window r0 = getWindow();
        Intrinsics.checkNotNull(r0);
        ViewTreeLifecycleOwner.set(r0.getDecorView(), (LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"));
        Window r1 = getWindow();
        Intrinsics.checkNotNull(r1);
        View r2 = r1.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r2, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(r2, (OnBackPressedDispatcherOwner) ZeusTransformUtils.preCheckCast(this, OnBackPressedDispatcherOwner.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void lambda$3VrmmHeIN9Sasz9FquQXdvV7x_o(ComponentDialog r0) {
        m2onBackPressedDispatcher$lambda1(r0);
    }

    /* JADX INFO: renamed from: onBackPressedDispatcher$lambda-1, reason: not valid java name */
    private static final void m2onBackPressedDispatcher$lambda1(ComponentDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initViewTreeOwners();
        super.addContentView(r2, r3);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return (Lifecycle) ZeusTransformUtils.preCheckCast(getLifecycleRegistry(), Lifecycle.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.onBackPressedDispatcher.setOnBackInvokedDispatcher(getOnBackInvokedDispatcher());
    L5:
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int r1) {
        initViewTreeOwners();
        super.setContentView(r1);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initViewTreeOwners();
        super.setContentView(r2);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initViewTreeOwners();
        super.setContentView(r2, r3);
    }
}
