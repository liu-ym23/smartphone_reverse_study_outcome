package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f2189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2190b;
    private f.a c;
    private boolean d;
    private ContentObserver e;

    k(Context r3, Handler r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f2189a = r4;
        this.f2190b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ void a(k r0) {
        r0.e();
    }

    private void c() {
        boolean r0 = com.bytedance.common.wschannel.l.a(this.f2190b).c();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L6;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r0);     // Catch: Throwable -> L9
    L6:
        if (r0 == this.d) goto L12;
        this.d = r0;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private void d() {
        ZeusProviderTransform.registerContentObserver(this.f2190b.getContentResolver(), WsChannelMultiProcessSharedProvider.a(this.f2190b, WsConstants.KEY_FRONTIER_ENABLED, TypedValues.Custom.S_BOOLEAN), true, this.e, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        return;
    }

    private void e() {
        boolean r0 = this.d;     // Catch: Exception -> L8
        c();     // Catch: Exception -> L8
        boolean r1 = this.d;     // Catch: Exception -> L8
        if (r0 == r1) goto L11;
        f.a r2 = this.c;     // Catch: Exception -> L8
        if (r2 == null) goto L12;
        r2.a(r1);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void a() {
        c();
        final Handler r1 = this.f2189a;
        this.e = new AnonymousClass1(this, r1);
        d();
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void a(f.a r3) {
        this.c = (f.a) ZeusTransformUtils.wrapperContextForParams(r3, f.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.common.wschannel.server.f
    public boolean b() {
        return this.d;
    }
}
