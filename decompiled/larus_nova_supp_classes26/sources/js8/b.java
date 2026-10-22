package js8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final AuthMode a;
    public final Map<String, String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
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
        return "UploadCredential(authMode=" + this.a + ", attributes=" + this.b + ')';
    }

    public b(AuthMode r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "authMode");
        Intrinsics.checkNotNullParameter(r3, "attributes");
        this.a = r2;
        this.b = r3;
    }
}
