package com.bytedance.android.livesdk.interactivity.interactive.episode;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ EpisodeInteractiveDialog a;

    public a(EpisodeInteractiveDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        sh6.b r3 = (sh6.b) r2;
        EpisodeInteractiveDialog r4 = this.a;
        int r0 = EpisodeInteractiveDialog.l;
        r4.b();
    }
}
