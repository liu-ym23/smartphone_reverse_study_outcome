package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f2749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f2750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.s f2751c;

    public q(AtomicInteger r5, Ref.BooleanRef r10, kotlinx.coroutines.s r11) {
        this.f2749a = r5;
        this.f2750b = r10;
        this.f2751c = r11;
    }

    @Override // com.bytedance.ai.resource.l
    public final void a(AIPackage r5, String r10, String r11, AIPackage.AIPackageType r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "packageType");
        int r15 = this.f2749a.decrementAndGet();
        Ref.BooleanRef r16 = this.f2750b;
        if (r13 == 0) goto L5;
        r16.element = true;
    L5:
        if (r15 != 0) goto L8;
        this.f2751c.N(Boolean.valueOf(!r16.element));
        return;
    }
}
