package com.obric.aikernel.res.metadata.config;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u000b\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"getBoolOrNull", "", "Lcom/google/gson/JsonObject;", ActivityLifecycle.NAME, "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getIntOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "getLongOrNull", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "getString", "getStringOrNull", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final String a(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        String r3 = r1.get(r2).getAsString();
        Intrinsics.checkNotNullExpressionValue(r3, "get(name).asString");
        return r3;
    }

    public static final String b(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        if (r1.has(r2) == true) goto L7;
        return null;
    L7:
        return r1.get(r2).getAsString();
    }

    public static final Integer c(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        if (r1.has(r2) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(r1.get(r2).getAsInt());
    }

    public static final Long d(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        if (r1.has(r2) == true) goto L7;
        return null;
    L7:
        return Long.valueOf(r1.get(r2).getAsLong());
    }

    public static final Boolean e(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        if (r1.has(r2) == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r1.get(r2).getAsBoolean());
    }
}
