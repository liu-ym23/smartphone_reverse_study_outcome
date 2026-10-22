package com.larus.camera.impl.ui.component.result.general.edu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.camera.api.vlm.VLMIntentScene;
import com.larus.camera.impl.databinding.LarusLayoutViewResultEduIntentPreviewComponentBinding;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.component.result.edu.EduResultTabView;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.k;
import com.larus.camera.impl.utils.u;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ix8.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import nx8.l;
import nx8.m;
import oq9.g;
import oq9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultEduIntentPreviewComponent extends com.larus.camera.impl.ui.arch.b {
    public static final /* synthetic */ int s = 0;
    public m m;
    public LarusLayoutViewResultEduIntentPreviewComponentBinding n;
    public final Lazy o;
    public final Lazy p;
    public EduIntentMode q;
    public List<? extends VLMIntentScene> r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EduIntentMode.values().length];
            r0[EduIntentMode.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EduIntentMode.SINGLE_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EduIntentMode.MULTI_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EduIntentMode.HOMEWORK_CORRECTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements m.a {
        public final /* synthetic */ CameraResultViewModel a;

        public c(CameraResultViewModel r1) {
            this.a = r1;
        }

        @Override // nx8.m.a
        public final void a(int r2) {
            this.a.clickImageRangeOnResultPage(r2);
            this.a.changeSelectedBounds();
        }
    }

    static {
    }

    public ResultEduIntentPreviewComponent() {
        super(com.larus.camera.impl.ui.arch.c.a, 1);
        this.o = LazyKt.lazy(new com.larus.camera.impl.ui.component.result.general.edu.b());
        this.p = LazyKt.lazy(new com.larus.camera.impl.ui.component.result.general.edu.c());
        this.q = EduIntentMode.SINGLE_QUESTION;
        this.r = CollectionsKt.emptyList();
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, null, 6, null);
        r0.updatePageStyle();
        String r1 = r0.getParamAlbumUrl();
        LarusLayoutViewResultEduIntentPreviewComponentBinding r2 = this.n;
        if (r2 == null) goto L10;
        EduResultTabView r3 = r2.c;
        if (r3 == null) goto L10;
        r3.a(r0, k());
    L10:
        m r4 = this.m;
        if (r4 == null) goto L14;
        r0.updateEduImageAbility(r4);
    L14:
        if (k.a() == true) goto L18;
        m r5 = this.m;
        if (r5 == null) goto L18;
        r5.m(new c(r0));
    L18:
        BuildersKt.launch$default(k(), null, null, new ResultEduIntentPreviewComponent$onViewCreated$3(r0, this, r1, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getRotation(), new ResultEduIntentPreviewComponent$onViewCreated$4(r0, this, null)), CoroutineScopeKt.plus(k(), Dispatchers.getMain()));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getEduResultTabState(), new ResultEduIntentPreviewComponent$onViewCreated$5(this, r0, null)), CoroutineScopeKt.plus(k(), Dispatchers.getMain()));
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        m r0 = this.m;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final g q() {
        return (g) this.p.getValue();
    }

    public final void r() {
        final CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        ix8.d r1 = r0.detectedIntent();
        EduResultMode r3 = null;
        if ((r1 instanceof ix8.d.b) == false) goto L8;
        ix8.d.b r2 = (ix8.d.b) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        FLogger r4 = FLogger.a;
        r4.i("ResultEduIntentPreviewComponent", "[initQuestionClipViewInternal] eduResult=" + r2);
        if (this.n == null) goto L77;
        m r6 = this.m;
        if (r6 == null) goto L16;
        r6.g(r2.g, r2.e, r2.f, Intrinsics.areEqual(((h) this.o.getValue()).r(), Boolean.TRUE), SceneType.Doubao_General_Camera_Intent_Recognition_Education_Qa, r2.i, r2.j, q().b());
    L16:
        boolean r5 = t();
        boolean r7 = true;
        if (q().d() == false) goto L34;
        this.r = i.a(r2).a;
        if (q().a() != 1) goto L21;
        EduIntentMode r8 = EduIntentMode.MULTI_QUESTION;
    L23:
        if (s(r8, r5) == true) goto L26;
        r8 = null;
    L26:
        if (r8 != null) goto L33;
        r8 = EduIntentMode.SINGLE_QUESTION;
        if (s(r8, r5) == true) goto L31;
        r8 = null;
    L31:
        if (r8 != null) goto L33;
        r8 = EduIntentMode.COMMON;
    L33:
        u(r8);
    L39:
        r4.i("ResultEduIntentPreviewComponent", "[initCurrentIntent] currentIntent:" + this.q + ", multiQuestionEnabled:" + r5 + ", eduCameraResultTabConfig:" + q() + ", availableIntentScenes:" + this.r);
        LarusLayoutViewResultEduIntentPreviewComponentBinding r9 = this.n;
        if (r9 != null) goto L43;
    L75:
        p(r0, false);
        return;
    L43:
        if (q().d() == false) goto L74;
        r9.d.setVisibility(8);
        r9.d.setOnClickListener(null);
        boolean r10 = t();
        List r11 = CollectionsKt.createListBuilder();
        if (this.r.contains(VLMIntentScene.QUESTION_SOLVING) == false) goto L49;
        r11.add(EduResultMode.SINGLE_QUESTION);
        if (r10 == false) goto L49;
        r11.add(EduResultMode.MULTI_QUESTION);
    L49:
        if (r10 == false) goto L54;
        if (this.r.contains(VLMIntentScene.HOMEWORK_CORRECTION) == false) goto L54;
        r11.add(EduResultMode.HOMEWORK_CORRECTION);
    L54:
        if (this.r.contains(VLMIntentScene.COMMON) == false) goto L56;
        r11.add(EduResultMode.PHOTO);
    L56:
        List r12 = CollectionsKt.build(r11);
        EduResultMode r13 = v(this.q);
        if (r12.contains(r13) == true) goto L60;
        r13 = null;
    L60:
        if (r13 != null) goto L69;
        r13 = EduResultMode.SINGLE_QUESTION;
        if (r12.contains(r13) == false) goto L64;
        r3 = r13;
    L64:
        if (r3 != null) goto L68;
        r3 = (EduResultMode) CollectionsKt.firstOrNull(r12);
        if (r3 == null) goto L69;
    L68:
        r13 = r3;
    L69:
        u(r13.toEduIntentMode());
        if (r12.size() > 1) goto L73;
        r7 = false;
    L73:
        r0.updateEduResultTabState(new px8.b(r12, r13, r7, r13));
        goto L75
    L74:
        r0.updateEduResultTabState(px8.b.e);
        TextView r14 = r9.d;
        Intrinsics.checkNotNull(r14);
        w(r14);
        r14.setVisibility(0);
        r14.setOnClickListener(new d(r0, this));
        Intrinsics.checkNotNull(r14);
        goto L75
    L21:
        r8 = EduIntentMode.SINGLE_QUESTION;
        goto L23
    L34:
        this.r = CollectionsKt.emptyList();
        EduIntentMode.a r15 = EduIntentMode.Companion;
        int r16 = z2.a.getMainCameraDetectConfig().b();
        r15.getClass();
        EduIntentMode r17 = EduIntentMode.a.a(r16);
        if (r5 == true) goto L38;
        r17 = EduIntentMode.SINGLE_QUESTION;
    L38:
        u(r17);
        goto L39
    L77:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final boolean t() {
        m r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(((h) this.o.getValue()).r(), Boolean.TRUE) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r0.k() != true) goto L7;
        r1 = true;
        goto L8
    }

    public static EduResultMode v(EduIntentMode r1) {
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L12;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L14;
        return EduResultMode.SINGLE_QUESTION;
    L14:
        return EduResultMode.HOMEWORK_CORRECTION;
    L15:
        return EduResultMode.MULTI_QUESTION;
    L12:
        return EduResultMode.PHOTO;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public final void u(EduIntentMode r3) {
        this.q = r3;
        FLogger.a.i("ResultEduIntentPreviewComponent", "[currentIntent] " + this.q);
    }

    public final void w(TextView r8) {
        CameraResultViewModel r1 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 == null) goto L17;
        EduIntentMode r0 = this.q;
        if (r0 != EduIntentMode.SINGLE_QUESTION) goto L9;
        String r2 = "identify_single_question";
    L15:
        CameraResultViewModel.showCameraItemForEduMode$default(r1, r2, null, null, 6, null);
        goto L17
    L9:
        if (r0 != EduIntentMode.MULTI_QUESTION) goto L12;
        r2 = "identify_multi_question";
        goto L15
    L12:
        if (r0 != EduIntentMode.HOMEWORK_CORRECTION) goto L14;
        r2 = "identify_check";
        goto L15
    L14:
        r2 = "identify_picture";
    L17:
        if (this.q == EduIntentMode.SINGLE_QUESTION) goto L19;
    L21:
        CharSequence r3 = r8.getContext().getText(this.q.getTextResId());
    L22:
        Intrinsics.checkNotNull(r3);
        r8.setText(r8.getContext().getString(2131900563, new Object[]{r3}));
        return;
    L19:
        if (t() == true) goto L21;
        r3 = r8.getContext().getText(2131900560);
        goto L22
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r7, ViewGroup r8) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Intrinsics.checkNotNullParameter(r8, "parent");
        u.a();
        ConstraintLayout r9 = r7.inflate(2131562921, r8, false);
        int r0 = 2131364481;
        if (ViewBindings.findChildViewById(r9, 2131364481) == null) goto L29;
        ConstraintLayout r1 = r9;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r9, 2131371490);
        if (r2 == null) goto L27;
        EduResultTabView r3 = (EduResultTabView) ViewBindings.findChildViewById(r9, 2131371492);
        if (r3 == null) goto L26;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, 2131375496);
        if (r4 != null) goto L11;
        r0 = 2131375496;
        goto L29
    L11:
        if (ViewBindings.findChildViewById(r9, 2131389181) == null) goto L24;
        this.n = new LarusLayoutViewResultEduIntentPreviewComponentBinding(r1, r2, r3, r4);
        Context r10 = r7.getContext();
        com.larus.camera.impl.edulibs.camera.a r11 = com.larus.camera.impl.edulibs.camera.a.a;
        Intrinsics.checkNotNull(r10);
        ViewGroup r5 = null;
        m r12 = l.a(r10, nx8.i.g.d, null, 12);
        this.m = r12;
        ((com.larus.camera.impl.edulibs.camera.c) r12).t();
        m r13 = this.m;
        if (r13 == null) goto L16;
        View r14 = r13.getView();
        if (r14 == null) goto L16;
    L17:
        ViewParent r15 = r14.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L20;
        r5 = (ViewGroup) r15;
    L20:
        if (r5 == null) goto L22;
        r5.removeView(r14);
    L22:
        r2.addView(r14, new FrameLayout.LayoutParams(-1, -1));
        r4.setBackgroundColor(ColorProtector.parseColor("#CC454545"));
        r4.setClipToOutline(true);
        r4.setOutlineProvider(new f());
        return r1;
    L16:
        r14 = new AppCompatImageView(r10);
        goto L17
    L24:
        r0 = 2131389181;
        goto L29
    L26:
        r0 = 2131371492;
        goto L29
    L27:
        r0 = 2131371490;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    public final void p(CameraResultViewModel r7, boolean r8) {
        r7.changeEduIntent(this.q);
        if (r8 == false) goto L16;
        EduIntentMode r9 = this.q;
        if (r9 != EduIntentMode.SINGLE_QUESTION) goto L9;
        String r10 = "single_question_mode";
    L15:
        CameraResultViewModel.clickCameraButtonForEduMode$default(r7, r10, null, null, 6, null);
        goto L16
    L9:
        if (r9 != EduIntentMode.MULTI_QUESTION) goto L12;
        r10 = "multi_question_mode";
        goto L15
    L12:
        if (r9 != EduIntentMode.HOMEWORK_CORRECTION) goto L14;
        r10 = "check_mode";
        goto L15
    L14:
        r10 = "picture_mode";
    L16:
        m r11 = this.m;
        int r0 = 0;
        if (r11 == null) goto L23;
        nx8.c r1 = this.q.getClipViewMode();
        if (this.q != EduIntentMode.COMMON) goto L21;
        boolean r2 = true;
    L22:
        r11.a(r1, r2);
        goto L23
    L21:
        r2 = false;
    L23:
        EduResultMode r12 = v(this.q);
        m r3 = this.m;
        if (r3 == null) goto L26;
        r0 = r3.l();
    L26:
        r7.reportClipItemsIfNeeded(r12, r0);
        m r13 = this.m;
        if (r13 == null) goto L34;
        if (this.q != EduIntentMode.HOMEWORK_CORRECTION) goto L31;
        SceneType r14 = SceneType.Doubao_General_Camera_Intent_Recognition_Education_Correction;
    L32:
        r13.n(r14);
        goto L34
    L31:
        r14 = SceneType.Doubao_General_Camera_Intent_Recognition_Education_Qa;
    L34:
        if (q().d() == true) goto L41;
        LarusLayoutViewResultEduIntentPreviewComponentBinding r15 = this.n;
        if (r15 == null) goto L42;
        TextView r16 = r15.d;
        if (r16 == null) goto L43;
        w(r16);
        return;
    L43:
        return;
    L42:
        return;
    }

    public final boolean s(EduIntentMode r4, boolean r5) {
        int r6 = b.a[r4.ordinal()];
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L23;
        if (r6 != 3) goto L9;
        if (r5 == true) goto L17;
    L10:
        return false;
    L17:
        if (this.r.contains(VLMIntentScene.QUESTION_SOLVING) == false) goto L10;
        return true;
    L9:
        if (r6 != 4) goto L10;
        if (r5 == false) goto L10;
        if (this.r.contains(VLMIntentScene.HOMEWORK_CORRECTION) == false) goto L10;
        return true;
    L23:
        return this.r.contains(VLMIntentScene.QUESTION_SOLVING);
    L21:
        return this.r.contains(VLMIntentScene.COMMON);
    }
}
