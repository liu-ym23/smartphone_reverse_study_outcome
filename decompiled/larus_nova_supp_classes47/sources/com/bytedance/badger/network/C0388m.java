package com.bytedance.badger.network;

import com.bytedance.badger.Badger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0388m extends Lambda implements Function0 {
    public static final C0388m a = null;

    static {
        a = new C0388m();
    }

    public C0388m() {
        super(0);
    }

    public Object invoke() {
        return new j0(Badger.INSTANCE.getContext().getApplicationContext());
    }
}
