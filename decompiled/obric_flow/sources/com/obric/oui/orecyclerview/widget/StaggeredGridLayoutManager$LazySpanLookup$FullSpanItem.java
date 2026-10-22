package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"BanParcelableUsage"})
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f13778c;
    public boolean d;

    static {
        CREATOR = new z0(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f13776a + ", mGapDir=" + this.f13777b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.f13778c) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f13776a);
        r5.writeInt(this.f13777b);
        r5.writeInt(this.d ? 1 : 0);
        int[] r11 = this.f13778c;
        if (r11 != null) goto L5;
    L7:
        r5.writeInt(0);
        return;
    L5:
        if (r11.length <= 0) goto L7;
        r5.writeInt(r11.length);
        r5.writeIntArray(r11);
    }
}
