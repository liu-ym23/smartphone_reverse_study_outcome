package com.ss.android.lark.chameleon.pluginsystem.plugin;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHostViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "pluginHost", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;", "getPluginHost", "()Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;", "setPluginHost", "(Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;)V", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PluginHostViewModel extends ViewModel {
    private PluginHost pluginHost;

    public PluginHostViewModel() {
    }

    public final PluginHost getPluginHost() {
        return this.pluginHost;
    }

    public final void setPluginHost(PluginHost r1) {
        this.pluginHost = r1;
    }
}
