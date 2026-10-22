package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskRunStore$loadRunIds$2", f = "CocreationTaskRunStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CocreationTaskRunStore$loadRunIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends String>>, Object> {
    final /* synthetic */ List<e4> $tasks;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ CocreationTaskRunStore this$0;

    public CocreationTaskRunStore$loadRunIds$2(String r1, List<e4> r2, CocreationTaskRunStore r3, Continuation<? super CocreationTaskRunStore$loadRunIds$2> r4) {
        this.$userId = r1;
        this.$tasks = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CocreationTaskRunStore$loadRunIds$2(this.$userId, this.$tasks, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Set<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        if (StringsKt.isBlank(this.$userId) == true) goto L7;
        Sequence r5 = SequencesKt.map(CollectionsKt.asSequence(this.$tasks), new u4());
        final CocreationTaskRunStore r0 = this.this$0;
        final String r1 = this.$userId;
        return SequencesKt.toSet(SequencesKt.filter(r5, new v4(r0, r1)));
    L7:
        return SetsKt.emptySet();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
