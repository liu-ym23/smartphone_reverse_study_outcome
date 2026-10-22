package com.bytedance.ai.resource.core;

import android.content.SharedPreferences;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public List<AIPackageManager.a> a;
    public SharedPreferences b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = new ArrayList();
    }

    public final void b() {
        AIPackageNetworkResponse<AIPackageAppList> r0 = o5.b.a().requestPreInstallList();
        AIPackageAppList r1 = r0.getData();
        if (r0.getCode() != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L13;
        if (r1 == null) goto L13;
        a(r1);
        SharedPreferences r11 = this.b;
        if (r11 == null) goto L12;
        SharedPreferences.Editor r12 = r11.edit();
        r12.putString("PRE-LIST", com.bytedance.ai.applet.base.gson.e.c(r1));
        r12.apply();
    L12:
        g.a.d("AIPackageManager", "Get pre-install list successfully ===> data = " + r1);
        return;
    L13:
        g.a.e("AIPackageManager", "Failed to get pre-install list ===> code = " + r0.getCode() + ",msg = " + r0.getMsg());
        SharedPreferences r13 = this.b;
        if (r13 == null) goto L20;
        String r14 = r13.getString("PRE-LIST", null);
        if (r14 == null) goto L21;
        Lazy r15 = com.bytedance.ai.applet.base.gson.e.a;
        a((AIPackageAppList) com.bytedance.ai.applet.base.gson.e.a(r14, AIPackageAppList.class));
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r10 = false;
        goto L7
    }

    public final void a(AIPackageAppList r10) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<AIPackageResponseItem> r11 = r10.getAppList().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        AIPackageDeployment.AIPackageDeploymentItem r12 = AIPackageDeployment.c(r11.next());
        if (r12 == null) goto L4;
        r0.add(r12);
        r1.add(r12);
        goto L4
    L8:
        this.a = r0;
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r13 = AIPackageDeployment.a;
        Intrinsics.checkNotNullParameter(r1, "items");
        Iterator r14 = r1.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        AIPackageDeployment.AIPackageDeploymentItem r15 = (AIPackageDeployment.AIPackageDeploymentItem) r14.next();
        String r16 = r15.getAppId();
        String r17 = r15.getPackageName();
        int r18 = AIPackage.J;
        String r19 = AIPackage.a.a(r17, r16);
        AIPackageDeployment.a.putIfAbsent(r19, r15);
        goto L10
    }
}
