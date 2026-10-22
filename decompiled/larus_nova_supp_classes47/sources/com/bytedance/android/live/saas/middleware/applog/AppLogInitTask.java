package com.bytedance.android.live.saas.middleware.applog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.BDLiveSdkInternal;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.login.ILogin;
import com.bytedance.common.utility.NetworkClient;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.g0;
import com.ss.android.common.applog.h0;
import com.ss.android.common.applog.i0;
import com.ss.android.common.applog.m0;
import eta.b;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jta.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/applog/AppLogInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/live/saas/middleware/applog/AppLogConfig;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "attachUid", "", "uid", "", "init", "app", "Landroid/app/Application;", "params", "initInnerLogSDK", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class AppLogInitTask implements ISdkInitTask<AppLogConfig> {
    private CompositeDisposable compositeDisposable;

    private final void initInnerLogSDK() {
        g.b(new AnonymousClass1());
        Context r0 = BDLiveSdk.getContext();
        boolean r1 = true;
        if (r0 == null) goto L5;
        m0 r2 = m0.h;
        b r3 = BDLiveSdkInternal.getAppContext();
        m0 r4 = m0.h;
        i0 r5 = new i0();
        r5.e = r0;
        r5.g = r4;
        r5.f = true;
        r5.a = r3;
        h0 r6 = r5.a();
        NetworkClient.setDefault(new DefaultNetworkClient());
        g0.a(r6);
    L5:
        ILogin r7 = (ILogin) BDLiveSdk.getImp(ILogin.class);
        if (r7 == null) goto L17;
        String r8 = r7.getUid();
        if (r8.length() > 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        attachUid(r8);
        return;
    L13:
        Disposable r9 = r7.getUidObservable().subscribe(new AppLogInitTask$initInnerLogSDK$$inlined$apply$lambda$1(this));
        if (r9 == null) goto L19;
        this.compositeDisposable.add(r9);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
        this.compositeDisposable.dispose();
    }

    public AppLogInitTask() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    private final void attachUid(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("openid", r3);
        AppLog.g0.d(r0);
    }

    public final void setCompositeDisposable(CompositeDisposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.compositeDisposable = r2;
    }

    public static final /* synthetic */ void access$attachUid(AppLogInitTask r0, String r1) {
        r0.attachUid(r1);
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(Application r2, AppLogConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "params");
        initInnerLogSDK();
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r1, AppLogConfig r2) {
        init2(r1, r2);
    }
}
