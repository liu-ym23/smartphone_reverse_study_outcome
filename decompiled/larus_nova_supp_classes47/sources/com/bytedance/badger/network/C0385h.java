package com.bytedance.badger.network;

import com.bytedance.badger.data.BadgerUpdateInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0385h extends Lambda implements Function1 {
    public static final C0385h a = null;

    static {
        a = new C0385h();
    }

    public C0385h() {
        super(1);
    }

    public Object invoke(Object r1) {
        BadgerUpdateInfo r2 = (BadgerUpdateInfo) r1;
        com.bytedance.badger.monitor.c.c.getClass();
        com.bytedance.badger.monitor.c.e();
        return Unit.INSTANCE;
    }
}
