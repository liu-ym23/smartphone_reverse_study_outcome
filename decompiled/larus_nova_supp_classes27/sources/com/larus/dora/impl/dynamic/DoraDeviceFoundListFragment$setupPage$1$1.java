package com.larus.dora.impl.dynamic;

import android.view.View;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageDeviceListBinding;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDeviceFoundListFragment$setupPage$1$1", f = "DoraDeviceFoundListFragment.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
final class DoraDeviceFoundListFragment$setupPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasContent;
    final /* synthetic */ c59.l $pageInfo;
    final /* synthetic */ Map<String, String> $starling;
    int label;
    final /* synthetic */ DoraDeviceFoundListFragment this$0;

    public DoraDeviceFoundListFragment$setupPage$1$1(DoraDeviceFoundListFragment r1, c59.l r2, boolean r3, Map<String, String> r4, Continuation<? super DoraDeviceFoundListFragment$setupPage$1$1> r5) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        this.$hasContent = r3;
        this.$starling = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraDeviceFoundListFragment$setupPage$1$1(this.this$0, this.$pageInfo, this.$hasContent, this.$starling, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.larus.dora.impl.dynamic.n] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L22
    L13:
        String r11 = (String) r10;     // Catch: Exception -> L22
        final DoraDeviceFoundListFragment r2 = this.this$0;     // Catch: Exception -> L22
        LarusDoraPageDeviceListBinding r3 = r2.f;     // Catch: Exception -> L22
        if (r3 == null) goto L39;
        boolean r4 = this.$hasContent;     // Catch: Exception -> L22
        c59.l r5 = this.$pageInfo;     // Catch: Exception -> L22
        Map<String, String> r6 = this.$starling;     // Catch: Exception -> L22
        r3.c.setTitle(r11);     // Catch: Exception -> L22
        View r12 = r3.c.findViewById(2131384558);     // Catch: Exception -> L22
        if (r4 == false) goto L24;
        if (r12 == null) goto L19;
        com.larus.utils.e1.x(r12);     // Catch: Exception -> L22
    L19:
        HistoryDeviceNavigationBar r7 = r3.c;     // Catch: Exception -> L22
        final ?? r8 = new n(r2);     // Catch: Exception -> L22
        com.larus.utils.e1.x(r7.l);     // Catch: Exception -> L22
        r7.l.setImageResource(2131240477);     // Catch: Exception -> L22
        r7.l.setPadding(0, 0, 0, 0);     // Catch: Exception -> L22
        r7.l.setOnClickListener(new com.larus.dora.impl.dynamic.widget.d(r8));     // Catch: Exception -> L22
        if (r12 == null) goto L30;
        r12.setEnabled(true);     // Catch: Exception -> L22
    L30:
        DslCardAdapter r13 = r2.g;     // Catch: Exception -> L22
        if (r13 == null) goto L39;
        List<c59.i> r9 = r5.b;     // Catch: Exception -> L22
        int r14 = n1.a;     // Catch: Exception -> L22
        z49.b r15 = n1.b(DoraAdapterExtKt.h(kj4.a.g()));     // Catch: Exception -> L22
        List r16 = DoraAdapterExtKt.k(kj4.a.g());     // Catch: Exception -> L22
        if (r6 != null) goto L35;
        r6 = MapsKt.emptyMap();     // Catch: Exception -> L22
    L35:
        r13.C2(r9, new d59.b(r15, r16, r6, ""));     // Catch: Exception -> L22
        goto L39
    L24:
        if (r12 == null) goto L26;
        com.larus.utils.e1.q(r12);     // Catch: Exception -> L22
    L26:
        if (r12 == null) goto L28;
        r12.setEnabled(false);     // Catch: Exception -> L22
    L28:
        if (r12 == null) goto L30;
        r12.setOnClickListener(null);     // Catch: Exception -> L22
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Exception -> L22
        DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1 r18 = new DoraDeviceFoundListFragment$setupPage$1$1$navBarTitle$1(this.$pageInfo, null);     // Catch: Exception -> L22
        this.label = 1;     // Catch: Exception -> L22
        r10 = BuildersKt.withContext(r17, r18, this);     // Catch: Exception -> L22
        if (r10 != r0) goto L13;
        return r0;
    L22:
        e = move-exception;
        g49.d.c("DoraDeviceFoundListFragment", "setupPage failed", e);
        goto L39
    }
}
