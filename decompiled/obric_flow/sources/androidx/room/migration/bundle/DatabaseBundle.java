package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0000H\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001c\u0010\u0013¨\u0006#"}, d2 = {"Landroidx/room/migration/bundle/DatabaseBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "version", "", "identityHash", "", "entities", "", "Landroidx/room/migration/bundle/EntityBundle;", "views", "Landroidx/room/migration/bundle/DatabaseViewBundle;", "setupQueries", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEntities", "()Ljava/util/List;", "entitiesByTableName", "", "getEntitiesByTableName", "()Ljava/util/Map;", "entitiesByTableName$delegate", "Lkotlin/Lazy;", "getIdentityHash", "()Ljava/lang/String;", "getVersion", "()I", "getViews", "viewsByName", "getViewsByName", "viewsByName$delegate", "buildCreateQueries", "isSchemaEqual", "", "other", "FtsEntityCreateComparator", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DatabaseBundle implements SchemaEquality<DatabaseBundle> {

    @SerializedName("entities")
    private final List<EntityBundle> entities;
    private final transient Lazy entitiesByTableName$delegate;

    @SerializedName("identityHash")
    private final String identityHash;

    @SerializedName("setupQueries")
    private final List<String> setupQueries;

    @SerializedName("version")
    private final int version;

    @SerializedName("views")
    private final List<DatabaseViewBundle> views;
    private final transient Lazy viewsByName$delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/migration/bundle/DatabaseBundle$FtsEntityCreateComparator;", "Ljava/util/Comparator;", "Landroidx/room/migration/bundle/EntityBundle;", "Lkotlin/Comparator;", "()V", "compare", "", "firstEntity", "secondEntity", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FtsEntityCreateComparator implements Comparator<EntityBundle> {
        public FtsEntityCreateComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(EntityBundle r5, EntityBundle r10) {
            return compare2(r5, r10);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(EntityBundle r5, EntityBundle r10) {
            Intrinsics.checkNotNullParameter(r5, "firstEntity");
            Intrinsics.checkNotNullParameter(r10, "secondEntity");
            if ((r5 instanceof FtsEntityBundle) == false) goto L9;
            if (Intrinsics.areEqual(((FtsEntityBundle) r5).getFtsOptions().getContentTable(), r10.getTableName()) == false) goto L14;
            return 1;
        L14:
            return 0;
        L9:
            if ((r10 instanceof FtsEntityBundle) == true) goto L11;
            return 0;
        L11:
            if (Intrinsics.areEqual(((FtsEntityBundle) r10).getFtsOptions().getContentTable(), r5.getTableName()) == false) goto L17;
            return -1;
        L17:
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DatabaseBundle(int r5, String r10, List<? extends EntityBundle> r11, List<? extends DatabaseViewBundle> r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r10, "identityHash");
        Intrinsics.checkNotNullParameter(r11, "entities");
        Intrinsics.checkNotNullParameter(r12, "views");
        Intrinsics.checkNotNullParameter(r13, "setupQueries");
        this.version = r5;
        this.identityHash = r10;
        this.entities = r11;
        this.views = r12;
        this.setupQueries = r13;
        this.entitiesByTableName$delegate = LazyKt.lazy(new DatabaseBundle$entitiesByTableName$2(this));
        this.viewsByName$delegate = LazyKt.lazy(new DatabaseBundle$viewsByName$2(this));
    }

    public List<String> buildCreateQueries() {
        List r5 = CollectionsKt.createListBuilder();
        Iterator r10 = CollectionsKt.sortedWith(getEntities(), new FtsEntityCreateComparator()).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.addAll(((EntityBundle) r10.next()).buildCreateQueries());
        goto L4
    L6:
        Iterator<T> r11 = getViews().iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r5.add(((DatabaseViewBundle) r11.next()).createView());
        goto L8
    L10:
        r5.addAll(this.setupQueries);
        return CollectionsKt.build(r5);
    }

    public List<EntityBundle> getEntities() {
        return this.entities;
    }

    public Map<String, EntityBundle> getEntitiesByTableName() {
        return (Map) this.entitiesByTableName$delegate.getValue();
    }

    public String getIdentityHash() {
        return this.identityHash;
    }

    public int getVersion() {
        return this.version;
    }

    public List<DatabaseViewBundle> getViews() {
        return this.views;
    }

    public final Map<String, DatabaseViewBundle> getViewsByName() {
        return (Map) this.viewsByName$delegate.getValue();
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(DatabaseBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(DatabaseBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        SchemaEqualityUtil r10 = SchemaEqualityUtil.INSTANCE;
        if (r10.checkSchemaEquality(getEntitiesByTableName(), r5.getEntitiesByTableName()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.checkSchemaEquality(getViewsByName(), r5.getViewsByName()) == false) goto L7;
        return true;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    public DatabaseBundle() {
        this(0, "", CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
