package com.larus.dora.obric.device_management.explore;

import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResourceDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImageResource;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DoraObricGlassesImageResourceDeserializer implements JsonDeserializer<DoraObricGlassesImageResource> {
    public DoraObricGlassesImageResourceDeserializer() {
    }

    public final Object deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "typeOfT");
        Intrinsics.checkNotNullParameter(r5, "context");
        JsonObject r6 = r3.getAsJsonObject();
        JsonElement r7 = r6.get("url");
        String r0 = null;
        if (r7 == null) goto L12;
        String r8 = r7.getAsString();
        if (r8 == null) goto L12;
        if ((!StringsKt.isBlank(r8)) == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L12;
        return new DoraObricGlassesImageResource.RemoteUrl(r8);
    L12:
        JsonElement r9 = r6.get("resId");
        if (r9 == null) goto L23;
        Integer r10 = Integer.valueOf(r9.getAsInt());
        if (r10.intValue() == 0) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == true) goto L21;
        r10 = null;
    L21:
        if (r10 == null) goto L23;
        return new DoraObricGlassesImageResource.Apk(r10.intValue());
    L17:
        r1 = false;
    L23:
        JsonElement r11 = r6.get("uri");
        if (r11 == null) goto L34;
        String r12 = r11.getAsString();
        if (r12 == null) goto L34;
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L30;
        r0 = r12;
    L30:
        if (r0 == null) goto L34;
        return new DoraObricGlassesImageResource.FileUri(UriProtector.parse(r0));
    L34:
        throw new JsonParseException("unknown DoraObricGlassesImageResource payload: " + r6);
    }
}
