package com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.setting.a2;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.b;
import com.bytedance.android.livesdk.chatroom.ui.framework.d;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.h;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.notification.AudioLiveNotificationManager;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.focus.IFocusContext;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.l3;
import zg1.u1;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/AnchorPortraitPKAndMultiCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/multistate/PKAndMultiCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPortraitPKAndMultiCompositeWidget extends PKAndMultiCompositeWidget {
    public static final /* synthetic */ int j = 0;
    public boolean h;
    public int i;

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final boolean Bq() {
        return DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), true, true);
    }

    public final void Qq() {
        if (Aq() == true) goto L5;
        return;
    L5:
        if (yq() != null) goto L7;
        return;
    L7:
        if (Nt() == true) goto L9;
        return;
    L9:
        if (this.e == false) goto L16;
        ((Widget) this).dataCenter.put("data_is_score_open_targety", Float.valueOf(this.d));
        h.a(((Widget) this).dataCenter, "AudioKtv");
        return;
    }

    public final int Rq() {
        if (yq() == null) goto L5;
        int r0 = c9();
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_score_open", Boolean.FALSE)).booleanValue() == false) goto L9;
        int r1 = 2131168852;
    L10:
        int r2 = s1.j(r1);
        int r3 = ((int) this.d) + r2;
        int r4 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(Boolean.TRUE));
        int r5 = this.i;
        if (r0 < ((r3 + r5) + r4)) goto L13;
        return r5;
    L13:
        return Math.max((r0 - r3) - r4, s1.j(2131169173));
    L9:
        r1 = 2131168851;
        goto L10
    L5:
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.c;
        if (r0 == null) goto L10;
        PropertyOwner r1 = r0.getLoadState();
        if (r1 == null) goto L11;
        Disposable r2 = b.b(r1, new AnonymousClass1(this));
        if (r2 == null) goto L12;
        RxUtilKt.c(r2, this.f);
        return;
    L12:
        return;
    L11:
        return;
    }

    public AnchorPortraitPKAndMultiCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Cq(boolean r4) {
        if (r4 != this.h) goto L5;
        return;
    L5:
        if (r4 == true) goto L7;
        Qq();
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
        Qq();
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Eq(boolean r4) {
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_ktv_move", Boolean.FALSE)).booleanValue() == true) goto L6;
        Qq();
    L6:
        if (this.e == false) goto L15;
        if (r4 == true) goto L9;
        return;
    L9:
        if (Rq() == this.i) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L17;
        this.d = s1.f(186);
        return;
    L17:
        return;
    L11:
        r5 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Fq(int r3) {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if ((r0 instanceof RoomContext) == true) goto L5;
        r0 = null;
    L5:
        RoomContext r1 = (RoomContext) r0;
        if (r1 == null) goto L16;
        j r2 = r1.getFocusContext();
        if (r2 == null) goto L16;
        IFocusContext r4 = (IFocusContext) r2.getValue();
        if (r4 == null) goto L16;
        if (r3 > 2) goto L14;
        boolean r5 = true;
    L15:
        r4.setEnable(r5);
        goto L16
    L14:
        r5 = false;
    L16:
        IInteractService r6 = k.f(IInteractService.class);
        if (r6 == null) goto L19;
        String r7 = r6.changeMode2String(r3);
    L20:
        e r8 = com.bytedance.android.livesdk.sharedpref.b.E;
        if (StringUtils.equal(r7, (String) r8.getValue()) == true) goto L24;
        f.d(r8, r7);
        return;
    L24:
        return;
    L19:
        r7 = "";
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Iq(u1 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        super.Iq(r3);
        if (yq() != null) goto L6;
        return;
    L6:
        if (r3.f != 1) goto L11;
        this.d = (r3.g - s1.j(2131168851)) - s1.f(8.0f);
        IKtvService r4 = k.f(IKtvService.class);
        if (r4 == null) goto L12;
        r4.ktvContainerPositionUpdate(Float.valueOf(this.d), null);
        return;
    L12:
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
    public final void Mq(z0 r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (hq() == true) goto L5;
        return;
    L5:
        super.Mq(r7);
        d r0 = this.b;
        if (r0 == null) goto L8;
        InteractionWidgetsPosContext r1 = r0.Om();
    L10:
        if (yq() == null) goto L37;
        if (r1 == null) goto L41;
        int r2 = r7.a;
        boolean r3 = true;
        if (r2 != 0) goto L34;
        this.e = true;
        this.i = ((Number) r1.getPublicScreenHeight().getValue()).intValue();
        if (Bq() == true) goto L19;
        this.d = s1.f(186);
    L26:
        if (Rq() != this.i) goto L29;
        r3 = false;
    L29:
        if (r3 == false) goto L31;
        this.d = s1.f(186);
    L31:
        IKtvService r8 = k.f(IKtvService.class);
        if (r8 == null) goto L38;
        r8.ktvContainerPositionUpdate(Float.valueOf(this.d), null);
        return;
    L38:
        return;
    L19:
        if ((r7.b instanceof Integer) == false) goto L26;
        int r4 = s1.f(10.0f) + (-s1.f(4.0f));
        Object r9 = r7.b;
        if (r9 == null) goto L24;
        this.d = ((Integer) r9).intValue() - r4;
        goto L26
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L34:
        if (r2 != 1) goto L40;
        this.e = false;
        return;
    L40:
        return;
    L41:
        return;
    L37:
        return;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.multistate.PKAndMultiCompositeWidget
    public final void Pq(l3 r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r6, "event");
        View r0 = yq();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r6.a;
        if (r1 != 0) goto L8;
    L31:
        int r2 = r6.c;
        int r3 = r6.b;
        int r7 = r6.e;
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L38;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        if (r4 == null) goto L37;
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r4;
        r5.rightMargin = s1.f(r3);
        r5.leftMargin = s1.f(r7);
        r0.setLayoutParams(r5);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L38:
        this.d = c9() - s1.f(r2);
        IKtvService r8 = k.f(IKtvService.class);
        if (r8 == null) goto L47;
        r8.ktvContainerPositionUpdate(Float.valueOf(this.d), Integer.valueOf(r3));
        return;
    L47:
        return;
    L8:
        if (r1 == 3) goto L31;
        if (r1 != 1) goto L20;
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L42;
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        if (r9 == null) goto L18;
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r9;
        r10.rightMargin = 0;
        r0.setLayoutParams(r10);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L42:
        return;
    L20:
        if (r1 == 6) goto L22;
        return;
    L22:
        if ((r0.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L28;
        ViewGroup.LayoutParams r11 = r0.getLayoutParams();
        if (r11 == null) goto L27;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
        r12.rightMargin = 0;
        r0.setLayoutParams(r12);
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L28:
        this.d = c9() - r6.c;
        IKtvService r13 = k.f(IKtvService.class);
        if (r13 == null) goto L45;
        r13.ktvContainerPositionUpdate(Float.valueOf(this.d), 0);
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
        Qq();
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
        if (((Boolean) a2.a.getValue()).booleanValue() == false) goto L12;
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
