package com.ss.android.lark.chameleon.pluginapi;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.PluginProvider;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J+\u0010'\u001a\u0004\u0018\u0001H(\"\n\b\u0000\u0010(*\u0004\u0018\u00010)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u0002H(\u0018\u00010+H\u0016¢\u0006\u0002\u0010,R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lcom/bytedance/ee/bear/browser/WebPluginHost;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonContextAbility;", "chameleonWeb", "Lcom/bytedance/ee/bear/browser/Web;", "url", BuildConfig.FLAVOR, "config", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "sessionId", "serviceManager", "Lcom/bytedance/ee/bear/browser/WebServiceManager;", "afterCreate", "Lkotlin/Function0;", BuildConfig.FLAVOR, "<init>", "(Lcom/bytedance/ee/bear/browser/Web;Ljava/lang/String;Lcom/ss/android/lark/chameleon/ChameleonConfig;Ljava/lang/String;Lcom/bytedance/ee/bear/browser/WebServiceManager;Lkotlin/jvm/functions/Function0;)V", "getChameleonWeb", "()Lcom/bytedance/ee/bear/browser/Web;", "getAfterCreate", "()Lkotlin/jvm/functions/Function0;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "loader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "setLoader", "(Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;)V", "onCreate", "delegate", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost$Delegate;", "getChameleonConfig", "getUrl", "getSession", "getWebService", "P", "Lcom/bytedance/ee/bear/browser/WebService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChameleonPluginHost extends WebPluginHost implements ChameleonContextAbility {
    private final Function0<Unit> afterCreate;
    private final k chameleonWeb;
    private final ChameleonConfig config;
    public Fragment fragment;
    public IChameleonLoader loader;
    private final n serviceManager;
    private final String sessionId;
    private final String url;

    public final Fragment getFragment() {
        Fragment r0 = this.fragment;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    public final IChameleonLoader getLoader() {
        IChameleonLoader r0 = this.loader;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loader");
        return null;
    }

    public final Function0<Unit> getAfterCreate() {
        return this.afterCreate;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public ChameleonConfig getChameleonConfig() {
        return this.config;
    }

    public final k getChameleonWeb() {
        return this.chameleonWeb;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public String getSession() {
        return this.sessionId;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public String getUrl() {
        return this.url;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility
    public <P extends m> P getWebService(Class<P> r2) {
        return (P) this.serviceManager.a(r2);
    }

    public void onCreate(PluginHost.a r1) {
        super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.onCreate(r1);
        this.afterCreate.invoke();
    }

    public final void setFragment(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fragment = r2;
    }

    public final void setLoader(IChameleonLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loader = r2;
    }

    public ChameleonPluginHost(k r2, String r3, ChameleonConfig r4, String r5, n r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "serviceManager");
        Intrinsics.checkNotNullParameter(r7, "afterCreate");
        super(r2);
        this.chameleonWeb = r2;
        this.url = r3;
        this.config = r4;
        this.sessionId = r5;
        this.serviceManager = r6;
        this.afterCreate = r7;
        registerHostAbility(this);
        OpenConfig r8 = r4.getOpenConfig();
        if (r8 == null) goto L12;
        PluginProvider r9 = r8.getPluginProvider();
        if (r9 == null) goto L14;
        ArrayList<i> r10 = r9.getPluginHostAbilitys();
        if (r10 == null) goto L15;
        Iterator<T> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L16;
        registerHostAbility((i) r11.next());
        goto L10
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public /* synthetic */ ChameleonPluginHost(k r8, String r9, ChameleonConfig r10, String r11, n r12, Function0 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = AnonymousClass1.INSTANCE;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }
}
