package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.composer.n;
import com.bytedance.android.live.effect.utils.LiveAnchorBeautifyLogHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements ILiveEffectComposerManager.e, ILiveEffectComposerManager.c {
    public final List<LiveAnchorBeautifyLogHelper> a;
    public final LiveEffectContextFactoryDelegate$Type b;

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.b;
    }

    public d(String r4, LiveEffectContextFactoryDelegate$Type r5) {
        Intrinsics.checkNotNullParameter(r4, "eventPage");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.b = r5;
        this.a = CollectionsKt.listOf(new LiveAnchorBeautifyLogHelper[]{new LiveAnchorBeautifyLogHelper(d0.i, r4, r5), new LiveAnchorBeautifyLogHelper(d0.a, r4, r5), new LiveAnchorBeautifyLogHelper(d0.k, r4, r5), new LiveAnchorBeautifyLogHelper("livebody", r4, r5), new LiveAnchorBeautifyLogHelper("live_adjustment", r4, r5), new LiveAnchorBeautifyLogHelper("live_camera_move", r4, r5)});
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r1, Sticker r2) {
        e(r1, r2);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.k
    public final void c(List<n> r3, Map<String, ? extends List<Sticker>> r4) {
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void e(String r1, Sticker r2) {
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r3.next()).getClass();
        goto L4
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r2, String r3, Sticker r4) {
        d(r2, r3, r4, null);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void d(boolean r3, String r4, Sticker r5, HashMap<String, String> r6) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r0.next()).d(r3, r4, r5, r6);
        goto L4
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r9, Sticker r11, String r12, float r13, HashMap<String, String> r14) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r0.next()).u2(r9, r11, r12, r13, r14);
        goto L4
    }
}
