package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f2714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f2715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2716c;

    public f(long r5, Map r10, AtomicReference r11) {
        this.f2714a = r5;
        this.f2715b = r10;
        this.f2716c = r11;
    }

    @Override // com.bytedance.ai.resource.l
    public final void a(AIPackage r18, String r19, String r20, AIPackage.AIPackageType r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "packageName");
        Intrinsics.checkNotNullParameter(r20, Constant.APPID);
        Intrinsics.checkNotNullParameter(r21, "packageType");
        AtomicReference r12 = this.f2716c;
        long r5 = this.f2714a;
        if (r22 != 0) goto L17;
        if (r18 == null) goto L17;
        String r10 = "===install AIPackage succeed. packageName: " + r18.f2259b + ", appId: " + r18.c() + ", packageType: " + r18.e().name() + ", version: " + r18.f2260c;
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L8;
        r11.d("AIManager", r10);
    L8:
        StringBuilder r13 = com.lynx.tasm.utils.e.b("<initApplet><", r19, ", ");
        r13.append(r18.c());
        r13.append("> ");
        r13.append(r21.name());
        r13.append(" install success");
        String r14 = r13.toString();
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L11;
        r15.i("applet_lifecycle", r14);
    L11:
        r18.B = "aisdk_install";
        j r16 = j.f2734a;
        j.j(r18, r22, r23, System.currentTimeMillis() - r5, this.f2715b);
        AIPackage.PackageStatus r17 = AIPackage.PackageStatus.f2282a;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r18.f2277y = r17;
        j.k(r18, false);
        kotlinx.coroutines.j r24 = (kotlinx.coroutines.j) r12.getAndSet(null);
        if (r24 != null) goto L14;
        return;
    L14:
        if (r24.isActive() == false) goto L30;
        r24.resumeWith(Result.m124constructorimpl(r18));
        return;
    L30:
        return;
    L17:
        StringBuilder r25 = com.lynx.tasm.base.a.e("===Failed to install AIPackage. packageName: ", r19, ", appId: ", r20, ", packageType: ");
        r25.append(r21.name());
        r25.append(" errorCode: ");
        r25.append(r22);
        String r26 = r25.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L20;
        r110.e("AIManager", r26);
    L20:
        StringBuilder r27 = com.lynx.tasm.base.a.e("<initApplet><", r19, ", ", r20, "> ");
        r27.append(r21.name());
        r27.append(" install fail");
        String r28 = r27.toString();
        Intrinsics.checkNotNullParameter("applet_lifecycle", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L23;
        r29.i("applet_lifecycle", r28);
    L23:
        j r30 = j.f2734a;
        z2.d.e("applet_resource_load_end", new i(r19, r20, -1, r21, r22, r23, System.currentTimeMillis() - r5, "aisdk_install", this.f2715b));
        kotlinx.coroutines.j r31 = (kotlinx.coroutines.j) r12.getAndSet(null);
        if (r31 != null) goto L26;
        return;
    L26:
        if (r31.isActive() == false) goto L32;
        r31.resumeWith(Result.m124constructorimpl(null));
        return;
    }
}
