package com.larus.doc.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.SoftReference;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragmentV2$initFragment$1", f = "DocFragmentV2.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class DocFragmentV2$initFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $it;
    int label;
    final /* synthetic */ DocFragmentV2 this$0;

    public DocFragmentV2$initFragment$1(Context r1, DocFragmentV2 r2, Continuation<? super DocFragmentV2$initFragment$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragmentV2$initFragment$1(this.$it, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L18:
        Fragment r11 = (Fragment) r10;
        if (r11 == null) goto L26;
        final DocFragmentV2 r2 = this.this$0;
        if (r2.isAdded() == false) goto L23;
        r2.i = r11;
        INVOKEVIRTUAL_com_larus_doc_impl_DocFragmentV2$initFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(r2.getChildFragmentManager().beginTransaction(), 2131369315, r11).commitNowAllowingStateLoss();
    L24:
        SoftReference r12 = com.larus.utils.y.a;
        Runnable r13 = new q1(r2);
        Intrinsics.checkNotNullParameter(r13, "action");
        com.larus.utils.y.d(r13, 1000);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), Dispatchers.getIO(), null, new DocFragment$refreshDocPermission$1(r2, null), 2, null);
        goto L26
    L23:
        FLogger.a.e("DocFragmentV2", "DocFragment is detached, will not add fragment created by doc sdk");
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppHost.Companion r14 = AppHost.a;
        if (r14.isDebug() == false) goto L11;
    L14:
        t19.s.j(t19.s.a, this.$it, "融合文档" + this.this$0.f, null, false, 28);
    L15:
        DocFragmentV2 r15 = this.this$0;
        Context r3 = this.$it;
        this.label = 1;
        r10 = r15.V3(r3, this);
        if (r10 != r0) goto L18;
        return r0;
    L11:
        if (r14.isDebugChannel() == true) goto L14;
        if (r14.isTestChannel() == false) goto L15;
        goto L14
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_larus_doc_impl_DocFragmentV2$initFragment$1_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
        return r2;
    L6:
        return r2.replace(r3, r4);
    }
}
