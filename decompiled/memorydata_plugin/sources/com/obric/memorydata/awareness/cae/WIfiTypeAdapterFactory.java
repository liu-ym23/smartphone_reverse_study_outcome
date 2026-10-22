package com.obric.memorydata.awareness.cae;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.memorydata.database.entity.ConnectWifiInfo;
import com.obric.memorydata.database.entity.ConnectWifiInfoSummary;
import com.obric.memorydata.database.entity.ScanWIfiInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0016J\f\u0010\f\u001a\u00020\r*\u00020\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/awareness/cae/WIfiTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "shortSsid", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WIfiTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/awareness/cae/WIfiTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WIfiTypeAdapterFactory f8554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Gson f8555b;

        a(WIfiTypeAdapterFactory r1, Gson r2) {
            this.f8554a = r1;
            this.f8555b = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r1) {
            Intrinsics.checkNotNullParameter(r1, "input");
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, "out");
            if (ZeusTransformUtils.instanceOf(r6, ScanWIfiInfo.class) == false) goto L6;
            JsonObject r0 = new JsonObject();
            r0.addProperty("s", WIfiTypeAdapterFactory.a(this.f8554a, ((ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r6, ScanWIfiInfo.class, "com.obric.memorydata.plugin")).getSsid()));
            r0.addProperty("b", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r6, ScanWIfiInfo.class, "com.obric.memorydata.plugin")).getBssid().hashCode()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty("r", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r6, ScanWIfiInfo.class, "com.obric.memorydata.plugin")).getRssi()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty(com.bytedance.apm.util.f.f1488a, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r6, ScanWIfiInfo.class, "com.obric.memorydata.plugin")).getFrequency()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty("a", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ScanWIfiInfo) ZeusTransformUtils.preCheckCast(r6, ScanWIfiInfo.class, "com.obric.memorydata.plugin")).getApStandard()), Number.class, "com.obric.memorydata.plugin"));
            this.f8555b.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin"), r5);
            return;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/awareness/cae/WIfiTypeAdapterFactory$create$2", "Lcom/google/gson/TypeAdapter;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WIfiTypeAdapterFactory f8556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Gson f8557b;

        b(WIfiTypeAdapterFactory r1, Gson r2) {
            this.f8556a = r1;
            this.f8557b = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r1) {
            Intrinsics.checkNotNullParameter(r1, "input");
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, "out");
            if (ZeusTransformUtils.instanceOf(r6, ConnectWifiInfo.class) == false) goto L6;
            JsonObject r0 = new JsonObject();
            r0.addProperty("s", WIfiTypeAdapterFactory.a(this.f8556a, ((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getSsid()));
            r0.addProperty("b", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getBssid().hashCode()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty("r", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getRssi()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty(com.bytedance.apm.util.f.f1488a, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getFrequency()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty("t", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getTimestamp()), Number.class, "com.obric.memorydata.plugin"));
            r0.addProperty("m", Boolean.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).isMobileHotspot()));
            r0.addProperty("a", (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfo) ZeusTransformUtils.preCheckCast(r6, ConnectWifiInfo.class, "com.obric.memorydata.plugin")).getApStandard()), Number.class, "com.obric.memorydata.plugin"));
            this.f8557b.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin"), r5);
            return;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/awareness/cae/WIfiTypeAdapterFactory$create$3", "Lcom/google/gson/TypeAdapter;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WIfiTypeAdapterFactory f8558a;

        c(WIfiTypeAdapterFactory r1) {
            this.f8558a = r1;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r1) {
            Intrinsics.checkNotNullParameter(r1, "input");
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r6, T r7) {
            Intrinsics.checkNotNullParameter(r6, "out");
            if (ZeusTransformUtils.instanceOf(r7, ConnectWifiInfoSummary.class) == false) goto L10;
            r6.beginObject();
            r6.name("s").value(WIfiTypeAdapterFactory.a(this.f8558a, ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getSsid()));
            r6.name("b").value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getBssid().hashCode()), Number.class, "com.obric.memorydata.plugin"));
            r6.name("r");
            r6.beginArray();
            int[] r5 = ((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getRssi();
            int r0 = 0;
            int r1 = r5.length;
        L5:
            if (r0 >= r1) goto L7;
            r6.value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5[r0]), Number.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L5
        L7:
            r6.endArray();
            r6.name(com.bytedance.apm.util.f.f1488a).value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getFrequency()), Number.class, "com.obric.memorydata.plugin"));
            r6.name("m").value(((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).isMobileHotspot());
            r6.name("a").value((Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getApStandard()), Number.class, "com.obric.memorydata.plugin"));
            r6.name("u").value(((ConnectWifiInfoSummary) ZeusTransformUtils.preCheckCast(r7, ConnectWifiInfoSummary.class, "com.obric.memorydata.plugin")).getUseTime());
            r6.endObject();
            return;
        }
    }

    public WIfiTypeAdapterFactory() {
    }

    public static final /* synthetic */ String a(WIfiTypeAdapterFactory r0, String r1) {
        return r0.a(r1);
    }

    private final String a(String r3) {
        if (r3.length() > 6) goto L5;
        return r3;
    L5:
        return com.obric.memorydata.utils.b.a(r3, 0, 3) + com.obric.memorydata.utils.b.a(r3, r3.length() - 3);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r2, TypeToken<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        Intrinsics.checkNotNullParameter(r3, "type");
        Class<? super T> r4 = r3.getRawType();
        if (ScanWIfiInfo.class.isAssignableFrom(r4) == false) goto L7;
        return new a(this, r2).nullSafe();
    L7:
        if (ConnectWifiInfo.class.isAssignableFrom(r4) == false) goto L11;
        return new b(this, r2).nullSafe();
    L11:
        if (ConnectWifiInfoSummary.class.isAssignableFrom(r4) == true) goto L13;
        return null;
    L13:
        return new c(this).nullSafe();
    }
}
