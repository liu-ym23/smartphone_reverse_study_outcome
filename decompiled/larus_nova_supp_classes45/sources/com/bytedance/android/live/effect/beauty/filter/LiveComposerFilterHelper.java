package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveComposerFilterHelper {
    public final Lazy a;
    public final List<Sticker> b;
    public final List<com.bytedance.android.live.effect.beauty.makeups.a.b> c;
    public final LiveEffectContextFactoryDelegate$Type d;

    public static final class a {
    }

    static {
    }

    public final ILiveEffectComposerManager b() {
        return (ILiveEffectComposerManager) this.a.getValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.d;
    }

    public LiveComposerFilterHelper(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.d = r2;
        this.a = LazyKt.lazy(new LiveComposerFilterHelper$composerManager$2(this));
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final int c(Sticker r3, Sticker.ComposerConfig r4) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Intrinsics.checkNotNullParameter(r4, "composerConfig");
        Float r5 = b().G(r3.getEffectId(), r4.getTag());
        if (r5 != null) goto L6;
        return r4.getDefaultValue();
    L6:
        return q.a(r4, r5.floatValue());
    }

    public final void d(LiveComposerFilterFragment.c r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "page");
        e r3 = new e(this, r9, r11);
        List<String> r12 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.d).b().h().c() == false) goto L5;
        o.a.a(LiveEffectContext.a.a(this.d).b().d(), d0.l, r3, true, true, true, 16);
        return;
    L5:
        LiveEffectContext.a.a(this.d).b().r().p(d0.l, r3, true);
    }

    public static void a(LiveComposerFilterHelper r8, Sticker r9, String r11, String r12, boolean r13, boolean r14, int r15) {
        if ((r15 & 8) == 0) goto L6;
        r13 = false;
    L6:
        if ((r15 & 16) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r15 & 32) == 0) goto L12;
        r14 = false;
    L12:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r11, "trace");
        Intrinsics.checkNotNullParameter(r12, "eventPage");
        HashMap<String, String> r5 = new HashMap();
        if (r0 == false) goto L15;
        r5.put("is_filter_click", "");
    L15:
        if (r14 == false) goto L18;
        r5.put("is_restore", "");
    L18:
        if (r9 != null) goto L20;
        r8.b().k(d0.a, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r11), r5, r13);
        return;
    L20:
        Iterator<T> r16 = r8.b().o(d0.a).iterator();
    L22:
        if (r16.hasNext() == false) goto L26;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Sticker) r17).getResourceId(), r9.getResourceId()) == false) goto L22;
    L28:
        if (((Sticker) r17) != null) goto L35;
        List<String> r18 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a r19 = LiveEffectContext.a.a(r8.d).b().f();
        String r2 = d0.a;
        ((com.bytedance.android.live.effect.beauty.makeups.d) r19).c(r2, r9, r12);
        r8.b().t(r2, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r11), r5);
        ILiveEffectComposerManager.f.a(r8.b(), r2, r9, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r11), r5, null, 48);
        Unit r21 = Unit.INSTANCE;
        return;
    L35:
        return;
    L26:
        r17 = null;
        goto L28
    L8:
        r0 = false;
        goto L10
    }
}
