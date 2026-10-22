package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Configuration;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.vx0;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.VsScheduleMessage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/VSLiveCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLiveCompositeWidget extends MiddlewareRoomWidget implements vlc.l {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public final CompositeDisposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ VSLiveCompositeWidget a;

        public a(VSLiveCompositeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            VSLiveCompositeWidget r0 = this.a;
            Configuration r5 = ((n.a) ((h80.c) r4).a()).a;
            MiddlewareRoomContext r6 = r0.getMiddlewareRoomContext();
            Integer r2 = null;
            if ((r6 instanceof RoomContext) == true) goto L5;
            r6 = null;
        L5:
            RoomContext r7 = (RoomContext) r6;
            if (r7 != null) goto L8;
            return;
        L8:
            if (VSMediaUIConfigHelper.a(r7) == false) goto L17;
            DataCenter r8 = ((Widget) r0).dataCenter;
            if (r8 == null) goto L12;
            r2 = Integer.valueOf(r8.hashCode());
        L12:
            LayerEventDispatcher r9 = o70.c.a(r2);
            if (r9 == null) goto L18;
            r9.b(new bh1.c());
            return;
        L18:
            return;
        }
    }

    public VSLiveCompositeWidget() {
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        if (((Widget) this).dataCenter == null) goto L8;
        IEpisodeInteractiveService r0 = jc1.k.f(IEpisodeInteractiveService.class);
        if (r0 == null) goto L8;
        r0.setUpForTemplate(getComponentContext(), ((Widget) this).dataCenter);
    L8:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e == false) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        boolean r2 = true;
        if (r1 != null) goto L12;
    L13:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L25;
        if (vx0.a.getValue().booleanValue() == false) goto L25;
        IGiftServiceExternal r4 = jc1.k.f(IGiftServiceExternal.class);
        if (r4 == null) goto L25;
        r4.initGiftModule(getContext(), this, ((Widget) this).dataCenter);
        goto L25
    L16:
        if (r3.V9() != true) goto L18;
    L12:
        if (r1.dg() == true) goto L19;
    L25:
        runWithRoomEntered(new AnonymousClass1(this));
        DataCenter r5 = ((Widget) this).dataCenter;
        n r6 = null;
        if (r5 == null) goto L30;
        vlc.d r7 = (vlc.d) r5.get("data_message_manager", null);
        if (r7 == null) goto L30;
        r7.addMessageListener(MessageType.VS_SCHEDULE_MESSAGE.getWsMethod(), this);
    L30:
        h70.b r8 = getComponentContext();
        if (r8 == null) goto L33;
        r6 = ho1.a.e(r8);
    L33:
        if (r6 == null) goto L40;
        PropertyOwner r9 = r6.sa();
        if (r9 == null) goto L41;
        Disposable r10 = r9.subscribe(new a(this));
        if (r10 == null) goto L42;
        RxUtilKt.c(r10, this.b);
        return;
    L42:
        return;
    L41:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        vlc.d r1 = (vlc.d) r0.get("data_message_manager", null);
        if (r1 == null) goto L7;
        r1.removeMessageListener(this);
    L7:
        this.b.dispose();
        this.a = null;
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof VsScheduleMessage) == false) goto L26;
        VsScheduleMessage r11 = (VsScheduleMessage) r10;
        if (r11.getAction() != 1) goto L7;
    L8:
        nm1.m r2 = pm1.f.l();
        if (r2 == null) goto L12;
        r2.g(r11.getEventId(), r11.getContentId(), r11.getMatchId(), ((Widget) this).dataCenter);
    L12:
        if (pm1.f.l() == null) goto L17;
        nm1.m r0 = pm1.f.l();
        if (r0 != null) goto L16;
        return;
    L16:
        if (r0.y(((Widget) this).dataCenter) == false) goto L17;
        return;
    L17:
        MiddlewareRoomContext r1 = getMiddlewareRoomContext();
        if ((r1 instanceof RoomContext) == true) goto L20;
        r1 = null;
    L20:
        RoomContext r3 = (RoomContext) r1;
        if (r3 == null) goto L30;
        com.bytedance.live.datacontext.m r4 = r3.getCurrentMatchId();
        if (r4 == null) goto L31;
        r4.setValue(Long.valueOf(r11.getMatchId()));
        return;
    L31:
        return;
    L30:
        return;
    L7:
        if (r11.getAction() == 2) goto L8;
        return;
    }
}
