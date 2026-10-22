package com.bytedance.sdk.xbridge.cn.auth;

import ai.g0;
import android.content.Context;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements IHostNetworkDepend, com.bytedance.framwork.core.sdkmonitor.d, ja.b, mi.b, c7.g, pt.g, kj.c, org.threeten.bp.temporal.i, s8.f, s9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7345a;

    public /* synthetic */ g(int r5) {
        this.f7345a = r5;
    }

    @Override // s8.f
    public Map a() {
        return Collections.EMPTY_MAP;
    }

    @Override // pt.g
    public void accept(Object r5) {
        wn.f.k(new OnErrorNotImplementedException((Throwable) r5));
    }

    @Override // ja.b
    public boolean b(Context r5) {
        return f4.b.l(r5);
    }

    @Override // s9.a
    /* JADX INFO: renamed from: create */
    public s9.b mo98create() {
        vj.a r5 = new vj.a();
        r5.f22584z = -1;
        return r5;
    }

    @Override // com.bytedance.ai.bridge.service.IHostNetworkDepend
    public IAppletRetrofit createRetrofit(String r5, boolean r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "baseUrl");
        Intrinsics.checkNotNullParameter(r5, "baseUrl");
        g0 r12 = new g0(0);
        r12.g(r5);
        r12.c(aa.a.f());
        r12.g = new h.a(3);
        r12.d(new wa.a(1));
        if (r10 == false) goto L5;
        Object r13 = new com.lynx.tasm.behavior.d(2);
    L6:
        r12.f210b = r13;
        return new g8.g(r12.e());
    L5:
        r13 = new com.lynx.tasm.utils.c(2);
        goto L6
    }

    @Override // org.threeten.bp.temporal.i
    public Object d(org.threeten.bp.temporal.d r5) {
        switch(this.f7345a) {
            case 14: goto L7;
            default: goto L5;
        };
    L5:
        return (org.threeten.bp.chrono.i) r5.query(this);
    L7:
        return LocalDateTime.from(r5);
    }

    @Override // s8.f
    public void e(ConcurrentHashMap r5) {
    }

    @Override // mi.b
    public void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.g("XBridgeAuth", r10, null, 12);
    }
}
