package com.bytedance.ies.bullet.lynx.init;

import android.graphics.Typeface;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import zm.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f5678a;

    public g(boolean r5) {
        this.f5678a = r5;
    }

    public final Typeface a(int r10, String r11) {
        boolean r5 = false;
        if (this.f5678a == false) goto L23;
        String r12 = r11 + '_' + r10;
        ConcurrentHashMap r13 = mc.a.f20057a;
        Intrinsics.checkNotNullParameter(r12, "url");
        ConcurrentHashMap r14 = mc.a.f20057a;
        if (r14.containsKey(r12) == false) goto L7;
    L17:
        boolean r15 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r16 = new StringBuilder("return typeface with cache, key=");
        r16.append(r12);
        r16.append(", typeface is null = ");
        Intrinsics.checkNotNullParameter(r12, "url");
        Typeface r17 = (Typeface) r14.get(r12);
        Typeface r18 = h.f5681c;
        r16.append(Intrinsics.areEqual(r17, r18));
        com.bytedance.ies.bullet.service.base.b.d(r16.toString(), LogLevel.f5954b, "XLynxKit");
        Intrinsics.checkNotNullParameter(r12, "url");
        if (Intrinsics.areEqual((Typeface) r14.get(r12), r18) == false) goto L20;
        return null;
    L20:
        Intrinsics.checkNotNullParameter(r12, "url");
        return (Typeface) r14.get(r12);
    L7:
        if (i.f5682a == null) goto L9;
        Typeface r19 = g0.b(i.a().getAssets(), r11, r10);
    L10:
        boolean r110 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r111 = com.lynx.tasm.utils.e.b("get typeface from assets, key=", r12, ", typeface is null = ");
        if (r19 != null) goto L13;
        r5 = true;
    L13:
        r111.append(r5);
        com.bytedance.ies.bullet.service.base.b.d(r111.toString(), LogLevel.f5954b, "XLynxKit");
        if (r19 != null) goto L16;
        r19 = h.f5681c;
    L16:
        Intrinsics.checkNotNullParameter(r12, "url");
        Intrinsics.checkNotNullParameter(r19, "cache");
        r14.put(r12, r19);
        goto L17
    L9:
        r19 = null;
        goto L10
    L23:
        if (i.f5682a == null) goto L29;
        Typeface r20 = g0.b(i.a().getAssets(), r11, r10);
        boolean r21 = com.bytedance.ies.bullet.service.base.b.f5956a;
        StringBuilder r22 = com.lynx.tasm.utils.e.b("return typeface without cache,  fontFamilyName=", r11, ", typeface is null = ");
        if (r20 != null) goto L27;
        r5 = true;
    L27:
        r22.append(r5);
        com.bytedance.ies.bullet.service.base.b.d(r22.toString(), LogLevel.f5954b, "XLynxKit");
        return r20;
    L29:
        boolean r23 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d(com.lynx.tasm.utils.g.d("return typeface without cache,  fontFamilyName=", r11, ", LynxKitBase.isContextInitialized() = false"), LogLevel.f5954b, "XLynxKit");
        return null;
    }
}
