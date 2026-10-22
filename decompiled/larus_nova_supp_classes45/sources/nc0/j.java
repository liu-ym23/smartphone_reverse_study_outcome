package nc0;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements ey.k {
    public final com.bytedance.android.live.revenuelink.connect.n a;

    public j(com.bytedance.android.live.revenuelink.connect.n r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    @Override // ey.k
    public final void a(fy.g r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        com.bytedance.android.live.revenuelink.connect.n r0 = this.a;
        Intrinsics.checkNotNullParameter(r13, "$this$toKickOutParams");
        int r3 = r13.a;
        long r4 = r13.b;
        String r6 = r13.c;
        String r7 = r13.d;
        String r8 = r13.e;
        LinkerKickOutContent.KickOutSource r2 = r13.f;
        Intrinsics.checkNotNullParameter(r2, "$this$map");
        int r5 = n.a[r2.ordinal()];
        int r9 = 1;
        if (r5 != 1) goto L5;
        r9 = 0;
    L17:
        r0.j(new d11.e(r3, r4, r6, r7, r8, r9, r13.g));
        return;
    L5:
        if (r5 == 2) goto L17;
        r9 = 3;
        if (r5 != 3) goto L9;
        r9 = 2;
        goto L17
    L9:
        if (r5 == 4) goto L17;
        if (r5 != 5) goto L14;
        r9 = 4;
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // ey.k
    public final void b(fy.e r41) {
        Intrinsics.checkNotNullParameter(r41, "params");
        com.bytedance.android.live.revenuelink.connect.n r2 = this.a;
        Intrinsics.checkNotNullParameter(r41, "$this$toInviteParams");
        int r5 = r41.a;
        long r6 = r41.b;
        long r8 = r41.c;
        int r11 = r41.d;
        int r12 = r41.e;
        String r13 = r41.f.toString();
        String r14 = r41.g;
        Room r4 = r41.h;
        if (r4 != null) goto L5;
        r4 = new Room();
    L5:
        r2.d(new d11.d(r5, r6, r8, r11, r12, r13, r14, r4, 0, r41.i, r41.j, r41.k, r41.l, r41.m, r41.n, r41.o, r41.p, r41.q, r41.r, r41.s, r41.t, r41.u, r41.v, null, r41.w, null, null, null, 511705088), null);
    }

    @Override // ey.k
    public final void c(fy.c r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        com.bytedance.android.live.revenuelink.connect.n r0 = this.a;
        Intrinsics.checkNotNullParameter(r14, "$this$toCancelParams");
        int r3 = r14.a;
        long r4 = r14.b;
        long r6 = r14.c;
        String r8 = r14.d;
        String r2 = r14.e;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.e(new d11.c(r3, r4, r6, r8, r2, r14.f, r14.g, r14.h), null);
    }

    @Override // ey.k
    public final void d(fy.j r41) {
        Intrinsics.checkNotNullParameter(r41, "params");
        com.bytedance.android.live.revenuelink.connect.n r2 = this.a;
        Intrinsics.checkNotNullParameter(r41, "$this$toReplyParams");
        int r5 = r41.a;
        long r7 = r41.b;
        long r9 = r41.c;
        int r11 = r41.d;
        String r12 = r41.e;
        String r13 = r41.f;
        Boolean r14 = r41.g;
        Integer r15 = r41.h;
        fy.a r0 = r41.i;
        Intrinsics.checkNotNullParameter(r0, "$this$toAnchorReplyParams");
        r2.h(new d11.g(r5, 0, r7, r9, r11, r12, r13, r14, r15, new d11.a(r0.a, r0.b, r0.c, r0.e, r0.f, r0.g, r0.h, r0.i, r0.j, r0.k, r0.l, null, 2048), null, null, null, null, 15360), null);
    }
}
