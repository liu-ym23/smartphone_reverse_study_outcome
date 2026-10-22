package t8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import idb.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q8b.c;
import q8b.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements c {
    public long a;
    public final List<i> b;
    public final String c;

    /* JADX INFO: renamed from: t8b.a$a, reason: collision with other inner class name */
    public static final class C0301a {
    }

    static {
    }

    public a() {
        this.b = CollectionsKt.listOf(new i(new q8b.a("ACCESS_CONTROL_ACTION_COMMON"), new q8b.a("DEFAULT_PLATFORM_POLICY_SET"), 4));
        this.c = "TnsDialogActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.c;
    }

    @Override // q8b.b
    public final List<i> getRules() {
        return this.b;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r7) {
        Intrinsics.checkNotNullParameter(r7, "internalSecurityAction");
        if (f.a().isEnable("lark.security.enable_risk_intercept_dialog_handler") == true) goto L6;
        ScsLogger.d("SecurityPolicy_TnsDialogActionHandler", "riskInterceptDialogHandlerEnabled is false");
        return;
    L6:
        String r0 = r7.getCurrentAction().getParams().get("containerType");
        if (Intrinsics.areEqual(r0, "dialog") == true) goto L9;
        int r8 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_TnsDialogActionHandler", "handleAction() containerType is not dialog, containerType: " + r0);
        return;
    L9:
        if ((this.a + ((long) 5000)) <= System.currentTimeMillis()) goto L12;
        ScsLogger.d("SecurityPolicy_TnsDialogActionHandler", "handleAction() dialog interval is less than 5s");
        return;
    L12:
        this.a = System.currentTimeMillis();
        String r1 = r7.getCurrentAction().getParams().get("securityCustomizedContent");
        if (r1 != null) goto L16;
        r1 = BuildConfig.FLAVOR;
    L16:
        if (r1.length() != 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L22;
        ScsLogger.e("SecurityPolicy_TnsDialogActionHandler", "handleAction() securityCustomizedContent is empty");
        return;
    L22:
        SecurityPolicyDialogActionManager.a.d(91, r7);
        return;
    L18:
        r2 = false;
        goto L19
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return c.a.a(this, r1);
    }
}
