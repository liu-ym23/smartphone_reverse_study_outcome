package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 {
    public final String a;
    public final String b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r11 = (c0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "HomepageCreateBitableResult(url=" + this.a + ", token=" + this.b + ')';
    }

    public c0(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, BdpShareBaseInfo.CHANNEL_TOKEN);
        this.a = r10;
        this.b = r11;
    }
}
