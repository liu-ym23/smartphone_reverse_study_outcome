package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.utils.q;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.p;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ISearchEffectListenerV2;
import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.net.SearchEffectResponseV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 32\u00020\u0001:\u0003456B\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006R&\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020)8F¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100)8F¢\u0006\u0006\u001a\u0004\b/\u0010+¨\u00067"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerBaseViewModel;", "", "newContent", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$b;", "trace", "", "doSearchSticker", "updateSearchContent", "resetSearchStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/effect/sticker/viewmodel/a;", "Lcom/ss/android/ugc/effectmanager/effect/model/SearchEffectModel;", "_stickerSearchResultData", "Landroidx/lifecycle/MutableLiveData;", "_searchContent", "Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$SearchStatus;", "_searchStatus", "Lcom/bytedance/live/datacontext/k;", "tabViewClearContentEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getTabViewClearContentEvent", "()Lcom/bytedance/live/datacontext/k;", "tabViewClearContentEvent", "tabViewCoverClickEvent$delegate", "getTabViewCoverClickEvent", "tabViewCoverClickEvent", "tabViewSearchFailEvent$delegate", "getTabViewSearchFailEvent", "tabViewSearchFailEvent", "tabViewKeywordClickEvent$delegate", "getTabViewKeywordClickEvent", "tabViewKeywordClickEvent", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "scene", "Lcom/bytedance/android/live/effect/api/LiveEffectScene;", "panel", "Ljava/lang/String;", "Landroidx/lifecycle/LiveData;", "getStickerSearchResultData", "()Landroidx/lifecycle/LiveData;", "stickerSearchResultData", "getSearchContent", "searchContent", "getSearchStatus", "searchStatus", "<init>", "(Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;Lcom/bytedance/android/live/effect/api/LiveEffectScene;Ljava/lang/String;)V", "Companion", "a", "SearchStatus", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSearchViewModel extends StickerBaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int SEARCH_COUNT = 60;
    public static final String TAG = "ttlive_anchor_effect_StickerSearchViewModel";
    private final MutableLiveData<String> _searchContent;
    private final MutableLiveData<SearchStatus> _searchStatus;
    private final MutableLiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, b>> _stickerSearchResultData;
    private final String panel;
    private final LiveEffectScene scene;
    private final p tabViewClearContentEvent$delegate;
    private final p tabViewCoverClickEvent$delegate;
    private final p tabViewKeywordClickEvent$delegate;
    private final p tabViewSearchFailEvent$delegate;
    private final LiveEffectContextFactoryDelegate$Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerSearchViewModel$SearchStatus;", "", "None", "Searching", "SearchFinish", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SearchStatus extends Enum<SearchStatus> {
        public static final SearchStatus None = null;
        public static final SearchStatus SearchFinish = null;
        public static final SearchStatus Searching = null;
        public static final /* synthetic */ SearchStatus[] a = null;

        static {
            SearchStatus r1 = new SearchStatus("None", 0);
            None = r1;
            SearchStatus r2 = new SearchStatus("Searching", 1);
            Searching = r2;
            SearchStatus r3 = new SearchStatus("SearchFinish", 2);
            SearchFinish = r3;
            a = new SearchStatus[]{r1, r2, r3};
        }

        public static SearchStatus valueOf(String r1) {
            return (SearchStatus) r27.a.a(SearchStatus.class, r1);
        }

        public static SearchStatus[] values() {
            return (SearchStatus[]) a.clone();
        }

        public SearchStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final int c;
        public final boolean d;
        public final long e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof b) == false) goto L16;
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r6.b) goto L10;
            return false;
        L10:
            if (this.c == r6.c) goto L12;
            return false;
        L12:
            if (this.d == r6.d) goto L14;
            return false;
        L14:
            if (this.e == r6.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (((r2 + r5) * 31) + this.c) * 31;
            boolean r7 = this.d;
            if (r7 == true) goto L13;
            r4 = r7;
        L13:
            long r8 = this.e;
            return ((r6 + r4) * 31) + ((int) (r8 ^ (r8 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "StickerSearchTraceInfo(searchContent=" + this.a + ", searchWithKeyBoard=" + this.b + ", currentSearchIndex=" + this.c + ", clickRecommendKeyword=" + this.d + ", searchStartTime=" + this.e + ")";
        }

        public b(String r2, boolean r3, int r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "searchContent");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = false;
            this.e = r5;
        }
    }

    public static final class c implements ISearchEffectListenerV2 {
        public final /* synthetic */ StickerSearchViewModel a;
        public final /* synthetic */ b b;

        public final void onFail(ExceptionResult r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.C0196a(r4.getException(), this.b));
            StickerSearchViewModel.access$get_searchStatus$p(this.a).setValue(SearchStatus.SearchFinish);
        }

        public final void onSuccess(Object r11) {
            SearchEffectResponseV2 r12 = (SearchEffectResponseV2) r11;
            Intrinsics.checkNotNullParameter(r12, "response");
            SearchEffectModel r13 = r12.getData();
            if (r13 != null) goto L5;
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.C0196a(new Exception("effect model is null"), this.b));
        L17:
            StickerSearchViewModel.access$get_searchStatus$p(this.a).setValue(SearchStatus.SearchFinish);
            return;
        L5:
            List<String> r0 = q.a;
            String r1 = r13.getSearch_id();
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            b r2 = this.b;
            String r3 = r2.a;
            boolean r4 = r2.d;
            boolean r5 = Intrinsics.areEqual(r13.getUse_hot(), Boolean.TRUE);
            long r6 = System.currentTimeMillis() - this.b.e;
            String r7 = StickerSearchViewModel.access$getScene$p(this.a).getPage();
            Intrinsics.checkNotNullParameter(r1, "searchID");
            Intrinsics.checkNotNullParameter(r3, "keyword");
            Intrinsics.checkNotNullParameter(r7, "page");
            Pair[] r8 = new Pair[6];
            r8[0] = TuplesKt.to("live_type", "video_live");
            r8[1] = TuplesKt.to("search_keyword", r3);
            r8[2] = TuplesKt.to("search_id", r1);
            if (r4 == false) goto L11;
            String r9 = "search_rec";
        L12:
            r8[3] = TuplesKt.to("search_method", r9);
            if (r5 == false) goto L15;
            String r14 = "0";
        L16:
            r8[4] = TuplesKt.to("is_success", r14);
            r8[5] = TuplesKt.to("duration", String.valueOf(r6));
            q.e("livesdk_live_sticker_search", MapsKt.hashMapOf(r8), r7);
            StickerSearchViewModel.access$get_stickerSearchResultData$p(this.a).setValue(new com.bytedance.android.live.effect.sticker.viewmodel.a.b(r13, this.b));
            goto L17
        L15:
            r14 = GamePromoteDataContext.GAME_TYPE_MOBILE;
            goto L16
        L11:
            r9 = "search_sug";
            goto L12
        }

        public c(StickerSearchViewModel r1, b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewClearContentEvent", "getTabViewClearContentEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewCoverClickEvent", "getTabViewCoverClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewSearchFailEvent", "getTabViewSearchFailEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(StickerSearchViewModel.class, "tabViewKeywordClickEvent", "getTabViewKeywordClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new a();
    }

    public final k<Unit> getTabViewClearContentEvent() {
        return (k) this.tabViewClearContentEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Unit> getTabViewCoverClickEvent() {
        return (k) this.tabViewCoverClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<String> getTabViewKeywordClickEvent() {
        return (k) this.tabViewKeywordClickEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<Unit> getTabViewSearchFailEvent() {
        return (k) this.tabViewSearchFailEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    public final void resetSearchStatus() {
        this._searchStatus.setValue(SearchStatus.None);
    }

    public final LiveData<String> getSearchContent() {
        return this._searchContent;
    }

    public final LiveData<SearchStatus> getSearchStatus() {
        return this._searchStatus;
    }

    public final LiveData<com.bytedance.android.live.effect.sticker.viewmodel.a<SearchEffectModel, b>> getStickerSearchResultData() {
        return this._stickerSearchResultData;
    }

    public static final /* synthetic */ LiveEffectScene access$getScene$p(StickerSearchViewModel r0) {
        return r0.scene;
    }

    public static final /* synthetic */ MutableLiveData access$get_searchStatus$p(StickerSearchViewModel r0) {
        return r0._searchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_stickerSearchResultData$p(StickerSearchViewModel r0) {
        return r0._stickerSearchResultData;
    }

    public final void updateSearchContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "newContent");
        this._searchContent.setValue(r2);
    }

    public final void doSearchSticker(String r9, b r11) {
        Intrinsics.checkNotNullParameter(r9, "newContent");
        Intrinsics.checkNotNullParameter(r11, "trace");
        this._searchStatus.setValue(SearchStatus.Searching);
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.type).d().searchEffects("0", r9, 60, 0, MapsKt.mapOf(TuplesKt.to("panel", this.panel)), new c(this, r11));
    }

    public StickerSearchViewModel(LiveEffectContextFactoryDelegate$Type r2, LiveEffectScene r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "panel");
        this.type = r2;
        this.scene = r3;
        this.panel = r4;
        this._stickerSearchResultData = new MutableLiveData();
        this._searchContent = new MutableLiveData();
        this._searchStatus = new MutableLiveData(SearchStatus.None);
        this.tabViewClearContentEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewCoverClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewSearchFailEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.tabViewKeywordClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
    }
}
