package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f408b;

        public static class a implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            public final QueueItem createFromParcel(Parcel r8) {
                return new QueueItem(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final QueueItem[] newArray(int r8) {
                return new QueueItem[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public QueueItem(Parcel r8) {
            this.f407a = MediaDescriptionCompat.CREATOR.createFromParcel(r8);
            this.f408b = r8.readLong();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.f407a + ", Id=" + this.f408b + " }";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            this.f407a.writeToParcel(r8, r10);
            r8.writeLong(this.f408b);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResultReceiver f409a;

        public static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper createFromParcel(Parcel r8) {
                return new ResultReceiverWrapper(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final ResultReceiverWrapper[] newArray(int r8) {
                return new ResultReceiverWrapper[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public ResultReceiverWrapper(Parcel r8) {
            this.f409a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r8);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            this.f409a.writeToParcel(r8, r10);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IMediaSession f411b;

        public static class a implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            public final Token createFromParcel(Parcel r8) {
                return new Token(r8.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            public final Token[] newArray(int r8) {
                return new Token[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public Token(Parcelable r8) {
            this.f410a = r8;
            this.f411b = null;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r10 = (Token) r8;
            Object r11 = this.f410a;
            if (r11 == null) goto L11;
            Object r12 = r10.f410a;
            if (r12 != null) goto L19;
            return false;
        L19:
            return r11.equals(r12);
        L11:
            if (r10.f410a != null) goto L14;
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            Object r8 = this.f410a;
            if (r8 != null) goto L7;
            return 0;
        L7:
            return r8.hashCode();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeParcelable((Parcelable) this.f410a, r10);
        }
    }

    public static void a(Bundle r8) {
        if (r8 == null) goto L5;
        r8.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }
}
