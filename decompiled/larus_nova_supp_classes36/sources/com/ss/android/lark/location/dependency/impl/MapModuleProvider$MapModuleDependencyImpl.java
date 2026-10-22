package com.ss.android.lark.location.dependency.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(bqb.b.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/location/dependency/impl/MapModuleProvider$MapModuleDependencyImpl;", "Lcom/ss/android/lark/location/dependency/IMapModuleDependency;", "<init>", "()V", "getContext", "Landroid/content/Context;", "getTopActivity", "Landroid/app/Activity;", "getSpecificAMapKey", "", "isFeatureGatingOn", "", TabAppInfo.IMAGE_JSON_KEY, "getLanguageDependency", "Lcom/ss/android/lark/location/dependency/IMapModuleDependency$ILanguageDependency;", "getAppStateDependency", "Lcom/ss/android/lark/location/dependency/IMapModuleDependency$IAppStateDependency;", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MapModuleProvider$MapModuleDependencyImpl implements bqb.b {

    public static final class a implements bqb.b.a {
        public a() {
        }
    }

    public static final class b implements bqb.b.InterfaceC0013b {
        public b() {
        }
    }

    public MapModuleProvider$MapModuleDependencyImpl() {
    }

    public bqb.b.a getAppStateDependency() {
        return new a();
    }

    public bqb.b.InterfaceC0013b getLanguageDependency() {
        return new b();
    }

    public String getSpecificAMapKey() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().getThirdSdkKeys().p;
    }

    public Activity getTopActivity() {
        return AppLifecycle.a.a.f();
    }

    @Override // bqb.b
    public Context getContext() {
        return LarkContext.getApplication();
    }

    public boolean isFeatureGatingOn(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }
}
