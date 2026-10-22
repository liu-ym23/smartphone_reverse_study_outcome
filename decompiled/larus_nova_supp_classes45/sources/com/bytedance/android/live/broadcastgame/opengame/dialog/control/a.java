package com.bytedance.android.live.broadcastgame.opengame.dialog.control;

import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    void F0(String r1);

    void dismiss();

    boolean isShowing();

    void n0(long r1, Function0<Unit> r3);

    void setContent(String r1);

    void setIcon(Drawable r1);

    void setTitle(String r1);

    void show();

    void v(Function0<Unit> r1);

    void y(String r1);
}
