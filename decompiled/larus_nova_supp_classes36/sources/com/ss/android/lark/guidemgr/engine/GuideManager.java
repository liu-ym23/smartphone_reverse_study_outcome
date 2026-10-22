package com.ss.android.lark.guidemgr.engine;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.guidemgr.engine.service.GuideMgrService;
import com.ss.android.lark.guidemgr.manis.IGuideMgrProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class GuideManager {
    public final Map<String, xjb.b> a;
    public final AtomicInteger b;
    public final MutableLiveData<Boolean> c;
    public final Gson d;
    public final IGetDataCallback<List<Pair<xjb.a, List<xjb.b>>>> e;

    public static class a {
        public static final GuideManager a = null;

        static {
            a = new GuideManager();
        }
    }

    public GuideManager() {
        this.a = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.b = new AtomicInteger(-1);
        this.c = new MutableLiveData(Boolean.FALSE);
        new AtomicBoolean(false);
        this.d = new Gson();
        this.e = new AnonymousClass1(this);
    }

    public final boolean a(final String r5) {
        final Application r0 = LarkContext.getApplication();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (z.e(r0) == false) goto L15;
        Log.i("GuideManager", "consumeGuide: " + r5 + " in main process.");
        if (TextUtils.isEmpty(r5) == true) goto L18;
        xjb.b r1 = (xjb.b) ((ConcurrentHashMap) this.a).get(r5);
        if (r1 != null) goto L13;
        Log.i("GuideManager", "consumeGuide: but the guideKey[" + r5 + "] is not in guide");
        return false;
    L13:
        r1.d();
        ArrayList r2 = new ArrayList();
        r2.add(r5);
        GuideMgrService.b.a.b(r2, new AnonymousClass3(this, r5));
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new d(this));
        return true;
    L18:
        return false;
    L15:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new b(this, r5, r0));
        return true;
    }

    public final void b(Map<String, ? extends xjb.b> r4) {
        Application r0 = LarkContext.getApplication();
        if (r0 != null) goto L6;
        return;
    L6:
        if (z.e(r0) == false) goto L16;
        jrc.b.a.a.getClass();
        IGuideMgrProxy r1 = (IGuideMgrProxy) jrc.b.a(r0, IGuideMgrProxy.class);
        if (r1 == null) goto L17;
        r1.onGuideChanged(GsonProtectorUtils.toJson(this.d, r4));     // Catch: NullPointerException -> L11
        return;
    L11:
        e = move-exception;
        Log.w("GuideManager", "Exception in notifyOtherProcess() when calling Gson.toJson()", e);
        return;
    L17:
        return;
    }
}
