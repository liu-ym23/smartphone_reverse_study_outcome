package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;
import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.f0;
import com.bytedance.android.livesdk.config.mq;
import com.bytedance.android.livesdk.config.n21;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0088\u0001BW\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010h\u001a\u00020g\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010k\u001a\u00020\u0010\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010O\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010s¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0013\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0002J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0012J\u0018\u0010\u001d\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000bJ\u001c\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u0007J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u00022\u0006\u0010\u001e\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002J&\u0010(\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002J\u0014\u0010)\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002J\u0010\u0010*\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u0018\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0012J\b\u0010-\u001a\u0004\u0018\u00010\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u0012J\u0010\u0010/\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000bJ\b\u00101\u001a\u0004\u0018\u00010\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u0012J\u0018\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bJ\u0016\u00105\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bJ\u000e\u00106\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bR \u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020:078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00109R!\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0007078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00109R \u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0007078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00109R#\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020E0D8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR)\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070D8\u0006¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010IR#\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020:0D8\u0006¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010IR\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR#\u0010Z\u001a\n U*\u0004\u0018\u00010T0T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR#\u0010_\u001a\n U*\u0004\u0018\u00010[0[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010W\u001a\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010jR\u0014\u0010k\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR$\u0010m\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001d\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070z8F¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0017\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020:0z8F¢\u0006\u0006\u001a\u0004\b~\u0010|R\u001f\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070z8F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010|R \u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0007078F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerDataViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectCategoryModel;", "tabList", "", "removeTabFromTabListForSaas", "", "Lcom/bytedance/android/live/effect/sticker/ui/SpecialTabType;", "specialTabList", "addSpecialTabToTabList", "", "extra", "Lcom/bytedance/android/live/effect/sticker/p;", "generatePanelExtraInfo", "key", "", "ensureValid", "", "getTabPositionByKey", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "effectList", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "convertEffectListToStickerList", "panel", "maxTabSize", "fetchPanelInfo", "sticker", "addToFavorite", "updateStickerFavoriteStatus", "tabKey", "fetchCategoryStickerList", "childrenCategoryIDs", "fetchCategoryInfo", "fetchFavoriteStickerList", "fetchCampaignStickerListFromCacheAndUpdate", "updateCampaignTabStatus", "stickerList", "dealWithPopUpStickerIfNeed", "insertSticker", "dealWithInsertStickerIfNeed", "removeStickerForSaas", "isFavoriteSticker", "position", "getStickerByTabAndPosition", "getCurrentTabInfo", "getTabInfoByPosition", "getTabInfoByTabKey", "getTabPositionByTabKey", "getCurrentSecondaryTabInfo", "getSecondaryTabInfoByPosition", "parentTabKey", "getSecondaryTabInfoByTabKey", "getSecondaryTabPositionByTabKey", "isMultiCategoryTab", "Landroidx/lifecycle/MutableLiveData;", "_categoryListInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerLoadingStatus;", "_panelLoadingStatus", "Lcom/bytedance/live/datacontext/m;", "panelExtraInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getPanelExtraInfo", "()Lcom/bytedance/live/datacontext/m;", "panelExtraInfo", "_favoriteCategoryInfo", "_campaignCategoryInfo", "Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "Lcom/ss/android/ugc/effectmanager/effect/model/CategoryInfoModelList;", "multiCategoryInfoMap", "Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "getMultiCategoryInfoMap", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/c;", "normalCategoryInfoMap", "getNormalCategoryInfoMap", "tabLoadingStatusMap", "getTabLoadingStatusMap", "Lcom/bytedance/android/live/effect/sticker/viewmodel/b;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/f0;", "updatePageStatus", "Lcom/bytedance/android/live/effect/sticker/viewmodel/b;", "getUpdatePageStatus", "()Lcom/bytedance/android/live/effect/sticker/viewmodel/b;", "Lcom/bytedance/android/live/effect/sticker/presenter/o;", "kotlin.jvm.PlatformType", "stickerDataManager$delegate", "Lkotlin/Lazy;", "getStickerDataManager", "()Lcom/bytedance/android/live/effect/sticker/presenter/o;", "stickerDataManager", "Lcom/bytedance/android/live/effect/api/k;", "stickerPresenter$delegate", "getStickerPresenter", "()Lcom/bytedance/android/live/effect/api/k;", "stickerPresenter", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "Ljava/lang/String;", "Lws1/a;", "dataConfig", "Lws1/a;", "Ljava/util/List;", "enableSecondaryTab", "Z", "initialPageStatus", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/f0;", "getInitialPageStatus", "()Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/f0;", "setInitialPageStatus", "(Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/f0;)V", "Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;", "insertStickerInfo", "Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;", "getInsertStickerInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;", "setInsertStickerInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;)V", "Landroidx/lifecycle/LiveData;", "getCategoryListInfo", "()Landroidx/lifecycle/LiveData;", "categoryListInfo", "getPanelLoadingStatus", "panelLoadingStatus", "getFavoriteCategoryInfo", "favoriteCategoryInfo", "getCampaignCategoryInfo", "()Landroidx/lifecycle/MutableLiveData;", "campaignCategoryInfo", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;Lws1/a;Ljava/util/List;ZLcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/f0;Lcom/bytedance/android/livesdkapi/depend/model/InsertStickerInfo;)V", "Companion", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerDataViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static final String NAME_ALL = "全部";
    public static final String TAG = "ttlive_anchor_effect_StickerDataViewModel";
    private final MutableLiveData<List<Sticker>> _campaignCategoryInfo;
    private final MutableLiveData<List<EffectCategoryModel>> _categoryListInfo;
    private final MutableLiveData<List<Sticker>> _favoriteCategoryInfo;
    private final MutableLiveData<StickerLoadingStatus> _panelLoadingStatus;
    private final ws1.a dataConfig;
    private final boolean enableSecondaryTab;
    private f0 initialPageStatus;
    private InsertStickerInfo insertStickerInfo;
    private final c<String, CategoryInfoModelList> multiCategoryInfoMap;
    private final c<String, List<Sticker>> normalCategoryInfoMap;
    private final String panel;
    private final p panelExtraInfo$delegate;
    private final LiveEffectScene scene;
    private final List<SpecialTabType> specialTabList;
    private final Lazy stickerDataManager$delegate;
    private final Lazy stickerPresenter$delegate;
    private final c<String, StickerLoadingStatus> tabLoadingStatusMap;
    private final LiveEffectContextFactoryDelegate$Type type;
    private final com.bytedance.android.live.effect.sticker.viewmodel.b<f0> updatePageStatus;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements k.c {
        public final /* synthetic */ StickerDataViewModel a;
        public final /* synthetic */ String b;

        @Override // com.bytedance.android.live.effect.api.k.c
        public final void onFetchFailed() {
            this.a.getTabLoadingStatusMap().update(this.b, StickerLoadingStatus.Error);
        }

        public b(StickerDataViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.effect.api.k.c
        public final void a(CategoryInfoModelList r5, EffectDataFetchCacheType r6) {
            Intrinsics.checkNotNullParameter(r5, "panelInfo");
            Intrinsics.checkNotNullParameter(r6, "cacheType");
            CategoryInfoModelList r7 = new CategoryInfoModelList(null, 1, null);
            ArrayList r2 = new ArrayList();
            EffectCategoryModel r3 = new EffectCategoryModel(null, 1, null);
            r3.setName(StickerDataViewModel.NAME_ALL);
            r3.setKey(this.b);
            Unit r0 = Unit.INSTANCE;
            r2.add(r3);
            List r8 = r5.getCategoryList();
            if (r8 == null) goto L5;
            r2.addAll(r8);
        L5:
            r7.setCategoryList(r2);
            this.a.getMultiCategoryInfoMap().update(this.b, r7);
            this.a.getTabLoadingStatusMap().update(this.b, StickerLoadingStatus.Normal);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1", f = "StickerDataViewModel.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ StickerDataViewModel this$0;

        public AnonymousClass1(StickerDataViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            MutableLiveData r2 = StickerDataViewModel.access$get_campaignCategoryInfo$p(this.this$0);
            r2.setValue((List) r5);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r6 = Dispatchers.getIO();
            StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1 r3 = new StickerDataViewModel$fetchCampaignStickerListFromCacheAndUpdate$1$stickerList$1(this, null);
            this.label = 1;
            r5 = BuildersKt.withContext(r6, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchCategoryStickerList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03161 implements k.a {
        public final /* synthetic */ StickerDataViewModel a;
        public final /* synthetic */ String b;

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void onFetchFailed() {
            this.a.getTabLoadingStatusMap().update(this.b, StickerLoadingStatus.Error);
        }

        public C03161(StickerDataViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.effect.api.k.a
        public final void a(List<Effect> r7, EffectDataFetchCacheType r8) {
            Intrinsics.checkNotNullParameter(r7, "effectList");
            Intrinsics.checkNotNullParameter(r8, "cacheType");
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new StickerDataViewModel$fetchCategoryStickerList$1$onFetchSuccess$1(this, r7, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel$fetchFavoriteStickerList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03171 implements k.h {
        public final /* synthetic */ StickerDataViewModel a;

        public C03171(StickerDataViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.h
        public final void a(EffectCategoryResponse r8) {
            StickerDataViewModel.access$getStickerPresenter$p(this.a).i(StickerDataViewModel.access$getPanel$p(this.a));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new StickerDataViewModel$fetchFavoriteStickerList$1$onSyncSuccess$1(this, r8, null), 3, null);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StickerDataViewModel.class, "panelExtraInfo", "getPanelExtraInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    private final o getStickerDataManager() {
        return (o) this.stickerDataManager$delegate.getValue();
    }

    private final k getStickerPresenter() {
        return (k) this.stickerPresenter$delegate.getValue();
    }

    public final m<com.bytedance.android.live.effect.sticker.p> getPanelExtraInfo() {
        return (m) this.panelExtraInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void fetchFavoriteStickerList() {
        this.tabLoadingStatusMap.update(SpecialTabType.FAVORITE.getTabKey(), StickerLoadingStatus.Loading);
        getStickerPresenter().m(this.panel, new C03171(this));
        getStickerPresenter().c(this.panel);
    }

    public final EffectCategoryModel getCurrentSecondaryTabInfo() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        StickerDialogUIViewModel r2 = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
        if (r2 == null) goto L8;
        LiveData<Integer> r3 = r2.getCurrentSecondaryTabPosition();
        if (r3 == null) goto L8;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L8;
    L10:
        return getSecondaryTabInfoByPosition(r4.intValue());
    L8:
        r4 = 0;
        goto L10
    }

    public final EffectCategoryModel getCurrentTabInfo() {
        StickerBaseViewModel.a r0 = StickerBaseViewModel.Companion;
        LiveEffectScene r1 = this.scene;
        r0.getClass();
        StickerDialogUIViewModel r2 = (StickerDialogUIViewModel) StickerBaseViewModel.a.a(r1, StickerDialogUIViewModel.class);
        if (r2 == null) goto L8;
        LiveData<Integer> r3 = r2.getCurrentTabPosition();
        if (r3 == null) goto L8;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L8;
    L10:
        return getTabInfoByPosition(r4.intValue());
    L8:
        r4 = 0;
        goto L10
    }

    public final void fetchCampaignStickerListFromCacheAndUpdate() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void updateCampaignTabStatus() {
        String r0 = s1.B(2131916353);
        List r1 = (List) this._campaignCategoryInfo.getValue();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((!r1.isEmpty()) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        List<EffectCategoryModel> r3 = (List) this._categoryListInfo.getValue();
        if (r3 != null) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        SpecialTabType r8 = SpecialTabType.CAMPAIGN;
        int r4 = getTabPositionByKey(r3, r8.getTabKey(), false);
        if (r2 == false) goto L34;
        if (r4 >= 0) goto L51;
        List r5 = (List) this._categoryListInfo.getValue();
        if (r5 == null) goto L21;
        List r6 = CollectionsKt.toMutableList(r5);
        if (r6 == null) goto L21;
    L22:
        List r11 = r6;
        int r7 = getTabPositionByKey$default(this, r11, r0, false, 4, null) + 1;
        if (r7 >= 0) goto L25;
    L27:
        com.bytedance.android.live.effect.sticker.viewmodel.b<f0> r9 = this.updatePageStatus;
        EffectCategoryModel r12 = getCurrentTabInfo();
        if (r12 == null) goto L33;
        String r13 = r12.getKey();
        if (r13 == null) goto L33;
        r0 = r13;
    L33:
        r9.update(new f0(r0, 6));
        this._categoryListInfo.setValue(r11);
        return;
    L25:
        if (r7 >= r11.size()) goto L27;
        EffectCategoryModel r14 = new EffectCategoryModel(null, 1, null);
        r14.setName(r8.getTabName());
        r14.setKey(r8.getTabKey());
        Unit r15 = Unit.INSTANCE;
        ListProtector.add(r11, r7, r14);
    L21:
        r6 = new ArrayList();
        goto L22
    L51:
        return;
    L34:
        if (r4 < 0) goto L53;
        EffectCategoryModel r16 = getCurrentTabInfo();
        if (r16 == null) goto L39;
        String r17 = r16.getKey();
        if (r17 == null) goto L39;
    L41:
        if (Intrinsics.areEqual(r17, r8.getTabKey()) == true) goto L44;
        r0 = r17;
    L44:
        List r18 = (List) this._categoryListInfo.getValue();
        if (r18 == null) goto L48;
        List r19 = CollectionsKt.toMutableList(r18);
        if (r19 == null) goto L48;
    L49:
        ListProtector.remove(r19, r4);
        this.updatePageStatus.update(new f0(r0, 6));
        this._categoryListInfo.setValue(r19);
        return;
    L48:
        r19 = new ArrayList();
    L39:
        r17 = r0;
        goto L41
    L53:
        return;
    L8:
        if (this.specialTabList.contains(SpecialTabType.CAMPAIGN) == false) goto L10;
        r2 = true;
        goto L11
    }

    public final MutableLiveData<List<Sticker>> getCampaignCategoryInfo() {
        return this._campaignCategoryInfo;
    }

    public final LiveData<List<EffectCategoryModel>> getCategoryListInfo() {
        return this._categoryListInfo;
    }

    public final LiveData<List<Sticker>> getFavoriteCategoryInfo() {
        return this._favoriteCategoryInfo;
    }

    public final f0 getInitialPageStatus() {
        return this.initialPageStatus;
    }

    public final InsertStickerInfo getInsertStickerInfo() {
        return this.insertStickerInfo;
    }

    public final c<String, CategoryInfoModelList> getMultiCategoryInfoMap() {
        return this.multiCategoryInfoMap;
    }

    public final c<String, List<Sticker>> getNormalCategoryInfoMap() {
        return this.normalCategoryInfoMap;
    }

    public final LiveData<StickerLoadingStatus> getPanelLoadingStatus() {
        return this._panelLoadingStatus;
    }

    public final c<String, StickerLoadingStatus> getTabLoadingStatusMap() {
        return this.tabLoadingStatusMap;
    }

    public final com.bytedance.android.live.effect.sticker.viewmodel.b<f0> getUpdatePageStatus() {
        return this.updatePageStatus;
    }

    public static final /* synthetic */ String access$getPanel$p(StickerDataViewModel r0) {
        return r0.panel;
    }

    public static final /* synthetic */ List access$getSpecialTabList$p(StickerDataViewModel r0) {
        return r0.specialTabList;
    }

    public static final /* synthetic */ o access$getStickerDataManager$p(StickerDataViewModel r0) {
        return r0.getStickerDataManager();
    }

    public static final /* synthetic */ k access$getStickerPresenter$p(StickerDataViewModel r0) {
        return r0.getStickerPresenter();
    }

    public static final /* synthetic */ LiveEffectContextFactoryDelegate$Type access$getType$p(StickerDataViewModel r0) {
        return r0.type;
    }

    public static final /* synthetic */ MutableLiveData access$get_campaignCategoryInfo$p(StickerDataViewModel r0) {
        return r0._campaignCategoryInfo;
    }

    public static final /* synthetic */ MutableLiveData access$get_categoryListInfo$p(StickerDataViewModel r0) {
        return r0._categoryListInfo;
    }

    public static final /* synthetic */ MutableLiveData access$get_favoriteCategoryInfo$p(StickerDataViewModel r0) {
        return r0._favoriteCategoryInfo;
    }

    public static final /* synthetic */ MutableLiveData access$get_panelLoadingStatus$p(StickerDataViewModel r0) {
        return r0._panelLoadingStatus;
    }

    private final List<Sticker> convertEffectListToStickerList(List<? extends Effect> r4) {
        List<? extends Effect> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Effect r1 = (Effect) r6.next();
        if (LiveEffectSettings.LIVE_EFFECT_FIX_STICKER_CONVERT_WITH_PANEL.getValue().booleanValue() == false) goto L8;
        Sticker r2 = com.bytedance.android.live.effect.sticker.d.d(r1, this.panel);
    L9:
        r0.add(r2);
        goto L4
    L8:
        r2 = com.bytedance.android.live.effect.sticker.d.b(r1);
        r2.setStickerPanel(this.panel);
        goto L9
    L11:
        return CollectionsKt.toMutableList(r0);
    }

    private final com.bytedance.android.live.effect.sticker.p generatePanelExtraInfo(String r11) {
        com.bytedance.android.live.effect.sticker.ui.o r12 = (com.bytedance.android.live.effect.sticker.ui.o) GsonHelper.get().fromJson(r11, com.bytedance.android.live.effect.sticker.ui.o.class);     // Catch: Exception -> L4
    L5:
        String r1 = "";
        if (r12 == null) goto L9;
        String r2 = r12.c();
        if (r2 == null) goto L9;
    L10:
        if (r12 == null) goto L15;
        String r3 = r12.b();
        if (r3 == null) goto L15;
        String r4 = r3;
    L16:
        List r5 = StringsKt.split$default(r4, new String[]{","}, false, 0, 6, null);
        if (r12 == null) goto L23;
        String r13 = r12.a();
        if (r13 == null) goto L23;
        r1 = r13;
    L23:
        return new com.bytedance.android.live.effect.sticker.p(r2, r5, r1);
    L15:
        r4 = "";
    L9:
        r2 = "";
    L4:
        r12 = new com.bytedance.android.live.effect.sticker.ui.o(0);
        goto L5
    }

    private final void removeTabFromTabListForSaas(List<EffectCategoryModel> r6) {
        List r0 = ((n21) mq.a.getValue()).a();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r6.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if ((!r0.contains(((EffectCategoryModel) r3).getId())) == false) goto L7;
        r2.add(r3);
        goto L7
    L11:
        r6.clear();
        r6.addAll(r2);
    }

    public final void fetchCategoryStickerList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tabKey");
        this.tabLoadingStatusMap.update(r5, StickerLoadingStatus.Loading);
        getStickerDataManager().k(this.panel, r5, this.dataConfig.a(), new C03161(this, r5));
    }

    public final EffectCategoryModel getSecondaryTabInfoByPosition(int r4) {
        EffectCategoryModel r0 = getCurrentTabInfo();
        if (r0 == null) goto L12;
        String r1 = r0.getKey();
        if (r1 == null) goto L13;
        CategoryInfoModelList r2 = this.multiCategoryInfoMap.a(r1);
        if (r2 == null) goto L14;
        List r3 = r2.getCategoryList();
        if (r3 != null) goto L11;
        return null;
    L11:
        return (EffectCategoryModel) CollectionsKt.getOrNull(r3, r4);
    L14:
        return null;
    L13:
        return null;
    L12:
        return null;
    }

    public final EffectCategoryModel getTabInfoByPosition(int r2) {
        List r0 = (List) this._categoryListInfo.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (EffectCategoryModel) CollectionsKt.getOrNull(r0, r2);
    }

    public final EffectCategoryModel getTabInfoByTabKey(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tabKey");
        List r0 = (List) this._categoryListInfo.getValue();
        Object r1 = null;
        if (r0 == null) goto L15;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((EffectCategoryModel) r3).getKey(), r5) == false) goto L6;
        r1 = r3;
    L11:
        return (EffectCategoryModel) r1;
    L15:
        return null;
    }

    public final int getTabPositionByTabKey(String r8) {
        Intrinsics.checkNotNullParameter(r8, "tabKey");
        List r0 = (List) this._categoryListInfo.getValue();
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        return getTabPositionByKey$default(this, r0, r8, false, 4, null);
    }

    public final boolean isFavoriteSticker(Sticker r3) {
        return getStickerPresenter().o(this.panel, r3);
    }

    public final boolean isMultiCategoryTab(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabKey");
        CategoryInfoModelList r3 = this.multiCategoryInfoMap.a(r2);
        if (r3 == null) goto L9;
        List r4 = r3.getCategoryList();
        if (r4 == null) goto L9;
        if ((!r4.isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void removeStickerForSaas(List<Sticker> r5) {
        Intrinsics.checkNotNullParameter(r5, "stickerList");
        if (Intrinsics.areEqual(((n21) mq.a.getValue()).b(), Boolean.TRUE) == false) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator<T> r0 = r5.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        if ((!((Sticker) r2).isInteractSticker()) == false) goto L6;
        r1.add(r2);
        goto L6
    L10:
        r5.clear();
        r5.addAll(r1);
        return;
    }

    public final void setInitialPageStatus(f0 r1) {
        this.initialPageStatus = r1;
    }

    public final void setInsertStickerInfo(InsertStickerInfo r1) {
        this.insertStickerInfo = r1;
    }

    public static final /* synthetic */ List access$convertEffectListToStickerList(StickerDataViewModel r0, List r1) {
        return r0.convertEffectListToStickerList(r1);
    }

    public static final /* synthetic */ com.bytedance.android.live.effect.sticker.p access$generatePanelExtraInfo(StickerDataViewModel r0, String r1) {
        return r0.generatePanelExtraInfo(r1);
    }

    public static final /* synthetic */ void access$removeTabFromTabListForSaas(StickerDataViewModel r0, List r1) {
        r0.removeTabFromTabListForSaas(r1);
    }

    private final void addSpecialTabToTabList(List<EffectCategoryModel> r11, List<? extends SpecialTabType> r12) {
        Iterator r13 = CollectionsKt.asReversed(r12).iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        SpecialTabType r0 = (SpecialTabType) r13.next();
        int r1 = e.a[r0.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L4;
        if (getStickerDataManager().b(this.panel) == false) goto L4;
        int r2 = getTabPositionByKey$default(this, r11, s1.B(2131916353), false, 4, null) + 1;
        if (r2 < 0) goto L4;
        if (r2 >= r11.size()) goto L4;
        EffectCategoryModel r4 = new EffectCategoryModel(null, 1, null);
        r4.setName(r0.getTabName());
        r4.setKey(r0.getTabKey());
        Unit r3 = Unit.INSTANCE;
        ListProtector.add(r11, r2, r4);
    L19:
        EffectCategoryModel r5 = new EffectCategoryModel(null, 1, null);
        r5.setName(r0.getTabName());
        r5.setKey(r0.getTabKey());
        Unit r6 = Unit.INSTANCE;
        ListProtector.add(r11, 0, r5);
        goto L4
    }

    public final List<Sticker> dealWithPopUpStickerIfNeed(String r11, List<Sticker> r12) {
        Intrinsics.checkNotNullParameter(r11, "tabKey");
        Intrinsics.checkNotNullParameter(r12, "stickerList");
        InsertStickerInfo r0 = this.insertStickerInfo;
        Sticker r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getInsertTabKey();
    L7:
        if (Intrinsics.areEqual(r11, r2) == false) goto L17;
        InsertStickerInfo r3 = this.insertStickerInfo;
        if (r3 == null) goto L17;
        String r4 = r3.getSecondaryTabKey();
        if (r4 == null) goto L17;
        if (r4.length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 != true) goto L17;
    L23:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L31;
        InsertStickerInfo r14 = this.insertStickerInfo;
        if (r14 == null) goto L31;
        if (r14.getShouldForcePopUp() != true) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == true) goto L34;
        return r12;
    L34:
        InsertStickerInfo r16 = this.insertStickerInfo;
        if (r16 == null) goto L58;
        Sticker r17 = r16.getSticker();
        if (r17 == null) goto L58;
        long r6 = r17.getId();
        Iterator<T> r18 = r12.iterator();
    L40:
        if (r18.hasNext() == false) goto L47;
        Object r7 = r18.next();
        if (((Sticker) r7).getId() != r6) goto L44;
        boolean r8 = true;
    L45:
        if (r8 == false) goto L40;
    L48:
        Sticker r9 = (Sticker) r7;
        if (r9 != null) goto L53;
        InsertStickerInfo r19 = this.insertStickerInfo;
        if (r19 == null) goto L54;
        r1 = r19.getSticker();
    L54:
        if (r1 != null) goto L56;
        return r12;
    L56:
        ArrayList r110 = new ArrayList();
        r110.addAll(r12);
        r110.remove(r1);
        ListProtector.add(r110, 0, r1);
        return r110;
    L53:
        r1 = r9;
        goto L54
    L44:
        r8 = false;
        goto L45
    L47:
        r7 = null;
    L58:
        return r12;
    L31:
        r15 = false;
        goto L32
    L15:
        r5 = false;
    L17:
        InsertStickerInfo r21 = this.insertStickerInfo;
        if (r21 == null) goto L20;
        String r22 = r21.getSecondaryTabKey();
    L22:
        if (Intrinsics.areEqual(r11, r22) == true) goto L23;
        r13 = false;
        goto L25
    L20:
        r22 = null;
        goto L22
    L5:
        r2 = null;
        goto L7
    }

    public final void fetchCategoryInfo(String r9, List<Integer> r11) {
        Intrinsics.checkNotNullParameter(r9, "tabKey");
        Intrinsics.checkNotNullParameter(r11, "childrenCategoryIDs");
        this.tabLoadingStatusMap.update(r9, StickerLoadingStatus.Loading);
        getStickerDataManager().p(this.panel, r9, r11, false, new b(this, r9));
    }

    public final void fetchPanelInfo(String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        this._panelLoadingStatus.setValue(StickerLoadingStatus.Loading);
        o.a.c(getStickerDataManager(), r11, "", r12, false, new C03181(this), this.enableSecondaryTab, 48);
    }

    public final EffectCategoryModel getSecondaryTabInfoByTabKey(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tabKey");
        Intrinsics.checkNotNullParameter(r5, "parentTabKey");
        CategoryInfoModelList r6 = this.multiCategoryInfoMap.a(r5);
        Object r0 = null;
        if (r6 == null) goto L17;
        List r7 = r6.getCategoryList();
        if (r7 == null) goto L18;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(((EffectCategoryModel) r1).getKey(), r4) == false) goto L8;
        r0 = r1;
    L13:
        return (EffectCategoryModel) r0;
    L18:
        return null;
    L17:
        return null;
    }

    public final int getSecondaryTabPositionByTabKey(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "tabKey");
        Intrinsics.checkNotNullParameter(r8, "parentTabKey");
        CategoryInfoModelList r9 = this.multiCategoryInfoMap.a(r8);
        if (r9 == null) goto L6;
        List r11 = r9.getCategoryList();
        if (r11 == null) goto L6;
    L8:
        return getTabPositionByKey$default(this, r11, r7, false, 4, null);
    L6:
        r11 = CollectionsKt.emptyList();
        goto L8
    }

    public final Sticker getStickerByTabAndPosition(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "tabKey");
        if (Intrinsics.areEqual(r3, SpecialTabType.FAVORITE.getTabKey()) == false) goto L8;
        List r5 = (List) this._favoriteCategoryInfo.getValue();
        if (r5 != null) goto L17;
        return null;
    L17:
        return (Sticker) CollectionsKt.getOrNull(r5, r4);
    L8:
        if (Intrinsics.areEqual(r3, SpecialTabType.CAMPAIGN.getTabKey()) == false) goto L12;
        List r6 = (List) this._campaignCategoryInfo.getValue();
        if (r6 != null) goto L19;
        return null;
    L19:
        return (Sticker) CollectionsKt.getOrNull(r6, r4);
    L12:
        List<Sticker> r7 = this.normalCategoryInfoMap.a(r3);
        if (r7 != null) goto L15;
        return null;
    L15:
        return (Sticker) CollectionsKt.getOrNull(r7, r4);
    }

    public final void updateStickerFavoriteStatus(Sticker r7, boolean r8) {
        getStickerPresenter().f(this.panel, r7, r8);
        EffectCategoryResponse r9 = getStickerPresenter().h(this.panel);
        if (r9 == null) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new StickerDataViewModel$updateStickerFavoriteStatus$$inlined$let$lambda$1(r9, null, this), 3, null);
        return;
    }

    public static final /* synthetic */ void access$addSpecialTabToTabList(StickerDataViewModel r0, List r1, List r2) {
        r0.addSpecialTabToTabList(r1, r2);
    }

    private final int getTabPositionByKey(List<EffectCategoryModel> r4, String r5, boolean r6) {
        Iterator<EffectCategoryModel> r7 = r4.iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r7.next().getKey(), r5) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r6 == true) goto L12;
        return r1;
    L12:
        if (r1 >= 0) goto L15;
        return 0;
    L15:
        return r1;
    L9:
        r1 = -1;
        goto L10
    }

    public final void dealWithInsertStickerIfNeed(String r11, Sticker r12, List<Sticker> r13) {
        Intrinsics.checkNotNullParameter(r11, "tabKey");
        Intrinsics.checkNotNullParameter(r13, "stickerList");
        if (LiveEffectSettings.LIVE_STICKER_DIALOG_SCHEMA_ENABLE_FORCE_INSERT.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        InsertStickerInfo r0 = this.insertStickerInfo;
        Object r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getInsertTabKey();
    L9:
        boolean r3 = true;
        if (Intrinsics.areEqual(r11, r2) == false) goto L20;
        InsertStickerInfo r4 = this.insertStickerInfo;
        if (r4 == null) goto L20;
        String r5 = r4.getSecondaryTabKey();
        if (r5 == null) goto L20;
        if (r5.length() != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 != true) goto L20;
    L26:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L46;
        InsertStickerInfo r8 = this.insertStickerInfo;
        if (r8 == null) goto L46;
        if (r8.getShouldForceInsert() != true) goto L46;
        Iterator<T> r9 = r13.iterator();
    L35:
        if (r9.hasNext() == false) goto L44;
        Object r14 = r9.next();
        long r15 = ((Sticker) r14).getId();
        if (r12 != null) goto L39;
    L41:
        boolean r16 = false;
    L42:
        if (r16 == false) goto L35;
        r1 = r14;
        goto L44
    L39:
        if (r15 != r12.getId()) goto L41;
        r16 = true;
    L44:
        if (r1 != null) goto L46;
    L47:
        if (r3 == false) goto L57;
        if (r12 == null) goto L58;
        ListProtector.add(r13, 0, r12);
        getStickerDataManager().d(this.panel, r11, r12);
        return;
    L58:
        return;
    L57:
        return;
    L46:
        r3 = false;
        goto L47
    L18:
        r6 = false;
    L20:
        InsertStickerInfo r17 = this.insertStickerInfo;
        if (r17 == null) goto L23;
        String r18 = r17.getSecondaryTabKey();
    L25:
        if (Intrinsics.areEqual(r11, r18) == true) goto L26;
        r7 = false;
        goto L28
    L23:
        r18 = null;
        goto L25
    L8:
        r2 = null;
        goto L9
    }

    public static /* synthetic */ int getTabPositionByKey$default(StickerDataViewModel r0, List r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        return r0.getTabPositionByKey(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerDataViewModel(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4, ws1.a r5, List<? extends SpecialTabType> r6, boolean r7, f0 r8, InsertStickerInfo r9) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "dataConfig");
        Intrinsics.checkNotNullParameter(r6, "specialTabList");
        this.type = r2;
        this.scene = r3;
        this.panel = r4;
        this.dataConfig = r5;
        this.specialTabList = r6;
        this.enableSecondaryTab = r7;
        this.initialPageStatus = r8;
        this.insertStickerInfo = r9;
        this._categoryListInfo = new MutableLiveData();
        this._panelLoadingStatus = new MutableLiveData();
        this.panelExtraInfo$delegate = q.d(this, new com.bytedance.android.live.effect.sticker.p(0));
        this._favoriteCategoryInfo = new MutableLiveData();
        this._campaignCategoryInfo = new MutableLiveData();
        this.multiCategoryInfoMap = new c();
        this.normalCategoryInfoMap = new c();
        this.tabLoadingStatusMap = new c();
        this.updatePageStatus = new com.bytedance.android.live.effect.sticker.viewmodel.b();
        this.stickerDataManager$delegate = LazyKt.lazy(new StickerDataViewModel$stickerDataManager$2(this));
        this.stickerPresenter$delegate = LazyKt.lazy(new StickerDataViewModel$stickerPresenter$2(this));
    }

    public /* synthetic */ StickerDataViewModel(LiveEffectContextFactoryDelegate$Type r13, LiveEffectScene r14, String r15, ws1.a r16, List r17, boolean r18, f0 r19, InsertStickerInfo r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 64) == 0) goto L5;
        f0 r11 = null;
    L7:
        if ((r22 & 128) == 0) goto L9;
        InsertStickerInfo r12 = null;
    L10:
        this(r13, r14, r15, r16, r17, r18, r11, r12);
        return;
    L9:
        r12 = r21;
        goto L10
    L5:
        r11 = r19;
        goto L7
    }
}
