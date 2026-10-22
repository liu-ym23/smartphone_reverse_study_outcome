package xa;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final List<String> b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "FullSceneInfo(sceneId=" + this.a + ", fullUrls=" + this.b + ')';
    }

    public a(String r10, List<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "sceneId");
        Intrinsics.checkNotNullParameter(r11, "fullUrls");
        this.a = r10;
        this.b = r11;
    }
}
