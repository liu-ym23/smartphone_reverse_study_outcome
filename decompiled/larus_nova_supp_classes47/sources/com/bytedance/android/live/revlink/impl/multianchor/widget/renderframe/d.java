package com.bytedance.android.live.revlink.impl.multianchor.widget.renderframe;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ Function0 a;

    public d(Function0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.invoke();
    }
}
