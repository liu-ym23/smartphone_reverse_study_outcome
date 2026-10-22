package com.bytedance.android.live.browser.service;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 implements z9.b {
    public b0() {
    }

    public final void D(y6.e r6, FragmentActivity r7) {
        Intrinsics.checkNotNullParameter(r6, "shareInfo");
        Intrinsics.checkNotNullParameter(r7, "activity");
        if (StringsKt.isBlank(r6.b) == false) goto L5;
        return;
    L5:
        ShareParams.Builder r0 = ShareParams.buildShareScene(ShareScene.H5);
        com.bytedance.android.livesdk.share.h r1 = jc1.k.n(IMiddlewareRoomService.class).share();
        if (r1 == null) goto L13;
        String r2 = r6.b;
        if (StringsKt.isBlank(r2) == true) goto L11;
        Uri.Builder r3 = UriProtector.parse(r2).buildUpon();
        r3.appendQueryParameter("__live_platform__", "webcast");
        r2 = r3.build().toString();
    L11:
        ShareParams r8 = r0.setUrl(r2).setDescription(r6.c).setImageUrl(r6.d).setTitle(r6.a).build();
        a0 r4 = new a0();
        r1.a.showShareDialog(r7, r8, r4);
        return;
    }
}
