package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.BridgeHolder;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.AbilityProvider;
import com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DefaultPluginMounter implements PluginMounter {
    private static final String TAG = "DefaultPluginMounter";
    private final Map<PluginHostAbility, Plugin<?>> abilityPluginMap;
    protected PluginList allPlugins;
    private final Map<PluginList.Metadata, Map<String, BridgeHandlerV2<?>>> boundHandlers;
    protected final PluginHost pluginHost;

    public static /* synthetic */ void a(DefaultPluginMounter r0, Plugin r1, CountDownLatch r2) {
        r0.lambda$syncAttachPlugin$0(r1, r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void release() {
        Log.i(TAG, "release");
    }

    public DefaultPluginMounter(PluginHost r2) {
        this.boundHandlers = new HashMap();
        this.abilityPluginMap = new ConcurrentHashMap();
        this.pluginHost = r2;
    }

    public void attachPlugin(Plugin<?> r2) {
        if (this.pluginHost.isDestroyed() == false) goto L6;
        Log.e(TAG, "mountPlugin while plugin host destroyed !");
        return;
    L6:
        this.pluginHost.attachPlugin(r2);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public final void mountPlugins(PluginList r5) {
        this.allPlugins = r5;
        List<PluginList.Metadata> r6 = r5.getPluginMetadata(true);
        Log.i(TAG, "mountPlugins size:" + r6.size());
        Iterator<PluginList.Metadata> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Plugin r1 = r0.next().plugin;
        if ((r1 instanceof BasePlugin) == false) goto L4;
        ((BasePlugin) r1).setHost(this.pluginHost);
        goto L4
    L8:
        Iterator<PluginList.Metadata> r2 = r6.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        PluginList.Metadata r3 = r2.next();
        if (this.boundHandlers.containsKey(r3) == true) goto L10;
        this.boundHandlers.put(r3, onBindPluginBridgeHandlers(r3));
        goto L10
    L15:
        Iterator<PluginList.Metadata> r4 = r6.iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        onBindPluginAbilities(r4.next());
        goto L17
    L19:
        Iterator<PluginList.Metadata> r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        PluginList.Metadata r8 = r7.next();
        if (this.pluginHost.isPluginAttached(r8.plugin) == true) goto L21;
        onMountPlugin(r8, this.boundHandlers.get(r8));
        goto L21
    }

    public void onBindPluginAbilities(PluginList.Metadata r4) {
        Plugin<?> r5 = r4.plugin;
        if ((r5 instanceof AbilityProvider) == false) goto L8;
        Iterator<PluginHostAbility> r0 = ((AbilityProvider) r5).getAbilities().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        PluginHostAbility r1 = r0.next();
        this.pluginHost.registerHostAbility(r1);
        this.abilityPluginMap.put(r1, r5);
        goto L6
    L10:
        return;
    }

    public Map<String, BridgeHandlerV2<?>> onBindPluginBridgeHandlers(PluginList.Metadata r6) {
        Plugin r7 = r6.plugin;
        HashMap r0 = new HashMap();
        PluginHost r1 = this.pluginHost;
        if ((r1 instanceof WebPluginHost) == true) goto L5;
    L10:
        BridgeHolder r2 = (BridgeHolder) r1.getHostAbilityOrNull(BridgeHolder.class);
        if (r2 != null) goto L13;
    L18:
        return r0;
    L13:
        if ((r7 instanceof BridgeInteractivePlugin) == false) goto L18;
        ((BridgeInteractivePlugin) r7).getBridgeHandlers(r0);
        Iterator r8 = r0.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r8.next();
        r2.getBridge().bindBridgeHandler((String) r3.getKey(), (BridgeHandlerV2) r3.getValue());
        goto L16
    L5:
        if ((r7 instanceof BridgeInteractivePlugin) == false) goto L10;
        ((BridgeInteractivePlugin) r7).getBridgeHandlers(r0);
        Web r9 = ((WebPluginHost) this.pluginHost).getWeb();
        Iterator r4 = r0.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r4.next();
        r9.bindJSHandler((String) r5.getKey(), (BridgeHandlerV2) r5.getValue());
        goto L8
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void onFindAbility(PluginHostAbility r4) {
        Plugin<?> r0 = this.abilityPluginMap.remove(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.pluginHost.isPluginAttached(r0) == true) goto L9;
        Log.i(TAG, "Mount plugin by findAbility, ability: " + r4 + ", plugin: " + r0);
        syncAttachPlugin(r0);
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter
    public void onFindPlugin(Plugin<?> r3) {
        if (this.pluginHost.isPluginAttached(r3) == true) goto L6;
        Log.i(TAG, "Mount plugin by findPlugin:" + r3);
        syncAttachPlugin(r3);
        return;
    }

    public void syncAttachPlugin(final Plugin<?> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.pluginHost.isPluginAttached(r5) == false) goto L7;
        return;
    L7:
        if (MainLooper.isRunningInMainThread() == false) goto L10;
        attachPlugin(r5);
        return;
    L10:
        Log.w(TAG, "Sync wait plugin mount:" + r5);
        final CountDownLatch r0 = new CountDownLatch(1);
        MainLooper.runOnMainThread(new a(this, r5, r0));
        r0.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L13
        return;
    L13:
        e = move-exception;
        Log.w(TAG, e.toString());
    }

    private /* synthetic */ void lambda$syncAttachPlugin$0(Plugin r1, CountDownLatch r2) {
        attachPlugin(r1);     // Catch: Throwable -> L5
        r2.countDown();
        return;
    L5:
        th = move-exception;
        r2.countDown();
        throw th;
    }

    public void onMountPlugin(PluginList.Metadata r1, Map<String, BridgeHandlerV2<?>> r2) {
        attachPlugin(r1.plugin);
    }
}
