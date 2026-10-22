package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements ne0.a {
    public final /* synthetic */ CommonMultiLinkWindowManager a;

    public n(CommonMultiLinkWindowManager r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        CommonMultiLinkWindowManager r4 = this.a;
        r4.l0(r4.d0(), this.a.c0());
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r5 = this.a.h;
        if (r5 == null) goto L10;
        BehaviorSubject<List<tf0.e>> r6 = r5.b;
        if (r6 == null) goto L11;
        List<? extends tf0.e> r7 = (List) r6.getValue();
        if (r7 == null) goto L12;
        this.a.n1(r7);
        return;
    L12:
        return;
    L11:
        return;
    }
}
