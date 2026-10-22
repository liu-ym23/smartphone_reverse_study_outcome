package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.live.effect.beauty.makeups.a {
    public final ArrayList<Sticker> a;
    public final ArrayList<com.bytedance.android.live.effect.beauty.makeups.a.b> b;
    public final LiveEffectContextFactoryDelegate$Type c;

    public static final class a {
    }

    public static final class b implements k.f {
        public final /* synthetic */ d a;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r1, Sticker r2) {
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r3, Sticker r4) {
            String r0 = d0.k;
            if (StringUtils.equal(r0, r3) == false) goto L16;
            if (r4 != null) goto L9;
            Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r5 = this.a.b.iterator();
        L7:
            if (r5.hasNext() == false) goto L19;
            r5.next().onError();
            goto L7
        L19:
            return;
        L9:
            d r6 = this.a;
            r6.getClass();
            List<String> r1 = LiveEffectContext.h;
            Sticker r2 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r6.c).a().o(r0));
            if (r2 == null) goto L12;
            com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(r6, r2, "updateLocalTagValue_");
        L12:
            Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r7 = this.a.b.iterator();
        L14:
            if (r7.hasNext() == false) goto L20;
            r7.next().a(r4);
            goto L14
        L20:
            return;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r1, Sticker r2, ExceptionResult r3) {
            if (StringUtils.equal(d0.k, r1) == false) goto L8;
            Iterator<T> r4 = this.a.b.iterator();
        L6:
            if (r4.hasNext() == false) goto L10;
            ((com.bytedance.android.live.effect.beauty.makeups.a.b) r4.next()).onError();
            goto L6
        L10:
            return;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.c;
    }

    public d(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void b(LiveMakeupsBeautyFragment.c r8) {
        System.currentTimeMillis();
        e r2 = new e(this, r8);
        List<String> r9 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.c).b().h().c() == false) goto L5;
        LiveEffectContext.a.a(this.c).b().d().a(d0.k, r2, true, true, false, true);
        return;
    L5:
        LiveEffectContext.a.a(this.c).b().r().p(d0.k, r2, true);
    }

    public final void d(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.c).b().r().q(r4) == false) goto L12;
        Sticker r1 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(this.c).a().o(d0.k));
        if (r1 == null) goto L7;
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(this, r1, "updateLocalTagValue_");
    L7:
        Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r2 = this.b.iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        r2.next().a(r4);
        goto L9
    L11:
        return;
    L12:
        LiveEffectContext.a.a(this.c).b().r().g(d0.k, r4, new b(this));
    }

    public final void a(Sticker r8, String r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "trace");
        if (r8 != null) goto L6;
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.c).a().b(d0.k, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups_stickerIsNull");
        return;
    L6:
        List<String> r13 = LiveEffectContext.h;
        Iterator<T> r14 = LiveEffectContext.a.a(this.c).a().o(d0.k).iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        Object r0 = r14.next();
        if (((Sticker) r0).getResourceId().equals(r8.getResourceId()) == false) goto L8;
    L14:
        if (((Sticker) r0) != null) goto L23;
        List<String> r15 = LiveEffectContext.h;
        ILiveEffectComposerManager r16 = LiveEffectContext.a.a(this.c).a();
        String r1 = d0.k;
        r16.b(r1, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups");
        HashMap r4 = new HashMap();
        if (r11 == false) goto L18;
        r4.put("is_restore", "");
    L18:
        ILiveEffectComposerManager.f.a(LiveEffectContext.a.a(this.c).a(), r1, r8, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups", r4, null, 48);
        Unit r17 = Unit.INSTANCE;
        return;
    L23:
        return;
    L12:
        r0 = null;
        goto L14
    }

    public final void c(String r12, Sticker r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "stickerPanel");
        Intrinsics.checkNotNullParameter(r14, "page");
        Object r1 = null;
        if (Intrinsics.areEqual(r12, d0.a) == false) goto L10;
        List<String> r15 = LiveEffectContext.h;
        Iterator<T> r16 = LiveEffectContext.a.a(this.c).a().o(d0.k).iterator();
    L6:
        if (r16.hasNext() == false) goto L57;
        if ((((Sticker) r16.next()).getStickerFeature() & 1) <= 0) goto L6;
        PthreadHandlerThreadV2 r17 = LiveEffectMonitor.a;
        LiveEffectMonitor.j("effect_mutex_type_makeup_by_filter");
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(this, null, "makeupsRepelIfNeed_FILTER_");
        goto L6
    L57:
        return;
    L10:
        String r0 = d0.c;
        if (Intrinsics.areEqual(r12, r0) == false) goto L20;
        List<String> r18 = LiveEffectContext.h;
        Iterator<T> r19 = LiveEffectContext.a.a(this.c).a().o(d0.k).iterator();
    L14:
        if (r19.hasNext() == false) goto L58;
        Sticker r110 = (Sticker) r19.next();
        if (r13 == null) goto L18;
        r13.getStickerFeature();
    L18:
        r110.getStickerFeature();
        goto L14
    L58:
        return;
    L20:
        if (Intrinsics.areEqual(r12, d0.k) == true) goto L22;
        return;
    L22:
        if (r13 == null) goto L24;
        int r3 = r13.getStickerFeature();
    L26:
        if ((r3 & 1) <= 0) goto L28;
        PthreadHandlerThreadV2 r4 = LiveEffectMonitor.a;
        LiveEffectMonitor.j("effect_mutex_type_filter_by_makeup");
        List<String> r5 = LiveEffectContext.h;
        LiveComposerFilterHelper.a(LiveEffectContext.a.a(this.c).b().m(), null, "makeupsRepelIfNeed_MAKEUPS_", r14, false, false, 56);
    L28:
        List<String> r111 = LiveEffectContext.h;
        Iterator<T> r112 = LiveEffectContext.a.a(this.c).a().o(r0).iterator();
    L30:
        if (r112.hasNext() == false) goto L41;
        Object r2 = r112.next();
        Sticker r6 = (Sticker) r2;
        if (r13 == null) goto L34;
        int r7 = r13.getStickerFeature();
    L36:
        if ((r6.getStickerFeature() & r7) <= 0) goto L38;
        boolean r8 = true;
    L39:
        if (r8 == false) goto L30;
        r1 = r2;
        goto L41
    L38:
        r8 = false;
        goto L39
    L34:
        r7 = 0;
    L41:
        Sticker r9 = (Sticker) r1;
        return;
    L24:
        r3 = 0;
        goto L26
    }

    public final void e(Sticker r9, Sticker.ComposerConfig r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "sticker");
        Intrinsics.checkNotNullParameter(r11, "composerConfig");
        List<String> r0 = LiveEffectContext.h;
        ILiveEffectComposerManager.f.d(LiveEffectContext.a.a(this.c).a(), d0.k, r9, r11.getTag(), q.c(r11, r12), null, 48);
    }
}
