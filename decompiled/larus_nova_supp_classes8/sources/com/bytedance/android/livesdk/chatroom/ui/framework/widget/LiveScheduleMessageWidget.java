package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.model.ScheduledSettingInfo;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/LiveScheduleMessageWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScheduleMessageWidget extends MiddlewareRoomWidget implements vlc.l {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public vlc.d c;
    public Handler d;
    public b0 e;
    public boolean f;

    public static final class a implements Runnable {
        public final /* synthetic */ LiveScheduleMessageWidget a;
        public final /* synthetic */ e2 b;

        public a(LiveScheduleMessageWidget r1, e2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            vlc.d r0 = n3.e(((Widget) this.a).dataCenter);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.j(this.b, true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void wq() {
        if (this.f == false) goto L5;
        return;
    L5:
        if (isViewValid() == false) goto L81;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(getComponentContext());
        e2 r3 = null;
        String r4 = "";
        if (r0 != null) goto L10;
    L43:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = ho1.a.d(getComponentContext());
        if (r1 == null) goto L46;
        Room r2 = r1.getRoom();
    L47:
        if (r2 != null) goto L49;
    L56:
        String r5 = null;
    L57:
        if (r5 != null) goto L59;
    L62:
        boolean r6 = true;
    L63:
        if (r6 == false) goto L65;
        r5 = null;
    L65:
        if (r5 != null) goto L67;
        return;
    L67:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = ho1.a.d(getComponentContext());
        if (r7 == null) goto L70;
        Room r8 = r7.getRoom();
    L71:
        if (r8 == null) goto L73;
        r3 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.i.a(r8.getId(), r8.getOwner(), r5);
    L73:
        if (r3 == null) goto L75;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r3, PSMessageAction.CHAT);
    L75:
        Handler r9 = this.d;
        if (r9 == null) goto L78;
        r9.postDelayed(new a(this, r3), 2000);
    L78:
        this.f = true;
        HashMap r10 = new HashMap();
        r10.put("enter_from_merge", "live_message");
        com.bytedance.android.livesdk.log.u.l().sendLog("live_timetable_show", r10, new Object[0]);
        return;
    L70:
        r8 = null;
        goto L71
    L59:
        if (r5.length() == 0) goto L62;
        r6 = false;
        goto L63
    L49:
        if (TextUtils.isEmpty(r2.anchorScheduledTimeText) == true) goto L56;
        String r11 = r2.anchorScheduledTimeText;
        if (r11 == null) goto L55;
        r4 = r11;
    L55:
        r5 = r4;
        goto L57
    L46:
        r2 = null;
        goto L47
    L10:
        if (r0.dg() != true) goto L43;
        IAnnouncementService r12 = jc1.k.f(IAnnouncementService.class);
        if (r12 != null) goto L14;
    L28:
        ScheduledSettingInfo r13 = (ScheduledSettingInfo) ((Widget) this).dataCenter.get("data_live_scheduled_info", null);
        if (r13 == null) goto L56;
        if (TextUtils.isEmpty(r13.getScheduledTimeWords()) == true) goto L56;
        if (r13.getMasterSwitch() == false) goto L56;
        String r14 = r13.getScheduledTimeWords();
        if (r14 == null) goto L40;
        r4 = r14;
    L40:
        if (TextUtils.isEmpty(r4) == true) goto L56;
        r5 = s1.C(2131916706, new Object[]{r4});
        goto L57
    L14:
        if (r12.enable() == false) goto L28;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r15 = this.a;
        if (r15 == null) goto L18;
        FragmentActivity r16 = r15.p0();
    L20:
        if (r12.announcementIsOpen(r16) == false) goto L40;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r17 = this.a;
        if (r17 == null) goto L24;
        FragmentActivity r18 = r17.p0();
    L25:
        AnnouncementInfo r19 = r12.getAnnouncementInfo(r18, null);
        if (r19 == null) goto L40;
        r4 = r19.scheduledTimeText;
        goto L40
    L24:
        r18 = null;
        goto L25
    L18:
        r16 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        this.d = new Handler(Looper.getMainLooper());
        this.c = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.dg();
    L6:
        if (r1 == false) goto L10;
        vlc.d r2 = this.c;
        if (r2 == null) goto L17;
        r2.addMessageListener(MessageType.ROOM.getIntType(), this);
        return;
    L17:
        return;
    L10:
        HashSet r5 = new HashSet();
        r5.add(Integer.valueOf(MessageType.ROOM.getIntType()));
        b0 r3 = new b0(this, r5, r5, new HashSet(), new dmc.d(0));
        this.e = r3;
        vlc.d r4 = this.c;
        int r6 = d4.a;
        if ((r4 instanceof dmc.a) == true) goto L13;
        r4 = null;
    L13:
        dmc.a r7 = (dmc.a) r4;
        if (r7 == null) goto L19;
        r7.C(r3);
        return;
    L19:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        b0 r0 = this.e;
        if (r0 == null) goto L11;
        vlc.d r2 = this.c;
        int r3 = d4.a;
        if ((r2 instanceof dmc.a) == true) goto L7;
        r2 = null;
    L7:
        dmc.a r4 = (dmc.a) r2;
        if (r4 == null) goto L10;
        r4.o(r0);
    L10:
        this.e = null;
    L11:
        vlc.d r1 = this.c;
        if (r1 == null) goto L14;
        r1.removeMessageListener(this);
    L14:
        Handler r5 = this.d;
        if (r5 == null) goto L17;
        r5.removeCallbacksAndMessages(null);
    L17:
        this.d = null;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L23;
        vlc.d r7 = (vlc.d) r6.get("data_message_manager", null);
        if (r7 == null) goto L24;
        r7.removeMessageListener(this);
        return;
    L24:
        return;
    }

    public LiveScheduleMessageWidget() {
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2.getMessageMethod(), MessageType.ROOM.getWsMethod()) == false) goto L8;
        wq();
        return;
    }
}
