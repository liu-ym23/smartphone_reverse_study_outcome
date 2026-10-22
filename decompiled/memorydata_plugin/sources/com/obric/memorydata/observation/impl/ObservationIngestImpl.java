package com.obric.memorydata.observation.impl;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.observation.api.ObservationIngest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J2\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u0002H\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001fH\u0082\b¢\u0006\u0002\u0010 J\u001f\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fH\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/obric/memorydata/observation/impl/ObservationIngestImpl;", "Lcom/obric/memorydata/observation/api/ObservationIngest;", "<init>", "()V", "TAG", "", "getInst", "repo", "Lcom/obric/memorydata/observation/impl/RawObservationRepository;", "getRepo", "()Lcom/obric/memorydata/observation/impl/RawObservationRepository;", "repo$delegate", "Lkotlin/Lazy;", "writeScreenshot", "", "input", "Lcom/obric/memorydata/observation/api/ScreenshotObservationInput;", "writeAgent", "", "timestamp", "agentText", ObricMemoryConstants.KEY_SESSION_ID, "writeOAuto", "writeGlasses", "Lcom/obric/memorydata/observation/api/GlassesObservationInput;", "deviceIdOrNull", "safeInsert", ExifInterface.GPS_DIRECTION_TRUE, AILabCheckPermissionTask.KEY_SOURCE, "fallback", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObservationIngestImpl implements ObservationIngest {
    public static final ObservationIngestImpl INSTANCE = null;
    private static final String TAG = "ObservationIngest";
    private static final Lazy repo$delegate = null;

    static {
        INSTANCE = new ObservationIngestImpl();
        repo$delegate = LazyKt.lazy($$Lambda$ObservationIngestImpl$F4zQiLgo7T8hKrXgglVjYaBv_v4.INSTANCE);
    }

    private ObservationIngestImpl() {
    }

    private final String deviceIdOrNull() {
        String r0 = AppContext.INSTANCE.getServerDeviceId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L9;
        ObservationIngestImpl r10 = (ObservationIngestImpl) ZeusTransformUtils.preCheckCast(this, ObservationIngestImpl.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "observation skipped, deviceId empty", null, 4, null);
        return null;
    L9:
        return r0;
    }

    @JvmStatic
    public static final ObservationIngestImpl getInst() {
        return INSTANCE;
    }

    private final d getRepo() {
        return (d) ZeusTransformUtils.preCheckCast(repo$delegate.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ d lambda$F4zQiLgo7T8hKrXgglVjYaBv_v4() {
        return repo_delegate$lambda$0();
    }

    private static final d repo_delegate$lambda$0() {
        return new d(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao());
    }

    private final <T> T safeInsert(String r4, T r5, Function0<? extends T> r6) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r3.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L11;
        RunLog.INSTANCE.error(TAG, "write " + r4 + " raw observation failed", r9);
    L11:
        if (Result.m1427isFailureimpl(r8) == false) goto L14;
        return r5;
    L14:
        return (T) r8;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void safeInsert(String r4, Function0<Unit> r5) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Unit r6 = Unit.INSTANCE;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r3.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L10;
        RunLog.INSTANCE.error(TAG, "write " + r4 + " raw observation failed", r9);
    L10:
        Result.m1427isFailureimpl(r8);
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeAgent(long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "agentText");
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_SESSION_ID);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "agent observation skipped, empty text/sessionId", null, 4, null);
        return;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L20;
        String r3 = deviceIdOrNull();
        if (r3 != null) goto L10;
        return;
    L10:
        Unit r8 = Unit.INSTANCE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        INSTANCE.getRepo().insert(a.f11996a.a(r3, r9, r11, r12));     // Catch: Throwable -> L13
        Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L18;
        RunLog.INSTANCE.error(TAG, "write agent raw observation failed", r14);
    L18:
        Result.m1427isFailureimpl(r13);
        return;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeGlasses(com.obric.memorydata.observation.api.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "glasses observation skipped, glasses deviceId empty", null, 4, null);
        return;
    L6:
        Unit r6 = Unit.INSTANCE;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L9
        INSTANCE.getRepo().insert(b.f11997a.a(r7));     // Catch: Throwable -> L9
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "write glasses raw observation failed", r10);
    L14:
        Result.m1427isFailureimpl(r9);
        return;
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public void writeOAuto(long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "agentText");
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_SESSION_ID);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "oauto observation skipped, empty text/sessionId", null, 4, null);
        return;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L20;
        String r3 = deviceIdOrNull();
        if (r3 != null) goto L10;
        return;
    L10:
        Unit r8 = Unit.INSTANCE;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        INSTANCE.getRepo().insert(c.f11998a.a(r3, r9, r11, r12));     // Catch: Throwable -> L13
        Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L18;
        RunLog.INSTANCE.error(TAG, "write oauto raw observation failed", r14);
    L18:
        Result.m1427isFailureimpl(r13);
        return;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.memorydata.observation.api.ObservationIngest
    public long writeScreenshot(com.obric.memorydata.observation.api.b r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        String r4 = deviceIdOrNull();
        if (r4 != null) goto L5;
        return 0;
    L5:
        Object r0 = 0L;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r6 = Result.m1421constructorimpl(Long.valueOf(INSTANCE.getRepo().insert(e.f12000a.a(r5, r4))));     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error(TAG, "write screenshot raw observation failed", r7);
    L14:
        if (Result.m1427isFailureimpl(r6) == true) goto L18;
        r0 = r6;
    L18:
        return ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue();
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
