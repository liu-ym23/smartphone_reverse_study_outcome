package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0013¢\u0006\u0002\u0010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/room/migration/bundle/PrimaryKeyBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "isAutoGenerate", "", "columnNames", "", "", "(ZLjava/util/List;)V", "getColumnNames", "()Ljava/util/List;", "()Z", "isSchemaEqual", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PrimaryKeyBundle implements SchemaEquality<PrimaryKeyBundle> {

    @SerializedName("columnNames")
    private final List<String> columnNames;

    @SerializedName("autoGenerate")
    private final boolean isAutoGenerate;

    public PrimaryKeyBundle(boolean r5, List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "columnNames");
        this.isAutoGenerate = r5;
        this.columnNames = r10;
    }

    public List<String> getColumnNames() {
        return this.columnNames;
    }

    public boolean isAutoGenerate() {
        return this.isAutoGenerate;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(PrimaryKeyBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(PrimaryKeyBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(getColumnNames(), r5.getColumnNames()) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAutoGenerate() != r5.isAutoGenerate()) goto L7;
        return true;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private PrimaryKeyBundle() {
        this(false, CollectionsKt.emptyList());
    }
}
