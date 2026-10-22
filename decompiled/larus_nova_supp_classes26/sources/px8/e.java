package px8;

import com.larus.camera.impl.entity.ResultBottomControlType;
import com.larus.camera.impl.entity.ResultSuggestType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final ResultBottomControlType a;
    public final ResultSuggestType b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        ResultSuggestType r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResultBottomState(controlType=" + this.a + ", suggestType=" + this.b + ')';
    }

    public e(ResultBottomControlType r2, ResultSuggestType r3) {
        Intrinsics.checkNotNullParameter(r2, "controlType");
        this.a = r2;
        this.b = r3;
    }
}
