package com.larus.dora.impl.dynamic;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeyword;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywords;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$3", f = "DoraFunctionIntroductionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFunctionIntroductionFragment$setupButton$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.b $action;
    int label;
    final /* synthetic */ DoraFunctionIntroductionFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$3$1", f = "DoraFunctionIntroductionFragment.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c59.b $action;
        final /* synthetic */ boolean $isOwenEnabled;
        final /* synthetic */ boolean $isOwenKeyword;
        final /* synthetic */ boolean $isVoiceWakeEnabled;
        final /* synthetic */ DoraWakeupKeyword $owenKeyword;
        int label;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.DoraFunctionIntroductionFragment$setupButton$1$3$1$a */
        public static final class a implements com.larus.common_ui.dialog.u {
            public a() {
            }

            @Override // com.larus.common_ui.dialog.u
            public final void cancel() {
            }
        }

        public AnonymousClass1(c59.b r1, boolean r2, boolean r3, boolean r4, DoraWakeupKeyword r5, Continuation<? super AnonymousClass1> r6) {
            this.$action = r1;
            this.$isVoiceWakeEnabled = r2;
            this.$isOwenEnabled = r3;
            this.$isOwenKeyword = r4;
            this.$owenKeyword = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$action, this.$isVoiceWakeEnabled, this.$isOwenEnabled, this.$isOwenKeyword, this.$owenKeyword, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            Lazy r13 = c59.s.a;
            final DoraFunctionIntroductionFragment.a.C0059a r14 = (DoraFunctionIntroductionFragment.a.C0059a) c59.s.c(this.$action.a(), DoraFunctionIntroductionFragment.a.C0059a.class);
            FragmentActivity r2 = AppHost.a.a().getCurrentActivity();
            if ((r2 instanceof FragmentActivity) == false) goto L14;
            FragmentActivity r3 = r2;
        L15:
            if (r3 == null) goto L17;
            FragmentManager r7 = r3.getSupportFragmentManager();
            CommonDialog.a r8 = new CommonDialog.a();
            String r9 = "";
            if (r14 == null) goto L26;
            c59.o r4 = r14.a();
            if (r4 == null) goto L26;
            c59.t r5 = r4.d();
            if (r5 == null) goto L26;
            String r6 = c59.p.b(r5);
            if (r6 == null) goto L26;
        L27:
            Intrinsics.checkNotNullParameter(r6, "title");
            r8.a = r6;
            if (r14 == null) goto L35;
            c59.o r10 = r14.a();
            if (r10 == null) goto L35;
            c59.t r11 = r10.c();
            if (r11 == null) goto L35;
            String r15 = c59.p.b(r11);
            if (r15 == null) goto L35;
        L36:
            Intrinsics.checkNotNullParameter(r15, "message");
            r8.i = r15;
            final boolean r16 = this.$isVoiceWakeEnabled;
            final boolean r17 = this.$isOwenEnabled;
            final boolean r18 = this.$isOwenKeyword;
            final DoraWakeupKeyword r20 = this.$owenKeyword;
            com.larus.common_ui.dialog.p0 r110 = new C00601(r16, r14, r17, r18, r20);
            if (r14 == null) goto L44;
            c59.o r21 = r14.a();
            if (r21 == null) goto L44;
            c59.t r22 = r21.b();
            if (r22 == null) goto L44;
            String r23 = c59.p.b(r22);
            if (r23 == null) goto L44;
        L45:
            CommonDialog.a.f(r8, r110, r23, false, 12);
            a r24 = new a();
            if (r14 == null) goto L55;
            c59.o r111 = r14.a();
            if (r111 == null) goto L55;
            c59.t r112 = r111.a();
            if (r112 == null) goto L55;
            String r113 = c59.p.b(r112);
            if (r113 == null) goto L55;
            r9 = r113;
        L55:
            CommonDialog.a.e(r8, r24, r9, 4);
            INVOKEVIRTUAL_com_larus_dora_impl_dynamic_DoraFunctionIntroductionFragment$setupButton$1$3$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r8.a(), r7, null);
            return Unit.INSTANCE;
        L44:
            r23 = "";
        L35:
            r15 = "";
        L26:
            r6 = "";
            goto L27
        L17:
            return Unit.INSTANCE;
        L14:
            r3 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L11;
            return r0;
        }

        public static void INVOKEVIRTUAL_com_larus_dora_impl_dynamic_DoraFunctionIntroductionFragment$setupButton$1$3$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
            if ((r2 instanceof Fragment) == false) goto L5;
            CommonDialog r0 = r2;
        L6:
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
            return;
        L13:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r2.show(r3, r4);
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public DoraFunctionIntroductionFragment$setupButton$1$3(DoraFunctionIntroductionFragment r1, c59.b r2, Continuation<? super DoraFunctionIntroductionFragment$setupButton$1$3> r3) {
        this.this$0 = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFunctionIntroductionFragment$setupButton$1$3(this.this$0, this.$action, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r13);
        boolean r2 = DoraAdapterExtKt.p(kj4.a.g());
        DoraWakeupKeywords r14 = (DoraWakeupKeywords) DoraWakeupKeywordsHandler.e.getValue();
        String r0 = null;
        if (r14 == null) goto L20;
        List<DoraWakeupKeyword> r15 = r14.getWakeupKeywords();
        if (r15 == null) goto L20;
        Iterator<T> r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L18;
        Object r1 = r16.next();
        DoraWakeupKeyword r3 = (DoraWakeupKeyword) r1;
        if (r3 == null) goto L14;
        String r4 = r3.getKeyword();
    L15:
        Lazy<String> r5 = com.larus.dora.impl.device.ailab.t.h;
        if (Intrinsics.areEqual(r4, com.larus.dora.impl.device.ailab.t.a.b()) == false) goto L10;
    L19:
        DoraWakeupKeyword r6 = (DoraWakeupKeyword) r1;
    L21:
        if (r6 == null) goto L28;
        Integer r17 = r6.getStatus();
        if (r17 == null) goto L28;
        if (r17.intValue() != 1) goto L28;
        boolean r7 = true;
    L29:
        if (r6 == null) goto L31;
        r0 = r6.getKeyword();
    L31:
        Lazy<String> r18 = com.larus.dora.impl.device.ailab.t.h;
        boolean r8 = Intrinsics.areEqual(r0, com.larus.dora.impl.device.ailab.t.a.b());
        if (r7 == true) goto L34;
        if (r8 == false) goto L34;
    L35:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this.$action, r2, r7, r8, r6, null), 3, null);
    L36:
        com.bytedance.router.i r110 = SmartRouter.buildRoute(this.this$0.getContext(), this.$action.e());
        r110.d = 2130772401;
        r110.e = 2130772399;
        r110.d();
        return Unit.INSTANCE;
    L34:
        if (r2 == true) goto L36;
    L28:
        r7 = false;
        goto L29
    L14:
        r4 = null;
        goto L15
    L18:
        r1 = null;
    L20:
        r6 = null;
        goto L21
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
