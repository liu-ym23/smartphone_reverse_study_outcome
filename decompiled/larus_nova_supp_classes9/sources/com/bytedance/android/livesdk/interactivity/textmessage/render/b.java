package com.bytedance.android.livesdk.interactivity.textmessage.render;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.m4;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAudiencePanelConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final o f;

    public b(o r1) {
        this.f = r1;
        this.a = ((LiveAudiencePanelConfig) m4.a.getValue()).getMessageShowThreshold();
        this.b = s1.h(2131107747);
        this.c = s1.h(2131107748);
        this.d = 2131252697;
        this.e = 2131252698;
    }
}
