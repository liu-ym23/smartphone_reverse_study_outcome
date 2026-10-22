package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements Callable<Boolean> {
    public final /* synthetic */ r a;
    public final /* synthetic */ String b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        LiveSeiUtil r0 = LiveSeiUtil.i;
        String r1 = this.b;
        r0.getClass();
        JSONObject r2 = LiveSeiUtil.c(r1);
        if (((Boolean) this.a.a.i.getValue()).booleanValue() == false) goto L7;
        this.a.a.h = r2;
        return Boolean.TRUE;
    L7:
        return Boolean.valueOf(this.a.a.a(r2));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Boolean call() {
        return call();
    }

    public q(r r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
