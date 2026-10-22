package com.bytedance.android.live.livelink.multilink;

import android.content.Context;
import bn0.b;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vb6.c;
import vb6.d;
import vb6.f;
import vb6.g;
import yb6.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkService extends c implements g {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final AtomicBoolean g;
    public final Context h;
    public final boolean i;
    public final fc6.a j;
    public final b k;

    public static final class a {
    }

    static {
    }

    public final cc6.a i() {
        return (cc6.a) this.f.getValue();
    }

    public final ac6.a a() {
        return (ac6.a) this.d.getValue();
    }

    public final void attach() {
        d((wb6.a) this.b.getValue());
        d((ac6.a) this.d.getValue());
        d((bc6.a) this.c.getValue());
        d(i());
        d((e) this.e.getValue());
    }

    public final void e() {
        if (this.g.get() == true) goto L6;
        LinkMonitor.a("MultiLinkService", "MultiLinkService is not Init", "invoke init() first " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, false, 120);
        return;
    }

    public final wb6.a f() {
        return (wb6.a) this.b.getValue();
    }

    public final e j() {
        return (e) this.e.getValue();
    }

    public final Context getContext() {
        return this.h;
    }

    public final void E0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        i().E0(r2);
    }

    public final void a1(f r2) {
        i().a1(r2);
    }

    public final void c1(int r2) {
        e();
        i().c1(r2);
    }

    public final void f1(xb6.b r2) {
        i().f1(r2);
    }

    public final void g(f r2) {
        i().g(r2);
    }

    public final void g1(xb6.a r2) {
        i().g1(r2);
    }

    public final void h(xb6.b r3) {
        Iterator r0 = ((c) this).a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).h(r3);
        goto L4
    L6:
        ((c) this).a.clear();
        this.g.set(false);
    }

    public final void W0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "source");
        i().W0(r2, r3);
    }

    public final void X0(f r2, boolean r3) {
        e();
        i().X0(r2, r3);
    }

    public final void b1(xb6.a r2, boolean r3) {
        e();
        i().b1(r2, r3);
    }

    public final void d1(int r2, int r3) {
        e();
        i().d1(r2, r3);
    }

    public final void e1(xb6.b r2, boolean r3) {
        e();
        i().e1(r2, r3);
    }

    public final void i1(String r2, boolean r3) {
        e();
        i().i1(r2, r3);
    }

    public final void O0(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        i().O0(r2, r3, r4);
    }

    public final void b(long r3, String r5, xb6.c r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        this.g.set(true);
        MultiLinkConfig r0 = new MultiLinkConfig(this.i, r3, r5);
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "preRtcInfo");
        r0.l = r6;
    L5:
        i().k1(r0);
    }

    public final void h1(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r4, "source");
        i().h1(r2, r3, r4);
    }

    public MultiLinkService(Context r2, boolean r3, fc6.a r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "hostService");
        Intrinsics.checkNotNullParameter(r5, "multiLinkRoomScope");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.b = LazyKt.lazy(new MultiLinkService$mApiManager$2(this));
        this.c = LazyKt.lazy(new MultiLinkService$mPermissionManager$2(this));
        this.d = LazyKt.lazy(MultiLinkService$mMsgManager$2.INSTANCE);
        this.e = LazyKt.lazy(new MultiLinkService$mMediaManager$2(this));
        this.f = LazyKt.lazy(new MultiLinkService$mPipelineManager$2(this));
        this.g = new AtomicBoolean(false);
    }

    public final void Y0(boolean r8, boolean r9, boolean r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        i().Y0(r11, r9, r10, r8, r12);
    }

    public final void c(int r7, String r8, String r9, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "replySecToUserId");
        Intrinsics.checkNotNullParameter(r9, "replyToUserIdString");
        e();
        i().j1(r7, r8, r9, r10, r12);
    }
}
