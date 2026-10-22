package com.obric.oui.forms;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OBoxInputView f13328b;

    public /* synthetic */ b(OBoxInputView r5, int r10) {
        this.f13327a = r10;
        this.f13328b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13327a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OBoxInputView r5 = this.f13328b;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        OBoxInputView.e(r5);
        return;
    L6:
        OBoxInputView r10 = this.f13328b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        OBoxInputView.e(r10);
    }
}
