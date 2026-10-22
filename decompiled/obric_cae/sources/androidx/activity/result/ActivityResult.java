package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f506b;

    public class a implements Parcelable.Creator<ActivityResult> {
        @Override // android.os.Parcelable.Creator
        public final ActivityResult createFromParcel(Parcel r8) {
            return new ActivityResult(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ActivityResult[] newArray(int r8) {
            return new ActivityResult[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ActivityResult(Intent r8, int r10) {
        this.f505a = r10;
        this.f506b = r8;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("ActivityResult{resultCode=");
        int r10 = this.f505a;
        if (r10 == (-1)) goto L7;
        if (r10 == 0) goto L6;
        String r11 = String.valueOf(r10);
    L8:
        r8.append(r11);
        r8.append(", data=");
        r8.append(this.f506b);
        r8.append('}');
        return r8.toString();
    L6:
        r11 = "RESULT_CANCELED";
        goto L8
    L7:
        r11 = "RESULT_OK";
        goto L8
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f505a);
        Intent r11 = this.f506b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        r8.writeInt(r12);
        if (r11 == null) goto L10;
        r11.writeToParcel(r8, r10);
        return;
    L10:
        return;
    L5:
        r12 = 1;
        goto L6
    }

    public ActivityResult(Parcel r8) {
        this.f505a = r8.readInt();
        if (r8.readInt() != 0) goto L5;
        Intent r10 = null;
    L6:
        this.f506b = r10;
        return;
    L5:
        r10 = (Intent) Intent.CREATOR.createFromParcel(r8);
        goto L6
    }
}
