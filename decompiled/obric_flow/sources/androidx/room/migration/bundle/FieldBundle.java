package androidx.room.migration.bundle;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0007\b\u0013¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0000H\u0016R\u0016\u0010\u0005\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/room/migration/bundle/FieldBundle;", "Landroidx/room/migration/bundle/SchemaEquality;", "fieldPath", "", "columnName", "affinity", "nonNull", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "()V", "isNonNull", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAffinity", "()Ljava/lang/String;", "getColumnName", "getDefaultValue", "getFieldPath", "()Z", "isSchemaEqual", "other", "room-migration"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FieldBundle implements SchemaEquality<FieldBundle> {

    @SerializedName("affinity")
    private final String affinity;

    @SerializedName("columnName")
    private final String columnName;

    @SerializedName("defaultValue")
    private final String defaultValue;

    @SerializedName("fieldPath")
    private final String fieldPath;

    @SerializedName("notNull")
    private final boolean isNonNull;

    public FieldBundle(String r5, String r10, String r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, "fieldPath");
        Intrinsics.checkNotNullParameter(r10, "columnName");
        Intrinsics.checkNotNullParameter(r11, "affinity");
        this.fieldPath = r5;
        this.columnName = r10;
        this.affinity = r11;
        this.isNonNull = r12;
        this.defaultValue = r13;
    }

    public String getAffinity() {
        return this.affinity;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getFieldPath() {
        return this.fieldPath;
    }

    public boolean isNonNull() {
        return this.isNonNull;
    }

    @Override // androidx.room.migration.bundle.SchemaEquality
    public /* bridge */ /* synthetic */ boolean isSchemaEqual(FieldBundle r5) {
        return isSchemaEqual2(r5);
    }

    /* JADX INFO: renamed from: isSchemaEqual, reason: avoid collision after fix types in other method */
    public boolean isSchemaEqual2(FieldBundle r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (isNonNull() == r5.isNonNull()) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(getColumnName(), r5.getColumnName()) == true) goto L8;
        return false;
    L8:
        String r10 = getDefaultValue();
        boolean r11 = true;
        if (r10 == null) goto L12;
        r11 = true ^ Intrinsics.areEqual(r10, r5.getDefaultValue());
    L15:
        if (r11 == false) goto L18;
        return false;
    L18:
        return Intrinsics.areEqual(getAffinity(), r5.getAffinity());
    L12:
        if (r5.getDefaultValue() != null) goto L15;
        r11 = false;
        goto L15
    }

    @Deprecated(message = "Use [FieldBundle(String, String, String, boolean, String)")
    public FieldBundle(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "fieldPath");
        Intrinsics.checkNotNullParameter(r11, "columnName");
        Intrinsics.checkNotNullParameter(r12, "affinity");
        this(r10, r11, r12, r13, null);
    }

    @Deprecated(message = "Marked deprecated to avoid usage in the codebase")
    private FieldBundle() {
        this("", "", "", false, null);
    }
}
