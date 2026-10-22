package com.ss.android.lark.player.player;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Base64;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LarkPlayerUtils {
    public static final LarkPlayerUtils a = null;
    public static Handler b;
    public static final ConcurrentHashMap<String, Runnable> c = null;
    public static final Lazy d = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0<HashMap<String, String>> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ IMPlayerSettings.VideoLarkConfig d;

        /* JADX INFO: renamed from: com.ss.android.lark.player.player.LarkPlayerUtils$a$a, reason: collision with other inner class name */
        public static final class C0103a implements IPreLoaderItemCallBackListener {
            public final /* synthetic */ long a;
            public final /* synthetic */ String b;

            public C0103a(long r1, String r3) {
                this.a = r1;
                this.b = r3;
            }

            public final void preloadItemInfo(PreLoaderItemCallBackInfo r5) {
                StringBuilder r0 = new StringBuilder("info key: ");
                Integer r1 = null;
                if (r5 == null) goto L5;
                Integer r2 = Integer.valueOf(r5.getKey());
            L6:
                r0.append(r2);
                Log.i("LarkPlayerUtils", r0.toString());
                if (r5 == null) goto L10;
                r1 = Integer.valueOf(r5.getKey());
            L10:
                if (r1 != null) goto L13;
            L14:
                if (r1 != null) goto L17;
                return;
            L17:
                if (r1.intValue() == 3) goto L19;
                return;
            L19:
                if (r5.getKey() != 2) goto L21;
                String r6 = "success";
            L22:
                JSONObject r7 = new JSONObject().put("result", r6).put("duration", System.currentTimeMillis() - this.a);
                LarkPlayerUtils.a.getClass();
                ((o5c.b) LarkPlayerUtils.d.getValue()).sendEvent("preload_video_finish_dev", r7);
                LarkPlayerUtils.c.remove(this.b);
                return;
            L21:
                r6 = "failed";
                goto L22
            L13:
                if (r1.intValue() == 2) goto L19;
            L5:
                r2 = null;
                goto L6
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends HashMap<String, String>> r1, String r2, String r3, IMPlayerSettings.VideoLarkConfig r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            HashMap r7 = (HashMap) this.a.invoke();
            long r0 = System.currentTimeMillis();
            LarkPlayerUtils.a.getClass();
            ((o5c.b) LarkPlayerUtils.d.getValue()).sendEvent("preload_video_start_dev", null);
            LarkPlayerUtils.h(this.b, this.c, this.d.getPreloadSize(), this.d.getPreloadFooterSize(), r7, new C0103a(r0, this.b));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public LarkPlayerUtils() {
    }

    static {
        a = new LarkPlayerUtils();
        Log.i("LarkPlayerUtils", "generateHandler");
        b = CoreThreadPool.newThreadHandler("lk-preload-media");
        c = new ConcurrentHashMap();
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LarkPlayerUtils$statistics$2.INSTANCE);
    }

    public static void a() {
        Log.i("LarkPlayerUtils", "cancelAllPreload");
        Iterator<T> r1 = c.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "url");
        Runnable r3 = c.remove(r2);
        if (r3 == null) goto L4;
        Log.i("LarkPlayerUtils", "cancel preloadMsgVideo success, url: " + i(r2));
        b.removeCallbacks(r3);
        goto L4
    }

    @JvmStatic
    public static final boolean c() {
        boolean r1 = true;
        if (CipherManager.d() == 1) goto L6;
        r1 = false;
    L6:
        Log.i("LarkPlayerUtils", "isCipherEncrypt:" + r1);
        return r1;
    }

    @JvmStatic
    public static final boolean d() {
        return FeatureGatingModule.getFeatureGatingService().isEnable("performance.im.rollback_video_preload_session_governance");
    }

    @JvmStatic
    public static final String i(String r3) {
        if (r3 == null) goto L11;
        return Base64.encodeToString(r3.getBytes(Charsets.UTF_8), 0);
    L6:
        e = move-exception;
        Log.e("LarkPlayerUtils", "urlToBase64String exception:" + e);
        return "";
    L11:
        return "";
    }

    @JvmStatic
    public static final String b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return r1 + "__" + r2.hashCode();
    }

    @Deprecated(message = "Credential values must not cross module boundaries. session is long-lived and does not include the device-bound short-lived credential. Please use preloadMsgVideoForUser(url, cacheKeyPrefix, userId) instead", replaceWith = @ReplaceWith(expression = "preloadMsgVideoForUser(url, cacheKeyPrefix, userId)", imports = {}))
    @JvmStatic
    public static final void e(String r2, String r3, final String r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        LarkPlayerUtils r0 = a;
        Function0<HashMap<String, String>> r1 = new LarkPlayerUtils$preloadMsgVideo$1(r4);
        r0.getClass();
        g(r2, r3, r1);
    }

    @JvmStatic
    public static final void f(final String r2, String r3, final String r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r4, "userId");
        LarkPlayerUtils r0 = a;
        Function0<HashMap<String, String>> r1 = new LarkPlayerUtils$preloadMsgVideoForUser$1(r2, r4);
        r0.getClass();
        g(r2, r3, r1);
    }

    public static void g(String r7, String r8, Function0 r9) {
        String r0 = i(r7);
        IMPlayerSettings.VideoLarkConfig r1 = IMPlayerSettings.a();
        NetworkInfo r2 = ((ConnectivityManager) LarkContext.getApplication().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        StringBuilder r4 = new StringBuilder("preloadMsgVideo, url: ");
        r4.append(r0);
        r4.append(", isMobile: ");
        r4.append(r3);
        r4.append(", size: ");
        ConcurrentHashMap<String, Runnable> r5 = c;
        r4.append(r5.size());
        Log.i("LarkPlayerUtils", r4.toString());
        if (r1.getPreloadEnable() == 1) goto L11;
        return;
    L11:
        if (r1.getCellularPreloadEnable() != 0) goto L15;
        if (r3 == false) goto L15;
        return;
    L15:
        if (r1.getCancelPreloadDelayEnable() == 1) goto L17;
    L19:
        long r6 = r1.getPreloadDelay();
    L20:
        com.ss.android.lark.playerconfig.a.b("IM", "");
        if (r5.size() <= 3) goto L23;
        a();
    L23:
        a r10 = new a(r9, r7, r8, r1);
        r5.put(r7, r10);
        if (ThreadMethodProxy.isAlive(ThreadMethodProxy.getLooperThread(b.getLooper())) == true) goto L26;
        Log.i("LarkPlayerUtils", "generateHandler");
        b = CoreThreadPool.newThreadHandler("lk-preload-media");
    L26:
        b.postDelayed(r10, r6);
        return;
    L17:
        if (DataLoaderHelper.getDataLoader().isRunning() == false) goto L19;
        r6 = 0;
        goto L20
    L5:
        if (r2.getType() != 0) goto L7;
        r3 = true;
        goto L8
    }

    @JvmStatic
    public static final void h(String r13, String r14, long r15, long r17, HashMap<String, String> r19, IPreLoaderItemCallBackListener r20) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r20, "callback");
        if (c() == false) goto L5;
        return;
    L5:
        String r2 = i(r13);
        StringBuilder r5 = new StringBuilder("start to preload remote video, url: ");
        r5.append(r2);
        r5.append(", cacheKeyPrefix: ");
        r5.append(r14);
        r5.append(", headerSize: ");
        r5.append(r15);
        r5.append(", footerSize: ");
        r5.append(r17);
        r5.append(", extra size: ");
        if (r19 == null) goto L8;
        Integer r9 = Integer.valueOf(r19.size());
    L9:
        r5.append(r9);
        Log.i("LarkPlayerUtils", r5.toString());
        if (StringsKt.startsWith$default(r13, "http", false, 2, null) == true) goto L12;
        return;
    L12:
        if (r15 <= 0) goto L27;
        PreloaderURLItem r12 = new PreloaderURLItem(b(r14, r13), null, r15, new String[]{r13});
        if (r17 <= 0) goto L17;
        r12.setPreloadFooterSize(r17);
    L17:
        r12.setPriorityLevel(0);
        r12.setCallBackListener(r20);
        if (r19 == null) goto L23;
        Iterator<Map.Entry<String, String>> r0 = r19.entrySet().iterator();
    L21:
        if (r0.hasNext() == false) goto L23;
        Map.Entry<String, String> r1 = r0.next();
        r12.setCustomHeader(r1.getKey(), r1.getValue());
    L23:
        TTVideoEngine.addTask(r12);
        return;
    L27:
        return;
    L8:
        r9 = null;
        goto L9
    }
}
