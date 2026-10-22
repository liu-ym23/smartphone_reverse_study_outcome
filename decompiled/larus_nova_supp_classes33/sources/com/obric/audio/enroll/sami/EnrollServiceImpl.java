package com.obric.audio.enroll.sami;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.VoiceEnrollServiceImpl;
import com.obric.audio.enroll.view.EnrollStageView;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/audio/enroll/sami/EnrollServiceImpl;", "Lcom/obric/audio/enroll/IEnrollService;", "<init>", "()V", "serialDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "serialScope", "Lkotlinx/coroutines/CoroutineScope;", "createSamiHandle", "", "context", "Landroid/content/Context;", "deviceSn", "", "isDoraEnroll", "", "createPhoneSamiHandle", "startRecord", "taskId", "callback", "Lcom/obric/audio/enroll/EnrollAsrCallback;", "wakeupId", "stopRecord", "release", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollServiceImpl implements IEnrollService {
    public final CoroutineScope b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.sami.EnrollServiceImpl$release$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.sami.EnrollServiceImpl$release$1", f = "EnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SamiEnrollEngine.a.getClass();
            SamiEnrollEngine.x();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void release() {
        FLogger.a.i("EnrollServiceImpl", "release");
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass1(null), 3, null);
    }

    public EnrollServiceImpl() {
        ExecutorCoroutineDispatcher r0 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("EnrollServiceImpl")));
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r0));
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        FLogger.a.i("EnrollServiceImpl", "stopRecord taskId=" + r10);
        BuildersKt.launch$default(this.b, null, null, new EnrollServiceImpl$stopRecord$1(r10, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void c(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        FLogger.a.i("EnrollServiceImpl", "createPhoneSamiHandle");
        VoiceEnrollServiceImpl.k.getClass();
        VoiceEnrollServiceImpl.b.a("create phone enroll handle");
        BuildersKt.launch$default(this.b, null, null, new EnrollServiceImpl$createPhoneSamiHandle$1(r8, null), 3, null);
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void d(String r2, EnrollStageView r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        e(r2, r3, null);
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void b(Context r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("createSamiHandle isDoraEnroll=");
        r1.append(r12);
        r1.append(" snLen=");
        if (r11 == null) goto L5;
        int r2 = r11.length();
    L6:
        r1.append(r2);
        r0.i("EnrollServiceImpl", r1.toString());
        BuildersKt.launch$default(this.b, null, null, new EnrollServiceImpl$createSamiHandle$1(r10, r11, r12, null), 3, null);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.obric.audio.enroll.IEnrollService
    public final void e(String r10, com.obric.audio.enroll.a r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("startRecord taskId=");
        r1.append(r10);
        r1.append(" wakeupIdLen=");
        if (r12 == null) goto L5;
        int r2 = r12.length();
    L6:
        r1.append(r2);
        r0.i("EnrollServiceImpl", r1.toString());
        BuildersKt.launch$default(this.b, null, null, new EnrollServiceImpl$startRecord$1(r10, r12, r11, null), 3, null);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
