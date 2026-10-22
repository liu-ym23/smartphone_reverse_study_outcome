package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.l();
    }
}
