package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.y1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.ui.g7;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AnchorZoomFeatureWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ljo1/c;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorZoomFeatureWidget extends MiddlewareRoomWidget implements vlc.l, Observer<KVData>, jo1.c {
    public LiveMode a;
    public com.bytedance.android.live.pushstream.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c c;
    public g7 d;
    public Disposable e;
    public vlc.d f;
    public final String g;

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public AnchorZoomFeatureWidget() {
        this.g = "AnchorZoomWidget";
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        this.c = r0;
        vlc.d r1 = null;
        if (r0 == null) goto L5;
        LiveMode r2 = r0.getLiveMode();
    L6:
        this.a = r2;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.c;
        if (r3 == null) goto L9;
        com.bytedance.android.live.pushstream.d r4 = r3.getLiveStream();
    L10:
        this.b = r4;
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L13;
        ho1.a.p(r5, jo1.c.class, this);
    L13:
        LiveMode r6 = this.a;
        if (r6 == LiveMode.VIDEO) goto L18;
        if (r6 == LiveMode.MEDIA) goto L18;
    L73:
        if (this.f != null) goto L78;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L77;
        r1 = (vlc.d) r7.get("data_message_manager", null);
    L77:
        this.f = r1;
    L78:
        vlc.d r8 = this.f;
        if (r8 == null) goto L82;
        r8.addMessageListener(MessageType.CONTROL.getWsMethod(), this);
        return;
    L82:
        return;
    L18:
        if (this.b == null) goto L73;
        if (com.bytedance.android.live.broadcast.api.model.r.c() == false) goto L22;
        ALogger.i(this.g, "is front camera");
    L34:
        this.d = new g7(getContext(), this.b, ((Widget) this).dataCenter);
        com.bytedance.android.livesdk.chatroom.ui.framework.a r9 = ho1.a.c(getComponentContext());
        if (r9 == null) goto L38;
        r9.Og(com.bytedance.android.livesdk.chatroom.ui.framework.f.f1);
    L38:
        if (qw2.d.j == 1.0f) goto L66;
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L42;
        y1 r11 = (y1) r10.get("cmd_anchor_broadcast_start_zoom", new y1(1.0f));
    L43:
        if (r11 == null) goto L45;
        com.bytedance.android.live.broadcast.api.model.r.d(r11, qw2.d.j);
    L45:
        if (r11 == null) goto L49;
        float r12 = r11.c;
        com.bytedance.android.live.pushstream.d r13 = this.b;
        if (r13 == null) goto L49;
        r13.startZoom(r12);
    L49:
        String r14 = this.g;
        StringBuilder r15 = new StringBuilder("loadZoom,value:");
        if (r11 == null) goto L52;
        Float r16 = Float.valueOf(r11.c);
    L53:
        r15.append(r16);
        ALogger.i(r14, r15.toString());
        if (r11 == null) goto L62;
        float r17 = r11.c;
        h70.b r18 = getComponentContext();
        if (r18 == null) goto L62;
        IAbilityCenter r19 = r18.a();
        if (r19 == null) goto L62;
        jo1.j r20 = (jo1.j) r19.getAbility(jo1.j.class);
        if (r20 == null) goto L62;
        r20.Wh(r17);
    L62:
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L65;
        r21.put("cmd_anchor_broadcast_start_zoom", r11);
    L65:
        qw2.d.j = 1.0f;
        goto L66
    L52:
        r16 = null;
        goto L53
    L42:
        r11 = null;
    L66:
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L69;
        r22.observe("cmd_anchor_broadcast_start_zoom", this);
    L69:
        DataCenter r23 = ((Widget) this).dataCenter;
        if (r23 == null) goto L73;
        r23.observe("cmd_anchor_broadcast_revese_camera", this);
        goto L73
    L22:
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == true) goto L33;
        IBroadcastService r24 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r24 == null) goto L30;
        if (r24.isPlayingGame() == true) goto L33;
    L30:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.l0.getValue()).booleanValue() == false) goto L32;
        ALogger.i(this.g, "has show zoom guid");
        goto L34
    L32:
        this.e = ((SingleSubscribeProxy) Single.timer(AppointmentService.SOURCE_UNDEFINED, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
    L33:
        ALogger.i(this.g, "cant show zoomguid,other dialog show");
        goto L34
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        Disposable r1 = this.e;
        if (r1 != null) goto L5;
    L10:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L13;
        r2.removeObserver(this);
    L13:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L18;
        vlc.d r0 = (vlc.d) r3.get("data_message_manager", null);
        if (r0 == null) goto L18;
        r0.removeMessageListener(this);
    L18:
        ho1.a.q(getComponentContext(), jo1.c.class);
        return;
    L5:
        if (r1.isDisposed() == true) goto L10;
        Disposable r4 = this.e;
        if (r4 == null) goto L9;
        r4.dispose();
    L9:
        this.e = null;
        goto L10
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (isViewValid() == false) goto L51;
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L8;
        return;
    L8:
        if (r6.getData() == null) goto L63;
        String r0 = r6.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1504465517)) goto L35;
        if (r1 == 1112322285) goto L16;
        return;
    L16:
        if (r0.equals("cmd_anchor_broadcast_revese_camera") == false) goto L54;
        h70.b r7 = getComponentContext();
        if (r7 == null) goto L24;
        IAbilityCenter r8 = r7.a();
        if (r8 == null) goto L24;
        jo1.j r9 = (jo1.j) r8.getAbility(jo1.j.class);
        if (r9 == null) goto L24;
        r9.T0();
    L24:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L27;
        y1 r11 = (y1) r10.get("cmd_anchor_broadcast_start_zoom", new y1(1.0f));
    L28:
        if (r11 == null) goto L30;
        r11.b = 1.0f;
    L30:
        if (r11 == null) goto L32;
        r11.a = 1.0f;
    L32:
        if (r11 == null) goto L55;
        r11.c = 1.0f;
        return;
    L55:
        return;
    L27:
        r11 = null;
        goto L28
    L54:
        return;
    L35:
        if (r0.equals("cmd_anchor_broadcast_start_zoom") == true) goto L37;
        return;
    L37:
        if (this.b == null) goto L58;
        y1 r12 = (y1) r6.getData();
        if (r12 == null) goto L59;
        com.bytedance.android.live.pushstream.d r2 = this.b;
        if (r2 == null) goto L43;
        r2.startZoom(r12.c);
    L43:
        ALogger.i(this.g, "update zoom,value:" + r12.c);
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L60;
        IAbilityCenter r4 = r3.a();
        if (r4 == null) goto L61;
        jo1.j r13 = (jo1.j) r4.getAbility(jo1.j.class);
        if (r13 == null) goto L62;
        r13.sj(r12.c);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L63:
        return;
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof com.bytedance.android.live.base.model.message.o0) == true) goto L5;
        return;
    L5:
        if (2 != ((com.bytedance.android.live.base.model.message.o0) r5).getAction()) goto L27;
        LiveMode r6 = this.a;
        if (r6 == LiveMode.VIDEO) goto L11;
        if (r6 == LiveMode.MEDIA) goto L11;
        return;
    L11:
        if (this.b == null) goto L29;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L30;
        y1 r8 = (y1) r7.get("cmd_anchor_broadcast_start_zoom", new y1(1.0f));
        if (r8 == null) goto L17;
        Float r9 = Float.valueOf(r8.c);
    L19:
        if ((!Intrinsics.areEqual(r9, 1.0f)) == false) goto L31;
        if (r9 == null) goto L24;
        float r0 = r9.floatValue();
        com.bytedance.android.live.pushstream.d r1 = this.b;
        if (r1 == null) goto L24;
        r1.startZoom(r0);
    L24:
        ALogger.i(this.g, "recoverZoom,value:" + r9);
        return;
    L31:
        return;
    L17:
        r9 = null;
        goto L19
    L30:
        return;
    L29:
        return;
    }

    @Override // jo1.c
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        g7 r0 = this.d;
        if (r0 == null) goto L9;
        r0.onTouchEvent(r2);
        g7 r3 = this.d;
        if (r3 != null) goto L7;
        return false;
    L7:
        if (r3.isInProgress() != true) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }
}
