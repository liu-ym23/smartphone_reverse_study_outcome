package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ RoomIntroLabelSelectDialog a;

    public c(RoomIntroLabelSelectDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        TextView r1 = this.a.g;
        if (r1 == null) goto L10;
        r1.setText(s1.C(2131919918, new Object[]{Integer.valueOf(r6), 3}));
        return;
    L10:
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
