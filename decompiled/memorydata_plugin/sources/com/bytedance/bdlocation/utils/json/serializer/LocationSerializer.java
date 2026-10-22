package com.bytedance.bdlocation.utils.json.serializer;

import android.location.Location;
import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationSerializer implements JsonSerializer<Location> {
    public LocationSerializer() {
    }

    /* JADX INFO: renamed from: serialize, reason: avoid collision after fix types in other method */
    public JsonElement serialize2(Location r4, Type r5, JsonSerializationContext r6) {
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r8 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r6, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        JsonObject r9 = new JsonObject();
        r9.addProperty("mProvider", r4.getProvider());     // Catch: Exception -> L16
        r9.addProperty("mAccuracy", Float.valueOf(r4.getAccuracy()));     // Catch: Exception -> L16
        r9.addProperty("mAltitude", Double.valueOf(r4.getAltitude()));     // Catch: Exception -> L16
        r9.addProperty("mBearing", Float.valueOf(r4.getBearing()));     // Catch: Exception -> L16
        if (Build.VERSION.SDK_INT < 26) goto L7;
        r9.addProperty("mBearingAccuracyDegrees", Float.valueOf(r4.getBearingAccuracyDegrees()));     // Catch: Exception -> L16
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L9;
        r9.addProperty("mElapsedRealtimeNanos", Long.valueOf(r4.getElapsedRealtimeNanos()));     // Catch: Exception -> L16
    L9:
        r9.addProperty("mLatitude", Double.valueOf(r4.getLatitude()));     // Catch: Exception -> L16
        r9.addProperty("mLongitude", Double.valueOf(r4.getLongitude()));     // Catch: Exception -> L16
        r9.addProperty("mProvider", r4.getProvider());     // Catch: Exception -> L16
        r9.addProperty("mSpeed", Float.valueOf(r4.getSpeed()));     // Catch: Exception -> L16
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r9.addProperty("mSpeedAccuracyMetersPerSecond", Float.valueOf(r4.getSpeedAccuracyMetersPerSecond()));     // Catch: Exception -> L16
    L12:
        r9.addProperty("mTime", Long.valueOf(r4.getTime()));     // Catch: Exception -> L16
        if (Build.VERSION.SDK_INT < 26) goto L18;
        r9.addProperty("mVerticalAccuracyMeters", Float.valueOf(r4.getVerticalAccuracyMeters()));     // Catch: Exception -> L16
    L18:
        return r9;
    L16:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L18
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(Location r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        return serialize2((Location) ZeusTransformUtils.preCheckCast(r3, Location.class, "com.obric.memorydata.plugin"), r6, r7);
    }
}
