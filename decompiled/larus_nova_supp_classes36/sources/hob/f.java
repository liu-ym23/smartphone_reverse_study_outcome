package hob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final /* synthetic */ int f = 0;
    public final com.ss.android.lark.widget.span.b.b<?> a;
    public final String b;
    public final boolean c;
    public RichTextElement.ImageProperty d;
    public int e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        RichTextElement.ImageProperty r3 = this.d;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return r2 + r4;
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "InsertImageInfo(imageInfo=" + this.a + ", imageToken=" + this.b + ", keepOrigin=" + this.c + ", imageProperty=" + this.d + ')';
    }

    public f(com.ss.android.lark.widget.span.b.b<?> r2, String r3, boolean r4, RichTextElement.ImageProperty r5) {
        Intrinsics.checkNotNullParameter(r2, "imageInfo");
        Intrinsics.checkNotNullParameter(r3, "imageToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = -1;
    }
}
