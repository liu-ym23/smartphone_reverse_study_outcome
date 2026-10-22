package androidx.room.writer;

import ai.j0;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.String_extKt;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.solver.types.CursorValueReader;
import androidx.room.solver.types.StatementValueBinder;
import androidx.room.vo.CallType;
import androidx.room.vo.Constructor;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Field;
import androidx.room.vo.FieldGetter;
import androidx.room.vo.FieldSetter;
import androidx.room.vo.FieldWithIndex;
import androidx.room.vo.Pojo;
import androidx.room.vo.RelationCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/room/writer/FieldReadWriteWriter;", "", "fieldWithIndex", "Landroidx/room/vo/FieldWithIndex;", "(Landroidx/room/vo/FieldWithIndex;)V", "alwaysExists", "", "getAlwaysExists", "()Z", "field", "Landroidx/room/vo/Field;", "getField", "()Landroidx/room/vo/Field;", "indexVar", "", "getIndexVar", "()Ljava/lang/String;", "bindToStatement", "", "ownerVar", "stmtParamVar", "scope", "Landroidx/room/solver/CodeGenScope;", "readFromCursor", "cursorVar", "readIntoTmpVar", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "Companion", "Node", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FieldReadWriteWriter {
    public static final Companion Companion = null;
    private final boolean alwaysExists;
    private final Field field;
    private final String indexVar;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ`\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\tJB\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t¨\u0006%"}, d2 = {"Landroidx/room/writer/FieldReadWriteWriter$Companion;", "", "()V", "bindToStatement", "", "ownerVar", "", "stmtParamVar", "fieldsWithIndices", "", "Landroidx/room/vo/FieldWithIndex;", "scope", "Landroidx/room/solver/CodeGenScope;", "construct", "outVar", "constructor", "Landroidx/room/vo/Constructor;", "typeName", "Landroidx/room/compiler/codegen/XTypeName;", "localVariableNames", "", "localEmbeddeds", "Landroidx/room/writer/FieldReadWriteWriter$Node;", "localRelations", "Landroidx/room/vo/Field;", "createNodeTree", "rootVar", "getAllParents", "", "Landroidx/room/vo/EmbeddedField;", "fields", "readFromCursor", "outPojo", "Landroidx/room/vo/Pojo;", "cursorVar", "relationCollectors", "Landroidx/room/vo/RelationCollector;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private static final void bindToStatement$visitNode(CodeGenScope r5, String r10, Node r11) {
            EmbeddedField r12 = r11.getFieldParent();
            if (r12 == null) goto L9;
            FieldGetter r13 = r12.getGetter();
            Node r14 = r11.getParentNode();
            Intrinsics.checkNotNull(r14);
            r13.writeGet(r14.getVarName(), r11.getVarName(), r5.getBuilder());
            XCodeBlock.Builder r15 = r5.getBuilder();
            r15.beginControlFlow("if (%L != null)", new Object[]{r11.getVarName()});
            bindToStatement$visitNode$bindWithDescendants(r11, r10, r5);
            XCodeBlock.Builder r16 = r15.nextControlFlow("else", new Object[0]);
            Iterator<T> r17 = r11.allFields().iterator();
        L6:
            if (r17.hasNext() == false) goto L8;
            r16.addStatement("%L.bindNull(%L)", new Object[]{r10, ((FieldWithIndex) r17.next()).getIndexVar()});
            goto L6
        L8:
            r15.endControlFlow();
            return;
        L9:
            bindToStatement$visitNode$bindWithDescendants(r11, r10, r5);
        }

        private static final void bindToStatement$visitNode$bindWithDescendants(Node r5, String r10, CodeGenScope r11) {
            Iterator<T> r12 = r5.getDirectFields().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            FieldReadWriteWriter.access$bindToStatement(new FieldReadWriteWriter((FieldWithIndex) r12.next()), r5.getVarName(), r10, r11);
            goto L4
        L6:
            Iterator<T> r13 = r5.getSubNodes().iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            bindToStatement$visitNode(r11, r10, (Node) r13.next());
            goto L8
        }

        private final void construct(String r10, Constructor r11, XTypeName r12, Map<String, FieldWithIndex> r13, List<Node> r14, Map<String, Field> r15, CodeGenScope r16) {
            if (r11 != null) goto L5;
            r16.getBuilder().addStatement("%L = %L", new Object[]{r10, XCodeBlock.Companion.ofNewInstance$default(XCodeBlock.Companion, r16.getLanguage(), r12, null, new Object[0], 4, null)});
            return;
        L5:
            List<Constructor.Param> r17 = r11.getParams();
            ArrayList r5 = new ArrayList(CollectionsKt.h(r17));
            Iterator<T> r18 = r17.iterator();
        L7:
            if (r18.hasNext() == false) goto L47;
            Constructor.Param r19 = (Constructor.Param) r18.next();
            String r20 = null;
            if ((r19 instanceof Constructor.Param.FieldParam) == false) goto L21;
            Iterator<T> r21 = r13.entrySet().iterator();
        L12:
            if (r21.hasNext() == false) goto L16;
            Object r22 = r21.next();
            if (((FieldWithIndex) ((Map.Entry) r22).getValue()).getField() != ((Constructor.Param.FieldParam) r19).getField()) goto L12;
        L17:
            Map.Entry r23 = (Map.Entry) r22;
            if (r23 == null) goto L44;
            r20 = (String) r23.getKey();
        L44:
            r5.add(r20);
            goto L7
        L16:
            r22 = null;
            goto L17
        L21:
            if ((r19 instanceof Constructor.Param.EmbeddedParam) == false) goto L33;
            Iterator<T> r24 = r14.iterator();
        L24:
            if (r24.hasNext() == false) goto L28;
            Object r25 = r24.next();
            if (Intrinsics.areEqual(((Node) r25).getFieldParent(), ((Constructor.Param.EmbeddedParam) r19).getEmbedded()) == false) goto L24;
        L29:
            Node r26 = (Node) r25;
            if (r26 == null) goto L44;
            r20 = r26.getVarName();
            goto L44
        L28:
            r25 = null;
            goto L29
        L33:
            if ((r19 instanceof Constructor.Param.RelationParam) == false) goto L46;
            Iterator<T> r27 = r15.entrySet().iterator();
        L36:
            if (r27.hasNext() == false) goto L40;
            Object r28 = r27.next();
            if (((Map.Entry) r28).getValue() != ((Constructor.Param.RelationParam) r19).getRelation().getField()) goto L36;
        L41:
            Map.Entry r29 = (Map.Entry) r28;
            if (r29 == null) goto L44;
            r20 = (String) r29.getKey();
            goto L44
        L40:
            r28 = null;
            goto L41
        L46:
            throw new NoWhenBranchMatchedException();
        L47:
            r11.writeConstructor(r10, CollectionsKt.q(r5, ",", null, null, 0, null, FieldReadWriteWriter$Companion$construct$args$1.INSTANCE, 30), r16.getBuilder());
        }

        private final Node createNodeTree(String r10, List<FieldWithIndex> r11, CodeGenScope r12) {
            ArrayList r5 = new ArrayList(CollectionsKt.h(r11));
            Iterator<T> r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r5.add(((FieldWithIndex) r13.next()).getField());
            goto L4
        L6:
            Set<EmbeddedField> r14 = getAllParents(r5);
            Node r15 = new Node(r10, null);
            ArrayList r16 = new ArrayList();
            Iterator<T> r17 = r11.iterator();
        L8:
            if (r17.hasNext() == false) goto L12;
            Object r18 = r17.next();
            if (((FieldWithIndex) r18).getField().getParent() != null) goto L8;
            r16.add(r18);
            goto L8
        L12:
            r15.setDirectFields(r16);
            Set<EmbeddedField> r19 = r14;
            LinkedHashMap r20 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r19)), 16));
            Iterator<T> r21 = r19.iterator();
        L14:
            if (r21.hasNext() == false) goto L16;
            Object r22 = r21.next();
            EmbeddedField r23 = (EmbeddedField) r22;
            r20.put(r22, new Node(r12.getTmpVar(CodeGenScope.TMP_VAR_DEFAULT_PREFIX + String_extKt.capitalize(r23.getField().getName(), Locale.US)), r23));
            goto L14
        L16:
            Iterator r24 = r20.values().iterator();
        L18:
            if (r24.hasNext() == false) goto L31;
            Node r110 = (Node) r24.next();
            EmbeddedField r25 = r110.getFieldParent();
            Intrinsics.checkNotNull(r25);
            EmbeddedField r26 = r25.getParent();
            if (r26 == null) goto L23;
            Node r27 = (Node) r20.get(r26);
            if (r27 == null) goto L23;
        L24:
            ArrayList r28 = new ArrayList();
            Iterator<T> r29 = r11.iterator();
        L26:
            if (r29.hasNext() == false) goto L30;
            Object r30 = r29.next();
            if (Intrinsics.areEqual(((FieldWithIndex) r30).getField().getParent(), r25) == false) goto L26;
            r28.add(r30);
            goto L26
        L30:
            r110.setDirectFields(r28);
            r110.setParentNode(r27);
            r27.getSubNodes().add(r110);
        L23:
            r27 = r15;
            goto L24
        L31:
            return r15;
        }

        private static final void getAllParents$addAllParents(Set<EmbeddedField> r5, Field r10) {
            EmbeddedField r11 = r10.getParent();
        L3:
            if (r11 == null) goto L7;
            if (r5.add(r11) == false) goto L10;
            r11 = r11.getParent();
            goto L3
        L10:
            return;
        }

        private static final void readFromCursor$visitNode$31(CodeGenScope r12, List<RelationCollector> r13, Pojo r14, final String r15, List<FieldWithIndex> r16, Node r17) {
            EmbeddedField r5 = r17.getFieldParent();
            if (r5 != null) goto L5;
            readFromCursor$visitNode$31$readNode(r17, r13, r5, r12, r14, r15, r16);
            return;
        L5:
            XCodeBlock.Builder.addLocalVariable$default(r12.getBuilder(), r17.getVarName(), r5.getPojo().getTypeName(), false, null, 12, null);
            if (r5.getNonNull() == false) goto L8;
            readFromCursor$visitNode$31$readNode(r17, r13, r5, r12, r14, r15, r16);
            return;
        L8:
            String r10 = CollectionsKt.q(r17.allFields(), " && ", null, null, 0, null, new FieldReadWriteWriter$Companion$readFromCursor$visitNode$allNullCheck$1(r15), 30);
            XCodeBlock.Builder r11 = r12.getBuilder();
            r11.beginControlFlow("if (!(%L))", new Object[]{r10});
            readFromCursor$visitNode$31$readNode(r17, r13, r5, r12, r14, r15, r16);
            r11.nextControlFlow("else", new Object[0]).addStatement("%L = null", new Object[]{r17.getVarName()});
            r11.endControlFlow();
        }

        private static final void readFromCursor$visitNode$31$readNode(Node r12, List<RelationCollector> r13, EmbeddedField r14, CodeGenScope r15, Pojo r16, String r17, List<FieldWithIndex> r18) {
            List<FieldWithIndex> r5 = r12.getDirectFields();
            ArrayList r10 = new ArrayList();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            Object r19 = r11.next();
            if (((FieldWithIndex) r19).getField().getSetter().getCallType() != CallType.CONSTRUCTOR) goto L4;
            r10.add(r19);
            goto L4
        L8:
            LinkedHashMap r110 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r10)), 16));
            Iterator r20 = r10.iterator();
        L10:
            if (r20.hasNext() == false) goto L12;
            Object r21 = r20.next();
            FieldWithIndex r22 = (FieldWithIndex) r21;
            r110.put(new FieldReadWriteWriter(r22).readIntoTmpVar(r17, r22.getField().getSetter().getType().asTypeName(), r15), r21);
            goto L10
        L12:
            Iterator<T> r111 = r12.getSubNodes().iterator();
        L14:
            if (r111.hasNext() == false) goto L16;
            readFromCursor$visitNode$31(r15, r13, r16, r17, r18, (Node) r111.next());
            goto L14
        L16:
            ArrayList r23 = new ArrayList();
            Iterator<T> r24 = r13.iterator();
        L18:
            if (r24.hasNext() == false) goto L22;
            Object r25 = r24.next();
            if (((RelationCollector) r25).component1().getField().getParent() != r14) goto L18;
            r23.add(r25);
            goto L18
        L22:
            LinkedHashMap r112 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r23)), 16));
            Iterator r26 = r23.iterator();
        L24:
            if (r26.hasNext() == false) goto L26;
            Pair<String, Field> r27 = ((RelationCollector) r26.next()).writeReadCollectionIntoTmpVar(r17, r18, r15);
            r112.put(r27.getFirst(), r27.getSecond());
            goto L24
        L26:
            if (r14 == null) goto L28;
            FieldReadWriteWriter.Companion.construct(r12.getVarName(), r14.getPojo().getConstructor(), r14.getField().getTypeName(), r110, r12.getSubNodes(), r112, r15);
        L29:
            List<FieldWithIndex> r28 = r12.getDirectFields();
            ArrayList r29 = new ArrayList();
            Iterator<T> r30 = r28.iterator();
        L31:
            if (r30.hasNext() == false) goto L36;
            Object r31 = r30.next();
            if (((FieldWithIndex) r31).getField().getSetter().getCallType() == CallType.CONSTRUCTOR) goto L31;
            r29.add(r31);
            goto L31
        L36:
            Iterator r32 = r29.iterator();
        L38:
            if (r32.hasNext() == false) goto L40;
            FieldReadWriteWriter.access$readFromCursor(new FieldReadWriteWriter((FieldWithIndex) r32.next()), r12.getVarName(), r17, r15);
            goto L38
        L40:
            List<Node> r33 = r12.getSubNodes();
            ArrayList r34 = new ArrayList();
            Iterator<T> r35 = r33.iterator();
        L42:
            if (r35.hasNext() == false) goto L53;
            Node r36 = (Node) r35.next();
            EmbeddedField r37 = r36.getFieldParent();
            Pair r38 = null;
            if (r37 == null) goto L46;
            FieldSetter r39 = r37.getSetter();
        L47:
            if (r39 != null) goto L49;
        L51:
            if (r38 == null) goto L42;
            r34.add(r38);
            goto L42
        L49:
            if (r39.getCallType() == CallType.CONSTRUCTOR) goto L51;
            r38 = new Pair(r36.getVarName(), r39);
            goto L51
        L46:
            r39 = null;
            goto L47
        L53:
            Iterator r40 = r34.iterator();
        L55:
            if (r40.hasNext() == false) goto L57;
            Pair r41 = (Pair) r40.next();
            ((FieldSetter) r41.component2()).writeSet(r12.getVarName(), (String) r41.component1(), r15.getBuilder());
            goto L55
        L57:
            LinkedHashMap r42 = new LinkedHashMap();
            Iterator r43 = r112.entrySet().iterator();
        L59:
            if (r43.hasNext() == false) goto L64;
            Map.Entry r44 = (Map.Entry) r43.next();
            if (((Field) r44.getValue()).getSetter().getCallType() == CallType.CONSTRUCTOR) goto L59;
            r42.put(r44.getKey(), r44.getValue());
            goto L59
        L64:
            Iterator r45 = r42.entrySet().iterator();
        L66:
            if (r45.hasNext() == false) goto L68;
            Map.Entry r46 = (Map.Entry) r45.next();
            ((Field) r46.getValue()).getSetter().writeSet(r12.getVarName(), (String) r46.getKey(), r15.getBuilder());
            goto L66
        L68:
            return;
        L28:
            FieldReadWriteWriter.Companion.construct(r12.getVarName(), r16.getConstructor(), r16.getTypeName(), r110, r12.getSubNodes(), r112, r15);
            goto L29
        }

        public final void bindToStatement(String r5, String r10, List<FieldWithIndex> r11, CodeGenScope r12) {
            Intrinsics.checkNotNullParameter(r5, "ownerVar");
            Intrinsics.checkNotNullParameter(r10, "stmtParamVar");
            Intrinsics.checkNotNullParameter(r11, "fieldsWithIndices");
            Intrinsics.checkNotNullParameter(r12, "scope");
            bindToStatement$visitNode(r12, r10, createNodeTree(r5, r11, r12));
        }

        public final Set<EmbeddedField> getAllParents(List<Field> r5) {
            Intrinsics.checkNotNullParameter(r5, "fields");
            LinkedHashSet r10 = new LinkedHashSet();
            Iterator<T> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            getAllParents$addAllParents(r10, (Field) r11.next());
            goto L4
        L6:
            return r10;
        }

        public final void readFromCursor(String r10, Pojo r11, String r12, List<FieldWithIndex> r13, CodeGenScope r14, List<RelationCollector> r15) {
            Intrinsics.checkNotNullParameter(r10, "outVar");
            Intrinsics.checkNotNullParameter(r11, "outPojo");
            Intrinsics.checkNotNullParameter(r12, "cursorVar");
            Intrinsics.checkNotNullParameter(r13, "fieldsWithIndices");
            Intrinsics.checkNotNullParameter(r14, "scope");
            Intrinsics.checkNotNullParameter(r15, "relationCollectors");
            readFromCursor$visitNode$31(r14, r15, r11, r12, r13, createNodeTree(r10, r13, r14));
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/room/writer/FieldReadWriteWriter$Node;", "", "varName", "", "fieldParent", "Landroidx/room/vo/EmbeddedField;", "(Ljava/lang/String;Landroidx/room/vo/EmbeddedField;)V", "directFields", "", "Landroidx/room/vo/FieldWithIndex;", "getDirectFields", "()Ljava/util/List;", "setDirectFields", "(Ljava/util/List;)V", "getFieldParent", "()Landroidx/room/vo/EmbeddedField;", "parentNode", "getParentNode", "()Landroidx/room/writer/FieldReadWriteWriter$Node;", "setParentNode", "(Landroidx/room/writer/FieldReadWriteWriter$Node;)V", "subNodes", "", "getSubNodes", "getVarName", "()Ljava/lang/String;", "allFields", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Node {
        public List<FieldWithIndex> directFields;
        private final EmbeddedField fieldParent;
        private Node parentNode;
        private final List<Node> subNodes;
        private final String varName;

        public Node(String r5, EmbeddedField r10) {
            Intrinsics.checkNotNullParameter(r5, "varName");
            this.varName = r5;
            this.fieldParent = r10;
            this.subNodes = new ArrayList();
        }

        public final List<FieldWithIndex> allFields() {
            List<FieldWithIndex> r5 = getDirectFields();
            List<Node> r10 = this.subNodes;
            ArrayList r11 = new ArrayList();
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            CollectionsKt.a(r11, ((Node) r12.next()).allFields());
            goto L4
        L7:
            return CollectionsKt.plus(r5, r11);
        }

        public final List<FieldWithIndex> getDirectFields() {
            List<FieldWithIndex> r5 = this.directFields;
            if (r5 == null) goto L5;
            return r5;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("directFields");
            return null;
        }

        public final EmbeddedField getFieldParent() {
            return this.fieldParent;
        }

        public final Node getParentNode() {
            return this.parentNode;
        }

        public final List<Node> getSubNodes() {
            return this.subNodes;
        }

        public final String getVarName() {
            return this.varName;
        }

        public final void setDirectFields(List<FieldWithIndex> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.directFields = r5;
        }

        public final void setParentNode(Node r5) {
            this.parentNode = r5;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[CallType.values().length];
            r5[CallType.FIELD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[CallType.METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[CallType.CONSTRUCTOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FieldReadWriteWriter(FieldWithIndex r5) {
        Intrinsics.checkNotNullParameter(r5, "fieldWithIndex");
        this.field = r5.getField();
        this.indexVar = r5.getIndexVar();
        this.alwaysExists = r5.getAlwaysExists();
    }

    public static final /* synthetic */ void access$bindToStatement(FieldReadWriteWriter r5, String r10, String r11, CodeGenScope r12) {
        r5.bindToStatement(r10, r11, r12);
    }

    public static final /* synthetic */ void access$readFromCursor(FieldReadWriteWriter r5, String r10, String r11, CodeGenScope r12) {
        r5.readFromCursor(r10, r11, r12);
    }

    private final void bindToStatement(String r5, String r10, CodeGenScope r11) {
        StatementValueBinder r12 = this.field.getStatementBinder();
        if (r12 != null) goto L5;
        return;
    L5:
        if (this.field.getGetter().getCallType() != CallType.FIELD) goto L7;
        String r13 = j0.D(r5, ".", this.field.getName());
    L8:
        r12.bindToStmt(r10, this.indexVar, r13, r11);
        return;
    L7:
        r13 = a.q(r5, ".", this.field.getGetter().getJvmName(), "()");
        goto L8
    }

    private final void readFromCursor(String r5, String r10, CodeGenScope r11) {
        if (this.alwaysExists == false) goto L5;
        readFromCursor$doRead(this, r11, r5, r10);
        return;
    L5:
        XCodeBlock.Builder r12 = r11.getBuilder();
        r12.beginControlFlow("if (%L != -1)", new Object[]{this.indexVar});
        readFromCursor$doRead(this, r11, r5, r10);
        r12.endControlFlow();
    }

    private static final void readFromCursor$doRead(FieldReadWriteWriter r10, CodeGenScope r11, String r12, String r13) {
        CursorValueReader r5 = r10.field.getCursorValueReader();
        if (r5 == null) goto L12;
        XCodeBlock.Builder r14 = r11.getBuilder();
        int r15 = WhenMappings.$EnumSwitchMapping$0[r10.field.getSetter().getCallType().ordinal()];
        if (r15 != 1) goto L7;
        r5.readFromCursor(j0.D(r12, ".", r10.field.getSetter().getJvmName()), r13, r10.indexVar, r11);
        return;
    L7:
        if (r15 != 2) goto L14;
        String r16 = r11.getTmpVar(CodeGenScope.TMP_VAR_DEFAULT_PREFIX + String_extKt.capitalize(r10.field.getName(), Locale.US));
        XCodeBlock.Builder.addLocalVariable$default(r14, r16, r10.field.getSetter().getType().asTypeName(), false, null, 12, null);
        r5.readFromCursor(r16, r13, r10.indexVar, r11);
        r14.addStatement("%L.%L(%L)", new Object[]{r12, r10.field.getSetter().getJvmName(), r16});
        return;
    L14:
        return;
    }

    public final boolean getAlwaysExists() {
        return this.alwaysExists;
    }

    public final Field getField() {
        return this.field;
    }

    public final String getIndexVar() {
        return this.indexVar;
    }

    public final String readIntoTmpVar(String r10, XTypeName r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "cursorVar");
        Intrinsics.checkNotNullParameter(r11, "typeName");
        Intrinsics.checkNotNullParameter(r12, "scope");
        String r5 = r12.getTmpVar(CodeGenScope.TMP_VAR_DEFAULT_PREFIX + String_extKt.capitalize(this.field.getName(), Locale.US));
        XCodeBlock.Builder r13 = r12.getBuilder();
        XCodeBlock.Builder.addLocalVariable$default(r13, r5, r11, false, null, 12, null);
        if (this.alwaysExists == false) goto L7;
        CursorValueReader r14 = this.field.getCursorValueReader();
        if (r14 == null) goto L11;
        r14.readFromCursor(r5, r10, this.indexVar, r12);
    L11:
        return r5;
    L7:
        r13.beginControlFlow("if (%L == -1)", new Object[]{this.indexVar}).addStatement("%L = %L", new Object[]{r5, Javapoet_extKt.defaultValue(XTypeNameKt.toJavaPoet(r11))});
        r13.nextControlFlow("else", new Object[0]);
        CursorValueReader r15 = this.field.getCursorValueReader();
        if (r15 == null) goto L10;
        r15.readFromCursor(r5, r10, this.indexVar, r12);
    L10:
        r13.endControlFlow();
        goto L11
    }
}
