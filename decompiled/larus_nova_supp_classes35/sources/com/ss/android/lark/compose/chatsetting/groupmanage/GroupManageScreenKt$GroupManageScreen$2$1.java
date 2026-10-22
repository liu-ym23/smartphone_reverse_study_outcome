package com.ss.android.lark.compose.chatsetting.groupmanage;

import androidx.compose.runtime.SnapshotStateKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreenKt$GroupManageScreen$2$1", f = "GroupManageScreen.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class GroupManageScreenKt$GroupManageScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onBack;
    final /* synthetic */ GroupManageViewModel $viewModel;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ((Boolean) r1).booleanValue();
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public GroupManageScreenKt$GroupManageScreen$2$1(GroupManageViewModel r1, Function0<Unit> r2, Continuation<? super GroupManageScreenKt$GroupManageScreen$2$1> r3) {
        this.$viewModel = r1;
        this.$onBack = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GroupManageScreenKt$GroupManageScreen$2$1(this.$viewModel, this.$onBack, r4);
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
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final GroupManageViewModel r2 = this.$viewModel;
        Flow r6 = e.n(SnapshotStateKt.snapshotFlow(new AnonymousClass1(r2)));
        a r3 = new a(this.$onBack);
        this.label = 1;
        Object r7 = r6.collect(new GroupManageScreenKt$GroupManageScreen$2$1$invokeSuspend$$inlined$filter$1$2(r3), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r7 = Unit.INSTANCE;
    L12:
        if (r7 != r0) goto L15;
        return r0;
    }
}
