package s8b;

import android.os.Bundle;
import com.bytedance.lark.pb.security.v1.ChallengeType;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements q8b.c {
    public final List<q8b.i> a;
    public final String b;

    public a() {
        q8b.a r2 = new q8b.a("BLOCKED_BY_DEVICE_OWNERSHIP");
        q8b.a r4 = new q8b.a("COND_ACCESS");
        ChallengeType r7 = ChallengeType.NEED_REGISTERED_DEVICE;
        q8b.a r3 = new q8b.a("BLOCKED_BY_DEVICE_OWNERSHIP");
        q8b.a r5 = new q8b.a("COND_ACCESS");
        ChallengeType r6 = ChallengeType.NEED_MANAGED_DEVICE;
        this.a = CollectionsKt.listOf(new q8b.i[]{new q8b.i(r2, r4, new q8b.a(Integer.valueOf(r7.getValue()))), new q8b.i(r3, r5, new q8b.a(Integer.valueOf(r6.getValue()))), new q8b.i(new q8b.a("BLOCKED_BY_DEVICE_CREDIBILITY"), new q8b.a("COND_ACCESS"), new q8b.a(Integer.valueOf(r7.getValue()))), new q8b.i(new q8b.a("BLOCKED_BY_DEVICE_CREDIBILITY"), new q8b.a("COND_ACCESS"), new q8b.a(Integer.valueOf(r6.getValue())))});
        this.b = "DeviceAuthenticationNoPermissionActionHandler";
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
        g8b.b.a.a().c(NoPermissionType.DEVICE_AUTHENTICATION, r0);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r1) {
        return q8b.c.a.a(this, r1);
    }
}
