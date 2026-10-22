package com.obric.oui.orecyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class StaggeredGridLayoutManager$SavedState implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13781c;
    public int[] d;
    public int e;
    public int[] f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13784j;

    static {
        CREATOR = new z0(1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f13779a);
        r5.writeInt(this.f13780b);
        int r11 = this.f13781c;
        r5.writeInt(r11);
        if (r11 <= 0) goto L5;
        r5.writeIntArray(this.d);
    L5:
        int r12 = this.e;
        r5.writeInt(r12);
        if (r12 <= 0) goto L8;
        r5.writeIntArray(this.f);
    L8:
        r5.writeInt(this.f13782h ? 1 : 0);
        r5.writeInt(this.f13783i ? 1 : 0);
        r5.writeInt(this.f13784j ? 1 : 0);
        r5.writeList(this.g);
    }
}
