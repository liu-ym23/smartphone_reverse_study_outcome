package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/RenderGonePlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RenderGonePlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_RenderGonePlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/biz/RenderGonePlugin$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RenderGonePlugin() {
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (r3 == null) goto L8;
        IChameleonLoader r0 = r3.getLoader();
        if (r0 == null) goto L9;
        r0.addLoadCallback(new AnonymousClass1(r3));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
