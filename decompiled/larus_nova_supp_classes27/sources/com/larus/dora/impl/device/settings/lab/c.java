package com.larus.dora.impl.device.settings.lab;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        public final boolean s;
        public final boolean t;
        public final boolean u;
        public final boolean v;

        public b() {
            this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L54;
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
            if (this.v == r6.v) goto L74;
            return false;
        L74:
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
            int r6 = (r4 + r5) * 31;
            if (this.d == false) goto L17;
            int r7 = 1231;
        L18:
            int r8 = (r6 + r7) * 31;
            if (this.e == false) goto L21;
            int r9 = 1231;
        L22:
            int r10 = (r8 + r9) * 31;
            if (this.f == false) goto L25;
            int r11 = 1231;
        L26:
            int r12 = (r10 + r11) * 31;
            if (this.g == false) goto L29;
            int r13 = 1231;
        L30:
            int r14 = (r12 + r13) * 31;
            if (this.h == false) goto L33;
            int r15 = 1231;
        L34:
            int r16 = (r14 + r15) * 31;
            if (this.i == false) goto L37;
            int r17 = 1231;
        L38:
            int r18 = (r16 + r17) * 31;
            if (this.j == false) goto L41;
            int r20 = 1231;
        L42:
            int r21 = (r18 + r20) * 31;
            if (this.k == false) goto L45;
            int r22 = 1231;
        L46:
            int r23 = (r21 + r22) * 31;
            if (this.l == false) goto L49;
            int r24 = 1231;
        L50:
            int r25 = (r23 + r24) * 31;
            if (this.m == false) goto L53;
            int r26 = 1231;
        L54:
            int r27 = (r25 + r26) * 31;
            if (this.n == false) goto L57;
            int r28 = 1231;
        L58:
            int r30 = (r27 + r28) * 31;
            if (this.o == false) goto L61;
            int r31 = 1231;
        L62:
            int r32 = (r30 + r31) * 31;
            if (this.p == false) goto L65;
            int r33 = 1231;
        L66:
            int r34 = (r32 + r33) * 31;
            if (this.q == false) goto L69;
            int r35 = 1231;
        L70:
            int r36 = (r34 + r35) * 31;
            if (this.r == false) goto L73;
            int r37 = 1231;
        L74:
            int r38 = (r36 + r37) * 31;
            if (this.s == false) goto L77;
            int r40 = 1231;
        L78:
            int r41 = (r38 + r40) * 31;
            if (this.t == false) goto L81;
            int r42 = 1231;
        L82:
            int r43 = (r41 + r42) * 31;
            if (this.u == false) goto L85;
            int r44 = 1231;
        L86:
            int r45 = (r43 + r44) * 31;
            if (this.v == true) goto L91;
            r1 = 1237;
        L91:
            return r45 + r1;
        L85:
            r44 = 1237;
            goto L86
        L81:
            r42 = 1237;
            goto L82
        L77:
            r40 = 1237;
            goto L78
        L73:
            r37 = 1237;
            goto L74
        L69:
            r35 = 1237;
            goto L70
        L65:
            r33 = 1237;
            goto L66
        L61:
            r31 = 1237;
            goto L62
        L57:
            r28 = 1237;
            goto L58
        L53:
            r26 = 1237;
            goto L54
        L49:
            r24 = 1237;
            goto L50
        L45:
            r22 = 1237;
            goto L46
        L41:
            r20 = 1237;
            goto L42
        L37:
            r17 = 1237;
            goto L38
        L33:
            r15 = 1237;
            goto L34
        L29:
            r13 = 1237;
            goto L30
        L25:
            r11 = 1237;
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
            return "Success(isSupportEnvObserver=" + this.a + ", envEnable=" + this.b + ", envState=" + this.c + ", envAuthEnable=" + this.d + ", isSupportSimulInterpret=" + this.e + ", isSupportQuickContinuousConversation=" + this.f + ", quickContinuousConversationEnable=" + this.g + ", naturalInteractionBgmEnable=" + this.h + ", isSupportRecordMinutes=" + this.i + ", allowDoubaoViewImagesEnable=" + this.j + ", rtosPlayerEnable=" + this.k + ", isSupportRtosPlayer=" + this.l + ", bluetoothRTCEnable=" + this.m + ", p2pRTCEnable=" + this.n + ", isSupportBluetoothRTC=" + this.o + ", isP2PRTCRuntimeSupported=" + this.p + ", isP2PRTCAbilitySupported=" + this.q + ", isSupportHeadGestureControl=" + this.r + ", isSupportBehaviorAware=" + this.s + ", behaviorAwareEnable=" + this.t + ", isDataSavingEntranceVisible=" + this.u + ", dataSavingEnable=" + this.v + ')';
        }

        public static b a(b r27, boolean r28, boolean r210, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r310, boolean r40, int r41) {
            if ((r41 & 1) == 0) goto L5;
            boolean r5 = r27.a;
        L7:
            if ((r41 & 2) == 0) goto L9;
            boolean r6 = r27.b;
        L11:
            if ((r41 & 4) == 0) goto L13;
            boolean r7 = r27.c;
        L15:
            if ((r41 & 8) == 0) goto L17;
            boolean r8 = r27.d;
        L19:
            if ((r41 & 16) == 0) goto L21;
            boolean r9 = r27.e;
        L23:
            if ((r41 & 32) == 0) goto L25;
            boolean r10 = r27.f;
        L27:
            if ((r41 & 64) == 0) goto L29;
            boolean r11 = r27.g;
        L31:
            if ((r41 & 128) == 0) goto L33;
            boolean r12 = r27.h;
        L35:
            if ((r41 & 256) == 0) goto L37;
            boolean r13 = r27.i;
        L39:
            if ((r41 & 512) == 0) goto L41;
            boolean r14 = r27.j;
        L43:
            if ((r41 & 1024) == 0) goto L45;
            boolean r15 = r27.k;
        L47:
            if ((r41 & 2048) == 0) goto L49;
            boolean r16 = r27.l;
        L51:
            if ((r41 & 4096) == 0) goto L53;
            boolean r17 = r27.m;
        L55:
            if ((r41 & 8192) == 0) goto L57;
            boolean r18 = r27.n;
        L59:
            if ((r41 & 16384) == 0) goto L61;
            boolean r110 = r27.o;
        L63:
            if ((32768 & r41) == 0) goto L65;
            boolean r20 = r27.p;
        L67:
            if ((65536 & r41) == 0) goto L69;
            boolean r21 = r27.q;
        L71:
            if ((131072 & r41) == 0) goto L73;
            boolean r22 = r27.r;
        L75:
            if ((262144 & r41) == 0) goto L77;
            boolean r23 = r27.s;
        L79:
            if ((524288 & r41) == 0) goto L81;
            boolean r24 = r27.t;
        L83:
            if ((1048576 & r41) == 0) goto L85;
            boolean r25 = r27.u;
        L87:
            if ((r41 & 2097152) == 0) goto L89;
            boolean r26 = r27.v;
        L90:
            r27.getClass();
            return new b(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26);
        L89:
            r26 = r40;
            goto L90
        L85:
            r25 = false;
            goto L87
        L81:
            r24 = r310;
            goto L83
        L77:
            r23 = false;
            goto L79
        L73:
            r22 = false;
            goto L75
        L69:
            r21 = r38;
            goto L71
        L65:
            r20 = r37;
            goto L67
        L61:
            r110 = false;
            goto L63
        L57:
            r18 = r36;
            goto L59
        L53:
            r17 = r35;
            goto L55
        L49:
            r16 = false;
            goto L51
        L45:
            r15 = r34;
            goto L47
        L41:
            r14 = r33;
            goto L43
        L37:
            r13 = false;
            goto L39
        L33:
            r12 = r32;
            goto L35
        L29:
            r11 = r31;
            goto L31
        L25:
            r10 = false;
            goto L27
        L21:
            r9 = false;
            goto L23
        L17:
            r8 = r30;
            goto L19
        L13:
            r7 = r210;
            goto L15
        L9:
            r6 = r28;
            goto L11
        L5:
            r5 = false;
            goto L7
        }

        public b(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r110, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24) {
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = r14;
            this.m = r15;
            this.n = r16;
            this.o = r17;
            this.p = r18;
            this.q = r110;
            this.r = r20;
            this.s = r21;
            this.t = r22;
            this.u = r23;
            this.v = r24;
        }
    }
}
