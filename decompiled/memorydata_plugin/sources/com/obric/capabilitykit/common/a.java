package com.obric.capabilitykit.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/ComponentEnabledChecker;", "", "()V", "TAG", "", "isAppDisabled", "", "pm", "Landroid/content/pm/PackageManager;", ObricMemoryConstants.KEY_PACKAGE_NAME, "isComponentEnabled", "context", "Landroid/content/Context;", "componentName", "Landroid/content/ComponentName;", "isManifestEnabled", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7486b = "ComponentEnabledChecker";

    static {
        f7485a = new a();
    }

    private a() {
    }

    private final boolean a(PackageManager r2, ComponentName r3) {
        boolean r1 = false;
        r1 = r2.getActivityInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L5 Exception -> L11
    L14:
    L5:
        r1 = r2.getServiceInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L7 Exception -> L11
    L7:
        r1 = r2.getReceiverInfo(r3, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L9 Exception -> L11
    L9:
        r1 = r2.getProviderInfo(r3, 0).enabled;     // Catch: Exception -> L11
    L10:
        return r1;
    }

    private final boolean a(PackageManager r2, String r3) {
        ApplicationInfo r1 = r2.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        Intrinsics.checkNotNullExpressionValue(r1, "pm.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L6
        return true ^ r1.enabled;
    L9:
        return true;
    }

    public final boolean a(Context r4, ComponentName r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "componentName");
        PackageManager r7 = r6.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r7, "pm");
        String r0 = r5.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "componentName.packageName");
        if (a(r7, r0) == false) goto L5;
        return false;
    L5:
        int r1 = r7.getComponentEnabledSetting(r5);
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L12;
        return false;
    L12:
        return true;
    L11:
        return a(r7, r5);
    }
}
