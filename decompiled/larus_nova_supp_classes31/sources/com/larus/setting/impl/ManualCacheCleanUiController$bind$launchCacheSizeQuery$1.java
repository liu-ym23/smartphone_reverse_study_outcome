package com.larus.setting.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tx9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$bind$launchCacheSizeQuery$1", f = "ManualCacheCleanUiController.kt", i = {0, 0}, l = {79}, m = "invokeSuspend", n = {"hasDisplayedSize", "shouldShowLoading"}, s = {"I$0", "I$1"})
public final class ManualCacheCleanUiController$bind$launchCacheSizeQuery$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentPage;
    final /* synthetic */ Function1<Long, String> $formatSize;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ItemTextArrow $item;
    final /* synthetic */ Ref.ObjectRef<Job> $operationJob;
    final /* synthetic */ boolean $showConfirmDialog;
    final /* synthetic */ by7.e $trackNode;
    int I$0;
    int I$1;
    int label;

    public static final class a implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ String a;
        public final /* synthetic */ by7.e b;

        public final void cancel() {
            String r0 = this.a;
            by7.e r1 = this.b;
            Intrinsics.checkNotNullParameter("cancel", "clickFrom");
            Intrinsics.checkNotNullParameter(r0, "currentPage");
            r.b("cancel", r0, null, r1);
        }

        public a(String r1, by7.e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ManualCacheCleanUiController$bind$launchCacheSizeQuery$1(ItemTextArrow r1, boolean r2, Fragment r3, Function1<? super Long, String> r4, Ref.ObjectRef<Job> r5, String r6, by7.e r7, Continuation<? super ManualCacheCleanUiController$bind$launchCacheSizeQuery$1> r8) {
        this.$item = r1;
        this.$showConfirmDialog = r2;
        this.$fragment = r3;
        this.$formatSize = r4;
        this.$operationJob = r5;
        this.$currentPage = r6;
        this.$trackNode = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ManualCacheCleanUiController$bind$launchCacheSizeQuery$1(this.$item, this.$showConfirmDialog, this.$fragment, this.$formatSize, this.$operationJob, this.$currentPage, this.$trackNode, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        int r2 = this.I$1;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L8
    L27:
        final Long r10 = (Long) r14;     // Catch: Throwable -> L8
        if (r2 == 0) goto L30;
        this.$item.V5();
    L30:
        if (r10 != null) goto L37;
        if (this.$showConfirmDialog == false) goto L35;
        t19.s r15 = t19.s.a;
        Context r4 = this.$fragment.getContext();
        r15.getClass();
        t19.s.b(r4, 2131906594, false);
    L35:
        return Unit.INSTANCE;
    L37:
        if (this.$showConfirmDialog == false) goto L39;
        if (r3 == 0) goto L39;
    L41:
        if (this.$showConfirmDialog == true) goto L45;
        return Unit.INSTANCE;
    L45:
        if (this.$fragment.isAdded() == false) goto L56;
        if (this.$fragment.getChildFragmentManager().isStateSaved() == true) goto L56;
        if (this.$fragment.getChildFragmentManager().findFragmentByTag("manual_cache_clean_confirm") != null) goto L52;
        CommonDialog.a r16 = new CommonDialog.a();
        r16.i(this.$fragment.getString(2131906592));
        r16.g(this.$fragment.getString(2131906591));
        final Ref.ObjectRef<Job> r5 = this.$operationJob;
        final String r6 = this.$currentPage;
        final by7.e r7 = this.$trackNode;
        final Fragment r8 = this.$fragment;
        final ItemTextArrow r9 = this.$item;
        final Function1<Long, String> r11 = this.$formatSize;
        CommonDialog.a.f(r16, new AnonymousClass1(r5, r6, r7, r8, r9, r10, r11), r8.getString(2131900457), false, 12);
        CommonDialog.a.e(r16, new a(this.$currentPage, this.$trackNode), this.$fragment.getString(2131900590), 4);
        r16.z = false;
        r16.A = false;
        INVOKEVIRTUAL_com_larus_setting_impl_ManualCacheCleanUiController$bind$launchCacheSizeQuery$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r16.a(), this.$fragment.getChildFragmentManager(), "manual_cache_clean_confirm");
        return Unit.INSTANCE;
    L52:
        return Unit.INSTANCE;
    L56:
        return Unit.INSTANCE;
    L39:
        ManualCacheCleanUiController r17 = ManualCacheCleanUiController.a;
        ItemTextArrow r12 = this.$item;
        long r13 = r10.longValue();
        Function1<Long, String> r18 = this.$formatSize;
        r17.getClass();
        ManualCacheCleanUiController.f(r12, r13, r18);
    L8:
        th = move-exception;
        int r19 = r2;
        th = th;
        int r110 = r19;
    L59:
        if (r110 == 0) goto L61;
        this.$item.V5();
    L61:
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r14);
        if (this.$item.getSubTextView().getText().length() <= 0) goto L15;
        r3 = 1;
    L17:
        if (this.$showConfirmDialog == true) goto L20;
        if (r3 != 0) goto L20;
        r110 = 1;
    L21:
        if (r110 == 0) goto L64;
        this.$item.c6();
    L64:
        ManualCacheCleanUiController r20 = ManualCacheCleanUiController.a;     // Catch: Throwable -> L58
        this.I$0 = r3;     // Catch: Throwable -> L58
        this.I$1 = r110;     // Catch: Throwable -> L58
        this.label = 1;     // Catch: Throwable -> L58
        Object r21 = r20.e(this);     // Catch: Throwable -> L58
        if (r21 != r0) goto L26;
        return r0;
    L26:
        r2 = r110;
        r14 = r21;
    L58:
        th = th;
    L20:
        r110 = 0;
        goto L21
    L15:
        r3 = 0;
        goto L17
    }

    public static void INVOKEVIRTUAL_com_larus_setting_impl_ManualCacheCleanUiController$bind$launchCacheSizeQuery$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
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
