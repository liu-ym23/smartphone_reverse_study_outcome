package com.bytedance.salamander.anniex;

import com.bytedance.salamander.adapter.Lock;
import com.bytedance.salamander.adapter.Queue;
import com.bytedance.salamander.adapter.SLThread;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a0 f7242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f7243c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f7244a;

    static {
        f7243c = new Lock();
    }

    public a0() {
        this.f7244a = new Queue("anniex.salamander.monitor", true);
    }

    public final void a(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "workLoad");
        SLThread.Companion r5 = SLThread.Companion;
        Queue r11 = this.f7244a;
        Intrinsics.checkNotNull(r11);
        SLThread.Companion.runOnThread$default(r5, r10, r11, 0.0d, 4, null);
    }
}
