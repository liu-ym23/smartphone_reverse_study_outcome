package com.bytedance.android.ec.adapter.api.state;

import android.os.Bundle;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final Function0<Boolean> b;
    public final Map<String, String> c;
    public final Bundle d;

    public static final class a {
    }

    static {
    }

    public c(String r10, String r11, String r12, String r13, Function0 r14, Map r15, Bundle r16) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_UID);
        Intrinsics.checkNotNullParameter(r11, "secUid");
        Intrinsics.checkNotNullParameter(r12, "clientKey");
        Intrinsics.checkNotNullParameter(r13, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r14, "isLoginFunc");
        Intrinsics.checkNotNullParameter(r15, "reportParams");
        Intrinsics.checkNotNullParameter(r16, "extra");
        this.a = r10;
        this.b = r14;
        this.c = r15;
        this.d = r16;
    }
}
