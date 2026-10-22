package sob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.AsrAdoptionRate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final List<b> a;
    public final AsrAdoptionRate b;

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
        return "AsrNerStatistic(userInfoList=" + this.a + ", adoptionRate=" + this.b + ')';
    }

    public a(List<b> r2, AsrAdoptionRate r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoList");
        Intrinsics.checkNotNullParameter(r3, "adoptionRate");
        this.a = r2;
        this.b = r3;
    }
}
