package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f29a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f30b;

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final c mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String r1, Bundle r2, c r3, Handler r4) {
            super(r4);
            this.mAction = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r3, Bundle r4) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.a(r4);
            if (r3 == (-1)) goto L13;
            if (r3 != 0) goto L9;
            this.mCallback.b(this.mAction, this.mExtras, r4);
            return;
        L9:
            if (r3 == 1) goto L11;
            Log.w("MediaBrowserCompat", "Unknown result code: " + r3 + " (extras=" + this.mExtras + ", resultData=" + r4 + ")");
            return;
        L11:
            this.mCallback.a(this.mAction, this.mExtras, r4);
            return;
        L13:
            this.mCallback.c(this.mAction, this.mExtras, r4);
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final d mCallback;
        private final String mMediaId;

        ItemReceiver(String r1, d r2, Handler r3) {
            super(r3);
            this.mMediaId = r1;
            this.mCallback = r2;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r2, Bundle r3) {
            MediaSessionCompat.a(r3);
            if (r2 != 0) goto L16;
            if (r3 == null) goto L16;
            if (r3.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L16;
            Parcelable r4 = r3.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r4 != null) goto L11;
        L14:
            this.mCallback.a((MediaItem) ZeusTransformUtils.preCheckCast(r4, MediaItem.class, "com.obric.memorydata.plugin"));
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r4, MediaItem.class) == true) goto L14;
            this.mCallback.a(this.mMediaId);
            return;
        L16:
            this.mCallback.a(this.mMediaId);
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        static {
            CREATOR = new AnonymousClass1();
        }

        MediaItem(Parcel r3) {
            this.mFlags = r3.readInt();
            this.mDescription = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r3), MediaDescriptionCompat.class, "com.obric.memorydata.plugin");
        }

        public MediaItem(MediaDescriptionCompat r2, int r3) {
            if (r2 == null) goto L11;
            if (TextUtils.isEmpty(r2.getMediaId()) == true) goto L9;
            this.mFlags = r3;
            this.mDescription = r2;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            int r0 = android.support.v4.media.a.c.a(r2);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.a.c.b(r2)), r0);
        L10:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r2) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L15;
            ArrayList r0 = new ArrayList(r3.size());
            Iterator r4 = r3.iterator();
        L9:
            if (r4.hasNext() == false) goto L11;
            r0.add(fromMediaItem(r4.next()));
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

        public int getFlags() {
            return this.mFlags;
        }

        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPlayable() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("MediaItem{");
            r0.append("mFlags=").append(this.mFlags);
            r0.append(", mDescription=").append(this.mDescription);
            r0.append('}');
            return r0.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r2, r3);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final k mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String r1, Bundle r2, k r3, Handler r4) {
            super(r4);
            this.mQuery = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r6, Bundle r7) {
            MediaSessionCompat.a(r7);
            if (r6 != 0) goto L15;
            if (r7 == null) goto L15;
            if (r7.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L15;
            Parcelable[] r8 = r7.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList r9 = null;
            if (r8 == null) goto L13;
            r9 = new ArrayList();
            int r0 = r8.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L13;
            r9.add((MediaItem) ZeusTransformUtils.preCheckCast(r8[r1], MediaItem.class, "com.obric.memorydata.plugin"));
            r1 = r1 + 1;
        L13:
            this.mCallback.a(this.mQuery, this.mExtras, r9);
            return;
        L15:
            this.mCallback.a(this.mQuery, this.mExtras);
        }
    }

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f31a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f32b;

        a(j r3) {
            this.f31a = new WeakReference((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"));
        }

        void a(Messenger r2) {
            this.f32b = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r12) {
            WeakReference<Messenger> r1 = this.f32b;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.get() != null) goto L7;
            return;
        L7:
            if (this.f31a.get() == null) goto L33;
            Bundle r2 = r12.getData();
            MediaSessionCompat.a(r2);
            j r3 = (j) ZeusTransformUtils.preCheckCast(this.f31a.get(), j.class, "com.obric.memorydata.plugin");
            Messenger r11 = (Messenger) ZeusTransformUtils.preCheckCast(this.f32b.get(), Messenger.class, "com.obric.memorydata.plugin");
            int r5 = r12.what;     // Catch: BadParcelableException -> L22
            if (r5 != 1) goto L14;
            Bundle r6 = r2.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r6);     // Catch: BadParcelableException -> L22
            r3.a(r11, r2.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) ZeusTransformUtils.preCheckCast(r2.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), MediaSessionCompat.Token.class, "com.obric.memorydata.plugin"), r6);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r5 != 2) goto L16;
            r3.a(r11);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r5 == 3) goto L18;
            Log.w("MediaBrowserCompat", "Unhandled message: " + r12 + "\n  Client version: 1\n  Service version: " + r12.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r9 = r2.getBundle(MediaBrowserProtocol.DATA_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r9);     // Catch: BadParcelableException -> L22
            Bundle r10 = r2.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r10);     // Catch: BadParcelableException -> L22
            r3.a(r11, r2.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), r2.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), r9, r10);     // Catch: BadParcelableException -> L22
        L22:
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (r12.what != 1) goto L32;
            r3.a(r11);
            return;
        L32:
            return;
        }
    }

    public static class b {
        a mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        interface a {
            void a();

            void b();

            void c();
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        private class C0007b implements android.support.v4.media.a.InterfaceC0008a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f33a;

            C0007b(b r1) {
                this.f33a = r1;
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void a() {
                if (this.f33a.mConnectionCallbackInternal == null) goto L5;
                this.f33a.mConnectionCallbackInternal.a();
            L5:
                this.f33a.onConnected();
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void b() {
                if (this.f33a.mConnectionCallbackInternal == null) goto L5;
                this.f33a.mConnectionCallbackInternal.b();
            L5:
                this.f33a.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.InterfaceC0008a
            public void c() {
                if (this.f33a.mConnectionCallbackInternal == null) goto L5;
                this.f33a.mConnectionCallbackInternal.c();
            L5:
                this.f33a.onConnectionFailed();
            }
        }

        public b() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            Object r0 = android.support.v4.media.a.a(new C0007b(this));
        L6:
            this.mConnectionCallbackObj = r0;
            return;
        L5:
            r0 = null;
            goto L6
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        void setInternalConnectionCallback(a r3) {
            this.mConnectionCallbackInternal = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        }
    }

    public static abstract class c {
        public void a(String r1, Bundle r2, Bundle r3) {
        }

        public void b(String r1, Bundle r2, Bundle r3) {
        }

        public void c(String r1, Bundle r2, Bundle r3) {
        }
    }

    public static abstract class d {
        public void a(MediaItem r1) {
        }

        public void a(String r1) {
        }
    }

    interface e {
        void d();

        void e();

        MediaSessionCompat.Token f();
    }

    static class f implements b.a, e, j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f34a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f35b;
        protected final Bundle c;
        protected final a d;
        protected int e;
        protected l f;
        protected Messenger g;
        private final ArrayMap<String, m> h;
        private MediaSessionCompat.Token i;
        private Bundle j;

        f(Context r3, ComponentName r4, b r5, Bundle r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.d = new a(this);
            this.h = new ArrayMap();
            this.f34a = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
            if (r6 == null) goto L5;
            Bundle r0 = new Bundle(r6);
        L6:
            this.c = r0;
            r0.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            r5.setInternalConnectionCallback(this);
            this.f35b = android.support.v4.media.a.a(r7, r4, r5.mConnectionCallbackObj, r0);
            return;
        L5:
            r0 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void a() {
            Bundle r0 = android.support.v4.media.a.c(this.f35b);
            if (r0 != null) goto L5;
            return;
        L5:
            this.e = r0.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder r1 = BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (r1 == null) goto L11;
            this.f = new l(r1, this.c);
            Messenger r2 = new Messenger(this.d);
            this.g = r2;
            this.d.a(r2);
            this.f.b(this.f34a, this.g);     // Catch: RemoteException -> L10
        L10:
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
        L11:
            android.support.v4.media.session.b r3 = android.support.v4.media.session.b.a.a(BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (r3 == null) goto L17;
            this.i = MediaSessionCompat.Token.fromToken(android.support.v4.media.a.d(this.f35b), r3);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r1) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r3, String r4, List r5, Bundle r6, Bundle r7) {
            List<MediaItem> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (this.g == r3) goto L5;
            return;
        L5:
            m r9 = (m) ZeusTransformUtils.preCheckCast(this.h.get(r4), m.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L8;
            n r10 = r9.a(r6);
            if (r10 != null) goto L14;
            return;
        L14:
            if (r6 != null) goto L18;
            if (r8 != null) goto L17;
            r10.a(r4);
            return;
        L17:
            this.j = r7;
            r10.a(r4, r8);
        L21:
            this.j = null;
            return;
        L18:
            if (r8 != null) goto L20;
            r10.a(r4, r6);
            return;
        L20:
            this.j = r7;
            r10.a(r4, r8, r6);
            goto L21
        L8:
            if (MediaBrowserCompat.f29a == false) goto L23;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r4);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            this.f = null;
            this.g = null;
            this.i = null;
            this.d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void d() {
            android.support.v4.media.a.a(this.f35b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void e() {
            l r0 = this.f;
            if (r0 == null) goto L9;
            Messenger r1 = this.g;
            if (r1 == null) goto L9;
            r0.b(r1);     // Catch: RemoteException -> L8
        L8:
            Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        L9:
            android.support.v4.media.a.b(this.f35b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public MediaSessionCompat.Token f() {
            if (this.i != null) goto L6;
            this.i = MediaSessionCompat.Token.fromToken(android.support.v4.media.a.d(this.f35b));
        L6:
            return this.i;
        }
    }

    static class g extends f {
        g(Context r3, ComponentName r4, b r5, Bundle r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }
    }

    static class h extends g {
        h(Context r3, ComponentName r4, b r5, Bundle r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }
    }

    static class i implements e, j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f36a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ComponentName f37b;
        final b c;
        final Bundle d;
        final a e;
        int f;
        a g;
        l h;
        Messenger i;
        private final ArrayMap<String, m> j;
        private String k;
        private MediaSessionCompat.Token l;
        private Bundle m;
        private Bundle n;

        private class a implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f40a;

            a(i r1) {
                this.f40a = r1;
            }

            private void a(Runnable r3) {
                Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
                if (Thread.currentThread() != this.f40a.e.getLooper().getThread()) goto L5;
                r4.run();
                return;
            L5:
                this.f40a.e.post(r4);
            }

            boolean a(String r3) {
                if (this.f40a.g != this) goto L11;
                if (this.f40a.f == 0) goto L11;
                if (this.f40a.f == 1) goto L11;
                return true;
            L11:
                if (this.f40a.f != 0) goto L13;
                return false;
            L13:
                if (this.f40a.f == 1) goto L18;
                Log.i("MediaBrowserCompat", r3 + " for " + this.f40a.f37b + " with mServiceConnection=" + this.f40a.g + " this=" + this);
                return false;
            L18:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r3, IBinder r4) {
                final IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
                a(new AnonymousClass1(this, r3, r5));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r2) {
                a(new AnonymousClass2(this, r2));
            }
        }

        public i(Context r3, ComponentName r4, b r5, Bundle r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.e = new a(this);
            this.j = new ArrayMap();
            this.f = 1;
            if (r7 == null) goto L17;
            if (r4 == null) goto L15;
            if (r5 == null) goto L13;
            this.f36a = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
            this.f37b = r4;
            this.c = r5;
            if (r6 != null) goto L9;
            Bundle r8 = null;
        L10:
            this.d = r8;
            return;
        L9:
            r8 = new Bundle(r6);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }

        private static String a(int r2) {
            if (r2 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r2 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r2 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r2 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r2 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r2;
        }

        private boolean a(Messenger r3, String r4) {
            if (this.i != r3) goto L9;
            int r5 = this.f;
            if (r5 == 0) goto L9;
            if (r5 == 1) goto L9;
            return true;
        L9:
            int r6 = this.f;
            if (r6 == 0) goto L15;
            if (r6 == 1) goto L16;
            Log.i("MediaBrowserCompat", r4 + " for " + this.f37b + " with mCallbacksMessenger=" + this.i + " this=" + this);
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        void a() {
            a r0 = this.g;
            if (r0 == null) goto L5;
            ZeusTransformUtils.unbindService(this.f36a, r0, "com.obric.memorydata.plugin");
        L5:
            this.f = 1;
            this.g = null;
            this.h = null;
            this.i = null;
            this.e.a(null);
            this.k = null;
            this.l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r3) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f37b);
            if (a(r3, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.f == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            return;
        L9:
            a();
            this.c.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r8, String r9, MediaSessionCompat.Token r10, Bundle r11) {
            if (a(r8, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.f == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + a(this.f) + "... ignoring");
            return;
        L9:
            this.k = r9;
            this.l = r10;
            this.m = r11;
            this.f = 3;
            if (MediaBrowserCompat.f29a == false) goto L12;
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            c();
        L12:
            this.c.onConnected();
            Iterator<Map.Entry<String, m>> r12 = this.j.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r12.hasNext() == false) goto L27;
            Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L21
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L21
            m r15 = (m) ZeusTransformUtils.preCheckCast(r13.getValue(), m.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L21
            List<n> r16 = r15.b();     // Catch: RemoteException -> L21
            List<Bundle> r17 = r15.a();     // Catch: RemoteException -> L21
            int r1 = 0;
        L18:
            if (r1 >= r16.size()) goto L15;
            this.h.a(r14, ((n) ZeusTransformUtils.preCheckCast(r16.get(r1), n.class, "com.obric.memorydata.plugin")).f50b, (Bundle) ZeusTransformUtils.preCheckCast(r17.get(r1), Bundle.class, "com.obric.memorydata.plugin"), this.i);     // Catch: RemoteException -> L21
            r1 = r1 + 1;
            goto L18
        L27:
            return;
        L21:
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void a(Messenger r4, String r5, List r6, Bundle r7, Bundle r8) {
            List<MediaItem> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            if (a(r4, "onLoadChildren") == true) goto L6;
            return;
        L6:
            if (MediaBrowserCompat.f29a == false) goto L8;
            Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f37b + " id=" + r5);
        L8:
            m r10 = (m) ZeusTransformUtils.preCheckCast(this.j.get(r5), m.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L11;
            n r11 = r10.a(r7);
            if (r11 != null) goto L17;
            return;
        L17:
            if (r7 != null) goto L21;
            if (r9 != null) goto L20;
            r11.a(r5);
            return;
        L20:
            this.n = r8;
            r11.a(r5, r9);
        L24:
            this.n = null;
            return;
        L21:
            if (r9 != null) goto L23;
            r11.a(r5, r7);
            return;
        L23:
            this.n = r8;
            r11.a(r5, r9, r7);
            goto L24
        L11:
            if (MediaBrowserCompat.f29a == false) goto L26;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r5);
            return;
        }

        public boolean b() {
            if (this.f != 3) goto L5;
            return true;
        L5:
            return false;
        }

        void c() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f37b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.d);
            Log.d("MediaBrowserCompat", "  mState=" + a(this.f));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.g);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.h);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.i);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.l);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void d() {
            int r0 = this.f;
            if (r0 != 0) goto L5;
        L9:
            this.f = 2;
            this.e.post(new AnonymousClass1(this));
            return;
        L5:
            if (r0 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + a(this.f) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void e() {
            this.f = 0;
            this.e.post(new AnonymousClass2(this));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public MediaSessionCompat.Token f() {
            if (b() == false) goto L7;
            return this.l;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f + ")");
        }
    }

    interface j {
        void a(Messenger r1);

        void a(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4);

        void a(Messenger r1, String r2, List r3, Bundle r4, Bundle r5);
    }

    public static abstract class k {
        public void a(String r1, Bundle r2) {
        }

        public void a(String r1, Bundle r2, List<MediaItem> r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f45a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f46b;

        public l(IBinder r3, Bundle r4) {
            this.f45a = new Messenger((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin"));
            this.f46b = r4;
        }

        private void a(int r2, Bundle r3, Messenger r4) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 1;
            r0.setData(r3);
            r0.replyTo = r4;
            this.f45a.send(r0);
        }

        void a(Context r3, Messenger r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r5.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f46b);
            a(1, r0, r4);
        }

        void a(Messenger r3) {
            a(2, null, r3);
        }

        void a(String r3, IBinder r4, Bundle r5, Messenger r6) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            BundleCompat.putBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r7);
            r0.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r5);
            a(3, r0, r6);
        }

        void b(Context r3, Messenger r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r5.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f46b);
            a(6, r0, r4);
        }

        void b(Messenger r3) {
            a(7, null, r3);
        }
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<n> f47a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f48b;

        public m() {
            this.f47a = new ArrayList();
            this.f48b = new ArrayList();
        }

        public n a(Bundle r5) {
            int r0 = 0;
        L4:
            if (r0 >= this.f48b.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions((Bundle) ZeusTransformUtils.preCheckCast(this.f48b.get(r0), Bundle.class, "com.obric.memorydata.plugin"), r5) == true) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return (n) ZeusTransformUtils.preCheckCast(this.f47a.get(r0), n.class, "com.obric.memorydata.plugin");
        L10:
            return null;
        }

        public List<Bundle> a() {
            return this.f48b;
        }

        public List<n> b() {
            return this.f47a;
        }
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f49a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f50b;
        WeakReference<m> c;

        private class a implements android.support.v4.media.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f51a;

            a(n r1) {
                this.f51a = r1;
            }

            List<MediaItem> a(List<MediaItem> r3, Bundle r4) {
                List<MediaItem> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                if (r2 != null) goto L6;
                return null;
            L6:
                int r5 = r4.getInt("android.media.browse.extra.PAGE", -1);
                int r6 = r4.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (r5 != (-1)) goto L10;
                if (r6 != (-1)) goto L10;
                return r2;
            L10:
                int r0 = r6 * r5;
                int r1 = r0 + r6;
                if (r5 < 0) goto L23;
                if (r6 < 1) goto L23;
                if (r0 >= r2.size()) goto L23;
                if (r1 <= r2.size()) goto L21;
                r1 = r2.size();
            L21:
                return r2.subList(r0, r1);
            L23:
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.a.d
            public void a(String r1) {
                this.f51a.a(r1);
            }

            @Override // android.support.v4.media.a.d
            public void a(String r8, List<?> r9) {
                List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
                if (this.f51a.c != null) goto L5;
                m r0 = null;
            L6:
                if (r0 != null) goto L8;
                this.f51a.a(r8, MediaItem.fromMediaItemList(r10));
                return;
            L8:
                List<MediaItem> r11 = MediaItem.fromMediaItemList(r10);
                List<n> r2 = r0.b();
                List<Bundle> r1 = r0.a();
                int r3 = 0;
            L10:
                if (r3 >= r2.size()) goto L20;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(r1.get(r3), Bundle.class, "com.obric.memorydata.plugin");
                if (r4 != null) goto L14;
                this.f51a.a(r8, r11);
            L15:
                r3 = r3 + 1;
                goto L10
            L14:
                this.f51a.a(r8, a(r11, r4), r4);
                goto L15
            L20:
                return;
            L5:
                r0 = (m) ZeusTransformUtils.preCheckCast(this.f51a.c.get(), m.class, "com.obric.memorydata.plugin");
                goto L6
            }
        }

        private class b extends a implements android.support.v4.media.b.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n f52b;

            b(n r1) {
                this.f52b = r1;
                super(r1);
            }

            @Override // android.support.v4.media.b.a
            public void a(String r1, Bundle r2) {
                this.f52b.a(r1, r2);
            }

            @Override // android.support.v4.media.b.a
            public void a(String r3, List<?> r4, Bundle r5) {
                List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                this.f52b.a(r3, MediaItem.fromMediaItemList(r6), r5);
            }
        }

        public n() {
            this.f50b = new Binder();
            if (Build.VERSION.SDK_INT < 26) goto L7;
            Object r0 = android.support.v4.media.b.a(new b(this));
        L5:
            this.f49a = r0;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 21) goto L9;
            r0 = android.support.v4.media.a.a(new a(this));
            goto L5
        L9:
            r0 = null;
            goto L5
        }

        public void a(String r1) {
        }

        public void a(String r1, Bundle r2) {
        }

        public void a(String r1, List<MediaItem> r2) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        }

        public void a(String r1, List<MediaItem> r2, Bundle r3) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f29a = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context r3, ComponentName r4, b r5, Bundle r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        e r0 = new h(r7, r4, r5, r6);
    L5:
        this.f30b = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0 = new g(r7, r4, r5, r6);
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r0 = new f(r7, r4, r5, r6);
        goto L5
    L12:
        r0 = new i(r7, r4, r5, r6);
        goto L5
    }

    public void a() {
        this.f30b.d();
    }

    public void b() {
        this.f30b.e();
    }

    public MediaSessionCompat.Token c() {
        return this.f30b.f();
    }
}
