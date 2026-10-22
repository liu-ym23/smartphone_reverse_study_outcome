package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(s.class, "ENABLE_FIND_INNER_SCOPE_OPTIMIZE", "getENABLE_FIND_INNER_SCOPE_OPTIMIZE()Z", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_find_inner_scope_optimize", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }

    public static final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f c() {
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L7:
        return (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final GiftExtraRepo a() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftExtraRepo.class);
    L7:
        return (GiftExtraRepo) r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final GiftDataStorageService b() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftDataStorageService.class);
    L7:
        return (GiftDataStorageService) r1;
    L5:
        r1 = null;
        goto L7
    }
}
