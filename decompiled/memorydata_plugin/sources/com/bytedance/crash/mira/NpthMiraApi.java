package com.bytedance.crash.mira;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class NpthMiraApi {
    static MiraCallbackImpl sMiraCallbackImpl = null;
    private static boolean sMiraInited = false;
    private static PluginInfoCallback sPluginInfoCallback;

    interface MiraCallbackImpl {
        void setMiraCallbackImpl(MiraPluginEventListener r1);
    }

    public static class MiraPluginEventListener {
        public MiraPluginEventListener() {
        }

        public void onPluginInstallResult(String r1, boolean r2) {
        }

        public void onPluginLoaded(String r1) {
        }
    }

    public interface PluginInfoCallback {
        JSONArray getPluginInfo();
    }

    static {
    }

    public NpthMiraApi() {
    }

    public static JSONArray getPluginInfo() {
        PluginInfoCallback r0 = sPluginInfoCallback;
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.getPluginInfo();
    L11:
        return null;
    }

    public static boolean miraInited() {
        return sMiraInited;
    }

    public static void registerMiraCallback(MiraPluginEventListener r1) {
        MiraCallbackImpl r0 = sMiraCallbackImpl;
        if (r0 == null) goto L9;
        r0.setMiraCallbackImpl(r1);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    static void setMiraCallbackImpl(MiraCallbackImpl r2) {
        sMiraCallbackImpl = (MiraCallbackImpl) ZeusTransformUtils.wrapperContextForParams(r2, MiraCallbackImpl.class, "com.obric.memorydata.plugin");
    }

    public static void setMiraInited() {
        sMiraInited = true;
    }

    public static void setPluginInfoCallback(PluginInfoCallback r2) {
        sPluginInfoCallback = (PluginInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, PluginInfoCallback.class, "com.obric.memorydata.plugin");
    }
}
