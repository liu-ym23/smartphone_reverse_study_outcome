package i8b;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public final List<PolicyModel> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CCMFileProtectUpdateData(policyModels=" + this.a + ')';
    }

    public f(List<PolicyModel> r2) {
        Intrinsics.checkNotNullParameter(r2, "policyModels");
        this.a = r2;
    }
}
