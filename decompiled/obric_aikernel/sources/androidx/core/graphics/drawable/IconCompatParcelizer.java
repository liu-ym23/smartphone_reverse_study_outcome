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

    public static IconCompat read(VersionedParcel r10) {
        IconCompat r11 = new IconCompat();
        r11.mType = r10.readInt(r11.mType, 1);
        r11.mData = r10.readByteArray(r11.mData, 2);
        r11.mParcelable = r10.readParcelable(r11.mParcelable, 3);
        r11.mInt1 = r10.readInt(r11.mInt1, 4);
        r11.mInt2 = r10.readInt(r11.mInt2, 5);
        r11.mTintList = (ColorStateList) r10.readParcelable(r11.mTintList, 6);
        r11.mTintModeStr = r10.readString(r11.mTintModeStr, 7);
        r11.mString1 = r10.readString(r11.mString1, 8);
        r11.onPostParceling();
        return r11;
    }

    public static void write(IconCompat r10, VersionedParcel r11) {
        r11.setSerializationFlags(true, true);
        r10.onPreParceling(r11.isStream());
        int r12 = r10.mType;
        if ((-1) == r12) goto L5;
        r11.writeInt(r12, 1);
    L5:
        byte[] r13 = r10.mData;
        if (r13 == null) goto L8;
        r11.writeByteArray(r13, 2);
    L8:
        Parcelable r14 = r10.mParcelable;
        if (r14 == null) goto L11;
        r11.writeParcelable(r14, 3);
    L11:
        int r15 = r10.mInt1;
        if (r15 == 0) goto L14;
        r11.writeInt(r15, 4);
    L14:
        int r16 = r10.mInt2;
        if (r16 == 0) goto L17;
        r11.writeInt(r16, 5);
    L17:
        ColorStateList r17 = r10.mTintList;
        if (r17 == null) goto L20;
        r11.writeParcelable(r17, 6);
    L20:
        String r18 = r10.mTintModeStr;
        if (r18 == null) goto L23;
        r11.writeString(r18, 7);
    L23:
        String r19 = r10.mString1;
        if (r19 == null) goto L27;
        r11.writeString(r19, 8);
        return;
    }
}
