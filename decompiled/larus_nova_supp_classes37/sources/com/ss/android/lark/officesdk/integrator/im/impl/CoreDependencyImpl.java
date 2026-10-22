package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.ArrayList;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CoreDependencyImpl implements pmb.d {
    public final void b() {
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void g() {
    }

    public final void getProfile() {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final void j() {
    }

    public final void l() {
    }

    public final void m() {
    }

    public final void p() {
    }

    public final void q() {
    }

    public final void r() {
    }

    public final long a() {
        return cac.b.a.a.a(MmUploadRetryConfigSetting.MAX_INTERVAL_MS);
    }

    public final qpc.e f() {
        return (qpc.e) ApiUtils.getApi(qpc.e.class);
    }

    public final ArrayList n() {
        return new ArrayList();
    }

    @Inject
    public CoreDependencyImpl() {
    }

    public final void o(com.ss.android.lark.integrator.im.chat.core.dependency.r.a r2) {
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).addPushResourceUploadProgressListener(r2);
    }

    public final void removePushResourceUploadProgressListener(qpc.d r2) {
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).removePushResourceUploadProgressListener(r2);
    }

    public final void e(final Context r2, final ProfileSource r3) {
        final IGetDataCallback<ProfileSource> r0 = new AnonymousClass1(this, r2);
        RxScheduledExecutor.execInIO(new d(r3), new e(r0));
    }

    public final boolean k(Context r3, String r4) {
        return ova.f.m().i(r3, r4, 0);
    }

    public final void s(Context r3, String r4) {
        ova.f.m().y(r3, r4, 0);
    }
}
