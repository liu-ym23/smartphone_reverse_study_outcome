package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\r\u001a\n \u0003*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \u0003*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerNormalTabView;", "Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerBaseTabView;", "Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getLoading", "()Lcom/bytedance/android/live/uikit/recyclerview/LoadingStatusView;", "loading", "Landroidx/recyclerview/widget/RecyclerView;", "e", "getStickerList", "()Landroidx/recyclerview/widget/RecyclerView;", "stickerList", "Landroid/widget/TextView;", "f", "getEmptyTextView", "()Landroid/widget/TextView;", "emptyTextView", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerNormalTabView extends StickerBaseTabView {
    public static final /* synthetic */ int n = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public LiveStickerDialogListAdapter g;
    public final WeakReference<LifecycleOwner> h;
    public final String i;
    public final StickerNormalTabDataSourceType j;
    public final String k;
    public final boolean l;
    public final String m;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ StickerNormalTabView a;

        public a(StickerNormalTabView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            StickerNormalTabView r3 = this.a;
            int r0 = StickerNormalTabView.n;
            r3.Y5();
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ StickerNormalTabView a;

        public b(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Sticker r2 = (Sticker) r1;
            LiveStickerDialogListAdapter r3 = this.a.g;
            if (r3 == null) goto L6;
            r3.C2();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ StickerNormalTabView a;

        public c(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadingStatusView r0 = StickerNormalTabView.U5(this.a);
            StickerBaseTabView.S5(r0, (StickerLoadingStatus) r2);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ StickerNormalTabView a;

        public d(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerNormalTabView r0 = this.a;
            StickerNormalTabView.V5(r0, (List) r2);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ StickerNormalTabView a;

        public e(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerNormalTabView r0 = this.a;
            StickerNormalTabView.V5(r0, (List) r2);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ StickerNormalTabView a;

        public f(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StickerNormalTabView r0 = this.a;
            StickerNormalTabView.V5(r0, (List) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ StickerNormalTabView a;

        public g(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Sticker r3 = (Sticker) r2;
            LiveStickerDialogListAdapter r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.B2(r3);
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ StickerNormalTabView a;

        public h(StickerNormalTabView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Sticker r3 = (Sticker) r2;
            LiveStickerDialogListAdapter r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.B2(r3);
            return;
        }
    }

    private final TextView getEmptyTextView() {
        return (TextView) this.f.getValue();
    }

    private final LoadingStatusView getLoading() {
        return (LoadingStatusView) this.d.getValue();
    }

    private final RecyclerView getStickerList() {
        return (RecyclerView) this.e.getValue();
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void T5() {
        super.T5();
        StickerDialogUIViewModel r0 = getUiViewModel();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.k<Sticker> r1 = r0.getStickerDownloadCompleteEvent();
        if (r1 == null) goto L11;
        PublishSubject r2 = r1.onEvent();
        if (r2 == null) goto L11;
        Disposable r3 = r2.subscribe(new g(this));
        if (r3 == null) goto L11;
        RxUtilKt.c(r3, getCompositeDisposable());
    L11:
        StickerDialogUIViewModel r4 = getUiViewModel();
        if (r4 == null) goto L20;
        com.bytedance.live.datacontext.k<Sticker> r5 = r4.getStickerDownloadStartEvent();
        if (r5 == null) goto L20;
        PublishSubject r6 = r5.onEvent();
        if (r6 == null) goto L20;
        Disposable r7 = r6.subscribe(new h(this));
        if (r7 == null) goto L20;
        RxUtilKt.c(r7, getCompositeDisposable());
    L20:
        LifecycleOwner r8 = this.h.get();
        if (r8 == null) goto L52;
        StickerDialogUIViewModel r9 = getUiViewModel();
        if (r9 == null) goto L27;
        LiveData<Sticker> r11 = r9.getCurrentSelectStickerData();
        if (r11 == null) goto L27;
        r11.observe(r8, new b(this));
    L27:
        StickerDataViewModel r12 = getStickerDataViewModel();
        if (r12 == null) goto L32;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, StickerLoadingStatus> r13 = r12.getTabLoadingStatusMap();
        if (r13 == null) goto L32;
        r13.b(this.i, r8, new c(this));
    L32:
        StickerNormalTabDataSourceType r14 = this.j;
        int r15 = g0.a[r14.ordinal()];
        if (r15 != 1) goto L35;
        StickerDataViewModel r16 = getStickerDataViewModel();
        if (r16 == null) goto L59;
        LiveData<List<Sticker>> r17 = r16.getFavoriteCategoryInfo();
        if (r17 == null) goto L60;
        r17.observe(r8, new d(this));
        return;
    L60:
        return;
    L59:
        return;
    L35:
        if (r15 == 2) goto L41;
        StickerDataViewModel r18 = getStickerDataViewModel();
        if (r18 == null) goto L53;
        com.bytedance.android.live.effect.sticker.viewmodel.c<String, List<Sticker>> r19 = r18.getNormalCategoryInfoMap();
        if (r19 == null) goto L54;
        r19.b(this.i, r8, new f(this));
        return;
    L54:
        return;
    L53:
        return;
    L41:
        StickerDataViewModel r21 = getStickerDataViewModel();
        if (r21 == null) goto L56;
        MutableLiveData<List<Sticker>> r22 = r21.getCampaignCategoryInfo();
        if (r22 == null) goto L57;
        r22.observe(r8, new e(this));
        return;
    L57:
        return;
    L56:
        return;
    }

    public final void Y5() {
        StickerDialogUIViewModel r0 = getUiViewModel();
        if (r0 == null) goto L9;
        com.bytedance.android.live.effect.base.f r1 = r0.getShowTraceInfo();
        if (r1 == null) goto L9;
        if (Intrinsics.areEqual(r1.c, this.i) == false) goto L9;
        r1.k = System.currentTimeMillis();
    L9:
        StickerNormalTabDataSourceType r2 = this.j;
        int r3 = g0.b[r2.ordinal()];
        if (r3 != 1) goto L12;
        StickerDataViewModel r4 = getStickerDataViewModel();
        if (r4 == null) goto L27;
        r4.fetchFavoriteStickerList();
        return;
    L27:
        return;
    L12:
        if (r3 == 2) goto L16;
        StickerDataViewModel r5 = getStickerDataViewModel();
        if (r5 == null) goto L23;
        r5.fetchCategoryStickerList(this.i);
        return;
    L23:
        return;
    L16:
        StickerDataViewModel r6 = getStickerDataViewModel();
        if (r6 == null) goto L25;
        r6.fetchCampaignStickerListFromCacheAndUpdate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerBaseTabView
    public final void initView() {
        R5(getLoading(), new a(this));
        this.g = new LiveStickerDialogListAdapter(getType(), getScene(), this.i, this.m, new WeakReference(getStickerList()));
        RecyclerView r0 = getStickerList();
        if (r0 == null) goto L5;
        r0.setLayoutManager(new SSGridLayoutManager(getContext(), 5, 1));
    L5:
        RecyclerView r1 = getStickerList();
        if (r1 == null) goto L8;
        r1.setAdapter(this.g);
    L8:
        TextView r2 = getEmptyTextView();
        if (r2 == null) goto L11;
        r2.setVisibility(4);
    L11:
        Y5();
    }

    public static final /* synthetic */ LoadingStatusView U5(StickerNormalTabView r0) {
        return r0.getLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void V5(StickerNormalTabView r14, List r15) {
        StickerDialogUIViewModel r0 = r14.getUiViewModel();
        if (r0 == null) goto L9;
        com.bytedance.android.live.effect.base.f r1 = r0.getShowTraceInfo();
        if (r1 == null) goto L9;
        if (Intrinsics.areEqual(r1.c, r14.i) == false) goto L9;
        r1.l = System.currentTimeMillis();
    L9:
        LiveStickerDialogListAdapter r2 = r14.g;
        if (r2 == null) goto L13;
        r2.y2(r15);
    L13:
        if (r15.isEmpty() == false) goto L20;
        TextView r3 = r14.getEmptyTextView();
        if (r3 == null) goto L17;
        r3.setText(r14.k);
    L17:
        TextView r4 = r14.getEmptyTextView();
        if (r4 == null) goto L23;
        r4.setVisibility(0);
    L23:
        Sticker r5 = null;
        if (r14.l == false) goto L32;
        StickerDataViewModel r6 = r14.getStickerDataViewModel();
        if (r6 == null) goto L30;
        f0 r7 = r6.getInitialPageStatus();
        if (r7 == null) goto L30;
        String r8 = r7.b;
    L31:
        boolean r9 = Intrinsics.areEqual(r8, r14.i);
    L39:
        int r11 = -1;
        if (r9 == false) goto L71;
        StickerDataViewModel r12 = r14.getStickerDataViewModel();
        if (r12 == null) goto L44;
        f0 r13 = r12.getInitialPageStatus();
    L45:
        StickerDataViewModel r16 = r14.getStickerDataViewModel();
        if (r16 == null) goto L48;
        r16.setInitialPageStatus(null);
    L48:
        if (r13 == null) goto L50;
        Long r17 = Long.valueOf(r13.c);
    L51:
        if (r17 == null) goto L71;
        if (r13.c <= 0) goto L71;
        Iterator r18 = r15.iterator();
        int r19 = 0;
    L57:
        if (r18.hasNext() == false) goto L65;
        if (((Sticker) r18.next()).getId() != r13.c) goto L61;
        boolean r21 = true;
    L62:
        if (r21 == true) goto L66;
        r19 = r19 + 1;
    L66:
        if (r19 < 0) goto L71;
        RecyclerView r22 = r14.getStickerList();
        if (r22 == null) goto L71;
        r22.scrollToPosition(r19);
        goto L71
    L61:
        r21 = false;
        goto L62
    L65:
        r19 = -1;
        goto L66
    L50:
        r17 = null;
        goto L51
    L44:
        r13 = null;
    L71:
        if (r14.l == false) goto L110;
        StickerDataViewModel r23 = r14.getStickerDataViewModel();
        if (r23 == null) goto L77;
        InsertStickerInfo r24 = r23.getInsertStickerInfo();
        if (r24 == null) goto L77;
        String r25 = r24.getSecondaryTabKey();
    L78:
        boolean r26 = Intrinsics.areEqual(r25, r14.i);
        if (LiveEffectSettings.LIVE_STICKER_DIALOG_SCHEMA_ENABLE_FORCE_INSERT.getValue().booleanValue() == false) goto L104;
        StickerDataViewModel r27 = r14.getStickerDataViewModel();
        if (r27 == null) goto L85;
        InsertStickerInfo r28 = r27.getInsertStickerInfo();
        if (r28 == null) goto L85;
        String r29 = r28.getInsertTabKey();
    L87:
        if (Intrinsics.areEqual(r29, r14.m) == false) goto L104;
        if (Intrinsics.areEqual(r14.m, r14.i) == false) goto L104;
        StickerDataViewModel r31 = r14.getStickerDataViewModel();
        if (r31 == null) goto L95;
        InsertStickerInfo r32 = r31.getInsertStickerInfo();
        if (r32 == null) goto L95;
        String r33 = r32.getSecondaryTabKey();
    L96:
        if (r33 != null) goto L98;
    L101:
        boolean r34 = true;
    L102:
        if (r34 == false) goto L104;
        boolean r35 = true;
    L105:
        if (r26 == true) goto L109;
        if (r35 == true) goto L109;
        boolean r36 = false;
    L117:
        if (r36 == false) goto L158;
        StickerDataViewModel r37 = r14.getStickerDataViewModel();
        if (r37 == null) goto L121;
        InsertStickerInfo r38 = r37.getInsertStickerInfo();
    L122:
        StickerDataViewModel r39 = r14.getStickerDataViewModel();
        if (r39 == null) goto L125;
        r39.setInsertStickerInfo(null);
    L125:
        if (r38 == null) goto L127;
        r5 = r38.getSticker();
    L127:
        if (r5 == null) goto L158;
        Sticker r41 = r38.getSticker();
        if (r41 != null) goto L131;
    L133:
        Iterator r42 = r15.iterator();
        int r43 = 0;
    L135:
        if (r42.hasNext() == false) goto L145;
        long r44 = ((Sticker) r42.next()).getId();
        Sticker r45 = r38.getSticker();
        if (r45 != null) goto L139;
    L141:
        boolean r46 = false;
    L142:
        if (r46 == true) goto L143;
        r43 = r43 + 1;
        goto L135
    L143:
        r11 = r43;
        goto L145
    L139:
        if (r44 != r45.getId()) goto L141;
        r46 = true;
    L145:
        Sticker r110 = (Sticker) CollectionsKt.getOrNull(r15, r11);
        if (r110 == null) goto L158;
        StickerDialogUIViewModel r47 = r14.getUiViewModel();
        if (r47 == null) goto L158;
        Context r48 = r14.getContext();
        if (r14.l == false) goto L152;
        String r49 = r38.getSecondaryTabKey();
    L154:
        if (r14.l == false) goto L156;
        String r51 = r38.getInsertTabKey();
    L157:
        r47.tryApplySticker(r48, r110, r49, r51);
        goto L158
    L156:
        r51 = "";
        goto L157
    L152:
        r49 = r38.getInsertTabKey();
        goto L154
    L131:
        if (r41.getId() != 0) goto L133;
    L121:
        r38 = null;
    L158:
        StickerDialogUIViewModel r111 = r14.getUiViewModel();
        if (r111 == null) goto L177;
        com.bytedance.android.live.effect.base.f r112 = r111.getShowTraceInfo();
        if (r112 != null) goto L163;
        return;
    L163:
        if (Intrinsics.areEqual(r112.c, r14.i) == false) goto L179;
        StickerDialogUIViewModel r52 = r14.getUiViewModel();
        if (r52 != null) goto L167;
        return;
    L167:
        if (r52.getHasReportPanelShow() == true) goto L181;
        StickerDialogUIViewModel r53 = r14.getUiViewModel();
        if (r53 == null) goto L171;
        r53.setHasReportPanelShow(true);
    L171:
        r112.m = System.currentTimeMillis();
        List<String> r54 = com.bytedance.android.live.effect.utils.q.a;
        com.bytedance.android.live.effect.utils.q.i(r112, r14.getScene().getPage());
        return;
    L181:
        return;
    L179:
        return;
    L177:
        return;
    L109:
        r36 = true;
        goto L117
    L98:
        if (r33.length() == 0) goto L101;
        r34 = false;
    L95:
        r33 = null;
    L85:
        r29 = null;
    L104:
        r35 = false;
    L77:
        r25 = null;
        goto L78
    L110:
        StickerDataViewModel r55 = r14.getStickerDataViewModel();
        if (r55 == null) goto L115;
        InsertStickerInfo r56 = r55.getInsertStickerInfo();
        if (r56 == null) goto L115;
        String r57 = r56.getInsertTabKey();
    L116:
        r36 = Intrinsics.areEqual(r57, r14.i);
    L115:
        r57 = null;
    L30:
        r8 = null;
        goto L31
    L32:
        StickerDataViewModel r58 = r14.getStickerDataViewModel();
        if (r58 == null) goto L37;
        f0 r59 = r58.getInitialPageStatus();
        if (r59 == null) goto L37;
        String r61 = r59.a;
    L38:
        r9 = Intrinsics.areEqual(r61, r14.i);
    L37:
        r61 = null;
        goto L38
    L20:
        TextView r62 = r14.getEmptyTextView();
        if (r62 == null) goto L23;
        r62.setVisibility(4);
        goto L23
    }

    public StickerNormalTabView(Context r2, LiveEffectContextFactoryDelegate$Type r3, LiveEffectScene r4, WeakReference<LifecycleOwner> r5, String r6, StickerNormalTabDataSourceType r7, String r8, boolean r9, String r11) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mType");
        Intrinsics.checkNotNullParameter(r4, "mScene");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "tabKey");
        Intrinsics.checkNotNullParameter(r7, "dataSourceType");
        Intrinsics.checkNotNullParameter(r8, "emptyText");
        Intrinsics.checkNotNullParameter(r11, "parentTabKey");
        super(r2, 2131565931, r3, r4);
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.m = r11;
        this.d = LazyKt.lazy(new StickerNormalTabView$loading$2(this));
        this.e = LazyKt.lazy(new StickerNormalTabView$stickerList$2(this));
        this.f = LazyKt.lazy(new StickerNormalTabView$emptyTextView$2(this));
    }
}
