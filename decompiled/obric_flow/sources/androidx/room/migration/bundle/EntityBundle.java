package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)B\u0007\b\u0013¢\u0006\u0002\u0010\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0000H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011¨\u0006*"}, d2 = {"Landroidx/room/migration/bundle/EntityBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "tableName", "", "createSql", "fields", "", "Landroidx/room/migration/bundle/FieldBundle;", "primaryKey", "Landroidx/room/migration/bundle/PrimaryKeyBundle;", "indices", "Landroidx/room/migration/bundle/IndexBundle;", "foreignKeys", "Landroidx/room/migration/bundle/ForeignKeyBundle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroidx/room/migration/bundle/PrimaryKeyBundle;Ljava/util/List;Ljava/util/List;)V", "getCreateSql", "()Ljava/lang/String;", "getFields", "()Ljava/util/List;", "fieldsByColumnName", "", "getFieldsByColumnName", "()Ljava/util/Map;", "fieldsByColumnName$delegate", "Lkotlin/Lazy;", "getForeignKeys", "getIndices", "newTableName", "getNewTableName", "getPrimaryKey", "()Landroidx/room/migration/bundle/PrimaryKeyBundle;", "getTableName", "buildCreateQueries", "", "createNewTable", "createTable", "isSchemaEqual", "", "other", "renameToOriginal", "Companion", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class EntityBundle implements SchemaEquality<EntityBundle> {
    public static final Companion Companion = null;
    public static final String NEW_TABLE_PREFIX = "_new_";

    @SerializedName("createSql")
    private final String createSql;

    @SerializedName("fields")
    private final List<FieldBundle> fields;
    private final transient Lazy fieldsByColumnName$delegate;

    @SerializedName("foreignKeys")
    private final List<ForeignKeyBundle> foreignKeys;

    @SerializedName("indices")
    private final List<IndexBundle> indices;

    @SerializedName("primaryKey")
    private final PrimaryKeyBundle primaryKey;

    @SerializedName("tableName")
    private final String tableName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/migration/bundle/EntityBundle$Companion;", "", "()V", "NEW_TABLE_PREFIX", "", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntityBundle(String r5, String r10, List<? extends FieldBundle> r11, PrimaryKeyBundle r12, List<? extends IndexBundle> r13, List<? extends ForeignKeyBundle> r14) {
        Intrinsics.checkNotNullParameter(r5, "tableName");
        Intrinsics.checkNotNullParameter(r10, "createSql");
        Intrinsics.checkNotNullParameter(r11, "fields");
        Intrinsics.checkNotNullParameter(r12, "primaryKey");
        Intrinsics.checkNotNullParameter(r13, "indices");
        Intrinsics.checkNotNullParameter(r14, "foreignKeys");
        this.tableName = r5;
        this.createSql = r10;
        this.fields = r11;
        this.primaryKey = r12;
        this.indices = r13;
        this.foreignKeys = r14;
        this.fieldsByColumnName$delegate = LazyKt.lazy(new EntityBundle$fieldsByColumnName$2(this));
    }

    public Collection<String> buildCreateQueries() {
        List r5 = CollectionsKt.createListBuilder();
        r5.add(createTable());
        Iterator<T> r10 = getIndices().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5.add(((IndexBundle) r10.next()).create(getTableName()));
        goto L4
    L7:
        return CollectionsKt.build(r5);
    }

    public String createNewTable() {
        return BundleUtil.replaceTableName(getCreateSql(), getNewTableName());
    }

    public String createTable() {
        return BundleUtil.replaceTableName(getCreateSql(), getTableName());
    }

    public String getCreateSql() {
        return this.createSql;
    }

    public List<FieldBundle> getFields() {
        return this.fields;
    }

    public Map<String, FieldBundle> getFieldsByColumnName() {
        return (Map) this.fieldsByColumnName$delegate.getValue();
    }

    public List<ForeignKeyBundle> getForeignKeys() {
        return this.foreignKeys;
    }

    public List<IndexBundle> getIndices() {
        return this.indices;
    }

    public String getNewTableName() {
        return NEW_TABLE_PREFIX + getTableName();
    }

    public PrimaryKeyBundle getPrimaryKey() {
        return this.primaryKey;
    }

    public String getTableName() {
        return this.tableName;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(EntityBundle r5) {
        return isSchemaEqual2(r5);
    }

    public String renameToOriginal() {
        return "ALTER TABLE " + getNewTableName() + " RENAME TO " + getTableName();
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(EntityBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(getTableName(), r5.getTableName()) == true) goto L5;
        return false;
    L5:
        SchemaEqualityUtil r10 = SchemaEqualityUtil.INSTANCE;
        if (r10.checkSchemaEquality(getFieldsByColumnName(), r5.getFieldsByColumnName()) == true) goto L8;
        return false;
    L8:
        if (r10.checkSchemaEquality(getPrimaryKey(), r5.getPrimaryKey()) == true) goto L10;
        return false;
    L10:
        if (r10.checkSchemaEquality(getIndices(), r5.getIndices()) == true) goto L12;
        return false;
    L12:
        if (r10.checkSchemaEquality(getForeignKeys(), r5.getForeignKeys()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private EntityBundle() {
        this("", "", CollectionsKt.emptyList(), new PrimaryKeyBundle(false, CollectionsKt.emptyList()), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
