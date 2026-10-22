package com.ss.android.lark.chameleon.api.pluginapi;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.pluginsystem.WebService;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHostAbility;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonContextAbility;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHostAbility;", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "getSession", BuildConfig.FLAVOR, "getUrl", "getWebService", "P", "Lcom/ss/android/lark/chameleon/pluginsystem/WebService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/chameleon/pluginsystem/WebService;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ChameleonContextAbility extends PluginHostAbility {
    ChameleonConfig getChameleonConfig();

    String getSession();

    String getUrl();

    <P extends WebService> P getWebService(Class<P> r1);
}
