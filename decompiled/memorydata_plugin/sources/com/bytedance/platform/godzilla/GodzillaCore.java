package com.bytedance.platform.godzilla;

import android.app.Activity;
import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.a;
import com.bytedance.platform.godzilla.common.e;
import com.bytedance.platform.godzilla.common.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final enum GodzillaCore extends Enum<GodzillaCore> {
    private static final /* synthetic */ GodzillaCore[] $VALUES = null;
    private static final int ACTIVITY_STATE_DESTORY = 3;
    private static final int ACTIVITY_STATE_PAUSE = 1;
    private static final int ACTIVITY_STATE_RESUME = 0;
    private static final int ACTIVITY_STATE_STOP = 2;
    public static final GodzillaCore INSTANCE = null;
    private static final String TAG = "UncaughtExceptionPlugin";
    private static HashMap<Integer, WeakReference<Activity>> mActivityMaps;
    private a mConsumeExceptionHandler;
    private WeakReference<Activity> mLastDestoryActivity;
    private WeakReference<Activity> mLastPauseActivity;
    private WeakReference<Activity> mLastResumedActivity;
    private WeakReference<Activity> mLastStopActivity;

    static {
        GodzillaCore r0 = new GodzillaCore("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new GodzillaCore[]{r0};
        mActivityMaps = new HashMap();
    }

    private GodzillaCore(String r1, int r2) {
        super(r1, r2);
        this.mLastResumedActivity = null;
        this.mLastPauseActivity = null;
        this.mLastStopActivity = null;
        this.mLastDestoryActivity = null;
        this.mConsumeExceptionHandler = null;
    }

    private void registerExceptionHandlerIfNeed() {
        if (this.mConsumeExceptionHandler != null) goto L5;
        a r0 = new a();
        this.mConsumeExceptionHandler = r0;
        r0.b();
    L5:
        Logger.a(TAG, "init mConsumeExceptionHandler:" + this.mConsumeExceptionHandler);
    }

    public static GodzillaCore valueOf(String r2) {
        return (GodzillaCore) ZeusTransformUtils.preCheckCast(Enum.valueOf(GodzillaCore.class, r2), GodzillaCore.class, "com.obric.memorydata.plugin");
    }

    public static GodzillaCore[] values() {
        return (GodzillaCore[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GodzillaCore[].class, "com.obric.memorydata.plugin");
    }

    public void addUncaughtExceptionConsumer(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        registerExceptionHandlerIfNeed();
        Logger.a(TAG, "add consumer:" + r4);
        this.mConsumeExceptionHandler.a(r4);
    }

    public void destroy() {
        a r0 = this.mConsumeExceptionHandler;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void init(Application r2, e r3, Logger.Level r4) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        Logger.a(r5);
    L5:
        if (r4 == null) goto L8;
        Logger.a(r4);
        return;
    }

    public void removeUncaughtExceptionConsumer(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Logger.a(TAG, "remove consumer:" + r4);
        this.mConsumeExceptionHandler.b(r4);
    }
}
