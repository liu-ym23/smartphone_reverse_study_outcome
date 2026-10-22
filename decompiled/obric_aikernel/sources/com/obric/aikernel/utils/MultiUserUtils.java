package com.obric.aikernel.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiUserUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MultiUserUtils f5580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5581b = null;

    static {
        f5580a = new MultiUserUtils();
        f5581b = LazyKt.lazy(MultiUserUtils$_myUserId$2.INSTANCE);
    }

    private MultiUserUtils() {
    }

    private final int b() {
        return ((Number) f5581b.getValue()).intValue();
    }

    public final int a() {
        return b();
    }
}
