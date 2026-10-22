package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.processing.XElement;
import androidx.room.migration.bundle.PrimaryKeyBundle;
import androidx.room.writer.DaoWriter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0018J\t\u0010\u001e\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/room/vo/PrimaryKey;", "Landroidx/room/vo/HasSchemaIdentity;", "Landroidx/room/vo/HasFields;", "declaredIn", "Landroidx/room/compiler/processing/XElement;", "fields", "Landroidx/room/vo/Fields;", "autoGenerateId", "", "(Landroidx/room/compiler/processing/XElement;Landroidx/room/vo/Fields;Z)V", "getAutoGenerateId", "()Z", "getDeclaredIn", "()Landroidx/room/compiler/processing/XElement;", "getFields", "()Landroidx/room/vo/Fields;", "component1", "component2", "component3", "copy", "equals", "other", "", "getIdKey", "", "hashCode", "", "toBundle", "Landroidx/room/migration/bundle/PrimaryKeyBundle;", "toHumanReadableString", "toString", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PrimaryKey implements HasSchemaIdentity, HasFields {
    public static final Companion Companion = null;
    private static final PrimaryKey MISSING = null;
    private final boolean autoGenerateId;
    private final XElement declaredIn;
    private final Fields fields;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/vo/PrimaryKey$Companion;", "", "()V", "MISSING", "Landroidx/room/vo/PrimaryKey;", "getMISSING", "()Landroidx/room/vo/PrimaryKey;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final PrimaryKey getMISSING() {
            return PrimaryKey.access$getMISSING$cp();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.room.vo.PrimaryKey$toHumanReadableString$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Field, String> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, Field.class, "getPath", "getPath()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Field r5) {
            return invoke2(r5);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Field r5) {
            Intrinsics.checkNotNullParameter(r5, "p0");
            return r5.getPath();
        }
    }

    static {
        Companion = new Companion(null);
        MISSING = new PrimaryKey(null, new Fields(null, 1, null), false);
    }

    public PrimaryKey(XElement r5, Fields r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "fields");
        this.declaredIn = r5;
        this.fields = r10;
        this.autoGenerateId = r11;
    }

    public static final /* synthetic */ PrimaryKey access$getMISSING$cp() {
        return MISSING;
    }

    public static /* synthetic */ PrimaryKey copy$default(PrimaryKey r5, XElement r10, Fields r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.declaredIn;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.getFields();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.autoGenerateId;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final XElement component1() {
        return this.declaredIn;
    }

    public final Fields component2() {
        return getFields();
    }

    public final boolean component3() {
        return this.autoGenerateId;
    }

    public final PrimaryKey copy(XElement r5, Fields r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "fields");
        return new PrimaryKey(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PrimaryKey) == true) goto L8;
        return false;
    L8:
        PrimaryKey r10 = (PrimaryKey) r5;
        if (Intrinsics.areEqual(this.declaredIn, r10.declaredIn) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getFields(), r10.getFields()) == true) goto L15;
        return false;
    L15:
        if (this.autoGenerateId == r10.autoGenerateId) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean getAutoGenerateId() {
        return this.autoGenerateId;
    }

    public final XElement getDeclaredIn() {
        return this.declaredIn;
    }

    @Override // androidx.room.vo.HasFields
    public Fields getFields() {
        return this.fields;
    }

    @Override // androidx.room.vo.HasSchemaIdentity
    public String getIdKey() {
        return this.autoGenerateId + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + HasFieldsKt.getColumnNames(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        XElement r5 = this.declaredIn;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = getFields().hashCode();
        int r12 = (r11 + (r10 * 31)) * 31;
        boolean r13 = this.autoGenerateId;
        ?? r14 = r13;
        if (r13 == false) goto L10;
        r14 = 1;
    L10:
        return r12 + r14;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public final PrimaryKeyBundle toBundle() {
        return new PrimaryKeyBundle(this.autoGenerateId, HasFieldsKt.getColumnNames(this));
    }

    public final String toHumanReadableString() {
        return j0.k("PrimaryKey[", CollectionsKt.q(getFields(), ", ", null, null, 0, null, AnonymousClass1.INSTANCE, 30), "]");
    }

    public String toString() {
        XElement r5 = this.declaredIn;
        Fields r10 = getFields();
        boolean r11 = this.autoGenerateId;
        StringBuilder r12 = new StringBuilder("PrimaryKey(declaredIn=");
        r12.append(r5);
        r12.append(", fields=");
        r12.append(r10);
        r12.append(", autoGenerateId=");
        return j0.r(r12, r11, ")");
    }
}
