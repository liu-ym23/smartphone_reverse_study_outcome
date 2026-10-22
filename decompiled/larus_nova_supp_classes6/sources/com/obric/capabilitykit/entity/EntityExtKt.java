package com.obric.capabilitykit.entity;

import android.net.Uri;
import android.os.Parcel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0005H\u0007\"\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "", "toJson", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "toJsonKeepTimeStamp", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "Lcom/google/gson/Gson;", "entityGson", "Lcom/google/gson/Gson;", "a", "()Lcom/google/gson/Gson;", "entityKeepTimeStampGson", "b", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1})
public final class EntityExtKt {
    public static final Gson a = null;
    private static final Gson entityGson = null;
    private static final Gson entityKeepTimeStampGson = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).registerTypeAdapter(AppEntity.class, new e()).registerTypeAdapter(AppEntity.class, new f()).registerTypeAdapter(MemoryEntity.class, new e()).registerTypeAdapter(MemoryEntity.class, new f()).registerTypeAdapter(MetaValue.class, new i()).registerTypeAdapter(MetaValue.class, new h()).create();
        Intrinsics.checkNotNull(r0);
        entityGson = r0;
        Gson r1 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).registerTypeAdapterFactory(new g()).create();
        Intrinsics.checkNotNull(r1);
        a = r1;
        Gson r2 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapterFactory(new ExtraTypeAdapterFactory()).create();
        Intrinsics.checkNotNull(r2);
        entityKeepTimeStampGson = r2;
    }

    public static final Gson a() {
        return entityGson;
    }

    public static final Gson b() {
        return entityKeepTimeStampGson;
    }

    public static final boolean c(Object r4) {
        if (r4 != null) goto L6;
        return true;
    L6:
        if ((r4 instanceof Integer) == false) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
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
    L30:
        if (r9 == false) goto L33;
        return true;
    L33:
        if ((r4 instanceof Uri) == false) goto L36;
        return true;
    L36:
        if ((r4 instanceof MetaValue) == false) goto L39;
        return true;
    L39:
        if ((r4 instanceof List) == false) goto L52;
        Iterable r10 = (Iterable) r4;
        if ((r10 instanceof Collection) == true) goto L43;
    L45:
        Iterator r11 = r10.iterator();
    L47:
        if (r11.hasNext() == false) goto L81;
        if (c(r11.next()) == true) goto L47;
    L66:
        return false;
    L81:
        return true;
    L43:
        if (((Collection) r10).isEmpty() == false) goto L45;
        return true;
    L52:
        if ((r4 instanceof Map) == false) goto L66;
        Map r12 = (Map) r4;
        if (r12.isEmpty() == true) goto L80;
        Iterator r13 = r12.entrySet().iterator();
    L58:
        if (r13.hasNext() == false) goto L82;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (c(r14.getKey()) == true) goto L62;
    L64:
        boolean r15 = false;
    L65:
        if (r15 == true) goto L58;
    L62:
        if (c(r14.getValue()) == false) goto L64;
        r15 = true;
        goto L65
    L82:
        return true;
    L80:
        return true;
    L29:
        r9 = r4 instanceof String;
        goto L30
    L26:
        r8 = r4 instanceof Character;
        goto L27
    L23:
        r7 = r4 instanceof Boolean;
        goto L24
    L20:
        r6 = r4 instanceof Byte;
        goto L21
    L17:
        r5 = r4 instanceof Short;
        goto L18
    L14:
        r3 = r4 instanceof Long;
        goto L15
    L11:
        r2 = r4 instanceof Float;
        goto L12
    L8:
        r1 = r4 instanceof Double;
        goto L9
    }

    public static final boolean d(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.readInt() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String e(Parcel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static final String toJson(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return GsonProtectorUtils.toJson(a, r1);
    }

    public static final String toJson(ExtraEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return GsonProtectorUtils.toJson(a, r1);
    }

    public static final String toJson(MetaValue r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return GsonProtectorUtils.toJson(a, r1);
    }

    public static final String toJsonKeepTimeStamp(AppEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return GsonProtectorUtils.toJson(entityKeepTimeStampGson, r1);
    }
}
