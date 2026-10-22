package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000e\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/room/migration/bundle/SchemaBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "formatVersion", "", "database", "Landroidx/room/migration/bundle/DatabaseBundle;", "(ILandroidx/room/migration/bundle/DatabaseBundle;)V", "getDatabase", "()Landroidx/room/migration/bundle/DatabaseBundle;", "getFormatVersion", "()I", "isSchemaEqual", "", "other", "Companion", "EntityTypeAdapterFactory", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SchemaBundle implements SchemaEquality<SchemaBundle> {
    private static final String CHARSET = "UTF-8";
    public static final Companion Companion = null;
    private static final Gson GSON = null;
    public static final int LATEST_FORMAT = 1;

    @SerializedName("database")
    private final DatabaseBundle database;

    @SerializedName("formatVersion")
    private final int formatVersion;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/migration/bundle/SchemaBundle$Companion;", "", "()V", "CHARSET", "", "GSON", "Lcom/google/gson/Gson;", "LATEST_FORMAT", "", "deserialize", "Landroidx/room/migration/bundle/SchemaBundle;", "fis", "Ljava/io/InputStream;", "serialize", "", "bundle", "file", "Ljava/io/File;", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final SchemaBundle deserialize(InputStream r5) throws UnsupportedEncodingException {
            Intrinsics.checkNotNullParameter(r5, "fis");
            InputStreamReader r10 = new InputStreamReader(r5, SchemaBundle.CHARSET);
            SchemaBundle r11 = (SchemaBundle) SchemaBundle.access$getGSON$cp().fromJson(r10, SchemaBundle.class);     // Catch: Throwable -> L9
            if (r11 == null) goto L8;
            CloseableKt.closeFinally(r10, null);
            return r11;
        L8:
            throw new IllegalStateException("Invalid schema file");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void serialize(SchemaBundle r5, File r10) throws IOException {
            Intrinsics.checkNotNullParameter(r5, "bundle");
            Intrinsics.checkNotNullParameter(r10, "file");
            OutputStreamWriter r11 = new OutputStreamWriter(new FileOutputStream(r10, false), SchemaBundle.CHARSET);
            SchemaBundle.access$getGSON$cp().toJson(r5, r11);     // Catch: Throwable -> L6
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
            CloseableKt.closeFinally(r11, null);
            return;
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/room/migration/bundle/SchemaBundle$EntityTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "EntityTypeAdapter", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class EntityTypeAdapterFactory implements TypeAdapterFactory {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\u0010\bJ\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/room/migration/bundle/SchemaBundle$EntityTypeAdapterFactory$EntityTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroidx/room/migration/bundle/EntityBundle;", "jsonElementAdapter", "Lcom/google/gson/JsonElement;", "entityBundleAdapter", "ftsEntityBundleAdapter", "Landroidx/room/migration/bundle/FtsEntityBundle;", "(Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "getEntityBundleAdapter", "()Lcom/google/gson/TypeAdapter;", "getFtsEntityBundleAdapter", "getJsonElementAdapter", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class EntityTypeAdapter extends TypeAdapter<EntityBundle> {
            private final TypeAdapter<EntityBundle> entityBundleAdapter;
            private final TypeAdapter<FtsEntityBundle> ftsEntityBundleAdapter;
            private final TypeAdapter<JsonElement> jsonElementAdapter;

            public EntityTypeAdapter(TypeAdapter<JsonElement> r5, TypeAdapter<EntityBundle> r10, TypeAdapter<FtsEntityBundle> r11) {
                Intrinsics.checkNotNullParameter(r5, "jsonElementAdapter");
                Intrinsics.checkNotNullParameter(r10, "entityBundleAdapter");
                Intrinsics.checkNotNullParameter(r11, "ftsEntityBundleAdapter");
                this.jsonElementAdapter = r5;
                this.entityBundleAdapter = r10;
                this.ftsEntityBundleAdapter = r11;
            }

            public final TypeAdapter<EntityBundle> getEntityBundleAdapter() {
                return this.entityBundleAdapter;
            }

            public final TypeAdapter<FtsEntityBundle> getFtsEntityBundleAdapter() {
                return this.ftsEntityBundleAdapter;
            }

            public final TypeAdapter<JsonElement> getJsonElementAdapter() {
                return this.jsonElementAdapter;
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ EntityBundle read(JsonReader r5) {
                return read(r5);
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(JsonWriter r5, EntityBundle r10) {
                write2(r5, r10);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public EntityBundle read(JsonReader r5) {
                JsonObject r10 = this.jsonElementAdapter.read(r5).getAsJsonObject();
                if (r10.has("ftsVersion") == false) goto L6;
                return this.ftsEntityBundleAdapter.fromJsonTree(r10);
            L6:
                return this.entityBundleAdapter.fromJsonTree(r10);
            }

            /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
            public void write2(JsonWriter r5, EntityBundle r10) throws IOException {
                if ((r10 instanceof FtsEntityBundle) == false) goto L5;
                this.ftsEntityBundleAdapter.write(r5, r10);
                return;
            L5:
                this.entityBundleAdapter.write(r5, r10);
            }
        }

        public EntityTypeAdapterFactory() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r5, TypeToken<T> r10) {
            Intrinsics.checkNotNullParameter(r5, "gson");
            Intrinsics.checkNotNullParameter(r10, "type");
            if (EntityBundle.class.isAssignableFrom(r10.getRawType()) == true) goto L7;
            return null;
        L7:
            return new EntityTypeAdapter(r5.getAdapter(JsonElement.class), r5.getDelegateAdapter(this, TypeToken.get(EntityBundle.class)), r5.getDelegateAdapter(this, TypeToken.get(FtsEntityBundle.class)));
        }
    }

    static {
        Companion = new Companion(null);
        GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().registerTypeAdapterFactory(new EntityTypeAdapterFactory()).create();
    }

    public SchemaBundle(int r5, DatabaseBundle r10) {
        Intrinsics.checkNotNullParameter(r10, "database");
        this.formatVersion = r5;
        this.database = r10;
    }

    public static final /* synthetic */ Gson access$getGSON$cp() {
        return GSON;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SchemaBundle deserialize(InputStream r5) throws UnsupportedEncodingException {
        return Companion.deserialize(r5);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void serialize(SchemaBundle r5, File r10) throws IOException {
        Companion.serialize(r5, r10);
    }

    public DatabaseBundle getDatabase() {
        return this.database;
    }

    public int getFormatVersion() {
        return this.formatVersion;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(SchemaBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(SchemaBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (SchemaEqualityUtil.INSTANCE.checkSchemaEquality(getDatabase(), r5.getDatabase()) == true) goto L5;
    L7:
        return false;
    L5:
        if (getFormatVersion() != r5.getFormatVersion()) goto L7;
        return true;
    }
}
