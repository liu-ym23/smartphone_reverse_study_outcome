package yn0;

import com.bytedance.android.live.broadcast.api.IAnchorBizPanelService;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.anchorbizpanel.OperateSource;
import com.bytedance.android.live.broadcast.api.anchorbizpanel.OperateType;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements l81.b {
    public static final b a = null;

    public static final class a implements js0.b {
        public final /* synthetic */ OperateType a;
        public final /* synthetic */ OperateSource b;

        @Override // js0.b
        public final void onSuccess(String r3) {
            Intrinsics.checkNotNullParameter(r3, "track");
            IAnchorBizPanelService r4 = ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).fetchAnchorBizPanelService();
            if (r4 == null) goto L6;
            r4.operatePanel(this.a, this.b);
            return;
        }

        public a(OperateType r1, OperateSource r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public b() {
    }

    static {
        a = new b();
    }

    public final void operatePanel(OperateType r3, OperateSource r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a(r3, r4)).callbackOnMainThread().syncCallbackIfReady(true).justPrepare();
    }
}
