package com.larus.dora.impl.device.settings.gesture;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isDarkMode", "", "()Z", "loadJob", "Lkotlinx/coroutines/Job;", "_gestureStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettingsState;", "gestureStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getGestureStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_otaTooLowToastFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "otaTooLowToastFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getOtaTooLowToastFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "load", "lastSwitchSide", "Lcom/larus/dora/impl/device/settings/gesture/LastSwitchSide;", "buildGestureSettingsState", "loadedList", "", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGGestureSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "DoraGGestureSettingsViewModel";
    private final z0<r> _gestureStateFlow;
    private final MutableSharedFlow<Unit> _otaTooLowToastFlow;
    private final i1<r> gestureStateFlow;
    private final boolean isDarkMode;
    private Job loadJob;
    private final d1<Unit> otaTooLowToastFlow;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LastSwitchSide.values().length];
            r0[LastSwitchSide.BUTTON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LastSwitchSide.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LastSwitchSide.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((DoraGGestureSettings) r1).c & 255), Integer.valueOf(((DoraGGestureSettings) r2).c & 255));
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsViewModel$load$1", f = "DoraGGestureSettingsViewModel.kt", i = {}, l = {38, 49, 59}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LastSwitchSide $lastSwitchSide;
        int label;
        final /* synthetic */ DoraGGestureSettingsViewModel this$0;

        public AnonymousClass1(LastSwitchSide r1, DoraGGestureSettingsViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$lastSwitchSide = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$lastSwitchSide, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L12;
            if (r3 == 2) goto L11;
            if (r3 != 3) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14 CancellationException -> L34
        L36:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14 CancellationException -> L34
        L26:
            m r11 = (m) r10;     // Catch: Throwable -> L14 CancellationException -> L34
            DoraGGestureSettingsViewModel.access$get_gestureStateFlow$p(this.this$0).setValue(DoraGGestureSettingsViewModel.access$buildGestureSettingsState(this.this$0, this.$lastSwitchSide, r11.a));     // Catch: Throwable -> L14 CancellationException -> L34
            if (r11.b == false) goto L36;
            g49.d.d(DoraGGestureSettingsViewModel.TAG, "load: emit ota too low toast, side=" + this.$lastSwitchSide);     // Catch: Throwable -> L14 CancellationException -> L34
            MutableSharedFlow r12 = DoraGGestureSettingsViewModel.access$get_otaTooLowToastFlow$p(this.this$0);     // Catch: Throwable -> L14 CancellationException -> L34
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14 CancellationException -> L34
            this.label = 3;     // Catch: Throwable -> L14 CancellationException -> L34
            if (r12.emit(r0, this) != r2) goto L36;
            return r2;
        L12:
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14 CancellationException -> L34
        L20:
            List r13 = (List) r10;     // Catch: Throwable -> L14 CancellationException -> L34
            if ((!r13.isEmpty()) == false) goto L23;
            g49.d.d(DoraGGestureSettingsViewModel.TAG, "load: apply cached gesture settings, size=" + r13.size() + ", side=" + this.$lastSwitchSide);     // Catch: Throwable -> L14 CancellationException -> L34
            DoraGGestureSettingsViewModel.access$get_gestureStateFlow$p(this.this$0).setValue(DoraGGestureSettingsViewModel.access$buildGestureSettingsState(this.this$0, this.$lastSwitchSide, r13));     // Catch: Throwable -> L14 CancellationException -> L34
        L23:
            CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L34
            DoraGGestureSettingsViewModel$load$1$loadedList$1 r1 = new DoraGGestureSettingsViewModel$load$1$loadedList$1(null);     // Catch: Throwable -> L14 CancellationException -> L34
            this.label = 2;     // Catch: Throwable -> L14 CancellationException -> L34
            r10 = BuildersKt.withContext(r14, r1, this);     // Catch: Throwable -> L14 CancellationException -> L34
            if (r10 != r2) goto L26;
            return r2;
        L16:
            ResultKt.throwOnFailure(r10);
            CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Throwable -> L14 CancellationException -> L34
            DoraGGestureSettingsViewModel$load$1$cachedList$1 r4 = new DoraGGestureSettingsViewModel$load$1$cachedList$1(null);     // Catch: Throwable -> L14 CancellationException -> L34
            this.label = 1;     // Catch: Throwable -> L14 CancellationException -> L34
            r10 = BuildersKt.withContext(r15, r4, this);     // Catch: Throwable -> L14 CancellationException -> L34
            if (r10 != r2) goto L20;
            return r2;
        L34:
            g49.d.d(DoraGGestureSettingsViewModel.TAG, "load cancelled: lastSwitchSide=" + this.$lastSwitchSide);
        L14:
            th = move-exception;
            g49.d.b(DoraGGestureSettingsViewModel.TAG, "load failed: lastSwitchSide=" + this.$lastSwitchSide + ", message=" + th.getMessage());
            if ((DoraGGestureSettingsViewModel.access$get_gestureStateFlow$p(this.this$0).getValue() instanceof r.c) == true) goto L36;
            DoraGGestureSettingsViewModel.access$get_gestureStateFlow$p(this.this$0).setValue(r.a.a);
            goto L36
        }
    }

    static {
        Companion = new a();
    }

    public DoraGGestureSettingsViewModel() {
        boolean r0 = v19.h.a;
        this.isDarkMode = v19.h.a(null);
        StateFlowImpl r1 = j1.a(r.b.a);
        this._gestureStateFlow = r1;
        this.gestureStateFlow = kotlinx.coroutines.flow.e.b(r1);
        MutableSharedFlow<Unit> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._otaTooLowToastFlow = r2;
        this.otaTooLowToastFlow = kotlinx.coroutines.flow.e.a(r2);
    }

    public final i1<r> getGestureStateFlow() {
        return this.gestureStateFlow;
    }

    public final d1<Unit> getOtaTooLowToastFlow() {
        return this.otaTooLowToastFlow;
    }

    public final boolean isDarkMode() {
        return this.isDarkMode;
    }

    public static final /* synthetic */ z0 access$get_gestureStateFlow$p(DoraGGestureSettingsViewModel r0) {
        return r0._gestureStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_otaTooLowToastFlow$p(DoraGGestureSettingsViewModel r0) {
        return r0._otaTooLowToastFlow;
    }

    public final void load(LastSwitchSide r10) {
        Intrinsics.checkNotNullParameter(r10, "lastSwitchSide");
        g49.d.d(TAG, "load: lastSwitchSide=" + r10);
        Job r0 = this.loadJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.loadJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r10, this, null), 3, null);
    }

    private final r buildGestureSettingsState(LastSwitchSide r14, List<DoraGGestureSettings> r15) {
        g49.d.d(TAG, "buildGestureSettingsState: lastSwitchSide=" + r14 + ", totalSize=" + r15.size());
        boolean r2 = true;
        if ((!r15.isEmpty()) == false) goto L111;
        List r0 = CollectionsKt.emptyList();
        List r3 = CollectionsKt.emptyList();
        int r4 = b.a[r14.ordinal()];
        byte r5 = 16;
        if (r4 != 1) goto L7;
        ArrayList r6 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L81:
        if (r16.hasNext() == false) goto L90;
        Object r8 = r16.next();
        DoraGGestureSettings r10 = (DoraGGestureSettings) r8;
        if (r10.b == 4) goto L85;
    L87:
        boolean r9 = false;
    L88:
        if (r9 == false) goto L81;
        r6.add(r8);
        goto L81
    L85:
        if (r10.c == 1) goto L87;
        r9 = true;
        goto L88
    L90:
        List r17 = CollectionsKt.toMutableList(r6);
        List r7 = r17;
        if ((r7 instanceof Collection) == true) goto L93;
    L95:
        Iterator r11 = r7.iterator();
    L97:
        if (r11.hasNext() == false) goto L104;
        if (((DoraGGestureSettings) r11.next()).c != 2) goto L101;
        boolean r12 = true;
    L102:
        if (r12 == false) goto L97;
        r2 = false;
        goto L104
    L101:
        r12 = false;
    L104:
        if (r2 == false) goto L109;
        DoraGGestureSettings r13 = (DoraGGestureSettings) CollectionsKt.firstOrNull(r17);
        if (r13 == null) goto L108;
        r5 = r13.a;
    L108:
        r17.add(new DoraGGestureSettings(r5, (byte) 4, (byte) 2, (byte) 0));
    L109:
        List r18 = CollectionsKt.sortedWith(r7, new c());
    L110:
        g49.d.d(TAG, "buildGestureSettingsState: side=" + r14 + ", mediaCount=" + r0.size() + ", callingCount=" + r3.size() + ", aiCount=" + r18.size());
        return new r.c(r14, r0, r3, r18);
    L93:
        if (r7.isEmpty() == false) goto L95;
    L7:
        if (r4 != 2) goto L9;
        List<DoraGGestureSettings> r110 = r15;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r110.iterator();
    L47:
        if (r21.hasNext() == false) goto L56;
        Object r22 = r21.next();
        DoraGGestureSettings r23 = (DoraGGestureSettings) r22;
        if (r23.b == 6) goto L51;
    L53:
        boolean r24 = false;
    L54:
        if (r24 == false) goto L47;
        r20.add(r22);
        goto L47
    L51:
        if (r23.a != 16) goto L53;
        r24 = true;
        goto L54
    L56:
        ArrayList r1 = new ArrayList();
        Iterator<T> r25 = r110.iterator();
    L58:
        if (r25.hasNext() == false) goto L67;
        Object r26 = r25.next();
        DoraGGestureSettings r27 = (DoraGGestureSettings) r26;
        if (r27.b == 1) goto L62;
    L64:
        boolean r28 = false;
    L65:
        if (r28 == false) goto L58;
        r1.add(r26);
        goto L58
    L62:
        if (r27.a != 16) goto L64;
        r28 = true;
        goto L65
    L67:
        r18 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L69:
        if (r111.hasNext() == false) goto L78;
        Object r30 = r111.next();
        DoraGGestureSettings r31 = (DoraGGestureSettings) r30;
        if (r31.b == 2) goto L73;
    L75:
        boolean r32 = false;
    L76:
        if (r32 == false) goto L69;
        r18.add(r30);
        goto L69
    L73:
        if (r31.a != 16) goto L75;
        r32 = true;
    L78:
        ArrayList r112 = r20;
        r3 = r1;
        r0 = r112;
        goto L110
    L9:
        if (r4 != 3) goto L44;
        List<DoraGGestureSettings> r113 = r15;
        r20 = new ArrayList();
        Iterator<T> r33 = r113.iterator();
    L12:
        if (r33.hasNext() == false) goto L21;
        Object r34 = r33.next();
        DoraGGestureSettings r35 = (DoraGGestureSettings) r34;
        if (r35.b == 6) goto L16;
    L18:
        boolean r36 = false;
    L19:
        if (r36 == false) goto L12;
        r20.add(r34);
        goto L12
    L16:
        if (r35.a != 0) goto L18;
        r36 = true;
        goto L19
    L21:
        r1 = new ArrayList();
        Iterator<T> r37 = r113.iterator();
    L23:
        if (r37.hasNext() == false) goto L32;
        Object r38 = r37.next();
        DoraGGestureSettings r40 = (DoraGGestureSettings) r38;
        if (r40.b == 1) goto L27;
    L29:
        boolean r41 = false;
    L30:
        if (r41 == false) goto L23;
        r1.add(r38);
        goto L23
    L27:
        if (r40.a != 0) goto L29;
        r41 = true;
        goto L30
    L32:
        r18 = new ArrayList();
        Iterator<T> r114 = r113.iterator();
    L34:
        if (r114.hasNext() == false) goto L78;
        Object r42 = r114.next();
        DoraGGestureSettings r43 = (DoraGGestureSettings) r42;
        if (r43.b == 2) goto L38;
    L40:
        boolean r44 = false;
    L41:
        if (r44 == false) goto L34;
        r18.add(r42);
        goto L34
    L38:
        if (r43.a != 0) goto L40;
        r44 = true;
        goto L41
    L44:
        throw new NoWhenBranchMatchedException();
    L111:
        g49.d.b(TAG, "buildGestureSettingsState: loadedList is empty");
        return r.a.a;
    }

    public static final /* synthetic */ r access$buildGestureSettingsState(DoraGGestureSettingsViewModel r0, LastSwitchSide r1, List r2) {
        return r0.buildGestureSettingsState(r1, r2);
    }
}
