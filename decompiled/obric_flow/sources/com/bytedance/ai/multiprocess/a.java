package com.bytedance.ai.multiprocess;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile u0.c f2400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Function1 f2401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f2402c;
    public final Set d;

    public a() {
        this.d = Collections.synchronizedSet(new LinkedHashSet());
    }
}
