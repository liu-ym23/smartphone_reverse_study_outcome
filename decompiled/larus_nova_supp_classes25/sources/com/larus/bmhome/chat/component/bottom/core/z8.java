package com.larus.bmhome.chat.component.bottom.core;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface z8 {

    public static final class a {
        public static final a y = null;
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final Map<Integer, g9.a> d;
        public final boolean e;
        public final boolean f;
        public final e g;
        public final c h;
        public final boolean i;
        public final boolean j;
        public final Map<String, String> k;
        public final b l;
        public final d m;
        public final boolean n;
        public final Function0<Boolean> o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        public final boolean t;
        public final boolean u;
        public final boolean v;
        public final boolean w;
        public final wc9.e x;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.z8$a$a, reason: collision with other inner class name */
        public static final class C0049a {
        }

        public a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (this.p == r6.p) goto L57;
            return false;
        L57:
            if (this.q == r6.q) goto L60;
            return false;
        L60:
            if (this.r == r6.r) goto L63;
            return false;
        L63:
            if (this.s == r6.s) goto L66;
            return false;
        L66:
            if (this.t == r6.t) goto L69;
            return false;
        L69:
            if (this.u == r6.u) goto L72;
            return false;
        L72:
            if (this.v == r6.v) goto L75;
            return false;
        L75:
            if (this.w == r6.w) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.x, r6.x) == true) goto L80;
            return false;
        L80:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == false) goto L13;
            int r5 = 1231;
        L14:
            int r6 = (((r4 + r5) * 31) + this.d.hashCode()) * 31;
            if (this.e == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.f == false) goto L21;
            int r9 = 1231;
        L22:
            int r10 = (r8 + r9) * 31;
            e r11 = this.g;
            int r12 = 0;
            if (r11 != null) goto L25;
            int r13 = 0;
        L26:
            int r14 = (r10 + r13) * 31;
            c r15 = this.h;
            if (r15 != null) goto L29;
            int r16 = 0;
        L30:
            int r17 = (r14 + r16) * 31;
            if (this.i == false) goto L33;
            int r18 = 1231;
        L34:
            int r19 = (r17 + r18) * 31;
            if (this.j == false) goto L37;
            int r20 = 1231;
        L38:
            int r21 = (((r19 + r20) * 31) + this.k.hashCode()) * 31;
            b r22 = this.l;
            if (r22 != null) goto L41;
            int r23 = 0;
        L42:
            int r24 = (r21 + r23) * 31;
            d r25 = this.m;
            if (r25 != null) goto L45;
            int r26 = 0;
        L46:
            int r27 = (r24 + r26) * 31;
            if (this.n == false) goto L49;
            int r28 = 1231;
        L50:
            int r29 = (r27 + r28) * 31;
            Function0<Boolean> r30 = this.o;
            if (r30 != null) goto L53;
            int r31 = 0;
        L54:
            int r32 = (r29 + r31) * 31;
            if (this.p == false) goto L57;
            int r33 = 1231;
        L58:
            int r34 = (r32 + r33) * 31;
            if (this.q == false) goto L61;
            int r35 = 1231;
        L62:
            int r36 = (r34 + r35) * 31;
            if (this.r == false) goto L65;
            int r37 = 1231;
        L66:
            int r38 = (r36 + r37) * 31;
            if (this.s == false) goto L69;
            int r39 = 1231;
        L70:
            int r40 = (r38 + r39) * 31;
            if (this.t == false) goto L73;
            int r41 = 1231;
        L74:
            int r42 = (r40 + r41) * 31;
            if (this.u == false) goto L77;
            int r43 = 1231;
        L78:
            int r44 = (r42 + r43) * 31;
            if (this.v == false) goto L81;
            int r45 = 1231;
        L82:
            int r46 = (r44 + r45) * 31;
            if (this.w == true) goto L86;
            r1 = 1237;
        L86:
            int r47 = (r46 + r1) * 31;
            wc9.e r48 = this.x;
            if (r48 == null) goto L91;
            r12 = r48.hashCode();
        L91:
            return r47 + r12;
        L81:
            r45 = 1237;
            goto L82
        L77:
            r43 = 1237;
            goto L78
        L73:
            r41 = 1237;
            goto L74
        L69:
            r39 = 1237;
            goto L70
        L65:
            r37 = 1237;
            goto L66
        L61:
            r35 = 1237;
            goto L62
        L57:
            r33 = 1237;
            goto L58
        L53:
            r31 = r30.hashCode();
            goto L54
        L49:
            r28 = 1237;
            goto L50
        L45:
            r26 = r25.hashCode();
            goto L46
        L41:
            r23 = r22.hashCode();
            goto L42
        L37:
            r20 = 1237;
            goto L38
        L33:
            r18 = 1237;
            goto L34
        L29:
            r16 = r15.hashCode();
            goto L30
        L25:
            r13 = r11.hashCode();
            goto L26
        L21:
            r9 = 1237;
            goto L22
        L17:
            r7 = 1237;
            goto L18
        L13:
            r5 = 1237;
            goto L14
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(enable=" + this.a + ", speakerAsrOnly=" + this.b + ", disableFullScreenAction=" + this.c + ", statusConfig=" + this.d + ", disableAutoResetHint=" + this.e + ", disableKeyboardLongPressPopup=" + this.f + ", inputPopupMenuAction=" + this.g + ", actionEntranceOuterInterceptor=" + this.h + ", enableDisclaimer=" + this.i + ", enableActionbar=" + this.j + ", eventInfoMap=" + this.k + ", actionEntranceMenuInterceptor=" + this.l + ", inputAllActionMobInterceptor=" + this.m + ", enableClearContentTextAfterSend=" + this.n + ", onVoiceTouchBlockCallback=" + this.o + ", forceAudioInputEnable=" + this.p + ", banInstructionHandleContent=" + this.q + ", disableActionBar=" + this.r + ", enableSetFullScreenEditBackground=" + this.s + ", overrideActionEntranceIcon=" + this.t + ", takeOverActionEntranceVisibility=" + this.u + ", disableCreationActionEntrance=" + this.v + ", retainVoiceEntranceWithText=" + this.w + ", sendConversation=" + this.x + ')';
        }

        static {
            y = new a(0);
        }

        public /* synthetic */ a(int r26) {
            this(false, false, false, MapsKt.emptyMap(), false, false, null, null, true, true, MapsKt.emptyMap(), null, null, true, null, false, false, false, false, false, false, false, false, null);
        }

        public a(boolean r5, boolean r6, boolean r7, Map<Integer, g9.a> r8, boolean r9, boolean r10, e r11, c r12, boolean r13, boolean r14, Map<String, String> r15, b r16, d r17, boolean r18, Function0<Boolean> r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, wc9.e r28) {
            Intrinsics.checkNotNullParameter(r8, "statusConfig");
            Intrinsics.checkNotNullParameter(r15, "eventInfoMap");
            this.a = r5;
            this.b = r6;
            this.c = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r14;
            this.k = r15;
            this.l = r16;
            this.m = r17;
            this.n = r18;
            this.o = r19;
            this.p = r20;
            this.q = r21;
            this.r = r22;
            this.s = r23;
            this.t = r24;
            this.u = r25;
            this.v = r26;
            this.w = r27;
            this.x = r28;
        }

        public static a a(a r17, boolean r18, boolean r19, boolean r20, Map r21, boolean r22, boolean r23, e r24, c r25, boolean r26, boolean r27, Map r28, b r29, d r30, boolean r31, Function0 r32, boolean r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r39, boolean r40, wc9.e r41, int r42) {
            if ((r42 & 1) == 0) goto L5;
            boolean r2 = r17.a;
        L7:
            if ((r42 & 2) == 0) goto L9;
            boolean r3 = r17.b;
        L11:
            if ((r42 & 4) == 0) goto L13;
            boolean r4 = r17.c;
        L15:
            if ((r42 & 8) == 0) goto L17;
            Map r5 = r17.d;
        L19:
            if ((r42 & 16) == 0) goto L21;
            boolean r6 = r17.e;
        L23:
            if ((r42 & 32) == 0) goto L25;
            boolean r7 = r17.f;
        L27:
            if ((r42 & 64) == 0) goto L29;
            e r8 = r17.g;
        L31:
            if ((r42 & 128) == 0) goto L33;
            c r9 = r17.h;
        L35:
            if ((r42 & 256) == 0) goto L37;
            boolean r10 = r17.i;
        L39:
            if ((r42 & 512) == 0) goto L41;
            boolean r11 = r17.j;
        L43:
            if ((r42 & 1024) == 0) goto L45;
            Map r12 = r17.k;
        L47:
            if ((r42 & 2048) == 0) goto L49;
            b r13 = r17.l;
        L51:
            if ((r42 & 4096) == 0) goto L53;
            d r14 = r17.m;
        L55:
            if ((r42 & 8192) == 0) goto L57;
            boolean r15 = r17.n;
        L58:
            boolean r310 = r15;
            if ((r42 & 16384) == 0) goto L61;
            Function0 r16 = r17.o;
        L62:
            Function0 r311 = r16;
            if ((r42 & 32768) == 0) goto L65;
            boolean r110 = r17.p;
        L66:
            boolean r312 = r110;
            if ((r42 & 65536) == 0) goto L69;
            boolean r111 = r17.q;
        L70:
            boolean r313 = r111;
            if ((r42 & 131072) == 0) goto L73;
            boolean r112 = r17.r;
        L74:
            boolean r314 = r112;
            if ((r42 & 262144) == 0) goto L77;
            boolean r113 = r17.s;
        L78:
            boolean r315 = r113;
            if ((r42 & 524288) == 0) goto L81;
            boolean r114 = r17.t;
        L82:
            boolean r316 = r114;
            if ((r42 & 1048576) == 0) goto L85;
            boolean r115 = r17.u;
        L86:
            boolean r317 = r115;
            if ((r42 & 2097152) == 0) goto L89;
            boolean r116 = r17.v;
        L90:
            boolean r318 = r116;
            if ((r42 & 4194304) == 0) goto L93;
            boolean r117 = r17.w;
        L95:
            if ((r42 & 8388608) == 0) goto L97;
            wc9.e r1 = r17.x;
        L98:
            r17.getClass();
            Intrinsics.checkNotNullParameter(r5, "statusConfig");
            Intrinsics.checkNotNullParameter(r12, "eventInfoMap");
            return new a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r117, r1);
        L97:
            r1 = r41;
            goto L98
        L93:
            r117 = r40;
            goto L95
        L89:
            r116 = r39;
            goto L90
        L85:
            r115 = r38;
            goto L86
        L81:
            r114 = r37;
            goto L82
        L77:
            r113 = r36;
            goto L78
        L73:
            r112 = r35;
            goto L74
        L69:
            r111 = r34;
            goto L70
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }
    }

    public static final class b {
        public final boolean a;
        public final Function0<Unit> b;

        public b() {
            boolean r1 = false;
            this(r1, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            Function0<Unit> r2 = this.b;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "InputActionEntranceMenuInterceptor(enableShown=" + this.a + ", onActionEntranceMenuClick=" + this.b + ')';
        }

        public /* synthetic */ b(boolean r1, int r2) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1, null);
        }

        public b(boolean r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final Function2<? super Integer, ? super String, Unit> a;
        public final Function0<Boolean> b;

        public c() {
            this(null, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Function2<? super Integer, ? super String, Unit> r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Function0<Boolean> r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "InputActionEntranceOuterInterceptor(onOuterClicked=" + this.a + ", onOuterVisibilityInterceptor=" + this.b + ')';
        }

        public /* synthetic */ c(com.larus.common.venue.impl.venue.component.e r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = null;
        L5:
            this(r2, null);
        }

        public c(Function2<? super Integer, ? super String, Unit> r1, Function0<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d {
        public final Function1<String, Boolean> a;

        public d() {
            this(null);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Function1<String, Boolean> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "InputAllActionMobInterceptor(onInputSwitch=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super String, Boolean> r1) {
            this.a = r1;
        }
    }

    public static final class e {
        public final Function0<Unit> a;
        public final Function0<Unit> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "InputPopupMenuAction(onCopyMenuClick=" + this.a + ", onCopyAndSendMenuClick=" + this.b + ')';
        }

        public e(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "onCopyMenuClick");
            Intrinsics.checkNotNullParameter(r3, "onCopyAndSendMenuClick");
            this.a = r2;
            this.b = r3;
        }
    }

    void C8(boolean r1);

    void R8();

    void S8(boolean r1);

    void W8(c r1);

    void X8();

    void a9(boolean r1);

    void c9();

    void e9();

    void f9(boolean r1);

    void g9(Map<String, String> r1);

    void j9();

    void l9(b r1);

    void n9(boolean r1);

    void r8(boolean r1, e r2);

    void r9();

    void s9();

    void t9(d r1);

    void v9(Function0<Boolean> r1);

    void w8();

    void w9(boolean r1);

    void y9(int r1, g9.a r2);

    void z9(boolean r1);
}
