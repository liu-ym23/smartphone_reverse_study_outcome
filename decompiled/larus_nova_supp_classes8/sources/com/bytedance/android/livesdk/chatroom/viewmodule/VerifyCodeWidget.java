package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.app.Activity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.live.MonitorMessageType;
import com.bytedance.android.livesdk.message.model.cn;
import com.bytedance.android.livesdk.message.model.dn;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.verify.VerificationCodeApi;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/VerifyCodeWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerifyCodeWidget extends LiveRecyclableWidget implements vlc.l {
    public static final /* synthetic */ int g = 0;
    public final CompositeDisposable a;
    public boolean b;
    public boolean c;
    public Disposable d;
    public final String e;
    public String f;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public b(VerifyCodeWidget r1) {
        }

        public final void accept(Object r1) {
            ((ch1.b) r1).getType();
            MonitorMessageType r2 = MonitorMessageType.UNKNOWN;
        }
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a209";
    }

    public final void onInit(Object[] r1) {
    }

    public final void Aq() {
        Room r0 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r0 == null) goto L6;
        HashMap r1 = new HashMap();
        r1.put("_param_live_platform", "live");
        r1.put("anchor_id", r0.getOwnerUserIdString());
        r1.put("live_type", zq(r0));
        r1.put("notice_type", this.f);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_verification_code_notice", r1, new Object[0]);
        return;
    }

    public VerifyCodeWidget() {
        this.a = new CompositeDisposable();
        this.e = "VerifyCodeWidget.Channel";
        this.f = "";
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.a.clear();
        Disposable r1 = this.d;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 != null) goto L5;
        return;
    L5:
        this.b = false;
        Disposable r1 = null;
        vlc.d r5 = (vlc.d) r4.get("data_message_manager", null);
        if (r5 == null) goto L8;
        r5.addMessageListener(MessageType.VERIFY_CODE_MESSAGE.getIntType(), this);
        r5.addMessageListener(MessageType.VERIFY_DECISION_CODE_MESSAGE.getIntType(), this);
    L8:
        DataContext r6 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r6 instanceof RoomContext) == true) goto L11;
        r6 = null;
    L11:
        RoomContext r7 = (RoomContext) r6;
        if (r7 == null) goto L18;
        com.bytedance.live.datacontext.m r8 = r7.getReconnectMonitorMessage();
        if (r8 == null) goto L18;
        Observable r9 = r8.a();
        if (r9 == null) goto L18;
        r1 = r9.subscribe(new b(this));
    L18:
        this.d = r1;
    }

    public final void onMessage(tlc.d r12) {
        long r0 = 0;
        String r2 = null;
        if (r12 != null) goto L5;
    L20:
        if (r12 != null) goto L22;
        return;
    L22:
        if (r12.getIntType() == MessageType.VERIFY_DECISION_CODE_MESSAGE.getIntType()) goto L24;
        return;
    L24:
        if ((r12 instanceof dn) == false) goto L53;
        dn r13 = (dn) r12;
        Logger.d("VerifyCodeWidget", "showVerifyCodeDialogV2, data=" + r13.E() + ' ' + r13.G() + ' ' + r13.H());
        IHostVerify r6 = TTLiveSDK.hostService().verify();
        Activity r7 = com.bytedance.android.live.core.utils.s2.a(((Widget) this).context);
        String r8 = r13.G();
        String r9 = "";
        if (r8 != null) goto L28;
        r8 = "";
    L28:
        r6.showCaptchaV2(r7, r8, new t3(this, r13));
        if (r13.H() <= 0) goto L31;
        long r1 = r13.H();
    L32:
        Logger.i("VerifyCodeWidget", "showVerifyCodeDialogV2, timeout = " + r1);
        this.a.add(Observable.timer(r1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(u3.a, v3.a));
        String r14 = r13.E();
        Room r3 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        String r4 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r4 instanceof RoomContext) == false) goto L36;
        r2 = r4;
    L36:
        RoomContext r5 = (RoomContext) r2;
        if (r3 == null) goto L54;
        HashMap r10 = new HashMap();
        r10.put("anchor_id", r3.getOwnerUserIdString());
        r10.put("room_id", r3.getIdStr());
        if (r5 == null) goto L48;
        com.bytedance.live.datacontext.n r11 = r5.getCurStatMessage();
        if (r11 == null) goto L48;
        mk r15 = (mk) r11.getValue();
        if (r15 == null) goto L48;
        String r16 = String.valueOf(r15.getTotal());
        if (r16 == null) goto L48;
        r9 = r16;
    L48:
        r10.put("watch_ucnt", r9);
        r10.put("check_reason", r14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_man_machine_check_show", r10, new Object[0]);
        return;
    L54:
        return;
    L31:
        r1 = 60;
        goto L32
    L53:
        return;
    L5:
        if (r12.getIntType() != MessageType.VERIFY_CODE_MESSAGE.getIntType()) goto L20;
        if ((r12 instanceof cn) == false) goto L20;
        this.b = false;
        cn r17 = (cn) r12;
        Logger.d("VerifyCodeWidget", "VerificationCodeMessage, id=" + r17.getId() + ", duration=" + r17.getDuration());
        Room r18 = (Room) ((Widget) this).dataCenter.get("data_room", null);
        if (r18 == null) goto L11;
        r0 = r18.id;
    L11:
        if (r18 == null) goto L14;
        String r19 = r18.getOwnerUserIdString();
        if (r19 == null) goto L14;
    L15:
        if (r18 == null) goto L19;
        User r20 = r18.getOwner();
        if (r20 == null) goto L19;
        r2 = r20.getCastSecUid();
    L19:
        this.a.add(((VerificationCodeApi) com.bytedance.android.live.network.c.b().e(VerificationCodeApi.class)).requestVerificationCode(r19, r2, r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o3(this, r17, r18), p3.a));
        return;
    L14:
        r19 = "0";
        goto L15
    }

    public final String zq(Room r2) {
        LiveMode r3 = r2.getStreamType();
        int r4 = l3.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return "video_live";
    L5:
        if (r4 != 2) goto L7;
        return "voice_live";
    L7:
        if (r4 != 3) goto L9;
        return "third_party";
    L9:
        if (r4 == 4) goto L11;
        return "undefined";
    L11:
        return "game";
    }

    public static final void wq(VerifyCodeWidget r4, int r5) {
        Room r0 = (Room) ((Widget) r4).dataCenter.get("data_room", null);
        if (r0 == null) goto L13;
        HashMap r1 = new HashMap();
        r1.put("_param_live_platform", "live");
        r1.put("anchor_id", r0.getOwnerUserIdString());
        switch(r5) {
            case 0: goto L10;
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L6:
        r1.put("type", "shutdown");
    L11:
        r1.put("live_type", r4.zq(r0));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_verification_code_close", r1, new Object[0]);
        return;
    L7:
        r1.put("type", "timeout");
        goto L11
    L8:
        r1.put("type", "shutdown");
        goto L11
    L9:
        r1.put("type", "notpass");
        goto L11
    L10:
        r1.put("type", "pass");
        goto L11
    }

    public static final void xq(VerifyCodeWidget r4, String r5, boolean r6) {
        DataCenter r7 = ((Widget) r4).dataCenter;
        if (r7 == null) goto L27;
        RoomContext r1 = null;
        Room r8 = (Room) r7.get("data_room", null);
        RoomContext r0 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r0 instanceof RoomContext) == false) goto L9;
        r1 = r0;
    L9:
        RoomContext r2 = r1;
        if (r8 == null) goto L26;
        HashMap r3 = new HashMap();
        r3.put("anchor_id", r8.getOwnerUserIdString());
        r3.put("room_id", r8.getIdStr());
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.n r9 = r2.getCurStatMessage();
        if (r9 == null) goto L19;
        mk r10 = (mk) r9.getValue();
        if (r10 == null) goto L19;
        String r11 = String.valueOf(r10.getTotal());
        if (r11 == null) goto L19;
    L20:
        r3.put("watch_ucnt", r11);
        r3.put("check_reason", r5);
        if (r6 == false) goto L23;
        String r12 = "success";
    L24:
        r3.put("check_result", r12);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_man_machine_check_result", r3, new Object[0]);
        return;
    L23:
        r12 = "fail";
    L19:
        r11 = "";
        goto L20
    L26:
        return;
    }

    public static final void yq(VerifyCodeWidget r7, cn r8, int r9) {
        if (r7.b == true) goto L7;
        Disposable r10 = ((VerificationCodeApi) com.bytedance.android.live.network.c.b().e(VerificationCodeApi.class)).reportVerificationResult(r8.getId(), r8.getMessageId(), r9).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(m3.a, n3.a);
        r7.a.add(r10);
        return;
    }
}
