package androidx.room.vo;

import ai.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/room/vo/FieldWithIndex;", "", "field", "Landroidx/room/vo/Field;", "indexVar", "", "alwaysExists", "", "(Landroidx/room/vo/Field;Ljava/lang/String;Z)V", "getAlwaysExists", "()Z", "getField", "()Landroidx/room/vo/Field;", "getIndexVar", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FieldWithIndex {
    public static final Companion Companion = null;
    private final boolean alwaysExists;
    private final Field field;
    private final String indexVar;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Landroidx/room/vo/FieldWithIndex$Companion;", "", "()V", "byOrder", "", "Landroidx/room/vo/FieldWithIndex;", "fields", "Landroidx/room/vo/Field;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final List<FieldWithIndex> byOrder(List<Field> r10) {
            Intrinsics.checkNotNullParameter(r10, "fields");
            ArrayList r5 = new ArrayList(CollectionsKt.h(r10));
            Iterator<T> r11 = r10.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L9;
            Object r13 = r11.next();
            int r14 = r12 + 1;
            if (r12 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            r5.add(new FieldWithIndex((Field) r13, String.valueOf(r14), true));
            r12 = r14;
            goto L4
        L9:
            return r5;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FieldWithIndex(Field r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "indexVar");
        this.field = r5;
        this.indexVar = r10;
        this.alwaysExists = r11;
    }

    public static /* synthetic */ FieldWithIndex copy$default(FieldWithIndex r5, Field r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.field;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.indexVar;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.alwaysExists;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final Field component1() {
        return this.field;
    }

    public final String component2() {
        return this.indexVar;
    }

    public final boolean component3() {
        return this.alwaysExists;
    }

    public final FieldWithIndex copy(Field r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "indexVar");
        return new FieldWithIndex(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FieldWithIndex) == true) goto L8;
        return false;
    L8:
        FieldWithIndex r10 = (FieldWithIndex) r5;
        if (Intrinsics.areEqual(this.field, r10.field) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.indexVar, r10.indexVar) == true) goto L15;
        return false;
    L15:
        if (this.alwaysExists == r10.alwaysExists) goto L17;
        return false;
    L17:
        return true;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.field.hashCode() * 31, 31, this.indexVar);
        boolean r10 = this.alwaysExists;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return r5 + r11;
    }

    public String toString() {
        Field r5 = this.field;
        String r10 = this.indexVar;
        boolean r11 = this.alwaysExists;
        StringBuilder r12 = new StringBuilder("FieldWithIndex(field=");
        r12.append(r5);
        r12.append(", indexVar=");
        r12.append(r10);
        r12.append(", alwaysExists=");
        return j0.r(r12, r11, ")");
    }
}
