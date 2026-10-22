package fn8;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final String a;
    public final int b;
    public final RichMediaKind c;
    public final String d;
    public final int e;
    public final int f;
    public final String g;
    public final b h;
    public final boolean i;

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
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "RichMediaItemUiModel(stableKey=" + this.a + ", mediaType=" + this.b + ", mediaKind=" + this.c + ", coverUrl=" + this.d + ", mediaWidth=" + this.e + ", mediaHeight=" + this.f + ", bizTag=" + this.g + ", source=" + this.h + ", holdForNoWatermark=" + this.i + ')';
    }

    public /* synthetic */ c(String r11, int r12, RichMediaKind r13, String r14, int r15, int r16, String r17, b r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, false);
    }

    public c(String r2, int r3, RichMediaKind r4, String r5, int r6, int r7, String r8, b r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "stableKey");
        Intrinsics.checkNotNullParameter(r4, "mediaKind");
        Intrinsics.checkNotNullParameter(r5, "coverUrl");
        Intrinsics.checkNotNullParameter(r8, "bizTag");
        Intrinsics.checkNotNullParameter(r9, MusicAppletPage.KEY_SOURCE);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
