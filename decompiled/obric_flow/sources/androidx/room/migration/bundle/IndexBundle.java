package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import androidx.room.Index;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB\u0007\b\u0013¢\u0006\u0002\u0010\nB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0017J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0000H\u0016R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/room/migration/bundle/IndexBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "name", "", "unique", "", "columnNames", "", "createSql", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;)V", "()V", "isUnique", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getColumnNames", "()Ljava/util/List;", "getCreateSql", "()Ljava/lang/String;", "()Z", "getName", "getOrders", "create", "tableName", "isSchemaEqual", "other", "Companion", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class IndexBundle implements SchemaEquality<IndexBundle> {
    public static final Companion Companion = null;
    public static final String DEFAULT_PREFIX = "index_";

    @SerializedName("columnNames")
    private final List<String> columnNames;

    @SerializedName("createSql")
    private final String createSql;

    @SerializedName("unique")
    private final boolean isUnique;

    @SerializedName("name")
    private final String name;

    @SerializedName("orders")
    private final List<String> orders;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/migration/bundle/IndexBundle$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public IndexBundle(String r5, boolean r10, List<String> r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r13, "createSql");
        this.name = r5;
        this.isUnique = r10;
        this.columnNames = r11;
        this.orders = r12;
        this.createSql = r13;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String create(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tableName");
        return BundleUtil.replaceTableName(getCreateSql(), r5);
    }

    public List<String> getColumnNames() {
        return this.columnNames;
    }

    public String getCreateSql() {
        return this.createSql;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOrders() {
        return this.orders;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(IndexBundle r5) {
        return isSchemaEqual2(r5);
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public String getCreateSql(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tableName");
        return BundleUtil.replaceTableName(getCreateSql(), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(IndexBundle r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (isUnique() == r10.isUnique()) goto L6;
        return false;
    L6:
        if (StringsKt.P(getName(), "index_") == false) goto L11;
        if (StringsKt.P(r10.getName(), "index_") == true) goto L17;
        return false;
    L17:
        if (getColumnNames() == null) goto L20;
        boolean r5 = !Intrinsics.areEqual(getColumnNames(), r10.getColumnNames());
    L23:
        if (r5 == false) goto L25;
        return false;
    L25:
        List<String> r11 = getColumnNames();
        if (r11 == null) goto L28;
        int r12 = r11.size();
    L29:
        List<String> r13 = getOrders();
        if (r13 != null) goto L32;
    L35:
        boolean r14 = true;
    L36:
        if (r14 == false) goto L40;
        Object r15 = new ArrayList(r12);
        int r16 = 0;
    L38:
        if (r16 >= r12) goto L41;
        r15.add(Index.Order.ASC.name());
        r16 = r16 + 1;
    L41:
        List<String> r17 = r10.getOrders();
        if (r17 != null) goto L44;
    L47:
        boolean r18 = true;
    L48:
        if (r18 == false) goto L52;
        Object r19 = new ArrayList(r12);
        int r20 = 0;
    L50:
        if (r20 >= r12) goto L54;
        r19.add(Index.Order.ASC.name());
        r20 = r20 + 1;
    L54:
        if (Intrinsics.areEqual(r15, r19) == true) goto L56;
        return false;
    L56:
        return true;
    L52:
        r19 = r10.getOrders();
        goto L54
    L44:
        if (r17.isEmpty() == true) goto L47;
        r18 = false;
        goto L48
    L40:
        r15 = getOrders();
        goto L41
    L32:
        if (r13.isEmpty() == true) goto L35;
        r14 = false;
        goto L36
    L28:
        r12 = 0;
        goto L29
    L20:
        if (r10.getColumnNames() == null) goto L22;
        r5 = true;
        goto L23
    L22:
        r5 = false;
        goto L23
    L11:
        if (StringsKt.P(r10.getName(), "index_") == false) goto L14;
        return false;
    L14:
        if (getName().equals(r10.getName()) == true) goto L17;
        return false;
    }

    @Deprecated(message = "Use {@link #IndexBundle(String, boolean, List, List, String)}")
    public IndexBundle(String r10, boolean r11, List<String> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "columnNames");
        Intrinsics.checkNotNullParameter(r13, "createSql");
        this(r10, r11, r12, null, r13);
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private IndexBundle() {
        this("", false, CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");
    }
}
