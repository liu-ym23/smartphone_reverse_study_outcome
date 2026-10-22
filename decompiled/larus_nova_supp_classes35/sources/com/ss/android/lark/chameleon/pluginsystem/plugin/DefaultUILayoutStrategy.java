package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DefaultUILayoutStrategy implements UIContainer.LayoutStrategy {
    private static final String TAG_ALL_PLUGINS_ROOT = "AllPluginsRoot";
    private final String TAG;
    private PluginList allPlugins;
    private ViewGroup allPluginsRoot;
    private final UIContainer uiContainer;

    public static /* synthetic */ int a(Map r0, Plugin r1, Plugin r2) {
        return lambda$ensureContainerWithLevel$0(r0, r1, r2);
    }

    private void ensureAllPluginsRoot() {
        ViewGroup r0 = (ViewGroup) this.uiContainer.findView(2131382479);
        this.allPluginsRoot = r0;
        if (r0 == null) goto L7;
        r0.setTag(TAG_ALL_PLUGINS_ROOT);
        return;
    L7:
        throw new IllegalStateException("All plugins root not found ! [find by id: R.id.pluginUIContainer]");
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public UIState saveUIState() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.allPluginsRoot.getChildCount()) goto L10;
        View r2 = this.allPluginsRoot.getChildAt(r1);
        if (r2.getTag(2131382479) == null) goto L8;
        r0.add(new Pair(r2.getTag(), Integer.valueOf(r2.getId())));
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return new UIState(r0);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public ViewGroup getAllPluginsContainer() {
        return this.allPluginsRoot;
    }

    public DefaultUILayoutStrategy(UIContainer r3) {
        this.TAG = "LayoutStrategy#" + Integer.toHexString(hashCode());
        this.uiContainer = r3;
    }

    private void ensureContainerWithLevel(PluginList r7) {
        ArrayList r0 = new ArrayList();
        final HashMap r1 = new HashMap();
        Iterator<Map.Entry<Plugin, PluginList.Metadata>> r8 = r7.metadataMap().entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry<Plugin, PluginList.Metadata> r2 = r8.next();
        Plugin r3 = r2.getKey();
        PluginList.Metadata r4 = r2.getValue();
        if (r4.pluginContainerLevel == Integer.MIN_VALUE) goto L4;
        r0.add(r3);
        r1.put(r3, Integer.valueOf(r4.pluginContainerLevel));
        goto L4
    L8:
        Collections.sort(r0, new a(r1));
        int r9 = 0;
    L10:
        if (r9 >= r0.size()) goto L12;
        Plugin r5 = (Plugin) ListProtector.get(r0, r9);
        ensurePluginContainer(r5.getClass().getName(), getPluginContainerViewId(r5));
        r9 = r9 + 1;
        goto L10
    }

    private PluginList.Metadata findPluginMeta(Plugin<?> r5) {
        PluginList r0 = this.allPlugins;
        if (r0 == null) goto L5;
        PluginList.Metadata r1 = r0.findPluginMetadata(r5);
    L6:
        if (r1 != null) goto L8;
        Log.w(this.TAG, "Plugin metadata not found:" + r5);
    L8:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    private View findViewWithTag(String r2) {
        if (TAG_ALL_PLUGINS_ROOT.equals(r2) == false) goto L7;
        return this.allPluginsRoot;
    L7:
        return this.uiContainer.findView(r2);
    }

    private String getPluginContainerTag(Plugin r3) {
        String r0 = r3.getClass().getName();
        if (this.allPluginsRoot.findViewWithTag(r0) == null) goto L5;
        return r0;
    L5:
        PluginList.Metadata r4 = findPluginMeta(r3);
        if (r4 != null) goto L8;
        return TAG_ALL_PLUGINS_ROOT;
    L8:
        if (r4.pluginContainerLevel == Integer.MIN_VALUE) goto L12;
        return r0;
    L12:
        return TAG_ALL_PLUGINS_ROOT;
    }

    private int getPluginContainerViewId(Plugin r2) {
        View r3 = this.allPluginsRoot.findViewWithTag(r2.getClass().getName());
        if (r3 == null) goto L7;
        return r3.getId();
    L7:
        return View.generateViewId();
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public void restoreUIState(UIState r3) {
        ensureAllPluginsRoot();
        if (r3 == null) goto L8;
        Iterator<Pair<Object, Integer>> r4 = r3.pluginLevels.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Pair<Object, Integer> r0 = r4.next();
        ensurePluginContainer(r0.first, ((Integer) r0.second).intValue());
        goto L6
    L10:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public void updateLayoutStrategy(PluginList r1) {
        this.allPlugins = r1;
        ensureAllPluginsRoot();
        ensureContainerWithLevel(r1);
    }

    private void ensurePluginContainer(Object r3, int r4) {
        if (this.allPluginsRoot.findViewWithTag(r3) == null) goto L5;
        return;
    L5:
        NoConsumeInsetsFrameLayout r0 = new NoConsumeInsetsFrameLayout(this.uiContainer.getContext());
        r0.setTag(r3);
        r0.setTag(2131382479, r3);
        r0.setId(r4);
        this.allPluginsRoot.addView(r0, -1, -1);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer.LayoutStrategy
    public ViewGroup getPluginContainer(UIContainer r1, Plugin r2) {
        View r3 = findViewWithTag(getPluginContainerTag(r2));
        if (r3 != null) goto L7;
        IllegalStateException r4 = new IllegalStateException(r2.toString());
        Log.e(this.TAG, r4.toString());
        return this.allPluginsRoot;
    L7:
        return (ViewGroup) r3;
    }

    private static /* synthetic */ int lambda$ensureContainerWithLevel$0(Map r0, Plugin r1, Plugin r2) {
        return ((Integer) r0.get(r1)).compareTo((Integer) r0.get(r2));
    }
}
