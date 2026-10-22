package com.larus.voice_setting.voice.dialog.v2;

import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceViewModel;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.dialog.v2.UgcVoiceContainerDialog$initObservers$1", f = "UgcVoiceContainerDialog.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
final class UgcVoiceContainerDialog$initObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UgcVoiceContainerDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ UgcVoiceContainerDialog a;

        /* JADX INFO: renamed from: com.larus.voice_setting.voice.dialog.v2.UgcVoiceContainerDialog$initObservers$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0010a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UgcVoiceViewModel.Action.values().length];
                r0[UgcVoiceViewModel.Action.Close.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[UgcVoiceViewModel.Action.Authorize.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[UgcVoiceViewModel.Action.Create.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(UgcVoiceContainerDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            UgcVoiceViewModel.Action r7 = (UgcVoiceViewModel.Action) r5;
            f2a.c r8 = com.larus.voice_setting.voice.utils.k.a.b("receive [viewModel.nav] " + r7);
            r8.c.d = "UgcVoiceContainerDialog.onViewCreated";
            List r1 = CollectionsKt.listOf(new String[]{this.a.i, "VoiceCreate"});
            f2a.g r2 = r8.c;
            r2.b = r1;
            r2.e = this.a.h;
            f2a.c.c(r8, null, 15);
            int r9 = C0010a.a[r7.ordinal()];
            if (r9 == 1) goto L21;
            if (r9 != 2) goto L7;
            this.a.S90("viewModel.nav");
        L20:
            return Unit.INSTANCE;
        L7:
            if (r9 != 3) goto L10;
            this.a.T90("viewModel.nav");
            goto L20
        L10:
            throw new NoWhenBranchMatchedException();
        L21:
            this.a.dismiss();     // Catch: Exception -> L15
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r10 = DialogFragmentLancet.sLastShowStack;
            if (r10 == null) goto L20;
            com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L20
        }
    }

    public UgcVoiceContainerDialog$initObservers$1(UgcVoiceContainerDialog r1, Continuation<? super UgcVoiceContainerDialog$initObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcVoiceContainerDialog$initObservers$1(this.this$0, r3);
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
        UgcVoiceContainerDialog r6 = this.this$0;
        int r2 = UgcVoiceContainerDialog.l;
        d1<UgcVoiceViewModel.Action> r7 = ((UgcVoiceViewModel) r6.e.getValue()).getNav();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
