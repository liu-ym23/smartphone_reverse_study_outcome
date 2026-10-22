package com.bytedance.android.anniex.lite.flow.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements com.bytedance.android.anniex.lite.flow.base.model.a.b {
    public static d a;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.model.a.b
    public final <T extends AnnieXModel> T create(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelClass");
        return r10.newInstance();
    L5:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r10, e);
    L8:
        e = move-exception;
        throw new RuntimeException("Cannot create an instance of " + r10, e);
    }
}
