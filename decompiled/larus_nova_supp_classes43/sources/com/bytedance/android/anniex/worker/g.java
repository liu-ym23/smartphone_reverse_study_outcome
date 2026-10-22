package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends me7.c {
    public final Context e;
    public final ue7.d f;
    public final PlatformType g;

    public final Context getContext() {
        return this.e;
    }

    public final ue7.d getJsEventDelegate() {
        return this.f;
    }

    public final PlatformType getPlatformType() {
        return this.g;
    }

    public g(String r10, View r11, Context r12, ue7.d r13) {
        Intrinsics.checkNotNullParameter(r10, "containerID");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "jsEventDelegate");
        Intrinsics.checkNotNullParameter("", "namespace");
        super(r10, r11, "");
        this.e = r12;
        this.f = r13;
        this.g = PlatformType.WORKER;
    }
}
