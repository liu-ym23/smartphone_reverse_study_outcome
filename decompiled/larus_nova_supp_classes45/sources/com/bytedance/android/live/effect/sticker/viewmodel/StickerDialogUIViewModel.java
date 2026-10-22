package com.bytedance.android.live.effect.sticker.viewmodel;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.live.effect.sticker.chain.l;
import com.bytedance.android.live.effect.sticker.chain.m;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.n9;
import com.bytedance.android.livesdk.config.o9;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 r2\u00020\u0001:\u0001sBI\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020\u0002\u0012\b\u0010S\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U\u0012\b\u0010Z\u001a\u0004\u0018\u00010Y\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\bp\u0010qJ$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002J\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R!\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010/R!\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010/R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0017078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0017078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00109R<\u0010A\u001a*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070?j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`@0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010E\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020V0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u0004\u0018\u00010Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0017\u0010]\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010d\u001a\u0004\u0018\u00010a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0019\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0e8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u001d\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00170e8F¢\u0006\u0006\u001a\u0004\bl\u0010gR\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00170e8F¢\u0006\u0006\u001a\u0004\bn\u0010g¨\u0006t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDialogUIViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "tabKey", "parentTabKey", "", "generateApplyStickerExtra", "Lcom/bytedance/android/live/effect/sticker/viewmodel/g;", "params", "tabName", "subTabName", "", "sendShowStickerLog", LiveSlardarConstants.EXTRA_KEY_URL, "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "appendParams", "Landroid/content/Context;", "context", "tryApplySticker", "updateSelectSticker", "extra", "updateCurrentSelectStickerExtra", "", "position", "updateCurrentTabPosition", "updateCurrentSecondaryTabPosition", "sendStickerShowLogWhenTabChange", "onStickerViewAttached", "onStickerViewDetached", "onClickHint", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager$delegate", "Lkotlin/Lazy;", "getComposerManager", "()Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager;", "composerManager", "Lcom/bytedance/live/datacontext/m;", "", "searchPageStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getSearchPageStatus", "()Lcom/bytedance/live/datacontext/m;", "searchPageStatus", "Lcom/bytedance/live/datacontext/k;", "hideDialogEvent$delegate", "getHideDialogEvent", "()Lcom/bytedance/live/datacontext/k;", "hideDialogEvent", "stickerDownloadStartEvent$delegate", "getStickerDownloadStartEvent", "stickerDownloadStartEvent", "stickerDownloadCompleteEvent$delegate", "getStickerDownloadCompleteEvent", "stickerDownloadCompleteEvent", "Landroidx/lifecycle/MutableLiveData;", "_currentSelectStickerData", "Landroidx/lifecycle/MutableLiveData;", "", "_selectStickerExtra", "Ljava/util/Map;", "_currentTabPosition", "_currentSecondaryTabPosition", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "showingStickerMap", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "currentStickerItemClickChain", "Lcom/bytedance/android/live/effect/sticker/chain/l;", "hasReportPanelShow", "Z", "getHasReportPanelShow", "()Z", "setHasReportPanelShow", "(Z)V", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "initialSelectSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "", "Lcom/bytedance/android/live/effect/sticker/chain/m;", "stickerApplyInterceptorList", "Ljava/util/List;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;", "abilityProxy", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;", "Lcom/bytedance/android/live/effect/base/f;", "showTraceInfo", "Lcom/bytedance/android/live/effect/base/f;", "getShowTraceInfo", "()Lcom/bytedance/android/live/effect/base/f;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "getStickerDataViewModel", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "stickerDataViewModel", "Landroidx/lifecycle/LiveData;", "getCurrentSelectStickerData", "()Landroidx/lifecycle/LiveData;", "currentSelectStickerData", "getSelectStickerExtra", "()Ljava/util/Map;", "selectStickerExtra", "getCurrentTabPosition", "currentTabPosition", "getCurrentSecondaryTabPosition", "currentSecondaryTabPosition", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;Ljava/util/List;Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/a;Lcom/bytedance/android/live/effect/base/f;)V", "Companion", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDialogUIViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG = "ttlive_anchor_effect_StickerDialogUIViewModel";
    private final MutableLiveData<Integer> _currentSecondaryTabPosition;
    private final MutableLiveData<Sticker> _currentSelectStickerData;
    private final MutableLiveData<Integer> _currentTabPosition;
    private final Map<String, String> _selectStickerExtra;
    private final com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.a abilityProxy;
    private final Lazy composerManager$delegate;
    private l currentStickerItemClickChain;
    private boolean hasReportPanelShow;
    private final p hideDialogEvent$delegate;
    private final Sticker initialSelectSticker;
    private final String panel;
    private final LiveEffectScene scene;
    private final p searchPageStatus$delegate;
    private final com.bytedance.android.live.effect.base.f showTraceInfo;
    private final Map<String, HashMap<String, g>> showingStickerMap;
    private final List<m> stickerApplyInterceptorList;
    private final p stickerDownloadCompleteEvent$delegate;
    private final p stickerDownloadStartEvent$delegate;
    private final LiveEffectContextFactoryDelegate$Type type;

    public static final class a {
        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "searchPageStatus", "getSearchPageStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "hideDialogEvent", "getHideDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "stickerDownloadStartEvent", "getStickerDownloadStartEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerDialogUIViewModel.class, "stickerDownloadCompleteEvent", "getStickerDownloadCompleteEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    private final ILiveEffectComposerManager getComposerManager() {
        return (ILiveEffectComposerManager) this.composerManager$delegate.getValue();
    }

    public final k<Unit> getHideDialogEvent() {
        return (k) this.hideDialogEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getSearchPageStatus() {
        return (com.bytedance.live.datacontext.m) this.searchPageStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Sticker> getStickerDownloadCompleteEvent() {
        return (k) this.stickerDownloadCompleteEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Sticker> getStickerDownloadStartEvent() {
        return (k) this.stickerDownloadStartEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    private final StickerDataViewModel getStickerDataViewModel() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        return (StickerDataViewModel) StickerBaseViewModel.a.a(r1, StickerDataViewModel.class);
    }

    public final LiveData<Integer> getCurrentSecondaryTabPosition() {
        return this._currentSecondaryTabPosition;
    }

    public final LiveData<Sticker> getCurrentSelectStickerData() {
        return this._currentSelectStickerData;
    }

    public final LiveData<Integer> getCurrentTabPosition() {
        return this._currentTabPosition;
    }

    public final boolean getHasReportPanelShow() {
        return this.hasReportPanelShow;
    }

    public final Map<String, String> getSelectStickerExtra() {
        return this._selectStickerExtra;
    }

    public final com.bytedance.android.live.effect.base.f getShowTraceInfo() {
        return this.showTraceInfo;
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerDialogUIViewModel r0) {
        return r0.type;
    }

    public final void setHasReportPanelShow(boolean r1) {
        this.hasReportPanelShow = r1;
    }

    public final void updateCurrentSecondaryTabPosition(int r4) {
        this._currentSecondaryTabPosition.setValue(Integer.valueOf(r4));
        StickerDataViewModel r0 = getStickerDataViewModel();
        EffectCategoryModel r1 = null;
        if (r0 == null) goto L5;
        EffectCategoryModel r2 = r0.getCurrentTabInfo();
    L6:
        StickerDataViewModel r3 = getStickerDataViewModel();
        if (r3 == null) goto L9;
        r1 = r3.getSecondaryTabInfoByPosition(r4);
    L9:
        String r5 = "";
        if (r1 == null) goto L13;
        String r6 = r1.getKey();
        if (r6 == null) goto L13;
    L14:
        if (r2 == null) goto L17;
        String r7 = r2.getName();
        if (r7 == null) goto L17;
    L18:
        if (r1 == null) goto L23;
        String r8 = r1.getName();
        if (r8 == null) goto L23;
        r5 = r8;
    L23:
        sendStickerShowLogWhenTabChange(r6, r7, r5);
        return;
    L17:
        r7 = "";
    L13:
        r6 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void updateCurrentSelectStickerExtra(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        this._selectStickerExtra.clear();
        this._selectStickerExtra.putAll(r2);
    }

    public final void updateCurrentTabPosition(int r9) {
        this._currentTabPosition.setValue(Integer.valueOf(r9));
        StickerDataViewModel r0 = getStickerDataViewModel();
        if (r0 == null) goto L5;
        EffectCategoryModel r11 = r0.getTabInfoByPosition(r9);
    L6:
        StickerDataViewModel r1 = getStickerDataViewModel();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r11 == null) goto L12;
        String r2 = r11.getKey();
        if (r2 == null) goto L12;
    L14:
        if (r1.isMultiCategoryTab(r2) == true) goto L30;
        if (r11 == null) goto L20;
        String r3 = r11.getKey();
        if (r3 == null) goto L20;
        String r4 = r3;
    L21:
        if (r11 == null) goto L26;
        String r12 = r11.getName();
        if (r12 == null) goto L26;
        String r5 = r12;
    L27:
        sendStickerShowLogWhenTabChange$default(this, r4, r5, null, 4, null);
        return;
    L26:
        r5 = "";
    L20:
        r4 = "";
        goto L21
    L30:
        return;
    L12:
        r2 = "";
        goto L14
    L5:
        r11 = null;
        goto L6
    }

    public final void updateSelectSticker(Sticker r3) {
        if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L12;
        Sticker r0 = (Sticker) this._currentSelectStickerData.getValue();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getEffectId();
    L8:
        if (r3 == null) goto L11;
        r1 = r3.getEffectId();
    L11:
        if ((!Intrinsics.areEqual(r2, r1)) == true) goto L12;
        return;
    L7:
        r2 = null;
    L12:
        this._currentSelectStickerData.setValue(r3);
    }

    private final String appendParams(String r4, Sticker r5) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r4;
    L8:
        Uri.Builder r6 = UriProtector.parse(r4).buildUpon();
        String r1 = null;
        if (r5 == null) goto L11;
        String r2 = r5.getEffectId();
    L12:
        Uri.Builder r7 = r6.appendQueryParameter("effect_id", r2);
        if (r5 == null) goto L16;
        r1 = r5.getResourceId();
    L16:
        return r7.appendQueryParameter("resource_id", r1).build().toString();
    L11:
        r2 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final Map<String, String> generateApplyStickerExtra(String r5, String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        StickerDataViewModel r1 = getStickerDataViewModel();
        String r2 = "";
        if (r1 != null) goto L5;
    L15:
        String r3 = "";
    L16:
        r0.put("effect_type", r3);
        StickerDataViewModel r4 = getStickerDataViewModel();
        if (r4 == null) goto L24;
        EffectCategoryModel r7 = r4.getSecondaryTabInfoByTabKey(r5, r6);
        if (r7 == null) goto L24;
        String r8 = r7.getName();
        if (r8 == null) goto L24;
        r2 = r8;
    L24:
        r0.put("sub_effect_type", r2);
        r0.put("effect_category_key", r5);
        return r0;
    L5:
        if (r6.length() != 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L10;
        String r11 = r5;
    L11:
        EffectCategoryModel r12 = r1.getTabInfoByTabKey(r11);
        if (r12 == null) goto L15;
        r3 = r12.getName();
        if (r3 != null) goto L16;
    L10:
        r11 = r6;
        goto L11
    L7:
        r9 = false;
        goto L8
    }

    public final void onStickerViewDetached(String r3, Sticker r4) {
        Intrinsics.checkNotNullParameter(r3, "tabKey");
        Intrinsics.checkNotNullParameter(r4, "sticker");
        HashMap<String, g> r5 = this.showingStickerMap.get(r3);
        if (r5 == null) goto L6;
        g r6 = r5.remove(String.valueOf(r4.getId()));
        return;
    }

    private final void sendShowStickerLog(g r12, String r13, String r14) {
        List<String> r0 = q.a;
        q.h(String.valueOf(r12.a), false, r12.b + 1, r13, this.type, this.scene.getPage(), null, r12.c, r14);
    }

    public final void onClickHint(Context r2, String r3, Sticker r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        appendParams(r3, r4);
    }

    public final void onStickerViewAttached(String r7, Sticker r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "tabKey");
        Intrinsics.checkNotNullParameter(r8, "sticker");
        if (this.showingStickerMap.get(r7) != null) goto L5;
        this.showingStickerMap.put(r7, new HashMap());
    L5:
        HashMap<String, g> r0 = this.showingStickerMap.get(r7);
        if (r0 != null) goto L8;
    L9:
        HashMap<String, g> r1 = this.showingStickerMap.get(r7);
        if (r1 == null) goto L12;
        g r2 = r1.put(String.valueOf(r8.getId()), new g(r8.getId(), r9, r8.getStickerType()));
    L12:
        StickerDataViewModel r3 = getStickerDataViewModel();
        String r4 = null;
        if (r3 == null) goto L15;
        EffectCategoryModel r5 = r3.getCurrentTabInfo();
    L16:
        StickerDataViewModel r6 = getStickerDataViewModel();
        if (r6 == null) goto L19;
        EffectCategoryModel r11 = r6.getCurrentSecondaryTabInfo();
    L20:
        if (r5 == null) goto L22;
        String r12 = r5.getKey();
    L24:
        if (Intrinsics.areEqual(r12, r7) == true) goto L38;
        if (r11 == null) goto L27;
        String r13 = r11.getKey();
    L29:
        if (Intrinsics.areEqual(r13, r7) == true) goto L38;
        if (r5 == null) goto L33;
        r4 = r5.getKey();
    L33:
        if (Intrinsics.areEqual(r4, SpecialTabType.SEARCH.getTabKey()) == true) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r7, "search_0") == true) goto L37;
        return;
    L37:
        if (((Boolean) getSearchPageStatus().getValue()).booleanValue() == true) goto L38;
        return;
    L27:
        r13 = null;
    L38:
        g r14 = new g(r8.getId(), r9, r8.getStickerType());
        String r15 = "";
        if (r5 == null) goto L42;
        String r16 = r5.getName();
        if (r16 == null) goto L42;
    L43:
        if (r11 == null) goto L48;
        String r17 = r11.getName();
        if (r17 == null) goto L48;
        r15 = r17;
    L48:
        sendShowStickerLog(r14, r16, r15);
        return;
    L42:
        r16 = "";
        goto L43
    L22:
        r12 = null;
        goto L24
    L19:
        r11 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L8:
        if (r0.containsKey(String.valueOf(r8.getId())) != true) goto L9;
    }

    public final void sendStickerShowLogWhenTabChange(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tabKey");
        Intrinsics.checkNotNullParameter(r3, "tabName");
        Intrinsics.checkNotNullParameter(r4, "subTabName");
        HashMap<String, g> r5 = this.showingStickerMap.get(r2);
        if (r5 == null) goto L8;
        Iterator<T> r6 = r5.values().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        sendShowStickerLog((g) r6.next(), r3, r4);
        goto L6
    L10:
        return;
    }

    public final void tryApplySticker(Context r14, Sticker r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "sticker");
        Intrinsics.checkNotNullParameter(r16, "tabKey");
        Intrinsics.checkNotNullParameter(r17, "parentTabKey");
        Sticker r3 = (Sticker) getCurrentSelectStickerData().getValue();
        if (r3 != null) goto L5;
    L7:
        l r4 = this.currentStickerItemClickChain;
        if (r4 == null) goto L19;
        Sticker r5 = r4.g;
        if (r5 == null) goto L19;
        if (r5.getId() != r15.getId()) goto L19;
        l r6 = this.currentStickerItemClickChain;
        if (r6 == null) goto L19;
        if (r6.b != true) goto L19;
        return;
    L19:
        if (this.scene == LiveEffectScene.Live) goto L21;
    L28:
        l r7 = this.currentStickerItemClickChain;
        if (r7 == null) goto L31;
        r7.b = false;
    L31:
        l r8 = new l(r14, this.type, this.scene, this.panel, r15, generateApplyStickerExtra(r16, r17), new LinkedList(this.stickerApplyInterceptorList));
        this.currentStickerItemClickChain = r8;
        com.bytedance.android.live.effect.base.e r1 = r8.a;
        if (r1 == null) goto L34;
        r1.a = true;
        String r2 = this.panel;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.c = r2;
        r1.d = RenderTriggerType.SelectByUser;
        r1.f = System.currentTimeMillis();
    L34:
        l r9 = this.currentStickerItemClickChain;
        if (r9 == null) goto L38;
        r9.a();
        return;
    L38:
        return;
    L21:
        if (((Boolean) n9.a.getValue()).booleanValue() == false) goto L28;
        if (((Boolean) o9.a.getValue()).booleanValue() == false) goto L28;
        getComposerManager().q();
        if (r15.getTransferType() != 2) goto L28;
        f2.c("直播中无法使用，请在开播前设置", 0);
        return;
    L5:
        if (r3.getId() != r15.getId()) goto L7;
    }

    public static /* synthetic */ void sendShowStickerLog$default(StickerDialogUIViewModel r0, g r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.sendShowStickerLog(r1, r2, r3);
    }

    public static /* synthetic */ void sendStickerShowLogWhenTabChange$default(StickerDialogUIViewModel r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.sendStickerShowLogWhenTabChange(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerDialogUIViewModel(LiveEffectContextFactoryDelegate$Type r1, LiveEffectScene r2, String r3, Sticker r4, List<? extends m> r5, com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.a r6, com.bytedance.android.live.effect.base.f r7) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r5, "stickerApplyInterceptorList");
        Intrinsics.checkNotNullParameter(r7, "showTraceInfo");
        this.type = r1;
        this.scene = r2;
        this.panel = r3;
        this.initialSelectSticker = r4;
        this.stickerApplyInterceptorList = r5;
        this.showTraceInfo = r7;
        this.composerManager$delegate = LazyKt.lazy(new StickerDialogUIViewModel$composerManager$2(this));
        this.searchPageStatus$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.hideDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.stickerDownloadStartEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.stickerDownloadCompleteEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this._currentSelectStickerData = new MutableLiveData(r4);
        this._selectStickerExtra = new LinkedHashMap();
        this._currentTabPosition = new MutableLiveData();
        this._currentSecondaryTabPosition = new MutableLiveData();
        this.showingStickerMap = new LinkedHashMap();
    }
}
