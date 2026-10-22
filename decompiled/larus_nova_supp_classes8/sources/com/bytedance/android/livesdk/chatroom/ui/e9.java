package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e9 implements Observer<Long> {
    public final /* synthetic */ d9 a;

    public final void onComplete() {
        this.a.b();
    }

    public e9(d9 r1) {
        this.a = r1;
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        ALogger.e("RoomTimer", "timer error: " + r3.getMessage());
        this.a.b();
    }

    public final void onNext(Object r10) {
        long r6 = ((Number) r10).longValue();
        Iterator r11 = ((ArrayList) this.a.b).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        d9.c r8 = (d9.c) r11.next();
        d9.b r0 = r8.c;
        if (r0 == null) goto L4;
        if (r0.a(r6, this.a.e, r8.b) != true) goto L4;
        r8.b++;
        goto L4
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.a = r2;
    }
}
