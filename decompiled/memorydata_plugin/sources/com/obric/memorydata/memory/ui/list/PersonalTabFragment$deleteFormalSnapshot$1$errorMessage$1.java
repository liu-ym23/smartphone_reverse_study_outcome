package com.obric.memorydata.memory.ui.list;

import android.database.sqlite.SQLiteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1", f = "PersonalTabFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Integer>, Object> {
    final /* synthetic */ List<PersonalTabFragment.b> $items;
    int label;

    PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1(List<PersonalTabFragment.b> r3, Continuation<? super PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1> r4) {
        List<PersonalTabFragment.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$items = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1(this.$items, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Integer> r4) {
        return ((PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalTabFragment$deleteFormalSnapshot$1$errorMessage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r8);
        com.obric.memorydata.memory.memoryentity.d r9 = com.obric.memorydata.memory.memoryentity.d.f10317a;     // Catch: SQLiteException -> L14
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(this.$items, Iterable.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L14
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L14
        Iterator r10 = r7.iterator();     // Catch: SQLiteException -> L14
    L7:
        if (r10.hasNext() == false) goto L10;
        PersonalTabFragment.b r3 = (PersonalTabFragment.b) ZeusTransformUtils.preCheckCast(r10.next(), PersonalTabFragment.b.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L14
        Pair r4 = TuplesKt.to(r3.a(), Boxing.boxLong(r3.b()));     // Catch: SQLiteException -> L14
        r2.put(r4.getFirst(), r4.getSecond());     // Catch: SQLiteException -> L14
        goto L7
    L10:
        if (r9.a(r2, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue()) == true) goto L21;
        return Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_changed_retry, TypedValues.Custom.S_STRING, "memory_pending_changed_retry"));
    L21:
        return null;
    L15:
        return Boxing.boxInt(ZeusTransformUtils.mapRes(R.string.memory_pending_operation_failed, TypedValues.Custom.S_STRING, "memory_pending_operation_failed"));
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
