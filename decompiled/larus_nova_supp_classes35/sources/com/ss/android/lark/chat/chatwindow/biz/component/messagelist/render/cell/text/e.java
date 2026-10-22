package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnAttachStateChangeListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ View c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.element = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.element = false;
        this.b.invoke();
        this.c.removeOnAttachStateChangeListener(this);
    }

    public e(Ref.BooleanRef r1, Function0<Unit> r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
