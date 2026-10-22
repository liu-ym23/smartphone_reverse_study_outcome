package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleonv2.lkapi.app.IApp$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.domain.IDomain$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.env.IEnv$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.featuregating.IFeatureGating$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.passport.IPassport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.transport.ITransport$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$Property;
import com.ss.android.lark.chameleonv2.lkapi.window.IWindow$Internal$Property;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003Jw\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006D"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$GlobalInternalProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "app", "Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;", "base", "Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "domain", "Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;", "env", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "featureGating", "Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "passport", "Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;", "resource", "Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;", "system", "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;", "transport", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;", "webview", "Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;", "window", "Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;)V", "getApp", "()Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Property;", "getBase", "()Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$InternalBaseProperty;", "getDomain", "()Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;", "getEnv", "()Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Internal$Property;", "getFeatureGating", "()Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "getPassport", "()Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;", "getResource", "()Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Internal$Property;", "getSystem", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Property;", "getTransport", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Property;", "getWebview", "()Lcom/ss/android/lark/chameleonv2/lkapi/webview/IWebview$Internal$Property;", "getWindow", "()Lcom/ss/android/lark/chameleonv2/lkapi/window/IWindow$Internal$Property;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IManifest$GlobalInternalProperty implements NonProguard {
    private final IApp$Internal$Property app;
    private final IManifest$InternalBaseProperty base;
    private final IDomain$Internal$Property domain;
    private final IEnv$Internal$Property env;
    private final IFeatureGating$Internal$Property featureGating;
    private final IPassport$Internal$Property passport;
    private final IResource$Internal$Property resource;
    private final ISystem$Internal$Property system;
    private final ITransport$Internal$Property transport;
    private final IWebview$Internal$Property webview;
    private final IWindow$Internal$Property window;

    public static /* synthetic */ IManifest$GlobalInternalProperty copy$default(IManifest$GlobalInternalProperty r12, IApp$Internal$Property r13, IManifest$InternalBaseProperty r14, IDomain$Internal$Property r15, IEnv$Internal$Property r16, IFeatureGating$Internal$Property r17, IPassport$Internal$Property r18, IResource$Internal$Property r19, ISystem$Internal$Property r20, ITransport$Internal$Property r21, IWebview$Internal$Property r22, IWindow$Internal$Property r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        IApp$Internal$Property r2 = r12.app;
    L7:
        if ((r24 & 2) == 0) goto L9;
        IManifest$InternalBaseProperty r3 = r12.base;
    L11:
        if ((r24 & 4) == 0) goto L13;
        IDomain$Internal$Property r4 = r12.domain;
    L15:
        if ((r24 & 8) == 0) goto L17;
        IEnv$Internal$Property r5 = r12.env;
    L19:
        if ((r24 & 16) == 0) goto L21;
        IFeatureGating$Internal$Property r6 = r12.featureGating;
    L23:
        if ((r24 & 32) == 0) goto L25;
        IPassport$Internal$Property r7 = r12.passport;
    L27:
        if ((r24 & 64) == 0) goto L29;
        IResource$Internal$Property r8 = r12.resource;
    L31:
        if ((r24 & 128) == 0) goto L33;
        ISystem$Internal$Property r9 = r12.system;
    L35:
        if ((r24 & 256) == 0) goto L37;
        ITransport$Internal$Property r10 = r12.transport;
    L39:
        if ((r24 & 512) == 0) goto L41;
        IWebview$Internal$Property r11 = r12.webview;
    L43:
        if ((r24 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        IWindow$Internal$Property r1 = r12.window;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final IApp$Internal$Property component1() {
        return this.app;
    }

    public final IWebview$Internal$Property component10() {
        return this.webview;
    }

    public final IWindow$Internal$Property component11() {
        return this.window;
    }

    public final IManifest$InternalBaseProperty component2() {
        return this.base;
    }

    public final IDomain$Internal$Property component3() {
        return this.domain;
    }

    public final IEnv$Internal$Property component4() {
        return this.env;
    }

    public final IFeatureGating$Internal$Property component5() {
        return this.featureGating;
    }

    public final IPassport$Internal$Property component6() {
        return this.passport;
    }

    public final IResource$Internal$Property component7() {
        return this.resource;
    }

    public final ISystem$Internal$Property component8() {
        return this.system;
    }

    public final ITransport$Internal$Property component9() {
        return this.transport;
    }

    public final IManifest$GlobalInternalProperty copy(IApp$Internal$Property r14, IManifest$InternalBaseProperty r15, IDomain$Internal$Property r16, IEnv$Internal$Property r17, IFeatureGating$Internal$Property r18, IPassport$Internal$Property r19, IResource$Internal$Property r20, ISystem$Internal$Property r21, ITransport$Internal$Property r22, IWebview$Internal$Property r23, IWindow$Internal$Property r24) {
        Intrinsics.checkNotNullParameter(r14, "app");
        Intrinsics.checkNotNullParameter(r15, "base");
        Intrinsics.checkNotNullParameter(r16, "domain");
        Intrinsics.checkNotNullParameter(r17, "env");
        Intrinsics.checkNotNullParameter(r18, "featureGating");
        Intrinsics.checkNotNullParameter(r19, "passport");
        Intrinsics.checkNotNullParameter(r20, "resource");
        Intrinsics.checkNotNullParameter(r21, "system");
        Intrinsics.checkNotNullParameter(r22, "transport");
        Intrinsics.checkNotNullParameter(r23, "webview");
        Intrinsics.checkNotNullParameter(r24, "window");
        return new IManifest$GlobalInternalProperty(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IManifest$GlobalInternalProperty) == true) goto L8;
        return false;
    L8:
        IManifest$GlobalInternalProperty r6 = (IManifest$GlobalInternalProperty) r5;
        if (Intrinsics.areEqual(this.app, r6.app) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.base, r6.base) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.domain, r6.domain) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.env, r6.env) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.featureGating, r6.featureGating) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.passport, r6.passport) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resource, r6.resource) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.system, r6.system) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.transport, r6.transport) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.webview, r6.webview) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.window, r6.window) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.app.hashCode() * 31) + this.base.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.env.hashCode()) * 31) + this.featureGating.hashCode()) * 31) + this.passport.hashCode()) * 31) + this.resource.hashCode()) * 31) + this.system.hashCode()) * 31) + this.transport.hashCode()) * 31) + this.webview.hashCode()) * 31) + this.window.hashCode();
    }

    public String toString() {
        return "GlobalInternalProperty(app=" + this.app + ", base=" + this.base + ", domain=" + this.domain + ", env=" + this.env + ", featureGating=" + this.featureGating + ", passport=" + this.passport + ", resource=" + this.resource + ", system=" + this.system + ", transport=" + this.transport + ", webview=" + this.webview + ", window=" + this.window + ')';
    }

    public final IApp$Internal$Property getApp() {
        return this.app;
    }

    public final IManifest$InternalBaseProperty getBase() {
        return this.base;
    }

    public final IDomain$Internal$Property getDomain() {
        return this.domain;
    }

    public final IEnv$Internal$Property getEnv() {
        return this.env;
    }

    public final IFeatureGating$Internal$Property getFeatureGating() {
        return this.featureGating;
    }

    public final IPassport$Internal$Property getPassport() {
        return this.passport;
    }

    public final IResource$Internal$Property getResource() {
        return this.resource;
    }

    public final ISystem$Internal$Property getSystem() {
        return this.system;
    }

    public final ITransport$Internal$Property getTransport() {
        return this.transport;
    }

    public final IWebview$Internal$Property getWebview() {
        return this.webview;
    }

    public final IWindow$Internal$Property getWindow() {
        return this.window;
    }

    public IManifest$GlobalInternalProperty(IApp$Internal$Property r2, IManifest$InternalBaseProperty r3, IDomain$Internal$Property r4, IEnv$Internal$Property r5, IFeatureGating$Internal$Property r6, IPassport$Internal$Property r7, IResource$Internal$Property r8, ISystem$Internal$Property r9, ITransport$Internal$Property r10, IWebview$Internal$Property r11, IWindow$Internal$Property r12) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "base");
        Intrinsics.checkNotNullParameter(r4, "domain");
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r6, "featureGating");
        Intrinsics.checkNotNullParameter(r7, "passport");
        Intrinsics.checkNotNullParameter(r8, "resource");
        Intrinsics.checkNotNullParameter(r9, "system");
        Intrinsics.checkNotNullParameter(r10, "transport");
        Intrinsics.checkNotNullParameter(r11, "webview");
        Intrinsics.checkNotNullParameter(r12, "window");
        this.app = r2;
        this.base = r3;
        this.domain = r4;
        this.env = r5;
        this.featureGating = r6;
        this.passport = r7;
        this.resource = r8;
        this.system = r9;
        this.transport = r10;
        this.webview = r11;
        this.window = r12;
    }
}
