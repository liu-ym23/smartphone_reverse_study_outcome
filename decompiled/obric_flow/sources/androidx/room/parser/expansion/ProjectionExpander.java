package androidx.room.parser.expansion;

import ai.j0;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.parser.ParsedQuery;
import androidx.room.parser.SqlParser;
import androidx.room.parser.Table;
import androidx.room.processor.QueryRewriter;
import androidx.room.solver.query.result.PojoRowAdapter;
import androidx.room.solver.query.result.QueryResultAdapter;
import androidx.room.solver.query.result.RowAdapter;
import androidx.room.verifier.ColumnInfo;
import androidx.room.verifier.QueryResultInfo;
import androidx.room.vo.EmbeddedField;
import androidx.room.vo.Entity;
import androidx.room.vo.EntityOrView;
import androidx.room.vo.Field;
import androidx.room.vo.Fields;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Pojo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005JD\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J<\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J.\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u00020\u0007*\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0014\u0010'\u001a\u00020\f*\u00020\u00102\u0006\u0010(\u001a\u00020\u0007H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/room/parser/expansion/ProjectionExpander;", "Landroidx/room/processor/QueryRewriter;", "tables", "", "Landroidx/room/vo/EntityOrView;", "(Ljava/util/List;)V", "expand", "", "pojo", "Landroidx/room/vo/Pojo;", "ignoredColumnNames", "shallow", "", "nameToAlias", "", "resultInfo", "Landroidx/room/verifier/QueryResultInfo;", "expandEmbeddedField", "embedded", "Landroidx/room/vo/EmbeddedField;", "table", "tableToAlias", "findEmbeddedField", "tableAlias", "findEntityOrView", "interpret", "query", "Landroidx/room/parser/ParsedQuery;", "Landroidx/room/parser/expansion/ExpandableParsedQuery;", "interpretProjection", "section", "Landroidx/room/parser/expansion/ExpandableSection$Projection;", "queriedTableNames", "rewrite", "resultAdapter", "Landroidx/room/solver/query/result/QueryResultAdapter;", "columnNameWithoutPrefix", "Landroidx/room/vo/Field;", "prefix", "hasColumn", "columnName", "IdentifierMap", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProjectionExpander implements QueryRewriter {
    private final List<EntityOrView> tables;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u0001`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/parser/expansion/ProjectionExpander$IdentifierMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "()V", "get", STGroup.DICT_KEY, "(Ljava/lang/String;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class IdentifierMap<V> extends HashMap<String, V> {
        public IdentifierMap() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r5) {
            if ((r5 instanceof String) == true) goto L7;
            return false;
        L7:
            return containsKey((String) r5);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
            return (Set<Map.Entry<String, V>>) getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ V get(Object r5) {
            if ((r5 instanceof String) == true) goto L7;
            return null;
        L7:
            return get((String) r5);
        }

        public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object r5, Object r10) {
            if ((r5 instanceof String) == true) goto L6;
            return r10;
        L6:
            return getOrDefault((String) r5, r10);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Object> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object r5, Object r10) {
            return put((String) r5, r10);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ V remove(Object r5) {
            if ((r5 instanceof String) == true) goto L7;
            return null;
        L7:
            return (V) remove((String) r5);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return (Collection<V>) getValues();
        }

        public /* bridge */ boolean containsKey(String r5) {
            return super.containsKey(r5);
        }

        public V get(String r5) {
            Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
            return (V) super.get(r5.toLowerCase(Locale.ENGLISH));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ Object getOrDefault(String r5, Object r10) {
            return super.getOrDefault(r5, r10);
        }

        public V put(String r5, V r10) {
            Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
            return (V) super.put(r5.toLowerCase(Locale.ENGLISH), r10);
        }

        public /* bridge */ Object remove(String r5) {
            return super.remove(r5);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r5, Object r10) {
            if ((r5 instanceof String) == true) goto L7;
            return false;
        L7:
            return remove((String) r5, r10);
        }

        public /* bridge */ boolean remove(String r5, Object r10) {
            return super.remove(r5, r10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProjectionExpander(List<? extends EntityOrView> r5) {
        Intrinsics.checkNotNullParameter(r5, "tables");
        this.tables = r5;
    }

    public static final /* synthetic */ String access$interpretProjection(ProjectionExpander r5, ExpandableParsedQuery r10, ExpandableSection.Projection r11, Pojo r12, List r13) {
        return r5.interpretProjection(r10, r11, r12, r13);
    }

    private final String columnNameWithoutPrefix(Field r5, String r10) {
        if (StringsKt.P(r5.getColumnName(), r10) == false) goto L6;
        return r5.getColumnName().substring(r10.length());
    L6:
        return r5.getColumnName();
    }

    private final String expand(Pojo r15, List<String> r16, boolean r17, Map<String, String> r18, QueryResultInfo r19) {
        EntityOrView r5 = findEntityOrView(r15);
        List<EmbeddedField> r10 = r15.getEmbeddedFields();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        EmbeddedField r13 = (EmbeddedField) r12.next();
        CollectionsKt.a(r11, expandEmbeddedField(r13, findEntityOrView(r13.getPojo()), r17, r18));
        goto L4
    L6:
        Fields r14 = r15.getFields();
        ArrayList r20 = new ArrayList();
        Iterator<Field> r21 = r14.iterator();
    L8:
        if (r21.hasNext() == false) goto L18;
        Field r22 = r21.next();
        Field r23 = r22;
        if (r23.getParent() != null) goto L8;
        if (r16.contains(r23.getColumnName()) == true) goto L8;
        if (r19 == null) goto L16;
        if (hasColumn(r19, r23.getColumnName()) == false) goto L8;
    L16:
        r20.add(r22);
        goto L8
    L18:
        ArrayList r24 = new ArrayList(CollectionsKt.h(r20));
        Iterator r25 = r20.iterator();
    L20:
        if (r25.hasNext() == false) goto L32;
        Field r26 = (Field) r25.next();
        if (r5 != null) goto L24;
    L29:
        String r27 = j0.k("`", r26.getColumnName(), "`");
    L30:
        r24.add(r27);
        goto L20
    L24:
        if ((r5 instanceof Entity) == false) goto L29;
        Entity r28 = (Entity) r5;
        String r29 = r18.get(r28.getTableName().toLowerCase(Locale.ENGLISH));
        if (r29 != null) goto L28;
        r29 = r28.getTableName();
    L28:
        String r30 = r26.getColumnName();
        String r31 = r26.getColumnName();
        r27 = j0.q(a.y("`", r29, "`.`", r30, "` AS `"), r31, "`");
        goto L30
    L32:
        return CollectionsKt.q(CollectionsKt.plus(r11, r24), ", ", null, null, 0, null, null, 62);
    }

    private final List<String> expandEmbeddedField(EmbeddedField r10, EntityOrView r11, boolean r12, Map<String, String> r13) {
        Pojo r5 = r10.getPojo();
        if (r11 != null) goto L5;
        if (r12 == false) goto L28;
    L36:
        Fields r14 = r5.getFields();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<Field> r16 = r14.iterator();
    L38:
        if (r16.hasNext() == false) goto L51;
        r15.add("`" + r16.next().getColumnName() + "`");
        goto L38
    L51:
        return r15;
    L28:
        if (r10.getPrefix().length() <= 0) goto L36;
        if (r13.values().contains(r10.getPrefix()) == false) goto L36;
        Fields r17 = r5.getFields();
        ArrayList r18 = new ArrayList(CollectionsKt.h(r17));
        Iterator<Field> r19 = r17.iterator();
    L33:
        if (r19.hasNext() == false) goto L49;
        Field r110 = r19.next();
        String r20 = r10.getPrefix();
        String r21 = columnNameWithoutPrefix(r110, r10.getPrefix());
        String r111 = r110.getColumnName();
        StringBuilder r22 = a.y("`", r20, "`.`", r21, "` AS `");
        r22.append(r111);
        r22.append("`");
        r18.add(r22.toString());
        goto L33
    L49:
        return r18;
    L5:
        if (r10.getPrefix().length() <= 0) goto L14;
        Fields r23 = r11.getFields();
        ArrayList r24 = new ArrayList(CollectionsKt.h(r23));
        Iterator<Field> r25 = r23.iterator();
    L8:
        if (r25.hasNext() == false) goto L50;
        Field r112 = r25.next();
        if (r12 == false) goto L12;
        String r113 = a.p("`", r10.getPrefix(), r112.getColumnName(), "`");
    L13:
        r24.add(r113);
        goto L8
    L12:
        String r26 = r10.getPrefix();
        String r27 = r112.getColumnName();
        r113 = a.t(a.y("`", r26, "`.`", r27, "` AS `"), r10.getPrefix(), r112.getColumnName(), "`");
        goto L13
    L50:
        return r24;
    L14:
        Fields r28 = r11.getFields();
        ArrayList r29 = new ArrayList(CollectionsKt.h(r28));
        Iterator<Field> r30 = r28.iterator();
    L16:
        if (r30.hasNext() == false) goto L40;
        Field r31 = r30.next();
        if (r12 == false) goto L20;
        String r32 = j0.k("`", r31.getColumnName(), "`");
    L24:
        r29.add(r32);
        goto L16
    L20:
        String r33 = r13.get(r11.getTableName());
        if (r33 != null) goto L23;
        r33 = r11.getTableName();
    L23:
        String r34 = r31.getColumnName();
        r32 = j0.q(a.y("`", r33, "`.`", r34, "` AS `"), r31.getColumnName(), "`");
        goto L24
    L40:
        return r29;
    }

    private final EmbeddedField findEmbeddedField(Pojo r5, String r10) {
        Iterator<T> r11 = r5.getEmbeddedFields().iterator();
    L3:
        Object r12 = null;
        if (r11.hasNext() == false) goto L8;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(((EmbeddedField) r13).getPrefix(), r10) == false) goto L3;
    L9:
        EmbeddedField r14 = (EmbeddedField) r13;
        if (r14 == null) goto L12;
        return r14;
    L12:
        Iterator<T> r15 = r5.getEmbeddedFields().iterator();
    L14:
        if (r15.hasNext() == false) goto L25;
        Object r16 = r15.next();
        EmbeddedField r17 = (EmbeddedField) r16;
        if (r17.getPrefix().length() != 0) goto L14;
        EntityOrView r18 = findEntityOrView(r17.getPojo());
        if (r18 == null) goto L20;
        String r19 = r18.getTableName();
    L22:
        if (Intrinsics.areEqual(r19, r10) == false) goto L14;
        r12 = r16;
        goto L25
    L20:
        r19 = null;
    L25:
        return (EmbeddedField) r12;
    L8:
        r13 = null;
        goto L9
    }

    private final EntityOrView findEntityOrView(Pojo r5) {
        Iterator<T> r10 = this.tables.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((EntityOrView) r11).getTypeName(), r5.getTypeName()) == false) goto L4;
    L10:
        return (EntityOrView) r11;
    L8:
        r11 = null;
        goto L10
    }

    private final boolean hasColumn(QueryResultInfo r5, String r10) {
        List<ColumnInfo> r11 = r5.getColumns();
        if (r11 != null) goto L5;
    L7:
        Iterator<T> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ColumnInfo) r12.next()).getName(), r10) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return false;
    }

    private final String interpretProjection(ExpandableParsedQuery r18, final ExpandableSection.Projection r19, Pojo r20, List<String> r21) {
        Set<Table> r5 = r18.getTables();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Table r12 = (Table) r11.next();
        String r13 = r12.component1();
        r10.add(TuplesKt.to(r12.component2(), r13));
        goto L4
    L6:
        IdentifierMap r14 = (IdentifierMap) MapsKt.d(r10, new IdentifierMap());
        Set<Table> r15 = r18.getTables();
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator<T> r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L13;
        Object r22 = r17.next();
        String r23 = ((Table) r22).getName().toLowerCase(Locale.ENGLISH);
        Object r24 = r16.get(r23);
        if (r24 != null) goto L12;
        r24 = new ArrayList();
        r16.put(r23, r24);
    L12:
        ((List) r24).add(r22);
        goto L8
    L13:
        LinkedHashMap r25 = new LinkedHashMap();
        Iterator r26 = r16.entrySet().iterator();
    L15:
        if (r26.hasNext() == false) goto L19;
        Map.Entry r27 = (Map.Entry) r26.next();
        if (((List) r27.getValue()).size() != 1) goto L15;
        r25.put(r27.getKey(), r27.getValue());
        goto L15
    L19:
        ArrayList r28 = new ArrayList(r25.size());
        Iterator r29 = r25.entrySet().iterator();
    L21:
        if (r29.hasNext() == false) goto L23;
        Map.Entry r30 = (Map.Entry) r29.next();
        r28.add(TuplesKt.to((String) r30.getKey(), ((Table) CollectionsKt.first((List) r30.getValue())).getAlias()));
        goto L21
    L23:
        IdentifierMap r31 = (IdentifierMap) MapsKt.d(r28, new IdentifierMap());
        Object r32 = null;
        if ((r19 instanceof ExpandableSection.Projection.All) == false) goto L30;
        List<String> r33 = r18.getExplicitColumns();
        EntityOrView r34 = findEntityOrView(r20);
        if (r34 == null) goto L86;
        r32 = r34.getTableName();
    L86:
        return expand(r20, r33, CollectionsKt.contains(r21, r32), r31, r18.getResultInfo());
    L30:
        if ((r19 instanceof ExpandableSection.Projection.Table) == false) goto L59;
        ExpandableSection.Projection.Table r35 = (ExpandableSection.Projection.Table) r19;
        EmbeddedField r36 = findEmbeddedField(r20, r35.getTableAlias());
        if (r36 != null) goto L87;
        String r37 = (String) r14.get(r35.getTableAlias());
        if (r37 != null) goto L37;
        r37 = r35.getTableAlias();
    L37:
        Iterator<T> r38 = this.tables.iterator();
    L39:
        if (r38.hasNext() == false) goto L43;
        Object r39 = r38.next();
        if (Intrinsics.areEqual(((EntityOrView) r39).getTableName(), r37) == false) goto L39;
        r32 = r39;
    L43:
        EntityOrView r40 = (EntityOrView) r32;
        Fields r41 = r20.getFields();
        ArrayList r42 = new ArrayList();
        Iterator<Field> r43 = r41.iterator();
    L45:
        if (r43.hasNext() == false) goto L57;
        Field r44 = r43.next();
        Field r45 = r44;
        if (r45.getParent() != null) goto L45;
        if (r18.getExplicitColumns().contains(r45.getColumnName()) == true) goto L45;
        if (r40 == null) goto L45;
        List<String> r46 = HasFieldsKt.getColumnNames(r40);
        if (r46 == null) goto L45;
        if (r46.contains(r45.getColumnName()) != true) goto L45;
        r42.add(r44);
        goto L45
    L57:
        return CollectionsKt.q(r42, ", ", null, null, 0, null, new C01362(r19), 30);
    L87:
        return CollectionsKt.q(expandEmbeddedField(r36, findEntityOrView(r36.getPojo()), false, r31), ", ", null, null, 0, null, null, 62);
    L59:
        throw new NoWhenBranchMatchedException();
    }

    @VisibleForTesting(otherwise = 2)
    public final String interpret(ParsedQuery r5, Pojo r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        ExpandableParsedQuery r11 = ExpandableSqlParser.Companion.parse(r5.getOriginal());
        r11.setResultInfo(r5.getResultInfo());
        return interpret(r11, r10);
    }

    @Override // androidx.room.processor.QueryRewriter
    public ParsedQuery rewrite(ParsedQuery r5, QueryResultAdapter r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        Intrinsics.checkNotNullParameter(r10, "resultAdapter");
        if (r10.getRowAdapters().isEmpty() == false) goto L6;
        return r5;
    L6:
        if (r10.getRowAdapters().size() <= 1) goto L8;
        return r5;
    L8:
        RowAdapter r11 = (RowAdapter) CollectionsKt.single(r10.getRowAdapters());
        if ((r11 instanceof PojoRowAdapter) == false) goto L14;
        String r12 = interpret(ExpandableSqlParser.Companion.parse(r5.getOriginal()), ((PojoRowAdapter) r11).getPojo());
        ParsedQuery r13 = SqlParser.Companion.parse(r12);
        if (r13.getErrors().isEmpty() == true) goto L13;
        return r5;
    L13:
        return r13;
    L14:
        return r5;
    }

    private final String interpret(final ExpandableParsedQuery r12, final Pojo r13) {
        Set<Table> r5 = r12.getTables();
        final ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.add(((Table) r11.next()).getName());
        goto L4
    L7:
        return CollectionsKt.q(r12.getSections(), "", null, null, 0, null, new AnonymousClass2(r13, this, r12, r10), 30);
    }
}
