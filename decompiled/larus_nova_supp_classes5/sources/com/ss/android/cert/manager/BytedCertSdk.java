package com.ss.android.cert.manager;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.api.ICertInitTask;
import el9.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BytedCertSdk {
    private static final String ADAPTER_NAME = "com.ss.android.bytedcert.adapter.CertInitTaskAdapter";

    public BytedCertSdk() {
    }

    public static /* synthetic */ void a(BytedCertSdkInitParam.PluginParams r0, BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r1, Map r2, BytedCertSdkInitParam.PluginParams.PluginType r3, BytedCertSdkInitParam.PluginParams.Status r4, String r5) {
        lambda$checkPluginReady$0(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_cert_manager_BytedCertSdk_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void init(BytedCertSdkInitParam r1) {
        BytedCertSdkManager.getInstance().init(r1);
    }

    public static void checkPluginReady(Map<String, String> r4, BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r5) {
        if (CertManager.getInstance().isBytedCertReady() == false) goto L5;
        r5.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, BytedCertSdkInitParam.PluginParams.Status.SUCCESS, null);
        return;
    L5:
        BytedCertSdkInitParam.PluginParams r0 = BytedCertSdkManager.getInstance().getPluginParams();
        if (r0 == null) goto L17;
        dta.a r1 = new dta.a(r0, r5, r4);
        BytedCertSdkInitParam.PluginParams.PluginType r6 = BytedCertSdkInitParam.PluginParams.PluginType.CERT;
        if (r0.isPluginLoaded(r6) == false) goto L10;
        r1.onFinish(r6, BytedCertSdkInitParam.PluginParams.Status.SUCCESS, "preload cert plugin success");
        return;
    L10:
        r0.tryPreloadPlugin(r4, r6, r1);
        return;
    L17:
        ((ICertInitTask) INVOKESTATIC_com_ss_android_cert_manager_BytedCertSdk_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(ADAPTER_NAME).newInstance()).init();     // Catch: Throwable -> L14
        checkPluginReady(r4, r5);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        r5.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, BytedCertSdkInitParam.PluginParams.Status.FAIL, "cert sdk init error:" + th.getMessage());
    }

    private static /* synthetic */ void lambda$checkPluginReady$0(BytedCertSdkInitParam.PluginParams r0, BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r1, Map r2, BytedCertSdkInitParam.PluginParams.PluginType r3, BytedCertSdkInitParam.PluginParams.Status r4, String r5) {
        BytedCertSdkInitParam.PluginParams.Status r6 = BytedCertSdkInitParam.PluginParams.Status.SUCCESS;
        if (r4 != r6) goto L8;
        BytedCertSdkInitParam.PluginParams.PluginType r7 = BytedCertSdkInitParam.PluginParams.PluginType.ALIYUN;
        if (r0.isPluginLoaded(r7) == false) goto L7;
        r1.onFinish(r7, r6, "preload aliyun plugin success");
        return;
    L7:
        BytedCertSdkManager.getInstance().getPluginParams().tryPreloadPlugin(r2, r7, r1);
        return;
    L8:
        r1.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, r4, r5);
    }
}
