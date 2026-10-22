package cy8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public final String a;
    public final String b;
    public final String c;
    public final v d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final x g;
    public final int h;
    public final Long i;

    public w() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h) * 31;
        Long r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CanvasSSEStartParams(sessionId=" + this.a + ", scene=" + this.b + ", path=" + this.c + ", body=" + this.d + ", headers=" + this.e + ", queryParams=" + this.f + ", timeout=" + this.g + ", retryLeft=" + this.h + ", sequenceId=" + this.i + ')';
    }

    public w(String r5, String r6, v r7, x r8, int r9) {
        Map<String, String> r0 = MapsKt.emptyMap();
        Map<String, String> r1 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter("/creativity/canvas/generate", MusicAppletPage.KEY_PATH);
        Intrinsics.checkNotNullParameter(r7, "body");
        Intrinsics.checkNotNullParameter(r0, "headers");
        Intrinsics.checkNotNullParameter(r1, "queryParams");
        Intrinsics.checkNotNullParameter(r8, "timeout");
        this.a = r5;
        this.b = r6;
        this.c = "/creativity/canvas/generate";
        this.d = r7;
        this.e = r0;
        this.f = r1;
        this.g = r8;
        this.h = r9;
        this.i = null;
    }
}
