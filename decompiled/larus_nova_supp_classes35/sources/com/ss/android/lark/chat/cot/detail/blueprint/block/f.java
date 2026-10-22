package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ Function0<Unit> a;

    public f(Function0<Unit> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.invoke();
    }
}
