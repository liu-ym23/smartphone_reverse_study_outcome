package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ TuningEffectListView a;

    public e(TuningEffectListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List<h> r5 = (List) r4;
        if ((!r5.isEmpty()) == false) goto L16;
        this.a.setDataAndNotify(r5);
        Iterator<T> r6 = r5.iterator();
        int r0 = 0;
    L6:
        if (r6.hasNext() == false) goto L22;
        T r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        h r3 = (h) r1;
        if (r3.a == false) goto L15;
        if (TuningEffectListView.r(this.a).y2(r3) < 0) goto L15;
        TuningEffectListView r7 = this.a;
        r7.smoothScrollToPosition(TuningEffectListView.r(r7).y2(r3));
        return;
    L15:
        r0 = r2;
        goto L6
    L22:
        return;
    }
}
