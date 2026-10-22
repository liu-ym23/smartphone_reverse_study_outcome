package com.bytedance.ies.xelement.input;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f6449b;

    public /* synthetic */ m(o r5, int r10) {
        this.f6448a = r10;
        this.f6449b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f6448a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        o r5 = this.f6449b;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.f.c();
        r5.c();
        return;
    L6:
        o r10 = this.f6449b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.f.c();
        r10.c();
    }
}
