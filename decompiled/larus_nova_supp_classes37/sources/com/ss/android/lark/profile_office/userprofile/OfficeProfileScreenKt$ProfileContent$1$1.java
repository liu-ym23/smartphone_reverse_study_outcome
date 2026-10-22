package com.ss.android.lark.profile_office.userprofile;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileScreenKt$ProfileContent$1$1", f = "OfficeProfileScreen.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeProfileScreenKt$ProfileContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Integer, Unit>> $latestOnScroll$delegate;
    final /* synthetic */ ScrollState $scrollState;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ State<Function1<Integer, Unit>> a;

        public a(State<? extends Function1<? super Integer, Unit>> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = ((Number) r1).intValue();
            Function1 r4 = (Function1) this.a.getValue();
            if (r4 == null) goto L6;
            r4.invoke(Boxing.boxInt(r3));
        L6:
            return Unit.INSTANCE;
        }
    }

    public OfficeProfileScreenKt$ProfileContent$1$1(ScrollState r1, State<? extends Function1<? super Integer, Unit>> r2, Continuation<? super OfficeProfileScreenKt$ProfileContent$1$1> r3) {
        this.$scrollState = r1;
        this.$latestOnScroll$delegate = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OfficeProfileScreenKt$ProfileContent$1$1(this.$scrollState, this.$latestOnScroll$delegate, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final ScrollState r2 = this.$scrollState;
        Flow r6 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(r2));
        a r3 = new a(this.$latestOnScroll$delegate);
        this.label = 1;
        if (r6.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
