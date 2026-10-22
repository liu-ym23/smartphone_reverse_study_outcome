package i8b;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v {
    public final List<PolicyModel> a;
    public final Map<String, b0> b;
    public final FileAuthMonitor.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ValidateUpdateData(policyModelList=" + this.a + ", resultMap=" + this.b + ", updateInfo=" + this.c + ')';
    }

    public v(List<PolicyModel> r2, Map<String, b0> r3, FileAuthMonitor.a r4) {
        Intrinsics.checkNotNullParameter(r2, "policyModelList");
        Intrinsics.checkNotNullParameter(r3, "resultMap");
        Intrinsics.checkNotNullParameter(r4, "updateInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
