package com.obric.capabilitykit.entity;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "ExtraEntityTypeAdapter", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {
    public static final a Companion = null;
    private static final String KEY = "key";
    private static final String KEY_DATA_TYPE = "data_type";
    private static final String VALUE = "value";

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", "delegate", "Lcom/google/gson/TypeAdapter;", "getDelegate", "()Lcom/google/gson/TypeAdapter;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
    public static final class b<T> extends TypeAdapter<T> {
        public final Gson a;
        public final TypeAdapter<T> b;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter$read$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/google/gson/JsonElement;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r2, TypeAdapter<T> r3) {
            Intrinsics.checkNotNullParameter(r2, "gson");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.a = r2;
            this.b = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
        public final T read(JsonReader r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            JsonObject r10 = new JsonParser().parse(r9).getAsJsonObject();
            JsonObject r1 = r10.get(ExtraTypeAdapterFactory.VALUE);
            r10.add(ExtraTypeAdapterFactory.VALUE, null);
            T r11 = (T) this.b.fromJsonTree(r10);
            if ((r11 instanceof ExtraEntity) == true) goto L5;
        L14:
            return r11;
        L5:
            if ((r1 instanceof JsonObject) == false) goto L14;
            JsonObject r2 = r1;
            String r3 = r2.get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            JsonElement r4 = r2.get(ExtraTypeAdapterFactory.VALUE);
            ExtraEntity r5 = (ExtraEntity) r11;
            if (List.class.isAssignableFrom(a(r3)) == false) goto L12;
            Type r6 = new a().getType();
            List r7 = (List) GsonProtectorUtils.fromJson(this.a, r4, r6);
            Object r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r12 = r7.iterator();
        L10:
            if (r12.hasNext() == false) goto L13;
            JsonElement r13 = (JsonElement) r12.next();
            String r14 = r13.getAsJsonObject().get(ExtraTypeAdapterFactory.KEY_DATA_TYPE).getAsString();
            r8.add(GsonProtectorUtils.fromJson(this.a, r13.getAsJsonObject().get(ExtraTypeAdapterFactory.VALUE), a(r14)));
        L13:
            r5.setValue(r8);
            goto L14
        L12:
            r8 = GsonProtectorUtils.fromJson(this.a, r4, a(r3));
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void write(JsonWriter r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "out");
            JsonObject r0 = this.b.toJsonTree(r11).getAsJsonObject();
            if ((r11 instanceof ExtraEntity) == false) goto L19;
            ExtraEntity r12 = (ExtraEntity) r11;
            if (r12.getValue() == null) goto L19;
            JsonObject r1 = new JsonObject();
            Object r3 = r12.getValue();
            Intrinsics.checkNotNull(r3);
            r1.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r3.getClass().getName()));
            if ((r12.getValue() instanceof List) == false) goto L17;
            JsonArray r2 = new JsonArray();
            Object r13 = r12.getValue();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator<T> r14 = ((List) r13).iterator();
        L10:
            if (r14.hasNext() == false) goto L16;
            T r5 = r14.next();
            JsonObject r6 = new JsonObject();
            if (r5 == null) goto L14;
            String r8 = r5.getClass().getName();
        L15:
            r6.add(ExtraTypeAdapterFactory.KEY_DATA_TYPE, new JsonPrimitive(r8));
            r6.add(ExtraTypeAdapterFactory.VALUE, GsonProtectorUtils.toJsonTree(this.a, r5));
            r2.add(r6);
            goto L10
        L14:
            r8 = null;
            goto L15
        L16:
            r1.add(ExtraTypeAdapterFactory.VALUE, r2);
        L18:
            r0.add(ExtraTypeAdapterFactory.VALUE, r1);
            goto L19
        L17:
            r1.add(ExtraTypeAdapterFactory.VALUE, GsonProtectorUtils.toJsonTree(this.a, r12.getValue()));
        L19:
            this.a.toJson(r0, r10);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }
    }

    static {
        Companion = new a();
    }

    public ExtraTypeAdapterFactory() {
    }

    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        if (Intrinsics.areEqual(r4.getRawType(), ExtraEntity.class) == true) goto L7;
        return null;
    L7:
        return new b(r3, r3.getDelegateAdapter(this, r4));
    }
}
