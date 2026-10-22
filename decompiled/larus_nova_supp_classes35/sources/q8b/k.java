package q8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements c {
    public final List<i> a;

    public static final class a {
    }

    static {
    }

    @Override // q8b.c
    public final String c() {
        return "TTBlockActionHandler";
    }

    public k() {
        this.a = CollectionsKt.listOf(new i(new q8b.a("TT_BLOCK"), null, 6));
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, "internalSecurityAction");
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_TTBlockActionHandler", "hit TT control, action:" + r3.getCurrentAction());
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return c.a.a(this, r1);
    }
}
