package com.ss.android.lark.chameleon.pluginsystem.plugin;

import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMountStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PluginList {
    public static final int LEVEL_MAX_VALUE = Integer.MAX_VALUE;
    public static final int LEVEL_NOT_SET = Integer.MIN_VALUE;
    private static final String TAG = "PluginList";
    static final String TAG_NOT_SET = "Tag#NotSet";
    private List<Plugin> enabledPlugins;
    private final List<Metadata> items;

    public static class Metadata {
        public boolean enable;
        public PluginMountStrategy mountStrategy;
        public Plugin plugin;
        public int pluginContainerLevel;
        public String pluginContainerTag;

        public Metadata() {
            this.enable = true;
            this.pluginContainerTag = PluginList.TAG_NOT_SET;
            this.pluginContainerLevel = PluginList.LEVEL_NOT_SET;
        }

        public Metadata mountWith(PluginMountStrategy r1) {
            this.mountStrategy = r1;
            return this;
        }
    }

    private void initEnabledPlugins() {
        Iterator<Metadata> r0 = this.items.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Metadata r1 = r0.next();
        if (r1.enable == false) goto L4;
        this.enabledPlugins.add(r1.plugin);
        goto L4
    }

    public Map<Plugin, Metadata> metadataMap() {
        HashMap r0 = new HashMap();
        Iterator<Metadata> r1 = this.items.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Metadata r2 = r1.next();
        r0.put(r2.plugin, r2);
        goto L4
    L6:
        return r0;
    }

    private PluginList(Metadata[] r2) {
        this.enabledPlugins = new ArrayList();
        if (r2 != null) goto L5;
        List<Metadata> r3 = Collections.emptyList();
    L6:
        this.items = r3;
        initEnabledPlugins();
        return;
    L5:
        r3 = new ArrayList(Arrays.asList(r2));
        goto L6
    }

    public static PluginList newList(List<Metadata> r1) {
        return new PluginList(r1);
    }

    public static Metadata plugin(Plugin<?> r1) {
        return plugin(r1, true);
    }

    public static Metadata pluginWithFixUI(Plugin<?> r0) {
        return plugin(r0);
    }

    public <T extends Plugin> T findPlugin(Class<T> r4) {
        Iterator<Plugin> r0 = this.enabledPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        T r1 = (T) r0.next();
        if (r4.isAssignableFrom(r1.getClass()) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public Plugin findPluginByInterface(Class<?> r4) {
        Iterator<Plugin> r0 = this.enabledPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Plugin r1 = r0.next();
        if (r4.isAssignableFrom(r1.getClass()) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    public Metadata findPluginMetadata(Plugin<?> r4) {
        Iterator<Metadata> r0 = this.items.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Metadata r1 = r0.next();
        if (r1.plugin != r4) goto L4;
        return r1;
    L8:
        return null;
    }

    public List<Metadata> getPluginMetadata(boolean r4) {
        if (r4 == false) goto L4;
        ArrayList r5 = new ArrayList();
        Iterator<Metadata> r0 = this.items.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Metadata r1 = r0.next();
        if (r1.enable == false) goto L7;
        r5.add(r1);
        goto L7
    L11:
        return r5;
    L4:
        return this.items;
    }

    public void removePlugin(Class<? extends Plugin> r4) {
        Iterator<Metadata> r0 = this.items.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Metadata r1 = r0.next();
        if (r4.isAssignableFrom(r1.plugin.getClass()) == false) goto L4;
        r0.remove();
        if (r1.enable == false) goto L4;
        this.enabledPlugins.remove(r1.plugin);
        goto L4
    }

    public PluginList setDefaultMountStrategy(PluginMountStrategy r4) {
        Log.i(TAG, "setDefaultMountStrategy:" + r4);
        Iterator<Metadata> r0 = this.items.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Metadata r1 = r0.next();
        if (r1.mountStrategy != null) goto L4;
        r1.mountStrategy = r4;
        goto L4
    L8:
        return this;
    }

    private PluginList(List<Metadata> r2) {
        this.enabledPlugins = new ArrayList();
        if (r2 != null) goto L5;
        r2 = new ArrayList();
    L5:
        this.items = r2;
        initEnabledPlugins();
    }

    public static PluginList newList(Metadata... r1) {
        return new PluginList(r1);
    }

    public static PluginList merge(PluginList r3, PluginList r4) {
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        HashSet r2 = new HashSet();
        merge(r3.items, r0, r1, r2);
        merge(r4.items, r0, r1, r2);
        Metadata[] r5 = new Metadata[r0.size()];
        r0.toArray(r5);
        return new PluginList(r5);
    }

    public static Metadata plugin(Plugin<?> r2, Enum<?> r3) {
        return plugin(r2, r3.ordinal(), true, null);
    }

    public static Metadata pluginWithUILevel(Plugin<?> r2, int r3) {
        return plugin(r2, r3, true, null);
    }

    public static Metadata plugin(Plugin<?> r2, PluginMountStrategy r3) {
        return plugin(r2, LEVEL_NOT_SET, true, r3);
    }

    public static Metadata plugin(Plugin<?> r2, boolean r3) {
        return plugin(r2, LEVEL_NOT_SET, r3, null);
    }

    public static Metadata plugin(Plugin<?> r1, Enum<?> r2, PluginMountStrategy r3) {
        return plugin(r1, r2.ordinal(), true, r3);
    }

    public static Metadata plugin(Plugin<?> r1, Enum<?> r2, boolean r3) {
        return plugin(r1, r2.ordinal(), r3, null);
    }

    public static Metadata plugin(Plugin<?> r1, boolean r2, PluginMountStrategy r3) {
        return plugin(r1, LEVEL_NOT_SET, r2, r3);
    }

    public static Metadata plugin(Plugin<?> r1, int r2, PluginMountStrategy r3) {
        return plugin(r1, r2, true, r3);
    }

    private static void merge(Collection<Metadata> r6, List<Metadata> r7, Set<Class> r8, Set<Integer> r9) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L36;
        Iterator<Metadata> r10 = r6.iterator();
    L8:
        if (r10.hasNext() == false) goto L37;
        Metadata r0 = r10.next();
        Class<?> r1 = r0.plugin.getClass();
        boolean r2 = r8.contains(r1);
        boolean r3 = r9.contains(Integer.valueOf(r0.pluginContainerLevel));
        if (r2 == true) goto L18;
        if (r3 == true) goto L18;
        r8.add(r1);
        r7.add(r0);
        int r4 = r0.pluginContainerLevel;
        if (r4 == Integer.MIN_VALUE) goto L8;
        if (r4 == Integer.MAX_VALUE) goto L8;
        r9.add(Integer.valueOf(r4));
    L18:
        if (r2 == false) goto L20;
        Log.w(TAG, new IllegalStateException("Found same type plugin :" + r1).toString());
    L20:
        if (r3 == false) goto L8;
        Log.w(TAG, new IllegalStateException("Found same level plugin :" + r1).toString());
        goto L8
    L37:
        return;
    }

    public static Metadata plugin(Plugin<?> r1, int r2, boolean r3, PluginMountStrategy r4) {
        Metadata r0 = new Metadata();
        r0.plugin = r1;
        r0.pluginContainerLevel = r2;
        r0.enable = r3;
        r0.mountStrategy = r4;
        return r0;
    }

    public static Metadata plugin(Plugin<?> r0, Enum<?> r1, boolean r2, PluginMountStrategy r3) {
        return plugin(r0, r1.ordinal(), r2, r3);
    }
}
