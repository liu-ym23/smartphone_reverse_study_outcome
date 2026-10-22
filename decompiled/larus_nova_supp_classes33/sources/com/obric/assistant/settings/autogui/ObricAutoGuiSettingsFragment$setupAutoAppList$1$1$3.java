package com.obric.assistant.settings.autogui;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.obric.assistant.impl.databinding.ObricFragmentAutoGuiSettingsBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3", f = "ObricAutoGuiSettingsFragment.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricFragmentAutoGuiSettingsBinding $this_run;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsFragment this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3$1", f = "ObricAutoGuiSettingsFragment.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ObricFragmentAutoGuiSettingsBinding $this_run;
        int label;
        final /* synthetic */ ObricAutoGuiSettingsFragment this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3$1$1", f = "ObricAutoGuiSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00161 extends SuspendLambda implements Function2<List<? extends b0>, Continuation<? super Unit>, Object> {
            final /* synthetic */ ObricFragmentAutoGuiSettingsBinding $this_run;
            /* synthetic */ Object L$0;
            int label;

            public C00161(ObricFragmentAutoGuiSettingsBinding r1, Continuation<? super C00161> r2) {
                this.$this_run = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00161 r0 = new C00161(this.$this_run, r4);
                r0.L$0 = r3;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((List) r1, (Continuation) r2);
            }

            public final Object invoke(List<b0> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                List r4 = (List) this.L$0;
                ObricAutoGuiItemAdapter r0 = this.$this_run.c.getAdapter();
                Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.settings.autogui.ObricAutoGuiItemAdapter");
                r0.submitList(r4);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ObricAutoGuiSettingsFragment r1, ObricFragmentAutoGuiSettingsBinding r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$this_run = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$this_run, r4);
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
            ObricAutoGuiSettingsFragment r7 = this.this$0;
            int r2 = ObricAutoGuiSettingsFragment.h;
            i1<List<b0>> r8 = ((ObricAutoGuiViewModel) r7.f.getValue()).getAutoGuiUIModelListFlow();
            C00161 r3 = new C00161(this.$this_run, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3(ObricAutoGuiSettingsFragment r1, ObricFragmentAutoGuiSettingsBinding r2, Continuation<? super ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3> r3) {
        this.this$0 = r1;
        this.$this_run = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3(this.this$0, this.$this_run, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ObricAutoGuiSettingsFragment r8 = this.this$0;
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(r8, this.$this_run, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.b(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
