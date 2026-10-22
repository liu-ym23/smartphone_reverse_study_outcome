package com.obric.memorydata.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b\u001a\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0001\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, d2 = {"TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "fromJsonArray", "", ExifInterface.GPS_DIRECTION_TRUE, "data", "type", "Ljava/lang/Class;", "toBundle", "Landroid/os/Bundle;", "Lorg/json/JSONObject;", "jsonElement", "Lcom/google/gson/JsonElement;", "parseJson", "Lcom/google/gson/JsonObject;", "getFirstCodeBlockContentFromMarkdownString", "markdownString", "getJsonArrayFromString", "str", "optStringOrNull", "key", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f13155a = null;

    static {
        f13155a = new Gson();
    }

    public static final Gson a() {
        return f13155a;
    }

    public static final JsonObject a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("JsonUtils", "parseJson exception:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return new JsonObject();
    }

    public static final <T> List<T> a(JsonElement r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "jsonElement");
        Intrinsics.checkNotNullParameter(r5, "type");
        ArrayList r1 = new ArrayList();
    L10:
        e = move-exception;
        RunLog.INSTANCE.error("JsonUtils", "fromJsonArray exception:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L4:
        if (r4.isJsonArray() == false) goto L13;
        JsonArray r6 = r4.getAsJsonArray();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r6, "getAsJsonArray(...)");     // Catch: Exception -> L10
        Iterator<T> r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L10
    L7:
        if (r7.hasNext() == false) goto L13;
        JsonElement r2 = (JsonElement) ZeusTransformUtils.preCheckCast(r7.next(), JsonElement.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        r1.add(f13155a.fromJson(r2, r5));     // Catch: Exception -> L10
        goto L7
    }
}
