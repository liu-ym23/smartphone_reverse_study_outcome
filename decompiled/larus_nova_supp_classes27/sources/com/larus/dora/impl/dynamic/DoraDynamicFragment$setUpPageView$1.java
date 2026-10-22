package com.larus.dora.impl.dynamic;

import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$setUpPageView$1", f = "DoraDynamicFragment.kt", i = {}, l = {743}, m = "invokeSuspend", n = {}, s = {})
final class DoraDynamicFragment$setUpPageView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.m $pageInfo;
    Object L$0;
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public DoraDynamicFragment$setUpPageView$1(DoraDynamicFragment r1, c59.m r2, Continuation<? super DoraDynamicFragment$setUpPageView$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDynamicFragment$setUpPageView$1(this.this$0, this.$pageInfo, r4);
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
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        LarusDoraPageDynamicListBinding r2 = (LarusDoraPageDynamicListBinding) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L8
    L34:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r7);
        final DoraDynamicFragment r8 = this.this$0;
        LarusDoraPageDynamicListBinding r3 = r8.f;
        if (r3 == null) goto L34;
        c59.m r4 = this.$pageInfo;
        HistoryDeviceNavigationBar r5 = r3.b;     // Catch: Exception -> L8
        c59.v r6 = r4.a;     // Catch: Exception -> L8
        if (r6 == null) goto L18;
        Map<String, ? extends Object> r9 = r6.a;     // Catch: Exception -> L8
    L19:
        r5.S5(r9);     // Catch: Exception -> L8
        r3.b.setShowListBar(true);     // Catch: Exception -> L8
        r3.b.setDidSelectDevice(new o0(r8));     // Catch: Exception -> L8
        e59.b r10 = (e59.b) r8.ba0().getConnectionState().getValue();     // Catch: Exception -> L8
        if (r10 != null) goto L22;
        r10 = e59.b.d.a;     // Catch: Exception -> L8
    L22:
        r8.ga0(r10, r4);     // Catch: Exception -> L8
        LarusDoraPageDynamicListBinding r11 = r8.f;     // Catch: Exception -> L8
        if (r11 == null) goto L34;
        NestedDynamicPageView r12 = r11.c;     // Catch: Exception -> L8
        if (r12 == null) goto L34;
        e59.b r13 = (e59.b) r8.ba0().getConnectionState().getValue();     // Catch: Exception -> L8
        if (r13 != null) goto L29;
        r13 = e59.b.d.a;     // Catch: Exception -> L8
    L29:
        this.L$0 = r3;     // Catch: Exception -> L8
        this.label = 1;     // Catch: Exception -> L8
        if (r12.e(r4, r13, this) != r0) goto L34;
        return r0;
    L18:
        r9 = null;
    L8:
        e = move-exception;
        g49.d.b("DoraDynamicFragment", "setUpPageView, e = " + e);
        goto L34
    }
}
