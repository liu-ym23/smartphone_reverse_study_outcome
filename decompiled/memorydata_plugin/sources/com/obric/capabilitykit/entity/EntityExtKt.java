package com.obric.capabilitykit.entity;

import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.common.e;
import com.obric.capabilitykit.common.f;
import com.obric.capabilitykit.common.g;
import com.obric.capabilitykit.common.h;
import com.obric.capabilitykit.common.i;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a,\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0010\b\u0000\u0010\t\u0018\u0001*\b\u0012\u0004\u0012\u0002H\t0\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0002\u0010\r\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\f*\u00020\u0013\u001a\f\u0010\u0015\u001a\u00020\f*\u00020\u0016H\u0007\u001a\f\u0010\u0015\u001a\u00020\f*\u00020\u0017H\u0007\u001a\f\u0010\u0015\u001a\u00020\f*\u00020\u0018H\u0007\u001a\f\u0010\u0019\u001a\u00020\f*\u00020\u0016H\u0007\u001a\u0012\u0010\u001a\u001a\u00020\u001b*\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000f\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\u001d"}, d2 = {"entityGson", "Lcom/google/gson/Gson;", "getEntityGson", "()Lcom/google/gson/Gson;", "entityKeepTimeStampGson", "getEntityKeepTimeStampGson", "innerEntityGson", "getInnerEntityGson", "enumFrom", ExifInterface.GPS_DIRECTION_TRUE, "", ActivityLifecycle.NAME, "", "(Ljava/lang/String;)Ljava/lang/Enum;", "isValidEntityPropertyType", "", "obj", "", "readBool", "Landroid/os/Parcel;", "readStringOrEmpty", "toJson", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "toJsonKeepTimeStamp", "writeBool", "", EventBody.KEY_VALUE, "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EntityExtKt {
    private static final Gson entityGson = null;
    private static final Gson entityKeepTimeStampGson = null;
    private static final Gson innerEntityGson = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).registerTypeAdapter(AppEntity.class, new e()).registerTypeAdapter(AppEntity.class, new f()).registerTypeAdapter(MemoryEntity.class, new e()).registerTypeAdapter(MemoryEntity.class, new f()).registerTypeAdapter(MetaValue.class, new i()).registerTypeAdapter(MetaValue.class, new h()).create();
        Intrinsics.checkNotNull(r0);
        entityGson = r0;
        Gson r1 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).create();
        Intrinsics.checkNotNull(r1);
        innerEntityGson = r1;
        Gson r2 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
        Intrinsics.checkNotNull(r2);
        entityKeepTimeStampGson = r2;
    }

    public static final /* synthetic */ <T extends Enum<T>> T enumFrom(String r4) {
        if (r4 != null) goto L10;
        return null;
    L10:
        Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: IllegalArgumentException -> L8
        return (T) Enum.valueOf(null, r4);
    L8:
        StringBuilder r5 = new StringBuilder().append("failed to create enum from name ").append(r4).append(" for enum type ");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Log.w("EntityEnum", r5.append(Reflection.getOrCreateKotlinClass(Enum.class).getSimpleName()).append(' ').toString());
        return null;
    }

    public static final Gson getEntityGson() {
        return entityGson;
    }

    public static final Gson getEntityKeepTimeStampGson() {
        return entityKeepTimeStampGson;
    }

    public static final Gson getInnerEntityGson() {
        return innerEntityGson;
    }

    public static final boolean isValidEntityPropertyType(Object r5) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L34;
        return true;
    L34:
        if (ZeusTransformUtils.instanceOf(r5, Uri.class) == false) goto L37;
        return true;
    L37:
        if (ZeusTransformUtils.instanceOf(r5, MetaValue.class) == false) goto L40;
        return true;
    L40:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == false) goto L53;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L44;
    L46:
        Iterator r11 = r10.iterator();
    L48:
        if (r11.hasNext() == false) goto L82;
        if (isValidEntityPropertyType(r11.next()) == true) goto L48;
    L68:
        return false;
    L82:
        return true;
    L44:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L46;
        return true;
    L53:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L68;
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (r12.isEmpty() == true) goto L81;
        Iterator r13 = r12.entrySet().iterator();
    L59:
        if (r13.hasNext() == false) goto L83;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (isValidEntityPropertyType(r14.getKey()) == true) goto L63;
    L65:
        boolean r15 = false;
    L66:
        if (r15 == true) goto L59;
    L63:
        if (isValidEntityPropertyType(r14.getValue()) == false) goto L65;
        r15 = true;
        goto L66
    L83:
        return true;
    L81:
        return true;
    L29:
        r9 = ZeusTransformUtils.instanceOf(r5, String.class);
        goto L31
    L26:
        r8 = ZeusTransformUtils.instanceOf(r5, Character.class);
        goto L27
    L23:
        r7 = ZeusTransformUtils.instanceOf(r5, Boolean.class);
        goto L24
    L20:
        r6 = ZeusTransformUtils.instanceOf(r5, Byte.class);
        goto L21
    L17:
        r4 = ZeusTransformUtils.instanceOf(r5, Short.class);
        goto L18
    L14:
        r3 = ZeusTransformUtils.instanceOf(r5, Long.class);
        goto L15
    L11:
        r2 = ZeusTransformUtils.instanceOf(r5, Float.class);
        goto L12
    L8:
        r1 = ZeusTransformUtils.instanceOf(r5, Double.class);
        goto L9
    }

    public static final boolean readBool(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.readInt() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String readStringOrEmpty(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static final String toJson(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = innerEntityGson.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJson(ExtraEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = innerEntityGson.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJson(MetaValue r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = innerEntityGson.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "innerEntityGson.toJson(this)");
        return r2;
    }

    public static final String toJsonKeepTimeStamp(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = entityKeepTimeStampGson.toJson(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "entityKeepTimeStampGson.toJson(this)");
        return r2;
    }

    public static final void writeBool(Parcel r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.writeInt(r2 ? 1 : 0);
    }
}
