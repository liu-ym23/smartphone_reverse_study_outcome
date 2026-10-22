package com.larus.search.impl.global;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.business.search.impl.databinding.LarusFragmentGlobalSearchBinding;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.platform.model.SearchMobParam;
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
@DebugMetadata(c = "com.larus.search.impl.global.GlobalSearchFragment$eventHelper$1$onBotClick$1", f = "GlobalSearchFragment.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalSearchFragment$eventHelper$1$onBotClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ GlobalSearchFragment$eventHelper$1 this$0;
    final /* synthetic */ GlobalSearchFragment this$1;

    public GlobalSearchFragment$eventHelper$1$onBotClick$1(GlobalSearchFragment$eventHelper$1 r1, RecommendBot r2, GlobalSearchFragment r3, int r4, Continuation<? super GlobalSearchFragment$eventHelper$1$onBotClick$1> r5) {
        this.this$0 = r1;
        this.$data = r2;
        this.this$1 = r3;
        this.$position = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GlobalSearchFragment$eventHelper$1$onBotClick$1(this.this$0, this.$data, this.this$1, this.$position, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        final String r15 = (String) r14;
        LarusFragmentGlobalSearchBinding r2 = this.this$1.e;
        if (r2 == null) goto L16;
        SearchBar r3 = r2.c;
        if (r3 == null) goto L16;
        boolean r4 = ViewExtKt.h(r3);
    L17:
        if (r4 == false) goto L28;
        LarusFragmentGlobalSearchBinding r5 = this.this$1.e;
        if (r5 == null) goto L23;
        SearchBar r6 = r5.c;
        if (r6 == null) goto L23;
        r6.a();
    L23:
        LarusFragmentGlobalSearchBinding r7 = this.this$1.e;
        if (r7 == null) goto L29;
        SearchBar r8 = r7.c;
        if (r8 == null) goto L29;
        final GlobalSearchFragment$eventHelper$1 r9 = this.this$0;
        final RecommendBot r10 = this.$data;
        final int r11 = this.$position;
        Boxing.boxBoolean(r8.postDelayed(new p(r9, r10, r15, r11), 300));
    L29:
        String r12 = this.$data.o();
        String r13 = this.this$1.V90(this.$data);
        SearchMobParam r16 = this.$data.b;
        if (r16 == null) goto L32;
        String r17 = r16.c;
    L33:
        if (r16 == null) goto L35;
        String r18 = r16.d;
    L36:
        if (r16 == null) goto L38;
        String r19 = r16.e;
    L39:
        if (r16 == null) goto L41;
        String r20 = r16.f;
    L42:
        i3.e(r12, r13, null, r20, r17, r18, r19, null, null, null, null, this.this$1, 31836);
        return Unit.INSTANCE;
    L41:
        r20 = null;
        goto L42
    L38:
        r19 = null;
        goto L39
    L35:
        r18 = null;
        goto L36
    L32:
        r17 = null;
        goto L33
    L28:
        GlobalSearchFragment$eventHelper$1.f(this.this$0, this.$data, r15, this.$position);
    L16:
        r4 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        GlobalSearchFragment$eventHelper$1 r110 = this.this$0;
        RecommendBot r21 = this.$data;
        this.label = 1;
        r14 = GlobalSearchFragment$eventHelper$1.e(r110, r21, this);
        if (r14 != r0) goto L11;
        return r0;
    }
}
