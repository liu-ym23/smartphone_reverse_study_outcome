package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.res.Configuration;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface Plugin<H extends PluginHost> {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static void $default$onPause(Plugin r0, PluginHost r1) {
        }

        public static void $default$onResume(Plugin r0, PluginHost r1) {
        }

        public static void $default$onStart(Plugin r0, PluginHost r1) {
        }

        public static void $default$onStop(Plugin r0, PluginHost r1) {
        }
    }

    H getHost();

    boolean isViewImmersive();

    void onAttachToHost(H r1);

    void onAttachToUIContainer(H r1, UIContainer r2);

    void onConfigurationChanged(Configuration r1);

    void onDetachFromHost(H r1);

    void onDetachFromUIContainer(H r1, UIContainer r2);

    void onPause(H r1);

    void onResume(H r1);

    void onStart(H r1);

    void onStop(H r1);

    void setUserVisibleHint(boolean r1);
}
