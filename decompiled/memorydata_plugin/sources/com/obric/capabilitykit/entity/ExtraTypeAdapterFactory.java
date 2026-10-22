package com.obric.capabilitykit.entity;

import androidx.exifinterface.media.ExifInterface;
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
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "ExtraEntityTypeAdapter", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {
    public static final a Companion = null;
    private static final String KEY = "key";
    private static final String KEY_DATA_TYPE = "data_type";
    private static final String VALUE = "value";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$Companion;", "", "()V", "KEY", "", "KEY_DATA_TYPE", "VALUE", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "gson", "Lcom/google/gson/Gson;", "delegate", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "getDelegate", "()Lcom/google/gson/TypeAdapter;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Gson f7539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TypeAdapter<T> f7540b;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter$read$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/google/gson/JsonElement;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r2, TypeAdapter<T> r3) {
            Intrinsics.checkNotNullParameter(r2, "gson");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.f7539a = r2;
            this.f7540b = r3;
        }

        public final TypeAdapter<T> a() {
            return this.f7540b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList, java.util.Collection] */
        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r10) {
            Intrinsics.checkNotNullParameter(r10, "in");
            JsonObject r11 = new JsonParser().parse(r10).getAsJsonObject();
            JsonElement r1 = r11.get("value");
            r11.add("value", null);
            T r12 = this.f7540b.fromJsonTree(r11);
            if (ZeusTransformUtils.instanceOf(r12, ExtraEntity.class) == true) goto L5;
        L14:
            return r12;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, JsonObject.class) == false) goto L14;
            JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(r1, JsonObject.class, "com.obric.memorydata.plugin");
            String r4 = r2.get("data_type").getAsString();
            JsonElement r3 = r2.get("value");
            ExtraEntity r5 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r12, ExtraEntity.class, "com.obric.memorydata.plugin");
            if (List.class.isAssignableFrom(ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin")) == false) goto L12;
            Type r6 = new a().getType();
            List r7 = (List) ZeusTransformUtils.preCheckCast(this.f7539a.fromJson(r3, r6), List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r7, "jsonList");
            Object r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r9 = r7.iterator();
        L10:
            if (r9.hasNext() == false) goto L13;
            JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
            String r14 = r13.getAsJsonObject().get("data_type").getAsString();
            r8.add(this.f7539a.fromJson(r13.getAsJsonObject().get("value"), ZeusTransformUtils.forName(r14, "com.obric.memorydata.plugin")));
        L13:
            r5.setValue(r8);
            goto L14
        L12:
            r8 = this.f7539a.fromJson(r3, ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin"));
            goto L13
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "out");
            JsonObject r0 = this.f7540b.toJsonTree(r11).getAsJsonObject();
            if (ZeusTransformUtils.instanceOf(r11, ExtraEntity.class) == false) goto L21;
            ExtraEntity r12 = (ExtraEntity) ZeusTransformUtils.preCheckCast(r11, ExtraEntity.class, "com.obric.memorydata.plugin");
            if (r12.getValue() == null) goto L21;
            JsonObject r1 = new JsonObject();
            Object r4 = r12.getValue();
            Intrinsics.checkNotNull(r4);
            r1.add("data_type", new JsonPrimitive(r4.getClass().getName()));
            if (ZeusTransformUtils.instanceOf(r12.getValue(), List.class) == false) goto L19;
            JsonArray r3 = new JsonArray();
            Object r13 = r12.getValue();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator<T> r14 = ((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin")).iterator();
        L10:
            if (r14.hasNext() == false) goto L18;
            T r2 = r14.next();
            JsonObject r6 = new JsonObject();
            if (r2 == null) goto L16;
            Class<?> r8 = r2.getClass();
            if (r8 == null) goto L16;
            String r9 = r8.getName();
        L17:
            r6.add("data_type", new JsonPrimitive(r9));
            r6.add("value", this.f7539a.toJsonTree(r2));
            r3.add(r6);
        L16:
            r9 = null;
            goto L17
        L18:
            r1.add("value", r3);
        L20:
            r0.add("value", r1);
            goto L21
        L19:
            r1.add("value", this.f7539a.toJsonTree(r12.getValue()));
        L21:
            this.f7539a.toJson(r0, r10);
        }
    }

    static {
        Companion = new a(null);
    }

    public ExtraTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        if (Intrinsics.areEqual(r4.getRawType(), ExtraEntity.class) == false) goto L5;
        TypeAdapter<T> r2 = r3.getDelegateAdapter(this, r4);
        Intrinsics.checkNotNullExpressionValue(r2, "delegate");
        return new b(r3, r2);
    L5:
        return null;
    }
}
