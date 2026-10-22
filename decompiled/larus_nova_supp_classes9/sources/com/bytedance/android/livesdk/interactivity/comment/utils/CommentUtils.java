package com.bytedance.android.livesdk.interactivity.comment.utils;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.TopicCommentTip;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommentUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(t r4, DataCenter r5) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L21;
        o r1 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isVSFirstShow() == false) goto L19;
        b(r4, r5);
        EpisodeInteractivityTracer.a("insert seek time message manager");
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 == null) goto L22;
        o r6 = IRoomContextService.a.a(r2, r5, 0, 2);
        if (r6 == null) goto L27;
        com.bytedance.live.datacontext.j r7 = r6.K1();
        if (r7 == null) goto L23;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L24;
        r8.j((tlc.d) r4, true);
        return;
    L24:
        return;
    L23:
        return;
    L27:
        return;
    L22:
        return;
    L19:
        b(r4, r5);
        return;
    }

    public static void b(t r4, DataCenter r5) {
        EpisodeInteractivityTracer.a("insert real time message manager");
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L13;
        o r6 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.j r7 = r6.getMessageManager();
        if (r7 == null) goto L14;
        vlc.d r8 = (vlc.d) r7.getValue();
        if (r8 == null) goto L15;
        r8.j((tlc.d) r4, true);
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    @JvmStatic
    public static final void c(IRoom r1, DataCenter r2) {
        if (r1 == null) goto L13;
        RoomInteractData r3 = r1.getRoomInteractData();
        if (r3 == null) goto L14;
        final TopicCommentTip r4 = r3.getTopicTip();
        if (r4 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.i.b(r2, 1);
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.j<t22.g> r6 = r5.getTopicTipManager();
        if (r6 == null) goto L17;
        r6.e(new CommentUtils$tryCreateTopicTipManager$1$1(r4));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }
}
