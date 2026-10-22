package hob;

import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public static final /* synthetic */ int f = 0;
    public final com.ss.android.lark.widget.span.b.b<?> a;
    public final int b;
    public final VideoInfo c;
    public final FrameInfo d;
    public RichTextElement.MediaProperty e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        RichTextElement.MediaProperty r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "InsertMediaInfo(coverLoadInfo=" + this.a + ", duration=" + this.b + ", videoInfo=" + this.c + ", frameInfo=" + this.d + ", mediaProperty=" + this.e + ')';
    }

    public g(com.ss.android.lark.widget.span.b.b<?> r2, int r3, VideoInfo r4, FrameInfo r5, RichTextElement.MediaProperty r6) {
        Intrinsics.checkNotNullParameter(r2, "coverLoadInfo");
        Intrinsics.checkNotNullParameter(r4, "videoInfo");
        Intrinsics.checkNotNullParameter(r5, "frameInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
