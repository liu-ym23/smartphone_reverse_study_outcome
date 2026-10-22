package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import he.i;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentSender f511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f512b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f514n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentSender f515a;

        public a(IntentSender r8) {
            i.f(r8, "intentSender");
            this.f515a = r8;
        }
    }

    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        public final IntentSenderRequest createFromParcel(Parcel r8) {
            i.f(r8, "inParcel");
            Parcelable r10 = r8.readParcelable(IntentSender.class.getClassLoader());
            i.c(r10);
            return new IntentSenderRequest((IntentSender) r10, (Intent) r8.readParcelable(Intent.class.getClassLoader()), r8.readInt(), r8.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final IntentSenderRequest[] newArray(int r8) {
            return new IntentSenderRequest[r8];
        }
    }

    static {
        CREATOR = new b();
    }

    public IntentSenderRequest(IntentSender r8, Intent r10, int r11, int r12) {
        i.f(r8, "intentSender");
        this.f511a = r8;
        this.f512b = r10;
        this.f513m = r11;
        this.f514n = r12;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        i.f(r8, "dest");
        r8.writeParcelable(this.f511a, r10);
        r8.writeParcelable(this.f512b, r10);
        r8.writeInt(this.f513m);
        r8.writeInt(this.f514n);
    }
}
