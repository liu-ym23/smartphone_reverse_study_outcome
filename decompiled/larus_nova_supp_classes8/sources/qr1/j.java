package qr1;

import am2.n;
import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdk.chatroom.helper.EnterRoomTimeTracer;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdk.commerce.LiveAdViewModel;
import com.bytedance.android.livesdk.config.on0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.k;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.player.LivePlayerMonitor;
import com.bytedance.android.livesdk.room.util.ConvertorKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.a0;
import vr1.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h, o {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int A() {
        return 126;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String F() {
        return "ttlive_vs_follow";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int I() {
        return 108;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int J() {
        return 111;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String K() {
        return "duration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void L() {
        com.bytedance.android.livesdk.chatroom.helper.h.a(1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String R() {
        return "apiDuration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int S() {
        return 114;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int X() {
        return 109;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int a() {
        return 105;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String b0() {
        return "ttlive_vs_comment_send_status";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int c() {
        return 107;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int d() {
        return 2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int f() {
        return 120;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int f0() {
        return 118;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String g() {
        return "ttlive_vs_unfollow";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int h() {
        return 123;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String i() {
        return "innerDuration";
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int j0() {
        return 113;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String o0() {
        return "ttlive_vs_info_card_show";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int s() {
        return 112;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int x() {
        return 110;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int y() {
        return 115;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final a0 N() {
        return new nr1.c(new LivePlayerMonitor());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String e0() {
        return EnterRoomTimeTracer.EventName.vs_video_player_try_play.name();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String getPlaying() {
        return EnterRoomTimeTracer.EventName.playing.name();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String j() {
        return EnterRoomTimeTracer.EventName.first_frame.name();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final wr1.c n() {
        return new nr1.a(new com.bytedance.android.livesdk.chatroom.helper.f());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final b0 w() {
        return new nr1.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final wr1.d E(Bundle r2) {
        return new nr1.b(new EnterRoomTimeTracer());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void Y(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "data");
        ((LiveAdViewModel) ViewModelProviders.of(r2).get(LiveAdViewModel.class)).getMobData().setValue(r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final HashMap<String, String> o(Episode r5, Map<String, String> r6) {
        if (r5 == null) goto L5;
        com.bytedance.android.live.base.a r1 = new com.bytedance.android.live.base.a(r5);
    L6:
        com.bytedance.android.livesdk.commerce.a r0 = new com.bytedance.android.livesdk.commerce.a(r1);
        if (TextUtils.isEmpty(l0.a("is_other_channel", j0.l().c(n.class))) == true) goto L9;
        String r2 = l0.a("is_other_channel", j0.l().c(n.class));
    L10:
        r0.g(r2);
        r0.f(l0.a("IESLiveEffectAdTrackExtraServiceKey", j0.l().c(n.class)));
        if (r5 == null) goto L13;
        long r3 = r5.getId();
    L14:
        r0.h(k1.e(r3));
        if (r6 == null) goto L18;
        r0.a.putAll(r6);
    L18:
        return r0.a;
    L13:
        r3 = 0;
        goto L14
    L9:
        r2 = l0.a("is_other_channel", j0.l().c(x.class));
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void k(String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter("-1", "anchorId");
        k.a(r7, r8, -1, "-1", r9);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final IRoomState U(boolean r2, Bundle r3, Episode r4, Map r5, Map r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "eventParams");
        Intrinsics.checkNotNullParameter(r6, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r7, "panelHeight");
        return ConvertorKt.a(r2, r3, r4, r5, r6, r7);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final jm1.b q(Bundle r10, Fragment r11, String r12, String r13, ReplayEventHub r14, DataCenter r15) {
        Intrinsics.checkNotNullParameter(r12, "episodeId");
        Intrinsics.checkNotNullParameter(r13, "userId");
        Intrinsics.checkNotNullParameter(r14, "videoEventHub");
        Intrinsics.checkNotNullParameter(r15, "dataCenter");
        LiveRoomAPMConfig r8 = on0.a.getValue();
        if (r8 != null) goto L5;
    L7:
        return null;
    L5:
        if (r8.enableRoomAPM == false) goto L7;
        return new i(r10, r11, r12, r13, r14, r15, r8);
    }
}
