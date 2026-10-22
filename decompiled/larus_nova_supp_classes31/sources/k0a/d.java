package k0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final UserCreation a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(creation=" + this.a + ')';
    }

    public d(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        this.a = r2;
    }
}
