package com.bytedance.android.live.effect.common;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.chain.LiveCommonDownloadStickerInterceptor;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001.B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\r\u001a\u00020\nJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerRenderViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "composerConfig", "", "getTagValue", "Landroid/content/Context;", "context", "", "tryApplySticker", "renderSticker", "clearRenderSticker", "", "", "generateValueMapBySticker", "value", "updateTagValue", "Landroidx/lifecycle/MutableLiveData;", "_renderStickerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "Lkotlin/Lazy;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "currentStickerItemClickChain", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "getRenderStickerData", "()Landroidx/lifecycle/LiveData;", "renderStickerData", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveCommonStickerRenderViewModel extends StickerBaseViewModel {
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_LiveCommonStickerRenderViewModel";
    private final MutableLiveData<Sticker> _renderStickerData;
    private final Lazy composerManager$delegate;
    private com.bytedance.android.live.effect.sticker.chain.l currentStickerItemClickChain;
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    public final void clearRenderSticker() {
        getComposerManager().b(this.panel, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelclearRenderSticker");
        this._renderStickerData.setValue(null);
    }

    public final LiveData<Sticker> getRenderStickerData() {
        return this._renderStickerData;
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(LiveCommonStickerRenderViewModel r0) {
        return r0.type;
    }

    public final Map<String, Integer> generateValueMapBySticker(Sticker r5) {
        if (r5 == null) goto L4;
        List r0 = r5.getComposerConfigList();
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Sticker.ComposerConfig r3 = (Sticker.ComposerConfig) r1.next();
        Pair r4 = TuplesKt.to(r3.getTag(), Integer.valueOf(getTagValue(r5, r3)));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L7
    L9:
        return r2;
    L4:
        return MapsKt.emptyMap();
    }

    public void renderSticker(Sticker r11) {
        Intrinsics.checkNotNullParameter(r11, "sticker");
        getComposerManager().b(this.panel, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelrenderSticker_" + r11.getId());
        getComposerManager().a(this.panel, r11, "ttlive_anchor_effect_LiveCommonStickerRenderViewModelrenderSticker_" + r11.getId());
        Iterator r0 = r11.getComposerConfigList().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Sticker.ComposerConfig r1 = (Sticker.ComposerConfig) r0.next();
        String r5 = r1.getTag();
        Float r2 = getComposerManager().G(r11.getEffectId(), r5);
        if (r2 == null) goto L8;
        float r3 = r2.floatValue();
    L9:
        ILiveEffectComposerManager.f.d(getComposerManager(), this.panel, r11, r5, r3, null, 48);
        goto L4
    L8:
        r3 = com.bytedance.android.live.effect.q.d(r11, r1.getDefaultValue());
        goto L9
    L10:
        this._renderStickerData.setValue(r11);
    }

    private final int getTagValue(Sticker r3, Sticker.ComposerConfig r4) {
        Float r5 = getComposerManager().G(r3.getEffectId(), r4.getTag());
        if (r5 != null) goto L6;
        return r4.getDefaultValue();
    L6:
        return com.bytedance.android.live.effect.q.a(r4, r5.floatValue());
    }

    public final void tryApplySticker(Context r12, Sticker r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "sticker");
        Sticker r0 = (Sticker) this._renderStickerData.getValue();
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.live.effect.sticker.chain.l r1 = this.currentStickerItemClickChain;
        if (r1 == null) goto L18;
        Sticker r2 = r1.g;
        if (r2 == null) goto L18;
        if (r2.getId() != r13.getId()) goto L18;
        com.bytedance.android.live.effect.sticker.chain.l r3 = this.currentStickerItemClickChain;
        if (r3 == null) goto L18;
        if (r3.b != true) goto L18;
        return;
    L18:
        com.bytedance.android.live.effect.sticker.chain.l r4 = this.currentStickerItemClickChain;
        if (r4 == null) goto L21;
        r4.b = false;
    L21:
        com.bytedance.android.live.effect.sticker.chain.l r5 = new com.bytedance.android.live.effect.sticker.chain.l(r12, this.type, this.scene, this.panel, r13, MapsKt.emptyMap(), new LinkedList(CollectionsKt.listOf(new com.bytedance.android.live.effect.sticker.chain.m[]{new com.bytedance.android.live.effect.sticker.chain.j(), new LiveCommonDownloadStickerInterceptor(), new com.bytedance.android.live.effect.sticker.chain.i()})));
        this.currentStickerItemClickChain = r5;
        r5.a();
        return;
    L5:
        if (r0.getId() != r13.getId()) goto L7;
    }

    public LiveCommonStickerRenderViewModel(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "panel");
        this.type = r2;
        this.scene = r3;
        this.panel = r4;
        List<String> r0 = LiveEffectContext.h;
        this._renderStickerData = new MutableLiveData(CollectionsKt.firstOrNull(LiveEffectContext.a.a(r2).a().o(r4)));
        this.composerManager$delegate = LazyKt.lazy(new LiveCommonStickerRenderViewModel$composerManager$2(this));
    }

    public final void updateTagValue(Sticker r9, Sticker.ComposerConfig r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "sticker");
        Intrinsics.checkNotNullParameter(r11, "composerConfig");
        ILiveEffectComposerManager.f.d(getComposerManager(), this.panel, r9, r11.getTag(), com.bytedance.android.live.effect.q.c(r11, r12), null, 48);
    }
}
