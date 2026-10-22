package i8b;

import com.ss.android.lark.conditional.access.auth.v2.SecurityPolicyAuthManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class m extends a {
    public abstract com.ss.android.lark.conditional.access.auth.v2.e e(PolicyModel r1, boolean r2);

    public abstract com.ss.android.lark.conditional.access.auth.v2.c f(PolicyModel r1);

    public abstract void g(String r1, String r2, String r3);

    public abstract void h(List<PolicyModel> r1);

    public m(SecurityPolicyAuthManager r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
    }
}
