package li;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f19676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19677c;

    public n(boolean r5, int r10) {
        boolean r11 = false;
        if ((r10 & 1) == 0) goto L5;
        r5 = false;
    L5:
        Map r12 = MapsKt.emptyMap();
        if ((r10 & 4) != 0) goto L9;
        r11 = true;
    L9:
        Intrinsics.checkNotNullParameter(r12, "privateDomains");
        this.f19675a = r5;
        this.f19676b = r12;
        this.f19677c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r10 = (n) r5;
        if (this.f19675a == r10.f19675a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19676b, r10.f19676b) == true) goto L15;
        return false;
    L15:
        if (this.f19677c == r10.f19677c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f19675a) * 31;
        int r10 = (this.f19676b.hashCode() + r5) * 31;
        return Boolean.hashCode(this.f19677c) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WebAuthStrategyConfig(enableJSBAuthV3=");
        r5.append(this.f19675a);
        r5.append(", privateDomains=");
        r5.append(this.f19676b);
        r5.append(", enableAutoMatchUrl=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f19677c, ')');
    }
}
