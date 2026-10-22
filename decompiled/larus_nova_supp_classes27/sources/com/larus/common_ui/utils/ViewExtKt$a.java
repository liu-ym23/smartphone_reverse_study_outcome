package com.larus.common_ui.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ViewExtKt$a implements Function1<Throwable, Unit> {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ ViewExtKt$awaitScrollEnd$2$listener$1 b;

    public ViewExtKt$a(RecyclerView r1, ViewExtKt$awaitScrollEnd$2$listener$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.removeOnScrollListener(this.b);
        return Unit.INSTANCE;
    }
}
