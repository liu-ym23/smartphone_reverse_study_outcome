package xcb;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Map<String, UrlPreviewHangPoint> a;
    public final Map<String, UrlPreviewEntity> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "UrlPreviewEntityPbBundle(hangPointMap=" + this.a + ", previewEntityMap=" + this.b + ')';
    }

    public a(Map<String, UrlPreviewHangPoint> r2, Map<String, UrlPreviewEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "hangPointMap");
        Intrinsics.checkNotNullParameter(r3, "previewEntityMap");
        this.a = r2;
        this.b = r3;
    }
}
