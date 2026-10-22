package com.lynx.tasm.core.resource;

import android.text.TextUtils;
import com.google.common.reflect.w;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.fontface.c;
import com.lynx.tasm.g;
import com.lynx.tasm.k;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.utils.j;
import com.lynx.tasm.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import ko.r;
import ln.b;
import mn.i;
import nn.d;
import nn.e;
import nn.f;
import r6.a;
import wn.h;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public class LynxResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f10834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f10835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f10836c;
    public final h d;
    public final WeakReference e;
    public final v f;

    public LynxResourceLoader(k r5, b r10, g r11, dn.a r12, h r13) {
        this.f = new v();
        this.f10834a = r5;
        this.f10835b = new z(r10);
        this.e = new WeakReference(r11);
        this.f10836c = new a(r12);
        this.d = r13;
    }

    public static byte[] d(String r11) {
        String r5 = r11.substring(14);
    L10:
        th = th;
        InputStream r10 = null;
    L55:
        LynxLog.b(4, "LynxResourceLoader", "loadLynxJSAsset " + r11 + "with error message " + th.getMessage());     // Catch: Throwable -> L42
        if (r10 != null) goto L61;
    L40:
        LynxLog.b(4, "LynxResourceLoader", "loadLynxJSAsset failed, can not load ".concat(r11));
        return null;
    L61:
        r10.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        String r12 = "loadLynxJSAsset inputStream close error: " + e.getMessage();
    L39:
        LynxLog.b(4, "LynxResourceLoader", r12);
    L42:
        th = move-exception;
        if (r10 != null) goto L57;
    L48:
        throw th;
    L57:
        r10.close();     // Catch: IOException -> L46
    L46:
        e = move-exception;
        LynxLog.b(4, "LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
        goto L48
    L5:
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L54;
    L12:
        r10 = null;
    L13:
        if (r10 == null) goto L59;
    L17:
        if (r10 == null) goto L28;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Throwable -> L15
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L15
    L19:
        int r15 = r10.read(r14);     // Catch: Throwable -> L15
        if (r15 == (-1)) goto L22;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L15
        goto L19
    L22:
        byte[] r16 = r13.toByteArray();     // Catch: Throwable -> L15
        r10.close();     // Catch: IOException -> L25
    L27:
        return r16;
    L25:
        e = move-exception;
        LynxLog.b(4, "LynxResourceLoader", "loadLynxJSAsset inputStream close error: " + e.getMessage());
    L15:
        th = th;
        goto L55
    L28:
        if (r10 == null) goto L40;
        r10.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        r12 = "loadLynxJSAsset inputStream close error: " + e.getMessage();
        goto L39
    L59:
        r10 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r5);     // Catch: Throwable -> L15
        goto L17
    L54:
        String[] r17 = r5.split("\\.");     // Catch: Throwable -> L10 IOException -> L49
        if (r17.length != 2) goto L12;
        r10 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r17[0] + "_dev." + r17[1]);     // Catch: Throwable -> L10 IOException -> L49
        goto L12
    }

    @CalledByNative
    private void loadResource(long r10, String r11, int r12, boolean r13) {
        if (r13 == false) goto L10;
        b(r12, r11, r10);
        return;
    L10:
        mn.h.i().execute(new d(r12, r10, this, r11));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        nativeInvokeCallback(r10, null, 0, null, -1, th.getMessage());
    }

    private native void nativeConfigLynxResourceSetting();

    public static native void nativeInvokeCallback(long r5, byte[] r10, long r11, ByteBuffer r12, int r13, String r14);

    public final fo.h a(int r5) {
        k r10 = this.f10834a;
        if (r10 != null) goto L5;
        fo.h r11 = null;
    L13:
        if (r11 != null) goto L15;
        LynxLog.b(4, "LynxResourceLoader", "lynx resource provider is null, type: " + r5);
    L15:
        return r11;
    L5:
        if (r5 != 7) goto L7;
        String r12 = "DYNAMIC_COMPONENT";
    L11:
        r11 = (fo.h) r10.e.get(r12);
        goto L13
    L7:
        if (r5 == 9) goto L9;
        r12 = "";
        goto L11
    L9:
        r12 = "EXTERNAL_JS_SOURCE";
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v30, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v21 */
    public final void b(int r16, String r17, long r18) {
        if (r16 == 7) goto L93;
        if (r16 != 9) goto L7;
        h r5 = this.d;
        if (r5 == null) goto L86;
        r5.i(new r(8, r17, LynxResourceRequest$LynxResourceType.f10945h), new i(this, r17, r18));
        return;
    L86:
        fo.h r10 = a(9);
        if (r10 != null) goto L90;
        nativeInvokeCallback(r18, null, 0, null, -1, "No available provider or fetcher.");
        return;
    L90:
        r10.a(new n(r17), new e(1, r18, this, r17));
        return;
    L7:
        if (r16 == 11) goto L18;
        if (r16 == 15) goto L13;
        nativeInvokeCallback(r18, null, 0, null, -1, com.lynx.jsbridge.a.d(r16, "Unsupported type"));
        return;
    L13:
        if (c(r18, r17, LynxResourceRequest$LynxResourceType.f) == true) goto L129;
        nativeInvokeCallback(r18, null, 0, null, -1, "No available provider or fetcher.");
        return;
    L129:
        return;
    L18:
        if (TextUtils.isEmpty(r17) == false) goto L20;
        LynxLog.b(3, "LynxResourceLoader", "loadJSSource failed with empty name");
    L75:
        ?? r11 = 0;
    L76:
        nativeInvokeCallback(r18, r11, 0, null, 0, null);
        return;
    L20:
        LynxLog.b(2, "LynxResourceLoader", "loadJSSource with name " + r17);
        boolean r12 = "assets://lynx_core.js".equals(r17);     // Catch: Throwable -> L27
        ?? r13 = r12;
        if (r12 == false) goto L36;
        boolean r14 = LynxEnv.inst().isDevtoolEnabled();     // Catch: Throwable -> L27
        r13 = r14;
        if (r14 == false) goto L36;
        InputStream r15 = LynxEnv.inst().getAppContext().getResources().getAssets().open("lynx_core_dev.js");     // Catch: Throwable -> L27 IOException -> L29
        InputStream r19 = r15;
        r13 = r15;
    L32:
        if (r19 == null) goto L121;
        nativeConfigLynxResourceSetting();     // Catch: Throwable -> L34
    L34:
        th = th;
        InputStream r20 = r19;
    L111:
        String r21 = th.getMessage();     // Catch: Throwable -> L77
        if (r20 != null) goto L118;
    L73:
        if (r21 == null) goto L75;
        j.a().post(new c(this, 30302, "loadLocalResource", "Error when loading js source", r21, r17));
        LynxLog.b(4, "LynxResourceLoader", "loadJSSource " + r17 + "with error message: " + r21);
        goto L75
    L118:
        r20.close();     // Catch: IOException -> L107
    L77:
        th = move-exception;
        if (r20 == null) goto L126;
        r20.close();     // Catch: IOException -> L108
        throw th;
    L127:
        throw th;
    L126:
        throw th;
    L121:
        if (r19 == null) goto L39;
    L59:
        if (r19 == null) goto L67;
        ByteArrayOutputStream r22 = new ByteArrayOutputStream();     // Catch: Throwable -> L34
        byte[] r23 = new byte[4096];     // Catch: Throwable -> L34
    L61:
        int r24 = r19.read(r23);     // Catch: Throwable -> L34
        if (r24 == (-1)) goto L64;
        r22.write(r23, 0, r24);     // Catch: Throwable -> L34
        goto L61
    L64:
        byte[] r25 = r22.toByteArray();     // Catch: Throwable -> L34
        r19.close();     // Catch: IOException -> L106
        r13 = r25;
    L120:
        goto L58
    L67:
        if (r19 == null) goto L75;
        r19.close();     // Catch: IOException -> L105
        goto L75
    L39:
        if (r17.length() <= 7) goto L49;
        if (r17.startsWith("file://") == false) goto L49;
        String r26 = r17.substring(7);     // Catch: Throwable -> L34
        if (r26.startsWith("/") == false) goto L45;
        File r27 = new File(r26);     // Catch: Throwable -> L34
    L46:
        InputStream r28 = new FileInputStream(r27);     // Catch: Throwable -> L34
    L47:
        r19 = r28;
        goto L59
    L45:
        r27 = new File(LynxEnv.inst().getAppContext().getFilesDir(), r26);     // Catch: Throwable -> L34
    L49:
        if (r17.length() <= 9) goto L54;
        if (r17.startsWith("assets://") == false) goto L54;
        r28 = LynxEnv.inst().getAppContext().getResources().getAssets().open(r17.substring(9));     // Catch: Throwable -> L34
    L54:
        if (r17.startsWith("lynx_assets://") == false) goto L59;
        r13 = d(r17);     // Catch: Throwable -> L34
        if (r19 == null) goto L58;
        r19.close();     // Catch: IOException -> L106
        r13 = r13;
    L58:
        r11 = r13;
        goto L76
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        r19 = null;
        r13 = e;
    L36:
        r19 = null;
    L27:
        th = th;
        r20 = null;
        goto L111
    L93:
        if (c(r18, r17, LynxResourceRequest$LynxResourceType.g) == true) goto L130;
        LynxResourceRequest$LynxResourceType r110 = LynxResourceRequest$LynxResourceType.g;
        k6.a r29 = new k6.a();
        r29.f18623a = new f(r17, r18, this.f, r110);
        b r30 = (b) this.f10835b.f23549a;
        if (r30 == null) goto L99;
        TraceEvent.c("Using DynamicComponentFetcher");
        r30.a(r17, new zm.c(r29, 7));
        TraceEvent.a(0, "Using DynamicComponentFetcher");
        return;
    L99:
        fo.h r31 = a(7);
        if (r31 != null) goto L103;
        nativeInvokeCallback(r18, null, 0, null, -1, "No available provider or fetcher.");
        return;
    L103:
        r31.a(new n(r17), new e(0, r18, this, r17));
        return;
    }

    public final boolean c(long r15, String r17, LynxResourceRequest$LynxResourceType r18) {
        a r5 = this.f10836c;
        if (((dn.a) r5.f21695a) == null) goto L5;
        boolean r10 = true;
    L6:
        LynxLog.b(2, "LynxResourceLoader", "Generic template fetcher existed: " + r10);
        if (r10 == true) goto L9;
        return false;
    L9:
        f r11 = new f(r17, r15, this.f, r18);
        ((dn.a) r5.f21695a).O(new r(8, r17, r18), new android.support.v4.media.c(r11));
        return true;
    L5:
        r10 = false;
        goto L6
    }

    @CalledByNative
    public void loadBytecode(long r10, String r11, int r12) {
        if (r12 == 16) goto L5;
        return;
    L5:
        if (this.d == null) goto L8;
        new jg.k(this, r11, r10).f(w.b(new Throwable("fetchBytecode is not implemented.")));
        return;
    L8:
        nativeInvokeCallback(r10, null, 0, null, -1, "No available provider or fetcher.");
    }
}
