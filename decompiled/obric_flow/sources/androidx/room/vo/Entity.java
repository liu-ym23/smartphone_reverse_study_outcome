package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.migration.bundle.BundleUtil;
import androidx.room.migration.bundle.EntityBundle;
import androidx.room.migration.bundle.PrimaryKeyBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bq\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0018J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0016J\u0014\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0000J\b\u0010-\u001a\u00020.H\u0016R\u001b\u0010\u0019\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001b¨\u0006/"}, d2 = {"Landroidx/room/vo/Entity;", "Landroidx/room/vo/Pojo;", "Landroidx/room/vo/HasSchemaIdentity;", "Landroidx/room/vo/EntityOrView;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "tableName", "", "type", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "primaryKey", "Landroidx/room/vo/PrimaryKey;", "indices", "Landroidx/room/vo/Index;", "foreignKeys", "Landroidx/room/vo/ForeignKey;", "constructor", "Landroidx/room/vo/Constructor;", "shadowTableName", "(Landroidx/room/compiler/processing/XTypeElement;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/PrimaryKey;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/Constructor;Ljava/lang/String;)V", "createTableQuery", "getCreateTableQuery", "()Ljava/lang/String;", "createTableQuery$delegate", "Lkotlin/Lazy;", "getForeignKeys", "()Ljava/util/List;", "getIndices", "getPrimaryKey", "()Landroidx/room/vo/PrimaryKey;", "getShadowTableName", "getTableName", "createForeignKeyDefinitions", "createPrimaryKeyDefinition", "getIdKey", "isUnique", "", "columns", "shouldBeDeletedAfter", "other", "toBundle", "Landroidx/room/migration/bundle/EntityBundle;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class Entity extends Pojo implements HasSchemaIdentity, EntityOrView {
    private final Lazy createTableQuery$delegate;
    private final List<ForeignKey> foreignKeys;
    private final List<Index> indices;
    private final PrimaryKey primaryKey;
    private final String shadowTableName;
    private final String tableName;

    public Entity(XTypeElement r13, String r14, XType r15, List<Field> r16, List<EmbeddedField> r17, PrimaryKey r18, List<Index> r19, List<ForeignKey> r20, Constructor r21, String r22) {
        Intrinsics.checkNotNullParameter(r13, "element");
        Intrinsics.checkNotNullParameter(r14, "tableName");
        Intrinsics.checkNotNullParameter(r15, "type");
        Intrinsics.checkNotNullParameter(r16, "fields");
        Intrinsics.checkNotNullParameter(r17, "embeddedFields");
        Intrinsics.checkNotNullParameter(r18, "primaryKey");
        Intrinsics.checkNotNullParameter(r19, "indices");
        Intrinsics.checkNotNullParameter(r20, "foreignKeys");
        super(r13, r15, r16, r17, CollectionsKt.emptyList(), r21);
        this.tableName = r14;
        this.primaryKey = r18;
        this.indices = r19;
        this.foreignKeys = r20;
        this.shadowTableName = r22;
        this.createTableQuery$delegate = LazyKt.lazy(new AnonymousClass2(this));
    }

    public static final /* synthetic */ String access$createTableQuery(Entity r5, String r10) {
        return r5.createTableQuery(r10);
    }

    private final List<String> createForeignKeyDefinitions() {
        List<ForeignKey> r5 = this.foreignKeys;
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((ForeignKey) r11.next()).databaseDefinition());
        goto L4
    L6:
        return r10;
    }

    private final String createPrimaryKeyDefinition() {
        if (this.primaryKey.getFields().isEmpty() == false) goto L5;
    L8:
        return null;
    L5:
        if (this.primaryKey.getAutoGenerateId() == true) goto L8;
        return j0.k("PRIMARY KEY(", CollectionsKt.q(HasFieldsKt.getColumnNames(this.primaryKey), ", ", null, null, 0, null, Entity$createPrimaryKeyDefinition$keys$1.INSTANCE, 30), ")");
    }

    private final String createTableQuery(String r10) {
        Fields r5 = getFields();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<Field> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        Field r13 = r12.next();
        if (this.primaryKey.getAutoGenerateId() == true) goto L8;
    L10:
        boolean r14 = false;
    L11:
        r11.add(r13.databaseDefinition(r14));
        goto L4
    L8:
        if (this.primaryKey.getFields().contains(r13) == false) goto L10;
        r14 = true;
        goto L11
    L13:
        return j0.l("CREATE TABLE IF NOT EXISTS `", r10, "` (", CollectionsKt.q(CollectionsKt.m(CollectionsKt.plus(CollectionsKt.plus(r11, createPrimaryKeyDefinition()), createForeignKeyDefinitions())), ", ", null, null, 0, null, null, 62), ")");
    }

    public String getCreateTableQuery() {
        return (String) this.createTableQuery$delegate.getValue();
    }

    public final List<ForeignKey> getForeignKeys() {
        return this.foreignKeys;
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        SchemaIdentityKey r5 = new SchemaIdentityKey();
        r5.append(getTableName());
        r5.append(this.primaryKey);
        r5.appendSorted(getFields());
        r5.appendSorted(this.indices);
        r5.appendSorted(this.foreignKeys);
        return r5.hash();
    }

    public final List<Index> getIndices() {
        return this.indices;
    }

    public final PrimaryKey getPrimaryKey() {
        return this.primaryKey;
    }

    public final String getShadowTableName() {
        return this.shadowTableName;
    }

    @Override // androidx.room.vo.EntityOrView
    public String getTableName() {
        return this.tableName;
    }

    public final boolean isUnique(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "columns");
        if (HasFieldsKt.getColumnNames(this.primaryKey).size() == r10.size()) goto L5;
    L7:
        List<Index> r5 = this.indices;
        if (r5 != null) goto L10;
    L12:
        Iterator<T> r11 = r5.iterator();
    L14:
        if (r11.hasNext() == false) goto L21;
        Index r12 = (Index) r11.next();
        if (r12.getUnique() == false) goto L14;
        if (r12.getFields().size() != r10.size()) goto L14;
        if (HasFieldsKt.getColumnNames(r12).containsAll(r10) == false) goto L14;
        return true;
    L21:
        return false;
    L10:
        if (r5.isEmpty() == false) goto L12;
    L5:
        if (HasFieldsKt.getColumnNames(this.primaryKey).containsAll(r10) == false) goto L7;
        return true;
    }

    public final boolean shouldBeDeletedAfter(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        List<ForeignKey> r10 = this.foreignKeys;
        if (r10 != null) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L28;
        ForeignKey r12 = (ForeignKey) r11.next();
        if (Intrinsics.areEqual(r12.getParentTable(), r5.getTableName()) == false) goto L9;
        if (r12.getDeferred() == true) goto L17;
        if (r12.getOnDelete() != ForeignKeyAction.NO_ACTION) goto L17;
    L18:
        return true;
    L17:
        if (r12.getOnDelete() != ForeignKeyAction.RESTRICT) goto L9;
    L28:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public EntityBundle toBundle() {
        String r5 = getTableName();
        String r10 = createTableQuery(BundleUtil.TABLE_NAME_PLACEHOLDER);
        Fields r11 = getFields();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<Field> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(r13.next().toBundle());
        goto L4
    L6:
        PrimaryKeyBundle r14 = this.primaryKey.toBundle();
        List<Index> r15 = this.indices;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r16.add(((Index) r17.next()).toBundle());
        goto L8
    L10:
        List<ForeignKey> r18 = this.foreignKeys;
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator<T> r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L15;
        r19.add(((ForeignKey) r20.next()).toBundle());
        goto L12
    L15:
        return new EntityBundle(r5, r10, r12, r14, r16, r19);
    }
}
