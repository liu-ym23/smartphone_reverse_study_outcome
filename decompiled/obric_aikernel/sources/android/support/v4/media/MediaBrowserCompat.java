package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f141b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f142a;

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final c mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String r10, Bundle r11, c r12, Handler r13) {
            super(r13);
            this.mAction = r10;
            this.mExtras = r11;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int r10, Bundle r11) {
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final d mCallback;
        private final String mMediaId;

        ItemReceiver(String r10, d r11, Handler r12) {
            super(r12);
            this.mMediaId = r10;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int r10, Bundle r11) {
            MediaSessionCompat.a(r11);
            if (r10 != 0) goto L15;
            if (r11 != null) goto L6;
            throw null;
        L6:
            if (r11.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L17;
            Parcelable r12 = r11.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r12 != null) goto L10;
        L13:
            MediaItem r13 = (MediaItem) r12;
            throw null;
        L10:
            if ((r12 instanceof MediaItem) == true) goto L13;
            throw null;
        L17:
            throw null;
        L15:
            throw null;
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        static class a implements Parcelable.Creator<MediaItem> {
            a() {
            }

            public MediaItem a(Parcel r10) {
                return new MediaItem(r10);
            }

            public MediaItem[] b(int r10) {
                return new MediaItem[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MediaItem createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MediaItem[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        MediaItem(Parcel r10) {
            this.mFlags = r10.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r10);
        }

        public MediaItem(@NonNull MediaDescriptionCompat r10, int r11) {
            if (r10 == null) goto L11;
            if (TextUtils.isEmpty(r10.getMediaId()) == true) goto L9;
            this.mFlags = r11;
            this.mDescription = r10;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            int r11 = android.support.v4.media.a.c.b(r10);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.a.c.a(r10)), r11);
        L10:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r10) {
            if (r10 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L14;
            ArrayList r11 = new ArrayList(r10.size());
            Iterator<?> r12 = r10.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            r11.add(fromMediaItem(r12.next()));
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

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
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
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r10, r11);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final k mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String r10, Bundle r11, k r12, Handler r13) {
            super(r13);
            this.mQuery = r10;
            this.mExtras = r11;
        }

        @Override // android.support.v4.os.ResultReceiver
        protected void onReceiveResult(int r10, Bundle r11) {
            MediaSessionCompat.a(r11);
            if (r10 != 0) goto L13;
            if (r11 != null) goto L6;
            throw null;
        L6:
            if (r11.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L17;
            Parcelable[] r12 = r11.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (r12 == null) goto L12;
            ArrayList r13 = new ArrayList();
            int r14 = r12.length;
            int r15 = 0;
        L10:
            if (r15 >= r14) goto L15;
            r13.add((MediaItem) r12[r15]);
            r15 = r15 + 1;
            goto L10
        L15:
            throw null;
        L12:
            throw null;
        L17:
            throw null;
        L13:
            throw null;
        }
    }

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f144b;

        a(j r10) {
            this.f143a = new WeakReference(r10);
        }

        void a(Messenger r10) {
            this.f144b = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            WeakReference<Messenger> r10 = this.f144b;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.get() != null) goto L7;
            return;
        L7:
            if (this.f143a.get() == null) goto L33;
            Bundle r12 = r11.getData();
            MediaSessionCompat.a(r12);
            j r13 = this.f143a.get();
            Messenger r14 = this.f144b.get();
            int r15 = r11.what;     // Catch: BadParcelableException -> L22
            if (r15 != 1) goto L14;
            Bundle r16 = r12.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r16);     // Catch: BadParcelableException -> L22
            r13.e(r14, r12.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) r12.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), r16);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r15 != 2) goto L16;
            r13.i(r14);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r15 == 3) goto L18;
            Log.w("MediaBrowserCompat", "Unhandled message: " + r11 + "\n  Client version: 1\n  Service version: " + r11.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r17 = r12.getBundle(MediaBrowserProtocol.DATA_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r17);     // Catch: BadParcelableException -> L22
            Bundle r18 = r12.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r18);     // Catch: BadParcelableException -> L22
            r13.f(r14, r12.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), r12.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), r17, r18);     // Catch: BadParcelableException -> L22
        L22:
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (r11.what != 1) goto L32;
            r13.i(r14);
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
        private class C0006b implements android.support.v4.media.a.InterfaceC0007a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f145a;

            C0006b(b r10) {
                this.f145a = r10;
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void a() {
                a r10 = this.f145a.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.a();
            L5:
                this.f145a.onConnected();
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void b() {
                a r10 = this.f145a.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.b();
            L5:
                this.f145a.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void c() {
                a r10 = this.f145a.mConnectionCallbackInternal;
                if (r10 == null) goto L5;
                r10.c();
            L5:
                this.f145a.onConnectionFailed();
            }
        }

        public b() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            Object r10 = android.support.v4.media.a.c(new C0006b(this));
        L6:
            this.mConnectionCallbackObj = r10;
            return;
        L5:
            r10 = null;
            goto L6
        }

        public void onConnected() {
            throw null;
        }

        public void onConnectionFailed() {
            throw null;
        }

        public void onConnectionSuspended() {
            throw null;
        }

        void setInternalConnectionCallback(a r10) {
            this.mConnectionCallbackInternal = r10;
        }
    }

    public static abstract class c {
    }

    public static abstract class d {
    }

    interface e {
        @NonNull
        MediaSessionCompat.Token d();

        void g();

        void h();
    }

    @RequiresApi(21)
    static class f implements e, j, b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Bundle f148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final a f149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ArrayMap<String, m> f150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected l f151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected Messenger f152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private MediaSessionCompat.Token f153h;

        f(Context r10, ComponentName r11, b r12, Bundle r13) {
            this.f149d = new a(this);
            this.f150e = new ArrayMap();
            this.f146a = r10;
            if (r13 == null) goto L5;
            Bundle r14 = new Bundle(r13);
        L6:
            this.f148c = r14;
            r14.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            r12.setInternalConnectionCallback(this);
            this.f147b = android.support.v4.media.a.b(r10, r11, r12.mConnectionCallbackObj, r14);
            return;
        L5:
            r14 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void a() {
            Bundle r10 = android.support.v4.media.a.f(this.f147b);
            if (r10 != null) goto L5;
            return;
        L5:
            r10.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder r11 = BundleCompat.getBinder(r10, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (r11 == null) goto L11;
            this.f151f = new l(r11, this.f148c);
            Messenger r12 = new Messenger(this.f149d);
            this.f152g = r12;
            this.f149d.a(r12);
            this.f151f.d(this.f146a, this.f152g);     // Catch: RemoteException -> L10
        L10:
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
        L11:
            android.support.v4.media.session.b r13 = android.support.v4.media.session.b.a.U0(BundleCompat.getBinder(r10, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (r13 == null) goto L17;
            this.f153h = MediaSessionCompat.Token.fromToken(android.support.v4.media.a.g(this.f147b), r13);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            this.f151f = null;
            this.f152g = null;
            this.f153h = null;
            this.f149d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @NonNull
        public MediaSessionCompat.Token d() {
            if (this.f153h != null) goto L6;
            this.f153h = MediaSessionCompat.Token.fromToken(android.support.v4.media.a.g(this.f147b));
        L6:
            return this.f153h;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void f(Messenger r10, String r11, List r12, Bundle r13, Bundle r14) {
            if (this.f152g == r10) goto L5;
            return;
        L5:
            m r15 = this.f150e.get(r11);
            if (r15 == null) goto L8;
            n r16 = r15.a(r13);
            if (r16 == null) goto L22;
            if (r13 != null) goto L17;
            if (r12 != null) goto L16;
            r16.c(r11);
            return;
        L16:
            r16.a(r11, r12);
            return;
        L17:
            if (r12 != null) goto L19;
            r16.d(r11, r13);
            return;
        L19:
            r16.b(r11, r12, r13);
            return;
        L22:
            return;
        L8:
            if (MediaBrowserCompat.f141b == false) goto L21;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r11);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void g() {
            l r10 = this.f151f;
            if (r10 == null) goto L9;
            Messenger r11 = this.f152g;
            if (r11 == null) goto L9;
            r10.f(r11);     // Catch: RemoteException -> L8
        L8:
            Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        L9:
            android.support.v4.media.a.e(this.f147b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            android.support.v4.media.a.a(this.f147b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger r10) {
        }
    }

    @RequiresApi(23)
    static class g extends f {
        g(Context r10, ComponentName r11, b r12, Bundle r13) {
            super(r10, r11, r12, r13);
        }
    }

    @RequiresApi(26)
    static class h extends g {
        h(Context r10, ComponentName r11, b r12, Bundle r13) {
            super(r10, r11, r12, r13);
        }
    }

    static class i implements e, j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ComponentName f155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final b f156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Bundle f157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final a f158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ArrayMap<String, m> f159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        c f161h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        l f162i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Messenger f163j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f164k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private MediaSessionCompat.Token f165l;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i f166c;

            a(i r10) {
                this.f166c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                i r10 = this.f166c;
                if (r10.f160g != 0) goto L5;
                return;
            L5:
                r10.f160g = 2;
                if (MediaBrowserCompat.f141b == false) goto L13;
                if (r10.f161h == null) goto L13;
                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.f166c.f161h);
            L13:
                if (r10.f162i != null) goto L29;
                if (r10.f163j != null) goto L27;
                Intent r11 = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                r11.setComponent(this.f166c.f155b);
                i r12 = this.f166c;
                r12.f161h = new c(r12);
                boolean r13 = false;
                i r14 = this.f166c;     // Catch: Exception -> L19
                r13 = r14.f154a.bindService(r11, r14.f161h, 1);     // Catch: Exception -> L19
            L20:
                if (r13 == true) goto L23;
                this.f166c.b();
                this.f166c.f156c.onConnectionFailed();
            L23:
                if (MediaBrowserCompat.f141b == false) goto L32;
                Log.d("MediaBrowserCompat", "connect...");
                this.f166c.a();
                return;
            L32:
                return;
            L19:
                Log.e("MediaBrowserCompat", "Failed binding to service " + this.f166c.f155b);
                goto L20
            L27:
                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.f166c.f163j);
            L29:
                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.f166c.f162i);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i f167c;

            b(i r10) {
                this.f167c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                i r10 = this.f167c;
                Messenger r11 = r10.f163j;
                if (r11 != null) goto L14;
            L7:
                i r12 = this.f167c;
                int r13 = r12.f160g;
                r12.b();
                if (r13 == 0) goto L11;
                this.f167c.f160g = r13;
            L11:
                if (MediaBrowserCompat.f141b == false) goto L16;
                Log.d("MediaBrowserCompat", "disconnect...");
                this.f167c.a();
                return;
            L16:
                return;
            L14:
                r10.f162i.c(r11);     // Catch: RemoteException -> L6
            L6:
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.f167c.f155b);
                goto L7
            }
        }

        private class c implements ServiceConnection {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i f168c;

            class a implements Runnable {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ComponentName f169c;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ IBinder f170g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ c f171h;

                a(c r10, ComponentName r11, IBinder r12) {
                    this.f171h = r10;
                    this.f169c = r11;
                    this.f170g = r12;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean r10 = MediaBrowserCompat.f141b;
                    if (r10 == false) goto L6;
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.f169c + " binder=" + this.f170g);
                    this.f171h.f168c.a();
                L6:
                    if (this.f171h.a("onServiceConnected") == true) goto L8;
                    return;
                L8:
                    i r11 = this.f171h.f168c;
                    r11.f162i = new l(this.f170g, r11.f157d);
                    this.f171h.f168c.f163j = new Messenger(this.f171h.f168c.f158e);
                    i r12 = this.f171h.f168c;
                    r12.f158e.a(r12.f163j);
                    this.f171h.f168c.f160g = 2;
                    if (r10 == true) goto L17;
                L11:
                    i r13 = this.f171h.f168c;     // Catch: RemoteException -> L13
                    r13.f162i.b(r13.f154a, r13.f163j);     // Catch: RemoteException -> L13
                    return;
                L13:
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.f171h.f168c.f155b);
                    if (MediaBrowserCompat.f141b == false) goto L19;
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    this.f171h.f168c.a();
                    return;
                L19:
                    return;
                L17:
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");     // Catch: RemoteException -> L13
                    this.f171h.f168c.a();     // Catch: RemoteException -> L13
                    goto L11
                }
            }

            class b implements Runnable {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ ComponentName f172c;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ c f173g;

                b(c r10, ComponentName r11) {
                    this.f173g = r10;
                    this.f172c = r11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserCompat.f141b == false) goto L6;
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.f172c + " this=" + this + " mServiceConnection=" + this.f173g.f168c.f161h);
                    this.f173g.f168c.a();
                L6:
                    if (this.f173g.a("onServiceDisconnected") == true) goto L8;
                    return;
                L8:
                    i r10 = this.f173g.f168c;
                    r10.f162i = null;
                    r10.f163j = null;
                    r10.f158e.a(null);
                    i r11 = this.f173g.f168c;
                    r11.f160g = 4;
                    r11.f156c.onConnectionSuspended();
                }
            }

            c(i r10) {
                this.f168c = r10;
            }

            private void b(Runnable r10) {
                if (Thread.currentThread() != this.f168c.f158e.getLooper().getThread()) goto L5;
                r10.run();
                return;
            L5:
                this.f168c.f158e.post(r10);
            }

            boolean a(String r10) {
                i r11 = this.f168c;
                if (r11.f161h != this) goto L9;
                int r12 = r11.f160g;
                if (r12 == 0) goto L9;
                if (r12 == 1) goto L9;
                return true;
            L9:
                int r13 = r11.f160g;
                if (r13 == 0) goto L15;
                if (r13 == 1) goto L16;
                Log.i("MediaBrowserCompat", r10 + " for " + this.f168c.f155b + " with mServiceConnection=" + this.f168c.f161h + " this=" + this);
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r10, IBinder r11) {
                b(new a(this, r10, r11));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r10) {
                b(new b(this, r10));
            }
        }

        public i(Context r10, ComponentName r11, b r12, Bundle r13) {
            this.f158e = new a(this);
            this.f159f = new ArrayMap();
            this.f160g = 1;
            if (r10 == null) goto L17;
            if (r11 == null) goto L15;
            if (r12 == null) goto L13;
            this.f154a = r10;
            this.f155b = r11;
            this.f156c = r12;
            if (r13 != null) goto L9;
            Bundle r14 = null;
        L10:
            this.f157d = r14;
            return;
        L9:
            r14 = new Bundle(r13);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        private static String c(int r10) {
            if (r10 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r10 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r10 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r10 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r10 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r10;
        }

        private boolean k(Messenger r10, String r11) {
            if (this.f163j != r10) goto L9;
            int r12 = this.f160g;
            if (r12 == 0) goto L9;
            if (r12 == 1) goto L9;
            return true;
        L9:
            int r13 = this.f160g;
            if (r13 == 0) goto L15;
            if (r13 == 1) goto L16;
            Log.i("MediaBrowserCompat", r11 + " for " + this.f155b + " with mCallbacksMessenger=" + this.f163j + " this=" + this);
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        void a() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f155b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f156c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f157d);
            Log.d("MediaBrowserCompat", "  mState=" + c(this.f160g));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f161h);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f162i);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f163j);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f164k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f165l);
        }

        void b() {
            c r10 = this.f161h;
            if (r10 == null) goto L5;
            this.f154a.unbindService(r10);
        L5:
            this.f160g = 1;
            this.f161h = null;
            this.f162i = null;
            this.f163j = null;
            this.f158e.a(null);
            this.f164k = null;
            this.f165l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @NonNull
        public MediaSessionCompat.Token d() {
            if (j() == false) goto L7;
            return this.f165l;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f160g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13) {
            if (k(r10, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.f160g == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + c(this.f160g) + "... ignoring");
            return;
        L9:
            this.f164k = r11;
            this.f165l = r12;
            this.f160g = 3;
            if (MediaBrowserCompat.f141b == false) goto L12;
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            a();
        L12:
            this.f156c.onConnected();
            Iterator<Map.Entry<String, m>> r14 = this.f159f.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r14.hasNext() == false) goto L27;
            Map.Entry<String, m> r15 = r14.next();     // Catch: RemoteException -> L21
            String r16 = r15.getKey();     // Catch: RemoteException -> L21
            m r17 = r15.getValue();     // Catch: RemoteException -> L21
            List<n> r18 = r17.b();     // Catch: RemoteException -> L21
            List<Bundle> r19 = r17.c();     // Catch: RemoteException -> L21
            int r20 = 0;
        L18:
            if (r20 >= r18.size()) goto L15;
            this.f162i.a(r16, r18.get(r20).f179b, r19.get(r20), this.f163j);     // Catch: RemoteException -> L21
            r20 = r20 + 1;
            goto L18
        L27:
            return;
        L21:
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void f(Messenger r10, String r11, List r12, Bundle r13, Bundle r14) {
            if (k(r10, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r15 = MediaBrowserCompat.f141b;
            if (r15 == false) goto L8;
            Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f155b + " id=" + r11);
        L8:
            m r16 = this.f159f.get(r11);
            if (r16 != null) goto L13;
            if (r15 == false) goto L23;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r11);
            return;
        L23:
            return;
        L13:
            n r17 = r16.a(r13);
            if (r17 == null) goto L24;
            if (r13 != null) goto L19;
            if (r12 != null) goto L18;
            r17.c(r11);
            return;
        L18:
            r17.a(r11, r12);
            return;
        L19:
            if (r12 != null) goto L21;
            r17.d(r11, r13);
            return;
        L21:
            r17.b(r11, r12, r13);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void g() {
            this.f160g = 0;
            this.f158e.post(new b(this));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            int r10 = this.f160g;
            if (r10 != 0) goto L5;
        L9:
            this.f160g = 2;
            this.f158e.post(new a(this));
            return;
        L5:
            if (r10 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + c(this.f160g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger r10) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f155b);
            if (k(r10, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.f160g == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + c(this.f160g) + "... ignoring");
            return;
        L9:
            b();
            this.f156c.onConnectionFailed();
        }

        public boolean j() {
            if (this.f160g != 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    interface j {
        void e(Messenger r10, String r11, MediaSessionCompat.Token r12, Bundle r13);

        void f(Messenger r10, String r11, List r12, Bundle r13, Bundle r14);

        void i(Messenger r10);
    }

    public static abstract class k {
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f175b;

        public l(IBinder r10, Bundle r11) {
            this.f174a = new Messenger(r10);
            this.f175b = r11;
        }

        private void e(int r10, Bundle r11, Messenger r12) {
            Message r13 = Message.obtain();
            r13.what = r10;
            r13.arg1 = 1;
            r13.setData(r11);
            r13.replyTo = r12;
            this.f174a.send(r13);
        }

        void a(String r10, IBinder r11, Bundle r12, Messenger r13) {
            Bundle r14 = new Bundle();
            r14.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r10);
            BundleCompat.putBinder(r14, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r11);
            r14.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r12);
            e(3, r14, r13);
        }

        void b(Context r10, Messenger r11) {
            Bundle r12 = new Bundle();
            r12.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r10.getPackageName());
            r12.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f175b);
            e(1, r12, r11);
        }

        void c(Messenger r10) {
            e(2, null, r10);
        }

        void d(Context r10, Messenger r11) {
            Bundle r12 = new Bundle();
            r12.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r10.getPackageName());
            r12.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f175b);
            e(6, r12, r11);
        }

        void f(Messenger r10) {
            e(7, null, r10);
        }
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<n> f176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f177b;

        public m() {
            this.f176a = new ArrayList();
            this.f177b = new ArrayList();
        }

        public n a(Bundle r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.f177b.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions(this.f177b.get(r11), r10) == true) goto L8;
            r11 = r11 + 1;
            goto L4
        L8:
            return this.f176a.get(r11);
        L10:
            return null;
        }

        public List<n> b() {
            return this.f176a;
        }

        public List<Bundle> c() {
            return this.f177b;
        }
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WeakReference<m> f180c;

        private class a implements android.support.v4.media.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f181a;

            a(n r10) {
                this.f181a = r10;
            }

            @Override // android.support.v4.media.a.d
            public void a(@NonNull String r10) {
                this.f181a.c(r10);
            }

            @Override // android.support.v4.media.a.d
            public void d(@NonNull String r10, List<?> r11) {
                WeakReference<m> r12 = this.f181a.f180c;
                if (r12 != null) goto L5;
                m r13 = null;
            L6:
                if (r13 != null) goto L8;
                this.f181a.a(r10, MediaItem.fromMediaItemList(r11));
                return;
            L8:
                List<MediaItem> r14 = MediaItem.fromMediaItemList(r11);
                List<n> r15 = r13.b();
                List<Bundle> r16 = r13.c();
                int r17 = 0;
            L10:
                if (r17 >= r15.size()) goto L20;
                Bundle r18 = r16.get(r17);
                if (r18 != null) goto L14;
                this.f181a.a(r10, r14);
            L15:
                r17 = r17 + 1;
                goto L10
            L14:
                this.f181a.b(r10, e(r14, r18), r18);
                goto L15
            L20:
                return;
            L5:
                r13 = r12.get();
                goto L6
            }

            List<MediaItem> e(List<MediaItem> r10, Bundle r11) {
                if (r10 != null) goto L5;
                return null;
            L5:
                int r12 = r11.getInt("android.media.browse.extra.PAGE", -1);
                int r13 = r11.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (r12 != (-1)) goto L9;
                if (r13 != (-1)) goto L9;
                return r10;
            L9:
                int r14 = r13 * r12;
                int r15 = r14 + r13;
                if (r12 < 0) goto L22;
                if (r13 < 1) goto L22;
                if (r14 >= r10.size()) goto L22;
                if (r15 <= r10.size()) goto L20;
                r15 = r10.size();
            L20:
                return r10.subList(r14, r15);
            L22:
                return Collections.emptyList();
            }
        }

        private class b extends a implements android.support.v4.media.b.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n f182b;

            b(n r10) {
                this.f182b = r10;
                super(r10);
            }

            @Override // android.support.v4.media.b.a
            public void b(@NonNull String r10, @NonNull Bundle r11) {
                this.f182b.d(r10, r11);
            }

            @Override // android.support.v4.media.b.a
            public void c(@NonNull String r10, List<?> r11, @NonNull Bundle r12) {
                this.f182b.b(r10, MediaItem.fromMediaItemList(r11), r12);
            }
        }

        public n() {
            this.f179b = new Binder();
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 26) goto L7;
            Object r11 = android.support.v4.media.b.a(new b(this));
        L5:
            this.f178a = r11;
            return;
        L7:
            if (r10 < 21) goto L10;
            r11 = android.support.v4.media.a.d(new a(this));
            goto L5
        }

        public void a(@NonNull String r10, @NonNull List<MediaItem> r11) {
        }

        public void b(@NonNull String r10, @NonNull List<MediaItem> r11, @NonNull Bundle r12) {
        }

        public void c(@NonNull String r10) {
        }

        public void d(@NonNull String r10, @NonNull Bundle r11) {
        }
    }

    static {
        f141b = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context r10, ComponentName r11, b r12, Bundle r13) {
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 26) goto L7;
        e r15 = new h(r10, r11, r12, r13);
    L5:
        this.f142a = r15;
        return;
    L7:
        if (r14 < 23) goto L10;
        r15 = new g(r10, r11, r12, r13);
        goto L5
    L10:
        if (r14 < 21) goto L12;
        r15 = new f(r10, r11, r12, r13);
        goto L5
    L12:
        r15 = new i(r10, r11, r12, r13);
        goto L5
    }

    public void a() {
        this.f142a.h();
    }

    public void b() {
        this.f142a.g();
    }

    @NonNull
    public MediaSessionCompat.Token c() {
        return this.f142a.d();
    }
}
