package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n {
    public final int a;
    public String b;
    public int c;
    public final b d;

    public static final class a {
    }

    public interface b {
        void a(OPPluginMoreDialog r1, View r2, n r3);
    }

    static {
    }

    public n(int r2, String r3, int r4, OPPluginMoreDialog$getItemClickListener$1 r5) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "itemClickListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
