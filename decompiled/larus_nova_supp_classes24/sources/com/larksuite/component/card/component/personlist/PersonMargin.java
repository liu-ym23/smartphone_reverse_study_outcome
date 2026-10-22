package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonMargin;", "Landroid/os/Parcelable;", "left", "", "right", "top", "bottom", "<init>", "(IIII)V", "getLeft", "()I", "getRight", "getTop", "getBottom", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonMargin implements Parcelable {
    public static final Parcelable.Creator<PersonMargin> CREATOR = null;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public static final class a implements Parcelable.Creator<PersonMargin> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonMargin createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new PersonMargin(r5.readInt(), r5.readInt(), r5.readInt(), r5.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PersonMargin[] newArray(int r1) {
            return new PersonMargin[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ PersonMargin copy$default(PersonMargin r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.left;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.right;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.top;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bottom;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.right;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.bottom;
    }

    public final PersonMargin copy(int r2, int r3, int r4, int r5) {
        return new PersonMargin(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PersonMargin) == true) goto L8;
        return false;
    L8:
        PersonMargin r6 = (PersonMargin) r5;
        if (this.left == r6.left) goto L12;
        return false;
    L12:
        if (this.right == r6.right) goto L15;
        return false;
    L15:
        if (this.top == r6.top) goto L18;
        return false;
    L18:
        if (this.bottom == r6.bottom) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.right) * 31) + this.top) * 31) + this.bottom;
    }

    public String toString() {
        return "PersonMargin(left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.left);
        r1.writeInt(this.right);
        r1.writeInt(this.top);
        r1.writeInt(this.bottom);
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public PersonMargin(int r1, int r2, int r3, int r4) {
        this.left = r1;
        this.right = r2;
        this.top = r3;
        this.bottom = r4;
    }
}
