package i8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final FileAuthMonitor.a a;
    public final List<PolicyModel> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        return "BatchValidateData(updateInfo=" + this.a + ", validateModels=" + this.b + ')';
    }

    public b(FileAuthMonitor.a r2, List<PolicyModel> r3) {
        Intrinsics.checkNotNullParameter(r2, "updateInfo");
        Intrinsics.checkNotNullParameter(r3, "validateModels");
        this.a = r2;
        this.b = r3;
    }
}
