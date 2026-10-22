package androidx.media;

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
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends PluginService {
    static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
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

        public BrowserRoot(String r1, Bundle r2) {
            if (r1 == null) goto L7;
            this.mRootId = r1;
            this.mExtras = r2;
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

        ConnectionRecord(MediaBrowserServiceCompat r3, String r4, int r5, int r6, Bundle r7, ServiceCallbacks r8) {
            MediaBrowserServiceCompat r9 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            ServiceCallbacks r10 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r8, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0 = r9;
            this.subscriptions = new HashMap();
            this.pkg = r4;
            this.pid = r5;
            this.uid = r6;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(r4, r5, r6);
            this.rootHints = r7;
            this.callbacks = r10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mHandler.post(new AnonymousClass1(this));
        }
    }

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r1, String r2, Bundle r3);

        void notifyChildrenChanged(String r1, Bundle r2);

        IBinder onBind(Intent r1);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token r1);
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList;
        Object mServiceObj;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi21(MediaBrowserServiceCompat r3) {
            this.this$0 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            this.mRootExtrasList = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger != null) goto L6;
            return null;
        L6:
            if (this.this$0.mCurConnection == null) goto L13;
            if (this.this$0.mCurConnection.rootHints != null) goto L11;
            return null;
        L11:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L13:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (this.this$0.mCurConnection == null) goto L7;
            return this.this$0.mCurConnection.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r1, String r2, Bundle r3) {
            notifyChildrenChangedForCompat(r1, r2, r3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String r1, Bundle r2) {
            notifyChildrenChangedForFramework(r1, r2);
            notifyChildrenChangedForCompat(r1, r2);
        }

        void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo r3, final String r4, final Bundle r5) {
            this.this$0.mHandler.post(new AnonymousClass4(this, r3, r4, r5));
        }

        void notifyChildrenChangedForCompat(final String r3, final Bundle r4) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r3, r4));
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord r6, String r7, Bundle r8) {
            List r0 = (List) ZeusTransformUtils.preCheckCast(r6.subscriptions.get(r7), List.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L10;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L16;
            Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin");
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r8, (Bundle) ZeusTransformUtils.preCheckCast(r2.second, Bundle.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.this$0.performLoadChildren(r7, r6, (Bundle) ZeusTransformUtils.preCheckCast(r2.second, Bundle.class, "com.obric.memorydata.plugin"), r8);
            goto L6
        L16:
            return;
        }

        void notifyChildrenChangedForFramework(String r1, Bundle r2) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, r1);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r1) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, r1);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object r0 = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
            this.mServiceObj = r0;
            MediaBrowserServiceCompatApi21.onCreate(r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String r12, int r13, Bundle r14) {
            if (r14 != null) goto L5;
        L14:
            Bundle r1 = null;
        L15:
            this.this$0.mCurConnection = new ConnectionRecord(this.this$0, r12, -1, r13, r14, null);
            BrowserRoot r15 = this.this$0.onGetRoot(r12, r13, r14);
            this.this$0.mCurConnection = null;
            if (r15 != null) goto L18;
            return null;
        L18:
            if (r1 != null) goto L21;
            r1 = r15.getExtras();
        L24:
            return new MediaBrowserServiceCompatApi21.BrowserRoot(r15.getRootId(), r1);
        L21:
            if (r15.getExtras() == null) goto L24;
            r1.putAll(r15.getExtras());
            goto L24
        L5:
            if (r14.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) goto L14;
            r14.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
            this.mMessenger = new Messenger(this.this$0.mHandler);
            r1 = new Bundle();
            r1.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            BundleCompat.putBinder(r1, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
            if (this.this$0.mSession == null) goto L13;
            b r2 = this.this$0.mSession.getExtraBinder();
            if (r2 != null) goto L11;
            IBinder r3 = null;
        L12:
            BundleCompat.putBinder(r1, MediaBrowserProtocol.EXTRA_SESSION_BINDER, r3);
            goto L15
        L11:
            r3 = r2.asBinder();
            goto L12
        L13:
            this.mRootExtrasList.add(r1);
            goto L15
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(final String r2, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> r3) {
            Result<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass2(this, r2, r3);
            this.this$0.onLoadChildren(r2, r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r3) {
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r3));
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi23(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(final String r2, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r3) {
            Result<MediaBrowserCompat.MediaItem> r0 = new AnonymousClass1(this, r2, r3);
            this.this$0.onLoadItem(r2, r0);
        }
    }

    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi26(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.this$0.mCurConnection == null) goto L10;
            if (this.this$0.mCurConnection.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void notifyChildrenChangedForFramework(String r1, Bundle r2) {
            if (r2 == null) goto L4;
            MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, r1, r2);
            return;
        L4:
            super.notifyChildrenChangedForFramework(r1, r2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(final String r2, final MediaBrowserServiceCompatApi26.ResultWrapper r3, Bundle r4) {
            Result<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass1(this, r2, r3);
            this.this$0.onLoadChildren(r2, r0, r4);
        }
    }

    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplApi28(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            super(r4);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (this.this$0.mCurConnection == null) goto L7;
            return this.this$0.mCurConnection.browserInfo;
        L7:
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) ZeusTransformUtils.preCheckCast(this.mServiceObj, MediaBrowserService.class, "com.obric.memorydata.plugin")).getCurrentBrowserInfo());
        }
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        MediaBrowserServiceImplBase(MediaBrowserServiceCompat r3) {
            this.this$0 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.this$0.mCurConnection == null) goto L10;
            if (this.this$0.mCurConnection.rootHints != null) goto L8;
            return null;
        L8:
            return new Bundle(this.this$0.mCurConnection.rootHints);
        L10:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (this.this$0.mCurConnection == null) goto L7;
            return this.this$0.mCurConnection.browserInfo;
        L7:
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final MediaSessionManager.RemoteUserInfo r3, final String r4, final Bundle r5) {
            this.this$0.mHandler.post(new AnonymousClass3(this, r3, r4, r5));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(final String r3, final Bundle r4) {
            this.this$0.mHandler.post(new AnonymousClass2(this, r3, r4));
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord r6, String r7, Bundle r8) {
            List r0 = (List) ZeusTransformUtils.preCheckCast(r6.subscriptions.get(r7), List.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L10;
            Iterator r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L16;
            Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin");
            if (MediaBrowserCompatUtils.hasDuplicatedItems(r8, (Bundle) ZeusTransformUtils.preCheckCast(r2.second, Bundle.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.this$0.performLoadChildren(r7, r6, (Bundle) ZeusTransformUtils.preCheckCast(r2.second, Bundle.class, "com.obric.memorydata.plugin"), r8);
            goto L6
        L16:
            return;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent r2) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(r2.getAction()) == true) goto L5;
            return null;
        L5:
            return this.mMessenger.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(this.this$0.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(final MediaSessionCompat.Token r3) {
            this.this$0.mHandler.post(new AnonymousClass1(this, r3));
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        Result(Object r1) {
            this.mDebug = r1;
        }

        private void checkExtraFields(Bundle r2) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS") == false) goto L13;
            float r1 = r2.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
            if (r1 < (-1.0E-5f)) goto L12;
            if (r1 > 1.00001f) goto L12;
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

        void onErrorSent(Bundle r3) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        void onProgressUpdateSent(Bundle r3) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onResultSent(T r1) {
        }

        public void sendError(Bundle r3) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendErrorCalled = true;
            onErrorSent(r3);
            return;
        L9:
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendProgressUpdate(Bundle r3) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            checkExtraFields(r3);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(r3);
            return;
        L9:
            throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        public void sendResult(T r3) {
            if (this.mSendResultCalled == true) goto L9;
            if (this.mSendErrorCalled == true) goto L9;
            this.mSendResultCalled = true;
            onResultSent(r3);
            return;
        L9:
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
        }

        void setFlags(int r1) {
            this.mFlags = r1;
        }
    }

    private class ServiceBinderImpl {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        ServiceBinderImpl(MediaBrowserServiceCompat r3) {
            this.this$0 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
        }

        public void addSubscription(final String r9, IBinder r10, final Bundle r11, ServiceCallbacks r12) {
            final IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r10, IBinder.class, "com.obric.memorydata.plugin");
            final ServiceCallbacks r4 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r12, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0.mHandler.postOrRun(new AnonymousClass3(this, r4, r9, r6, r11));
        }

        public void connect(final String r9, final int r10, final int r11, final Bundle r12, ServiceCallbacks r13) {
            final ServiceCallbacks r2 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r13, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            if (this.this$0.isValidPackage(r9, r11) == false) goto L7;
            this.this$0.mHandler.postOrRun(new AnonymousClass1(this, r2, r9, r10, r11, r12));
            return;
        L7:
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + r11 + " package=" + r9);
        }

        public void disconnect(ServiceCallbacks r3) {
            final ServiceCallbacks r4 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0.mHandler.postOrRun(new AnonymousClass2(this, r4));
        }

        public void getMediaItem(final String r3, final ResultReceiver r4, ServiceCallbacks r5) {
            final ServiceCallbacks r6 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r5, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(r3) == true) goto L8;
            if (r4 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass5(this, r6, r3, r4));
            return;
        L9:
            return;
        }

        public void registerCallbacks(ServiceCallbacks r9, final String r10, final int r11, final int r12, final Bundle r13) {
            final ServiceCallbacks r2 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r9, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0.mHandler.postOrRun(new AnonymousClass6(this, r2, r10, r11, r12, r13));
        }

        public void removeSubscription(final String r3, IBinder r4, ServiceCallbacks r5) {
            final IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            final ServiceCallbacks r7 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r5, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0.mHandler.postOrRun(new AnonymousClass4(this, r7, r3, r6));
        }

        public void search(final String r8, final Bundle r9, final ResultReceiver r10, ServiceCallbacks r11) {
            final ServiceCallbacks r2 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r11, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(r8) == true) goto L8;
            if (r10 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass8(this, r2, r8, r9, r10));
            return;
        L9:
            return;
        }

        public void sendCustomAction(final String r8, final Bundle r9, final ResultReceiver r10, ServiceCallbacks r11) {
            final ServiceCallbacks r2 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r11, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            if (TextUtils.isEmpty(r8) == true) goto L8;
            if (r10 == null) goto L9;
            this.this$0.mHandler.postOrRun(new AnonymousClass9(this, r2, r8, r9, r10));
            return;
        L9:
            return;
        }

        public void unregisterCallbacks(ServiceCallbacks r3) {
            final ServiceCallbacks r4 = (ServiceCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCallbacks.class, "com.obric.memorydata.plugin");
            this.this$0.mHandler.postOrRun(new AnonymousClass7(this, r4));
        }
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String r1, MediaSessionCompat.Token r2, Bundle r3);

        void onConnectFailed();

        void onLoadChildren(String r1, List<MediaBrowserCompat.MediaItem> r2, Bundle r3, Bundle r4);
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger r1) {
            this.mCallbacks = r1;
        }

        private void sendRequest(int r2, Bundle r3) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 2;
            r0.setData(r3);
            this.mCallbacks.send(r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String r3, MediaSessionCompat.Token r4, Bundle r5) {
            if (r5 != null) goto L4;
            r5 = new Bundle();
        L4:
            r5.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            r0.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, r4);
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, r5);
            sendRequest(1, r0);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String r4, List<MediaBrowserCompat.MediaItem> r5, Bundle r6, Bundle r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r4);
            r0.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r6);
            r0.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, r7);
            if (r8 != null) goto L5;
        L9:
            sendRequest(3, r0);
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r8, ArrayList.class) == false) goto L7;
            ArrayList<? extends Parcelable> r9 = (ArrayList) ZeusTransformUtils.preCheckCast(r8, ArrayList.class, "com.obric.memorydata.plugin");
        L8:
            r0.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, r9);
            goto L9
        L7:
            r9 = new ArrayList(r8);
            goto L8
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        ServiceHandler(MediaBrowserServiceCompat r3) {
            MediaBrowserServiceCompat r4 = (MediaBrowserServiceCompat) ZeusTransformUtils.wrapperContextForParams(r3, MediaBrowserServiceCompat.class, "com.obric.memorydata.plugin");
            this.this$0 = r4;
            this.mServiceBinderImpl = new ServiceBinderImpl(r4);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            Bundle r0 = r11.getData();
            switch(r11.what) {
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
            Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + r11 + "\n  Service version: 2\n  Client version: " + r11.arg1);
            return;
        L5:
            Bundle r1 = r0.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
            MediaSessionCompat.a(r1);
            this.mServiceBinderImpl.sendCustomAction(r0.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), r1, (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), ResultReceiver.class, "com.obric.memorydata.plugin"), new ServiceCallbacksCompat(r11.replyTo));
            return;
        L6:
            Bundle r2 = r0.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
            MediaSessionCompat.a(r2);
            this.mServiceBinderImpl.search(r0.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), r2, (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), ResultReceiver.class, "com.obric.memorydata.plugin"), new ServiceCallbacksCompat(r11.replyTo));
            return;
        L7:
            this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(r11.replyTo));
            return;
        L8:
            Bundle r6 = r0.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.a(r6);
            this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(r11.replyTo), r0.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r0.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r0.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r6);
            return;
        L9:
            this.mServiceBinderImpl.getMediaItem(r0.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) ZeusTransformUtils.preCheckCast(r0.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), ResultReceiver.class, "com.obric.memorydata.plugin"), new ServiceCallbacksCompat(r11.replyTo));
            return;
        L10:
            this.mServiceBinderImpl.removeSubscription(r0.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(r11.replyTo));
            return;
        L11:
            Bundle r3 = r0.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
            MediaSessionCompat.a(r3);
            this.mServiceBinderImpl.addSubscription(r0.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), r3, new ServiceCallbacksCompat(r11.replyTo));
            return;
        L12:
            this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(r11.replyTo));
            return;
        L13:
            Bundle r7 = r0.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
            MediaSessionCompat.a(r7);
            this.mServiceBinderImpl.connect(r0.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), r0.getInt(MediaBrowserProtocol.DATA_CALLING_PID), r0.getInt(MediaBrowserProtocol.DATA_CALLING_UID), r7, new ServiceCallbacksCompat(r11.replyTo));
        }

        public void postOrRun(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            if (Thread.currentThread() != getLooper().getThread()) goto L5;
            r4.run();
            return;
        L5:
            post(r4);
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r4, long r5) {
            Bundle r0 = r4.getData();
            r0.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            r0.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            r0.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(r4, r5);
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserServiceCompat() {
        this.mConnections = new ArrayMap();
        this.mHandler = new ServiceHandler(this);
    }

    void addSubscription(String r6, ConnectionRecord r7, IBinder r8, Bundle r9) {
        IBinder r10 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r8, IBinder.class, "com.obric.memorydata.plugin");
        List<Pair<IBinder, Bundle>> r0 = (List) ZeusTransformUtils.preCheckCast(r7.subscriptions.get(r6), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        Iterator<Pair<IBinder, Bundle>> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        if (r10 != r3.first) goto L7;
        if (MediaBrowserCompatUtils.areSameOptions(r9, (Bundle) ZeusTransformUtils.preCheckCast(r3.second, Bundle.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return;
    L13:
        r0.add(new Pair(r10, r9));
        r7.subscriptions.put(r6, r0);
        performLoadChildren(r6, r7, r9, null);
        this.mCurConnection = r7;
        onSubscribe(r6, r9);
        this.mCurConnection = null;
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> r3, Bundle r4) {
        List<MediaBrowserCompat.MediaItem> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
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

    public void attachToBaseContext(Context r3) {
        attachBaseContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public void dump(FileDescriptor r1, PrintWriter r2, String[] r3) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    boolean isValidPackage(String r4, int r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String[] r3 = getPackageManager().getPackagesForUid(r5);
        int r6 = r3.length;
        int r1 = 0;
    L6:
        if (r1 >= r6) goto L12;
        if (r3[r1].equals(r4) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo r1, String r2, Bundle r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L10;
        if (r3 == null) goto L8;
        this.mImpl.notifyChildrenChanged(r1, r2, r3);
        return;
    L8:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L10:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    L12:
        throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String r2) {
        if (r2 == null) goto L6;
        this.mImpl.notifyChildrenChanged(r2, null);
        return;
    L6:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public void notifyChildrenChanged(String r1, Bundle r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        this.mImpl.notifyChildrenChanged(r1, r2);
        return;
    L7:
        throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    L9:
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public IBinder onBind(Intent r1) {
        return this.mImpl.onBind(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        if (Build.VERSION.SDK_INT < 28) goto L7;
        MediaBrowserServiceImpl r0 = new MediaBrowserServiceImplApi28(this);
    L5:
        this.mImpl = r0;
        this.mImpl.onCreate();
        return;
    L7:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r0 = new MediaBrowserServiceImplApi26(this);
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r0 = new MediaBrowserServiceImplApi23(this);
        goto L5
    L13:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        r0 = new MediaBrowserServiceImplApi21(this);
        goto L5
    L15:
        r0 = new MediaBrowserServiceImplBase(this);
        goto L5
    }

    public void onCustomAction(String r1, Bundle r2, Result<Bundle> r3) {
        r3.sendError(null);
    }

    public abstract BrowserRoot onGetRoot(String r1, int r2, Bundle r3);

    public abstract void onLoadChildren(String r1, Result<List<MediaBrowserCompat.MediaItem>> r2);

    public void onLoadChildren(String r1, Result<List<MediaBrowserCompat.MediaItem>> r2, Bundle r3) {
        r2.setFlags(1);
        onLoadChildren(r1, r2);
    }

    public void onLoadItem(String r1, Result<MediaBrowserCompat.MediaItem> r2) {
        r2.setFlags(2);
        r2.sendResult(null);
    }

    public void onSearch(String r1, Bundle r2, Result<List<MediaBrowserCompat.MediaItem>> r3) {
        r3.setFlags(4);
        r3.sendResult(null);
    }

    public void onSubscribe(String r1, Bundle r2) {
    }

    public void onUnsubscribe(String r1) {
    }

    void performCustomAction(final String r2, Bundle r3, ConnectionRecord r4, final ResultReceiver r5) {
        Result<Bundle> r0 = new AnonymousClass4(this, r2, r5);
        this.mCurConnection = r4;
        onCustomAction(r2, r3, r0);
        this.mCurConnection = null;
        if (r0.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + r2 + " extras=" + r3);
    }

    void performLoadChildren(final String r9, final ConnectionRecord r10, final Bundle r11, final Bundle r12) {
        Result<List<MediaBrowserCompat.MediaItem>> r7 = new AnonymousClass1(this, r9, r10, r9, r11, r12);
        this.mCurConnection = r10;
        if (r11 != null) goto L5;
        onLoadChildren(r9, r7);
    L6:
        this.mCurConnection = null;
        if (r7.isDone() == false) goto L10;
        return;
    L10:
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + r10.pkg + " id=" + r9);
    L5:
        onLoadChildren(r9, r7, r11);
        goto L6
    }

    void performLoadItem(final String r2, ConnectionRecord r3, final ResultReceiver r4) {
        Result<MediaBrowserCompat.MediaItem> r0 = new AnonymousClass2(this, r2, r4);
        this.mCurConnection = r3;
        onLoadItem(r2, r0);
        this.mCurConnection = null;
        if (r0.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + r2);
    }

    void performSearch(final String r2, Bundle r3, ConnectionRecord r4, final ResultReceiver r5) {
        Result<List<MediaBrowserCompat.MediaItem>> r0 = new AnonymousClass3(this, r2, r5);
        this.mCurConnection = r4;
        onSearch(r2, r3, r0);
        this.mCurConnection = null;
        if (r0.isDone() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + r2);
    }

    boolean removeSubscription(String r9, ConnectionRecord r10, IBinder r11) {
        IBinder r12 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r11, IBinder.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        boolean r2 = false;
        if (r12 == null) goto L5;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r10.subscriptions.get(r9), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r4 == null) goto L21;
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L23
    L14:
        if (r5.hasNext() == false) goto L19;
        if (r12 != ((Pair) ZeusTransformUtils.preCheckCast(r5.next(), Pair.class, "com.obric.memorydata.plugin")).first) goto L14;
        r5.remove();     // Catch: Throwable -> L23
        r2 = true;
        goto L14
    L19:
        if (r4.size() != 0) goto L21;
        r10.subscriptions.remove(r9);     // Catch: Throwable -> L23
    L21:
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        return r2;
    L5:
        if (r10.subscriptions.remove(r9) != null) goto L8;
        r0 = false;
    L8:
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        return r0;
    L23:
        th = move-exception;
        this.mCurConnection = r10;
        onUnsubscribe(r9);
        this.mCurConnection = null;
        throw th;
    }

    public void setSessionToken(MediaSessionCompat.Token r2) {
        if (r2 == null) goto L10;
        if (this.mSession != null) goto L8;
        this.mSession = r2;
        this.mImpl.setSessionToken(r2);
        return;
    L8:
        throw new IllegalStateException("The session token has already been set.");
    L10:
        throw new IllegalArgumentException("Session token may not be null.");
    }
}
