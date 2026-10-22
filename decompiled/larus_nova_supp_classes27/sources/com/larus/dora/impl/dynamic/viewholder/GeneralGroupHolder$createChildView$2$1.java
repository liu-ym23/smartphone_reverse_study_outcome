package com.larus.dora.impl.dynamic.viewholder;

import com.larus.dora.impl.core.DoraUserManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$2$1", f = "GeneralGroupHolder.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
final class GeneralGroupHolder$createChildView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isChecked;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$2$1$1", f = "GeneralGroupHolder.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;

        public AnonymousClass1(boolean r1, Continuation<? super AnonymousClass1> r2) {
            this.$isChecked = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$isChecked, r3);
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
            g49.d.d("GeneraGroupHolder", "updateMultiUserModeState: result = " + ((Boolean) r5).booleanValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraUserManager r6 = DoraUserManager.a;
            boolean r7 = DoraUserManager.b();
            boolean r2 = this.$isChecked;
            if (r7 != r2) goto L12;
            g49.d.d("GeneraGroupHolder", "updateMultiUserModeState: enable already " + this.$isChecked);
            return Unit.INSTANCE;
        L12:
            this.label = 1;
            r5 = DoraUserManager.e(r2, this);
            if (r5 != r0) goto L15;
            return r0;
        }
    }

    public GeneralGroupHolder$createChildView$2$1(boolean r1, Continuation<? super GeneralGroupHolder$createChildView$2$1> r2) {
        this.$isChecked = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GeneralGroupHolder$createChildView$2$1(this.$isChecked, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$isChecked, null);
        this.label = 1;
        if (BuildersKt.withContext(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
