package com.larus.dora.obric.device_management.setting.g.feedback;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements com.larus.dora.impl.feedback.i {
    public final /* synthetic */ DoraObricGFeedbackFragment a;

    public u(DoraObricGFeedbackFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void a(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraObricGFeedbackFragment.b r1 = this.a.j;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, -1);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.g).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void d(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraObricGFeedbackFragment.b r1 = this.a.j;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, 50);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.g).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void e(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        DoraObricGFeedbackFragment.b r1 = this.a.j;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, 100);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.g).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void b(int r3, int r4) {
        pk4.j.d("DoraGFeedbackViewModel", "onUploadNotifyCallback: " + r4);
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        float r1 = 50;
        int r5 = (int) (((r4 * r1) / 100) + r1);
        DoraObricGFeedbackFragment.b r2 = this.a.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r2 = null;
    L11:
        r2.A2(r3, r5);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.g).size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.feedback.i
    public final void c(int r3, int r4) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L13;
        int r5 = (int) ((r4 * 50) / 100);
        DoraObricGFeedbackFragment.b r1 = this.a.j;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r1 = null;
    L11:
        r1.A2(r3, r5);
        return;
    L13:
        return;
    L5:
        if (r3 >= ((ArrayList) this.a.g).size()) goto L7;
        r0 = true;
        goto L7
    }
}
