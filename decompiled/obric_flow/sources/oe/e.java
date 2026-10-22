package oe;

import com.bytedance.ies.xelement.LynxNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxNestedScrollView f20552a;

    public e(LynxNestedScrollView r5) {
        this.f20552a = r5;
    }

    @Override // oe.b
    public final void a(int r5, int r10, int r11, int r12) {
    }

    @Override // oe.b
    public final void a(int r5) {
        LynxNestedScrollView r10 = this.f20552a;
        if (r10.d == true) goto L8;
        if (r5 == 0) goto L11;
        r10.recognizeGesturere();
        return;
    L11:
        return;
    L8:
        if (r5 != 1) goto L12;
        r10.recognizeGesturere();
        return;
    }
}
