package com.bytedance.android.livesdk.dslservice.util.jsb;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends le7.a<ReadableMap> {
    public final ReadableMap M;
    public final PlatformType N;
    public final String O;
    public final ReadableMap P;

    public final Object b() {
        return this.M;
    }

    public final PlatformType c() {
        return this.N;
    }

    public final String d() {
        return this.O;
    }

    public e(String r3, JavaOnlyMap r4) {
        Intrinsics.checkNotNullParameter(r3, "methodName");
        Intrinsics.checkNotNullParameter("", "pageUrl");
        super(r3);
        this.P = r4;
        if (r4 != null) goto L5;
        r4 = new JavaOnlyMap();
    L5:
        this.M = r4;
        this.N = PlatformType.LYNX;
        this.O = "";
    }
}
