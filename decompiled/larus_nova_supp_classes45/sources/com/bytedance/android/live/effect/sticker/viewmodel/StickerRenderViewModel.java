package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livehostapi.business.depend.OnStickerViewListener;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020\t\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+¢\u0006\u0004\b6\u00107J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004R\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\n \u0019*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR#\u0010 \u001a\n \u0019*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerRenderViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", "fromPreview", "Lcom/bytedance/android/live/effect/base/e;", "traceInfo", "", "", "extra", "", "renderSticker", "clearRenderSticker", "updateRenderSticker", "isAllowOtherStickerPreview", "Landroidx/lifecycle/MutableLiveData;", "_renderStickerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "Lkotlin/Lazy;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "kotlin.jvm.PlatformType", "noCameraRenderSettings$delegate", "getNoCameraRenderSettings", "()Ljava/lang/Boolean;", "noCameraRenderSettings", "allowOtherEffectPreviewSetting$delegate", "getAllowOtherEffectPreviewSetting", "allowOtherEffectPreviewSetting", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "initialSelectSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "Lcom/bytedance/android/livehostapi/business/depend/OnStickerViewListener;", "onStickerViewListener", "Lcom/bytedance/android/livehostapi/business/depend/OnStickerViewListener;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "stickerDataViewModel", "Landroidx/lifecycle/LiveData;", "getRenderStickerData", "()Landroidx/lifecycle/LiveData;", "renderStickerData", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;Lcom/bytedance/android/livehostapi/business/depend/OnStickerViewListener;)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerRenderViewModel extends StickerBaseViewModel {
    private final MutableLiveData<Sticker> _renderStickerData;
    private final Lazy allowOtherEffectPreviewSetting$delegate;
    private final Lazy composerManager$delegate;
    private final Sticker initialSelectSticker;
    private final Lazy noCameraRenderSettings$delegate;
    private final OnStickerViewListener onStickerViewListener;
    private final String panel;
    private final LiveEffectScene scene;
    private final LiveEffectContextFactoryDelegate$Type type;

    private final Boolean getAllowOtherEffectPreviewSetting() {
        return (Boolean) this.allowOtherEffectPreviewSetting$delegate.getValue();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    private final Boolean getNoCameraRenderSettings() {
        return (Boolean) this.noCameraRenderSettings$delegate.getValue();
    }

    private final StickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        return (StickerDataViewModel) StickerBaseViewModel.a.a(r1, StickerDataViewModel.class);
    }

    public final void clearRenderSticker() {
        int r0 = x8.a.a;
        x8.a.d("StickerRenderViewModel", "clearRenderSticker " + this.panel, false);
        getComposerManager().b(this.panel, "ApplyStickerInterceptor");
        if (getNoCameraRenderSettings().booleanValue() == true) goto L5;
    L7:
        Sticker r1 = (Sticker) this._renderStickerData.getValue();
        if (r1 == null) goto L12;
        OnStickerViewListener r2 = this.onStickerViewListener;
        if (r2 == null) goto L12;
        r2.onStickerCancel(r1);
    L12:
        this._renderStickerData.setValue(null);
        return;
    L5:
        if (Intrinsics.areEqual(this.panel, d0.c) == false) goto L7;
        getComposerManager().F(false);
        goto L7
    }

    public final boolean isAllowOtherStickerPreview() {
        if (getAllowOtherEffectPreviewSetting().booleanValue() == true) goto L5;
        return true;
    L5:
        Sticker r0 = (Sticker) getRenderStickerData().getValue();
        if (r0 == null) goto L8;
        boolean r1 = r0.getAllowOtherEffectPreview();
    L9:
        boolean r2 = getComposerManager().p();
        if (r1 == false) goto L13;
        if (r2 == true) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = true;
        goto L9
    }

    public final LiveData<Sticker> getRenderStickerData() {
        return this._renderStickerData;
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerRenderViewModel r0) {
        return r0.type;
    }

    public final void updateRenderSticker(Sticker r2) {
        this._renderStickerData.setValue(r2);
    }

    public final void renderSticker(Sticker r13, boolean r14, com.bytedance.android.live.effect.base.e r15, Map<String, String> r16) {
        Intrinsics.checkNotNullParameter(r13, "sticker");
        if (r15 == null) goto L5;
        r15.h = System.currentTimeMillis();
    L5:
        HashMap<String, String> r2 = new HashMap();
        HashMap r5 = new HashMap();
        String r4 = "";
        if (r16 == null) goto L11;
        String r7 = r16.get("effect_type");
        if (r7 == null) goto L11;
        String r9 = r7;
    L13:
        if (r16 == null) goto L16;
        String r11 = r16.get("sub_effect_type");
        if (r11 == null) goto L16;
    L18:
        if (r16 == null) goto L23;
        String r1 = r16.get("effect_category_key");
        if (r1 == null) goto L23;
        r4 = r1;
    L23:
        r5.put("effect_type", r9);
        r5.put("sub_effect_type", r11);
        r5.put("effect_category_key", r4);
        if (getRenderStickerData().getValue() == null) goto L26;
        r2.put("block_update_effect_status_when_remove", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L26:
        getComposerManager().t(this.panel, "ApplyStickerInterceptor", r2);
        Sticker r3 = (Sticker) this._renderStickerData.getValue();
        if (r3 == null) goto L32;
        OnStickerViewListener r6 = this.onStickerViewListener;
        if (r6 == null) goto L32;
        r6.onStickerCancel(r3);
    L32:
        if (getNoCameraRenderSettings().booleanValue() == true) goto L34;
    L39:
        r13.setPanelExtra(r5);
        ILiveEffectComposerManager.f.a(getComposerManager(), this.panel, r13, "ApplyStickerInterceptor", r5, r15, 32);
        OnStickerViewListener r8 = this.onStickerViewListener;
        if (r8 == null) goto L42;
        r8.onStickerChosen(r13);
    L42:
        this._renderStickerData.setValue(r13);
        List<String> r12 = q.a;
        String r17 = r9;
        q.g(r13, r17, this.type, this.scene.getPage(), r14, r11);
        return;
    L34:
        if (Intrinsics.areEqual(this.panel, d0.c) == false) goto L39;
        if (r13.getNoCameraRender() == false) goto L38;
        getComposerManager().F(true);
        goto L39
    L38:
        getComposerManager().F(false);
    L16:
        r11 = "";
    L11:
        r9 = "";
        goto L13
    }

    public StickerRenderViewModel(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4, Sticker r5, OnStickerViewListener r6) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "panel");
        this.type = r2;
        this.scene = r3;
        this.panel = r4;
        this.initialSelectSticker = r5;
        this.onStickerViewListener = r6;
        this._renderStickerData = new MutableLiveData(r5);
        this.composerManager$delegate = LazyKt.lazy(new StickerRenderViewModel$composerManager$2(this));
        this.noCameraRenderSettings$delegate = LazyKt.lazy(StickerRenderViewModel$noCameraRenderSettings$2.INSTANCE);
        this.allowOtherEffectPreviewSetting$delegate = LazyKt.lazy(StickerRenderViewModel$allowOtherEffectPreviewSetting$2.INSTANCE);
    }

    public /* synthetic */ StickerRenderViewModel(LiveEffectContextFactoryDelegate$Type r7, LiveEffectScene r8, String r9, Sticker r11, OnStickerViewListener r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 16) == 0) goto L5;
        r12 = null;
    L5:
        this(r7, r8, r9, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void renderSticker$default(StickerRenderViewModel r0, Sticker r1, boolean r2, com.bytedance.android.live.effect.base.e r3, Map r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.renderSticker(r1, r2, r3, r4);
    }
}
