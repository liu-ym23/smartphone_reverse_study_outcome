package kc0;

import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.RevStreamLayoutBizManager;
import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.live.revlink.impl.multianchor.service.RevLinkPreloadService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface m extends b {
    com.bytedance.android.live.revlink.impl.service.d b();

    k31.e c();

    int currentRoomLayoutType();

    List<com.bytedance.android.livesdk.link.model.bridge.k> d();

    RevLinkPreloadService e();

    StreamLayoutManager m(Function1 r1);

    com.bytedance.android.live.revlink.impl.multianchor.transfer.c r(DataCenter r1);

    RevStreamLayoutBizManager s(DataCenter r1, Function0 r2);
}
