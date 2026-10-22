package z0b;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.LKAPIWebviewPlugin;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Paths;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Property;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Property;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$AllManifest;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$GlobalInternalProperty;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$GlobalManifest;
import com.ss.android.lark.chameleonv2.lkapi.manifest.IManifest$InternalBaseProperty;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$KaConfig;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$DeviceType;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Paths;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Property;
import com.ss.android.lark.chameleonv2.lkapi.transport.ITransport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$VisibilityState;
import com.ss.android.lark.chameleonv2.lkapi.window.IWindow$Internal$Property;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.utils.di.m;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ntb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements l {
    public d() {
    }

    public final f R() {
        return new f();
    }

    public final LKAPIWebviewPlugin f0() {
        return new LKAPIWebviewPlugin();
    }

    public final i m() {
        return new i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String z(boolean r49, Boolean r50) {
        if (TextUtils.isEmpty(g.a) == false) goto L41;
        Application r0 = LarkContext.getApplication();
        int r3 = swb.j.a;
        InputStream r2 = r0.getAssets().open("lark-api-injected@7.53.0.js");     // Catch: Throwable -> L22 Exception -> L24
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r2));     // Catch: Throwable -> L18 Exception -> L20
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L18 Exception -> L20
    L7:
        String r5 = r1.readLine();     // Catch: Throwable -> L18 Exception -> L20
        if (r5 == null) goto L12;
        if (r5.matches("^\\s*\\/\\/.*") == true) goto L12;
        r4.append(r5);     // Catch: Throwable -> L18 Exception -> L20
    L12:
        if (r5 != null) goto L7;
        r1.close();     // Catch: Throwable -> L18 Exception -> L20
        r2.close();     // Catch: Throwable -> L18 Exception -> L20
        String r6 = r4.toString();     // Catch: Throwable -> L18 Exception -> L20
        r2.close();     // Catch: IOException -> L16
    L33:
        g.a = r6;
    L16:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
    L20:
        e = e;
    L26:
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());     // Catch: Throwable -> L18
        if (r2 != null) goto L99;
    L32:
        r6 = null;
        goto L33
    L99:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
        goto L32
    L18:
        th = move-exception;
        Throwable r7 = th;
        FilterInputStream r8 = "lark-api-injected@7.53.0.js";
    L35:
        if (r8 == 0) goto L107;
        r8.close();     // Catch: IOException -> L38
        throw r7;
    L38:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("FileUtil", e.toString());
        throw r7;
    L107:
        throw r7;
    L24:
        e = e;
        r2 = null;
    L22:
        th = move-exception;
        r7 = th;
        r8 = 0;
    L41:
        int r9 = a1b.a.a;
        IApp$Property r10 = new IApp$Property(0.0d);
        int r11 = d1b.a.a;
        Application r12 = LarkContext.getApplication();
        boolean r21 = PackageChannelManager.isKABuildPackage(r12);
        if (r21 == false) goto L44;
        String r13 = PackageChannelManager.getBuildPackageChannel(r12);
    L45:
        String r25 = r13;
        int r14 = PackageChannelManager.getDeployMode(r12);
        if (r14 != 1) goto L48;
        String r15 = "saas";
    L56:
        String r17 = r15;
        String r16 = PackageChannelManager.getBuildPackageChannel(r12);
        LarkAppContext.Companion.getClass();
        int r18 = LarkAppContext.access$getInstance$cp().appIdInfo().a;
        int r19 = m.a;
        boolean r33 = m.a.a().isBoe();
        ArrayList r20 = new ArrayList();
        boolean r22 = DevEnvUtil.isDevelopPackage(r12);
        yob.e.a().getClass();
        int r23 = com.ss.android.lark.language.service.impl.a.f;
        apb.b r34 = com.ss.android.lark.language.service.impl.a.b.a;
        boolean r24 = r34.isGooglePlay();
        Intrinsics.checkNotNull(r25);
        IEnv$Property r110 = new IEnv$Property(r16, r18, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, r33, false, BuildConfig.FLAVOR, r20, r17, false, false, r22, r21, false, true, r24, r25, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "release", r12.getPackageName(), BuildConfig.FLAVOR, ApkUtil.getUpdateVersionCode(r12));
        yob.e.a().getClass();
        Locale r26 = r34.getLanguageSetting();
        String r27 = swb.l.a(r26.getCountry(), r26.getLanguage());
        Intrinsics.checkNotNull(r27);
        IApp$Internal$Paths r111 = new IApp$Internal$Paths(BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        String r28 = ApkUtil.getAppVersionName(LarkContext.getApplication());
        String r29 = BuildConfig.FLAVOR;
        IApp$Internal$Property r30 = new IApp$Internal$Property(r27, BuildConfig.FLAVOR, r111, r28);
        IManifest$InternalBaseProperty r31 = new IManifest$InternalBaseProperty((ArrayList) CollectionsKt.toCollection(LKAPIModules.INSTANCE.getAllValue(), new ArrayList()), new HashMap());
        int r32 = c1b.a.c;
        IDomain$Internal$Property r38 = c1b.a.C0014a.a();
        IEnv$Internal$Property r35 = new IEnv$Internal$Property(true, 5000);
        int r112 = e1b.a.c;
        IFeatureGating$Internal$Property r40 = e1b.a.C0212a.a();
        int r113 = i1b.a.a;
        String r114 = m.a.a().getDeviceId();
        if (r114 != null) goto L59;
        r114 = BuildConfig.FLAVOR;
    L59:
        String r115 = m.a.a().getUserId();
        if (r115 != null) goto L62;
        r115 = BuildConfig.FLAVOR;
    L62:
        IPassport$Internal$Property r116 = new IPassport$Internal$Property(r114, r115);
        int r117 = j1b.b.c;
        IResource$Internal$Property r118 = new IResource$Internal$Property(new IResource$Internal$KaConfig(BuildConfig.FLAVOR, new HashMap(), new HashMap()));
        int r119 = m1b.a.c;
        ISystem$Internal$Property r120 = new ISystem$Internal$Property(new ISystem$Internal$Paths(BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
        int r121 = com.ss.android.lark.chameleonv2.lkapi.transport.c.c;
        ITransport$Internal$Property r122 = new ITransport$Internal$Property(y9c.d.h(2131891714));
        int r123 = r1b.a.a;
        if (r49 == false) goto L65;
        IWebview$VisibilityState r124 = IWebview$VisibilityState.Visible;
    L66:
        IWebview$Internal$Property r125 = new IWebview$Internal$Property(r124);
        int r126 = t1b.a.a;
        IManifest$GlobalInternalProperty r36 = new IManifest$GlobalInternalProperty(r30, r31, r38, r35, r40, r116, r118, r120, r122, r125, new IWindow$Internal$Property(BuildConfig.FLAVOR));
        if (Intrinsics.areEqual(r50, Boolean.TRUE) == false) goto L69;
        float r37 = 18.0f;
    L70:
        boolean r127 = false;
        String r39 = JSON.toJSONString(new IManifest$AllManifest(new IManifest$GlobalManifest(r10, r110, r36, new ISystem$Property("Android", ISystem$DeviceType.Phone, r37, 0))));
        if (TextUtils.isEmpty(g.a) == false) goto L73;
        return BuildConfig.FLAVOR;
    L73:
        if (TextUtils.isEmpty(r39) == true) goto L110;
        StringBuilder r41 = new StringBuilder();
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication().getApplicationContext()) == false) goto L90;
        vzb.a r42 = (vzb.a) ClaymoreServiceLoader.loadFirst(vzb.a.class);
        if (r42 == null) goto L81;
        String r43 = r42.a();
    L82:
        if (r43 != null) goto L84;
    L85:
        r127 = true;
    L87:
        if (r127 == false) goto L89;
        com.ss.android.lark.officesdk.utils.di.j.e("LKAPILoader", "ttFeatureEnv empty, refuse x-tt-env Inject");
        goto L90
    L89:
        com.ss.android.lark.officesdk.utils.di.j.e("LKAPILoader", "x-tt-env injected: " + r43);
        r29 = "(function () {\n                      var originalOpen = XMLHttpRequest.prototype.open;\n                      var originalSetRequestHeader = XMLHttpRequest.prototype.setRequestHeader;\n                      var originalSend = XMLHttpRequest.prototype.send;\n                      XMLHttpRequest.prototype.open = function (method, url) {\n                        // 记录是否已有 x-tt-env\n                        this._hasXttEnv = false;\n                    \n                        // 包一层 setRequestHeader，用来侦测用户是否设置了 x-tt-env\n                        var xhr = this;\n                        this.setRequestHeader = function (name, value) {\n                          if (String(name).toLowerCase() === 'x-tt-env') {\n                            xhr._hasXttEnv = true;\n                          }\n                          return originalSetRequestHeader.apply(this, arguments);\n                        };\n                    \n                        return originalOpen.apply(this, arguments);\n                      };\n                      XMLHttpRequest.prototype.send = function () {\n                        // 最终注入点：只有当用户没设置过时才补\n                        if (!this._hasXttEnv) {\n                          originalSetRequestHeader.call(this, 'x-tt-env', '" + r43 + "');\n                        }\n                        return originalSend.apply(this, arguments);\n                      };\n                      var originalFetch = window.fetch;\n                    \n                      window.fetch = function (input, init) {\n                        init = init || {};\n                        init.headers = init.headers || {};\n                        if (globalThis.Headers && init.headers instanceof globalThis.Headers) {\n                          if (!init.headers.has('x-tt-env')) {\n                            init.headers.append('x-tt-env', '" + r43 + "');\n                          }\n                        } else {\n                          var hasXttEnv = Object.keys(init.headers)\n                            .some(k => k.toLowerCase() === 'x-tt-env');\n                          if (!hasXttEnv) {\n                            init.headers['x-tt-env'] = '" + r43 + "';\n                          }\n                        }\n                        return originalFetch(input, init);\n                      };\n                    })();\n            ";
        goto L90
    L84:
        if (r43.length() != 0) goto L87;
    L81:
        r43 = null;
    L90:
        r41.append(r29);
        r41.append("; globalThis.LarkAPIInternalManifest=");
        r41.append(r39);
        r41.append("; ");
        r41.append(g.a);
        return r41.toString();
    L110:
        return BuildConfig.FLAVOR;
    L69:
        r37 = UIUtils.px2dp(LarkContext.getApplication(), DeviceUtils.getStatusHeight(LarkContext.getApplication()));
        goto L70
    L65:
        r124 = IWebview$VisibilityState.Hidden;
        goto L66
    L48:
        if (r14 != 2) goto L50;
        r15 = "hosted";
        goto L56
    L50:
        if (r14 != 3) goto L53;
        r15 = "on_premise";
        goto L56
    L53:
        throw new IllegalArgumentException("Unknown deploy mode");
    L44:
        r13 = "sass";
        goto L45
    }
}
