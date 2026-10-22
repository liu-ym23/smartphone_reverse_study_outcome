package com.obric.memorydata.realtimecontext;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ReferenceEntityTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "removeContactEntityProperty", "", "jsonObject", "Lcom/google/gson/JsonObject;", "removeCallHistoryEntityProperty", "removePhotoEntityProperty", "removeAlbumEntityProperty", "removeNoteEntityProperty", "removeAppEntityProperty", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReferenceEntityTypeAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleDateFormat f12434b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/realtimecontext/ReferenceEntityTypeAdapterFactory$Companion;", "", "<init>", "()V", "TAG", "", "TIME_FORMAT", "KEY_CREATE_TIME", "KEY_LAST_MODIFIED_TIME", "KEY_ENTITY_TYPE", "PACKAGE_NAME", "VERSION", "EXTRAS", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/realtimecontext/ReferenceEntityTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TypeAdapter<T> f12435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ReferenceEntityTypeAdapterFactory f12436b;
        final /* synthetic */ Gson c;

        b(TypeAdapter<T> r1, ReferenceEntityTypeAdapterFactory r2, Gson r3) {
            this.f12435a = r1;
            this.f12436b = r2;
            this.c = r3;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r8) {
            Intrinsics.checkNotNullParameter(r8, "input");
            JsonObject r9 = JsonParser.parseReader(r8).getAsJsonObject();
            String r1 = r9.get("createTime").getAsString();
            String r3 = r9.get("lastModifiedTime").getAsString();
            Date r2 = ReferenceEntityTypeAdapterFactory.a(this.f12436b).parse(r1);
            Long r4 = null;
            if (r2 == null) goto L5;
            Long r5 = Long.valueOf(r2.getTime());
        L6:
            r9.addProperty("createTime", (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin"));
            Date r0 = ReferenceEntityTypeAdapterFactory.a(this.f12436b).parse(r3);
            if (r0 == null) goto L9;
            r4 = Long.valueOf(r0.getTime());
        L9:
            r9.addProperty("lastModifiedTime", (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
            return this.f12435a.fromJsonTree((JsonElement) ZeusTransformUtils.preCheckCast(r9, JsonElement.class, "com.obric.memorydata.plugin"));
        L5:
            r5 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "out");
            if (ZeusTransformUtils.instanceOf(r11, AppEntity.class) == false) goto L24;
            JsonObject r0 = this.f12435a.toJsonTree(r11).getAsJsonObject();
            long r3 = ((AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin")).getCreateTime();
            long r5 = ((AppEntity) ZeusTransformUtils.preCheckCast(r11, AppEntity.class, "com.obric.memorydata.plugin")).getLastModifiedTime();
            r0.addProperty("createTime", ReferenceEntityTypeAdapterFactory.a(this.f12436b).format(new Date(r3)));
            r0.addProperty("lastModifiedTime", ReferenceEntityTypeAdapterFactory.a(this.f12436b).format(new Date(r5)));
            r0.addProperty("entityType", r11.getClass().getSimpleName());
            r0.remove("_packageName");
            r0.remove("_version");
            r0.remove("extras");
            if (ZeusTransformUtils.instanceOf(r11, ContactEntity.class) == false) goto L8;
            ReferenceEntityTypeAdapterFactory r12 = this.f12436b;
            Intrinsics.checkNotNull(r0);
            ReferenceEntityTypeAdapterFactory.a(r12, r0);
        L22:
            this.c.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin"), r10);
            return;
        L8:
            if (ZeusTransformUtils.instanceOf(r11, CallHistoryEntity.class) == false) goto L11;
            ReferenceEntityTypeAdapterFactory r13 = this.f12436b;
            Intrinsics.checkNotNull(r0);
            ReferenceEntityTypeAdapterFactory.b(r13, r0);
            goto L22
        L11:
            if (ZeusTransformUtils.instanceOf(r11, MessageEntity.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r11, PhotoEntity.class) == false) goto L16;
            ReferenceEntityTypeAdapterFactory r14 = this.f12436b;
            Intrinsics.checkNotNull(r0);
            ReferenceEntityTypeAdapterFactory.c(r14, r0);
            goto L22
        L16:
            if (ZeusTransformUtils.instanceOf(r11, AlbumEntity.class) == false) goto L19;
            ReferenceEntityTypeAdapterFactory r15 = this.f12436b;
            Intrinsics.checkNotNull(r0);
            ReferenceEntityTypeAdapterFactory.d(r15, r0);
            goto L22
        L19:
            if (ZeusTransformUtils.instanceOf(r11, NoteEntity.class) == false) goto L21;
            ReferenceEntityTypeAdapterFactory r16 = this.f12436b;
            Intrinsics.checkNotNull(r0);
            ReferenceEntityTypeAdapterFactory.e(r16, r0);
            goto L22
        L21:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ReferenceEntityTypeAdapter", "unknown entity type: " + r11.getClass().getSimpleName(), false, 4, null);
            goto L22
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/realtimecontext/ReferenceEntityTypeAdapterFactory$create$2", "Lcom/google/gson/TypeAdapter;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", EventBody.KEY_VALUE, "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TypeAdapter<T> f12437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Gson f12438b;

        c(TypeAdapter<T> r1, Gson r2) {
            this.f12437a = r1;
            this.f12438b = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r3) {
            JsonObject r4 = JsonParser.parseReader(r3).getAsJsonObject();
            return this.f12437a.fromJsonTree((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r4, T r5) {
            JsonObject r0 = this.f12437a.toJsonTree(r5).getAsJsonObject();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.capabilitykit.entity.meta.MetaValue");
            r0.addProperty("entityType", ((MetaValue) ZeusTransformUtils.preCheckCast(r5, MetaValue.class, "com.obric.memorydata.plugin")).getClass().getSimpleName());
            this.f12438b.toJson((JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static {
        f12433a = new a(null);
    }

    public ReferenceEntityTypeAdapterFactory() {
        this.f12434b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public static final /* synthetic */ SimpleDateFormat a(ReferenceEntityTypeAdapterFactory r0) {
        return r0.f12434b;
    }

    private final void a(JsonObject r2) {
        r2.remove("createTime");
        r2.remove("lastModifiedTime");
        r2.remove("avatar");
        r2.remove("note");
        r2.remove("gender");
        r2.remove("credentialNumbers");
        r2.remove("emails");
        r2.remove("addresses");
        r2.remove("company");
        r2.remove("instantMessagings");
        r2.remove("anniversaries");
        r2.remove("voip");
        r2.remove("relationShips");
        f(r2);
    }

    public static final /* synthetic */ void a(ReferenceEntityTypeAdapterFactory r0, JsonObject r1) {
        r0.a(r1);
    }

    private final void b(JsonObject r2) {
        r2.remove(LocationMonitorConst.TAG);
        r2.remove("isAIPickup");
        r2.remove("hasTranscript");
        r2.remove("carriers");
        f(r2);
    }

    public static final /* synthetic */ void b(ReferenceEntityTypeAdapterFactory r0, JsonObject r1) {
        r0.b(r1);
    }

    private final void c(JsonObject r2) {
        r2.remove("file");
        r2.remove("resolution");
        r2.remove("fileSize");
        r2.remove("ocr");
        r2.remove("faces");
        r2.remove("sourcePackageName");
        r2.remove("sourceAppName");
        f(r2);
    }

    public static final /* synthetic */ void c(ReferenceEntityTypeAdapterFactory r0, JsonObject r1) {
        r0.c(r1);
    }

    private final void d(JsonObject r2) {
        r2.remove("cover");
        r2.remove("hashCodeValue");
        f(r2);
    }

    public static final /* synthetic */ void d(ReferenceEntityTypeAdapterFactory r0, JsonObject r1) {
        r0.d(r1);
    }

    private final void e(JsonObject r2) {
        r2.remove(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        r2.remove("formatMode");
        r2.remove("noteFolder");
        f(r2);
    }

    public static final /* synthetic */ void e(ReferenceEntityTypeAdapterFactory r0, JsonObject r1) {
        r0.e(r1);
    }

    private final void f(JsonObject r1) {
        r1.remove("hashCodeValue");
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r3, TypeToken<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        Intrinsics.checkNotNullParameter(r4, "type");
        TypeAdapter<T> r0 = r3.getDelegateAdapter((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(this, TypeAdapterFactory.class, "com.obric.memorydata.plugin"), r4);
        Class<? super T> r5 = r4.getRawType();
        if (AppEntity.class.isAssignableFrom(r5) == false) goto L7;
        return new b(r0, this, r3).nullSafe();
    L7:
        if (MetaValue.class.isAssignableFrom(r5) == true) goto L9;
        return null;
    L9:
        return new c(r0, r3).nullSafe();
    }
}
