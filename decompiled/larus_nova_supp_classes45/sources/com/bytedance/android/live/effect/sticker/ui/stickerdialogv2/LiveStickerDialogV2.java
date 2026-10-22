package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.base.EffectDataFetchType;
import com.bytedance.android.live.effect.base.LiveEffectPagerSlidingTabStrip;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.effect.sticker.ui.StickerFavoriteView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerRenderViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerSearchViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.live.uikit.rtl.RtlViewPager;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.InsertStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogV2;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerDialogV2 extends LiveDialogFragment {
    public static final /* synthetic */ int y = 0;
    public final boolean d;
    public final boolean e;
    public StickerDataViewModel f;
    public StickerDialogUIViewModel g;
    public StickerPreviewViewModel h;
    public StickerRenderViewModel i;
    public StickerAigcViewModel j;
    public final CompositeDisposable k;
    public LiveStickerDialogViewPagerAdapter l;
    public final com.bytedance.android.live.effect.sticker.viewmodel.b<f0> m;
    public final com.bytedance.android.live.effect.sticker.viewmodel.b<InsertStickerInfo> n;
    public final com.bytedance.android.live.effect.base.f o;
    public final LiveEffectContextFactoryDelegate$Type p;
    public final LiveEffectScene q;
    public final com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b r;
    public final List<com.bytedance.android.live.effect.sticker.chain.m> s;
    public final String t;
    public final ws1.a u;
    public final List<SpecialTabType> v;
    public final String w;
    public final boolean x;

    public static final class a {
        public a() {
        }

        public static LiveStickerDialogV2 a(LiveEffectContextFactoryDelegate$Type r11, LiveEffectScene r12, x0 r13, List r14, String r15, List r16, String r17, boolean r18) {
            int r0 = LiveStickerDialogV2.y;
            ws1.a r7 = LiveEffectSettings.LIVE_ANCHOR_STICKER_DIALOG_CONFIG.getValue();
            Intrinsics.checkNotNullParameter(r11, "type");
            Intrinsics.checkNotNullParameter(r12, "liveEffectScene");
            Intrinsics.checkNotNullParameter(r13, "dynamicProxy");
            Intrinsics.checkNotNullParameter(r14, "stickerApplyInterceptorList");
            Intrinsics.checkNotNullParameter(r15, "panel");
            Intrinsics.checkNotNullParameter(r7, "dataConfig");
            Intrinsics.checkNotNullParameter(r16, "specialTabList");
            Intrinsics.checkNotNullParameter(r17, "defaultTabKey");
            if (r17.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            String r9 = "hot";
        L10:
            return new LiveStickerDialogV2(r11, r12, r13, r14, r15, r7, r16, r9, r18);
        L8:
            r9 = r17;
            goto L10
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveStickerDialogV2 a;

        public b(LiveStickerDialogV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveStickerDialogV2.S90(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        new a();
    }

    public LiveStickerDialogV2() {
        throw null;
    }

    public final f0 V90() {
        StickerDataViewModel r0 = this.f;
        if (r0 != null) goto L5;
    L13:
        InsertStickerInfo r1 = this.n.a;
        long r2 = 0;
        if (r1 == null) goto L39;
        String r3 = r1.getInsertTabKey();
        if (r3 == null) goto L39;
        if (r3.length() <= 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 != true) goto L39;
        InsertStickerInfo r5 = this.n.a;
        String r6 = "";
        if (r5 == null) goto L26;
        String r7 = r5.getInsertTabKey();
        if (r7 == null) goto L26;
    L27:
        InsertStickerInfo r8 = this.n.a;
        if (r8 == null) goto L33;
        String r9 = r8.getSecondaryTabKey();
        if (r9 == null) goto L33;
        r6 = r9;
    L33:
        InsertStickerInfo r11 = this.n.a;
        if (r11 == null) goto L38;
        Sticker r12 = r11.getSticker();
        if (r12 == null) goto L38;
        r2 = r12.getId();
    L38:
        f0 r13 = new f0(r7, r6, r2);
    L43:
        f0 r14 = r13;
    L44:
        this.m.update(r14);
        return r14;
    L26:
        r7 = "";
        goto L27
    L20:
        r4 = false;
    L39:
        com.bytedance.android.live.effect.sticker.viewmodel.b<f0> r15 = this.m;
        f0 r16 = r15.a;
        if (r16 == null) goto L42;
        r15.a = null;
        Intrinsics.checkNotNull(r16);
        r14 = r16;
        goto L44
    L42:
        String r17 = this.w;
        r13 = new f0(r17, r17, 0);
        goto L43
    L5:
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L8:
        if (r0.getUpdatePageStatus().a == null) goto L13;
        StickerDataViewModel r18 = this.f;
        if (r18 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L12:
        com.bytedance.android.live.effect.sticker.viewmodel.b<f0> r19 = r18.getUpdatePageStatus();
        f0 r21 = r19.a;
        r19.a = null;
        Intrinsics.checkNotNull(r21);
        r14 = r21;
        goto L44
    }

    public final void X90() {
        StickerDialogUIViewModel r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L5:
        com.bytedance.android.live.effect.base.f r1 = r0.getShowTraceInfo();
        r1.i = System.currentTimeMillis();
        StickerDataViewModel r2 = this.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L8:
        r2.fetchPanelInfo(this.t, this.u.c());
    }

    public final void Y90() {
        com.bytedance.android.live.effect.sticker.viewmodel.b<f0> r0 = this.m;
        this.r.c();
        r0.update(null);
        com.bytedance.android.live.effect.sticker.viewmodel.b<InsertStickerInfo> r1 = this.n;
        this.r.b();
        r1.update(null);
        com.bytedance.android.live.effect.base.f r2 = this.o;
        r2.a = true;
        r2.h = System.currentTimeMillis();
        r2.e = true;
        String r3 = this.t;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.b = r3;
        r2.d = EffectDataFetchType.FetchByCategory;
    }

    public final void Z90() {
        StickerRenderViewModel r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerRenderViewModel");
    L5:
        Sticker r1 = (Sticker) r0.getRenderStickerData().getValue();
        StickerPreviewViewModel r2 = this.h;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L8:
        com.bytedance.android.live.effect.sticker.viewmodel.f r3 = (com.bytedance.android.live.effect.sticker.viewmodel.f) r2.getPreviewStatusData().getValue();
        if (r3 == null) goto L11;
        Sticker r4 = r3.b;
    L13:
        if (r4 == null) goto L18;
        StickerDialogUIViewModel r5 = this.g;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L17:
        r5.updateSelectSticker(r4);
        return;
    L18:
        StickerDialogUIViewModel r6 = this.g;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L21:
        r6.updateSelectSticker(r1);
        return;
    L11:
        r4 = null;
        goto L13
    }

    public final String U90() {
        View r0 = getView();
        if (r0 == null) goto L7;
        RtlViewPager r1 = r0.findViewById(2131387348);
        if (r1 == null) goto L7;
        int r2 = r1.getCurrentItem();
    L8:
        StickerDataViewModel r3 = this.f;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L11:
        EffectCategoryModel r4 = r3.getTabInfoByPosition(r2);
        if (r4 == null) goto L15;
        String r5 = r4.getName();
        if (r5 == null) goto L15;
        return r5;
    L15:
        return "";
    L7:
        r2 = 0;
        goto L8
    }

    public final void W90() {
        if (getContext() != null) goto L5;
        return;
    L5:
        this.l = new LiveStickerDialogViewPagerAdapter(getContext(), new WeakReference(this), this.p, this.q, this.x, false, "");
        View r0 = getView();
        if (r0 == null) goto L19;
        LiveEffectPagerSlidingTabStrip r1 = (LiveEffectPagerSlidingTabStrip) r0.findViewById(2131388052);
        if (r1 == null) goto L20;
        r1.setTextSelectedStyle(1);
        if (this.e == false) goto L12;
        Integer r2 = 0;
        com.bytedance.android.live.effect.sticker.ui.u r3 = new com.bytedance.android.live.effect.sticker.ui.u();
        r1.J.put(r2.intValue(), r3);
    L12:
        View r4 = getView();
        if (r4 == null) goto L17;
        RtlViewPager r5 = r4.findViewById(2131387348);
        if (r5 == null) goto L17;
        r5.setOffscreenPageLimit(this.u.b());
        r5.setAdapter(this.l);
        r1.f = r5;
        r5.setOnPageChangeListener(r1.c);
    L17:
        r1.setOnPageChangeListener(new LiveStickerDialogV2$initViewPager$$inlined$apply$lambda$1(this));
        return;
    L20:
        return;
    }

    public final void dismiss() {
        View r0 = getView();
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131387344);
        if (r1 == null) goto L7;
        r1.setVisibility(4);
    L7:
        com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.b r2 = this.r;
        StickerDialogUIViewModel r3 = this.g;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L10:
        Sticker r4 = (Sticker) r3.getCurrentSelectStickerData().getValue();
        StickerDialogUIViewModel r5 = this.g;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L13:
        r2.e(r4, MapsKt.toMap(r5.getSelectStickerExtra()));
        StickerPreviewViewModel r6 = this.h;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L16:
        r6.releasePreview();
        View r7 = getView();
        View r8 = null;
        if (r7 == null) goto L83;
        RtlViewPager r9 = r7.findViewById(2131387348);
        if (r9 == null) goto L83;
        StickerDataViewModel r11 = this.f;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L24:
        EffectCategoryModel r12 = r11.getTabInfoByPosition(r9.getCurrentItem());
        String r13 = "";
        if (r12 == null) goto L28;
        String r14 = r12.getKey();
        if (r14 == null) goto L28;
    L29:
        StickerDataViewModel r15 = this.f;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L32:
        EffectCategoryModel r16 = r15.getCurrentSecondaryTabInfo();
        if (r16 == null) goto L38;
        String r17 = r16.getKey();
        if (r17 == null) goto L38;
        r13 = r17;
    L38:
        int r18 = 0;
        if (r13.length() != 0) goto L41;
        boolean r19 = true;
    L43:
        if (r19 == false) goto L52;
        LiveStickerDialogViewPagerAdapter r21 = this.l;
        if (r21 == null) goto L65;
        Intrinsics.checkNotNullParameter(r14, "tabKey");
        WeakReference r22 = (WeakReference) ((LinkedHashMap) r21.c).get(r14);
        if (r22 == null) goto L49;
        ConstraintLayout r23 = (StickerNormalTabView) r22.get();
    L50:
        if (r23 == null) goto L65;
        RecyclerView r24 = (RecyclerView) r23.findViewById(2131367812);
    L66:
        if (r24 == null) goto L68;
        RecyclerView.LayoutManager r25 = r24.getLayoutManager();
    L70:
        if ((r25 instanceof GridLayoutManager) == true) goto L72;
        r25 = null;
    L72:
        GridLayoutManager r26 = (GridLayoutManager) r25;
        if (r26 == null) goto L75;
        r18 = r26.findFirstCompletelyVisibleItemPosition();
    L75:
        StickerDataViewModel r27 = this.f;
        if (r27 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L78:
        Sticker r28 = r27.getStickerByTabAndPosition(r14, r18);
        if (r28 == null) goto L81;
        long r29 = r28.getId();
    L82:
        this.r.a(new f0(r14, r13, r29));
        goto L83
    L81:
        r29 = 0;
        goto L82
    L68:
        r25 = null;
        goto L70
    L49:
        r23 = null;
    L65:
        r24 = null;
        goto L66
    L52:
        LiveStickerDialogViewPagerAdapter r31 = this.l;
        if (r31 == null) goto L65;
        Intrinsics.checkNotNullParameter(r14, "tabKey");
        WeakReference r32 = (WeakReference) ((LinkedHashMap) r31.d).get(r14);
        if (r32 == null) goto L57;
        StickerMultiCategoryTabView r33 = (StickerMultiCategoryTabView) r32.get();
    L58:
        if (r33 == null) goto L65;
        Intrinsics.checkNotNullParameter(r13, "tabKey");
        LiveStickerDialogViewPagerAdapter r34 = r33.h;
        r34.getClass();
        Intrinsics.checkNotNullParameter(r13, "tabKey");
        WeakReference r35 = (WeakReference) ((LinkedHashMap) r34.c).get(r13);
        if (r35 == null) goto L62;
        ConstraintLayout r36 = (StickerNormalTabView) r35.get();
    L63:
        if (r36 == null) goto L65;
        r24 = r36.findViewById(2131367812);
        goto L66
    L62:
        r36 = null;
        goto L63
    L57:
        r33 = null;
        goto L58
    L41:
        r19 = false;
    L28:
        r14 = "";
    L83:
        LiveStickerDialogViewPagerAdapter r37 = this.l;
        if (r37 == null) goto L89;
        WeakReference<View> r38 = r37.b;
        if (r38 == null) goto L88;
        r38.clear();
    L88:
        ((LinkedHashMap) r37.c).clear();
        ((LinkedHashMap) r37.d).clear();
    L89:
        this.l = null;
        this.k.clear();
        this.n.a = null;
        this.m.a = null;
        this.r.h();
        View r39 = getView();
        if (r39 == null) goto L92;
        r8 = r39.findViewById(2131387344);
    L92:
        if (r8 == null) goto L95;
        r8.post(new b(this));
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.k.clear();
    }

    public static final void S90(LiveStickerDialogV2 r1) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void T90(LiveStickerDialogV2 r1) {
        r1.getClass();
        r1.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L12;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        ViewGroup.LayoutParams r1 = null;
        if ((r5 instanceof LiveBottomSheetDialog) == true) goto L5;
        r5 = null;
    L5:
        LiveBottomSheetDialog r6 = (LiveBottomSheetDialog) r5;
        if (r6 == null) goto L8;
        View r7 = r6.getBottomSheetView();
    L9:
        if (r7 == null) goto L12;
        r1 = r7.getLayoutParams();
    L12:
        if (r1 == null) goto L14;
        r1.height = -1;
    L14:
        if (r7 == null) goto L16;
        r7.setLayoutParams(r1);
    L16:
        Dialog r8 = getDialog();
        if (r8 == null) goto L25;
        Window r2 = r8.getWindow();
        if (r2 == null) goto L23;
        r2.addFlags(67108864);
        r2.setLayout(-1, -2);
        WindowManager.LayoutParams r0 = r2.getAttributes();
        r0.width = s1.y();
        r0.height = s1.w();
        r2.setAttributes(r0);
        r2.setGravity(80);
        View r3 = r2.findViewById(2131389843);
        if (r3 == null) goto L23;
        r3.setVisibility(8);
    L23:
        r8.setCanceledOnTouchOutside(true);
        return;
    L25:
        return;
    L8:
        r7 = null;
        goto L9
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setStyle(1, 2131954666);
        super.setBottomSheetSlideProcessor(k.a);
        final f0 r5 = V90();
        com.bytedance.android.live.effect.base.f r0 = this.o;
        String r1 = r5.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.c = r1;
        com.bytedance.android.live.effect.sticker.viewmodel.b<InsertStickerInfo> r2 = this.n;
        InsertStickerInfo r3 = r2.a;
        r2.a = null;
        final InsertStickerInfo r6 = r3;
        StickerDataViewModel r7 = (StickerDataViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$1(this, r5, r6)).a(StickerDataViewModel.class);
        com.bytedance.live.datacontext.b.a(r7, this.q.name() + StickerDataViewModel.class.getName());
        this.f = r7;
        com.bytedance.live.datacontext.b.a((StickerSearchViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$2(this)).a(StickerSearchViewModel.class), this.q.name() + StickerSearchViewModel.class.getName());
        StickerDialogUIViewModel r8 = (StickerDialogUIViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$3(this)).a(StickerDialogUIViewModel.class);
        com.bytedance.live.datacontext.b.a(r8, this.q.name() + StickerDialogUIViewModel.class.getName());
        this.g = r8;
        StickerPreviewViewModel r9 = (StickerPreviewViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$4(this)).a(StickerPreviewViewModel.class);
        com.bytedance.live.datacontext.b.a(r9, this.q.name() + StickerPreviewViewModel.class.getName());
        this.h = r9;
        StickerRenderViewModel r11 = (StickerRenderViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$5(this)).a(StickerRenderViewModel.class);
        com.bytedance.live.datacontext.b.a(r11, this.q.name() + StickerRenderViewModel.class.getName());
        this.i = r11;
        StickerAigcViewModel r12 = (StickerAigcViewModel) com.bytedance.live.datacontext.d.b(this, new LiveStickerDialogV2$initViewModel$6(this)).a(StickerAigcViewModel.class);
        com.bytedance.live.datacontext.b.a(r12, this.q.name() + StickerAigcViewModel.class.getName());
        this.j = r12;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        StickerDataViewModel r7 = this.f;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L5:
        r7.getPanelLoadingStatus().observe(this, new r(this));
        StickerDataViewModel r8 = this.f;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L8:
        r8.getCategoryListInfo().observe(this, new s(this));
        StickerDataViewModel r9 = this.f;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L11:
        r9.getCampaignCategoryInfo().observe(this, new t(this));
        StickerDialogUIViewModel r11 = this.g;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L14:
        RxUtilKt.c(com.bytedance.android.live.effect.sticker.viewmodel.d.a(r11.getSearchPageStatus(), new LiveStickerDialogV2$registerLiveData$4(this)), this.k);
        StickerRenderViewModel r12 = this.i;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("stickerRenderViewModel");
    L17:
        r12.getRenderStickerData().observe(this, new u(this));
        StickerPreviewViewModel r13 = this.h;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L20:
        r13.getPreviewStatusData().observe(this, new v(this));
        StickerDialogUIViewModel r14 = this.g;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L23:
        r14.getCurrentSelectStickerData().observe(this, new w(this));
        StickerAigcViewModel r15 = this.j;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L26:
        r15.getAigcTaskPanelVisible().observe(this, new x(this));
        StickerAigcViewModel r16 = this.j;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L29:
        r16.getAigcTaskPanelStatus().observe(this, new y(this));
        StickerAigcViewModel r17 = this.j;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L32:
        r17.getAigcHintStatus().observe(this, new o(this));
        StickerAigcViewModel r18 = this.j;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L35:
        r18.getAigcTaskPanelListener().observe(this, new p(this));
        StickerDialogUIViewModel r19 = this.g;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L38:
        RxUtilKt.c(r19.getHideDialogEvent().onEvent().subscribe(new q(this)), this.k);
        RxUtilKt.c(xs2.b.a().b(n90.f.class).subscribe(new z(this)), this.k);
        View r21 = getView();
        if (r21 == null) goto L43;
        Button r22 = (Button) r21.findViewById(2131364595);
        if (r22 == null) goto L43;
        r22.setOnClickListener(new i(this));
    L43:
        View r23 = getView();
        if (r23 == null) goto L48;
        View r24 = r23.findViewById(2131364111);
        if (r24 == null) goto L48;
        r24.setOnClickListener(new j(this));
    L48:
        HSImageView r0 = null;
        View r25 = LayoutInflater.from(getContext()).inflate(2131565944, null, false);
        if (r25 == null) goto L51;
        r25.setOnClickListener(new m(this));
    L51:
        Context r26 = getContext();
        if (r26 == null) goto L54;
        FrameLayout r2 = new LiveDoubleColorBallAnimationView(r26);
        int r27 = r2.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r27, r27);
        r3.gravity = 17;
        r2.setLayoutParams(r3);
    L55:
        View r28 = getView();
        if (r28 == null) goto L60;
        LoadingStatusView r29 = r28.findViewById(2131387318);
        if (r29 == null) goto L60;
        r29.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(r29.getContext()).setErrorView(r25).setLoadingView(r2));
    L60:
        W90();
        View r31 = getView();
        if (r31 == null) goto L65;
        SurfaceView r32 = (SurfaceView) r31.findViewById(2131371503);
        if (r32 == null) goto L65;
        List<String> r33 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.p).a().i(r32);
    L65:
        View r34 = getView();
        if (r34 == null) goto L70;
        Button r35 = (Button) r34.findViewById(2131371499);
        if (r35 == null) goto L70;
        this.r.d();
        r35.setText("选择");
        r35.setOnClickListener(new n(this));
    L70:
        LiveEffectScene r36 = this.q;
        if (r36 != LiveEffectScene.Preview) goto L73;
    L74:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r37 = m90.b.v;
        if (((Boolean) r37.getValue()).booleanValue() == true) goto L91;
        com.bytedance.android.livesdk.sharedpref.f.d(r37, Boolean.TRUE);
        View r38 = getView();
        if (r38 == null) goto L79;
        r0 = (HSImageView) r38.findViewById(2131371506);
    L79:
        ImageLoader.bindImage(r0, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/webcast_native_resource_douyin/effect_preview/image_effect_preview_tips.png");
        View r39 = getView();
        if (r39 == null) goto L84;
        ConstraintLayout r41 = r39.findViewById(2131371502);
        if (r41 == null) goto L84;
        r41.setVisibility(0);
    L84:
        View r42 = getView();
        if (r42 == null) goto L89;
        ConstraintLayout r43 = r42.findViewById(2131371502);
        if (r43 == null) goto L89;
        r43.setOnClickListener(new b0(this));
    L89:
        RxUtilKt.c(Observable.just("").delay(n5.DEFAULT_SHOW_DURATION, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(this)), this.k);
    L91:
        if (this.d == false) goto L98;
        View r44 = getView();
        if (r44 == null) goto L98;
        StickerFavoriteView r45 = (StickerFavoriteView) r44.findViewById(2131372178);
        if (r45 == null) goto L98;
        r45.setFavoriteStatusListener(new l(r45, this));
    L98:
        if (this.e == false) goto L104;
        View r46 = getView();
        if (r46 == null) goto L104;
        StickerSearchPageView r47 = (StickerSearchPageView) r46.findViewById(2131385553);
        if (r47 == null) goto L104;
        StickerSearchPageView.i6(r47, this.p, this.q, this);
    L104:
        X90();
        this.r.h();
        return;
    L73:
        if (r36 != LiveEffectScene.Live) goto L91;
    L54:
        r2 = null;
        goto L55
    }

    public final int show(FragmentTransaction r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "transaction");
        Y90();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, this, r0) == false) goto L9;
        return -1;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L7:
        return super.show(r2, r3);
    }

    public final void showNow(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Y90();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r2, r3);
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Y90();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.show(r2, r3);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Dialog r5 = getDialog();
        if (r5 == null) goto L8;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L8;
        r6.setSoftInputMode(48);
    L8:
        return r2.inflate(2131565864, r3, false);
    }

    public LiveStickerDialogV2(LiveEffectContextFactoryDelegate$Type r1, LiveEffectScene r2, x0 r3, List r4, String r5, ws1.a r6, List r7, String r8, boolean r9) {
        this.p = r1;
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.t = r5;
        this.u = r6;
        this.v = r7;
        this.w = r8;
        this.x = r9;
        this.d = r7.contains(SpecialTabType.FAVORITE);
        this.e = r7.contains(SpecialTabType.SEARCH);
        r7.contains(SpecialTabType.CAMPAIGN);
        this.k = new CompositeDisposable();
        this.m = new com.bytedance.android.live.effect.sticker.viewmodel.b();
        this.n = new com.bytedance.android.live.effect.sticker.viewmodel.b();
        this.o = new com.bytedance.android.live.effect.base.f();
    }
}
