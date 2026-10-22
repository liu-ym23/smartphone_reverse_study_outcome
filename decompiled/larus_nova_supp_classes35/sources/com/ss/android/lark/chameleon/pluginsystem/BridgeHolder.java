package com.ss.android.lark.chameleon.pluginsystem;

import com.ss.android.lark.chameleon.bridge.IBridge;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginsystem/BridgeHolder;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHostAbility;", "bridge", "Lcom/ss/android/lark/chameleon/bridge/IBridge;", "getBridge", "()Lcom/ss/android/lark/chameleon/bridge/IBridge;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BridgeHolder extends PluginHostAbility {
    IBridge getBridge();
}
