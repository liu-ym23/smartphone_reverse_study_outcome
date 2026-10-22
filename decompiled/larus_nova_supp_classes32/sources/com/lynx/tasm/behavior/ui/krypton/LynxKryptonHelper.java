package com.lynx.tasm.behavior.ui.krypton;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.c;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonHelper {
    private static final String TAG = "LynxKryptonHelper";
    private LynxKryptonAudioFrameCallback mAudioDownstreamCallback;
    private LynxKryptonAudioDownstreamMode mAudioDownstreamMode;
    private final c mBehaviorRegistry;
    private final LinkedHashMap<Class<?>, Object> mCachedServiceMap;
    private CanvasRuntimeMediator mRuntimeMediator;
    private String mTemporaryDirectory;

    public void deInit() {
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L5;
        r0.deInit();
    L5:
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    }

    public ICanvasManager getCanvasManager() {
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCanvasManager();
    }

    public void setupCanvasIfCanvasViewCreated() {
        LLog.i(TAG, "[Krypton] Setup canvas environment if introduce canvas tag in app.");
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L6;
        r0.setupCanvasFromUI();
        return;
    }

    public void setupCanvasIfEnableCanvas() {
        LLog.i(TAG, "[Krypton] Setup canvas environment when specify enable_canvas in schema.");
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L6;
        r0.setupCanvasFromUI();
        this.mRuntimeMediator.registerCanvasBehavior(this.mBehaviorRegistry);
        return;
    }

    public LynxKryptonHelper(c r2) {
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        this.mCachedServiceMap = new LinkedHashMap();
        this.mBehaviorRegistry = r2;
    }

    public void onTemplateLoad(String r2) {
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L6;
        r0.onTemplateLoad(r2);
        return;
    }

    public void registerCanvasRuntimeMediator(CanvasRuntimeMediator r4) {
        LLog.i(TAG, "[Krypton] Register new CanvasRuntimeMediator." + r4);
        this.mRuntimeMediator = r4;
        String r0 = this.mTemporaryDirectory;
        if (r0 == null) goto L5;
        r4.setTemporaryDirectory(r0);
    L5:
        Iterator<Map.Entry<Class<?>, Object>> r5 = this.mCachedServiceMap.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<Class<?>, Object> r1 = r5.next();
        this.mRuntimeMediator.registerService(r1.getKey(), r1.getValue());
        goto L7
    L9:
        LynxKryptonAudioFrameCallback r6 = this.mAudioDownstreamCallback;
        if (r6 == null) goto L14;
        this.mRuntimeMediator.setAudioDownstreamCallback(r6, this.mAudioDownstreamMode);
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        return;
    }

    public void setRenderFrameCallback(RenderFrameCallback r2) {
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L9;
        ICanvasManager r1 = r0.getCanvasManager();
        if (r1 == null) goto L7;
        r1.setRenderFrameCallback(r2);
        return;
    L7:
        LLog.w(TAG, "do not support set render frame callback when canvas manager is null(only be lazy init mode)");
        return;
    }

    public void setTemporaryDirectory(String r2) {
        this.mTemporaryDirectory = r2;
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L6;
        r0.setTemporaryDirectory(r2);
        return;
    }

    public void registerService(Class<?> r2, Object r3) {
        if (r3 != null) goto L5;
        LLog.w(TAG, "do not support unregister service or register null service");
        return;
    L5:
        this.mCachedServiceMap.put(r2, r3);
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 == null) goto L9;
        r0.registerService(r2, r3);
        return;
    }

    public void setAudioDownstreamCallback(LynxKryptonAudioFrameCallback r3, LynxKryptonAudioDownstreamMode r4) {
        if (r4 != null) goto L4;
        r4 = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    L4:
        CanvasRuntimeMediator r0 = this.mRuntimeMediator;
        if (r0 != null) goto L8;
        this.mAudioDownstreamCallback = r3;
        this.mAudioDownstreamMode = r4;
        return;
    L8:
        this.mAudioDownstreamCallback = null;
        r0.setAudioDownstreamCallback(r3, r4);
    }
}
