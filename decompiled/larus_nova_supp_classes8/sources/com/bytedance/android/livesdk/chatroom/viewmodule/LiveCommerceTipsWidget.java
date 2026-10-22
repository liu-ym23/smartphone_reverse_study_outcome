package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.config.tl;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/LiveCommerceTipsWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "Lc42/a;", "event", "", "onEvent", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommerceTipsWidget extends LiveRecyclableWidget implements Observer<KVData>, vlc.l {
    public static final a c = null;
    public boolean a;
    public final CompositeDisposable b;

    public static final class a {
        public a() {
        }

        public static boolean a(DataCenter r3) {
            if (r3 != null) goto L5;
            return true;
        L5:
            String r4 = (String) r3.get("data_commerce_task_id", "");
            if (r4.length() <= 0) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L14;
            HashMap r0 = (HashMap) com.bytedance.android.livesdk.sharedpref.b.M2.getValue();
            LiveCommerceTipsWidget.c.getClass();
            List r2 = (List) r0.get(TTLiveSDKContext.getHostService().h().n());
            if (r2 != null) goto L13;
            return false;
        L13:
            return r2.contains(r4);
        L14:
            return true;
        L8:
            r1 = false;
            goto L9
        }

        public static boolean b(ik r1) {
            if (((com.bytedance.android.livesdk.message.model.o0) r1).isLocalInsertMsg2 == false) goto L13;
            CommonMessageData r2 = ((BaseMessage) r1).baseMessage;
            if (r2 == null) goto L9;
            Text r3 = r2.getDisplayText();
            if (r3 == null) goto L9;
            String r4 = r3.getDefaultPattern();
        L11:
            if (Intrinsics.areEqual(r4, tl.a.getValue().b()) == false) goto L13;
            return true;
        L9:
            r4 = null;
        L13:
            return false;
        }

        public static boolean c(DataCenter r6) {
            if (r6 != null) goto L6;
            return false;
        L6:
            if (tl.a.getValue().c() != 1) goto L8;
            boolean r1 = true;
        L9:
            boolean r3 = TTLiveSDKContext.getHostService().h().isLogin();
            Boolean r4 = (Boolean) r6.get("from_promote_live", Boolean.FALSE);
            boolean r7 = a(r6);
            if (r1 == false) goto L17;
            if (r3 == true) goto L13;
            return false;
        L13:
            if (r4.booleanValue() == false) goto L19;
            if (r7 == true) goto L20;
            return true;
        L20:
            return false;
        L19:
            return false;
        L17:
            return false;
        L8:
            r1 = false;
            goto L9
        }

        public static void d(ik r6, DataCenter r7) {
            if (r6 != null) goto L4;
            return;
        L4:
            if (r7 != null) goto L7;
            return;
        L7:
            if (b(r6) == true) goto L9;
            return;
        L9:
            if (a(r7) == true) goto L25;
            String r1 = (String) r7.get("data_commerce_task_id", "");
            if (r1.length() <= 0) goto L13;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L19;
            com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.M2;
            HashMap r4 = (HashMap) r3.getValue();
            List r5 = (List) r4.get(TTLiveSDKContext.getHostService().h().n());
            if (r5 != null) goto L18;
            r5 = new ArrayList();
        L18:
            r5.add(r1);
            r4.put(TTLiveSDKContext.getHostService().h().n(), r5);
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        L19:
            HashMap r8 = new HashMap();
            r8.put("room_id", String.valueOf(((Number) r7.get("data_room_id", 0)).intValue()));
            r8.put("enter_method", "top_message");
            Room r9 = (Room) r7.get("data_room", null);
            if (r9 == null) goto L22;
            LiveMode r10 = r9.getStreamType();
            int r11 = com.bytedance.android.live.core.utils.h1.a;
            r8.put("live_type", com.bytedance.android.live.core.utils.i1.a(r10));
            r8.put("anchor_id", r9.getOwnerUserIdString());
        L22:
            r8.put("task_id", r7.get("data_commerce_task_id", ""));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_task_top_message_show", r8, new Object[0]);
            return;
        L13:
            r2 = false;
            goto L14
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveCommerceTipsWidget a;

        public b(LiveCommerceTipsWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LiveCommerceTipsWidget r0 = this.a;
            r0.a = ((zg1.o2) r2).a;
        }
    }

    public final class c implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.LiveCommerceTipsWidget$onLoad$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lc42/a;", "p1", "", "invoke", "(Lc42/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<c42.a, Unit> {
        public AnonymousClass2(LiveCommerceTipsWidget r8) {
            super(1, r8, LiveCommerceTipsWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/interactivity/api/notifies/OnNotifyShowEvent;)V", 0);
        }

        public final void invoke(c42.a r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            LiveCommerceTipsWidget.wq((LiveCommerceTipsWidget) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((c42.a) r1);
            return Unit.INSTANCE;
        }
    }

    public final void onInit(Object[] r1) {
    }

    static {
        c = new a();
    }

    public LiveCommerceTipsWidget() {
        this.b = new CompositeDisposable();
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (this.b.isDisposed() == true) goto L5;
        this.b.dispose();
        this.b.clear();
    L5:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.removeObserver(this);
    L8:
        DataCenter r1 = ((Widget) this).dataCenter;
        vlc.d r2 = null;
        if (r1 == null) goto L11;
        r2 = (vlc.d) r1.get("data_message_manager", null);
    L11:
        if (r2 == null) goto L14;
        r2.removeMessageListener(this);
        return;
    }

    private final void onEvent(c42.a r3) {
        a r0 = c;
        ik r4 = r3.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        a.d(r4, r1);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L16;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-1379241172)) goto L9;
        return;
    L9:
        if (r5.equals("cmd_commerce_record_save") == true) goto L11;
        return;
    L11:
        if (this.b.isDisposed() == true) goto L15;
        this.b.dispose();
        this.b.clear();
        return;
    L15:
        return;
    }

    public final void onLoad(Object[] r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L5;
        r5.observe("cmd_commerce_record_save", this);
    L5:
        DataCenter r6 = ((Widget) this).dataCenter;
        vlc.d r0 = null;
        if (r6 == null) goto L8;
        r0 = (vlc.d) r6.get("data_message_manager", null);
    L8:
        if (r0 == null) goto L10;
        r0.addMessageListener(MessageType.ROOM_NOTIFY.getIntType(), this);
    L10:
        Disposable r7 = RxBusAbility.INSTANCE.getRxBus(com.bytedance.android.live.core.utils.a0.p(((Widget) this).dataCenter)).b(zg1.o2.class).subscribe(new b(this));
        if (r7 == null) goto L13;
        RxUtilKt.c(r7, this.b);
    L13:
        CompositeDisposable r8 = this.b;
        c.getClass();
        r8.add(((SingleSubscribeProxy) Single.timer(tl.a.getValue().a(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new t1(this), u1.a));
        if (ho1.a.o(getComponentContext()) == false) goto L17;
        c r1 = new c(new AnonymousClass2(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(c42.a.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r1);
        return;
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof ik) == false) goto L12;
        c.getClass();
        if (a.b((ik) r2) == true) goto L9;
        return;
    L9:
        if (a.a(((Widget) this).dataCenter) == true) goto L14;
        ALogger.w("LiveCommerceTipsWidget", "commerce tips msg has received");
        return;
    L14:
        return;
    }

    public static final /* synthetic */ void wq(LiveCommerceTipsWidget r0, c42.a r1) {
        r0.onEvent(r1);
    }
}
