package androidx.room.vo;

import androidx.room.migration.bundle.ForeignKeyBundle;
import androidx.room.writer.DaoWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0003J\b\u0010 \u001a\u00020\u0003H\u0002J\u0013\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\b\u0010$\u001a\u00020\u0003H\u0016J\t\u0010%\u001a\u00020&HÖ\u0001J\u0016\u0010'\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0002J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Landroidx/room/vo/ForeignKey;", "Landroidx/room/vo/HasSchemaIdentity;", "parentTable", "", "parentColumns", "", "childFields", "Landroidx/room/vo/Field;", "onDelete", "Landroidx/room/vo/ForeignKeyAction;", "onUpdate", "deferred", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/ForeignKeyAction;Landroidx/room/vo/ForeignKeyAction;Z)V", "getChildFields", "()Ljava/util/List;", "getDeferred", "()Z", "getOnDelete", "()Landroidx/room/vo/ForeignKeyAction;", "getOnUpdate", "getParentColumns", "getParentTable", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "databaseDefinition", "deferredDeclaration", "equals", "other", "", "getIdKey", "hashCode", "", "joinEscaped", "values", "", "toBundle", "Landroidx/room/migration/bundle/ForeignKeyBundle;", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ForeignKey implements HasSchemaIdentity {
    private final List<Field> childFields;
    private final boolean deferred;
    private final ForeignKeyAction onDelete;
    private final ForeignKeyAction onUpdate;
    private final List<String> parentColumns;
    private final String parentTable;

    public ForeignKey(String r5, List<String> r10, List<Field> r11, ForeignKeyAction r12, ForeignKeyAction r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "parentTable");
        Intrinsics.checkNotNullParameter(r10, "parentColumns");
        Intrinsics.checkNotNullParameter(r11, "childFields");
        Intrinsics.checkNotNullParameter(r12, "onDelete");
        Intrinsics.checkNotNullParameter(r13, "onUpdate");
        this.parentTable = r5;
        this.parentColumns = r10;
        this.childFields = r11;
        this.onDelete = r12;
        this.onUpdate = r13;
        this.deferred = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForeignKey copy$default(ForeignKey r5, String r10, List r11, List r12, ForeignKeyAction r13, ForeignKeyAction r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.parentTable;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.parentColumns;
    L8:
        List r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.childFields;
    L11:
        List r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.onDelete;
    L14:
        ForeignKeyAction r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.onUpdate;
    L17:
        ForeignKeyAction r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.deferred;
    L20:
        String r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    private final String deferredDeclaration() {
        if (this.deferred == false) goto L5;
        return "DEFERRABLE INITIALLY DEFERRED";
    L5:
        return "";
    }

    private final String joinEscaped(Iterable<String> r10) {
        return CollectionsKt.q(r10, ", ", null, null, 0, null, C01451.INSTANCE, 30);
    }

    public final String component1() {
        return this.parentTable;
    }

    public final List<String> component2() {
        return this.parentColumns;
    }

    public final List<Field> component3() {
        return this.childFields;
    }

    public final ForeignKeyAction component4() {
        return this.onDelete;
    }

    public final ForeignKeyAction component5() {
        return this.onUpdate;
    }

    public final boolean component6() {
        return this.deferred;
    }

    public final ForeignKey copy(String r10, List<String> r11, List<Field> r12, ForeignKeyAction r13, ForeignKeyAction r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "parentTable");
        Intrinsics.checkNotNullParameter(r11, "parentColumns");
        Intrinsics.checkNotNullParameter(r12, "childFields");
        Intrinsics.checkNotNullParameter(r13, "onDelete");
        Intrinsics.checkNotNullParameter(r14, "onUpdate");
        return new ForeignKey(r10, r11, r12, r13, r14, r15);
    }

    public final String databaseDefinition() {
        List<Field> r5 = this.childFields;
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((Field) r11.next()).getColumnName());
        goto L4
    L6:
        String r12 = joinEscaped(r10);
        String r13 = this.parentTable;
        String r14 = joinEscaped(this.parentColumns);
        String r15 = this.onUpdate.getSqlName();
        String r16 = this.onDelete.getSqlName();
        String r17 = deferredDeclaration();
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("FOREIGN KEY(", r12, ") REFERENCES `", r13, "`(");
        androidx.constraintlayout.motion.widget.a.C(r18, r14, ") ON UPDATE ", r15, " ON DELETE ");
        return androidx.constraintlayout.motion.widget.a.t(r18, r16, " ", r17);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ForeignKey) == true) goto L8;
        return false;
    L8:
        ForeignKey r10 = (ForeignKey) r5;
        if (Intrinsics.areEqual(this.parentTable, r10.parentTable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentColumns, r10.parentColumns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.childFields, r10.childFields) == true) goto L18;
        return false;
    L18:
        if (this.onDelete == r10.onDelete) goto L21;
        return false;
    L21:
        if (this.onUpdate == r10.onUpdate) goto L24;
        return false;
    L24:
        if (this.deferred == r10.deferred) goto L26;
        return false;
    L26:
        return true;
    }

    public final List<Field> getChildFields() {
        return this.childFields;
    }

    public final boolean getDeferred() {
        return this.deferred;
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        String r5 = this.parentTable;
        String r10 = CollectionsKt.q(this.parentColumns, ",", null, null, 0, null, null, 62);
        String r11 = CollectionsKt.q(this.childFields, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30);
        String r12 = this.onDelete.getSqlName();
        String r13 = this.onUpdate.getSqlName();
        boolean r14 = this.deferred;
        StringBuilder r15 = androidx.room.jarjarred.org.antlr.runtime.a.y(r5, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r10, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r11);
        androidx.constraintlayout.motion.widget.a.C(r15, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r12, DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, r13);
        r15.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        r15.append(r14);
        return r15.toString();
    }

    public final ForeignKeyAction getOnDelete() {
        return this.onDelete;
    }

    public final ForeignKeyAction getOnUpdate() {
        return this.onUpdate;
    }

    public final List<String> getParentColumns() {
        return this.parentColumns;
    }

    public final String getParentTable() {
        return this.parentTable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = this.parentTable.hashCode() * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.f(this.parentColumns, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.f(this.childFields, r10, 31);
        int r12 = (this.onDelete.hashCode() + r11) * 31;
        int r13 = (this.onUpdate.hashCode() + r12) * 31;
        boolean r14 = this.deferred;
        ?? r15 = r14;
        if (r14 == false) goto L6;
        r15 = 1;
    L6:
        return r13 + r15;
    }

    public final ForeignKeyBundle toBundle() {
        String r5 = this.parentTable;
        String r10 = this.onDelete.getSqlName();
        String r11 = this.onUpdate.getSqlName();
        List<Field> r12 = this.childFields;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13.add(((Field) r14.next()).getColumnName());
        goto L4
    L7:
        return new ForeignKeyBundle(r5, r10, r11, r13, this.parentColumns);
    }

    public String toString() {
        return "ForeignKey(parentTable=" + this.parentTable + ", parentColumns=" + this.parentColumns + ", childFields=" + this.childFields + ", onDelete=" + this.onDelete + ", onUpdate=" + this.onUpdate + ", deferred=" + this.deferred + ")";
    }
}
