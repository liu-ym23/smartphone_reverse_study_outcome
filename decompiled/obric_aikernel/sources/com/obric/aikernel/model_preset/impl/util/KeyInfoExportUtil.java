package com.obric.aikernel.model_preset.impl.util;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyInfoExportUtil {
    public static final KeyInfoExportUtil INSTANCE = null;
    private static final String TAG = "KeyInfoExportUtil";

    static {
        INSTANCE = new KeyInfoExportUtil();
    }

    private KeyInfoExportUtil() {
    }

    public final Map<String, String> exportKeyInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "keyInfoText");
        LinkedHashMap r12 = new LinkedHashMap();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r14 = new JSONObject(r11).optJSONObject(r10);     // Catch: Throwable -> L18
        if (r14 == null) goto L15;
        Iterator<String> r15 = r14.keys();     // Catch: Throwable -> L18
        if (r15 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r15, "keys()");     // Catch: Throwable -> L18
    L9:
        if (r15.hasNext() == false) goto L14;
        String r16 = r15.next();     // Catch: Throwable -> L18
        Intrinsics.checkNotNullExpressionValue(r16, "fileName");     // Catch: Throwable -> L18
        String r17 = r14.optString(r16);     // Catch: Throwable -> L18
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        r12.put(r16, r17);     // Catch: Throwable -> L18
        goto L9
    L14:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r19 = Result.m32constructorimpl(r18);     // Catch: Throwable -> L18
    L20:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);
        if (r20 == null) goto L23;
        AIKLog.INSTANCE.w(TAG, "exportKeyInfo failed: " + r20.getMessage(), r20);
    L23:
        return r12;
    L15:
        r18 = null;
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
