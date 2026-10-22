package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.flow.f2;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.p2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aA\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0000*\u00028\u0001\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00028\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\n\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/p2;", "Lkotlin/coroutines/CoroutineContext;", "context", "Landroidx/compose/runtime/State;", "collectAsState", "(Lkotlinx/coroutines/flow/p2;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "R", "Lkotlinx/coroutines/flow/g;", "initial", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "block", "snapshotFlow", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/flow/g;", "", "other", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "(Ljava/util/Set;Ljava/util/Set;)Z", "intersects", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
@SourceDebugExtension({"SMAP\nSnapshotFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n1747#2,3:174\n*S KotlinDebug\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt\n*L\n172#1:174,3\n*E\n"})
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/compose/runtime/ProduceStateScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1", f = "SnapshotFlow.kt", i = {}, l = {64, 65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1<R> extends SuspendLambda implements Function2<ProduceStateScope<R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ g $this_collectAsState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2", f = "SnapshotFlow.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProduceStateScope<R> $$this$produceState;
            final /* synthetic */ g $this_collectAsState;
            int label;

            public AnonymousClass2(g r5, ProduceStateScope<R> r10, Continuation<? super AnonymousClass2> r11) {
                this.$this_collectAsState = r5;
                this.$$this$produceState = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                return new AnonymousClass2(this.$this_collectAsState, this.$$this$produceState, r10);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                g r12 = this.$this_collectAsState;
                final ProduceStateScope<R> r13 = this.$$this$produceState;
                h r14 = new C00021(r13);
                this.label = 1;
                if (r12.collect(r14, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public AnonymousClass1(CoroutineContext r5, g r10, Continuation<? super AnonymousClass1> r11) {
            this.$context = r5;
            this.$this_collectAsState = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.$context, this.$this_collectAsState, r10);
            r11.L$0 = r5;
            return r11;
        }

        public final Object invoke(ProduceStateScope<R> r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            final ProduceStateScope r12 = (ProduceStateScope) this.L$0;
            if (Intrinsics.areEqual(this.$context, EmptyCoroutineContext.INSTANCE) == false) goto L15;
            g r13 = this.$this_collectAsState;
            h r14 = new C00011(r12);
            this.label = 1;
            if (r13.collect(r14, this) != r5) goto L19;
            return r5;
        L15:
            CoroutineContext r15 = this.$context;
            AnonymousClass2 r16 = new AnonymousClass2(this.$this_collectAsState, r12, null);
            this.label = 2;
            if (BuildersKt.withContext(r15, r16, this) != r5) goto L19;
            return r5;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke((ProduceStateScope) r5, r10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {133, 137, 159}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @SourceDebugExtension({"SMAP\nSnapshotFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n*L\n1#1,173:1\n129#2,5:174\n129#2,5:179\n*S KotlinDebug\n*F\n+ 1 SnapshotFlow.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1\n*L\n128#1:174,5\n151#1:179,5\n*E\n"})
    public static final class C00641 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C00641(Function0<? extends T> r5, Continuation<? super C00641> r10) {
            this.$block = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C00641 r11 = new C00641(this.$block, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(h r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L20;
            if (r10 == 1) goto L19;
            if (r10 == 2) goto L14;
            if (r10 != 3) goto L13;
            Object r11 = this.L$5;
            ObserverHandle r12 = (ObserverHandle) this.L$4;
            final i r13 = (i) this.L$3;
            Function1<Object, Unit> r14 = (Function1) this.L$2;
            final Set r16 = (Set) this.L$1;
            h r17 = (h) this.L$0;
        L8:
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L10
        L28:
            this.L$0 = r17;     // Catch: Throwable -> L10
            this.L$1 = r16;     // Catch: Throwable -> L10
            this.L$2 = r14;     // Catch: Throwable -> L10
            this.L$3 = r13;     // Catch: Throwable -> L10
            this.L$4 = r12;     // Catch: Throwable -> L10
            this.L$5 = r11;     // Catch: Throwable -> L10
            this.I$0 = 0;     // Catch: Throwable -> L10
            this.label = 2;     // Catch: Throwable -> L10
            r15 = r13.l(this);     // Catch: Throwable -> L10
            if (r15 != r5) goto L31;
            return r5;
        L31:
            h r18 = r17;
            Set r19 = r16;
            Function1<Object, Unit> r110 = r14;
            i r20 = r13;
            ObserverHandle r21 = r12;
            Object r22 = r11;
            int r23 = 0;
        L32:
            Set r111 = (Set) r15;     // Catch: Throwable -> L17
        L33:
            if (r23 == 0) goto L35;
        L38:
            r23 = 1;
        L39:
            Object r112 = r20.j();     // Catch: Throwable -> L17
            if ((r112 instanceof m) == false) goto L43;
            r112 = null;
        L43:
            r111 = (Set) r112;     // Catch: Throwable -> L17
            if (r111 != null) goto L33;
            if (r23 == 0) goto L62;
            r19.clear();     // Catch: Throwable -> L17
            Snapshot r113 = Snapshot.Companion.takeSnapshot(r110);     // Catch: Throwable -> L17
            Function0<T> r24 = this.$block;     // Catch: Throwable -> L17
            Snapshot r114 = r113.makeCurrent();     // Catch: Throwable -> L55
            r11 = r24.invoke();     // Catch: Throwable -> L57
            r113.restoreCurrent(r114);     // Catch: Throwable -> L55
            r113.dispose();     // Catch: Throwable -> L17
            if (Intrinsics.areEqual(r11, r22) == true) goto L62;
            this.L$0 = r18;     // Catch: Throwable -> L17
            this.L$1 = r19;     // Catch: Throwable -> L17
            this.L$2 = r110;     // Catch: Throwable -> L17
            this.L$3 = r20;     // Catch: Throwable -> L17
            this.L$4 = r21;     // Catch: Throwable -> L17
            this.L$5 = r11;     // Catch: Throwable -> L17
            this.label = 3;     // Catch: Throwable -> L17
            if (r18.emit(r11, this) != r5) goto L63;
            return r5;
        L63:
            r12 = r21;
            r13 = r20;
            r14 = r110;
            r16 = r19;
            r17 = r18;
            goto L28
        L57:
            th = move-exception;
            r113.restoreCurrent(r114);     // Catch: Throwable -> L55
            throw th;     // Catch: Throwable -> L55
        L55:
            th = move-exception;
            r113.dispose();     // Catch: Throwable -> L17
            throw th;     // Catch: Throwable -> L17
        L17:
            th = th;
            r12 = r21;
        L71:
            r12.dispose();
            throw th;
        L62:
            r11 = r22;
            r12 = r21;
            r13 = r20;
            r14 = r110;
            r16 = r19;
            r17 = r18;
            goto L28
        L35:
            if (SnapshotStateKt__SnapshotFlowKt.access$intersects(r19, r111) == true) goto L38;
            r23 = 0;
            goto L39
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            r23 = this.I$0;
            r22 = this.L$5;
            r21 = (ObserverHandle) this.L$4;
            r20 = (i) this.L$3;
            r110 = (Function1) this.L$2;
            r19 = (Set) this.L$1;
            r18 = (h) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L17
            goto L32
        L19:
            r11 = this.L$5;
            r12 = (ObserverHandle) this.L$4;
            r13 = (i) this.L$3;
            r14 = (Function1) this.L$2;
            r16 = (Set) this.L$1;
            r17 = (h) this.L$0;
            goto L8
        L20:
            ResultKt.throwOnFailure(r15);
            r17 = (h) this.L$0;
            r16 = new LinkedHashSet();
            r14 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1(r16);
            r13 = p.a(Integer.MAX_VALUE, 6, null);
            Snapshot.Companion r115 = Snapshot.Companion;
            r12 = r115.registerApplyObserver(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(r13));
            Snapshot r116 = r115.takeSnapshot(r14);     // Catch: Throwable -> L10
            Function0<T> r25 = this.$block;     // Catch: Throwable -> L10
            Snapshot r117 = r116.makeCurrent();     // Catch: Throwable -> L64
            r11 = r25.invoke();     // Catch: Throwable -> L66
            r116.restoreCurrent(r117);     // Catch: Throwable -> L64
            r116.dispose();     // Catch: Throwable -> L10
            this.L$0 = r17;     // Catch: Throwable -> L10
            this.L$1 = r16;     // Catch: Throwable -> L10
            this.L$2 = r14;     // Catch: Throwable -> L10
            this.L$3 = r13;     // Catch: Throwable -> L10
            this.L$4 = r12;     // Catch: Throwable -> L10
            this.L$5 = r11;     // Catch: Throwable -> L10
            this.label = 1;     // Catch: Throwable -> L10
            if (r17.emit(r11, this) != r5) goto L28;
            return r5;
        L66:
            th = move-exception;
            r116.restoreCurrent(r117);     // Catch: Throwable -> L64
            throw th;     // Catch: Throwable -> L64
        L64:
            th = move-exception;
            r116.dispose();     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L10:
            th = th;
            goto L71
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(h r5, Continuation<? super Unit> r10) {
            return ((C00641) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final /* synthetic */ boolean access$intersects(Set r5, Set r10) {
        return intersects$SnapshotStateKt__SnapshotFlowKt(r5, r10);
    }

    @Composable
    public static final <T> State<T> collectAsState(p2 r10, CoroutineContext r11, Composer r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r12.startReplaceableGroup(-1439883919);
        if ((r14 & 1) == 0) goto L5;
        r11 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r5 = r11;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1439883919, r13, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:44)");
    L8:
        State<T> r15 = SnapshotStateKt.collectAsState(r10, r10.getValue(), r5, r12, 520, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r12.endReplaceableGroup();
        return r15;
    }

    private static final <T> boolean intersects$SnapshotStateKt__SnapshotFlowKt(Set<? extends T> r5, Set<? extends T> r10) {
        if (r5.size() >= r10.size()) goto L15;
        Set<? extends T> r11 = r5;
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L25;
        if (r10.contains(r12.next()) == false) goto L11;
        return true;
    L25:
        return false;
    L7:
        if (r11.isEmpty() == false) goto L9;
    L15:
        Set<? extends T> r13 = r10;
        if ((r13 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r14 = r13.iterator();
    L22:
        if (r14.hasNext() == false) goto L25;
        if (r5.contains(r14.next()) == false) goto L22;
        return true;
    L18:
        if (r13.isEmpty() == false) goto L20;
        goto L20
    }

    public static final <T> g snapshotFlow(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        return new f2(new C00641(r5, null));
    }

    @Composable
    public static final <T extends R, R> State<R> collectAsState(g r10, R r11, CoroutineContext r12, Composer r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r13.startReplaceableGroup(-606625098);
        if ((r15 & 2) == 0) goto L5;
        r12 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r5 = r12;
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-606625098, r14, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:58)");
    L8:
        int r16 = r14 >> 3;
        State<R> r17 = SnapshotStateKt.produceState(r11, r10, r5, new AnonymousClass1(r5, r10, null), r13, ((r16 & 8) | 4672) | (r16 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        r13.endReplaceableGroup();
        return r17;
    }
}
