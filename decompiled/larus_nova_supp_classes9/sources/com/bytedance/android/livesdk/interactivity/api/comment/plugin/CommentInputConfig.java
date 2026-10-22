package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentInputConfig {
    public final State a;
    public final State b;
    public final State c;
    public final State d;
    public final State e;
    public final State f;
    public final State g;
    public final State h;
    public final State i;
    public final State j;
    public final State k;
    public final State l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final State q;
    public final String r;
    public final boolean s;
    public final boolean t;
    public final State u;
    public final State v;
    public final boolean w;
    public final State x;
    public final State y;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentInputConfig$State;", BuildConfig.FLAVOR, "ForceOpen", "ForeClose", "NotCare", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State ForceOpen = null;
        public static final State ForeClose = null;
        public static final State NotCare = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("ForceOpen", 0);
            ForceOpen = r1;
            State r2 = new State("ForeClose", 1);
            ForeClose = r2;
            State r3 = new State("NotCare", 2);
            NotCare = r3;
            a = new State[]{r1, r2, r3};
        }

        public static State valueOf(String r1) {
            return (State) a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CommentInputConfig() {
        this(null, null, null, null, null, null, null, null, null, null, false, false, false, false, null, null, false, null, null, null, 33554431);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommentInputConfig) == false) goto L56;
        CommentInputConfig r4 = (CommentInputConfig) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (this.n == r4.n) goto L34;
        return false;
    L34:
        if (this.o == r4.o) goto L36;
        return false;
    L36:
        if (this.p == r4.p) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r4.r) == true) goto L42;
        return false;
    L42:
        if (this.s == r4.s) goto L44;
        return false;
    L44:
        if (this.t == r4.t) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.u, r4.u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.v, r4.v) == true) goto L50;
        return false;
    L50:
        if (this.w == r4.w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.x, r4.x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.y, r4.y) == true) goto L85;
        return false;
    L85:
        return true;
    L56:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50, types: [int] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        State r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        State r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        State r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        State r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        State r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        State r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        State r20 = this.g;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r23 = (r19 + r21) * 31;
        State r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        State r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        State r30 = this.j;
        if (r30 == null) goto L41;
        int r31 = r30.hashCode();
    L42:
        int r33 = (r29 + r31) * 31;
        State r34 = this.k;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        State r37 = this.l;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        boolean r40 = this.m;
        ?? r41 = 1;
        ?? r43 = r40;
        if (r40 == false) goto L53;
        r43 = 1;
    L53:
        int r44 = (r39 + r43) * 31;
        boolean r45 = this.n;
        ?? r46 = r45;
        if (r45 == false) goto L56;
        r46 = 1;
    L56:
        int r47 = (r44 + r46) * 31;
        boolean r48 = this.o;
        ?? r49 = r48;
        if (r48 == false) goto L59;
        r49 = 1;
    L59:
        int r50 = (r47 + r49) * 31;
        boolean r51 = this.p;
        ?? r53 = r51;
        if (r51 == false) goto L62;
        r53 = 1;
    L62:
        int r54 = (r50 + r53) * 31;
        State r55 = this.q;
        if (r55 == null) goto L65;
        int r56 = r55.hashCode();
    L66:
        int r57 = (r54 + r56) * 31;
        String r58 = this.r;
        if (r58 == null) goto L69;
        int r59 = r58.hashCode();
    L70:
        int r60 = (r57 + r59) * 31;
        boolean r61 = this.s;
        ?? r63 = r61;
        if (r61 == false) goto L73;
        r63 = 1;
    L73:
        int r64 = (r60 + r63) * 31;
        boolean r65 = this.t;
        ?? r66 = r65;
        if (r65 == false) goto L76;
        r66 = 1;
    L76:
        int r67 = (r64 + r66) * 31;
        State r68 = this.u;
        if (r68 == null) goto L79;
        int r69 = r68.hashCode();
    L80:
        int r70 = (r67 + r69) * 31;
        State r71 = this.v;
        if (r71 == null) goto L83;
        int r73 = r71.hashCode();
    L84:
        int r74 = (r70 + r73) * 31;
        boolean r75 = this.w;
        if (r75 == true) goto L88;
        r41 = r75;
    L88:
        int r76 = (r74 + r41) * 31;
        State r77 = this.x;
        if (r77 == null) goto L91;
        int r78 = r77.hashCode();
    L92:
        int r79 = (r76 + r78) * 31;
        State r80 = this.y;
        if (r80 == null) goto L96;
        r1 = r80.hashCode();
    L96:
        return r79 + r1;
    L91:
        r78 = 0;
        goto L92
    L83:
        r73 = 0;
        goto L84
    L79:
        r69 = 0;
        goto L80
    L69:
        r59 = 0;
        goto L70
    L65:
        r56 = 0;
        goto L66
    L49:
        r38 = 0;
        goto L50
    L45:
        r35 = 0;
        goto L46
    L41:
        r31 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentInputConfig(enableDanmu=" + this.a + ", enableSubscribeEmoji=" + this.b + ", enableVoiceEntry=" + this.c + ", enableAsr=" + this.d + ", enableVideoEntry=" + this.e + ", enableHotMsg=" + this.f + ", enableEmotionalText=" + this.g + ", enableCustomerEntrance=" + this.h + ", enableFrequentChat=" + this.i + ", enableAI=" + this.j + ", enableInteractivityShare=" + this.k + ", enableRaisePublicScreen=" + this.l + ", ignoreUserBanned=" + this.m + ", ignoreAnchorBanned=" + this.n + ", ignoreFixComment=" + this.o + ", ignoreLandscapeBarrageBlock=" + this.p + ", enableQuickComment=" + this.q + ", hintText=" + this.r + ", enableMention=" + this.s + ", enableMentionFriend=" + this.t + ", enableActivityEmoji=" + this.u + ", enableGuideChat=" + this.v + ", enableHighlight=" + this.w + ", enableFusionEmoji=" + this.x + ", enableWordAssociate=" + this.y + ")";
    }

    public CommentInputConfig(State r25, State r26, State r27, State r28, State r29, State r30, State r31, State r33, State r34, State r35, boolean r36, boolean r37, boolean r38, boolean r39, State r310, String r40, boolean r41, State r43, State r44, State r45, int r46) {
        if ((r46 & 1) == 0) goto L5;
        State r2 = State.NotCare;
    L7:
        if ((r46 & 2) == 0) goto L9;
        State r3 = State.NotCare;
    L11:
        if ((r46 & 4) == 0) goto L13;
        State r4 = State.NotCare;
    L15:
        if ((r46 & 8) == 0) goto L17;
        State r5 = State.NotCare;
    L19:
        if ((r46 & 16) == 0) goto L21;
        State r7 = State.NotCare;
    L23:
        if ((r46 & 32) == 0) goto L25;
        State r8 = State.NotCare;
    L27:
        if ((r46 & 64) == 0) goto L29;
        State r9 = State.NotCare;
    L31:
        if ((r46 & 128) == 0) goto L33;
        State r10 = State.NotCare;
    L35:
        if ((r46 & 256) == 0) goto L37;
        State r11 = State.NotCare;
    L39:
        if ((r46 & 512) == 0) goto L41;
        State r13 = State.NotCare;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        State r14 = State.NotCare;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        State r15 = State.NotCare;
    L51:
        if ((r46 & 4096) == 0) goto L53;
        boolean r16 = false;
    L55:
        if ((r46 & 8192) == 0) goto L57;
        boolean r6 = false;
    L58:
        boolean r210 = r6;
        if ((r46 & 16384) == 0) goto L61;
        boolean r17 = false;
    L63:
        if ((r46 & 32768) == 0) goto L65;
        boolean r18 = false;
    L67:
        if ((r46 & 65536) == 0) goto L69;
        State r19 = State.NotCare;
    L71:
        if ((r46 & 131072) == 0) goto L73;
        String r110 = null;
    L75:
        if ((r46 & 262144) == 0) goto L77;
        boolean r20 = false;
    L79:
        if ((r46 & 1048576) == 0) goto L81;
        State r111 = State.NotCare;
    L83:
        if ((r46 & 2097152) == 0) goto L85;
        State r0 = State.ForeClose;
    L87:
        if ((r46 & 8388608) == 0) goto L89;
        State r23 = State.NotCare;
    L91:
        if ((r46 & 16777216) == 0) goto L93;
        State r21 = State.NotCare;
    L94:
        Intrinsics.checkNotNullParameter(r2, "enableDanmu");
        Intrinsics.checkNotNullParameter(r3, "enableSubscribeEmoji");
        Intrinsics.checkNotNullParameter(r4, "enableVoiceEntry");
        Intrinsics.checkNotNullParameter(r5, "enableAsr");
        Intrinsics.checkNotNullParameter(r7, "enableVideoEntry");
        Intrinsics.checkNotNullParameter(r8, "enableHotMsg");
        Intrinsics.checkNotNullParameter(r9, "enableEmotionalText");
        Intrinsics.checkNotNullParameter(r10, "enableCustomerEntrance");
        Intrinsics.checkNotNullParameter(r11, "enableFrequentChat");
        Intrinsics.checkNotNullParameter(r13, "enableAI");
        Intrinsics.checkNotNullParameter(r14, "enableInteractivityShare");
        Intrinsics.checkNotNullParameter(r15, "enableRaisePublicScreen");
        Intrinsics.checkNotNullParameter(r19, "enableQuickComment");
        Intrinsics.checkNotNullParameter(r111, "enableActivityEmoji");
        Intrinsics.checkNotNullParameter(r0, "enableGuideChat");
        State r211 = r0;
        Intrinsics.checkNotNullParameter(r23, "enableFusionEmoji");
        Intrinsics.checkNotNullParameter(r21, "enableWordAssociate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r210;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r110;
        this.s = r20;
        this.t = false;
        this.u = r111;
        this.v = r211;
        this.w = false;
        this.x = r23;
        this.y = r21;
        return;
    L93:
        r21 = r45;
        goto L94
    L89:
        r23 = r44;
        goto L91
    L85:
        r0 = null;
        goto L87
    L81:
        r111 = r43;
        goto L83
    L77:
        r20 = r41;
        goto L79
    L73:
        r110 = r40;
        goto L75
    L69:
        r19 = r310;
        goto L71
    L65:
        r18 = r39;
        goto L67
    L61:
        r17 = r38;
        goto L63
    L57:
        r6 = r37;
        goto L58
    L53:
        r16 = r36;
        goto L55
    L49:
        r15 = null;
        goto L51
    L45:
        r14 = r35;
        goto L47
    L41:
        r13 = r34;
        goto L43
    L37:
        r11 = r33;
        goto L39
    L33:
        r10 = r31;
        goto L35
    L29:
        r9 = r30;
        goto L31
    L25:
        r8 = r29;
        goto L27
    L21:
        r7 = r28;
        goto L23
    L17:
        r5 = null;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r2 = r25;
        goto L7
    }
}
