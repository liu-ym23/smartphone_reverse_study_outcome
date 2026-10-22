package com.obric.aivoice.core.utils;

import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.v;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u00052\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a<\u0010\r\u001a\u00020\f*\u00020\b2#\b\u0004\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0000H\u0086Hø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a?\u0010\u0012\u001a\u00020\u0002\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a3\u0010\u0013\u001a\u00020\u0002*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a?\u0010\u0014\u001a\u00020\f\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a\u001e\u0010\u0016\u001a\u00020\u0002*\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0086\fø\u0001\u0001\"\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "block", "Lkotlinx/coroutines/Job;", "listenConnectionChanged", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "it", "Lcom/obric/aivoice/core/utils/TryRunResult;", "tryBinder", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", NameKeys.UnloadStrategy_No_Strategy, "T", "t", "catch", "catchAll", "catching", "Lkotlin/Function0;", "finally", "Lkotlinx/coroutines/flow/z0;", NameKeys.UnloadStrategy_No_Strategy, "connStatusEvent", "Lkotlinx/coroutines/flow/z0;", "getConnStatusEvent", "()Lkotlinx/coroutines/flow/z0;", "voicesdk_release"}, k = 2, mv = {1, 7, 1})
public final class TryExtKt {
    private static final z0<Boolean> connStatusEvent = null;

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", NameKeys.UnloadStrategy_No_Strategy, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1", f = "TryExt.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy, "emit", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class C00711<T> implements FlowCollector {
            final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;

            public C00711(Function1<? super Continuation<? super Unit>, ? extends Object> r1) {
                this.$block = r1;
            }

            public final Object emit(boolean r5, Continuation<? super Unit> r6) {
                if ((r6 instanceof TryExtKt$listenConnectionChanged$1$1$emit$1) == false) goto L7;
                TryExtKt$listenConnectionChanged$1$1$emit$1 r0 = (TryExtKt$listenConnectionChanged$1$1$emit$1) r6;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r7 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L12;
                ResultKt.throwOnFailure(r7);
            L20:
                throw new CancellationException("disconnection posted.");
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r7);
                if (r5 == true) goto L22;
                Function1<Continuation<? super Unit>, Object> r8 = this.$block;
                r0.label = 1;
                if (r8.invoke(r0) != r2) goto L20;
                return r2;
            L22:
                return Unit.INSTANCE;
            L7:
                r0 = new TryExtKt$listenConnectionChanged$1$1$emit$1(this, r6);
                goto L8
            }

            public /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return emit(((Boolean) r1).booleanValue(), r2);
            }
        }

        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AnonymousClass1> r2) {
            this.$block = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$block, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            v r6 = e.p(TryExtKt.getConnStatusEvent(), 1);
            C00711 r2 = new C00711(this.$block);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$tryBinder$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
    @DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt", f = "TryExt.kt", i = {}, l = {31}, m = "tryBinder", n = {}, s = {})
    public static final class C01381 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01381(Continuation<? super C01381> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return TryExtKt.tryBinder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$tryBinder$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy, "emit", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2<T> implements FlowCollector {
        public static final AnonymousClass2<T> INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
        }

        public /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return emit(((Boolean) r1).booleanValue(), r2);
        }

        public final Object emit(boolean r1, Continuation<? super Unit> r2) {
            throw new BinderCloseException();
        }
    }

    static {
        connStatusEvent = j1.a(Boolean.FALSE);
    }

    public static final z0<Boolean> getConnStatusEvent() {
        return connStatusEvent;
    }

    public static final Job listenConnectionChanged(Function1<? super Continuation<? super Unit>, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(r7, null), 3, null);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final /* synthetic */ <T extends Throwable> void m34catch(TryRunResult r3, Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        if ((r3.getThrowable() instanceof CancellationException) == true) goto L13;
        Throwable r0 = r3.getThrowable();
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((r0 instanceof Throwable) == false) goto L8;
        r4.invoke(r3.getThrowable());
        return;
    L8:
        if (r3.getThrowable() != null) goto L11;
        return;
    L11:
        throw r3.getThrowable();
    L13:
        throw r3.getThrowable();
    }

    public static final void catchAll(TryRunResult r1, Function1<? super Throwable, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "block");
        if ((r1.getThrowable() instanceof CancellationException) == true) goto L9;
        if (r1.getThrowable() == null) goto L10;
        r2.invoke(r1.getThrowable());
        return;
    L10:
        return;
    L9:
        throw r1.getThrowable();
    }

    public static final /* synthetic */ <T extends Throwable> TryRunResult catching(TryRunResult r3, Function1<? super T, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        Throwable r0 = r3.getThrowable();
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((r0 instanceof Throwable) == false) goto L6;
        r4.invoke(r3.getThrowable());
        return new TryRunResult(null);
    L6:
        return r3;
    }

    /* JADX INFO: renamed from: finally, reason: not valid java name */
    public static final void m35finally(TryRunResult r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "block");
        r2.invoke();
        if (r1.getThrowable() != null) goto L6;
        return;
    L6:
        throw r1.getThrowable();
    }

    public static final Object tryBinder(CoroutineScope r4, Function1<? super CoroutineScope, Unit> r5, Continuation<? super TryRunResult> r6) {
        if ((r6 instanceof C01381) == false) goto L7;
        C01381 r0 = (C01381) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L12;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L21
    L20:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L21
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        r5.invoke(r4);     // Catch: Throwable -> L21
        z0<Boolean> r8 = getConnStatusEvent();     // Catch: Throwable -> L21
        FlowCollector r9 = AnonymousClass2.INSTANCE;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        if (r8.collect(r9, r0) != r2) goto L20;
        return r2;
    L21:
        th = move-exception;
        return new TryRunResult(th);
    L7:
        r0 = new C01381(r6);
        goto L8
    }

    private static final Object tryBinder$$forInline(CoroutineScope r1, Function1<? super CoroutineScope, Unit> r2, Continuation<? super TryRunResult> r3) {
        r2.invoke(r1);     // Catch: Throwable -> L4
        z0<Boolean> r4 = getConnStatusEvent();     // Catch: Throwable -> L4
        FlowCollector r5 = AnonymousClass2.INSTANCE;     // Catch: Throwable -> L4
        InlineMarker.mark(0);     // Catch: Throwable -> L4
        r4.collect(r5, r3);     // Catch: Throwable -> L4
        InlineMarker.mark(1);     // Catch: Throwable -> L4
        throw new KotlinNothingValueException();     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        return new TryRunResult(th);
    }
}
