package com.larksuite.component.card.component.avatar;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J<\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/avatar/AvatarProps;", "", "personID", "", "size", "", "avatarKey", "clickable", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "getPersonID", "()Ljava/lang/String;", "getSize", "()I", "getAvatarKey", "getClickable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)Lcom/larksuite/component/card/component/avatar/AvatarProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AvatarProps {
    private final String avatarKey;
    private final Boolean clickable;
    private final String personID;
    private final int size;

    public static /* synthetic */ AvatarProps copy$default(AvatarProps r0, String r1, int r2, String r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.personID;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.size;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.avatarKey;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.clickable;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.personID;
    }

    public final int component2() {
        return this.size;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final Boolean component4() {
        return this.clickable;
    }

    public final AvatarProps copy(String r2, int r3, String r4, Boolean r5) {
        return new AvatarProps(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AvatarProps) == true) goto L8;
        return false;
    L8:
        AvatarProps r6 = (AvatarProps) r5;
        if (Intrinsics.areEqual(this.personID, r6.personID) == true) goto L12;
        return false;
    L12:
        if (this.size == r6.size) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickable, r6.clickable) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.personID;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.size) * 31;
        String r4 = this.avatarKey;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.clickable;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AvatarProps(personID=" + this.personID + ", size=" + this.size + ", avatarKey=" + this.avatarKey + ", clickable=" + this.clickable + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final Boolean getClickable() {
        return this.clickable;
    }

    public final String getPersonID() {
        return this.personID;
    }

    public final int getSize() {
        return this.size;
    }

    public AvatarProps(String r1, int r2, String r3, Boolean r4) {
        this.personID = r1;
        this.size = r2;
        this.avatarKey = r3;
        this.clickable = r4;
    }

    public /* synthetic */ AvatarProps(String r2, int r3, String r4, Boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = Boolean.FALSE;
    L11:
        this(r2, r3, r4, r5);
    }
}
