package com.bytedance.android.live.effect.sticker.presenter;

import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements ICheckChannelListener {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ h0 i;

    public final void checkChannelFailed(ExceptionResult r9) {
        this.b.set(false);
        this.a.t().fetchCategoryEffect(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public final void checkChannelSuccess(boolean r9) {
        if (r9 == false) goto L4;
        this.b.set(false);
        this.a.t().fetchCategoryEffect(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        return;
    L4:
        this.b.set(true);
        this.a.t().fetchCategoryEffectFromCache(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public g0(LiveStickerDataManager r1, AtomicBoolean r2, String r3, String r4, int r5, h0 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = 0;
        this.g = 0;
        this.h = "0";
        this.i = r6;
    }
}
