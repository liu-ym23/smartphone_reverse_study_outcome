package com.obric.memorydata.database.util.file_utils;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0006\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052 \b\u0004\u0010\u0007\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0086H¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"withFileErrorHandling", ExifInterface.GPS_DIRECTION_TRUE, "fileTypeTag", "", "preCheck", "Lkotlin/Function0;", "", "processBlock", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class p {
    public static final <T> Object a(String r8, Function0<Boolean> r9, Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, IFileProcessorKt$withFileErrorHandling$1.class) == false) goto L7;
        IFileProcessorKt$withFileErrorHandling$1 r0 = (IFileProcessorKt$withFileErrorHandling$1) ZeusTransformUtils.preCheckCast(r14, IFileProcessorKt$withFileErrorHandling$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r8 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L25
    L22:
        Object r16 = Result.m1421constructorimpl(r15);     // Catch: Throwable -> L25
    L27:
        String r4 = r8;
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L52;
        if (ZeusTransformUtils.instanceOf(r17, NotOfficeXmlFileException.class) == false) goto L34;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r18 = new StringBuilder();
        String r1 = "File is not a valid Office XML file: ";
    L32:
        IRunLog.a.a(r5, r4, r18.append(r1).append(r17.getMessage()).toString(), null, 4, null);
    L48:
        if (AppContext.INSTANCE.isDebug() == false) goto L52;
        throw r17;
    L34:
        if (ZeusTransformUtils.instanceOf(r17, IllegalArgumentException.class) == false) goto L37;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r1 = "Doubao Assistant is not started, unable to obtain permission: ";
        goto L32
    L37:
        if (ZeusTransformUtils.instanceOf(r17, RecordFormatException.class) == false) goto L40;
        RunLog.INSTANCE.warn(r4, "POI memory limit exceeded : " + r17.getMessage() + " (" + ExceptionsKt.stackTraceToString(r17) + ')', r17);
        goto L48
    L40:
        if (ZeusTransformUtils.instanceOf(r17, POIXMLException.class) == false) goto L43;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r18 = new StringBuilder();
        r1 = "POI ZIP stream error (possibly closed): ";
        goto L32
    L43:
        if (ZeusTransformUtils.instanceOf(r17, OutOfMemoryError.class) == false) goto L46;
        RunLog.INSTANCE.error(r4, "OOM while use " + r4 + " parser. The file may be too large or corrupt.", r17);
        System.gc();
        return null;
    L46:
        RunLog.INSTANCE.error(r4, "File access failed", r17);
    L52:
        if (Result.m1427isFailureimpl(r16) == true) goto L54;
        return r16;
    L54:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L25
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        r0.L$0 = r8;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        r15 = r13.invoke(r0);     // Catch: Throwable -> L25
        if (r15 != r2) goto L22;
        return r2;
    L24:
        throw new RuntimeException(r8 + " pre-check failed!");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new IFileProcessorKt$withFileErrorHandling$1(r14);
        goto L8
    }
}
