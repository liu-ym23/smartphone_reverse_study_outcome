package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f1442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f.a f1444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ContentObserver f1446e;

    class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f1447a;

        a(k r10, Handler r11) {
            this.f1447a = r10;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            if (Logger.debug() == false) goto L5;
            Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
        L5:
            k.c(this.f1447a);
        }
    }

    k(Context r10, Handler r11) {
        this.f1442a = r11;
        this.f1443b = r10;
    }

    static /* synthetic */ void c(k r10) {
        r10.d();
    }

    private void d() {
        boolean r10 = this.f1445d;     // Catch: Exception -> L8
        e();     // Catch: Exception -> L8
        boolean r11 = this.f1445d;     // Catch: Exception -> L8
        if (r10 == r11) goto L11;
        f.a r12 = this.f1444c;     // Catch: Exception -> L8
        if (r12 == null) goto L12;
        r12.a(r11);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    private void e() {
        boolean r10 = com.bytedance.common.wschannel.l.f(this.f1443b).g();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L6;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r10);     // Catch: Throwable -> L9
    L6:
        if (r10 == this.f1445d) goto L12;
        this.f1445d = r10;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private void f() {
        this.f1443b.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.h(this.f1443b, WsConstants.KEY_FRONTIER_ENABLED, TypedValues.Custom.S_BOOLEAN), true, this.f1446e);     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void a() {
        e();
        this.f1446e = new a(this, this.f1442a);
        f();
    }

    @Override // com.bytedance.common.wschannel.server.f
    public void b(f.a r10) {
        this.f1444c = r10;
    }

    @Override // com.bytedance.common.wschannel.server.f
    public boolean isEnable() {
        return this.f1445d;
    }
}
