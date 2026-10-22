package com.larus.dora.impl.device.settings.gesture.options;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsTracker;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u001aJ\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u001aJ\u0014\u0010)\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010+\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0007J\u001c\u0010,\u001a\u00020-2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J4\u00100\u001a\u00020\"2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00068"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_gestureOptionsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "gestureOptionsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getGestureOptionsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_selectedGestureStateFlow", "Lcom/larus/dora/impl/device/settings/gesture/options/SelectedGestureState;", "selectedGestureStateFlow", "getSelectedGestureStateFlow", "_gestureOptionActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/gesture/options/GestureOptionAction;", "gestureOptionActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getGestureOptionActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "updateJob", "Lkotlinx/coroutines/Job;", "isDarkMode", "", "()Z", "currentGesture", "getCurrentGesture", "()Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "setCurrentGesture", "(Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;)V", "initData", "", "data", "isG1", "onGestureOptionSelected", "gesture", "isHeadphoneModeActive", "isSupportGlassesModeControl", "applyQuickControlGuide", "settings", "updateGestureFunction", "syncBatchGestureSettingsWithRetry", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadGestureSettingsSysInfo", "traceGestureUpdates", "previousSettings", "currentSettings", "errorCode", "duration", "", "buildCurrentGestureSnapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOptionsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long DEBOUNCE_TIME_MS = 300;
    private static final long MULTI_SETTINGS_SETTLE_DELAY_MS = 300;
    private static final String TAG = "DoraGOptionsViewModel";
    private static final long TIMEOUT_MS = 3000;
    private final MutableSharedFlow<m> _gestureOptionActionSharedFlow;
    private final z0<List<DoraGGestureSettings>> _gestureOptionsStateFlow;
    private final z0<q> _selectedGestureStateFlow;
    private DoraGGestureSettings currentGesture;
    private final d1<m> gestureOptionActionSharedFlow;
    private final i1<List<DoraGGestureSettings>> gestureOptionsStateFlow;
    private final boolean isDarkMode;
    private final i1<q> selectedGestureStateFlow;
    private Job updateJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$applyQuickControlGuide$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$applyQuickControlGuide$1", f = "DoraGOptionsViewModel.kt", i = {0, 0}, l = {218, 233, 243, 244}, m = "invokeSuspend", n = {"previousSettings", "updateOperationStartTime"}, s = {"L$0", "J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DoraGGestureSettings> $settings;
        long J$0;
        Object L$0;
        int label;
        final /* synthetic */ DoraGOptionsViewModel this$0;

        public AnonymousClass1(DoraGOptionsViewModel r1, List<DoraGGestureSettings> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$settings = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$settings, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L18;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 != 4) goto L10;
            ResultKt.throwOnFailure(r20);
        L42:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r20);
        L38:
            MutableSharedFlow r1 = DoraGOptionsViewModel.access$get_gestureOptionActionSharedFlow$p(this.this$0);
            m.a r3 = m.a.a;
            this.label = 4;
            if (r1.emit(r3, this) != r2) goto L42;
            return r2;
        L12:
            ResultKt.throwOnFailure(r20);
        L34:
            return Unit.INSTANCE;
        L13:
            long r7 = this.J$0;
            List r9 = (List) this.L$0;
            ResultKt.throwOnFailure(r20);     // Catch: Exception -> L16 CancellationException -> L43
            Object r4 = r20;
        L23:
            int r5 = ((Number) r4).intValue();     // Catch: Exception -> L16 CancellationException -> L43
            List r12 = r9;
        L28:
            long r10 = System.currentTimeMillis() - r7;
            DoraGOptionsViewModel.access$traceGestureUpdates(this.this$0, r12, this.$settings, r5, r10);
            g49.d.d(DoraGOptionsViewModel.TAG, "applyQuickControlGuide: settings=" + this.$settings + ", ret=" + r5 + ", duration=" + r10);
            if (r5 == 0) goto L35;
            MutableSharedFlow r6 = DoraGOptionsViewModel.access$get_gestureOptionActionSharedFlow$p(this.this$0);
            m.b r8 = new m.b();
            this.L$0 = null;
            this.label = 2;
            if (r6.emit(r8, this) != r2) goto L34;
            return r2;
        L35:
            DoraGGestureSettingsRepository.a.i(this.$settings);
            DoraGOptionsViewModel.access$uploadGestureSettingsSysInfo(this.this$0, this.$settings);
            this.L$0 = null;
            this.label = 3;
            if (DelayKt.delay(300, this) != r2) goto L38;
            return r2;
        L16:
            e = e;
            List r11 = r9;
            long r13 = r7;
        L27:
            g49.d.c(DoraGOptionsViewModel.TAG, "applyQuickControlGuide exception", e);
            r5 = -1;
            r12 = r11;
            r7 = r13;
            goto L28
        L18:
            ResultKt.throwOnFailure(r20);
            r11 = DoraGOptionsViewModel.access$buildCurrentGestureSnapshot(this.this$0, this.$settings);
            r13 = System.currentTimeMillis();
            DoraGOptionsViewModel r14 = this.this$0;     // Catch: Exception -> L26 CancellationException -> L43
            List<DoraGGestureSettings> r15 = this.$settings;     // Catch: Exception -> L26 CancellationException -> L43
            this.L$0 = r11;     // Catch: Exception -> L26 CancellationException -> L43
            this.J$0 = r13;     // Catch: Exception -> L26 CancellationException -> L43
            this.label = 1;     // Catch: Exception -> L26 CancellationException -> L43
            r4 = DoraGOptionsViewModel.access$syncBatchGestureSettingsWithRetry(r14, r15, this);     // Catch: Exception -> L26 CancellationException -> L43
            if (r4 != r2) goto L22;
            return r2;
        L22:
            r9 = r11;
            r7 = r13;
        L26:
            e = e;
        L43:
            e = move-exception;
            throw e;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$initData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$initData$1", f = "DoraGOptionsViewModel.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
    public static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraGGestureSettings $data;
        final /* synthetic */ boolean $isG1;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraGOptionsViewModel this$0;

        public C02581(DoraGGestureSettings r1, DoraGOptionsViewModel r2, boolean r3, Continuation<? super C02581> r4) {
            this.$data = r1;
            this.this$0 = r2;
            this.$isG1 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02581(this.$data, this.this$0, this.$isG1, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List] */
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            boolean r3 = this.Z$0;
            DoraGGestureSettings r4 = (DoraGGestureSettings) this.L$1;
            DoraGOptionsViewModel r5 = (DoraGOptionsViewModel) this.L$0;
            ResultKt.throwOnFailure(r18);
        L15:
            if (r4.b == 2) goto L17;
        L25:
            byte r6 = r4.b;
            if (r6 != 6) goto L45;
            z0 r7 = DoraGOptionsViewModel.access$get_gestureOptionsStateFlow$p(r5);
            byte r8 = r4.c;
            if (r8 != 1) goto L31;
            List r9 = CollectionsKt.listOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 16, 7)});
        L44:
            r7.setValue(r9);
        L74:
            return Unit.INSTANCE;
        L31:
            if (r8 != 2) goto L36;
            List r10 = CollectionsKt.mutableListOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 16, 7), DoraGGestureSettings.a(r4, (byte) 19, 7), DoraGGestureSettings.a(r4, (byte) 20, 7), DoraGGestureSettings.a(r4, (byte) 34, 7)});
            sk4.e r11 = o0.a;
            if (o0.c("handset_mode") == false) goto L35;
            r10.add(DoraGGestureSettings.a(r4, (byte) 40, 7));
        L35:
            r10.add(DoraGGestureSettings.a(r4, (byte) 33, 7));
            r9 = CollectionsKt.toList(r10);
            goto L44
        L36:
            if (r8 != 3) goto L41;
            List r12 = CollectionsKt.mutableListOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 16, 7), DoraGGestureSettings.a(r4, (byte) 19, 7), DoraGGestureSettings.a(r4, (byte) 20, 7), DoraGGestureSettings.a(r4, (byte) 34, 7)});
            sk4.e r13 = o0.a;
            if (o0.c("handset_mode") == false) goto L40;
            r12.add(DoraGGestureSettings.a(r4, (byte) 40, 7));
        L40:
            r12.add(DoraGGestureSettings.a(r4, (byte) 33, 7));
            r9 = CollectionsKt.toList(r12);
            goto L44
        L41:
            if (r8 != 16) goto L43;
            r9 = CollectionsKt.listOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 6, 7)});
            goto L44
        L43:
            r9 = CollectionsKt.emptyList();
            goto L44
        L45:
            if (r6 != 1) goto L51;
            z0 r14 = DoraGOptionsViewModel.access$get_gestureOptionsStateFlow$p(r5);
            if (r4.c != 2) goto L49;
            List r15 = CollectionsKt.listOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 1, 7), DoraGGestureSettings.a(r4, (byte) 2, 7), DoraGGestureSettings.a(r4, (byte) 3, 7)});
        L50:
            r14.setValue(r15);
            goto L74
        L49:
            r15 = CollectionsKt.emptyList();
            goto L50
        L51:
            if (r6 != 2) goto L64;
            z0 r16 = DoraGOptionsViewModel.access$get_gestureOptionsStateFlow$p(r5);
            if (r4.c != 6) goto L62;
            int r17 = com.larus.dora.impl.device.settings.gesture.options.a.a;
            byte r20 = r4.a;
            List r21 = CollectionsKt.createListBuilder();
            r21.add((byte) 0);
            if (r3 == true) goto L58;
            if (r20 != 0) goto L58;
            r21.add((byte) 32);
        L58:
            r21.add((byte) 35);
            r21.add((byte) 38);
            List r22 = CollectionsKt.build(r21);
            Object r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
            Iterator r24 = r22.iterator();
        L60:
            if (r24.hasNext() == false) goto L63;
            r23.add(DoraGGestureSettings.a(r4, ((Number) r24.next()).byteValue(), 7));
        L63:
            r16.setValue(r23);
            goto L74
        L62:
            r23 = CollectionsKt.emptyList();
            goto L63
        L64:
            if (r6 != 4) goto L74;
            z0 r25 = DoraGOptionsViewModel.access$get_gestureOptionsStateFlow$p(r5);
            byte r26 = r4.c;
            if (r26 != 2) goto L69;
            List r27 = CollectionsKt.listOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 37, 7)});
        L72:
            r25.setValue(r27);
            goto L74
        L69:
            if (r26 != 6) goto L71;
            r27 = CollectionsKt.listOf(new DoraGGestureSettings[]{DoraGGestureSettings.a(r4, (byte) 0, 7), DoraGGestureSettings.a(r4, (byte) 39, 7), DoraGGestureSettings.a(r4, (byte) 33, 7)});
            goto L72
        L71:
            r27 = CollectionsKt.emptyList();
            goto L72
        L17:
            if (r4.a != 16) goto L19;
            boolean r28 = true;
        L21:
            if (r4.d != 40) goto L23;
            boolean r110 = true;
        L24:
            DoraGGestureSettingsRepository r111 = DoraGGestureSettingsRepository.a;
            DoraGGestureSettingsRepository.m(r28, r110);
            goto L25
        L23:
            r110 = false;
            goto L24
        L19:
            r28 = false;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            g49.d.d(DoraGOptionsViewModel.TAG, "initData: data = " + this.$data);
            r4 = this.$data;
            if (r4 == null) goto L74;
            r5 = this.this$0;
            boolean r30 = this.$isG1;
            r5.setCurrentGesture(r4);
            z0 r31 = DoraGOptionsViewModel.access$get_selectedGestureStateFlow$p(r5);
            q.b r32 = new q.b(r4);
            this.L$0 = r5;
            this.L$1 = r4;
            this.Z$0 = r30;
            this.label = 1;
            if (r31.emit(r32, this) != r1) goto L13;
            return r1;
        L13:
            r3 = r30;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel", f = "DoraGOptionsViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {401, 436}, m = "syncBatchGestureSettingsWithRetry", n = {"settings", "maxRetries", "retryCount", "settings", "maxRetries", "retryCount"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    public static final class C02591 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGOptionsViewModel this$0;

        public C02591(DoraGOptionsViewModel r1, Continuation<? super C02591> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraGOptionsViewModel.access$syncBatchGestureSettingsWithRetry(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$1", f = "DoraGOptionsViewModel.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraGGestureSettings $gesture;
        int label;
        final /* synthetic */ DoraGOptionsViewModel this$0;

        public C02601(DoraGOptionsViewModel r1, DoraGGestureSettings r2, Continuation<? super C02601> r3) {
            this.this$0 = r1;
            this.$gesture = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02601(this.this$0, this.$gesture, r4);
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
            z0 r6 = DoraGOptionsViewModel.access$get_selectedGestureStateFlow$p(this.this$0);
            q.b r2 = new q.b(this.$gesture);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$2", f = "DoraGOptionsViewModel.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {265, 278, 318, 368}, m = "invokeSuspend", n = {"$this$launch", "updateOperationStartTime", "maxRetries", "retryCount", "updateOperationStartTime", "maxRetries", "retryCount"}, s = {"L$0", "J$0", "I$0", "I$1", "J$0", "I$0", "I$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraGGestureSettings $gesture;
        final /* synthetic */ DoraGGestureSettings $original;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraGOptionsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$updateGestureFunction$2$2", f = "DoraGOptionsViewModel.kt", i = {}, l = {378, 379}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DoraGGestureSettings $original;
            int label;
            final /* synthetic */ DoraGOptionsViewModel this$0;

            public C00422(DoraGOptionsViewModel r1, DoraGGestureSettings r2, Continuation<? super C00422> r3) {
                this.this$0 = r1;
                this.$original = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00422(this.this$0, this.$original, r4);
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
                ResultKt.throwOnFailure(r6);
            L13:
                MutableSharedFlow r7 = DoraGOptionsViewModel.access$get_gestureOptionActionSharedFlow$p(this.this$0);
                m.b r2 = new m.b();
                this.label = 2;
                if (r7.emit(r2, this) != r0) goto L17;
                return r0;
            L10:
                ResultKt.throwOnFailure(r6);
                z0 r8 = DoraGOptionsViewModel.access$get_selectedGestureStateFlow$p(this.this$0);
                q.b r3 = new q.b(this.$original);
                this.label = 1;
                if (r8.emit(r3, this) != r0) goto L13;
                return r0;
            }
        }

        public AnonymousClass2(DoraGGestureSettings r1, DoraGGestureSettings r2, DoraGOptionsViewModel r3, Continuation<? super AnonymousClass2> r4) {
            this.$original = r1;
            this.$gesture = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$original, this.$gesture, this.this$0, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0259 -> B:98:0x0261). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r27) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            Continuation r3 = null;
            int r7 = 4;
            if (r2 == 0) goto L20;
            if (r2 == 1) goto L19;
            if (r2 == 2) goto L15;
            if (r2 == 3) goto L12;
            if (r2 != 4) goto L11;
            ResultKt.throwOnFailure(r27);     // Catch: Exception -> L54 CancellationException -> L56
        L101:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            int r4 = this.I$1;
            int r12 = this.I$0;
            long r13 = this.J$0;
            ResultKt.throwOnFailure(r27);     // Catch: Exception -> L54 CancellationException -> L56
            int r5 = r12;
            long r14 = r13;
            AnonymousClass2 r15 = this;
        L98:
            int r16 = r5;
            r3 = null;
            r7 = 4;
        L28:
            DoraGOptionsViewModel$updateGestureFunction$2$result$1 r6 = new DoraGOptionsViewModel$updateGestureFunction$2$result$1(r15.$gesture, r3);     // Catch: Exception -> L54 CancellationException -> L56
            r15.L$0 = r3;     // Catch: Exception -> L54 CancellationException -> L56
            r15.J$0 = r14;     // Catch: Exception -> L54 CancellationException -> L56
            r15.I$0 = r16;     // Catch: Exception -> L54 CancellationException -> L56
            r15.I$1 = r4;     // Catch: Exception -> L54 CancellationException -> L56
            r15.label = 2;     // Catch: Exception -> L54 CancellationException -> L56
            Object r8 = TimeoutKt.c(DoraGOptionsViewModel.TIMEOUT_MS, r6, r15);     // Catch: Exception -> L54 CancellationException -> L56
            if (r8 != r0) goto L31;
            return r0;
        L31:
            AnonymousClass2 r9 = r15;
            long r17 = r14;
            int r18 = r16;
        L18:
            int r25 = r4;
            Object r10 = r0;
            Integer r11 = (Integer) r8;     // Catch: Exception -> L54 CancellationException -> L56
            if (r11 == null) goto L35;
            int r20 = r11.intValue();     // Catch: Exception -> L54 CancellationException -> L56
        L36:
            if (r20 != 0) goto L38;
            g49.d.d(DoraGOptionsViewModel.TAG, "updateGestureFunction: success on attempt " + r25);     // Catch: Exception -> L54 CancellationException -> L56
        L41:
            long r110 = System.currentTimeMillis();     // Catch: Exception -> L54 CancellationException -> L56
            g49.d.d(DoraGOptionsViewModel.TAG, "setDoraGGestureSettings ret: " + r20);     // Catch: Exception -> L54 CancellationException -> L56
            GestureSettingsTracker r1 = GestureSettingsTracker.a;     // Catch: Exception -> L54 CancellationException -> L56
            DoraGGestureSettings r21 = r9.$original;     // Catch: Exception -> L54 CancellationException -> L56
            DoraGGestureSettings r22 = r9.$gesture;     // Catch: Exception -> L54 CancellationException -> L56
            if (r20 != 0) goto L44;
            boolean r23 = true;
        L45:
            GestureSettingsTracker.d(r21, r22, r20, r23, r110 - r17);     // Catch: Exception -> L54 CancellationException -> L56
            if (r20 != 0) goto L87;
            g49.d.d(DoraGOptionsViewModel.TAG, "updateGestureFunction success: " + r9.$gesture);     // Catch: Exception -> L54 CancellationException -> L56
            DoraGGestureSettingsRepository.a.i(CollectionsKt.listOf(r9.$gesture));     // Catch: Exception -> L54 CancellationException -> L56
            DoraGGestureSettings r24 = r9.$gesture;     // Catch: Exception -> L54 CancellationException -> L56
            if (r24.b == 2) goto L50;
        L58:
            DoraGGestureSettings r26 = r9.this$0.getCurrentGesture();     // Catch: Exception -> L54 CancellationException -> L56
            if (r26 != null) goto L61;
        L63:
            boolean r28 = false;
        L64:
            if (r28 == false) goto L103;
            DoraGGestureSettings r30 = r9.this$0.getCurrentGesture();     // Catch: Exception -> L54 CancellationException -> L56
            if (r30 != null) goto L68;
        L70:
            boolean r31 = false;
        L71:
            DoraGGestureSettings r32 = r9.this$0.getCurrentGesture();     // Catch: Exception -> L54 CancellationException -> L56
            if (r32 != null) goto L74;
        L76:
            boolean r33 = false;
        L77:
            DoraGGestureSettingsRepository.m(r31, r33);     // Catch: Exception -> L54 CancellationException -> L56
            goto L103
        L74:
            if (r32.d != 40) goto L76;
            r33 = true;
            goto L77
        L68:
            if (r30.a != 16) goto L70;
            r31 = true;
        L103:
            ArrayList r34 = new ArrayList();     // Catch: Exception -> L80
            r34.add(new Pair(com.larus.dora.impl.device.settings.gesture.a.b(r9.$gesture), com.larus.dora.impl.device.settings.gesture.a.a(r9.$gesture)));     // Catch: Exception -> L80
            g49.d.d(DoraGOptionsViewModel.TAG, "Uploading gesture setting to server: " + r34);     // Catch: Exception -> L80
            DoraSystemInfoManager r35 = DoraSystemInfoManager.a;     // Catch: Exception -> L80
            DoraSystemInfoManager.f(r34);     // Catch: Exception -> L80
        L82:
            int r36 = l.a;     // Catch: Exception -> L54 CancellationException -> L56
            p r37 = l.a(r9.$gesture, DoraGGestureSettingsRepository.a.e());     // Catch: Exception -> L54 CancellationException -> L56
            if (r37 == null) goto L101;
            MutableSharedFlow r38 = DoraGOptionsViewModel.access$get_gestureOptionActionSharedFlow$p(r9.this$0);     // Catch: Exception -> L54 CancellationException -> L56
            m.c r40 = new m.c(r37);     // Catch: Exception -> L54 CancellationException -> L56
            r9.label = r7;     // Catch: Exception -> L54 CancellationException -> L56
            if (r38.emit(r40, r9) != r10) goto L101;
            return r10;
        L80:
            e = move-exception;
            g49.d.c(DoraGOptionsViewModel.TAG, "Failed to upload gesture settings after update", e);     // Catch: Exception -> L54 CancellationException -> L56
            goto L82
        L61:
            if (r26.b != 2) goto L63;
            r28 = true;
            goto L64
        L50:
            if (r24.c != 6) goto L58;
            if (r24.d != 34) goto L58;
            kj4.a.g().c.getClass();     // Catch: Exception -> L54 CancellationException -> L56
            pk4.i.a.a.a.storeInt("simul_interpret_double_click_gesture_set", 1);     // Catch: Exception -> L54 CancellationException -> L56
            goto L58
        L87:
            g49.d.b(DoraGOptionsViewModel.TAG, "updateGestureFunction failed: gesture = " + r9.$gesture + ", ret: " + r20);     // Catch: Exception -> L54 CancellationException -> L56
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r9.this$0), Dispatchers.getMain(), null, new C00422(r9.this$0, r9.$original, r3), 2, null);     // Catch: Exception -> L54 CancellationException -> L56
            r9.this$0.setCurrentGesture(r9.$original);     // Catch: Exception -> L54 CancellationException -> L56
            goto L101
        L44:
            r23 = false;
            goto L45
        L38:
            int r41 = r25 + 1;     // Catch: Exception -> L54 CancellationException -> L56
            if (r41 < r18) goto L88;
            g49.d.d(DoraGOptionsViewModel.TAG, "updateGestureFunction: max retries reached");     // Catch: Exception -> L54 CancellationException -> L56
            goto L41
        L88:
            if (r41 == 1) goto L93;
            if (r41 == 2) goto L91;
            long r111 = 800;
        L92:
            long r42 = r111;
        L94:
            g49.d.d(DoraGOptionsViewModel.TAG, "updateGestureFunction: retry " + r41 + ", delaying for " + r42 + " ms, error code: " + r20);     // Catch: Exception -> L54 CancellationException -> L56
            r9.J$0 = r17;     // Catch: Exception -> L54 CancellationException -> L56
            r9.I$0 = r18;     // Catch: Exception -> L54 CancellationException -> L56
            r9.I$1 = r41;     // Catch: Exception -> L54 CancellationException -> L56
            r9.label = 3;     // Catch: Exception -> L54 CancellationException -> L56
            if (DelayKt.delay(r42, r9) != r10) goto L97;
            return r10;
        L97:
            r5 = r18;
            r14 = r17;
            r15 = r9;
            r4 = r41;
            r0 = r10;
            goto L98
        L91:
            r111 = 500;
            goto L92
        L93:
            r42 = 300;
            goto L94
        L35:
            r20 = -3;
            goto L36
        L15:
            r4 = this.I$1;
            r18 = this.I$0;
            r17 = this.J$0;
            ResultKt.throwOnFailure(r27);     // Catch: Exception -> L54 CancellationException -> L56
            r8 = r27;
            r9 = this;
            goto L18
        L19:
            CoroutineScope r43 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r27);
        L24:
            if (CoroutineScopeKt.isActive(r43) == true) goto L27;
            g49.d.d(DoraGOptionsViewModel.TAG, "updateGestureFunction: job cancelled");
            return Unit.INSTANCE;
        L27:
            r14 = System.currentTimeMillis();
            r15 = this;
            r4 = 0;
            r16 = 3;
            goto L28
        L20:
            ResultKt.throwOnFailure(r27);
            r43 = (CoroutineScope) this.L$0;
            this.L$0 = r43;
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L24;
            return r0;
        L56:
            e = move-exception;
            throw e;
        L54:
            e = move-exception;
            g49.d.c(DoraGOptionsViewModel.TAG, "updateGestureFunction exception: " + e, e);
            goto L101
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isHeadphoneModeActive() {
        t69.b r0 = t69.b.a;
        if (t69.b.c == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public DoraGOptionsViewModel() {
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._gestureOptionsStateFlow = r0;
        this.gestureOptionsStateFlow = kotlinx.coroutines.flow.e.b(r0);
        StateFlowImpl r1 = j1.a(q.a.a);
        this._selectedGestureStateFlow = r1;
        this.selectedGestureStateFlow = kotlinx.coroutines.flow.e.b(r1);
        MutableSharedFlow<m> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._gestureOptionActionSharedFlow = r2;
        this.gestureOptionActionSharedFlow = kotlinx.coroutines.flow.e.a(r2);
        boolean r3 = v19.h.a;
        this.isDarkMode = v19.h.a(null);
    }

    public final boolean isSupportGlassesModeControl() {
        DoraDevice r0 = kj4.a.g().c();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isSupportGlassesModeControl() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final DoraGGestureSettings getCurrentGesture() {
        return this.currentGesture;
    }

    public final d1<m> getGestureOptionActionSharedFlow() {
        return this.gestureOptionActionSharedFlow;
    }

    public final i1<List<DoraGGestureSettings>> getGestureOptionsStateFlow() {
        return this.gestureOptionsStateFlow;
    }

    public final i1<q> getSelectedGestureStateFlow() {
        return this.selectedGestureStateFlow;
    }

    public final boolean isDarkMode() {
        return this.isDarkMode;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_gestureOptionActionSharedFlow$p(DoraGOptionsViewModel r0) {
        return r0._gestureOptionActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_gestureOptionsStateFlow$p(DoraGOptionsViewModel r0) {
        return r0._gestureOptionsStateFlow;
    }

    public static final /* synthetic */ z0 access$get_selectedGestureStateFlow$p(DoraGOptionsViewModel r0) {
        return r0._selectedGestureStateFlow;
    }

    private final List<DoraGGestureSettings> buildCurrentGestureSnapshot(List<DoraGGestureSettings> r9) {
        List<DoraGGestureSettings> r0 = DoraGGestureSettingsRepository.a.e();
        List<DoraGGestureSettings> r10 = r9;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L24;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r11.next();
        Iterator<T> r3 = r0.iterator();
    L7:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        DoraGGestureSettings r5 = (DoraGGestureSettings) r4;
        if (r5.a == r2.a) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L7;
    L19:
        DoraGGestureSettings r7 = (DoraGGestureSettings) r4;
        if (r7 == null) goto L23;
        r2 = r7;
    L23:
        r1.add(r2);
        goto L4
    L11:
        if (r5.b != r2.b) goto L15;
        if (r5.c != r2.c) goto L15;
        r6 = true;
        goto L16
    L18:
        r4 = null;
        goto L19
    L24:
        return r1;
    }

    private final void uploadGestureSettingsSysInfo(List<DoraGGestureSettings> r6) {
        List<DoraGGestureSettings> r7 = r6;     // Catch: Exception -> L9
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Exception -> L9
        Iterator<T> r8 = r7.iterator();     // Catch: Exception -> L9
    L5:
        if (r8.hasNext() == false) goto L7;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r8.next();     // Catch: Exception -> L9
        r1.add(new Pair(com.larus.dora.impl.device.settings.gesture.a.b(r2), com.larus.dora.impl.device.settings.gesture.a.a(r2)));     // Catch: Exception -> L9
        goto L5
    L7:
        g49.d.d(TAG, "uploadGestureSettingsSysInfo: sysInfoList=" + r1);     // Catch: Exception -> L9
        DoraSystemInfoManager r9 = DoraSystemInfoManager.a;     // Catch: Exception -> L9
        DoraSystemInfoManager.f(r1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        g49.d.c(TAG, "uploadGestureSettingsSysInfo failed", e);
    }

    public final void applyQuickControlGuide(List<DoraGGestureSettings> r10) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        Job r0 = this.updateJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.updateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r10, null), 2, null);
    }

    public final void onGestureOptionSelected(DoraGGestureSettings r4) {
        Intrinsics.checkNotNullParameter(r4, "gesture");
        Object r0 = this._selectedGestureStateFlow.getValue();
        DoraGGestureSettings r2 = null;
        if ((r0 instanceof q.b) == false) goto L5;
        q.b r1 = (q.b) r0;
    L6:
        if (r1 == null) goto L8;
        r2 = r1.a;
    L8:
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        if (r3 == false) goto L16;
        g49.d.d(TAG, "onGestureOptionSelected: ignore duplicated selection, gesture=" + r4);
        return;
    L16:
        updateGestureFunction(r4);
        return;
    L11:
        if (r2.d != r4.d) goto L13;
        r3 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void setCurrentGesture(DoraGGestureSettings r1) {
        this.currentGesture = r1;
    }

    public final void updateGestureFunction(DoraGGestureSettings r15) {
        Intrinsics.checkNotNullParameter(r15, "gesture");
        g49.d.d(TAG, "updateGestureFunction: " + r15);
        if ((this._selectedGestureStateFlow.getValue() instanceof q.b) == false) goto L9;
        Object r0 = this._selectedGestureStateFlow.getValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.gesture.options.SelectedGestureState.Success");
        DoraGGestureSettings r1 = ((q.b) r0).a;
        this.currentGesture = r15;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C02601(this, r15, null), 2, null);
        Job r2 = this.updateJob;
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        this.updateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(r1, r15, this, null), 2, null);
        return;
    }

    public static final /* synthetic */ List access$buildCurrentGestureSnapshot(DoraGOptionsViewModel r0, List r1) {
        return r0.buildCurrentGestureSnapshot(r1);
    }

    public static final /* synthetic */ void access$uploadGestureSettingsSysInfo(DoraGOptionsViewModel r0, List r1) {
        r0.uploadGestureSettingsSysInfo(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d6 -> B:13:0x0033). Please report as a decompilation issue!!! */
    private final Object syncBatchGestureSettingsWithRetry(List<DoraGGestureSettings> r13, Continuation<? super Integer> r14) {
        if ((r14 instanceof C02591) == false) goto L7;
        C02591 r0 = (C02591) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        int r16 = r0.I$1;
        int r4 = r0.I$0;
        List<DoraGGestureSettings> r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L13:
        int r17 = r4;
        int r6 = r16;
        r13 = r5;
    L18:
        DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1 r7 = new DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1(r13, null);
        r0.L$0 = r13;
        r0.I$0 = r17;
        r0.I$1 = r6;
        r0.label = 1;
        Object r8 = TimeoutKt.c(TIMEOUT_MS, r7, r0);
        if (r8 != r2) goto L21;
        return r2;
    L21:
        r5 = r13;
        int r18 = r6;
        r4 = r17;
        r15 = r8;
    L22:
        Integer r110 = (Integer) r15;
        if (r110 == null) goto L25;
        int r111 = r110.intValue();
    L27:
        if (r111 != 0) goto L29;
        g49.d.d(TAG, "syncBatchGestureSettingsWithRetry: success on attempt " + r18);
    L33:
        return Boxing.boxInt(r111);
    L29:
        r16 = r18 + 1;
        if (r16 < r4) goto L34;
        g49.d.d(TAG, "syncBatchGestureSettingsWithRetry: max retries reached");
        goto L33
    L34:
        if (r16 == 1) goto L38;
        if (r16 == 2) goto L37;
        long r9 = 800;
    L39:
        g49.d.d(TAG, "syncBatchGestureSettingsWithRetry: retry " + r16 + ", delaying for " + r9 + " ms, error code: " + r111);
        r0.L$0 = r5;
        r0.I$0 = r4;
        r0.I$1 = r16;
        r0.label = 2;
        if (DelayKt.delay(r9, r0) != r2) goto L13;
        return r2;
    L37:
        r9 = 500;
        goto L39
    L38:
        r9 = 300;
        goto L39
    L25:
        r111 = -3;
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r18 = r0.I$1;
        r4 = r0.I$0;
        r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r15);
        goto L22
    L17:
        ResultKt.throwOnFailure(r15);
        r17 = 3;
        r6 = 0;
    L7:
        r0 = new C02591(this, r14);
        goto L8
    }

    public final void initData(DoraGGestureSettings r7, boolean r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02581(r7, this, r8, null), 2, null);
    }

    public static final /* synthetic */ Object access$syncBatchGestureSettingsWithRetry(DoraGOptionsViewModel r0, List r1, Continuation r2) {
        return r0.syncBatchGestureSettingsWithRetry(r1, r2);
    }

    private final void traceGestureUpdates(List<DoraGGestureSettings> r9, List<DoraGGestureSettings> r10, int r11, long r12) {
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L31;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r13.next();
        Iterator<T> r0 = r9.iterator();
    L6:
        boolean r4 = false;
        if (r0.hasNext() == false) goto L18;
        Object r1 = r0.next();
        DoraGGestureSettings r5 = (DoraGGestureSettings) r1;
        if (r5.a == r2.a) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L6;
    L19:
        DoraGGestureSettings r3 = (DoraGGestureSettings) r1;
        if (r3 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == true) goto L4;
        GestureSettingsTracker r8 = GestureSettingsTracker.a;
        if (r11 != 0) goto L30;
        r4 = true;
    L30:
        GestureSettingsTracker.d(r3, r2, r11, r4, r12);
        goto L4
    L22:
        if (r3.d != r2.d) goto L24;
        r7 = true;
        goto L25
    L11:
        if (r5.b != r2.b) goto L15;
        if (r5.c != r2.c) goto L15;
        r6 = true;
        goto L16
    L18:
        r1 = null;
        goto L19
    }

    public static final /* synthetic */ void access$traceGestureUpdates(DoraGOptionsViewModel r0, List r1, List r2, int r3, long r4) {
        r0.traceGestureUpdates(r1, r2, r3, r4);
    }
}
