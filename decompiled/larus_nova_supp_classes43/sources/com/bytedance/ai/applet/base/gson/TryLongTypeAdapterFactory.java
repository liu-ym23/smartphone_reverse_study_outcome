package com.bytedance.ai.applet.base.gson;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "valueType", "Ljava/lang/reflect/Type;", "elementType", "unwrapType", "writeValue", "", "writer", "Lcom/google/gson/stream/JsonWriter;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "readValue", "reader", "Lcom/google/gson/stream/JsonReader;", "readNumber", "", "", "lenient", "", "MapAdapter", "ListAdapter", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TryLongTypeAdapterFactory implements TypeAdapterFactory {
    public static final TryLongTypeAdapterFactory a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory$ListAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "read", "reader", "Lcom/google/gson/stream/JsonReader;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ListAdapter extends TypeAdapter<List<? extends Object>> {
        public final Gson a;

        public ListAdapter(Gson r10) {
            Intrinsics.checkNotNullParameter(r10, "gson");
            this.a = r10;
        }

        public final Object read(JsonReader r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            if (r10.peek() != JsonToken.NULL) goto L5;
            r10.nextNull();
            return null;
        L5:
            ArrayList r0 = new ArrayList();
            r10.beginArray();
        L7:
            if (r10.hasNext() == false) goto L9;
            TryLongTypeAdapterFactory.a.getClass();
            r0.add(TryLongTypeAdapterFactory.a(r10));
            goto L7
        L9:
            r10.endArray();
            return r0;
        }

        public final void write(JsonWriter r10, Object r11) {
            List r12 = (List) r11;
            Intrinsics.checkNotNullParameter(r10, "writer");
            if (r12 != null) goto L5;
            r10.nullValue();
            return;
        L5:
            r10.beginArray();
            Iterator r13 = r12.iterator();
        L7:
            if (r13.hasNext() == false) goto L12;
            Object r0 = r13.next();
            TryLongTypeAdapterFactory r1 = TryLongTypeAdapterFactory.a;
            Gson r14 = this.a;
            r1.getClass();
            if (r0 == null) goto L10;
            Class<?> r15 = r0.getClass();
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            r14.getAdapter(r15).write(r10, r0);
            goto L7
        L10:
            r10.nullValue();
            goto L7
        L12:
            r10.endArray();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0016J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/TryLongTypeAdapterFactory$MapAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "read", "reader", "Lcom/google/gson/stream/JsonReader;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MapAdapter extends TypeAdapter<Map<String, ? extends Object>> {
        public final Gson a;

        public MapAdapter(Gson r10) {
            Intrinsics.checkNotNullParameter(r10, "gson");
            this.a = r10;
        }

        public final Object read(JsonReader r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            if (r10.peek() != JsonToken.NULL) goto L5;
            r10.nextNull();
            return null;
        L5:
            LinkedHashMap r0 = new LinkedHashMap();
            r10.beginObject();
        L7:
            if (r10.hasNext() == false) goto L9;
            String r1 = r10.nextName();
            TryLongTypeAdapterFactory.a.getClass();
            r0.put(r1, TryLongTypeAdapterFactory.a(r10));
            goto L7
        L9:
            r10.endObject();
            return r0;
        }

        public final void write(JsonWriter r10, Object r11) {
            Map r12 = (Map) r11;
            Intrinsics.checkNotNullParameter(r10, "writer");
            if (r12 != null) goto L5;
            r10.nullValue();
            return;
        L5:
            r10.beginObject();
            Iterator r13 = r12.entrySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L12;
            Map.Entry r0 = (Map.Entry) r13.next();
            String r1 = (String) r0.getKey();
            Object r14 = r0.getValue();
            r10.name(r1.toString());
            TryLongTypeAdapterFactory r15 = TryLongTypeAdapterFactory.a;
            Gson r16 = this.a;
            r15.getClass();
            if (r14 == null) goto L10;
            Class<?> r17 = r14.getClass();
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            r16.getAdapter(r17).write(r10, r14);
            goto L7
        L10:
            r10.nullValue();
            goto L7
        L12:
            r10.endObject();
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            r0[JsonToken.BEGIN_OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[JsonToken.BOOLEAN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[JsonToken.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[JsonToken.NUMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        a = new TryLongTypeAdapterFactory();
    }

    private TryLongTypeAdapterFactory() {
    }

    public static Object a(JsonReader r10) {
        JsonToken r0 = r10.peek();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        switch(r1) {
            case 1: goto L37;
            case 2: goto L32;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L29;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        boolean r11 = r10.isLenient();
        String r12 = r10.nextString();
        Long r13 = StringsKt.toLongOrNull(r12);
        if (r13 != null) goto L47;
        double r14 = CastDoubleProtector.parseDouble(r12);     // Catch: NumberFormatException -> L26
        if (Double.isInfinite(r14) == false) goto L15;
    L16:
        if (r11 == false) goto L25;
    L18:
        if ((r14 % 1.0d) != 0.0d) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == false) goto L49;
        return Long.valueOf((long) r14);
    L49:
        return Double.valueOf(r14);
    L20:
        r15 = false;
        goto L21
    L25:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r14);     // Catch: NumberFormatException -> L26
    L15:
        if (Double.isNaN(r14) == false) goto L18;
    L26:
        e = move-exception;
        throw new JsonParseException("Cannot parse " + r12, e);
    L47:
        return Long.valueOf(r13.longValue());
    L29:
        r10.nextNull();
        return null;
    L32:
        ArrayList r16 = new ArrayList();
        r10.beginArray();
    L34:
        if (r10.hasNext() == false) goto L36;
        r16.add(a(r10));
        goto L34
    L36:
        r10.endArray();
        Object r17 = r16;
    L43:
        return r17;
    L37:
        LinkedHashMap r18 = new LinkedHashMap();
        r10.beginObject();
    L39:
        if (r10.hasNext() == false) goto L41;
        r18.put(r10.nextName(), a(r10));
        goto L39
    L41:
        r10.endObject();
        r17 = r18;
        goto L43
    L8:
        throw new IllegalStateException("Unexpected token: " + r10.peek());
    L51:
        return Boolean.valueOf(r10.nextBoolean());
    L52:
        return r10.nextString();
    L5:
        r1 = a.a[r0.ordinal()];
        goto L6
    }

    public static Type b(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L14;
        Type[] r11 = ((WildcardType) r10).getUpperBounds();
        Intrinsics.checkNotNull(r11);
        if (r11.length != 0) goto L7;
        boolean r0 = true;
    L9:
        if ((!r0) == true) goto L24;
        return Object.class;
    L24:
        return b(r11[0]);
    L7:
        r0 = false;
        goto L9
    L14:
        if ((r10 instanceof TypeVariable) == false) goto L25;
        Type[] r12 = ((TypeVariable) r10).getBounds();
        Intrinsics.checkNotNull(r12);
        if (r12.length != 0) goto L18;
        boolean r1 = true;
    L20:
        if ((!r1) == true) goto L26;
        return Object.class;
    L26:
        return b(r12[0]);
    L18:
        r1 = false;
        goto L20
    L25:
        return r10;
    }

    public final <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "gson");
        Intrinsics.checkNotNullParameter(r11, "type");
        Class r0 = r11.getRawType();
        if (Map.class.isAssignableFrom(r0) == false) goto L14;
        Type r1 = r11.getType();
        if ((r1 instanceof ParameterizedType) == false) goto L9;
        Type[] r12 = ((ParameterizedType) r1).getActualTypeArguments();
        if (r12.length != 2) goto L9;
        Object r13 = b(r12[1]);
    L11:
        if (Intrinsics.areEqual(r13, Object.class) == false) goto L14;
        return new MapAdapter(r10);
    L9:
        r13 = Object.class;
    L14:
        if (List.class.isAssignableFrom(r0) == false) goto L24;
        Type r14 = r11.getType();
        if ((r14 instanceof ParameterizedType) == false) goto L20;
        Type[] r15 = ((ParameterizedType) r14).getActualTypeArguments();
        if (r15.length != 1) goto L20;
        Object r16 = b(r15[0]);
    L22:
        if (Intrinsics.areEqual(r16, Object.class) == false) goto L24;
        return new ListAdapter(r10);
    L20:
        r16 = Object.class;
    L24:
        return null;
    }
}
