package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.chatroom.ui.r8;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.fi1;
import com.bytedance.android.livesdk.config.hv;
import com.bytedance.android.livesdk.config.n61;
import com.bytedance.android.livesdk.config.yl;
import com.bytedance.android.livesdk.config.yy;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.message.model.k3;
import com.bytedance.android.livesdk.message.model.p4;
import com.bytedance.android.livesdk.message.model.z5;
import com.bytedance.android.livesdk.pluggableinterface.IShareGuideService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/PlatformGuideMessageServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/bl/PlatformMessageHelper$c;", "Lvlc/l;", "Lga0/c;", "Ljo1/i;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lb30/d0;", "event", "", "onEvent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformGuideMessageServiceWidget extends MiddlewareRoomWidget implements PlatformMessageHelper.c, vlc.l, ga0.c, jo1.i, Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public boolean c;
    public final int d;
    public vlc.d e;
    public ga0.a f;
    public Dialog g;
    public String h;
    public m0 i;
    public FragmentActivity j;
    public Fragment k;
    public Room l;
    public r8 m;
    public final CompositeDisposable n;
    public final a o;

    public static final class a implements Runnable {
        public final /* synthetic */ PlatformGuideMessageServiceWidget a;

        public a(PlatformGuideMessageServiceWidget r1) {
            this.a = r1;
        }

        public final void a() {
            PlatformGuideMessageServiceWidget r0 = this.a;
            Room r2 = r0.l;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = ho1.a.d(r0.getComponentContext());
            if (r3 == null) goto L7;
            if (r3.dg() != true) goto L7;
            return;
        L7:
            if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L53;
            if (r2 != null) goto L11;
        L13:
            if (r2 == null) goto L18;
            User r4 = r2.getOwner();
            if (r4 == null) goto L18;
            if (r4.isFollowing() != true) goto L18;
        L48:
            r0.xq(120000);
            return;
        L18:
            r0.yq(true);
            JSONObject r5 = new JSONObject();
            com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);     // Catch: Exception -> L40
            String r7 = "";
            if (r6.getMap().containsKey("enter_from") == false) goto L26;
            Object r8 = r6.getMap().get("enter_from");     // Catch: Exception -> L40
            if (r8 == null) goto L25;
            String r9 = r8.toString();     // Catch: Exception -> L40
        L28:
            if (r2 == null) goto L31;
            String r10 = r2.getRequestId();     // Catch: Exception -> L40
            if (r10 == null) goto L31;
        L32:
            r5.put("request_id", r10);     // Catch: Exception -> L40
            if (r2 == null) goto L38;
            String r11 = r2.getLog_pb();     // Catch: Exception -> L40
            if (r11 == null) goto L38;
            r7 = r11;
        L38:
            r5.put("log_pb", r7);     // Catch: Exception -> L40
            r5.put("enter_from", r9);     // Catch: Exception -> L40
        L42:
            com.bytedance.android.live.base.model.user.o0.a r1 = com.bytedance.android.live.base.model.user.o0.a;
            if (r2 == null) goto L47;
            User r12 = r2.getOwner();
            if (r12 == null) goto L47;
            r12.getIdStr();
        L47:
            r1.getClass();
            ((Number) n61.b.getValue()).intValue();
        L31:
            r10 = "";
            goto L32
        L25:
            r9 = null;
            goto L28
        L26:
            r9 = "";
        L40:
            e = move-exception;
            e.printStackTrace();
            goto L42
        L11:
            if (r2.isMediaRoom() != true) goto L13;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final void om() {
        Dialog r0 = this.g;
        if (r0 == null) goto L31;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isShowing() != true) goto L33;
        Dialog r1 = this.g;
        if (r1 == null) goto L26;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r1);
        goto L26
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r3 == null) goto L23;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r2.getLooper()) goto L14;
        r2.post(DialogLancet.createDismissRunnable(r1));
    L26:
        this.g = null;
        return;
    L33:
        return;
    }

    public final void wq() {
        DataContext r0 = this.dataContext;
        if ((r0 instanceof RoomContext) == true) goto L5;
        r0 = null;
    L5:
        vlc.d r1 = n3.d((RoomContext) r0);
        this.e = r1;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.FOLLOW_GUIDE.getWsMethod(), this);
    L8:
        vlc.d r2 = this.e;
        if (r2 == null) goto L11;
        r2.addMessageListener(MessageType.COMMON_GUIDE.getWsMethod(), this);
    L11:
        b r3 = new b(new PlatformGuideMessageServiceWidget$registeMessageEvent$1(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(b30.d0.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
        com.bytedance.android.livesdk.chatroom.ui.framework.a r4 = ho1.a.c(getComponentContext());
        if (r4 == null) goto L18;
        PropertyOwner r5 = r4.getLoadState();
        if (r5 == null) goto L18;
        Disposable r6 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r5, new PlatformGuideMessageServiceWidget$registeMessageEvent$2(this));
        if (r6 == null) goto L18;
        RxUtilKt.c(r6, this.n);
    L18:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L22;
        r7.observe("cmd_effect_start", this);
        return;
    }

    public PlatformGuideMessageServiceWidget() {
        this.d = 200;
        this.n = new CompositeDisposable();
        this.o = new a(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        FragmentActivity r2 = r0.p0();
    L6:
        this.j = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 == null) goto L9;
        Fragment r4 = r3.getFragment();
    L10:
        this.k = r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = this.a;
        if (r5 == null) goto L13;
        Room r6 = r5.getRoom();
    L14:
        this.l = r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = this.a;
        if (r7 == null) goto L19;
        Bundle r8 = r7.Wl();
        if (r8 == null) goto L19;
        r1 = r8.getString("live.intent.extra.ENTER_LIVE_SOURCE", "");
    L19:
        this.h = r1;
        PlatformMessageHelper.INSTANCE.start(this);
        h70.b r9 = getComponentContext();
        if (r9 == null) goto L22;
        ho1.a.p(r9, jo1.i.class, this);
    L22:
        this.i = new m0(this, Looper.getMainLooper());
        wq();
        return;
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        PlatformMessageHelper.INSTANCE.stop();
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.q(r0, jo1.i.class);
    L5:
        vlc.d r1 = this.e;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L11;
        r2.removeObserver(this);
    L11:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L17;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager", null);
        if (r4 == null) goto L17;
        r4.removeMessageListener(this);
    L17:
        if (this.n.isDisposed() == true) goto L19;
        this.n.dispose();
    L19:
        ga0.a r5 = this.f;
        if (r5 == null) goto L22;
        r5.detachView();
    L22:
        m0 r6 = this.i;
        if (r6 == null) goto L25;
        r6.removeCallbacksAndMessages(null);
    L25:
        this.i = null;
        yq(false);
        this.a = null;
        this.b = null;
    }

    public final void AS(BaseMessage r7) {
        if (r7 != null) goto L5;
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L5:
        qo1.a r1 = null;
        if (yl.a.getValue().booleanValue() == true) goto L18;
        if ((r7 instanceof com.bytedance.android.livesdk.message.model.n3) == false) goto L18;
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L14;
        IAbilityCenter r2 = r0.a();
        if (r2 == null) goto L14;
        qo1.b r3 = (qo1.b) r2.getAbility(qo1.b.class);
    L15:
        if (r3 == null) goto L18;
        r3.M9((com.bytedance.android.livesdk.message.model.n3) r7);
    L14:
        r3 = null;
    L18:
        if ((r7 instanceof p4) == false) goto L47;
        DataContext r8 = this.dataContext;
        if ((r8 instanceof RoomContext) == true) goto L22;
        r8 = null;
    L22:
        RoomContext r9 = (RoomContext) r8;
        if (r9 == null) goto L31;
        com.bytedance.live.datacontext.m r10 = r9.getCommonPopupModel();
        if (r10 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.b r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.b) r10.getValue();
        if (r11 == null) goto L31;
        if (r11.a != true) goto L31;
        return;
    L31:
        qo1.a r12 = this.dataContext;
        if ((r12 instanceof RoomContext) == false) goto L35;
        r1 = r12;
    L35:
        RoomContext r4 = (RoomContext) r1;
        if (r4 == null) goto L41;
        if (r4.isVSRoom() != true) goto L41;
        return;
    L41:
        if (this.c == true) goto L130;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r13 = this.b;
        if (r13 == null) goto L45;
        r13.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.t0);
    L45:
        this.c = true;
        return;
    L130:
        return;
    L47:
        if ((r7 instanceof z5) == false) goto L115;
        z5 r14 = (z5) r7;
        Room r5 = this.l;
        if (r5 != null) goto L51;
    L62:
        boolean r6 = false;
    L64:
        if (this.l == null) goto L67;
        if (r6 == false) goto L67;
        return;
    L67:
        int r15 = fi1.a;
        if (fi1.a.a() == false) goto L70;
        return;
    L70:
        if (fi1.a.c() == false) goto L73;
        return;
    L73:
        if (com.bytedance.android.livesdk.slideuptip.k.e() == true) goto L143;
        qo1.a r16 = this.dataContext;
        if ((r16 instanceof RoomContext) == false) goto L79;
        r1 = r16;
    L79:
        RoomContext r17 = (RoomContext) r1;
        if (r17 == null) goto L88;
        com.bytedance.live.datacontext.m r18 = r17.getCommonPopupModel();
        if (r18 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.viewmodel.b r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.b) r18.getValue();
        if (r19 == null) goto L88;
        if (r19.a != true) goto L88;
        return;
    L88:
        Room r20 = this.l;
        if (r20 == null) goto L100;
        if (r20.getRoomAuthStatus() == null) goto L100;
        Room r21 = this.l;
        if (r21 == null) goto L98;
        RoomAuthStatus r22 = r21.getRoomAuthStatus();
        if (r22 == null) goto L98;
        if (r22.getEnableGift() == true) goto L100;
    L98:
        ALogger.e("PlatformGuideMessage", "handleGuideMessage roomAuthStatus enableGift is true");
        return;
    L100:
        if (r14.getGuideType() != 1) goto L102;
    L110:
        ga0.a r23 = this.f;
        if (r23 != null) goto L113;
    L114:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L113:
        if (r23.c0(r14) != true) goto L114;
        return;
    L102:
        if (r14.getGuideType() == 3) goto L110;
        if (r14.getGuideType() != 2) goto L134;
        m0 r24 = this.i;
        if (r24 == null) goto L109;
        r24.post(this.o);
    L109:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
        return;
    L134:
        return;
    L143:
        return;
    L51:
        if (r5.isMediaRoom() != true) goto L62;
        DataContext r25 = this.dataContext;
        if ((r25 instanceof RoomContext) == true) goto L55;
        r25 = null;
    L55:
        RoomContext r26 = (RoomContext) r25;
        if (r26 == null) goto L61;
        com.bytedance.live.datacontext.i r27 = r26.isAnchor();
        if (r27 == null) goto L61;
        if (((Boolean) r27.getValue()).booleanValue() == true) goto L62;
    L61:
        r6 = true;
        goto L64
    L115:
        boolean r28 = r7 instanceof k3;
        if (r28 == false) goto L128;
        if (r28 == true) goto L119;
        r7 = null;
    L119:
        k3 r29 = (k3) r7;
        if (r29 == null) goto L138;
        h70.b r30 = getComponentContext();
        if (r30 == null) goto L126;
        IAbilityCenter r31 = r30.a();
        if (r31 == null) goto L126;
        r1 = (qo1.a) r31.getAbility(qo1.a.class);
    L126:
        if (r1 == null) goto L139;
        r1.Qf(r29);
        return;
    L139:
        return;
    L138:
        return;
    L128:
        PlatformMessageHelper.INSTANCE.onMessageFinish();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L38;
        User r1 = null;
        if (r6 == null) goto L10;
        String r7 = r6.getKey();
    L11:
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.hashCode() == 949872409) goto L17;
        return;
    L17:
        if (r7.equals("cmd_effect_start") == false) goto L34;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.a;
        if (r8 == null) goto L21;
        boolean r9 = r8.dg();
    L22:
        if (r9 == false) goto L41;
        Room r10 = this.l;
        if (r10 == null) goto L27;
        r1 = r10.getOwner();
    L27:
        IShareGuideService r2 = (IShareGuideService) com.bytedance.android.livesdk.service.l.d().b().a(IShareGuideService.class);
        if (hv.a.getValue().booleanValue() == false) goto L35;
        if (r1 == null) goto L36;
        if (r2 == null) goto L37;
        r2.notifyEffect(r1.getIdStr(), r10.id, this);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L41:
        return;
    L21:
        r9 = false;
        goto L22
    L34:
        return;
    L10:
        r7 = null;
        goto L11
    }

    public final void onEvent(b30.d0 r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.c == true) goto L10;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r0 = this.b;
        if (r0 == null) goto L9;
        j70.f r1 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r0.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.t0);
    L9:
        this.c = true;
    L10:
        Room r2 = this.l;
        if (r2 == null) goto L14;
        PlatformMessageHelper.INSTANCE.addFollowGuideMessage(r2, r3.a);
        return;
    }

    public final void onMessage(tlc.d r5) {
        if (r5 == null) goto L5;
        String r0 = r5.getMessageMethod();
        if (r0 == null) goto L5;
    L6:
        MessageType r1 = MessageType.COMMON_GUIDE;
        if (Intrinsics.areEqual(r0, r1.getWsMethod()) == false) goto L13;
        PlatformMessageHelper r2 = PlatformMessageHelper.INSTANCE;
        if ((r5 instanceof com.bytedance.android.livesdk.message.model.o0) == true) goto L11;
        r5 = null;
    L11:
        r2.add((com.bytedance.android.livesdk.message.model.o0) r5);
        return;
    L13:
        if (Intrinsics.areEqual(r0, MessageType.FOLLOW_GUIDE.getWsMethod()) == false) goto L39;
        if (this.c == true) goto L20;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r3 = this.b;
        if (r3 == null) goto L19;
        j70.f r4 = com.bytedance.android.livesdk.chatroom.ui.framework.f.a;
        r3.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.t0);
    L19:
        this.c = true;
    L20:
        Room r6 = this.l;
        if (r6 == null) goto L27;
        PlatformMessageHelper r7 = PlatformMessageHelper.INSTANCE;
        if ((r5 instanceof com.bytedance.android.livesdk.message.model.o0) == true) goto L25;
        tlc.d r8 = null;
    L26:
        r7.addFollowGuideMessage(r6, (com.bytedance.android.livesdk.message.model.o0) r8);
        goto L27
    L25:
        r8 = r5;
    L27:
        h70.b r9 = getComponentContext();
        if (r9 == null) goto L32;
        IAbilityCenter r10 = r9.a();
        if (r10 == null) goto L32;
        qo1.c r11 = (qo1.c) r10.getAbility(qo1.c.class);
    L33:
        if (r11 == null) goto L51;
        Room r12 = this.l;
        if ((r5 instanceof p4) == true) goto L37;
        r5 = null;
    L37:
        r11.Kd(r12, (p4) r5, ((Widget) this).dataCenter);
        return;
    L51:
        return;
    L32:
        r11 = null;
        goto L33
    L39:
        if (Intrinsics.areEqual(r0, MessageType.COMMON_TOAST.getWsMethod()) == false) goto L41;
    L44:
        PlatformMessageHelper r13 = PlatformMessageHelper.INSTANCE;
        if (r5 == null) goto L49;
        r13.add((com.bytedance.android.livesdk.message.model.o0) r5);
        return;
    L49:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.BaseLiveMessage");
    L41:
        if (Intrinsics.areEqual(r0, MessageType.GUIDE_MESSAGE.getWsMethod()) == true) goto L44;
        if (Intrinsics.areEqual(r0, r1.getWsMethod()) == true) goto L44;
        return;
    L5:
        r0 = "";
        goto L6
    }

    public final void xq(long r5) {
        xs2.b.a().post(new u22.j(false, 2));
        m0 r0 = this.i;
        if (r0 != null) goto L5;
    L9:
        m0 r1 = this.i;
        if (r1 == null) goto L13;
        r1.sendEmptyMessageDelayed(this.d, r5);
        return;
    L13:
        return;
    L5:
        if (r0.hasMessages(this.d) != true) goto L9;
        m0 r2 = this.i;
        if (r2 == null) goto L9;
        r2.removeMessages(this.d);
        goto L9
    }

    public final void yq(boolean r7) {
        Window r0 = null;
        if (r7 == false) goto L67;
        DiggContext.a r8 = DiggContext.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        r8.getClass();
        DiggContext r9 = DiggContext.a.a(r2);
        if (isViewValid() == false) goto L66;
        r8 r3 = this.m;
        if (r3 != null) goto L9;
    L10:
        if (r9 != null) goto L12;
    L17:
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        DataContext r10 = this.dataContext;
        if (r10 == null) goto L31;
        if ((r10 instanceof RoomContext) == true) goto L22;
        r10 = null;
    L22:
        RoomContext r11 = (RoomContext) r10;
        if (r11 == null) goto L31;
        com.bytedance.live.datacontext.m r12 = r11.getHasShownLinkFollowGuide();
        if (r12 == null) goto L31;
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L31;
        ALogger.i("follow_guide", "intercept remind follow since hasShownLinkFollowGuide");
        return;
    L31:
        if (this.m != null) goto L43;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r13 = ho1.a.d(getComponentContext());
        if (r13 != null) goto L35;
    L36:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r14 = ho1.a.d(getComponentContext());
        if (r14 != null) goto L39;
    L41:
        boolean r15 = false;
    L42:
        this.m = new r8(this.j, r15, this.l);
        goto L43
    L39:
        if (r14.V9() != true) goto L41;
    L40:
        r15 = true;
        goto L42
    L35:
        if (r13.dg() == true) goto L40;
    L43:
        r8 r16 = this.m;
        if (r16 == null) goto L46;
        r16.g = ((Widget) this).dataCenter;
    L46:
        if (r16 == null) goto L48;
        r0 = r16.getWindow();
    L48:
        if (r0 != null) goto L50;
    L56:
        int r17 = fi1.a;
        if (fi1.a.b() == true) goto L101;
        r8 r18 = this.m;
        if (r18 != null) goto L61;
    L65:
        com.bytedance.android.livesdk.log.u.l().d("livesdk_follow_popup_show", new Object[]{am2.x.class, Room.class});
        return;
    L61:
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L94;
        DialogLancet.handleBlockedDialogShow(r18);
        goto L65
    L94:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L93
    L64:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L65
    L101:
        return;
    L50:
        if (tb1.c.a == false) goto L56;
        r8 r19 = this.m;
        if (r19 == null) goto L56;
        Window r20 = r19.getWindow();
        if (r20 == null) goto L56;
        r20.setDimAmount(0.0f);
        goto L56
    L12:
        if (r9.getDiggWidget().getValue() == null) goto L17;
        u32.k r21 = (u32.k) r9.getDiggWidget().getValue();
        if (r21 == null) goto L17;
        if (r21.Eg() != true) goto L17;
        return;
    L9:
        if (r3.isShowing() != true) goto L10;
        return;
    L66:
        return;
    L67:
        r8 r22 = this.m;
        if (r22 != null) goto L70;
    L91:
        this.m = null;
        return;
    L70:
        if (r22.isShowing() != true) goto L91;
        r8 r23 = this.m;
        if (r23 == null) goto L90;
        Handler r1 = DialogLancet.resolveDialogHandler(r23);
        if (r1 != null) goto L76;
    L78:
        DialogLancet.beforeDialogDismiss(r23);
        r23.dismiss();     // Catch: Throwable -> L81 Exception -> L83
    L87:
        DialogLancet.afterDialogDismiss(r23);
        goto L90
    L83:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L81
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L81
        if (r4 == null) goto L87;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r23);
        throw th;
    L76:
        if (Looper.myLooper() == r1.getLooper()) goto L78;
        r1.post(DialogLancet.createDismissRunnable(r23));
    L90:
        ((Widget) this).dataCenter.put("cmd_start_count_authorization", Boolean.TRUE);
        goto L91
    }

    public final boolean G20(xy1.p r18, long r19, String r21, long r22) {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r1 = DiggContext.a.a(r2);
        if (r1 != null) goto L5;
    L11:
        Integer r3 = yy.a.getValue();
        Dialog r4 = null;
        if (r3 != null) goto L15;
    L16:
        Room r5 = this.l;
        if (r5 == null) goto L19;
        Map r6 = r5.anchorAbMap;
    L20:
        if (r6 != null) goto L22;
    L74:
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        if (this.l == null) goto L122;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r7 == null) goto L122;
        if (r7.isVSRoom() == false) goto L122;
        return false;
    L122:
    L116:
        th = move-exception;
        Logger.e(th.getMessage());
    L118:
        return false;
    L82:
        if (this.k != null) goto L84;
    L115:
        return false;
    L84:
        if (this.j == null) goto L115;
        IGiftServiceExternal r8 = jc1.k.f(IGiftServiceExternal.class);     // Catch: Throwable -> L116
        if (r8 == null) goto L115;
        if (r8.findLiteGiftById(r19) == null) goto L115;
        if (this.g != null) goto L97;
        IGiftServiceExternal r9 = jc1.k.f(IGiftServiceExternal.class);     // Catch: Throwable -> L116
        if (r9 == null) goto L96;
        r4 = r9.getGiftGuideDialog(this.j, this.l, TTLiveSDKContext.getHostService().h().a, r18, r19, r21, r22, this.h, ((Widget) this).dataCenter);     // Catch: Throwable -> L116
    L96:
        this.g = r4;     // Catch: Throwable -> L116
    L97:
        Dialog r10 = this.g;     // Catch: Throwable -> L116
        if (r10 == null) goto L118;
        if (r10.isShowing() == true) goto L118;
        if (com.bytedance.android.livesdk.slideuptip.k.e() == true) goto L118;
        Dialog r11 = this.g;     // Catch: Throwable -> L116
        if (r11 != null) goto L106;
    L111:
        com.bytedance.android.livesdk.f.d().a();     // Catch: Throwable -> L116
        Dialog r12 = this.g;     // Catch: Throwable -> L116
        if (r12 == null) goto L114;
        r12.setOnDismissListener(new n0(this));     // Catch: Throwable -> L116
    L114:
        return true;
    L106:
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L120;
        DialogLancet.handleBlockedDialogShow(r11);     // Catch: Throwable -> L116
        goto L111
    L120:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L119 Throwable -> L116
    L110:
        DialogLancet.beforeDialogShow(r11);     // Catch: Throwable -> L116
        r11.show();     // Catch: Throwable -> L116
        DialogLancet.afterDialogShow(r11);     // Catch: Throwable -> L116
        goto L111
    L22:
        if (r5 == null) goto L26;
        Map r13 = r5.anchorAbMap;
        if (r13 == null) goto L26;
        String r14 = (String) r13.get("gift_hide_tip");
    L27:
        if (r14 == null) goto L74;
        Room r15 = this.l;
        if (r15 == null) goto L33;
        Map r16 = r15.anchorAbMap;
        if (r16 == null) goto L33;
        String r17 = (String) r16.get("gift_hide_tip");
    L35:
        if (Intrinsics.areEqual(r17, "2") == false) goto L74;
    L37:
        if (VSDataContext.a.c(VSDataContext.Companion, ((Widget) this).dataCenter) == null) goto L60;
        VSDataContext r20 = VSDataContext.a.b(((Widget) this).dataCenter);
        if (r20 == null) goto L41;
        com.bytedance.live.datacontext.m r23 = r20.isVSVideo();
    L42:
        if (r23 == null) goto L60;
        VSDataContext r24 = VSDataContext.a.b(((Widget) this).dataCenter);
        if (r24 == null) goto L50;
        com.bytedance.live.datacontext.m r25 = r24.isVSVideo();
        if (r25 == null) goto L50;
        if (((Boolean) r25.getValue()).booleanValue() != true) goto L50;
    L71:
        boolean r26 = true;
    L72:
        if (r26 == true) goto L74;
        return false;
    L50:
        Room r27 = this.l;
        if (r27 == null) goto L53;
        RoomAuthStatus r28 = r27.getMRoomAuthStatus();
    L54:
        if (r28 == null) goto L71;
        Room r29 = this.l;
        if (r29 == null) goto L70;
        RoomAuthStatus r30 = r29.getMRoomAuthStatus();
        if (r30 == null) goto L70;
        r26 = r30.getEnableGift();
    L70:
        r26 = false;
        goto L72
    L53:
        r28 = null;
        goto L54
    L41:
        r23 = null;
    L60:
        Room r31 = this.l;
        if (r31 == null) goto L63;
        RoomAuthStatus r32 = r31.getMRoomAuthStatus();
    L64:
        if (r32 == null) goto L71;
        Room r33 = this.l;
        if (r33 == null) goto L70;
        RoomAuthStatus r34 = r33.getMRoomAuthStatus();
        if (r34 == null) goto L70;
        r26 = r34.getEnableGift();
        goto L72
    L63:
        r32 = null;
    L33:
        r17 = null;
    L26:
        r14 = null;
        goto L27
    L19:
        r6 = null;
        goto L20
    L15:
        if (r3.intValue() == 1) goto L37;
    L5:
        if (r1.getDiggWidget().getValue() == null) goto L11;
        u32.k r35 = (u32.k) r1.getDiggWidget().getValue();
        if (r35 == null) goto L11;
        if (r35.Eg() != true) goto L11;
        return false;
    }
}
