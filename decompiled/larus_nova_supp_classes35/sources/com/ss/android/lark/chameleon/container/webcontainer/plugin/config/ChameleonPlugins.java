package com.ss.android.lark.chameleon.container.webcontainer.plugin.config;

import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.TitlebarConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.CorePlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.RenderGonePlugin;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.title.TitleBarPlugin;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMountStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/config/ChameleonPlugins;", BuildConfig.FLAVOR, "()V", "create", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginList;", "host", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/PluginHost;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonPlugins {
    public static final ChameleonPlugins INSTANCE = null;

    static {
        INSTANCE = new ChameleonPlugins();
    }

    private ChameleonPlugins() {
    }

    @JvmStatic
    public static final PluginList create(PluginHost r8) {
        boolean r0 = r8 instanceof ChameleonPluginHost;
        String r1 = null;
        if (r0 == false) goto L5;
        ChameleonPluginHost r2 = (ChameleonPluginHost) r8;
    L6:
        if (r2 == null) goto L8;
        ChameleonConfig r3 = r2.getChameleonConfig();
    L9:
        ArrayList r4 = new ArrayList();
        CorePlugin r5 = new CorePlugin();
        PluginMountStrategy r6 = PluginMountStrategy.Immediate;
        r4.add(PluginList.plugin(r5, r6));
        TitleBarPlugin r7 = new TitleBarPlugin();
        boolean r9 = false;
        if (r3 == null) goto L18;
        OpenConfig r10 = r3.getOpenConfig();
        if (r10 == null) goto L18;
        TitlebarConfig r11 = r10.getTitlebarConfig();
        if (r11 == null) goto L18;
        if (r11.getShowTitlebar() == true) goto L18;
        r9 = true;
    L18:
        r4.add(PluginList.plugin(r7, !r9, r6));
        r4.add(PluginList.plugin(new LoadingPlugin(), r6));
        r4.add(PluginList.plugin(new RenderGonePlugin(), r6));
        if (r0 == false) goto L21;
        ChameleonPluginHost r12 = (ChameleonPluginHost) r8;
    L22:
        if (r12 == null) goto L24;
        r1 = r12.getSession();
    L24:
        if (r1 == null) goto L30;
        Iterator<T> r13 = ChameleonContainerUtils.INSTANCE.getBizPlugins(r1).iterator();
    L27:
        if (r13.hasNext() == false) goto L30;
        r4.add(PluginList.plugin((AbsChameleonPlugin) r13.next(), PluginMountStrategy.Immediate));
    L30:
        return PluginList.newList(r4);
    L21:
        r12 = null;
        goto L22
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
