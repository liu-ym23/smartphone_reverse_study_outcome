package com.obric.aikernel.res.update;

import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.trace.TraceCons;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00012\u001c\u0010\n\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0000\u001a\u001a\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0010H\u0000\u001a2\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0017H\u0000\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0000\u001a \u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0000\u001a&\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020%00H\u0000\u001a \u00101\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0017H\u0000\u001a\u001a\u00104\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000106H\u0000\u001a\u0018\u00107\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0017H\u0000\u001a(\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0000\u001a \u0010=\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0017H\u0000\u001a\u0010\u0010?\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0004H\u0000\u001a\u000e\u0010@\u001a\u00020\u0001*\u0004\u0018\u00010AH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"UPDATE_AWAIT_FALLBACK_MARKER", "", "UPDATE_METADATA_FAILURE_MARKER", "awaitUpdateTargetResult", "Lcom/obric/aikernel/res/update/UpdateResult;", "biz", "constriction", "Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", AILabCheckPermissionTask.KEY_SOURCE, TypedValues.CycleType.S_WAVE_PHASE, "awaitBlock", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;Lcom/obric/aikernel/res/update/UpdateResult;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheOnlyFetchPackageConfigs", "", "packagesDir", "Ljava/io/File;", "configs", "", "Lcom/obric/aikernel/res/metadata/config/UpdateTaskConfig;", "deleteUpdateDownloads", "", "downloadsDir", "describePackageDirsForLog", "limit", "describeUpdateStage", "stage", "failedAwaitResult", "message", "getPendingUpdateNames", "", "isActiveUpdateJobUsingDownloads", "updateResult", "jobIsActive", "markMetadataRequestFailure", "", "result", "failure", "Lcom/obric/aikernel/res/update/MetadataRequestException;", "resolveExternalUpdateDownloadsDir", "externalRoot", "internalRoot", "internalDownloadsDir", "runResumeInspectionSafely", "trigger", "block", "Lkotlin/Function0;", "shouldCleanUpdateDownloads", "hasActiveUpdateJob", "onlyDownload", "shouldMarkMetadataRequestFailureBeforeRetry", "metadataOutcome", "Lcom/obric/aikernel/res/update/MetadataRequestOutcome;", "shouldRetryForegroundResult", TraceCons.METRIC_BACKGROUND, "shouldRetryPendingPackageUpdate", "hasPendingConfig", "now", "", "shouldRunPendingUpdateRetryCheck", "hasValidatedNetwork", "summarizeSingleUpdateResult", "describeConfigForUpdateLog", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class o {
    public static final int a(File r7, Collection<? extends com.obric.aikernel.res.metadata.config.k> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "packagesDir");
        Intrinsics.checkNotNullParameter(r9, "configs");
        Iterator r10 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(PackageUpdaterKt$cacheOnlyFetchPackageConfigs$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
    L4:
        if (r10.hasNext() == false) goto L16;
        com.obric.aikernel.res.metadata.config.k r3 = (com.obric.aikernel.res.metadata.config.k) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aikernel.res.metadata.config.k.class, "com.obric.memorydata.plugin");
        File r4 = new File(new File(r7, r3.a()), "configuration.json");
        File r5 = r4.getParentFile();
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L15;
        File r11 = r4.getParentFile();
        if (r11 == null) goto L15;
        r11.mkdirs();
    L15:
        com.obric.aikernel.res.utils.a r12 = com.obric.aikernel.res.utils.a.f6155a;
        String r13 = r3.b().toString();
        Intrinsics.checkNotNullExpressionValue(r13, "config.json.toString()");
        r12.b(r4, r13);
        r2 = r2 + 1;
        goto L4
    L8:
        if (r5.exists() == true) goto L10;
        r6 = true;
        goto L11
    L16:
        return r2;
    }

    public static final UpdateResult a(String r22, n.b r23, UpdateResult r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r22, "biz");
        Intrinsics.checkNotNullParameter(r23, "constriction");
        Intrinsics.checkNotNullParameter(r25, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r26, "message");
        if (r24 == null) goto L5;
        int r4 = r24.getStage();
    L6:
        String r16 = r23.a();
        if (r24 == null) goto L9;
        int r1 = r24.getPrior();
    L10:
        int r17 = r1;
        if (r24 == null) goto L13;
        boolean r2 = r24.getBackground();
    L14:
        UpdateResult r12 = new UpdateResult(r22, false, r4, null, false, 0, 0, r16, r17, r2, 104, null);
        Boolean r3 = null;
        if (r24 == null) goto L17;
        com.obric.aikernel.res.metadata.config.k r5 = r24.getCfg();
    L18:
        r12.setCfg(r5);
        StringBuilder r6 = new StringBuilder();
        if (r24 == null) goto L23;
        com.obric.aikernel.res.metadata.config.k r7 = r24.getCfg();
        if (r7 == null) goto L23;
        String r8 = r7.a();
    L24:
        StringBuilder r9 = r6.append(r8).append('@');
        if (r24 == null) goto L29;
        com.obric.aikernel.res.metadata.config.k r10 = r24.getCfg();
        if (r10 == null) goto L29;
        String r11 = r10.c();
    L30:
        StringBuilder r13 = r9.append(r11).append('_');
        if (r24 == null) goto L35;
        com.obric.aikernel.res.metadata.config.k r14 = r24.getCfg();
        if (r14 == null) goto L35;
        String r15 = r14.l();
    L36:
        r12.setMsg(r13.append(r15).append(" update await fallback phase=").append(r25).append(' ').append(r26).toString());
        r12.setFinished(true);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L39
        Object r18 = Result.m1421constructorimpl(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L39
    L42:
        if (Result.m1424exceptionOrNullimpl(r18) == null) goto L45;
        r18 = Long.valueOf(System.currentTimeMillis());
    L45:
        r12.setFinishTimestamp(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).longValue());
        com.obric.aikernel.runtime.utils.d r19 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r20 = new StringBuilder().append("update target await fallback phase=").append(r25).append(" biz=").append(r22).append(" caller=").append(r23.a()).append(" sourceSuccess=");
        if (r24 == null) goto L48;
        Boolean r21 = Boolean.valueOf(r24.getSuccess());
    L49:
        StringBuilder r27 = r20.append(r21).append(" sourceStage=");
        if (r24 == null) goto L52;
        Integer r28 = Integer.valueOf(r24.getStage());
    L53:
        StringBuilder r29 = r27.append(r28).append(" sourceFinished=");
        if (r24 == null) goto L56;
        r3 = Boolean.valueOf(r24.getFinished());
    L56:
        r19.c("PackageUpdater", r29.append(r3).append(" result=").append(a(r12)).toString());
        return r12;
    L52:
        r28 = null;
        goto L53
    L48:
        r21 = null;
    L39:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L35:
        r15 = null;
    L29:
        r11 = null;
    L23:
        r8 = null;
        goto L24
    L17:
        r5 = null;
        goto L18
    L13:
        r2 = r23.g();
        goto L14
    L9:
        r1 = r23.b();
        goto L10
    L5:
        r4 = 1;
        goto L6
    }

    public static final File a(File r1, File r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "externalRoot");
        Intrinsics.checkNotNullParameter(r2, "internalRoot");
        Intrinsics.checkNotNullParameter(r3, "internalDownloadsDir");
        return new File(r1, FilesKt.relativeTo(r3, r2).getPath());
    }

    public static final Object a(String r10, n.b r11, UpdateResult r12, String r13, Function1<? super Continuation<? super UpdateResult>, ? extends Object> r14, Continuation<? super UpdateResult> r15) {
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, PackageUpdaterKt$awaitUpdateTargetResult$1.class) == false) goto L7;
        PackageUpdaterKt$awaitUpdateTargetResult$1 r0 = (PackageUpdaterKt$awaitUpdateTargetResult$1) ZeusTransformUtils.preCheckCast(r17, PackageUpdaterKt$awaitUpdateTargetResult$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$3, String.class, "com.obric.memorydata.plugin");
        r12 = (UpdateResult) ZeusTransformUtils.preCheckCast(r0.L$2, UpdateResult.class, "com.obric.memorydata.plugin");
        r11 = (n.b) ZeusTransformUtils.preCheckCast(r0.L$1, n.b.class, "com.obric.memorydata.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L14
    L39:
        Object r19 = Result.m1421constructorimpl((UpdateResult) ZeusTransformUtils.preCheckCast(r18, UpdateResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L42:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 != null) goto L50;
        UpdateResult r111 = (UpdateResult) ZeusTransformUtils.preCheckCast(r19, UpdateResult.class, "com.obric.memorydata.plugin");
        if (r111.getFinishTimestamp() != 0) goto L47;
        r111.finish();
    L47:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "update target await end phase=" + r13 + " biz=" + r10 + " caller=" + r11.a() + ' ' + a(r111));
        return r111;
    L50:
        return a(r10, r11, r12, r13, "await exception " + r110.getClass().getName() + ": " + r110.getMessage());
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r18);
        com.obric.aikernel.runtime.utils.d r112 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r4 = new StringBuilder().append("update target await start phase=").append(r13).append(" biz=").append(r10).append(" caller=").append(r11.a()).append(" background=").append(r11.g()).append(" sourceSuccess=");
        String r8 = null;
        if (r12 == null) goto L21;
        Boolean r9 = Boxing.boxBoolean(r12.getSuccess());
    L22:
        StringBuilder r5 = r4.append(r9).append(" sourceStage=");
        if (r12 == null) goto L25;
        Integer r20 = Boxing.boxInt(r12.getStage());
    L26:
        StringBuilder r6 = r5.append(r20).append(" sourceFinished=");
        if (r12 == null) goto L29;
        Boolean r21 = Boxing.boxBoolean(r12.getFinished());
    L30:
        StringBuilder r7 = r6.append(r21).append(" sourceMsg=");
        if (r12 == null) goto L35;
        String r22 = r12.getMsg();
        if (r22 == null) goto L35;
        r8 = StringsKt.take(r22, 160);
    L35:
        r112.b("PackageUpdater", r7.append(r8).toString());
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L14
        r0.L$0 = r10;     // Catch: Throwable -> L14
        r0.L$1 = r11;     // Catch: Throwable -> L14
        r0.L$2 = r12;     // Catch: Throwable -> L14
        r0.L$3 = r13;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r18 = r16.invoke(r0);     // Catch: Throwable -> L14
        if (r18 != r2) goto L39;
        return r2;
    L29:
        r21 = null;
        goto L30
    L25:
        r20 = null;
        goto L26
    L21:
        r9 = null;
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new PackageUpdaterKt$awaitUpdateTargetResult$1(r17);
        goto L8
    }

    public static final String a(int r9) {
        boolean r0 = true;
        if (r9 != 1) goto L6;
        return CommonConsts.APM_INNER_EVENT_COST_INIT;
    L6:
        if (r9 != 100) goto L9;
        return "metadata";
    L9:
        if (200 > r9) goto L12;
        if (r9 >= 300) goto L12;
        boolean r4 = true;
    L13:
        String r5 = "";
        String r7 = null;
        if (r4 == false) goto L30;
        StringBuilder r2 = new StringBuilder().append("download");
        Integer r10 = Integer.valueOf(r9 - 200);
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L19;
        r0 = false;
    L19:
        if (r0 == true) goto L22;
        r10 = null;
    L22:
        if (r10 == null) goto L24;
        r7 = new StringBuilder().append('+').append(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue()).toString();
    L24:
        if (r7 == null) goto L27;
    L26:
        r5 = r7;
    L27:
        StringBuilder r11 = r2.append(r5);
    L71:
        return r11.toString();
    L30:
        if (300 > r9) goto L33;
        if (r9 >= 400) goto L33;
        boolean r6 = true;
    L34:
        if (r6 == false) goto L49;
        StringBuilder r1 = new StringBuilder().append("process");
        Integer r12 = Integer.valueOf(r9 - 300);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L39;
        r0 = false;
    L39:
        if (r0 == true) goto L42;
        r12 = null;
    L42:
        if (r12 == null) goto L44;
        r7 = new StringBuilder().append('+').append(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue()).toString();
    L44:
        if (r7 == null) goto L47;
        r5 = r7;
    L47:
        r11 = r1.append(r5);
        goto L71
    L49:
        if (400 > r9) goto L52;
        if (r9 >= 500) goto L52;
        boolean r8 = true;
    L53:
        if (r8 == false) goto L65;
        r2 = new StringBuilder().append("install");
        Integer r13 = Integer.valueOf(r9 - 400);
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L58;
        r0 = false;
    L58:
        if (r0 == true) goto L61;
        r13 = null;
    L61:
        if (r13 == null) goto L63;
        r7 = new StringBuilder().append('+').append(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue()).toString();
    L63:
        if (r7 != null) goto L26;
    L65:
        if (r9 < 500) goto L67;
        return "success";
    L67:
        return "unknown";
    L52:
        r8 = false;
    L33:
        r6 = false;
    L12:
        r4 = false;
        goto L13
    }

    public static final String a(com.obric.aikernel.res.metadata.config.a r3) {
        if (r3 != null) goto L5;
        return "none";
    L5:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aikernel.res.metadata.config.e.class) == false) goto L10;
        StringBuilder r0 = new StringBuilder();
        String r2 = "lora:";
    L7:
        StringBuilder r1 = r0.append(r2);
    L14:
        return r1.append(r3.a()).append('@').append(r3.c()).toString();
    L10:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aikernel.res.metadata.config.i.class) == false) goto L12;
        r0 = new StringBuilder();
        r2 = "package:";
        goto L7
    L12:
        r1 = new StringBuilder().append(r3.getType()).append(':');
        goto L14
    }

    public static final String a(UpdateResult r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        return "biz=" + r4.getBiz() + ",success=" + r4.getSuccess() + ",stage=" + r4.getStage() + ",stageLabel=" + a(r4.getStage()) + ",finished=" + r4.getFinished() + ",cfg=" + a((com.obric.aikernel.res.metadata.config.a) ZeusTransformUtils.preCheckCast(r4.getCfg(), com.obric.aikernel.res.metadata.config.a.class, "com.obric.memorydata.plugin")) + ",caller=" + r4.getCaller() + ",prior=" + r4.getPrior() + ",background=" + r4.getBackground() + ",finishTimestamp=" + r4.getFinishTimestamp() + ",msg=" + StringsKt.take(r4.getMsg(), 240);
    }

    public static final String a(File r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L11;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        int r3 = r12.length;
    L5:
        if (r2 >= r3) goto L10;
        File r4 = r12[r2];
        if (r4.isDirectory() == false) goto L9;
        r1.add(r4);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L12:
        if (r13 != null) goto L15;
        r13 = CollectionsKt.emptyList();
    L15:
        if (r13.isEmpty() == false) goto L19;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L19:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), r11, null, (Function1) ZeusTransformUtils.preCheckCast(PackageUpdaterKt$describePackageDirsForLog$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 17, null);
    L11:
        r13 = null;
        goto L12
    }

    public static /* synthetic */ String a(File r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 12;
    L6:
        return a(r0, r1);
    }

    public static final List<String> a(File r8) {
        Intrinsics.checkNotNullParameter(r8, "packagesDir");
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L20;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r9.length;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L15;
        File r5 = r9[r4];
        if (r5.isDirectory() == true) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L14;
        r0.add(r5);
    L14:
        r4 = r4 + 1;
        goto L5
    L9:
        if (new File(r5, "configuration.json").exists() == false) goto L11;
        r6 = true;
        goto L12
    L15:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r2.add(((File) ZeusTransformUtils.preCheckCast(r11.next(), File.class, "com.obric.memorydata.plugin")).getName());
        goto L17
    L19:
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L21:
        if (r12 == null) goto L23;
        return r12;
    L23:
        return CollectionsKt.emptyList();
    L20:
        r12 = null;
        goto L21
    }

    public static final void a(UpdateResult r4, MetadataRequestException r5) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "failure");
        r4.setSuccess(false);
        if (r4.getStage() >= 100) goto L5;
        r4.setStage(100);
    L5:
        StringBuilder r0 = new StringBuilder();
        com.obric.aikernel.res.metadata.config.k r1 = r4.getCfg();
        if (r1 == null) goto L8;
        r0.append(r1.a() + '@' + r1.c() + '_' + r1.l() + ' ');
    L8:
        r0.append("metadata request failed");
        r0.append(" kind=" + r5.getKind() + " reason=" + r5.getMessage());
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
        r4.setMsg(r6);
        r4.finish();
    }

    public static final boolean a(UpdateResult r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L13;
        if (r2.getCfg() != null) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r3.c() == true) goto L7;
        r4 = true;
        goto L8
    }

    public static final boolean a(UpdateResult r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "updateResult");
        if (r2 == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.getFinished() == true) goto L9;
        if (r1.getStage() < 200) goto L9;
        return true;
    }

    public static final boolean a(File r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "packagesDir");
        if (r3 == true) goto L18;
        if (r2 == false) goto L7;
        return false;
    L7:
        if (r1.exists() == true) goto L9;
        return true;
    L9:
        String[] r4 = r1.list();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.length != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        r5 = false;
        goto L15
    L18:
        return false;
    }

    public static final boolean a(String r4, String r5, Function0<Unit> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "trigger");
        Intrinsics.checkNotNullParameter(r5, "biz");
        Intrinsics.checkNotNullParameter(r7, "block");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r7.invoke();     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.m1424exceptionOrNullimpl(r8);
        if (r1 == null) goto L11;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", "resumeBlockedUpdateTasksIfNeed inspect failed trigger=" + r4 + " biz=" + r5 + ' ' + ExceptionsKt.stackTraceToString(r1));
    L11:
        return Result.m1428isSuccessimpl(r8);
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final boolean a(boolean r7, UpdateResult r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "updateResult");
        if (r7 == false) goto L37;
        if (r9 == false) goto L7;
        return false;
    L7:
        if (r8.getFinished() == true) goto L15;
        if (r8.getStage() >= 200) goto L11;
        return false;
    L11:
        if (r8.getStage() < 300) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (r8.getSuccess() == false) goto L23;
        if (r8.getStage() == 1) goto L19;
        return false;
    L19:
        if (r8.getFinishTimestamp() == 0) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (r8.getStage() >= 200) goto L25;
        return false;
    L25:
        if (r8.getStage() < 300) goto L28;
        return false;
    L28:
        if (r8.getFinishTimestamp() == 0) goto L32;
        if (r10 >= (r8.getFinishTimestamp() + 10000)) goto L32;
        return false;
    L32:
        return true;
    L37:
        return false;
    }

    public static final boolean b(UpdateResult r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r3.getSuccess() == true) goto L9;
        if (r4 == false) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3.getMsg(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("update await fallback", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    public static final boolean b(File r1) {
        Intrinsics.checkNotNullParameter(r1, "downloadsDir");
        if (FilesKt.deleteRecursively(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.exists() == false) goto L8;
        return false;
    }

    public static final boolean b(File r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "packagesDir");
        if (r3 == false) goto L8;
        if (r2 == true) goto L8;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(a(r1), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
