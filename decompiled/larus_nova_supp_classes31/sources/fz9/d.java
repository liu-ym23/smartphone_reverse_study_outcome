package fz9;

import com.larus.im.bean.message.CreationTaskType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements c {
    public final String a;
    public final int b;
    public final int c;
    public final Message d;
    public final Integer e;
    public final ImageInfo f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Integer k;

    public d() {
        this(null, 0, 0, null, 0, null, false, false, false, false, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        Message r4 = this.d;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageInfo r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.g == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.h == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        if (this.i == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        if (this.j == true) goto L34;
        r13 = 1237;
    L34:
        int r20 = (r19 + r13) * 31;
        Integer r21 = this.k;
        if (r21 == null) goto L39;
        r1 = r21.hashCode();
    L39:
        return r20 + r1;
    L29:
        r18 = 1237;
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = 1237;
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
        return "ImageItemData(taskId=" + this.a + ", width=" + this.b + ", height=" + this.c + ", message=" + this.d + ", index=" + this.e + ", imageInfo=" + this.f + ", canDownload=" + this.g + ", canShare=" + this.h + ", canEditImage=" + this.i + ", canEditVideo=" + this.j + ", taskType=" + this.k + ')';
    }

    @Override // fz9.c
    public final int getHeight() {
        return this.c;
    }

    @Override // fz9.c
    public final Integer getIndex() {
        return this.e;
    }

    @Override // fz9.c
    public final Message getMessage() {
        return this.d;
    }

    @Override // fz9.c
    public final String getTaskId() {
        return this.a;
    }

    @Override // fz9.c
    public final int getWidth() {
        return this.b;
    }

    public d(String r1, int r2, int r3, Message r4, Integer r5, ImageInfo r6, boolean r7, boolean r8, boolean r9, boolean r10, @CreationTaskType Integer r11) {
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
