package com.bytedance.android.live.liveinteract.revenue.game.linker;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.larus.apm.impl.protector.RunnableProtector;
import hg6.g;
import kg6.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends GameRtcRoomController {
    public final C0084b n;
    public final j1 o;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public a(b r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            cg6.a r0 = b.o(this.a);     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            jg6.a r1 = r0.e5();     // Catch: Throwable -> L10
            if (r1 == null) goto L17;
            e r2 = r1.b();     // Catch: Throwable -> L10
            if (r2 == null) goto L18;
            r2.u(this.b, this.c);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L17:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.game.linker.b$b, reason: collision with other inner class name */
    public static final class C0084b extends eg6.a {
        public final /* synthetic */ b a;

        public C0084b(b r1) {
            this.a = r1;
        }

        public final void n(int r3) {
            ALogger.i("GameRtcRoomController", "onLocalUserAudioPublishStateChanged, publishStatus: " + r3);
            b r0 = this.a;
            if (r0.b == true) goto L5;
            return;
        L5:
            if (r3 != 1) goto L9;
            r0.p(true, "onLocalUserAudioPublishStateChanged -> keep mute");
            return;
        }

        public final void k(String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "interactId");
            Intrinsics.checkNotNullParameter(r3, "interactId");
            ALogger.i("GameRtcRoomController", "onRemoteAudioMute, interactId: " + r3 + ", isMuteAudio: " + r4);
            b r0 = this.a;
            if (r0.b == true) goto L5;
            return;
        L5:
            if (r0.a == false) goto L12;
            if (r4 == false) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual(GameRtcRoomController.b(), r3) == false) goto L14;
            this.a.q(r3, true, "onAnchorPublishAudioInMultiLink -> keep mute");
            return;
        L14:
            return;
        }
    }

    private final cg6.a d() {
        return this.o.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController, com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public final void attach() {
        super.attach();
        cg6.a r0 = d();
        if (r0 == null) goto L8;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        r1.h0(this.n);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController, com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public final void detach() {
        super.detach();
        cg6.a r0 = d();
        if (r0 == null) goto L8;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        r1.s(this.n);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController
    public final void l() {
        super.l();
        p(true, "joinGameRtcRoom");
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController
    public final void m() {
        super.m();
        p(false, "leaveGameRtcRoom");
        String r2 = GameRtcRoomController.b();
        if (r2 != null) goto L6;
        ALogger.e("GameRtcRoomController", "onLeaveGameRtcRoom return, cause: anchorRtcUserId == null");
        return;
    L6:
        q(r2, false, "leaveGameRtcRoom");
    }

    public b(j1 r2) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        super(r2);
        this.o = r2;
        this.n = new C0084b(this);
    }

    public static final /* synthetic */ cg6.a o(b r0) {
        return r0.d();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController, com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public final void a(boolean r5) {
        super.a(r5);
        if (this.b == false) goto L22;
        ALogger.i("GameRtcRoomController", "onIsXplayRunningChange: " + r5);
        cg6.a r0 = d();
        if (r0 == null) goto L9;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L9;
        ei6.a r2 = r1.V0();
    L10:
        if (r2 != null) goto L13;
        ALogger.e("GameRtcRoomController", "onIsXplayRunningChange: " + r5 + " return, cause: client == null");
        return;
    L13:
        String r3 = GameRtcRoomController.b();
        if (r3 != null) goto L18;
        ALogger.e("GameRtcRoomController", "onIsXplayRunningChange: " + r5 + " return, cause: anchorRtcUserId == null");
        return;
    L18:
        if (r5 == false) goto L20;
        i(r3, false, "onIsXplayRunningChange");
        q(r3, true, "onIsXplayRunningChange");
        return;
    L20:
        i(r3, true, "onIsXplayRunningChange");
        q(r3, false, "onIsXplayRunningChange");
        return;
    L9:
        r2 = null;
        goto L10
    }

    public final void p(boolean r4, String r5) {
        ALogger.i("GameRtcRoomController", "muteMultiLinkLocalAudioStream, mute: " + r4 + ", reason: " + r5);
        cg6.a r0 = d();
        ei6.a r2 = null;
        if (r0 == null) goto L5;
        g r1 = r0.getRtcManager();
    L6:
        if (r1 != null) goto L9;
        ALogger.w("GameRtcRoomController", "muteMultiLinkLocalAudioStream return, cause: rtcManager is null");
        return;
    L9:
        cg6.a r3 = d();
        if (r3 == null) goto L14;
        g r6 = r3.getRtcManager();
        if (r6 == null) goto L14;
        r2 = r6.V0();
    L14:
        if (r2 != null) goto L17;
        ALogger.w("GameRtcRoomController", "muteMultiLinkLocalAudioStream return, cause: client is null");
        return;
    L17:
        MainThreadPostUtils.b(new a(this, r4, r5));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController
    public final void j(String r3, String r4, boolean r5) {
        ALogger.i("GameRtcRoomController", "onAnchorPublishStreamAudio, roomId: " + r3 + ", uid: " + r4 + ", isPublish: " + r5 + ", isXplayRunning: " + this.a);
        if (r5 == false) goto L21;
        cg6.a r6 = d();
        if (r6 == null) goto L9;
        g r7 = r6.getRtcManager();
        if (r7 == null) goto L9;
        ei6.a r8 = r7.V0();
    L10:
        if (r8 != null) goto L13;
        ALogger.e("GameRtcRoomController", "onAnchorPublishStreamAudio return, cause: client == null");
        return;
    L13:
        if (r4 != null) goto L17;
        ALogger.e("GameRtcRoomController", "onAnchorPublishStreamAudio return, cause: anchorRtcUserId == null");
        return;
    L17:
        if (this.a == false) goto L19;
        q(r4, true, "onAnchorPublishStreamAudio");
        return;
    L19:
        i(r4, true, "onAnchorPublishStreamAudio");
        q(r4, false, "onAnchorPublishStreamAudio");
        return;
    L9:
        r8 = null;
        goto L10
    }

    public final void q(String r4, boolean r5, String r6) {
        ALogger.i("GameRtcRoomController", "muteMultiLinkRemoteAudioStream, interactId: " + r4 + ", mute: " + r5 + ", reason: " + r6);
        cg6.a r0 = d();
        ei6.a r2 = null;
        if (r0 == null) goto L5;
        jg6.a r1 = r0.e5();
    L6:
        if (r1 != null) goto L9;
        ALogger.w("GameRtcRoomController", "muteMultiLinkRemoteAudioStream return, cause: getStatusCenter is null");
        return;
    L9:
        cg6.a r3 = d();
        if (r3 == null) goto L14;
        g r7 = r3.getRtcManager();
        if (r7 == null) goto L14;
        r2 = r7.V0();
    L14:
        if (r2 != null) goto L17;
        ALogger.w("GameRtcRoomController", "muteMultiLinkRemoteAudioStream return, cause: client is null");
        return;
    L17:
        cg6.a r8 = d();
        if (r8 == null) goto L24;
        jg6.a r9 = r8.e5();
        if (r9 == null) goto L24;
        e r10 = r9.b();
        if (r10 == null) goto L24;
        r10.A(r4, r5);
    L24:
        cg6.a r11 = d();
        if (r11 == null) goto L32;
        jg6.a r12 = r11.e5();
        if (r12 == null) goto L33;
        e r13 = r12.b();
        if (r13 == null) goto L34;
        r13.h(r4, r5, r6);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
