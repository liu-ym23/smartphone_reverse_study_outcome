package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.String_extKt;
import androidx.room.parser.SQLTypeAffinity;
import androidx.room.vo.Entity;
import androidx.room.vo.Field;
import androidx.room.vo.ForeignKey;
import androidx.room.vo.HasFieldsKt;
import androidx.room.vo.Index;
import com.squareup.javapoet.e;
import com.squareup.javapoet.u;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/room/writer/TableInfoValidationWriter;", "Landroidx/room/writer/ValidationWriter;", "Landroidx/room/vo/Entity;", "entity", "<init>", "(Landroidx/room/vo/Entity;)V", "Lcom/squareup/javapoet/u;", "dbParam", "Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;", "scope", "", "write", "(Lcom/squareup/javapoet/u;Landroidx/room/writer/ValidationWriter$CountingCodeGenScope;)V", "Landroidx/room/vo/Entity;", "getEntity", "()Landroidx/room/vo/Entity;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableInfoValidationWriter extends ValidationWriter {
    public static final String CREATED_FROM_ENTITY = "CREATED_FROM_ENTITY";
    public static final Companion Companion = null;
    private final Entity entity;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/writer/TableInfoValidationWriter$Companion;", "", "()V", TableInfoValidationWriter.CREATED_FROM_ENTITY, "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public TableInfoValidationWriter(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        this.entity = r5;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    @Override // androidx.room.writer.ValidationWriter
    public void write(u r46, ValidationWriter.CountingCodeGenScope r47) {
        TableInfoValidationWriter r5 = this;
        Intrinsics.checkNotNullParameter(r46, "dbParam");
        Intrinsics.checkNotNullParameter(r47, "scope");
        String r10 = String_extKt.capitalize(String_extKt.stripNonJava(r5.entity.getTableName()), Locale.US);
        String r11 = r47.getTmpVar("_info" + r10);
        ValidationWriter.CodeBlockWrapper r12 = r47.builder();
        String r13 = r47.getTmpVar("_columns" + r10);
        v r14 = v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(HashMap.class)), new x[]{CommonTypeNames.INSTANCE.getSTRING(), RoomTypeNames.INSTANCE.getTABLE_INFO_COLUMN()});
        String r15 = "final ";
        String r16 = " ";
        String r17 = " = new ";
        String r18 = ")";
        r12.addStatement(a.u(a.y("final ", Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = new "), Javapoet_extKt.getT(), "(", Javapoet_extKt.getL(), ")"), new Object[]{r14, r13, r14, Integer.valueOf(r5.entity.getFields().size())});
        Iterator<Field> r19 = r5.entity.getFields().iterator();
    L4:
        if (r19.hasNext() == false) goto L11;
        Field r20 = r19.next();
        Iterator<Field> r23 = r19;
        String r21 = Javapoet_extKt.getL();
        String r110 = r16;
        String r111 = Javapoet_extKt.getS();
        String r112 = r15;
        String r113 = Javapoet_extKt.getT();
        String r22 = Javapoet_extKt.getS();
        String r24 = r11;
        String r25 = Javapoet_extKt.getS();
        String r26 = r18;
        String r27 = Javapoet_extKt.getL();
        String r28 = r17;
        String r114 = Javapoet_extKt.getL();
        String r29 = Javapoet_extKt.getS();
        String r210 = r10;
        String r30 = Javapoet_extKt.getT();
        ValidationWriter.CodeBlockWrapper r211 = r12;
        String r115 = Javapoet_extKt.getL();
        String r212 = r13;
        StringBuilder r31 = androidx.room.jarjarred.org.antlr.runtime.a.y(r21, ".put(", r111, ", new ", r113);
        a.C(r31, "(", r22, ", ", r25);
        a.C(r31, ", ", r27, ", ", r114);
        a.C(r31, ", ", r29, ", ", r30);
        String r32 = a.t(r31, ".", r115, "))");
        String r116 = r20.getColumnName();
        RoomTypeNames r33 = RoomTypeNames.INSTANCE;
        e r117 = r33.getTABLE_INFO_COLUMN();
        String r34 = r20.getColumnName();
        SQLTypeAffinity r35 = r20.getAffinity();
        if (r35 == null) goto L9;
        String r36 = r35.name();
        if (r36 == null) goto L9;
    L10:
        r211.addStatement(r32, new Object[]{r212, r116, r117, r34, r36, Boolean.valueOf(r20.getNonNull()), Integer.valueOf(this.entity.getPrimaryKey().getFields().indexOf(r20) + 1), r20.getDefaultValue(), r33.getTABLE_INFO(), CREATED_FROM_ENTITY});
        r16 = r110;
        r5 = this;
        r15 = r112;
        r19 = r23;
        r11 = r24;
        r18 = r26;
        r17 = r28;
        r13 = r212;
        r12 = r211;
        r10 = r210;
    L9:
        r36 = "TEXT";
        goto L10
    L11:
        String r213 = r10;
        String r214 = r11;
        String r215 = r18;
        String r216 = r13;
        String r217 = r17;
        ValidationWriter.CodeBlockWrapper r37 = r12;
        String r38 = r16;
        String r118 = r15;
        TableInfoValidationWriter r39 = r5;
        StringBuilder r40 = new StringBuilder("_foreignKeys");
        String r41 = r213;
        r40.append(r41);
        String r119 = r47.getTmpVar(r40.toString());
        Class<HashSet> r42 = HashSet.class;
        v r43 = v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(r42)), new x[]{RoomTypeNames.INSTANCE.getTABLE_INFO_FOREIGN_KEY()});
        String r44 = Javapoet_extKt.getT();
        String r45 = Javapoet_extKt.getL();
        String r48 = Javapoet_extKt.getT();
        String r120 = Javapoet_extKt.getL();
        String r121 = r217;
        StringBuilder r49 = a.y(r118, r44, r38, r45, r121);
        String r50 = r215;
        r37.addStatement(a.u(r49, r48, "(", r120, r50), new Object[]{r43, r119, r43, Integer.valueOf(r39.entity.getForeignKeys().size())});
        Iterator r51 = r39.entity.getForeignKeys().iterator();
    L12:
        String r218 = r50;
        if (r51.hasNext() == false) goto L15;
        ForeignKey r52 = (ForeignKey) r51.next();
        String r310 = CollectionsKt.q(r52.getChildFields(), ",", null, null, 0, null, TableInfoValidationWriter$write$1$2$myColumnNames$1.INSTANCE, 30);
        String r311 = CollectionsKt.q(r52.getParentColumns(), ",", null, null, 0, null, TableInfoValidationWriter$write$1$2$refColumnNames$1.INSTANCE, 30);
        Iterator r122 = r51;
        String r53 = Javapoet_extKt.getL();
        String r123 = r38;
        String r54 = Javapoet_extKt.getT();
        String r219 = r118;
        String r124 = Javapoet_extKt.getS();
        String r220 = r121;
        String r125 = Javapoet_extKt.getS();
        Class<HashSet> r221 = r42;
        String r55 = Javapoet_extKt.getS();
        String r126 = Javapoet_extKt.getT();
        String r222 = r41;
        String r56 = Javapoet_extKt.getL();
        ValidationWriter.CodeBlockWrapper r223 = r37;
        String r57 = Javapoet_extKt.getT();
        String r224 = r119;
        String r127 = Javapoet_extKt.getL();
        StringBuilder r58 = androidx.room.jarjarred.org.antlr.runtime.a.y(r53, ".add(new ", r54, "(", r124);
        a.C(r58, ", ", r125, ", ", r55);
        a.C(r58, ",", r126, ".asList(", r56);
        a.C(r58, "), ", r57, ".asList(", r127);
        r58.append(")))");
        r223.addStatement(r58.toString(), new Object[]{r224, RoomTypeNames.INSTANCE.getTABLE_INFO_FOREIGN_KEY(), r52.getParentTable(), r52.getOnDelete().getSqlName(), r52.getOnUpdate().getSqlName(), Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(Arrays.class)), r310, Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(Arrays.class)), r311});
        r37 = r223;
        r51 = r122;
        r38 = r123;
        r118 = r219;
        r42 = r221;
        r119 = r224;
        r50 = r218;
        r121 = r220;
        r41 = r222;
        goto L12
    L15:
        Class<HashSet> r225 = r42;
        String r226 = r41;
        ValidationWriter.CodeBlockWrapper r59 = r37;
        String r227 = r119;
        String r228 = r118;
        String r229 = r121;
        String r60 = r47.getTmpVar("_indices" + r226);
        v r61 = v.n(Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(r225)), new x[]{RoomTypeNames.INSTANCE.getTABLE_INFO_INDEX()});
        String r62 = Javapoet_extKt.getT();
        String r128 = Javapoet_extKt.getL();
        String r129 = Javapoet_extKt.getT();
        String r130 = Javapoet_extKt.getL();
        String r63 = r38;
        String r131 = r228;
        String r64 = r229;
        StringBuilder r65 = a.y(r131, r62, r63, r128, r64);
        String r132 = r218;
        r59.addStatement(a.u(r65, r129, "(", r130, r132), new Object[]{r61, r60, r61, Integer.valueOf(this.entity.getIndices().size())});
        Iterator r66 = this.entity.getIndices().iterator();
    L17:
        if (r66.hasNext() == false) goto L28;
        Index r67 = (Index) r66.next();
        String r312 = CollectionsKt.q(HasFieldsKt.getColumnNames(r67), ",", null, null, 0, null, TableInfoValidationWriter$write$1$3$columnNames$1.INSTANCE, 30);
        if (r67.getOrders().isEmpty() == false) goto L26;
        List<String> r68 = HasFieldsKt.getColumnNames(r67);
        ArrayList r69 = new ArrayList(CollectionsKt.h(r68));
        Iterator<T> r70 = r68.iterator();
    L22:
        if (r70.hasNext() == false) goto L24;
        String r133 = (String) r70.next();
        r69.add("ASC");
        goto L22
    L24:
        String r71 = CollectionsKt.q(r69, ",", null, null, 0, null, TableInfoValidationWriter$write$1$3$orders$2.INSTANCE, 30);
    L25:
        String r313 = r71;
        String r72 = Javapoet_extKt.getL();
        String r73 = Javapoet_extKt.getT();
        String r134 = Javapoet_extKt.getS();
        String r230 = r132;
        String r135 = Javapoet_extKt.getL();
        String r231 = r64;
        String r74 = Javapoet_extKt.getT();
        String r136 = r63;
        String r75 = Javapoet_extKt.getL();
        String r232 = r131;
        String r137 = Javapoet_extKt.getT();
        ValidationWriter.CodeBlockWrapper r233 = r59;
        String r76 = Javapoet_extKt.getL();
        StringBuilder r77 = androidx.room.jarjarred.org.antlr.runtime.a.y(r72, ".add(new ", r73, "(", r134);
        a.C(r77, ", ", r135, ", ", r74);
        a.C(r77, ".asList(", r75, "), ", r137);
        r233.addStatement(a.t(r77, ".asList(", r76, ")))"), new Object[]{r60, RoomTypeNames.INSTANCE.getTABLE_INFO_INDEX(), r67.getName(), Boolean.valueOf(r67.getUnique()), Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(Arrays.class)), r312, Javapoet_extKt.getTypeName(Reflection.getOrCreateKotlinClass(Arrays.class)), r313});
        r59 = r233;
        r66 = r66;
        r63 = r136;
        r131 = r232;
        r132 = r230;
        r64 = r231;
        goto L17
    L26:
        r71 = CollectionsKt.q(r67.getOrders(), ",", null, null, 0, null, TableInfoValidationWriter$write$1$3$orders$3.INSTANCE, 30);
        goto L25
    L28:
        String r234 = r64;
        String r138 = r63;
        String r235 = r132;
        String r236 = r131;
        ValidationWriter.CodeBlockWrapper r78 = r59;
        String r79 = Javapoet_extKt.getT();
        String r80 = Javapoet_extKt.getL();
        String r81 = Javapoet_extKt.getT();
        String r82 = Javapoet_extKt.getS();
        String r83 = Javapoet_extKt.getL();
        String r84 = Javapoet_extKt.getL();
        String r85 = Javapoet_extKt.getL();
        StringBuilder r86 = a.y(r236, r79, r138, r80, r234);
        a.C(r86, r81, "(", r82, ", ");
        a.C(r86, r83, ", ", r84, ", ");
        String r87 = j0.q(r86, r85, r235);
        RoomTypeNames r88 = RoomTypeNames.INSTANCE;
        r78.addStatement(r87, new Object[]{r88.getTABLE_INFO(), r214, r88.getTABLE_INFO(), this.entity.getTableName(), r216, r227, r60});
        String r89 = r47.getTmpVar("_existing" + r226);
        String r90 = Javapoet_extKt.getT();
        String r91 = Javapoet_extKt.getL();
        String r92 = Javapoet_extKt.getT();
        String r93 = Javapoet_extKt.getN();
        String r94 = Javapoet_extKt.getS();
        StringBuilder r95 = a.y(r236, r90, r138, r91, " = ");
        a.C(r95, r92, ".read(", r93, ", ");
        r78.addStatement(j0.q(r95, r94, r235), new Object[]{r88.getTABLE_INFO(), r89, r88.getTABLE_INFO(), r46, this.entity.getTableName()});
        ValidationWriter.CodeBlockWrapper r96 = r78.beginControlFlow(j0.l("if (! ", Javapoet_extKt.getL(), ".equals(", Javapoet_extKt.getL(), "))"), new Object[]{r214, r89});
        String r97 = Javapoet_extKt.getT();
        String r98 = Javapoet_extKt.getS();
        String r99 = Javapoet_extKt.getL();
        String r100 = Javapoet_extKt.getS();
        String r139 = Javapoet_extKt.getL();
        StringBuilder r101 = a.y("return new ", r97, "(false, ", r98, " + ");
        a.C(r101, r99, " + ", r100, " + ");
        r96.addStatement(j0.q(r101, r139, r235), new Object[]{r88.getOPEN_HELPER_VALIDATION_RESULT(), androidx.room.jarjarred.org.antlr.runtime.a.q(this.entity.getTableName(), "(", this.entity.getElement().getQualifiedName(), ").\n Expected:\n"), r214, "\n Found:\n", r89});
        r78.endControlFlow();
    }
}
