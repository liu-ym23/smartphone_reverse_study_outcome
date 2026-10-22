package com.larus.uaigc.music.template;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.Logger;
import com.larus.uaigc.impl.databinding.LarusPageTemplateBinding;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateListFragment$requestMoreTemplateRecommendList$1", f = "MusicTemplateListFragment.kt", i = {1}, l = {345, 352}, m = "invokeSuspend", n = {"batchResult"}, s = {"L$0"})
final class MusicTemplateListFragment$requestMoreTemplateRecommendList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MusicTemplateListFragment this$0;

    public MusicTemplateListFragment$requestMoreTemplateRecommendList$1(MusicTemplateListFragment r1, Continuation<? super MusicTemplateListFragment$requestMoreTemplateRecommendList$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicTemplateListFragment$requestMoreTemplateRecommendList$1(this.this$0, r3);
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
        List r2 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        com.larus.bmhome.music.protocol.c r3 = (com.larus.bmhome.music.protocol.c) this.L$0;
        ResultKt.throwOnFailure(r10);
    L30:
        MusicTemplateListFragment$requestMoreTemplateRecommendList$1 r11 = this;
    L31:
        LarusPageTemplateBinding r7 = r11.this$0.g;
        if (r7 == null) goto L38;
        RecyclerView r8 = r7.e;
        if (r8 == null) goto L38;
        if (r8.isComputingLayout() != true) goto L38;
        boolean r9 = true;
    L39:
        if (r9 == false) goto L43;
        r11.L$0 = r3;
        r11.label = 2;
        if (DelayKt.delay(20, r11) != r0) goto L31;
        return r0;
    L43:
        Logger.i("MusicTemplateListFragment", "trying to refresh delay wait idle end");
        MusicTemplateAdapter r4 = r11.this$0.i;     // Catch: IllegalStateException -> L60
        if (r4 == null) goto L62;
        List r5 = r3.c();     // Catch: IllegalStateException -> L60
        if (r5 == null) goto L49;
        r2 = CollectionsKt.filterNotNull(r5);     // Catch: IllegalStateException -> L60
    L49:
        List r6 = r2;     // Catch: IllegalStateException -> L60
        if (r6 != null) goto L52;
    L55:
        boolean r12 = true;
    L56:
        if (r12 == false) goto L58;
        r4.notifyItemChanged(r4.getItemCount() - 1);     // Catch: IllegalStateException -> L60
        goto L62
    L58:
        int r13 = r4.f.size();     // Catch: IllegalStateException -> L60
        r4.f.addAll(r6);     // Catch: IllegalStateException -> L60
        int r14 = r4.getItemCount() - r13;     // Catch: IllegalStateException -> L60
        r4.A2();     // Catch: IllegalStateException -> L60
        r4.notifyItemRangeChanged(r13, r14);     // Catch: IllegalStateException -> L60
        goto L62
    L52:
        if (r6.isEmpty() == true) goto L55;
        r12 = false;
    L62:
        Logger.i("MusicTemplateListFragment", "requestTemplateRecommendList success result has more " + r11.this$0.j);
    L64:
        Logger.i("MusicTemplateListFragment", "requestTemplateRecommendList over");
        r11.this$0.k = false;
        return Unit.INSTANCE;
    L60:
        e = move-exception;
        Logger.i("MusicTemplateListFragment", "trying to refresh too fast", e);
    L38:
        r9 = false;
        goto L39
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L19:
        com.larus.bmhome.music.protocol.c r15 = (com.larus.bmhome.music.protocol.c) r10;
    L21:
        if (r15 == null) goto L63;
        this.this$0.j = Intrinsics.areEqual(r15.a(), Boxing.boxBoolean(true));
        MusicTemplateListFragment r16 = this.this$0;
        Integer r17 = r15.b();
        if (r17 == null) goto L25;
        int r18 = r17.intValue();
    L26:
        r16.l = r18;
        MusicTemplateListFragment r19 = this.this$0;
        MusicTemplateAdapter r20 = r19.i;
        if (r20 == null) goto L29;
        r20.i = r19.j;
    L29:
        Logger.i("MusicTemplateListFragment", "trying to refresh delay wait idle join");
        r3 = r15;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L63:
        r11 = this;
        goto L64
    L10:
        ResultKt.throwOnFailure(r10);
        if (this.this$0.k == true) goto L13;
        Logger.i("MusicTemplateListFragment", "requestTemplateRecommendList start");
        MusicTemplateListFragment r110 = this.this$0;
        r110.k = true;
        MusicTemplateModel r21 = r110.m;
        if (r21 == null) goto L20;
        int r111 = r110.l;
        this.label = 1;
        r10 = r21.a(r111, this);
        if (r10 != r0) goto L19;
        return r0;
    L20:
        r15 = null;
        goto L21
    L13:
        return Unit.INSTANCE;
    }
}
