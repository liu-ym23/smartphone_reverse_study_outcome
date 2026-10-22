package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements Disposable {
    public boolean a;
    public boolean b;
    public boolean c;
    public ByteBuffer d;
    public final int e;
    public long f;
    public int g;
    public int h;
    public final Subject<com.bytedance.android.live.broadcastgame.api.xplay.g> i;

    public static final class a {
    }

    static {
    }

    public final void dispose() {
        if (this.a == true) goto L9;
        ByteBuffer r0 = this.d;
        if (r0 == null) goto L7;
        r0.clear();
    L7:
        this.d = null;
        this.i.onComplete();
        this.a = true;
        return;
    }

    public final boolean isDisposed() {
        return this.a;
    }

    public t(PublishSubject r3) {
        Intrinsics.checkNotNullParameter(r3, "frameSink");
        this.i = r3;
        this.c = true;
        this.e = 1000;
        this.f = System.currentTimeMillis();
    }
}
