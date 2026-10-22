package com.obric.matrix.platform.sdk.ones.dataanalysis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcel;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import nq.a;
import nq.b;
import nq.c;
import nq.d;
import nq.e;
import nq.f;
import nq.g;
import nq.h;
import nq.i;
import nq.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0003PTW\u0018\u0000 Z2\u00020\u0001:\u0002[NB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020%¢\u0006\u0004\b(\u0010'J\u0015\u0010)\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020%¢\u0006\u0004\b)\u0010'J\u001d\u0010-\u001a\u00020\b2\u0006\u0010*\u001a\u00020%2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J)\u00100\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001f\u001a\u00020%¢\u0006\u0004\b0\u00101J%\u00100\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0014¢\u0006\u0004\b0\u00103J!\u00106\u001a\u00020\b2\u0006\u00104\u001a\u00020\r2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b<\u0010;J\u000f\u0010=\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010\nJ\u001f\u0010>\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b>\u0010\u0017J\u0013\u0010?\u001a\u00020\u0014*\u00020\u0014H\u0002¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010AR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u0002080H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020N0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010JR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010MR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaManager;", "", "Landroid/content/Context;", "context", "Lnq/e;", "config", "<init>", "(Landroid/content/Context;Lnq/e;)V", "", "rebindService", "()V", "bindService", "bindServiceInternal", "", "getDeviceId", "()Ljava/lang/String;", "getInstallId", "getOAID", "getUDID", "eventName", "Lorg/json/JSONObject;", "jsonObject", "onEvent", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "pageName", "", "fps", "frameDrop", "onApmFpsEvent", "(Ljava/lang/String;FLorg/json/JSONObject;)V", "", "duration", "extraInfo", "onApmColdLaunchUserCompleteEvent", "(JLorg/json/JSONObject;)V", "onApmColdLaunchFirstFrameEvent", "(J)V", "", "onApmColdLaunchFirstFrameEventTail", "(I)V", "onApmHotLaunchEvent", "onApmHotLaunchEventTail", "memorySize", "", "isForeGround", "onApmMemoryEvent", "(IZ)V", "prevPageName", "onPageShowEvent", "(Ljava/lang/String;Ljava/lang/String;I)V", "extra", "(Ljava/lang/String;JLorg/json/JSONObject;)V", "componentName", "scene", "onButtonClickEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "Lnq/a;", "listener", "addDeviceInfoListener", "(Lnq/a;)V", "removeDeviceInfoListener", "processPendingEvents", "onEventInternal", "copyJson", "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "Landroid/content/Context;", "Lnq/e;", "Lnq/d;", NotificationCompat.CATEGORY_SERVICE, "Lnq/d;", "isBound", "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Lnq/g;", "pendingEvents", "nq/j", "retryRunnable", "Lnq/j;", "backgroundHandler", "nq/i", "deviceInfoCallback", "Lnq/i;", "nq/h", WsConstants.KEY_CONNECTION, "Lnq/h;", "Companion", "nq/f", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixTeaManager {
    private static final long BIND_RETRY_INTERVAL = 5000;
    public static final f Companion = null;
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME = "apm_event_coldlaunch_first_frame";
    private static final String EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL = "apm_event_coldlaunch_first_frame_tail";
    private static final String EVENT_APM_COLD_USER_COMPLETE = "apm_event_coldlaunch_user_complete";
    private static final String EVENT_APM_FPS = "apm_event_fps";
    private static final String EVENT_APM_HOT_LAUNCH = "apm_event_hotlaunch";
    private static final String EVENT_APM_HOT_LAUNCH_TAIL = "apm_event_hotlaunch_tail";
    private static final String EVENT_APM_MEMORY = "apm_event_memory";
    private static final String EVENT_BUTTON_CLICK = "button_click";
    private static final String EVENT_PAGE_SHOW = "page_show";
    private static final String TAG = "MatrixTeaManager";
    private static String did;
    private static MatrixTeaManager instance;
    private static String mUDid;
    private static String myInstallId;
    private final Handler backgroundHandler;
    private final e config;
    private final h connection;
    private final Context context;
    private final i deviceInfoCallback;
    private final Handler handler;
    private boolean isBound;
    private final CopyOnWriteArrayList<a> listeners;
    private final CopyOnWriteArrayList<g> pendingEvents;
    private final j retryRunnable;
    private d service;

    static {
        Companion = new f();
    }

    public /* synthetic */ MatrixTeaManager(Context r5, e r10, DefaultConstructorMarker r11) {
        this(r5, r10);
    }

    public static /* synthetic */ void a(MatrixTeaManager r5, String r10, JSONObject r11, JSONObject r12) {
        m103onEventInternal$lambda8(r5, r10, r11, r12);
    }

    public static final /* synthetic */ i access$getDeviceInfoCallback$p(MatrixTeaManager r5) {
        return r5.deviceInfoCallback;
    }

    public static final /* synthetic */ Handler access$getHandler$p(MatrixTeaManager r5) {
        return r5.handler;
    }

    public static final /* synthetic */ MatrixTeaManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getListeners$p(MatrixTeaManager r5) {
        return r5.listeners;
    }

    public static final /* synthetic */ d access$getService$p(MatrixTeaManager r5) {
        return r5.service;
    }

    public static final /* synthetic */ boolean access$isBound$p(MatrixTeaManager r5) {
        return r5.isBound;
    }

    public static final /* synthetic */ void access$processPendingEvents(MatrixTeaManager r5) {
        r5.processPendingEvents();
    }

    public static final /* synthetic */ void access$setBound$p(MatrixTeaManager r5, boolean r10) {
        r5.isBound = r10;
    }

    public static final /* synthetic */ void access$setDid$cp(String r5) {
        did = r5;
    }

    public static final /* synthetic */ void access$setInstance$cp(MatrixTeaManager r5) {
        instance = r5;
    }

    public static final /* synthetic */ void access$setMyInstallId$cp(String r5) {
        myInstallId = r5;
    }

    public static final /* synthetic */ void access$setService$p(MatrixTeaManager r5, d r10) {
        r5.service = r10;
    }

    public static /* synthetic */ void b(MatrixTeaManager r5) {
        m104rebindService$lambda1(r5);
    }

    private final JSONObject copyJson(JSONObject r5) {
        LinkedList r10 = new LinkedList();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L23;
        r10.add(r11.next());
        goto L4
    L23:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        Object[] r13 = r10.toArray(new String[0]);     // Catch: Throwable -> L9
        if (r13 == null) goto L12;
        Object r14 = Result.m124constructorimpl(new JSONObject(r5, (String[]) r13));     // Catch: Throwable -> L9
    L15:
        if (Result.m127exceptionOrNullimpl(r14) == null) goto L17;
        com.lynx.jsbridge.a.r(TAG, "copyJson error");
    L17:
        Object r15 = r5;
        if (Result.m130isFailureimpl(r14) == true) goto L22;
        r15 = r14;
    L22:
        return (JSONObject) r15;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static /* synthetic */ void onApmFpsEvent$default(MatrixTeaManager r5, String r10, float r11, JSONObject r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r10 = "";
    L5:
        r5.onApmFpsEvent(r10, r11, r12);
    }

    public static /* synthetic */ void onButtonClickEvent$default(MatrixTeaManager r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = "";
    L5:
        r5.onButtonClickEvent(r10, r11);
    }

    private final void onEventInternal(String r10, JSONObject r11) {
        JSONObject r5 = copyJson(r11);
        this.backgroundHandler.post(new com.bytedance.ai.bridge.method.router.f(3, this, r10, r5, r11));
    }

    /* JADX INFO: renamed from: onEventInternal$lambda-8, reason: not valid java name */
    private static final void m103onEventInternal$lambda8(MatrixTeaManager r5, String r10, JSONObject r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$eventName");
        Intrinsics.checkNotNullParameter(r11, "$copyJson");
        Intrinsics.checkNotNullParameter(r12, "$jsonObject");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L6
        d r14 = r5.service;     // Catch: Throwable -> L6
        if (r14 == null) goto L8;
        b r15 = (b) r14;     // Catch: Throwable -> L6
        r15.d(r10, r11.toString());     // Catch: Throwable -> L6
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L6
    L9:
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L6
    L13:
        if (Result.m127exceptionOrNullimpl(r17) == null) goto L18;
        r5.pendingEvents.add(new g(r10, r12));
        com.lynx.jsbridge.a.r(TAG, "onEvent error");
        return;
    L18:
        return;
    L8:
        r16 = null;
    L6:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static /* synthetic */ void onPageShowEvent$default(MatrixTeaManager r5, String r10, String r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        r5.onPageShowEvent(r10, r11, r12);
    }

    private final void processPendingEvents() {
        if (this.pendingEvents.isEmpty() == false) goto L6;
        com.lynx.jsbridge.a.s(TAG, "没有暂存的事件需要处理");
        return;
    L6:
        com.lynx.jsbridge.a.s(TAG, "开始处理 " + this.pendingEvents.size() + " 个暂存事件");
        CopyOnWriteArrayList<g> r5 = this.pendingEvents;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L15;
        Object r12 = r11.next();
        g r13 = (g) r12;
        JSONObject r14 = r13.f20296b;     // Catch: Exception -> L14
        String r15 = r13.f20295a;
        JSONObject r16 = new JSONObject(r14.toString());     // Catch: Exception -> L14
        r16.put("app_package_name", this.config.f20294a);     // Catch: Exception -> L14
        this.config.getClass();     // Catch: Exception -> L14
        r16.put("app_version_code", 4);     // Catch: Exception -> L14
        this.config.getClass();     // Catch: Exception -> L14
        r16.put("app_version_name", "1.0.3");     // Catch: Exception -> L14
        this.config.getClass();     // Catch: Exception -> L14
        r16.put("app_is_boe", 0);     // Catch: Exception -> L14
        onEventInternal(r15, r16);     // Catch: Exception -> L14
        com.lynx.jsbridge.a.s(TAG, "成功发送暂存事件: " + r15);     // Catch: Exception -> L14
    L14:
        com.lynx.jsbridge.a.r(TAG, "发送暂存事件 " + r13.f20295a + " 失败");
        r10.add(r12);
        goto L8
    L15:
        this.pendingEvents.clear();
        this.pendingEvents.addAll(r10);
    }

    /* JADX INFO: renamed from: rebindService$lambda-1, reason: not valid java name */
    private static final void m104rebindService$lambda1(MatrixTeaManager r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.bindService();
    }

    public final void addDeviceInfoListener(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        com.lynx.jsbridge.a.s(TAG, "addDeviceInfoListener " + r5);
        if (this.listeners.contains(r5) == true) goto L5;
        this.listeners.add(r5);
        com.lynx.jsbridge.a.s(TAG, "addDeviceInfoListener不包含，添加进listeners中,当前size = " + this.listeners.size());
    L5:
        String r10 = did;
        if (r10 != null) goto L8;
    L11:
        String r11 = myInstallId;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.length() == 0) goto L19;
        com.lynx.jsbridge.a.s(TAG, "注册deviceInfoListener时installId有值，立即回调 " + myInstallId);
        Intrinsics.checkNotNull(myInstallId);
        r5.b();
        return;
    L19:
        return;
    L8:
        if (r10.length() == 0) goto L11;
        com.lynx.jsbridge.a.s(TAG, "注册deviceInfoListener时did有值，立即回调 " + did);
        Intrinsics.checkNotNull(did);
        r5.a();
        goto L11
    }

    public final void bindService() {
        bindServiceInternal();
        this.handler.postDelayed(this.retryRunnable, BIND_RETRY_INTERVAL);
    }

    public final void bindServiceInternal() {
        if (this.isBound == false) goto L6;
        com.lynx.jsbridge.a.s(TAG, "bindServiceInternal: service is already bound");
        return;
    L6:
        Intent r5 = new Intent();
        r5.setAction("com.obric.matrix.dataanalysis.service");
        r5.setPackage("com.obric.matrix");
        this.context.bindService(r5, this.connection, 1);
    }

    public final String getDeviceId() {
        String r5 = did;
        if (r5 == null) goto L10;
        if (r5.length() == 0) goto L10;
        com.lynx.jsbridge.a.s(TAG, "getDeviceId 有值，立即回调 " + did);
        return did;
    L10:
        if (this.isBound == true) goto L31;
        com.lynx.jsbridge.a.r(TAG, "getDeviceId error,Service not bounded");
        return null;
    L31:
        d r10 = this.service;     // Catch: Exception -> L25
        if (r10 == null) goto L22;
        b r11 = (b) r10;     // Catch: Exception -> L25
        Parcel r12 = Parcel.obtain();     // Catch: Exception -> L25
        Parcel r13 = Parcel.obtain();     // Catch: Exception -> L25
        r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L19
        if (r11.f20292a.transact(1, r12, r13, 0) == true) goto L17;
        int r14 = c.f20293a;     // Catch: Throwable -> L19
    L17:
        r13.readException();     // Catch: Throwable -> L19
        String r15 = r13.readString();     // Catch: Throwable -> L19
        r13.recycle();     // Catch: Exception -> L25
        r12.recycle();     // Catch: Exception -> L25
    L23:
        did = r15;     // Catch: Exception -> L25
        return r15;
    L19:
        th = move-exception;
        r13.recycle();     // Catch: Exception -> L25
        r12.recycle();     // Catch: Exception -> L25
        throw th;     // Catch: Exception -> L25
    L22:
        r15 = null;
    L25:
        com.lynx.jsbridge.a.r(TAG, "getDeviceId error");
        return null;
    }

    public final String getInstallId() {
        String r5 = myInstallId;
        if (r5 == null) goto L10;
        if (r5.length() == 0) goto L10;
        com.lynx.jsbridge.a.s(TAG, "getInstallId 有值，立即回调 " + myInstallId);
        return myInstallId;
    L10:
        if (this.isBound == true) goto L31;
        com.lynx.jsbridge.a.r(TAG, "getInstallId error,Service not bounded");
        return null;
    L31:
        d r10 = this.service;     // Catch: Exception -> L25
        if (r10 == null) goto L22;
        b r11 = (b) r10;     // Catch: Exception -> L25
        Parcel r12 = Parcel.obtain();     // Catch: Exception -> L25
        Parcel r13 = Parcel.obtain();     // Catch: Exception -> L25
        r12.writeInterfaceToken("com.obric.matrix.platform.sdk.ones.dataanalysis.IDataService");     // Catch: Throwable -> L19
        if (r11.f20292a.transact(2, r12, r13, 0) == true) goto L17;
        int r14 = c.f20293a;     // Catch: Throwable -> L19
    L17:
        r13.readException();     // Catch: Throwable -> L19
        String r15 = r13.readString();     // Catch: Throwable -> L19
        r13.recycle();     // Catch: Exception -> L25
        r12.recycle();     // Catch: Exception -> L25
    L23:
        myInstallId = r15;     // Catch: Exception -> L25
        return r15;
    L19:
        th = move-exception;
        r13.recycle();     // Catch: Exception -> L25
        r12.recycle();     // Catch: Exception -> L25
        throw th;     // Catch: Exception -> L25
    L22:
        r15 = null;
    L25:
        com.lynx.jsbridge.a.r(TAG, "getInstallId error");
        return null;
    }

    public final String getOAID() {
        Object r5 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        Bundle r11 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.oaidprovider"), "get_oaid", null, null);     // Catch: Throwable -> L10
        if (r11 == null) goto L15;
        String r12 = r11.getString("oaid");     // Catch: Throwable -> L10
        if (r12 == null) goto L13;
        if (r12.length() == 0) goto L13;
        String r13 = "oaid not empty, return " + r12.substring(0, 2) + "****" + r12.substring(r12.length() - 2);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r13, "msg");     // Catch: Throwable -> L10
        com.lynx.jsbridge.a.s("matrix_ones", r13);     // Catch: Throwable -> L10
        Object r14 = Result.m124constructorimpl(r12);     // Catch: Throwable -> L10
    L18:
        if (Result.m127exceptionOrNullimpl(r14) == null) goto L21;
        com.lynx.jsbridge.a.r(TAG, "getOAID error");
    L21:
        if (Result.m130isFailureimpl(r14) == true) goto L25;
        r5 = r14;
    L25:
        return (String) r5;
    L13:
        throw new IllegalStateException(("get oaid failed, errorCode = " + r11.getString("errCode") + ", errorMsg = " + r11.getString("errMsg")).toString());     // Catch: Throwable -> L10
    L15:
        throw new IllegalStateException("provider return null");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final String getUDID() {
        String r5 = mUDid;
        if (r5 != null) goto L5;
    L9:
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        Bundle r12 = this.context.getContentResolver().call(Uri.parse("content://com.bytedance.securityserver.udidprovider"), "get_udid", null, null);     // Catch: Throwable -> L17
        if (r12 == null) goto L22;
        String r13 = r12.getString("udid");     // Catch: Throwable -> L17
        if (r13 == null) goto L20;
        if (r13.length() == 0) goto L20;
        mUDid = r13;     // Catch: Throwable -> L17
        String r14 = "udid not empty, return " + r13.substring(0, 2) + "****" + r13.substring(r13.length() - 2);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r14, "msg");     // Catch: Throwable -> L17
        com.lynx.jsbridge.a.s("matrix_ones", r14);     // Catch: Throwable -> L17
        Object r15 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L17
    L25:
        if (Result.m127exceptionOrNullimpl(r15) == null) goto L28;
        com.lynx.jsbridge.a.r(TAG, "getUDID error");
    L28:
        if (Result.m130isFailureimpl(r15) == true) goto L32;
        r10 = r15;
    L32:
        return (String) r10;
    L20:
        throw new IllegalStateException(("get udid failed, errorCode = " + r12.getString("errCode") + ", errorMsg = " + r12.getString("errMsg")).toString());     // Catch: Throwable -> L17
    L22:
        throw new IllegalStateException("provider return null");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        if (r5.length() == 0) goto L9;
        com.lynx.jsbridge.a.s(TAG, "getUDID 有值，立即回调 " + r5.substring(0, 2) + "****" + r5.substring(r5.length() - 2));
        return r5;
    }

    public final void onApmColdLaunchFirstFrameEvent(long r5) {
        JSONObject r10 = new JSONObject();
        r10.put("duration", r5);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME, r10);
    }

    public final void onApmColdLaunchFirstFrameEventTail(int r5) {
        JSONObject r10 = new JSONObject();
        r10.put("duration", r5);
        onEvent(EVENT_APM_COLD_LAUNCH_FIRST_FRAME_TAIL, r10);
    }

    public final void onApmColdLaunchUserCompleteEvent(long r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "extraInfo");
        JSONObject r11 = new JSONObject();
        r11.put("duration", r5);
        Iterator<String> r12 = r10.keys();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        r11.put(r13, r10.get(r13));
        goto L4
    L6:
        onEvent(EVENT_APM_COLD_USER_COMPLETE, r11);
    }

    public final void onApmFpsEvent(String r5, float r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        if (r11 != null) goto L5;
        r11 = new JSONObject();
    L5:
        r11.put("page_name", r5);
        r11.put("fps", Float.valueOf(r10));
        onEvent(EVENT_APM_FPS, r11);
    }

    public final void onApmHotLaunchEvent(int r5) {
        JSONObject r10 = new JSONObject();
        r10.put("duration", r5);
        onEvent(EVENT_APM_HOT_LAUNCH, r10);
    }

    public final void onApmHotLaunchEventTail(int r5) {
        JSONObject r10 = new JSONObject();
        r10.put("duration", r5);
        onEvent(EVENT_APM_HOT_LAUNCH_TAIL, r10);
    }

    public final void onApmMemoryEvent(int r5, boolean r10) {
        JSONObject r11 = new JSONObject();
        r11.put("memory_size", r5);
        r11.put("type", !r10 ? 1 : 0);
        onEvent(EVENT_APM_MEMORY, r11);
    }

    public final void onButtonClickEvent(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "componentName");
        JSONObject r11 = new JSONObject();
        r11.put("click_for", r5);
        r11.put("scene", r10);
        onEvent(EVENT_BUTTON_CLICK, r11);
    }

    public final void onEvent(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        int r11 = r10.toString().getBytes(Charsets.UTF_8).length;     // Catch: Throwable -> L17
        if (r11 <= 204800) goto L9;
        com.lynx.jsbridge.a.r(TAG, "事件 " + r5 + " 数据大小 " + r11 + " 字节超过200KB限制，已丢弃");
        return;
    L9:
        if (this.isBound == true) goto L23;
        this.pendingEvents.add(new g(r5, new JSONObject(r10.toString())));     // Catch: Exception -> L15
        com.lynx.jsbridge.a.s(TAG, "服务未绑定，暂存事件: " + r5 + " 成功，当前暂存数量: " + this.pendingEvents.size());     // Catch: Exception -> L15
        return;
    L15:
        com.lynx.jsbridge.a.r(TAG, "服务未绑定，暂存事件 " + r5 + " 失败");
        return;
    L23:
        r10.put("app_package_name", this.config.f20294a);     // Catch: Exception -> L12
        this.config.getClass();     // Catch: Exception -> L12
        r10.put("app_version_code", 4);     // Catch: Exception -> L12
        this.config.getClass();     // Catch: Exception -> L12
        r10.put("app_version_name", "1.0.3");     // Catch: Exception -> L12
        this.config.getClass();     // Catch: Exception -> L12
        r10.put("app_is_boe", 0);     // Catch: Exception -> L12
        onEventInternal(r5, r10);     // Catch: Exception -> L12
        return;
    L12:
        com.lynx.jsbridge.a.r(TAG, "onEvent error");
        return;
    L17:
        com.lynx.jsbridge.a.r(TAG, "计算事件大小失败，已丢弃事件 " + r5);
    }

    public final void onPageShowEvent(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        JSONObject r12 = new JSONObject();
        r12.put("duration", r11);
        r12.put("page_name", r5);
        r12.put("prev_page_name", r10);
        onEvent(EVENT_PAGE_SHOW, r12);
    }

    public final void rebindService() {
        this.isBound = false;     // Catch: Exception -> L5
        this.service = null;     // Catch: Exception -> L5
        this.handler.postDelayed(new com.obric.oui.lisitem.a(this, 20), WsConstants.EXIT_DELAY_TIME);     // Catch: Exception -> L5
        return;
    L5:
        com.lynx.jsbridge.a.r(TAG, "rebindService error");
    }

    public final void removeDeviceInfoListener(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.listeners.remove(r5);     // Catch: Exception -> L5
        com.lynx.jsbridge.a.s(TAG, "removeDeviceInfoListener " + r5 + ", size = " + this.listeners.size());     // Catch: Exception -> L5
        return;
    L5:
        com.lynx.jsbridge.a.r(TAG, "removeDeviceInfoListener error");
    }

    private MatrixTeaManager(Context r5, e r10) {
        this.context = r5;
        this.config = r10;
        this.listeners = new CopyOnWriteArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        this.pendingEvents = new CopyOnWriteArrayList();
        this.retryRunnable = new j(this);
        HandlerThread r11 = new HandlerThread("MatrixTeaBackgroundThread");
        r11.start();
        this.backgroundHandler = new Handler(r11.getLooper());
        this.deviceInfoCallback = new i(this);
        this.connection = new h(this);
    }

    public final void onPageShowEvent(String r5, long r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "pageName");
        Intrinsics.checkNotNullParameter(r11, "extra");
        JSONObject r12 = new JSONObject();
        r12.put("duration", r10);
        r12.put("page_name", r5);
        Iterator<String> r13 = r11.keys();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = r13.next();
        r12.put(r14, r11.get(r14));
        goto L4
    L6:
        onEvent(EVENT_PAGE_SHOW, r12);
    }
}
