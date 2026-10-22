package cz9;

import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements b {
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

    public m() {
        this(0, 0, 0, null, null, 0, false, 2047);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        return "LocalImageItemData(viewType=" + this.a + ", width=" + this.b + ", height=" + this.c + ", creationItem=" + this.d + ", message=" + this.e + ", indexInMsg=" + this.f + ", canDownload=" + this.g + ", canShare=" + this.h + ", canEditImage=" + this.i + ", canEditVideo=" + this.j + ", canCite=" + this.k + ')';
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
    public final a c(b r4) {
        Intrinsics.checkNotNullParameter(r4, "other");
        if ((r4 instanceof m) == true) goto L5;
        return null;
    L5:
        CreationItem r0 = this.d;
        if (r0 == null) goto L8;
        String r1 = r0.id;
    L9:
        m r5 = (m) r4;
        CreationItem r2 = r5.d;
        if (r2 == null) goto L12;
        String r3 = r2.id;
    L14:
        if (Intrinsics.areEqual(r1, r3) == false) goto L28;
        CreationItem r6 = this.d;
        if (r6 == null) goto L18;
        LocalImageData r7 = r6.localImage;
    L19:
        CreationItem r8 = r5.d;
        if (r8 == null) goto L22;
        LocalImageData r9 = r8.localImage;
    L24:
        if (bz9.c.f(r7, r9) == false) goto L28;
        if (this.k != r5.k) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L36;
        int r11 = this.b;
        if (r11 != r5.b) goto L35;
        if (this.c != r5.c) goto L35;
        return null;
    L35:
        return new a(r11, this.c);
    L36:
        return null;
    L22:
        r9 = null;
        goto L24
    L18:
        r7 = null;
    L28:
        r10 = false;
        goto L29
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
        if ((r5 instanceof m) == true) goto L5;
        return false;
    L5:
        CreationItem r0 = this.d;
        LocalImageData r2 = null;
        if (r0 == null) goto L8;
        String r1 = r0.id;
    L9:
        m r6 = (m) r5;
        CreationItem r3 = r6.d;
        if (r3 == null) goto L12;
        String r4 = r3.id;
    L14:
        if (Intrinsics.areEqual(r1, r4) == true) goto L16;
        return false;
    L16:
        if (this.b == r6.b) goto L18;
        return false;
    L18:
        if (this.c != r6.c) goto L34;
        CreationItem r7 = this.d;
        if (r7 == null) goto L22;
        LocalImageData r8 = r7.localImage;
    L23:
        CreationItem r9 = r6.d;
        if (r9 == null) goto L27;
        r2 = r9.localImage;
    L27:
        if (bz9.c.f(r8, r2) == true) goto L29;
        return false;
    L29:
        if (this.k != r6.k) goto L36;
        return true;
    L36:
        return false;
    L22:
        r8 = null;
        goto L23
    L34:
        return false;
    L12:
        r4 = null;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public m(int r4, int r5, int r6, CreationItem r7, Message r8, int r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r4 = 1;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r9 = 0;
    L21:
        if ((r11 & 64) == 0) goto L23;
        r10 = false;
    L23:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
    }
}
