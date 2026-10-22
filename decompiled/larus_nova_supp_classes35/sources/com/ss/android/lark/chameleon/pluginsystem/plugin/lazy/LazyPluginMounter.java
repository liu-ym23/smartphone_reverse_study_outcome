package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LazyPluginMounter extends DefaultPluginMounter {
    private static final String TAG = "LazyPluginMounter";
    private boolean loadFinish;
    private final Map<String, Plugin<?>> pluginJSMap;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.LazyPluginMounter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy = null;

        static {
            int[] r0 = new int[PluginMountStrategy.values().length];
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy = r0;
            r0[PluginMountStrategy.Immediate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.FirstFind.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.FirstJSCall.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[PluginMountStrategy.LoadFinish.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static /* synthetic */ void b(LazyPluginMounter r0) {
        r0.lambda$syncMountPluginsByLoadFinish$0();
    }

    private /* synthetic */ void lambda$syncMountPluginsByLoadFinish$0() {
        mountPlugins(this.allPlugins);
    }

    public void syncMountPluginsByLoadFinish() {
        Log.i(TAG, "syncMountPluginsByLoadFinish");
        this.loadFinish = true;
        MainLooper.runOnMainThread(new b(this));
    }

    public LazyPluginMounter(PluginHost r1) {
        super(r1);
        this.pluginJSMap = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter
    public Map<String, BridgeHandlerV2<?>> onBindPluginBridgeHandlers(PluginList.Metadata r2) {
        Map<String, BridgeHandlerV2<?>> r0 = super.onBindPluginBridgeHandlers(r2);
        registerJSPlugin(r2, r0);
        return r0;
    }

    public void syncMountWebPluginByJSMsg(String r3) {
        Plugin<?> r4 = this.pluginJSMap.remove(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.pluginHost.isPluginAttached(r4) == true) goto L9;
        Log.i(TAG, "Mount plugin by js msg:" + r4);
        syncAttachPlugin(r4);
        return;
    }

    private void registerJSPlugin(PluginList.Metadata r4, Map<String, BridgeHandlerV2<?>> r5) {
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = r6.next();
        this.pluginJSMap.put(r0, r4.plugin);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter
    public void onMountPlugin(PluginList.Metadata r3, Map<String, BridgeHandlerV2<?>> r4) {
        PluginMountStrategy r0 = r3.mountStrategy;
        if (r0 != null) goto L5;
        r0 = PluginMountStrategy.Immediate;
    L5:
        int r1 = AnonymousClass1.$SwitchMap$com$ss$android$lark$chameleon$pluginsystem$plugin$lazy$PluginMountStrategy[r0.ordinal()];
        if (r1 != 1) goto L8;
        super.onMountPlugin(r3, r4);
        return;
    L8:
        if (r1 != 2) goto L10;
        registerJSPlugin(r3, r4);
        return;
    L10:
        if (r1 != 3) goto L12;
        registerJSPlugin(r3, r4);
        if (r4.isEmpty() == false) goto L26;
        Log.w(TAG, "Plugin lazy mount with FirstJSCall , but no js handler . Mount it now !" + r3.plugin);
        super.onMountPlugin(r3, r4);
        return;
    L26:
        return;
    L12:
        if (r1 == 4) goto L15;
        return;
    L15:
        if (this.loadFinish == false) goto L17;
        super.onMountPlugin(r3, r4);
        return;
    L17:
        registerJSPlugin(r3, r4);
    }
}
