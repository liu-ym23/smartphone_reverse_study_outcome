package com.bytedance.android.monitorV2.executor;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f3572b;

    public /* synthetic */ a(int r5, Function0 r10) {
        this.f3571a = r5;
        this.f3572b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3571a) {
            case 0: goto L23;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        this.f3572b.invoke();
        return;
    L6:
        this.f3572b.invoke();
        return;
    L8:
        this.f3572b.invoke();
        return;
    L10:
        this.f3572b.invoke();
        return;
    L12:
        this.f3572b.invoke();
        return;
    L14:
        this.f3572b.invoke();
        return;
    L16:
        this.f3572b.invoke();
        return;
    L23:
        this.f3572b.invoke();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        h.g("default_handle", e);
    }

    public a(Function0 r5) {
        this.f3571a = 7;
        Intrinsics.checkNotNullParameter(r5, "function");
        this.f3572b = r5;
    }
}
