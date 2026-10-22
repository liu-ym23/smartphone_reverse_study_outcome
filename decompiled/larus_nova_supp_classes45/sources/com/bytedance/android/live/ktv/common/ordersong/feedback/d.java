package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.widget.LinearLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ KtvFeedbackDialog a;

    public d(KtvFeedbackDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        List r6 = (List) r5;
        KtvFeedbackDialog r0 = this.a;
        int r1 = KtvFeedbackDialog.u;
        if (r6 == null) goto L15;
        KtvFeedbackComponentView r2 = (KtvFeedbackComponentView) r0.X90(2131372271);
        List r7 = r6;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r3.add(((com.bytedance.android.livesdk.rank.model.b) r8.next()).getCategory());
        goto L6
    L8:
        r2.setData(r3);
        if (r0.s == false) goto L11;
    L14:
        ((LinearLayout) r0.X90(2131372277)).setVisibility(0);
        return;
    L11:
        if (r0.t == false) goto L14;
        ((LinearLayout) r0.X90(2131372277)).setVisibility(8);
        return;
    L15:
        r0.getClass();
    }
}
