package com.bytedance.android.live.liveinteract.api.data;

import cj0.k;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.sharedpref.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import fj0.c;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final C0017a h = null;
    public final int a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.api.data.a$a, reason: collision with other inner class name */
    public static final class C0017a {
        public C0017a() {
        }

        @JvmStatic
        public static k b() {
            cj0.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r0 == null) goto L7;
            k r1 = r0.currentPaidLinkMicState();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new k(0);
        }

        @JvmStatic
        public static a a() {
            boolean r1 = false;
            if (c.a() == false) goto L5;
            k r0 = b();
            return new a((int) r0.b, (int) r0.c, r0.a, r1);
        L5:
            int r2 = ((Number) com.bytedance.android.livesdk.sharedpref.c.u.getValue()).intValue();
            int r3 = ((Number) com.bytedance.android.livesdk.sharedpref.c.v.getValue()).intValue();
            j r4 = m.d().J();
            if (r4 == null) goto L15;
            LivePlayModeLogContext r5 = (LivePlayModeLogContext) r4.getValue();
            if (r5 == null) goto L15;
            com.bytedance.live.datacontext.m r6 = r5.getPlayModes();
            if (r6 == null) goto L15;
            Set r7 = (Set) r6.getValue();
            if (r7 == null) goto L15;
            boolean r8 = r7.contains(11);
        L17:
            return new a(r2, r3, r8, r1);
        L15:
            r8 = false;
            goto L17
        }

        @JvmStatic
        public static int c() {
            if (c.a() == false) goto L6;
            return (int) b().c;
        L6:
            if (e() == false) goto L9;
            return ((Number) d.L.getValue(null, d.a[36])).intValue();
        L9:
            return ((Number) d.G.getValue(null, d.a[31])).intValue();
        }

        @JvmStatic
        public static int d() {
            if (c.a() == false) goto L6;
            return (int) b().b;
        L6:
            if (e() == false) goto L8;
            Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.B.getValue();
        L10:
            return r0.intValue();
        L8:
            r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.q0.getValue();
            goto L10
        }

        public static boolean e() {
            com.bytedance.live.datacontext.m r0 = m.i().getRoom();
            if (r0 == null) goto L11;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L11;
            Map r2 = r1.getAnchorABMap();
            if (r2 == null) goto L11;
            String r3 = (String) r2.get("opt_paid_link_feature_switch");
            if (r3 == null) goto L11;
            Integer r4 = StringsKt.toIntOrNull(r3);
        L13:
            if (r4 == null) goto L18;
            if (r4.intValue() != 1) goto L18;
            return true;
        L18:
            if (c.a() == true) goto L23;
            return false;
        L23:
            return true;
        L11:
            r4 = null;
            goto L13
        }

        @JvmStatic
        public static int f() {
            if (c.a() == false) goto L6;
            return (int) b().c;
        L6:
            if (e() == false) goto L9;
            return ((Number) d.O.getValue(null, d.a[39])).intValue();
        L9:
            return ((Number) d.I.getValue(null, d.a[33])).intValue();
        }

        @JvmStatic
        public static int g() {
            if (c.a() == false) goto L6;
            return (int) b().b;
        L6:
            if (e() == false) goto L8;
            Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.u.getValue();
        L10:
            return r0.intValue();
        L8:
            r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.w.getValue();
            goto L10
        }

        @JvmStatic
        public static a h() {
            if (c.a() == false) goto L12;
            k r0 = b();
            int r5 = (int) r0.b;
            int r6 = (int) r0.c;
            boolean r7 = r0.a;
            Integer r1 = (Integer) com.bytedance.android.livesdk.sharedpref.c.r.getValue();
            if (r1 != null) goto L8;
        L9:
            boolean r9 = true;
        L11:
            a r12 = new a(r5, r6, r7, false, r9, (String) com.bytedance.android.livesdk.sharedpref.c.s.getValue(), (String) com.bytedance.android.livesdk.sharedpref.c.t.getValue());
        L32:
            return r12;
        L8:
            if (r1.intValue() != 2) goto L9;
            r9 = false;
            goto L11
        L12:
            int r14 = d();
            int r15 = c();
            if (c.a() == false) goto L19;
            cj0.b r2 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r2 != null) goto L17;
        L23:
            boolean r16 = false;
        L24:
            Integer r3 = (Integer) com.bytedance.android.livesdk.sharedpref.c.r.getValue();
            if (r3 != null) goto L28;
        L29:
            boolean r18 = true;
        L31:
            r12 = new a(r14, r15, r16, false, r18, (String) com.bytedance.android.livesdk.sharedpref.c.s.getValue(), (String) com.bytedance.android.livesdk.sharedpref.c.t.getValue());
            goto L32
        L28:
            if (r3.intValue() != 2) goto L29;
            r18 = false;
            goto L31
        L17:
            if (r2.isPaidLinkOn() != true) goto L23;
        L22:
            r16 = true;
            goto L24
        L19:
            int r4 = d();
            if (r4 == (-1)) goto L23;
            if (r4 == 0) goto L23;
            goto L22
        }

        @JvmStatic
        public static boolean i() {
            if (c.a() == false) goto L5;
            return true;
        L5:
            if (e() == false) goto L8;
            boolean r0 = ((Boolean) d.N.getValue(null, d.a[38])).booleanValue();
        L11:
            if (r0 == true) goto L16;
            return false;
        L16:
            return true;
        L8:
            if (((Number) d.H.getValue(null, d.a[32])).intValue() == (-1)) goto L10;
            r0 = true;
            goto L11
        L10:
            r0 = false;
            goto L11
        }

        @JvmStatic
        public static boolean j() {
            if (c.a() == false) goto L10;
            cj0.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
            if (r0 != null) goto L7;
            return false;
        L7:
            if (r0.isPaidLinkOn() != true) goto L16;
            return true;
        L16:
            return false;
        L10:
            int r1 = g();
            if (r1 == (-1)) goto L17;
            if (r1 == 0) goto L18;
            return true;
        L18:
            return false;
        L17:
            return false;
        }

        @JvmStatic
        public static a k() {
            boolean r1 = true;
            if (c.a() == false) goto L6;
            k r0 = b();
            return new a((int) r0.b, (int) r0.c, r0.a, r1);
        L6:
            return new a(g(), f(), j(), r1);
        }
    }

    @JvmStatic
    public static final a a() {
        h.getClass();
        return C0017a.h();
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        ?? r6 = r5;
        if (r5 == false) goto L8;
        r6 = 1;
    L8:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.e;
        if (r8 == true) goto L12;
        r2 = r8;
    L12:
        int r9 = (r7 + r2) * 31;
        String r10 = this.f;
        int r11 = 0;
        if (r10 == null) goto L15;
        int r12 = r10.hashCode();
    L16:
        int r13 = (r9 + r12) * 31;
        String r14 = this.g;
        if (r14 == null) goto L20;
        r11 = r14.hashCode();
    L20:
        return r13 + r11;
    L15:
        r12 = 0;
        goto L16
    }

    public final String toString() {
        return "PaidLinkConfig(paidCount=" + this.a + ", limitTime=" + this.b + ", isOn=" + this.c + ", isVideoTalk=" + this.d + ", isReasonNecessary=" + this.e + ", manualReason=" + this.f + ", defaultReason=" + this.g + ")";
    }

    static {
        h = new C0017a();
    }

    public /* synthetic */ a(int r9, int r10, boolean r11, boolean r12) {
        this(r9, r10, r11, r12, true, "", "");
    }

    public a(int r2, int r3, boolean r4, boolean r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "manualReason");
        Intrinsics.checkNotNullParameter(r8, "defaultReason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
