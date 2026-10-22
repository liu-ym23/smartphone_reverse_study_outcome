package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0013¢\u0006\u0002\u0010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0016R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Landroidx/room/migration/bundle/ForeignKeyBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "table", "", "onDelete", "onUpdate", "columns", "", "referencedColumns", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getColumns", "()Ljava/util/List;", "getOnDelete", "()Ljava/lang/String;", "getOnUpdate", "getReferencedColumns", "getTable", "isSchemaEqual", "", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ForeignKeyBundle implements SchemaEquality<ForeignKeyBundle> {

    @SerializedName("columns")
    private final List<String> columns;

    @SerializedName("onDelete")
    private final String onDelete;

    @SerializedName("onUpdate")
    private final String onUpdate;

    @SerializedName("referencedColumns")
    private final List<String> referencedColumns;

    @SerializedName("table")
    private final String table;

    public ForeignKeyBundle(String r5, String r10, String r11, List<String> r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r5, "table");
        Intrinsics.checkNotNullParameter(r10, "onDelete");
        Intrinsics.checkNotNullParameter(r11, "onUpdate");
        Intrinsics.checkNotNullParameter(r12, "columns");
        Intrinsics.checkNotNullParameter(r13, "referencedColumns");
        this.table = r5;
        this.onDelete = r10;
        this.onUpdate = r11;
        this.columns = r12;
        this.referencedColumns = r13;
    }

    public List<String> getColumns() {
        return this.columns;
    }

    public String getOnDelete() {
        return this.onDelete;
    }

    public String getOnUpdate() {
        return this.onUpdate;
    }

    public List<String> getReferencedColumns() {
        return this.referencedColumns;
    }

    public String getTable() {
        return this.table;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(ForeignKeyBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(ForeignKeyBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(getTable(), r5.getTable()) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getOnDelete(), r5.getOnDelete()) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(getOnUpdate(), r5.getOnUpdate()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getColumns(), r5.getColumns()) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getReferencedColumns(), r5.getReferencedColumns()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private ForeignKeyBundle() {
        this("", "", "", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
