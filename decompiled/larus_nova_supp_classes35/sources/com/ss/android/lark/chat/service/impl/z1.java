package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceRequest;
import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceResponse;
import com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class z1 implements m6b.n {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public z1(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    @Override // m6b.n
    public final void Z2(String r10, boolean r11, InnerVideoPreviewFragment$playVideo$1 r12) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r12, "callback");
        GetPreviewVideoSourceRequest.Builder r1 = new GetPreviewVideoSourceRequest.Builder().url(r10).force_update(Boolean.valueOf(r11));
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r1, GetPreviewVideoSourceResponse.ADAPTER, Command.GET_PREVIEW_VIDEO_SOURCE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r13).a()).map(y1.a), r12);
    }
}
