package androidx.room.vo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/room/vo/Junction;", "", "entity", "Landroidx/room/vo/EntityOrView;", "parentField", "Landroidx/room/vo/Field;", "entityField", "(Landroidx/room/vo/EntityOrView;Landroidx/room/vo/Field;Landroidx/room/vo/Field;)V", "getEntity", "()Landroidx/room/vo/EntityOrView;", "getEntityField", "()Landroidx/room/vo/Field;", "getParentField", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Junction {
    private final EntityOrView entity;
    private final Field entityField;
    private final Field parentField;

    public Junction(EntityOrView r5, Field r10, Field r11) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        Intrinsics.checkNotNullParameter(r10, "parentField");
        Intrinsics.checkNotNullParameter(r11, "entityField");
        this.entity = r5;
        this.parentField = r10;
        this.entityField = r11;
    }

    public static /* synthetic */ Junction copy$default(Junction r5, EntityOrView r10, Field r11, Field r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.entity;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.parentField;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.entityField;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final EntityOrView component1() {
        return this.entity;
    }

    public final Field component2() {
        return this.parentField;
    }

    public final Field component3() {
        return this.entityField;
    }

    public final Junction copy(EntityOrView r5, Field r10, Field r11) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        Intrinsics.checkNotNullParameter(r10, "parentField");
        Intrinsics.checkNotNullParameter(r11, "entityField");
        return new Junction(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Junction) == true) goto L8;
        return false;
    L8:
        Junction r10 = (Junction) r5;
        if (Intrinsics.areEqual(this.entity, r10.entity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentField, r10.parentField) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityField, r10.entityField) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final EntityOrView getEntity() {
        return this.entity;
    }

    public final Field getEntityField() {
        return this.entityField;
    }

    public final Field getParentField() {
        return this.parentField;
    }

    public int hashCode() {
        int r5 = this.entity.hashCode() * 31;
        int r10 = (this.parentField.hashCode() + r5) * 31;
        return this.entityField.hashCode() + r10;
    }

    public String toString() {
        return "Junction(entity=" + this.entity + ", parentField=" + this.parentField + ", entityField=" + this.entityField + ")";
    }
}
