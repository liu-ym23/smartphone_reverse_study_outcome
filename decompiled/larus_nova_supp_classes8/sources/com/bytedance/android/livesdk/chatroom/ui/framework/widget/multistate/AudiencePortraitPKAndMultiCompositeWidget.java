package com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.setting.b2;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.utils.c;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.b;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.android.livesdk.config.li0;
import com.bytedance.android.livesdk.config.t40;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.notification.AudioLiveNotificationManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.l3;
import zg1.u1;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/AudiencePortraitPKAndMultiCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/PKAndMultiCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitPKAndMultiCompositeWidget extends PKAndMultiCompositeWidget {
    public boolean h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.setAlpha(1.0f);
        }
    }

    public final boolean Sq() {
        i32.a r0 = (i32.a) ((Widget) this).dataCenter.get("cmd_data_interact_public_screen_height_change", null);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (yq() != null) goto L8;
        return false;
    L8:
        int r2 = c9();
        DataCenter r3 = ((Widget) this).dataCenter;
        Boolean r4 = Boolean.FALSE;
        if (((Boolean) r3.get("data_is_score_open", r4)).booleanValue() == false) goto L11;
        int r5 = 2131168852;
    L12:
        int r6 = s1.j(r5);
        int r7 = ((int) this.d) + r6;
        int r8 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(r4));
        if (r2 >= ((r7 + r0.a) + r8)) goto L16;
        return true;
    L16:
        return false;
    L11:
        r5 = 2131168851;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final boolean Bq() {
        return DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), true, false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Gq() {
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L11;
        View r1 = Ia();
        if (r1 == null) goto L12;
        r1.setVisibility(0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Jq() {
        Room r0 = getRoom();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLiveTypeAudio() != true) goto L11;
        View r1 = Ia();
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        Tq(false);
        t40 r0 = t40.a;
        if (r0.getValue().booleanValue() == false) goto L12;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r1 = this.c;
        if (r1 == null) goto L12;
        PropertyOwner r2 = r1.getLoadState();
        if (r2 == null) goto L12;
        Disposable r3 = b.c(r2, new AnonymousClass1(this));
        if (r3 == null) goto L12;
        RxUtilKt.c(r3, this.f);
    L12:
        if (r0.getValue().booleanValue() == true) goto L21;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r4 = this.c;
        if (r4 == null) goto L22;
        PropertyOwner r5 = r4.getLoadState();
        if (r5 == null) goto L23;
        Disposable r6 = b.b(r5, new AnonymousClass2(this));
        if (r6 == null) goto L24;
        RxUtilKt.c(r6, this.f);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    public AudiencePortraitPKAndMultiCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    public static final void Qq(AudiencePortraitPKAndMultiCompositeWidget r4) {
        View r0 = r4.yq();
        if (r0 == null) goto L21;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L20;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.addRule(3, 0);
        r2.setMargins(0, 0, 0, 0);
        r0.setLayoutParams(r2);
        r0.setTop(0);
        if (r4.Nt() == false) goto L10;
        int r3 = s1.f(316);
    L11:
        r4.d = r3;
        View r5 = r4.yq();
        if (r5 == null) goto L14;
        r5.setY(r4.d);
    L14:
        IKtvService r6 = k.f(IKtvService.class);
        if (r6 == null) goto L17;
        r6.ktvContainerPositionUpdate(Float.valueOf(r4.d), null);
    L17:
        r0.bringToFront();
        return;
    L10:
        r3 = s1.j(2131168828);
        goto L11
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Cq(boolean r4) {
        if (r4 != this.h) goto L5;
        return;
    L5:
        if (r4 == true) goto L7;
        Rq(false);
    L13:
        this.h = r4;
        return;
    L7:
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        r0.put("data_is_ktv_move", r1);
        View r2 = yq();
        if (r2 == null) goto L11;
        r2.getY();
    L11:
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_ktv_move", r1)).booleanValue() == true) goto L13;
        Rq(true);
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Eq(boolean r4) {
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_ktv_move", Boolean.FALSE)).booleanValue() == true) goto L6;
        Rq(true);
    L6:
        if (this.e == false) goto L12;
        if (r4 == true) goto L9;
        return;
    L9:
        if (Sq() == false) goto L14;
        this.d = s1.f(186);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Iq(u1 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        super.Iq(r3);
        if (yq() != null) goto L6;
        return;
    L6:
        if (r3.f != 1) goto L9;
        this.d = (r3.g - s1.j(2131168851)) - s1.f(8.0f);
        IKtvService r4 = k.f(IKtvService.class);
        Intrinsics.checkNotNull(r4);
        r4.ktvContainerPositionUpdate(Float.valueOf(this.d), null);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Kq(int r2) {
        if (v.a(r2, 32) == true) goto L6;
        Tq(true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Lq(RevPkState r2) {
        Intrinsics.checkNotNullParameter(r2, "pkState");
        Intrinsics.checkNotNullParameter(r2, "pkState");
        if (r2 != RevPkState.PK) goto L8;
        IPerformanceManager r3 = k.f(IPerformanceManager.class);
        if (r3 == null) goto L9;
        r3.monitorPerformance("live_pk");
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Mq(z0 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (hq() == true) goto L5;
        return;
    L5:
        super.Mq(r4);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L10;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L10;
        jo1.b r2 = (jo1.b) r1.getAbility(jo1.b.class);
    L11:
        if (r2 == null) goto L14;
        r2.Go(r4);
    L14:
        if (yq() != null) goto L16;
        return;
    L16:
        int r3 = r4.a;
        if (r3 != 0) goto L31;
        this.e = true;
        if (Bq() == true) goto L22;
        this.d = s1.f(186);
    L29:
        if (Sq() == false) goto L34;
        this.d = s1.f(186);
        return;
    L34:
        return;
    L22:
        if ((r4.b instanceof Integer) == false) goto L29;
        int r5 = s1.f(10.0f) + (-s1.f(4.0f));
        Object r6 = r4.b;
        if (r6 == null) goto L27;
        this.d = ((Integer) r6).intValue() - r5;
        goto L29
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L31:
        if (r3 != 1) goto L36;
        this.e = false;
        return;
    L36:
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Pq(l3 r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r7, "event");
        View r0 = yq();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r7.a;
        if (r1 != 0) goto L8;
    L35:
        int r2 = r7.c;
        int r4 = r7.b;
        int r8 = r7.e;
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L42;
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if (r5 == null) goto L41;
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r5;
        r6.rightMargin = s1.f(r4);
        r6.leftMargin = s1.f(r8);
        r0.setLayoutParams(r6);
        goto L42
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L42:
        this.d = c9() - s1.f(r2);
        IKtvService r9 = k.f(IKtvService.class);
        if (r9 == null) goto L45;
        r9.ktvContainerPositionUpdate(Float.valueOf(this.d), Integer.valueOf(r4));
    L45:
        Tq(true);
        return;
    L8:
        if (r1 == 3) goto L35;
        if (r1 != 1) goto L23;
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L19;
        ViewGroup.LayoutParams r10 = r0.getLayoutParams();
        if (r10 == null) goto L18;
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r10;
        r11.rightMargin = 0;
        r0.setLayoutParams(r11);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L19:
        IKtvService r12 = k.f(IKtvService.class);
        if (r12 == null) goto L47;
        r12.ktvContainerPositionUpdate(null, 0);
        return;
    L47:
        return;
    L23:
        if (r1 == 6) goto L25;
        return;
    L25:
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L31;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        if (r3 == null) goto L30;
        RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) r3;
        r13.rightMargin = 0;
        r0.setLayoutParams(r13);
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L31:
        this.d = c9() - s1.f(r7.c);
        IKtvService r14 = k.f(IKtvService.class);
        if (r14 == null) goto L34;
        r14.ktvContainerPositionUpdate(Float.valueOf(this.d), 0);
    L34:
        Tq(true);
    }

    public final void Rq(boolean r3) {
        if (Aq() == true) goto L5;
        return;
    L5:
        if (yq() != null) goto L7;
        return;
    L7:
        if (Nt() == true) goto L9;
        return;
    L9:
        if (this.e == false) goto L18;
        if (r3 == false) goto L13;
        ((Widget) this).dataCenter.put("data_is_score_open_targety", Float.valueOf(this.d));
    L13:
        h.a(((Widget) this).dataCenter, "AudioKtv");
        return;
    }

    public final void Tq(boolean r4) {
        View r0 = yq();
        if (r0 != null) goto L6;
        return;
    L6:
        if (c.a() == false) goto L11;
        if (r4 == false) goto L9;
        r0.setAlpha(1.0f);
        return;
    L9:
        r0.setAlpha(0.0f);
        Disposable r5 = Observable.interval(li0.a.getValue().getRemoveViewMockTimeOut(), TimeUnit.SECONDS).take(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r0));
        this.f.add(r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void wq(boolean r3) {
        if (Aq() == true) goto L5;
        return;
    L5:
        if (yq() != null) goto L7;
        return;
    L7:
        if (Nt() == false) goto L22;
        if (r3 == true) goto L11;
    L15:
        ((Widget) this).dataCenter.put("data_is_ktv_move", Boolean.FALSE);
        if (this.h == false) goto L21;
        Rq(true);
        return;
    L21:
        return;
    L11:
        if (Bq() == false) goto L13;
        int r4 = s1.f(423);
    L14:
        this.d = r4;
        goto L15
    L13:
        r4 = (s1.f(122.0f) + (s1.w() / 2)) - s1.j(2131168851);
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Nq(boolean r2, boolean r3) {
        if (((Boolean) b2.a.getValue()).booleanValue() == false) goto L12;
        if (r3 == false) goto L8;
        if (r2 == false) goto L7;
        Lazy r4 = AudioLiveNotificationManager.f;
        AudioLiveNotificationManager.a.a().i();
        return;
    L7:
        Lazy r5 = AudioLiveNotificationManager.f;
        AudioLiveNotificationManager.a.a().getClass();
        AudioLiveNotificationManager.c();
        return;
    L8:
        if (r2 == false) goto L10;
        Lazy r6 = AudioLiveNotificationManager.f;
        AudioLiveNotificationManager.a.a().h();
        return;
    L10:
        Lazy r7 = AudioLiveNotificationManager.f;
        AudioLiveNotificationManager.a.a().b();
        return;
    }
}
