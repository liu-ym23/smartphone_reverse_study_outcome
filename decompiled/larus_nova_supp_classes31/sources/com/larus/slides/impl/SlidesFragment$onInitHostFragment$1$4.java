package com.larus.slides.impl;

import android.os.Bundle;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$onInitHostFragment$1$4", f = "SlidesFragment.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesFragment$onInitHostFragment$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SlidesFragment this$0;

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesFragment$onInitHostFragment$1$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$onInitHostFragment$1$4$1", f = "SlidesFragment.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;
        final /* synthetic */ SlidesFragment this$0;

        public AnonymousClass1(SlidesFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<String> r5 = this.this$0.J;
            this.label = 1;
            r4 = r5.await(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public SlidesFragment$onInitHostFragment$1$4(SlidesFragment r1, Continuation<? super SlidesFragment$onInitHostFragment$1$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SlidesFragment$onInitHostFragment$1$4(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r60) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        SlidesFragment r3 = (SlidesFragment) this.L$0;
        ResultKt.throwOnFailure(r60);
        Object r4 = r60;
    L20:
        r3.G = (String) r4;
    L21:
        SlidesFragment r5 = this.this$0;
        r5.H = true;
        String r12 = SlidesFragment.ha0(r5);
        JSONObject r6 = new JSONObject();
        SlidesFragment r7 = this.this$0;
        r6.put("artifact_type", 9);
        r6.put("artifact_create_method", SlidesFragment.ga0(r7));
        r6.put("resource_type", SlidesFragment.ia0(r7));
        r6.put("resource_id", r7.j);
        r6.put("presentation_id", r7.j);
        r6.put("artifact_meta_id", r7.F);
        Bundle r8 = r7.getArguments();
        if (r8 == null) goto L26;
        String r9 = r8.getString("aippt_task_id");
        if (r9 == null) goto L26;
        r6.put("aippt_task_id", r9);
    L26:
        a1.c(null, null, null, null, null, "aippt_new_detail", null, null, r12, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r6, this.this$0, null, null, null, null, null, null, null, -1153, -25165825, 7);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r60);
        String r10 = this.this$0.G;
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == false) goto L21;
        SlidesFragment r13 = this.this$0;
        AnonymousClass1 r14 = new AnonymousClass1(r13, null);
        this.L$0 = r13;
        this.label = 1;
        r4 = TimeoutKt.c(15000, r14, this);
        if (r4 != r1) goto L19;
        return r1;
    L19:
        r3 = r13;
        goto L20
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    }
}
