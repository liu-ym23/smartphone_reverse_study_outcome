package ah;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final JSONObject a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((a) r10).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ChangeTempWidthEvent(params=" + this.a + ")";
    }

    public a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        this.a = r10;
    }
}
