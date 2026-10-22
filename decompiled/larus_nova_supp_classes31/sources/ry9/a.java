package ry9;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final ArrayList<ResourceItemBean> a;
    public final ArrayList<String> b;
    public final int c;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "AlbumResourceConfig(resourceList=" + this.a + ", albumPathList=" + this.b + ", replaceIndex=" + this.c + ')';
    }

    public a(ArrayList<ResourceItemBean> r2, ArrayList<String> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "resourceList");
        Intrinsics.checkNotNullParameter(r3, "albumPathList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
