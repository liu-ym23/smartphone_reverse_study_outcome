package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/UserCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserCompositeWidget extends MiddlewareRoomWidget implements vlc.l {
    public static final /* synthetic */ int f = 0;
    public User a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public boolean d;
    public final CompositeDisposable e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.UserCompositeWidget$onCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ UserCompositeWidget a;

        public AnonymousClass1(UserCompositeWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UserCompositeWidget r0 = this.a;     // Catch: Throwable -> L10
            int r1 = UserCompositeWidget.f;     // Catch: Throwable -> L10
            RoomContext r2 = r0.getMiddlewareRoomContext();     // Catch: Throwable -> L10
            if (r2 == null) goto L13;
            com.bytedance.live.datacontext.j r3 = r2.getUserContext();     // Catch: Throwable -> L10
            if (r3 == null) goto L17;
            Disposable r4 = n32.a.a(r3, new C00171(this));     // Catch: Throwable -> L10
            if (r4 == null) goto L18;
            RxUtilKt.c(r4, this.a.e);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.widget.UserCompositeWidget$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/k1;", "p1", "", "invoke", "(Lzg1/k1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<zg1.k1, Unit> {
        public AnonymousClass3(UserCompositeWidget r8) {
            super(1, r8, UserCompositeWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LiveLoginEvent;)V", 0);
        }

        public final void invoke(zg1.k1 r6) {
            UserCompositeWidget r0 = (UserCompositeWidget) ((CallableReference) this).receiver;
            int r1 = UserCompositeWidget.f;
            Room r2 = null;
            if (r6 == null) goto L24;
            r0.getClass();
            if (r6.a != true) goto L24;
            if (r0.d == true) goto L24;
            UnLoginFeatureUtils r3 = UnLoginFeatureUtils.INSTANCE;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = r0.b;
            if (r4 == null) goto L11;
            Room r5 = r4.getRoom();
        L13:
            if (r3.restartWhenLogin(r5) == false) goto L24;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = r0.b;
            if (r7 == null) goto L17;
            Bundle r8 = r7.Wl();
        L18:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = r0.b;
            if (r9 == null) goto L21;
            r2 = r9.getRoom();
        L21:
            if (r8 == null) goto L38;
            if (r2 == null) goto L39;
            r8.putBoolean("live_reenter_room", true);
            r8.putBoolean("finish_current_activity", true);
            TTLiveSDK.hostService().action().startLive(r0.getContext(), r2.id, r8);
            return;
        L39:
            return;
        L38:
            return;
        L17:
            r8 = null;
            goto L18
        L11:
            r5 = null;
        L24:
            ((Widget) r0).dataCenter.put("data_login_event", r6);
            if (r6 == null) goto L27;
            r2 = r6.b;
        L27:
            if (r2 == null) goto L41;
            StringBuilder r10 = new StringBuilder("loginInRoom, ");
            String r11 = "succ: ";
            if (r6.a == false) goto L31;
            String r12 = "succ: ";
        L32:
            r10.append(r12);
            r10.append(r6.b.getIdString());
            ALogger.d("UserCompositeWidget", r10.toString());
            xs2.b r13 = xs2.b.a();
            if (r6.a == true) goto L36;
            r11 = "fail: " + r6.b.getIdString();
        L36:
            r13.post(new zg1.h("login", r11));
            return;
        L31:
            r12 = "fail: ";
            goto L32
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((zg1.k1) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public UserCompositeWidget() {
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.b = ho1.a.d(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        this.d = TTLiveSDKContext.getHostService().h().isLogin();
        int r0 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.e, "UserCompositeWidget", new AnonymousClass1(this));
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L7;
        vlc.d r2 = (vlc.d) r1.get("data_message_manager", null);
        if (r2 == null) goto L7;
        r2.addMessageListener(MessageType.MEMBER.getIntType(), this);
    L7:
        L7(zg1.k1.class, new AnonymousClass4.a(new AnonymousClass3(this)));
        com.bytedance.android.livesdk.chatroom.ui.framework.a r3 = this.c;
        if (r3 == null) goto L15;
        PropertyOwner r4 = r3.getLoadState();
        if (r4 == null) goto L16;
        Disposable r5 = com.bytedance.android.livesdk.chatroom.ui.framework.b.f(r4, new AnonymousClass4(this));
        if (r5 == null) goto L17;
        RxUtilKt.c(r5, this.e);
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.e.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(this);
    L7:
        this.b = null;
        this.a = null;
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof MemberMessage) == false) goto L23;
        MemberMessage r7 = (MemberMessage) r6;
        if (r7.getAction() != 6) goto L25;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L24;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 != null) goto L13;
        return;
    L13:
        if (r7.isCurrentRoom(r1.id) == false) goto L27;
        User r8 = r7.getUser();
        if (r8 == null) goto L28;
        com.bytedance.android.live.base.model.user.o0.a r2 = com.bytedance.android.live.base.model.user.o0.a;
        String r9 = r8.getIdStr();
        String r3 = TTLiveSDKContext.getHostService().h().n();
        r2.getClass();
        if (com.bytedance.android.live.base.model.user.o0.a.a(r9, r3) == false) goto L29;
        ((Widget) this).dataCenter.put("data_interact_number_dot_show", "");
        ((Widget) this).dataCenter.put("data_audio_talk_dot_with_number_show", "");
        ((Widget) this).dataCenter.put("data_video_talk_dot_with_number_show", "");
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L24:
        return;
    L25:
        return;
    }

    public final void wq(String r1) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.b;
        if (r2 == null) goto L5;
        boolean r3 = r2.dg();
    L6:
        if (r3 == false) goto L13;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.b;
        if (r4 == null) goto L14;
        nz.r r5 = ho1.b.a(r4);
        if (r5 == null) goto L15;
        r5.d();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }
}
