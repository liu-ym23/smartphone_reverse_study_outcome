package com.bytedance.android.live.lynx.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements e76.b {
    public final /* synthetic */ LiveLynxAlphaPlayer a;

    public h(LiveLynxAlphaPlayer r1) {
        this.a = r1;
    }

    public final void onResult(Object r4) {
        this.a.Q("unknown exception, " + ((Throwable) r4), this.a.g, -6);
        throw null;
    }
}
