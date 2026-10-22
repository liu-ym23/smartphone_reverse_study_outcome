package com.bytedance.android.live.ktv.common.ordersong.feedback;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ KtvMusicFeedbackDialog a;

    public h(KtvMusicFeedbackDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        if (r5 != null) goto L5;
    L14:
        KtvMusicFeedbackDialog r6 = this.a;
        int r0 = KtvMusicFeedbackDialog.o;
        r6.getClass();
        Unit r7 = Unit.INSTANCE;
        return;
    L5:
        if ((!r5.isEmpty()) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L14;
        KtvFeedbackComponentView r1 = (KtvFeedbackComponentView) this.a.X90(2131372271);
        List r8 = r5;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        r2.add(((com.bytedance.android.livesdk.rank.model.b) r9.next()).getCategory());
        goto L11
    L13:
        r1.setData(r2);
    }
}
