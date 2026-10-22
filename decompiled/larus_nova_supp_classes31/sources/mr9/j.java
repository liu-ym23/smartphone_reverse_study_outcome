package mr9;

import android.content.Context;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final String a;
    public final String b;
    public final UploadDataType c;
    public final Function1<l, Unit> d;
    public final Function1<k, Unit> e;
    public final Function1<ResourceUploadError, Unit> f;
    public final boolean g;
    public m h;
    public final int i;
    public final Context j;
    public final String k;
    public final String l;
    public final boolean m;
    public final CountDownLatch n;
    public final h o;
    public final String p;
    public final Boolean q;
    public final c r;
    public final String s;
    public final Long t;
    public final Function1<String, Unit> u;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
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
        if (this.m == r6.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
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
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        int r2 = 1231;
        if (this.g == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        m r4 = this.h;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r3 + r6) * 31) + this.i) * 31;
        Context r8 = this.j;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.k;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.l;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        if (this.m == true) goto L26;
        r2 = 1237;
    L26:
        int r17 = (r16 + r2) * 31;
        CountDownLatch r18 = this.n;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (((r17 + r19) * 31) + this.o.hashCode()) * 31;
        String r21 = this.p;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        Boolean r24 = this.q;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        c r27 = this.r;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        String r30 = this.s;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Long r33 = this.t;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Function1<String, Unit> r36 = this.u;
        if (r36 == null) goto L55;
        r5 = r36.hashCode();
    L55:
        return r35 + r5;
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
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
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceUploadParam(path=" + this.a + ", scene=" + this.b + ", dataType=" + this.c + ", successCallback=" + this.d + ", processCallback=" + this.e + ", failedCallback=" + this.f + ", pathIsUri=" + this.g + ", tokenData=" + this.h + ", fileNumber=" + this.i + ", context=" + this.j + ", fileExtension=" + this.k + ", uploaderIdentifier=" + this.l + ", limitUploaderCount=" + this.m + ", latch=" + this.n + ", resourceUploadParam=" + this.o + ", originPath=" + this.p + ", originPathIsUri=" + this.q + ", instantUploadPolicy=" + this.r + ", uploadSourceScene=" + this.s + ", uploadFileSize=" + this.t + ", audioUploadReporter=" + this.u + ')';
    }

    public final Function1<String, Unit> b() {
        return this.u;
    }

    public final c c() {
        return this.r;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.s;
    }

    public final Context getContext() {
        return this.j;
    }

    public static j a(j r25, String r26, com.larus.bmhome.rc.b r27, com.larus.bmhome.rc.c r28, com.larus.bmhome.rc.d r29, String r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        String r4 = r25.a;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r5 = r25.b;
    L11:
        if ((r31 & 4) == 0) goto L13;
        UploadDataType r6 = r25.c;
    L15:
        if ((r31 & 8) == 0) goto L17;
        com.larus.bmhome.rc.b r7 = r25.d;
    L19:
        if ((r31 & 16) == 0) goto L21;
        com.larus.bmhome.rc.c r8 = r25.e;
    L23:
        if ((r31 & 32) == 0) goto L25;
        com.larus.bmhome.rc.d r9 = r25.f;
    L27:
        if ((r31 & 64) == 0) goto L29;
        boolean r2 = r25.g;
    L31:
        if ((r31 & 128) == 0) goto L33;
        m r11 = r25.h;
    L35:
        if ((r31 & 256) == 0) goto L37;
        int r12 = r25.i;
    L39:
        if ((r31 & 512) == 0) goto L41;
        Context r13 = r25.j;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        String r14 = r25.k;
    L47:
        if ((r31 & 2048) == 0) goto L49;
        String r15 = r25.l;
    L51:
        if ((r31 & 4096) == 0) goto L53;
        boolean r16 = r25.m;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        CountDownLatch r17 = r25.n;
    L59:
        if ((r31 & 16384) == 0) goto L61;
        h r10 = r25.o;
    L63:
        if ((32768 & r31) == 0) goto L65;
        String r19 = r25.p;
    L67:
        if ((65536 & r31) == 0) goto L69;
        Boolean r20 = r25.q;
    L71:
        if ((131072 & r31) == 0) goto L73;
        c r21 = r25.r;
    L75:
        if ((262144 & r31) == 0) goto L77;
        String r22 = r25.s;
    L79:
        if ((524288 & r31) == 0) goto L81;
        Long r23 = r25.t;
    L83:
        if ((r31 & 1048576) == 0) goto L85;
        Function1<String, Unit> r24 = r25.u;
    L86:
        r25.getClass();
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r6, "dataType");
        Intrinsics.checkNotNullParameter(r7, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "processCallback");
        Intrinsics.checkNotNullParameter(r9, "failedCallback");
        Intrinsics.checkNotNullParameter(r10, "resourceUploadParam");
        h r1 = r10;
        return new j(r4, r5, r6, r7, r8, r9, r2, r11, r12, r13, r14, r15, r16, r17, r1, r19, r20, r21, r22, r23, r24);
    L85:
        r24 = null;
        goto L86
    L81:
        r23 = null;
        goto L83
    L77:
        r22 = null;
        goto L79
    L73:
        r21 = null;
        goto L75
    L69:
        r20 = null;
        goto L71
    L65:
        r19 = null;
        goto L67
    L61:
        r10 = null;
        goto L63
    L57:
        r17 = null;
        goto L59
    L53:
        r16 = false;
        goto L55
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = 0;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r2 = false;
        goto L31
    L25:
        r9 = r29;
        goto L27
    L21:
        r8 = r28;
        goto L23
    L17:
        r7 = r27;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }

    public /* synthetic */ j(String r26, String r27, UploadDataType r28, Function1 r29, Function1 r30, Function1 r31, boolean r32, m r33, Context r34, String r35, String r36, boolean r37, CountDownLatch r38, h r39, String r40, Boolean r41, c r42, String r43, Long r44, com.larus.bmhome.chat.component.bottom.multimodal.upload.i r45, int r46) {
        if ((r46 & 64) == 0) goto L5;
        boolean r10 = false;
    L7:
        if ((r46 & 128) == 0) goto L9;
        m r11 = null;
    L11:
        if ((r46 & 256) == 0) goto L13;
        int r12 = 1;
    L15:
        if ((r46 & 512) == 0) goto L17;
        Context r13 = null;
    L19:
        if ((r46 & 1024) == 0) goto L21;
        String r14 = null;
    L23:
        if ((r46 & 2048) == 0) goto L25;
        String r15 = null;
    L27:
        if ((r46 & 4096) == 0) goto L29;
        boolean r16 = false;
    L31:
        if ((r46 & 8192) == 0) goto L33;
        CountDownLatch r17 = null;
    L35:
        if ((r46 & 16384) == 0) goto L37;
        h r18 = new h(false, null, null, 31);
    L39:
        if ((32768 & r46) == 0) goto L41;
        String r19 = null;
    L43:
        if ((65536 & r46) == 0) goto L45;
        Boolean r20 = null;
    L47:
        if ((131072 & r46) == 0) goto L49;
        c r21 = null;
    L51:
        if ((262144 & r46) == 0) goto L53;
        String r22 = null;
    L55:
        if ((524288 & r46) == 0) goto L57;
        Long r23 = null;
    L59:
        if ((r46 & 1048576) == 0) goto L61;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.i r24 = null;
    L62:
        this(r26, r27, r28, r29, r30, r31, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L61:
        r24 = r45;
        goto L62
    L57:
        r23 = r44;
        goto L59
    L53:
        r22 = r43;
        goto L55
    L49:
        r21 = r42;
        goto L51
    L45:
        r20 = r41;
        goto L47
    L41:
        r19 = r40;
        goto L43
    L37:
        r18 = r39;
        goto L39
    L33:
        r17 = r38;
        goto L35
    L29:
        r16 = r37;
        goto L31
    L25:
        r15 = r36;
        goto L27
    L21:
        r14 = r35;
        goto L23
    L17:
        r13 = r34;
        goto L19
    L13:
        r12 = 0;
        goto L15
    L9:
        r11 = r33;
        goto L11
    L5:
        r10 = r32;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(String r10, String r11, UploadDataType r12, Function1<? super l, Unit> r13, Function1<? super k, Unit> r14, Function1<? super ResourceUploadError, Unit> r15, boolean r16, m r17, int r18, Context r19, String r20, String r21, boolean r22, CountDownLatch r23, h r24, String r25, Boolean r26, c r27, String r28, Long r29, Function1<? super String, Unit> r30) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "dataType");
        Intrinsics.checkNotNullParameter(r13, "successCallback");
        Intrinsics.checkNotNullParameter(r14, "processCallback");
        Intrinsics.checkNotNullParameter(r15, "failedCallback");
        Intrinsics.checkNotNullParameter(r24, "resourceUploadParam");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
        this.q = r26;
        this.r = r27;
        this.s = r28;
        this.t = r29;
        this.u = r30;
    }
}
