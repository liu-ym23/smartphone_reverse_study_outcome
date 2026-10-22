package com.bytedance.android.live.livelink.guestlink;

import android.content.Context;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lb6.c;
import lb6.d;
import sb6.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestLinkService extends c {
    public static final /* synthetic */ int k = 0;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicBoolean h;
    public final boolean i;
    public final fc6.a j;

    public static final class a {
    }

    static {
    }

    public final b q() {
        return (b) this.g.getValue();
    }

    public final void detach() {
        jy0.b.d("GuestLinkService", "detach");
        Iterator r0 = ((c) this).a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((d) r0.next()).detach();
        goto L4
    L6:
        ((c) this).a.clear();
        this.h.set(false);
    }

    public final mb6.b f() {
        return (mb6.b) this.b.getValue();
    }

    public final ob6.a j() {
        return (ob6.a) this.e.getValue();
    }

    public final void o() {
        jy0.b.d("GuestLinkService", "attach");
        n((mb6.b) this.b.getValue());
        n((qb6.a) this.d.getValue());
        n((rb6.a) this.c.getValue());
        n(q());
        n((ob6.a) this.e.getValue());
    }

    public final void p() {
        if (this.h.get() == true) goto L6;
        LinkMonitor.a("GuestLinkService", "GuestLinkService is not Init", "invoke init() first " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, false, 120);
        return;
    }

    public final boolean e() {
        p();
        return q().e();
    }

    public final sb6.a getLinkState() {
        return q().getLinkState();
    }

    public final void b(lb6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        q().b(r2);
    }

    public final void k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        p();
        q().k(r2);
    }

    public final void a(int r2, GuestLinkMainPageDialogForLinker.g r3) {
        q().a(r2, r3);
    }

    public final void d(lb6.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        p();
        q().d(r2, r3);
    }

    public final void m(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        this.h.set(true);
        nb6.a r2 = new nb6.a(r3);
        q().j(r2);
    }

    public GuestLinkService(final Context r2, boolean r3, fc6.a r4, bn0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "hostService");
        Intrinsics.checkNotNullParameter(r5, "multiLinkRoomScope");
        this.i = r3;
        this.j = r4;
        this.b = LazyKt.lazy(GuestLinkService$mApiManager$2.INSTANCE);
        this.c = LazyKt.lazy(new GuestLinkService$mPermissionManager$2(this));
        this.d = LazyKt.lazy(new GuestLinkService$mMsgManager$2(r2));
        this.e = LazyKt.lazy(new GuestLinkService$mMediaManager$2(this, r2));
        this.f = LazyKt.lazy(GuestLinkService$mCountDownManager$2.INSTANCE);
        this.g = LazyKt.lazy(new GuestLinkService$mPipelineManager$2(this, r2));
        this.h = new AtomicBoolean(false);
    }

    public final void g(long r9, long r11, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "source");
        p();
        q().g(r9, r11, r13, r14);
    }

    public final void h(long r9, long r11, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r14, "requestSource");
        q().h(r9, r11, r13, r14);
    }

    public final void i(long r10, long r12, long r14, long r16) {
        p();
        q().i(r10, r12, r14, r16);
    }

    public final void c(long r10, long r12, String r14, String r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r14, "source");
        Intrinsics.checkNotNullParameter(r15, "requestSource");
        p();
        q().c(r10, r12, r14, r15, r16);
    }

    public final void l(long r14, long r16, int r18, int r19, String r20, String r21, long r22, boolean r24) {
        Intrinsics.checkNotNullParameter(r20, "rtcExtInfo");
        p();
        q().l(r14, r16, r18, r19, r20, r21, r22, r24);
    }
}
