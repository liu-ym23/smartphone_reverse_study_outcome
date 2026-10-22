package xy8;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final SourceType a;
    public final String b;
    public final b c;
    public final g d;
    public final GalleryType e;
    public final Map<String, Object> f;
    public final String g;
    public final long h;
    public final String i;
    public final Map<String, String> j;
    public final Map<String, String> k;
    public final f l;
    public final e m;
    public final UserCreation n;
    public final Message o;
    public final c p;
    public final int q;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        b r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        g r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        long r8 = this.h;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        String r10 = this.i;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (((r9 + r11) * 31) + this.j.hashCode()) * 31;
        Map<String, String> r13 = this.k;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (r12 + r14) * 31;
        f r16 = this.l;
        if (r16 != null) goto L21;
        int r17 = 0;
    L22:
        int r18 = (r15 + r17) * 31;
        e r19 = this.m;
        if (r19 != null) goto L25;
        int r20 = 0;
    L26:
        int r21 = (r18 + r20) * 31;
        UserCreation r22 = this.n;
        if (r22 != null) goto L29;
        int r23 = 0;
    L30:
        int r24 = (r21 + r23) * 31;
        Message r25 = this.o;
        if (r25 != null) goto L33;
        int r26 = 0;
    L34:
        int r27 = (r24 + r26) * 31;
        c r28 = this.p;
        if (r28 == null) goto L39;
        r2 = r28.hashCode();
    L39:
        return ((r27 + r2) * 31) + this.q;
    L33:
        r26 = r25.hashCode();
        goto L34
    L29:
        r23 = r22.hashCode();
        goto L30
    L25:
        r20 = r19.hashCode();
        goto L26
    L21:
        r17 = r16.hashCode();
        goto L22
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewGalleryData(sourceType=" + this.a + ", itemKey=" + this.b + ", imageContent=" + this.c + ", videoContent=" + this.d + ", resourceType=" + this.e + ", traceParams=" + this.f + ", desc=" + this.g + ", createTime=" + this.h + ", originAttachmentStableId=" + this.i + ", ext=" + this.j + ", metaDataExif=" + this.k + ", sendMetadata=" + this.l + ", publishMetadata=" + this.m + ", userCreation=" + this.n + ", message=" + this.o + ", localMediaResource=" + this.p + ", groupPosition=" + this.q + ')';
    }

    public static d a(d r23, b r24, g r25, GalleryType r26, Map r27, String r28, Map r29, e r30, UserCreation r31, c r32, int r33, int r34) {
        Message r3 = null;
        if ((r34 & 1) == 0) goto L5;
        SourceType r5 = r23.a;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r6 = r23.b;
    L11:
        if ((r34 & 4) == 0) goto L13;
        b r7 = r23.c;
    L15:
        if ((r34 & 8) == 0) goto L17;
        g r8 = r23.d;
    L19:
        if ((r34 & 16) == 0) goto L21;
        GalleryType r9 = r23.e;
    L23:
        if ((r34 & 32) == 0) goto L25;
        Map r10 = r23.f;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r11 = r23.g;
    L31:
        if ((r34 & 128) == 0) goto L33;
        long r12 = r23.h;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r14 = r23.i;
    L39:
        if ((r34 & 512) == 0) goto L41;
        Map r15 = r23.j;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        Map<String, String> r16 = r23.k;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        f r17 = r23.l;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        e r18 = r23.m;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        UserCreation r19 = r23.n;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        r3 = r23.o;
    L61:
        Message r20 = r3;
        if ((32768 & r34) == 0) goto L64;
        c r21 = r23.p;
    L66:
        if ((r34 & 65536) == 0) goto L68;
        int r22 = r23.q;
    L69:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r5, "sourceType");
        Intrinsics.checkNotNullParameter(r6, "itemKey");
        Intrinsics.checkNotNullParameter(r9, "resourceType");
        Intrinsics.checkNotNullParameter(r10, "traceParams");
        Intrinsics.checkNotNullParameter(r11, "desc");
        Intrinsics.checkNotNullParameter(r15, "ext");
        return new d(r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L68:
        r22 = r33;
        goto L69
    L64:
        r21 = r32;
        goto L66
    L57:
        r19 = r31;
        goto L59
    L53:
        r18 = r30;
        goto L55
    L49:
        r17 = null;
        goto L51
    L45:
        r16 = null;
        goto L47
    L41:
        r15 = r29;
        goto L43
    L37:
        r14 = null;
        goto L39
    L33:
        r12 = 0;
        goto L35
    L29:
        r11 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r7 = r24;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public d(SourceType r9, String r10, b r11, g r12, GalleryType r13, Map<String, ? extends Object> r14, String r15, long r16, String r18, Map<String, String> r19, Map<String, String> r20, f r21, e r22, UserCreation r23, Message r24, c r25, int r26) {
        Intrinsics.checkNotNullParameter(r9, "sourceType");
        Intrinsics.checkNotNullParameter(r10, "itemKey");
        Intrinsics.checkNotNullParameter(r13, "resourceType");
        Intrinsics.checkNotNullParameter(r14, "traceParams");
        Intrinsics.checkNotNullParameter(r15, "desc");
        Intrinsics.checkNotNullParameter(r19, "ext");
        this.a = r9;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
        this.q = r26;
    }

    public /* synthetic */ d(SourceType r23, String r24, b r25, g r26, GalleryType r27, Map r28, String r29, long r30, String r32, Map r33, Map r34, f r35, e r36, UserCreation r37, Message r38, c r39, int r40, int r41) {
        if ((r41 & 4) == 0) goto L5;
        b r6 = null;
    L7:
        if ((r41 & 8) == 0) goto L9;
        g r7 = null;
    L11:
        if ((r41 & 32) == 0) goto L13;
        Map r9 = MapsKt.emptyMap();
    L15:
        if ((r41 & 64) == 0) goto L17;
        String r10 = "";
    L19:
        if ((r41 & 128) == 0) goto L21;
        long r11 = 0;
    L23:
        if ((r41 & 256) == 0) goto L25;
        String r13 = null;
    L27:
        if ((r41 & 512) == 0) goto L29;
        Map r14 = MapsKt.emptyMap();
    L31:
        if ((r41 & 1024) == 0) goto L33;
        Map r15 = null;
    L35:
        if ((r41 & 2048) == 0) goto L37;
        f r16 = null;
    L39:
        if ((r41 & 4096) == 0) goto L41;
        e r17 = null;
    L43:
        if ((r41 & 8192) == 0) goto L45;
        UserCreation r18 = null;
    L47:
        if ((r41 & 16384) == 0) goto L49;
        Message r19 = null;
    L51:
        if ((32768 & r41) == 0) goto L53;
        c r20 = null;
    L55:
        if ((r41 & 65536) == 0) goto L57;
        int r21 = 1;
    L58:
        this(r23, r24, r6, r7, r27, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        return;
    L57:
        r21 = r40;
        goto L58
    L53:
        r20 = r39;
        goto L55
    L49:
        r19 = r38;
        goto L51
    L45:
        r18 = r37;
        goto L47
    L41:
        r17 = r36;
        goto L43
    L37:
        r16 = r35;
        goto L39
    L33:
        r15 = r34;
        goto L35
    L29:
        r14 = r33;
        goto L31
    L25:
        r13 = r32;
        goto L27
    L21:
        r11 = r30;
        goto L23
    L17:
        r10 = r29;
        goto L19
    L13:
        r9 = r28;
        goto L15
    L9:
        r7 = r26;
        goto L11
    L5:
        r6 = r25;
        goto L7
    }
}
