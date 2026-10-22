package com.larus.sheet.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.impl.SheetFragment$initChameleonFragment$1", f = "SheetFragment.kt", i = {}, l = {295, 296}, m = "invokeSuspend", n = {}, s = {})
public final class SheetFragment$initChameleonFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<Fragment> $fragment;
    Object L$0;
    int label;
    final /* synthetic */ SheetFragment this$0;

    /* JADX INFO: renamed from: com.larus.sheet.impl.SheetFragment$initChameleonFragment$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.impl.SheetFragment$initChameleonFragment$1$1", f = "SheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Fragment> $fragment;
        int label;
        final /* synthetic */ SheetFragment this$0;

        public AnonymousClass1(SheetFragment r1, Ref.ObjectRef<Fragment> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$fragment = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$fragment, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r3);
            if (this.this$0.isAdded() == false) goto L9;
            Fragment r4 = (Fragment) this.$fragment.element;
            if (r4 == null) goto L11;
            INVOKEVIRTUAL_com_larus_sheet_impl_SheetFragment$initChameleonFragment$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getChildFragmentManager().beginTransaction(), 2131369315, r4).commitNowAllowingStateLoss();
        L11:
            return Unit.INSTANCE;
        L9:
            FLogger.a.e("SheetFragment", "SheetFragment is detached");
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_sheet_impl_SheetFragment$initChameleonFragment$1$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
            return r2;
        L6:
            return r2.replace(r3, r4);
        }
    }

    public SheetFragment$initChameleonFragment$1(Context r1, SheetFragment r2, Ref.ObjectRef<Fragment> r3, Continuation<? super SheetFragment$initChameleonFragment$1> r4) {
        this.$context = r1;
        this.this$0 = r2;
        this.$fragment = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SheetFragment$initChameleonFragment$1(this.$context, this.this$0, this.$fragment, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Ref.ObjectRef<Fragment> r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r11);
    L26:
        r2.element = r11;
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$fragment, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r12, r3, this) != r0) goto L30;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        AppHost.Companion r13 = AppHost.a;
        if (r13.isDebug() == false) goto L13;
    L16:
        t19.s.j(t19.s.a, this.$context, "融合Sheet", null, false, 28);
    L17:
        final SheetFragment r14 = this.this$0;
        int r4 = SheetFragment.R;
        r14.getClass();
        k1a.b.a(r14, new g(r14));
        com.larus.office.base.component.permission.a r5 = s1a.a.g(r14).getAbility(com.larus.office.base.component.permission.a.class);
        r14.I = r5;
        if (r5 == null) goto L20;
        r5.mW(r14);
    L20:
        com.larus.office.base.component.permission.a r6 = r14.I;
        if (r6 == null) goto L23;
        r6.R20(r14.K);
    L23:
        r2 = this.$fragment;
        SheetFragment r15 = this.this$0;
        Context r7 = this.$context;
        this.L$0 = r2;
        this.label = 1;
        r11 = r15.V3(r7, this);
        if (r11 != r0) goto L26;
        return r0;
    L13:
        if (r13.isDebugChannel() == true) goto L16;
        if (r13.isTestChannel() == false) goto L17;
        goto L16
    }
}
