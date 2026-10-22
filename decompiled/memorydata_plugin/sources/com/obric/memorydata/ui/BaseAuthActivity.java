package com.obric.memorydata.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0014J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0014J\b\u0010\u001e\u001a\u00020\rH\u0004J\b\u0010\u001f\u001a\u00020\rH\u0004J\b\u0010 \u001a\u00020\u000bH\u0004J\b\u0010!\u001a\u00020\u000bH\u0004J\b\u0010\"\u001a\u00020\u000bH\u0004R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lcom/obric/memorydata/ui/BaseAuthActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "authDelegate", "Lcom/obric/memorydata/ui/AuthOverlayDelegate;", "getAuthDelegate", "()Lcom/obric/memorydata/ui/AuthOverlayDelegate;", "authDelegate$delegate", "Lkotlin/Lazy;", "authedHook", "", "deferLoginCheckDispatch", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setContentView", "layoutResID", "", "view", "Landroid/view/View;", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "onStart", "onResume", "onStop", "onWindowFocusChanged", "hasFocus", "onDestroy", "isLocked", "isAuthed", "freeAuthed", "exitApp", "requestAuth", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseAuthActivity extends BaseActivity {
    private final Lazy authDelegate$delegate;

    public BaseAuthActivity() {
        this.authDelegate$delegate = LazyKt.lazy(new $$Lambda$BaseAuthActivity$G9rlT2tYslSijos5vvAlHZk_41M(this));
    }

    private static final a authDelegate_delegate$lambda$2(BaseAuthActivity r3) {
        final BaseAuthActivity r4 = (BaseAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseAuthActivity.class, "com.obric.memorydata.plugin");
        a r0 = new a((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.memorydata.plugin"));
        r0.a(new $$Lambda$BaseAuthActivity$yFyZdGT4KPZ6HYN4SjMKgUFsVzU(r4));
        return r0;
    }

    private static final Unit authDelegate_delegate$lambda$2$lambda$1$lambda$0(BaseAuthActivity r2) {
        ((BaseAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseAuthActivity.class, "com.obric.memorydata.plugin")).authedHook();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ a lambda$G9rlT2tYslSijos5vvAlHZk_41M(BaseAuthActivity r0) {
        return authDelegate_delegate$lambda$2(r0);
    }

    public static /* synthetic */ Unit lambda$yFyZdGT4KPZ6HYN4SjMKgUFsVzU(BaseAuthActivity r0) {
        return authDelegate_delegate$lambda$2$lambda$1$lambda$0(r0);
    }

    public void authedHook() {
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean deferLoginCheckDispatch() {
        return true;
    }

    public final void exitApp() {
        getAuthDelegate().j();
    }

    public final void freeAuthed() {
        getAuthDelegate().i();
    }

    public final a getAuthDelegate() {
        return (a) ZeusTransformUtils.preCheckCast(this.authDelegate$delegate.getValue(), a.class, "com.obric.memorydata.plugin");
    }

    public final boolean isAuthed() {
        return getAuthDelegate().h();
    }

    public final boolean isLocked() {
        return getAuthDelegate().g();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        getAuthDelegate().b();
        dispatchOnCreateLoginCheck(r2);
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        getAuthDelegate().f();
        super.onDestroy();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        getAuthDelegate().d();
        dispatchOnResumeLoginCheck();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getAuthDelegate().c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        getAuthDelegate().e();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        getAuthDelegate().a(r1);
    }

    public final void requestAuth() {
        getAuthDelegate().b(true);
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(int r1) {
        super.setContentView(r1);
        getAuthDelegate().a();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(View r1) {
        super.setContentView(r1);
        getAuthDelegate().a();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        super.setContentView(r1, r2);
        getAuthDelegate().a();
    }
}
