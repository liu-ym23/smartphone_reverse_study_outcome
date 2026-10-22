package com.ss.android.lark.chameleon;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.container.webcontainer.ChameleonImpl;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\nR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/Chameleon;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "()V", "chameleonImpl", "Lcom/ss/android/lark/chameleon/container/webcontainer/ChameleonImpl;", "getChameleonImpl", "()Lcom/ss/android/lark/chameleon/container/webcontainer/ChameleonImpl;", "chameleonImpl$delegate", "Lkotlin/Lazy;", "hostDefaultConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "getChameleonFragment", "Landroidx/fragment/app/Fragment;", "context", "Landroid/content/Context;", "chameleonConfig", "bizPlugins", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "getHostDefaultConfig", "init", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "open", "preloadWebview", "setHostDefaultConfig", "config", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Chameleon {
    public static final Chameleon INSTANCE = null;
    private static final Lazy chameleonImpl$delegate = null;
    private static com.ss.android.lark.chameleon.api.ChameleonConfig hostDefaultConfig;

    private Chameleon() {
    }

    static {
        INSTANCE = new Chameleon();
        chameleonImpl$delegate = LazyKt.lazy(Chameleon$chameleonImpl$2.INSTANCE);
        hostDefaultConfig = new com.ss.android.lark.chameleon.api.ChameleonConfig(null, null, null, null, null, null, null, null, null, 511, null);
    }

    private final ChameleonImpl getChameleonImpl() {
        return (ChameleonImpl) chameleonImpl$delegate.getValue();
    }

    public final com.ss.android.lark.chameleon.api.ChameleonConfig getHostDefaultConfig() {
        return hostDefaultConfig;
    }

    public final void init(com.ss.android.lark.chameleon.idependency.IDependency r2) {
        Intrinsics.checkNotNullParameter(r2, "iDependency");
        getChameleonImpl().init(r2);
    }

    public final void preloadWebview(com.ss.android.lark.chameleon.api.ChameleonConfig r2) {
        getChameleonImpl().preloadWebview(r2);
    }

    public final void setHostDefaultConfig(com.ss.android.lark.chameleon.api.ChameleonConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        hostDefaultConfig = r2;
    }

    public final Fragment getChameleonFragment(Context r2, com.ss.android.lark.chameleon.api.ChameleonConfig r3, List<? extends com.ss.android.lark.chameleon.api.AbsChameleonPlugin> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return getChameleonImpl().getChameleonFragment(r2, r3, r4);
    }

    public final void open(Context r2, com.ss.android.lark.chameleon.api.ChameleonConfig r3, List<? extends com.ss.android.lark.chameleon.api.AbsChameleonPlugin> r4) {
        getChameleonImpl().open(r2, r3, r4);
    }
}
