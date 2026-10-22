package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$flushPending$result$1$1", f = "DoubaoChatterTagEnricher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoChatterTagEnricher$flushPending$result$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends DoubaoLocalChatterTagState>>, Object> {
    final /* synthetic */ List<String> $ids;
    final /* synthetic */ DoubaoChatterTagEnricher $this_runCatching;
    int label;

    public DoubaoChatterTagEnricher$flushPending$result$1$1(DoubaoChatterTagEnricher r1, List<String> r2, Continuation<? super DoubaoChatterTagEnricher$flushPending$result$1$1> r3) {
        this.$this_runCatching = r1;
        this.$ids = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoubaoChatterTagEnricher$flushPending$result$1$1(this.$this_runCatching, this.$ids, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, DoubaoLocalChatterTagState>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return DoubaoChatterTagEnricher.access$getProvider$p(this.$this_runCatching).getTagStatesByChatterIds(this.$ids);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
