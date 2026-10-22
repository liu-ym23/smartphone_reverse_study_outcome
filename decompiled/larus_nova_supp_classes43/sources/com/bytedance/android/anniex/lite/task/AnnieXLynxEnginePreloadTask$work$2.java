package com.bytedance.android.anniex.lite.task;

import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2", f = "AnnieXLynxEnginePreloadTask.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXLynxEnginePreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.android.anniex.lite.flow.base.model.a $input;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ c this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lra/a;", "model", "", "enable", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$1", f = "AnnieXLynxEnginePreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<ra.a, Boolean, Continuation<? super ra.a>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(3, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11) {
            return invoke((ra.a) r1, ((Boolean) r10).booleanValue(), (Continuation) r11);
        }

        public final Object invoke(ra.a r10, boolean r11, Continuation<? super ra.a> r12) {
            AnonymousClass1 r0 = new AnonymousClass1(r12);
            r0.L$0 = r10;
            r0.Z$0 = r11;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            ra.a r11 = (ra.a) this.L$0;
            if (this.Z$0 == true) goto L11;
            return null;
        L11:
            return r11;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AnnieXLynxEnginePreloadTask$work$2(com.bytedance.android.anniex.lite.flow.base.model.a r1, c r10, Continuation<? super AnnieXLynxEnginePreloadTask$work$2> r11) {
        this.$input = r1;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AnnieXLynxEnginePreloadTask$work$2 r0 = new AnnieXLynxEnginePreloadTask$work$2(this.$input, null, r11);
        r0.L$0 = r10;
        return r0;
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
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        qa.b r12 = (qa.b) this.$input.a(qa.b.class);
        PreTaskSchemaModel r13 = (PreTaskSchemaModel) this.$input.a(PreTaskSchemaModel.class);
        v0 r14 = new v0(r12.d, r13.f, new AnonymousClass1(null));
        AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 r15 = new AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1(r12, r11);
        this.label = 1;
        if (r14.collect(r15, this) != r0) goto L12;
        return r0;
    }
}
