package com.bytedance.badger.utils;

import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class s extends Lambda implements Function0 {
    final /* synthetic */ t a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ ServiceConnection c;

    public s(t r1, ServiceConnection r2, ServiceConnection r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(0);
    }

    public Object invoke() {
        this.a.d.a(this.b, this.c);
        return Unit.INSTANCE;
    }
}
