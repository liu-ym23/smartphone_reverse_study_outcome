package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.live.effect.api.l.a {
    public final /* synthetic */ LiveStickerDownloadHelper a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.l.b b;
    public final /* synthetic */ Sticker c;
    public final /* synthetic */ String d;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void a() {
            f r0 = this.a;
            com.bytedance.android.live.effect.api.l.b r1 = r0.b;
            if (r1 == null) goto L5;
            r1.a(r0.c);
        L5:
            Iterator r2 = ((ArrayList) this.a.a.b).iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            ((com.bytedance.android.live.effect.api.l.b) r2.next()).a(this.a.c);
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.effect.api.l.a
    public final void a(boolean r9) {
        if (r9 == false) goto L4;
        AndroidSchedulers.mainThread().scheduleDirect(new a(this));
        return;
    L4:
        LiveStickerDownloadHelper r3 = this.a;
        String r4 = this.d;
        Sticker r6 = this.c;
        com.bytedance.android.live.effect.api.l.b r5 = this.b;
        r3.getClass();
        if (r6.getEffect() != null) goto L7;
        AndroidSchedulers.mainThread().scheduleDirect(new i(r3, r5, r6));
        return;
    L7:
        Effect r11 = r6.getEffect();
        if (r11 == null) goto L13;
        List<String> r0 = r3.c;
        ArrayList r1 = (ArrayList) r0;
        r1.add(r11.getEffectId());
        ((EffectManager) r3.a.getValue()).fetchEffect(r11, new h(r11, r3, r4, r5, r6));
        return;
    }

    public f(LiveStickerDownloadHelper r1, com.bytedance.android.live.effect.api.l.c r2, Sticker r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
