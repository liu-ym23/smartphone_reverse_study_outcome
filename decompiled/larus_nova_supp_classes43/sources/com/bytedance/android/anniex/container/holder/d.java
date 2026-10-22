package com.bytedance.android.anniex.container.holder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class d implements ja.c {
    public d() {
    }

    public abstract ia.b a();

    @Override // ja.c
    public final void loadSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        a().loadSchema(r10, null);
    }
}
