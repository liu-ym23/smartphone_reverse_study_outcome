package com.obric.memorydata.database.util.file_utils;

import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.hslf.usermodel.HSLFPictureShape;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SlideShow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J6\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0094@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptFileProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BasePptProcessor;", "<init>", "()V", "imageIndexCounter", "", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "supportedFileType", "Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "getSupportedFileType", "()Lcom/obric/memorydata/database/util/file_utils/FileExtension;", "createPresentation", "Lorg/apache/poi/sl/usermodel/SlideShow;", "fis", "Ljava/io/FileInputStream;", "processPictureShape", "", "shape", "Lorg/apache/poi/sl/usermodel/Shape;", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "parentId", "docFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lorg/apache/poi/sl/usermodel/Shape;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends d {
    private int c;
    private final String d;
    private final FileExtension e;

    public t() {
        this.c = 1;
        this.d = "PptFileProcessor";
        this.e = FileExtension.PPT;
    }

    @Override // com.obric.memorydata.database.util.file_utils.d
    public Object a(Shape<?, ?> r16, j r17, int r18, FileEntity r19, Continuation<? super Unit> r20) {
        Shape r3 = (Shape) ZeusTransformUtils.wrapperContextForParams(r16, Shape.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, PptFileProcessor$processPictureShape$1.class) == false) goto L7;
        PptFileProcessor$processPictureShape$1 r4 = (PptFileProcessor$processPictureShape$1) ZeusTransformUtils.preCheckCast(r0, PptFileProcessor$processPictureShape$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        PptFileProcessor$processPictureShape$1 r12 = r4;
        Object r1 = r12.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r12.label;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        Shape r7 = (Shape) ZeusTransformUtils.preCheckCast(r12.L$1, Shape.class, "com.obric.memorydata.plugin");
        t r2 = (t) ZeusTransformUtils.preCheckCast(r12.L$0, t.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Exception -> L31 ClassCastException -> L33
    L36:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.apache.poi.hslf.usermodel.HSLFPictureShape");     // Catch: Exception -> L31 ClassCastException -> L33
        HSLFPictureData r8 = ((HSLFPictureShape) ZeusTransformUtils.preCheckCast(r3, HSLFPictureShape.class, "com.obric.memorydata.plugin")).getPictureData();     // Catch: Exception -> L31 ClassCastException -> L33
        if (r8 != null) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Picture data is null for shape: " + r3.getClass().getName() + ", file: " + r19.getFileName(), null, 4, null);     // Catch: Exception -> L31 ClassCastException -> L33
        return Unit.INSTANCE;
    L22:
        if (r8.getType() != PictureData.PictureType.WMF) goto L24;
    L29:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Unsupported image type: " + r8.getType() + ", skipping", null, 4, null);     // Catch: Exception -> L31 ClassCastException -> L33
        return Unit.INSTANCE;
    L24:
        if (r8.getType() == PictureData.PictureType.EMF) goto L29;
        String r9 = a((PictureData) ZeusTransformUtils.preCheckCast(r8, PictureData.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L31 ClassCastException -> L33
        int r10 = this.c;     // Catch: Exception -> L31 ClassCastException -> L33
        this.c = r10 + 1;     // Catch: Exception -> L31 ClassCastException -> L33
        i r11 = new i(r9, "Microsoft PowerPoint", r10);     // Catch: Exception -> L31 ClassCastException -> L33
        n r13 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 ClassCastException -> L33
        byte[] r14 = r8.getData();     // Catch: Exception -> L31 ClassCastException -> L33
        Intrinsics.checkNotNullExpressionValue(r14, "getData(...)");     // Catch: Exception -> L31 ClassCastException -> L33
        r12.L$0 = this;     // Catch: Exception -> L31 ClassCastException -> L33
        r12.L$1 = r3;     // Catch: Exception -> L31 ClassCastException -> L33
        r12.label = 1;     // Catch: Exception -> L31 ClassCastException -> L33
        if (n.a.a(r13, r14, r11, r17, r18, r19, false, r12, 32, null) != r5) goto L36;
        return r5;
    L33:
        e = move-exception;
        RunLog.INSTANCE.error(a(), "Shape is not HSLFPictureShape: " + r3.getClass().getName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L31:
        e = move-exception;
        RunLog.INSTANCE.error(a(), "Failed to process HSLF picture", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        r4 = new PptFileProcessor$processPictureShape$1(this, r0);
        goto L8
    }

    @Override // com.obric.memorydata.database.util.file_utils.d, com.obric.memorydata.database.util.file_utils.b
    public String a() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.util.file_utils.d
    public SlideShow<?, ?> a(FileInputStream r3) {
        Intrinsics.checkNotNullParameter(r3, "fis");
        return (SlideShow) ZeusTransformUtils.preCheckCast(new HSLFSlideShow((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin")), SlideShow.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.util.file_utils.o
    public FileExtension j() {
        return this.e;
    }
}
