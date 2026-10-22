package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements AdjustPercentBar.d {
    public final /* synthetic */ LiveColorAdjustFragment a;

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void b() {
    }

    public g(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void a(int r5) {
        LiveColorAdjustFragment r6 = this.a;
        Sticker r0 = r6.e;
        if (r0 == null) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        List<String> r2 = LiveEffectContext.h;     // Catch: Throwable -> L14
        Iterator r7 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(r6.getType()).b().n().b).iterator();     // Catch: Throwable -> L14
        int r3 = 0;
    L6:
        if (r7.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((Sticker) r7.next()).getEffectId(), r0.getEffectId()) == true) goto L12;
        r3 = r3 + 1;     // Catch: Throwable -> L14
    L12:
        int r8 = s.a;     // Catch: Throwable -> L14
        s.a(this.a.q, r3, r0, "drag");     // Catch: Throwable -> L14
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Result.box-impl(r9);
        return;
    L11:
        r3 = -1;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
    public final void onChanged(int r9) {
        LiveColorAdjustFragment r0 = this.a;
        if (r0.e != null) goto L5;
        return;
    L5:
        List<String> r1 = LiveEffectContext.h;
        ILiveEffectComposerManager r2 = LiveEffectContext.a.a(r0.getType()).a();
        Sticker r3 = this.a.e;
        Intrinsics.checkNotNull(r3);
        Sticker r4 = this.a.e;
        if (r4 == null) goto L11;
        Sticker.ComposerConfig r5 = r4.getSmallItemConfig();
        if (r5 == null) goto L11;
        String r6 = r5.getTag();
        if (r6 == null) goto L11;
    L12:
        String r7 = r6;
        Sticker r8 = this.a.e;
        Intrinsics.checkNotNull(r8);
        ILiveEffectComposerManager.f.d(r2, "live_adjustment", r3, r7, com.bytedance.android.live.effect.q.d(r8, r9), null, 48);
        this.a.getClass();
        Sticker r11 = this.a.e;
        if (r11 == null) goto L17;
        Sticker.ComposerConfig r12 = r11.getSmallItemConfig();
        if (r12 == null) goto L17;
        int r13 = r12.getDefaultValue();
    L18:
        LiveColorAdjustFragment r14 = this.a;
        boolean r15 = r14.m;
        if (r15 == true) goto L21;
        if (r9 == r13) goto L21;
    L23:
        r14.T90();
    L24:
        this.a.getClass();
        return;
    L21:
        if (r15 == false) goto L24;
        if (r9 != r13) goto L24;
    L17:
        r13 = 0;
    L11:
        r6 = "";
        goto L12
    }
}
