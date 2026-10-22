package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer {
    public IconCompatParcelizer() {
    }

    public static IconCompat read(VersionedParcel r5) {
        IconCompat r10 = new IconCompat();
        r10.mType = r5.readInt(r10.mType, 1);
        r10.mData = r5.readByteArray(r10.mData, 2);
        r10.mParcelable = r5.readParcelable(r10.mParcelable, 3);
        r10.mInt1 = r5.readInt(r10.mInt1, 4);
        r10.mInt2 = r5.readInt(r10.mInt2, 5);
        r10.mTintList = (ColorStateList) r5.readParcelable(r10.mTintList, 6);
        r10.mTintModeStr = r5.readString(r10.mTintModeStr, 7);
        r10.mString1 = r5.readString(r10.mString1, 8);
        r10.onPostParceling();
        return r10;
    }

    public static void write(IconCompat r5, VersionedParcel r10) {
        r10.setSerializationFlags(true, true);
        r5.onPreParceling(r10.isStream());
        int r11 = r5.mType;
        if ((-1) == r11) goto L5;
        r10.writeInt(r11, 1);
    L5:
        byte[] r12 = r5.mData;
        if (r12 == null) goto L8;
        r10.writeByteArray(r12, 2);
    L8:
        Parcelable r13 = r5.mParcelable;
        if (r13 == null) goto L11;
        r10.writeParcelable(r13, 3);
    L11:
        int r14 = r5.mInt1;
        if (r14 == 0) goto L14;
        r10.writeInt(r14, 4);
    L14:
        int r15 = r5.mInt2;
        if (r15 == 0) goto L17;
        r10.writeInt(r15, 5);
    L17:
        ColorStateList r16 = r5.mTintList;
        if (r16 == null) goto L20;
        r10.writeParcelable(r16, 6);
    L20:
        String r17 = r5.mTintModeStr;
        if (r17 == null) goto L23;
        r10.writeString(r17, 7);
    L23:
        String r18 = r5.mString1;
        if (r18 == null) goto L27;
        r10.writeString(r18, 8);
        return;
    }
}
