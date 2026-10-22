package com.obric.memorydata.memory.ui.automemory.memorylist;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\rJ'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0018J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryProFeedbackHelper;", "", "<init>", "()V", "TAG", "", "FEEDBACK_BUILD_PACKAGE_EXPORT_TIMEOUT_MS", "", "feedbackPreviewExportGate", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/FeedbackPreviewExportGate;", "resolvePreviewAttachmentPaths", "", "previewPath", "resolvePreviewAttachmentPaths$memory_obricRelease", "resolveFeedbackAttachmentDirectoryPaths", "outputDir", "Ljava/io/File;", "resolveFeedbackAttachmentDirectoryPaths$memory_obricRelease", "showFeedbackSheet", "", "activity", "Landroid/app/Activity;", "item", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "itemId", "odpReportDataProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "exportAutoMemoryPreviewForFeedback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final i f10707b = null;

    static {
        f10706a = new g();
        f10707b = new i(null, 1, null);
    }

    private g() {
    }

    private static final com.obric.memorydata.memory.ui.feedback.h a(AutoMemoryProEntity r1) {
        return com.obric.memorydata.memory.ui.feedback.i.f10952a.a(r1);
    }

    private static final com.obric.memorydata.memory.ui.feedback.h a(y r3) {
        AutoMemoryProEntity r4 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(r3.a()), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return com.obric.memorydata.memory.ui.feedback.i.f10952a.a(r4);
    }

    private final String a(final long r8, final File r10) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProFeedbackHelper", "skip feedback preview export on main thread, id=" + r8, null, 4, null);
        return null;
    L10:
        return (String) ZeusTransformUtils.preCheckCast(f10707b.a(10000, new $$Lambda$g$Gf7cKNH7dm563l1bIIvFdAVB2xw(r10, r8)), String.class, "com.obric.memorydata.plugin");
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProFeedbackHelper", "feedback preview export error, id=" + r8, null, 4, null);
        return null;
    }

    private static final String a(File r8, long r9) {
        r8.mkdirs();
        z r10 = (z) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryProFeedbackHelper$exportAutoMemoryPreviewForFeedback$1$result$1(r9, r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, z.b.class) == false) goto L8;
        String r11 = ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r10, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath();
        if (((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r10, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).isFile() == true) goto L14;
        return null;
    L14:
        return r11;
    L8:
        if (ZeusTransformUtils.instanceOf(r10, z.a.class) == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProFeedbackHelper", "feedback preview export failed, id=" + r9, null, 4, null);
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    private static final List a(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "<unused var>");
        File r7 = new File(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "auto_memory_feedback"), new StringBuilder().append(r4).append('_').append(System.currentTimeMillis()).toString());
        g r0 = f10706a;
        return r0.a(r7, r0.a(r4, r7));
    }

    private final void a(Activity r2, final long r3, Function0<com.obric.memorydata.memory.ui.feedback.h> r5) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Function0<com.obric.memorydata.memory.ui.feedback.h> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        new com.obric.memorydata.memory.ui.automemory.h(r1).a(null, new $$Lambda$g$So7kBpfF09lWHOa98izsgIrIWH4(r3), r4);
    }

    /* JADX INFO: renamed from: lambda$GcAjQFd21jq3dW-k5bdqjhuh1M0, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.feedback.h m813lambda$GcAjQFd21jq3dWk5bdqjhuh1M0(y r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$Gf7cKNH7dm563l1bIIvFdAVB2xw(File r0, long r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ List lambda$So7kBpfF09lWHOa98izsgIrIWH4(long r0, String r2) {
        return a(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$kXilHiaY0zx050Y2Rhy_rl3v-WU, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.feedback.h m814lambda$kXilHiaY0zx050Y2Rhy_rl3vWU(AutoMemoryProEntity r0) {
        return a(r0);
    }

    public final List<String> a(File r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "outputDir");
        if (r9 == null) goto L39;
        File r3 = new File(r9);
        boolean r4 = false;
        if (r3.isFile() == false) goto L9;
        String r10 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "getName(...)");
        if (StringsKt.endsWith$default(r10, ".preview.zip", false, 2, null) == false) goto L9;
        r4 = true;
    L9:
        if (r4 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L39;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
        g r12 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Object r13 = Result.m1421constructorimpl(r8.getCanonicalFile());     // Catch: Throwable -> L15
    L18:
        if (Result.m1427isFailureimpl(r13) == false) goto L20;
        r13 = null;
    L20:
        File r14 = (File) ZeusTransformUtils.preCheckCast(r13, File.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L39;
        if (r14.isDirectory() == true) goto L26;
        r14 = null;
    L26:
        if (r14 == null) goto L39;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L29
        g r7 = (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Object r16 = Result.m1421constructorimpl(r3.getCanonicalFile().getParentFile());     // Catch: Throwable -> L29
    L32:
        if (Result.m1427isFailureimpl(r16) == false) goto L35;
        r16 = null;
    L35:
        if (Intrinsics.areEqual((File) ZeusTransformUtils.preCheckCast(r16, File.class, "com.obric.memorydata.plugin"), r14) == true) goto L38;
        return null;
    L38:
        return CollectionsKt.listOf(r14.getAbsolutePath());
    L29:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L15:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L39:
        return null;
    }

    public final List<String> a(String r5) {
        if (r5 == null) goto L15;
        File r0 = new File(r5);
        boolean r1 = false;
        if (r0.isFile() == false) goto L9;
        String r6 = r0.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "getName(...)");
        if (StringsKt.endsWith$default(r6, ".preview.zip", false, 2, null) == false) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
        return null;
    L14:
        return CollectionsKt.listOf(r0.getAbsolutePath());
    L15:
        return null;
    }

    public final void a(Activity r4, final AutoMemoryProEntity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r5, "item");
        a(r6, r5.getId(), new $$Lambda$g$kXilHiaY0zx050Y2Rhy_rl3vWU(r5));
    }

    public final void a(Activity r4, final y r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r5, "item");
        a(r6, r5.a(), new $$Lambda$g$GcAjQFd21jq3dWk5bdqjhuh1M0(r5));
    }
}
