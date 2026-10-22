package com.larus.avlink.plugins;

import com.larus.avlink.activeSummary.SoundPlayManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q2 implements SoundPlayManager.b {
    public final /* synthetic */ DoraNotificationSummaryPlugin a;

    public final void onBegin() {
    }

    public final void onEnd() {
        u68.a.a.a(com.larus.audio.call.arch.b.a(this.a.getContext()).e0(), false, "noti_summary_end", 3);
    }

    public final void onError() {
        u68.a.a.a(com.larus.audio.call.arch.b.a(this.a.getContext()).e0(), false, "noti_summary_err", 3);
    }

    public q2(DoraNotificationSummaryPlugin r1) {
        this.a = r1;
    }
}
