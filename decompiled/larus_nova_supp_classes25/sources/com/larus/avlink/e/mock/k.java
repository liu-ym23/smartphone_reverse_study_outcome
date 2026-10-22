package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer a(String r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r4, "callbackType");
        Intrinsics.checkNotNullParameter(r5, "args");
        switch(r4.hashCode()) {
            case -417316668: goto L37;
            case -103534882: goto L34;
            case -57227364: goto L26;
            case 637830808: goto L18;
            case 1736788534: goto L15;
            case 1975921694: goto L6;
            default: goto L45;
        };
    L45:
        FLogger.a.w("ImageUuidExtractor", "Unknown callback type for imageUuid extraction: ".concat(r4));
        return null;
    L6:
        if (r4.equals("onCameraCompleteImage") == false) goto L45;
        Object r6 = ArraysKt.getOrNull(r5, 0);
        if ((r6 instanceof b49.h) == false) goto L11;
        b49.h r7 = (b49.h) r6;
    L12:
        if (r7 != null) goto L48;
        return null;
    L48:
        return Integer.valueOf(r7.a);
    L11:
        r7 = null;
        goto L12
    L15:
        if (r4.equals("onRtosQueryTrackInfo") == false) goto L45;
        return null;
    L18:
        if (r4.equals("onImageOcrStateUpdate") == false) goto L45;
        if (r5.length <= 1) goto L50;
        Object r8 = r5[1];
        if ((r8 instanceof Integer) == true) goto L52;
        return null;
    L52:
        return (Integer) r8;
    L50:
        return null;
    L26:
        if (r4.equals("onTakeImageState") == false) goto L45;
        if (r5.length <= 1) goto L53;
        Object r9 = r5[1];
        if ((r9 instanceof Integer) == true) goto L55;
        return null;
    L55:
        return (Integer) r9;
    L53:
        return null;
    L34:
        if (r4.equals("onTakeImageHotWordIDReceived") == false) goto L45;
        return null;
    L37:
        if (r4.equals("onDataFrame") == false) goto L45;
        Object r10 = ArraysKt.getOrNull(r5, 0);
        if ((r10 instanceof b49.g) == false) goto L42;
        b49.g r11 = (b49.g) r10;
    L43:
        if (r11 != null) goto L58;
        return null;
    L58:
        return Integer.valueOf(r11.h);
    L42:
        r11 = null;
        goto L43
    }
}
