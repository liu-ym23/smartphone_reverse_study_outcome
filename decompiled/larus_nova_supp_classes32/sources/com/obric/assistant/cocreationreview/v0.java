package com.obric.assistant.cocreationreview;

import android.os.Looper;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class v0 implements f5 {
    public final /* synthetic */ CocreationReviewActivity a;

    public /* synthetic */ v0(CocreationReviewActivity r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Activity, com.obric.assistant.cocreationreview.CocreationReviewActivity] */
    @Override // com.obric.assistant.cocreationreview.f5
    public final void a(final i5 r4) {
        final ?? r0 = this.a;
        Set<String> r1 = CocreationReviewActivity.P1;
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        r0.runOnUiThread(new l2(r0, r4));
        return;
    L5:
        r0.d2(r4);
    }
}
