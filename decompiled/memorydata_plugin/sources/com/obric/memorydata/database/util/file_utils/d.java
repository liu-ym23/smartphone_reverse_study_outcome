package com.obric.memorydata.database.util.file_utils;

import android.content.res.AssetFileDescriptor;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.lang.reflect.Method;
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
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.poi.hslf.usermodel.HSLFTextShape;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.sl.usermodel.AutoShape;
import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.PictureShape;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH$J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H\u0014J6\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0094@¢\u0006\u0002\u0010\u001aJ6\u0010\u001b\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H¤@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0004J\u0018\u0010\"\u001a\u00020\b2\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001dH\u0014J\u0018\u0010#\u001a\u00020\b2\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001dH\u0002J(\u0010$\u001a\u00020\u00142\u000e\u0010%\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0014J \u0010'\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0084@¢\u0006\u0002\u0010(J.\u0010)\u001a\u00020\u00142\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010*J(\u0010+\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030,2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J(\u0010-\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J(\u0010/\u001a\u00020\u00142\u000e\u00100\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0014J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\bH\u0004J\u0018\u00104\u001a\u0004\u0018\u00010\u00162\u0006\u00105\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u00106R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u00068"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BasePptProcessor;", "Lcom/obric/memorydata/database/util/file_utils/BaseDocumentImageProcessor;", "Lcom/obric/memorydata/database/util/file_utils/IFileProcessor;", "<init>", "()V", "xmlElementCount", "", "fileTypeTag", "", "getFileTypeTag", "()Ljava/lang/String;", "createPresentation", "Lorg/apache/poi/sl/usermodel/SlideShow;", "fis", "Ljava/io/FileInputStream;", "shouldSkipSlide", "", "slide", "Lorg/apache/poi/sl/usermodel/Slide;", "processSlideContent", "", "tree", "Lcom/obric/memorydata/database/util/file_utils/DocumentTree;", "parentId", "docFileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "(Lorg/apache/poi/sl/usermodel/Slide;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPictureShape", "shape", "Lorg/apache/poi/sl/usermodel/Shape;", "(Lorg/apache/poi/sl/usermodel/Shape;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;ILcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPictureFormat", "pictureData", "Lorg/apache/poi/sl/usermodel/PictureData;", "processTextShape", "getTextFromAutoShape", "processTableShape", "table", "Lorg/apache/poi/sl/usermodel/TableShape;", "fromStream", "(Ljava/io/FileInputStream;Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processSlide", "(Lorg/apache/poi/sl/usermodel/Slide;Lcom/obric/memorydata/database/util/file_utils/DocumentTree;Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTextNode", "Lorg/apache/poi/sl/usermodel/TextShape;", "processAutoShape", "Lorg/apache/poi/sl/usermodel/AutoShape;", "processGroupShape", "group", "Lorg/apache/poi/sl/usermodel/GroupShape;", "isTrulyBlankString", "s", "process", "fileEntity", "(Lcom/obric/capabilitykit/entity/app/FileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class d extends com.obric.memorydata.database.util.file_utils.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9641b = null;
    private int c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/BasePptProcessor$Companion;", "", "<init>", "()V", "MAX_SLIDES_TO_PROCESS", "", "MAX_SHAPES_PER_SLIDE", "MAX_XML_ELEMENTS", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9642a = null;

        static {
            int[] r0 = new int[PictureData.PictureType.values().length];
            r0[PictureData.PictureType.PNG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[PictureData.PictureType.JPEG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[PictureData.PictureType.WMF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[PictureData.PictureType.EMF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[PictureData.PictureType.GIF.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[PictureData.PictureType.BMP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f9642a = r0;
        }
    }

    static {
        f9641b = new a(null);
    }

    public d() {
    }

    private static final CharSequence a(d r12, Object r13) {
        String r1 = "";
        if (r13 != null) goto L40;
    L14:
        String r3 = "";
    L15:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
    L17:
        List r4 = null;
        if (r13 != null) goto L38;
    L26:
        Object r14 = null;
    L28:
        if (ZeusTransformUtils.instanceOf(r14, List.class) == false) goto L30;
        r4 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L24
    L30:
        if (r4 == null) goto L37;
        String r15 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$d$d6eNP28DQ3lj84_n1EjgpHw9S0I.INSTANCE, 30, null);     // Catch: Exception -> L24
        if (r15 == null) goto L37;
        r1 = r15;
    L24:
        e = move-exception;
        RunLog.INSTANCE.warn(r12.a(), "Failed to get text via HSLF fallback", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L37:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
    L38:
        Class<?> r5 = r13.getClass();     // Catch: Exception -> L24
        if (r5 == null) goto L26;
        Method r6 = r5.getMethod("getTextRuns", new Class[0]);     // Catch: Exception -> L24
        if (r6 == null) goto L26;
        r14 = r6.invoke(r13, new Object[0]);     // Catch: Exception -> L24
        goto L28
    L40:
        Class<?> r7 = r13.getClass();     // Catch: NoSuchMethodException -> L17
        if (r7 == null) goto L14;
        Method r8 = r7.getMethod("getText", new Class[0]);     // Catch: NoSuchMethodException -> L17
        if (r8 == null) goto L14;
        Object r9 = r8.invoke(r13, new Object[0]);     // Catch: NoSuchMethodException -> L17
        if (r9 == null) goto L14;
        String r10 = r9.toString();     // Catch: NoSuchMethodException -> L17
        if (r10 == null) goto L14;
        r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: NoSuchMethodException -> L17
        if (r3 != null) goto L15;
        goto L14
    }

    private static final CharSequence a(Object r5) {
        if (r5 == null) goto L13;
        Class<?> r1 = r5.getClass();
        if (r1 == null) goto L13;
        Method r2 = r1.getMethod("getRawText", new Class[0]);
        if (r2 == null) goto L13;
        Object r6 = r2.invoke(r5, new Object[0]);
        if (r6 == null) goto L13;
        String r7 = r6.toString();
        if (r7 == null) goto L13;
        Object r8 = ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
    L15:
        return (CharSequence) r8;
    L13:
        r8 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.memorydata.database.util.file_utils.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<com.obric.memorydata.database.util.file_utils.d>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.obric.memorydata.middleware.api.log.RunLog] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [com.obric.memorydata.database.util.file_utils.d] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v48, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.obric.memorydata.database.util.file_utils.m] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.io.Closeable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.obric.memorydata.database.util.file_utils.BasePptProcessor$process$1, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static /* synthetic */ Object a(d r13, FileEntity r14, Continuation<? super j> r15) {
        ?? r2 = d.class;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BasePptProcessor$process$1.class) == false) goto L7;
        BasePptProcessor$process$1 r5 = (BasePptProcessor$process$1) ZeusTransformUtils.preCheckCast(r3, BasePptProcessor$process$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
        ?? r6 = r5;
    L8:
        Object r4 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 == 0) goto L26;
        if (r8 == 1) goto L25;
        if (r8 == 2) goto L20;
        if (r8 != 3) goto L19;
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r6.L$2, Closeable.class, "com.obric.memorydata.plugin");
        r2 = (Closeable) ZeusTransformUtils.preCheckCast(r6.L$1, Closeable.class, "com.obric.memorydata.plugin");
        r6 = (String) ZeusTransformUtils.preCheckCast(r6.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L16
        r2 = r2;
        r6 = r6;
    L45:
        j r0 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L58
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L49
        ?? r9 = r6;
    L69:
        Object r10 = Result.m1421constructorimpl(r0);     // Catch: Throwable -> L23
        ?? r11 = r9;
    L74:
        ?? r12 = r11;
        Throwable r16 = Result.m1424exceptionOrNullimpl(r10);
        if (r16 == null) goto L98;
        if (ZeusTransformUtils.instanceOf(r16, NotOfficeXmlFileException.class) == false) goto L81;
        IRunLog r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder();
        String r19 = "File is not a valid Office XML file: ";
    L79:
        IRunLog.a.a(r17, r12, r18.append(r19).append(r16.getMessage()).toString(), null, 4, null);
    L94:
        if (AppContext.INSTANCE.isDebug() == false) goto L98;
        throw r16;
    L81:
        if (ZeusTransformUtils.instanceOf(r16, IllegalArgumentException.class) == false) goto L84;
        r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r19 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L79
    L84:
        if (ZeusTransformUtils.instanceOf(r16, RecordFormatException.class) == false) goto L87;
        RunLog.INSTANCE.warn(r12, "POI memory limit exceeded : " + r16.getMessage() + " (" + ExceptionsKt.stackTraceToString(r16) + ')', r16);
        goto L94
    L87:
        if (ZeusTransformUtils.instanceOf(r16, POIXMLException.class) == false) goto L90;
        r17 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r19 = "POI ZIP stream error (possibly closed): ";
        goto L79
    L90:
        if (ZeusTransformUtils.instanceOf(r16, OutOfMemoryError.class) == false) goto L92;
        RunLog.INSTANCE.error(r12, "OOM while use " + r12 + " parser. The file may be too large or corrupt.", r16);
        System.gc();
        return null;
    L92:
        RunLog.INSTANCE.error(r12, "File access failed", r16);
    L98:
        if (Result.m1427isFailureimpl(r10) == false) goto L101;
        return null;
    L101:
        return r10;
    L49:
        th = th;
        ?? r20 = r6;
    L73:
        Result.Companion r21 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        r11 = r20;
    L16:
        th = th;
    L17:
        Throwable r22 = th;
        throw r22;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        CloseableKt.closeFinally(r1, r22);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        String r23 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        FileEntity r24 = (FileEntity) ZeusTransformUtils.preCheckCast(r6.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        d r25 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L23
        r20 = r23;
        ?? r26 = r25;
    L35:
        UriFileAccessSession r27 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r27 == null) goto L68;
        AssetFileDescriptor r28 = r27.getFd();     // Catch: Throwable -> L23
        if (r28 == null) goto L68;
        ?? r29 = (Closeable) ZeusTransformUtils.preCheckCast(r28, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Closeable r30 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(((AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r29, AssetFileDescriptor.class, "com.obric.memorydata.plugin")).getFileDescriptor()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        FileInputStream r31 = (FileInputStream) ZeusTransformUtils.preCheckCast(r30, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        r6.L$0 = r20;     // Catch: Throwable -> L51
        r6.L$1 = r29;     // Catch: Throwable -> L51
        r6.L$2 = r30;     // Catch: Throwable -> L51
        r6.label = 3;     // Catch: Throwable -> L51
        Object r32 = r26.a(r31, r24, r6);     // Catch: Throwable -> L51
        if (r32 != r7) goto L44;
        return r7;
    L44:
        r6 = r20;
        r2 = r29;
        r1 = r30;
        r4 = r32;
    L51:
        th = th;
        r6 = r20;
        r2 = r29;
        r1 = r30;
    L61:
        th = th;
    L60:
        Throwable r33 = th;
        throw r33;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r29, r33);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L68:
        r0 = null;
        r9 = r20;
        goto L69
    L25:
        FileEntity r34 = (FileEntity) ZeusTransformUtils.preCheckCast(r6.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        d r35 = (d) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        FileEntity r36 = r34;
        ?? r37 = r35;
    L30:
        String r38 = r37.a();
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L71
        Continuation r40 = (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L71
        ?? r41 = m.f9660a;     // Catch: Throwable -> L71
        r6.L$0 = r37;     // Catch: Throwable -> L71
        r6.L$1 = r36;     // Catch: Throwable -> L71
        r6.L$2 = r38;     // Catch: Throwable -> L71
        r6.label = 2;     // Catch: Throwable -> L71
        r4 = r41.a(r36, r6);     // Catch: Throwable -> L71
        if (r4 != r7) goto L34;
        return r7;
    L34:
        r26 = r37;
        r24 = r36;
        r20 = r38;
    L71:
        th = th;
        r20 = r38;
        goto L73
    L26:
        ResultKt.throwOnFailure(r4);
        r6.L$0 = r13;
        r6.L$1 = r14;
        r6.label = 1;
        if (super.a(r14, r6) != r7) goto L29;
        return r7;
    L29:
        r37 = r13;
        r36 = r14;
    L58:
        th = th;
        r29 = r2;
        r20 = r6;
    L23:
        th = th;
    L7:
        r6 = new BasePptProcessor$process$1(r13, r3);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0120 -> B:49:0x0232). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x017a -> B:49:0x0232). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x019d -> B:49:0x0232). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x01b2 -> B:49:0x0232). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01c7 -> B:49:0x0232). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01fd -> B:47:0x0205). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x020e -> B:49:0x0232). Please report as a decompilation issue!!! */
    static /* synthetic */ Object a(d r17, Slide<?, ?> r18, j r19, int r20, FileEntity r21, Continuation<? super Unit> r22) {
        d r0 = r17;
        Slide r1 = (Slide) ZeusTransformUtils.wrapperContextForParams(r18, Slide.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BasePptProcessor$processSlideContent$1.class) == false) goto L7;
        BasePptProcessor$processSlideContent$1 r4 = (BasePptProcessor$processSlideContent$1) ZeusTransformUtils.preCheckCast(r3, BasePptProcessor$processSlideContent$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        int r8 = 10000;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r2 = r4.I$1;
        int r9 = r4.I$0;
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$3, Iterator.class, "com.obric.memorydata.plugin");
        FileEntity r11 = (FileEntity) ZeusTransformUtils.preCheckCast(r4.L$2, FileEntity.class, "com.obric.memorydata.plugin");
        j r12 = (j) ZeusTransformUtils.preCheckCast(r4.L$1, j.class, "com.obric.memorydata.plugin");
        d r13 = (d) ZeusTransformUtils.preCheckCast(r4.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L47:
        int r14 = r2;
        int r15 = r9;
        j r16 = r12;
        r0 = r13;
        Iterator r110 = r10;
        BasePptProcessor$processSlideContent$1 r23 = r4;
        FileEntity r24 = r11;
        Object r25 = r6;
    L49:
        int r26 = r14;
        r8 = 10000;
    L20:
        if (r110.hasNext() == false) goto L51;
        Object r111 = r110.next();
        r14 = r26 + 1;
        if (r26 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        Shape<?, ?> r112 = (Shape) ZeusTransformUtils.preCheckCast(r111, Shape.class, "com.obric.memorydata.plugin");
        int r113 = r0.c + 1;
        r0.c = r113;
        if (r113 <= r8) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r0.a(), "XML element limit reached", null, 4, null);
        goto L49
    L27:
        RunLog.INSTANCE.debug(r0.a(), "Processing shape " + r26 + " of type " + r112.getClass().getName());
        if (ZeusTransformUtils.instanceOf(r112, TextShape.class) == false) goto L31;
        r0.a((TextShape) ZeusTransformUtils.preCheckCast(r112, TextShape.class, "com.obric.memorydata.plugin"), r16, r15);
        goto L49
    L31:
        if (ZeusTransformUtils.instanceOf(r112, AutoShape.class) == false) goto L36;
        if (((AutoShape) ZeusTransformUtils.preCheckCast(r112, AutoShape.class, "com.obric.memorydata.plugin")).getTextParagraphs() == null) goto L36;
        r0.a((AutoShape) ZeusTransformUtils.preCheckCast(r112, AutoShape.class, "com.obric.memorydata.plugin"), r16, r15);
    L36:
        if (ZeusTransformUtils.instanceOf(r112, TableShape.class) == false) goto L39;
        r0.a((TableShape) ZeusTransformUtils.preCheckCast(r112, TableShape.class, "com.obric.memorydata.plugin"), r16, r15);
        goto L49
    L39:
        if (ZeusTransformUtils.instanceOf(r112, GroupShape.class) == false) goto L42;
        r0.a((GroupShape) ZeusTransformUtils.preCheckCast(r112, GroupShape.class, "com.obric.memorydata.plugin"), r16, r15);
        goto L49
    L42:
        if (ZeusTransformUtils.instanceOf(r112, PictureShape.class) == false) goto L48;
        r23.L$0 = r0;
        r23.L$1 = r16;
        r23.L$2 = r24;
        r23.L$3 = r110;
        r23.I$0 = r15;
        r23.I$1 = r14;
        r23.label = 1;
        if (r0.a(r112, r16, r15, r24, r23) != r25) goto L46;
        return r25;
    L46:
        r13 = r0;
        r6 = r25;
        r2 = r14;
        r11 = r24;
        r4 = r23;
        r10 = r110;
        r12 = r16;
        r9 = r15;
        goto L47
    L48:
        RunLog.INSTANCE.debug(r0.a(), "Unhandled shape type: " + r112.getClass().getName());
        goto L49
    L51:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (r0.c <= 10000) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r17.a(), "XML element limit reached, skipping remaining shapes", null, 4, null);
        return Unit.INSTANCE;
    L18:
        RunLog.INSTANCE.debug(r17.a(), "Processing slide content, shape count: " + r1.getShapes().size());
        List r27 = r1.getShapes();
        Intrinsics.checkNotNullExpressionValue(r27, "getShapes(...)");
        r110 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin"), 50), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        r23 = r4;
        r25 = r6;
        r16 = r19;
        r24 = r21;
        r26 = 0;
        r15 = r20;
    L7:
        r4 = new BasePptProcessor$processSlideContent$1(r0, r3);
        goto L8
    }

    public static final /* synthetic */ Object a(d r2, Slide r3, j r4, FileEntity r5, Continuation r6) {
        return r2.a((Slide) ZeusTransformUtils.wrapperContextForParams(r3, Slide.class, "com.obric.memorydata.plugin"), r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Slide<?, ?> r19, j r20, FileEntity r21, Continuation<? super Unit> r22) {
        d r6 = this;
        Slide<?, ?> r8 = (Slide) ZeusTransformUtils.wrapperContextForParams(r19, Slide.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, BasePptProcessor$processSlide$1.class) == false) goto L7;
        BasePptProcessor$processSlide$1 r1 = (BasePptProcessor$processSlide$1) ZeusTransformUtils.preCheckCast(r0, BasePptProcessor$processSlide$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        BasePptProcessor$processSlide$1 r5 = r1;
        Object r2 = r5.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        r8 = (Slide) ZeusTransformUtils.preCheckCast(r5.L$1, Slide.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.preCheckCast(r5.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: NoClassDefFoundError -> L14
    L33:
        return Unit.INSTANCE;
    L14:
        r6 = r4;
    L31:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r6.a(), "Slide " + r8.getSlideNumber() + ": contains unsupported graphics.", null, 4, null);
        goto L33
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r2);
        h r7 = j.a(r20, NodeType.TITLE, "Slide " + r8.getSlideNumber(), 2, null, 8, null);
        String r10 = null;
        String r11 = r8.getTitle();     // Catch: NoClassDefFoundError -> L24
        if (r11 == null) goto L25;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        r10 = r11;
    L25:
        if (r10 == null) goto L39;
        r20.a(NodeType.TITLE, r10, 3, Boxing.boxInt(r7.a()));
    L39:
        int r12 = r7.a();     // Catch: NoClassDefFoundError -> L34
        r5.L$0 = r6;     // Catch: NoClassDefFoundError -> L34
        r5.L$1 = r8;     // Catch: NoClassDefFoundError -> L34
        r5.label = 1;     // Catch: NoClassDefFoundError -> L34
        if (a(r8, r20, r12, r21, r5) != r9) goto L33;
        return r9;
    L24:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), a(), "Slide " + r8.getSlideNumber() + ": Title contains graphics that are not currently supported", null, 4, null);
    L7:
        r1 = new BasePptProcessor$processSlide$1(r6, r0);
        goto L8
    }

    private final void a(AutoShape<?, ?> r10, j r11, int r12) {
        String r4 = a((Shape) ZeusTransformUtils.preCheckCast((AutoShape) ZeusTransformUtils.wrapperContextForParams(r10, AutoShape.class, "com.obric.memorydata.plugin"), Shape.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        j.a(r11, NodeType.PARAGRAPH, r4, 0, Integer.valueOf(r12), 4, null);
        return;
    }

    private final void a(TextShape<?, ?> r10, j r11, int r12) {
        String r4 = a((Shape) ZeusTransformUtils.preCheckCast((TextShape) ZeusTransformUtils.wrapperContextForParams(r10, TextShape.class, "com.obric.memorydata.plugin"), Shape.class, "com.obric.memorydata.plugin"));
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        j.a(r11, NodeType.PARAGRAPH, r4, 0, Integer.valueOf(r12), 4, null);
        return;
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("---", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(Shape<?, ?> r13) {
        Shape r14 = (Shape) ZeusTransformUtils.wrapperContextForParams(r13, Shape.class, "com.obric.memorydata.plugin");
        Object r15 = r14.getClass().getMethod("getTextParagraphs", new Class[0]).invoke(r14, new Object[0]);     // Catch: Exception -> L11
        if (ZeusTransformUtils.instanceOf(r15, List.class) == false) goto L6;
        List r16 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
    L7:
        if (r16 != null) goto L9;
        return "";
    L9:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$d$F3Ku84eT3rgFL2ME5Nf6j1TiRU(this), 30, null);
    L6:
        r16 = null;
    L11:
        e = move-exception;
        RunLog.INSTANCE.error(a(), "AutoShape text extraction failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    public static /* synthetic */ CharSequence lambda$CuG9ZlHFrwEKrXiOjPbod7ZPPpU(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$F3Ku84eT3rgFL2ME5N-f6j1TiRU, reason: not valid java name */
    public static /* synthetic */ CharSequence m578lambda$F3Ku84eT3rgFL2ME5Nf6j1TiRU(d r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$d6eNP28DQ3lj84_n1EjgpHw9S0I(Object r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.database.util.file_utils.b, com.obric.memorydata.database.util.file_utils.o
    public Object a(FileEntity r3, Continuation<? super j> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.obric.capabilitykit.entity.app.FileEntity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.memorydata.database.util.file_utils.BasePptProcessor$fromStream$1] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.obric.memorydata.database.util.file_utils.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.obric.memorydata.database.util.file_utils.d] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.obric.capabilitykit.entity.app.FileEntity] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.memorydata.database.util.file_utils.BasePptProcessor$fromStream$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f3 -> B:30:0x00fa). Please report as a decompilation issue!!! */
    public final Object a(FileInputStream r10, FileEntity r11, Continuation<? super j> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, BasePptProcessor$fromStream$1.class) == false) goto L7;
        BasePptProcessor$fromStream$1 r0 = (BasePptProcessor$fromStream$1) ZeusTransformUtils.preCheckCast(r13, BasePptProcessor$fromStream$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
        ?? r1 = r0;
    L8:
        Object r14 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r1.L$4, Iterator.class, "com.obric.memorydata.plugin");
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r1.L$3, Closeable.class, "com.obric.memorydata.plugin");
        j r16 = (j) ZeusTransformUtils.preCheckCast(r1.L$2, j.class, "com.obric.memorydata.plugin");
        FileEntity r4 = (FileEntity) ZeusTransformUtils.preCheckCast(r1.L$1, FileEntity.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.preCheckCast(r1.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        ?? r5 = r1;
        ?? r7 = r4;
        ?? r8 = r6;
    L30:
        j r17 = r16;
        Closeable r18 = r15;
        r10 = r8;
        Object r19 = r2;
        ?? r20 = r5;
        r1 = r7;
        Object r21 = r19;
    L57:
    L36:
        Throwable th = th;
    L52:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);     // Catch: OutOfMemoryError -> L44
        throw th;     // Catch: OutOfMemoryError -> L44
    L23:
        if (r9.hasNext() == false) goto L31;
        Slide r22 = (Slide) ZeusTransformUtils.preCheckCast(r9.next(), Slide.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L36
        if (r10.a(r22) == true) goto L57;
        r20.L$0 = r10;     // Catch: Throwable -> L36
        r20.L$1 = r1;     // Catch: Throwable -> L36
        r20.L$2 = r17;     // Catch: Throwable -> L36
        r20.L$3 = r18;     // Catch: Throwable -> L36
        r20.L$4 = r9;     // Catch: Throwable -> L36
        r20.label = 1;     // Catch: Throwable -> L36
        if (r10.a(r22, r17, r1, r20) != r21) goto L29;
        return r21;
    L29:
        r8 = r10;
        r15 = r18;
        r16 = r17;
        Object r23 = r21;
        r7 = r1;
        r5 = r20;
        r2 = r23;
        goto L30
    L31:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r18, null);     // Catch: OutOfMemoryError -> L44
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17.c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L66;
        return null;
    L66:
        return r17;
    L14:
        th = th;
        r18 = r15;
        r1 = r4;
        r10 = r6;
        goto L52
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r17 = new j();
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(a(r10), Closeable.class, "com.obric.memorydata.plugin");     // Catch: OutOfMemoryError -> L46
        List r25 = ((SlideShow) ZeusTransformUtils.preCheckCast(r110, SlideShow.class, "com.obric.memorydata.plugin")).getSlides();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r25, "getSlides(...)");     // Catch: Throwable -> L38
        r10 = this;
        r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), 20), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L38
        r21 = r2;
        r20 = r1;
        r1 = r11;
        r18 = r110;
    L38:
        th = move-exception;
        r1 = r11;
        r18 = r110;
        r10 = this;
        th = th;
    L46:
        e = move-exception;
        ?? r111 = this;
        e = e;
        ?? r112 = r11;
    L48:
        RunLog.INSTANCE.error(r111.a(), "OOM while opening presentation " + com.obric.memorydata.utils.q.f13259a.b(r112.getFileName()) + ". The file may be too large or corrupt.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        System.gc();
        return null;
    L44:
        e = e;
        r112 = r1;
        r111 = r10;
    L7:
        r1 = new BasePptProcessor$fromStream$1(this, r13);
        goto L8
    }

    public abstract Object a(Shape<?, ?> r1, j r2, int r3, FileEntity r4, Continuation<? super Unit> r5);

    public Object a(Slide<?, ?> r9, j r10, int r11, FileEntity r12, Continuation<? super Unit> r13) {
        return a(this, (Slide) ZeusTransformUtils.wrapperContextForParams(r9, Slide.class, "com.obric.memorydata.plugin"), r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.util.file_utils.b
    public abstract String a();

    public final String a(PictureData r2) {
        PictureData r1 = (PictureData) ZeusTransformUtils.wrapperContextForParams(r2, PictureData.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "pictureData");
        PictureData.PictureType r3 = r1.getType();
        if (r3 != null) goto L5;
        int r4 = -1;
    L6:
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L7:
        String r5 = r3.extension;
        Intrinsics.checkNotNullExpressionValue(r5, "extension");
        return com.obric.memorydata.utils.b.a(r5, 1);
    L8:
        return "bmp";
    L9:
        return "gif";
    L10:
        return "emf";
    L11:
        return "wmf";
    L12:
        return "jpg";
    L13:
        return "png";
    L5:
        r4 = b.f9642a[r3.ordinal()];
        goto L6
    }

    public String a(Shape<?, ?> r9) {
        Shape<?, ?> r10 = (Shape) ZeusTransformUtils.wrapperContextForParams(r9, Shape.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "shape");
        if (ZeusTransformUtils.instanceOf(r10, XSLFTextShape.class) == false) goto L10;
        String r11 = ((XSLFTextShape) ZeusTransformUtils.preCheckCast(r10, XSLFTextShape.class, "com.obric.memorydata.plugin")).getText();
        if (r11 == null) goto L8;
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r12 == null) goto L8;
    L32:
        if (a(r12) == false) goto L35;
        r12 = null;
    L35:
        if (r12 != null) goto L38;
        return "";
    L38:
        return r12;
    L8:
        r12 = "";
        goto L32
    L10:
        if (ZeusTransformUtils.instanceOf(r10, HSLFTextShape.class) == false) goto L17;
        String r13 = ((HSLFTextShape) ZeusTransformUtils.preCheckCast(r10, HSLFTextShape.class, "com.obric.memorydata.plugin")).getText();
        if (r13 == null) goto L8;
        r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r12 != null) goto L32;
    L17:
        if (ZeusTransformUtils.instanceOf(r10, TextShape.class) == false) goto L23;
        String r14 = ((TextShape) ZeusTransformUtils.preCheckCast(r10, TextShape.class, "com.obric.memorydata.plugin")).getText();
        if (r14 == null) goto L8;
        r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r12 != null) goto L32;
    L23:
        Class<?>[] r0 = r10.getClass().getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r0, "getInterfaces(...)");
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.memorydata.plugin");
        int r3 = r1.length;
        boolean r4 = false;
        int r5 = 0;
    L24:
        if (r5 >= r3) goto L29;
        if (Intrinsics.areEqual((Class) ZeusTransformUtils.preCheckCast(r1[r5], Class.class, "com.obric.memorydata.plugin"), AutoShape.class) == true) goto L27;
        r5 = r5 + 1;
        goto L24
    L27:
        r4 = true;
    L29:
        if (r4 == false) goto L8;
        r12 = b(r10);
        goto L32
    }

    public abstract SlideShow<?, ?> a(FileInputStream r1);

    public void a(GroupShape<?, ?> r10, j r11, int r12) {
        GroupShape r13 = (GroupShape) ZeusTransformUtils.wrapperContextForParams(r10, GroupShape.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "group");
        Intrinsics.checkNotNullParameter(r11, "tree");
        h r14 = j.a(r11, NodeType.VIRTUAL, "Group Shape", 0, Integer.valueOf(r12), 4, null);
        Collection r15 = r13.getShapes();
        Intrinsics.checkNotNullExpressionValue(r15, "getShapes(...)");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L16;
        Shape r0 = (Shape) ZeusTransformUtils.preCheckCast(r16.next(), Shape.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, TextShape.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r0, AutoShape.class) == false) goto L14;
        if (((AutoShape) ZeusTransformUtils.preCheckCast(r0, AutoShape.class, "com.obric.memorydata.plugin")).getTextParagraphs() == null) goto L14;
        a((AutoShape) ZeusTransformUtils.preCheckCast(r0, AutoShape.class, "com.obric.memorydata.plugin"), r11, r14.a());
    L14:
        if (ZeusTransformUtils.instanceOf(r0, TableShape.class) == false) goto L4;
        a((TableShape) ZeusTransformUtils.preCheckCast(r0, TableShape.class, "com.obric.memorydata.plugin"), r11, r14.a());
        goto L4
    L7:
        a((TextShape) ZeusTransformUtils.preCheckCast(r0, TextShape.class, "com.obric.memorydata.plugin"), r11, r14.a());
        goto L4
    }

    public void a(TableShape<?, ?> r26, j r27, int r28) {
        TableShape r0 = (TableShape) ZeusTransformUtils.wrapperContextForParams(r26, TableShape.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "table");
        Intrinsics.checkNotNullParameter(r27, "tree");
        h r2 = j.a(r27, NodeType.VIRTUAL, "Table (" + r0.getNumberOfRows() + 'x' + r0.getNumberOfColumns() + ')', 0, Integer.valueOf(r28), 4, null);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.getNumberOfColumns()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L3:
        String r13 = "";
        if (r5.hasNext() == false) goto L14;
        TableCell r6 = r0.getCell(0, ((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r6 == null) goto L13;
        String r7 = r6.getText();
        if (r7 == null) goto L13;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L13;
        r13 = r8;
    L13:
        r4.add(r13);
        goto L3
    L14:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        j.a(r27, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), 0, Integer.valueOf(r2.a()), 4, null);
        j.a(r27, NodeType.TABLE_HEADER, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$d$CuG9ZlHFrwEKrXiOjPbod7ZPPpU.INSTANCE, 24, null), 0, Integer.valueOf(r2.a()), 4, null);
        int r15 = r0.getNumberOfRows();
        int r9 = 1;
    L15:
        if (r9 >= r15) goto L28;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.getNumberOfColumns()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L18:
        if (r12.hasNext() == false) goto L27;
        TableCell r16 = r0.getCell(r9, ((IntIterator) ZeusTransformUtils.preCheckCast(r12, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r16 == null) goto L25;
        String r17 = r16.getText();
        if (r17 == null) goto L25;
        String r18 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r18 == null) goto L25;
    L26:
        r11.add(r18);
    L25:
        r18 = "";
        goto L26
    L27:
        j.a(r27, NodeType.TABLE_ROW, CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" | ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("| ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" |", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), 0, Integer.valueOf(r2.a()), 4, null);
        r9 = r9 + 1;
        goto L15
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, " ") == true) goto L12;
        if (Intrinsics.areEqual(r2, "\u200b") == true) goto L12;
        if (Intrinsics.areEqual(r2, "\ufeff") == true) goto L12;
        return false;
    }

    public boolean a(Slide<?, ?> r2) {
        Intrinsics.checkNotNullParameter((Slide) ZeusTransformUtils.wrapperContextForParams(r2, Slide.class, "com.obric.memorydata.plugin"), "slide");
        return false;
    }
}
