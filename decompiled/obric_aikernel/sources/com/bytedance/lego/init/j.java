package com.bytedance.lego.init;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f2092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f2093b = null;

    static {
        f2093b = new j();
    }

    private j() {
    }

    @Override // com.bytedance.lego.init.e
    public <T> T a(Class<T> r10) {
        Intrinsics.checkParameterIsNotNull(r10, "clazz");
        e r11 = f2092a;
        if (r11 == null) goto L9;
        if (r11 != null) goto L10;
        return null;
    L10:
        return (T) r11.a(r10);
    L9:
        return (T) c4.d.a(r10);
    }

    public final void b(e r10) {
        f2092a = r10;
    }
}
