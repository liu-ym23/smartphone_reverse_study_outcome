package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements k.g {
    public final /* synthetic */ LiveSoundEffectHelper a;
    public final /* synthetic */ LiveSoundEffectHelper.b b;
    public final /* synthetic */ LiveSoundAdapter.ViewHolder c;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r4, Sticker r5) {
        if (Intrinsics.areEqual("livesoundeffect", r4) == false) goto L19;
        if (r5 != null) goto L12;
        Logger.d(g.class.getSimpleName(), "sound effect download fail response: sticker: null");
        LiveSoundEffectHelper.b r6 = this.b;
        if (r6 == null) goto L8;
        r6.onError();
    L8:
        Iterator<LiveSoundEffectHelper.b> r7 = this.a.b.iterator();
    L10:
        if (r7.hasNext() == false) goto L22;
        r7.next().onError();
        goto L10
    L22:
        return;
    L12:
        Logger.d(g.class.getSimpleName(), "sound effect download success ^_^,response: sticker: " + r5.getId() + " path: " + r5.getUnzipPath());
        h.a(r5, this.a.getType());
        r5.setDownloaded(true);
        LiveSoundEffectHelper.b r8 = this.b;
        if (r8 == null) goto L15;
        r8.a(r5);
    L15:
        Iterator<LiveSoundEffectHelper.b> r9 = this.a.b.iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        r9.next().a(r5);
        goto L17
    L23:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r3, Sticker r4) {
        if (r4 == null) goto L5;
        Map<String, Long> r5 = h.a;
        Intrinsics.checkNotNullParameter(r4, "sticker");
        long r0 = System.currentTimeMillis();
        h.a.put(r4.getEffectId(), Long.valueOf(r0));
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.g
    public final void onProgress(int r2, long r3) {
        Iterator<LiveSoundEffectHelper.b> r4 = this.a.b.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().x1(r2, this.c);
        goto L4
    }

    public g(LiveSoundEffectHelper r1, LiveSoundEffectHelper.b r2, LiveSoundAdapter.ViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r4, Sticker r5, ExceptionResult r6) {
        if (Intrinsics.areEqual("livesoundeffect", r4) == false) goto L18;
        String r7 = g.class.getSimpleName();
        StringBuilder r8 = new StringBuilder("sound effect download fail response: sticker: ");
        String r0 = null;
        if (r5 == null) goto L7;
        Long r1 = Long.valueOf(r5.getId());
    L8:
        r8.append(r1);
        r8.append(" path: ");
        if (r5 == null) goto L11;
        r0 = r5.getUnzipPath();
    L11:
        r8.append(r0);
        Logger.d(r7, r8.toString());
        LiveSoundEffectHelper.b r9 = this.b;
        if (r9 == null) goto L14;
        r9.onError();
    L14:
        Iterator<LiveSoundEffectHelper.b> r11 = this.a.b.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        r11.next().onError();
        goto L16
    L20:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
