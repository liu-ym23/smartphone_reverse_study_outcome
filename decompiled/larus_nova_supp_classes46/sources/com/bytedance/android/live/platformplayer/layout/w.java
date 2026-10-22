package com.bytedance.android.live.platformplayer.layout;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public w(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        this.a.sr();
    }
}
