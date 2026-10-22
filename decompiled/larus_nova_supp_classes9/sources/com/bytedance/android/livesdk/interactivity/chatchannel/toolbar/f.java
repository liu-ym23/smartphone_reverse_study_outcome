package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements s22.e.c {
    public final /* synthetic */ ChatChannelWidgetManager a;

    @Override // s22.e.c
    public final void Ij(long r1, long r3, Long r5, Long r6, Throwable r7) {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Oo() {
    }

    @Override // s22.e.c
    public final void Va(long r1) {
    }

    @Override // s22.e.c
    public final void Y9(long r1) {
    }

    @Override // s22.e.c
    public final void a3(long r1, Throwable r3) {
    }

    @Override // s22.e.c
    public final void p6(long r1) {
    }

    @Override // s22.e.c
    public final void t9(long r1) {
    }

    @Override // s22.e.c
    public final void Df() {
        DataCenter r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.put("match_scroll_to_chat_channel", Boolean.TRUE);
        return;
    }

    public f(ChatChannelWidgetManager r1) {
        this.a = r1;
    }

    @Override // s22.e.c
    public final void Dm(s22.a r3) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r3, "channel");
        DataCenter r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.put("match_scroll_to_chat_channel", Boolean.TRUE);
        return;
    }

    @Override // s22.e.c
    public final void W5(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void d8(s22.a r3) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r3, "channel");
        DataCenter r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.put("match_scroll_to_chat_channel", Boolean.TRUE);
        return;
    }

    @Override // s22.e.c
    public final void gf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "channels");
        Intrinsics.checkNotNullParameter(r2, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void vg(s22.a r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
    }

    @Override // s22.e.c
    public final void D9(s22.a r2, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r2, "channel");
        DataCenter r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.put("match_scroll_to_chat_channel", Boolean.TRUE);
        return;
    }

    @Override // s22.e.c
    public final void Gh(s22.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "channel");
        Intrinsics.checkNotNullParameter(r1, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r1, g r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r1, k r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r3, "response");
    }
}
