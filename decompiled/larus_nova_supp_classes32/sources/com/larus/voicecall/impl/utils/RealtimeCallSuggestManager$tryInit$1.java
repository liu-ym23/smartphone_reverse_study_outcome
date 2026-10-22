package com.larus.voicecall.impl.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSuggestManager$tryInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycle;
    final /* synthetic */ Function2<Long, Continuation<? super Unit>, Object> $onInit;
    final /* synthetic */ Function3<List<String>, String, Continuation<? super Unit>, Object> $onUpdate;
    int label;
    final /* synthetic */ RealtimeCallSuggestManager this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {49, 49}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<List<String>, String, Continuation<? super Unit>, Object> $onUpdate;
        Object L$0;
        int label;
        final /* synthetic */ RealtimeCallSuggestManager this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> r1, RealtimeCallSuggestManager r2, Continuation<? super AnonymousClass1> r3) {
            this.$onUpdate = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$onUpdate, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Function3<List<String>, String, Continuation<? super Unit>, Object> r2 = (Function3) this.L$0;
            ResultKt.throwOnFailure(r6);
        L13:
            String r3 = RealtimeCallSuggestManager.ShowFrom.CALL_DIRECT.getValue();
            this.L$0 = null;
            this.label = 2;
            if (r2.invoke(r6, r3, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            r2 = this.$onUpdate;
            RealtimeCallSuggestManager.Repository r7 = (RealtimeCallSuggestManager.Repository) this.this$0.d.getValue();
            this.L$0 = r2;
            this.label = 1;
            r6 = r7.a(this);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1$3", f = "RealtimeCallSuggestManager.kt", i = {}, l = {57, 57}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<List<String>, String, Continuation<? super Unit>, Object> $onUpdate;
        Object L$0;
        int label;
        final /* synthetic */ RealtimeCallSuggestManager this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> r1, RealtimeCallSuggestManager r2, Continuation<? super AnonymousClass3> r3) {
            this.$onUpdate = r1;
            this.this$0 = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass3(this.$onUpdate, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Function3<List<String>, String, Continuation<? super Unit>, Object> r2 = (Function3) this.L$0;
            ResultKt.throwOnFailure(r6);
        L13:
            String r3 = RealtimeCallSuggestManager.ShowFrom.CALL_SILENCE_POPUP.getValue();
            this.L$0 = null;
            this.label = 2;
            if (r2.invoke(r6, r3, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            r2 = this.$onUpdate;
            RealtimeCallSuggestManager.Repository r7 = (RealtimeCallSuggestManager.Repository) this.this$0.d.getValue();
            this.L$0 = r2;
            this.label = 1;
            r6 = r7.a(this);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeCallSuggestManager$tryInit$1(RealtimeCallSuggestManager r1, Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> r2, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> r3, LifecycleOwner r4, Continuation<? super RealtimeCallSuggestManager$tryInit$1> r5) {
        this.this$0 = r1;
        this.$onUpdate = r2;
        this.$onInit = r3;
        this.$lifecycle = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RealtimeCallSuggestManager$tryInit$1(this.this$0, this.$onUpdate, this.$onInit, this.$lifecycle, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.utils.o] */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L16:
        if (AppHost.a.isOversea() == false) goto L18;
        RealtimeCallSuggestManager r10 = this.this$0;
        r10.g = false;
        BuildersKt.launch$default(r10.a, null, null, new AnonymousClass1(this.$onUpdate, r10, null), 3, null);
    L18:
        com.larus.voicecall.impl.component.scene.a r11 = this.this$0.c;
        if (r11 == null) goto L23;
        LiveData<com.larus.voicecall.impl.scene.m> r12 = r11.getCurrentScene();
        if (r12 == null) goto L23;
        LifecycleOwner r2 = this.$lifecycle;
        final RealtimeCallSuggestManager r3 = this.this$0;
        final Function3<List<String>, String, Continuation<? super Unit>, Object> r4 = this.$onUpdate;
        r12.observe(r2, new RealtimeCallSuggestManager.a(new o(r3, r4)));
    L23:
        RealtimeCallSuggestManager.Timer r13 = (RealtimeCallSuggestManager.Timer) this.this$0.e.getValue();
        AnonymousClass3 r5 = new AnonymousClass3(this.$onUpdate, this.this$0, null);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "onFinish");
        r13.b = r5;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        RealtimeCallSuggestManager r14 = this.this$0;
        r14.f = this.$onUpdate;
        Function2<Long, Continuation<? super Unit>, Object> r15 = this.$onInit;
        Long r6 = z2.a.realtimeSuggestUIConfig().getSuggestSwitchInterval();
        if (r6 == null) goto L11;
        long r7 = r6.longValue();
    L12:
        Long r8 = Boxing.boxLong(r7);
        this.label = 1;
        if (r15.invoke(r8, this) != r0) goto L16;
        return r0;
    L11:
        r7 = 3000;
        goto L12
    }
}
