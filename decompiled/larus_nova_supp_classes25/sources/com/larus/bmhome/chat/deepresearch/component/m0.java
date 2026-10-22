package com.larus.bmhome.chat.deepresearch.component;

import java.util.concurrent.LinkedBlockingQueue;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0<T> {
    public final long a;
    public final LinkedBlockingQueue<T> b;
    public Job c;

    public m0() {
        this.a = 500;
        this.b = new LinkedBlockingQueue();
    }
}
