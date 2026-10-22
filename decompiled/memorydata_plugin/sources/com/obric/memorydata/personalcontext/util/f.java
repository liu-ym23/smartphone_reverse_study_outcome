package com.obric.memorydata.personalcontext.util;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0002\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0001H\u0086\b\u001a\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", "toListObjByEntityGson", "", ExifInterface.GPS_DIRECTION_TRUE, "parseFileEntityArrayFromJson", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "jsonString", "parseFileEntityFromJson", "parseFileEntityFromJsonNullable", "parseFileEntityFromJsonObject", "jsonElement", "Lcom/google/gson/JsonElement;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    private static final FileEntity a(JsonElement r15) {
        Uri r1 = null;
        if (ZeusTransformUtils.instanceOf(r15, JsonObject.class) == true) goto L6;
        return null;
    L6:
        if (((JsonObject) ZeusTransformUtils.preCheckCast(r15, JsonObject.class, "com.obric.memorydata.plugin")).get("type").getAsInt() != 10015) goto L19;
        JsonElement r0 = ((JsonObject) ZeusTransformUtils.preCheckCast(r15, JsonObject.class, "com.obric.memorydata.plugin")).get("contentUrl");
        if (r0 == null) goto L12;
        String r2 = r0.getAsString();
        if (r2 == null) goto L12;
        r1 = Uri.parse(r2);
    L12:
        Uri r12 = r1;
        if (r12 == null) goto L19;
        String r9 = ((JsonObject) ZeusTransformUtils.preCheckCast(r15, JsonObject.class, "com.obric.memorydata.plugin")).get("fileName").getAsString();     // Catch: Exception -> L16
        Intrinsics.checkNotNullExpressionValue(r9, "getAsString(...)");     // Catch: Exception -> L16
        return new FileEntity("UNKNOWN", 0, 0, r9, 0, r12, FileTypeEnum.FILE, ((JsonObject) ZeusTransformUtils.preCheckCast(r15, JsonObject.class, "com.obric.memorydata.plugin")).get("mimeType").getAsString());
    L16:
        e = move-exception;
        RunLog.INSTANCE.error("EntityGsonUtil", "parse FileEntity from MetaMedia error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        return (FileEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityGson().fromJson(r15, FileEntity.class), FileEntity.class, "com.obric.memorydata.plugin");
    }

    public static final List<FileEntity> a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "jsonString");
        JsonArray r0 = (JsonArray) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityGson().fromJson(r6, JsonArray.class), JsonArray.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        List<FileEntity> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        FileEntity r4 = a((JsonElement) ZeusTransformUtils.preCheckCast(r1.next(), JsonElement.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L13
        if (r4 == null) goto L7;
        r3.add(r4);     // Catch: Exception -> L13
    L14:
        throw new JsonParseException("parse fileEntity error: " + r6);
    L16:
        if (r3.isEmpty() == false) goto L18;
        return null;
    L18:
        return r3;
    }

    public static final FileEntity b(String r3) {
        FileEntity r0 = c(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new JsonParseException("parse fileEntity error: " + r3);
    }

    public static final FileEntity c(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L20;
        return null;
    L20:
        JsonObject r5 = (JsonObject) ZeusTransformUtils.preCheckCast(EntityExtKt.getEntityGson().fromJson(r4, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r5 != null) goto L15;
        return null;
    L15:
        return a((JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin"));
    L17:
        e = move-exception;
        RunLog.INSTANCE.error("EntityGsonUtil", "parse FileEntity error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
