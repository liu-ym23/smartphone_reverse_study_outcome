package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007\b\u0013¢\u0006\u0002\u0010\u0002BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0001H\u0016R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/room/migration/bundle/FtsEntityBundle;", "Landroidx/room/migration/bundle/EntityBundle;", "()V", "tableName", "", "createSql", "fields", "", "Landroidx/room/migration/bundle/FieldBundle;", "primaryKey", "Landroidx/room/migration/bundle/PrimaryKeyBundle;", "ftsVersion", "ftsOptions", "Landroidx/room/migration/bundle/FtsOptionsBundle;", "contentSyncSqlTriggers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroidx/room/migration/bundle/PrimaryKeyBundle;Ljava/lang/String;Landroidx/room/migration/bundle/FtsOptionsBundle;Ljava/util/List;)V", "SHADOW_TABLE_NAME_SUFFIXES", "getContentSyncSqlTriggers", "()Ljava/util/List;", "getFtsOptions", "()Landroidx/room/migration/bundle/FtsOptionsBundle;", "getFtsVersion", "()Ljava/lang/String;", "shadowTableNames", "getShadowTableNames", "shadowTableNames$delegate", "Lkotlin/Lazy;", "buildCreateQueries", "", "isSchemaEqual", "", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FtsEntityBundle extends EntityBundle {
    private final transient List<String> SHADOW_TABLE_NAME_SUFFIXES;

    @SerializedName("contentSyncTriggers")
    private final List<String> contentSyncSqlTriggers;

    @SerializedName("ftsOptions")
    private final FtsOptionsBundle ftsOptions;

    @SerializedName("ftsVersion")
    private final String ftsVersion;
    private final transient Lazy shadowTableNames$delegate;

    public FtsEntityBundle(String r10, String r11, List<? extends FieldBundle> r12, PrimaryKeyBundle r13, String r14, FtsOptionsBundle r15, List<String> r16) {
        Intrinsics.checkNotNullParameter(r10, "tableName");
        Intrinsics.checkNotNullParameter(r11, "createSql");
        Intrinsics.checkNotNullParameter(r12, "fields");
        Intrinsics.checkNotNullParameter(r13, "primaryKey");
        Intrinsics.checkNotNullParameter(r14, "ftsVersion");
        Intrinsics.checkNotNullParameter(r15, "ftsOptions");
        Intrinsics.checkNotNullParameter(r16, "contentSyncSqlTriggers");
        super(r10, r11, r12, r13, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.ftsVersion = r14;
        this.ftsOptions = r15;
        this.contentSyncSqlTriggers = r16;
        this.SHADOW_TABLE_NAME_SUFFIXES = CollectionsKt.listOf(new String[]{"_content", "_segdir", "_segments", "_stat", "_docsize"});
        this.shadowTableNames$delegate = LazyKt.lazy(new FtsEntityBundle$shadowTableNames$2(this));
    }

    public static final /* synthetic */ List access$getSHADOW_TABLE_NAME_SUFFIXES$p(FtsEntityBundle r5) {
        return r5.SHADOW_TABLE_NAME_SUFFIXES;
    }

    @Override // androidx.room.migration.bundle.EntityBundle
    public Collection<String> buildCreateQueries() {
        List r5 = CollectionsKt.createListBuilder();
        r5.add(createTable());
        r5.addAll(getContentSyncSqlTriggers());
        return CollectionsKt.build(r5);
    }

    public List<String> getContentSyncSqlTriggers() {
        return this.contentSyncSqlTriggers;
    }

    public FtsOptionsBundle getFtsOptions() {
        return this.ftsOptions;
    }

    public String getFtsVersion() {
        return this.ftsVersion;
    }

    public List<String> getShadowTableNames() {
        return (List) this.shadowTableNames$delegate.getValue();
    }

    @Override // androidx.room.migration.bundle.EntityBundle, androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(EntityBundle r5) {
        return isSchemaEqual(r5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.room.migration.bundle.EntityBundle
    public boolean isSchemaEqual(EntityBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        boolean r10 = super.isSchemaEqual2(r5);
        if ((r5 instanceof FtsEntityBundle) == false) goto L12;
        if (r10 == false) goto L10;
        FtsEntityBundle r11 = (FtsEntityBundle) r5;
        if (Intrinsics.areEqual(getFtsVersion(), r11.getFtsVersion()) == false) goto L10;
        if (SchemaEqualityUtil.INSTANCE.checkSchemaEquality(getFtsOptions(), r11.getFtsOptions()) == false) goto L10;
        return true;
    L10:
        return false;
    L12:
        return r10;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private FtsEntityBundle() {
        this("", "", CollectionsKt.emptyList(), new PrimaryKeyBundle(false, CollectionsKt.emptyList()), "", new FtsOptionsBundle("", CollectionsKt.emptyList(), "", "", "", CollectionsKt.emptyList(), CollectionsKt.emptyList(), ""), CollectionsKt.emptyList());
    }
}
