package com.larus.camera.impl.ui.component.result.edu;

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
import com.larus.camera.impl.databinding.LarusLayoutViewEduPreviewComponentBinding;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.c0;
import com.larus.camera.impl.utils.k;
import com.larus.camera.impl.utils.u;
import com.larus.camera.impl.widget.EduPreviewLoadingView;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import nx8.i;
import nx8.l;
import nx8.m;
import oq9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class EduResultPreviewComponent extends com.larus.camera.impl.ui.arch.b {
    public static final /* synthetic */ int q = 0;
    public m m;
    public LarusLayoutViewEduPreviewComponentBinding n;
    public final Lazy o;
    public boolean p;

    public static final class a {
    }

    public static final class b implements m.a {
        public final /* synthetic */ CameraResultViewModel a;

        public b(CameraResultViewModel r1) {
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

    public EduResultPreviewComponent() {
        super(com.larus.camera.impl.ui.arch.c.a, 1);
        this.o = LazyKt.lazy(new c());
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, null, 6, null);
        r0.updatePageStyle();
        r0.enterResultPage();
        boolean r7 = false;
        r0.setIsPhotoEditable(false);
        LarusLayoutViewEduPreviewComponentBinding r1 = this.n;
        if (r1 == null) goto L10;
        EduResultTabView r2 = r1.d;
        if (r2 == null) goto L10;
        r2.a(r0, k());
    L10:
        int r8 = r0.getParamOrientation();
        String r4 = r0.getParamAlbumUrl();
        m r3 = this.m;
        if (r3 == null) goto L14;
        r0.updateEduImageAbility(r3);
    L14:
        if (k.a() == true) goto L18;
        m r5 = this.m;
        if (r5 == null) goto L18;
        r5.m(new b(r0));
    L18:
        r0.recoverRotation(r8);
        BuildersKt.launch$default(k(), null, null, new EduResultPreviewComponent$onViewCreated$3(r0, this, r4, r8, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getRotation(), new EduResultPreviewComponent$onViewCreated$4(r0, this, null)), CoroutineScopeKt.plus(k(), Dispatchers.getMain()));
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getEduResultTabState(), new EduResultPreviewComponent$onViewCreated$5(this, r0, null)), CoroutineScopeKt.plus(k(), Dispatchers.getMain()));
        if (k.a() == true) goto L22;
        BuildersKt.launch$default(k(), null, null, new EduResultPreviewComponent$onViewCreated$6(this, r0, null), 3, null);
    L22:
        if (Intrinsics.areEqual(s(), "CAPTURE_MODE_EDU_GENERAL_PHOTO") == true) goto L24;
        LarusLayoutViewEduPreviewComponentBinding r6 = this.n;
        if (r6 == null) goto L70;
        TextView r9 = r6.g;
        if (r9 == null) goto L71;
        r9.setVisibility(8);
        return;
    L71:
        return;
    L70:
        return;
    L24:
        if (k.a() == false) goto L30;
        LarusLayoutViewEduPreviewComponentBinding r10 = this.n;
        if (r10 == null) goto L64;
        FrameLayout r11 = r10.e;
        if (r11 == null) goto L65;
        e1.o(r11);
        return;
    L65:
        return;
    L64:
        return;
    L30:
        LarusLayoutViewEduPreviewComponentBinding r12 = this.n;
        if (r12 == null) goto L67;
        FrameLayout r13 = r12.e;
        if (r13 == null) goto L68;
        int r14 = c0.d;
        float r15 = c0.a.a(r8, false);
        r13.setRotation(r15);
        ConstraintLayout.LayoutParams r16 = r13.getLayoutParams();
        if (r16 == null) goto L57;
        ConstraintLayout.LayoutParams r17 = r16;
        if (r15 != 270.0f) goto L39;
        boolean r18 = true;
    L41:
        if (r18 == false) goto L43;
    L54:
        r17.startToStart = -1;
        r17.endToEnd = 2131371490;
        r17.topToTop = 2131371490;
        r17.bottomToBottom = 2131371490;
    L55:
        r13.setLayoutParams(r17);
        return;
    L43:
        if (r15 != (-90.0f)) goto L45;
        boolean r19 = true;
    L46:
        if (r19 == true) goto L54;
        if (r15 != 90.0f) goto L51;
        r7 = true;
    L51:
        if (r7 == false) goto L53;
        r17.startToStart = 2131371490;
        r17.endToEnd = -1;
        r17.topToTop = 2131371490;
        r17.bottomToBottom = 2131371490;
        goto L55
    L53:
        r17.startToStart = 2131371490;
        r17.endToEnd = 2131371490;
        r17.topToTop = -1;
        r17.bottomToBottom = 2131371490;
        goto L55
    L45:
        r19 = false;
        goto L46
    L39:
        r18 = false;
        goto L41
    L57:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L68:
        return;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void n() {
        m r0 = this.m;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final String s() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 == null) goto L7;
        CameraData r1 = r0.getCameraData();
        if (r1 == null) goto L7;
        return r1.getCaptureMode();
    L7:
        return null;
    }

    public final boolean t() {
        if (Intrinsics.areEqual(z2.a.getEduCameraConfig().r(), Boolean.TRUE) == false) goto L13;
        m r0 = this.m;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.k() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public static px8.b r(EduResultMode r2, boolean r3) {
        List r0 = CollectionsKt.createListBuilder();
        r0.add(EduResultMode.SINGLE_QUESTION);
        r0.add(EduResultMode.MULTI_QUESTION);
        if (r3 == false) goto L6;
        r0.add(EduResultMode.HOMEWORK_CORRECTION);
    L6:
        return new px8.b(CollectionsKt.build(r0), r2, true, r2);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r17, ViewGroup r18) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Intrinsics.checkNotNullParameter(r18, "parent");
        u.a();
        boolean r4 = false;
        ConstraintLayout r2 = r17.inflate(2131562911, r18, false);
        int r3 = 2131364481;
        if (ViewBindings.findChildViewById(r2, 2131364481) == null) goto L87;
        ConstraintLayout r5 = r2;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131371490);
        if (r14 == null) goto L85;
        EduPreviewLoadingView r9 = (EduPreviewLoadingView) ViewBindings.findChildViewById(r2, 2131371491);
        if (r9 == null) goto L84;
        EduResultTabView r10 = (EduResultTabView) ViewBindings.findChildViewById(r2, 2131371492);
        if (r10 == null) goto L83;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131388740);
        if (r11 != null) goto L13;
        r3 = 2131388740;
        goto L87
    L13:
        if (ViewBindings.findChildViewById(r2, 2131389181) == null) goto L81;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r2, 2131390960);
        if (r15 == null) goto L80;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r2, 2131391594);
        if (r13 == null) goto L79;
        this.n = new LarusLayoutViewEduPreviewComponentBinding(r5, r14, r9, r10, r11, r15, r13);
        Context r1 = r17.getContext();
        String r6 = s();
        if (r6 == null) goto L53;
        switch(r6.hashCode()) {
            case -1332250801: goto L49;
            case -861871587: goto L45;
            case 358782896: goto L41;
            case 1556930703: goto L24;
            default: goto L53;
        };
    L24:
        if (r6.equals("CAPTURE_MODE_EDU_GENERAL_PHOTO") == false) goto L53;
        if (k.a() == false) goto L29;
        i r7 = i.g.d;
    L56:
        com.larus.camera.impl.edulibs.camera.a r8 = com.larus.camera.impl.edulibs.camera.a.a;
        Intrinsics.checkNotNull(r1);
        Pair[] r12 = new Pair[3];
        CameraResultViewModel r16 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        ViewGroup r19 = null;
        if (r16 == null) goto L61;
        CameraData r20 = r16.getCameraData();
        if (r20 == null) goto L61;
        String r21 = r20.getScene();
    L62:
        r12[0] = TuplesKt.to("is_from_live_tutor", Boolean.valueOf(Intrinsics.areEqual(r21, "edu_live_tutor")));
        if (Intrinsics.areEqual(s(), "CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == true) goto L65;
    L67:
        r12[1] = TuplesKt.to("need_question_detection", Boolean.valueOf(r4));
        r12[2] = TuplesKt.to("need_dewarp", Boolean.valueOf(((g) this.o.getValue()).b()));
        m r22 = l.a(r1, r7, MapsKt.mapOf(r12), 4);
        this.m = r22;
        ((com.larus.camera.impl.edulibs.camera.c) r22).t();
        m r23 = this.m;
        if (r23 == null) goto L71;
        View r24 = r23.getView();
        if (r24 == null) goto L71;
    L72:
        ViewParent r25 = r24.getParent();
        if ((r25 instanceof ViewGroup) == false) goto L75;
        r19 = (ViewGroup) r25;
    L75:
        if (r19 == null) goto L77;
        r19.removeView(r24);
    L77:
        r14.addView(r24, new FrameLayout.LayoutParams(-1, -1));
        r13.setText(z2.a.getEduCameraConfig().p());
        r13.setBackgroundColor(ColorProtector.parseColor("#4d000000"));
        r13.setClipToOutline(true);
        r13.setOutlineProvider(new d());
        r15.setBackgroundColor(ColorProtector.parseColor("#80666666"));
        r15.setClipToOutline(true);
        r15.setOutlineProvider(new e());
        return r5;
    L71:
        r24 = new AppCompatImageView(r1);
        goto L72
    L65:
        if (((g) this.o.getValue()).d() == false) goto L67;
        r4 = true;
    L61:
        r21 = null;
        goto L62
    L29:
        z2 r26 = z2.a;
        boolean r27 = Intrinsics.areEqual(r26.getEduCameraConfig().r(), Boolean.TRUE);
        if (r26.getEduDefaultQuestionMode() != 1) goto L32;
        boolean r28 = true;
    L33:
        if (r28 == false) goto L36;
        if (r27 == false) goto L36;
        boolean r29 = true;
    L37:
        if (r29 == false) goto L39;
        r7 = i.e.d;
        goto L56
    L39:
        r7 = i.f.d;
    L36:
        r29 = false;
        goto L37
    L32:
        r28 = false;
        goto L33
    L41:
        if (r6.equals("CAPTURE_MODE_EDU_CALCULATION_PHOTO") == false) goto L53;
        r7 = i.d.d;
        goto L56
    L45:
        if (r6.equals("CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L53;
        r7 = i.b.d;
        goto L56
    L49:
        if (r6.equals("CAPTURE_MODE_EDU_HOMEWORK_PHOTO") == false) goto L53;
        r7 = i.c.d;
    L53:
        if (k.a() == false) goto L55;
        r7 = i.g.d;
        goto L56
    L55:
        r7 = i.f.d;
        goto L56
    L79:
        r3 = 2131391594;
        goto L87
    L80:
        r3 = 2131390960;
        goto L87
    L81:
        r3 = 2131389181;
        goto L87
    L83:
        r3 = 2131371492;
        goto L87
    L84:
        r3 = 2131371491;
        goto L87
    L85:
        r3 = 2131371490;
    L87:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    }

    public final void p(CameraResultViewModel r4, EduResultMode r5) {
        r4.changeEduIntent(r5.toEduIntentMode());
        m r0 = this.m;
        int r1 = 0;
        if (r0 == null) goto L5;
        r0.a(r5.getClipViewMode(), false);
    L5:
        m r2 = this.m;
        if (r2 == null) goto L8;
        r1 = r2.l();
    L8:
        r4.reportClipItemsIfNeeded(r5, r1);
        m r6 = this.m;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r5 != EduResultMode.HOMEWORK_CORRECTION) goto L13;
        SceneType r7 = SceneType.Doubao_Education_Camera_Homework_Correction;
    L14:
        r6.n(r7);
        return;
    L13:
        r7 = SceneType.Doubao_Education_Camera_Qa;
        goto L14
    }

    public final void q(CameraResultViewModel r3, boolean r4) {
        if (r4 == false) goto L4;
        EduResultMode r0 = EduResultMode.MULTI_QUESTION;
    L5:
        r3.changeEduIntent(r0.toEduIntentMode());
        m r5 = this.m;
        if (r5 == null) goto L11;
        if (r4 == false) goto L9;
        nx8.c r1 = nx8.c.b.a;
    L10:
        r5.a(r1, false);
        goto L11
    L9:
        r1 = nx8.c.C0123c.a;
    L11:
        LarusLayoutViewEduPreviewComponentBinding r6 = this.n;
        if (r6 == null) goto L20;
        TextView r7 = r6.f;
        if (r7 == null) goto L21;
        if (r4 == false) goto L17;
        String r8 = getContext().getString(2131900547);
    L18:
        r7.setText(r8);
        return;
    L17:
        r8 = getContext().getString(2131900546);
        goto L18
    L21:
        return;
    L20:
        return;
    L4:
        r0 = EduResultMode.SINGLE_QUESTION;
        goto L5
    }
}
