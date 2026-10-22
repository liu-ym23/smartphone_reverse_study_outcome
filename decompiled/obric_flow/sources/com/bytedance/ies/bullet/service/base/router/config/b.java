package com.bytedance.ies.bullet.service.base.router.config;

import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f6000c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f6002b;

    static {
        f6000c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, StackManager$Companion$instance$2.f5996a);
    }

    public b() {
        this.f6001a = new ArrayList();
        this.f6002b = new ArrayList();
    }
}
