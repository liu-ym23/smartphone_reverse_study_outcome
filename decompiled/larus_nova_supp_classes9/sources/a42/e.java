package a42;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
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
public final class e extends g {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public e() {
        this.a = 1.0f;
        this.b = 0.3f;
        this.c = 0.2f;
        this.d = 0.1f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.g
    public final void a(MonitorEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        Long r0 = r9.c(PSRoomStatValueNode.TotalMsgCount.getValueNodeName());
        Long r10 = r9.c(PSRoomStatValueNode.TotalShowCount.getValueNodeName());
        if (r0 == null) goto L32;
        if (r10 == null) goto L35;
        float r1 = ((t) i2.a.getValue()).b();
        if (r0.longValue() <= 0) goto L33;
        float r2 = r10.longValue() / r0.longValue();
        if (r2 > r1) goto L34;
        float r3 = this.a;
        if (r2 != 0.0f) goto L13;
        r3 = 0.0f;
    L22:
        JSONObject r4 = new JSONObject();
        r4.put("show_rate", String.valueOf(r2));
        IRoomContextService r5 = k.f(IRoomContextService.class);
        if (r5 == null) goto L29;
        o r6 = IRoomContextService.a.a(r5, null, 0, 3);
        if (r6 == null) goto L29;
        m r7 = r6.getRoom();
        if (r7 == null) goto L29;
        IRoom r8 = (IRoom) r7.getValue();
    L30:
        LiveMonitor.a r11 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenRoomExposureError, r8, null);
        r11.c(String.valueOf(r3));
        r11.k(r4);
        r11.i("show_message", r10);
        r11.i("total_message", r0);
        r11.a().report();
        return;
    L29:
        r8 = null;
        goto L30
    L13:
        float r13 = this.d;
        if (r2 > r13) goto L16;
    L15:
        r3 = r13;
        goto L22
    L16:
        r13 = this.c;
        if (r2 <= r13) goto L15;
        r13 = this.b;
        if (r2 > r13) goto L22;
    L34:
        return;
    L33:
        return;
    L35:
        return;
    }
}
