package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0013¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"Landroidx/room/migration/bundle/DatabaseViewBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "()V", "viewName", "", "createSql", "(Ljava/lang/String;Ljava/lang/String;)V", "getCreateSql", "()Ljava/lang/String;", "getViewName", "createView", "isSchemaEqual", "", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DatabaseViewBundle implements SchemaEquality<DatabaseViewBundle> {

    @SerializedName("createSql")
    private final String createSql;

    @SerializedName("viewName")
    private final String viewName;

    public DatabaseViewBundle(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "viewName");
        Intrinsics.checkNotNullParameter(r10, "createSql");
        this.viewName = r5;
        this.createSql = r10;
    }

    public String createView() {
        return BundleUtil.replaceViewName(getCreateSql(), getViewName());
    }

    public String getCreateSql() {
        return this.createSql;
    }

    public String getViewName() {
        return this.viewName;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(DatabaseViewBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(DatabaseViewBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(getViewName(), r5.getViewName()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getCreateSql(), r5.getCreateSql()) == false) goto L7;
        return true;
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private DatabaseViewBundle() {
        this("", "");
    }
}
