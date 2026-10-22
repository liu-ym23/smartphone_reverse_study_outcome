package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.View;
import com.bytedance.android.live.base.model.data.n;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LikeEggTemplatePreviewDialog a;

    public b(LikeEggTemplatePreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        LikeEggTemplatePreviewDialog r4 = this.a;
        n.a r5 = (n.a) CollectionsKt.getOrNull(r4.K, r4.Q);
        if (r5 == null) goto L10;
        k r6 = r5.templatePhoto;
        if (r6 == null) goto L11;
        LikeEggTemplatePreviewDialog r0 = this.a;
        Function2<? super k, ? super Integer, Unit> r1 = r0.L;
        if (r1 == null) goto L12;
        Unit r7 = (Unit) r1.invoke(r6, Integer.valueOf(r0.Q));
        return;
    L12:
        return;
    L11:
        return;
    }
}
