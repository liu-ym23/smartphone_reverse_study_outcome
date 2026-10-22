package a42;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatConstantNode;
import com.bytedance.android.livesdk.interactivity.api.settings.config.t;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.g;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r52.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends g {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public d() {
        this.a = 8000;
        this.b = 5000;
        this.c = 4000;
        this.d = 3000;
        this.e = I18nInitTask.DELAY_TS_MS;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.g
    public final void a(MonitorEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        String r0 = PSRoomStatConstantNode.FirstMessageShowDelay.getNodeName();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        com.bytedance.android.livesdk.interactivity.service.monitor.b r9 = r8.b().get(r0);
        if (r9 == null) goto L5;
        String r10 = r9.b;
    L6:
        if (r10 == null) goto L37;
        Long r11 = StringsKt.toLongOrNull(r10);
        if (r11 == null) goto L38;
        long r1 = r11.longValue();
        if (r1 < ((t) i2.a.getValue()).a()) goto L39;
        int r13 = this.a;
        if (r1 >= r13) goto L27;
        r13 = this.b;
        if (r1 >= r13) goto L27;
        r13 = this.c;
        if (r1 >= r13) goto L27;
        r13 = this.d;
        if (r1 >= r13) goto L27;
        r13 = this.e;
        if (r1 >= r13) goto L27;
        r13 = 0;
    L27:
        IRoomContextService r3 = k.f(IRoomContextService.class);
        if (r3 == null) goto L34;
        o r4 = IRoomContextService.a.a(r3, null, 0, 3);
        if (r4 == null) goto L34;
        m r5 = r4.getRoom();
        if (r5 == null) goto L34;
        IRoom r6 = (IRoom) r5.getValue();
    L35:
        LiveMonitor.a r2 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenFirstShowError, r6, null);
        r2.c(String.valueOf(r13));
        r2.j(r1);
        r2.a().report();
        return;
    L34:
        r6 = null;
        goto L35
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
