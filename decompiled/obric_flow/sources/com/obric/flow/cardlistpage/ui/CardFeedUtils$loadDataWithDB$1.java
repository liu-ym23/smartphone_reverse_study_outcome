package com.obric.flow.cardlistpage.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedUtils", f = "CardFeedUtils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {152, 155, 173}, m = "loadDataWithDB", n = {"desc", "appWidgetManager", "appWidgetHost", "headerSpacerHeightPx", "desc", "appWidgetManager", "appWidgetHost", "headerSpacerHeightPx", "desc", "appWidgetManager", "appWidgetHost", "installed", "list", "headerSpacerHeightPx"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class CardFeedUtils$loadDataWithDB$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public CardFeedUtils$loadDataWithDB$1(i r5, Continuation<? super CardFeedUtils$loadDataWithDB$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return i.a(this.this$0, null, null, null, null, 0, this);
    }
}
