package com.bytedance.ai.resource.core;

import android.content.SharedPreferences;
import com.bytedance.ai.resource.IAIPackageNetService;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.net.AIPackageTTNET;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import t0.d;
import ym.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackagePreInstall;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackagePreInstall.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackagePreInstall.kt\ncom/bytedance/ai/resource/core/AIPackagePreInstall\n+ 2 AIPackageNetworkResponse.kt\ncom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse\n*L\n1#1,77:1\n60#2:78\n*S KotlinDebug\n*F\n+ 1 AIPackagePreInstall.kt\ncom/bytedance/ai/resource/core/AIPackagePreInstall\n*L\n60#1:78\n*E\n"})
public final class AIPackagePreInstall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f2617b;

    public AIPackagePreInstall() {
        this.f2616a = new ArrayList();
    }

    public final void a(AIPackageAppList r5) {
        ArrayList r10 = new ArrayList();
        Iterator<AIPackageResponseItem> r11 = r5.getAppList().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        AIPackageDeployment.AIPackageDeploymentItem r12 = AIPackageDeployment.a(r11.next());
        if (r12 == null) goto L4;
        this.f2616a.add(r12);
        r10.add(r12);
        goto L4
    L8:
        ConcurrentHashMap r13 = AIPackageDeployment.f2573a;
        Intrinsics.checkNotNullParameter(r10, "items");
        Iterator r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        AIPackageDeployment.AIPackageDeploymentItem r15 = (AIPackageDeployment.AIPackageDeploymentItem) r14.next();
        String r16 = r15.getAppId();
        String r17 = a.b(r15.getPackageName(), r16);
        AIPackageDeployment.f2573a.putIfAbsent(r17, r15);
        goto L10
    }

    public final ArrayList a() {
        if (this.f2616a.isEmpty() == false) goto L22;
        AIPackageNetworkResponse<AIPackageAppList> r5 = ((IAIPackageNetService) AIPackageTTNET.f2669a.getValue()).requestPreInstallList();
        AIPackageAppList r10 = r5.getData();
        if (r5.getCode() != 0) goto L13;
        if (r10 == null) goto L13;
        a(r10);
        SharedPreferences r11 = this.f2617b;
        if (r11 == null) goto L10;
        SharedPreferences.Editor r12 = r11.edit();
        Intrinsics.checkNotNullParameter(r10, "value");
        r12.putString("PRE-LIST", z0.a.a().toJson(r10));
        r12.apply();
    L10:
        String r13 = "Get pre-install list successfully ===> data = " + r10;
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r14 = c.f2846a;
        if (r14 == null) goto L22;
        r14.d("AIPackageManager", r13);
    L13:
        String r15 = "Failed to get pre-install list ===> code = " + r5.getCode() + ",msg = " + r5.getMsg();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r16 = c.f2846a;
        if (r16 == null) goto L16;
        r16.e("AIPackageManager", r15);
    L16:
        SharedPreferences r17 = this.f2617b;
        if (r17 == null) goto L22;
        String r18 = r17.getString("PRE-LIST", null);
        if (r18 == null) goto L22;
        a((AIPackageAppList) z0.a.a().fromJson(r18, AIPackageAppList.class));
    L22:
        return this.f2616a;
    }
}
