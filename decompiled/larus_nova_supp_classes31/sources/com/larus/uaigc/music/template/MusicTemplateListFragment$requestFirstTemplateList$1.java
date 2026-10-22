package com.larus.uaigc.music.template;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.common.utility.Logger;
import com.larus.bmhome.chat.GridSpacingItemDecoration;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.uaigc.impl.databinding.LarusPageTemplateBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListFragment$requestFirstTemplateList$1", f = "MusicTemplateListFragment.kt", i = {0}, l = {289}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class MusicTemplateListFragment$requestFirstTemplateList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MusicTemplateListFragment this$0;

    public MusicTemplateListFragment$requestFirstTemplateList$1(MusicTemplateListFragment r1, Continuation<? super MusicTemplateListFragment$requestFirstTemplateList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MusicTemplateListFragment$requestFirstTemplateList$1 r0 = new MusicTemplateListFragment$requestFirstTemplateList$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.uaigc.music.template.n] */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        MusicTemplateListFragment r2 = (MusicTemplateListFragment) this.L$2;
        MusicTemplateModel r3 = (MusicTemplateModel) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L16:
        r2.m = r3;
    L17:
        MusicTemplateListFragment r16 = this.this$0;
        MusicTemplateModel r5 = r16.m;
        Bundle r6 = null;
        if (r5 == null) goto L20;
        com.larus.bmhome.music.protocol.c r7 = r5.c;
    L22:
        if (r7 == null) goto L111;
        StaggeredGridLayoutManager r8 = new StaggeredGridLayoutManager(r16.h, 1);
        LarusPageTemplateBinding r17 = this.this$0.g;
        if (r17 == null) goto L28;
        RecyclerView r18 = r17.e;
        if (r18 == null) goto L28;
        r18.setLayoutManager(r8);
    L28:
        MusicTemplateListFragment r19 = this.this$0;
        LarusPageTemplateBinding r9 = r19.g;
        if (r9 == null) goto L33;
        RecyclerView r10 = r9.e;
        if (r10 == null) goto L33;
        r10.addItemDecoration(new GridSpacingItemDecoration(r19.h, i5.j0()));
    L33:
        LarusPageTemplateBinding r110 = this.this$0.g;
        if (r110 == null) goto L59;
        RecyclerView r111 = r110.e;
        if (r111 == null) goto L59;
        ConstraintLayout.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L59;
        MusicTemplateListFragment r11 = this.this$0;
        if ((r112 instanceof ConstraintLayout.LayoutParams) == false) goto L42;
        ConstraintLayout.LayoutParams r113 = r112;
    L43:
        if (r113 == null) goto L59;
        r113.setMarginStart(i5.h());
        r113.setMarginEnd(i5.h());
        LarusPageTemplateBinding r12 = r11.g;
        if (r12 == null) goto L49;
        RecyclerView r13 = r12.e;
        if (r13 == null) goto L49;
        r13.setLayoutParams(r113);
    L49:
        LarusPageTemplateBinding r114 = r11.g;
        if (r114 == null) goto L54;
        RecyclerView r115 = r114.e;
        if (r115 == null) goto L54;
        r115.requestLayout();
    L54:
        LarusPageTemplateBinding r116 = r11.g;
        if (r116 == null) goto L59;
        RecyclerView r117 = r116.e;
        if (r117 == null) goto L59;
        r117.invalidate();
        goto L59
    L42:
        r113 = null;
    L59:
        LarusPageTemplateBinding r118 = this.this$0.g;
        if (r118 == null) goto L64;
        RecyclerView r119 = r118.b;
        if (r119 == null) goto L64;
        e1.o(r119);
    L64:
        Context r14 = this.this$0.getContext();
        if (r14 == null) goto L67;
        final MusicTemplateListFragment r120 = this.this$0;
        String r20 = r120.e;
        String r21 = r120.f;
        ?? r22 = new n(r120);
        LifecycleCoroutineScope r121 = LifecycleOwnerKt.getLifecycleScope(r120);
        ArrayList r122 = new ArrayList();
        MusicTemplateModel r23 = this.this$0.m;
        if (r23 == null) goto L77;
        com.larus.bmhome.music.protocol.c r24 = r23.c;
        if (r24 == null) goto L77;
        List r25 = r24.c();
        if (r25 == null) goto L77;
        List r26 = CollectionsKt.filterNotNull(r25);
        if (r26 == null) goto L77;
    L78:
        r122.addAll(r26);
        Unit r27 = Unit.INSTANCE;
        MusicTemplateListFragment r28 = this.this$0;
        LarusPageTemplateBinding r29 = r28.g;
        if (r29 == null) goto L81;
        RecyclerView r123 = r29.e;
    L82:
        Bundle r30 = r28.getArguments();
        if (r30 == null) goto L85;
        r6 = new Bundle(r30);
    L85:
        r120.i = new MusicTemplateAdapter(r14, r20, r21, r22, r121, r122, r123, r6);
        MusicTemplateListFragment r124 = this.this$0;
        MusicTemplateAdapter r31 = r124.i;
        if (r31 == null) goto L88;
        r31.j = r124.d;
    L88:
        Logger.i("MusicTemplateListFragment", "setImageTemplateChoose hashcode is " + r4.hashCode());
        MusicTemplateListFragment r125 = this.this$0;
        MusicTemplateModel r32 = r125.m;
        if (r32 == null) goto L93;
        com.larus.bmhome.music.protocol.c r33 = r32.c;
        if (r33 == null) goto L93;
        boolean r34 = Intrinsics.areEqual(r33.a(), Boxing.boxBoolean(true));
    L94:
        r125.j = r34;
        MusicTemplateListFragment r126 = this.this$0;
        MusicTemplateAdapter r35 = r126.i;
        if (r35 == null) goto L97;
        r35.i = r126.j;
    L97:
        MusicTemplateModel r36 = r126.m;
        if (r36 == null) goto L104;
        com.larus.bmhome.music.protocol.c r37 = r36.c;
        if (r37 == null) goto L104;
        Integer r38 = r37.b();
        if (r38 == null) goto L104;
        int r39 = r38.intValue();
    L105:
        r126.l = r39;
        MusicTemplateListFragment r127 = this.this$0;
        LarusPageTemplateBinding r40 = r127.g;
        if (r40 == null) goto L110;
        RecyclerView r41 = r40.e;
        if (r41 == null) goto L110;
        r41.setAdapter(r127.i);
    L110:
        Logger.i("MusicTemplateListFragment", "requestFirstTemplateList offset is " + this.this$0.l);
    L121:
        this.this$0.k = false;
        return Unit.INSTANCE;
    L104:
        r39 = 0;
    L93:
        r34 = false;
        goto L94
    L81:
        r123 = null;
    L77:
        r26 = CollectionsKt.emptyList();
        goto L78
    L67:
        return Unit.INSTANCE;
    L111:
        LarusPageTemplateBinding r128 = r16.g;
        if (r128 == null) goto L116;
        LoadingWithRetryView r129 = r128.d;
        if (r129 == null) goto L116;
        r129.c(Boxing.boxInt(2131908354));
    L116:
        LarusPageTemplateBinding r130 = this.this$0.g;
        if (r130 == null) goto L121;
        RecyclerView r131 = r130.b;
        if (r131 == null) goto L121;
        e1.o(r131);
        goto L121
    L20:
        r7 = null;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r4 = (CoroutineScope) this.L$0;
        MusicTemplateListFragment r132 = this.this$0;
        r132.k = true;
        MusicTemplateModel r42 = r132.m;
        if (r42 != null) goto L11;
    L12:
        r3 = new MusicTemplateModel();
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r132;
        this.label = 1;
        if (r3.b(this) != r0) goto L15;
        return r0;
    L15:
        r2 = r132;
        goto L16
    L11:
        if (r42.c != null) goto L17;
        goto L12
    }
}
