package cz9;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements b {
    public final int a;
    public final int b;
    public final int c;
    public final CreationItem d;
    public final Message e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public h() {
        this(0, 0, null, null, 0, 2047);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        CreationItem r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Message r5 = this.e;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((r4 + r2) * 31) + this.f) * 31;
        int r7 = 1231;
        if (this.g == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.h == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.i == false) goto L21;
        int r12 = 1231;
    L22:
        int r13 = (r11 + r12) * 31;
        if (this.j == false) goto L25;
        int r14 = 1231;
    L26:
        int r15 = (r13 + r14) * 31;
        if (this.k == true) goto L31;
        r7 = 1237;
    L31:
        return r15 + r7;
    L25:
        r14 = 1237;
        goto L26
    L21:
        r12 = 1237;
        goto L22
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageItemData(viewType=" + this.a + ", width=" + this.b + ", height=" + this.c + ", creationItem=" + this.d + ", message=" + this.e + ", indexInMsg=" + this.f + ", canDownload=" + this.g + ", canShare=" + this.h + ", canEditImage=" + this.i + ", canEditVideo=" + this.j + ", canCite=" + this.k + ')';
    }

    @Override // cz9.b
    public final CreationItem a() {
        return this.d;
    }

    @Override // cz9.b
    public final int b() {
        return this.f;
    }

    @Override // cz9.b
    public final Message getMessage() {
        return this.e;
    }

    @Override // cz9.b
    public final int getViewType() {
        return this.a;
    }

    @Override // cz9.b
    public final a c(b r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof h) == true) goto L5;
        return null;
    L5:
        CreationItem r0 = this.d;
        if (r0 == null) goto L8;
        String r1 = r0.id;
    L9:
        h r6 = (h) r5;
        CreationItem r2 = r6.d;
        if (r2 == null) goto L12;
        String r3 = r2.id;
    L14:
        if (Intrinsics.areEqual(r1, r3) == false) goto L55;
        CreationItem r4 = this.d;
        if (r4 == null) goto L20;
        ImageData r7 = r4.image;
        if (r7 == null) goto L20;
        Integer r8 = r7.status;
    L21:
        CreationItem r9 = r6.d;
        if (r9 == null) goto L26;
        ImageData r10 = r9.image;
        if (r10 == null) goto L26;
        Integer r11 = r10.status;
    L28:
        if (Intrinsics.areEqual(r8, r11) == false) goto L55;
        CreationItem r12 = this.d;
        if (r12 == null) goto L34;
        ImageData r13 = r12.image;
        if (r13 == null) goto L34;
        String r14 = r13.key;
    L35:
        String r15 = "";
        if (r14 != null) goto L38;
        r14 = "";
    L38:
        CreationItem r16 = r6.d;
        if (r16 == null) goto L43;
        ImageData r17 = r16.image;
        if (r17 == null) goto L43;
        String r18 = r17.key;
    L44:
        if (r18 == null) goto L48;
        r15 = r18;
    L48:
        if (Intrinsics.areEqual(r14, r15) == false) goto L55;
        int r19 = this.b;
        if (r19 != r6.b) goto L54;
        if (this.c == r6.c) goto L55;
    L54:
        return new a(r19, this.c);
    L43:
        r18 = null;
    L34:
        r14 = null;
    L26:
        r11 = null;
    L20:
        r8 = null;
    L55:
        return null;
    L12:
        r3 = null;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    @Override // cz9.b
    public final boolean d(b r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof h) == false) goto L54;
        CreationItem r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.id;
    L8:
        h r6 = (h) r5;
        CreationItem r3 = r6.d;
        if (r3 == null) goto L11;
        String r4 = r3.id;
    L13:
        if (Intrinsics.areEqual(r2, r4) == false) goto L54;
        if (this.b != r6.b) goto L54;
        if (this.c != r6.c) goto L54;
        CreationItem r7 = this.d;
        if (r7 == null) goto L23;
        ImageData r8 = r7.image;
        if (r8 == null) goto L23;
        Integer r9 = r8.status;
    L24:
        CreationItem r10 = r6.d;
        if (r10 == null) goto L29;
        ImageData r11 = r10.image;
        if (r11 == null) goto L29;
        Integer r12 = r11.status;
    L31:
        if (Intrinsics.areEqual(r9, r12) == false) goto L54;
        CreationItem r13 = this.d;
        if (r13 == null) goto L37;
        ImageData r14 = r13.image;
        if (r14 == null) goto L37;
        String r15 = r14.key;
    L38:
        String r16 = "";
        if (r15 != null) goto L41;
        r15 = "";
    L41:
        CreationItem r17 = r6.d;
        if (r17 == null) goto L46;
        ImageData r18 = r17.image;
        if (r18 == null) goto L46;
        r1 = r18.key;
    L46:
        if (r1 == null) goto L50;
        r16 = r1;
    L50:
        if (Intrinsics.areEqual(r15, r16) == false) goto L54;
        if (this.k != r6.k) goto L54;
        return true;
    L37:
        r15 = null;
    L29:
        r12 = null;
    L23:
        r9 = null;
        goto L24
    L11:
        r4 = null;
        goto L13
    L7:
        r2 = null;
    L54:
        return false;
    }

    public /* synthetic */ h(int r15, int r16, CreationItem r17, Message r18, int r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        int r3 = 1;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r20 & 8) == 0) goto L17;
        CreationItem r6 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Message r7 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r8 = 0;
    L26:
        this(r3, r4, r5, r6, r7, r8, false, false, false, false, false);
        return;
    L25:
        r8 = r19;
        goto L26
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r3 = 0;
        goto L7
    }

    public h(int r1, int r2, int r3, CreationItem r4, Message r5, int r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
