package qp1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl;
import com.bytedance.android.livesdk.chatroom.vs.player.tips.impl.VSPlayerTipServiceImpl;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements gr1.a, o {
    public final Map<Integer, com.bytedance.android.livesdk.chatroom.vsplayer.api.b> a;
    public final Map<Integer, com.bytedance.android.livesdk.chatroom.vsplayer.api.c> b;
    public final mm1.a c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public c(mm1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.c = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    @Override // gr1.a
    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.b provideVSPlayerTipService(DataCenter r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r0 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.b) ((LinkedHashMap) this.a).get(Integer.valueOf(r4.hashCode()));
        if (r0 != null) goto L9;
        VSPlayerTipServiceImpl r1 = new VSPlayerTipServiceImpl();
        this.a.put(Integer.valueOf(r4.hashCode()), r1);
        ALogger.w(VSPlayerServiceImpl.TAG, "create IVSPlayerTipService for dataCenter:" + r4.hashCode() + ",now size:" + this.a.size());
        return r1;
    L9:
        return r0;
    }

    @Override // gr1.a
    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.c provideVSPlayerViewControlService(DataCenter r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r0 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.c) ((LinkedHashMap) this.b).get(Integer.valueOf(r4.hashCode()));
        if (r0 != null) goto L9;
        wp1.a r1 = new wp1.a();
        this.b.put(Integer.valueOf(r4.hashCode()), r1);
        ALogger.w(VSPlayerServiceImpl.TAG, "create IVSPlayerViewControlService for dataCenter:" + r4.hashCode() + ",now size:" + this.b.size());
        return r1;
    L9:
        return r0;
    }

    @Override // gr1.a
    public final void releaseService(DataCenter r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ALogger.w(VSPlayerServiceImpl.TAG, "start do PlayerControlBrickService release for dataCenter:" + r3.hashCode());
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r0 = (com.bytedance.android.livesdk.chatroom.vsplayer.api.c) ((LinkedHashMap) this.b).get(Integer.valueOf(r3.hashCode()));
        if (r0 == null) goto L7;
        r0.releaseService();
    L7:
        int r4 = r3.hashCode();
        this.a.remove(Integer.valueOf(r4));
        this.b.remove(Integer.valueOf(r4));
    }
}
