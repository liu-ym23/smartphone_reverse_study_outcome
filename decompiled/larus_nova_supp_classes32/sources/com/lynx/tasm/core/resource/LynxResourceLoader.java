package com.lynx.tasm.core.resource;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.i;
import com.lynx.tasm.q;
import com.lynx.tasm.q0;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.utils.UIThreadUtils;
import com.miui.easygo.constant.EasyGoConstant;
import com.obric.aivoice.core.data.NameKeys;
import d8a.d;
import d8a.e;
import d8a.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import l7a.f;
import l7a.g;
import l7a.h;
import l7a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxResourceLoader {
    public final q a;
    public final e b;
    public final j c;
    public final f8a.a d;
    public final WeakReference<i> e;
    public final q0 f;

    public class a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ LynxResourceLoader d;

        @Override // java.lang.Runnable
        public final void run() {
            this.d.e(this.a, this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxResourceLoader r1, long r2, String r4, int r5) {
            this.d = r1;
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public class b implements e8a.a<byte[]> {
        public final l7a.b a;

        @Override // e8a.a
        public final void onResponse(LynxResourceResponse<byte[]> r8) {
            int r2 = 0;
            if (r8.a != LynxResourceResponse.ResponseState.SUCCESS) goto L5;
            boolean r0 = true;
        L6:
            Throwable r1 = r8.c;
            l7a.b r3 = this.a;
            byte[] r9 = r8.b;
            if (r1 == null) goto L9;
            String r4 = r1.getMessage();
        L11:
            if (r3.a() == true) goto L14;
            return;
        L14:
            if (r0 == false) goto L21;
            LLog.i("LynxResourceLoader", "load resource success with url: " + r3.b);
            if (r9 != null) goto L18;
        L19:
            r4 = "get null data for provider.";
            r2 = 30301;
        L20:
            LynxResourceLoader.a(r3.c, r9, r2, r4);
            return;
        L18:
            if (r9.length != 0) goto L20;
        L21:
            LLog.i("LynxResourceLoader", "load resource failed with url: " + r3.b + " error message: " + r4);
            LynxResourceLoader.a(r3.c, null, 30301, r4 + ": " + r4);
            return;
        L9:
            r4 = NameKeys.UnloadStrategy_No_Strategy;
            goto L11
        L5:
            r0 = false;
            goto L6
        }

        public b(String r2, long r3) {
            this.a = new l7a.b(r2, r3);
        }
    }

    private native void nativeConfigLynxResourceSetting();

    public static native void nativeInvokeCallback(long r0, byte[] r2, long r3, ByteBuffer r5, int r6, String r7);

    public static byte[] d(String r10) {
        String r3 = r10.substring(14);
    L32:
        th = th;
        InputStream r5 = null;
    L61:
        LLog.e("LynxResourceLoader", "loadLynxJSAsset " + r10 + "with error message " + th.getMessage());     // Catch: Throwable -> L43
        if (r5 != null) goto L56;
    L41:
        LLog.e("LynxResourceLoader", "loadLynxJSAsset failed, can not load ".concat(r10));
        return null;
    L56:
        r5.close();     // Catch: IOException -> L38
    L38:
        IOException e = e;
        StringBuilder r4 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
    L40:
        r4.append(e.getMessage());
        LLog.e("LynxResourceLoader", r4.toString());
    L43:
        th = move-exception;
        if (r5 != null) goto L52;
    L49:
        throw th;
    L52:
        r5.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        LLog.e("LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
        goto L49
    L5:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L58;
    L11:
        r5 = null;
    L12:
        if (r5 == null) goto L63;
    L14:
        if (r5 == null) goto L27;
        ByteArrayOutputStream r6 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        byte[] r7 = new byte[4096];     // Catch: Throwable -> L19
    L16:
        int r8 = r5.read(r7);     // Catch: Throwable -> L19
        if (r8 == (-1)) goto L21;
        r6.write(r7, 0, r8);     // Catch: Throwable -> L19
        goto L16
    L21:
        byte[] r11 = r6.toByteArray();     // Catch: Throwable -> L19
        r5.close();     // Catch: IOException -> L24
    L26:
        return r11;
    L24:
        e = move-exception;
        LLog.e("LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L19:
        th = th;
        goto L61
    L27:
        if (r5 == null) goto L41;
        r5.close();     // Catch: IOException -> L30
    L30:
        e = e;
        r4 = new StringBuilder("loadLynxJSAsset inputStream close error: ");
        goto L40
    L63:
        r5 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r3);     // Catch: Throwable -> L19
        goto L14
    L58:
        String[] r9 = r3.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: IOException -> L10 Throwable -> L32
        if (r9.length != 2) goto L11;
        r5 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r9[0] + "_dev." + r9[1]);     // Catch: IOException -> L10 Throwable -> L32
        goto L11
    }

    public final k c(int r4) {
        q r0 = this.a;
        if (r0 != null) goto L5;
        k r1 = null;
    L13:
        if (r1 != null) goto L15;
        LLog.e("LynxResourceLoader", "lynx resource provider is null, type: " + r4);
    L15:
        return r1;
    L5:
        if (r4 != 7) goto L7;
        String r2 = "DYNAMIC_COMPONENT";
    L11:
        r1 = (k) ((HashMap) r0.e).get(r2);
        goto L13
    L7:
        if (r4 == 9) goto L9;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    L9:
        r2 = "EXTERNAL_JS_SOURCE";
        goto L11
    }

    public final boolean b(long r12, String r14, LynxResourceRequest.LynxResourceType r15) {
        if (this.c.a == null) goto L5;
        boolean r0 = true;
    L6:
        LLog.i("LynxResourceLoader", "Generic template fetcher existed: " + r0);
        if (r0 == true) goto L9;
        return false;
    L9:
        this.c.a.b(new LynxResourceRequest(r14, r15), new l7a.i(new l7a.k(r14, r12, this.f, r15)));
        return true;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(long r17, String r19, int r20) {
        String r6 = null;
        if (r20 != 7) goto L5;
        LynxResourceRequest.LynxResourceType r0 = LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent;
        if (b(r17, r19, r0) == true) goto L140;
        e r4 = this.b;
        l7a.e r5 = new l7a.e(this, r19, r17, r0);
        if (r4.a == null) goto L101;
        TraceEvent.beginSection("Using DynamicComponentFetcher");
        r4.a.loadDynamicComponent(r19, new d(r5));
        TraceEvent.endSection("Using DynamicComponentFetcher");
        boolean r1 = true;
    L102:
        if (r1 == true) goto L141;
        k r7 = c(7);
        if (r7 != null) goto L107;
        boolean r8 = false;
    L108:
        if (r8 == true) goto L142;
        a(r17, null, -1, "No available provider or fetcher.");
        return;
    L142:
        return;
    L107:
        r7.request(new com.lynx.tasm.provider.LynxResourceRequest(r19), new f(this, r19, r17, r0));
        r8 = true;
        goto L108
    L141:
        return;
    L101:
        r1 = false;
        goto L102
    L140:
        return;
    L5:
        if (r20 != 9) goto L7;
        f8a.a r2 = this.d;
        if (r2 == null) goto L85;
        r2.a(new LynxResourceRequest(r19, LynxResourceRequest.LynxResourceType.LynxResourceTypeExternalJSSource), new g(this, r19, r17));
        boolean r3 = true;
    L86:
        if (r3 == true) goto L138;
        k r9 = c(9);
        if (r9 != null) goto L91;
        boolean r10 = false;
    L92:
        if (r10 == true) goto L139;
        a(r17, null, -1, "No available provider or fetcher.");
        return;
    L139:
        return;
    L91:
        r9.request(new com.lynx.tasm.provider.LynxResourceRequest(r19), new h(this, r19, r17));
        r10 = true;
        goto L92
    L138:
        return;
    L85:
        r3 = false;
        goto L86
    L7:
        if (r20 == 11) goto L16;
        if (r20 == 15) goto L12;
        a(r17, null, -1, "Unsupported type" + r20);
        return;
    L12:
        if (b(r17, r19, LynxResourceRequest.LynxResourceType.LynxResourceTypeTemplate) == true) goto L137;
        a(r17, null, -1, "No available provider or fetcher.");
        return;
    L137:
        return;
    L16:
        if (TextUtils.isEmpty(r19) == false) goto L19;
        LLog.w("LynxResourceLoader", "loadJSSource failed with empty name");
    L75:
        byte[] r11 = r6;
    L76:
        a(r17, r11, 0, r6);
        return;
    L19:
        LLog.i("LynxResourceLoader", "loadJSSource with name " + r19);
    L66:
        th = th;
        InputStream r12 = null;
    L119:
        String r13 = th.getMessage();     // Catch: Throwable -> L77
        if (r12 != null) goto L115;
    L73:
        if (r13 == null) goto L75;
        UIThreadUtils.runOnUiThread(new l7a.d(this, 30302, "loadLocalResource", "Error when loading js source", r13, r19));
        LLog.e("LynxResourceLoader", "loadJSSource " + r19 + "with error message: " + r13);
        goto L75
    L115:
        r12.close();     // Catch: IOException -> L72
    L77:
        th = move-exception;
        if (r12 == null) goto L131;
        r12.close();     // Catch: IOException -> L114
        throw th;
    L132:
        throw th;
    L131:
        throw th;
    L21:
        if ("assets://lynx_core.js".equals(r19) == true) goto L23;
    L31:
        r12 = null;
    L32:
        if (r12 == null) goto L34;
    L53:
        if (r12 == null) goto L63;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L58
        byte[] r15 = new byte[4096];     // Catch: Throwable -> L58
    L55:
        int r16 = r12.read(r15);     // Catch: Throwable -> L58
        if (r16 == (-1)) goto L60;
        r14.write(r15, 0, r16);     // Catch: Throwable -> L58
        goto L55
    L60:
        byte[] r18 = r14.toByteArray();     // Catch: Throwable -> L58
    L123:
        r12.close();     // Catch: IOException -> L113
    L62:
        r6 = null;
        r11 = r18;
        goto L76
    L63:
        if (r12 == null) goto L75;
        r12.close();     // Catch: IOException -> L112
        goto L75
    L34:
        if (r19.length() <= 7) goto L43;
        if (r19.startsWith("file://") == false) goto L43;
        String r21 = r19.substring(7);     // Catch: Throwable -> L58
        if (r21.startsWith("/") == false) goto L40;
        PolarisFileWrapper r22 = new PolarisFileWrapper(r21);     // Catch: Throwable -> L58
    L41:
        InputStream r23 = new PolarisFileInputStreamWrapper(r22);     // Catch: Throwable -> L58
    L47:
        r12 = r23;
        goto L53
    L40:
        r22 = new PolarisFileWrapper(LynxEnv.inst().getAppContext().getFilesDir(), r21);     // Catch: Throwable -> L58
    L43:
        if (r19.length() <= 9) goto L49;
        if (r19.startsWith("assets://") == false) goto L49;
        r23 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r19.substring(9));     // Catch: Throwable -> L58
    L49:
        if (r19.startsWith("lynx_assets://") == false) goto L53;
        r18 = d(r19);     // Catch: Throwable -> L58
        if (r12 == null) goto L62;
    L23:
        if (LynxEnv.inst().isDevtoolEnabled() == false) goto L31;
        r12 = LynxEnv.inst().getAppContext().getResources().getAssets().open("lynx_core_dev.js");     // Catch: IOException -> L26 Throwable -> L66
    L29:
        if (r12 == null) goto L32;
        nativeConfigLynxResourceSetting();     // Catch: Throwable -> L58
    L58:
        th = th;
        goto L119
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        r12 = null;
        goto L29
    }

    public void loadBytecode(long r2, String r4, int r5) {
        if (r5 == 16) goto L5;
        return;
    L5:
        if (this.d == null) goto L8;
        LynxResourceRequest.LynxResourceType r6 = LynxResourceRequest.LynxResourceType.LynxResourceTypeGeneric;
        new b(r4, r2).onResponse(LynxResourceResponse.a(new Throwable("fetchBytecode is not implemented.")));
        return;
    L8:
        a(r2, null, -1, "No available provider or fetcher.");
    }

    public static void a(long r8, byte[] r10, int r11, String r12) {
        nativeInvokeCallback(r8, r10, 0, null, r11, r12);
    }

    private void loadResource(long r8, String r10, int r11, boolean r12) {
        if (r12 == false) goto L9;
        e(r8, r10, r11);
        return;
    L9:
        LynxThreadPool.b().execute(new a(this, r8, r10, r11));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(r8, null, -1, th.getMessage());
    }

    public LynxResourceLoader(q r2, k7a.a r3, i r4, h8a.a r5, f8a.a r6) {
        this.f = new q0();
        this.a = r2;
        this.b = new e(r3);
        this.e = new WeakReference(r4);
        this.c = new j(r5);
        this.d = r6;
    }
}
