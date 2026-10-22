package op9;

import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final long a;
    public final mp9.b b;
    public final Map<MediaTab, List<d>> c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "UIMediaFolder(id=" + this.a + ", mediaFolder=" + this.b + ", uiMediaItemsMap=" + this.c + ')';
    }

    public c(long r2, mp9.b r4, Map<MediaTab, List<d>> r5) {
        Intrinsics.checkNotNullParameter(r4, "mediaFolder");
        Intrinsics.checkNotNullParameter(r5, "uiMediaItemsMap");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
