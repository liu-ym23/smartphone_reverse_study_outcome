package com.ss.android.lark.compose.chatsetting.add_chatter;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusManager;
import com.ss.android.lark.compose.chatsetting.common.platform.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.KotlinNothingValueException;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1", f = "AddChatterScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AddChatterScreenKt$AddChatterScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $actualOnBack;
    final /* synthetic */ String $addMemberFailedToast;
    final /* synthetic */ String $addMemberSuccessToast;
    final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.a $childScreenHost;
    final /* synthetic */ Context $context;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
    final /* synthetic */ AddMemberViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1$1", f = "AddChatterScreen.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $loading$delegate;
        final /* synthetic */ AddMemberViewModel $viewModel;
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MutableState<Boolean> a;

            public a(MutableState<Boolean> r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                boolean r3 = ((Boolean) r1).booleanValue();
                this.a.setValue(Boolean.valueOf(r3));
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(AddMemberViewModel r1, MutableState<Boolean> r2, Continuation<? super AnonymousClass1> r3) {
            this.$viewModel = r1;
            this.$loading$delegate = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$viewModel, this.$loading$delegate, r4);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1<Boolean> r6 = this.$viewModel.getLoading();
            a r2 = new a(this.$loading$delegate);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "event", "Lcom/ss/android/lark/compose/chatsetting/add_chatter/AddMemberViewModel$ActionEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.add_chatter.AddChatterScreenKt$AddChatterScreen$1$1$2", f = "AddChatterScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<AddMemberViewModel.a, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $actualOnBack;
        final /* synthetic */ String $addMemberFailedToast;
        final /* synthetic */ String $addMemberSuccessToast;
        final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.a $childScreenHost;
        final /* synthetic */ Context $context;
        final /* synthetic */ FocusManager $focusManager;
        final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b $platformEffects;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(com.ss.android.lark.compose.chatsetting.common.platform.b r1, Context r2, String r3, FocusManager r4, com.ss.android.lark.compose.chatsetting.common.platform.a r5, Function0<Unit> r6, String r7, Continuation<? super AnonymousClass2> r8) {
            this.$platformEffects = r1;
            this.$context = r2;
            this.$addMemberSuccessToast = r3;
            this.$focusManager = r4;
            this.$childScreenHost = r5;
            this.$actualOnBack = r6;
            this.$addMemberFailedToast = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            AnonymousClass2 r9 = new AnonymousClass2(this.$platformEffects, this.$context, this.$addMemberSuccessToast, this.$focusManager, this.$childScreenHost, this.$actualOnBack, this.$addMemberFailedToast, r12);
            r9.L$0 = r11;
            return r9;
        }

        public final Object invoke(AddMemberViewModel.a r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((AddMemberViewModel.a) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L26;
            ResultKt.throwOnFailure(r5);
            AddMemberViewModel.a r6 = (AddMemberViewModel.a) this.L$0;
            if (Intrinsics.areEqual(r6, AddMemberViewModel.a.c.a) == false) goto L8;
            this.$platformEffects.n(this.$context, new c.k(this.$addMemberSuccessToast));
            this.$focusManager.clearFocus(true);
            this.$childScreenHost.c();
            this.$actualOnBack.invoke();
        L22:
            return Unit.INSTANCE;
        L8:
            if (Intrinsics.areEqual(r6, AddMemberViewModel.a.C0126a.a) == false) goto L11;
            this.$platformEffects.n(this.$context, new c.k(this.$addMemberFailedToast));
            goto L22
        L11:
            if ((r6 instanceof AddMemberViewModel.a.b) == false) goto L24;
            String r7 = ((AddMemberViewModel.a.b) r6).a;
            if (r7 != null) goto L15;
        L19:
            r7 = "当前群成员数量已达上限";
        L20:
            this.$platformEffects.n(this.$context, new c.k(r7));
            goto L22
        L15:
            if ((!StringsKt.isBlank(r7)) == true) goto L18;
            r7 = null;
        L18:
            if (r7 != null) goto L20;
        L24:
            throw new NoWhenBranchMatchedException();
        L26:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AddChatterScreenKt$AddChatterScreen$1$1(AddMemberViewModel r1, MutableState<Boolean> r2, com.ss.android.lark.compose.chatsetting.common.platform.b r3, Context r4, String r5, FocusManager r6, com.ss.android.lark.compose.chatsetting.common.platform.a r7, Function0<Unit> r8, String r9, Continuation<? super AddChatterScreenKt$AddChatterScreen$1$1> r10) {
        this.$viewModel = r1;
        this.$loading$delegate = r2;
        this.$platformEffects = r3;
        this.$context = r4;
        this.$addMemberSuccessToast = r5;
        this.$focusManager = r6;
        this.$childScreenHost = r7;
        this.$actualOnBack = r8;
        this.$addMemberFailedToast = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        AddChatterScreenKt$AddChatterScreen$1$1 r11 = new AddChatterScreenKt$AddChatterScreen$1$1(this.$viewModel, this.$loading$delegate, this.$platformEffects, this.$context, this.$addMemberSuccessToast, this.$focusManager, this.$childScreenHost, this.$actualOnBack, this.$addMemberFailedToast, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(r13, null, null, new AnonymousClass1(this.$viewModel, this.$loading$delegate, null), 3, null);
        e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.$viewModel.getActionEvent(), new AnonymousClass2(this.$platformEffects, this.$context, this.$addMemberSuccessToast, this.$focusManager, this.$childScreenHost, this.$actualOnBack, this.$addMemberFailedToast, null)), r13);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
