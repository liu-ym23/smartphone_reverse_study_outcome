package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/RenderGonePlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "observerAdded", BuildConfig.FLAVOR, "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderGonePlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    public static final String TAG = "CML_TAG_RenderGonePlugin";
    private boolean observerAdded;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public RenderGonePlugin() {
    }

    public static final /* synthetic */ boolean access$getObserverAdded$p(RenderGonePlugin r0) {
        return r0.observerAdded;
    }

    public void onAttachToHost(final ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (r3 == null) goto L8;
        k r0 = r3.getChameleonWeb();
        if (r0 == null) goto L9;
        r0.w(new AnonymousClass1(this, r3));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static final /* synthetic */ void access$setObserverAdded$p(RenderGonePlugin r0, boolean r1) {
        r0.observerAdded = r1;
    }
}
