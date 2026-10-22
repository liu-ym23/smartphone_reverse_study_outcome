package com.ss.bduploader.util;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.util.k;
import com.ss.bduploader.BDUploadUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes6.dex */
public class BDUrlDispatch {
    private static final String TAG = "ttmn";
    private static final String URL_DISPATCHRESULT_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult";
    private static final String URL_DISPATCH_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher";
    private static final String URL_REQUEST_CLASS_NAME = "com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest";
    private static volatile BDUrlDispatch mInstance;
    public long mDispatchDuration;
    private final ReentrantReadWriteLock mDispatchlock;
    public String mTncTag;

    public BDUrlDispatch() {
        this.mDispatchlock = new ReentrantReadWriteLock();
        this.mDispatchDuration = -1;
        this.mTncTag = null;
    }

    private String doOkHttpDispatchPrivate(String r18, String r19) {
        String r1 = r18;
        Log.d(TAG, "url is " + r1 + ", method:" + r19);
        Class r3 = ZeusTransformUtils.forName(URL_DISPATCH_CLASS_NAME, "com.obric.memorydata.plugin");
        Object r8 = r3.getMethod("inst", new Class[0]).invoke(null, new Object[0]);
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r3.getMethod("isDispatchActionsEmpty", new Class[0]).invoke(r8, new Object[0]), Boolean.class, "com.obric.memorydata.plugin");
        this.mTncTag = (String) ZeusTransformUtils.preCheckCast(r3.getMethod("getTncEtag", new Class[0]).invoke(r8, new Object[0]), String.class, "com.obric.memorydata.plugin");
        Log.d(TAG, "isDispatchActionsEmpty:" + r9 + "getTncEtag:" + this.mTncTag);
        if (r9.booleanValue() == true) goto L18;
        Log.d(TAG, "isDispatchActionsEmpty" + r9);
        long r10 = System.currentTimeMillis();
        Class<?> r11 = ZeusTransformUtils.forName(URL_REQUEST_CLASS_NAME, "com.obric.memorydata.plugin");
        Object r2 = r3.getMethod("getDispatchResultForUrl", new Class[]{r11}).invoke(r8, new Object[]{r11.getConstructor(new Class[]{String.class, String.class}).newInstance(new Object[]{r1, r19})});
        this.mDispatchDuration = System.currentTimeMillis() - r10;
        Log.d(TAG, "dispatchTime:" + this.mDispatchDuration);
        if (r2 == null) goto L23;
        Class r0 = ZeusTransformUtils.forName(URL_DISPATCHRESULT_CLASS_NAME, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r0.getField("mDispatchedURL").get(r2), String.class, "com.obric.memorydata.plugin");
        if (r1.equals(r4) == true) goto L23;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r0.getField("mActionRuleIdList").get(r2), List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L16;
        if (r5.isEmpty() == true) goto L16;
        throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
    L16:
        if (k.b(r4) == false) goto L23;
        r1 = r4;
    L23:
        Log.d(TAG, "url is " + r1);
        return r1;
    L18:
        Log.d(TAG, "fallback to host replace map");
        long r12 = System.currentTimeMillis();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.getMethod("handleHostMapping", new Class[]{String.class}).invoke(r8, new Object[]{r1}), String.class, "com.obric.memorydata.plugin");
        this.mDispatchDuration = System.currentTimeMillis() - r12;
        Log.d(TAG, "dispatchTime:" + this.mDispatchDuration);
        if (r1.equals(r6) == true) goto L23;
        if (k.b(r6) == false) goto L23;
        r1 = r6;
        goto L23
    }

    public static BDUrlDispatch inst() {
        if (mInstance != null) goto L15;
        monitor-enter(BDUrlDispatch.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new BDUrlDispatch();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDUrlDispatch.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public String getDispatchUrl(String r3, String r4) {
        this.mDispatchlock.writeLock().lock();
        this.mDispatchDuration = -1;
        String r5 = doOkHttpDispatchPrivate(r3, r4);     // Catch: Exception -> L5
    L10:
        this.mDispatchlock.writeLock().unlock();
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        Log.d(TAG, e.toString());
        if (BDUploadUtil.urlDispatch == null) goto L9;
        r5 = BDUploadUtil.urlDispatch.doDispatchUrl(r3, r4);
        goto L10
    L9:
        r5 = null;
        goto L10
    }
}
