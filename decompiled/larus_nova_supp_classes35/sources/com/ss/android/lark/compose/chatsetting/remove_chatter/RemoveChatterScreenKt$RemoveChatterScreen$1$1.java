package com.ss.android.lark.compose.chatsetting.remove_chatter;

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
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterScreenKt$RemoveChatterScreen$1$1", f = "RemoveChatterScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RemoveChatterScreenKt$RemoveChatterScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $actualOnBack;
    final /* synthetic */ Context $context;
    final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
    final /* synthetic */ String $removeMemberFailedToast;
    final /* synthetic */ String $removeMemberSuccessToast;
    final /* synthetic */ RemoveChatterViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterScreenKt$RemoveChatterScreen$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/ss/android/lark/compose/chatsetting/remove_chatter/RemoveChatterViewModel$ActionEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterScreenKt$RemoveChatterScreen$1$1$1", f = "RemoveChatterScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<RemoveChatterViewModel.a, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $actualOnBack;
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
        final /* synthetic */ String $removeMemberFailedToast;
        final /* synthetic */ String $removeMemberSuccessToast;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(com.ss.android.lark.compose.chatsetting.common.platform.b r1, Context r2, String r3, Function0<Unit> r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.$platformEffects = r1;
            this.$context = r2;
            this.$removeMemberSuccessToast = r3;
            this.$actualOnBack = r4;
            this.$removeMemberFailedToast = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$platformEffects, this.$context, this.$removeMemberSuccessToast, this.$actualOnBack, this.$removeMemberFailedToast, r10);
            r7.L$0 = r9;
            return r7;
        }

        public final Object invoke(RemoveChatterViewModel.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((RemoveChatterViewModel.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            RemoveChatterViewModel.a r5 = (RemoveChatterViewModel.a) this.L$0;
            if (Intrinsics.areEqual(r5, RemoveChatterViewModel.a.b.a) == false) goto L8;
            this.$platformEffects.n(this.$context, new c.k(this.$removeMemberSuccessToast));
            this.$actualOnBack.invoke();
        L11:
            return Unit.INSTANCE;
        L8:
            if (Intrinsics.areEqual(r5, RemoveChatterViewModel.a.C0139a.a) == false) goto L13;
            this.$platformEffects.n(this.$context, new c.k(this.$removeMemberFailedToast));
            goto L11
        L13:
            throw new NoWhenBranchMatchedException();
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RemoveChatterScreenKt$RemoveChatterScreen$1$1(RemoveChatterViewModel r1, com.ss.android.lark.compose.chatsetting.common.platform.b r2, Context r3, String r4, Function0<Unit> r5, String r6, Continuation<? super RemoveChatterScreenKt$RemoveChatterScreen$1$1> r7) {
        this.$viewModel = r1;
        this.$platformEffects = r2;
        this.$context = r3;
        this.$removeMemberSuccessToast = r4;
        this.$actualOnBack = r5;
        this.$removeMemberFailedToast = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        RemoveChatterScreenKt$RemoveChatterScreen$1$1 r8 = new RemoveChatterScreenKt$RemoveChatterScreen$1$1(this.$viewModel, this.$platformEffects, this.$context, this.$removeMemberSuccessToast, this.$actualOnBack, this.$removeMemberFailedToast, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getActionEvent(), new AnonymousClass1(this.$platformEffects, this.$context, this.$removeMemberSuccessToast, this.$actualOnBack, this.$removeMemberFailedToast, null)), r11);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
