package sz9;

import android.net.Uri;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final n1 a;
    public final Uri b;
    public final Integer c;
    public final l d;
    public final String e;
    public final JSONObject f;
    public final Boolean g;
    public final g h;
    public final String i;
    public final String j;
    public final CoroutineScope k;
    public final Message l;
    public final h m;
    public final c4 n;
    public final com.larus.bmhome.share.panel.d o;
    public final boolean p;
    public final Integer q;

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 131071);
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
        if (this.p == r6.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        n1 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Uri r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        l r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        JSONObject r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        g r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        CoroutineScope r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Message r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        h r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        c4 r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        com.larus.bmhome.share.panel.d r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        if (this.p == false) goto L65;
        int r46 = 1231;
    L66:
        int r47 = (r45 + r46) * 31;
        Integer r48 = this.q;
        if (r48 == null) goto L71;
        r1 = r48.hashCode();
    L71:
        return r47 + r1;
    L65:
        r46 = 1237;
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
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
        return "CreationOperationParams(imageUrl=" + this.a + ", downloadUri=" + this.b + ", creationType=" + this.c + ", imageInfo=" + this.d + ", imageResourceKey=" + this.e + ", reportParam=" + this.f + ", isCaseMode=" + this.g + ", videoPlayData=" + this.h + ", creationKey=" + this.i + ", creationId=" + this.j + ", scope=" + this.k + ", message=" + this.l + ", sharePanelEventParam=" + this.m + ", videoEventParams=" + this.n + ", clickInterceptor=" + this.o + ", noWatermarkSelected=" + this.p + ", taskType=" + this.q + ')';
    }

    public c(n1 r19, Uri r20, Integer r21, l r22, String r23, JSONObject r24, Boolean r25, g r26, String r27, String r28, CoroutineScope r29, Message r30, h r31, c4 r32, com.larus.bmhome.share.panel.d r33, boolean r34, Integer r35, int r36) {
        if ((r36 & 1) == 0) goto L5;
        n1 r2 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        Uri r4 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        l r6 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        JSONObject r8 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        Boolean r9 = Boolean.FALSE;
    L31:
        if ((r36 & 128) == 0) goto L33;
        g r10 = null;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        CoroutineScope r13 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Message r14 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        h r15 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        c4 r3 = null;
    L58:
        c4 r110 = r3;
        if ((r36 & 16384) == 0) goto L61;
        com.larus.bmhome.share.panel.d r16 = null;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        boolean r17 = false;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        Integer r1 = null;
    L70:
        this.a = r2;
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
        this.n = r110;
        this.o = r16;
        this.p = r17;
        this.q = r1;
        return;
    L69:
        r1 = r35;
        goto L70
    L65:
        r17 = r34;
        goto L67
    L61:
        r16 = r33;
        goto L63
    L57:
        r3 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
