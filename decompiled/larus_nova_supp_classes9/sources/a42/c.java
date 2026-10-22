package a42;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeValueNode;
import com.bytedance.android.livesdk.interactivity.api.settings.config.t;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.g;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r52.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends g {
    public final float a;
    public final float b;
    public final float c;

    public c() {
        this.a = 1.0f;
        this.b = 0.1f;
        this.c = 0.05f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.g
    public final void a(MonitorEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Long r0 = r9.c(PSRealtimeValueNode.ShowCount.getValueNodeName());
        Long r10 = r9.c(PSRealtimeValueNode.MsgCount.getValueNodeName());
        float r1 = ((t) i2.a.getValue()).c();
        if (r10 == null) goto L29;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r10.longValue() <= 0) goto L30;
        float r2 = r0.longValue() / r10.longValue();
        if (r2 > r1) goto L31;
        float r3 = this.a;
        if (r2 != 0.0f) goto L13;
        r3 = 0.0f;
    L19:
        JSONObject r4 = new JSONObject();
        r4.put("show_rate", String.valueOf(r2));
        IRoomContextService r5 = k.f(IRoomContextService.class);
        if (r5 == null) goto L26;
        o r6 = IRoomContextService.a.a(r5, null, 0, 3);
        if (r6 == null) goto L26;
        m r7 = r6.getRoom();
        if (r7 == null) goto L26;
        IRoom r8 = (IRoom) r7.getValue();
    L27:
        LiveMonitor.a r11 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenRealtimeExposureError, r8, null);
        r11.c(String.valueOf(r3));
        r11.k(r4);
        r11.i("show_count", r0);
        r11.i("total_count", r10);
        r11.a().report();
        return;
    L26:
        r8 = null;
        goto L27
    L13:
        float r13 = this.c;
        if (r2 > r13) goto L16;
    L15:
        r3 = r13;
        goto L19
    L16:
        r13 = this.b;
        if (r2 > r13) goto L19;
    L31:
        return;
    L30:
        return;
    }
}
