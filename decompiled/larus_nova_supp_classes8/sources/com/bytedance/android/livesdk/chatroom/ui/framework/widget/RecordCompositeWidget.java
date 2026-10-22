package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudienceRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.m2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.v3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.config.pq;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.android.livesdk.record.admin.AdminRecordManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/RecordCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/q;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData>, vlc.l, q, ILiveRecordService.RecordStatusChangeListener {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d c;
    public v3 d;
    public SlideGuideView e;
    public final CompositeDisposable f;

    public final class a implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.RecordCompositeWidget$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ltp2/c;", "p1", "", "invoke", "(Ltp2/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<tp2.c, Unit> {
        public AnonymousClass2(RecordCompositeWidget r8) {
            super(1, r8, RecordCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/record/LiveScreenRecordEvent;)V", 0);
        }

        public final void invoke(tp2.c r18) {
            Intrinsics.checkNotNullParameter(r18, "p1");
            RecordCompositeWidget r2 = (RecordCompositeWidget) ((CallableReference) this).receiver;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = r2.a;
            if (r3 == null) goto L59;
            com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = r3.Gg();
            if (r4 != null) goto L8;
            return;
        L8:
            if (r4.getRootView() == null) goto L60;
            Room r5 = r18.a;
            if (r5 == null) goto L61;
            DataCenter r6 = ((Widget) r2).dataCenter;
            if (r6 == null) goto L56;
            Room r7 = com.bytedance.android.live.core.utils.z.o(r6);
            if (r7 != null) goto L19;
            return;
        L19:
            if (r5.getRoomId() == r7.getRoomId()) goto L21;
            return;
        L21:
            if (r2.xq() == false) goto L58;
            com.bytedance.android.live.pushstream.d r8 = r3.getLiveStream();
            if (r3.V9() == false) goto L25;
        L28:
            boolean r9 = true;
        L29:
            boolean r15 = r3.dg();
            if (r8 != null) goto L32;
            boolean r10 = true;
        L33:
            if (r8 != null) goto L41;
            IBroadcastService r11 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
            if (r11 == null) goto L37;
            r11.init();
        L37:
            IPushStreamService r12 = jc1.k.f(IPushStreamService.class);
            if (r12 == null) goto L40;
            r8 = r12.getRecordLiveStream(r2.getContext());
            goto L41
        L40:
            r8 = null;
        L41:
            com.bytedance.android.live.pushstream.d r13 = r8;
            if (r13 == null) goto L63;
            xs2.b.a().post(new zg1.n1(r13, new q0(r10, r13), false, 0, r15, r18.b));
            HashMap r0 = new HashMap();
            IUser r14 = r7.author();
            if (r14 == null) goto L48;
            String r16 = r14.getIdString();
            if (r16 == null) goto L48;
        L49:
            r0.put("anchor_id", r16);
            r0.put("room_id", String.valueOf(r7.id));
            AdminRecordManager.k(r0);
            if (r9 == false) goto L52;
            String r17 = "0";
        L53:
            r0.put("room_orientation", r17);
            r0.put("enter_way", "long_press");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_pm_live_record_screen_click", r0, new Object[]{new am2.x(), Room.class});
            return;
        L52:
            r17 = "1";
        L48:
            r16 = "";
            goto L49
        L63:
            return;
        L32:
            r10 = false;
            goto L33
        L25:
            if (r3.dg() == true) goto L28;
            r9 = false;
            goto L29
        L58:
            return;
        L56:
            return;
        L61:
            return;
        L60:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((tp2.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.RecordCompositeWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/h1;", "p1", "", "invoke", "(Lzg1/h1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<zg1.h1, Unit> {
        public AnonymousClass3(RecordCompositeWidget r8) {
            super(1, r8, RecordCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LiveEvent;)V", 0);
        }

        public final void invoke(zg1.h1 r10) {
            RecordCompositeWidget r0 = (RecordCompositeWidget) ((CallableReference) this).receiver;
            r0.getClass();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.a != 26) goto L88;
            DataContext r11 = r0.getRoomContext();
            zg1.n1 r2 = null;
            if (r11 == null) goto L13;
            Intrinsics.checkNotNullParameter(r11, "$this$getRoomDataCtxExt");
            com.bytedance.android.livesdk.chatroom.o r12 = z51.a.g(r11);
            if (r12 == null) goto L13;
            com.bytedance.live.datacontext.m r13 = r12.getRoom();
            if (r13 == null) goto L13;
            IRoom r14 = (IRoom) r13.getValue();
        L15:
            if (com.bytedance.android.livesdk.chatroom.record.u.f(true, r14) == true) goto L17;
            return;
        L17:
            if (pq.a.getValue().booleanValue() == false) goto L90;
            va1.b r15 = va1.b.a.a;
            IBroadcastService r4 = (IBroadcastService) r15.a(IBroadcastService.class);
            if (r4 == null) goto L23;
            if (r4.isPlayingGame() != true) goto L23;
            return;
        L23:
            if (r0.xq() == false) goto L92;
            com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = ho1.a.i(r0.getComponentContext());
            if (r5 == null) goto L27;
            View r6 = r5.getRootView();
        L28:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = r0.a;
            if (r7 == null) goto L31;
            com.bytedance.android.live.pushstream.d r8 = r7.getLiveStream();
        L32:
            if (r6 == null) goto L93;
            f22.a.c("broadcast_has_used_long_press");
            IBroadcastService r9 = (IBroadcastService) r15.a(IBroadcastService.class);
            if (r9 == null) goto L37;
            r9.init();
        L37:
            if (r8 != null) goto L39;
            boolean r16 = true;
        L40:
            if (r8 == null) goto L42;
        L51:
            xs2.b r17 = xs2.b.a();
            if (r8 == null) goto L54;
            r2 = new zg1.n1(r8, new p0(r8, r16), "long_press");
        L54:
            r17.post(r2);
            com.bytedance.android.livesdk.chatroom.ui.framework.c r18 = r0.a;
            HashMap r3 = new HashMap();
            DataContext r19 = r0.getRoomContext();
            if (r19 == null) goto L66;
            Intrinsics.checkNotNullParameter(r19, "$this$getRoomDataCtxExt");
            com.bytedance.android.livesdk.chatroom.o r20 = z51.a.g(r19);
            if (r20 == null) goto L66;
            com.bytedance.live.datacontext.m r21 = r20.getRoom();
            if (r21 == null) goto L66;
            IRoom r22 = (IRoom) r21.getValue();
            if (r22 == null) goto L66;
            IBaseUser r23 = r22.authorFlex();
            if (r23 == null) goto L66;
            String r24 = r23.getIdString();
            if (r24 == null) goto L66;
        L67:
            r3.put("anchor_id", r24);
            DataContext r1 = r0.getRoomContext();
            if (r1 == null) goto L76;
            Intrinsics.checkNotNullParameter(r1, "$this$getRoomDataCtxExt");
            com.bytedance.android.livesdk.chatroom.o r25 = z51.a.g(r1);
            if (r25 == null) goto L76;
            com.bytedance.live.datacontext.m r26 = r25.getRoom();
            if (r26 == null) goto L76;
            IRoom r27 = (IRoom) r26.getValue();
            if (r27 == null) goto L76;
            Object r28 = Long.valueOf(r27.getId());
        L77:
            r3.put("room_id", r28.toString());
            String r29 = "1";
            r3.put("is_anchor", "1");
            r3.put("event_from", "");
            if (r18 != null) goto L80;
        L81:
            if (r18 != null) goto L83;
        L85:
            r3.put("room_orientation", r29);
            r3.put("enter_way", "long_press");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_pm_live_record_screen_click", r3, new Object[]{new am2.x(), Room.class});
            return;
        L83:
            if (r18.V9() != true) goto L85;
        L84:
            r29 = "0";
            goto L85
        L80:
            if (r18.dg() == true) goto L84;
        L76:
            r28 = "";
        L66:
            r24 = "";
            goto L67
        L42:
            if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L46;
            g00.c r110 = (g00.c) com.bytedance.android.scope.m.e.d(f00.a.b, g00.c.class);
            if (r110 == null) goto L47;
            r110.init();
        L47:
            IPushStreamService r111 = jc1.k.f(IPushStreamService.class);
            if (r111 == null) goto L50;
            r8 = r111.getRecordLiveStream(r0.getContext());
            goto L51
        L50:
            r8 = null;
            goto L51
        L46:
            ((IBroadcastService) r15.a(IBroadcastService.class)).init();
            goto L47
        L39:
            r16 = false;
            goto L40
        L93:
            return;
        L31:
            r8 = null;
            goto L32
        L27:
            r6 = null;
            goto L28
        L92:
            return;
        L90:
            return;
        L13:
            r14 = null;
            goto L15
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((zg1.h1) r1);
            return Unit.INSTANCE;
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final boolean xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
    L8:
        DataCenter r1 = getDataCenter();
        if (r1 == null) goto L18;
        IAbilityCenter r2 = com.bytedance.android.live.core.utils.a0.a(r1);
        if (r2 == null) goto L19;
        IRoomRecordService r3 = r2.getAbility(IRoomRecordService.class);
        if (r3 != null) goto L15;
        return false;
    L15:
        if (r3.isRecording() == true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L18:
        return false;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(r0, false) != true) goto L8;
        return !com.bytedance.android.livesdk.service.l.d().e().isRecording();
    }

    public final void yq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = r0.dg();
        if (r0.dg() == false) goto L8;
    L11:
        boolean r2 = true;
    L12:
        FragmentActivity r5 = r0.p0();
        com.bytedance.android.live.pushstream.d r3 = r0.getLiveStream();
        DataCenter r6 = ((Widget) this).dataCenter;
        ToolbarAudienceRecordBehavior r7 = null;
        if (r6 == null) goto L15;
        Room r8 = com.bytedance.android.live.core.utils.z.o(r6);
    L16:
        if (r1 == false) goto L23;
        if (r3 == null) goto L19;
    L22:
        boolean r4 = true;
    L24:
        if (r4 == true) goto L26;
        return;
    L26:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L37;
        if (com.bytedance.android.live.core.utils.z.e(r9, false) != true) goto L37;
        kh1.a r10 = kh1.a.a;
        if (kh1.a.d(r8) == true) goto L35;
        this.d = new v3(getContext(), r3, r8);
        g3 r11 = y3.f(((Widget) this).dataCenter);
        ToolbarButton r12 = ToolbarButton.RECORD;
        r11.k(r12, this.d);
        if (r2 == true) goto L61;
        y3.m(((Widget) this).dataCenter).k(r12, this.d);
        return;
    L61:
        return;
    L35:
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.RECORD_COMBINE, new ToolbarAnchorRecordBehavior(r5, r3));
        return;
    L37:
        if (kh1.a.a.e(r2, r8) == true) goto L41;
        this.d = new v3(getContext(), r3, r8);
        g3 r13 = y3.f(((Widget) this).dataCenter);
        ToolbarButton r14 = ToolbarButton.RECORD;
        r13.k(r14, this.d);
        y3.i(((Widget) this).dataCenter).k(ToolbarButton.RECORD_LANDSCAPE, this.d);
        if (r2 == true) goto L64;
        y3.m(((Widget) this).dataCenter).k(r14, this.d);
        return;
    L64:
        return;
    L41:
        g3 r15 = y3.f(((Widget) this).dataCenter);
        ToolbarButton r16 = ToolbarButton.RECORD_COMBINE;
        if (r5 != null) goto L44;
        ToolbarAudienceRecordBehavior r17 = null;
    L49:
        r15.k(r16, r17);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r18 = y3.i(((Widget) this).dataCenter);
        if (r5 != null) goto L52;
    L56:
        r18.k(r16, r7);
        HashMap r19 = new HashMap();
        if (r8 == null) goto L59;
        LiveMode r20 = r8.getStreamType();
        int r21 = com.bytedance.android.live.core.utils.h1.a;
        r19.put("live_type", com.bytedance.android.live.core.utils.i1.a(r20));
    L59:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_live_record_get", r19, new Object[]{Room.class, am2.x.class});
        return;
    L52:
        if (r3 != null) goto L54;
        boolean r22 = true;
    L55:
        r7 = new ToolbarAudienceRecordBehavior(r5, r2, r3, r22);
        goto L56
    L54:
        r22 = false;
        goto L55
    L44:
        if (r3 != null) goto L46;
        boolean r110 = true;
    L47:
        r17 = new ToolbarAudienceRecordBehavior(r5, r2, r3, r110);
        goto L49
    L46:
        r110 = false;
        goto L47
    L19:
        if (com.bytedance.android.livesdk.chatroom.record.u.f(true, r8) == true) goto L22;
        r4 = false;
        goto L24
    L23:
        r4 = com.bytedance.android.livesdk.chatroom.record.u.f(false, r8);
        goto L24
    L15:
        r8 = null;
        goto L16
    L8:
        if (r0.V9() == true) goto L11;
        r2 = false;
        goto L12
    }

    public RecordCompositeWidget() {
        this.f = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.c(getComponentContext());
        this.c = ho1.a.i(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        LiveMode r1 = r0.getLiveMode();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L8;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r2);
    L10:
        if (r0.dg() == false) goto L15;
        if (r1 != LiveMode.THIRD_PARTY) goto L15;
        yq();
    L23:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.a;
        if (r4 != null) goto L27;
    L43:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = this.a;
        if (r5 == null) goto L62;
        MiddlewareRoomContext r6 = getMiddlewareRoomContext();
        if ((r6 instanceof RoomContext) == true) goto L49;
        r6 = null;
    L49:
        RoomContext r7 = (RoomContext) r6;
        if (r7 == null) goto L62;
        if (r5.R7() == true) goto L62;
        Object r8 = ((h80.c) r7.getAnchorRecordEnableTempState().getValue()).a;
        if (r8 != null) goto L59;
        r8 = null;
    L59:
        Boolean r9 = (Boolean) r8;
        if (r9 == null) goto L62;
        r7.getAnchorRecordEnableTempState().setValue(h80.c.b);
        D2(r9.booleanValue());
    L62:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L65;
        r10.observe("cmd_update_admin_record", this);
    L65:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L71;
        vlc.d r12 = (vlc.d) r11.get("data_message_manager", null);
        if (r12 == null) goto L71;
        r12.addMessageListener(MessageType.ADMIN_RECORD_MESSAGE.getIntType(), this);
        r12.addMessageListener(MessageType.ADMIN_RECORD_HANDLE_RESULT_MESSAGE.getIntType(), this);
    L71:
        if (r0.R7() == false) goto L74;
        L7(tp2.c.class, new a(new AnonymousClass2(this)));
    L74:
        if (r0.dg() == false) goto L76;
        L7(zg1.h1.class, new a(new AnonymousClass3(this)));
    L76:
        FragmentActivity r13 = r0.p0();
        if (r0.R7() == false) goto L79;
        AdminRecordManager.d(((Widget) this).dataCenter, r13);
    L81:
        if (r0.dg() == false) goto L89;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r14 = this.b;
        if (r14 == null) goto L89;
        PropertyOwner r15 = r14.getLoadState();
        if (r15 == null) goto L89;
        Disposable r16 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r15, new AnonymousClass4(this));
        if (r16 == null) goto L89;
        RxUtilKt.c(r16, this.f);
    L89:
        h70.b r17 = getComponentContext();
        if (r17 == null) goto L95;
        IAbilityCenter r18 = r17.a();
        if (r18 == null) goto L96;
        r18.registerAbility(q.class, this);
        return;
    L96:
        return;
    L95:
        return;
    L79:
        AdminRecordManager.c(((Widget) this).dataCenter, r13);
        goto L81
    L27:
        if (r4.R7() == false) goto L43;
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L43;
        Room r20 = com.bytedance.android.live.core.utils.z.o(r19);
        if (r20 == null) goto L43;
        boolean r21 = r4.V9();
        FragmentActivity r22 = r4.p0();
        if (com.bytedance.android.livesdk.chatroom.record.u.e(false, r20) == false) goto L43;
        if (kh1.a.a.e(r21, r20) == true) goto L43;
        g3 r23 = y3.f(((Widget) this).dataCenter);
        ToolbarButton r24 = ToolbarButton.AUDIENCE_RECORD;
        r23.k(r24, new m2(r22, r21));
        if (r20.isMediaRoom() == true) goto L42;
        if (r21 == true) goto L42;
        y3.i(((Widget) this).dataCenter).k(r24, new m2(r22, false));
    L42:
        HashMap r25 = new HashMap();
        LiveMode r26 = r20.getStreamType();
        int r27 = com.bytedance.android.live.core.utils.h1.a;
        r25.put("live_type", com.bytedance.android.live.core.utils.i1.a(r26));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_live_record_get", r25, new Object[]{Room.class, am2.x.class});
    L15:
        if (r0.o5() == false) goto L21;
        if (r3 != null) goto L18;
    L19:
        yq();
        goto L23
    L18:
        if (r3.isMediaRoom() != true) goto L19;
    L21:
        if (r0.V9() == false) goto L23;
        yq();
        goto L23
    L8:
        r3 = null;
        goto L10
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(q.class);
    L7:
        this.f.dispose();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.removeObserver(this);
    L10:
        MiddlewareRoomContext r3 = getMiddlewareRoomContext();
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.j r4 = r3.getMessageManager();
        if (r4 == null) goto L17;
        vlc.d r5 = (vlc.d) r4.getValue();
        if (r5 == null) goto L17;
        r5.removeMessageListener(this);
    L17:
        this.d = null;
        this.e = null;
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public final void onPause() {
        super.onPause();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.o5() != true) goto L13;
        IAbilityCenter r1 = com.bytedance.android.live.core.utils.a0.b(((Widget) this).dataCenter);
        if (r1 == null) goto L14;
        ISessionRecordService r2 = r1.getAbility(ISessionRecordService.class);
        if (r2 == null) goto L15;
        r2.removeRecordStatsChangeListener(this);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onResume() {
        super.onResume();
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.o5() != true) goto L13;
        IAbilityCenter r1 = com.bytedance.android.live.core.utils.a0.b(((Widget) this).dataCenter);
        if (r1 == null) goto L14;
        ISessionRecordService r2 = r1.getAbility(ISessionRecordService.class);
        if (r2 == null) goto L15;
        r2.addRecordStatsChangeListener(this);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static final void wq(RecordCompositeWidget r2) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = r2.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L18;
        SlideGuideView r1 = r2.e;
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = r2.c;
        if (r3 == null) goto L12;
        r3.bk(r1);
    L12:
        com.bytedance.android.livesdk.e.b().d();
        SlideGuideView r4 = r2.e;
        if (r4 == null) goto L15;
        r4.b();
    L15:
        r2.e = null;
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.q
    public final void D2(boolean r3) {
        if (r3 == false) goto L5;
        yq();
        return;
    L5:
        if (this.d == null) goto L9;
        y3.f(((Widget) this).dataCenter).d(ToolbarButton.RECORD, this.d);
        this.d = null;
        return;
    }

    public final void onChange(ILiveRecordService.RecordStatus r6) {
        Intrinsics.checkNotNullParameter(r6, "recording");
        com.bytedance.android.livesdk.chatroom.widget.landscape.u r0 = ho1.a.h(getComponentContext());
        if (r0 != null) goto L5;
        return;
    L5:
        ILiveRecordService.RecordStatus r1 = ILiveRecordService.RecordStatus.READY;
        if (r6 != r1) goto L9;
        r0.setVisibility(false);
    L11:
        if (r6 != r1) goto L13;
    L16:
        r0.qb();
        r0.Lm(false);
        return;
    L13:
        if (r6 == ILiveRecordService.RecordStatus.RECORDING) goto L16;
        r0.Lm(true);
        r0.Hj();
        return;
    L9:
        if (r6 != ILiveRecordService.RecordStatus.RECORDING) goto L11;
        r0.setVisibility(true);
        goto L11
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.R7() != true) goto L21;
        if (r4 == null) goto L9;
        String r5 = r4.getKey();
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.hashCode() == 473861234) goto L16;
        return;
    L16:
        if (r5.equals("cmd_update_admin_record") == false) goto L20;
        yq();
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L10
    }

    public final void onMessage(tlc.d r4) {
        py.m r1 = null;
        if ((r4 instanceof com.bytedance.android.livesdk.message.model.o0) == true) goto L5;
        tlc.d r0 = null;
    L6:
        com.bytedance.android.livesdk.message.model.o0 r2 = (com.bytedance.android.livesdk.message.model.o0) r0;
        if (r2 == null) goto L9;
        py.m r3 = r2.getMessageType();
    L11:
        if ((r3 instanceof MessageType) == false) goto L14;
        r1 = r3;
    L14:
        MessageType r5 = (MessageType) r1;
        if (r5 == null) goto L26;
        int r6 = o0.a[r5.ordinal()];
        if (r6 != 1) goto L20;
        AdminRecordManager.g((com.bytedance.android.livesdk.message.model.o0) r4, this);
        return;
    L20:
        if (r6 != 2) goto L27;
        AdminRecordManager.f((com.bytedance.android.livesdk.message.model.o0) r4);
        return;
    L27:
        return;
    L26:
        return;
    L9:
        r3 = null;
        goto L11
    L5:
        r0 = r4;
        goto L6
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}
