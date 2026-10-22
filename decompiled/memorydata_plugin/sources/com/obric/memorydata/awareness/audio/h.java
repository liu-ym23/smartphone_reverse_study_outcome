package com.obric.memorydata.awareness.audio;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0000¢\u0006\u0002\u0010\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000¨\u0006\u000e"}, d2 = {"wavStep", ExifInterface.GPS_DIRECTION_TRUE, "stage", "", "segmentIndex", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requireWav", "", "valid", "", InfoRequestQPSOptTraceLogger.REASON, "awareness_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(String r5, int r6, Function0<? extends T> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "stage");
        Intrinsics.checkNotNullParameter(r8, "block");
        return (T) r8.invoke();
    L18:
        e = move-exception;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(e.getStage(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (r0.length() != 0) goto L22;
        boolean r2 = true;
    L23:
        if (r2 == true) goto L26;
        r5 = r0;
    L26:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        Integer r1 = Integer.valueOf(e.getSegmentIndex());
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() >= 0) goto L30;
        r3 = false;
    L30:
        if (r3 == true) goto L33;
        r1 = null;
    L33:
        if (r1 == null) goto L36;
        r6 = r1.intValue();
    L36:
        throw new WavPreparationFailure(r9, r6, e.getReason(), (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin"));
    L22:
        r2 = false;
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SecurityException.class) == false) goto L9;
        String r4 = "ACCESS_DENIED";
    L17:
        throw new WavPreparationFailure(r5, r6, r4, e);
    L9:
        if (ZeusTransformUtils.instanceOf(e, IOException.class) == false) goto L11;
        r4 = "IO_FAILED";
        goto L17
    L11:
        if (ZeusTransformUtils.instanceOf(e, IllegalArgumentException.class) == false) goto L13;
        r4 = "INVALID_INPUT";
        goto L17
    L13:
        r4 = "OPERATION_FAILED";
        goto L17
    }

    public static /* synthetic */ Object a(String r1, int r2, Function0 r3, int r4, Object r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        return a(r1, r2, r6);
    }

    public static final void a(boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, InfoRequestQPSOptTraceLogger.REASON);
        if (r8 == false) goto L6;
        return;
    L6:
        throw new WavPreparationFailure("", -1, r9, null, 8, null);
    }
}
