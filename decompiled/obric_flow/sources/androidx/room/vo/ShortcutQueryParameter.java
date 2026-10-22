package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XVariableElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001c\u001a\u00020\u0005J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/room/vo/ShortcutQueryParameter;", "", "element", "Landroidx/room/compiler/processing/XVariableElement;", "name", "", "type", "Landroidx/room/compiler/processing/XType;", "pojoType", "isMultiple", "", "(Landroidx/room/compiler/processing/XVariableElement;Ljava/lang/String;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Z)V", "getElement", "()Landroidx/room/compiler/processing/XVariableElement;", "()Z", "getName", "()Ljava/lang/String;", "getPojoType", "()Landroidx/room/compiler/processing/XType;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "handleMethodName", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutQueryParameter {
    private final XVariableElement element;
    private final boolean isMultiple;
    private final String name;
    private final XType pojoType;
    private final XType type;

    public ShortcutQueryParameter(XVariableElement r5, String r10, XType r11, XType r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "type");
        this.element = r5;
        this.name = r10;
        this.type = r11;
        this.pojoType = r12;
        this.isMultiple = r13;
    }

    public static /* synthetic */ ShortcutQueryParameter copy$default(ShortcutQueryParameter r5, XVariableElement r10, String r11, XType r12, XType r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = r5.element;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = r5.name;
    L8:
        String r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = r5.type;
    L11:
        XType r18 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = r5.pojoType;
    L14:
        XType r19 = r13;
        if ((r15 & 16) == 0) goto L17;
        r14 = r5.isMultiple;
    L17:
        XVariableElement r20 = r10;
        return r5.copy(r20, r17, r18, r19, r14);
    }

    public final XVariableElement component1() {
        return this.element;
    }

    public final String component2() {
        return this.name;
    }

    public final XType component3() {
        return this.type;
    }

    public final XType component4() {
        return this.pojoType;
    }

    public final boolean component5() {
        return this.isMultiple;
    }

    public final ShortcutQueryParameter copy(XVariableElement r10, String r11, XType r12, XType r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "type");
        return new ShortcutQueryParameter(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShortcutQueryParameter) == true) goto L8;
        return false;
    L8:
        ShortcutQueryParameter r10 = (ShortcutQueryParameter) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pojoType, r10.pojoType) == true) goto L21;
        return false;
    L21:
        if (this.isMultiple == r10.isMultiple) goto L23;
        return false;
    L23:
        return true;
    }

    public final XVariableElement getElement() {
        return this.element;
    }

    public final String getName() {
        return this.name;
    }

    public final XType getPojoType() {
        return this.pojoType;
    }

    public final XType getType() {
        return this.type;
    }

    public final String handleMethodName() {
        if (this.isMultiple == false) goto L5;
        return "handleMultiple";
    L5:
        return "handle";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.element.hashCode() * 31, 31, this.name);
        int r10 = (this.type.hashCode() + r5) * 31;
        XType r11 = this.pojoType;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.isMultiple;
        ?? r15 = r14;
        if (r14 == false) goto L10;
        r15 = 1;
    L10:
        return r13 + r15;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final boolean isMultiple() {
        return this.isMultiple;
    }

    public String toString() {
        XVariableElement r5 = this.element;
        String r10 = this.name;
        XType r11 = this.type;
        XType r12 = this.pojoType;
        boolean r13 = this.isMultiple;
        StringBuilder r14 = new StringBuilder("ShortcutQueryParameter(element=");
        r14.append(r5);
        r14.append(", name=");
        r14.append(r10);
        r14.append(", type=");
        r14.append(r11);
        r14.append(", pojoType=");
        r14.append(r12);
        r14.append(", isMultiple=");
        return j0.r(r14, r13, ")");
    }
}
