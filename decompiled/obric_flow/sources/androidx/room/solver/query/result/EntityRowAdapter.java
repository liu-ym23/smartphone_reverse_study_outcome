package androidx.room.solver.query.result;

import ai.j0;
import androidx.room.compiler.codegen.XTypeNameKt;
import androidx.room.ext.AndroidTypeNames;
import androidx.room.ext.CommonTypeNames;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.RoomTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ColumnIndexVar;
import androidx.room.vo.Entity;
import androidx.room.vo.HasFieldsKt;
import androidx.room.writer.EntityCursorConverterWriter;
import com.squareup.javapoet.e;
import com.squareup.javapoet.g;
import com.squareup.javapoet.i;
import com.squareup.javapoet.t;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005*\u0001#\u0018\u00002\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Landroidx/room/solver/query/result/EntityRowAdapter;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter;", "Landroidx/room/vo/Entity;", "entity", "<init>", "(Landroidx/room/vo/Entity;)V", "", "cursorVarName", "Landroidx/room/solver/CodeGenScope;", "scope", "", "Landroidx/room/vo/ColumnIndexVar;", "indices", "", "onCursorReady", "(Ljava/lang/String;Landroidx/room/solver/CodeGenScope;Ljava/util/List;)V", "outVarName", "convert", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/solver/query/result/IndexAdapter;", "getDefaultIndexAdapter", "()Landroidx/room/solver/query/result/IndexAdapter;", "Landroidx/room/vo/Entity;", "getEntity", "()Landroidx/room/vo/Entity;", "Landroidx/room/solver/query/result/EntityRowAdapter$EntityMapping;", "mapping", "Landroidx/room/solver/query/result/EntityRowAdapter$EntityMapping;", "getMapping", "()Landroidx/room/solver/query/result/EntityRowAdapter$EntityMapping;", "Lcom/squareup/javapoet/t;", "methodSpec", "Lcom/squareup/javapoet/t;", "cursorDelegateVarName", "Ljava/lang/String;", "androidx/room/solver/query/result/EntityRowAdapter$indexAdapter$1", "indexAdapter", "Landroidx/room/solver/query/result/EntityRowAdapter$indexAdapter$1;", "EntityMapping", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityRowAdapter extends QueryMappedRowAdapter {
    private String cursorDelegateVarName;
    private final Entity entity;
    private final EntityRowAdapter$indexAdapter$1 indexAdapter;
    private final EntityMapping mapping;
    private t methodSpec;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/room/solver/query/result/EntityRowAdapter$EntityMapping;", "Landroidx/room/solver/query/result/QueryMappedRowAdapter$Mapping;", "entity", "Landroidx/room/vo/Entity;", "(Landroidx/room/vo/Entity;)V", "getEntity", "()Landroidx/room/vo/Entity;", "usedColumns", "", "", "getUsedColumns", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EntityMapping extends QueryMappedRowAdapter.Mapping {
        private final Entity entity;
        private final List<String> usedColumns;

        public EntityMapping(Entity r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            this.entity = r5;
            this.usedColumns = HasFieldsKt.getColumnNames(r5);
        }

        public static /* synthetic */ EntityMapping copy$default(EntityMapping r5, Entity r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.entity;
        L6:
            return r5.copy(r10);
        }

        public final Entity component1() {
            return this.entity;
        }

        public final EntityMapping copy(Entity r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            return new EntityMapping(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EntityMapping) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.entity, ((EntityMapping) r5).entity) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final Entity getEntity() {
            return this.entity;
        }

        @Override // androidx.room.solver.query.result.QueryMappedRowAdapter.Mapping
        public List<String> getUsedColumns() {
            return this.usedColumns;
        }

        public int hashCode() {
            return this.entity.hashCode();
        }

        public String toString() {
            return "EntityMapping(entity=" + this.entity + ")";
        }
    }

    public EntityRowAdapter(Entity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        super(r5.getType());
        this.entity = r5;
        this.mapping = new EntityMapping(r5);
        this.indexAdapter = new EntityRowAdapter$indexAdapter$1(this);
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void convert(String r10, String r11, CodeGenScope r12) {
        Intrinsics.checkNotNullParameter(r10, "outVarName");
        g r13 = a.k(r11, "cursorVarName", "scope", r12);
        StringBuilder r5 = a.y(Javapoet_extKt.getL(), " = ", Javapoet_extKt.getN(), "(", Javapoet_extKt.getL());
        r5.append(")");
        String r14 = r5.toString();
        t r15 = this.methodSpec;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("methodSpec");
        r15 = null;
    L5:
        String r16 = this.cursorDelegateVarName;
        if (r16 == null) goto L9;
        r11 = r16;
    L9:
        r13.c(r14, new Object[]{r10, r15, r11});
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public IndexAdapter getDefaultIndexAdapter() {
        return this.indexAdapter;
    }

    public final Entity getEntity() {
        return this.entity;
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public /* bridge */ /* synthetic */ QueryMappedRowAdapter.Mapping getMapping() {
        return getMapping();
    }

    @Override // androidx.room.solver.query.result.RowAdapter
    public void onCursorReady(String r16, CodeGenScope r17, List<ColumnIndexVar> r18) {
        Intrinsics.checkNotNullParameter(r16, "cursorVarName");
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r18, "indices");
        if (r18.isEmpty() == false) goto L5;
    L15:
        this.methodSpec = r17.getWriter().getOrCreateMethod(new EntityCursorConverterWriter(this.entity));
        return;
    L5:
        if (Intrinsics.areEqual(r18, this.indexAdapter.getIndexVars()) == true) goto L15;
        this.cursorDelegateVarName = r17.getTmpVar("_wrappedCursor");
        String r5 = j0.l("new ", Javapoet_extKt.getT(), "[] { ", Javapoet_extKt.getL(), " }");
        e r10 = CommonTypeNames.INSTANCE.getSTRING();
        List<String> r11 = HasFieldsKt.getColumnNames(this.entity);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator<T> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r12.add(i.d(Javapoet_extKt.getS(), new Object[]{(String) r13.next()}));
        goto L8
    L10:
        i r14 = i.d(r5, new Object[]{r10, i.c("," + Javapoet_extKt.getW(), r12)});
        String r15 = j0.l("new ", Javapoet_extKt.getT(), "[] { ", Javapoet_extKt.getL(), " }");
        x r19 = x.f15023h;
        ArrayList r20 = new ArrayList(CollectionsKt.h(r18));
        Iterator<T> r21 = r18.iterator();
    L12:
        if (r21.hasNext() == false) goto L14;
        r20.add(i.d(Javapoet_extKt.getL(), new Object[]{((ColumnIndexVar) r21.next()).getIndexVar()}));
        goto L12
    L14:
        i r22 = i.d(r15, new Object[]{r19, i.c("," + Javapoet_extKt.getW(), r20)});
        g r23 = r17.builder();
        String r24 = Javapoet_extKt.getT();
        String r25 = Javapoet_extKt.getN();
        String r26 = Javapoet_extKt.getT();
        String r27 = Javapoet_extKt.getN();
        String r110 = Javapoet_extKt.getL();
        String r111 = Javapoet_extKt.getL();
        StringBuilder r28 = androidx.constraintlayout.motion.widget.a.y("final ", r24, " ", r25, " = ");
        androidx.constraintlayout.motion.widget.a.C(r28, r26, ".wrapMappedColumns(", r27, ", ");
        r23.c(androidx.constraintlayout.motion.widget.a.u(r28, r110, ", ", r111, ")"), new Object[]{XTypeNameKt.toJavaPoet(AndroidTypeNames.INSTANCE.getCURSOR()), this.cursorDelegateVarName, RoomTypeNames.INSTANCE.getCURSOR_UTIL(), r16, r14, r22});
        goto L15
    }

    @Override // androidx.room.solver.query.result.QueryMappedRowAdapter
    public EntityMapping getMapping() {
        return this.mapping;
    }
}
