package gk0;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final C0214a b = null;
    public final IRoom a;

    /* JADX INFO: renamed from: gk0.a$a, reason: collision with other inner class name */
    public static final class C0214a {
        public C0214a() {
        }

        public static String a() {
            IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
            if (r0 == null) goto L7;
            ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
            if (r1 == null) goto L7;
            String r2 = r1.getEnterFromMerge();
        L9:
            if (TextUtils.isEmpty(r2) == false) goto L11;
            return "live_outside";
        L11:
            return "live_detail";
        L7:
            r2 = null;
            goto L9
        }

        public static String c() {
            t r0 = j0.l().c(x.class);
            if (r0 != null) goto L5;
        L16:
            return "";
        L5:
            if ((r0 instanceof t) == false) goto L16;
            t r1 = r0;
            String r2 = r1.b();
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == true) goto L16;
            String r4 = r1.b();
            if (r4 == null) goto L16;
            return r4;
        L9:
            if (r2.length() == 0) goto L12;
            r3 = false;
            goto L13
        }

        @JvmStatic
        public static LinkMatchType b(Integer r2, Boolean r3) {
            boolean r0 = true;
            if (r2 != null) goto L6;
        L19:
            if (r2 == null) goto L28;
            if (r2.intValue() != 1) goto L28;
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L33;
            return LinkMatchType.TRY_AGAIN;
        L33:
            return LinkMatchType.SHAKE_MATCH;
        L28:
            return LinkMatchType.NONE;
        L6:
            if (r2.intValue() != 0) goto L19;
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L11;
            return LinkMatchType.TRY_AGAIN;
        L11:
            if (Intrinsics.areEqual("song_guide", ChatMatchWidget.o) == true) goto L13;
        L15:
            r0 = false;
        L16:
            if (r0 == false) goto L31;
            return LinkMatchType.SING_MATCH;
        L31:
            return LinkMatchType.MATCH;
        L13:
            if (((IInteractService) k.n(IInteractService.class)).getCurrentScene() != 9) goto L15;
            goto L15
        }
    }

    static {
        b = new C0214a();
    }

    public a(IRoom r1) {
        this.a = r1;
        if (r1 != null) goto L10;
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
    L8:
        this.a = r3;
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "matchType");
        HashMap r0 = new HashMap();
        IRoom r1 = this.a;
        if (r1 != null) goto L5;
    L9:
        String r2 = null;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        TalkRoomLogUtils.Q0(r0);
        r0.put("request_page", ChatMatchWidget.o);
        r0.put("match_type", r5);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L12;
        String r6 = "anchor";
    L13:
        r0.put("user_type", r6);
        IRoom r7 = this.a;
        if (r7 == null) goto L16;
        r2 = r7.getRequestId();
    L16:
        TalkRoomLogUtils.U0(r0, r2);
        j0.l().sendLog("livesdk_connection_match_icon_show", r0, new Object[]{this.a, x.class});
        return;
    L12:
        r6 = "user";
        goto L13
    L5:
        if (r1.isLiveTypeAudio() == false) goto L7;
        String r3 = "voice_live";
    L8:
        r0.put("live_type", r3);
        goto L9
    L7:
        r3 = "video_live";
        goto L8
    }

    public final void a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "matchType");
        Intrinsics.checkNotNullParameter(r6, "cancelType");
        HashMap r0 = new HashMap();
        IRoom r1 = this.a;
        if (r1 != null) goto L5;
    L9:
        String r2 = null;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        TalkRoomLogUtils.Q0(r0);
        r0.put("request_page", ChatMatchWidget.o);
        r0.put("match_type", r5);
        r0.put("cancel_type", r6);
        b.getClass();
        r0.put("match_enter_from", C0214a.a());
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L12;
        String r7 = "anchor";
    L13:
        r0.put("user_type", r7);
        IRoom r8 = this.a;
        if (r8 == null) goto L16;
        r2 = r8.getRequestId();
    L16:
        TalkRoomLogUtils.U0(r0, r2);
        j0.l().sendLog("livesdk_connection_match_cancel", r0, new Object[]{this.a, x.class});
        return;
    L12:
        r7 = "user";
        goto L13
    L5:
        if (r1.isLiveTypeAudio() == false) goto L7;
        String r3 = "voice_live";
    L8:
        r0.put("live_type", r3);
        goto L9
    L7:
        r3 = "video_live";
        goto L8
    }

    public final void b(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "matchType");
        Intrinsics.checkNotNullParameter(r6, "failReason");
        HashMap r0 = new HashMap();
        IRoom r1 = this.a;
        if (r1 != null) goto L5;
    L9:
        String r2 = null;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        TalkRoomLogUtils.Q0(r0);
        r0.put("fail_reason", r6);
        r0.put("request_page", ChatMatchWidget.o);
        r0.put("match_type", r5);
        b.getClass();
        r0.put("match_enter_from", C0214a.a());
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L12;
        String r7 = "anchor";
    L13:
        r0.put("user_type", r7);
        IRoom r8 = this.a;
        if (r8 == null) goto L16;
        r2 = r8.getRequestId();
    L16:
        TalkRoomLogUtils.U0(r0, r2);
        j0.l().sendLog("livesdk_connection_match_fail", r0, new Object[]{this.a, x.class});
        return;
    L12:
        r7 = "user";
        goto L13
    L5:
        if (r1.isLiveTypeAudio() == false) goto L7;
        String r3 = "voice_live";
    L8:
        r0.put("live_type", r3);
        goto L9
    L7:
        r3 = "video_live";
        goto L8
    }

    public final void d(boolean r5, int r6) {
        HashMap r0 = new HashMap();
        IRoom r1 = this.a;
        if (r1 != null) goto L5;
    L9:
        String r2 = null;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        r0.put("request_page", ChatMatchWidget.o);
        if (r5 == false) goto L13;
        String r7 = LinkMatchType.TRY_AGAIN.getValue();
    L16:
        r0.put("match_type", r7);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L19;
        String r8 = "anchor";
    L20:
        r0.put("user_type", r8);
        IRoom r9 = this.a;
        if (r9 == null) goto L23;
        r2 = r9.getRequestId();
    L23:
        TalkRoomLogUtils.U0(r0, r2);
        j0.l().sendLog("livesdk_connection_match_icon_click", r0, new Object[]{this.a, x.class});
        return;
    L19:
        r8 = "user";
        goto L20
    L13:
        if (r6 != 9) goto L15;
        r7 = LinkMatchType.SING_MATCH.getValue();
        goto L16
    L15:
        r7 = LinkMatchType.MATCH.getValue();
        goto L16
    L5:
        if (r1.isLiveTypeAudio() == false) goto L7;
        String r3 = "voice_live";
    L8:
        r0.put("live_type", r3);
        goto L9
    L7:
        r3 = "video_live";
        goto L8
    }
}
