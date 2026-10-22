package com.obric.memorydata.memory.ui.feedback;

import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ha;
import com.obric.memorydata.memory.review.provider.ak;
import com.obric.memorydata.memory.review.provider.az;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0005*\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackRawObservationAttachmentCollector;", "", "<init>", "()V", "TAG", "", "RAW_OBSERVATIONS_FILE_NAME", "SCREENSHOTS_DIR_NAME", "INVALID_FILE_NAME_CHARACTER_REGEX", "Lkotlin/text/Regex;", "collect", "", "outputDir", "Ljava/io/File;", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "copyScreenshotIfPresent", "rawObservation", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "safeFileName", "FILE_URI_PREFIX", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f10960b = null;

    static {
        f10959a = new m();
        f10960b = new Regex("[^A-Za-z0-9._-]");
    }

    private m() {
    }

    private final String a(File r3) {
        String r2 = r3.getName();
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(f10960b.replace((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), "_"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L12;
        r4 = "screenshot";
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    }

    private final void a(File r12, RawObservationEntity r13) {
        String r0 = ha.f9173a.a(r13);
        boolean r3 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L30;
        String r1 = StringsKt.removePrefix(r0, (CharSequence) ZeusTransformUtils.preCheckCast("file://", CharSequence.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L31;
        File r2 = new File(r1);
        if (r2.isFile() == true) goto L12;
    L14:
        r3 = false;
    L15:
        if (r3 == false) goto L17;
        File r5 = r2;
    L18:
        if (r5 == null) goto L32;
        File r4 = new File(r12, "raw_observation_screenshots");
        r4.mkdirs();
        File r6 = new File(r4, r13.getId() + '_' + a(r5));
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L22
        m r11 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Object r15 = Result.m1421constructorimpl(FilesKt.copyTo$default(r5, r6, true, 0, 4, null));     // Catch: Throwable -> L22
    L24:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackRawObservation", "copy raw observation screenshot failed, id=" + r13.getId() + ", error=" + r16.getClass().getSimpleName(), null, 4, null);
        return;
    L33:
        return;
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    L32:
        return;
    L17:
        r5 = null;
        goto L18
    L12:
        if (r2.canRead() == false) goto L14;
    L31:
        return;
    }

    public final void a(File r13, EpisodicMemoryEntity r14) {
        Intrinsics.checkNotNullParameter(r13, "outputDir");
        Intrinsics.checkNotNullParameter(r14, "entity");
        List<Long> r15 = az.f10433a.a(r14.getSourceRawRefIds());
        if (r15.isEmpty() == false) goto L31;
        return;
    L31:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        m r4 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(new ak(null, 1, null).a(r15).b());     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 != null) goto L27;
        List<RawObservationEntity> r16 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == false) goto L29;
        return;
    L29:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L17
        m r12 = (m) ZeusTransformUtils.preCheckCast(this, m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        File r17 = new File(r13, "raw_observations.json");     // Catch: Throwable -> L17
        String r0 = g.f10949a.a(r16).toString(2);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");     // Catch: Throwable -> L17
        FilesKt.writeText$default(r17, r0, null, 2, null);     // Catch: Throwable -> L17
        Object r18 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
        if (r19 == null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackRawObservation", "write raw observations json failed, count=" + r16.size() + ", error=" + r19.getClass().getSimpleName(), null, 4, null);
    L22:
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        f10959a.a(r13, (RawObservationEntity) ZeusTransformUtils.preCheckCast(r110.next(), RawObservationEntity.class, "com.obric.memorydata.plugin"));
        goto L24
    L26:
        return;
    L17:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    L27:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackRawObservation", "query raw observations failed, count=" + r15.size() + ", error=" + r6.getClass().getSimpleName(), null, 4, null);
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
