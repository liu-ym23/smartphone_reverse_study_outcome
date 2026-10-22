package com.larus.search.impl.combine;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.business.search.impl.databinding.LarusFragmentCombineSearchBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment$EventHelper$onBotClick$1", f = "CombineSearchFragment.kt", i = {}, l = {991}, m = "invokeSuspend", n = {}, s = {})
public final class CombineSearchFragment$EventHelper$onBotClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ CombineSearchFragment this$0;
    final /* synthetic */ CombineSearchFragment.EventHelper this$1;

    public CombineSearchFragment$EventHelper$onBotClick$1(CombineSearchFragment r1, RecommendBot r2, int r3, CombineSearchFragment.EventHelper r4, Continuation<? super CombineSearchFragment$EventHelper$onBotClick$1> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.$position = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CombineSearchFragment$EventHelper$onBotClick$1(this.this$0, this.$data, this.$position, this.this$1, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L11:
        final String r4 = (String) r3;
        FLogger.a.i("CombineSearchFragment", "onBotClick: " + this.$data.o() + " conversationId: " + r4);
        LarusFragmentCombineSearchBinding r5 = this.this$0.e;
        if (r5 == null) goto L16;
        SearchBar r6 = r5.c;
        if (r6 == null) goto L16;
        boolean r7 = ViewExtKt.h(r6);
    L17:
        if (r7 == false) goto L28;
        LarusFragmentCombineSearchBinding r8 = this.this$0.e;
        if (r8 == null) goto L23;
        SearchBar r9 = r8.c;
        if (r9 == null) goto L23;
        r9.a();
    L23:
        final CombineSearchFragment r10 = this.this$0;
        LarusFragmentCombineSearchBinding r11 = r10.e;
        if (r11 == null) goto L29;
        SearchBar r12 = r11.c;
        if (r12 == null) goto L29;
        final RecommendBot r13 = this.$data;
        final int r14 = this.$position;
        Boxing.boxBoolean(r12.postDelayed(new v(r10, r13, r4, r14), 300));
    L29:
        String r15 = this.$data.o();
        String r16 = this.this$0.aa0(this.$data);
        SearchMobParam r17 = this.$data.b;
        if (r17 == null) goto L32;
        String r19 = r17.c;
    L33:
        if (r17 == null) goto L35;
        String r20 = r17.d;
    L36:
        if (r17 == null) goto L38;
        String r110 = r17.e;
    L39:
        boolean r21 = this.this$1.a;
        if (r21 == false) goto L42;
        String r22 = "rec_bot";
    L43:
        String r111 = r22;
        if (r17 == null) goto L46;
        String r23 = r17.f;
    L47:
        i3.e(r15, r16, null, r23, r19, r20, r110, r111, null, null, Boxing.boxBoolean(!r21), this.this$0, 22620);
        return Unit.INSTANCE;
    L46:
        r23 = null;
        goto L47
    L42:
        r22 = "bot";
        goto L43
    L38:
        r110 = null;
        goto L39
    L35:
        r20 = null;
        goto L36
    L32:
        r19 = null;
        goto L33
    L28:
        CombineSearchFragment.ja0(this.this$0, this.$data, r4, this.$position);
    L16:
        r7 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        CombineSearchFragment r24 = this.this$0;
        RecommendBot r25 = this.$data;
        this.label = 1;
        r3 = CombineSearchFragment.U90(r24, r25, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
