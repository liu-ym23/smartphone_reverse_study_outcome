package androidx.room.vo;

import androidx.room.migration.bundle.BundleUtil;
import androidx.room.migration.bundle.IndexBundle;
import androidx.room.writer.DaoWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B7\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\b¢\u0006\u0002\u0010\rB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u000e\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\b¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u000eHÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u000e2\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\bHÆ\u0001J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\b\u0010\"\u001a\u00020\u0004H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Landroidx/room/vo/Index;", "Landroidx/room/vo/HasSchemaIdentity;", "Landroidx/room/vo/HasFields;", "name", "", "unique", "", "fields", "", "Landroidx/room/vo/Field;", "orders", "Landroidx/room/Index$Order;", "Landroidx/room/vo/IndexOrder;", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "Landroidx/room/vo/Fields;", "(Ljava/lang/String;ZLandroidx/room/vo/Fields;Ljava/util/List;)V", "getFields", "()Landroidx/room/vo/Fields;", "getName", "()Ljava/lang/String;", "getOrders", "()Ljava/util/List;", "getUnique", "()Z", "component1", "component2", "component3", "component4", "copy", "createQuery", "tableName", "equals", "other", "", "getIdKey", "hashCode", "", "toBundle", "Landroidx/room/migration/bundle/IndexBundle;", "toString", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Index implements HasSchemaIdentity, HasFields {
    public static final Companion Companion = null;
    public static final String DEFAULT_PREFIX = "index_";
    private final Fields fields;
    private final String name;
    private final List<androidx.room.Index.Order> orders;
    private final boolean unique;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/vo/Index$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    /* JADX WARN: Multi-variable type inference failed */
    public Index(String r5, boolean r10, Fields r11, List<? extends androidx.room.Index.Order> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "fields");
        Intrinsics.checkNotNullParameter(r12, "orders");
        this.name = r5;
        this.unique = r10;
        this.fields = r11;
        this.orders = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Index copy$default(Index r5, String r10, boolean r11, Fields r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.name;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.unique;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.getFields();
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.orders;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.unique;
    }

    public final Fields component3() {
        return getFields();
    }

    public final List<androidx.room.Index.Order> component4() {
        return this.orders;
    }

    public final Index copy(String r5, boolean r10, Fields r11, List<? extends androidx.room.Index.Order> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "fields");
        Intrinsics.checkNotNullParameter(r12, "orders");
        return new Index(r5, r10, r11, r12);
    }

    public final String createQuery(String r14) {
        Intrinsics.checkNotNullParameter(r14, "tableName");
        if (this.unique == false) goto L5;
        String r5 = "UNIQUE INDEX";
    L7:
        if (this.orders.isEmpty() == true) goto L16;
        List<String> r10 = HasFieldsKt.getColumnNames(this);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
        int r13 = 0;
    L10:
        if (r12.hasNext() == false) goto L20;
        Object r15 = r12.next();
        int r16 = r13 + 1;
        if (r13 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r11.add("`" + ((String) r15) + "` " + this.orders.get(r13));
        r13 = r16;
    L20:
        String r17 = CollectionsKt.q(r11, ", ", null, null, 0, null, null, 62);
        StringBuilder r18 = androidx.constraintlayout.motion.widget.a.y("\n            CREATE ", r5, " IF NOT EXISTS `", this.name, "`\n            ON `");
        r18.append(r14);
        r18.append("` (");
        r18.append(r17);
        r18.append(")\n        ");
        return StringsKt.F(StringsKt.trimIndent(r18.toString()), "\n", " ");
    L16:
        List<String> r19 = HasFieldsKt.getColumnNames(this);
        r11 = new ArrayList(CollectionsKt.h(r19));
        Iterator<T> r20 = r19.iterator();
    L18:
        if (r20.hasNext() == false) goto L20;
        r11.add("`" + ((String) r20.next()) + "`");
        goto L18
    L5:
        r5 = "INDEX";
        goto L7
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Index) == true) goto L8;
        return false;
    L8:
        Index r10 = (Index) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (this.unique == r10.unique) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getFields(), r10.getFields()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.orders, r10.orders) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // androidx.room.vo.HasFields
    public Fields getFields() {
        return this.fields;
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.unique + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + this.name + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + CollectionsKt.q(HasFieldsKt.getColumnNames(this), ",", null, null, 0, null, null, 62));
        if (this.orders.isEmpty() == true) goto L6;
        r5.append(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + CollectionsKt.q(this.orders, ",", null, null, 0, null, null, 62));
    L6:
        return r5.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final List<androidx.room.Index.Order> getOrders() {
        return this.orders;
    }

    public final boolean getUnique() {
        return this.unique;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        boolean r10 = this.unique;
        ?? r11 = r10;
        if (r10 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = (r5 + r11) * 31;
        int r13 = (getFields().hashCode() + r12) * 31;
        return this.orders.hashCode() + r13;
    }

    public final IndexBundle toBundle() {
        String r5 = this.name;
        boolean r10 = this.unique;
        List<String> r11 = HasFieldsKt.getColumnNames(this);
        List<androidx.room.Index.Order> r12 = this.orders;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13.add(((androidx.room.Index.Order) r14.next()).name());
        goto L4
    L7:
        return new IndexBundle(r5, r10, r11, r13, createQuery(BundleUtil.TABLE_NAME_PLACEHOLDER));
    }

    public String toString() {
        return "Index(name=" + this.name + ", unique=" + this.unique + ", fields=" + getFields() + ", orders=" + this.orders + ")";
    }

    public Index(String r5, boolean r10, List<Field> r11, List<? extends androidx.room.Index.Order> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r11, "fields");
        Intrinsics.checkNotNullParameter(r12, "orders");
        this(r5, r10, new Fields(r11), r12);
    }
}
