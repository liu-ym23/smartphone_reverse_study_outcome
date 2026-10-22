package com.bytedance.android.live.revlink.impl.lynxcontainer;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final b a(String r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        return (b) GsonProtectorUtils.fromJson(l97.a.a, r2, TypesJVMKt.getJavaType(Reflection.typeOf(b.class)));
    }
}
