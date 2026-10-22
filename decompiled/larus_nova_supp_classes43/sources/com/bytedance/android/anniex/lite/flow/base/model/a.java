package com.bytedance.android.anniex.lite.flow.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final com.bytedance.android.anniex.lite.flow.base.model.b a;
    public final b b;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.base.model.a$a, reason: collision with other inner class name */
    public static final class C0096a {
    }

    public interface b {
        <T extends AnnieXModel> T create(Class<T> r1);
    }

    static {
    }

    public final <T extends AnnieXModel> T a(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        String r1 = r10.getCanonicalName();
        if (r1 == null) goto L15;
        String r11 = "AnnieXModelProvider.DefaultKey:".concat(r1);
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        com.bytedance.android.anniex.lite.flow.base.model.b r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "key");
        T r12 = (T) r0.a.get(r11);
        if (r12 != null) goto L7;
    L9:
        r12 = (T) this.b.create(r10);
        com.bytedance.android.anniex.lite.flow.base.model.b r13 = this.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "AnnieXModel");
        AnnieXModel r14 = r13.a.put(r11, r12);
        if (r14 == null) goto L12;
        r14.a();
    L12:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider.get");
    L13:
        return r12;
    L7:
        if (r10.isInstance(r12) == false) goto L9;
    L15:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public a(com.bytedance.android.anniex.lite.flow.base.model.b r10, d r11) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        Intrinsics.checkNotNullParameter(r11, "factory");
        this.a = r10;
        this.b = r11;
    }
}
