package com.bytedance.android.livesdk.interactivity.interactive.episode;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ EpisodeInteractiveDialog a;

    public b(EpisodeInteractiveDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        EpisodeInteractiveDialog r4 = this.a;
        int r0 = EpisodeInteractiveDialog.l;
        r4.b();
    }
}
