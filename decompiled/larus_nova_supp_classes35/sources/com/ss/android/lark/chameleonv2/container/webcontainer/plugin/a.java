package com.ss.android.lark.chameleonv2.container.webcontainer.plugin;

import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.lazy.PluginMountStrategy;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ChameleonPluginListProvider;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PluginProvider;
import com.ss.android.lark.chameleon.TitlebarConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.cookie.AuthCookiePlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.CorePlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.RenderGonePlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck.BlankPlugin;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.title.TitleBarPlugin;
import com.ss.android.lark.chameleonv2.lkapi.LKAPIWebviewPlugin;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.BlankScreenConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import ntb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements o {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.plugin.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    static {
    }

    public a() {
    }

    public final n a(PluginHost r11) {
        Intrinsics.checkNotNullParameter(r11, "host");
        j.e("CML_TAG_ChameleonPluginProvider", "getPluginList");
        boolean r1 = r11 instanceof ChameleonPluginHost;
        n r2 = null;
        if (r1 == false) goto L5;
        ChameleonPluginHost r3 = (ChameleonPluginHost) r11;
    L6:
        if (r3 == null) goto L8;
        ChameleonConfig r4 = r3.getChameleonConfig();
    L9:
        ArrayList r5 = new ArrayList();
        CorePlugin r6 = new CorePlugin();
        PluginMountStrategy r7 = PluginMountStrategy.Immediate;
        r5.add(n.k(r6, r7));
        r5.add(n.k(new AuthCookiePlugin(), r7));
        TitleBarPlugin r8 = new TitleBarPlugin();
        if (r4 == null) goto L18;
        OpenConfig r9 = r4.getOpenConfig();
        if (r9 == null) goto L18;
        TitlebarConfig r10 = r9.getTitlebarConfig();
        if (r10 == null) goto L18;
        if (r10.getShowTitlebar() == true) goto L18;
        boolean r12 = true;
    L19:
        r5.add(n.i(r8, !r12, r7));
        r5.add(n.k(new LoadingPlugin(), r7));
        r5.add(n.k(new RenderGonePlugin(), r7));
        WebViewOptimizeConfig r13 = ixb.a.a;
        if (swb.b.b() == false) goto L25;
        if (ixb.a.d == false) goto L25;
        j.e("WebViewOptimizeUtil", "DouBao disable blank detect");
    L35:
        boolean r14 = false;
    L36:
        if (r14 == false) goto L38;
        r5.add(n.k(new BlankPlugin(), r7));
    L38:
        if (r4 == null) goto L44;
        WebviewConfig r15 = r4.getWebviewConfig();
        if (r15 == null) goto L44;
        if (r15.getLarkApiEnable() == true) goto L44;
        boolean r16 = true;
    L45:
        if (r16 == true) goto L52;
        DependencyContainer r17 = DependencyContainer.a;
        l r18 = DependencyContainer.a(l.class, null);
        if (r18 != null) goto L49;
    L51:
        j.b("CML_TAG_ChameleonPluginProvider", "create, LKAPIDependency is null");
        goto L52
    L49:
        if ((r18.f0() instanceof AbsChameleonPlugin) == false) goto L51;
        LKAPIWebviewPlugin r0 = r18.f0();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chameleon.AbsChameleonPlugin");
        r5.add(n.k(r0, r7));
    L52:
        if (r1 == false) goto L54;
        ChameleonPluginHost r19 = (ChameleonPluginHost) r11;
    L55:
        if (r19 == null) goto L57;
        String r20 = r19.getSession();
    L58:
        if (r20 == null) goto L63;
        Iterator<T> r21 = com.ss.android.lark.chameleonv2.container.webcontainer.util.b.c(r20).iterator();
    L61:
        if (r21.hasNext() == false) goto L63;
        r5.add(n.k((AbsChameleonPlugin) r21.next(), PluginMountStrategy.Immediate));
    L63:
        if (r4 == null) goto L71;
        OpenConfig r22 = r4.getOpenConfig();
        if (r22 == null) goto L71;
        PluginProvider r23 = r22.getPluginProvider();
        if (r23 == null) goto L71;
        ChameleonPluginListProvider r24 = r23.getPluginListProvider();
        if (r24 == null) goto L71;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost");
        r2 = r24.getPluginList((ChameleonPluginHost) r11);
    L71:
        n r110 = new n(r5);
        ArrayList r25 = new ArrayList();
        HashSet r26 = new HashSet();
        HashSet r27 = new HashSet();
        n.d(r110.a, r25, r26, r27);
        if (r2 == null) goto L75;
        n.d(r2.a, r25, r26, r27);
    L75:
        if (r25.isEmpty() == true) goto L119;
        HashMap r111 = new HashMap();
        int r28 = 0;
    L79:
        if (r28 >= r25.size()) goto L99;
        n.a r29 = (n.a) ListProtector.get(r25, r28);
        if (r29 == null) goto L98;
        BasePlugin r30 = r29.a;
        if (r30 == null) goto L98;
        if ((r30 instanceof BasePlugin) == false) goto L98;
        BasePlugin r31 = r30;
        String r32 = r31.getPluginId();
        if (r32 == null) goto L93;
        if (r32.isEmpty() == true) goto L93;
        r111.put(r32, Integer.valueOf(r28));
    L93:
        if (r31.getUILevel() == null) goto L96;
        r29.c = r31.getUILevel().ordinal();
    L96:
        if (r31.getMountStrategy() == null) goto L98;
        r29.d = r31.getMountStrategy();
    L98:
        r28 = r28 + 1;
        goto L79
    L99:
        int r33 = 0;
    L101:
        if (r33 >= r25.size()) goto L119;
        n.a r34 = (n.a) ListProtector.get(r25, r33);
        if (r34 == null) goto L117;
        BasePlugin r35 = r34.a;
        if ((r35 instanceof BasePlugin) == false) goto L117;
        String r36 = r35.getPluginId();
        if (r36 == null) goto L117;
        if (r36.isEmpty() == true) goto L117;
        Integer r37 = (Integer) r111.get(r36);
        if (r37 == null) goto L117;
        if (r33 != r37.intValue()) goto L115;
        boolean r38 = true;
    L116:
        r34.b = r38;
        j.a("PluginList", "Same pluginId found, keep last one: ".concat(r36));
        goto L117
    L115:
        r38 = false;
    L117:
        r33 = r33 + 1;
    L119:
        return new n(r25);
    L57:
        r20 = null;
        goto L58
    L54:
        r19 = null;
    L44:
        r16 = false;
    L25:
        if (swb.b.b() == false) goto L27;
    L29:
        WebViewOptimizeConfig r39 = ixb.a.a;
        if (r39 == null) goto L32;
        BlankScreenConfig r40 = r39.getBlankScreen();
    L33:
        if (r40 == null) goto L35;
        r14 = r40.getEnableDetection();
        goto L36
    L32:
        r40 = null;
        goto L33
    L27:
        if (ixb.a.b == true) goto L29;
        j.e("WebViewOptimizeUtil", "blankFgEnable is false");
    L18:
        r12 = false;
        goto L19
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
