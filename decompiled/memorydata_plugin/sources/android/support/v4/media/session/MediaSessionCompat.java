package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.core.app.BundleCompat;
import androidx.media.VolumeProviderCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaControllerCompat f70a;

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        static {
            CREATOR = new AnonymousClass1();
        }

        QueueItem(Parcel r4) {
            this.mDescription = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r4), MediaDescriptionCompat.class, "com.obric.memorydata.plugin");
            this.mId = r4.readLong();
        }

        public QueueItem(MediaDescriptionCompat r2, long r3) {
            this(null, r2, r3);
        }

        private QueueItem(Object r3, MediaDescriptionCompat r4, long r5) {
            if (r4 == null) goto L11;
            if (r5 == (-1)) goto L9;
            this.mDescription = r4;
            this.mId = r5;
            this.mItem = r3;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        public static QueueItem fromQueueItem(Object r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new QueueItem(r4, MediaDescriptionCompat.fromMediaDescription(d.a.a(r4)), d.a.b(r4));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r2) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L15;
            ArrayList r0 = new ArrayList();
            Iterator r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            r0.add(fromQueueItem(r4.next()));
            goto L9
        L11:
            return r0;
        L15:
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
            if (this.mItem != null) goto L10;
            if (Build.VERSION.SDK_INT < 21) goto L10;
            Object r0 = d.a.a(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r0;
            return r0;
        L10:
            return this.mItem;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            this.mDescription.writeToParcel(r3, r4);
            r3.writeLong(this.mId);
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        static {
            CREATOR = new AnonymousClass1();
        }

        ResultReceiverWrapper(Parcel r3) {
            this.mResultReceiver = (ResultReceiver) ZeusTransformUtils.preCheckCast(ResultReceiver.CREATOR.createFromParcel(r3), ResultReceiver.class, "com.obric.memorydata.plugin");
        }

        public ResultReceiverWrapper(ResultReceiver r1) {
            this.mResultReceiver = r1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            this.mResultReceiver.writeToParcel(r1, r2);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private b mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        static {
            CREATOR = new AnonymousClass1();
        }

        Token(Object r2) {
            this(r2, null, null);
        }

        Token(Object r3, b r4) {
            this(r3, (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin"), null);
        }

        Token(Object r3, b r4, Bundle r5) {
            b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            this.mInner = r3;
            this.mExtraBinder = r6;
            this.mSessionToken2Bundle = r5;
        }

        public static Token fromBundle(Bundle r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            b r1 = b.a.a(BundleCompat.getBinder(r5, "android.support.v4.media.session.EXTRA_BINDER"));
            Bundle r2 = r5.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            Token r6 = (Token) ZeusTransformUtils.preCheckCast(r5.getParcelable("android.support.v4.media.session.TOKEN"), Token.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L9;
            return null;
        L9:
            return new Token(r6.mInner, r1, r2);
        }

        public static Token fromToken(Object r1) {
            return fromToken(r1, null);
        }

        public static Token fromToken(Object r2, b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return null;
        L7:
            return new Token(d.a(r2), r4);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Token.class) == true) goto L8;
            return false;
        L8:
            Token r6 = (Token) ZeusTransformUtils.preCheckCast(r5, Token.class, "com.obric.memorydata.plugin");
            Object r4 = this.mInner;
            if (r4 == null) goto L11;
            Object r7 = r6.mInner;
            if (r7 != null) goto L19;
            return false;
        L19:
            return r4.equals(r7);
        L11:
            if (r6.mInner != null) goto L14;
            return true;
        L14:
            return false;
        }

        public b getExtraBinder() {
            return this.mExtraBinder;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            Object r0 = this.mInner;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public void setExtraBinder(b r3) {
            this.mExtraBinder = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        }

        public void setSessionToken2Bundle(Bundle r1) {
            this.mSessionToken2Bundle = r1;
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable("android.support.v4.media.session.TOKEN", this);
            b r1 = this.mExtraBinder;
            if (r1 == null) goto L5;
            BundleCompat.putBinder(r0, "android.support.v4.media.session.EXTRA_BINDER", r1.asBinder());
        L5:
            Bundle r3 = this.mSessionToken2Bundle;
            if (r3 == null) goto L8;
            r0.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", r3);
        L8:
            return r0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r4, int r5) {
            int r0 = Build.VERSION.SDK_INT;
            Object r3 = this.mInner;
            if (r0 < 21) goto L5;
            r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.memorydata.plugin"), r5);
            return;
        L5:
            r4.writeStrongBinder((IBinder) ZeusTransformUtils.preCheckCast(r3, IBinder.class, "com.obric.memorydata.plugin"));
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AudioManager f71a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final RemoteControlClient f72b;
        final RemoteCallbackList<android.support.v4.media.session.a> c;
        boolean d;
        int e;
        int f;
        int g;
        VolumeProviderCompat h;
        private final ComponentName i;
        private final PendingIntent j;
        private boolean k;
        private boolean l;

        void a(PendingIntent r1, ComponentName r2) {
            this.f71a.registerMediaButtonEventReceiver(r2);
        }

        void a(ParcelableVolumeInfo r5) {
            int r0 = this.c.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((android.support.v4.media.session.a) ZeusTransformUtils.preCheckCast(this.c.getBroadcastItem(r0), android.support.v4.media.session.a.class, "com.obric.memorydata.plugin")).a(r5);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.c.finishBroadcast();
        }

        void b(PendingIntent r1, ComponentName r2) {
            this.f71a.unregisterMediaButtonEventReceiver(r2);
        }

        boolean update() {
            if (this.d == false) goto L23;
            boolean r0 = this.k;
            if (r0 == false) goto L7;
        L9:
            if (r0 == true) goto L11;
        L13:
            boolean r1 = this.l;
            if (r1 == false) goto L16;
        L18:
            if (r1 == false) goto L29;
            if ((this.e & 2) != 0) goto L29;
        L27:
            this.f72b.setPlaybackState(0);
            this.f71a.unregisterRemoteControlClient(this.f72b);
            this.l = false;
        L29:
            return false;
        L16:
            if ((this.e & 2) == 0) goto L18;
            this.f71a.registerRemoteControlClient(this.f72b);
            this.l = true;
            return true;
        L11:
            if ((this.e & 1) != 0) goto L13;
            b(this.j, this.i);
            this.k = false;
            goto L13
        L7:
            if ((this.e & 1) == 0) goto L9;
            a(this.j, this.i);
            this.k = true;
            goto L13
        L23:
            if (this.k == false) goto L26;
            b(this.j, this.i);
            this.k = false;
        L26:
            if (this.l == false) goto L29;
            goto L27
        }
    }

    public static void a(Bundle r1) {
        if (r1 == null) goto L5;
        r1.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    public MediaControllerCompat a() {
        return this.f70a;
    }
}
