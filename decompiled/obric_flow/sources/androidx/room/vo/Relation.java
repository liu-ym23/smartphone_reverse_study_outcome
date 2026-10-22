package androidx.room.vo;

import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Landroidx/room/vo/Relation;", "", "Landroidx/room/vo/EntityOrView;", "entity", "Landroidx/room/compiler/processing/XType;", "pojoType", "Landroidx/room/vo/Field;", "field", "parentField", "entityField", "Landroidx/room/vo/Junction;", "junction", "", "", "projection", "<init>", "(Landroidx/room/vo/EntityOrView;Landroidx/room/compiler/processing/XType;Landroidx/room/vo/Field;Landroidx/room/vo/Field;Landroidx/room/vo/Field;Landroidx/room/vo/Junction;Ljava/util/List;)V", "", "resultFields", "createSelect", "(Ljava/util/Set;)Ljava/lang/String;", "createLoadAllSql", "()Ljava/lang/String;", "Landroidx/room/vo/EntityOrView;", "getEntity", "()Landroidx/room/vo/EntityOrView;", "Landroidx/room/compiler/processing/XType;", "getPojoType", "()Landroidx/room/compiler/processing/XType;", "Landroidx/room/vo/Field;", "getField", "()Landroidx/room/vo/Field;", "getParentField", "getEntityField", "Landroidx/room/vo/Junction;", "getJunction", "()Landroidx/room/vo/Junction;", "Ljava/util/List;", "getProjection", "()Ljava/util/List;", "Lcom/squareup/javapoet/x;", "pojoTypeName$delegate", "Lkotlin/Lazy;", "getPojoTypeName", "()Lcom/squareup/javapoet/x;", "pojoTypeName", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Relation {
    private final EntityOrView entity;
    private final Field entityField;
    private final Field field;
    private final Junction junction;
    private final Field parentField;
    private final XType pojoType;
    private final Lazy pojoTypeName$delegate;
    private final List<String> projection;

    public Relation(EntityOrView r5, XType r10, Field r11, Field r12, Field r13, Junction r14, List<String> r15) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        Intrinsics.checkNotNullParameter(r10, "pojoType");
        Intrinsics.checkNotNullParameter(r11, "field");
        Intrinsics.checkNotNullParameter(r12, "parentField");
        Intrinsics.checkNotNullParameter(r13, "entityField");
        Intrinsics.checkNotNullParameter(r15, "projection");
        this.entity = r5;
        this.pojoType = r10;
        this.field = r11;
        this.parentField = r12;
        this.entityField = r13;
        this.junction = r14;
        this.projection = r15;
        this.pojoTypeName$delegate = LazyKt.lazy(new Relation$pojoTypeName$2(this));
    }

    private final String createSelect(Set<String> r19) {
        StringBuilder r5 = new StringBuilder();
        if (this.junction == null) goto L9;
        Set<String> r10 = r19;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        String r13 = (String) r12.next();
        StringBuilder r14 = androidx.constraintlayout.motion.widget.a.y("`", this.entity.getTableName(), "`.`", r13, "` AS `");
        r14.append(r13);
        r14.append("`");
        r11.add(r14.toString());
        goto L6
    L8:
        String r15 = CollectionsKt.q(CollectionsKt.plus(r11, "_junction.`" + this.junction.getParentField().getColumnName() + "`"), ",", null, null, 0, null, null, 62);
        StringBuilder r16 = new StringBuilder("SELECT ");
        r16.append(r15);
        r5.append(r16.toString());
        r5.append(" FROM `" + this.junction.getEntity().getTableName() + "` AS _junction");
        String r17 = this.entity.getTableName();
        String r18 = this.junction.getEntityField().getColumnName();
        r5.append(androidx.constraintlayout.motion.widget.a.u(androidx.constraintlayout.motion.widget.a.y(" INNER JOIN `", r17, "` ON (_junction.`", r18, "` = `"), this.entity.getTableName(), "`.`", this.entityField.getColumnName(), "`)"));
        r5.append(" WHERE _junction.`" + this.junction.getParentField().getColumnName() + "` IN (:args)");
    L15:
        return r5.toString();
    L9:
        Set<String> r20 = r19;
        ArrayList r21 = new ArrayList(CollectionsKt.h(r20));
        Iterator<T> r22 = r20.iterator();
    L11:
        if (r22.hasNext() == false) goto L13;
        r21.add("`" + ((String) r22.next()) + "`");
        goto L11
    L13:
        String r23 = CollectionsKt.q(SetsKt.plus(CollectionsKt.toSet(r21), "`" + this.entityField.getColumnName() + "`"), ",", null, null, 0, null, null, 62);
        StringBuilder r24 = new StringBuilder("SELECT ");
        r24.append(r23);
        r5.append(r24.toString());
        r5.append(" FROM `" + this.entity.getTableName() + "`");
        r5.append(" WHERE `" + this.entityField.getColumnName() + "` IN (:args)");
        goto L15
    }

    public final String createLoadAllSql() {
        return createSelect(CollectionsKt.toSet(this.projection));
    }

    public final EntityOrView getEntity() {
        return this.entity;
    }

    public final Field getEntityField() {
        return this.entityField;
    }

    public final Field getField() {
        return this.field;
    }

    public final Junction getJunction() {
        return this.junction;
    }

    public final Field getParentField() {
        return this.parentField;
    }

    public final XType getPojoType() {
        return this.pojoType;
    }

    public final x getPojoTypeName() {
        return (x) this.pojoTypeName$delegate.getValue();
    }

    public final List<String> getProjection() {
        return this.projection;
    }
}
