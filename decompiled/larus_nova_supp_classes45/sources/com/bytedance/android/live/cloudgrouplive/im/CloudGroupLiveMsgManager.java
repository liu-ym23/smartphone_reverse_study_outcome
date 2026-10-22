package com.bytedance.android.live.cloudgrouplive.im;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudGroupLiveMsgManager {
    public d a;
    public final CopyOnWriteArrayList<a> b;
    public final Lazy c;

    public CloudGroupLiveMsgManager() {
        this.b = new CopyOnWriteArrayList();
        this.c = LazyKt.lazy(new CloudGroupLiveMsgManager$mOnMessageListener$2(this));
    }
}
