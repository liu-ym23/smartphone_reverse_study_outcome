package com.obric.oui.orecyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13931a;

    public /* synthetic */ z0(int r5) {
        this.f13931a = r5;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r5) {
        switch(this.f13931a) {
            case 0: goto L29;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        LinearLayoutManager$SavedState r10 = new LinearLayoutManager$SavedState();
        r10.f13720a = r5.readInt();
        r10.f13721b = r5.readInt();
        boolean r11 = true;
        if (r5.readInt() == 1) goto L8;
        r11 = false;
    L8:
        r10.f13722c = r11;
        return r10;
    L10:
        StaggeredGridLayoutManager$SavedState r12 = new StaggeredGridLayoutManager$SavedState();
        r12.f13779a = r5.readInt();
        r12.f13780b = r5.readInt();
        int r13 = r5.readInt();
        r12.f13781c = r13;
        if (r13 <= 0) goto L13;
        int[] r14 = new int[r13];
        r12.d = r14;
        r5.readIntArray(r14);
    L13:
        int r15 = r5.readInt();
        r12.e = r15;
        if (r15 <= 0) goto L16;
        int[] r16 = new int[r15];
        r12.f = r16;
        r5.readIntArray(r16);
    L16:
        boolean r17 = false;
        if (r5.readInt() != 1) goto L19;
        boolean r18 = true;
    L20:
        r12.f13782h = r18;
        if (r5.readInt() != 1) goto L23;
        boolean r19 = true;
    L24:
        r12.f13783i = r19;
        if (r5.readInt() != 1) goto L27;
        r17 = true;
    L27:
        r12.f13784j = r17;
        r12.g = r5.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
        return r12;
    L23:
        r19 = false;
        goto L24
    L19:
        r18 = false;
        goto L20
    L29:
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r20 = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        r20.f13776a = r5.readInt();
        r20.f13777b = r5.readInt();
        boolean r21 = true;
        if (r5.readInt() == 1) goto L33;
        r21 = false;
    L33:
        r20.d = r21;
        int r22 = r5.readInt();
        if (r22 <= 0) goto L36;
        int[] r23 = new int[r22];
        r20.f13778c = r23;
        r5.readIntArray(r23);
    L36:
        return r20;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        switch(this.f13931a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new LinearLayoutManager$SavedState[r5];
    L7:
        return new StaggeredGridLayoutManager$SavedState[r5];
    L9:
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[r5];
    }
}
