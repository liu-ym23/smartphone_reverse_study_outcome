package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.sticker.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import m90.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy$stickerPreloadListener$2$a", "invoke", "()Lcom/bytedance/android/live/effect/view/EffectLivePreviewActivityProxy$stickerPreloadListener$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class EffectLivePreviewActivityProxy$stickerPreloadListener$2 extends Lambda implements Function0<a> {
    final /* synthetic */ EffectLivePreviewActivityProxy this$0;

    public static final class a implements k.i {
        public final /* synthetic */ EffectLivePreviewActivityProxy$stickerPreloadListener$2 a;

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void b() {
            Logger.e("PreviewSticker", "sticker preload error");
        }

        public a(EffectLivePreviewActivityProxy$stickerPreloadListener$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.i
        public final void a(EffectChannelResponse r11) {
            if (r11 != null) goto L4;
        L18:
            Effect r0 = this.a.this$0.a;
            if (r0 == null) goto L25;
            c<Map<String, Long>> r2 = m90.b.s;
            LiveEffectContextFactoryDelegate$Type r3 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
            Map<String, Long> r4 = r2.c(r3);
            boolean r5 = r4.containsKey(r0.getId());
            boolean r6 = true;
            if (r5 != true) goto L23;
            this.a.this$0.a = null;
            goto L25
        L23:
            if (r5 == true) goto L25;
            r4.put(r0.getId(), Long.valueOf(System.currentTimeMillis()));
            r2.e(r3, r4);
        L26:
            if (r6 == true) goto L41;
            if (r11 == null) goto L41;
            if (CollectionUtils.isEmpty(r11.getCategoryResponseList()) == true) goto L41;
            Iterator r12 = r11.getCategoryResponseList().iterator();
        L32:
            if (r12.hasNext() == false) goto L41;
            EffectCategoryResponse r1 = (EffectCategoryResponse) r12.next();
            if (r1 == null) goto L32;
            if (d.g(r1.getExtra(), "icon_random") == false) goto L32;
            if (CollectionUtils.isEmpty(r1.getTotalEffects()) == true) goto L32;
            double r7 = Math.random() * ((double) r1.getTotalEffects().size());
            EffectLivePreviewActivityProxy r13 = this.a.this$0;
            r13.a = (Effect) ListProtector.get(r1.getTotalEffects(), (int) r7);
        L41:
            if (this.a.this$0.a != null) goto L43;
            return;
        L43:
            Intrinsics.throwUninitializedPropertyAccessException("startLiveParamsListener");
            throw null;
        L25:
            r6 = false;
            goto L26
        L4:
            if (CollectionUtils.isEmpty(r11.getCategoryResponseList()) == true) goto L18;
            Iterator r8 = r11.getCategoryResponseList().iterator();
        L7:
            if (r8.hasNext() == false) goto L18;
            EffectCategoryResponse r9 = (EffectCategoryResponse) r8.next();
            if (CollectionUtils.isEmpty(r9.getTotalEffects()) == true) goto L7;
            Iterator r14 = r9.getTotalEffects().iterator();
        L12:
            if (r14.hasNext() == false) goto L7;
            Effect r15 = (Effect) r14.next();
            if (r15 == null) goto L12;
            if (d.g(r15.getExtra(), "icon_insert") == false) goto L12;
            this.a.this$0.a = r15;
            goto L18
        }
    }

    public EffectLivePreviewActivityProxy$stickerPreloadListener$2(EffectLivePreviewActivityProxy r1) {
        this.this$0 = r1;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m854invoke() {
        return invoke();
    }
}
