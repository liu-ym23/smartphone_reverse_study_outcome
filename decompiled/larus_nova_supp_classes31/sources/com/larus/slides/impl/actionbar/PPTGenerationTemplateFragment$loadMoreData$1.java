package com.larus.slides.impl.actionbar;

import com.larus.network.http.y;
import com.larus.slides.impl.actionbar.model.PPTGenerationRepo;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$loadMoreData$1", f = "PPTGenerationTemplateFragment.kt", i = {}, l = {430, 436}, m = "invokeSuspend", n = {}, s = {})
final class PPTGenerationTemplateFragment$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PPTGenerationTemplateFragment this$0;

    /* JADX INFO: renamed from: com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$loadMoreData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.actionbar.PPTGenerationTemplateFragment$loadMoreData$1$1", f = "PPTGenerationTemplateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.slides.impl.actionbar.model.d $result;
        int label;
        final /* synthetic */ PPTGenerationTemplateFragment this$0;

        public AnonymousClass1(PPTGenerationTemplateFragment r1, com.larus.slides.impl.actionbar.model.d r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L29;
            ResultKt.throwOnFailure(r6);
            PPTGenerationTemplateFragment r7 = this.this$0;
            com.larus.slides.impl.actionbar.model.d r0 = this.$result;
            if (r0 == null) goto L7;
            boolean r1 = r0.a();
        L8:
            r7.h = r1;
            PPTGenerationTemplateFragment r8 = this.this$0;
            com.larus.slides.impl.actionbar.model.d r2 = this.$result;
            if (r2 == null) goto L11;
            int r3 = r2.b();
        L12:
            r8.i = r3;
            com.larus.slides.impl.actionbar.model.d r9 = this.$result;
            if (r9 == null) goto L27;
            List<com.larus.slides.impl.actionbar.model.c> r10 = r9.c();
            if (r10 == null) goto L27;
            List r11 = CollectionsKt.filterNotNull(r10);
            if (r11 == null) goto L27;
            PPTGenerationTemplateFragment r4 = this.this$0;
            ArrayList r5 = (ArrayList) r4.j;
            r5.addAll(r11);
            Iterator r12 = ((ArrayList) r4.j).iterator();
        L20:
            if (r12.hasNext() == false) goto L22;
            com.larus.slides.impl.actionbar.model.c r13 = (com.larus.slides.impl.actionbar.model.c) r12.next();
            r13.e(Intrinsics.areEqual(r13.b(), String.valueOf(r4.f)));
            goto L20
        L22:
            PPTTemplateAdapter r14 = r4.e;
            if (r14 == null) goto L25;
            r14.y2(r4.j, r4.h);
        L25:
            r4.g = false;
            j.a r15 = j.a;
            j.a(r4.j, r4.i, r4.h, r4.f);
            r4.S90();
        L27:
            return Unit.INSTANCE;
        L11:
            r3 = 0;
            goto L12
        L7:
            r1 = false;
            goto L8
        L29:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PPTGenerationTemplateFragment$loadMoreData$1(PPTGenerationTemplateFragment r1, Continuation<? super PPTGenerationTemplateFragment$loadMoreData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PPTGenerationTemplateFragment$loadMoreData$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        y r8 = (com.larus.network.http.a) r7;
        if ((r8 instanceof y) == false) goto L18;
        com.larus.slides.impl.actionbar.model.d r9 = (com.larus.slides.impl.actionbar.model.d) ((com.larus.network.http.a) r8).b;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, r9, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L28;
        return r0;
    L18:
        PPTGenerationTemplateFragment r10 = this.this$0;
        PPTTemplateAdapter r4 = r10.e;
        if (r4 == null) goto L26;
        PPTTemplateAdapter.LoadMoreState r5 = PPTTemplateAdapter.LoadMoreState.ERROR;
        Intrinsics.checkNotNullParameter(r5, "state");
        List r6 = CollectionsKt.toMutableList(r4.getCurrentList());
        CollectionsKt.removeAll(r6, new k());
        if (r5 == PPTTemplateAdapter.LoadMoreState.END) goto L23;
    L24:
        r6.add(new PPTTemplateAdapter.b.a(r5));
    L25:
        r4.submitList(r6);
        goto L26
    L23:
        if ((true ^ r6.isEmpty()) == false) goto L25;
    L26:
        r10.g = false;
        goto L28
    L10:
        ResultKt.throwOnFailure(r7);
        PPTGenerationRepo r11 = PPTGenerationRepo.a;
        int r12 = this.this$0.i;
        this.label = 1;
        r7 = r11.a(r12, 20, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
