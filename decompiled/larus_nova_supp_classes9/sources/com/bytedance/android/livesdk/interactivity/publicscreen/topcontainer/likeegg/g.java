package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ CompositeImagePreviewDialog a;

    public g(CompositeImagePreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ALogger.d("CompositeImagePreviewDialog", "retry composite image loading");
        Function0<Unit> r3 = this.a.D;
        if (r3 == null) goto L5;
        Unit r4 = (Unit) r3.invoke();
    L5:
        this.a.Y0();
    }
}
