package op9;

import com.larus.photopicker.v2.impl.model.MediaViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final mp9.c a;
    public final boolean b;
    public final int c;
    public final MediaViewType d;
    public final boolean e;

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
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UIMediaItem(mediaItem=" + this.a + ", isSelected=" + this.b + ", selectionOrder=" + this.c + ", mediaViewType=" + this.d + ", selectableByType=" + this.e + ')';
    }

    public /* synthetic */ d(mp9.c r9, boolean r10, int r11, MediaViewType r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        r12 = MediaViewType.ITEM;
    L13:
        MediaViewType r6 = r12;
        if ((r13 & 16) == 0) goto L16;
        boolean r7 = true;
    L17:
        this(r9, r4, r5, r6, r7);
        return;
    L16:
        r7 = false;
        goto L17
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public d(mp9.c r2, boolean r3, int r4, MediaViewType r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        Intrinsics.checkNotNullParameter(r5, "mediaViewType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static d a(d r6, mp9.c r7, boolean r8, int r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        mp9.c r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        boolean r2 = r8;
        if ((r11 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        int r3 = r9;
        if ((r11 & 8) == 0) goto L14;
        MediaViewType r12 = r6.d;
    L15:
        MediaViewType r4 = r12;
        if ((r11 & 16) == 0) goto L18;
        r10 = r6.e;
    L18:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "mediaItem");
        Intrinsics.checkNotNullParameter(r4, "mediaViewType");
        return new d(r1, r2, r3, r4, r10);
    L14:
        r12 = null;
        goto L15
    }
}
