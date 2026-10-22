package fq1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.ReplayEventHub;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.room.state.IRoomState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.a0;
import vr1.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h, com.bytedance.android.scope.o {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int A() {
        return this.a.A();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final wr1.d E(Bundle r2) {
        return this.a.E(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String F() {
        return this.a.F();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int I() {
        return this.a.I();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int J() {
        return this.a.J();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String K() {
        return this.a.K();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void L() {
        this.a.L();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final a0 N() {
        return this.a.N();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String R() {
        return this.a.R();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int S() {
        return this.a.S();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final IRoomState U(boolean r9, Bundle r10, Episode r11, Map r12, Map r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r10, "extra");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r12, "eventParams");
        Intrinsics.checkNotNullParameter(r13, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r14, "panelHeight");
        return this.a.U(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int X() {
        return this.a.X();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void Y(FragmentActivity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.Y(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int a() {
        return this.a.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String b0() {
        return this.a.b0();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int d() {
        return this.a.d();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String e0() {
        return this.a.e0();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int f() {
        return this.a.f();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int f0() {
        return this.a.f0();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String g() {
        return this.a.g();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String getPlaying() {
        return this.a.getPlaying();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String i() {
        return this.a.i();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String j() {
        return this.a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int j0() {
        return this.a.j0();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final void k(String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter("-1", "anchorId");
        this.a.k(r3, r4, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final wr1.c n() {
        return this.a.n();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final HashMap<String, String> o(Episode r2, Map<String, String> r3) {
        return this.a.o(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final String o0() {
        return this.a.o0();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final jm1.b q(Bundle r9, Fragment r10, String r11, String r12, ReplayEventHub r13, DataCenter r14) {
        Intrinsics.checkNotNullParameter(r11, "episodeId");
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "videoEventHub");
        Intrinsics.checkNotNullParameter(r14, "dataCenter");
        return this.a.q(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int s() {
        return this.a.s();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final b0 w() {
        return this.a.w();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int x() {
        return this.a.x();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h
    public final int y() {
        return this.a.y();
    }

    public i(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.h r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorService");
        this.a = r2;
    }
}
