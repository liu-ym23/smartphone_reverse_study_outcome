package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.api.KtvCommonApi;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.b0;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.g;
import com.bytedance.android.live.ktv.common.karaokestation.model.j;
import com.bytedance.android.live.ktv.common.karaokestation.model.n;
import com.bytedance.android.live.ktv.common.karaokestation.model.o;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.ktv.common.karaokestation.model.z;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.live.ktv.common.model.api.m;
import com.bytedance.android.live.ktv.common.model.api.o0;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0002stB\u000f\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bo\u0010pB\t\b\u0016¢\u0006\u0004\bo\u0010qJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u007f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0002JV\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u001d2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001d2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\nH\u0002J \u0010(\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002J*\u0010-\u001a\u00020\b*\b\u0012\u0004\u0012\u00020)0%2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010%2\u0006\u0010,\u001a\u00020\nH\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u00102\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\rH\u0016J&\u00109\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0014\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010706H\u0016J \u0010?\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020)2\u0006\u0010>\u001a\u00020=H\u0016J\u0018\u0010B\u001a\u00020\b2\u0006\u0010<\u001a\u00020)2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\b2\u0006\u0010<\u001a\u00020)2\u0006\u0010A\u001a\u00020@H\u0016J\u0016\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J*\u0010G\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0018\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D06H\u0016J\b\u0010H\u001a\u00020\bH\u0016J\u0018\u0010J\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010I\u001a\u00020EH\u0016J\b\u0010K\u001a\u00020\bH\u0014Jo\u0010M\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010L\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0017Jo\u0010O\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\n2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0016J\u001a\u0010Q\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\nH\u0016J\u0018\u0010R\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001072\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J0\u0010S\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u001e\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0%0D06H\u0016J\u001e\u0010T\u001a\u00020\b2\u0006\u00105\u001a\u0002042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b06H\u0016J\b\u0010U\u001a\u00020\u0003H\u0016R \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R \u0010^\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010WR \u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020_0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010WR\"\u0010a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010WR\u0018\u0010c\u001a\u00060bR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR&\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR,\u0010h\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0%0D0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010gR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\u001b0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010gR \u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00120\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010WR\"\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001070e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010gR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006u"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/CommonOrderSongViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/b;", "", "tabMode", "firstLevelTabValue", "Lcom/bytedance/android/live/ktv/common/model/api/m;", "response", "", "updateTabListSp", "", "defaultLabelName", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "requestCallback", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/d;", "firstLevelTabData", "", "startTime", "roomId", "inplaceSongCollectionId", "topSongId", "requiredSongInfo", "handleTabListData", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/y;", "secondLevelTabData", "", "syncSongListStartTimeMap", "getSongListBySecondLevelTabData", "getFetchSongListCount", "getSyncSecondTab", "isNewRound", "labelName", "resetWantListenCursorIfNeed", "", "Lcom/bytedance/android/live/ktv/common/model/api/o0;", "labels", "updateSecondLevelTabDataList", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "ktvMusicList", "tabDescription", "trans2MusicPanel", "getSelectedSecondLevelTabData", "updateSecondLevelTabListState", "updateSongListData", "updateTabListData", "getFirstLevelTabDataByTopValue", "isSelect", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "observer", "observeTabListStateChange", "Landroid/content/Context;", "context", "musicPanel", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "addSong", "Lic0/a;", "favoriteCallback", "addFavorite", "delFavorite", "Lkotlin/Pair;", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/UpdateTabType;", "getSelectedFirstLevelTabValue", "observeSelectedFirstLevelTabValueChange", "clearData", "updateTabType", "updateSelectFirstLevelTabValue", "onCleared", "isForceFetch", "syncSecondLevelTabList", "pageCount", "syncSecondLevelTabSongList", "secondLevelTabName", "getSecondLevelTabDataByParams", "getSecondLevelTabDataList", "observeTabListDataChange", "observeSongListDataChange", "getCurTabMode", "hasLoadTabListMap", "Ljava/util/Map;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "songListRequestMap", "Lcom/bytedance/android/live/ktv/common/karaokestation/model/b;", "defaultTabDataMap", "queryIdMap", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/CommonOrderSongViewModel$b;", "listenSongData", "Lcom/bytedance/android/live/ktv/common/karaokestation/viewmodel/CommonOrderSongViewModel$b;", "Landroidx/lifecycle/MutableLiveData;", "selectedFirstLevelTabValue", "Landroidx/lifecycle/MutableLiveData;", "tabListData", "songListData", "allFirstLevelTabData", "secondLevelTabList", "Lnb0/b;", "orderSongHandler", "Lnb0/b;", "<init>", "(Lnb0/b;)V", "()V", "Companion", "a", "b", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonOrderSongViewModel extends ViewModel implements com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b {
    public static final a Companion = null;
    public static final String TAG = "CommonOrderSongViewModel";
    private final Map<Integer, d> allFirstLevelTabData;
    private final Lazy compositeDisposable$delegate;
    private final Map<Integer, com.bytedance.android.live.ktv.common.karaokestation.model.b> defaultTabDataMap;
    private final Map<Integer, Boolean> hasLoadTabListMap;
    private final b listenSongData;
    private final nb0.b orderSongHandler;
    private final Map<String, String> queryIdMap;
    private final MutableLiveData<List<y>> secondLevelTabList;
    private final MutableLiveData<Pair<Integer, UpdateTabType>> selectedFirstLevelTabValue;
    private final MutableLiveData<y> songListData;
    private final Map<String, Boolean> songListRequestMap;
    private final MutableLiveData<Pair<d, List<y>>> tabListData;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a(ViewModelStoreOwner r2, nb0.b r3) {
            Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
            Intrinsics.checkNotNullParameter(r3, "orderSongHandler");
            return new ViewModelProvider(r2, new CommonOrderSongViewModelFactory(r3)).get(CommonOrderSongViewModel.class);
        }
    }

    public final class b {
        public long a;
        public String b;

        public b() {
            this.b = "";
        }
    }

    public static final class c<T> implements SingleOnSubscribe {
        public final /* synthetic */ CommonOrderSongViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ m d;

        public c(CommonOrderSongViewModel r1, int r2, int r3, m r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void subscribe(SingleEmitter<Unit> r9) {
            Intrinsics.checkNotNullParameter(r9, "emitter");
            e r11 = com.bytedance.android.livesdk.sharedpref.c.p;
            Map r0 = (Map) r11.getValue();
            if (r0 != null) goto L5;
            r0 = new LinkedHashMap();
        L5:
            Map r1 = (Map) r0.get(String.valueOf(this.b));
            if (r1 == null) goto L8;
            Map r2 = MapsKt.toMutableMap(r1);
        L9:
            if (r2 == null) goto L11;
            r2.put(String.valueOf(this.c), new b0(this.c, this.b, this.d));
            r0.put(String.valueOf(this.b), r2);
        L12:
            r11.getClass();
            f.d(r11, r0);
            CommonOrderSongViewModel.access$getDefaultTabDataMap$p(this.a).put(Integer.valueOf(this.b), new com.bytedance.android.live.ktv.common.karaokestation.model.b(this.b, this.d.b(), this.d.a()));
            xs2.b.a().post(new com.bytedance.android.live.ktv.common.karaokestation.model.c(CommonOrderSongViewModel.access$getDefaultTabDataMap$p(this.a)));
            return;
        L11:
            String r3 = String.valueOf(this.b);
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put(String.valueOf(this.c), new b0(this.c, this.b, this.d));
            Unit r5 = Unit.INSTANCE;
            r0.put(r3, r4);
            goto L12
        L8:
            r2 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.compositeDisposable$delegate.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b newInstance(ViewModelStoreOwner r1, nb0.b r2) {
        Companion.getClass();
        return a.a(r1, r2);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void clearData() {
    }

    public CommonOrderSongViewModel() {
        this(new com.bytedance.android.live.ktv.common.karaokestation.viewmodel.a());
    }

    private final int getFetchSongListCount() {
        t61 r0 = this.orderSongHandler.e();
        if (r0 == null) goto L13;
        boolean r2 = true;
        if (u61.a(r0) != true) goto L13;
        if (bb0.b.a() == KtvMode.SOLO_KTV) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L18;
        return r0.L6();
    L18:
        return r0.R6();
    L13:
        if (r0 != null) goto L19;
        return 20;
    L19:
        return r0.L6();
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public int getCurTabMode() {
        return this.orderSongHandler.g();
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public Pair<Integer, UpdateTabType> getSelectedFirstLevelTabValue() {
        return (Pair) this.selectedFirstLevelTabValue.getValue();
    }

    public void onCleared() {
        super.onCleared();
        getCompositeDisposable().clear();
    }

    public CommonOrderSongViewModel(nb0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "orderSongHandler");
        this.orderSongHandler = r5;
        this.hasLoadTabListMap = new LinkedHashMap();
        this.compositeDisposable$delegate = LazyKt.lazy(CommonOrderSongViewModel$compositeDisposable$2.INSTANCE);
        this.songListRequestMap = new LinkedHashMap();
        this.defaultTabDataMap = new LinkedHashMap();
        this.queryIdMap = new LinkedHashMap();
        this.listenSongData = new b();
        this.selectedFirstLevelTabValue = new MutableLiveData(new Pair(Integer.valueOf(FirstLevelTab.Unknown.getValue()), UpdateTabType.DEFAULT));
        this.tabListData = new MutableLiveData(new Pair(new d(0, 15), new ArrayList()));
        this.songListData = new MutableLiveData(new y(0, 0, 65535));
        this.allFirstLevelTabData = new LinkedHashMap();
        this.secondLevelTabList = new MutableLiveData(new ArrayList());
    }

    public static final /* synthetic */ Map access$getDefaultTabDataMap$p(CommonOrderSongViewModel r0) {
        return r0.defaultTabDataMap;
    }

    public static final /* synthetic */ Map access$getHasLoadTabListMap$p(CommonOrderSongViewModel r0) {
        return r0.hasLoadTabListMap;
    }

    public static final /* synthetic */ b access$getListenSongData$p(CommonOrderSongViewModel r0) {
        return r0.listenSongData;
    }

    public static final /* synthetic */ nb0.b access$getOrderSongHandler$p(CommonOrderSongViewModel r0) {
        return r0.orderSongHandler;
    }

    public static final /* synthetic */ Map access$getQueryIdMap$p(CommonOrderSongViewModel r0) {
        return r0.queryIdMap;
    }

    public static final /* synthetic */ Map access$getSongListRequestMap$p(CommonOrderSongViewModel r0) {
        return r0.songListRequestMap;
    }

    private final Map<String, y> getSyncSecondTab(d r2) {
        Map<String, y> r0 = this.orderSongHandler.f(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r2.a;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public d getFirstLevelTabDataByTopValue(int r2) {
        return this.allFirstLevelTabData.get(Integer.valueOf(r2));
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public List<y> getSecondLevelTabDataList(int r2) {
        d r3 = this.allFirstLevelTabData.get(Integer.valueOf(r2));
        if (r3 == null) goto L9;
        Map<String, y> r4 = r3.a;
        if (r4 == null) goto L9;
        Collection<y> r5 = r4.values();
        if (r5 == null) goto L9;
        return CollectionsKt.toMutableList(r5);
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public y getSelectedSecondLevelTabData(int r4) {
        d r5 = this.allFirstLevelTabData.get(Integer.valueOf(r4));
        Object r0 = null;
        if (r5 == null) goto L19;
        Map<String, y> r6 = r5.a;
        if (r6 == null) goto L20;
        Collection<y> r7 = r6.values();
        if (r7 == null) goto L21;
        Iterator<T> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Object r1 = r8.next();
        if (((y) r1).j == false) goto L10;
        r0 = r1;
    L15:
        return (y) r0;
    L21:
        return null;
    L20:
        return null;
    L19:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void updateSecondLevelTabListState(y r3) {
        if (r3 == null) goto L18;
        d r0 = this.allFirstLevelTabData.get(Integer.valueOf(r3.k));
        if (r0 == null) goto L8;
        Map<String, y> r1 = r0.a;
        if (r1 == null) goto L8;
        y r2 = r1.put(r3.c, r3);
    L8:
        MutableLiveData<List<y>> r4 = this.secondLevelTabList;
        d r5 = this.allFirstLevelTabData.get(Integer.valueOf(r3.k));
        if (r5 == null) goto L15;
        Map<String, y> r6 = r5.a;
        if (r6 == null) goto L15;
        Collection<y> r7 = r6.values();
        if (r7 == null) goto L15;
        List r8 = CollectionsKt.toMutableList(r7);
    L16:
        r4.setValue(r8);
        return;
    L15:
        r8 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void updateSongListData(y r3) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabData");
        if (r3.b == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        d r1 = this.allFirstLevelTabData.get(Integer.valueOf(r3.k));
        if (r1 == null) goto L12;
        Map<String, y> r2 = r1.a;
        if (r2 == null) goto L12;
        y r4 = r2.put(r3.c, r3);
    L12:
        this.songListData.setValue(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void updateTabListData(d r4) {
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabData");
        this.allFirstLevelTabData.put(Integer.valueOf(r4.d), r4);
        this.tabListData.setValue(new Pair(r4, CollectionsKt.toMutableList(r4.a.values())));
    }

    private final void resetWantListenCursorIfNeed(boolean r3, String r4) {
        if (r3 == false) goto L5;
        this.queryIdMap.put(r4, "");
        b r5 = this.listenSongData;
        r5.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r5.b = "";
        r5.a = 0;
        return;
    }

    private final void updateSecondLevelTabDataList(d r8, List<o0> r9) {
        if (r9 == null) goto L10;
        Iterator<T> r0 = r9.iterator();
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L10;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        y r4 = new y(r8.d, r1, 48127);
        y r5 = z.update(r4, (o0) r2);
        r8.a.put(r5.c, r5);
        r1 = r3;
    L10:
        this.orderSongHandler.a(r8, r9);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void addFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        this.orderSongHandler.addFavorite(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void delFavorite(MusicPanel r2, ic0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r3, "favoriteCallback");
        this.orderSongHandler.delFavorite(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public y getSecondLevelTabDataByParams(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "secondLevelTabName");
        d r4 = this.allFirstLevelTabData.get(Integer.valueOf(r2));
        if (r4 == null) goto L7;
        Map<String, y> r5 = r4.a;
        if (r5 == null) goto L7;
        return r5.get(r3);
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void observeSelectedFirstLevelTabValueChange(LifecycleOwner r2, Observer<Pair<Integer, UpdateTabType>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.selectedFirstLevelTabValue.observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void observeSongListDataChange(LifecycleOwner r2, Observer<y> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.songListData.observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void observeTabListDataChange(LifecycleOwner r2, Observer<Pair<d, List<y>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.tabListData.observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void observeTabListStateChange(LifecycleOwner r2, Observer<List<y>> r3) {
        Intrinsics.checkNotNullParameter(r2, "lifeCycleOwner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.secondLevelTabList.observe(r2, r3);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void updateSecondLevelTabListState(y r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "secondLevelTabData");
        r4.j = r5;
        d r6 = this.allFirstLevelTabData.get(Integer.valueOf(r4.k));
        if (r6 == null) goto L15;
        Map<String, y> r7 = r6.a;
        if (r7 == null) goto L15;
        Collection<y> r8 = r7.values();
        if (r8 == null) goto L15;
        Iterator<T> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L15;
        y r0 = (y) r9.next();
        if (Intrinsics.areEqual(r0.c, r4.c) == true) goto L13;
        r0.j = false;
        goto L10
    L13:
        r0.j = r4.j;
    L15:
        MutableLiveData<List<y>> r11 = this.secondLevelTabList;
        d r12 = this.allFirstLevelTabData.get(Integer.valueOf(r4.k));
        if (r12 == null) goto L22;
        Map<String, y> r13 = r12.a;
        if (r13 == null) goto L22;
        Collection<y> r14 = r13.values();
        if (r14 == null) goto L22;
        List r15 = CollectionsKt.toMutableList(r14);
    L23:
        r11.setValue(r15);
        return;
    L22:
        r15 = null;
        goto L23
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void updateSelectFirstLevelTabValue(int r3, UpdateTabType r4) {
        Intrinsics.checkNotNullParameter(r4, "updateTabType");
        Pair r0 = (Pair) this.selectedFirstLevelTabValue.getValue();
        if (r0 != null) goto L5;
    L6:
        this.selectedFirstLevelTabValue.setValue(new Pair(Integer.valueOf(r3), r4));
        return;
    L5:
        if (((Number) r0.getFirst()).intValue() != r3) goto L6;
    }

    private final void trans2MusicPanel(List<MusicPanel> r11, List<KtvMusic> r12, String r13) {
        List<KtvMusic> r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<KtvMusic> r14 = r12.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        r11.add(new MusicPanel(r14.next(), 1, r13, false, MusicPanel.MusicPanelSource.KTV, null, null, 1073741780));
        goto L13
    L15:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void updateTabListSp(int r2, int r3, m r4) {
        Single.create(new c(this, r2, r3, r4)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.computation()).subscribe();
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void addSong(Context r2, MusicPanel r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        this.orderSongHandler.addSong(r2, r3, r4);
    }

    public static final /* synthetic */ void access$trans2MusicPanel(CommonOrderSongViewModel r0, List r1, List r2, String r3) {
        r0.trans2MusicPanel(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateTabListSp(CommonOrderSongViewModel r0, int r1, int r2, m r3) {
        r0.updateTabListSp(r1, r2, r3);
    }

    private final void getSongListBySecondLevelTabData(y r16, d r17, Map<String, Long> r18, long r19, int r21, long r22, long r24, String r26) {
        r16.j = Intrinsics.areEqual(r16.c, r17.c);
        r18.put(r16.c, Long.valueOf(System.currentTimeMillis()));
        int r4 = getFetchSongListCount();
        if (Intrinsics.areEqual(r16.c, "recommend") == false) goto L5;
        long r9 = r22;
    L7:
        if (Intrinsics.areEqual(r16.c, "recommend") == false) goto L9;
        long r11 = r24;
    L10:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b.a.b(this, r19, true, r4, r21, r16, r9, r11, r26, null, 256);
        return;
    L9:
        r11 = 0;
        goto L10
    L5:
        r9 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void syncSecondLevelTabList(final long r23, final int r25, final String r26, final int r27, final long r28, final long r31, boolean r32, final String r33, final Function1<? super Boolean, Unit> r34) {
        Intrinsics.checkNotNullParameter(r26, "defaultLabelName");
        if (r32 == false) goto L5;
    L10:
        this.hasLoadTabListMap.put(Integer.valueOf(r25), Boolean.TRUE);
        final long r11 = System.currentTimeMillis();
        final d r14 = new d(r25, 7);
        t61 r0 = this.orderSongHandler.e();
        if (r0 == null) goto L34;
        boolean r1 = true;
        if (u61.b(r0) != true) goto L34;
        Map r2 = (Map) ((Map) com.bytedance.android.livesdk.sharedpref.c.p.getValue()).get(String.valueOf(r27));
        Boolean r3 = null;
        if (r2 == null) goto L17;
        Object r4 = r2.get(String.valueOf(r25));
    L18:
        b0 r5 = (b0) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), GsonProtectorUtils.toJson(new Gson(), r4), b0.class);
        e r6 = com.bytedance.android.livesdk.sharedpref.c.q;
        Boolean r7 = (Boolean) r6.getValue();
        IMiddlewareHostAction r8 = k.f(IMiddlewareHostAction.class);
        if (r8 == null) goto L22;
        r3 = Boolean.valueOf(r8.isPersonalRecommendOn());
    L22:
        if ((!Intrinsics.areEqual(r7, r3)) == false) goto L24;
        f.d(r6, r3);
    L25:
        if (r1 == true) goto L31;
        if (r32 == true) goto L31;
        if (r5 == null) goto L31;
        handleTabListData(r5.a(), r25, r26, r27, r34, r14, r11, r23, r28, r31, r33);
        int r9 = g.a;
        Disposable r12 = g.b.a.d(r11, r23, Integer.valueOf(r25), r27, new AnonymousClass1(this, r27, r25), new AnonymousClass2(this, r14, r11));
        if (r12 == null) goto L38;
        RxUtilKt.c(r12, getCompositeDisposable());
        return;
    L38:
        return;
    L31:
        int r13 = g.a;
        Disposable r15 = g.b.a.d(r11, r23, Integer.valueOf(r25), r27, new AnonymousClass3(this, r25, r26, r27, r34, r14, r11, r23, r28, r31, r33), new AnonymousClass4(this, r14, r11, r25, r34));
        if (r15 == null) goto L40;
        RxUtilKt.c(r15, getCompositeDisposable());
        return;
    L40:
        return;
    L24:
        r1 = false;
        goto L25
    L17:
        r4 = null;
    L34:
        int r16 = g.a;
        Disposable r17 = g.b.a.d(r11, r23, Integer.valueOf(r25), r27, new AnonymousClass5(this, r25, r26, r27, r34, r14, r11, r23, r28, r31, r33), new AnonymousClass6(this, r14, r11, r25, r34));
        if (r17 == null) goto L42;
        RxUtilKt.c(r17, getCompositeDisposable());
        return;
    L42:
        return;
    L5:
        if (this.hasLoadTabListMap.containsKey(Integer.valueOf(r25)) == false) goto L10;
        if (Intrinsics.areEqual(this.hasLoadTabListMap.get(Integer.valueOf(r25)), Boolean.TRUE) == false) goto L10;
        int r18 = ob0.a.a;
        String r19 = "firstLevelTabValue == " + r25;
        ob0.a.b.a.getClass();
        Intrinsics.checkNotNullParameter(r19, "msg");
        ALogger.i("ttlive_ktv_common", r19);
    }

    @Override // com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b
    public void syncSecondLevelTabSongList(long r29, final boolean r31, final int r32, int r33, final y r34, long r35, long r37, String r39, final Function1<? super Boolean, Unit> r41) {
        Intrinsics.checkNotNullParameter(r34, "secondLevelTabData");
        final long r13 = System.currentTimeMillis();
        final String r15 = r34.c;
        t61 r0 = this.orderSongHandler.e();
        if (r0 != null) goto L5;
    L11:
        this.songListRequestMap.put(r15, Boolean.TRUE);
        Disposable r27 = null;
        if (r33 == 5) goto L14;
    L31:
        int r1 = r34.m;
        if (r31 == false) goto L34;
        int r19 = 0;
    L35:
        int r2 = g.a;
        g r11 = g.b.a;
        String r21 = this.queryIdMap.get(r15);
        final int r7 = r19;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.k>, Unit> r9 = new C03243(this, r15, r34, r13, r41, r7, r32, r31);
        Function1<Throwable, Unit> r8 = new C03254(this, r15, r34, r13, r41);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r9, "successCallback");
        Intrinsics.checkNotNullParameter(r8, "failCallback");
        KtvCommonApi r3 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r3 == null) goto L42;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.k>> r4 = r3.getSongList(r29, r15, r19, r32, r21, r33, r35, Long.valueOf(r37), r39);
        if (r4 == null) goto L42;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L42;
        r27 = r5.subscribe(new n(r13, r9), new o(r13, r8));
    L42:
        Disposable r6 = r27;
        if (r6 == null) goto L48;
        RxUtilKt.c(r6, getCompositeDisposable());
        return;
    L48:
        return;
    L34:
        r19 = r1;
        goto L35
    L14:
        if (this.orderSongHandler.getRoomInfo().d == false) goto L31;
        if (Intrinsics.areEqual(r15, "recommend") == false) goto L31;
        resetWantListenCursorIfNeed(r31, r15);
        int r12 = g.a;
        g r14 = g.b.a;
        b r16 = this.listenSongData;
        String r17 = r16.b;
        long r18 = r16.a;
        String r22 = this.queryIdMap.get(r15);
        if (r22 != null) goto L20;
        r22 = "";
    L20:
        String r23 = r22;
        Function1<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.f>, Unit> r24 = new C03221(this, r15, r34, r13, r41, r31);
        Function1<Throwable, Unit> r25 = new C03232(this, r15, r34, r13, r41);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r17, "wantListenCursor");
        Intrinsics.checkNotNullParameter(r23, "queryId");
        Intrinsics.checkNotNullParameter(r24, "successCallBack");
        Intrinsics.checkNotNullParameter(r25, "failCallBack");
        KtvCommonApi r26 = (KtvCommonApi) com.bytedance.android.live.network.c.b().e(KtvCommonApi.class);
        if (r26 == null) goto L27;
        Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.ktv.common.model.api.f>> r28 = r26.getListenSongList(r29, r17, r18, r23, r31);
        if (r28 == null) goto L27;
        Observable r36 = r28.compose(RxUtil.rxSchedulerHelper());
        if (r36 == null) goto L27;
        r27 = r36.subscribe(new j(r13, r24), new com.bytedance.android.live.ktv.common.karaokestation.model.k(r13, r25));
    L27:
        Disposable r38 = r27;
        if (r38 == null) goto L47;
        RxUtilKt.c(r38, getCompositeDisposable());
    L47:
        return;
    L5:
        if (u61.b(r0) != true) goto L11;
        Boolean r42 = this.songListRequestMap.get(r15);
        Boolean r43 = Boolean.TRUE;
        if (Intrinsics.areEqual(r42, r43) == false) goto L11;
        if (r41 == null) goto L46;
        Unit r44 = (Unit) r41.invoke(r43);
        return;
    }

    private final void handleTabListData(m r17, int r18, String r19, int r21, Function1<? super Boolean, Unit> r22, d r23, long r24, long r25, long r27, long r29, String r31) {
        List<o0> r1 = r17.c();
        boolean r6 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        this.hasLoadTabListMap.put(Integer.valueOf(r18), Boolean.FALSE);
        return;
    L11:
        if (r22 == null) goto L13;
        Unit r0 = (Unit) r22.invoke(Boolean.TRUE);
    L13:
        updateSecondLevelTabDataList(r23, r17.c());
        com.bytedance.android.live.ktv.common.karaokestation.model.e.update(r23, r17.b(), r17.a());
        this.orderSongHandler.d(true, null, r23, r24);
        LinkedHashMap r14 = new LinkedHashMap();
        t61 r3 = this.orderSongHandler.e();
        if (r3 != null) goto L16;
    L37:
        Iterator<T> r15 = getSyncSecondTab(r23).values().iterator();
    L39:
        if (r15.hasNext() == false) goto L42;
        getSongListBySecondLevelTabData((y) r15.next(), r23, r14, r25, r21, r27, r29, r31);
    L42:
        if (r23.d != FirstLevelTab.FirstOpenTab.getValue()) goto L44;
        this.selectedFirstLevelTabValue.setValue(new Pair(Integer.valueOf(r23.b), UpdateTabType.DEFAULT));
    L44:
        this.orderSongHandler.postSyncTabListData(r23);
        updateTabListData(r23);
        return;
    L16:
        if (u61.b(r3) != true) goto L37;
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L20;
        r6 = true;
    L20:
        if (r6 == true) goto L33;
        Iterator<T> r4 = getSyncSecondTab(r23).values().iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((y) r5).c, r19) == false) goto L23;
    L28:
        y r7 = (y) r5;
        if (r7 != null) goto L31;
        r7 = (y) CollectionsKt.firstOrNull(getSyncSecondTab(r23).values());
    L31:
        if (r7 == null) goto L42;
        getSongListBySecondLevelTabData(r7, r23, r14, r25, r21, r27, r29, r31);
        goto L42
    L27:
        r5 = null;
        goto L28
    L33:
        Iterator<T> r16 = getSyncSecondTab(r23).values().iterator();
    L35:
        if (r16.hasNext() == false) goto L42;
        getSongListBySecondLevelTabData((y) r16.next(), r23, r14, r25, r21, r27, r29, r31);
        goto L35
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final /* synthetic */ void access$handleTabListData(CommonOrderSongViewModel r0, m r1, int r2, String r3, int r4, Function1 r5, d r6, long r7, long r9, long r11, long r13, String r15) {
        r0.handleTabListData(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r15);
    }
}
