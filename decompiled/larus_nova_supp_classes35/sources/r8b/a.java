package r8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q8b.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements q8b.c {
    public final List<i> a;
    public final String b;

    /* JADX INFO: renamed from: r8b.a$a, reason: collision with other inner class name */
    public static final class C0294a {
    }

    static {
    }

    public a() {
        this.a = CollectionsKt.listOf(new i(new q8b.a("ACCESS_CONTROL_ACTION_COMMON"), new q8b.a("FILE_PROTECT"), 4));
        this.b = "CustomFileProtectActionHandler";
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
    public final void a(InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, "internalSecurityAction");
        if (w4c.c.a().A() == false) goto L5;
        SecurityPolicyDialogActionManager.a.d(9, r3);
        return;
    L5:
        ScsLogger.d("SecurityPolicy_CustomFileProtectActionHandler", "enableCustomDialog is false, DIALOG_CUSTOM_DISPLAY -> DIALOG_NORMAL");
        SecurityPolicyDialogActionManager.a.d(1, r3);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return q8b.c.a.a(this, r1);
    }
}
