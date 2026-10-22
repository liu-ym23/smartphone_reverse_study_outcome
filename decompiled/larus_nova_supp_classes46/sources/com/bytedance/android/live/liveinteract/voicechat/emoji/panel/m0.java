package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 extends g {
    public final String f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int b() {
        return 2;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String e() {
        return this.f;
    }

    public m0(q0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "url");
        super(r2);
        this.f = r3;
    }
}
