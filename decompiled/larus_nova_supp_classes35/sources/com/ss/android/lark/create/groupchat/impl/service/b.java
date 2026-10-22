package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class b implements g {
    public final Map<InterceptorType, Provider<c>> a;
    public final List<InterceptorType> b;

    public static final class a {
    }

    static {
    }

    @Inject
    public b(Map<InterceptorType, Provider<c>> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        this.a = r3;
        this.b = CollectionsKt.listOf(new InterceptorType[]{InterceptorType.HIT_POINT, InterceptorType.GROUP_MEMBER_LIMIT, InterceptorType.EXCEED_GROUP_LIMIT, InterceptorType.EXCEED_GROUP_LIMIT_NEED_APPLY, InterceptorType.BILLING, InterceptorType.DLP, InterceptorType.STRANGER, InterceptorType.DEFAULT});
    }
}
