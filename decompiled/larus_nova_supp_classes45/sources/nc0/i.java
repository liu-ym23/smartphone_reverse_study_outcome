package nc0;

import com.bytedance.android.live.anchorlink.network.model.AnchorApplyData;
import com.bytedance.android.live.anchorlink.network.model.AnchorPermitData;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.live.revenuelink.connect.m {
    public final ey.j a;

    public final void O1(d11.e r1, Throwable r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "params");
    }

    public i(ey.j r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    public final void A3(d11.d r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.T5(o.c(r2));
    }

    public final void M2(d11.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.H7(o.a(r2));
    }

    public final void Q4(d11.d r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.Vd(o.c(r2));
    }

    public final void Z3(d11.g r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.An(o.e(r2));
    }

    public final void Y1(d11.c r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.Nb(o.b(r1));
    }

    public final void Z1(d11.e r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        ey.j r13 = this.a;
        Intrinsics.checkNotNullParameter(r11, "$this$toKickOutParams");
        int r1 = r11.a;
        long r2 = r11.b;
        String r4 = r11.c;
        String r5 = r11.d;
        String r6 = r11.e;
        int r0 = r11.f;
        if (r0 != 0) goto L5;
        LinkerKickOutContent.KickOutSource r3 = LinkerKickOutContent.KickOutSource.Unknown;
    L18:
        r13.Ec(new fy.g(r1, r2, r4, r5, r6, r3, r11.g));
        return;
    L5:
        if (r0 != 1) goto L7;
        r3 = LinkerKickOutContent.KickOutSource.FromOrganizer;
        goto L18
    L7:
        if (r0 != 2) goto L9;
        r3 = LinkerKickOutContent.KickOutSource.General;
        goto L18
    L9:
        if (r0 != 3) goto L11;
        r3 = LinkerKickOutContent.KickOutSource.RTCLeave;
        goto L18
    L11:
        if (r0 == 4) goto L13;
        r3 = LinkerKickOutContent.KickOutSource.Unknown;
        goto L18
    L13:
        r3 = LinkerKickOutContent.KickOutSource.RTCUnLink;
        goto L18
    }

    public final void Je(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        ey.j r4 = this.a;
        vh7.c r5 = k.a(r2);
        if (r5 == null) goto L7;
        r4.mn(r1, (if) r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkerMessage");
    }

    public final void Tg(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        ey.j r4 = this.a;
        vh7.c r5 = k.a(r2);
        if (r5 == null) goto L7;
        r4.qe((if) r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkerMessage");
    }

    public final void ej(int r1, i6 r2, ey.l r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        ey.j r4 = this.a;
        vh7.c r5 = k.a(r2);
        if (r5 == null) goto L7;
        r4.P5((if) r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkerMessage");
    }

    public final void jo(int r1, i6 r2, ey.l.b r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerMessage");
        ey.j r4 = this.a;
        vh7.c r5 = k.a(r2);
        if (r5 == null) goto L7;
        r4.Fp((if) r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkerMessage");
    }

    public final void q9(d11.c r1, long r2, ey.l r4) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.Ci(o.b(r1));
    }

    public final void Cn(d11.g r1, Throwable r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.K8(o.e(r1), r2);
    }

    public final void Jd(d11.f r1, v r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "permitData");
        ey.j r4 = this.a;
        fy.i r6 = o.d(r1);
        vh7.c r7 = k.a(r2);
        if (r7 == null) goto L7;
        r4.ub(r6, (AnchorPermitData) r7);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.anchorlink.network.model.AnchorPermitData");
    }

    public final void O8(d11.b r1, com.bytedance.android.livesdk.link.model.f r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "applyResult");
        ey.j r4 = this.a;
        fy.b r6 = o.a(r1);
        vh7.c r7 = k.a(r2);
        if (r7 == null) goto L7;
        r4.tj(r6, (AnchorApplyData) r7);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.anchorlink.network.model.AnchorApplyData");
    }

    public final void Vc(d11.b r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.tl(o.a(r1));
    }

    public final void hl(d11.d r8, long r9, v4 r11, ey.l r12) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r11, "inviteResult");
        ey.j r1 = this.a;
        fy.e r2 = o.c(r8);
        vh7.c r13 = k.a(r11);
        if (r13 == null) goto L7;
        r1.zm(r2, r9, (LinkInviteResult) r13, r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult");
    }

    public final void nf(d11.g r1, q5 r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r2, "replyResult");
        ey.j r6 = this.a;
        fy.j r4 = o.e(r1);
        vh7.c r7 = k.a(r2);
        if (r7 == null) goto L7;
        r6.Ah(r4, (LinkReplyResult) r7, r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult");
    }

    public final void pp(d11.f r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.Oi(o.d(r1));
    }

    public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.Th(o.c(r1), r2);
    }

    public final void wh(d11.c r1, Throwable r2, long r3, ey.l r5) {
        Intrinsics.checkNotNullParameter(r1, "params");
        this.a.rc(o.b(r1));
    }
}
