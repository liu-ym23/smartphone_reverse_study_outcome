package g3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17027b;

    public c(String r5, List r10) {
        Intrinsics.checkNotNullParameter(r10, "uiOperations");
        this.f17026a = r5;
        this.f17027b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        String r11 = r10.f17026a;
        if (Intrinsics.areEqual(this.f17026a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17027b, r10.f17027b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f17026a;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = this.f17027b.hashCode();
        return r11 + (r10 * 31);
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("UIUOperationsPluginParams(cardId=");
        r5.append(this.f17026a);
        r5.append(", uiOperations=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.f17027b, ')');
    }
}
