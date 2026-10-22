package com.bytedance.android.livesdk.gamesticker.hok.anim;

import com.bytedance.android.livesdk.gamesticker.hok.HokGameStickerView;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public final LinkedList<a> a;
    public final d b;
    public final g c;

    public final void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        g r0 = this.c;
        Intrinsics.checkNotNullParameter(r0, "viewGetter");
        r3.c = r0;
        d r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r3.b = r1;
        this.a.add(r3);
    }

    public e(HokGameStickerView.a r2, HokGameStickerView.b r3) {
        Intrinsics.checkNotNullParameter(r2, "taskListener");
        Intrinsics.checkNotNullParameter(r3, "viewGetter");
        this.b = r2;
        this.c = r3;
        this.a = new LinkedList();
    }
}
