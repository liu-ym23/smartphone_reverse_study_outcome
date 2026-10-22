package com.bytedance.android.live.livepkaudience.dialog;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends b0<BasePkAudienceApplyListContract$View> {
    public abstract void d();

    public abstract void e();

    public abstract void f(boolean r1, String r2, long r3, String r5, int r6);

    public abstract void h();

    public abstract void i(Activity r1);

    public a(BasePkAudienceApplyListContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public static /* synthetic */ void g(a r7, boolean r8, String r9, long r10, String r12, int r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 20;
    L5:
        long r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r12 = "";
    L8:
        String r5 = r12;
        if ((r14 & 16) == 0) goto L11;
        r13 = WaitingListType.UNKNOWN.ordinal();
    L11:
        r7.f(r8, r9, r3, r5, r13);
    }
}
