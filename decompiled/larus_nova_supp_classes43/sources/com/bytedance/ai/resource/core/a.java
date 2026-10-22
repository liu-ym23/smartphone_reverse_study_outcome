package com.bytedance.ai.resource.core;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static String a;

    static {
        a = "";
    }

    public static String a(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        return a + '/' + r10.getPackageName() + "/base_" + r10.getVersionCode();
    }

    public static String b(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        return a + '/' + r10.getPackageName() + "/base_" + r10.getVersionCode() + ".zip";
    }

    public static String c(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        return a + '/' + r10.getPackageName() + "/base_" + r10.getVersionCode() + "/base/bundle.keystore";
    }

    public static String d(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        return a + '/' + r10.getPackageName() + "/base_" + r10.getVersionCode() + "/base/manifest.json";
    }

    public static String e(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        String r0 = r10.getPackageName();
        String r1 = r10.getAppId();
        String r11 = r10.getDigest();
        Intrinsics.checkNotNullParameter(r0, "packageName");
        Intrinsics.checkNotNullParameter(r1, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, "digest");
        return a + '/' + r0 + '/' + r1 + '_' + r11;
    }

    public static String f(AIPackageDeployment.AIPackageDeploymentItem r10) {
        Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
        String r0 = r10.getPackageName();
        String r1 = r10.getAppId();
        String r11 = r10.getDigest();
        Intrinsics.checkNotNullParameter(r0, "packageName");
        Intrinsics.checkNotNullParameter(r1, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, "digest");
        return a + '/' + r0 + '/' + r1 + '_' + r11 + ".zip";
    }
}
