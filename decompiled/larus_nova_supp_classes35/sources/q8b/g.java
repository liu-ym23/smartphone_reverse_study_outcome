package q8b;

import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.d0;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements c {
    public final List<i> a;
    public final String b;

    public g() {
        this.a = CollectionsKt.listOf(new i(new a("UNIVERSAL_FALLBACK_COMMON"), null, 6));
        this.b = "FallbackActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.b;
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r4) {
        Intrinsics.checkNotNullParameter(r4, "internalSecurityAction");
        int r0 = d0.a;
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        String r5 = com.larksuite.framework.utils.b.a.getString(2131892675);     // Catch: Exception -> L5
        UDToast.show(com.larksuite.framework.utils.b.a, r5, 2131243840);
        ScsLogger.d("SecurityPolicy_SecurityPolicyFallbackActionManager", "handleFallbackAction()，show Toast");
        return;
    L5:
        e = move-exception;
        int r1 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_SecurityPolicyFallbackActionManager", ExceptionsKt.stackTraceToString(e));
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return c.a.a(this, r1);
    }
}
