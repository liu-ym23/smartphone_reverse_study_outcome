package com.obric.aikernel.res.update;

import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.LoraConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
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

/* JADX INFO: loaded from: classes2.dex */
public final class PackageUpdaterKt {
    public static final Object a(String r10, PackageUpdater.b r11, UpdateResult r12, String r13, Function1<? super Continuation<? super UpdateResult>, ? extends Object> r14, Continuation<? super UpdateResult> r15) {
        if ((r15 instanceof PackageUpdaterKt$awaitUpdateTargetResult$1) == false) goto L7;
        PackageUpdaterKt$awaitUpdateTargetResult$1 r16 = (PackageUpdaterKt$awaitUpdateTargetResult$1) r15;
        int r17 = r16.label;
        if ((r17 & Integer.MIN_VALUE) == 0) goto L7;
        r16.label = r17 - Integer.MIN_VALUE;
    L8:
        Object r18 = r16.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r16.label;
        if (r20 == 0) goto L18;
        if (r20 != 1) goto L17;
        r13 = (String) r16.L$3;
        r12 = (UpdateResult) r16.L$2;
        r11 = (PackageUpdater.b) r16.L$1;
        r10 = (String) r16.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L14
    L39:
        Object r110 = Result.m32constructorimpl((UpdateResult) r18);     // Catch: Throwable -> L14
    L42:
        Throwable r111 = Result.m35exceptionOrNullimpl(r110);
        if (r111 != null) goto L50;
        UpdateResult r112 = (UpdateResult) r110;
        if (r112.getFinishTimestamp() != 0) goto L47;
        r112.finish();
    L47:
        com.obric.aikernel.runtime.utils.d.f5417a.i("PackageUpdater", "update target await end phase=" + r13 + " biz=" + r10 + " caller=" + r11.b() + ' ' + s(r112));
        return r112;
    L50:
        return h(r10, r11, r12, r13, "await exception " + r111.getClass().getName() + ": " + r111.getMessage());
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r18);
        com.obric.aikernel.runtime.utils.d r113 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r21 = new StringBuilder();
        r21.append("update target await start phase=");
        r21.append(r13);
        r21.append(" biz=");
        r21.append(r10);
        r21.append(" caller=");
        r21.append(r11.b());
        r21.append(" background=");
        r21.append(r11.a());
        r21.append(" sourceSuccess=");
        String r22 = null;
        if (r12 == null) goto L21;
        Boolean r23 = Boxing.boxBoolean(r12.getSuccess());
    L22:
        r21.append(r23);
        r21.append(" sourceStage=");
        if (r12 == null) goto L25;
        Integer r24 = Boxing.boxInt(r12.getStage());
    L26:
        r21.append(r24);
        r21.append(" sourceFinished=");
        if (r12 == null) goto L29;
        Boolean r25 = Boxing.boxBoolean(r12.getFinished());
    L30:
        r21.append(r25);
        r21.append(" sourceMsg=");
        if (r12 == null) goto L35;
        String r26 = r12.getMsg();
        if (r26 == null) goto L35;
        r22 = StringsKt.take(r26, 160);
    L35:
        r21.append(r22);
        r113.i("PackageUpdater", r21.toString());
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L14
        r16.L$0 = r10;     // Catch: Throwable -> L14
        r16.L$1 = r11;     // Catch: Throwable -> L14
        r16.L$2 = r12;     // Catch: Throwable -> L14
        r16.L$3 = r13;     // Catch: Throwable -> L14
        r16.label = 1;     // Catch: Throwable -> L14
        r18 = r14.invoke(r16);     // Catch: Throwable -> L14
        if (r18 != r19) goto L39;
        return r19;
    L29:
        r25 = null;
        goto L30
    L25:
        r24 = null;
        goto L26
    L21:
        r23 = null;
    L14:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r16 = new PackageUpdaterKt$awaitUpdateTargetResult$1(r15);
        goto L8
    }

    public static final int b(File r10, Collection<? extends UpdateTaskConfig> r11) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        Intrinsics.checkNotNullParameter(r11, "configs");
        Iterator r12 = SequencesKt.filter(CollectionsKt.asSequence(r11), PackageUpdaterKt$cacheOnlyFetchPackageConfigs$1.INSTANCE).iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L16;
        UpdateTaskConfig r14 = (UpdateTaskConfig) r12.next();
        File r15 = new File(new File(r10, r14.g()), "configuration.json");
        File r16 = r15.getParentFile();
        if (r16 != null) goto L8;
    L10:
        boolean r17 = false;
    L11:
        if (r17 == false) goto L15;
        File r18 = r15.getParentFile();
        if (r18 == null) goto L15;
        r18.mkdirs();
    L15:
        com.obric.aikernel.res.utils.a r19 = com.obric.aikernel.res.utils.a.f5222a;
        String r20 = r14.f().toString();
        Intrinsics.checkNotNullExpressionValue(r20, "config.json.toString()");
        r19.k(r15, r20);
        r13 = r13 + 1;
        goto L4
    L8:
        if (r16.exists() == true) goto L10;
        r17 = true;
        goto L11
    L16:
        return r13;
    }

    public static final boolean c(File r10) {
        Intrinsics.checkNotNullParameter(r10, "downloadsDir");
        if (FilesKt.deleteRecursively(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.exists() == false) goto L8;
        return false;
    }

    public static final String d(DistConfig r10) {
        if (r10 != null) goto L5;
        return "none";
    L5:
        if ((r10 instanceof LoraConfig) == false) goto L10;
        StringBuilder r11 = new StringBuilder();
        String r12 = "lora:";
    L7:
        r11.append(r12);
    L8:
        r11.append(r10.g());
        r11.append('@');
        r11.append(r10.i());
        return r11.toString();
    L10:
        if ((r10 instanceof com.obric.aikernel.res.metadata.config.e) == false) goto L12;
        r11 = new StringBuilder();
        r12 = "package:";
        goto L7
    L12:
        r11 = new StringBuilder();
        r11.append(r10.h());
        r11.append(':');
        goto L8
    }

    public static final String e(File r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        File[] r12 = r10.listFiles();
        if (r12 == null) goto L10;
        List r13 = new ArrayList();
        int r14 = 0;
        int r15 = r12.length;
    L5:
        if (r14 >= r15) goto L11;
        File r16 = r12[r14];
        if (r16.isDirectory() == false) goto L9;
        r13.add(r16);
    L9:
        r14 = r14 + 1;
    L11:
        if (r13 != null) goto L13;
        r13 = CollectionsKt.emptyList();
    L13:
        List r17 = r13;
        if (r17.isEmpty() == false) goto L18;
        return "[]";
    L18:
        return CollectionsKt.joinToString$default(r17, null, "[", "]", r11, null, PackageUpdaterKt$describePackageDirsForLog$1.INSTANCE, 17, null);
    L10:
        r13 = null;
        goto L11
    }

    public static /* synthetic */ String f(File r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 12;
    L6:
        return e(r10, r11);
    }

    public static final String g(int r10) {
        boolean r11 = true;
        if (r10 != 1) goto L6;
        return CommonConsts.APM_INNER_EVENT_COST_INIT;
    L6:
        if (r10 != 100) goto L9;
        return "metadata";
    L9:
        if (200 > r10) goto L12;
        if (r10 >= 300) goto L12;
        boolean r12 = true;
    L13:
        String r13 = "";
        String r14 = null;
        if (r12 == false) goto L29;
        StringBuilder r15 = new StringBuilder();
        r15.append("download");
        Integer r16 = Integer.valueOf(r10 - 200);
        if (r16.intValue() != 0) goto L19;
        r11 = false;
    L19:
        if (r11 == true) goto L22;
        r16 = null;
    L22:
        if (r16 == null) goto L24;
        int r17 = r16.intValue();
        StringBuilder r18 = new StringBuilder();
        r18.append('+');
        r18.append(r17);
        r14 = r18.toString();
    L24:
        if (r14 == null) goto L27;
    L26:
        r13 = r14;
    L27:
        r15.append(r13);
        return r15.toString();
    L29:
        if (300 > r10) goto L32;
        if (r10 >= 400) goto L32;
        boolean r19 = true;
    L33:
        if (r19 == false) goto L48;
        StringBuilder r20 = new StringBuilder();
        r20.append("process");
        Integer r21 = Integer.valueOf(r10 - 300);
        if (r21.intValue() != 0) goto L38;
        r11 = false;
    L38:
        if (r11 == true) goto L41;
        r21 = null;
    L41:
        if (r21 == null) goto L43;
        int r22 = r21.intValue();
        StringBuilder r23 = new StringBuilder();
        r23.append('+');
        r23.append(r22);
        r14 = r23.toString();
    L43:
        if (r14 == null) goto L46;
        r13 = r14;
    L46:
        r20.append(r13);
        return r20.toString();
    L48:
        if (400 > r10) goto L51;
        if (r10 >= 500) goto L51;
        boolean r24 = true;
    L52:
        if (r24 == false) goto L64;
        r15 = new StringBuilder();
        r15.append("install");
        Integer r25 = Integer.valueOf(r10 - 400);
        if (r25.intValue() != 0) goto L57;
        r11 = false;
    L57:
        if (r11 == true) goto L60;
        r25 = null;
    L60:
        if (r25 == null) goto L62;
        int r26 = r25.intValue();
        StringBuilder r27 = new StringBuilder();
        r27.append('+');
        r27.append(r26);
        r14 = r27.toString();
    L62:
        if (r14 != null) goto L26;
    L64:
        if (r10 < 500) goto L66;
        return "success";
    L66:
        return "unknown";
    L51:
        r24 = false;
    L32:
        r19 = false;
    L12:
        r12 = false;
        goto L13
    }

    public static final UpdateResult h(String r22, PackageUpdater.b r23, UpdateResult r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r22, "biz");
        Intrinsics.checkNotNullParameter(r23, "constriction");
        Intrinsics.checkNotNullParameter(r25, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r26, "message");
        if (r24 == null) goto L5;
        int r10 = r24.getStage();
    L6:
        String r16 = r23.b();
        if (r24 == null) goto L9;
        int r11 = r24.getPrior();
    L10:
        int r17 = r11;
        if (r24 == null) goto L13;
        boolean r12 = r24.getBackground();
    L14:
        UpdateResult r13 = new UpdateResult(r22, false, r10, null, false, 0, 0, r16, r17, r12, 104, null);
        Boolean r14 = null;
        if (r24 == null) goto L17;
        UpdateTaskConfig r15 = r24.getCfg();
    L18:
        r13.setCfg(r15);
        StringBuilder r18 = new StringBuilder();
        if (r24 == null) goto L23;
        UpdateTaskConfig r19 = r24.getCfg();
        if (r19 == null) goto L23;
        String r20 = r19.g();
    L24:
        r18.append(r20);
        r18.append('@');
        if (r24 == null) goto L29;
        UpdateTaskConfig r21 = r24.getCfg();
        if (r21 == null) goto L29;
        String r27 = r21.i();
    L30:
        r18.append(r27);
        r18.append('_');
        if (r24 == null) goto L35;
        UpdateTaskConfig r28 = r24.getCfg();
        if (r28 == null) goto L35;
        String r29 = r28.k();
    L36:
        r18.append(r29);
        r18.append(" update await fallback phase=");
        r18.append(r25);
        r18.append(' ');
        r18.append(r26);
        r13.setMsg(r18.toString());
        r13.setFinished(true);
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L39
        Object r31 = Result.m32constructorimpl(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L39
    L42:
        if (Result.m35exceptionOrNullimpl(r31) == null) goto L45;
        r31 = Long.valueOf(System.currentTimeMillis());
    L45:
        r13.setFinishTimestamp(((Number) r31).longValue());
        com.obric.aikernel.runtime.utils.d r32 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r33 = new StringBuilder();
        r33.append("update target await fallback phase=");
        r33.append(r25);
        r33.append(" biz=");
        r33.append(r22);
        r33.append(" caller=");
        r33.append(r23.b());
        r33.append(" sourceSuccess=");
        if (r24 == null) goto L48;
        Boolean r34 = Boolean.valueOf(r24.getSuccess());
    L49:
        r33.append(r34);
        r33.append(" sourceStage=");
        if (r24 == null) goto L52;
        Integer r35 = Integer.valueOf(r24.getStage());
    L53:
        r33.append(r35);
        r33.append(" sourceFinished=");
        if (r24 == null) goto L56;
        r14 = Boolean.valueOf(r24.getFinished());
    L56:
        r33.append(r14);
        r33.append(" result=");
        r33.append(s(r13));
        r32.f("PackageUpdater", r33.toString());
        return r13;
    L52:
        r35 = null;
        goto L53
    L48:
        r34 = null;
    L39:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r31 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L35:
        r29 = null;
    L29:
        r27 = null;
    L23:
        r20 = null;
        goto L24
    L17:
        r15 = null;
        goto L18
    L13:
        r12 = r23.a();
        goto L14
    L9:
        r11 = r23.f();
        goto L10
    L5:
        r10 = 1;
        goto L6
    }

    public static final List<String> i(File r10) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L19;
        ArrayList r12 = new ArrayList();
        int r13 = r11.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L15;
        File r15 = r11[r14];
        if (r15.isDirectory() == true) goto L9;
    L11:
        boolean r16 = false;
    L12:
        if (r16 == false) goto L14;
        r12.add(r15);
    L14:
        r14 = r14 + 1;
        goto L5
    L9:
        if (new File(r15, "configuration.json").exists() == false) goto L11;
        r16 = true;
        goto L12
    L15:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r18 = r12.iterator();
    L17:
        if (r18.hasNext() == false) goto L20;
        r17.add(((File) r18.next()).getName());
    L20:
        if (r17 == null) goto L22;
        return r17;
    L22:
        return CollectionsKt.emptyList();
    L19:
        r17 = null;
        goto L20
    }

    public static final boolean j(UpdateResult r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "updateResult");
        if (r11 == true) goto L5;
    L9:
        return false;
    L5:
        if (r10.getFinished() == true) goto L9;
        if (r10.getStage() < 200) goto L9;
        return true;
    }

    public static final void k(UpdateResult r10, MetadataRequestException r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "failure");
        r10.setSuccess(false);
        if (r10.getStage() >= 100) goto L5;
        r10.setStage(100);
    L5:
        StringBuilder r12 = new StringBuilder();
        UpdateTaskConfig r13 = r10.getCfg();
        if (r13 == null) goto L8;
        r12.append(r13.g() + '@' + r13.i() + '_' + r13.k() + ' ');
    L8:
        r12.append("metadata request failed");
        r12.append(" kind=" + r11.getKind() + " reason=" + r11.getMessage());
        String r14 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "StringBuilder().apply(builderAction).toString()");
        r10.setMsg(r14);
        r10.finish();
    }

    public static final File l(File r10, File r11, File r12) {
        Intrinsics.checkNotNullParameter(r10, "externalRoot");
        Intrinsics.checkNotNullParameter(r11, "internalRoot");
        Intrinsics.checkNotNullParameter(r12, "internalDownloadsDir");
        return new File(r10, FilesKt.relativeTo(r12, r11).getPath());
    }

    public static final boolean m(String r10, String r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "trigger");
        Intrinsics.checkNotNullParameter(r11, "biz");
        Intrinsics.checkNotNullParameter(r12, "block");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        r12.invoke();     // Catch: Throwable -> L5
        Object r14 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L11;
        com.obric.aikernel.runtime.utils.d.f5417a.f("PackageUpdater", "resumeBlockedUpdateTasksIfNeed inspect failed trigger=" + r10 + " biz=" + r11 + ' ' + ExceptionsKt.stackTraceToString(r15));
    L11:
        return Result.m39isSuccessimpl(r14);
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final boolean n(File r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        if (r12 == true) goto L18;
        if (r11 == false) goto L7;
        return false;
    L7:
        if (r10.exists() == true) goto L9;
        return true;
    L9:
        String[] r13 = r10.list();
        if (r13 != null) goto L12;
        return false;
    L12:
        if (r13.length != 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == true) goto L17;
        return false;
    L17:
        return true;
    L14:
        r14 = false;
        goto L15
    L18:
        return false;
    }

    public static final boolean o(UpdateResult r10, d r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L13;
        if (r10.getCfg() != null) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.d() == true) goto L7;
        r12 = true;
        goto L8
    }

    public static final boolean p(UpdateResult r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        if (r10.getSuccess() == true) goto L9;
        if (r11 == false) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r10.getMsg(), "update await fallback", false, 2, null) == true) goto L11;
        return true;
    L11:
        return false;
    L9:
        return false;
    }

    public static final boolean q(boolean r10, UpdateResult r11, boolean r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "updateResult");
        if (r10 == false) goto L37;
        if (r12 == false) goto L7;
        return false;
    L7:
        if (r11.getFinished() == true) goto L15;
        if (r11.getStage() >= 200) goto L11;
        return false;
    L11:
        if (r11.getStage() < 300) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (r11.getSuccess() == false) goto L23;
        if (r11.getStage() == 1) goto L19;
        return false;
    L19:
        if (r11.getFinishTimestamp() == 0) goto L21;
        return false;
    L21:
        return true;
    L23:
        if (r11.getStage() >= 200) goto L25;
        return false;
    L25:
        if (r11.getStage() < 300) goto L28;
        return false;
    L28:
        if (r11.getFinishTimestamp() == 0) goto L32;
        if (r13 >= (r11.getFinishTimestamp() + WorkRequest.MIN_BACKOFF_MILLIS)) goto L32;
        return false;
    L32:
        return true;
    L37:
        return false;
    }

    public static final boolean r(File r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "packagesDir");
        if (r12 == false) goto L8;
        if (r11 == true) goto L8;
        if ((!i(r10).isEmpty()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static final String s(UpdateResult r10) {
        Intrinsics.checkNotNullParameter(r10, "result");
        return "biz=" + r10.getBiz() + ",success=" + r10.getSuccess() + ",stage=" + r10.getStage() + ",stageLabel=" + g(r10.getStage()) + ",finished=" + r10.getFinished() + ",cfg=" + d(r10.getCfg()) + ",caller=" + r10.getCaller() + ",prior=" + r10.getPrior() + ",background=" + r10.getBackground() + ",finishTimestamp=" + r10.getFinishTimestamp() + ",msg=" + StringsKt.take(r10.getMsg(), 240);
    }
}
