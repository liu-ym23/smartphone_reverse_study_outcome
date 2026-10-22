package com.bytedance.android.livesdk.jsbridge.methods.draft;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements a {
    public Function1<? super Integer, Unit> a;
    public Function0<Unit> b;
    public Function1<? super Throwable, Unit> c;

    public e(int r4) {
        RealDownloadListener$1 r5 = RealDownloadListener$1.INSTANCE;
        RealDownloadListener$2 r0 = RealDownloadListener$2.INSTANCE;
        RealDownloadListener$3 r1 = RealDownloadListener$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r5, "onProgress");
        Intrinsics.checkNotNullParameter(r0, "onFinish");
        Intrinsics.checkNotNullParameter(r1, "onFail");
        this.a = r5;
        this.b = r0;
        this.c = r1;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void a(Function1<? super Throwable, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.a
    public final void c(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
