package di8;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.nestedmenu.NestedMenuPopupStrategy;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 {
    public final boolean a;
    public final boolean b;
    public final ReplyOption c;
    public final boolean d;
    public final Map<String, String> e;
    public final boolean f;
    public final Map<String, String> g;
    public final String h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final Integer m;
    public final boolean n;
    public final Function1<View, Unit> o;
    public final NestedMenuPopupStrategy p;
    public final Function1<View, Integer> q;
    public final Function0<Integer> r;
    public final View s;
    public final Function0<Unit> t;
    public final boolean u;
    public final boolean v;
    public final Function0<Unit> w;
    public final Integer x;
    public final Boolean y;

    public o0() {
        this(false, false, null, false, null, 0, 0, false, null, null, null, null, null, null, false, false, null, null, null, 33554431);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r6 = (o0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
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
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r6.u) goto L72;
        return false;
    L72:
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L83;
        return false;
    L83:
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
        ReplyOption r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((r8 + r9) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (((r10 + r11) * 31) + this.g.hashCode()) * 31;
        String r13 = this.h;
        if (r13 != null) goto L25;
        int r14 = 0;
    L26:
        int r15 = (r12 + r14) * 31;
        if (this.i == false) goto L29;
        int r16 = 1231;
    L30:
        int r17 = (((((((r15 + r16) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31;
        Integer r18 = this.m;
        if (r18 != null) goto L33;
        int r19 = 0;
    L34:
        int r20 = (r17 + r19) * 31;
        if (this.n == false) goto L37;
        int r21 = 1231;
    L38:
        int r22 = (r20 + r21) * 31;
        Function1<View, Unit> r23 = this.o;
        if (r23 != null) goto L41;
        int r24 = 0;
    L42:
        int r25 = (((r22 + r24) * 31) + this.p.hashCode()) * 31;
        Function1<View, Integer> r26 = this.q;
        if (r26 != null) goto L45;
        int r27 = 0;
    L46:
        int r28 = (r25 + r27) * 31;
        Function0<Integer> r29 = this.r;
        if (r29 != null) goto L49;
        int r30 = 0;
    L50:
        int r31 = (r28 + r30) * 31;
        View r32 = this.s;
        if (r32 != null) goto L53;
        int r33 = 0;
    L54:
        int r34 = (r31 + r33) * 31;
        Function0<Unit> r35 = this.t;
        if (r35 != null) goto L57;
        int r36 = 0;
    L58:
        int r37 = (r34 + r36) * 31;
        if (this.u == false) goto L61;
        int r38 = 1231;
    L62:
        int r39 = (r37 + r38) * 31;
        if (this.v == true) goto L66;
        r1 = 1237;
    L66:
        int r40 = (r39 + r1) * 31;
        Function0<Unit> r41 = this.w;
        if (r41 != null) goto L69;
        int r42 = 0;
    L70:
        int r43 = (r40 + r42) * 31;
        Integer r44 = this.x;
        if (r44 != null) goto L73;
        int r45 = 0;
    L74:
        int r46 = (r43 + r45) * 31;
        Boolean r47 = this.y;
        if (r47 == null) goto L79;
        r6 = r47.hashCode();
    L79:
        return r46 + r6;
    L73:
        r45 = r44.hashCode();
        goto L74
    L69:
        r42 = r41.hashCode();
        goto L70
    L61:
        r38 = 1237;
        goto L62
    L57:
        r36 = r35.hashCode();
        goto L58
    L53:
        r33 = r32.hashCode();
        goto L54
    L49:
        r30 = r29.hashCode();
        goto L50
    L45:
        r27 = r26.hashCode();
        goto L46
    L41:
        r24 = r23.hashCode();
        goto L42
    L37:
        r21 = 1237;
        goto L38
    L33:
        r19 = r18.hashCode();
        goto L34
    L29:
        r16 = 1237;
        goto L30
    L25:
        r14 = r13.hashCode();
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "NestedMenuUiConfig(modeOnly=" + this.a + ", conversationForkSourceIsTask=" + this.b + ", conversationForkSourceReplyOption=" + this.c + ", conversationForkShowsDeviceTargets=" + this.d + ", conversationForkSourceExt=" + this.e + ", conversationForkSourceSnapshotProvided=" + this.f + ", conversationForkTrackingParams=" + this.g + ", conversationForkPlaceholderText=" + this.h + ", updateExistingPresentation=" + this.i + ", sectionSpacing=" + this.j + ", minimumWidth=" + this.k + ", maxWidth=" + this.l + ", maxHeight=" + this.m + ", shouldApplyLegacyPopupMargin=" + this.n + ", popupMarginUpdater=" + this.o + ", popupStrategy=" + this.p + ", popupXOffProvider=" + this.q + ", popupYOffProvider=" + this.r + ", secondaryMenuParentView=" + this.s + ", onSecondaryMenuOutsideTouch=" + this.t + ", keepPopupLeadingEdgeAligned=" + this.u + ", keepPopupTrailingEdgeAligned=" + this.v + ", onPopupDismiss=" + this.w + ", showPosition=" + this.x + ", focusable=" + this.y + ')';
    }

    public static o0 a(o0 r30, boolean r31, ReplyOption r32, boolean r33, String r34, boolean r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        boolean r5 = r30.a;
    L7:
        if ((r36 & 2) == 0) goto L9;
        boolean r6 = r30.b;
    L11:
        if ((r36 & 4) == 0) goto L13;
        ReplyOption r7 = r30.c;
    L15:
        if ((r36 & 8) == 0) goto L17;
        boolean r8 = r30.d;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Map<String, String> r9 = r30.e;
    L23:
        if ((r36 & 32) == 0) goto L25;
        boolean r10 = r30.f;
    L27:
        if ((r36 & 64) == 0) goto L29;
        Map<String, String> r11 = r30.g;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r12 = r30.h;
    L35:
        if ((r36 & 256) == 0) goto L37;
        boolean r13 = r30.i;
    L39:
        if ((r36 & 512) == 0) goto L41;
        int r14 = r30.j;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        int r15 = r30.k;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        int r16 = r30.l;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        Integer r17 = r30.m;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        boolean r18 = r30.n;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        Function1<View, Unit> r19 = r30.o;
    L63:
        if ((32768 & r36) == 0) goto L65;
        NestedMenuPopupStrategy r2 = r30.p;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        Function1<View, Integer> r21 = r30.q;
    L71:
        if ((131072 & r36) == 0) goto L73;
        Function0<Integer> r22 = r30.r;
    L75:
        if ((262144 & r36) == 0) goto L77;
        View r23 = r30.s;
    L79:
        if ((524288 & r36) == 0) goto L81;
        Function0<Unit> r24 = r30.t;
    L83:
        if ((1048576 & r36) == 0) goto L85;
        boolean r25 = r30.u;
    L87:
        if ((2097152 & r36) == 0) goto L89;
        boolean r26 = r30.v;
    L91:
        if ((4194304 & r36) == 0) goto L93;
        Function0<Unit> r27 = r30.w;
    L95:
        if ((8388608 & r36) == 0) goto L97;
        Integer r28 = r30.x;
    L99:
        if ((r36 & 16777216) == 0) goto L101;
        Boolean r29 = r30.y;
    L102:
        r30.getClass();
        Intrinsics.checkNotNullParameter(r9, "conversationForkSourceExt");
        Intrinsics.checkNotNullParameter(r11, "conversationForkTrackingParams");
        Intrinsics.checkNotNullParameter(r2, "popupStrategy");
        return new o0(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r2, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    L101:
        r29 = null;
        goto L102
    L97:
        r28 = null;
        goto L99
    L93:
        r27 = null;
        goto L95
    L89:
        r26 = false;
        goto L91
    L85:
        r25 = false;
        goto L87
    L81:
        r24 = null;
        goto L83
    L77:
        r23 = null;
        goto L79
    L73:
        r22 = null;
        goto L75
    L69:
        r21 = null;
        goto L71
    L65:
        r2 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = false;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = 0;
        goto L51
    L45:
        r15 = 0;
        goto L47
    L41:
        r14 = 0;
        goto L43
    L37:
        r13 = r35;
        goto L39
    L33:
        r12 = r34;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = false;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = r33;
        goto L19
    L13:
        r7 = r32;
        goto L15
    L9:
        r6 = r31;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public /* synthetic */ o0(boolean r30, boolean r31, Map r32, boolean r33, Map r34, int r35, int r36, boolean r37, Function1 r38, NestedMenuPopupStrategy r39, Function1 r40, Function0 r41, LinearLayoutCompat r42, Function0 r43, boolean r44, boolean r45, Function0 r46, Integer r47, Boolean r48, int r49) {
        if ((r49 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r49 & 8) == 0) goto L9;
        boolean r7 = false;
    L11:
        if ((r49 & 16) == 0) goto L13;
        Map r8 = MapsKt.emptyMap();
    L15:
        if ((r49 & 32) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r49 & 64) == 0) goto L21;
        Map r10 = MapsKt.emptyMap();
    L23:
        if ((r49 & 512) == 0) goto L25;
        int r13 = i5.r0();
    L27:
        if ((r49 & 1024) == 0) goto L29;
        int r14 = i5.B();
    L31:
        if ((r49 & 2048) == 0) goto L33;
        int r15 = i5.y0(c.b(2130971356, null, 2131167081));
    L35:
        if ((r49 & 8192) == 0) goto L37;
        boolean r17 = true;
    L39:
        if ((r49 & 16384) == 0) goto L41;
        Function1 r18 = null;
    L43:
        if ((32768 & r49) == 0) goto L45;
        NestedMenuPopupStrategy r19 = NestedMenuPopupStrategy.ALIGN_TOP;
    L47:
        if ((65536 & r49) == 0) goto L49;
        Function1 r20 = null;
    L51:
        if ((131072 & r49) == 0) goto L53;
        Function0 r21 = null;
    L55:
        if ((262144 & r49) == 0) goto L57;
        LinearLayoutCompat r22 = null;
    L59:
        if ((524288 & r49) == 0) goto L61;
        Function0 r23 = null;
    L63:
        if ((1048576 & r49) == 0) goto L65;
        boolean r24 = false;
    L67:
        if ((2097152 & r49) == 0) goto L69;
        boolean r25 = false;
    L71:
        if ((4194304 & r49) == 0) goto L73;
        Function0 r26 = null;
    L75:
        if ((8388608 & r49) == 0) goto L77;
        Integer r27 = null;
    L79:
        if ((r49 & 16777216) == 0) goto L81;
        Boolean r28 = null;
    L82:
        this(r4, false, null, r7, r8, r9, r10, null, false, r13, r14, r15, null, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return;
    L81:
        r28 = r48;
        goto L82
    L77:
        r27 = r47;
        goto L79
    L73:
        r26 = r46;
        goto L75
    L69:
        r25 = r45;
        goto L71
    L65:
        r24 = r44;
        goto L67
    L61:
        r23 = r43;
        goto L63
    L57:
        r22 = r42;
        goto L59
    L53:
        r21 = r41;
        goto L55
    L49:
        r20 = r40;
        goto L51
    L45:
        r19 = r39;
        goto L47
    L41:
        r18 = r38;
        goto L43
    L37:
        r17 = r37;
        goto L39
    L33:
        r15 = r36;
        goto L35
    L29:
        r14 = r35;
        goto L31
    L25:
        r13 = 0;
        goto L27
    L21:
        r10 = r34;
        goto L23
    L17:
        r9 = r33;
        goto L19
    L13:
        r8 = r32;
        goto L15
    L9:
        r7 = r31;
        goto L11
    L5:
        r4 = r30;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(boolean r6, boolean r7, ReplyOption r8, boolean r9, Map<String, String> r10, boolean r11, Map<String, String> r12, String r13, boolean r14, int r15, int r16, int r17, Integer r18, boolean r19, Function1<? super View, Unit> r20, NestedMenuPopupStrategy r21, Function1<? super View, Integer> r22, Function0<Integer> r23, View r24, Function0<Unit> r25, boolean r26, boolean r27, Function0<Unit> r28, Integer r29, Boolean r30) {
        Intrinsics.checkNotNullParameter(r10, "conversationForkSourceExt");
        Intrinsics.checkNotNullParameter(r12, "conversationForkTrackingParams");
        Intrinsics.checkNotNullParameter(r21, "popupStrategy");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        this.t = r25;
        this.u = r26;
        this.v = r27;
        this.w = r28;
        this.x = r29;
        this.y = r30;
    }
}
