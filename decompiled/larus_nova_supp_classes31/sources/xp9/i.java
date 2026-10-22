package xp9;

import android.net.Uri;
import com.larus.platform.model.album.AlbumSelectItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final List<Uri> a;
    public final boolean b;
    public final List<AlbumSelectItem> c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public i() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        List<AlbumSelectItem> r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.g == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.h == true) goto L31;
        r2 = 1237;
    L31:
        return r14 + r2;
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumMultiSelectItem(uriList=" + this.a + ", isMultiChooseMode=" + this.b + ", itemList=" + this.c + ", resultReasonSend=" + this.d + ", isSelected=" + this.e + ", skipAttachUpload=" + this.f + ", forceClearAll=" + this.g + ", isOriginalImageChecked=" + this.h + ')';
    }

    public i(List r3, boolean r4, List r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, int r11) {
        if ((r11 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r11 & 16) == 0) goto L12;
        r7 = false;
    L12:
        if ((r11 & 32) == 0) goto L15;
        r8 = false;
    L15:
        if ((r11 & 64) == 0) goto L18;
        r9 = false;
    L18:
        if ((r11 & 128) == 0) goto L20;
        r10 = false;
    L20:
        Intrinsics.checkNotNullParameter(r3, "uriList");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
