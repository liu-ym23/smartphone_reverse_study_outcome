package s8b;

import android.os.Bundle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements q8b.c {
    public final List<q8b.i> a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public j() {
        this.a = CollectionsKt.listOf(new q8b.i[]{new q8b.i(new q8b.a("BLOCKED_BY_DEVICE_OWNERSHIP"), new q8b.a("COND_ACCESS"), new q8b.a(16)), new q8b.i(new q8b.a("BLOCKED_BY_DEVICE_CREDIBILITY"), new q8b.a("COND_ACCESS"), new q8b.a(16))});
        this.b = "OfficeSDKOAuthReauthorizationActionHandler";
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
        g8b.b.a.a().c(NoPermissionType.OAUTH_REAUTHORIZATION, r0);
    }

    @Override // q8b.b
    public final boolean b(DecisionData.Action r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
    L9:
        return false;
    L5:
        if (w4c.c.a().v0() == true) goto L9;
        if (q8b.c.a.a(this, r2) == false) goto L9;
        return true;
    }
}
