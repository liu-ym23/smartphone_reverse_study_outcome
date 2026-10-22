package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.migration.bundle.BundleUtil;
import androidx.room.migration.bundle.EntityBundle;
import androidx.room.migration.bundle.FtsEntityBundle;
import androidx.room.parser.FtsVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J.\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J \u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u00100\u001a\u00020\u0005H\u0002J\u001a\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u000207H\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b(\u0010\u0019¨\u00068"}, d2 = {"Landroidx/room/vo/FtsEntity;", "Landroidx/room/vo/Entity;", "element", "Landroidx/room/compiler/processing/XTypeElement;", "tableName", "", "type", "Landroidx/room/compiler/processing/XType;", "fields", "", "Landroidx/room/vo/Field;", "embeddedFields", "Landroidx/room/vo/EmbeddedField;", "primaryKey", "Landroidx/room/vo/PrimaryKey;", "constructor", "Landroidx/room/vo/Constructor;", "shadowTableName", "ftsVersion", "Landroidx/room/parser/FtsVersion;", "ftsOptions", "Landroidx/room/vo/FtsOptions;", "(Landroidx/room/compiler/processing/XTypeElement;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/PrimaryKey;Landroidx/room/vo/Constructor;Ljava/lang/String;Landroidx/room/parser/FtsVersion;Landroidx/room/vo/FtsOptions;)V", "contentSyncTriggerCreateQueries", "getContentSyncTriggerCreateQueries", "()Ljava/util/List;", "contentSyncTriggerCreateQueries$delegate", "Lkotlin/Lazy;", "contentSyncTriggerNames", "getContentSyncTriggerNames", "contentSyncTriggerNames$delegate", "createTableQuery", "getCreateTableQuery", "()Ljava/lang/String;", "createTableQuery$delegate", "getFtsOptions", "()Landroidx/room/vo/FtsOptions;", "getFtsVersion", "()Landroidx/room/parser/FtsVersion;", "nonHiddenFields", "getNonHiddenFields", "nonHiddenFields$delegate", "createAfterTrigger", "triggerOp", "contentTableName", "columnNames", "createBeforeTrigger", "createSyncTriggers", "contentTable", "includeTokenizer", "", "createTriggerName", "getCreateTableQueryWithoutTokenizer", "getIdKey", "toBundle", "Landroidx/room/migration/bundle/FtsEntityBundle;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsEntity extends Entity {
    private final Lazy contentSyncTriggerCreateQueries$delegate;
    private final Lazy contentSyncTriggerNames$delegate;
    private final Lazy createTableQuery$delegate;
    private final FtsOptions ftsOptions;
    private final FtsVersion ftsVersion;
    private final Lazy nonHiddenFields$delegate;

    public FtsEntity(XTypeElement r17, final String r18, XType r19, final List<Field> r20, List<EmbeddedField> r21, final PrimaryKey r22, Constructor r23, String r24, FtsVersion r25, FtsOptions r26) {
        Intrinsics.checkNotNullParameter(r17, "element");
        Intrinsics.checkNotNullParameter(r18, "tableName");
        Intrinsics.checkNotNullParameter(r19, "type");
        Intrinsics.checkNotNullParameter(r20, "fields");
        Intrinsics.checkNotNullParameter(r21, "embeddedFields");
        Intrinsics.checkNotNullParameter(r22, "primaryKey");
        Intrinsics.checkNotNullParameter(r25, "ftsVersion");
        Intrinsics.checkNotNullParameter(r26, "ftsOptions");
        super(r17, r18, r19, r20, r21, r22, CollectionsKt.emptyList(), CollectionsKt.emptyList(), r23, r24);
        this.ftsVersion = r25;
        this.ftsOptions = r26;
        this.createTableQuery$delegate = LazyKt.lazy(new C01462(this, r18));
        this.nonHiddenFields$delegate = LazyKt.lazy(new FtsEntity$nonHiddenFields$2(r20, r22, this));
        this.contentSyncTriggerNames$delegate = LazyKt.lazy(new FtsEntity$contentSyncTriggerNames$2(this, r18));
        this.contentSyncTriggerCreateQueries$delegate = LazyKt.lazy(new FtsEntity$contentSyncTriggerCreateQueries$2(this));
    }

    public static final /* synthetic */ List access$createSyncTriggers(FtsEntity r5, String r10) {
        return r5.createSyncTriggers(r10);
    }

    public static final /* synthetic */ String access$createTriggerName(FtsEntity r5, String r10, String r11) {
        return r5.createTriggerName(r10, r11);
    }

    private final String createAfterTrigger(String r11, String r12, String r13, List<String> r14) {
        String r10 = createTriggerName(r12, j0.C("AFTER_", r11));
        String r5 = CollectionsKt.q(CollectionsKt.plus(CollectionsKt.listOf("docid"), r14), ", ", null, null, 0, null, AnonymousClass1.INSTANCE, 30);
        String r15 = CollectionsKt.q(CollectionsKt.plus(CollectionsKt.listOf("rowid"), r14), ", ", null, null, 0, null, AnonymousClass2.INSTANCE, 30);
        StringBuilder r16 = androidx.constraintlayout.motion.widget.a.y("CREATE TRIGGER IF NOT EXISTS ", r10, " AFTER ", r11, " ON `");
        androidx.constraintlayout.motion.widget.a.C(r16, r13, "` BEGIN INSERT INTO `", r12, "`(");
        return androidx.constraintlayout.motion.widget.a.u(r16, r5, ") VALUES (", r15, "); END");
    }

    private final String createBeforeTrigger(String r5, String r10, String r11) {
        return androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y("CREATE TRIGGER IF NOT EXISTS ", createTriggerName(r10, j0.C("BEFORE_", r5)), " BEFORE ", r5, " ON `"), r11, "` BEGIN DELETE FROM `", r10, "` WHERE `docid`=OLD.`rowid`; END");
    }

    private final List<String> createSyncTriggers(String r10) {
        List<Field> r5 = getNonHiddenFields();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((Field) r12.next()).getColumnName());
        goto L4
    L6:
        String[] r13 = {"UPDATE", "DELETE"};
        ArrayList r14 = new ArrayList(2);
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r16 >= 2) goto L9;
        r14.add(createBeforeTrigger(r13[r16], getTableName(), r10));
        r16 = r16 + 1;
        goto L7
    L9:
        String[] r17 = {"UPDATE", "INSERT"};
        ArrayList r18 = new ArrayList(2);
    L10:
        if (r15 >= 2) goto L13;
        r18.add(createAfterTrigger(r17[r15], getTableName(), r10, r11));
        r15 = r15 + 1;
        goto L10
    L13:
        return CollectionsKt.plus(r14, r18);
    }

    private final String createTableQuery(String r11, boolean r12) {
        List<Field> r5 = getNonHiddenFields();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r10.add(((Field) r13.next()).databaseDefinition(false));
        goto L4
    L6:
        List r14 = CollectionsKt.plus(r10, this.ftsOptions.databaseDefinition(r12));
        String r15 = this.ftsVersion.name();
        String r16 = CollectionsKt.q(r14, ", ", null, null, 0, null, null, 62);
        return j0.q(androidx.constraintlayout.motion.widget.a.y("CREATE VIRTUAL TABLE IF NOT EXISTS `", r11, "` USING ", r15, "("), r16, ")");
    }

    public static /* synthetic */ String createTableQuery$default(FtsEntity r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = true;
    L6:
        return r5.createTableQuery(r10, r11);
    }

    private final String createTriggerName(String r5, String r10) {
        return androidx.constraintlayout.motion.widget.a.p("room_fts_content_sync_", r5, "_", r10);
    }

    public final List<String> getContentSyncTriggerCreateQueries() {
        return (List) this.contentSyncTriggerCreateQueries$delegate.getValue();
    }

    public final List<String> getContentSyncTriggerNames() {
        return (List) this.contentSyncTriggerNames$delegate.getValue();
    }

    @Override // androidx.room.vo.Entity
    public String getCreateTableQuery() {
        return (String) this.createTableQuery$delegate.getValue();
    }

    public final String getCreateTableQueryWithoutTokenizer() {
        return createTableQuery(getTableName(), false);
    }

    public final FtsOptions getFtsOptions() {
        return this.ftsOptions;
    }

    public final FtsVersion getFtsVersion() {
        return this.ftsVersion;
    }

    @Override // androidx.room.vo.Entity, androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        SchemaIdentityKey r5 = new SchemaIdentityKey();
        r5.append(getTableName());
        r5.appendSorted(getFields());
        r5.append(this.ftsVersion.name());
        r5.append(this.ftsOptions);
        return r5.hash();
    }

    public final List<Field> getNonHiddenFields() {
        return (List) this.nonHiddenFields$delegate.getValue();
    }

    @Override // androidx.room.vo.Entity
    public /* bridge */ /* synthetic */ EntityBundle toBundle() {
        return toBundle();
    }

    @Override // androidx.room.vo.Entity
    public FtsEntityBundle toBundle() {
        String r5 = getTableName();
        String r10 = createTableQuery$default(this, BundleUtil.TABLE_NAME_PLACEHOLDER, false, 2, null);
        List<Field> r11 = getNonHiddenFields();
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add(((Field) r13.next()).toBundle());
        goto L4
    L7:
        return new FtsEntityBundle(r5, r10, r12, getPrimaryKey().toBundle(), this.ftsVersion.name(), this.ftsOptions.toBundle(), getContentSyncTriggerCreateQueries());
    }
}
