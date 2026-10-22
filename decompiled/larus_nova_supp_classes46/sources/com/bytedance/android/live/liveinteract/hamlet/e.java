package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public e(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        Boolean r12 = (Boolean) r11;
        Function0<hg6.g> r13 = this.a.R;
        if (r13 == null) goto L19;
        hg6.g r14 = (hg6.g) r13.invoke();
        if (r14 == null) goto L20;
        ei6.a r15 = r14.V0();
        if (r15 != null) goto L9;
        return;
    L9:
        if (ff0.c.b() == false) goto L14;
        ff0.d r0 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "enable_audio_vad_report", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interval", String.valueOf(vm2.d.I().getVadInterval()))}), 12);
        ri6.b r1 = r15.r();
        if (r1 == null) goto L14;
        r1.h(vm2.d.I().getVadInterval());
    L14:
        if (vm2.d.I().getAedEnable() == false) goto L22;
        ff0.d r2 = ff0.d.a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "enable_audio_aed_report", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("interval", String.valueOf(vm2.d.I().getAedInterval()))}), 12);
        ri6.b r16 = r15.r();
        if (r16 == null) goto L23;
        r16.e(vm2.d.I().getAedInterval());
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    }
}
