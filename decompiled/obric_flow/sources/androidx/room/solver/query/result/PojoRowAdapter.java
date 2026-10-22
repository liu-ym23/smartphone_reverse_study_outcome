package androidx.room.solver.query.result;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.log.RLog;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.Table;
import androidx.room.processor.Context;
import androidx.room.processor.ProcessorErrors;
import androidx.room.solver.CodeGenScope;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.ColumnIndexVar;
import androidx.room.vo.Field;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.Pojo;
import androidx.room.vo.RelationCollector;
import androidx.room.writer.FieldReadWriteWriter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001)B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u0011H\u0016J&\u0010%\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eH\u0016J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Landroidx/room/solver/query/result/PojoRowAdapter;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "context", "Landroidx/room/processor/Context;", "info", "Landroidx/room/verifier/QueryResultInfo;", "query", "Landroidx/room/parser/ParsedQuery;", "pojo", "Landroidx/room/vo/Pojo;", "out", "Landroidx/room/compiler/processing/XType;", "(Landroidx/room/processor/Context;Landroidx/room/verifier/QueryResultInfo;Landroidx/room/parser/ParsedQuery;Landroidx/room/vo/Pojo;Landroidx/room/compiler/processing/XType;)V", "fieldsWithIndices", "", "Landroidx/room/vo/FieldWithIndex;", "indexAdapter", "Landroidx/room/solver/query/result/PojoIndexAdapter;", "mapping", "Landroidx/room/solver/query/result/PojoRowAdapter$PojoMapping;", "getMapping", "()Landroidx/room/solver/query/result/PojoRowAdapter$PojoMapping;", "getPojo", "()Landroidx/room/vo/Pojo;", "relationCollectors", "Landroidx/room/vo/RelationCollector;", "getRelationCollectors", "()Ljava/util/List;", "convert", "", "outVarName", "", "cursorVarName", "scope", "Landroidx/room/solver/CodeGenScope;", "emitRelationCollectorsReady", "getDefaultIndexAdapter", "onCursorReady", "indices", "Landroidx/room/vo/ColumnIndexVar;", "relationTableNames", "PojoMapping", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PojoRowAdapter extends QueryMappedRowAdapter {
    private final Context context;
    private List<FieldWithIndex> fieldsWithIndices;
    private final PojoIndexAdapter indexAdapter;
    private final QueryResultInfo info;
    private final PojoMapping mapping;
    private final Pojo pojo;
    private final ParsedQuery query;
    private final List<RelationCollector> relationCollectors;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Landroidx/room/solver/query/result/PojoRowAdapter$PojoMapping;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "pojo", "Landroidx/room/vo/Pojo;", "matchedFields", "", "Landroidx/room/vo/Field;", "unusedColumns", "", "unusedFields", "(Landroidx/room/vo/Pojo;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMatchedFields", "()Ljava/util/List;", "getPojo", "()Landroidx/room/vo/Pojo;", "getUnusedColumns", "getUnusedFields", "usedColumns", "getUsedColumns", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PojoMapping extends QueryMappedRowAdapter.Mapping {
        private final List<Field> matchedFields;
        private final Pojo pojo;
        private final List<String> unusedColumns;
        private final List<Field> unusedFields;
        private final List<String> usedColumns;

        public PojoMapping(Pojo r5, List<Field> r10, List<String> r11, List<Field> r12) {
            Intrinsics.checkNotNullParameter(r5, "pojo");
            Intrinsics.checkNotNullParameter(r10, "matchedFields");
            Intrinsics.checkNotNullParameter(r11, "unusedColumns");
            Intrinsics.checkNotNullParameter(r12, "unusedFields");
            this.pojo = r5;
            this.matchedFields = r10;
            this.unusedColumns = r11;
            this.unusedFields = r12;
            ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
            Iterator<T> r14 = r10.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            r13.add(((Field) r14.next()).getColumnName());
            goto L4
        L6:
            this.usedColumns = r13;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PojoMapping copy$default(PojoMapping r5, Pojo r10, List r11, List r12, List r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = r5.pojo;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = r5.matchedFields;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = r5.unusedColumns;
        L12:
            if ((r14 & 8) == 0) goto L15;
            r13 = r5.unusedFields;
        L15:
            return r5.copy(r10, r11, r12, r13);
        }

        public final Pojo component1() {
            return this.pojo;
        }

        public final List<Field> component2() {
            return this.matchedFields;
        }

        public final List<String> component3() {
            return this.unusedColumns;
        }

        public final List<Field> component4() {
            return this.unusedFields;
        }

        public final PojoMapping copy(Pojo r5, List<Field> r10, List<String> r11, List<Field> r12) {
            Intrinsics.checkNotNullParameter(r5, "pojo");
            Intrinsics.checkNotNullParameter(r10, "matchedFields");
            Intrinsics.checkNotNullParameter(r11, "unusedColumns");
            Intrinsics.checkNotNullParameter(r12, "unusedFields");
            return new PojoMapping(r5, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PojoMapping) == true) goto L8;
            return false;
        L8:
            PojoMapping r10 = (PojoMapping) r5;
            if (Intrinsics.areEqual(this.pojo, r10.pojo) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.matchedFields, r10.matchedFields) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.unusedColumns, r10.unusedColumns) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.unusedFields, r10.unusedFields) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final List<Field> getMatchedFields() {
            return this.matchedFields;
        }

        public final Pojo getPojo() {
            return this.pojo;
        }

        public final List<String> getUnusedColumns() {
            return this.unusedColumns;
        }

        public final List<Field> getUnusedFields() {
            return this.unusedFields;
        }

        @Override // androidx.room.solver.query.result.QueryMappedRowAdapter.Mapping
        public List<String> getUsedColumns() {
            return this.usedColumns;
        }

        public int hashCode() {
            int r5 = this.pojo.hashCode() * 31;
            int r10 = a.f(this.matchedFields, r5, 31);
            int r11 = a.f(this.unusedColumns, r10, 31);
            return this.unusedFields.hashCode() + r11;
        }

        public String toString() {
            return "PojoMapping(pojo=" + this.pojo + ", matchedFields=" + this.matchedFields + ", unusedColumns=" + this.unusedColumns + ", unusedFields=" + this.unusedFields + ")";
        }
    }

    public PojoRowAdapter(Context r10, QueryResultInfo r11, ParsedQuery r12, Pojo r13, XType r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "pojo");
        Intrinsics.checkNotNullParameter(r14, "out");
        super(r14);
        this.context = r10;
        this.info = r11;
        this.query = r12;
        this.pojo = r13;
        List r15 = CollectionsKt.toMutableList(r13.getFields());
        ArrayList r16 = new ArrayList();
        if (r11 == null) goto L40;
        List<ColumnInfo> r17 = r11.getColumns();
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L6:
        if (r19.hasNext() == false) goto L20;
        ColumnInfo r5 = (ColumnInfo) r19.next();
        Iterator r20 = r15.iterator();
    L8:
        Field r21 = null;
        if (r20.hasNext() == false) goto L13;
        Object r22 = r20.next();
        if (Intrinsics.areEqual(((Field) r22).getColumnName(), r5.getName()) == false) goto L8;
    L14:
        Field r23 = (Field) r22;
        if (r23 != null) goto L17;
        r16.add(r5.getName());
    L18:
        if (r21 == null) goto L6;
        r18.add(r21);
        goto L6
    L17:
        r15.remove(r23);
        r21 = r23;
        goto L18
    L13:
        r22 = null;
        goto L14
    L20:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r15.iterator();
    L22:
        if (r25.hasNext() == false) goto L27;
        Object r26 = r25.next();
        if (((Field) r26).getNonNull() == false) goto L22;
        r24.add(r26);
        goto L22
    L27:
        if (r24.isEmpty() == true) goto L38;
        RLog r27 = this.context.getLogger();
        ProcessorErrors r28 = ProcessorErrors.INSTANCE;
        x r29 = XTypeNameKt.toJavaPoet(this.pojo.getTypeName());
        ArrayList r30 = new ArrayList(CollectionsKt.h(r24));
        Iterator r31 = r24.iterator();
    L30:
        if (r31.hasNext() == false) goto L32;
        r30.add(((Field) r31.next()).getName());
        goto L30
    L32:
        List<ColumnInfo> r32 = this.info.getColumns();
        ArrayList r33 = new ArrayList(CollectionsKt.h(r32));
        Iterator<T> r34 = r32.iterator();
    L34:
        if (r34.hasNext() == false) goto L36;
        r33.add(((ColumnInfo) r34.next()).getName());
        goto L34
    L36:
        r27.e(r28.pojoMissingNonNull(r29, r30, r33), new Object[0]);
    L38:
        if (r18.isEmpty() == false) goto L45;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.cannotFindQueryResultAdapter(r14.getTypeName()), new Object[0]);
    L45:
        this.relationCollectors = RelationCollector.Companion.createCollectors(this.context, this.pojo.getRelations());
        this.mapping = new PojoMapping(this.pojo, r18, r16, r15);
        this.indexAdapter = new PojoIndexAdapter(getMapping(), this.info, this.query);
        return;
    L40:
        r18 = new ArrayList(CollectionsKt.h(r15));
        Iterator r35 = r15.iterator();
    L42:
        if (r35.hasNext() == false) goto L44;
        r18.add((Field) r35.next());
        goto L42
    L44:
        r15.clear();
        goto L45
    }

    public static final /* synthetic */ void access$convert$doReadFromCursor(PojoRowAdapter r5, String r10, String r11, CodeGenScope r12) {
        convert$doReadFromCursor(r5, r10, r11, r12);
    }

    public static final /* synthetic */ List access$getFieldsWithIndices$p(PojoRowAdapter r5) {
        return r5.fieldsWithIndices;
    }

    private static final void convert$doReadFromCursor(PojoRowAdapter r10, String r11, String r12, CodeGenScope r13) {
        FieldReadWriteWriter.Companion r5 = FieldReadWriteWriter.Companion;
        Pojo r14 = r10.pojo;
        List<FieldWithIndex> r15 = r10.fieldsWithIndices;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fieldsWithIndices");
        r15 = null;
    L5:
        r5.readFromCursor(r12, r14, r11, r15, r13, r10.relationCollectors);
    }

    private final void emitRelationCollectorsReady(String r5, CodeGenScope r10) {
        if (this.relationCollectors.isEmpty() == true) goto L19;
        Iterator<T> r11 = this.relationCollectors.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ((RelationCollector) r11.next()).writeInitCode(r10);
        goto L6
    L8:
        g r12 = r10.builder();
        r12.e(j0.k("while (", Javapoet_extKt.getL(), ".moveToNext())"), new Object[]{r5});
        Iterator<T> r13 = this.relationCollectors.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        RelationCollector r14 = (RelationCollector) r13.next();
        List<FieldWithIndex> r15 = this.fieldsWithIndices;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("fieldsWithIndices");
        r15 = null;
    L14:
        r14.writeReadParentKeyCode(r5, r15, r10);
        goto L10
    L15:
        r12.g();
        r10.builder().c(j0.j(Javapoet_extKt.getL(), ".moveToPosition(-1)"), new Object[]{r5});
        Iterator<T> r16 = this.relationCollectors.iterator();
    L17:
        if (r16.hasNext() == false) goto L25;
        ((RelationCollector) r16.next()).writeCollectionCode(r10);
        goto L17
    L25:
        return;
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void convert(final String r11, final String r12, CodeGenScope r13) {
        Intrinsics.checkNotNullParameter(r11, "outVarName");
        Intrinsics.checkNotNullParameter(r12, "cursorVarName");
        Intrinsics.checkNotNullParameter(r13, "scope");
        if (this.relationCollectors.isEmpty() == false) goto L16;
        CodeLanguage r5 = this.context.getCodeLanguage();
        final CodeLanguage r10 = CodeLanguage.KOTLIN;
        if (r5 != r10) goto L16;
        ParsedQuery r14 = this.query;
        if (r14 == null) goto L11;
        String r15 = r14.getOriginal();
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = Math.abs(r16);
        final XClassName r18 = XClassName.Companion.get("androidx.room.temp", new String[]{j0.g(r17, "PojoRowAdapter_")});
        new AnonymousClass1(this, r12, r18, r11, r10).write(this.context.getProcessingEnv());
        g r19 = r13.builder();
        String r20 = Javapoet_extKt.getL();
        String r21 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getL();
        String r23 = Javapoet_extKt.getL();
        String r24 = a.t(androidx.room.jarjarred.org.antlr.runtime.a.y(r20, " = new ", r21, "().readFromCursor(", r22), ", ", r23, ")");
        e r25 = XTypeNameKt.toJavaPoet(r18);
        List<FieldWithIndex> r110 = this.fieldsWithIndices;
        if (r110 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("fieldsWithIndices");
        r110 = null;
    L15:
        r19.c(r24, new Object[]{r11, r25, r12, CollectionsKt.q(r110, null, null, null, 0, null, PojoRowAdapter$convert$2$1.INSTANCE, 31)});
        return;
    L11:
        r16 = getOut().asTypeName().hashCode();
    L16:
        r13.builder();
        convert$doReadFromCursor(this, r12, r11, r13);
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public /* bridge */ /* synthetic */ IndexAdapter getDefaultIndexAdapter() {
        return getDefaultIndexAdapter();
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public /* bridge */ /* synthetic */ QueryMappedRowAdapter.Mapping getMapping() {
        return getMapping();
    }

    public final Pojo getPojo() {
        return this.pojo;
    }

    public final List<RelationCollector> getRelationCollectors() {
        return this.relationCollectors;
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void onCursorReady(String r10, CodeGenScope r11, List<ColumnIndexVar> r12) {
        Intrinsics.checkNotNullParameter(r10, "cursorVarName");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "indices");
        ArrayList r5 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L17;
        ColumnIndexVar r14 = (ColumnIndexVar) r13.next();
        String r15 = r14.component1();
        String r16 = r14.component2();
        Iterator<T> r17 = getMapping().getMatchedFields().iterator();
    L7:
        if (r17.hasNext() == false) goto L16;
        Field r18 = (Field) r17.next();
        if (Intrinsics.areEqual(r18.getColumnName(), r15) == false) goto L7;
        if (this.info == null) goto L13;
        boolean r19 = true;
    L14:
        r5.add(new FieldWithIndex(r18, r16, r19));
        goto L4
    L13:
        r19 = false;
        goto L14
    L16:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L17:
        this.fieldsWithIndices = r5;
        emitRelationCollectorsReady(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Iterable, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public final List<String> relationTableNames() {
        List<RelationCollector> r5 = this.relationCollectors;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        RelationCollector r12 = (RelationCollector) r11.next();
        Set<Table> r13 = r12.getLoadAllQuery().getTables();
        ?? r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator r15 = r13.iterator();
    L7:
        if (r15.hasNext() == false) goto L10;
        r14.add(((Table) r15.next()).getName());
        goto L7
    L10:
        if ((r12.getRowAdapter() instanceof PojoRowAdapter) == false) goto L12;
        r14 = CollectionsKt.plus(((PojoRowAdapter) r12.getRowAdapter()).relationTableNames(), r14);
    L12:
        CollectionsKt.a(r10, r14);
        goto L4
    L14:
        return CollectionsKt.distinct(r10);
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public PojoIndexAdapter getDefaultIndexAdapter() {
        return this.indexAdapter;
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public PojoMapping getMapping() {
        return this.mapping;
    }
}
