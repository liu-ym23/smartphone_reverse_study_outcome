package com.bytedance.android.annie.service.prefetch;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Pair r11 = (Pair) r10;
        JSONObject r0 = (JSONObject) r11.component1();
        Object r12 = r11.component2();
        d r1 = this.a;
        View r13 = r1.c;
        if (r13 == null) goto L8;
        if (r12 == null) goto L8;
        r9.d r14 = r1.e;
        if (r14 == null) goto L8;
        r14.updateData(r13, r12, false);
    L8:
        this.a.j(r0);
    }
}
