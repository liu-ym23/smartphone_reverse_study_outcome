package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.strategy.f;
import com.lynx.tasm.behavior.d;
import com.lynx.tasm.utils.c;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f4956c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f4957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.argus.aspect.eventCenter.b f4958b;

    static {
        f4956c = LazyKt.lazy(ArgusGlobalDelegate$Companion$instance$2.f4951a);
    }

    public b() {
        this.f4957a = new f(new c(5));
        this.f4958b = new com.bytedance.ies.argus.aspect.eventCenter.b(new d(5));
    }
}
