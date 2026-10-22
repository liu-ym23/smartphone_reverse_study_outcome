package com.bytedance.ies.bullet.service.base;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6007b;

    public t(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, LynxMonitorService.KEY_CHANNEL);
        this.f6006a = r5;
        this.f6007b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r10 = (t) r5;
        String r11 = r10.f6006a;
        if (Intrinsics.areEqual(this.f6006a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f6007b == r10.f6007b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6006a.hashCode() * 31;
        int r10 = k5.d.a(this.f6007b, r5);
        return Boolean.hashCode(false) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PreloadGeckoChannelConfig(channel=");
        r5.append(this.f6006a);
        r5.append(", priority=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.f6007b, ", serial=false)");
    }
}
