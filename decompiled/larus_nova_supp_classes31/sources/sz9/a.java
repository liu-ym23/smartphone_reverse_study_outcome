package sz9;

import android.net.Uri;
import com.larus.bmhome.bigimg.l;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.CreationTaskType;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final n1 a;
    public final Uri b;
    public int c;
    public final Uri d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public int m;
    public final Integer n;
    public final boolean o;
    public String p;
    public final l q;
    public final String r;
    public final g s;
    public final c4 t;
    public final JSONObject u;
    public final Message v;
    public final String w;
    public final String x;
    public final boolean y;
    public final Integer z;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r6.o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
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
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L86;
        return false;
    L86:
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
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        Uri r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        int r16 = 1231;
        if (this.i == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r15 + r17) * 31;
        if (this.j == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.k == false) goto L33;
        int r21 = 1231;
    L34:
        int r22 = (r20 + r21) * 31;
        if (this.l == false) goto L37;
        int r23 = 1231;
    L38:
        int r24 = (((r22 + r23) * 31) + this.m) * 31;
        Integer r25 = this.n;
        if (r25 != null) goto L41;
        int r26 = 0;
    L42:
        int r27 = (r24 + r26) * 31;
        if (this.o == false) goto L45;
        int r28 = 1231;
    L46:
        int r29 = (((r27 + r28) * 31) + this.p.hashCode()) * 31;
        l r30 = this.q;
        if (r30 != null) goto L49;
        int r31 = 0;
    L50:
        int r32 = (r29 + r31) * 31;
        String r33 = this.r;
        if (r33 != null) goto L53;
        int r34 = 0;
    L54:
        int r35 = (r32 + r34) * 31;
        g r36 = this.s;
        if (r36 != null) goto L57;
        int r37 = 0;
    L58:
        int r38 = (r35 + r37) * 31;
        c4 r39 = this.t;
        if (r39 != null) goto L61;
        int r40 = 0;
    L62:
        int r41 = (r38 + r40) * 31;
        JSONObject r42 = this.u;
        if (r42 != null) goto L65;
        int r43 = 0;
    L66:
        int r44 = (r41 + r43) * 31;
        Message r45 = this.v;
        if (r45 != null) goto L69;
        int r46 = 0;
    L70:
        int r47 = (r44 + r46) * 31;
        String r48 = this.w;
        if (r48 != null) goto L73;
        int r49 = 0;
    L74:
        int r50 = (r47 + r49) * 31;
        String r51 = this.x;
        if (r51 != null) goto L77;
        int r52 = 0;
    L78:
        int r53 = (r50 + r52) * 31;
        if (this.y == true) goto L82;
        r16 = 1237;
    L82:
        int r54 = (r53 + r16) * 31;
        Integer r55 = this.z;
        if (r55 == null) goto L87;
        r1 = r55.hashCode();
    L87:
        return r54 + r1;
    L77:
        r52 = r51.hashCode();
        goto L78
    L73:
        r49 = r48.hashCode();
        goto L74
    L69:
        r46 = r45.hashCode();
        goto L70
    L65:
        r43 = r42.hashCode();
        goto L66
    L61:
        r40 = r39.hashCode();
        goto L62
    L57:
        r37 = r36.hashCode();
        goto L58
    L53:
        r34 = r33.hashCode();
        goto L54
    L49:
        r31 = r30.hashCode();
        goto L50
    L45:
        r28 = 1237;
        goto L46
    L41:
        r26 = r25.hashCode();
        goto L42
    L37:
        r23 = 1237;
        goto L38
    L33:
        r21 = 1237;
        goto L34
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
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
        return "CreationBottomViewContext(imageUrl=" + this.a + ", downloadUri=" + this.b + ", latestCreationPrivateStatus=" + this.c + ", validUri=" + this.d + ", creationKey=" + this.e + ", creationTaskId=" + this.f + ", creationIndex=" + this.g + ", creationType=" + this.h + ", isBlockContent=" + this.i + ", canPublish=" + this.j + ", isReadonlyForwardDetail=" + this.k + ", disableCollection=" + this.l + ", currentCreationButtonStatus=" + this.m + ", currentCreationTypeFromIM=" + this.n + ", isCaseMode=" + this.o + ", creationId=" + this.p + ", imageInfo=" + this.q + ", imageResourceKey=" + this.r + ", videoPlayData=" + this.s + ", videoEventParams=" + this.t + ", reportParam=" + this.u + ", message=" + this.v + ", canvasId=" + this.w + ", canvasSubId=" + this.x + ", noWatermarkSelected=" + this.y + ", taskType=" + this.z + ')';
    }

    public /* synthetic */ a(n1 r31, Uri r32, Uri r33, String r34, String r35, String r36, Integer r37, boolean r38, boolean r39, boolean r40, boolean r41, int r42, Integer r43, boolean r44, String r45, String r46, g r47, c4 r48, JSONObject r49, Message r50, String r51, String r52, boolean r53, Integer r54, int r55) {
        if ((r55 & 1) == 0) goto L5;
        n1 r4 = null;
    L7:
        if ((r55 & 2) == 0) goto L9;
        Uri r5 = null;
    L11:
        if ((r55 & 4) == 0) goto L13;
        int r6 = 2;
    L15:
        if ((r55 & 8) == 0) goto L17;
        Uri r7 = null;
    L19:
        if ((r55 & 16) == 0) goto L21;
        String r1 = "";
    L23:
        if ((r55 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r55 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r55 & 256) == 0) goto L33;
        boolean r12 = false;
    L35:
        if ((r55 & 512) == 0) goto L37;
        boolean r13 = false;
    L39:
        if ((r55 & 1024) == 0) goto L41;
        boolean r14 = false;
    L43:
        if ((r55 & 2048) == 0) goto L45;
        boolean r15 = false;
    L47:
        if ((r55 & 4096) == 0) goto L49;
        int r16 = 0;
    L51:
        if ((r55 & 8192) == 0) goto L53;
        Integer r17 = null;
    L55:
        if ((r55 & 16384) == 0) goto L57;
        boolean r18 = false;
    L59:
        if ((32768 & r55) == 0) goto L61;
        String r19 = "";
    L63:
        if ((131072 & r55) == 0) goto L65;
        String r21 = null;
    L67:
        if ((262144 & r55) == 0) goto L69;
        g r22 = null;
    L71:
        if ((524288 & r55) == 0) goto L73;
        c4 r23 = null;
    L75:
        if ((1048576 & r55) == 0) goto L77;
        JSONObject r24 = null;
    L79:
        if ((2097152 & r55) == 0) goto L81;
        Message r25 = null;
    L83:
        if ((4194304 & r55) == 0) goto L85;
        String r26 = null;
    L87:
        if ((8388608 & r55) == 0) goto L89;
        String r27 = null;
    L91:
        if ((16777216 & r55) == 0) goto L93;
        boolean r28 = false;
    L95:
        if ((r55 & 33554432) == 0) goto L97;
        Integer r29 = null;
    L98:
        this(r4, r5, r6, r7, r1, r9, r10, r37, r12, r13, r14, r15, r16, r17, r18, r19, null, r21, r22, r23, r24, r25, r26, r27, r28, r29);
        return;
    L97:
        r29 = r54;
        goto L98
    L93:
        r28 = r53;
        goto L95
    L89:
        r27 = r52;
        goto L91
    L85:
        r26 = r51;
        goto L87
    L81:
        r25 = r50;
        goto L83
    L77:
        r24 = r49;
        goto L79
    L73:
        r23 = r48;
        goto L75
    L69:
        r22 = r47;
        goto L71
    L65:
        r21 = r46;
        goto L67
    L61:
        r19 = r45;
        goto L63
    L57:
        r18 = r44;
        goto L59
    L53:
        r17 = r43;
        goto L55
    L49:
        r16 = r42;
        goto L51
    L45:
        r15 = r41;
        goto L47
    L41:
        r14 = r40;
        goto L43
    L37:
        r13 = r39;
        goto L39
    L33:
        r12 = r38;
        goto L35
    L29:
        r10 = r36;
        goto L31
    L25:
        r9 = r35;
        goto L27
    L21:
        r1 = r34;
        goto L23
    L17:
        r7 = r33;
        goto L19
    L13:
        r6 = 0;
        goto L15
    L9:
        r5 = r32;
        goto L11
    L5:
        r4 = r31;
        goto L7
    }

    public a(n1 r6, Uri r7, int r8, Uri r9, String r10, String r11, String r12, Integer r13, boolean r14, boolean r15, boolean r16, boolean r17, int r18, Integer r19, boolean r20, String r21, l r22, String r23, g r24, c4 r25, JSONObject r26, Message r27, String r28, String r29, boolean r30, @CreationTaskType Integer r31) {
        Intrinsics.checkNotNullParameter(r10, "creationKey");
        Intrinsics.checkNotNullParameter(r11, "creationTaskId");
        Intrinsics.checkNotNullParameter(r21, "creationId");
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
        this.z = r31;
    }
}
