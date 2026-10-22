package com.larus.avlink;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DoraWakeupResponseManager {
    public static final DoraWakeupResponseManager a = null;
    public static final CoroutineScope b = null;
    public static Job c;
    public static Job d;
    public static final Lazy e = null;
    public static long f;
    public static String g;
    public static boolean h;

    public static final class a implements l68.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        /* JADX INFO: renamed from: com.larus.avlink.DoraWakeupResponseManager$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0093a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TtsState.values().length];
                r0[TtsState.TTS_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TtsState.TTS_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        @Override // l68.b
        public final void b(byte[] r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "data");
        }

        @Override // l68.b
        public final void e(TtsLifeState r1, String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "lifeState");
        }

        @Override // l68.b
        public final void a(TtsTracer r2) {
            Intrinsics.checkNotNullParameter(r2, "tracer");
        }

        @Override // l68.b
        public final void d(final TtsState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            DoraWakeupResponseManager r0 = DoraWakeupResponseManager.a;
            final String r1 = this.a;
            DoraWakeupResponseManager.g(new g1(r1, r3));
        }

        public a(String r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // l68.b
        public final void c(TtsEventEnum r4, String r5, int r6, String r7, Map<String, ? extends Object> r8) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r5, "customErrorMsg");
            Intrinsics.checkNotNullParameter(r7, "ext");
            Intrinsics.checkNotNullParameter(r8, "extMap");
            FLogger.a.i("DoraWakeupResponse", "wakeup response onEvent, event=" + r4 + ", customErrorMsg=" + r5 + ", customErrorErrorCode=" + r6 + ", ext=" + r7 + ", extMap=" + r8);
            if (r4 != TtsEventEnum.TTS_FIRST_PACKAGE) goto L6;
            DoraWakeupResponseManager r9 = DoraWakeupResponseManager.a;
            final long r10 = this.b;
            final String r11 = this.a;
            DoraWakeupResponseManager.g(new f1(r10, r11));
            return;
        }
    }

    public DoraWakeupResponseManager() {
    }

    static {
        a = new DoraWakeupResponseManager();
        b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new w0())));
        e = LazyKt.lazy(new x0());
    }

    public static void d() {
        Job r0 = c;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        c = null;
        Job r1 = d;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        d = null;
        f = 0;
        g = null;
        FLogger.a.i("DoraWakeupResponse", "cancelWakeupResponseTimer");
    }

    public static long e() {
        e10 r0 = e10.a;
        Long r1 = e10.w0().getWakeupResponseCancelCutoffMs();
        if (r1 != null) goto L7;
        return LKUIToast.DURATION_SHORT;
    L7:
        return r1.longValue();
    }

    public static void c(String r6) {
        ((SoundPlayManager) e.getValue()).h();
        String r0 = g;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        FLogger.a.i("DoraWakeupResponse", "skip cancel wakeup response, taskId is empty");
        return;
    L13:
        FLogger.a.i("DoraWakeupResponse", "cancel wakeup response because " + r6 + ", taskId=" + r0);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService r3 = IFlowTtsClientService.a.a();
        if (r3 == null) goto L17;
        r3.g(r0, false, r6);
        return;
    L17:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static void g(Function0 r6) {
        BuildersKt.launch$default(b, null, null, new DoraWakeupResponseManager$post$1(r6, null), 3, null);
    }

    public static final Object a(DoraWakeupResponseManager r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof DoraWakeupResponseManager$runCancelTimeout$1) == false) goto L7;
        DoraWakeupResponseManager$runCancelTimeout$1 r0 = (DoraWakeupResponseManager$runCancelTimeout$1) r5;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r6 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        c("wakeup response not started in 3000 ms");
        d();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r0.label = 1;
        if (DelayKt.delay(3000, r0) != r7) goto L17;
        return r7;
    L7:
        r0 = new DoraWakeupResponseManager$runCancelTimeout$1(r4, r5);
        goto L8
    }

    public static final Object b(DoraWakeupResponseManager r19, Continuation r20) {
        r19.getClass();
        if ((r20 instanceof DoraWakeupResponseManager$runWakeupResponse$1) == false) goto L7;
        DoraWakeupResponseManager$runWakeupResponse$1 r1 = (DoraWakeupResponseManager$runWakeupResponse$1) r20;
        int r2 = r1.label;
        if ((r2 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r1.label = r2 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        long r6 = r1.J$0;
        String r7 = (String) r1.L$1;
        String r8 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L39:
        FLogger.a.i("DoraWakeupResponse", "play wakeup response mp3, taskId=" + r8 + ", path=" + r7);
        ((SoundPlayManager) e.getValue()).f(r7, new e1(r8, r6));
    L41:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r9 = r1.J$1;
        long r11 = r1.J$0;
        String r10 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        long r12 = r11;
        long r13 = r9;
    L25:
        String r14 = (String) r0;
        JobKt.ensureActive(r1.getContext());
        long r15 = System.currentTimeMillis() - r13;
        if (r15 <= 2500) goto L28;
        FLogger.a.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path cost " + r15 + "ms exceed 2500 ms, skip wakeup response, taskId=" + r10);
        d();
        return Unit.INSTANCE;
    L28:
        if (r14 != null) goto L30;
    L33:
        if (r5 == false) goto L35;
        FLogger.a.i("DoraWakeupResponse", "wakeup response mp3 not found, play TTS now, taskId=" + r10);
        f(r10, r12);
        goto L41
    L35:
        long r16 = RangesKt.coerceAtLeast(e() - (System.currentTimeMillis() - f), 0);
        FLogger.a.i("DoraWakeupResponse", "wakeup response top style hit, schedule gecko mp3 after " + r16 + "ms, taskId=" + r10 + ", path=" + r14);
        r1.L$0 = r10;
        r1.L$1 = r14;
        r1.J$0 = r12;
        r1.label = 3;
        if (DelayKt.delay(r16, r1) == r3) goto L45;
        r7 = r14;
        r8 = r10;
        r6 = r12;
        goto L39
    L45:
        return r3;
    L30:
        if (r14.length() == 0) goto L33;
        r5 = false;
        goto L33
    L17:
        ResultKt.throwOnFailure(r0);
    L21:
        String r17 = "DoraWakeupNotice" + System.currentTimeMillis();
        g = r17;
        r12 = System.currentTimeMillis();
        FLogger.a.i("DoraWakeupResponse", "wakeupResponseTimer timeout, hasReceivedVadEnd=" + h + ", taskId=" + r17);
        r13 = System.currentTimeMillis();
        CoroutineDispatcher r21 = Dispatchers.getIO();
        DoraWakeupResponseManager$runWakeupResponse$mp3Path$1 r110 = new DoraWakeupResponseManager$runWakeupResponse$mp3Path$1(null);
        r1.L$0 = r17;
        r1.J$0 = r12;
        r1.J$1 = r13;
        r1.label = 2;
        Object r22 = BuildersKt.withContext(r21, r110, r1);
        if (r22 == r3) goto L44;
        r10 = r17;
        r0 = r22;
        goto L25
    L44:
        return r3;
    L18:
        ResultKt.throwOnFailure(r0);
        r1.label = 1;
        if (DelayKt.delay(1700, r1) != r3) goto L21;
        return r3;
    L7:
        r1 = new DoraWakeupResponseManager$runWakeupResponse$1(r19, r20);
        goto L8
    }

    public static void f(String r4, long r5) {
        String r0 = (String) CollectionsKt.random(CollectionsKt.listOf(new String[]{"嗯。", "我在听"}), Random.Default);
        FLogger.a.i("DoraWakeupResponse", "play wakeup response TTS, taskId=" + r4 + ", text=" + r0);
        u0.b(r0, r4, new a(r4, r5));
    }
}
