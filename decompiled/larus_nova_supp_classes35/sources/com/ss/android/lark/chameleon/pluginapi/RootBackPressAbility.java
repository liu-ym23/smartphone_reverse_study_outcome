package com.ss.android.lark.chameleon.pluginapi;

import com.bytedance.ee.bear.browser.plugin.i;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressAbility;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "onRootBackPressed", "Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressResult;", "source", "Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressSource;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RootBackPressAbility extends i {
    RootBackPressResult onRootBackPressed(RootBackPressSource r1);
}
