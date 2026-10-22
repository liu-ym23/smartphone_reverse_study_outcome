package com.ss.android.lark.chameleonv2.container.webcontainer.cookie;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import o0b.b;
import o0b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/cookie/AuthCookiePlugin;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "onAttachToHost", BuildConfig.FLAVOR, "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthCookiePlugin extends AbsChameleonPlugin {
    public static final a Companion = null;
    private static final String TAG = "CML_TAG_AuthCookiePlugin";

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

    public AuthCookiePlugin() {
    }

    public void onAttachToHost(ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        if (r3 == null) goto L5;
        String r4 = r3.getUrl();
    L6:
        if (r4 != null) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        j.e(TAG, "startAuthCookie");
        int r0 = b.a;
        c r1 = (c) OfficeSDKManager.getHostGlobalService(c.class);
        if (r1 != null) goto L11;
        r1 = new o0b.a();
    L11:
        r1.X(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r4, t r5) {
        if (r4 == null) goto L4;
        String r0 = r4.getUrl();
    L5:
        if (r0 != null) goto L7;
        r0 = BuildConfig.FLAVOR;
    L7:
        j.e(TAG, "stopAuthCookie");
        int r1 = b.a;
        c r2 = (c) OfficeSDKManager.getHostGlobalService(c.class);
        if (r2 != null) goto L10;
        r2 = new o0b.a();
    L10:
        r2.P1(r0);
        super.onDetachFromUIContainer(r4, r5);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
