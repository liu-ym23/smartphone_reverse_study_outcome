package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.model.LayoutEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public n0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        this.a.R8().post(new m0(this, (LayoutEvent) r3));
    }
}
