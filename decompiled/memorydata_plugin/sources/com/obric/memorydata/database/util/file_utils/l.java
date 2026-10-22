package com.obric.memorydata.database.util.file_utils;

import android.content.Context;
import android.text.format.Formatter;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/FileProcessorFactory;", "", "<init>", "()V", "TAG", "", "DEFAULT_REJECTION_THRESHOLD", "", "DEFAULT_PPT_REJECTION_THRESHOLD", "STRICTLY_REJECTION_THRESHOLD", "normalProcessorFactories", "", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "Lkotlin/Function0;", "Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "streamingProcessorFactories", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "streamingThresholdMap", "rejectionThresholdMap", "getProcessor", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "fileExtension", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f9658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<FileExtension, Function0<o>> f9659b = null;
    private static final Map<FileExtension, Function0<b>> c = null;
    private static final Map<FileExtension, Long> d = null;
    private static final Map<FileExtension, Long> e = null;

    static {
        f9658a = new l();
        f9659b = MapsKt.mapOf(new Pair[]{TuplesKt.to(FileExtension.TXT, $$Lambda$l$HTIFDP9JReNuqzdLXFVEg9MjWJw.INSTANCE), TuplesKt.to(FileExtension.PDF, $$Lambda$l$SAHZsDVSKrm0K5Vly8jkLkoscMc.INSTANCE), TuplesKt.to(FileExtension.DOC, $$Lambda$l$ipjyc4_dxO4CuqWh1aXzxsn9Lw.INSTANCE), TuplesKt.to(FileExtension.XLSX, $$Lambda$l$tIeKtWQZPgB3GR7CDAuNvwk0GwM.INSTANCE), TuplesKt.to(FileExtension.XLS, $$Lambda$l$VcFd8d5XtU3VXeIgFF0TTpliM.INSTANCE), TuplesKt.to(FileExtension.PPT, $$Lambda$l$56Fi3DTJKruTuAJb1woGwfTE2Eg.INSTANCE), TuplesKt.to(FileExtension.PPTX, $$Lambda$l$BnhnYl977gYSI2DL8l3ZJkll7OY.INSTANCE)});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(FileExtension.XLSX, $$Lambda$l$yvfV30nJxXvhmHn0trqJCRnS2Y.INSTANCE), TuplesKt.to(FileExtension.XLS, $$Lambda$l$ahSubHSsfvQmRIYwpwrgX_w04_I.INSTANCE), TuplesKt.to(FileExtension.CSV, $$Lambda$l$d8FeLLxZP2FJd91eSREx6msoy94.INSTANCE), TuplesKt.to(FileExtension.DOCX, $$Lambda$l$p0KJ121oydUFNXAOS2SV2FMhVaQ.INSTANCE)});
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(FileExtension.XLSX, 0L), TuplesKt.to(FileExtension.XLS, 0L), TuplesKt.to(FileExtension.CSV, 0L), TuplesKt.to(FileExtension.DOCX, 0L)});
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to(FileExtension.XLSX, 52428800L), TuplesKt.to(FileExtension.XLS, 52428800L), TuplesKt.to(FileExtension.PDF, 20971520L), TuplesKt.to(FileExtension.DOC, 20971520L), TuplesKt.to(FileExtension.DOCX, 20971520L), TuplesKt.to(FileExtension.CSV, 52428800L), TuplesKt.to(FileExtension.PPT, 15728640L), TuplesKt.to(FileExtension.PPTX, 15728640L), TuplesKt.to(FileExtension.TXT, 52428800L)});
    }

    private l() {
    }

    private static final aa a() {
        return new aa();
    }

    private static final b b() {
        return (b) ZeusTransformUtils.preCheckCast(new PdfFileProcessor(), b.class, "com.obric.memorydata.plugin");
    }

    private static final o c() {
        return (o) ZeusTransformUtils.preCheckCast(new g(), o.class, "com.obric.memorydata.plugin");
    }

    private static final o d() {
        return (o) ZeusTransformUtils.preCheckCast(new ad(), o.class, "com.obric.memorydata.plugin");
    }

    private static final o e() {
        return (o) ZeusTransformUtils.preCheckCast(new ab(), o.class, "com.obric.memorydata.plugin");
    }

    private static final o f() {
        return (o) ZeusTransformUtils.preCheckCast(new t(), o.class, "com.obric.memorydata.plugin");
    }

    private static final o g() {
        return (o) ZeusTransformUtils.preCheckCast(new u(), o.class, "com.obric.memorydata.plugin");
    }

    private static final ae h() {
        return new ae();
    }

    private static final b i() {
        return (b) ZeusTransformUtils.preCheckCast(new ac(), b.class, "com.obric.memorydata.plugin");
    }

    private static final b j() {
        return (b) ZeusTransformUtils.preCheckCast(new f(), b.class, "com.obric.memorydata.plugin");
    }

    private static final b k() {
        return (b) ZeusTransformUtils.preCheckCast(new k(), b.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ o lambda$56Fi3DTJKruTuAJb1woGwfTE2Eg() {
        return f();
    }

    public static /* synthetic */ o lambda$BnhnYl977gYSI2DL8l3ZJkll7OY() {
        return g();
    }

    public static /* synthetic */ aa lambda$HTIFDP9JReNuqzdLXFVEg9MjWJw() {
        return a();
    }

    public static /* synthetic */ b lambda$SAHZsDVSKrm0K5Vly8jkLkoscMc() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$VcFd8d-5XtU3VXeIgFF0TT-pliM, reason: not valid java name */
    public static /* synthetic */ o m582lambda$VcFd8d5XtU3VXeIgFF0TTpliM() {
        return e();
    }

    public static /* synthetic */ b lambda$ahSubHSsfvQmRIYwpwrgX_w04_I() {
        return i();
    }

    public static /* synthetic */ b lambda$d8FeLLxZP2FJd91eSREx6msoy94() {
        return j();
    }

    /* JADX INFO: renamed from: lambda$ipjyc4_dxO4CuqWh1aXzxsn-9Lw, reason: not valid java name */
    public static /* synthetic */ o m583lambda$ipjyc4_dxO4CuqWh1aXzxsn9Lw() {
        return c();
    }

    public static /* synthetic */ b lambda$p0KJ121oydUFNXAOS2SV2FMhVaQ() {
        return k();
    }

    public static /* synthetic */ o lambda$tIeKtWQZPgB3GR7CDAuNvwk0GwM() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$yvfV30nJx-XvhmHn0trqJCRnS2Y, reason: not valid java name */
    public static /* synthetic */ ae m584lambda$yvfV30nJxXvhmHn0trqJCRnS2Y() {
        return h();
    }

    public final o a(FileEntity r13, FileExtension r14) {
        Intrinsics.checkNotNullParameter(r13, "fileEntity");
        Intrinsics.checkNotNullParameter(r14, "fileExtension");
        Long r12 = (Long) ZeusTransformUtils.preCheckCast(e.get(r14), Long.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L5;
        long r2 = r12.longValue();
    L7:
        if (r13.getFileSize() < r2) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FileProcessorFactory", "The file is too large, skip indexing. filename: " + com.obric.memorydata.utils.q.f13259a.b(r13.getFileName()) + ", size: " + Formatter.formatFileSize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13.getFileSize()) + ", type: " + r14.getValue() + ", threshold: " + Formatter.formatFileSize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2), null, 4, null);
        return null;
    L10:
        Function0 r15 = (Function0) ZeusTransformUtils.preCheckCast(f9659b.get(r14), Function0.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L20;
        long r3 = r13.getFileSize();
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(d.get(r14), Long.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L15;
        long r7 = r6.longValue();
    L17:
        if (r3 >= r7) goto L20;
        o r16 = (o) ZeusTransformUtils.preCheckCast(r15.invoke(), o.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FileProcessorFactory", "Created new " + r14.getValue() + " processor for: " + com.obric.memorydata.utils.q.f13259a.b(r13.getFileName()) + ", size: " + Formatter.formatFileSize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13.getFileSize()), false, 4, null);
        return r16;
    L15:
        r7 = Long.MAX_VALUE;
    L20:
        Function0 r17 = (Function0) ZeusTransformUtils.preCheckCast(c.get(r14), Function0.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L24;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r17.invoke(), b.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("FileProcessorFactory", "Created streaming processor for: " + com.obric.memorydata.utils.q.f13259a.b(r13.getFileName()) + ", size: " + Formatter.formatFileSize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13.getFileSize()));
        return (o) ZeusTransformUtils.preCheckCast(r18, o.class, "com.obric.memorydata.plugin");
    L24:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FileProcessorFactory", "Unable to find a suitable parser. filename: " + r13.getFileName() + ", type: " + r14.getValue() + ", size: " + Formatter.formatFileSize((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13.getFileSize()), null, 4, null);
        return null;
    L5:
        r2 = 52428800;
        goto L7
    }
}
