package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-5f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    static final String TAG = "MBServiceCompat";
    final ArrayMap<IBinder, ConnectionRecord> mConnections;
    ConnectionRecord mCurConnection;
    final ServiceHandler mHandler;
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String r10, @Nullable Bundle r11) {
            if (r10 == null) goto L7;
            this.mRootId = r10;
            this.mExtras = r11;
            return;
        L7:
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;
        final /* synthetic */ MediaBrowserServiceCompat this$0;
        public final int uid;

        ConnectionRecord(MediaBrowserServiceCompat r10, String r11, int r12, int r13, Bundle r14, ServiceCallbacks r15) {
            this.this$0 = r10;
            this.subscriptions = new HashMap();
            this.pkg = r11;
            this.pid = r12;
            this.uid = r13;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(r11, r12, r13);
            this.rootHints = r14;
            this.callbacks = r15;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mHandler.post(new AnonymousClass1(this));
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r10, String r11, Bundle r12);

        void notifyChildrenChanged(String r10, Bundle r11);

        IBinder onBind(Intent r10);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token r10);
    }

    @RequiresApi(21)
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList;
        Object mServiceObj;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi21(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
            this.mRootExtrasList = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger != null) goto L5;
            return null;
        L5:
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L13;
            if (r10.rootHints != null) goto L11;
            return null;
        L11:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L13:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L7;
            return r10.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r10, String r11, Bundle r12) {
            notifyChildrenChangedForCompat(r10, r11, r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String r10, Bundle r11) {
            notifyChildrenChangedForFramework(r10, r11);
            notifyChildrenChangedForCompat(r10, r11);
        }

        void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo r10, final String r11, final Bundle r12) {
            this.this$0.mHandler.post(new AnonymousClass4(this, r10, r11, r12));
        }

        void notifyChildrenChangedForCompat(final String r10, final Bundle r11) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r10, r11));
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord r10, String r11, Bundle r12) {
            List<Pair<IBinder, Bundle>> r13 = r10.subscriptions.get(r11);
            if (r13 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r14 = r13.iterator();
        L6:
            if (r14.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r15 = r14.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r12, r15.second) == false) goto L6;
            this.this$0.performLoadChildren(r11, r10, r15.second, r12);
            goto L6
        L16:
            return;
        }

        void notifyChildrenChangedForFramework(String r10, Bundle r11) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r10) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r10 = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
            this.mServiceObj = r10;
            MediaBrowserServiceCompatApi21.onCreate(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String r12, int r13, Bundle r14) {
            if (r14 != null) goto L5;
        L14:
            Bundle r10 = null;
        L15:
            MediaBrowserServiceCompat r11 = this.this$0;
            r11.mCurConnection = new ConnectionRecord(r11, r12, -1, r13, r14, null);
            BrowserRoot r15 = this.this$0.onGetRoot(r12, r13, r14);
            this.this$0.mCurConnection = null;
            if (r15 != null) goto L18;
            return null;
        L18:
            if (r10 != null) goto L21;
            r10 = r15.getExtras();
        L24:
            return new MediaBrowserServiceCompatApi21.BrowserRoot(r15.getRootId(), r10);
        L21:
            if (r15.getExtras() == null) goto L24;
            r10.putAll(r15.getExtras());
            goto L24
        L5:
            if (r14.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) goto L14;
            r14.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            this.mMessenger = new Messenger(this.this$0.mHandler);
            r10 = new Bundle();
            r10.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(r10, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            MediaSessionCompat.Token r16 = this.this$0.mSession;
            if (r16 == null) goto L13;
            b r17 = r16.getExtraBinder();
            if (r17 != null) goto L11;
            IBinder r18 = null;
        L12:
            BundleCompat.putBinder(r10, MediaBrowserProtocol.EXTRA_SESSION_BINDER, r18);
            goto L15
        L11:
            r18 = r17.asBinder();
            goto L12
        L13:
            this.mRootExtrasList.add(r10);
            goto L15
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(final String r10, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> r11) {
            Result<List<MediaBrowserCompat.MediaItem>> r12 = new AnonymousClass2(this, r10, r11);
            this.this$0.onLoadChildren(r10, r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r10) {
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r10));
        }
    }

    @RequiresApi(23)
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi23(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r10 = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
            this.mServiceObj = r10;
            MediaBrowserServiceCompatApi21.onCreate(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(final String r10, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r11) {
            Result<MediaBrowserCompat.MediaItem> r12 = new AnonymousClass1(this, r10, r11);
            this.this$0.onLoadItem(r10, r12);
        }
    }

    @RequiresApi(26)
    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi26(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L10;
            if (r10.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void notifyChildrenChangedForFramework(String r10, Bundle r11) {
            if (r11 == null) goto L4;
            MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, r10, r11);
            return;
        L4:
            super.notifyChildrenChangedForFramework(r10, r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r10 = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
            this.mServiceObj = r10;
            MediaBrowserServiceCompatApi21.onCreate(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(final String r10, final MediaBrowserServiceCompatApi26.ResultWrapper r11, Bundle r12) {
            Result<List<MediaBrowserCompat.MediaItem>> r13 = new AnonymousClass1(this, r10, r11);
            this.this$0.onLoadChildren(r10, r13, r12);
        }
    }

    @RequiresApi(28)
    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi28(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
            super(r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L7;
            return r10.browserInfo;
        L7:
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplBase(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L10;
            if (r10.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r10 = this.this$0.mCurConnection;
            if (r10 == null) goto L7;
            return r10.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull final MediaSessionManager.RemoteUserInfo r10, @NonNull final String r11, final Bundle r12) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r10, r11, r12));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull final String r10, final Bundle r11) {
            this.this$0.mHandler.post(new AnonymousClass2(this, r10, r11));
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord r10, String r11, Bundle r12) {
            List<Pair<IBinder, Bundle>> r13 = r10.subscriptions.get(r11);
            if (r13 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r14 = r13.iterator();
        L6:
            if (r14.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r15 = r14.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r12, r15.second) == false) goto L6;
            this.this$0.performLoadChildren(r11, r10, r15.second, r12);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r10) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(r10.getAction()) == true) goto L5;
            return null;
        L5:
            return this.mMessenger.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(this.this$0.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r10) {
            this.this$0.mHandler.post(new AnonymousClass1(this, r10));
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object r10) {
            this.mDebug = r10;
        }

        private void checkExtraFields(Bundle r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS") == false) goto L13;
            float r11 = r10.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
            if (r11 < (-1.0E-5f)) goto L12;
            if (r11 > 1.00001f) goto L12;
            return;
        L12:
            throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
        }

        public void detach() {
            if (this.mDetachCalled == true) goto L15;
            if (this.mSendResultCalled == true) goto L13;
            if (this.mSendErrorCalled == true) goto L11;
            this.mDetachCalled = true;
            return;
        L11:
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
        L13:
            throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
        L15:
            throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
        }

        int getFlags() {
            return this.mFlags;
        }

        boolean isDone() {
            if (this.mDetachCalled == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mSendResultCalled == true) goto L10;
            if (this.mSendErrorCalled == true) goto L10;
            return false;
        }

        void onErrorSent(Bundle r10) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        void onProgressUpdateSent(Bundle r10) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onResultSent(T r10) {
        }

        public void sendError(Bundle r10) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendErrorCalled = true;
            onErrorSent(r10);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendProgressUpdate(Bundle r10) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            checkExtraFields(r10);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(r10);
            return;
        L9:
            throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendResult(T r10) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendResultCalled = true;
            onResultSent(r10);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        void setFlags(int r10) {
            this.mFlags = r10;
        }
    }

    private class ServiceBinderImpl {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        ServiceBinderImpl(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
        }

        public void addSubscription(final String r10, final IBinder r11, final Bundle r12, final ServiceCallbacks r13) {
            this.this$0.mHandler.postOrRun(new AnonymousClass3(this, r13, r10, r11, r12));
        }

        public void connect(final String r10, final int r11, final int r12, final Bundle r13, final ServiceCallbacks r14) {
            if (this.this$0.isValidPackage(r10, r12) == false) goto L7;
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r14, r10, r11, r12, r13));
            return;
        L7:
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + r12 + " package=" + r10);
        }

        public void disconnect(final ServiceCallbacks r10) {
            this.this$0.mHandler.postOrRun(new AnonymousClass2(this, r10));
        }

        public void getMediaItem(final String r10, final ResultReceiver r11, final ServiceCallbacks r12) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r11 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass5(this, r12, r10, r11));
            return;
        L9:
            return;
        }

        public void registerCallbacks(final ServiceCallbacks r10, final String r11, final int r12, final int r13, final Bundle r14) {
            this.this$0.mHandler.postOrRun(new AnonymousClass6(this, r10, r11, r12, r13, r14));
        }

        public void removeSubscription(final String r10, final IBinder r11, final ServiceCallbacks r12) {
            this.this$0.mHandler.postOrRun(new AnonymousClass4(this, r12, r10, r11));
        }

        public void search(final String r10, final Bundle r11, final ResultReceiver r12, final ServiceCallbacks r13) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r12 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass8(this, r13, r10, r11, r12));
            return;
        L9:
            return;
        }

        public void sendCustomAction(final String r10, final Bundle r11, final ResultReceiver r12, final ServiceCallbacks r13) {
            if (TextUtils.isEmpty(r10) == true) goto L8;
            if (r12 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass9(this, r13, r10, r11, r12));
            return;
        L9:
            return;
        }

        public void unregisterCallbacks(final ServiceCallbacks r10) {
            this.this$0.mHandler.postOrRun(new AnonymousClass7(this, r10));
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String r10, MediaSessionCompat.Token r11, Bundle r12);

        void onConnectFailed();

        void onLoadChildren(String r10, List<MediaBrowserCompat.MediaItem> r11, Bundle r12, Bundle r13);
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger r10) {
            this.mCallbacks = r10;
        }

        private void sendRequest(int r10, Bundle r11) {
            Message r12 = Message.obtain();
            r12.what = r10;
            r12.arg1 = 2;
            r12.setData(r11);
            this.mCallbacks.send(r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String r10, MediaSessionCompat.Token r11, Bundle r12) {
            if (r12 != null) goto L4;
            r12 = new Bundle();
        L4:
            r12.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle r13 = new Bundle();
            r13.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r10);
            r13.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, r11);
            r13.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, r12);
            sendRequest(1, r13);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String r10, List<MediaBrowserCompat.MediaItem> r11, Bundle r12, Bundle r13) {
            Bundle r14 = new Bundle();
            r14.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r10);
            r14.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r12);
            r14.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, r13);
            if (r11 != null) goto L5;
        L9:
            sendRequest(3, r14);
            return;
        L5:
            if ((r11 instanceof ArrayList) == false) goto L7;
            ArrayList<? extends Parcelable> r15 = (ArrayList) r11;
        L8:
            r14.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, r15);
            goto L9
        L7:
            r15 = new ArrayList(r11);
            goto L8
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        ServiceHandler(MediaBrowserServiceCompat r10) {
            this.this$0 = r10;
            this.mServiceBinderImpl = new ServiceBinderImpl(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Bundle r11 = r10.getData();
            switch(r10.what) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                case 9: goto L5;
                default: goto L4;
            };
        L4:
            Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + r10 + "\n  Service version: 2\n  Client version: " + r10.arg1);
            return;
        L5:
            Bundle r12 = r11.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
            MediaSessionCompat.a(r12);
            this.mServiceBinderImpl.sendCustomAction(r11.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), r12, (ResultReceiver) r11.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L6:
            Bundle r13 = r11.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
            MediaSessionCompat.a(r13);
            this.mServiceBinderImpl.search(r11.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), r13, (ResultReceiver) r11.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L7:
            this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(r10.replyTo));
            return;
        L8:
            Bundle r14 = r11.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.a(r14);
            this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(r10.replyTo), r11.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r11.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r11.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r14);
            return;
        L9:
            this.mServiceBinderImpl.getMediaItem(r11.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) r11.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L10:
            this.mServiceBinderImpl.removeSubscription(r11.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r11, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L11:
            Bundle r15 = r11.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
            MediaSessionCompat.a(r15);
            this.mServiceBinderImpl.addSubscription(r11.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r11, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), r15, new ServiceCallbacksCompat(r10.replyTo));
            return;
        L12:
            this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(r10.replyTo));
            return;
        L13:
            Bundle r16 = r11.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.a(r16);
            this.mServiceBinderImpl.connect(r11.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r11.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r11.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r16, new ServiceCallbacksCompat(r10.replyTo));
        }

        public void postOrRun(Runnable r10) {
            if (Thread.currentThread() != getLooper().getThread()) goto L5;
            r10.run();
            return;
        L5:
            post(r10);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r10, long r11) {
            Bundle r12 = r10.getData();
            r12.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            r12.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            r12.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(r10, r11);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    void addSubscription(String r10, ConnectionRecord r11, IBinder r12, Bundle r13) {
        List<Pair<IBinder, Bundle>> r14 = r11.subscriptions.get(r10);
        if (r14 != null) goto L5;
        r14 = new ArrayList();
    L5:
        Iterator<Pair<IBinder, Bundle>> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        Pair<IBinder, Bundle> r16 = r15.next();
        if (r12 != r16.first) goto L7;
        if (MediaBrowserCompatUtils.areSameOptions(r13, r16.second) == false) goto L7;
        return;
    L13:
        r14.add(new Pair(r12, r13));
        r11.subscriptions.put(r10, r14);
        performLoadChildren(r10, r11, r13, null);
        this.mCurConnection = r11;
        onSubscribe(r10, r13);
        this.mCurConnection = null;
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> r10, Bundle r11) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context r10) {
        attachBaseContext(r10);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r10, PrintWriter r11, String[] r12) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String r10, int r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        String[] r12 = getPackageManager().getPackagesForUid(r11);
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        if (r12[r14].equals(r10) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo r10, @NonNull String r11, @NonNull Bundle r12) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L10;
        if (r12 == null) goto L8;
        this.mImpl.notifyChildrenChanged(r10, r11, r12);
        return;
    L8:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L10:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    L12:
        throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(@NonNull String r10) {
        if (r10 == null) goto L6;
        this.mImpl.notifyChildrenChanged(r10, null);
        return;
    L6:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(@NonNull String r10, @NonNull Bundle r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L7;
        this.mImpl.notifyChildrenChanged(r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L9:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return this.mImpl.onBind(r10);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 28) goto L7;
        MediaBrowserServiceImpl r11 = new MediaBrowserServiceImplApi28(this);
    L5:
        this.mImpl = r11;
        this.mImpl.onCreate();
        return;
    L7:
        if (r10 < 26) goto L10;
        r11 = new MediaBrowserServiceImplApi26(this);
        goto L5
    L10:
        if (r10 < 23) goto L13;
        r11 = new MediaBrowserServiceImplApi23(this);
        goto L5
    L13:
        if (r10 < 21) goto L15;
        r11 = new MediaBrowserServiceImplApi21(this);
        goto L5
    L15:
        r11 = new MediaBrowserServiceImplBase(this);
        goto L5
    }

    public void onCustomAction(@NonNull String r10, Bundle r11, @NonNull Result<Bundle> r12) {
        r12.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String r10, int r11, @Nullable Bundle r12);

    public abstract void onLoadChildren(@NonNull String r10, @NonNull Result<List<MediaBrowserCompat.MediaItem>> r11);

    public void onLoadChildren(@NonNull String r10, @NonNull Result<List<MediaBrowserCompat.MediaItem>> r11, @NonNull Bundle r12) {
        r11.setFlags(1);
        onLoadChildren(r10, r11);
    }

    public void onLoadItem(String r10, @NonNull Result<MediaBrowserCompat.MediaItem> r11) {
        r11.setFlags(2);
        r11.sendResult(null);
    }

    public void onSearch(@NonNull String r10, Bundle r11, @NonNull Result<List<MediaBrowserCompat.MediaItem>> r12) {
        r12.setFlags(4);
        r12.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String r10, Bundle r11) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String r10) {
    }

    void performCustomAction(final String r10, Bundle r11, ConnectionRecord r12, final ResultReceiver r13) {
        Result<Bundle> r14 = new AnonymousClass4(this, r10, r13);
        this.mCurConnection = r12;
        onCustomAction(r10, r11, r14);
        this.mCurConnection = null;
        if (r14.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r10 + " extras=" + r11);
    }

    void performLoadChildren(final String r10, final ConnectionRecord r11, final Bundle r12, final Bundle r13) {
        Result<List<MediaBrowserCompat.MediaItem>> r14 = new AnonymousClass1(this, r10, r11, r10, r12, r13);
        this.mCurConnection = r11;
        if (r12 != null) goto L5;
        onLoadChildren(r10, r14);
    L6:
        this.mCurConnection = null;
        if (r14.isDone() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + r11.pkg + " id=" + r10);
    L5:
        onLoadChildren(r10, r14, r12);
        goto L6
    }

    void performLoadItem(final String r10, ConnectionRecord r11, final ResultReceiver r12) {
        Result<MediaBrowserCompat.MediaItem> r13 = new AnonymousClass2(this, r10, r12);
        this.mCurConnection = r11;
        onLoadItem(r10, r13);
        this.mCurConnection = null;
        if (r13.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + r10);
    }

    void performSearch(final String r10, Bundle r11, ConnectionRecord r12, final ResultReceiver r13) {
        Result<List<MediaBrowserCompat.MediaItem>> r14 = new AnonymousClass3(this, r10, r13);
        this.mCurConnection = r12;
        onSearch(r10, r11, r14);
        this.mCurConnection = null;
        if (r14.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + r10);
    }

    boolean removeSubscription(String r10, ConnectionRecord r11, IBinder r12) {
        boolean r13 = true;
        boolean r14 = false;
        if (r12 == null) goto L5;
        List<Pair<IBinder, Bundle>> r15 = r11.subscriptions.get(r10);     // Catch: Throwable -> L23
        if (r15 == null) goto L21;
        Iterator<Pair<IBinder, Bundle>> r16 = r15.iterator();     // Catch: Throwable -> L23
    L14:
        if (r16.hasNext() == false) goto L19;
        if (r12 != r16.next().first) goto L14;
        r16.remove();     // Catch: Throwable -> L23
        r14 = true;
        goto L14
    L19:
        if (r15.size() != 0) goto L21;
        r11.subscriptions.remove(r10);     // Catch: Throwable -> L23
    L21:
        this.mCurConnection = r11;
        onUnsubscribe(r10);
        this.mCurConnection = null;
        return r14;
    L5:
        if (r11.subscriptions.remove(r10) != null) goto L8;
        r13 = false;
    L8:
        this.mCurConnection = r11;
        onUnsubscribe(r10);
        this.mCurConnection = null;
        return r13;
    L23:
        th = move-exception;
        this.mCurConnection = r11;
        onUnsubscribe(r10);
        this.mCurConnection = null;
        throw th;
    }

    public void setSessionToken(MediaSessionCompat.Token r10) {
        if (r10 == null) goto L10;
        if (this.mSession != null) goto L8;
        this.mSession = r10;
        this.mImpl.setSessionToken(r10);
        return;
    L8:
        throw new IllegalStateException("The session token has already been set.");
    L10:
        throw new IllegalArgumentException("Session token may not be null.");
    }
}
