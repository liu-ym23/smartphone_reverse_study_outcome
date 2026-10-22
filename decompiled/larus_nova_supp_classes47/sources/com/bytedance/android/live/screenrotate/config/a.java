package com.bytedance.android.live.screenrotate.config;

import a81.b;
import io.reactivex.functions.Action;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements Action {
    public final /* synthetic */ Map a;
    public final /* synthetic */ b b;

    public a(Map r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.remove(this.b);
    }
}
