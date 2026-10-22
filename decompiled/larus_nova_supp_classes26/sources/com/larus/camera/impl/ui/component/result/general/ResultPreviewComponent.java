package com.larus.camera.impl.ui.component.result.general;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.databinding.LarusLayoutViewPreviewComponentBinding;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.generalonly.adapter.HorizontalItemDecoration;
import com.larus.camera.impl.ui.component.generalonly.adapter.ResultPreviewImageThumbListAdapter;
import com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class ResultPreviewComponent extends com.larus.camera.impl.ui.arch.b {
    public static final /* synthetic */ int z = 0;
    public LarusLayoutViewPreviewComponentBinding m;
    public final Lazy n;
    public int o;
    public boolean p;
    public u q;
    public boolean r;
    public final LinkedHashMap<View, Integer> s;
    public long t;
    public int u;
    public int v;
    public ConstraintLayout.LayoutParams w;
    public boolean x;
    public int y;

    public static final class a {
    }

    static {
    }

    public ResultPreviewComponent() {
        super(com.larus.camera.impl.ui.arch.c.a, 1);
        this.n = LazyKt.lazy(new q(this));
        this.s = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, com.larus.camera.impl.ui.component.result.general.u] */
    @Override // com.larus.camera.impl.ui.arch.b
    public void m() {
        final CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCurrentBitmap(), new ResultPreviewComponent$observeUnifiedPreviewLayout$1(this, r0, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultDetectionStatus(), new ResultPreviewComponent$observeUnifiedPreviewLayout$2(this, r0, null)), k());
        ?? r1 = new u(this, r0);
        this.q = r1;
        j().getViewTreeObserver().addOnGlobalLayoutListener(r1);
        LarusLayoutViewPreviewComponentBinding r2 = this.m;
        if (r2 == null) goto L10;
        PreviewContainerView r3 = r2.d;
        if (r3 == null) goto L10;
        r3.setUnifiedPreviewEnabled(CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r0, null, 1, null));
    L10:
        r0.updatePageStyle();
        r0.enterResultPage();
        r0.tryAdaptBottomLine((ConstraintLayout) h(2131367728), s(), new t(this, r0));
        BuildersKt.launch$default(k(), null, null, new ResultPreviewComponent$onViewCreated$2(r0, r0.getParamAlbumUrl(), this, null), 3, null);
        InputParam r4 = r0.getInputParam();
        if (r4 == null) goto L15;
        InputParamExtra r5 = r4.getExtra();
        if (r5 == null) goto L15;
        String r6 = (String) r5.get(InputParamExtra.KEY_RAW_IMAGE_URI);
    L16:
        if (r6 != null) goto L18;
    L21:
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
    L26:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.isInCropMode(), new ResultPreviewComponent$onViewCreated$4(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.isMultiResultLoadComplete(), new ResultPreviewComponent$onViewCreated$5(r0, this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureAppendComplete(), new ResultPreviewComponent$onViewCreated$6(this, null)), k());
        return;
    L24:
        if (r0.resultSupportMark() == false) goto L26;
        r0.setRawImageLoading(true);
        BuildersKt.launch$default(k(), null, null, new ResultPreviewComponent$onViewCreated$3(r6, r0, null), 3, null);
        goto L26
    L18:
        if (r6.length() == 0) goto L21;
        r7 = false;
    L15:
        r6 = null;
        goto L16
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public void n() {
        u r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        this.q = null;
        this.s.clear();
        this.r = false;
        this.x = false;
        this.y = 0;
        this.w = null;
        this.m = null;
        return;
    L5:
        if (j().getViewTreeObserver().isAlive() == false) goto L7;
        j().getViewTreeObserver().removeOnGlobalLayoutListener(r0);
        goto L7
    }

    public final int s() {
        if (this.x == false) goto L6;
        Resources r1 = getContext().getResources();
        return MathKt.roundToInt(144 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
    L6:
        return getContext().getResources().getDimensionPixelSize(2131166616);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public final void q(CameraResultViewModel r8) {
        LarusLayoutViewPreviewComponentBinding r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r9 = r8.shouldUseUnifiedMediaCanvas();
        if (r9 != this.x) goto L8;
        return;
    L8:
        this.x = r9;
        Resources r1 = r0.a.getResources();
        float r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        PreviewContainerView r3 = r0.d;
        FrameLayout.LayoutParams r4 = null;
        if (r9 == false) goto L11;
        ConstraintLayout.LayoutParams r5 = r0.d.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(r5);
        r6.dimensionRatio = null;
    L15:
        r3.setLayoutParams(r6);
        Guideline r7 = r0.e;
        if (r9 == false) goto L18;
        int r10 = MathKt.roundToInt(52 * r2);
    L19:
        r7.setGuidelineBegin(r10);
        if (r9 == false) goto L22;
        int r11 = MathKt.roundToInt(144 * r2);
    L23:
        r0.b.setGuidelineEnd(r11 + this.y);
        if (r9 == false) goto L42;
        PreviewContainerView r12 = r0.d;
        ViewPager2 r13 = r12.c;
        if (r13 == null) goto L28;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L30:
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L32;
        r4 = (FrameLayout.LayoutParams) r14;
    L32:
        if (r4 != null) goto L35;
        return;
    L35:
        if (r4.width == (-1)) goto L37;
    L39:
        r12.w = new FrameLayout.LayoutParams(r4);
        ViewPager2 r15 = r12.c;
        if (r15 == null) goto L50;
        r15.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        return;
    L50:
        return;
    L37:
        if (r4.height != (-1)) goto L39;
        return;
    L28:
        r14 = null;
        goto L30
    L42:
        PreviewContainerView r16 = r0.d;
        FrameLayout.LayoutParams r17 = r16.w;
        if (r17 == null) goto L54;
        ViewPager2 r18 = r16.c;
        if (r18 == null) goto L48;
        r18.setLayoutParams(new FrameLayout.LayoutParams(r17));
    L48:
        r16.w = null;
        return;
    L54:
        return;
    L22:
        r11 = r0.a.getResources().getDimensionPixelSize(2131166616);
        goto L23
    L18:
        r10 = r0.a.getResources().getDimensionPixelSize(2131166622);
        goto L19
    L11:
        ConstraintLayout.LayoutParams r19 = this.w;
        if (r19 != null) goto L14;
        return;
    L14:
        r6 = new ConstraintLayout.LayoutParams(r19);
        goto L15
    }

    public final void r(Integer r11) {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L6;
    L10:
        boolean r1 = false;
    L13:
        if (r1 == true) goto L16;
        FLogger.a.i("ResultPreviewComponent", "initPreviewThumbList return");
        return;
    L16:
        CameraResultViewModel r2 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r2 != null) goto L19;
        return;
    L19:
        ResultPreviewImageThumbListAdapter r4 = (ResultPreviewImageThumbListAdapter) this.n.getValue();
        boolean r5 = r2.shouldUseLargeUnifiedThumbnails();
        if (r4.c == r5) goto L23;
        r4.c = r5;
        r4.notifyDataSetChanged();
    L23:
        boolean r6 = this.p;
        boolean r7 = !r6;
        LarusLayoutViewPreviewComponentBinding r8 = this.m;
        if (r8 == null) goto L37;
        final RecyclerView r9 = r8.c;
        if (r9 == null) goto L37;
        if (r6 == true) goto L29;
        r9.setLayoutManager(new LinearLayoutManager(r9.getContext(), 0, false));
        r9.addItemDecoration(new HorizontalItemDecoration(0, i5.h(), i5.h()));
        r9.setAdapter((ResultPreviewImageThumbListAdapter) this.n.getValue());
        r9.setItemAnimator(null);
        this.p = true;
    L29:
        if (r11 == null) goto L31;
        final int r3 = r11.intValue();
    L32:
        if (r3 > 0) goto L36;
        if (r3 != 0) goto L37;
        if (r2.isMultiResultFromCamera() == false) goto L37;
    L36:
        FLogger.a.i("ResultPreviewComponent", "initPreviewThumbList " + r11 + ", selectedPosition=" + r3);
        u(r3, "initPreviewThumbList");
        r9.post(new r(r9, r3));
        goto L37
    L31:
        com.larus.camera.impl.ui.viewmodel.t r10 = com.larus.camera.impl.ui.viewmodel.t.a;
        r3 = com.larus.camera.impl.ui.viewmodel.t.e() - 1;
    L37:
        if (r7 == true) goto L39;
        return;
    L39:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2.previewThumbListStateFlow(), new ResultPreviewComponent$initPreviewThumbList$2(this, r2, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.w(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(r2.isInDrawingMode(), r2.isInCropMode(), new ResultPreviewComponent$initPreviewThumbList$3(null)), r2.isSeekbarDragging(), new ResultPreviewComponent$initPreviewThumbList$4(null)), Dispatchers.getMain()), new ResultPreviewComponent$initPreviewThumbList$5(this, null)), k());
        return;
    L6:
        if (r0.isMultiCaptureEnabled() == false) goto L8;
    L11:
        r1 = true;
        goto L13
    L8:
        if (r0.isMultiResultFromCamera() == false) goto L10;
        goto L10
    }

    public final void t(CameraContainer r6) {
        this.r = false;
        Iterator<Map.Entry<View, Integer>> r0 = this.s.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<View, Integer> r1 = r0.next();
        View r2 = r1.getKey();
        int r3 = r1.getValue().intValue();
        if (r2.getParent() != r6) goto L4;
        if (r2.getVisibility() != 4) goto L4;
        r2.setVisibility(r3);
        goto L4
    L10:
        this.s.clear();
        u(this.o, "restorePreviewChrome");
    }

    public final void v(CameraResultViewModel r7) {
        ConstraintLayout.LayoutParams r0 = null;
        boolean r2 = CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r7, null, 1, null);
        LarusLayoutViewPreviewComponentBinding r3 = this.m;
        if (r3 == null) goto L7;
        PreviewContainerView r4 = r3.d;
        if (r4 == null) goto L7;
        r4.setUnifiedPreviewEnabled(r2);
    L7:
        LarusLayoutViewPreviewComponentBinding r5 = this.m;
        if (r5 == null) goto L12;
        ConstraintLayout r6 = r5.a;
        if (r6 == null) goto L12;
        boolean r1 = true ^ r2;
        r6.setClipChildren(r1);
        r6.setClipToPadding(r1);
    L12:
        int r8 = 0;
        if (this.x == true) goto L44;
        LarusLayoutViewPreviewComponentBinding r9 = this.m;
        if (r9 == null) goto L38;
        RecyclerView r10 = r9.c;
        int r11 = this.u;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
    L21:
        if (r13 == null) goto L27;
        int r14 = r11 + 0;
        if (((ViewGroup.MarginLayoutParams) r13).bottomMargin == r14) goto L27;
        ((ViewGroup.MarginLayoutParams) r13).bottomMargin = r14;
        r10.setLayoutParams(r13);
    L27:
        View r15 = r9.f;
        int r16 = this.v;
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L30;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
    L31:
        if (r18 == null) goto L38;
        int r19 = r16 + 0;
        if (((ViewGroup.MarginLayoutParams) r18).bottomMargin == r19) goto L38;
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = r19;
        r15.setLayoutParams(r18);
        goto L38
    L30:
        r18 = null;
        goto L31
    L20:
        r13 = null;
    L38:
        if (this.r == false) goto L86;
        ViewParent r20 = j().getParent();
        if ((r20 instanceof CameraContainer) == false) goto L42;
        r0 = (CameraContainer) r20;
    L42:
        t(r0);
        return;
    L86:
        return;
    L44:
        LarusLayoutViewPreviewComponentBinding r21 = this.m;
        if (r21 == null) goto L87;
        PreviewContainerView r22 = r21.d;
        if (r22 != null) goto L50;
        return;
    L50:
        if (r22.getWidth() > 0) goto L52;
        return;
    L52:
        if (r22.getHeight() <= 0) goto L90;
        Bitmap r23 = (Bitmap) r7.getCurrentBitmap().getValue();
        if (r23 != null) goto L57;
    L63:
        LarusLayoutViewPreviewComponentBinding r24 = this.m;
        if (r24 == null) goto L91;
        RecyclerView r25 = r24.c;
        int r26 = this.u;
        ViewGroup.LayoutParams r27 = r25.getLayoutParams();
        if ((r27 instanceof ConstraintLayout.LayoutParams) == false) goto L69;
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
    L70:
        if (r28 == null) goto L76;
        int r29 = r26 + r8;
        if (((ViewGroup.MarginLayoutParams) r28).bottomMargin == r29) goto L76;
        ((ViewGroup.MarginLayoutParams) r28).bottomMargin = r29;
        r25.setLayoutParams(r28);
    L76:
        View r30 = r24.f;
        int r31 = this.v;
        ViewGroup.LayoutParams r32 = r30.getLayoutParams();
        if ((r32 instanceof ConstraintLayout.LayoutParams) == false) goto L79;
        r0 = (ConstraintLayout.LayoutParams) r32;
    L79:
        if (r0 == null) goto L92;
        int r33 = r31 + r8;
        if (((ViewGroup.MarginLayoutParams) r0).bottomMargin == r33) goto L93;
        ((ViewGroup.MarginLayoutParams) r0).bottomMargin = r33;
        r30.setLayoutParams(r0);
        return;
    L93:
        return;
    L92:
        return;
    L69:
        r28 = null;
        goto L70
    L91:
        return;
    L57:
        if (r23.isRecycled() == true) goto L63;
        if (r7.currentPreviewIsVideo() == true) goto L63;
        if (r7.currentPreviewIsGif() == true) goto L63;
        r8 = RangesKt.coerceAtLeast((int) ((r22.getHeight() - (r23.getHeight() * Math.min(r22.getWidth() / r23.getWidth(), r22.getHeight() / r23.getHeight()))) / 2.0f), 0);
        goto L63
    L90:
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public View g(LayoutInflater r12, ViewGroup r13) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        Intrinsics.checkNotNullParameter(r13, "parent");
        ConstraintLayout r14 = r12.inflate(2131562917, r13, false);
        int r15 = 2131364481;
        Guideline r3 = ViewBindings.findChildViewById(r14, 2131364481);
        if (r3 == null) goto L21;
        ConstraintLayout r16 = r14;
        RecyclerView r8 = ViewBindings.findChildViewById(r14, 2131382924);
        if (r8 == null) goto L19;
        PreviewContainerView r9 = (PreviewContainerView) ViewBindings.findChildViewById(r14, 2131382987);
        if (r9 == null) goto L18;
        Guideline r6 = ViewBindings.findChildViewById(r14, 2131389181);
        if (r6 == null) goto L17;
        View r10 = ViewBindings.findChildViewById(r14, 2131389272);
        if (r10 == null) goto L16;
        this.m = new LarusLayoutViewPreviewComponentBinding(r16, r3, r8, r9, r6, r10);
        ConstraintLayout.LayoutParams r0 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.w = new ConstraintLayout.LayoutParams(r0);
        ConstraintLayout.LayoutParams r17 = r8.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.u = ((ViewGroup.MarginLayoutParams) r17).bottomMargin;
        ConstraintLayout.LayoutParams r18 = r10.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.v = ((ViewGroup.MarginLayoutParams) r18).bottomMargin;
        CameraResultViewModel r19 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r19 == null) goto L15;
        q(r19);
    L15:
        return r16;
    L16:
        r15 = 2131389272;
        goto L21
    L17:
        r15 = 2131389181;
        goto L21
    L18:
        r15 = 2131382987;
        goto L21
    L19:
        r15 = 2131382924;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public final void u(int r7, String r8) {
        FLogger.a.i("ResultPreviewComponent", "updatePreviewThumbListState " + r7 + ' ' + r8);
        this.o = r7;
        com.larus.camera.impl.ui.viewmodel.t r9 = com.larus.camera.impl.ui.viewmodel.t.a;
        List r10 = com.larus.camera.impl.ui.viewmodel.t.f();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
        int r2 = 0;
    L3:
        boolean r4 = true;
        if (r11.hasNext() == false) goto L13;
        Object r3 = r11.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        OutputParam r6 = ((OutputParam) r3).clone();
        if (r2 == r7) goto L12;
        r4 = false;
    L12:
        r6.setSelected(r4);
        r0.add(r6);
        r2 = r5;
        goto L3
    L13:
        ((ResultPreviewImageThumbListAdapter) this.n.getValue()).submitList(r0);
        if (this.r == false) goto L16;
    L27:
        LarusLayoutViewPreviewComponentBinding r12 = this.m;
        if (r12 == null) goto L32;
        RecyclerView r13 = r12.c;
        if (r13 == null) goto L32;
        com.larus.utils.e1.o(r13);
    L32:
        LarusLayoutViewPreviewComponentBinding r14 = this.m;
        if (r14 == null) goto L44;
        View r15 = r14.f;
        if (r15 == null) goto L45;
        com.larus.utils.e1.o(r15);
        return;
    L45:
        return;
    L44:
        return;
    L16:
        if (r0.size() <= 1) goto L27;
        LarusLayoutViewPreviewComponentBinding r16 = this.m;
        if (r16 == null) goto L22;
        RecyclerView r17 = r16.c;
        if (r17 == null) goto L22;
        com.larus.utils.e1.x(r17);
    L22:
        LarusLayoutViewPreviewComponentBinding r18 = this.m;
        if (r18 == null) goto L41;
        View r19 = r18.f;
        if (r19 == null) goto L42;
        com.larus.utils.e1.x(r19);
        return;
    L42:
        return;
    }

    public final void p(OutputParam r19, int r20, Integer r21, Integer r22) {
        int r6 = this.o;
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 == null) goto L8;
        InputParam r1 = r0.getInputParam();
        if (r1 == null) goto L8;
        InputParam.InitialImageEditMode r2 = r1.getInitialImageEditMode();
        if (r2 == null) goto L8;
    L9:
        boolean r3 = true;
        if (r0 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L17;
    L20:
        if (r3 == false) goto L22;
        long r5 = this.t + 1;
        this.t = r5;
    L23:
        u(r20, "changeSelectedPreviewImage");
        BuildersKt.launch$default(k(), null, null, new ResultPreviewComponent$changeSelectedPreviewImage$1(this, r19, r3, r5, r6, r21, r20, r22, null), 3, null);
        return;
    L22:
        r5 = 0;
        goto L23
    L17:
        if (r2 != InputParam.InitialImageEditMode.NONE) goto L20;
        r3 = false;
        goto L20
    L12:
        if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r0, null, 1, null) != true) goto L14;
        r4 = true;
    L8:
        r2 = InputParam.InitialImageEditMode.NONE;
        goto L9
    }
}
