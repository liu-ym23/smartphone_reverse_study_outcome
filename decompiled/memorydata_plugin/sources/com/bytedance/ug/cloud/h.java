package com.bytedance.ug.cloud;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f3341a;

    h() {
        this.f3341a = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.ug.cloud.m
    public void a(b r3) {
        final RuntimeException r4 = new RuntimeException();
        this.f3341a.post(new AnonymousClass1(this, r4));
    }
}
