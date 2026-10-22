package com.bytedance.android.live.room.share.summersinging;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public m(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r2) {
        this.a.invoke(r2);
    }
}
