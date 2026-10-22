package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.enterprocess.IInteractionBizInterceptor;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.p;
import com.bytedance.android.livesdk.chatroom.ui.l8;
import com.bytedance.android.livesdk.chatroom.utils.o4;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.config.t1;
import com.bytedance.android.livesdk.config.y91;
import com.bytedance.android.livesdk.interactivity.api.exitroom.ICloseInterceptorService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/RoomCloseInterceptorWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/room/e;", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCloseInterceptorWidget extends MiddlewareRoomWidget implements e, WeakHandler.IHandler, Observer<KVData> {
    public static boolean g;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public final CopyOnWriteArrayList<kf1.a> b;
    public lm3.d c;
    public final WeakHandler d;
    public final CompositeDisposable e;
    public m32.b f;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ RoomCloseInterceptorWidget a;

        public b(RoomCloseInterceptorWidget r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(Object r2, Object r3) {
            kf1.a r4 = (kf1.a) r2;
            kf1.a r5 = (kf1.a) r3;
            Intrinsics.checkNotNullParameter(r4, "o1");
            Intrinsics.checkNotNullParameter(r5, "o2");
            return RoomCloseInterceptorWidget.xq(this.a, r5) - RoomCloseInterceptorWidget.xq(this.a, r4);
        }
    }

    public static final class c implements kf1.a {
        public final /* synthetic */ RoomCloseInterceptorWidget a;
        public final /* synthetic */ com.bytedance.android.live.room.l b;

        public final String tag() {
            return "FollowRetainInterceptor";
        }

        public final CloseRoomInterceptList config() {
            return CloseRoomInterceptList.DEFAULT;
        }

        public c(RoomCloseInterceptorWidget r1, com.bytedance.android.live.room.l r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean qa(Runnable r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "afterInterceptRunnable");
            if (r13 == false) goto L5;
            return false;
        L5:
            boolean r14 = tb1.c.a;
            final RoomCloseInterceptorWidget r15 = this.a;
            if (r15.f != null) goto L10;
            ICloseInterceptorService r1 = jc1.k.f(ICloseInterceptorService.class);
            if (r1 == null) goto L10;
            r15.f = r1.createQuitRoomGuideController();
        L10:
            m32.b r2 = r15.f;
            if (r2 == null) goto L23;
            DataCenter r4 = ((Widget) r15).dataCenter;
            Context r5 = r15.getContext();
            Room r6 = r15.getRoom();
            com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = r15.a;
            if (r0 == null) goto L16;
            Bundle r7 = r0.Wl();
        L17:
            boolean r8 = com.bytedance.android.livesdk.slideuptip.k.e();
            com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = r15.a;
            if (r3 == null) goto L20;
            com.bytedance.android.live.room.l r9 = r3.ef();
        L22:
            return r2.a(r12, r4, r5, r6, r7, r8, r9, new RoomCloseInterceptorWidget$showRoomQuitDialogForSaas$1(r15));
        L20:
            r9 = null;
            goto L22
        L16:
            r7 = null;
            goto L17
        L23:
            return false;
        }
    }

    public final class d implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.RoomCloseInterceptorWidget$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lu22/j;", "p1", "", "invoke", "(Lu22/j;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<u22.j, Unit> {
        public AnonymousClass1(RoomCloseInterceptorWidget r8) {
            super(1, r8, RoomCloseInterceptorWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/interactivity/api/comment/event/ShowExitFollowDialogEvent;)V", 0);
        }

        public final void invoke(u22.j r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            RoomCloseInterceptorWidget r0 = (RoomCloseInterceptorWidget) ((CallableReference) this).receiver;
            boolean r1 = RoomCloseInterceptorWidget.g;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = r0.a;
            if (r2 == null) goto L5;
            com.bytedance.android.live.room.l r4 = r2.ef();
        L6:
            if (r4 != null) goto L9;
            return;
        L9:
            if (r3.getType() == 2) goto L12;
            SystemClock.elapsedRealtime();
            r4.a();
            ((Number) n61.b.getValue()).longValue();
            return;
        L12:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((u22.j) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void handleMsg(Message r1) {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    private final Activity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public final boolean g1() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.V9() != true) goto L11;
        return true;
    L5:
        if (r0.V9() != true) goto L6;
        return true;
    }

    public final Room getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return z.o(r0);
    }

    public RoomCloseInterceptorWidget() {
        this.b = new CopyOnWriteArrayList();
        this.d = new WeakHandler(this);
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        RoomContext r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r0);
    L6:
        this.a = r2;
        if (r2 == null) goto L9;
        Bundle r3 = r2.Wl();
    L10:
        if (r3 == null) goto L12;
        Bundle r4 = m0.a(r3);
    L13:
        if (r4 == null) goto L15;
        r4.getLong("live.intent.extra.ENTER_LIVE_TIME", 0);
    L15:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L18;
        r5.observeForever("cmd_widget_loaded", this);
    L18:
        ((ObservableSubscribeProxy) xs2.b.a().b(u22.j.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new d(new AnonymousClass1(this)));
        RoomContext r6 = getMiddlewareRoomContext();
        if ((r6 instanceof RoomContext) == false) goto L22;
        r1 = r6;
    L22:
        RoomContext r7 = r1;
        if (r7 == null) goto L27;
        com.bytedance.live.datacontext.j r8 = r7.getCloseRoomInterceptors();
        if (r8 == null) goto L27;
        r8.d(this.b);
    L27:
        h70.b r9 = getComponentContext();
        if (r9 == null) goto L33;
        IAbilityCenter r10 = r9.a();
        if (r10 == null) goto L34;
        r10.registerAbility(e.class, this);
        return;
    L34:
        return;
    L33:
        return;
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(e.class);
    L7:
        this.e.dispose();
        this.d.removeCallbacksAndMessages(null);
        this.b.clear();
        this.a = null;
        this.c = null;
    }

    public final void yq() {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        Bundle r2 = null;
        if ((r0 instanceof RoomContext) == true) goto L5;
        r0 = null;
    L5:
        RoomContext r1 = (RoomContext) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        Room r3 = getRoom();
        if (r3 != null) goto L11;
        return;
    L11:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.a;
        if (r4 == null) goto L14;
        com.bytedance.android.live.room.l r5 = r4.ef();
    L15:
        if (r5 != null) goto L17;
        return;
    L17:
        IExternalConfigJudger r6 = (IExternalConfigJudger) r1.getExternalConfigJudger().getValue();
        if (r6 == null) goto L23;
        if (r6.disable(EXTERNAL_CONFIG_TYPE.Guide, "leaveRetainGuide") != true) goto L23;
        return;
    L23:
        if (o4.a == true) goto L26;
        o4.a = true;
        this.b.add(new g(this));
    L26:
        ICloseInterceptorService r7 = jc1.k.f(ICloseInterceptorService.class);
        if (r7 == null) goto L35;
        CopyOnWriteArrayList<kf1.a> r8 = this.b;
        Context r9 = getContext();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.a;
        if (r10 == null) goto L31;
        Bundle r11 = r10.Wl();
    L32:
        if (r11 == null) goto L34;
        r2 = m0.a(r11);
    L34:
        r8.addAll(r7.provideCloseRoomInterceptors(r9, r3, r2));
        goto L35
    L31:
        r11 = null;
    L35:
        this.b.add(new c(this, r5));
        this.b.add(new j(this));
        if (tb1.c.c == true) goto L38;
    L41:
        this.b.add(new h(this));
        this.b.add(new k(this));
        return;
    L38:
        if (l8.a() == false) goto L41;
        this.b.add(new i(this));
        goto L41
    L14:
        r5 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e
    public final List<kf1.a> op() {
        return this.b;
    }

    public static final /* synthetic */ Activity wq(RoomCloseInterceptorWidget r0) {
        return r0.getActivity();
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L109;
        boolean r1 = true;
        if (r0.hq() != true) goto L114;
        LiveMode r2 = null;
        if (r7 == null) goto L10;
        String r3 = r7.getKey();
    L11:
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.hashCode() == (-1836833765)) goto L17;
        return;
    L17:
        if (r3.equals("cmd_widget_loaded") == true) goto L19;
        return;
    L19:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r7) == false) goto L111;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.a;
        if (r8 == null) goto L23;
        boolean r9 = r8.dg();
    L24:
        if (r9 == false) goto L60;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.a;
        if (r10 == null) goto L29;
        r2 = r10.getLiveMode();
    L29:
        if (r2 == LiveMode.MEDIA) goto L32;
        r1 = false;
    L32:
        if (r1 == true) goto L34;
    L36:
        h70.b r11 = getComponentContext();
        if (r11 == null) goto L43;
        kf1.a r12 = ho1.a.k(r11);
        if (r12 == null) goto L43;
        if (this.b.contains(r12) == true) goto L43;
        this.b.add(0, r12);
    L43:
        h70.b r13 = getComponentContext();
        if (r13 == null) goto L52;
        p r14 = ho1.a.j(r13);
        if (r14 == null) goto L52;
        kf1.a r15 = r14.cf();
        if (r15 == null) goto L52;
        if (this.b.contains(r15) == true) goto L52;
        this.b.add(r15);
    L52:
        h70.b r16 = getComponentContext();
        if (r16 == null) goto L59;
        kf1.a r17 = ho1.a.a(r16);
        if (r17 == null) goto L59;
        if (this.b.contains(r17) == true) goto L59;
        this.b.add(r17);
    L59:
        yq();
    L103:
        IEnterProcessorService r18 = jc1.k.f(IEnterProcessorService.class);
        if (r18 == null) goto L112;
        IInteractionBizInterceptor r19 = r18.interactionBizInterceptor();
        if (r19 == null) goto L113;
        r19.processContinueAfterWidgetLoaded();
        return;
    L113:
        return;
    L112:
        return;
    L34:
        if (y91.a.getValue().booleanValue() == false) goto L36;
    L60:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r20 = this.a;
        if (r20 == null) goto L63;
        LiveMode r21 = r20.getLiveMode();
    L65:
        if (r21 == LiveMode.MEDIA) goto L68;
        r1 = false;
    L68:
        if (r1 == true) goto L102;
        h70.b r22 = getComponentContext();
        if (r22 == null) goto L77;
        kf1.a r23 = ho1.a.k(r22);
        if (r23 == null) goto L77;
        if (this.b.contains(r23) == true) goto L77;
        this.b.add(0, r23);
    L77:
        h70.b r24 = getComponentContext();
        if (r24 == null) goto L86;
        p r25 = ho1.a.j(r24);
        if (r25 == null) goto L86;
        kf1.a r26 = r25.cf();
        if (r26 == null) goto L86;
        if (this.b.contains(r26) == true) goto L86;
        this.b.add(r26);
    L86:
        h70.b r27 = getComponentContext();
        if (r27 == null) goto L95;
        IAbilityCenter r28 = r27.a();
        if (r28 == null) goto L91;
        r2 = (com.bytedance.android.live.pkaudience.api.c) r28.getAbility(com.bytedance.android.live.pkaudience.api.c.class);
    L91:
        if (r2 == null) goto L95;
        if (this.b.contains(r2) == true) goto L95;
        this.b.add(r2);
    L95:
        h70.b r29 = getComponentContext();
        if (r29 == null) goto L102;
        kf1.a r30 = ho1.a.a(r29);
        if (r30 == null) goto L102;
        if (this.b.contains(r30) == true) goto L102;
        this.b.add(r30);
    L102:
        yq();
        goto L103
    L63:
        r21 = null;
        goto L65
    L23:
        r9 = false;
        goto L24
    L111:
        return;
    L10:
        r3 = null;
        goto L11
    L114:
        return;
    }

    public static final int xq(RoomCloseInterceptorWidget r2, kf1.a r3) {
        r2.getClass();
        Map<String, Integer> r4 = ((t1) LiveConfigSettingKeys.CLOSE_REMAIN_RULE_CONFIG.getValue()).remainPriorityMap;
        if (r4.isEmpty() == true) goto L10;
        Integer r5 = r4.get(r3.config().name());
        if (r5 != null) goto L8;
        return 0;
    L8:
        return r5.intValue();
    L10:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.room.e
    public final boolean interceptCloseRoom(Runnable r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "runnable");
        if (((t1) LiveConfigSettingKeys.CLOSE_REMAIN_RULE_CONFIG.getValue()).enablePriority == false) goto L5;
        Collections.sort(this.b, new b(this));
    L5:
        Iterator<kf1.a> r0 = this.b.iterator();
    L7:
        if (r0.hasNext() == false) goto L17;
        kf1.a r1 = r0.next();
        if (r1.qa(r4, r5) == false) goto L7;
        String r6 = r1.tag();
        ALogger.i("RoomCloseInterceptorWidget", "interceptCloseRoom by " + r6);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = ho1.a.d(getComponentContext());
        if (r7 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.e r8 = r7.wl();
        if (r8 == null) goto L23;
        r8.report("exit_action_intercepted", r6);
        return true;
    L23:
        return true;
    L22:
        return true;
    L17:
        return false;
    }
}
