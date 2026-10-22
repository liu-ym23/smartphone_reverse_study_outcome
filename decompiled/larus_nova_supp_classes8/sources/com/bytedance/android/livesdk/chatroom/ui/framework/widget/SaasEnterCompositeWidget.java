package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/SaasEnterCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/r;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasEnterCompositeWidget extends MiddlewareRoomWidget implements r {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public final CompositeDisposable c;
    public Widget d;

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public SaasEnterCompositeWidget() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        DataCenter r0 = ((Widget) this).dataCenter;
        Widget r1 = null;
        if (r0 == null) goto L5;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r0);
    L7:
        if (r2 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 == null) goto L12;
        boolean r4 = r3.R7();
    L13:
        if (r4 == false) goto L27;
        IRoomCart r5 = r2.getRoomCart();
        if (r5 == null) goto L17;
        Boolean r6 = Boolean.valueOf(r5.getContainCart());
    L19:
        if (r6.booleanValue() == false) goto L27;
        IEnterGuideService r7 = jc1.k.f(IEnterGuideService.class);
        if (r7 == null) goto L23;
        Widget r8 = r7.createCouponDialogWidget(getContext());
    L24:
        this.d = r8;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r9 = this.b;
        if (r9 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(r9, r8, 6);
        goto L27
    L23:
        r8 = null;
        goto L24
    L17:
        r6 = null;
        goto L19
    L12:
        r4 = true;
    L27:
        h70.b r10 = getComponentContext();
        if (r10 == null) goto L32;
        IAbilityCenter r11 = r10.a();
        if (r11 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e r12 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e) r11.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e.class);
    L33:
        if (r12 == null) goto L45;
        List<kf1.a> r13 = r12.op();
        if (r13 == null) goto L45;
        IEnterGuideService r14 = jc1.k.f(IEnterGuideService.class);
        if (r14 == null) goto L40;
        Widget r15 = r14.createSlideTaskWidget(r13);
    L41:
        if (r15 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r16 = this.b;
        if (r16 == null) goto L45;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(r16, r15, 6);
        goto L45
    L40:
        r15 = null;
    L45:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r17 = this.a;
        if (r17 == null) goto L57;
        com.bytedance.android.live.room.l r18 = r17.ef();
        if (r18 == null) goto L57;
        IEnterGuideService r19 = jc1.k.f(IEnterGuideService.class);
        if (r19 == null) goto L53;
        r1 = r19.createUgCouponWidget(r18);
    L53:
        if (r1 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r20 = this.b;
        if (r20 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.b(r20, r1, 6);
    L57:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r21 = this.b;
        if (r21 == null) goto L64;
        PropertyOwner r22 = r21.getLoadState();
        if (r22 == null) goto L64;
        Disposable r23 = com.bytedance.android.livesdk.chatroom.ui.framework.b.e(r22, new AnonymousClass1(this));
        if (r23 == null) goto L64;
        RxUtilKt.c(r23, this.c);
    L64:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r24 = this.b;
        if (r24 == null) goto L71;
        PropertyOwner r25 = r24.getLoadState();
        if (r25 == null) goto L71;
        Function0<Unit> r26 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r25, "$this$runWithP3RealLoaded");
        Intrinsics.checkNotNullParameter(r26, "callback");
        Disposable r27 = com.bytedance.android.livesdk.chatroom.ui.framework.b.g(r25, LoadState.P3_REAL_END, r26);
        if (r27 == null) goto L71;
        RxUtilKt.c(r27, this.c);
    L71:
        ho1.a.p(getComponentContext(), r.class, this);
        return;
    L32:
        r12 = null;
        goto L33
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), r.class);
        this.c.dispose();
        this.d = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.r
    public final Widget pq() {
        return this.d;
    }
}
