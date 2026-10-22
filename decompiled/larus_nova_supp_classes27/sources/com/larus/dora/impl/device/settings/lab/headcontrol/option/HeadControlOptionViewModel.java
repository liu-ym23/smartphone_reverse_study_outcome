package com.larus.dora.impl.device.settings.lab.headcontrol.option;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import w49.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "optionState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlOptionState;", "getOptionState", "()Lkotlinx/coroutines/flow/StateFlow;", "syncJob", "Lkotlinx/coroutines/Job;", "loadHeadGestureOptions", "", "updateOption", "type", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "option", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlActionOption;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlOptionViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int SYNC_MAX_RETRIES = 3;
    private static final long SYNC_RETRY_DELAY_MS = 300;
    private static final String TAG = "HeadControlOptionVM";
    private final i1<w49.c> optionState;
    private Job syncJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.option.HeadControlOptionViewModel$loadHeadGestureOptions$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.option.HeadControlOptionViewModel$loadHeadGestureOptions$1", f = "HeadControlOptionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            zj4.a r5 = zj4.a.a.a;
            w49.c r0 = null;
            if (r5 == null) goto L7;
            byte[] r6 = r5.h();
        L8:
            g49.d.d(HeadControlOptionViewModel.TAG, "takeHeadGesture result=".concat(w49.b.a(r6)));
            if (r6 == null) goto L11;
            r0 = w49.b.b(r6);
        L11:
            if (r0 != null) goto L14;
            g49.d.e(HeadControlOptionViewModel.TAG, "takeHeadGesture ignored, invalid config=".concat(w49.b.a(r6)));
            return Unit.INSTANCE;
        L14:
            StateFlowImpl r7 = e.a;
            Intrinsics.checkNotNullParameter(r0, "optionState");
            e.a.setValue(r0);
            return Unit.INSTANCE;
        L7:
            r6 = null;
            goto L8
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.headcontrol.option.HeadControlOptionViewModel$updateOption$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.headcontrol.option.HeadControlOptionViewModel$updateOption$1", f = "HeadControlOptionViewModel.kt", i = {0, 0, 0}, l = {74}, m = "invokeSuspend", n = {"payload", "payloadLog", "attempt"}, s = {"L$0", "L$1", "I$0"})
    public static final class C02851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HeadControlActionOption $option;
        final /* synthetic */ HeadControlGestureType $type;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C02851(HeadControlGestureType r1, HeadControlActionOption r2, Continuation<? super C02851> r3) {
            this.$type = r1;
            this.$option = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02851(this.$type, this.$option, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e8 -> B:42:0x0101). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00fe -> B:42:0x0101). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$0;
            String r7 = (String) this.L$1;
            byte[] r8 = (byte[]) this.L$0;
            ResultKt.throwOnFailure(r13);
            C02851 r14 = this;
        L42:
            r2 = r2 + 1;
        L25:
            if (r2 >= 4) goto L44;
            zj4.a r9 = zj4.a.a.a;     // Catch: Exception -> L36
            if (r9 == null) goto L29;
            Integer r10 = Boxing.boxInt(r9.b(r8));     // Catch: Exception -> L36
        L30:
            g49.d.d(HeadControlOptionViewModel.TAG, "syncHeadGesture attempt=" + r2 + "/3, type=" + r14.$type + ", option=" + r14.$option + ", payload=" + r7 + ", ret=" + r10);     // Catch: Exception -> L36
            if (r10 != null) goto L34;
        L38:
            if (r2 >= 3) goto L42;
            g49.d.e(HeadControlOptionViewModel.TAG, "syncHeadGesture failed, will retry after 300ms");
            r14.L$0 = r8;
            r14.L$1 = r7;
            r14.I$0 = r2;
            r14.label = 1;
            if (DelayKt.delay(300, r14) != r0) goto L42;
            return r0;
        L34:
            if (r10.intValue() != 0) goto L38;
        L29:
            r10 = null;
        L36:
            e = move-exception;
            g49.d.b(HeadControlOptionViewModel.TAG, "syncHeadGesture attempt=" + r2 + "/3 exception: " + e.getMessage());
        L44:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            int r15 = w49.b.a;
            HeadControlGestureType r16 = this.$type;
            HeadControlActionOption r3 = this.$option;
            Intrinsics.checkNotNullParameter(r16, "type");
            Intrinsics.checkNotNullParameter(r3, "option");
            int r11 = 2;
            r8 = new byte[2];
            int r17 = w49.b.a.a[r16.ordinal()];
            if (r17 == 1) goto L14;
            if (r17 != 2) goto L13;
            int r18 = 4;
        L15:
            r8[0] = (byte) r18;
            int r110 = w49.b.a.b[r3.ordinal()];
            if (r110 == 1) goto L23;
            if (r110 == 2) goto L22;
            if (r110 != 3) goto L21;
        L24:
            r8[1] = (byte) r11;
            r7 = w49.b.a(r8);
            r2 = 1;
            r14 = this;
            goto L25
        L21:
            throw new NoWhenBranchMatchedException();
        L22:
            r11 = 1;
            goto L24
        L23:
            r11 = 0;
            goto L24
        L13:
            throw new NoWhenBranchMatchedException();
        L14:
            r18 = 3;
            goto L15
        }
    }

    static {
        Companion = new a();
    }

    public HeadControlOptionViewModel() {
        this.optionState = e.b;
    }

    public final void loadHeadGestureOptions() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final i1<w49.c> getOptionState() {
        return this.optionState;
    }

    public final void updateOption(HeadControlGestureType r12, HeadControlActionOption r13) {
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "option");
        Job r2 = this.syncJob;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        StateFlowImpl r3 = e.a;
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "option");
        StateFlowImpl r0 = e.a;
    L6:
        Object r1 = r0.getValue();
        w49.c r4 = (w49.c) r1;
        int r5 = e.a.a[r12.ordinal()];
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L11;
        w49.c r6 = w49.c.a(r4, null, r13, 1);
    L14:
        if (r0.compareAndSet(r1, r6) == false) goto L6;
        this.syncJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02851(r12, r13, null), 2, null);
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r6 = w49.c.a(r4, r13, null, 2);
        goto L14
    }
}
