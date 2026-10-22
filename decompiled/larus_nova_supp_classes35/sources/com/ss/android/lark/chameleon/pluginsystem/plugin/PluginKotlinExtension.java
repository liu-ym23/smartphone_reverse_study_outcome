package com.ss.android.lark.chameleon.pluginsystem.plugin;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0086\b¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u0004\u0018\u0001H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0006H\u0086\b¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginKotlinExtension;", BuildConfig.FLAVOR, "()V", "hostAbility", "T", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHostAbility;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/Plugin;", "(Lcom/ss/android/lark/chameleon/pluginsystem/plugin/Plugin;)Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHostAbility;", "hostAbilityOrNull", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PluginKotlinExtension {
    public static final PluginKotlinExtension INSTANCE = null;

    static {
        INSTANCE = new PluginKotlinExtension();
    }

    private PluginKotlinExtension() {
    }

    public final /* synthetic */ <T extends PluginHostAbility> T hostAbility(Plugin<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        PluginHost r4 = r3.getHost();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) r4.getHostAbility(PluginHostAbility.class);
    }

    public final /* synthetic */ <T extends PluginHostAbility> T hostAbilityOrNull(Plugin<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        PluginHost r4 = r3.getHost();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) r4.getHostAbilityOrNull(PluginHostAbility.class);
    }
}
