package com.bytedance.android.live.broadcast.api.camera;

import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final Lazy a;
    public final b b;
    public Disposable c;
    public String d;
    public final com.bytedance.android.live.pushstream.d e;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.api.camera.a$a, reason: collision with other inner class name */
    public static final class C0016a {
    }

    static {
    }

    public a(com.bytedance.android.live.pushstream.d r3) {
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        Intrinsics.checkNotNullParameter("live_take_page", "eventPage");
        this.e = r3;
        this.a = LazyKt.lazy(CameraDirtyCheckController$mainHandler$2.INSTANCE);
        this.b = new b();
        this.d = "";
    }
}
