package df8;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.platform.kmp.chat.TemplateInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final int a;
    public final ImageItem b;
    public final TemplateInfo.TemplateInfo c;
    public final Map<String, Object> d;

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        TemplateInfo.TemplateInfo r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Map<String, Object> r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageItemInfo(index=" + this.a + ", imageItem=" + this.b + ", templateInfo=" + this.c + ", commonTraceParams=" + this.d + ')';
    }

    public a(int r2, ImageItem r3, TemplateInfo.TemplateInfo r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "imageItem");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
