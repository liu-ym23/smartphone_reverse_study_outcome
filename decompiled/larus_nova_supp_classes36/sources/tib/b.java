package tib;

import android.view.View;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.p;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.base.widget.CustomSearchResultItem;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final List<ActionType> b;
    public final Boolean c;
    public final Boolean d;
    public final Integer e;
    public final Boolean f;
    public final Boolean g;
    public final BasePicker.IViewDependency h;
    public final BasePicker.IOnPickNotify i;
    public final SearchResultView.IOnBusinessConsumeItem j;
    public final d k;
    public final IncludeConfig l;
    public final boolean m;
    public final List<CustomSearchResultItem> n;
    public final y3c.a o;
    public final BasePicker.IOnPickModeChangeListener p;
    public final View q;
    public final Boolean r;
    public final SearchResultAdapter s;
    public final boolean t;

    public b() {
        this(null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 2097151);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L48;
        return false;
    L48:
        if (this.m == r6.m) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L69;
        return false;
    L69:
        if (this.t == r6.t) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<ActionType> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        BasePicker.IViewDependency r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        BasePicker.IOnPickNotify r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        SearchResultView.IOnBusinessConsumeItem r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (((r27 + r29) * 31) + 0) * 31;
        d r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        IncludeConfig r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        int r37 = 1231;
        if (this.m == false) goto L53;
        int r38 = 1231;
    L54:
        int r39 = (r36 + r38) * 31;
        List<CustomSearchResultItem> r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        y3c.a r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        BasePicker.IOnPickModeChangeListener r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        View r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Boolean r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        SearchResultAdapter r55 = this.s;
        if (r55 == null) goto L78;
        r1 = r55.hashCode();
    L78:
        int r56 = (r54 + r1) * 31;
        if (this.t == true) goto L83;
        r37 = 1237;
    L83:
        return r56 + r37;
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = 1237;
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForwardChatPickerConfig(scene=" + this.a + ", permissions=" + this.b + ", multiple=" + this.c + ", enableChatPreview=" + this.d + ", searchHintTextResId=" + this.e + ", disableRightViewHolder=" + this.f + ", chatCountStyle=" + this.g + ", viewDependency=" + this.h + ", onPickNotify=" + this.i + ", onBusinessConsumeItem=" + this.j + ", pickerParamsLoader=null, searchPickerParams=" + this.k + ", includeConfig=" + this.l + ", enableExternalTarget=" + this.m + ", customSearchResultItems=" + this.n + ", dataPuller=" + this.o + ", pickModeChangeListener=" + this.p + ", topCustomView=" + this.q + ", needInsertDoubaoWork=" + this.r + ", searchResultAdapter=" + this.s + ", clearSearchResultAdapter=" + this.t + ')';
    }

    public b(String r20, List r21, Boolean r22, Boolean r23, Boolean r24, BasePicker.IViewDependency r25, BasePicker.IOnPickNotify r26, SearchResultView.IOnBusinessConsumeItem r27, d r28, IncludeConfig r29, boolean r30, y3c.a r31, p r32, View r33, Boolean r34, SearchResultAdapter r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        List r4 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Boolean r5 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        Boolean r6 = null;
    L19:
        if ((r36 & 64) == 0) goto L21;
        Boolean r7 = null;
    L23:
        if ((r36 & 128) == 0) goto L25;
        BasePicker.IViewDependency r8 = null;
    L27:
        if ((r36 & 256) == 0) goto L29;
        BasePicker.IOnPickNotify r9 = null;
    L31:
        if ((r36 & 512) == 0) goto L33;
        SearchResultView.IOnBusinessConsumeItem r10 = null;
    L35:
        if ((r36 & 2048) == 0) goto L37;
        d r11 = null;
    L39:
        if ((r36 & 4096) == 0) goto L41;
        IncludeConfig r12 = null;
    L43:
        if ((r36 & 8192) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((32768 & r36) == 0) goto L49;
        y3c.a r15 = null;
    L51:
        if ((r36 & 65536) == 0) goto L53;
        p r14 = null;
    L55:
        if ((r36 & 131072) == 0) goto L57;
        View r17 = null;
    L59:
        if ((r36 & 262144) == 0) goto L61;
        Boolean r18 = null;
    L63:
        if ((r36 & 524288) == 0) goto L65;
        SearchResultAdapter r1 = null;
    L66:
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = null;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = null;
        this.o = r15;
        this.p = r14;
        this.q = r17;
        this.r = r18;
        this.s = r1;
        this.t = false;
        return;
    L65:
        r1 = r35;
        goto L66
    L61:
        r18 = r34;
        goto L63
    L57:
        r17 = r33;
        goto L59
    L53:
        r14 = r32;
        goto L55
    L49:
        r15 = r31;
        goto L51
    L45:
        r13 = r30;
        goto L47
    L41:
        r12 = r29;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r7 = r24;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r5 = r22;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L7
    }
}
