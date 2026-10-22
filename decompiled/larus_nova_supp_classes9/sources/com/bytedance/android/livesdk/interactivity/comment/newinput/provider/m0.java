package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 implements View.OnClickListener {
    public final /* synthetic */ j0.c a;

    public m0(j0.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.a.o.a;
        if (r3 == null) goto L5;
        r3.y0();
    L5:
        this.a.h(false);
        i40.h.a("V3 landscape on emoji click");
        j0.c.g(this.a, "emoji");
        com.bytedance.android.livesdk.sharedpref.f.d(this.a.j(), 3);
        ImageView r4 = this.a.e;
        if (r4 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    }
}
