package com.bytedance.android.livesdk.floatview;

import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ VideoFloatWindowView a;
    public final /* synthetic */ ILivePlayerClient b;

    public a0(VideoFloatWindowView r1, ILivePlayerClient r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        InnerContextEntity r0 = this.a.l;
        if (r0 == null) goto L9;
        InnerContextEntity.InnerFloatExtra r1 = r0.getEnterExtra();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.getMute() != true) goto L9;
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.booleanValue() == false) goto L17;
        if (r2 == false) goto L18;
        this.b.mute("VideoFloatWindowView.playing");
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }
}
