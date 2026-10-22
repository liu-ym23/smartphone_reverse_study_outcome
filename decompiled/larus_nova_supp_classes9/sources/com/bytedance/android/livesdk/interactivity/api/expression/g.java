package com.bytedance.android.livesdk.interactivity.api.expression;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ com.bytedance.android.live.base.model.data.activityemoji.b b;

    public g(Function0 r1, com.bytedance.android.live.base.model.data.activityemoji.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0 r2 = this.a;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
        return;
    }
}
