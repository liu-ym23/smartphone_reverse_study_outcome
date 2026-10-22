package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Proxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J1\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/H\u0016J\u001c\u00100\u001a\u00020\t2\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00103\u001a\u00020/H\u0016J\u0018\u00104\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0019H\u0016J\u0018\u00105\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u00106\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J:\u00107\u001a\u00020\t2\n\u0010.\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00142\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010:H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/CapabilityManagerClient;", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "api", "Lcom/obric/capabilitykit/common/ICapabilityManager;", "(Lcom/obric/capabilitykit/common/ICapabilityManager;)V", "apiVersion", "", "mApi", "finishFloatingActivity", "", "questionId", "", "getFloatingPendingIntent", "Landroid/app/PendingIntent;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "hideIntentResultCard", "isCardViewVisible", "", "(J)Ljava/lang/Boolean;", "isKeyguardReallyLocked", "registerIntent", ActivityLifecycle.NAME, "", "implClassName", "serviceName", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "requestStateChanged", OaidModel.KEY_ID, "stateInfo", "Lcom/obric/capabilitykit/common/TaskStateInfo;", "callback", "Lcom/obric/capabilitykit/TaskStateChangeCallback;", LocationMonitorConst.TIMEOUT, "(Ljava/lang/String;Lcom/obric/capabilitykit/common/TaskStateInfo;Lcom/obric/capabilitykit/TaskStateChangeCallback;Ljava/lang/Long;)V", "requestUriFileAccess", "uri", "Landroid/net/Uri;", ObricMemoryConstants.KEY_PACKAGE_NAME, "requester", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "sendIntentExecutionResult", "intentResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "oldResult", "stopUriFileAccess", "unregisterIntent", "unregisterResultCallback", "updateIntentResult", "isStatusChange", "ext", "", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements com.obric.capabilitykit.a {
    public static final a c = null;
    private static final String d = "CapabilityManagerClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ICapabilityManager f7533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7534b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/CapabilityManagerClient$Companion;", "", "()V", "TAG", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        c = new a(null);
    }

    public e(ICapabilityManager r7) {
        ICapabilityManager r8 = (ICapabilityManager) ZeusTransformUtils.wrapperContextForParams(r7, ICapabilityManager.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "api");
        Object r1 = Proxy.newProxyInstance(ICapabilityManager.class.getClassLoader(), new Class[]{ICapabilityManager.class}, new BinderExceptionHandlerProxy(r8, d, ICapabilityManager.class));     // Catch: Throwable -> L8
        if (r1 == null) goto L7;
        r8 = (ICapabilityManager) ZeusTransformUtils.preCheckCast(r1, ICapabilityManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        ICapabilityManager r9 = (ICapabilityManager) ZeusTransformUtils.preCheckCast(r8, ICapabilityManager.class, "com.obric.memorydata.plugin");
        this.f7533a = r9;
        int r10 = r9.getVersion();
        Logger.INSTANCE.i(d, "ICapabilityManager version: " + r10);
        this.f7534b = r10;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Throwable r2 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r2 == null) goto L12;
        Log.e(d, "BinderExceptionHandlerProxy createProxyInstance for " + r8.getClass() + " fail", r2);
        goto L12
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r2, Intent r4, FloatingIntentParams r5) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        return this.f7533a.getFloatingPendingIntent(r2, r4, r5);
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r1) {
        this.f7533a.hideIntentResultCard(r1);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        this.f7533a.requestCloseFile(r3, r2);
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r7, String r8, IUriFileReceiver r9) {
        IUriFileReceiver r10 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r9, IUriFileReceiver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "uri");
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, "requester");
        if (this.f7533a.requestOpenFile(r10, r7, r8) == true) goto L6;
        r10.onSessionReady(new UriFileAccessSession(1, "无权限或无法访问 URI。", null, 4, null));
        return;
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f7533a.unregisterResultCallback(r2);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.f7533a.sendActionExecuteResult(UtilsKt.getGson().toJson(r2));
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r7, long r8, boolean r10, Map<String, String> r11) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "result");
        this.f7533a.updateIntentResult(r7, r8, r10, r5);
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r2, IMAppAction r3) {
        Intrinsics.checkNotNullParameter(r2, "intentResult");
        Intrinsics.checkNotNullParameter(r3, "oldResult");
        this.f7533a.sendIntentExecutionResult(r2, UtilsKt.getGson().toJson(r3));
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r8, TaskStateInfo r9, TaskStateChangeCallback r10, Long r11) {
        Intrinsics.checkNotNullParameter(r8, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r9, "stateInfo");
        ICapabilityManager r1 = this.f7533a;
        if (r11 == null) goto L5;
        long r2 = r11.longValue();
    L6:
        r1.requestStateChanged(r8, r9, r10, r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        this.f7533a.unregisterIntent(r2, r3);
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        this.f7533a.registerIntent(r2, r3, r4);
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        return this.f7533a.isKeyguardReallyLocked();
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r1) {
        this.f7533a.finishFloatingActivity(r1);
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.f7533a.registerResultCallback(r2);
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r1) {
        return Boolean.valueOf(this.f7533a.isCardViewVisible(r1));
    }
}
