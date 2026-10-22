package com.larus.dora.impl.device.settings.lab.headcontrol.practice;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.dora.impl.util.t0;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0002\u0011\u0014\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\f\u0010\"\u001a\u00020!*\u00020\u0006H\u0002J\f\u0010#\u001a\u00020\u001e*\u00020!H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020!H\u0002J\u0006\u0010&\u001a\u00020\fJ\b\u0010'\u001a\u00020\u0017H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_practiceState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlPracticeState;", "practiceState", "Lkotlinx/coroutines/flow/StateFlow;", "getPracticeState", "()Lkotlinx/coroutines/flow/StateFlow;", "isHeadGestureDetectionStarted", "", "isLinkCallbackRegistered", "headGestureToggleJob", "Lkotlinx/coroutines/Job;", "healthCallback", "com/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel$healthCallback$1", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel$healthCallback$1;", "linkCallback", "com/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel$linkCallback$1", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel$linkCallback$1;", "resetPractice", "", "startHeadGestureDetection", "stopHeadGestureDetection", "registerLinkCallback", "unregisterLinkCallback", "syncCurrentHeadGestureToggle", "reason", "", "syncHeadGestureToggle", "toggle", "", "toHeadGestureToggle", "toHexCommand", "handleHeadGesture", "headGesture", "advancePractice", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlPracticeViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int HEAD_GESTURE_NOD_TWICE = 3;
    private static final int HEAD_GESTURE_SHAKE_TWICE = 4;
    private static final int HEAD_GESTURE_TOGGLE_NOD_ONLY = 2;
    private static final int HEAD_GESTURE_TOGGLE_OFF = 0;
    private static final int HEAD_GESTURE_TOGGLE_SHAKE_ONLY = 3;
    private static final int SYNC_MAX_RETRIES = 3;
    private static final long SYNC_RETRY_DELAY_MS = 300;
    private static final String TAG = "HeadControlPracticeVM";
    private final z0<w49.d> _practiceState;
    private Job headGestureToggleJob;
    private final c healthCallback;
    private boolean isHeadGestureDetectionStarted;
    private boolean isLinkCallbackRegistered;
    private final d linkCallback;
    private final i1<w49.d> practiceState;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HeadControlGestureType.values().length];
            r0[HeadControlGestureType.NOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HeadControlGestureType.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements zj4.d {
        public final /* synthetic */ HeadControlPracticeViewModel a;

        public final /* synthetic */ void a(int r1, long r2) {
        }

        public final /* synthetic */ void b(int r1) {
        }

        public final /* synthetic */ void c(int r1, long r2) {
        }

        public final /* synthetic */ void d(int r1, long r2) {
        }

        public final /* synthetic */ void e(int r1, long r2) {
        }

        public final /* synthetic */ void g(int r1) {
        }

        public c(HeadControlPracticeViewModel r1) {
            this.a = r1;
        }

        public final void f(int r5, long r6) {
            g49.d.d(HeadControlPracticeViewModel.TAG, "receive health head gesture, headGesture=" + r5 + ", timestamp=" + r6);
            if (HeadControlPracticeViewModel.access$handleHeadGesture(this.a, r5) == false) goto L6;
            g49.d.d(HeadControlPracticeViewModel.TAG, "practice head gesture matched, headGesture=" + r5 + ", timestamp=" + r6);
            return;
        }
    }

    public static final class d extends t0 {
        public final /* synthetic */ HeadControlPracticeViewModel a;

        public d(HeadControlPracticeViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r3, int r4, int r5) {
            super.onDoraLinkStateChanged(r3, r4, r5);
            StringBuilder r0 = new StringBuilder("onDoraLinkStateChanged, device=");
            if (r3 == null) goto L5;
            String r6 = r3.mac;
        L6:
            r0.append(r6);
            r0.append(", prevState=");
            r0.append(r4);
            r0.append(", state=");
            r0.append(r5);
            g49.d.d(HeadControlPracticeViewModel.TAG, r0.toString());
            if (r5 != 0) goto L9;
            HeadControlPracticeViewModel.access$syncHeadGestureToggle(this.a, 0, "device disconnected");
            return;
        L9:
            if (r5 == 2) goto L12;
            return;
        L12:
            if (HeadControlPracticeViewModel.access$isHeadGestureDetectionStarted$p(this.a) == false) goto L16;
            HeadControlPracticeViewModel.access$syncCurrentHeadGestureToggle(this.a, "device reconnected");
            return;
        L16:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.practice.HeadControlPracticeViewModel$syncHeadGestureToggle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.practice.HeadControlPracticeViewModel$syncHeadGestureToggle$1", f = "HeadControlPracticeViewModel.kt", i = {0}, l = {163}, m = "invokeSuspend", n = {"attempt"}, s = {"I$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        final /* synthetic */ int $toggle;
        int I$0;
        int label;
        final /* synthetic */ HeadControlPracticeViewModel this$0;

        public AnonymousClass1(int r1, HeadControlPracticeViewModel r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$toggle = r1;
            this.this$0 = r2;
            this.$reason = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$toggle, this.this$0, this.$reason, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00dc -> B:31:0x0101). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00df -> B:31:0x0101). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r11) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = this.label;
            if (r4 == 0) goto L8;
            if (r4 != 1) goto L7;
            int r5 = this.I$0;
            ResultKt.throwOnFailure(r11);
            AnonymousClass1 r12 = this;
        L31:
            r5 = r5 + 1;
        L10:
            if (r5 >= 4) goto L33;
            zj4.a r6 = zj4.a.a.a;     // Catch: Exception -> L14
            if (r6 == null) goto L16;
            Integer r7 = Boxing.boxInt(r6.c(r12.$toggle));     // Catch: Exception -> L14
        L17:
            g49.d.d(HeadControlPracticeViewModel.TAG, "syncHeadGestureToggle attempt=" + r5 + "/3, toggle=" + HeadControlPracticeViewModel.access$toHexCommand(r12.this$0, r12.$toggle) + ", reason=" + r12.$reason + ", ret=" + r7);     // Catch: Exception -> L14
            if (r7 != null) goto L21;
        L26:
            if (r5 >= 3) goto L30;
            g49.d.e(HeadControlPracticeViewModel.TAG, "syncHeadGestureToggle failed, retry after 300ms, toggle=" + HeadControlPracticeViewModel.access$toHexCommand(r12.this$0, r12.$toggle) + ", reason=" + r12.$reason);
            r12.I$0 = r5;
            r12.label = 1;
            if (DelayKt.delay(300, r12) != r3) goto L31;
            return r3;
        L30:
            g49.d.b(HeadControlPracticeViewModel.TAG, "syncHeadGestureToggle failed after retries, toggle=" + HeadControlPracticeViewModel.access$toHexCommand(r12.this$0, r12.$toggle) + ", reason=" + r12.$reason);
            goto L31
        L21:
            if (r7.intValue() != 0) goto L26;
            return Unit.INSTANCE;
        L16:
            r7 = null;
        L14:
            e = move-exception;
            g49.d.b(HeadControlPracticeViewModel.TAG, "syncHeadGestureToggle attempt=" + r5 + "/3 exception, toggle=" + HeadControlPracticeViewModel.access$toHexCommand(r12.this$0, r12.$toggle) + ", reason=" + r12.$reason + ", message=" + e.getMessage());
            goto L26
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            r12 = this;
            r5 = 1;
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    private final void registerLinkCallback() {
        if (this.isLinkCallbackRegistered == false) goto L6;
        g49.d.d(TAG, "link callback already registered");
        return;
    L6:
        kj4.a r0 = kj4.a.g();
        if (r0 != null) goto L10;
        g49.d.e(TAG, "register link callback failed, DoraAdapter is null");
        return;
    L10:
        g49.d.d(TAG, "register link callback");
        r0.registerDoraLinkCallback(this.linkCallback);
        this.isLinkCallbackRegistered = true;
    }

    private final void unregisterLinkCallback() {
        if (this.isLinkCallbackRegistered == true) goto L6;
        g49.d.d(TAG, "link callback already unregistered");
        return;
    L6:
        g49.d.d(TAG, "unregister link callback");
        kj4.a r0 = kj4.a.g();
        if (r0 == null) goto L9;
        r0.unregisterDoraLinkCallback(this.linkCallback);
    L9:
        this.isLinkCallbackRegistered = false;
    }

    public final boolean advancePractice() {
        w49.d r0 = (w49.d) this._practiceState.getValue();
        if (r0.b == true) goto L6;
        return false;
    L6:
        if (r0.a != HeadControlGestureType.NOD) goto L11;
        z0<w49.d> r1 = this._practiceState;
    L8:
        Object r2 = r1.getValue();
        w49.d r3 = (w49.d) r2;
        if (r1.compareAndSet(r2, new w49.d(HeadControlGestureType.SHAKE, false)) == false) goto L8;
        syncCurrentHeadGestureToggle("advance to shake practice");
        return false;
    L11:
        return true;
    }

    public final void resetPractice() {
        this._practiceState.setValue(new w49.d(0));
    }

    public final void startHeadGestureDetection() {
        if (this.isHeadGestureDetectionStarted == false) goto L6;
        g49.d.d(TAG, "head gesture detection already started");
        return;
    L6:
        zj4.a r0 = zj4.a.a.a;
        if (r0 != null) goto L10;
        g49.d.e(TAG, "start head gesture detection failed, DoraHealth is null");
        return;
    L10:
        g49.d.d(TAG, "register health callback");
        c r1 = this.healthCallback;
        ((CopyOnWriteArraySet) r0.a).add(r1);
        registerLinkCallback();
        this.isHeadGestureDetectionStarted = true;
        syncCurrentHeadGestureToggle("practice page visible");
    }

    public final void stopHeadGestureDetection() {
        if (this.isHeadGestureDetectionStarted == true) goto L6;
        g49.d.d(TAG, "head gesture detection already stopped");
        return;
    L6:
        syncHeadGestureToggle(0, "practice page invisible");
        g49.d.d(TAG, "unregister health callback");
        zj4.a r0 = zj4.a.a.a;
        if (r0 == null) goto L9;
        c r1 = this.healthCallback;
        ((CopyOnWriteArraySet) r0.a).remove(r1);
    L9:
        unregisterLinkCallback();
        this.isHeadGestureDetectionStarted = false;
    }

    public HeadControlPracticeViewModel() {
        StateFlowImpl r0 = j1.a(new w49.d(0));
        this._practiceState = r0;
        this.practiceState = e.b(r0);
        this.healthCallback = new c(this);
        this.linkCallback = new d(this);
    }

    public void onCleared() {
        stopHeadGestureDetection();
        super.onCleared();
    }

    public final i1<w49.d> getPracticeState() {
        return this.practiceState;
    }

    public static final /* synthetic */ boolean access$isHeadGestureDetectionStarted$p(HeadControlPracticeViewModel r0) {
        return r0.isHeadGestureDetectionStarted;
    }

    private final boolean handleHeadGesture(int r5) {
        w49.d r0 = (w49.d) this._practiceState.getValue();
        if (r0.b == false) goto L5;
        return false;
    L5:
        HeadControlGestureType r1 = r0.a;
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L13;
        if (r5 == 4) goto L16;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L20;
        return false;
    L20:
        z0<w49.d> r7 = this._practiceState;
    L21:
        Object r3 = r7.getValue();
        w49.d r4 = (w49.d) r3;
        HeadControlGestureType r8 = r4.a;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r8, "expectedGesture");
        if (r7.compareAndSet(r3, new w49.d(r8, true)) == false) goto L21;
        syncCurrentHeadGestureToggle("practice gesture matched");
        return true;
    L16:
        r6 = true;
        goto L18
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        if (r5 != 3) goto L17;
        goto L16
    }

    private final void syncCurrentHeadGestureToggle(String r2) {
        syncHeadGestureToggle(toHeadGestureToggle((w49.d) this._practiceState.getValue()), r2);
    }

    private final int toHeadGestureToggle(w49.d r3) {
        if (r3.b == true) goto L14;
        HeadControlGestureType r4 = r3.a;
        if (r4 != HeadControlGestureType.NOD) goto L9;
        return 2;
    L9:
        if (r4 != HeadControlGestureType.SHAKE) goto L13;
        return 3;
    L13:
        return 0;
    L14:
        return 0;
    }

    private final String toHexCommand(int r4) {
        return "0x" + StringsKt.padStart(Integer.toString(r4, CharsKt.checkRadix(16)), 2, '0');
    }

    public static final /* synthetic */ boolean access$handleHeadGesture(HeadControlPracticeViewModel r0, int r1) {
        return r0.handleHeadGesture(r1);
    }

    public static final /* synthetic */ void access$syncCurrentHeadGestureToggle(HeadControlPracticeViewModel r0, String r1) {
        r0.syncCurrentHeadGestureToggle(r1);
    }

    public static final /* synthetic */ String access$toHexCommand(HeadControlPracticeViewModel r0, int r1) {
        return r0.toHexCommand(r1);
    }

    private final void syncHeadGestureToggle(int r10, String r11) {
        Job r0 = this.headGestureToggleJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.headGestureToggleJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r10, this, r11, null), 2, null);
    }

    public static final /* synthetic */ void access$syncHeadGestureToggle(HeadControlPracticeViewModel r0, int r1, String r2) {
        r0.syncHeadGestureToggle(r1, r2);
    }
}
