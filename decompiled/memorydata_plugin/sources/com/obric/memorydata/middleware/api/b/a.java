package com.obric.memorydata.middleware.api.b;

import android.content.Context;
import android.provider.Settings;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.bytedance.crypto.CryptoSdk;
import com.bytedance.crypto.bridge.IEnvBridge;
import com.bytedance.crypto.bridge.ILogBridge;
import com.bytedance.crypto.cloudtrans.CloudTransCryptoManager;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/api/encrypt/CloudTransCryptoUtils;", "", "<init>", "()V", "TAG", "", "initSuccess", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "dataEncrypt", "", "data", "dataDecrypt", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f11605b;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.api.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/middleware/api/encrypt/CloudTransCryptoUtils$init$1", "Lcom/bytedance/crypto/bridge/ILogBridge;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "i", "w", "e", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0621a implements ILogBridge {
        C0621a() {
        }

        @Override // com.bytedance.crypto.bridge.ILogBridge
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug("CloudTransCryptoUtils", r2);
        }

        @Override // com.bytedance.crypto.bridge.ILogBridge
        public void e(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudTransCryptoUtils", r8, null, 4, null);
        }

        @Override // com.bytedance.crypto.bridge.ILogBridge
        public void i(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudTransCryptoUtils", r8, false, 4, null);
        }

        @Override // com.bytedance.crypto.bridge.ILogBridge
        public void w(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudTransCryptoUtils", r8, null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/middleware/api/encrypt/CloudTransCryptoUtils$init$2", "Lcom/bytedance/crypto/bridge/IEnvBridge;", "onIsBoeEnv", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements IEnvBridge {
        b() {
        }

        @Override // com.bytedance.crypto.bridge.IEnvBridge
        public boolean onIsBoeEnv() {
            if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "matrix_env_status_is_boe", 0) == 1) goto L5;
            return false;
        L5:
            return true;
        }
    }

    static {
        f11604a = new a();
    }

    private a() {
    }

    public final void a() {
        if (f11605b == false) goto L5;
        return;
    L5:
        RunLog.INSTANCE.debug("CloudTransCryptoUtils", CommonConsts.APM_INNER_EVENT_COST_INIT);
        CryptoSdk.initLogger((ILogBridge) ZeusTransformUtils.preCheckCast(new C0621a(), ILogBridge.class, "com.obric.memorydata.plugin"));
        CloudTransCryptoManager r9 = CloudTransCryptoManager.getInstance();
        r9.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AppContext.INSTANCE.getSecurityAid(), AppContext.INSTANCE.getServerDeviceId(), (IEnvBridge) ZeusTransformUtils.preCheckCast(new b(), IEnvBridge.class, "com.obric.memorydata.plugin"));     // Catch: CloudTransException -> L8
        byte[] r1 = "test".getBytes(Charsets.UTF_8);     // Catch: CloudTransException -> L8
        Intrinsics.checkNotNullExpressionValue(r1, "getBytes(...)");     // Catch: CloudTransException -> L8
        r9.dataEncrypt(r1);     // Catch: CloudTransException -> L8
        f11605b = true;     // Catch: CloudTransException -> L8
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CloudTransCryptoUtils", "init success", false, 4, null);     // Catch: CloudTransException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        RunLog.INSTANCE.error("CloudTransCryptoUtils", "init failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final byte[] a(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        byte[] r2 = CloudTransCryptoManager.getInstance().dataEncrypt(r3);     // Catch: CloudTransException -> L5
        Intrinsics.checkNotNullExpressionValue(r2, "dataEncrypt(...)");     // Catch: CloudTransException -> L5
        return Base64.encode(r2, 0);
    L5:
        e = move-exception;
        e.printStackTrace();
        RunLog.INSTANCE.error("CloudTransCryptoUtils", "dataEncrypt failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public final byte[] b(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        byte[] r4 = Base64.decode(r5, 0);     // Catch: Exception -> L5
        return CloudTransCryptoManager.getInstance().dataDecrypt(r4);
    L5:
        e = move-exception;
        e.printStackTrace();
        RunLog.INSTANCE.error("CloudTransCryptoUtils", "dataDecrypt failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "dataDecrypt failed");
        return null;
    }
}
