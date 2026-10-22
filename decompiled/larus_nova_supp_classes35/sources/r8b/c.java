package r8b;

import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogActionManager;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q8b.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements q8b.c {
    public final List<i> a;
    public final String b;

    public c() {
        this.a = CollectionsKt.listOf(new i(q8b.d.c, new q8b.a("FILE_PROTECT"), 4));
        this.b = "FilePolicyUnknownActionHandler";
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
        SecurityPolicyDialogActionManager.a.d(0, r3);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return q8b.c.a.a(this, r1);
    }
}
