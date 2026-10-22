package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final void a(HSImageView r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r3, "url");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Uri r5 = UriProtector.parse(r3);
        Intrinsics.checkNotNullParameter(r2, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(r2, "$this$loadWebp");
        Intrinsics.checkNotNullParameter(r5, "uri");
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(r5).setAutoPlayAnimations(true).setControllerListener(new e(r4)).build());
    }
}
