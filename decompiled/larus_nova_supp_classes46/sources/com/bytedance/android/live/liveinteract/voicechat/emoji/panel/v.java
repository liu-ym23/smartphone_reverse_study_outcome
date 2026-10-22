package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ s a;

    public v(s r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        r3.printStackTrace();
        s.a r0 = (s.a) ((q46.b) this.a).a;
        if (r0 == null) goto L6;
        r0.G3(r3);
        return;
    }
}
