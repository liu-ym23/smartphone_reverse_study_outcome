package com.ss.android.lark.compose.chatsetting.update_manager;

import android.content.Context;
import com.ss.android.lark.compose.chatsetting.common.platform.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerScreenKt$UpdateManagerScreen$1$1", f = "UpdateManagerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UpdateManagerScreenKt$UpdateManagerScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $actualOnBack;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $onUpdateSuccess;
    final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
    final /* synthetic */ String $updateFailureToast;
    final /* synthetic */ String $updateSuccessToast;
    final /* synthetic */ UpdateManagerViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerScreenKt$UpdateManagerScreen$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/ss/android/lark/compose/chatsetting/update_manager/UpdateManagerViewModel$ActionEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerScreenKt$UpdateManagerScreen$1$1$1", f = "UpdateManagerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<UpdateManagerViewModel.a, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $actualOnBack;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $onUpdateSuccess;
        final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
        final /* synthetic */ String $updateFailureToast;
        final /* synthetic */ String $updateSuccessToast;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Function0<Unit> r1, com.ss.android.lark.compose.chatsetting.common.platform.b r2, Context r3, String r4, Function0<Unit> r5, String r6, Continuation<? super AnonymousClass1> r7) {
            this.$onUpdateSuccess = r1;
            this.$platformEffects = r2;
            this.$context = r3;
            this.$updateSuccessToast = r4;
            this.$actualOnBack = r5;
            this.$updateFailureToast = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.$onUpdateSuccess, this.$platformEffects, this.$context, this.$updateSuccessToast, this.$actualOnBack, this.$updateFailureToast, r11);
            r8.L$0 = r10;
            return r8;
        }

        public final Object invoke(UpdateManagerViewModel.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((UpdateManagerViewModel.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r4);
            UpdateManagerViewModel.a r5 = (UpdateManagerViewModel.a) this.L$0;
            if (Intrinsics.areEqual(r5, UpdateManagerViewModel.a.b.a) == false) goto L11;
            Function0<Unit> r6 = this.$onUpdateSuccess;
            if (r6 == null) goto L9;
            r6.invoke();
        L9:
            this.$platformEffects.n(this.$context, new c.k(this.$updateSuccessToast));
            this.$actualOnBack.invoke();
        L14:
            return Unit.INSTANCE;
        L11:
            if (Intrinsics.areEqual(r5, UpdateManagerViewModel.a.C0142a.a) == false) goto L16;
            this.$platformEffects.n(this.$context, new c.k(this.$updateFailureToast));
            goto L14
        L16:
            throw new NoWhenBranchMatchedException();
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UpdateManagerScreenKt$UpdateManagerScreen$1$1(UpdateManagerViewModel r1, Function0<Unit> r2, com.ss.android.lark.compose.chatsetting.common.platform.b r3, Context r4, String r5, Function0<Unit> r6, String r7, Continuation<? super UpdateManagerScreenKt$UpdateManagerScreen$1$1> r8) {
        this.$viewModel = r1;
        this.$onUpdateSuccess = r2;
        this.$platformEffects = r3;
        this.$context = r4;
        this.$updateSuccessToast = r5;
        this.$actualOnBack = r6;
        this.$updateFailureToast = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        UpdateManagerScreenKt$UpdateManagerScreen$1$1 r9 = new UpdateManagerScreenKt$UpdateManagerScreen$1$1(this.$viewModel, this.$onUpdateSuccess, this.$platformEffects, this.$context, this.$updateSuccessToast, this.$actualOnBack, this.$updateFailureToast, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getActionEvent(), new AnonymousClass1(this.$onUpdateSuccess, this.$platformEffects, this.$context, this.$updateSuccessToast, this.$actualOnBack, this.$updateFailureToast, null)), r12);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
