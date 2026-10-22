package androidx.media;

import ai.j0;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.a;
import android.support.v4.media.session.c;
import android.support.v4.media.session.f;
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
    MediaSessionCompat$Token mSession;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String r5, @Nullable Bundle r10) {
            if (r5 == null) goto L7;
            this.mRootId = r5;
            this.mExtras = r10;
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

    public class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;
        final /* synthetic */ MediaBrowserServiceCompat this$0;
        public final int uid;

        public ConnectionRecord(MediaBrowserServiceCompat r5, String r10, int r11, int r12, Bundle r13, ServiceCallbacks r14) {
            this.this$0 = r5;
            this.subscriptions = new HashMap();
            this.pkg = r10;
            this.pid = r11;
            this.uid = r12;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(r10, r11, r12);
            this.rootHints = r13;
            this.callbacks = r14;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mHandler.post(new AnonymousClass1(this));
        }
    }

    public interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r5, String r10, Bundle r11);

        void notifyChildrenChanged(String r5, Bundle r10);

        IBinder onBind(Intent r5);

        void onCreate();

        void setSessionToken(MediaSessionCompat$Token r5);
    }

    @RequiresApi(21)
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList;
        Object mServiceObj;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplApi21(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
            this.mRootExtrasList = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger != null) goto L5;
            return null;
        L5:
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L13;
            if (r5.rootHints != null) goto L11;
            return null;
        L11:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L13:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L7;
            return r5.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String r5, Bundle r10) {
            notifyChildrenChangedForFramework(r5, r10);
            notifyChildrenChangedForCompat(r5, r10);
        }

        public void notifyChildrenChangedForCompat(final String r5, final Bundle r10) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r5, r10));
        }

        public void notifyChildrenChangedForCompatOnHandler(ConnectionRecord r5, String r10, Bundle r11) {
            List<Pair<IBinder, Bundle>> r12 = r5.subscriptions.get(r10);
            if (r12 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r14 = r13.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r11, r14.second) == false) goto L6;
            this.this$0.performLoadChildren(r10, r5, r14.second, r11);
            goto L6
        L16:
            return;
        }

        public void notifyChildrenChangedForFramework(String r5, Bundle r10) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r5) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r5 = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
            this.mServiceObj = r5;
            MediaBrowserServiceCompatApi21.onCreate(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String r12, int r13, Bundle r14) {
            if (r14 != null) goto L5;
        L14:
            Bundle r5 = null;
        L15:
            MediaBrowserServiceCompat r10 = this.this$0;
            r10.mCurConnection = new ConnectionRecord(r10, r12, -1, r13, r14, null);
            BrowserRoot r15 = this.this$0.onGetRoot(r12, r13, r14);
            this.this$0.mCurConnection = null;
            if (r15 != null) goto L18;
            return null;
        L18:
            if (r5 != null) goto L21;
            r5 = r15.getExtras();
        L24:
            return new MediaBrowserServiceCompatApi21.BrowserRoot(r15.getRootId(), r5);
        L21:
            if (r15.getExtras() == null) goto L24;
            r5.putAll(r15.getExtras());
            goto L24
        L5:
            if (r14.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) goto L14;
            r14.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            this.mMessenger = new Messenger(this.this$0.mHandler);
            r5 = new Bundle();
            r5.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(r5, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            MediaSessionCompat$Token r11 = this.this$0.mSession;
            if (r11 == null) goto L13;
            c r16 = r11.f380b;
            if (r16 != null) goto L11;
            IBinder r17 = null;
        L12:
            BundleCompat.putBinder(r5, MediaBrowserProtocol.EXTRA_SESSION_BINDER, r17);
            goto L15
        L11:
            r17 = ((a) r16).asBinder();
            goto L12
        L13:
            this.mRootExtrasList.add(r5);
            goto L15
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(final String r5, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> r10) {
            Result<List<MediaBrowserCompat$MediaItem>> r11 = new AnonymousClass2(this, r5, r10);
            this.this$0.onLoadChildren(r5, r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat$Token r5) {
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r5));
        }

        public void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo r5, final String r10, final Bundle r11) {
            this.this$0.mHandler.post(new AnonymousClass4(this, r5, r10, r11));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r5, String r10, Bundle r11) {
            notifyChildrenChangedForCompat(r5, r10, r11);
        }
    }

    @RequiresApi(23)
    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplApi23(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r5 = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
            this.mServiceObj = r5;
            MediaBrowserServiceCompatApi21.onCreate(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(final String r5, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r10) {
            Result<MediaBrowserCompat$MediaItem> r11 = new AnonymousClass1(this, r5, r10);
            this.this$0.onLoadItem(r5, r11);
        }
    }

    @RequiresApi(26)
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplApi26(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L10;
            if (r5.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        public void notifyChildrenChangedForFramework(String r5, Bundle r10) {
            if (r10 == null) goto L4;
            MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, r5, r10);
            return;
        L4:
            super.notifyChildrenChangedForFramework(r5, r10);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r5 = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
            this.mServiceObj = r5;
            MediaBrowserServiceCompatApi21.onCreate(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(final String r5, final MediaBrowserServiceCompatApi26.ResultWrapper r10, Bundle r11) {
            Result<List<MediaBrowserCompat$MediaItem>> r12 = new AnonymousClass1(this, r5, r10);
            this.this$0.onLoadChildren(r5, r12, r11);
        }
    }

    @RequiresApi(28)
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplApi28(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
            super(r5);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L7;
            return r5.browserInfo;
        L7:
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplBase(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L10;
            if (r5.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord r5 = this.this$0.mCurConnection;
            if (r5 == null) goto L7;
            return r5.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull final String r5, final Bundle r10) {
            this.this$0.mHandler.post(new AnonymousClass2(this, r5, r10));
        }

        public void notifyChildrenChangedOnHandler(ConnectionRecord r5, String r10, Bundle r11) {
            List<Pair<IBinder, Bundle>> r12 = r5.subscriptions.get(r10);
            if (r12 == null) goto L10;
            Iterator<Pair<IBinder, Bundle>> r13 = r12.iterator();
        L6:
            if (r13.hasNext() == false) goto L16;
            Pair<IBinder, Bundle> r14 = r13.next();
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r11, r14.second) == false) goto L6;
            this.this$0.performLoadChildren(r10, r5, r14.second, r11);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r5) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(r5.getAction()) == true) goto L5;
            return null;
        L5:
            return this.mMessenger.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(this.this$0.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat$Token r5) {
            this.this$0.mHandler.post(new AnonymousClass1(this, r5));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull final MediaSessionManager.RemoteUserInfo r5, @NonNull final String r10, final Bundle r11) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r5, r10, r11));
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        public Result(Object r5) {
            this.mDebug = r5;
        }

        private void checkExtraFields(Bundle r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS") == false) goto L13;
            float r10 = r5.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
            if (r10 < (-1.0E-5f)) goto L12;
            if (r10 > 1.00001f) goto L12;
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

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isDone() {
            if (this.mDetachCalled == false) goto L5;
        L10:
            return true;
        L5:
            if (this.mSendResultCalled == true) goto L10;
            if (this.mSendErrorCalled == true) goto L10;
            return false;
        }

        public void onErrorSent(Bundle r5) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        public void onProgressUpdateSent(Bundle r5) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        public void onResultSent(T r5) {
        }

        public void sendError(Bundle r5) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendErrorCalled = true;
            onErrorSent(r5);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendProgressUpdate(Bundle r5) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            checkExtraFields(r5);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(r5);
            return;
        L9:
            throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendResult(T r5) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendResultCalled = true;
            onResultSent(r5);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void setFlags(int r5) {
            this.mFlags = r5;
        }
    }

    public class ServiceBinderImpl {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceBinderImpl(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
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

        public void disconnect(final ServiceCallbacks r5) {
            this.this$0.mHandler.postOrRun(new AnonymousClass2(this, r5));
        }

        public void getMediaItem(final String r5, final ResultReceiver r10, final ServiceCallbacks r11) {
            if (TextUtils.isEmpty(r5) == true) goto L8;
            if (r10 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass5(this, r11, r5, r10));
            return;
        L9:
            return;
        }

        public void registerCallbacks(final ServiceCallbacks r10, final String r11, final int r12, final int r13, final Bundle r14) {
            this.this$0.mHandler.postOrRun(new AnonymousClass6(this, r10, r11, r12, r13, r14));
        }

        public void removeSubscription(final String r5, final IBinder r10, final ServiceCallbacks r11) {
            this.this$0.mHandler.postOrRun(new AnonymousClass4(this, r11, r5, r10));
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

        public void unregisterCallbacks(final ServiceCallbacks r5) {
            this.this$0.mHandler.postOrRun(new AnonymousClass7(this, r5));
        }
    }

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String r5, MediaSessionCompat$Token r10, Bundle r11) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String r5, List<MediaBrowserCompat$MediaItem> r10, Bundle r11, Bundle r12) throws RemoteException;
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        public ServiceCallbacksCompat(Messenger r5) {
            this.mCallbacks = r5;
        }

        private void sendRequest(int r5, Bundle r10) throws RemoteException {
            Message r11 = Message.obtain();
            r11.what = r5;
            r11.arg1 = 2;
            r11.setData(r10);
            this.mCallbacks.send(r11);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String r5, MediaSessionCompat$Token r10, Bundle r11) throws RemoteException {
            if (r11 != null) goto L4;
            r11 = new Bundle();
        L4:
            r11.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle r12 = new Bundle();
            r12.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r5);
            r12.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, r10);
            r12.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, r11);
            sendRequest(1, r12);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String r5, List<MediaBrowserCompat$MediaItem> r10, Bundle r11, Bundle r12) throws RemoteException {
            Bundle r13 = new Bundle();
            r13.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r5);
            r13.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r11);
            r13.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, r12);
            if (r10 != null) goto L5;
        L9:
            sendRequest(3, r13);
            return;
        L5:
            if ((r10 instanceof ArrayList) == false) goto L7;
            ArrayList<? extends Parcelable> r14 = (ArrayList) r10;
        L8:
            r13.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, r14);
            goto L9
        L7:
            r14 = new ArrayList(r10);
            goto L8
        }
    }

    public final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceHandler(MediaBrowserServiceCompat r5) {
            this.this$0 = r5;
            this.mServiceBinderImpl = new ServiceBinderImpl(r5);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Bundle r5 = r10.getData();
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
            Bundle r11 = r5.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
            f.a(r11);
            this.mServiceBinderImpl.sendCustomAction(r5.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), r11, (ResultReceiver) r5.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L6:
            Bundle r12 = r5.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
            f.a(r12);
            this.mServiceBinderImpl.search(r5.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), r12, (ResultReceiver) r5.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L7:
            this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(r10.replyTo));
            return;
        L8:
            Bundle r13 = r5.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            f.a(r13);
            this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(r10.replyTo), r5.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r5.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r5.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r13);
            return;
        L9:
            this.mServiceBinderImpl.getMediaItem(r5.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) r5.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L10:
            this.mServiceBinderImpl.removeSubscription(r5.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r5, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(r10.replyTo));
            return;
        L11:
            Bundle r14 = r5.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
            f.a(r14);
            this.mServiceBinderImpl.addSubscription(r5.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r5, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), r14, new ServiceCallbacksCompat(r10.replyTo));
            return;
        L12:
            this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(r10.replyTo));
            return;
        L13:
            Bundle r15 = r5.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            f.a(r15);
            this.mServiceBinderImpl.connect(r5.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r5.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r5.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r15, new ServiceCallbacksCompat(r10.replyTo));
        }

        public void postOrRun(Runnable r5) {
            if (Thread.currentThread() != getLooper().getThread()) goto L5;
            r5.run();
            return;
        L5:
            post(r5);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r5, long r10) {
            Bundle r11 = r5.getData();
            r11.setClassLoader(android.support.v4.media.f.class.getClassLoader());
            r11.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            r11.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(r5, r10);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    public void addSubscription(String r5, ConnectionRecord r10, IBinder r11, Bundle r12) {
        List<Pair<IBinder, Bundle>> r13 = r10.subscriptions.get(r5);
        if (r13 != null) goto L5;
        r13 = new ArrayList();
    L5:
        Iterator<Pair<IBinder, Bundle>> r14 = r13.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        Pair<IBinder, Bundle> r15 = r14.next();
        if (r11 != r15.first) goto L7;
        if (MediaBrowserCompatUtils.areSameOptions(r12, r15.second) == false) goto L7;
        return;
    L13:
        r13.add(new Pair(r11, r12));
        r10.subscriptions.put(r5, r13);
        performLoadChildren(r5, r10, r12, null);
        this.mCurConnection = r10;
        onSubscribe(r5, r12);
        this.mCurConnection = null;
    }

    public List<MediaBrowserCompat$MediaItem> applyOptions(List<MediaBrowserCompat$MediaItem> r5, Bundle r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r11 = r10.getInt("android.media.browse.extra.PAGE", -1);
        int r12 = r10.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (r11 != (-1)) goto L9;
        if (r12 != (-1)) goto L9;
        return r5;
    L9:
        int r13 = r12 * r11;
        int r14 = r13 + r12;
        if (r11 < 0) goto L22;
        if (r12 < 1) goto L22;
        if (r13 >= r5.size()) goto L22;
        if (r14 <= r5.size()) goto L20;
        r14 = r5.size();
    L20:
        return r5.subList(r13, r14);
    L22:
        return Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context r5) {
        attachBaseContext(r5);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r5, PrintWriter r10, String[] r11) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    @Nullable
    public MediaSessionCompat$Token getSessionToken() {
        return this.mSession;
    }

    public boolean isValidPackage(String r5, int r10) {
        if (r5 != null) goto L5;
        return false;
    L5:
        String[] r11 = getPackageManager().getPackagesForUid(r10);
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        if (r11[r13].equals(r5) == true) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void notifyChildrenChanged(@NonNull String r5) {
        if (r5 == null) goto L6;
        this.mImpl.notifyChildrenChanged(r5, null);
        return;
    L6:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r5) {
        return this.mImpl.onBind(r5);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MediaBrowserServiceImplApi28 r5 = new MediaBrowserServiceImplApi28(this);
        this.mImpl = r5;
        r5.onCreate();
    }

    public void onCustomAction(@NonNull String r5, Bundle r10, @NonNull Result<Bundle> r11) {
        r11.sendError(null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String r5, int r10, @Nullable Bundle r11);

    public abstract void onLoadChildren(@NonNull String r5, @NonNull Result<List<MediaBrowserCompat$MediaItem>> r10);

    public void onLoadChildren(@NonNull String r5, @NonNull Result<List<MediaBrowserCompat$MediaItem>> r10, @NonNull Bundle r11) {
        r10.setFlags(1);
        onLoadChildren(r5, r10);
    }

    public void onLoadItem(String r5, @NonNull Result<MediaBrowserCompat$MediaItem> r10) {
        r10.setFlags(2);
        r10.sendResult(null);
    }

    public void onSearch(@NonNull String r5, Bundle r10, @NonNull Result<List<MediaBrowserCompat$MediaItem>> r11) {
        r11.setFlags(4);
        r11.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String r5, Bundle r10) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String r5) {
    }

    public void performCustomAction(final String r5, Bundle r10, ConnectionRecord r11, final ResultReceiver r12) {
        Result<Bundle> r13 = new AnonymousClass4(this, r5, r12);
        this.mCurConnection = r11;
        onCustomAction(r5, r10, r13);
        this.mCurConnection = null;
        if (r13.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r5 + " extras=" + r10);
    }

    public void performLoadChildren(final String r10, final ConnectionRecord r11, final Bundle r12, final Bundle r13) {
        Result<List<MediaBrowserCompat$MediaItem>> r14 = new AnonymousClass1(this, r10, r11, r10, r12, r13);
        this.mCurConnection = r11;
        if (r12 != null) goto L5;
        onLoadChildren(r10, r14);
    L6:
        this.mCurConnection = null;
        if (r14.isDone() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException(androidx.constraintlayout.motion.widget.a.t(new StringBuilder("onLoadChildren must call detach() or sendResult() before returning for package="), r11.pkg, " id=", r10));
    L5:
        onLoadChildren(r10, r14, r12);
        goto L6
    }

    public void performLoadItem(final String r5, ConnectionRecord r10, final ResultReceiver r11) {
        Result<MediaBrowserCompat$MediaItem> r12 = new AnonymousClass2(this, r5, r11);
        this.mCurConnection = r10;
        onLoadItem(r5, r12);
        this.mCurConnection = null;
        if (r12.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(j0.C("onLoadItem must call detach() or sendResult() before returning for id=", r5));
    }

    public void performSearch(final String r5, Bundle r10, ConnectionRecord r11, final ResultReceiver r12) {
        Result<List<MediaBrowserCompat$MediaItem>> r13 = new AnonymousClass3(this, r5, r12);
        this.mCurConnection = r11;
        onSearch(r5, r10, r13);
        this.mCurConnection = null;
        if (r13.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(j0.C("onSearch must call detach() or sendResult() before returning for query=", r5));
    }

    public boolean removeSubscription(String r10, ConnectionRecord r11, IBinder r12) {
        boolean r5 = false;
        if (r12 == null) goto L5;
        List<Pair<IBinder, Bundle>> r13 = r11.subscriptions.get(r10);     // Catch: Throwable -> L9
        if (r13 != null) goto L13;
    L7:
        this.mCurConnection = r11;
        onUnsubscribe(r10);
        this.mCurConnection = null;
        return r5;
    L13:
        Iterator<Pair<IBinder, Bundle>> r14 = r13.iterator();     // Catch: Throwable -> L9
    L15:
        if (r14.hasNext() == false) goto L20;
        if (r12 != r14.next().first) goto L15;
        r14.remove();     // Catch: Throwable -> L9
        r5 = true;
        goto L15
    L20:
        if (r13.size() != 0) goto L7;
        r11.subscriptions.remove(r10);     // Catch: Throwable -> L9
        goto L7
    L5:
        if (r11.subscriptions.remove(r10) == null) goto L7;
        r5 = true;
    L9:
        th = move-exception;
        this.mCurConnection = r11;
        onUnsubscribe(r10);
        this.mCurConnection = null;
        throw th;
    }

    public void setSessionToken(MediaSessionCompat$Token r5) {
        if (r5 == null) goto L10;
        if (this.mSession != null) goto L8;
        this.mSession = r5;
        this.mImpl.setSessionToken(r5);
        return;
    L8:
        throw new IllegalStateException("The session token has already been set.");
    L10:
        throw new IllegalArgumentException("Session token may not be null.");
    }

    public void notifyChildrenChanged(@NonNull String r5, @NonNull Bundle r10) {
        if (r5 == null) goto L9;
        if (r10 == null) goto L7;
        this.mImpl.notifyChildrenChanged(r5, r10);
        return;
    L7:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L9:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo r5, @NonNull String r10, @NonNull Bundle r11) {
        if (r5 == null) goto L12;
        if (r10 == null) goto L10;
        if (r11 == null) goto L8;
        this.mImpl.notifyChildrenChanged(r5, r10, r11);
        return;
    L8:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L10:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    L12:
        throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    }
}
