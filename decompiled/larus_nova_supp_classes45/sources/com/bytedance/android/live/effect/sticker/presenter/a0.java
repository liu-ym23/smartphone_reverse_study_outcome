package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 implements o.b {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ o.c b;
    public final /* synthetic */ Sticker c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ a0 a;

        public a(a0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a0 r0 = this.a;     // Catch: Throwable -> L6
            o.c r1 = r0.b;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.a(r0.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o.b
    public final void a(boolean r6) {
        if (r6 == false) goto L4;
        AndroidSchedulers.mainThread().scheduleDirect(new a(this));
        return;
    L4:
        LiveStickerDataManager r7 = this.a;
        String r0 = this.d;
        Sticker r1 = this.c;
        o.c r2 = this.b;
        r7.getClass();
        if (r1 == null) goto L7;
        Effect r3 = r1.getEffect();
    L8:
        if (r3 != null) goto L10;
        AndroidSchedulers.mainThread().scheduleDirect(new m0(r2, r1));
        return;
    L10:
        Effect r4 = r1.getEffect();
        if (r4 == null) goto L16;
        r7.t().fetchEffect(r4, new l0(r2, r0, r1));
        return;
    L16:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public a0(LiveStickerDataManager r1, com.bytedance.android.live.effect.sticker.chain.b.C0190b r2, Sticker r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
