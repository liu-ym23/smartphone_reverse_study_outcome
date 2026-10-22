package com.bytedance.android.live.componentsmarket.impl.components.title;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ TitleTetris a;

    public b(TitleTetris r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        TitleTetris r0 = this.a;
        if (((Boolean) r3).booleanValue() == false) goto L7;
        TextView r4 = r0.s;
        if (r4 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r4);
    L10:
        TextView r5 = r0.u;
        if (r5 == null) goto L13;
        a1.m(r5, s1.f(4.0f));
    L13:
        TextView r6 = r0.u;
        if (r6 == null) goto L17;
        UtilityKotlinExtentionsKt.w(r6);
        return;
    L17:
        return;
    L7:
        TextView r7 = r0.s;
        if (r7 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r7);
        goto L10
    }
}
