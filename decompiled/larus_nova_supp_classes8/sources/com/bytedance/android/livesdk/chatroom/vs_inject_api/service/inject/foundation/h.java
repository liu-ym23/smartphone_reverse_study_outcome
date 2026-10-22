package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

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
import vr1.a0;
import vr1.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface h {
    int A();

    wr1.d E(Bundle r1);

    String F();

    int I();

    int J();

    String K();

    void L();

    a0 N();

    String R();

    int S();

    IRoomState U(boolean r1, Bundle r2, Episode r3, Map r4, Map r5, Function0 r6);

    int X();

    void Y(FragmentActivity r1, String r2);

    int a();

    String b0();

    int c();

    int d();

    String e0();

    int f();

    int f0();

    String g();

    String getPlaying();

    int h();

    String i();

    String j();

    int j0();

    void k(String r1, int r2, int r3);

    wr1.c n();

    HashMap<String, String> o(Episode r1, Map<String, String> r2);

    String o0();

    jm1.b q(Bundle r1, Fragment r2, String r3, String r4, ReplayEventHub r5, DataCenter r6);

    int s();

    b0 w();

    int x();

    int y();
}
