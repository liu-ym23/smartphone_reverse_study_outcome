package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/network/QuickNoteConfig;", "", "leftLongPressAction", "", "rightLongPressAction", "leftDoubleClickAction", "rightDoubleClickAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeftLongPressAction", "()Ljava/lang/String;", "getRightLongPressAction", "getLeftDoubleClickAction", "getRightDoubleClickAction", "isEmpty", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    @SerializedName("left_double_click")
    private final String leftDoubleClickAction;

    @SerializedName("left_long_press")
    private final String leftLongPressAction;

    @SerializedName("right_double_click")
    private final String rightDoubleClickAction;

    @SerializedName("right_long_press")
    private final String rightLongPressAction;

    public z() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L8;
        return false;
    L8:
        z r6 = (z) r5;
        if (Intrinsics.areEqual(this.leftLongPressAction, r6.leftLongPressAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightLongPressAction, r6.rightLongPressAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftDoubleClickAction, r6.leftDoubleClickAction) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightDoubleClickAction, r6.rightDoubleClickAction) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.leftLongPressAction;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.rightLongPressAction;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.leftDoubleClickAction;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.rightDoubleClickAction;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickNoteConfig(leftLongPressAction=" + this.leftLongPressAction + ", rightLongPressAction=" + this.rightLongPressAction + ", leftDoubleClickAction=" + this.leftDoubleClickAction + ", rightDoubleClickAction=" + this.rightDoubleClickAction + ')';
    }

    public final boolean f() {
        String r0 = this.leftLongPressAction;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L36;
        String r2 = this.rightLongPressAction;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L37;
        String r4 = this.leftDoubleClickAction;
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L38;
        String r6 = this.rightDoubleClickAction;
        if (r6 != null) goto L29;
    L32:
        boolean r7 = true;
    L33:
        if (r7 == false) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (r6.length() == 0) goto L32;
        r7 = false;
        goto L33
    L38:
        return false;
    L21:
        if (r4.length() == 0) goto L24;
        r5 = false;
        goto L25
    L37:
        return false;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
        goto L17
    L36:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String b() {
        return this.leftDoubleClickAction;
    }

    public final String c() {
        return this.leftLongPressAction;
    }

    public final String d() {
        return this.rightDoubleClickAction;
    }

    public final String e() {
        return this.rightLongPressAction;
    }

    public z(String r1, String r2, String r3, String r4) {
        this.leftLongPressAction = r1;
        this.rightLongPressAction = r2;
        this.leftDoubleClickAction = r3;
        this.rightDoubleClickAction = r4;
    }

    public static z a(z r1, String r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.leftLongPressAction;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.rightLongPressAction;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.leftDoubleClickAction;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.rightDoubleClickAction;
    L15:
        return new z(r2, r3, r4, r5);
    }
}
