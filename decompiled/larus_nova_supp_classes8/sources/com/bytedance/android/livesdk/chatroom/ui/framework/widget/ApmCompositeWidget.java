package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ApmCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ApmCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observeForever("cmd_send_priority_widget_load_track", this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.observeForever("cmd_widget_loaded", this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = null;
    }

    public ApmCompositeWidget() {
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L56;
        Room r1 = null;
        if (r10 == null) goto L10;
        String r2 = r10.getKey();
    L11:
        if (r2 == null) goto L57;
        int r3 = r2.hashCode();
        if (r3 == (-1836833765)) goto L26;
        if (r3 == 2125823940) goto L19;
        return;
    L19:
        if (r2.equals("cmd_send_priority_widget_load_track") == false) goto L50;
        Integer r11 = (Integer) r10.getData(null);
        if (r11 == null) goto L51;
        int r12 = r11.intValue();
        if (com.bytedance.android.live.core.tetris.widgets.d.d() == false) goto L52;
        wq(r12, SystemClock.elapsedRealtime() - ((Number) ((Widget) this).dataCenter.get("widget_load_start_time", 0L)).longValue(), "livesdk_framework_loading_duration");
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L26:
        if (r2.equals("cmd_widget_loaded") == true) goto L28;
        return;
    L28:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r10) == false) goto L55;
        int r13 = k60.b.g();
        if (r13 != 1) goto L32;
    L37:
        k60.b.i();
    L38:
        IPerformanceManager r14 = jc1.k.f(IPerformanceManager.class);
        if (r14 == null) goto L47;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L43;
        r1 = com.bytedance.android.live.core.utils.z.o(r4);
    L43:
        if (r1 == null) goto L45;
        long r5 = r1.id;
    L46:
        r14.forceStopLoadStallMonitor(r5, false);
        r14.onModuleStop("live_enter_room");
        goto L47
    L45:
        r5 = 0;
    L47:
        wq(-1, SystemClock.elapsedRealtime() - ((Number) ((Widget) this).dataCenter.get("widget_load_start_time", 0L)).longValue(), "livesdk_all_components_loading_duration");
        TimeCostUtil.Tag r15 = TimeCostUtil.Tag.ShowBInteractionFirstWidget;
        int r6 = TimeCostUtil.a;
        com.bytedance.android.live.core.performance.a r7 = com.bytedance.android.live.core.performance.a.a;
        r15.name();
        r7.getClass();
        TimeCostUtil.Tag.ShowCInteractionFirstWidget.name();
        return;
    L32:
        if (r13 == 3) goto L37;
        if (r13 != 2) goto L38;
        int r16 = cu2.a.a;
        cu2.a.a.b();
        goto L38
    L55:
        return;
    L57:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void wq(int r8, long r9, String r11) {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.log.filter.n0 r1 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r1 != null) goto L5;
    L16:
        String r2 = "";
        String r5 = r2;
    L17:
        r0.put("enter_from_merge", r5);
        r0.put("enter_method", r2);
        DataCenter r3 = ((Widget) this).dataCenter;
        String r4 = null;
        if (r3 == null) goto L20;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r3);
    L21:
        if (r6 != null) goto L23;
    L29:
        r0.put("duration", String.valueOf(r9));
        r0.put("action_type", (String) ((Widget) this).dataCenter.get("log_action_type", ""));
        if (r8 == (-1)) goto L32;
        r0.put("level", String.valueOf(r8));
    L32:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = ho1.a.d(getComponentContext());
        if (r10 == null) goto L35;
        boolean r12 = r10.dg();
    L36:
        if (r12 == false) goto L38;
        String r13 = "1";
    L39:
        r0.put("is_anchor", r13);
        com.bytedance.android.livesdk.log.u.l().sendLog(r11, r0, new Object[0]);
        return;
    L38:
        r13 = "0";
        goto L39
    L35:
        r12 = false;
        goto L36
    L23:
        if (r6.getOwner() == null) goto L28;
        User r7 = r6.getOwner();
        if (r7 == null) goto L27;
        r4 = r7.getIdStr();
    L27:
        r0.put("anchor_id", r4);
    L28:
        String r14 = String.valueOf(r6.id);
        LiveMode r15 = r6.getStreamType();
        int r16 = com.bytedance.android.live.core.utils.h1.a;
        String r17 = com.bytedance.android.live.core.utils.i1.a(r15);
        r0.put("room_id", r14);
        r0.put("live_type", r17);
        goto L29
    L20:
        r6 = null;
        goto L21
    L5:
        if ((r1 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L16;
        com.bytedance.android.livesdk.log.filter.n0 r18 = r1;
        if (((com.bytedance.android.livesdk.log.filter.a) r18).b.containsKey("enter_from_merge") == false) goto L10;
        r5 = (String) ((com.bytedance.android.livesdk.log.filter.a) r18).b.get("enter_from_merge");
        if (r5 == null) goto L10;
    L12:
        if (((com.bytedance.android.livesdk.log.filter.a) r18).b.containsKey("enter_method") == false) goto L15;
        r2 = (String) ((com.bytedance.android.livesdk.log.filter.a) r18).b.get("enter_method");
        if (r2 != null) goto L17;
    L15:
        r2 = "";
    L10:
        r5 = "";
        goto L12
    }
}
