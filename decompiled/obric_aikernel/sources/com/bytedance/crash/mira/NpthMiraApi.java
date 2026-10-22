package com.bytedance.crash.mira;

import androidx.annotation.Nullable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class NpthMiraApi {
    static MiraCallbackImpl sMiraCallbackImpl = null;
    private static boolean sMiraInited = false;
    private static PluginInfoCallback sPluginInfoCallback;

    interface MiraCallbackImpl {
        void setMiraCallbackImpl(MiraPluginEventListener r10);
    }

    public static class MiraPluginEventListener {
        public MiraPluginEventListener() {
        }

        public void onPluginInstallResult(String r10, boolean r11) {
        }

        public void onPluginLoaded(String r10) {
        }
    }

    public interface PluginInfoCallback {
        JSONArray getPluginInfo();
    }

    static {
    }

    public NpthMiraApi() {
    }

    @Nullable
    public static JSONArray getPluginInfo() {
        PluginInfoCallback r10 = sPluginInfoCallback;
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getPluginInfo();
    L11:
        return null;
    }

    public static boolean miraInited() {
        return sMiraInited;
    }

    public static void registerMiraCallback(MiraPluginEventListener r10) {
        MiraCallbackImpl r11 = sMiraCallbackImpl;
        if (r11 == null) goto L9;
        r11.setMiraCallbackImpl(r10);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    static void setMiraCallbackImpl(MiraCallbackImpl r10) {
        sMiraCallbackImpl = r10;
    }

    public static void setMiraInited() {
        sMiraInited = true;
    }

    public static void setPluginInfoCallback(PluginInfoCallback r10) {
        sPluginInfoCallback = r10;
    }
}
