package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ Function1<View, Boolean> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function1<? super View, Boolean> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        Function1<View, Boolean> r0 = this.a;
        Intrinsics.checkNotNull(r2);
        return ((Boolean) r0.invoke(r2)).booleanValue();
    }
}
