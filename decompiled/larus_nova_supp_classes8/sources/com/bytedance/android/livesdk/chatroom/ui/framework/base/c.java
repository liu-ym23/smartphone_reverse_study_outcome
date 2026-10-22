package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements Action {
    public final /* synthetic */ CompatComponentScheduler a;
    public final /* synthetic */ Observer b;

    public c(CompatComponentScheduler r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        CompatComponentScheduler.n(this.a).removeObserver(this.b);
    }
}
