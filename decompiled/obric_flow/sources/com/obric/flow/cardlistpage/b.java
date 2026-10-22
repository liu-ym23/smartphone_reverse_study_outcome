package com.obric.flow.cardlistpage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sj.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile g f11456a;

    static {
        f11456a = a.f11441c;
    }

    public static void a() {
        Intrinsics.checkNotNullParameter("CardContainerStatusManager", "tag");
        Intrinsics.checkNotNullParameter("finishDragging", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L7;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardContainerStatusManager", "finishDragging");
        f11456a = a.f11441c;
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("CardContainerStatusManager", "tag");
        Intrinsics.checkNotNullParameter("startCardDragging", "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L7;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("CardContainerStatusManager", "startCardDragging");
        f11456a = a.f11439a;
        return;
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
