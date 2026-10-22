package qp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements com.bytedance.android.livesdk.chatroom.vs_base.player.a, o {
    public final mm1.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b(mm1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.a
    public final IPlayerProgressService a(DataCenter r2) {
        return k.n(rk1.a.class).M4(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.a
    public final void releaseService(DataCenter r3) {
        StringBuilder r0 = new StringBuilder("start do PlayerBrickService release for dataCenter:");
        if (r3 == null) goto L5;
        int r1 = r3.hashCode();
    L6:
        r0.append(r1);
        ALogger.w(VSPlayerServiceImpl.TAG, r0.toString());
        k.n(rk1.a.class).E5(r3);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
