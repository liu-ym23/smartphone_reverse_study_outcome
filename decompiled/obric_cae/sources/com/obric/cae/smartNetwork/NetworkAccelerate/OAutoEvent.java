package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.content.Context;
import android.resourcemanager.IEventsCallBack;
import android.resourcemanager.IRm;
import android.resourcemanager.Rm;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class OAutoEvent {
    private static final int EVENT_SCENE_OAUTO = 12018;
    private static final int REPORTID_EVENT_OAUTO_START = 6;
    private static final int REPORTID_EVENT_OAUTO_VD = 7;
    private static final int SCENE_OAUTO_START = 1;
    private static final int SCENE_OAUTO_STOP = 0;
    private static final int SCENE_OAUTO_VD_HIDE = 0;
    private static final int SCENE_OAUTO_VD_SHOW = 1;
    private static final String TAG = "OAutoEvent";
    private static volatile OAutoEvent sInstance;
    private IEventsCallBack mTestCallBack;

    public static class OAutoSceneInfo {
        public boolean isEnterScene;
        public boolean isOnVD;
        public int paramInt;
        public String paramString;
        public int reportId;
        public int sceneEvent;

        private OAutoSceneInfo() {
        }

        public /* synthetic */ OAutoSceneInfo(AnonymousClass1 r8) {
            this();
        }

        public String toString() {
            return "OAutoSceneInfo[reportId:" + this.reportId + " sceneEvent:" + this.sceneEvent + " paramInt:" + this.paramInt + " paramString:" + this.paramString + " isOnVD:" + this.isOnVD + " isEnterScene:" + this.isEnterScene + "]";
        }
    }

    private OAutoEvent() {
        this.mTestCallBack = null;
    }

    public static OAutoEvent getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(OAutoEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OAutoEvent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OAutoEvent.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void registerOAutoEventCb(final Context r8) {
        CaeLog.i(TAG, "registerOAutoEventCb event= 12018");
        IRm r10 = Rm.getInstance();
        r10.connect();
        IEventsCallBack r11 = new AnonymousClass1(this, r8);
        this.mTestCallBack = r11;
        r10.setEventCallback(EVENT_SCENE_OAUTO, r11);
    }
}
