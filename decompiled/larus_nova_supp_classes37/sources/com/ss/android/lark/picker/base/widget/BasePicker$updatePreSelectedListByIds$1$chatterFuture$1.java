package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.HashMap;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/HashMap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$updatePreSelectedListByIds$1$chatterFuture$1", f = "BasePicker.kt", i = {}, l = {1755}, m = "invokeSuspend", n = {}, s = {})
public final class BasePicker$updatePreSelectedListByIds$1$chatterFuture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashMap<String, SearchBaseInfo>>, Object> {
    final /* synthetic */ List<String> $chatterIdList;
    int label;
    final /* synthetic */ BasePicker<P, PK> this$0;

    public BasePicker$updatePreSelectedListByIds$1$chatterFuture$1(BasePicker<P, PK> r1, List<String> r2, Continuation<? super BasePicker$updatePreSelectedListByIds$1$chatterFuture$1> r3) {
        this.this$0 = r1;
        this.$chatterIdList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BasePicker$updatePreSelectedListByIds$1$chatterFuture$1(this.this$0, this.$chatterIdList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super HashMap<String, SearchBaseInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        BasePicker<P, PK> r5 = this.this$0;
        List<String> r2 = this.$chatterIdList;
        this.label = 1;
        r4 = BasePicker.access$getSearchEntityByChatterIds(r5, r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
