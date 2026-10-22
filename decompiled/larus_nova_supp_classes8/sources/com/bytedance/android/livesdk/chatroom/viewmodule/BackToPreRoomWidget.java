package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.widget.CircleProgressView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BackToPreRoomWidget extends LiveRecyclableWidget {
    public k1 a;

    public final int getLayoutId() {
        return 2131565203;
    }

    public final String getSpm() {
        return "a100.a100.a157";
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        k1 r0 = this.a;
        if (r0 == null) goto L14;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        long r2 = ((long) com.bytedance.android.livesdk.config.l0.a.getValue().totalTime) * 1000;
        ObjectAnimator r4 = r0.g;
        if (r4 == null) goto L7;
        long r5 = r4.getCurrentPlayTime() + (r2 - r0.g.getDuration());
        r0.g.cancel();
        r0.g.removeAllListeners();
    L9:
        if (r0.g == null) goto L12;
        r2 = r5;
    L12:
        r1.put("data_back_to_pre_room_fraction", Long.valueOf(r2));
        return;
    L7:
        r5 = 0;
        goto L9
    }

    public BackToPreRoomWidget() {
    }

    public final void onLoad(Object[] r18) {
        if (((Widget) this).contentView == null) goto L54;
        Context r3 = ((Widget) this).context;
        Lifecycle r4 = getLifecycle();
        ViewGroup r5 = (ViewGroup) ((Widget) this).contentView;
        k1 r1 = new k1(r3, r4, r5);
        this.a = r1;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L53;
        Bundle r7 = (Bundle) r6.get("data_room_back");
        r1.i = r7;
        if (r7 == null) goto L53;
        if (r7.getLong("show_time", 0) < 0) goto L53;
        ImageModel r2 = r1.i.getParcelable("pre_room_user_avatar");
        if ((r2 instanceof ImageModel) == false) goto L14;
        int r10 = r1.a;
        ImageLoader.bindAvatar(r1.c, r2, r10, r10);
    L14:
        UIUtils.setViewVisibility(r5, 0);
        com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        r5.setOnClickListener(new j1(r1));
        long r11 = ((Long) r6.get("data_room_id", 0L)).longValue();
        if (r1.f != r11) goto L17;
    L19:
        r1.f = r11;
        CircleProgressView r8 = r1.e;
        if (tb1.c.a == false) goto L22;
        int r9 = -54187;
    L23:
        r8.setBorderColor(r9);
        r1.e.setBorderWidth(com.bytedance.android.live.core.utils.s1.f(1.5f));
        r1.e.setCounterClockWise(false);
        r1.d.setText(2131915229);
        long r12 = ((Long) r6.get("data_back_to_pre_room_fraction", 0L)).longValue();
        if (((Boolean) r6.get("data_back_to_pre_room_countdown_dismiss", Boolean.TRUE)).booleanValue() == false) goto L34;
        long r13 = r1.i.getLong("show_time", 0) * 1000;
        long r14 = com.bytedance.android.livesdk.config.l0.a.getValue().totalTime * BubbleId.PadCast;
        if (r13 <= 0) goto L28;
        r14 = Math.min(r13, r14);
    L28:
        float r15 = 360.0f;
        if (r12 <= 0) goto L31;
        r15 = 360.0f - ((r12 * 360.0f) / r14);
        r14 = r14 - r12;
    L31:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r1.e, "progress", new float[]{r15, 0.0f});
        r1.g = r16;
        if (r16 == null) goto L34;
        r16.setDuration(r14);
        r1.g.addListener(new i1(r1));
        r1.g.start();
    L34:
        long r17 = com.bytedance.android.livesdk.config.l0.a.getValue().delayTime * BubbleId.PadCast;
        if (r12 >= r17) goto L37;
        r17 = r17 - r12;
    L37:
        ((ObservableSubscribeProxy) Observable.just(r1).delay(r17, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(r4, Lifecycle.Event.ON_DESTROY)))).subscribe(new h1(), RxUtil.getNoOpThrowable());
        Bundle r19 = r1.i;
        if (r19 == null) goto L60;
        long r20 = r19.getLong("live.intent.extra.ROOM_ID", 0);
        com.bytedance.android.livesdk.log.filter.o r21 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        com.bytedance.android.livesdk.log.filter.o r22 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        HashMap r23 = new HashMap();
        String[] r24 = {"room_id", "anchor_id"};
        if (r24.length < 1) goto L46;
        int r25 = r24.length;
        int r110 = 0;
    L44:
        if (r110 >= r25) goto L46;
        String r111 = r24[r110];
        r23.put(r111, com.bytedance.android.livesdk.log.l0.a(r111, r21));
        r110 = r110 + 1;
    L46:
        r23.put("to_room_id", String.valueOf(r20));
        r23.put("to_anchor_id", com.bytedance.android.live.base.model.user.n0.c(r1.i, "anchor_id"));
        r23.put("orientation", String.valueOf(r1.i.getInt("orientation", 0)));
        String[] r26 = {"enter_from_merge", "enter_method", "action_type"};
        if (r26.length < 1) goto L52;
        int r27 = r26.length;
        int r112 = 0;
    L50:
        if (r112 >= r27) goto L52;
        String r28 = r26[r112];
        r23.put(r28, com.bytedance.android.livesdk.log.l0.a(r28, r22));
        r112 = r112 + 1;
    L52:
        com.bytedance.android.livesdk.log.g r29 = com.bytedance.android.livesdk.log.u.l();
        am2.o r30 = new am2.o();
        r30.a = r11;
        r29.sendLog("livesdk_return_show", r23, new Object[]{r30});
        return;
    L60:
        return;
    L22:
        r9 = -45517;
        goto L23
    L17:
        if (com.bytedance.android.livesdk.config.l0.a.getValue().enableHourRank() == true) goto L19;
        com.bytedance.android.live.core.utils.f2.h(r5.getContext(), 2131915634, 0);
    L53:
        r5.setVisibility(8);
        return;
    L54:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
    }
}
