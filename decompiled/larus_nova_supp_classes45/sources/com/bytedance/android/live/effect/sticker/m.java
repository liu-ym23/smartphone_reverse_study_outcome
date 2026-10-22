package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ k a;

    public m(k r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        k r0 = this.a;
        com.bytedance.android.live.effect.sticker.api.model.a r8 = (com.bytedance.android.live.effect.sticker.api.model.a) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r7)).data;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        List<com.bytedance.android.live.effect.sticker.api.model.b> r9 = r8.a();
        if (r9 == null) goto L17;
        Iterator<T> r11 = r9.iterator();
    L6:
        if (r11.hasNext() == false) goto L17;
        com.bytedance.android.live.effect.sticker.api.model.b r2 = (com.bytedance.android.live.effect.sticker.api.model.b) r11.next();
        if ((!Intrinsics.areEqual(String.valueOf(r2.a()), r0.h)) == false) goto L6;
        List<Long> r3 = r2.b();
        if (r3 == null) goto L6;
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L6;
        long r5 = ((Number) r4.next()).longValue();
        if (r1.contains(Long.valueOf(r5)) == true) goto L13;
        r1.add(Long.valueOf(r5));
    L17:
        r0.b = r1;
        k r12 = this.a;
        if (k.i == true) goto L20;
        r12.getClass();
        return;
    L20:
        r12.e = 0;
        List<Long> r6 = r12.b;
        if (r6 == null) goto L47;
        Iterator<T> r13 = r6.iterator();
    L24:
        if (r13.hasNext() == false) goto L48;
        long r14 = ((Number) r13.next()).longValue();
        Effect r15 = r12.d.get(String.valueOf(r14));
        if (r15 != null) goto L27;
        List<String> r16 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(String.valueOf(r14), new l(r12, r14));
        goto L24
    L27:
        r12.d.put(r15.getEffect_id(), r15);
        r12.a();
        goto L24
    L48:
        return;
    }
}
