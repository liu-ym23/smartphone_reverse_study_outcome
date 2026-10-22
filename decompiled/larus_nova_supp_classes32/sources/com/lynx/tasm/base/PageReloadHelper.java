package com.lynx.tasm.base;

import android.text.TextUtils;
import android.util.Base64;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import z6a.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PageReloadHelper {
    private static final String TAG = "PageReloadHelper";
    private ByteBuffer mFragmentsBuffer;
    private boolean mIgnoreCache;
    private b mInitBinaryData;
    private a mInitBundleData;
    private TemplateData mInitGlobalProps;
    private TemplateData mInitTemplateData;
    private c mInitUrlData;
    private boolean mInitWithBinary;
    private boolean mInitWithBundle;
    private boolean mInitWithUrl;
    private WeakReference<LynxView> mLynxView;
    private String mUrl;

    public class a {
        public TemplateBundle a;

        public a() {
            this.a = null;
        }
    }

    public class b {
        public byte[] a;

        public b() {
            this.a = null;
        }
    }

    public class c {
        public byte[] a;
        public String b;

        public c() {
            this.a = null;
            this.b = null;
        }
    }

    public void clearCache() {
        v.a.a.a.evictAll();
    }

    public long getTemplateDataPtr() {
        TemplateData r0 = this.mInitTemplateData;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getNativePtr();
    }

    public String getURL() {
        return this.mUrl;
    }

    public PageReloadHelper(LynxView r3) {
        this.mInitTemplateData = TemplateData.fromMap(new HashMap());
        this.mInitGlobalProps = null;
        this.mLynxView = new WeakReference(r3);
        this.mUrl = null;
        this.mInitWithBinary = false;
        this.mInitWithUrl = false;
        this.mInitWithBundle = false;
        this.mInitBinaryData = new b();
        this.mInitBundleData = new a();
        this.mInitUrlData = new c();
        this.mFragmentsBuffer = null;
        this.mIgnoreCache = false;
    }

    private void resetInitTemplateData(TemplateData r1) {
        this.mInitTemplateData = r1;
    }

    private void updateInitTemplateData(TemplateData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mInitTemplateData.updateWithTemplateData(r2.deepClone());
    }

    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
    }

    public void navigate(String r3) {
        this.mInitWithBinary = false;
        this.mInitWithBundle = false;
        this.mInitWithUrl = true;
        this.mInitUrlData.b = r3;
        this.mInitTemplateData = TemplateData.fromString(NameKeys.UnloadStrategy_No_Strategy);
        LynxView r4 = this.mLynxView.get();
        if (r4 != null) goto L5;
        return;
    L5:
        r4.renderTemplateUrl(this.mInitUrlData.b, this.mInitTemplateData);
    }

    public void onGlobalPropsUpdated(TemplateData r1) {
        this.mInitGlobalProps = r1;
    }

    public void onTemplateDataReset(TemplateData r1) {
        resetInitTemplateData(r1);
    }

    public void onTemplateDataUpdated(TemplateData r1) {
        updateInitTemplateData(r1);
    }

    public void onTemplateLoadSuccess(byte[] r2) {
        this.mInitUrlData.a = r2;
    }

    public void reload(boolean r2) {
        reload(r2, null);
    }

    private void reload(boolean r9, byte[] r10) {
        if (r9 == false) goto L4;
        clearCache();
    L4:
        LynxView r11 = this.mLynxView.get();
        if (r11 != null) goto L7;
        return;
    L7:
        TemplateBundle r3 = null;
        if (this.mInitWithBinary == false) goto L17;
        if (TextUtils.isEmpty(this.mUrl) == false) goto L12;
    L13:
        if (r10 != null) goto L15;
        r10 = this.mInitBinaryData.a;
        LLog.w(TAG, "Reloading lynx view with the old template binary data, the code changes may not take effect.");
    L15:
        String r0 = this.mUrl;
    L32:
        if (TextUtils.isEmpty(r0) == false) goto L34;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L34:
        if (r10 == null) goto L36;
        r11.renderTemplateWithBaseUrl(r10, this.mInitTemplateData, r0);
        return;
    L36:
        if (r3 == null) goto L38;
        r11.renderTemplateBundle(r3, this.mInitTemplateData, r0);
        return;
    L38:
        if (r0 == null) goto L40;
        r11.renderTemplateUrl(r0, this.mInitTemplateData);
        return;
    L40:
        LLog.w(TAG, "Failed to reload, the lynx view may not have been loaded before.");
        return;
    L12:
        if (this.mUrl.startsWith("http") == true) goto L15;
    L17:
        if (this.mInitWithBundle == true) goto L19;
        r0 = this.mInitUrlData.b;
        if (r0 == null) goto L32;
        long r4 = System.currentTimeMillis();
        int r6 = r0.lastIndexOf("?");
        if (r6 == (-1)) goto L29;
        String r1 = r0.substring(0, r6 + 1);
    L30:
        r0 = r1 + String.valueOf(r4);
        goto L32
    L29:
        r1 = r0.concat("?");
        goto L30
    L19:
        if (TextUtils.isEmpty(this.mUrl) == false) goto L21;
    L22:
        r3 = this.mInitBundleData.a;
        LLog.w(TAG, "Reloading lynx view with the old template bundle data, the code changes may not take effect.");
    L23:
        r0 = this.mUrl;
        goto L32
    L21:
        if (this.mUrl.startsWith("http") == true) goto L23;
        goto L22
    }

    public String getTemplateJsInfo(int r4, int r5) {
        if (this.mInitWithBinary == false) goto L6;
        byte[] r0 = this.mInitBinaryData.a;
    L9:
        if (r0 != null) goto L11;
        return NameKeys.UnloadStrategy_No_Strategy;
    L11:
        if (r4 >= r0.length) goto L19;
        int r1 = r0.length;
        if ((r4 + r5) <= r1) goto L16;
        r5 = r1 - r4;
    L16:
        return Base64.encodeToString(r0, r4, r5, 0);
    L19:
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (this.mInitWithUrl == false) goto L8;
        r0 = this.mInitUrlData.a;
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public void loadFromURL(String r3, TemplateData r4) {
        LLog.i(TAG, "loadFromURL:" + r3);
        this.mInitWithBinary = false;
        this.mInitWithBundle = false;
        this.mInitWithUrl = true;
        this.mInitUrlData.b = r3;
        updateInitTemplateData(r4);
        this.mUrl = r3;
    }

    public void onReceiveTemplateFragment(String r4, boolean r5) {
        LLog.i(TAG, "on receive template fragment");
    L15:
        e = move-exception;
        LLog.e(TAG, "Template fragments base64 decode failed:" + e.getMessage());
    L17:
        if (r5 == false) goto L28;
        LLog.i(TAG, "end of template fragments");
        ByteBuffer r6 = this.mFragmentsBuffer;
        if (r6 != null) goto L21;
    L23:
        reload(this.mIgnoreCache, null);
    L24:
        this.mFragmentsBuffer = null;
        return;
    L21:
        if (r6.position() <= 0) goto L23;
        reload(this.mIgnoreCache, this.mFragmentsBuffer.array());
        goto L24
    L28:
        return;
    L4:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        if (this.mFragmentsBuffer == null) goto L17;
        byte[] r7 = Base64.decode(r4, 0);     // Catch: Exception -> L15
        if (r7 == null) goto L17;
        if (r7.length <= 0) goto L17;
        if (this.mFragmentsBuffer.remaining() < r7.length) goto L17;
        this.mFragmentsBuffer.put(r7);     // Catch: Exception -> L15
        goto L17
    }

    public void reloadWithUrl(boolean r3, String r4) {
        LLog.i(TAG, "reloadWithUrl passed by Page.reload CDP msg:" + r4);
        this.mUrl = r4;
        if (r3 == false) goto L5;
        clearCache();
    L5:
        LynxView r5 = this.mLynxView.get();
        if (r5 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        r5.renderTemplateUrl(r4, this.mInitTemplateData);
        return;
    }

    public void loadFromBundle(TemplateBundle r3, TemplateData r4, String r5) {
        LLog.i(TAG, "loadFromBundle:" + r5);
        this.mInitWithBinary = false;
        this.mInitWithUrl = false;
        this.mInitWithBundle = true;
        a r0 = this.mInitBundleData;
        r0.a = r3;
        r0.getClass();
        updateInitTemplateData(r4);
        this.mUrl = r5;
    }

    public void loadFromLocalFile(byte[] r3, TemplateData r4, String r5) {
        LLog.i(TAG, "loadFromLocalFile:" + r5);
        this.mInitWithUrl = false;
        this.mInitWithBundle = false;
        this.mInitWithBinary = true;
        b r0 = this.mInitBinaryData;
        r0.a = r3;
        r0.getClass();
        updateInitTemplateData(r4);
        this.mUrl = r5;
    }

    public void reload(boolean r7, String r8, boolean r9, int r10) {
        reload(r7, r8, r9, r10, null);
    }

    public void saveURL(String r1, TemplateData r2, Map<String, Object> r3, String r4) {
        if (r2 == null) goto L4;
        loadFromURL(r1, r2);
        return;
    L4:
        if (r3 == null) goto L6;
        loadFromURL(r1, TemplateData.fromMap(r3));
        return;
    L6:
        if (r4 == null) goto L8;
        loadFromURL(r1, TemplateData.fromString(r4));
        return;
    L8:
        loadFromURL(r1, null);
    }

    public void reload(boolean r3, String r4, boolean r5, int r6, String r7) {
        if (r7 != null) goto L4;
    L7:
        byte[] r0 = null;
        if (TextUtils.isEmpty(r4) == true) goto L16;
        LLog.i(TAG, "reload with single template binary transferred by usb");
        r0 = Base64.decode(r4, 0);     // Catch: IllegalArgumentException -> L12
    L14:
        reload(r3, r0);
        return;
    L12:
        e = move-exception;
        LLog.e(TAG, "Template base64 decode failed:" + e.getMessage());
        goto L14
    L16:
        if (r5 == false) goto L20;
        if (r6 <= 0) goto L20;
        LLog.i(TAG, "reload with template fragments transferred by usb");
        this.mFragmentsBuffer = ByteBuffer.allocate(r6);
        this.mIgnoreCache = r3;
        return;
    L20:
        reload(r3, null);
        return;
    L4:
        if (r7.startsWith("http") == false) goto L7;
        reloadWithUrl(r3, r7);
    }
}
