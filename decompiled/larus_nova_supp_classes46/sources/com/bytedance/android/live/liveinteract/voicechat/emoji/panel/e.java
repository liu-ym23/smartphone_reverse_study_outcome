package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends g {
    public final LinkScreenCastType f;
    public final com.bytedance.android.live.liveinteract.linkcast.c g;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        com.bytedance.android.live.liveinteract.linkcast.c r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.c;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void a(HSImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "icon");
        int r0 = qy.a.a;
        com.bytedance.android.live.liveinteract.linkcast.c r1 = this.g;
        if (r1 == null) goto L5;
        String r2 = r1.b;
    L6:
        ImageUtil.loadRoundImage(r3, qy.a.b("", CollectionsKt.listOf(String.valueOf(r2))));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        int r6 = com.bytedance.android.live.liveinteract.linkcast.i.a;
        LinkScreenCastType r7 = this.f;
        com.bytedance.android.live.liveinteract.linkcast.c r0 = this.g;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.a;
        if (r2 == null) goto L6;
    L7:
        com.bytedance.android.live.liveinteract.linkcast.i.a.b(r7, r2);
        q0 r8 = this.e;
        LinkScreenCastType r3 = this.f;
        com.bytedance.android.live.liveinteract.linkcast.c r4 = this.g;
        if (r4 == null) goto L11;
        String r9 = r4.a;
        if (r9 == null) goto L11;
    L12:
        if (r4 == null) goto L17;
        String r10 = r4.c;
        if (r10 == null) goto L17;
        r1 = r10;
    L17:
        r8.H0(r3, r9, r1);
        return;
    L11:
        r9 = "";
    L6:
        r2 = "";
        goto L7
    }

    public e(LinkScreenCastType r2, com.bytedance.android.live.liveinteract.linkcast.c r3, q0 r4) {
        Intrinsics.checkNotNullParameter(r2, "linkCastType");
        Intrinsics.checkNotNullParameter(r4, "action");
        super(r4);
        this.f = r2;
        this.g = r3;
    }
}
