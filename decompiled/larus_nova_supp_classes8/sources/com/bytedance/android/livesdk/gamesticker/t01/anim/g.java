package com.bytedance.android.livesdk.gamesticker.t01.anim;

import com.bytedance.android.livesdk.gamesticker.t01.T01GameStickerView;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public final LinkedList<b> a;
    public final f b;
    public final i c;

    public final void a(b r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        i r0 = this.c;
        Intrinsics.checkNotNullParameter(r0, "viewGetter");
        r3.c = r0;
        f r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r3.b = r1;
        this.a.add(r3);
    }

    public g(T01GameStickerView.a r2, T01GameStickerView.b r3) {
        Intrinsics.checkNotNullParameter(r2, "taskListener");
        Intrinsics.checkNotNullParameter(r3, "viewGetter");
        this.b = r2;
        this.c = r3;
        this.a = new LinkedList();
    }
}
