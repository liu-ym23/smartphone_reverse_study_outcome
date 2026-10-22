package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.res.Configuration;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.PluginReport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PluginRuntime {
    private static final String TAG = "PluginRuntime";
    private static volatile PluginRuntime instance;
    private final LinkedHashMap<PluginHost.Delegate, PluginHost> hosts;

    public static PluginRuntime getInstance() {
        if (instance != null) goto L15;
        monitor-enter(PluginRuntime.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new PluginRuntime();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PluginRuntime.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public List<PluginHost> allPluginHost() {
        return new ArrayList(this.hosts.values());
    }

    private PluginRuntime() {
        this.hosts = new LinkedHashMap();
    }

    public void destroyHost(PluginHost.Delegate r3) {
        Log.i(TAG, "destroyHost");
        PluginHost r4 = this.hosts.remove(r3);
        if (r4 == null) goto L6;
        r4.onDestroy();
        return;
    }

    public void dispatchOnPause(PluginHost.Delegate r2) {
        PluginHost r3 = this.hosts.get(r2);
        if (r3 == null) goto L6;
        r3.onDispatchOnPause();
        return;
    }

    public void dispatchOnResume(PluginHost.Delegate r2) {
        PluginHost r3 = this.hosts.get(r2);
        if (r3 == null) goto L6;
        r3.onDispatchOnResume();
        return;
    }

    public void dispatchOnStart(PluginHost.Delegate r2) {
        PluginHost r3 = this.hosts.get(r2);
        if (r3 == null) goto L6;
        r3.onDispatchOnStart();
        return;
    }

    public void dispatchOnStop(PluginHost.Delegate r2) {
        PluginHost r3 = this.hosts.get(r2);
        if (r3 == null) goto L6;
        r3.onDispatchOnStop();
        return;
    }

    private PluginHost newPluginHost(PluginHost.Factory r2, PluginHost.Delegate r3) {
        if (r2 == null) goto L4;
        PluginHost r4 = r2.createPluginHost();
    L5:
        this.hosts.put(r3, r4);
        return r4;
    L4:
        r4 = new PluginHost();
        goto L5
    }

    private PluginList preparePluginList(PluginHost r1, PluginListProvider r2) {
        if (r2 == null) goto L4;
        PluginList r3 = r2.getPluginList(r1);
    L5:
        if (r3 == null) goto L7;
        return r3;
    L7:
        return PluginList.newList(new PluginList.Metadata[0]);
    L4:
        r3 = null;
        goto L5
    }

    public PluginHost createHost(PluginHost.Factory r3, PluginHost.Delegate r4) {
        Log.i(TAG, "createHost");
        PluginHost r5 = newPluginHost(r3, r4);
        r5.onCreate(r4);
        PluginList r6 = preparePluginList(r5, r4.getPluginListProvider());
        PluginReport.mNewPluginList = System.currentTimeMillis();
        r5.addPlugins(r6);
        PluginReport.mAttchPluginList = System.currentTimeMillis();
        return r5;
    }

    public void dispatchConfigurationChanged(PluginHost.Delegate r2, Configuration r3) {
        PluginHost r4 = this.hosts.get(r2);
        if (r4 == null) goto L6;
        r4.onDispatchConfigurationChanged(r3);
        return;
    }

    public void dispatchUIAttach(PluginHost.Delegate r2, UIContainer r3) {
        PluginHost r4 = this.hosts.get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.getLayoutStrategy() != null) goto L7;
        r3.setLayoutStrategy(new DefaultUILayoutStrategy(r3));
    L7:
        r4.onDispatchUIAttach(r3);
    }

    public void dispatchUIDetach(PluginHost.Delegate r2, UIContainer r3) {
        PluginHost r4 = this.hosts.get(r2);
        if (r4 == null) goto L6;
        r4.onDispatchUIDetach(r3);
        return;
    }

    public void dispatchUserVisibleHint(PluginHost.Delegate r2, boolean r3) {
        PluginHost r4 = this.hosts.get(r2);
        if (r4 == null) goto L6;
        r4.onDispatchUserVisibleHint(r3);
        return;
    }
}
