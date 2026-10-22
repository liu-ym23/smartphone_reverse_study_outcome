package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.CountDownView;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.ji;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.security.SecureRandom;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShowCountDownWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowCountDownWidget extends MiddlewareRoomWidget {
    public com.bytedance.android.livesdk.chatroom.ui.framework.a a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c c;
    public CountDownView d;
    public TextView e;
    public boolean f;
    public boolean g;
    public final CompositeDisposable h;

    public ShowCountDownWidget() {
        this.h = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.c(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        this.c = ho1.a.d(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        Room r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.Bc();
    L7:
        if ((r2 instanceof CountDownView) == true) goto L9;
        r2 = null;
    L9:
        this.d = (CountDownView) r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = this.b;
        if (r3 == null) goto L12;
        TextView r4 = r3.ch();
    L13:
        this.e = r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = this.c;
        if (r5 == null) goto L16;
        LiveMode r6 = r5.getLiveMode();
    L17:
        boolean r7 = true;
        if (r6 == null) goto L22;
        if (r6.isStreamingBackground() != true) goto L22;
    L111:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r8 = this.a;
        if (r8 == null) goto L119;
        PropertyOwner r9 = r8.getLoadState();
        if (r9 == null) goto L120;
        Disposable r10 = com.bytedance.android.livesdk.chatroom.ui.framework.b.b(r9, new AnonymousClass1(this));
        if (r10 == null) goto L121;
        RxUtilKt.c(r10, this.h);
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L22:
        if (ji.a.getValue().booleanValue() == false) goto L24;
        boolean r11 = false;
    L25:
        if (r11 == true) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r12 = this.c;
        if (r12 == null) goto L29;
        Bundle r13 = r12.Wl();
    L30:
        if (r13 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r14 = this.c;
        if (r14 == null) goto L34;
        Bundle r15 = r14.Wl();
    L35:
        if (r15 == null) goto L39;
        if (r15.getBoolean("extra_start_live_optimization", false) != true) goto L39;
        boolean r16 = true;
    L40:
        if (r16 == false) goto L48;
        h70.b r17 = getComponentContext();
        if (r17 == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r18 = ho1.a.i(r17);
        if (r18 == null) goto L111;
        View r19 = r18.getRootView();
        if (r19 == null) goto L111;
        r19.postDelayed(new h1(this), 3000);
        goto L111
    L48:
        com.bytedance.android.livesdk.log.filter.n0 r20 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r20 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L51;
        r20.getClass();
    L51:
        CountDownView r21 = this.d;
        if (r21 == null) goto L54;
        r21.setVisibility(0);
    L54:
        CountDownView r22 = this.d;
        if (r22 == null) goto L57;
        r22.setNeedAccessibility(true);
    L57:
        CountDownView r23 = this.d;
        if (r23 == null) goto L60;
        r23.setCountDownListener(new i1(this));
    L60:
        CountDownView r24 = this.d;
        if (r24 == null) goto L64;
        r24.c(true);
    L64:
        if (ms1.h.a() == false) goto L90;
        RoomContext r25 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r25 == null) goto L74;
        com.bytedance.live.datacontext.j r26 = r25.getAnchorRoomScopeViewModel();
        if (r26 == null) goto L74;
        nz.l r27 = (nz.l) r26.getValue();
        if (r27 == null) goto L74;
        com.bytedance.android.live.broadcast.api.scope.service.f r28 = (com.bytedance.android.live.broadcast.api.scope.service.f) r27.a();
        if (r28 == null) goto L74;
        String r29 = r28.a();
    L75:
        if (r29 != null) goto L77;
    L80:
        if (r7 == true) goto L87;
        TextView r30 = this.e;
        if (r30 == null) goto L84;
        r30.setText(r29);
    L84:
        TextView r31 = this.e;
        if (r31 == null) goto L90;
        r31.setVisibility(0);
        goto L90
    L87:
        TextView r32 = this.e;
        if (r32 == null) goto L90;
        r32.setVisibility(8);
        goto L90
    L77:
        if (r29.length() == 0) goto L80;
        r7 = false;
    L74:
        r29 = null;
    L90:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r33 = this.c;
        if (r33 == null) goto L93;
        Room r34 = r33.getRoom();
    L94:
        if (r34 == null) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r35 = this.c;
        if (r35 == null) goto L98;
        r1 = r35.getRoom();
    L98:
        if (r1 == null) goto L111;
        if (r1.getVisibilityRange() != 11) goto L111;
        String[] r36 = s1.D();
        if (r36 != null) goto L104;
    L108:
        TextView r37 = this.e;
        if (r37 == null) goto L111;
        r37.setVisibility(0);
        goto L111
    L104:
        if (r36.length <= 0) goto L108;
        String r38 = r36[new SecureRandom().nextInt(r36.length)];
        TextView r39 = this.e;
        if (r39 == null) goto L108;
        r39.setText("小贴士：" + r38);
        goto L108
    L93:
        r34 = null;
        goto L94
    L34:
        r15 = null;
    L39:
        r16 = false;
        goto L40
    L29:
        r13 = null;
        goto L30
    L24:
        r11 = com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c;
        goto L25
    L16:
        r6 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.h.dispose();
        this.g = false;
    }

    public final void onPause() {
        super.onPause();
        this.f = false;
        NewBroadcastMonitor.f("ttlive_interaction_fragment_pause");
    }

    public final void onResume() {
        super.onResume();
        this.f = true;
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_interaction_fragment_resume", null, null, 14);
        r0.i("send_live_start_on_resume", Boolean.valueOf(this.g));
        r0.a().report();
        if (this.g == false) goto L6;
        NewBroadcastMonitor.a r1 = NewBroadcastMonitor.c("ttlive_send_start_event", null, null, 14);
        r1.i("style", "delay");
        r1.a().report();
        zg1.h1 r2 = new zg1.h1(3);
        xs2.b.a().post(r2);
        this.g = false;
        return;
    }

    public static final void wq(ShowCountDownWidget r4) {
        jo1.g r1 = null;
        if (r4.f == false) goto L5;
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_send_start_event", null, null, 14);
        r0.i("style", "immediately");
        r0.a().report();
        zg1.h1 r2 = new zg1.h1(3);
        xs2.b.a().post(r2);
    L6:
        h70.b r3 = r4.getComponentContext();
        if (r3 == null) goto L11;
        IAbilityCenter r5 = r3.a();
        if (r5 == null) goto L11;
        r1 = (jo1.g) r5.getAbility(jo1.g.class);
    L11:
        if (r1 == null) goto L13;
        r1.fetch();
    L13:
        TextView r6 = r4.e;
        if (r6 == null) goto L17;
        r6.setVisibility(8);
        return;
    L17:
        return;
    L5:
        NewBroadcastMonitor.f("ttlive_delay_send_start_event");
        r4.g = true;
        goto L6
    }
}
