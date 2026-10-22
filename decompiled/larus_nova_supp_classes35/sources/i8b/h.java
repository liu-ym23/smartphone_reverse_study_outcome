package i8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public final List<String> a;
    public final FileAuthMonitor.a b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        return "DataResultChangeData(pointKeys=" + this.a + ", updateInfo=" + this.b + ')';
    }

    public h(List<String> r2, FileAuthMonitor.a r3) {
        Intrinsics.checkNotNullParameter(r2, "pointKeys");
        Intrinsics.checkNotNullParameter(r3, "updateInfo");
        this.a = r2;
        this.b = r3;
    }
}
