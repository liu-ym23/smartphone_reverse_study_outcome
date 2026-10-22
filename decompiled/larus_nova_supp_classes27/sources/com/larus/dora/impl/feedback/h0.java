package com.larus.dora.impl.feedback;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 implements i {
    public final /* synthetic */ DoraGFeedbackFragment a;

    public h0(DoraGFeedbackFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void a(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraGFeedbackFragment.ImagePreviewAdapter r1 = this.a.l;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, -1);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.k).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void d(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraGFeedbackFragment.ImagePreviewAdapter r1 = this.a.l;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, this.a.i);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.k).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void e(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraGFeedbackFragment.ImagePreviewAdapter r1 = this.a.l;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, 100);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.k).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void b(int r4, int r5) {
        pk4.j.d("DoraGFeedbackViewModel", "onUploadNotifyCallback: " + r5);
        boolean r0 = false;
        if (r4 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraGFeedbackFragment r1 = this.a;
        int r2 = r1.i;
        int r6 = (int) (((r5 * (100 - r2)) / 100) + r2);
        DoraGFeedbackFragment.ImagePreviewAdapter r3 = r1.l;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r3 = null;
    L11:
        r3.A2(r4, r6);
        return;
    L13:
        return;
    L5:
        if (r4 >= ((ArrayList) this.a.k).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void c(int r3, int r4) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraGFeedbackFragment r1 = this.a;
        int r5 = (int) ((r4 * r1.i) / 100);
        DoraGFeedbackFragment.ImagePreviewAdapter r2 = r1.l;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r2 = null;
    L11:
        r2.A2(r3, r5);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.k).size()) goto L7;
        r0 = true;
        goto L7
    }
}
