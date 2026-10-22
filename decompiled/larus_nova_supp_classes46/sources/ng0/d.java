package ng0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void a() {
        VoiceChatRoomAnchorView r0 = this.a.e;
        if (r0 == null) goto L5;
        int r7 = r0.getMeasuredWidth();
    L6:
        VoiceChatRoomAnchorView r1 = this.a.e;
        if (r1 == null) goto L9;
        int r8 = r1.getMeasuredHeight();
    L10:
        VoiceChatRoomAnchorView r2 = this.a.e;
        if (r2 == null) goto L15;
        SeatAnimationView r3 = r2.getSeatAnimView();
        if (r3 == null) goto L15;
        r3.o = r7;
        r3.p = r8;
        SeatAnimationView.f(r3.e, r7, r8);
    L15:
        j r4 = m.d().getVideoTalkRoomSubScene();
        if (r4 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L20;
        r5.t();
    L20:
        j r6 = m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r9 == null) goto L25;
        r9.t();
    L25:
        Boolean r10 = m.i().isAnchor();
        if (r10 == null) goto L28;
        boolean r11 = r10.booleanValue();
    L29:
        b r12 = this.a;
        if (r12.b != MicSeatScene.AUDIO_LINK_LARGE) goto L32;
        boolean r13 = true;
    L33:
        VoiceChatRoomAnchorView r14 = r12.e;
        if (r14 == null) goto L39;
        SeatAnimationView r15 = r14.getSeatAnimView();
        if (r15 == null) goto L40;
        r15.c(je0.d.f(), this.a.b, r13, r11, r7, r8);
        return;
    L40:
        return;
    L39:
        return;
    L32:
        r13 = false;
        goto L33
    L28:
        r11 = false;
        goto L29
    L9:
        r8 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
