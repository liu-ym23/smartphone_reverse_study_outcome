package yn0;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements l81.t {
    public static final t a = null;

    public t() {
    }

    static {
        a = new t();
    }

    public final void a(DataCenter r2, List<? extends ToolbarButton> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        IRoomService r0 = jc1.k.f(IRoomService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.live.room.u r1 = r0.getToolbarConfig();
        if (r1 == null) goto L9;
        r1.a(r2, r3);
        return;
    L9:
        return;
    }
}
