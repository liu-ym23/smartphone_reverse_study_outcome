package ty8;

import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Message;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Message a;
    public final m1 b;
    public final g c;
    public final String d;
    public final GalleryType e;
    public final JSONObject f;
    public final c4 g;
    public final String h;
    public final String i;
    public final ConcurrentHashMap<String, String> j;

    public b() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        if (this.e == r6.e) goto L24;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        m1 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        g r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.e.hashCode()) * 31;
        JSONObject r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        c4 r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.i;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return ((r21 + r1) * 31) + this.j.hashCode();
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
        return "ChatGalleryData(message=" + this.a + ", imageData=" + this.b + ", videoData=" + this.c + ", botId=" + this.d + ", resourceType=" + this.e + ", reportParams=" + this.f + ", videoParams=" + this.g + ", key=" + this.h + ", desc=" + this.i + ", ext=" + this.j + ')';
    }

    public b(Message r3, m1 r4, g r5, GalleryType r6, JSONObject r7, c4 r8, String r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 32) == 0) goto L15;
        r7 = null;
    L15:
        if ((r11 & 64) == 0) goto L18;
        r8 = null;
    L18:
        if ((r11 & 128) == 0) goto L21;
        r9 = null;
    L21:
        if ((r11 & 256) == 0) goto L24;
        r10 = null;
    L24:
        if ((r11 & 512) == 0) goto L26;
        ConcurrentHashMap<String, String> r12 = new ConcurrentHashMap();
    L27:
        Intrinsics.checkNotNullParameter(r6, "resourceType");
        Intrinsics.checkNotNullParameter(r12, "ext");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = null;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        return;
    L26:
        r12 = null;
        goto L27
    }
}
