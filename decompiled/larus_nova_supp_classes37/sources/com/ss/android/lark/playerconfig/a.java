package com.ss.android.lark.playerconfig;

import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.mediakit.medialoader.AVMDLLibraryManagerWrapper;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.LibraryLoaderProxy;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.ss.ttvideoengine.log.VideoEventManager;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z0c.b;
import z0c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.playerconfig.a$a, reason: collision with other inner class name */
    public static final class C0104a implements LibraryLoaderProxy {
        public static final C0104a a = null;

        static {
            a = new C0104a();
        }

        public C0104a() {
        }

        @JvmStatic
        public static void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
            com.bytedance.librarian.a.c(r4);
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
        }

        public final boolean loadLibrary(String r1) {
            a(r1);     // Catch: Exception -> L5
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    @JvmStatic
    public static final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Log.i("LarkPlayerKit", "startMDL, tag:" + r3 + ", subTag:" + r4 + ", isRunning:" + DataLoaderHelper.getDataLoader().isRunning());
        DataLoaderHelper.getDataLoader().setLoadProxy(C0104a.a);     // Catch: Exception -> L8
        c.a();     // Catch: Exception -> L8
        AVMDLLibraryManagerWrapper.setLibraryLoadLevel(124);     // Catch: Exception -> L8
        LarkAppContext.Companion.getClass();     // Catch: Exception -> L8
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L6;
        TTVideoEngine.setDataLoaderListener(new a1c.a());     // Catch: Exception -> L8
    L6:
        TTVideoEngine.startDataLoader(LarkContext.getApplication());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("LarkPlayerKit", "start data loader error: " + e.getMessage());
    }

    @JvmStatic
    public static final TTVideoEngine a(String r6, String r7, LarkPlayerSettings.NonStandardEngineSetting r8) {
        Intrinsics.checkNotNullParameter(r6, "tag");
        Log.i("LarkPlayerKit", "newEngine, tag:" + r6 + ", subTag:" + r7);
        if (r8 != null) goto L5;
        r8 = ((LarkPlayerSettings.EngineSetting) LarkPlayerSettings.d.getValue()).getNonStandard();
    L5:
        HashMap r1 = new HashMap();
        if (r8.getEnableLooper() != 1) goto L8;
        r1.put("enable_looper", Boolean.TRUE);
    L8:
        TTVideoEngine r2 = new TTVideoEngine(LarkContext.getApplication(), r8.getEngineType(), r1);
        r2.setAsyncInit(true, r8.getCodecID());
        if (r8.getSetCacheControlEnabled() != 1) goto L11;
        boolean r9 = true;
    L12:
        r2.setCacheControlEnabled(r9);
        int r10 = b.a;
        Intrinsics.checkNotNullParameter(r2, "engine");
        Intrinsics.checkNotNullParameter(r6, "tag");
        Intrinsics.checkNotNullParameter(r7, "subTag");
        r2.setTag(r6);     // Catch: Exception -> L22
        r2.setSubTag(r7);     // Catch: Exception -> L22
        r2.setCustomInfo(IVideoEventLogger.VideoEventCustomInfo.VIDEOEVENT_CUSTOM_INFO_COMPANY_ID, ((xzb.a) ApiUtils.getApi(xzb.a.class)).getTenantId());     // Catch: Exception -> L22
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L17;
        TTVideoEngineLog.turnOn(1, 1);     // Catch: Exception -> L22
    L20:
        VideoEventManager r11 = VideoEventManager.instance;     // Catch: Exception -> L22
        r11.setLoggerVersion(2);     // Catch: Exception -> L22
        r11.setListener(new a1c.c());     // Catch: Exception -> L22
        b.a(r2, r6, r7);     // Catch: Exception -> L22
    L24:
        return r2;
    L17:
        if (((LarkPlayerSettings.EngineSetting) LarkPlayerSettings.d.getValue()).getEnableDebugLog() == false) goto L19;
        TTVideoEngineLog.turnOn(1, 1);     // Catch: Exception -> L22
    L19:
        TTVideoEngineLog.setListener(new a1c.b());     // Catch: Exception -> L22
    L22:
        e = move-exception;
        Log.e("LarkPlayerEngineConfig", "config failed:" + e.getMessage());
        goto L24
    L11:
        r9 = false;
        goto L12
    }
}
