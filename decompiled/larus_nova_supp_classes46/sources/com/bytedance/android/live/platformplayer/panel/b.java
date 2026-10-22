package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements jg1.a {
    public final ClearScreenConst.InteractType a;

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return false;
    }

    public final void c() {
    }

    public final long d() {
        return 300;
    }

    public final boolean e(jg1.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return true;
    }

    public final void f() {
    }

    public b() {
        this.a = ClearScreenConst.InteractType.GAME_PANEL_CLEAR;
    }

    public final ClearScreenConst.AnimType g() {
        return ClearScreenConst.AnimType.TRANS;
    }

    public final ClearScreenConst.InteractType getInteractType() {
        return this.a;
    }
}
