package com.bytedance.android.anniex.container.popup;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SavedState;", "Landroidx/customview/view/AbsSavedState;", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class SavedState extends AbsSavedState {
    public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = null;
    public final int a;

    public static final class a implements Parcelable.ClassLoaderCreator<SavedState> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "inParcel");
            return new SavedState(r10, null);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new SavedState[r1];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final SavedState createFromParcel(Parcel r10, ClassLoader r11) {
            Intrinsics.checkNotNullParameter(r10, "inParcel");
            return new SavedState(r10, r11);
        }
    }

    public static final class b {
    }

    static {
        CREATOR = new a();
    }

    public SavedState(Parcel r10, ClassLoader r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        super(r10, r11);
        this.a = r10.readInt();
    }

    public final void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "out");
        super.writeToParcel(r10, r11);
        r10.writeInt(this.a);
    }

    public SavedState(Parcelable r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "superState");
        super(r10);
        this.a = r11;
    }
}
