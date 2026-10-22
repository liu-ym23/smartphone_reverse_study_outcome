package com.obric.memorydata.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.JSONArraySerializer;
import defpackage.JSONObjectSerializer;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\n\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u0001H\b\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\tH\u0086\b¢\u0006\u0002\u0010\n\u001a\u001d\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\r\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\tH\u0086\b\u001a\n\u0010\u000e\u001a\u00020\t*\u00020\u000f\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {GsonUtil.TAG, "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGSON", "()Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "toObj", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/String;)Ljava/lang/Object;", "toObjByType", "toListObj", "", "toJsonString", "", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f13265a = null;

    static {
        f13265a = LazyKt.lazy($$Lambda$u$a5ORWFVyhMMja8x7pM2zX2Z9c.INSTANCE);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f13265a.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    public static final String a(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = a().toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "toJson(...)");
        return r2;
    }

    private static final Gson b() {
        GsonBuilder r0 = new GsonBuilder();
        r0.registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(JSONObject.class, Type.class, "com.obric.memorydata.plugin"), new JSONObjectSerializer());
        r0.registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(JSONArray.class, Type.class, "com.obric.memorydata.plugin"), new JSONArraySerializer());
        return r0.create();
    }

    /* JADX INFO: renamed from: lambda$a5ORWFVyhMMja8x7pM2zX-2Z9-c, reason: not valid java name */
    public static /* synthetic */ Gson m1252lambda$a5ORWFVyhMMja8x7pM2zX2Z9c() {
        return b();
    }
}
