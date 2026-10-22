package com.bytedance.ai.resource.core;

import android.app.Application;
import cn.nubia.neopush.commons.Constant;
import jm.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.r;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.s;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageConfig;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AIPackageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2571a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f2572b = null;

    static {
        f2572b = j0.a();
    }

    public static void a(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Job r10 = f2572b;
        if (((r1) r10).isCompleted() == false) goto L5;
        return;
    L5:
        String r11 = r5.getFilesDir().getPath() + "/ai-sdk-apps";
        f2571a = r11;
        ((s) r10).N(r11);
    }

    public static String b(AIPackageDeployment.AIPackageDeploymentItem r5) {
        Intrinsics.checkNotNullParameter(r5, "deploymentInfo");
        String r10 = r5.getPackageName();
        String r11 = r5.getAppId();
        String r12 = r5.getDigest();
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "digest");
        return f2571a + '/' + r10 + '/' + r11 + '_' + r12;
    }

    public static String c(AIPackageDeployment.AIPackageDeploymentItem r5) {
        Intrinsics.checkNotNullParameter(r5, "deploymentInfo");
        String r10 = r5.getPackageName();
        String r11 = r5.getAppId();
        String r12 = r5.getDigest();
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "digest");
        return f2571a + '/' + r10 + '/' + r11 + '_' + r12 + ".zip";
    }

    public static String a(AIPackageDeployment.AIPackageDeploymentItem r5) {
        Intrinsics.checkNotNullParameter(r5, "deploymentInfo");
        StringBuilder r10 = new StringBuilder();
        r10.append(f2571a);
        r10.append('/');
        c.f(r5, r10, "/base_");
        r10.append(r5.getVersionCode());
        r10.append(".zip");
        return r10.toString();
    }
}
