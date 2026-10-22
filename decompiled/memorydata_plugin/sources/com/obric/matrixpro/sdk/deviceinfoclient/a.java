package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002 !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter;", "", "()V", "AUTHORITY", "", "COLUMN_ERROR", "COLUMN_OSDID", "MSG_GET_OSDID", "", "PATH_OSDID", "PATH_OSDID_OBSERVE", "applicationContext", "Landroid/content/Context;", "handlerThread", "Landroid/os/HandlerThread;", "mainHandler", "Landroid/os/Handler;", "osDidCache", "osDidObservers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrixpro/sdk/deviceinfoclient/ContentObserverWrapper;", "workerHandler", "addOsDidObserver", "", "context", "callback", "Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidCallback;", "destroy", "getOsDid", "handleOsDidQuery", "initThreadIfNeeded", "removeOsDidObserver", "OsDidCallback", "OsDidRequest", "deviceinfoclient_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HandlerThread f8261b;
    private static Handler c;
    private static Handler d;
    private static String e;
    private static CopyOnWriteArrayList<Object> f;
    private static Context g;

    /* JADX INFO: renamed from: com.obric.matrixpro.sdk.deviceinfoclient.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidCallback;", "", "onError", "", DTraitConstant.ERROR, "", "onSuccess", "osDid", "deviceinfoclient_release"}, k = 1, mv = {1, 4, 3})
    public interface InterfaceC0407a {
        void onError(String r1);

        void onSuccess(String r1);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidRequest;", "", "context", "Landroid/content/Context;", "callback", "Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidCallback;", "(Landroid/content/Context;Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidCallback;)V", "getCallback", "()Lcom/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$OsDidCallback;", "getContext", "()Landroid/content/Context;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "deviceinfoclient_release"}, k = 1, mv = {1, 4, 3})
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f8262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0407a f8263b;

        public b(Context r3, InterfaceC0407a r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            InterfaceC0407a r6 = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0407a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "callback");
            this.f8262a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.f8263b = r6;
        }

        public final InterfaceC0407a a() {
            return this.f8263b;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L11;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8262a, r4.f8262a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f8263b, r4.f8263b) == true) goto L17;
            return false;
        L17:
            return true;
        L11:
            return false;
        }

        public final Context getContext() {
            return this.f8262a;
        }

        public int hashCode() {
            Context r0 = this.f8262a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            InterfaceC0407a r4 = this.f8263b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "OsDidRequest(context=" + this.f8262a + ", callback=" + this.f8263b + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$handleOsDidQuery$2$1"}, k = 3, mv = {1, 4, 3})
    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0407a f8264a;

        c(InterfaceC0407a r3) {
            this.f8264a = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0407a.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8264a.onError("查询失败：Cursor为空");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$handleOsDidQuery$1$1"}, k = 3, mv = {1, 4, 3})
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0407a f8265a;

        d(InterfaceC0407a r3) {
            this.f8265a = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0407a.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f8265a.onError("Cursor无有效数据");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$handleOsDidQuery$1$2"}, k = 3, mv = {1, 4, 3})
    static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8267b;
        final /* synthetic */ InterfaceC0407a c;

        e(String r3, String r4, InterfaceC0407a r5) {
            InterfaceC0407a r6 = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0407a.class, "com.obric.memorydata.plugin");
            this.f8266a = r3;
            this.f8267b = r4;
            this.c = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.f8266a;
            if (r0 == null) goto L6;
            InterfaceC0407a r3 = this.c;
        L5:
            r3.onError(r0);
            return;
        L6:
            String r1 = this.f8267b;
            if (r1 != null) goto L9;
        L14:
            r3 = this.c;
            r0 = "OSDID为空或列索引异常";
            goto L5
        L9:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
            boolean r2 = true;
        L12:
            if (r2 == false) goto L14;
            a.a(a.f8260a, this.f8267b);
            this.c.onSuccess(this.f8267b);
            return;
        L11:
            r2 = false;
            goto L12
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0407a f8268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f8269b;

        f(InterfaceC0407a r3, Exception r4) {
            this.f8268a = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0407a.class, "com.obric.memorydata.plugin");
            this.f8269b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC0407a r0 = this.f8268a;
            StringBuilder r1 = new StringBuilder().append("获取失败：");
            String r3 = this.f8269b.getMessage();
            if (r3 != null) goto L5;
            r3 = "未知异常";
        L5:
            r0.onError(r1.append(r3).toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrixpro/sdk/deviceinfoclient/DeviceInfoGetter$initThreadIfNeeded$2", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "deviceinfoclient_release"}, k = 1, mv = {1, 4, 3})
    public static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8270a;

        g(a r1, Looper r2) {
            this.f8270a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
            if (r4.what != 1) goto L6;
            Object r3 = r4.obj;
            Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.matrixpro.sdk.deviceinfoclient.DeviceInfoGetter.OsDidRequest");
            b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            a.a(a.f8260a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5.a());
            return;
        }
    }

    static {
        f8260a = new a();
        f = new CopyOnWriteArrayList();
    }

    private a() {
    }

    public static final /* synthetic */ HandlerThread a(a r1) {
        HandlerThread r2 = f8261b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L5:
        return r2;
    }

    private final void a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (g != null) goto L6;
        g = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        if (f8261b != null) goto L15;
        HandlerThread r6 = new HandlerThread("DeviceInfoGetter-Worker");
        f8261b = r6;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L10:
        r6.start();
        HandlerThread r2 = f8261b;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L13:
        c = (Handler) ZeusTransformUtils.preCheckCast(new g(this, r2.getLooper()), Handler.class, "com.obric.memorydata.plugin");
        d = new Handler(Looper.getMainLooper());
        return;
    }

    public static final /* synthetic */ void a(a r2, Context r3, InterfaceC0407a r4) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0407a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r0, HandlerThread r1) {
        f8261b = r1;
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        e = r1;
    }

    private final void b(Context r11, InterfaceC0407a r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        InterfaceC0407a r14 = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r12, InterfaceC0407a.class, "com.obric.memorydata.plugin");
        Cursor r15 = ZeusProviderTransform.query(r13.getContentResolver(), Uri.parse("content://com.bytedance.securityserver.deviceInfoProvider/get_osdid"), null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        if (r15 == null) goto L32;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        Cursor r16 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r16.moveToFirst() == true) goto L14;
        Handler r17 = d;     // Catch: Throwable -> L27
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L27
    L11:
        r17.post((Runnable) ZeusTransformUtils.preCheckCast(new d(r14), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r10, null);     // Catch: Exception -> L37
        return;
    L14:
        int r1 = r16.getColumnIndex("osdid");     // Catch: Throwable -> L27
        int r4 = r16.getColumnIndex("error");     // Catch: Throwable -> L27
        if (r4 < 0) goto L17;
        String r5 = r16.getString(r4);     // Catch: Throwable -> L27
    L18:
        if (r1 < 0) goto L20;
        String r18 = r16.getString(r1);     // Catch: Throwable -> L27
    L21:
        Handler r2 = d;     // Catch: Throwable -> L27
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Throwable -> L27
    L24:
        r2.post((Runnable) ZeusTransformUtils.preCheckCast(new e(r5, r18, r14), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r10, null);     // Catch: Exception -> L37
        return;
    L20:
        r18 = null;
        goto L21
    L17:
        r5 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Exception -> L37
        throw th;     // Catch: Exception -> L37
    L32:
        a r19 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        Handler r110 = d;     // Catch: Exception -> L37
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");     // Catch: Exception -> L37
    L35:
        r110.post((Runnable) ZeusTransformUtils.preCheckCast(new c(r14), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        com.obric.matrixpro.sdk.deviceinfoclient.b.f8271a.a("OsDidClient", "查询OSDID异常", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Handler r111 = d;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mainHandler");
    L41:
        r111.post((Runnable) ZeusTransformUtils.preCheckCast(new f(r14, e), Runnable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Context r3, InterfaceC0407a r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        InterfaceC0407a r6 = (InterfaceC0407a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0407a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        a(r5);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context.applicationContext");
        b r2 = new b(r7, r6);
        Handler r8 = c;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L5:
        Message r9 = Message.obtain(r8, 1, r2);
        Handler r10 = c;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L8:
        r10.sendMessage(r9);
    }
}
