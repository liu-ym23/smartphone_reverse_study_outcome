package com.bytedance.bdlocation.utils.json.deserializer;

import android.location.Location;
import android.os.Build;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class LocationDeserializer implements JsonDeserializer<Location> {
    public LocationDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Location deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r7 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r6, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        JsonObject r8 = r4.getAsJsonObject();
        Location r9 = new Location(r8.getAsJsonPrimitive("mProvider").getAsString());
        r9.setAccuracy(r8.getAsJsonPrimitive("mAccuracy").getAsFloat());
        r9.setAltitude(r8.getAsJsonPrimitive("mAltitude").getAsFloat());
        r9.setBearing(r8.getAsJsonPrimitive("mBearing").getAsFloat());
        if (Build.VERSION.SDK_INT < 26) goto L6;
        r9.setBearingAccuracyDegrees(r8.getAsJsonPrimitive("mBearingAccuracyDegrees").getAsFloat());
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        r9.setElapsedRealtimeNanos(r8.getAsJsonPrimitive("mElapsedRealtimeNanos").getAsLong());
    L8:
        r9.setLatitude(r8.getAsJsonPrimitive("mLatitude").getAsDouble());
        r9.setLongitude(r8.getAsJsonPrimitive("mLongitude").getAsDouble());
        r9.setProvider(r8.getAsJsonPrimitive("mProvider").getAsString());
        r9.setSpeed(r8.getAsJsonPrimitive("mSpeed").getAsFloat());
        if (Build.VERSION.SDK_INT < 26) goto L11;
        r9.setSpeedAccuracyMetersPerSecond(r8.getAsJsonPrimitive("mSpeedAccuracyMetersPerSecond").getAsFloat());
    L11:
        r9.setTime(r8.getAsJsonPrimitive("mTime").getAsLong());
        if (Build.VERSION.SDK_INT < 26) goto L14;
        r9.setVerticalAccuracyMeters(r8.getAsJsonPrimitive("mVerticalAccuracyMeters").getAsFloat());
    L14:
        return r9;
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ Location deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
