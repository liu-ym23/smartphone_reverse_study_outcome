package com.obric.capabilitykit.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class g implements TypeAdapterFactory {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/obric/capabilitykit/entity/EntityTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
    public static final class b<T> extends TypeAdapter<T> {
        public final /* synthetic */ TypeAdapter<T> a;
        public final /* synthetic */ Gson b;

        public b(TypeAdapter<T> r1, Gson r2) {
            this.a = r1;
            this.b = r2;
        }

        public final T read(JsonReader r9) {
            Intrinsics.checkNotNullParameter(r9, "input");
            JsonObject r10 = new JsonParser().parse(r9).getAsJsonObject();
            String r1 = r10.get("createTime").getAsString();
            String r3 = r10.get("lastModifiedTime").getAsString();
            SimpleDateFormat r4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Long r7 = null;
            if (r10.has("createTimeStamp") == false) goto L7;
            long r5 = r10.get("createTimeStamp").getAsLong();
        L5:
            Long r2 = Long.valueOf(r5);
        L6:
            r10.addProperty("createTime", r2);
            if (r10.has("lastModifiedTimeStamp") == false) goto L14;
            r10.addProperty("lastModifiedTime", Long.valueOf(r10.get("lastModifiedTimeStamp").getAsLong()));
        L19:
            return (T) this.a.fromJsonTree(r10);
        L14:
            Date r0 = r4.parse(r3);
            if (r0 == null) goto L17;
            r7 = Long.valueOf(r0.getTime());
        L17:
            r10.addProperty("lastModifiedTime", r7);
            goto L19
        L7:
            Date r6 = r4.parse(r1);
            if (r6 == null) goto L10;
            r5 = r6.getTime();
            goto L5
        L10:
            r2 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void write(JsonWriter r8, T r9) {
            Intrinsics.checkNotNullParameter(r8, "out");
            JsonObject r0 = this.a.toJsonTree(r9).getAsJsonObject();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppEntity");
            AppEntity r10 = (AppEntity) r9;
            long r1 = r10.getCreateTime();
            long r3 = r10.getLastModifiedTime();
            SimpleDateFormat r11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            r0.addProperty("createTime", r11.format(new Date(r1)));
            r0.addProperty("createTimeStamp", Long.valueOf(r1));
            r0.addProperty("lastModifiedTime", r11.format(new Date(r3)));
            r0.addProperty("lastModifiedTimeStamp", Long.valueOf(r3));
            this.b.toJson(r0, r8);
        }
    }

    public g() {
    }

    public final <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        TypeAdapter r0 = r3.getDelegateAdapter(this, r4);
        if (AppEntity.class.isAssignableFrom(r4.getRawType()) == true) goto L5;
        return null;
    L5:
        return new b(r0, r3).nullSafe();
    }
}
