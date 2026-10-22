package com.bytedance.android.anniex.lite.task;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.h;
import ib.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.b1;
import t36.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2", f = "AnnieXCacheParamTask.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXCacheParamTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.base.model.a $input;
    int label;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lt36/j;", "schemaModelUnion", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2$1", f = "AnnieXCacheParamTask.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<j, Continuation<? super Unit>, Object> {
        final /* synthetic */ qa.b $loadStateModel;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ a this$0;

        public AnonymousClass1(a r1, qa.b r10, Continuation<? super AnonymousClass1> r11) {
            this.$loadStateModel = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r0 = new AnonymousClass1(null, this.$loadStateModel, r11);
            r0.L$0 = r10;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((j) r1, (Continuation) r10);
        }

        public final Object invoke(j r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 != 0) goto L5;
            ResultKt.throwOnFailure(r10);
            j r11 = (j) this.L$0;
            if (r11 == null) goto L23;
            Uri r12 = r11.a.getOriginUrl();
            if (e.b(r12) != null) goto L16;
            return Unit.INSTANCE;
        L16:
            if (h.l0() == false) goto L23;
            if (com.bytedance.ies.bullet.service.router.d.a(r12, "flow_page_cache_param") == null) goto L23;
            r12.buildUpon().appendQueryParameter("enable_lite_page_annie_cache_param", "1").build();
            com.bytedance.android.anniex.assemble.a r13 = com.bytedance.android.anniex.assemble.a.a;
            throw null;
        L23:
            return Unit.INSTANCE;
        L5:
            if (r0 != 1) goto L8;
            ResultKt.throwOnFailure(r10);
            goto L23
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AnnieXCacheParamTask$work$2(com.bytedance.android.anniex.lite.flow.base.model.a r1, a r10, Continuation<? super AnnieXCacheParamTask$work$2> r11) {
        this.$input = r1;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXCacheParamTask$work$2(this.$input, null, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        qa.b r11 = (qa.b) this.$input.a(qa.b.class);
        b1 r12 = r11.c;
        AnonymousClass1 r13 = new AnonymousClass1(null, r11, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r12, r13, this) != r0) goto L12;
        return r0;
    }
}
