package com.bytedance.android.livesdk.chatroom.ui.framework.widget.player;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.livesdk.a4;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.ui.framework.utils.f;
import com.bytedance.android.livesdk.chatroom.utils.h1;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.a11;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.PageUIContext;
import com.bytedance.android.livesdk.message.model.PullStreamUpdateMessage;
import com.bytedance.android.livesdk.message.model.ri;
import com.bytedance.android.livesdk.player.listen.ListenLiveOnlyView;
import com.bytedance.android.livesdkapi.depend.message.LiveStreamControlMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.streamcontrol.StreamControlInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import zg1.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/player/PlayerCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerCompositeWidget extends MiddlewareRoomWidget implements l, Observer<KVData> {
    public static final /* synthetic */ int f = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public int c;
    public int d;
    public final CompositeDisposable e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PlayerCompositeWidget a;
        public final /* synthetic */ String b;

        public b(PlayerCompositeWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            PlayerCompositeWidget r5 = this.a;
            String r0 = this.b;
            int r1 = PlayerCompositeWidget.f;
            r5.Aq(r0);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ALogger.e("PlayerCompositeWidget", (Throwable) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PlayerCompositeWidget a;

        public d(PlayerCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            ALogger.d("PlayerCompositeWidget", "requestStreamControl result : " + r4);
            String r0 = null;
            if (r4 == null) goto L5;
            StreamControlInfo r1 = (StreamControlInfo) ((BaseResponse) r4).data;
        L6:
            if (r1 == null) goto L12;
            PlayerCompositeWidget r2 = this.a;
            StreamControlInfo r5 = (StreamControlInfo) ((BaseResponse) r4).data;
            if (r5 == null) goto L10;
            r0 = r5.getControlParams();
        L10:
            r2.xq(r0);
            return;
        L12:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public void wq(ri r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public boolean yq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        return false;
    }

    public void zq(String r2, StreamControlInfo.ControlParams r3) {
        Intrinsics.checkNotNullParameter(r2, "controlMessage");
        Intrinsics.checkNotNullParameter(r3, "controlParams");
    }

    public PlayerCompositeWidget() {
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public void onCreate() {
        super.onCreate();
        f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        RoomContext r3 = null;
        if (((a11) a4.a.getValue()).b() == false) goto L32;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L32;
        ListenLiveStatus r1 = (ListenLiveStatus) r0.get("cmd_change_listen_live_status", new ListenLiveStatus());
        ListenLiveOnlyView r4 = r1.getListenLiveView();
        if (r4 != null) goto L10;
        r4 = new ListenLiveOnlyView(getContext(), ((Widget) this).dataCenter);
        r1.setListenLiveView(r4);
        r1.setEventHandler(r4);
        ((Widget) this).dataCenter.put("cmd_change_listen_live_status", r1);
    L10:
        if ((r4 instanceof ListenLiveOnlyView) == true) goto L12;
        r4 = null;
    L12:
        ListenLiveOnlyView r5 = r4;
        if (r5 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r2 = this.b;
        if (r2 == null) goto L17;
        View r6 = r2.ln();
    L19:
        if ((r6 instanceof ViewGroup) == true) goto L21;
        r6 = null;
    L21:
        ViewGroup r7 = (ViewGroup) r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r8 = this.a;
        if (r8 != null) goto L24;
    L25:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = this.a;
        if (r9 != null) goto L28;
    L30:
        boolean r10 = false;
    L31:
        r5.d(r7, r10);
        goto L32
    L28:
        if (r9.dg() != true) goto L30;
    L29:
        r10 = true;
        goto L31
    L24:
        if (r8.V9() == true) goto L29;
    L17:
        r6 = null;
    L32:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L37;
        Room r12 = z.o(r11);
        if (r12 == null) goto L37;
        ILivePlayerClient r13 = LivePlatformPlayerManager.a(r12.id, false);
    L38:
        MiddlewareRoomContext r14 = getMiddlewareRoomContext();
        if ((r14 instanceof RoomContext) == true) goto L41;
        r14 = null;
    L41:
        RoomContext r15 = (RoomContext) r14;
        if (r13 == null) goto L45;
        if (r15 == null) goto L45;
        r15.isStreamHorizontal().setValue(PlayerCompositeWidget$initPlayerForRoomContext$1.INSTANCE);
        r15.getLiveFrameBitmap().setValue(new PlayerCompositeWidget$initPlayerForRoomContext$2(this));
        r15.getStreamSize().setValue(PlayerCompositeWidget$initPlayerForRoomContext$3.INSTANCE);
    L45:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L50;
        vlc.d r17 = (vlc.d) r16.get("data_message_manager", null);
        if (r17 == null) goto L50;
        r17.addMessageListener(MessageType.STREAM_CONTROL_MESSAGE.getIntType(), this);
        r17.addMessageListener(MessageType.PULL_STREAM_UPDATE.getIntType(), this);
        r17.addMessageListener(MessageType.PULL_STREAM_CHANGE.getIntType(), this);
    L50:
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L53;
        r18.observe("cmd_video_orientation_changed", this, true);
    L53:
        RoomContext r19 = getMiddlewareRoomContext();
        if ((r19 instanceof RoomContext) == false) goto L57;
        r3 = r19;
    L57:
        RoomContext r20 = r3;
        if (r20 == null) goto L65;
        j r21 = r20.getPageUIContext();
        if (r21 == null) goto L66;
        Disposable r22 = n32.a.a(r21, new AnonymousClass2(this));
        if (r22 == null) goto L67;
        RxUtilKt.c(r22, this.e);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L37:
        r13 = null;
        goto L38
    }

    public void onDestroy() {
        super.onDestroy();
        f.d(this);
        h1.a r0 = h1.b;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        IVisibilityControlService r2 = h1.a.g(r1);
        if (r2 == null) goto L5;
        r2.onUnload();
    L5:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L10;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager", null);
        if (r4 == null) goto L10;
        r4.removeMessageListener(this);
    L10:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L13;
        r5.removeObserver(this);
    L13:
        this.e.dispose();
        this.a = null;
        this.b = null;
    }

    public final void Aq(String r6) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        Room r1 = z.o(r0);
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L9;
        boolean r3 = r2.hq();
    L10:
        ALogger.d("PlayerCompositeWidget", "requestStreamControl mRoom : " + r1 + ", controlParams: " + r6 + ", mIsViewValid: " + r3);
        if (r3 == false) goto L18;
        if (r1 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r6) == true) goto L20;
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).requestStreamControl(Long.valueOf(r1.id), Long.valueOf(r1.getStreamId()), r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), RxUtil.getNoOpThrowable());
        return;
    L20:
        return;
    L18:
        return;
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void Bq(k3 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.c = r2.b;
        PageUIContext r3 = PageUIContext.Companion.getContext(((Widget) this).dataCenter);
        if (r3 == null) goto L6;
        r3.getVideoBottom().setValue(Integer.valueOf(this.c));
        return;
    }

    public void onChanged(KVData r5) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() == true) goto L8;
        return;
    L8:
        if (r5 == null) goto L10;
        String r1 = r5.getKey();
    L11:
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.hashCode() == 1631824572) goto L17;
        return;
    L17:
        if (r1.equals("cmd_video_orientation_changed") == false) goto L23;
        k3 r6 = (k3) r5.getData(null);
        if (r6 == null) goto L24;
        Bq(r6);
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void onMessage(tlc.d r2) {
        if ((r2 instanceof LiveStreamControlMessage) == false) goto L6;
        xq(((LiveStreamControlMessage) r2).getControlParams());
        return;
    L6:
        if ((r2 instanceof PullStreamUpdateMessage) == false) goto L9;
        AudienceVideoResolutionManager.i((PullStreamUpdateMessage) r2, getContext());
        return;
    L9:
        if ((r2 instanceof ri) == false) goto L14;
        wq((ri) r2);
        return;
    }

    public void xq(String r7) {
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L5;
        Room r3 = z.o(r2);
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = this.a;
        if (r4 == null) goto L9;
        boolean r5 = r4.hq();
    L10:
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage controlMessage: " + r7 + ", mRoom: " + r3 + ", mIsViewValid: " + r5);
        if (r5 == false) goto L35;
        if (r3 == null) goto L36;
        if (r7 != null) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r7) == true) goto L41;
        StreamControlInfo.ControlParams r6 = (StreamControlInfo.ControlParams) GsonHelper.get().fromJson(r7, StreamControlInfo.ControlParams.class);     // Catch: Exception -> L31
        String r8 = r6.type;     // Catch: Exception -> L31
        if (r8 != null) goto L20;
    L29:
        ALogger.e("PlayerCompositeWidget", "handleStreamControlMessage no need handle controlParams: " + r6);     // Catch: Exception -> L31
        return;
    L20:
        if (yq(r8) == false) goto L29;
        ALogger.d("PlayerCompositeWidget", "handleStreamControlMessage filterRequired: " + r6.filterRequired + ", random: " + r6.random);     // Catch: Exception -> L31
        if (r6.filterRequired == false) goto L28;
        long r0 = r6.random;     // Catch: Exception -> L31
        if (r0 <= 0) goto L27;
        ((SingleSubscribeProxy) Single.timer(r0, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this, r7), c.a);     // Catch: Exception -> L31
        return;
    L27:
        Aq(r7);     // Catch: Exception -> L31
        return;
    L28:
        zq(r7, r6);     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        ALogger.e("PlayerCompositeWidget", "handleStreamControlMessage e: " + e);
        return;
    L41:
        return;
    L36:
        return;
    L35:
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
