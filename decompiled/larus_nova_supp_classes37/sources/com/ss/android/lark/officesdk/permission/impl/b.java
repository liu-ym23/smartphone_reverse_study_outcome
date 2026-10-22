package com.ss.android.lark.officesdk.permission.impl;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.permission.api.IPermissionRequester;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements IPermissionRequester {
    public b() {
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public final boolean hasPermission(String r2) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        IPermissionRequester r0 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.hasPermission(r2);
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public final boolean hasPermissions(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        IPermissionRequester r0 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.hasPermissions(r2);
    }

    @Override // com.ss.android.lark.officesdk.permission.api.IPermissionRequester
    public void requestPermissions(List<String> r4, Function1<? super Map<String, Boolean>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        Intrinsics.checkNotNullParameter(r5, "onResult");
        IPermissionRequester r0 = (IPermissionRequester) OfficeSDKManager.getHostGlobalService(IPermissionRequester.class);
        if (r0 == null) goto L5;
        r0.requestPermissions(r4, r5);
        return;
    L5:
        List<String> r6 = r4;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Object r2 = r7.next();
        String r3 = (String) r2;
        r1.put(r2, Boolean.FALSE);
        goto L7
    L9:
        r5.invoke(r1);
    }
}
