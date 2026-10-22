package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T1, T2> implements ttc.a {
    public final /* synthetic */ LiveSoundEffectHelper a;
    public final /* synthetic */ LiveSoundEffectHelper.c b;

    public f(LiveSoundEffectHelper r1, LiveSoundEffectHelper.c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6, Object r7) {
        List<Sticker> r8 = (List) r6;
        Throwable r9 = (Throwable) r7;
        List<Sticker> r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L24;
        if (r9 != null) goto L24;
        Iterator r11 = r8.iterator();
    L14:
        if (r11.hasNext() == false) goto L21;
        Sticker r2 = (Sticker) r11.next();
        LiveSoundEffectHelper r3 = this.a;
        r3.getClass();
        List<String> r4 = LiveEffectContext.h;
        r2.setDownloaded(LiveEffectContext.a.a(r3.g).b().r().q(r2));
        if (r2.isDownloaded() == true) goto L20;
        if (LiveSoundEffectHelper.a(r2) == false) goto L20;
        LiveSoundEffectHelper.c(r3, r2, new d(r3, r2), null, 4);
    L20:
        r3.a.add(r2);
        goto L14
    L21:
        LiveSoundEffectHelper.c r12 = this.b;
        if (r12 == null) goto L32;
        r12.onSuccess(r8);
        return;
    L32:
        return;
    L24:
        LiveSoundEffectHelper.c r13 = this.b;
        if (r13 == null) goto L34;
        r13.onError();
        return;
    L34:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
