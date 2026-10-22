package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.ShareReportResult;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.w5;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
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
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/ShareCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareCompositeWidget extends MiddlewareRoomWidget implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int h = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.behavior.a b;
    public e5 c;
    public long d;
    public boolean e;
    public boolean f;
    public final CompositeDisposable g;

    public static final class a {
    }

    public static final class b implements w5 {
        public final /* synthetic */ ShareCompositeWidget a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.w5
        public final boolean a() {
            h70.b r0 = this.a.getComponentContext();
            if (r0 == null) goto L7;
            IAbilityCenter r1 = r0.a();
            if (r1 == null) goto L7;
            com.bytedance.android.livesdk.vipim.a r2 = (com.bytedance.android.livesdk.vipim.a) r1.getAbility(com.bytedance.android.livesdk.vipim.a.class);
        L8:
            if (r2 != null) goto L12;
            return false;
        L12:
            return r2.Nn();
        L7:
            r2 = null;
            goto L8
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.w5
        public final String getSchema() {
            h70.b r0 = this.a.getComponentContext();
            if (r0 == null) goto L7;
            IAbilityCenter r1 = r0.a();
            if (r1 == null) goto L7;
            com.bytedance.android.livesdk.vipim.a r2 = (com.bytedance.android.livesdk.vipim.a) r1.getAbility(com.bytedance.android.livesdk.vipim.a.class);
        L8:
            if (r2 == null) goto L11;
            String r3 = r2.getSchema();
            if (r3 == null) goto L11;
            return r3;
        L11:
            return "";
        L7:
            r2 = null;
            goto L8
        }

        public b(ShareCompositeWidget r1) {
            this.a = r1;
        }
    }

    public static final class c implements ToolbarComponentCheckInterface {
        public final /* synthetic */ ShareCompositeWidget a;
        public final /* synthetic */ Room b;

        public c(ShareCompositeWidget r1, Room r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            if (tb1.c.a == true) goto L5;
        L11:
            r2.setExtraDataAfterCheck(this.a.c);
            r3.invoke();
            return true;
        L5:
            if (this.a.e == true) goto L11;
            if (ShareCompositeWidget.Aq(this.b) == true) goto L10;
            r4.invoke("share room auth disable");
            return true;
        L10:
            r4.invoke("share in landscape");
            return true;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ShareCompositeWidget a;

        public d(ShareCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            h80.c r3 = (h80.c) r2;
            ShareCompositeWidget r4 = this.a;
            int r0 = ShareCompositeWidget.h;
            r4.Bq();
        }
    }

    static {
    }

    public final void yq() {
        if (((Boolean) h21.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f == false) goto L8;
        return;
    L8:
        ALogger.d("NewToolbarLog", "compactLoadShareEnterRoom");
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L11;
        return;
    L11:
        DataCenter r1 = ((Widget) this).dataCenter;
        LiveToolbarData r2 = null;
        if (r1 == null) goto L14;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r1);
    L16:
        if (Aq(r3) == true) goto L18;
        return;
    L18:
        if (tb1.c.a == true) goto L20;
    L21:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L24;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r5);
    L25:
        r4.getClass();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.g(r6) == false) goto L28;
        ALogger.d("NewToolbarLog", "enter load share in toolbar");
        y3.m(((Widget) this).dataCenter).k(ToolbarButton.SHARE, this.c);
        return;
    L28:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L31;
        Room r8 = com.bytedance.android.live.core.utils.z.o(r7);
    L33:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.e(r8) == false) goto L35;
        ALogger.d("NewToolbarLog", "enter load share in more");
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.SHARE, this.c);
        return;
    L35:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L40;
        Room r10 = com.bytedance.android.live.core.utils.z.o(r9);
        if (r10 == null) goto L40;
        r2 = r10.getToolbarData();
    L40:
        if (r2 != null) goto L47;
        ALogger.d("NewToolbarLog", "enter room with null toolbar data");
        return;
    L47:
        return;
    L31:
        r8 = null;
        goto L33
    L24:
        r6 = null;
        goto L25
    L20:
        if (this.e == true) goto L21;
        return;
    L14:
        r3 = null;
        goto L16
    }

    public ShareCompositeWidget() {
        this.e = true;
        this.g = new CompositeDisposable();
    }

    public final void Bq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.user.f r5 = TTLiveSDKContext.getHostService().h();
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r1);
    L9:
        FragmentActivity r4 = r0.p0();
        DataContext r3 = this.dataContext;
        if ((r3 instanceof RoomContext) == true) goto L12;
        r3 = null;
    L12:
        e5 r6 = new e5(getContext(), r4, r5, (RoomContext) r3, ((Widget) this).dataCenter);
        this.c = r6;
        r6.q = new b(this);
        SettingKey<Boolean> r7 = h21.a;
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L19;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L17;
        Lazy r8 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(((Widget) this).dataCenter, NewToolbarButtonConstants.ToolbarShare.INSTANCE, new c(this, r2));
        goto L19
    L17:
        yq();
    L19:
        if (Aq(r2) == true) goto L21;
        return;
    L21:
        if (tb1.c.a == false) goto L25;
        if (this.e == true) goto L25;
        return;
    L25:
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L27;
    L28:
        y3.b(((Widget) this).dataCenter).k(ToolbarButton.SHARE, this.c);
    L29:
        DataCenter r9 = ((Widget) this).dataCenter;
        Boolean r10 = Boolean.FALSE;
        if (((Boolean) r9.get("data_pending_show_share_dialog", r10)).booleanValue() == false) goto L38;
        e5 r11 = this.c;
        if (r11 == null) goto L34;
        r11.onClick(null);
    L34:
        ((Widget) this).dataCenter.put("data_pending_show_share_dialog", r10);
        return;
    L38:
        return;
    L27:
        if (this.f == false) goto L29;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        this.a = r0;
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r2 = r0.isPortrait();
    L6:
        this.e = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 != null) goto L9;
    L11:
        r1 = false;
    L12:
        this.f = r1;
        Bq();
        com.bytedance.android.livesdk.chatroom.ui.framework.a r4 = ho1.a.c(getComponentContext());
        if (r4 == null) goto L19;
        PropertyOwner r5 = r4.Na();
        if (r5 == null) goto L19;
        Disposable r6 = r5.subscribe(new d(this));
        if (r6 == null) goto L19;
        RxUtilKt.c(r6, this.g);
    L19:
        runWithRoomEntered(new AnonymousClass2(this));
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = ho1.a.d(getComponentContext());
        if (r7 != null) goto L23;
    L41:
        int r8 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(((Widget) this).dataCenter, this.g, "ShareCompositeWidget#Register", new AnonymousClass3(this));
        ((Widget) this).dataCenter.observe("cmd_media_room_hide_share", this);
        if (com.bytedance.android.livesdk.config.setting.s.a() == true) goto L44;
        return;
    L44:
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L50;
        vlc.d r9 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r9 == null) goto L51;
        r9.addMessageListener(MessageType.TOOLBAR_CONTROL_MESSAGE.getIntType(), this);
        return;
    L51:
        return;
    L50:
        return;
    L23:
        if (r7.o5() == false) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r10 = y3.i(((Widget) this).dataCenter);
        FragmentActivity r11 = r7.p0();
        com.bytedance.android.livesdk.user.f0 r12 = TTLiveSDKContext.getHostService().h();
        IUser r13 = r12.a;
        if ((r13 instanceof User) == true) goto L28;
        r13 = null;
    L28:
        User r14 = (User) r13;
        DataContext r15 = this.dataContext;
        if ((r15 instanceof RoomContext) == true) goto L31;
        r15 = null;
    L31:
        RoomContext r16 = (RoomContext) r15;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L34;
        Room r18 = com.bytedance.android.live.core.utils.z.o(r17);
    L35:
        Context r19 = getContext();
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L38;
        String r21 = (String) r20.get("data_member_count_str", "");
    L38:
        this.b = new com.bytedance.android.livesdk.chatroom.ui.behavior.a(r19, r18, r11, r12, ((Widget) this).dataCenter, r16);
        if (Aq(r18) == false) goto L41;
        r10.k(ToolbarButton.SHARE, this.b);
        goto L41
    L34:
        r18 = null;
        goto L35
    L9:
        if (r3.dg() != true) goto L11;
    L5:
        r2 = true;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).post(new z2(true));
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.g.dispose();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        MiddlewareRoomContext r1 = getMiddlewareRoomContext();
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r1.getMessageManager();
        if (r2 == null) goto L12;
        vlc.d r3 = (vlc.d) r2.getValue();
        if (r3 == null) goto L12;
        r3.removeMessageListener(this);
    L12:
        this.b = null;
        this.c = null;
        this.a = null;
        if (((LiveMemLeakConfig) com.bytedance.android.livesdk.j1.a.getValue()).getFixShareCompositeWidgetCallback() == false) goto L16;
        ((Widget) this).widgetCallback = null;
        return;
    }

    public static boolean Aq(Room r1) {
        if (r1 == null) goto L11;
        RoomAuthStatus r2 = r1.getMRoomAuthStatus();
        if (r2 != null) goto L7;
        return true;
    L7:
        if (r2.isDisableShare() != true) goto L13;
        return false;
    L13:
        return true;
    L11:
        return true;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.V9() != true) goto L45;
        if (r6 == null) goto L9;
        String r1 = r6.getKey();
    L10:
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.hashCode() == 1555668198) goto L16;
        return;
    L16:
        if (r1.equals("cmd_media_room_hide_share") == false) goto L41;
        Boolean r7 = (Boolean) r6.getData();
        if (r7 == null) goto L42;
        r7.booleanValue();
        boolean r2 = r7.booleanValue();
        RoomAuthStatus r3 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter).getRoomAuthStatus();
        if (r2 == false) goto L22;
        long r4 = 2;
    L23:
        r3.setShowShare(r4);
        if (this.f == false) goto L26;
    L34:
        boolean r8 = r7.booleanValue();
        if (this.b == null) goto L43;
        if (r8 == false) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r9 = y3.i(((Widget) this).dataCenter);
        ToolbarButton r10 = ToolbarButton.SHARE;
        r9.i(r10.extended());
        y3.i(((Widget) this).dataCenter).d(r10, this.b);
        return;
    L38:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r11 = y3.i(((Widget) this).dataCenter);
        ToolbarButton r12 = ToolbarButton.SHARE;
        r11.k(r12, this.b);
        y3.i(((Widget) this).dataCenter).c(r12.extended());
        return;
    L43:
        return;
    L26:
        if (this.c == null) goto L34;
        if (((Boolean) h21.a.getValue()).booleanValue() == true) goto L34;
        if (r2 == false) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r13 = y3.b(((Widget) this).dataCenter);
        ToolbarButton r14 = ToolbarButton.SHARE;
        r13.i(r14.extended());
        y3.b(((Widget) this).dataCenter).d(r14, this.c);
        goto L34
    L33:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r15 = y3.b(((Widget) this).dataCenter);
        ToolbarButton r16 = ToolbarButton.SHARE;
        r15.k(r16, this.c);
        y3.b(((Widget) this).dataCenter).c(r16.extended());
        goto L34
    L22:
        r4 = 1;
        goto L23
    L42:
        return;
    L41:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof dm) == false) goto L27;
        dm r6 = (dm) r5;
        ALogger.d("NewToolbarLog", "compactLoad");
        if (r6.getComponentType() != 20) goto L28;
        ALogger.d("NewToolbarLog", "compactLoadShare");
        if (r6.getEventType() == 1) goto L23;
        if (r6.getEventType() == 3) goto L23;
        if (r6.getEventType() != 2) goto L14;
    L21:
        ALogger.d("NewToolbarLog", "remove share by msg");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r7 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r0 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter);
        r7.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.f(r0);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r8 = y3.b(((Widget) this).dataCenter);
        ToolbarButton r1 = ToolbarButton.SHARE;
        r8.i(r1.extended());
        y3.b(((Widget) this).dataCenter).d(r1, this.c);
        return;
    L14:
        if (r6.getEventType() == 4) goto L21;
        if (r6.getEventType() == 5) goto L19;
        return;
    L19:
        if (this.c == null) goto L30;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r9 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.c0.a(r6);
        e5 r2 = this.c;
        Intrinsics.checkNotNull(r2);
        r2.Mr(r9);
        return;
    L30:
        return;
    L23:
        if (r6.getOpType() != 0) goto L25;
        ALogger.d("NewToolbarLog", "load share to toolbar by msg");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r4 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter);
        r3.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.b(r4, r6, true);
        y3.m(((Widget) this).dataCenter).k(ToolbarButton.SHARE, this.c);
        return;
    L25:
        ALogger.d("NewToolbarLog", "load share to more by msg");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r11 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter);
        r10.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a.b(r11, r6, false);
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.SHARE, this.c);
        return;
    L28:
        return;
    }

    public final void zq(ShareReportResult r8) {
        DataCenter r0 = ((Widget) this).dataCenter;
        User r1 = null;
        if (r0 == null) goto L5;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r0);
    L6:
        User r3 = TTLiveSDKContext.getHostService().h().a;
        if ((r3 instanceof User) == false) goto L10;
        r1 = r3;
    L10:
        User r4 = r1;
        if (r8 != null) goto L13;
        return;
    L13:
        if (r8.getDeltaIntimacy() <= 0) goto L20;
        if (r2 == null) goto L21;
        vlc.d r5 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        if (r5 == null) goto L22;
        r5.j(ag1.c.e(r2.id, r8.getDisplayText(), r4), true);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void wq(ShareCompositeWidget r1, Class r2, AnonymousClass3.a r3) {
        r1.getClass();
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r1))).subscribe(r3);
    }

    public static final void xq(ShareCompositeWidget r3, long r4, String r6) {
        r3.getClass();
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.share.e.a.getClass();
        String r1 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b("chat_merge"));
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r0.put("target_id", r1);
    L5:
        String r2 = String.valueOf(1);
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.put("share_type", r2);
    L8:
        String r7 = String.valueOf(r6);
        if (TextUtils.isEmpty(r7) == true) goto L11;
        r0.put("common_label_list", r7);
    L11:
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r5 = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r4, r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new c1(r3), RxUtil.getNoOpThrowable());
        r3.g.add(r5);
    }
}
