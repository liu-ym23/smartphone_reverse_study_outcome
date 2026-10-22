package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public final int a;
    public final String b;
    public final int c;
    public final b d;

    public static final class a {
    }

    public interface b {
        void a(CommonStandardBottomDialog r1, View r2, i r3);
    }

    static {
    }

    public i(int r2, String r3, int r4, r0 r5) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r5, "itemClickListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
