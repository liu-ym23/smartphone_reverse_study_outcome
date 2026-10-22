package com.obric.assistant.interaction.impl.window.performance;

import android.os.SystemClock;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.dora.api.DoraConfig;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/performance/WindowColdOpenPreloadCoordinator;", "", "<init>", "()V", "TAG", "", "WINDOW_COLD_OPEN_PRELOAD_COOLDOWN_MS", "", "preloadScope", "Lkotlinx/coroutines/CoroutineScope;", "lastPreloadElapsedMs", "preloadForColdOpen", "", "source", "scene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowColdOpenPreloadCoordinator {
    public static final WindowColdOpenPreloadCoordinator INSTANCE = null;
    private static final String TAG = "WindowColdOpenPreloadCoordinator";
    private static final long WINDOW_COLD_OPEN_PRELOAD_COOLDOWN_MS = 1000;
    private static volatile long lastPreloadElapsedMs;
    private static final CoroutineScope preloadScope = null;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.window.performance.WindowColdOpenPreloadCoordinator$preloadForColdOpen$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.window.performance.WindowColdOpenPreloadCoordinator$preloadForColdOpen$1", f = "WindowColdOpenPreloadCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scene;
        final /* synthetic */ String $source;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$scene = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$scene, this.$source, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            long r0 = SystemClock.elapsedRealtime();
            String r12 = this.$scene;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
            IActionBarService r3 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);     // Catch: Throwable -> L11
            String r4 = DoraConfig.g();     // Catch: Throwable -> L11
            if (r3 == null) goto L8;
            Integer r13 = Boxing.boxInt(r3.l(r4, r12));     // Catch: Throwable -> L11
        L9:
            Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L11
        L13:
            String r5 = this.$source;
            String r6 = this.$scene;
            if (Result.isSuccess-impl(r14) == false) goto L16;
            Integer r7 = (Integer) r14;
            FLogger.a.i(WindowColdOpenPreloadCoordinator.TAG, "preloadForColdOpen finished, source=" + r5 + ", scene=" + r6 + ", costMs=" + (SystemClock.elapsedRealtime() - r0));
        L16:
            String r1 = this.$source;
            String r8 = this.$scene;
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L20;
            FLogger.a.w(WindowColdOpenPreloadCoordinator.TAG, "preloadForColdOpen failed, source=" + r1 + ", scene=" + r8, r15);
        L20:
            return Unit.INSTANCE;
        L8:
            r13 = null;
        L11:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private WindowColdOpenPreloadCoordinator() {
    }

    static {
        INSTANCE = new WindowColdOpenPreloadCoordinator();
        preloadScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final void preloadForColdOpen(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "source");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - lastPreloadElapsedMs) >= WINDOW_COLD_OPEN_PRELOAD_COOLDOWN_MS) goto L6;
        FLogger.a.i(TAG, "preloadForColdOpen skipped by cooldown, source=" + r8 + ", scene=" + r9);
        return;
    L6:
        lastPreloadElapsedMs = r0;
        BuildersKt.launch$default(preloadScope, null, null, new AnonymousClass1(r9, r8, null), 3, null);
    }

    public static /* synthetic */ void preloadForColdOpen$default(WindowColdOpenPreloadCoordinator r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.preloadForColdOpen(r1, r2);
    }
}
