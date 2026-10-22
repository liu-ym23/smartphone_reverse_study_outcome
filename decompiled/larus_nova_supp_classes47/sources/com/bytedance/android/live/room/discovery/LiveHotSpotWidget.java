package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.u0;
import com.bytedance.android.livesdk.config.yz;
import com.bytedance.android.livesdk.message.model.ak;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHotSpotInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class LiveHotSpotWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {
    public TextView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ViewGroup f;
    public Room g;
    public boolean h;
    public String i;
    public vlc.d j;
    public Dialog k;
    public String l;

    public class a extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveHotSpotWidget c;

        public final void run() {
            LiveHotSpotWidget r0 = this.c;
            LiveHotSpotInfo r1 = r0.g.getLiveHotSpotInfo();
            if (r0.xq() == false) goto L5;
            ((Widget) r0).containerView.setVisibility(8);
            Unit r2 = Unit.INSTANCE;
        L11:
            ViewGroup.LayoutParams r3 = r0.f.getLayoutParams();
            Room r4 = r0.g;
            if (r4 != null) goto L14;
        L18:
            r0.a.setMaxWidth((int) UIUtils.dip2Px(r0.getContext(), 80.0f));
            if (r3 == null) goto L21;
            r3.height = (int) UIUtils.dip2Px(r0.getContext(), 20.0f);
        L21:
            r0.f.setLayoutParams(r3);
            b(true);
            return;
        L14:
            if (r4.isMediaRoom() == false) goto L18;
            r0.a.setMaxWidth((int) UIUtils.dip2Px(r0.getContext(), 80.0f));
            if (r3 == null) goto L21;
            r3.height = (int) UIUtils.dip2Px(r0.getContext(), 22.0f);
            goto L21
        L5:
            if (r1 != null) goto L7;
        L10:
            ((Widget) r0).containerView.setVisibility(8);
            Unit r5 = Unit.INSTANCE;
            goto L11
        L7:
            if (TextUtils.isEmpty(r1.title) == true) goto L10;
            r0.yq(r1.title);
            r0.wq();
            goto L11
        }

        public a(LiveHotSpotWidget r1) {
            this.c = r1;
            super("hot_spot_widget_load");
        }
    }

    public final int getLayoutId() {
        return 2131566164;
    }

    public final String getSpm() {
        return "a100.a100.a145";
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final void onUnload() {
        vlc.d r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        Dialog r2 = this.k;
        if (r2 == null) goto L28;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r2);
    L25:
        this.k = null;
        goto L28
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r4 == null) goto L24;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r3.getLooper()) goto L15;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L28:
        this.i = "";
    }

    public final void wq() {
        HashMap r0 = new HashMap();
        r0.put("trending_topic", String.valueOf(this.i));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_topic_show", r0, new Object[]{new am2.x(), Room.class});
    }

    public final boolean xq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        u0 r1 = (u0) r0.get("data_hot_spot_room_info", null);
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.a == true) goto L11;
        return false;
    L11:
        if (r1.b == false) goto L15;
        return true;
    L15:
        return false;
    }

    public LiveHotSpotWidget() {
        this.i = "";
        this.l = "";
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (xq() == false) goto L6;
        return;
    L6:
        if ("data_keyboard_status_douyin".equals(r4.getKey()) == true) goto L8;
        return;
    L8:
        if (r4.getData() != null) goto L10;
        return;
    L10:
        if (((Boolean) r4.getData()).booleanValue() == false) goto L12;
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        Unit r5 = Unit.INSTANCE;
        return;
    L12:
        yq(this.i);
    }

    public final void onInit(Object[] r1) {
        this.a = (TextView) findViewById(2131374561);
        this.b = (ImageView) findViewById(2131373067);
        this.f = (ViewGroup) findViewById(2131374560);
        this.c = (ImageView) findViewById(2131374764);
        this.d = (ImageView) findViewById(2131374763);
        this.e = (ImageView) findViewById(2131374765);
    }

    public final void onLoad(Object[] r5) {
        this.g = (Room) ((Widget) this).dataCenter.get("data_room", null);
        this.h = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.b.setRotation(0.0f);
        this.f.setOnClickListener(new d0(this));
        vlc.d r6 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.j = r6;
        if (r6 == null) goto L5;
        r6.addMessageListener(MessageType.ROOM_HOTSPOT_MESSAGE.getIntType(), this);
    L5:
        ((Widget) this).dataCenter.observe("data_keyboard_status_douyin", this);
        final a r7 = new a(this);
        RoomContext.a r0 = RoomContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        long r2 = this.g.getId();
        r0.getClass();
        RoomContext r3 = RoomContext.a.a(r1, r2);
        if (r3 == null) goto L9;
        r3.getWidgetLoadTaskScheduler().c(new e0(this, r7));
    L9:
        if (((Boolean) yz.a.getValue()).booleanValue() == false) goto L11;
    L14:
        UIUtils.setViewVisibility(this.c, 8);
        UIUtils.setViewVisibility(this.d, 8);
        UIUtils.setViewVisibility(this.b, 8);
        UIUtils.setViewVisibility(this.e, 0);
        ((Widget) this).contentView.setPadding(0, 0, s1.f(8.0f), 0);
        return;
    L11:
        if (this.g.isMergeVSRoom() == true) goto L14;
        UIUtils.setViewVisibility(this.c, 0);
        UIUtils.setViewVisibility(this.d, 0);
        UIUtils.setViewVisibility(this.b, 0);
        UIUtils.setViewVisibility(this.e, 8);
    }

    public final void onMessage(tlc.d r4) {
        if (xq() == false) goto L6;
        return;
    L6:
        if ((r4 instanceof ak) == false) goto L18;
        ak r5 = (ak) r4;
        LiveHotSpotInfo r0 = r5.E();
        if (r0 != null) goto L10;
    L16:
        ((Widget) this).dataCenter.put("cmd_update_live_hotspot_show", Boolean.FALSE);
        int r6 = ib6.a.a;
        this.g.getId();
        yq("");
        return;
    L10:
        if (TextUtils.isEmpty(r0.title) == true) goto L16;
        if (TextUtils.equals(r0.title, this.i) == true) goto L15;
        wq();
    L15:
        yq(r0.title);
        this.g.setLiveHotSpotInfo(r5.G());
        return;
    }

    public final void yq(String r3) {
        this.i = r3;
        if (TextUtils.isEmpty(r3) == true) goto L8;
        ((Widget) this).containerView.setVisibility(0);
        Unit r4 = Unit.INSTANCE;
        this.a.setText(this.i);
        ((Widget) this).dataCenter.put("cmd_update_live_hotspot_show", Boolean.TRUE);
        int r5 = ib6.a.a;
        this.g.getId();
        if (this.g.isMergeVSRoom() == false) goto L7;
        this.a.setText("热点");
        return;
    L7:
        this.a.setText(this.i);
        return;
    L8:
        ((Widget) this).containerView.setVisibility(8);
        Unit r6 = Unit.INSTANCE;
    }
}
