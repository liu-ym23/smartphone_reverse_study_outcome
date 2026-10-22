package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

import com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface PluginMounter {
    void mountPlugins(PluginList r1);

    void onFindAbility(PluginHostAbility r1);

    void onFindPlugin(Plugin<?> r1);

    void release();
}
