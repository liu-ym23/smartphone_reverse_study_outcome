package androidx.room.processor;

import androidx.room.compiler.processing.XType;
import androidx.room.vo.ForeignKeyAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, d2 = {"Landroidx/room/processor/ForeignKeyInput;", "", "parent", "Landroidx/room/compiler/processing/XType;", "parentColumns", "", "", "childColumns", "onDelete", "Landroidx/room/vo/ForeignKeyAction;", "onUpdate", "deferred", "", "(Landroidx/room/compiler/processing/XType;Ljava/util/List;Ljava/util/List;Landroidx/room/vo/ForeignKeyAction;Landroidx/room/vo/ForeignKeyAction;Z)V", "getChildColumns", "()Ljava/util/List;", "getDeferred", "()Z", "getOnDelete", "()Landroidx/room/vo/ForeignKeyAction;", "getOnUpdate", "getParent", "()Landroidx/room/compiler/processing/XType;", "getParentColumns", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ForeignKeyInput {
    private final List<String> childColumns;
    private final boolean deferred;
    private final ForeignKeyAction onDelete;
    private final ForeignKeyAction onUpdate;
    private final XType parent;
    private final List<String> parentColumns;

    public ForeignKeyInput(XType r5, List<String> r10, List<String> r11, ForeignKeyAction r12, ForeignKeyAction r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r10, "parentColumns");
        Intrinsics.checkNotNullParameter(r11, "childColumns");
        this.parent = r5;
        this.parentColumns = r10;
        this.childColumns = r11;
        this.onDelete = r12;
        this.onUpdate = r13;
        this.deferred = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForeignKeyInput copy$default(ForeignKeyInput r5, XType r10, List r11, List r12, ForeignKeyAction r13, ForeignKeyAction r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.parent;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.parentColumns;
    L8:
        List r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.childColumns;
    L11:
        List r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.onDelete;
    L14:
        ForeignKeyAction r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.onUpdate;
    L17:
        ForeignKeyAction r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.deferred;
    L20:
        XType r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final XType component1() {
        return this.parent;
    }

    public final List<String> component2() {
        return this.parentColumns;
    }

    public final List<String> component3() {
        return this.childColumns;
    }

    public final ForeignKeyAction component4() {
        return this.onDelete;
    }

    public final ForeignKeyAction component5() {
        return this.onUpdate;
    }

    public final boolean component6() {
        return this.deferred;
    }

    public final ForeignKeyInput copy(XType r10, List<String> r11, List<String> r12, ForeignKeyAction r13, ForeignKeyAction r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "parentColumns");
        Intrinsics.checkNotNullParameter(r12, "childColumns");
        return new ForeignKeyInput(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ForeignKeyInput) == true) goto L8;
        return false;
    L8:
        ForeignKeyInput r10 = (ForeignKeyInput) r5;
        if (Intrinsics.areEqual(this.parent, r10.parent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentColumns, r10.parentColumns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.childColumns, r10.childColumns) == true) goto L18;
        return false;
    L18:
        if (this.onDelete == r10.onDelete) goto L21;
        return false;
    L21:
        if (this.onUpdate == r10.onUpdate) goto L24;
        return false;
    L24:
        if (this.deferred == r10.deferred) goto L26;
        return false;
    L26:
        return true;
    }

    public final List<String> getChildColumns() {
        return this.childColumns;
    }

    public final boolean getDeferred() {
        return this.deferred;
    }

    public final ForeignKeyAction getOnDelete() {
        return this.onDelete;
    }

    public final ForeignKeyAction getOnUpdate() {
        return this.onUpdate;
    }

    public final XType getParent() {
        return this.parent;
    }

    public final List<String> getParentColumns() {
        return this.parentColumns;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.f(this.childColumns, androidx.constraintlayout.motion.widget.a.f(this.parentColumns, this.parent.hashCode() * 31, 31), 31);
        ForeignKeyAction r10 = this.onDelete;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        ForeignKeyAction r14 = this.onUpdate;
        if (r14 == null) goto L10;
        r11 = r14.hashCode();
    L10:
        int r15 = (r13 + r11) * 31;
        boolean r16 = this.deferred;
        ?? r17 = r16;
        if (r16 == false) goto L14;
        r17 = 1;
    L14:
        return r15 + r17;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "ForeignKeyInput(parent=" + this.parent + ", parentColumns=" + this.parentColumns + ", childColumns=" + this.childColumns + ", onDelete=" + this.onDelete + ", onUpdate=" + this.onUpdate + ", deferred=" + this.deferred + ")";
    }
}
