package com.ss.android.lark.picker.doubao.view.pickercommon;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterProvider;
import com.ss.android.lark.picker.doubao.api.DoubaoLocalChatterTagState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ2\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010%\u001a\u00020\u001aJ\b\u0010&\u001a\u00020\u001aH\u0002J\u000e\u0010'\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0017\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher;", "", "provider", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "batchWindowMs", "", "<init>", "(Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterProvider;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;J)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pendingIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "inFlightIds", "", "resolvedStates", "", "Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "unavailableIds", "callbacks", "", "Lkotlin/Function1;", "", "flushJob", "Lkotlinx/coroutines/Job;", "destroyed", "", "request", "chatterId", "currentState", "Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "currentHasTagData", "onResolved", "destroy", "scheduleFlush", "flushPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoChatterTagEnricher {
    private static final Companion Companion = null;
    private static final long DEFAULT_BATCH_WINDOW_MS = 16;
    private static final String TAG = "DoubaoTagEnricher";
    private final long batchWindowMs;
    private final Map<String, List<Function1<DoubaoLocalChatterTagState, Unit>>> callbacks;
    private boolean destroyed;
    private Job flushJob;
    private final Set<String> inFlightIds;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineDispatcher mainDispatcher;
    private final LinkedHashSet<String> pendingIds;
    private final DoubaoLocalChatterProvider provider;
    private final Map<String, DoubaoLocalChatterTagState> resolvedStates;
    private final CoroutineScope scope;
    private final Set<String> unavailableIds;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoChatterTagEnricher$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_BATCH_WINDOW_MS", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$flushPending$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher", f = "DoubaoChatterTagEnricher.kt", i = {0}, l = {97}, m = "flushPending", n = {"ids"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoubaoChatterTagEnricher this$0;

        public AnonymousClass1(DoubaoChatterTagEnricher r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoubaoChatterTagEnricher.access$flushPending(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$scheduleFlush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.doubao.view.pickercommon.DoubaoChatterTagEnricher$scheduleFlush$1", f = "DoubaoChatterTagEnricher.kt", i = {}, l = {82, 83}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoubaoChatterTagEnricher this$0;

        public C03691(DoubaoChatterTagEnricher r1, Continuation<? super C03691> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03691(this.this$0, r3);
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
        L16:
            DoubaoChatterTagEnricher.access$setFlushJob$p(this.this$0, null);
            if ((!DoubaoChatterTagEnricher.access$getPendingIds$p(this.this$0).isEmpty()) == false) goto L20;
            DoubaoChatterTagEnricher.access$scheduleFlush(this.this$0);
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            DoubaoChatterTagEnricher r8 = this.this$0;
            this.label = 2;
            if (DoubaoChatterTagEnricher.access$flushPending(r8, this) != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            long r4 = DoubaoChatterTagEnricher.access$getBatchWindowMs$p(this.this$0);
            this.label = 1;
            if (DelayKt.delay(r4, this) != r0) goto L13;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void scheduleFlush() {
        Job r0 = this.flushJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        this.flushJob = BuildersKt.launch$default(this.scope, null, null, new C03691(this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void destroy() {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = true;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.flushJob = null;
        this.pendingIds.clear();
        this.inFlightIds.clear();
        this.callbacks.clear();
        this.resolvedStates.clear();
        this.unavailableIds.clear();
    }

    public static final /* synthetic */ long access$getBatchWindowMs$p(DoubaoChatterTagEnricher r2) {
        return r2.batchWindowMs;
    }

    public static final /* synthetic */ LinkedHashSet access$getPendingIds$p(DoubaoChatterTagEnricher r0) {
        return r0.pendingIds;
    }

    public static final /* synthetic */ DoubaoLocalChatterProvider access$getProvider$p(DoubaoChatterTagEnricher r0) {
        return r0.provider;
    }

    public static final /* synthetic */ void access$scheduleFlush(DoubaoChatterTagEnricher r0) {
        r0.scheduleFlush();
    }

    private final Object flushPending(Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        List r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L28:
        Object r12 = Result.constructor-impl((Map) r11);     // Catch: Throwable -> L14
    L34:
        if (this.destroyed == false) goto L38;
        return Unit.INSTANCE;
    L38:
        if (Result.isSuccess-impl(r12) == false) goto L59;
        Map r5 = (Map) r12;
        Iterator r6 = r4.iterator();
    L41:
        if (r6.hasNext() == false) goto L59;
        String r7 = (String) r6.next();
        DoubaoLocalChatterTagState r8 = (DoubaoLocalChatterTagState) r5.get(r7);
        List<Function1<DoubaoLocalChatterTagState, Unit>> r9 = this.callbacks.remove(r7);
        if (r9 != null) goto L45;
        r9 = CollectionsKt.emptyList();
    L45:
        this.inFlightIds.remove(r7);
        if (r8 == null) goto L47;
        this.resolvedStates.put(r7, r8);
        Iterator<T> r13 = r9.iterator();
    L50:
        if (r13.hasNext() == false) goto L41;
        Function1 r14 = (Function1) r13.next();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L54
        r14.invoke(r8);     // Catch: Throwable -> L54
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L54
    L56:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L50;
        Log.e(TAG, "notify local chatter tag state failed", r17);
    L54:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L47:
        Boxing.boxBoolean(this.unavailableIds.add(r7));
    L59:
        Throwable r19 = Result.exceptionOrNull-impl(r12);
        if (r19 == null) goto L66;
        Log.e(TAG, "get local chatter tag states failed, count=" + r4.size(), r19);
        Iterator r110 = r4.iterator();
    L63:
        if (r110.hasNext() == false) goto L66;
        String r20 = (String) r110.next();
        this.unavailableIds.add(r20);
        this.callbacks.remove(r20);
        this.inFlightIds.remove(r20);
    L66:
        return Unit.INSTANCE;
    L14:
        Throwable th = th;
    L32:
        Result.Companion r21 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        List r111 = CollectionsKt.toList(this.pendingIds);
        this.pendingIds.clear();
        if (r111.isEmpty() == true) goto L68;
        if (this.destroyed == true) goto L68;
        this.inFlightIds.addAll(r111);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L30
        CoroutineDispatcher r23 = this.ioDispatcher;     // Catch: Throwable -> L30
        DoubaoChatterTagEnricher$flushPending$result$1$1 r24 = new DoubaoChatterTagEnricher$flushPending$result$1$1(this, r111, null);     // Catch: Throwable -> L30
        r0.L$0 = r111;     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        Object r25 = BuildersKt.withContext(r23, r24, r0);     // Catch: Throwable -> L30
        if (r25 != r2) goto L27;
        return r2;
    L27:
        r4 = r111;
        r11 = r25;
    L30:
        th = move-exception;
        r4 = r111;
        th = th;
    L68:
        return Unit.INSTANCE;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object access$flushPending(DoubaoChatterTagEnricher r0, Continuation r1) {
        return r0.flushPending(r1);
    }

    public static final /* synthetic */ void access$setFlushJob$p(DoubaoChatterTagEnricher r0, Job r1) {
        r0.flushJob = r1;
    }

    public DoubaoChatterTagEnricher(DoubaoLocalChatterProvider r2, CoroutineDispatcher r3, CoroutineDispatcher r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        Intrinsics.checkNotNullParameter(r3, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r4, "ioDispatcher");
        this.provider = r2;
        this.mainDispatcher = r3;
        this.ioDispatcher = r4;
        this.batchWindowMs = r5;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r3));
        this.pendingIds = new LinkedHashSet();
        this.inFlightIds = new LinkedHashSet();
        this.resolvedStates = new LinkedHashMap();
        this.unavailableIds = new LinkedHashSet();
        this.callbacks = new LinkedHashMap();
    }

    public final void request(String r2, final DoubaoPickerTagState r3, final boolean r4, final Function1<? super DoubaoLocalChatterTagState, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "currentState");
        Intrinsics.checkNotNullParameter(r5, "onResolved");
        if (this.destroyed == false) goto L5;
        return;
    L5:
        if (r2.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (DoubaoChatterTagEnricherKt.access$hasAllLocalPersonalTags(r3) == false) goto L13;
        if (r4 == false) goto L13;
        return;
    L13:
        Function1<DoubaoLocalChatterTagState, Unit> r1 = new DoubaoChatterTagEnricher$request$callback$1(r3, r4, r5);
        DoubaoLocalChatterTagState r6 = this.resolvedStates.get(r2);
        if (r6 == null) goto L18;
        r1.invoke(r6);
        return;
    L18:
        if (this.unavailableIds.contains(r2) == false) goto L20;
        return;
    L20:
        Map<String, List<Function1<DoubaoLocalChatterTagState, Unit>>> r7 = this.callbacks;
        List<Function1<DoubaoLocalChatterTagState, Unit>> r8 = r7.get(r2);
        if (r8 != null) goto L23;
        r8 = new ArrayList();
        r7.put(r2, r8);
    L23:
        r8.add(r1);
        if (this.pendingIds.contains(r2) == false) goto L26;
        return;
    L26:
        if (this.inFlightIds.contains(r2) == true) goto L34;
        this.pendingIds.add(r2);
        scheduleFlush();
        return;
    L34:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public /* synthetic */ DoubaoChatterTagEnricher(DoubaoLocalChatterProvider r7, CoroutineDispatcher r8, CoroutineDispatcher r9, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = Dispatchers.getMain().getImmediate();
    L5:
        CoroutineDispatcher r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = Dispatchers.getIO();
    L8:
        CoroutineDispatcher r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        r10 = DEFAULT_BATCH_WINDOW_MS;
    L11:
        this(r7, r2, r3, r10);
    }
}
