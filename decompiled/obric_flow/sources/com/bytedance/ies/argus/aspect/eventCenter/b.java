package com.bytedance.ies.argus.aspect.eventCenter;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.behavior.d f4994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f4995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f4996c;

    public b(com.lynx.tasm.behavior.d r5) {
        Intrinsics.checkNotNullParameter(r5, "depend");
        this.f4994a = r5;
        this.f4995b = LazyKt.lazy(BaseEventCenter$aspectAsyncScope$2.f4984a);
        this.f4996c = LazyKt.lazy(BaseEventCenter$reportScope$2.f4985a);
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }
}
