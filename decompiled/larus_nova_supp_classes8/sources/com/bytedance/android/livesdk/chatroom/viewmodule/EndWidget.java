package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.y3;
import com.bytedance.android.livesdk.config.da1;
import com.bytedance.android.livesdk.config.i7;
import com.bytedance.android.livesdk.config.wy0;
import com.bytedance.android.livesdkapi.depend.event.LiveEventCenter;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class EndWidget extends LiveWidget {
    public boolean a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            ALogger.d("EndWidget", "PostRunnable EndWidgetTime = " + System.currentTimeMillis());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    public final String getSpm() {
        return "a100.a100.a247";
    }

    public final int getLayoutId() {
        if (wy0.a.getValue().getEndWidgetLoadOpt() == false) goto L6;
        return 0;
    L6:
        return 2131568008;
    }

    public final void onCreate() {
        super.onCreate();
        if (isViewValid() == false) goto L6;
        ((Widget) this).dataCenter.put("cmd_widget_loaded", new y3(this.a));
        ((Widget) this).dataCenter.put("cmd_all_widget_loaded", Boolean.TRUE);
        ((Widget) this).containerView.post(new a());
    L6:
        if (this.a == false) goto L9;
        return;
    L9:
        if (da1.a.getValue().booleanValue() == false) goto L12;
        jc1.k.f(IUserService.class).user().b().setVcdAdversaryAuthorizeState(false, false);
        jc1.k.f(IRoomService.class).getCurrentRoom().getBaseOwner().setVcdAdversaryAuthorizeState(true, true);
        ((Widget) this).contentView.setOnClickListener(new e0(this));
    L12:
        if (i7.a.getValue().intValue() != 1) goto L15;
        Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new f0(this));
    L15:
        if (RoomContext.getShared() != null) goto L17;
    L22:
        LiveEventCenter r0 = LiveEventCenter.INSTANCE;
        r0.onLiveWidgetLoaded();
        r0.onStartLiveWidgetLoaded();
        return;
    L17:
        if (((Boolean) RoomContext.getShared().isAnchor().getValue()).booleanValue() == false) goto L22;
        HashMap r1 = new HashMap();
        r1.put("duration", String.valueOf(System.currentTimeMillis() - ((Long) com.bytedance.android.livesdk.sharedpref.b.j.getValue()).longValue()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_room_ui_loading_duration", r1, new Object[0]);
        r1.put("scene", ((LiveMode) RoomContext.getShared().getLiveMode().getValue()).getSceneName());
        r1.put("stage", "anchor_component_all_load_time");
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L21;
        r1.put("start_live_page_mode", (String) r2.get("cmd_anchor_start_live_page_mode", "take_page"));
    L21:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_perf_monitor", r1, new Object[0]);
        jc1.k.f(IPerformanceManager.class).monitorPerformance("broadcast_load_end");
        com.bytedance.android.live.core.utils.i0.c().postDelayed(new g0(this), 2000);
        goto L22
    }

    public final void onResume() {
        super.onResume();
        if (isViewValid() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        r0.put("cmd_widget_loaded_v2", new y3(this.a));
        return;
    L9:
        return;
    }

    public EndWidget() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }
}
