package s8b;

import android.os.Bundle;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements q8b.c {
    public final List<q8b.i> a;
    public final String b;

    public k() {
        this.a = CollectionsKt.listOf(new q8b.i(q8b.d.c, new q8b.a("COND_ACCESS"), 4));
        this.b = "UnknownNoPermissionActionHandler";
    }

    @Override // q8b.c
    public final String c() {
        return this.b;
    }

    @Override // q8b.b
    public final List<q8b.i> getRules() {
        return this.a;
    }

    @Override // q8b.c
    public final void a(InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r3, "internalSecurityAction");
        Bundle r0 = new Bundle();
        r0.putParcelable("param_action", r3);
        int r4 = g8b.b.a;
        g8b.b.a.a().c(NoPermissionType.UNKNOWN, r0);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return q8b.c.a.a(this, r1);
    }
}
