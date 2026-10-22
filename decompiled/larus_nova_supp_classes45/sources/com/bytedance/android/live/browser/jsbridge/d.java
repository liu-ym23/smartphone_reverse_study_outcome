package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        if (StringsKt.startsWith$default(r4, "Open", false, 2, null) == false) goto L5;
        return r4;
    L5:
        return "Open" + r4;
    }

    public static String b(String r8) {
        if (r8 != null) goto L6;
        return "";
    L6:
        if (StringsKt.startsWith$default(r8, "WebcastOpen", false, 2, null) == false) goto L8;
        return r8;
    L8:
        if (StringsKt.startsWith$default(r8, "WebcastContentOpen", false, 2, null) == true) goto L12;
        ALogger.d("aggressive_fuse_message", "insert Open after Webcast prefix for " + r8 + " before callback");
        return StringsKt.replace$default(r8, "Webcast", "WebcastOpen", false, 4, null);
    L12:
        return r8;
    }

    public static void d(JsonObject r5) {
        Iterator r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) r0.next();
        JsonObject r2 = r5.get(r1);
        String r3 = GsonHelper.mappingFieldName(Object.class, r1);
        if ((!Intrinsics.areEqual(r3, r1)) == false) goto L9;
        r5.remove(r1);
        r5.add(r3, r2);
    L9:
        if ((r2 instanceof JsonObject) == false) goto L4;
        d(r2);
        goto L4
    }

    public static void c(JsonObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Intrinsics.checkNotNullParameter(r3, "method");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        r2.get("common").getAsJsonObject().addProperty("method", r3);     // Catch: Throwable -> L5
        d(r2);     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        StringBuilder r5 = new StringBuilder("modify json, success: ");
        r5.append(Result.isSuccess-impl(r4));
        r5.append(", error: ");
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L10;
        String r7 = r6.getMessage();
    L11:
        r5.append(r7);
        ALogger.d("aggressive_fuse_message", r5.toString());
        return;
    L10:
        r7 = null;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
