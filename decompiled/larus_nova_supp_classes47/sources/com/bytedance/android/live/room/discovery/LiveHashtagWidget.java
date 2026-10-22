package com.bytedance.android.live.room.discovery;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTag;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.vj;
import com.bytedance.android.livesdk.config.yz;
import com.bytedance.android.livesdk.message.model.yj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHotSpotInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Unit;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class LiveHashtagWidget extends RowRecyclableWidget implements vlc.l, Observer<KVData> {
    public TextView a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public vlc.d e;
    public ImageView f;
    public ConstraintLayout g;
    public Room h;
    public boolean i;
    public boolean j;
    public long k;
    public String l;
    public CircleInfo m;
    public Dialog n;
    public DialogFragment o;
    public boolean p;
    public boolean q;

    public class a extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ LiveHashtagWidget c;

        public final void run() {
            LiveHashtagWidget r0 = this.c;
            if (r0.m == null) goto L8;
            r0.b.setBackgroundResource(2131251706);
            r0.c.setBackgroundResource(2131250931);
            UIUtils.setViewVisibility(r0.b, 0);
            UIUtils.setViewVisibility(r0.c, 0);
            UIUtils.setViewVisibility(r0.d, 8);
            r0.a.setText(r0.m.getCircleName());
            if (r0.i == false) goto L7;
            UIUtils.setViewVisibility(r0.f, 8);
            r0.g.setOnClickListener(new z(r0));
        L41:
            b(true);
            return;
        L7:
            UIUtils.setViewVisibility(r0.f, 0);
            r0.g.setOnClickListener(new a0(r0));
            goto L41
        L8:
            View r1 = r0.a;
            if (((Integer) vj.a.getValue()).intValue() != 1) goto L11;
        L12:
            r1 = ((Widget) r0).contentView;
        L13:
            r1.setOnClickListener(new b0(r0));
            vlc.d r2 = (vlc.d) ((Widget) r0).dataCenter.get("data_message_manager", null);
            r0.e = r2;
            if (r2 == null) goto L16;
            r2.addMessageListener(MessageType.ROOM_CHALLENGE_MESSAGE.getIntType(), r0);
        L16:
            LiveHashTagInfo r3 = r0.h.getLiveHashTagInfo();
            LiveHotSpotInfo r5 = r0.h.getLiveHotSpotInfo();
            if (r5 != null) goto L19;
        L21:
            r0.p = true;
        L22:
            if (r3 != null) goto L24;
        L33:
            ((Widget) r0).containerView.setVisibility(8);
            Unit r4 = Unit.INSTANCE;
        L34:
            UIUtils.setViewVisibility(r0.f, 8);
            r0.b.setBackgroundResource(2131251727);
            r0.c.setBackgroundResource(2131251056);
            if (((Boolean) yz.a.getValue()).booleanValue() == false) goto L37;
        L40:
            UIUtils.setViewVisibility(r0.b, 8);
            UIUtils.setViewVisibility(r0.c, 8);
            UIUtils.setViewVisibility(r0.d, 0);
            goto L41
        L37:
            if (r0.h.isMergeVSRoom() == true) goto L40;
            UIUtils.setViewVisibility(r0.b, 0);
            UIUtils.setViewVisibility(r0.c, 0);
            UIUtils.setViewVisibility(r0.d, 8);
            goto L41
        L24:
            if (TextUtils.isEmpty(r3.id) == true) goto L33;
            if (TextUtils.isEmpty(r3.name) == true) goto L33;
            r0.zq(r3.id, r3.name);
            LiveHashTag r6 = (LiveHashTag) ((Widget) r0).dataCenter.get("cmd_update_live_challenge", null);
            if (r6 != null) goto L30;
        L32:
            r0.xq(new LiveHashTag(r3.id, r3.name));
            goto L34
        L30:
            if (TextUtils.equals(r3.id, r6.getId()) == false) goto L32;
            r0.xq(r6);
            goto L34
        L19:
            if (TextUtils.isEmpty(r5.title) == true) goto L21;
            r0.p = false;
            goto L22
        L11:
            if (r0.a.isShown() == true) goto L13;
            goto L12
        }

        public a(LiveHashtagWidget r1) {
            this.c = r1;
            super("hash_tag_widget_load");
        }
    }

    public class b implements IMiddlewareHostBusiness.HashTagCallback {
        public final /* synthetic */ long a;
        public final /* synthetic */ LiveHashtagWidget b;

        public final void onDismiss() {
        }

        public final void onShow() {
        }

        public final void onVideoRecordOpened() {
            xs2.b.a().post(new h1(32));
            this.b.o.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(LiveHashtagWidget r1, long r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onJumpToOtherRoom(long r6, String r8, long r9) {
            Bundle r0 = new Bundle();
            r0.putString("enter_from_merge", "live_challenge");
            r0.putString("enter_method", "live_cell");
            r0.putString("anchor_id", r8);
            r0.putString("challenge_page", "live_detail");
            r0.putString("tag_id", this.a + "");
            if (r9 != 1) goto L5;
            String r10 = "autoCover";
        L6:
            r0.putString("cover_type", r10);
            JumpToOtherRoomEvent r12 = new JumpToOtherRoomEvent(r6, r0);
            vj r7 = vj.a;
            if (((Integer) r7.getValue()).intValue() != 1) goto L9;
            r12.jumpSource = "jump_source_live_challenge";
        L9:
            r12.source = "sourceJumpToOtherLiveHashTagW";
            xs2.b.a().post(r12);
            if (((Integer) r7.getValue()).intValue() != 1) goto L13;
            r0.putString("source", "live_challenge");
            r0.putInt("back_source", 8);
            ContextUtil.contextToActivity(((Widget) this.b).context);
            DataCenter r13 = ((Widget) this.b).dataCenter;
            return;
        L13:
            return;
        L5:
            r10 = "other";
            goto L6
        }
    }

    public final int getLayoutId() {
        return 2131566152;
    }

    public final String getSpm() {
        return "a100.a100.a241";
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final void onUnload() {
        vlc.d r0 = this.e;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.k = 0;
        this.j = false;
        ((Widget) this).dataCenter.removeObserver(this);
        Dialog r1 = this.n;
        if (r1 == null) goto L25;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r1);
    L22:
        this.n = null;
        goto L25
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r3 == null) goto L21;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L10:
        if (Looper.myLooper() == r2.getLooper()) goto L12;
        r2.post(DialogLancet.createDismissRunnable(r1));
    L25:
        DialogFragment r4 = this.o;
        if (r4 == null) goto L40;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L29
    L33:
        this.o = null;
        return;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L33;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    }

    public LiveHashtagWidget() {
        this.l = "";
        this.m = null;
        this.p = true;
        this.q = true;
    }

    public static void wq(LiveHashtagWidget r5) {
        r5.getClass();
        HashMap r0 = new HashMap();
        if (r5.h.isLiveTypeAudio() == false) goto L5;
        String r1 = "voice_live";
    L6:
        r0.put("live_type", r1);
        r0.put("anchor_id", r5.h.getOwnerUserIdString());
        r0.put("room_id", r5.h.getId() + "");
        int r2 = jc1.k.f(IInteractService.class).getCurrentScene();
        com.bytedance.android.live.liveinteract.api.utils.a.a.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.a.b(r0, r2);
        if (r5.i == false) goto L9;
        r0.put("user_type", "anchor");
    L10:
        CircleInfo r3 = r5.m;
        if (r3 == null) goto L14;
        r0.put("circle_name", r3.getCircleName());
    L14:
        if (r5.i == false) goto L16;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_circle_icon_click", r0, new Object[0]);
        return;
    L16:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_circle_icon_click", r0, new Object[]{am2.x.class});
        return;
    L9:
        r0.put("user_type", "user");
        goto L10
    L5:
        r1 = "video_live";
        goto L6
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L58;
        if (r8 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r8.getKey()) == false) goto L8;
        return;
    L8:
        if (r8.getData() == null) goto L67;
        String r0 = r8.getKey();
        r0.getClass();
        switch(r0.hashCode()) {
            case -2095376959: goto L26;
            case 256598095: goto L22;
            case 294674590: goto L18;
            case 872172481: goto L14;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        if (r1 != 0) goto L32;
        LiveHashTag r9 = (LiveHashTag) r8.getData();
        if (r9 == null) goto L69;
        zq(r9.getId(), r9.getName());
        return;
    L69:
        return;
    L32:
        if (r1 == 1) goto L50;
        if (r1 == 2) goto L38;
        if (r1 != 3) goto L68;
        ((Integer) r8.getData()).intValue();
        return;
    L68:
        return;
    L38:
        if (r8.getData() == null) goto L62;
        boolean r10 = ((Boolean) r8.getData()).booleanValue();
        LiveHashTagInfo r2 = this.h.getLiveHashTagInfo();
        if (this.p == false) goto L48;
        if (r10 == true) goto L48;
        if (r2 == null) goto L48;
        if (TextUtils.isEmpty(r2.id) == true) goto L48;
        if (TextUtils.isEmpty(r2.name) == true) goto L48;
        UIUtils.setViewVisibility(((Widget) this).containerView, 0);
        Unit r12 = Unit.INSTANCE;
        return;
    L48:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        Unit r13 = Unit.INSTANCE;
        return;
    L62:
        return;
    L50:
        if (((Boolean) r8.getData()).booleanValue() == false) goto L52;
        this.p = false;
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        Unit r14 = Unit.INSTANCE;
        return;
    L52:
        this.p = true;
        zq(String.valueOf(this.k), this.l);
        return;
    L14:
        if (r0.equals("data_link_state") == false) goto L29;
        r1 = 3;
        goto L30
    L18:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L29;
        r1 = 2;
        goto L30
    L22:
        if (r0.equals("cmd_update_live_hotspot_show") == false) goto L29;
        r1 = 1;
        goto L30
    L26:
        if (r0.equals("cmd_update_live_challenge") == false) goto L29;
        r1 = 0;
        goto L30
    L67:
        return;
    }

    public final void onInit(Object[] r1) {
        this.a = (TextView) findViewById(2131374205);
        this.b = (ImageView) findViewById(2131374760);
        this.c = (ImageView) findViewById(2131374759);
        this.d = (ImageView) findViewById(2131374761);
        this.f = (ImageView) findViewById(2131374736);
        this.g = findViewById(2131374204);
    }

    public final void onLoad(Object[] r5) {
        this.h = (Room) ((Widget) this).dataCenter.get("data_room", null);
        DataCenter r6 = ((Widget) this).dataCenter;
        Boolean r0 = Boolean.FALSE;
        this.i = ((Boolean) r6.get("data_is_anchor", r0)).booleanValue();
        this.j = ((Boolean) ((Widget) this).dataCenter.get("data_is_from_back_to_pre_room", r0)).booleanValue();
        this.m = this.h.getCircleInfo();
        ((Widget) this).dataCenter.observe("cmd_update_live_challenge", this).observe("data_link_state", this).observe("data_keyboard_status_douyin", this).observe("cmd_update_live_hotspot_show", this);
        final a r7 = new a(this);
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = ((Widget) this).dataCenter;
        long r3 = this.h.getId();
        r1.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        if (r4 == null) goto L6;
        r4.getWidgetLoadTaskScheduler().c(new x(this, r7));
    L6:
        if (this.j == true) goto L8;
        return;
    L8:
        if ("live_challenge_live_detail".equals(((Widget) this).dataCenter.get("data_from_back_scene", "")) == false) goto L12;
        yq(this.k);
        return;
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof yj) == false) goto L17;
        yj r6 = (yj) r5;
        LiveHashTagInfo r0 = r6.E();
        if (r0 == null) goto L12;
        zq(r0.id, r0.name);
        this.h.setLiveHashTagInfo(r6.G());
        LiveHashTag r1 = (LiveHashTag) ((Widget) this).dataCenter.get("cmd_update_live_challenge", null);
        if (r1 != null) goto L9;
    L11:
        xq(new LiveHashTag(r0.id, r0.name));
    L13:
        String r7 = r6.getToastContent();
        if (TextUtils.isEmpty(r7) == true) goto L18;
        f2.c(r7, 0);
        return;
    L18:
        return;
    L9:
        if (TextUtils.equals(r0.id, r1.getId()) == false) goto L11;
        xq(r1);
        goto L13
    L12:
        zq(DataType.FALSE, "");
        this.h.setLiveHashTagInfo(null);
        xq(null);
        goto L13
    }

    public final void xq(LiveHashTag r3) {
        if (this.m == null) goto L5;
        return;
    L5:
        ((Widget) this).dataCenter.put("cmd_update_live_challenge", r3);
    }

    public final void yq(long r6) {
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L6;
        f2.b(2131911622, 0);
        return;
    L6:
        DialogFragment r0 = this.o;
        if (r0 == null) goto L14;
        if (r0.getDialog() == null) goto L14;
        if (this.o.getDialog().isShowing() == false) goto L14;
        return;
    L14:
        if (this.h != null) goto L16;
        return;
    L16:
        HashMap r1 = new HashMap();
        r1.put("tag_id", String.valueOf(r6));
        r1.put("challenge_page", "live_detail");
        r1.put("enter_from", "live_challenge");
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r3 == null) goto L21;
        Object r4 = r3.getMap().get("enter_from_merge");
        if ((r4 instanceof String) == false) goto L21;
        r1.put("previous_page", r4.toString());
    L21:
        com.bytedance.android.livesdk.log.u.l().e("enter_tag_detail", r1, new Object[]{new am2.x(), Room.class});
        this.o = jc1.k.f(IHostBusiness.class).showHashTagDialog((Activity) ((Widget) this).context, this.h.liveHotSpotJsonStr, new b(this, r6));
    }

    public final void zq(String r10, String r12) {
        if (this.m == null) goto L30;
        return;
    L30:
        Long r0 = CastLongProtector.valueOf(r10);     // Catch: NumberFormatException -> L28
        if (r0.longValue() != 0) goto L8;
    L13:
        this.l = r12;     // Catch: NumberFormatException -> L28
        if (this.k != 0) goto L17;
    L26:
        ((Widget) this).containerView.setVisibility(8);
        Unit r13 = Unit.INSTANCE;
        return;
    L17:
        if (TextUtils.isEmpty(r12) == true) goto L26;
        if (this.p == false) goto L21;
        ((Widget) this).containerView.setVisibility(0);
        Unit r14 = Unit.INSTANCE;
    L23:
        if (this.h.isMergeVSRoom() == false) goto L25;
        this.a.setText("话题");
        return;
    L25:
        this.a.setText(this.l);
        return;
    L21:
        ((Widget) this).containerView.setVisibility(8);
        Unit r15 = Unit.INSTANCE;
        goto L23
    L8:
        if (this.k == r0.longValue()) goto L13;
        long r1 = r0.longValue();     // Catch: NumberFormatException -> L28
        this.k = r1;     // Catch: NumberFormatException -> L28
        if (this.i == false) goto L12;
        com.bytedance.android.livesdk.log.l.a(r1);     // Catch: NumberFormatException -> L28
        goto L13
    L12:
        HashMap r2 = new HashMap();     // Catch: NumberFormatException -> L28
        r2.put("tag_id", String.valueOf(r1));     // Catch: NumberFormatException -> L28
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_challenge_show", r2, new Object[]{new am2.x(), Room.class});     // Catch: NumberFormatException -> L28
    L28:
        ALogger.e("hash_tag_info", "change hash tag id exception, tagId = " + r10 + ", tagName = " + r12);
    }
}
