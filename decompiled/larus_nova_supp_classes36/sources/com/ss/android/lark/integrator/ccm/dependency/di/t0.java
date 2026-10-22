package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.gecko.GeckoSettingConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maincore.TabType;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class t0 implements com.bytedance.ee.bear.lark.dependency.g {
    public final void A0() {
    }

    public final void B0() {
    }

    public final void D0() {
    }

    public final void E0() {
    }

    public final void F0() {
    }

    public final void G0() {
    }

    public final void H0() {
    }

    public final void I0() {
    }

    public final void K0() {
    }

    public final void L0() {
    }

    public final void M0() {
    }

    public final void P0() {
    }

    public final void Q0() {
    }

    public final void R0() {
    }

    public final void S0() {
    }

    public final void T0() {
    }

    public final void V0() {
    }

    public final void W0() {
    }

    public final void a() {
    }

    public final void d() {
    }

    public final void getLarkHttpClient() {
    }

    public final void getNtpTime() {
    }

    public final boolean C0() {
        return AppLifecycle.a.a.h();
    }

    public final boolean N0() {
        if (((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).s() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final String O0() {
        int r0 = gcb.c.a;
        if (idb.f.a().isEnable("lark.ka.dynamicres") == false) goto L107;
        final String r3 = kcb.a.c().getString("ka_resource_tid", "");
        com.ss.android.lark.gecko.a r1 = com.ss.android.lark.gecko.a.C0081a.a;
        final Application r5 = com.larksuite.framework.utils.b.a;
        r1.getClass();
        if (idb.f.a().isEnable("lark.hobby.lark_resource_bundle_refactor") == false) goto L63;
        com.ss.android.lark.hobby.d r2 = com.ss.android.lark.hobby.d.a.a;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L47;
        String r13 = UserSP.getInstance().getString("hobby_res_task_id", "");
        if (r5 != null) goto L12;
    L42:
        String r16 = "HybridDynamicResourceProvider";
    L43:
        String r4 = "";
    L45:
        if (TextUtils.isEmpty(r4) == true) goto L60;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.hobby.a(r5, r3));
    L60:
        if (TextUtils.isEmpty(r4) == false) goto L62;
        UserSP.getInstance().putString("hobby_res_task_id", "");
    L62:
        Log.i("GeckoResManager", "hobbyResPath: " + r4);
    L103:
        String r6 = r4;
    L106:
        if (TextUtils.isEmpty(r6) == true) goto L107;
        String r7 = kcb.a.c().getString("ka_resource_path", "");
        String r8 = kcb.a.c().getString("ka_hybrid_resource", "");
        if (TextUtils.isEmpty(r7) == false) goto L111;
    L160:
        InputStream r9 = new PolarisZipFileWrapper(r6).getInputStream(new ZipEntry("assets/hybrid_material"));     // Catch: Throwable -> L128 Exception -> L130 IOException -> L135 FileNotFoundException -> L140
    L115:
        String r10 = r16;
        Log.i(r10, "load hybrid material from remote");     // Catch: Exception -> L119 IOException -> L121 FileNotFoundException -> L154 Throwable -> L147
        String r11 = new String(com.larksuite.framework.utils.e0.b(r9), StandardCharsets.UTF_8);     // Catch: Exception -> L119 IOException -> L121 FileNotFoundException -> L154 Throwable -> L147
        r9.close();     // Catch: IOException -> L152
    L145:
        kcb.a.c().putString("ka_resource_path", r6);
        kcb.a.c().putString("ka_hybrid_resource", r11);
        Log.d(r10, "HYBRID_MATERIAL " + r11);
        return r11;
    L121:
        e = e;
    L137:
        Log.i(r10, e);     // Catch: Throwable -> L147
        if (r9 != null) goto L156;
    L144:
        r11 = null;
    L156:
        r9.close();     // Catch: IOException -> L153
    L119:
        e = e;
    L132:
        Log.i(r10, e);     // Catch: Throwable -> L147
        if (r9 == null) goto L144;
    L141:
        Log.i(r10, "default package without hybrid material file");     // Catch: Throwable -> L147
        if (r9 == null) goto L144;
    L147:
        th = th;
        ?? r12 = r8;
    L149:
        if (r12 != 0) goto L158;
    L151:
        throw th;
    L158:
        r12.close();     // Catch: IOException -> L155
    L140:
        r10 = r16;
        r9 = null;
    L135:
        e = e;
        r10 = r16;
        r9 = null;
    L130:
        e = e;
        r10 = r16;
        r9 = null;
    L128:
        th = th;
        r12 = 0;
        goto L149
    L111:
        if (TextUtils.equals(r7, r6) == false) goto L160;
        return r8;
    L12:
        if (TextUtils.isEmpty(r3) == true) goto L42;
        String r14 = com.ss.android.lark.hobby.d.d(r3);
        if (TextUtils.isEmpty(r13) == true) goto L20;
        r16 = "HybridDynamicResourceProvider";
        PolarisFileWrapper r15 = new PolarisFileWrapper(com.ss.android.lark.hobby.d.b(r5, r14) + File.separator + r13, "resource-bundle");
        if (r15.exists() == false) goto L19;
        Log.i("HobbyResManager", "getKaResPathFast: found res by SP, taskId: " + r13);
        r4 = r15.getAbsolutePath();
        goto L45
    L19:
        Log.w("HobbyResManager", "getKaResPathFast: res by SP not valid, taskId: " + r13 + ", path: " + r15.getAbsolutePath());
    L161:
        Log.i("HobbyResManager", "getKaResPathFast: start fallback scanning");     // Catch: Exception -> L40
        String r17 = com.ss.android.lark.hobby.d.b(r5, r14);     // Catch: Exception -> L40
        PolarisFileWrapper r18 = new PolarisFileWrapper(r17);     // Catch: Exception -> L40
        if (r18.exists() == true) goto L24;
    L38:
        Log.w("HobbyResManager", "getKaResPathFast: kaResDir not valid: " + r17);     // Catch: Exception -> L40
        goto L43
    L24:
        if (r18.isDirectory() == false) goto L38;
        File[] r19 = r18.listFiles();     // Catch: Exception -> L40
        if (r19 != null) goto L29;
    L37:
        Log.w("HobbyResManager", "getKaResPathFast: no task dirs found in " + r17);     // Catch: Exception -> L40
        goto L43
    L29:
        if (r19.length == 0) goto L37;
        Arrays.sort(r19, Collections.reverseOrder());     // Catch: Exception -> L40
        File r20 = r19[0];     // Catch: Exception -> L40
        File[] r21 = r20.listFiles();     // Catch: Exception -> L40
        if (r21 != null) goto L34;
    L36:
        Log.w("HobbyResManager", "getKaResPathFast: no resource bundles in " + r20.getAbsolutePath());     // Catch: Exception -> L40
        goto L43
    L34:
        if (r21.length <= 0) goto L36;
        String r22 = r21[0].getAbsolutePath();     // Catch: Exception -> L40
        Log.i("HobbyResManager", "getKaResPathFast: found res by scanning, taskId: " + r20.getName() + ", path: " + r22);     // Catch: Exception -> L40
        UserSP.getInstance().putString("hobby_res_task_id", r20.getName());     // Catch: Exception -> L40
        r4 = r22;
    L40:
        e = move-exception;
        Log.e("HobbyResManager", "getKaResPathFast error", e);
        goto L43
    L20:
        r16 = "HybridDynamicResourceProvider";
        Log.i("HobbyResManager", "getKaResPathFast: taskId in SP is empty");
        goto L161
    L47:
        r16 = "HybridDynamicResourceProvider";
        r2.a(r5, r3);
        File[] r23 = new PolarisFileWrapper(com.ss.android.lark.hobby.d.b(r5, com.ss.android.lark.hobby.d.d(r3))).listFiles();
        if (r23 != null) goto L50;
    L58:
        r4 = "";
        goto L60
    L50:
        if (r23.length == 0) goto L58;
        Arrays.sort(r23, Collections.reverseOrder());
        File[] r24 = r23[0].listFiles();
        if (r24 == null) goto L58;
        if (r24.length == 0) goto L58;
        r4 = r24[0].getAbsolutePath();
        Log.i("HobbyResManager", "kaResPath: " + r4);
        goto L60
    L63:
        r16 = "HybridDynamicResourceProvider";
        Log.i("GeckoResManager", "getKaRes context:" + r5 + ", tid:" + r3);
        if (r5 != null) goto L66;
    L104:
        r6 = null;
        goto L106
    L66:
        if (TextUtils.isEmpty(r3) == true) goto L104;
        String r25 = "ka_" + r3;
        if (((HashMap) r1.a).containsKey(r25) == false) goto L71;
        r4 = (String) ((HashMap) r1.a).get(r25);
        goto L103
    L71:
        GeckoSettingConfig r26 = (GeckoSettingConfig) SettingManager.getInstance().get(GeckoSettingConfig.class);
        if (r26 != null) goto L75;
        Log.i("GeckoResManager", "geckoSettingConfig is null");
        goto L104
    L75:
        if (r26.mKaDynamicResource != null) goto L77;
        Log.i("GeckoResManager", "mKaDynamicResource is null");
        goto L104
    L77:
        String r27 = ResLoadUtils.getChannelPath(new PolarisFileWrapper(r5.getFilesDir(), "gecko_offline_res_x"), r26.mKaDynamicResource.mAccessKey, r25);
        if (TextUtils.isEmpty(r27) == false) goto L80;
    L83:
        boolean r28 = true;
    L84:
        if (r28 == true) goto L104;
        PolarisFileWrapper r29 = new PolarisFileWrapper(r27);
        Long r30 = CastLongProtector.valueOf(r29.getParentFile().getName());
        StringBuilder r31 = new StringBuilder();
        r31.append(r5.getFilesDir().getAbsolutePath());
        String r32 = File.separator;
        r31.append(r32);
        r31.append("gecko_ka_res");
        r31.append(r32);
        r31.append(r25);
        String r33 = r31.toString();
        PolarisFileWrapper r34 = new PolarisFileWrapper(r33);
        if (r34.exists() == false) goto L104;
        List r35 = ez5.f.a(r34);
        if (r35 == null) goto L102;
        ArrayList r36 = (ArrayList) r35;
        if (r36.isEmpty() == true) goto L102;
        if (r36.contains(r30) == false) goto L102;
        PolarisFileWrapper r37 = new PolarisFileWrapper(r33 + r32 + r30.longValue() + r32 + "res");
        if (com.ss.android.lark.gecko.a.a(r37) == true) goto L102;
        if (r29.length() != r37.length()) goto L102;
        String r38 = r37.listFiles()[0].getAbsolutePath();
        ((HashMap) r1.a).put(r25, r38);
        r4 = r38;
    L102:
        r4 = null;
        goto L103
    L80:
        if (com.ss.android.lark.gecko.a.a(new PolarisFileWrapper(r27)) == true) goto L83;
        r28 = false;
    L107:
        return null;
    }

    public final u0 getSearchLifecycleObserver() {
        return new u0();
    }

    public final Activity getTopActivity() {
        return AppLifecycle.a.a.f();
    }

    @Inject
    public t0() {
    }

    public final TabType getTabType() {
        return TabType.Others;
    }

    public final void U0(c2 r2) {
        ((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).h6(r2);
    }

    public final String decodeQRCode(String r3) {
        dxa.g r4 = ((mlb.a) ApiUtils.getApi(mlb.a.class)).decodeQRCode(r3);
        if (r4 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r4.a) == false) goto L8;
        List r1 = r4.b;
        if (r1 != null) goto L12;
    L15:
        return "";
    L12:
        if (r1.size() <= 0) goto L15;
        return ((dxa.f) ListProtector.get(r4.b, 0)).a;
    L8:
        return r4.a;
    }

    public final WatermarkInfo z0(Context r2) {
        return ((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).z0(r2);
    }

    public final void openUrl(Context r1, String r2) {
        com.ss.android.lark.router.c.b(r1, r2);
    }

    public final void J0(Context r5, int[] r6, com.bytedance.ee.bear.lark.dependency.p0 r7) {
        s0 r1 = new s0(r7, new r0(r5));
        ew4.c0 r8 = ew4.v.a;
        UserSession r0 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L5
        r8 = (ew4.c0) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passportc.internal.v.class)).c(r0), ew4.c0.class);     // Catch: Throwable -> L5
    L7:
        r8.I0(r5, r6, r1);
        return;
    L5:
        th = move-exception;
        tt5.a.l("OfficeCoreDependencyImpl", "get session QR code service failed, use default service", th);
        goto L7
    }

    public final Bitmap e(String r3, int r4, int r5) {
        owb.b r0 = OfficeSDKManager.getHostGlobalService(owb.b.class);
        if (r0 != null) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNullParameter(r0, "hostService");
        Intrinsics.checkNotNullParameter(r3, "content");
        return r0.q1(r3, new owb.c(r4, r5));
    }
}
