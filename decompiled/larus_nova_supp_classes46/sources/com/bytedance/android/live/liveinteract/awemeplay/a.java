package com.bytedance.android.live.liveinteract.awemeplay;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import hd0.c;
import hh1.v0;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;
import td0.b;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements IMiddlewareHostBusiness.AwemeQueryCallBack {
    public final /* synthetic */ LiveAwemeVideoPlayWidget.c a;
    public final /* synthetic */ x0 b;
    public final /* synthetic */ Long c;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.awemeplay.a$a, reason: collision with other inner class name */
    public static final class C0019a implements IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback {
        public final /* synthetic */ a a;

        public final void onPlaying(String r1) {
        }

        public final void onResumePlay(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
        }

        public final void onDismiss() {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).P1();
            if (r0 == null) goto L6;
            r0.setValue(Boolean.FALSE);
            return;
        }

        public final void onShow() {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).P1();
            if (r0 == null) goto L6;
            r0.setValue(Boolean.TRUE);
            return;
        }

        public C0019a(a r1) {
            this.a = r1;
        }

        public final void onPlayCompletedFirstTime(String r8) {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r0 == null) goto L7;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L7;
            String r2 = r1.getOwnerUserIdString();
        L8:
            m r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r3 == null) goto L13;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L13;
            Long r5 = Long.valueOf(r4.getRoomId());
        L14:
            m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).Y1();
            if (r6 == null) goto L18;
            String r7 = (String) r6.getValue();
            if (r7 == null) goto L18;
        L19:
            if (r2 == null) goto L23;
            if (r5 == null) goto L24;
            long r9 = r5.longValue();
            Map<Integer, String> r10 = b.a;
            Intrinsics.checkNotNullParameter(r2, "anchorId");
            Intrinsics.checkNotNullParameter(r7, "playSource");
            LinkedHashMap r11 = new LinkedHashMap();
            TalkRoomLogUtils.J0(r11);
            r11.put("anchor_id", r2);
            r11.put("room_id", String.valueOf(r9));
            b.c(r11);
            TalkRoomLogUtils.B0(r11, null, null, 6);
            r11.put("video_id", String.valueOf(r8));
            r11.put("play_source", r7);
            j0.l().sendLog("livesdk_chatroom_video_play_finish", r11, new Object[0]);
            ALogger.i("LiveVideoCommentPlayLog", "livesdk_chatroom_video_play_finish: video_id=" + r8);
            return;
        L24:
            return;
        L23:
            return;
        L18:
            r7 = "";
        L13:
            r5 = null;
        L7:
            r2 = null;
            goto L8
        }

        public final void onRenderFirstFrame(String r8) {
            m r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r0 == null) goto L7;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L7;
            String r2 = r1.getOwnerUserIdString();
        L8:
            m r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r3 == null) goto L13;
            IRoom r4 = (IRoom) r3.getValue();
            if (r4 == null) goto L13;
            Long r5 = Long.valueOf(r4.getRoomId());
        L14:
            m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).Y1();
            if (r6 == null) goto L18;
            String r7 = (String) r6.getValue();
            if (r7 == null) goto L18;
        L19:
            if (r2 == null) goto L23;
            if (r5 == null) goto L24;
            long r9 = r5.longValue();
            Map<Integer, String> r10 = b.a;
            Intrinsics.checkNotNullParameter(r2, "anchorId");
            Intrinsics.checkNotNullParameter(r7, "playSource");
            LinkedHashMap r11 = new LinkedHashMap();
            TalkRoomLogUtils.J0(r11);
            r11.put("anchor_id", r2);
            r11.put("room_id", String.valueOf(r9));
            b.c(r11);
            TalkRoomLogUtils.B0(r11, null, null, 6);
            r11.put("video_id", String.valueOf(r8));
            r11.put("play_source", r7);
            j0.l().sendLog("livesdk_chatroom_video_play", r11, new Object[0]);
            ALogger.i("LiveVideoCommentPlayLog", "livesdk_chatroom_video_play: video_id=" + r8);
            return;
        L24:
            return;
        L23:
            return;
        L18:
            r7 = "";
        L13:
            r5 = null;
        L7:
            r2 = null;
            goto L8
        }

        public final void onPlayFailed(String r3, String r4) {
            Map<Integer, String> r0 = b.a;
            ALogger.i("LiveVideoCommentPlayLog", "video play failed: videoId=" + r3 + "， error=" + r4);
        }

        public final void onPausePlay(String r7, long r8, String r10) {
            Intrinsics.checkNotNullParameter(r10, "source");
            m r11 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r11 == null) goto L7;
            IRoom r12 = (IRoom) r11.getValue();
            if (r12 == null) goto L7;
            String r13 = r12.getOwnerUserIdString();
        L8:
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).getRoom();
            if (r1 == null) goto L13;
            IRoom r2 = (IRoom) r1.getValue();
            if (r2 == null) goto L13;
            Long r3 = Long.valueOf(r2.getRoomId());
        L14:
            m r4 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a.a).Y1();
            if (r4 == null) goto L18;
            String r5 = (String) r4.getValue();
            if (r5 == null) goto L18;
        L19:
            if (r13 == null) goto L23;
            if (r3 == null) goto L24;
            long r6 = r3.longValue();
            Map<Integer, String> r9 = b.a;
            Intrinsics.checkNotNullParameter(r13, "anchorId");
            Intrinsics.checkNotNullParameter(r5, "playSource");
            LinkedHashMap r14 = new LinkedHashMap();
            TalkRoomLogUtils.J0(r14);
            r14.put("anchor_id", r13);
            r14.put("room_id", String.valueOf(r6));
            b.c(r14);
            TalkRoomLogUtils.B0(r14, null, null, 6);
            r14.put("video_id", String.valueOf(r7));
            r14.put("duration", String.valueOf(r8));
            r14.put("play_source", r5);
            j0.l().sendLog("livesdk_chatroom_video_play_time", r14, new Object[0]);
            ALogger.i("LiveVideoCommentPlayLog", "livesdk_chatroom_video_play_time: video_id=" + r7 + "， duration=" + r8);
            return;
        L24:
            return;
        L23:
            return;
        L18:
            r5 = "";
        L13:
            r3 = null;
        L7:
            r13 = null;
            goto L8
        }
    }

    public final void onBatchSuccess(HashMap<Long, Object> r1) {
    }

    public static void a(x0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onSuccess(Object r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "aweme");
        a(this.b);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.j(this.a.a).isAnchor(), Boolean.TRUE) == false) goto L6;
        int r5 = 1;
    L9:
        IMiddlewareHostBusiness r0 = k.n(IMiddlewareHostBusiness.class);
        LiveAwemeVideoPlayWidget r9 = this.a.a;
        Context r2 = ((Widget) r9).context;
        com.bytedance.android.live.pushstream.d r1 = null;
        if (r9.b == false) goto L25;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L16;
        rj0.k r10 = rj0.k.a.a();
        if (r10 == null) goto L16;
        com.bytedance.android.live.pushstream.d r11 = r10.getLiveStream();
    L17:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L22;
        com.bytedance.android.live.liveinteract.voicechat.d r12 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r12 == null) goto L23;
        r1 = r12.Ri();
    L23:
        if (r1 != null) goto L46;
        r1 = r9.e;
    L46:
        if (r1 == null) goto L50;
        d0 r13 = r1.A();
        if (r13 == null) goto L50;
        r13.h();
    L50:
        IMiddlewareHostBusiness.AwemeVideoPlayFragment r14 = r0.getLivePureVideoPlayFragment(r7, r2, 0, r5);
        FragmentManager r15 = this.a.a.d;
        if (r15 == null) goto L60;
        if (r14 == null) goto L60;
        DialogFragment r16 = r14.asDialogFragment();
        if (r16 == null) goto L60;
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, "LiveAwemeVideoPlayWidget", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r16, r3) == true) goto L60;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
    L59:
        r16.show(r15, "LiveAwemeVideoPlayWidget");
    L60:
        if (r14 == null) goto L66;
        r14.setCallback(new C0019a(this));
        return;
    L66:
        return;
    L22:
        r1 = r11;
    L16:
        r11 = null;
        goto L17
    L25:
        l.n2.getClass();
        if (l.a.a() == null) goto L30;
        l r17 = l.a.a();
        if (r17 == null) goto L30;
        com.bytedance.android.live.pushstream.d r18 = r17.getLiveStream();
    L31:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L37;
        IVoiceChatGuestService r19 = IVoiceChatGuestService.a.a();
        if (r19 == null) goto L36;
        r18 = r19.guestLiveStream();
        goto L37
    L36:
        r18 = null;
    L37:
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.b.a.a() == null) goto L45;
        if (r18 != null) goto L45;
        com.bytedance.android.live.liveinteract.plantform.base.b r20 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r20 == null) goto L46;
        v0 r21 = r20.getLiveVideoClientFactory();
        if (r21 == null) goto L46;
        r1 = r21.getLiveStream();
    L45:
        r1 = r18;
    L30:
        r18 = null;
        goto L31
    L6:
        if (c.f().h() == false) goto L8;
        r5 = 2;
        goto L9
    L8:
        r5 = 3;
        goto L9
    }

    public a(LiveAwemeVideoPlayWidget.c r1, x0 r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFailure(String r2, String r3, String r4) {
        a(this.b);
        if (r3 == null) goto L5;
        f2.c(r3, 0);
    L5:
        if (r4 == null) goto L7;
        f2.c(s1.B(2131916038), 0);
    L7:
        Map<Integer, String> r5 = b.a;
        ALogger.i("LiveVideoCommentPlayLog", "video query aweme/detial: videoId=" + String.valueOf(this.c.longValue()) + "， error=" + r2);
    }
}
