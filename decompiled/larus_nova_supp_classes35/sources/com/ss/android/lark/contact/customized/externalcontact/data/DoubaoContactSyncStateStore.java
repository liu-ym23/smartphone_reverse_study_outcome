package com.ss.android.lark.contact.customized.externalcontact.data;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DoubaoContactSyncStateStore {
    public final String a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public DoubaoContactSyncStateStore(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.b = LazyKt.lazy(new DoubaoContactSyncStateStore$repo$2(this));
        this.a = r2;
    }
}
