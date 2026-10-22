package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import java.util.List;
import xh0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {
    void Cm(int r1);

    void F1(Object r1, SceneType r2);

    g M5(long r1, String r3, List r4);

    boolean Rh();

    com.bytedance.android.live.liveinteract.multiscene.a X2();

    boolean ck();

    void d3(String r1);

    void d6(JsonObject r1);

    JsonObject e2(JsonObject r1);

    void e5(int r1, int r2, long r3, String r5);

    String g3();

    li0.b.a g4();

    boolean isTeamFightShowing();

    void n5(DataCenter r1);

    TeamFightContext o3();

    g rl();

    boolean z3();

    boolean zh();
}
