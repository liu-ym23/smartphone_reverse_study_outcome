package com.ss.android.lark.guidemgr.manis;

import android.app.Application;
import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.guidemgr.engine.GuideManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@RemoteServiceImpl(service = IGuideMgrProxy.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/guidemgr/manis/GuideMgrProxyImpl;", "Lcom/ss/android/lark/guidemgr/manis/IGuideMgrProxy;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "guideChangeListeners", "", "Lcom/ss/android/lark/guidemgr/manis/IGuideMgrProxy$OnGuideChangeListener;", "report", "", "guideKey", "", "fetchFromMainProcess", "", "registerOnGuideChangeListener", "listener", "onGuideChanged", "guideListString", "Companion", "guide-mgr_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class GuideMgrProxyImpl implements IGuideMgrProxy {
    public static final a Companion = null;
    private static final String TAG = "GuideMgrProxyImpl";
    private final Context context;
    private final List<IGuideMgrProxy.a> guideChangeListeners;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void fetchFromMainProcess() {
        final GuideManager r0 = GuideManager.a.a;     // Catch: Exception -> L9
        r0.getClass();     // Catch: Exception -> L9
        Application r1 = LarkContext.getApplication();     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return;
    L6:
        if (z.e(r1) == false) goto L15;
        Log.i("GuideManager", "fetchFromMainProcess");     // Catch: Exception -> L9
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.ss.android.lark.guidemgr.engine.a(r0));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "Failed to fetchFromMainProcess", e);
    }

    public final Context getContext() {
        return this.context;
    }

    public GuideMgrProxyImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.guideChangeListeners = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void onGuideChanged(String r3) {
        Intrinsics.checkNotNullParameter(r3, "guideListString");
        Iterator<T> r0 = this.guideChangeListeners.iterator();     // Catch: Exception -> L8
    L5:
        if (r0.hasNext() == false) goto L15;
        ((IGuideMgrProxy.a) r0.next()).onGuideChanged(r3);     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to onGuideChanged", e);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void registerOnGuideChangeListener(IGuideMgrProxy.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.guideChangeListeners.add(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to registerOnGuideChangeListener", e);
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public boolean report(String r4) {
        return GuideManager.a.a.a(r4);
    L4:
        e = move-exception;
        Log.e(TAG, "Failed to report for key:" + r4, e);
        return false;
    }
}
