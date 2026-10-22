package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.picker.Searcher;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/search/dto/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoader$search$searchResponse$1$1", f = "DoubaoMentionRecommendDataLoader.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoMentionRecommendDataLoader$search$searchResponse$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
    final /* synthetic */ SearcherConfig $config;
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $requestId;
    int label;

    public DoubaoMentionRecommendDataLoader$search$searchResponse$1$1(String r1, String r2, SearcherConfig r3, Continuation<? super DoubaoMentionRecommendDataLoader$search$searchResponse$1$1> r4) {
        this.$requestId = r1;
        this.$keyword = r2;
        this.$config = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoubaoMentionRecommendDataLoader$search$searchResponse$1$1(this.$requestId, this.$keyword, this.$config, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Searcher r2 = new Searcher(null, 1, null);
        String r12 = this.$requestId;
        String r3 = this.$keyword;
        SearcherConfig r4 = this.$config;
        this.label = 1;
        r11 = Searcher.search$default(r2, r12, r3, r4, false, true, this, 8, null);
        if (r11 != r0) goto L11;
        return r0;
    }
}
