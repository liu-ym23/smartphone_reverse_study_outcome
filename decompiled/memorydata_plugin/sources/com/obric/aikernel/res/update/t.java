package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\"\u0010\u000e\u001a\u00020\u00062\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00110\u0010H\u0000\u001a\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\u001a\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u0000\u001a\u001a\u0010\u001f\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u001eH\u0000\u001a\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001eH\u0000\u001a\u0018\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0000\u001a\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0001H\u0000\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0000¨\u0006,"}, d2 = {"buildInstallArtifactStateLog", "", "type", ActivityLifecycle.NAME, "fileName", "move", "", "state", "Lcom/obric/aikernel/res/update/InstallArtifactState;", "finishStageFailureIfNeeded", "result", "Lcom/obric/aikernel/res/update/UpdateResult;", TypedValues.CycleType.S_WAVE_PHASE, InfoRequestQPSOptTraceLogger.REASON, "hasPendingWifiOnlyDownloads", "downloadStates", "", "Lkotlin/Pair;", "inspectInstallArtifactState", "src", "Ljava/io/File;", TypedValues.AttributesType.S_TARGET, "isApiTimeoutCancellation", "cause", "", "isPendingDownloadArtifact", "finalFileExists", "encryptedFileExists", "shouldEmitModelDownloadFailure", "failedTaskStates", "", "shouldRemoveDownloadGroupOnCallerCompletion", "remainingCallerCount", "shouldResumeDownloadConstraintForTrigger", "trigger", "blockedState", "shouldStartUpdateJob", "jobIsActive", "startInFlight", "shouldUseFastResourceCheck", "caller", "applyConstriction", "constriction", "Lcom/obric/aikernel/res/update/PackageUpdater$Constriction;", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class t {
    public static final c a(File r5, File r6) {
        Intrinsics.checkNotNullParameter(r5, "src");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        return new c(r5.exists(), r5.isDirectory(), r6.exists(), new File(r6.getPath() + "_temp").exists());
    }

    public static final String a(String r2, String r3, String r4, boolean r5, c r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r6, "state");
        StringBuilder r7 = new StringBuilder().append("install: ").append(r2).append('-').append(r3).append(" prepareFiles ").append(r4).append(" by ");
        if (r5 == false) goto L5;
        String r8 = "mv";
    L7:
        return r7.append(r8).append(" sourceExists=").append(r6.a()).append(" sourceIsDirectory=").append(r6.b()).append(" targetExists=").append(r6.c()).append(" targetTempExists=").append(r6.d()).toString();
    L5:
        r8 = "cp";
        goto L7
    }

    public static final boolean a(UpdateResult r4, n.b r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "constriction");
        r4.setCaller(r5.a());
        if (r5.b() <= r4.getPrior()) goto L5;
        r4.setPrior(r5.b());
        boolean r0 = true;
    L7:
        if (r5.g() == true) goto L12;
        if (r4.getBackground() == false) goto L12;
        r4.setBackground(false);
        return true;
    L12:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean a(UpdateResult r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r6, TypedValues.CycleType.S_WAVE_PHASE);
        Intrinsics.checkNotNullParameter(r7, InfoRequestQPSOptTraceLogger.REASON);
        if (r5.getFinished() == true) goto L5;
    L8:
        r5.fail("update failed phase=" + r6 + " stage=" + r5.getStage() + ' ' + r7);
        com.obric.aikernel.runtime.utils.d.f6216a.c("PackageUpdater", "finishStageFailureIfNeeded force terminal failure phase=" + r6 + " reason=" + r7 + " result=" + o.a(r5));
        return true;
    L5:
        if (r5.getSuccess() == true) goto L8;
        com.obric.aikernel.runtime.utils.d.f6216a.b("PackageUpdater", "finishStageFailureIfNeeded keep existing failure phase=" + r6 + " result=" + o.a(r5));
        return false;
    }

    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        if (Intrinsics.areEqual(r1, ":init") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, ":autoupdate") == true) goto L8;
        return false;
    }

    public static final boolean a(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "trigger");
        if (Intrinsics.areEqual(r1, "pending_retry_timer") == true) goto L5;
    L8:
        return true;
    L5:
        if (com.obric.aikernel.res.downloader.b.b(r2) == true) goto L8;
        return false;
    }

    public static final boolean a(Throwable r1) {
        return ZeusTransformUtils.instanceOf(r1, ApiTimeoutCancellationException.class);
    }

    public static final boolean a(Throwable r1, int r2) {
        if (ZeusTransformUtils.instanceOf(r1, CancellationException.class) == false) goto L8;
        if (r2 == 0) goto L7;
        return false;
    L7:
        return !a(r1);
    L8:
        return false;
    }

    public static final boolean a(Collection<Pair<Boolean, Boolean>> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "downloadStates");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L14;
        Iterator r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L14;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r0.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r0.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r4 == false) goto L12;
        if (r1 == false) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L7;
        return true;
    L12:
        r2 = false;
    L14:
        return false;
    }

    public static final boolean a(boolean r0, boolean r1) {
        if (r0 == true) goto L5;
        if (r1 == true) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(Collection<Integer> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "failedTaskStates");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L10;
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L10;
        if ((!com.obric.aikernel.res.downloader.b.a(((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).intValue())) == false) goto L7;
        return true;
    L10:
        return false;
    }

    public static final boolean b(boolean r0, boolean r1) {
        if (r0 == true) goto L5;
        if (r1 == true) goto L5;
        return true;
    L5:
        return false;
    }
}
