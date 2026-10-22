package rub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final Integer g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Function0<Unit> k;
    public final Function0<Unit> l;
    public final Function0<Unit> m;
    public final Function0<Unit> n;
    public final Map<String, Object> o;
    public final MmRecordingUILaunchMode p;

    public b() {
        this(null, null, null, null, null, false, null, null, 65535);
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
        if (this.h == r6.h) goto L33;
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
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r6.p) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        int r20 = 1231;
        if (this.h == false) goto L29;
        int r21 = 1231;
    L30:
        int r22 = (r19 + r21) * 31;
        if (this.i == false) goto L33;
        int r23 = 1231;
    L34:
        int r24 = (r22 + r23) * 31;
        if (this.j == true) goto L38;
        r20 = 1237;
    L38:
        int r25 = (r24 + r20) * 31;
        Function0<Unit> r26 = this.k;
        if (r26 != null) goto L41;
        int r27 = 0;
    L42:
        int r28 = (r25 + r27) * 31;
        Function0<Unit> r29 = this.l;
        if (r29 != null) goto L45;
        int r30 = 0;
    L46:
        int r31 = (r28 + r30) * 31;
        Function0<Unit> r32 = this.m;
        if (r32 != null) goto L49;
        int r33 = 0;
    L50:
        int r34 = (r31 + r33) * 31;
        Function0<Unit> r35 = this.n;
        if (r35 != null) goto L53;
        int r36 = 0;
    L54:
        int r37 = (r34 + r36) * 31;
        Map<String, Object> r38 = this.o;
        if (r38 == null) goto L59;
        r2 = r38.hashCode();
    L59:
        return ((r37 + r2) * 31) + this.p.hashCode();
    L53:
        r36 = r35.hashCode();
        goto L54
    L49:
        r33 = r32.hashCode();
        goto L50
    L45:
        r30 = r29.hashCode();
        goto L46
    L41:
        r27 = r26.hashCode();
        goto L42
    L33:
        r23 = 1237;
        goto L34
    L29:
        r21 = 1237;
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmDialogConfig(id=" + this.a + ", title=" + this.b + ", content=" + this.c + ", primaryButtonText=" + this.d + ", secondaryButtonText=" + this.e + ", primaryButtonTextColor=" + this.f + ", secondaryButtonTextColor=" + this.g + ", isCancelable=" + this.h + ", dismissOnBackPress=" + this.i + ", dismissOnClickOutside=" + this.j + ", onPrimaryButtonClick=" + this.k + ", onSecondaryButtonClick=" + this.l + ", onDismiss=" + this.m + ", onShow=" + this.n + ", extraData=" + this.o + ", uiLaunchMode=" + this.p + ')';
    }

    public b(String r5, String r6, String r7, String r8, Integer r9, boolean r10, Function0 r11, MmRecordingUILaunchMode r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r5 = "mm_default_dialog";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r6 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r7 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = null;
    L15:
        if ((r13 & 32) == 0) goto L18;
        r9 = null;
    L18:
        if ((r13 & 128) == 0) goto L20;
        r10 = true;
    L20:
        boolean r2 = false;
        if ((r13 & 256) == 0) goto L23;
        boolean r0 = r10;
    L25:
        if ((r13 & 512) == 0) goto L28;
        r2 = r10;
    L28:
        if ((r13 & 4096) == 0) goto L31;
        r11 = null;
    L31:
        if ((r13 & 32768) == 0) goto L33;
        r12 = MmRecordingUILaunchMode.UNKNOWN;
    L33:
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r12, "uiLaunchMode");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = null;
        this.f = r9;
        this.g = null;
        this.h = r10;
        this.i = r0;
        this.j = r2;
        this.k = null;
        this.l = null;
        this.m = r11;
        this.n = null;
        this.o = null;
        this.p = r12;
        return;
    L23:
        r0 = false;
        goto L25
    }
}
