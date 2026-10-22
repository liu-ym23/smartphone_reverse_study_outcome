package com.ss.android.lark.officesdk.appcontext;

import android.app.Application;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.component.appcontext.b;
import com.ss.android.lark.component.appcontext.model.Flavor;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import com.ss.android.lark.utils.y0;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020'H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/appcontext/OfficeSdkContextInitDependencyImpl;", "Lcom/ss/android/lark/component/appcontext/IAppContextInitDependency;", "<init>", "()V", "config", "Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "getConfig", "()Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "config$delegate", "Lkotlin/Lazy;", "getAllBuildConfigValues", "", "", "", "getStandardAppId", "", "getAppIdExcludeInternalTestPackage", "getAppIdExcludeDebug", "getAppIdByPackage", "getPackageDeployMode", "getPackageBrand", "getReleaseAction", "getPackageJobId", "releaseInfo", "Lcom/ss/android/lark/component/appcontext/model/ReleaseInfo;", "getReleaseInfo", "()Lcom/ss/android/lark/component/appcontext/model/ReleaseInfo;", "releaseInfo$delegate", "larkAppId", "Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "getLarkAppId", "()Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "larkAppId$delegate", "getContext", "Landroid/app/Application;", "getAppId", "getReleaseInformation", "getBuildConfig", "isAppLifecycle2Enable", "", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSdkContextInitDependencyImpl implements b {
    public static final a Companion = null;
    private static final String TAG = "OfficeSdkContextInitDependencyImpl";
    private final Lazy config$delegate;
    private final Lazy larkAppId$delegate;
    private final Lazy releaseInfo$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final int getAppIdExcludeDebug() {
        return 1161;
    }

    private final String getPackageDeployMode() {
        return "SaaS";
    }

    private final String getPackageJobId() {
        return "880125630";
    }

    private final Map<String, Object> getAllBuildConfigValues() {
        HashMap r1 = new HashMap();
        r1.put("FEISHU_SSO_AID", 0);     // Catch: Exception -> L5
        r1.put("FEISHU_SSO_SIGNATURE", "");     // Catch: Exception -> L5
        r1.put("FEISHU_SSO_APPLICATION_ID", "");     // Catch: Exception -> L5
        r1.put("DEFAULT_BRAND", "feishu");     // Catch: Exception -> L5
        r1.put("DEFAULT_GEO", EnvConst$GEO.CN);     // Catch: Exception -> L5
        r1.put("DEFAULT_UNIT", "eu_nc");     // Catch: Exception -> L5
        Boolean r2 = Boolean.FALSE;     // Catch: Exception -> L5
        r1.put("ENABLE_TRANSLATE_TO_KEY", r2);     // Catch: Exception -> L5
        r1.put("SCS_RUNTIME_ENABLE_APIMONITOR", r2);     // Catch: Exception -> L5
    L7:
        return r1;
    L5:
        e = move-exception;
        Log.e(TAG, "get all build config values error: " + e.getMessage());
        goto L7
    }

    private final int getAppIdByPackage() {
        return CastIntegerProtector.parseInt("835601");
    L4:
        e = move-exception;
        Log.e(TAG, "getAppIdByPackage error:" + e.getMessage());
        return getAppIdExcludeDebug();
    }

    private final LarkBuildConfig getConfig() {
        return (LarkBuildConfig) this.config$delegate.getValue();
    }

    private final b8b.a getLarkAppId() {
        return (b8b.a) this.larkAppId$delegate.getValue();
    }

    private final b8b.b getReleaseInfo() {
        return (b8b.b) this.releaseInfo$delegate.getValue();
    }

    public boolean isAppLifecycle2Enable() {
        return com.ss.android.lark.featuregating.b.d.a().a("mobile.infra.component.applifecycle.v2");
    }

    public OfficeSdkContextInitDependencyImpl() {
        this.config$delegate = LazyKt.lazy(new OfficeSdkContextInitDependencyImpl$config$2(this));
        this.releaseInfo$delegate = LazyKt.lazy(new OfficeSdkContextInitDependencyImpl$releaseInfo$2(this));
        this.larkAppId$delegate = LazyKt.lazy(new OfficeSdkContextInitDependencyImpl$larkAppId$2(this));
    }

    private final int getAppIdExcludeInternalTestPackage() {
        if (getConfig().isDebug() == false) goto L8;
        if (getConfig().isFlavors(new Flavor[]{Flavor.ENV_DEVELOPMENT}) == false) goto L8;
        return 2600;
    L8:
        return getAppIdExcludeDebug();
    }

    private final String getPackageBrand() {
        if (getConfig().getInHouse() == false) goto L5;
        return "feishu_alpha";
    L5:
        return "Feishu";
    }

    private final String getReleaseAction() {
        String r0 = PackageChannelManager.getPangolinChannel(LarkContext.getApplication());
        if (y0.d(r0) == false) goto L5;
        return "";
    L5:
        if (y0.a(r0, "feishu_website_organic_and") == false) goto L7;
        r0 = "website";
    L7:
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    private final int getStandardAppId() {
        return getAppIdExcludeDebug();
    }

    public b8b.a getAppId() {
        return getLarkAppId();
    }

    public LarkBuildConfig getBuildConfig() {
        return getConfig();
    }

    public Application getContext() {
        return LarkContext.getApplication();
    }

    public b8b.b getReleaseInformation() {
        return getReleaseInfo();
    }

    public static final /* synthetic */ Map access$getAllBuildConfigValues(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getAllBuildConfigValues();
    }

    public static final /* synthetic */ int access$getAppIdByPackage(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getAppIdByPackage();
    }

    public static final /* synthetic */ int access$getAppIdExcludeDebug(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getAppIdExcludeDebug();
    }

    public static final /* synthetic */ int access$getAppIdExcludeInternalTestPackage(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getAppIdExcludeInternalTestPackage();
    }

    public static final /* synthetic */ String access$getPackageBrand(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getPackageBrand();
    }

    public static final /* synthetic */ String access$getPackageDeployMode(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getPackageDeployMode();
    }

    public static final /* synthetic */ String access$getPackageJobId(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getPackageJobId();
    }

    public static final /* synthetic */ String access$getReleaseAction(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getReleaseAction();
    }

    public static final /* synthetic */ int access$getStandardAppId(OfficeSdkContextInitDependencyImpl r0) {
        return r0.getStandardAppId();
    }
}
