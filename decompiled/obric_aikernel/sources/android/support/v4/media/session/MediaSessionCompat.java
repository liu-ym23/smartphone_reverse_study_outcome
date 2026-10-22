package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.media.VolumeProviderCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaControllerCompat f204a;

    static class MediaSessionImplBase {

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1, reason: invalid class name */
        class AnonymousClass1 extends VolumeProviderCompat.Callback {
            final /* synthetic */ MediaSessionImplBase this$0;

            AnonymousClass1(MediaSessionImplBase r10) {
            }

            @Override // androidx.media.VolumeProviderCompat.Callback
            public void onVolumeChanged(VolumeProviderCompat r10) {
                throw null;
            }
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        static class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            public QueueItem a(Parcel r10) {
                return new QueueItem(r10);
            }

            public QueueItem[] b(int r10) {
                return new QueueItem[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueueItem createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueueItem[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        QueueItem(Parcel r10) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
            this.mId = r10.readLong();
        }

        public QueueItem(MediaDescriptionCompat r10, long r11) {
            this(null, r10, r11);
        }

        private QueueItem(Object r10, MediaDescriptionCompat r11, long r12) {
            if (r11 == null) goto L11;
            if (r12 == (-1)) goto L9;
            this.mDescription = r11;
            this.mId = r12;
            this.mItem = r10;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        public static QueueItem fromQueueItem(Object r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new QueueItem(r10, MediaDescriptionCompat.fromMediaDescription(d.a.b(r10)), d.a.c(r10));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L14;
            ArrayList r11 = new ArrayList();
            Iterator<?> r12 = r10.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(fromQueueItem(r12.next()));
            goto L8
        L10:
            return r11;
        L14:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public Object getQueueItem() {
            Object r10 = this.mItem;
            if (r10 == null) goto L5;
            return r10;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Object r11 = d.a.a(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r11;
            return r11;
        L10:
            return r10;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            this.mDescription.writeToParcel(r10, r11);
            r10.writeLong(this.mId);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            public ResultReceiverWrapper a(Parcel r10) {
                return new ResultReceiverWrapper(r10);
            }

            public ResultReceiverWrapper[] b(int r10) {
                return new ResultReceiverWrapper[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ResultReceiverWrapper createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ ResultReceiverWrapper[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        ResultReceiverWrapper(Parcel r10) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r10);
        }

        public ResultReceiverWrapper(ResultReceiver r10) {
            this.mResultReceiver = r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            this.mResultReceiver.writeToParcel(r10, r11);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private b mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        static class a implements Parcelable.Creator<Token> {
            a() {
            }

            public Token a(Parcel r10) {
                if (Build.VERSION.SDK_INT < 21) goto L5;
                Object r11 = r10.readParcelable(null);
            L7:
                return new Token(r11);
            L5:
                r11 = r10.readStrongBinder();
                goto L7
            }

            public Token[] b(int r10) {
                return new Token[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Token createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Token[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        Token(Object r10) {
            this(r10, null, null);
        }

        Token(Object r10, b r11) {
            this(r10, r11, null);
        }

        Token(Object r10, b r11, Bundle r12) {
            this.mInner = r10;
            this.mExtraBinder = r11;
            this.mSessionToken2Bundle = r12;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromBundle(Bundle r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            b r11 = b.a.U0(BundleCompat.getBinder(r10, "android.support.v4.media.session.EXTRA_BINDER"));
            Bundle r12 = r10.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            Token r13 = (Token) r10.getParcelable("android.support.v4.media.session.TOKEN");
            if (r13 != null) goto L9;
            return null;
        L9:
            return new Token(r13.mInner, r11, r12);
        }

        public static Token fromToken(Object r10) {
            return fromToken(r10, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Token fromToken(Object r10, b r11) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT >= 21) goto L6;
            return null;
        L6:
            return new Token(d.a(r10), r11);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r11 = (Token) r10;
            Object r12 = this.mInner;
            if (r12 == null) goto L11;
            Object r13 = r11.mInner;
            if (r13 != null) goto L19;
            return false;
        L19:
            return r12.equals(r13);
        L11:
            if (r11.mInner != null) goto L14;
            return true;
        L14:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public b getExtraBinder() {
            return this.mExtraBinder;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object r10 = this.mInner;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setExtraBinder(b r10) {
            this.mExtraBinder = r10;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void setSessionToken2Bundle(Bundle r10) {
            this.mSessionToken2Bundle = r10;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Bundle toBundle() {
            Bundle r10 = new Bundle();
            r10.putParcelable("android.support.v4.media.session.TOKEN", this);
            b r11 = this.mExtraBinder;
            if (r11 == null) goto L5;
            BundleCompat.putBinder(r10, "android.support.v4.media.session.EXTRA_BINDER", r11.asBinder());
        L5:
            Bundle r12 = this.mSessionToken2Bundle;
            if (r12 == null) goto L8;
            r10.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", r12);
        L8:
            return r10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            int r12 = Build.VERSION.SDK_INT;
            Object r13 = this.mInner;
            if (r12 < 21) goto L5;
            r10.writeParcelable((Parcelable) r13, r11);
            return;
        L5:
            r10.writeStrongBinder((IBinder) r13);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void a(@Nullable Bundle r10) {
        if (r10 == null) goto L5;
        r10.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public MediaControllerCompat b() {
        return this.f204a;
    }
}
