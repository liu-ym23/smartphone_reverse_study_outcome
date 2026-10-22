package com.larus.camera.impl.ui.component.result.general;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.widget.title.TitleRightIconView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultTitleComponent extends com.larus.camera.impl.ui.base.k {
    public static final /* synthetic */ int s = 0;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    public static final class a {
    }

    public static final class b {
        public final Boolean a;
        public final boolean b;
        public final boolean c;
        public final n d;
        public final boolean e;

        public b() {
            Boolean r2 = null;
            this(r2, false, 31);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Boolean r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            int r3 = 1231;
            if (this.b == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r2 + r4) * 31;
            if (this.c == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (((r5 + r6) * 31) + this.d.hashCode()) * 31;
            if (this.e == true) goto L19;
            r3 = 1237;
        L19:
            return r7 + r3;
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "TitleRightIconParams(photoEditable=" + this.a + ", inCropMode=" + this.b + ", inFreeInputMode=" + this.c + ", detectResult=" + this.d + ", hasAIBeautyAccess=" + this.e + ')';
        }

        public /* synthetic */ b(Boolean r9, boolean r10, int r11) {
            n.b r1 = null;
            if ((r11 & 1) == 0) goto L5;
            Boolean r3 = null;
        L7:
            if ((r11 & 2) == 0) goto L9;
            boolean r4 = false;
        L11:
            if ((r11 & 8) == 0) goto L13;
            r1 = n.b.a;
        L13:
            this(r3, r4, false, r1, false);
            return;
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public b(Boolean r2, boolean r3, boolean r4, n r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "detectResult");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public static b a(b r7, boolean r8, n r9, boolean r10, int r11) {
            if ((r11 & 1) == 0) goto L5;
            Boolean r0 = r7.a;
        L6:
            Boolean r2 = r0;
            if ((r11 & 2) == 0) goto L9;
            boolean r3 = r7.b;
        L11:
            if ((r11 & 4) == 0) goto L13;
            r8 = r7.c;
        L13:
            boolean r4 = r8;
            if ((r11 & 8) == 0) goto L16;
            r9 = r7.d;
        L16:
            n r5 = r9;
            if ((r11 & 16) == 0) goto L19;
            r10 = r7.e;
        L19:
            r7.getClass();
            Intrinsics.checkNotNullParameter(r5, "detectResult");
            return new b(r2, r3, r4, r5, r10);
        L9:
            r3 = false;
            goto L11
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        final CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        p(new q0(r0));
        w(r0);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.isPhotoEditable(), new ResultTitleComponent$onViewCreated$2(this, r0, null)), k());
        CameraResultViewModel r1 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L8;
        StateFlowImpl r2 = kotlinx.coroutines.flow.j1.a(new ay8.a(false, false, 31));
    L9:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2, new ResultTitleComponent$onViewCreated$3(this, null)), k());
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r3 = com.larus.camera.impl.utils.eventbus.c.a;
        CoroutineScope r4 = k();
        final kotlinx.coroutines.flow.a1 r5 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r6 = new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$1(r5);
        kotlinx.coroutines.flow.g1.a.getClass();
        kotlinx.coroutines.flow.h1 r7 = kotlinx.coroutines.flow.g1.a.b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r6, r4, r7, 0), new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$2(null, this)), r4);
        CoroutineScope r8 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$3(r5), r8, r7, 0), new ResultTitleComponent$subscribeInputStatus$$inlined$subscribe$4(null, this)), r8);
        return;
    L8:
        FLogger.a.i("ResultTitleComponent", "[resultTitleRightIconStateFlow] combine");
        kotlinx.coroutines.flow.v0 r9 = new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(new kotlinx.coroutines.flow.v0(r1.isPhotoEditable(), r1.isInCropMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$1(null)), r1.getInFreeInputMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$2(null)), r1.getResultDetectionStatus(), new ResultTitleComponent$resultTitleRightIconStateFlow$3(null)), r1.getHasAccessToAIBeauty(), new ResultTitleComponent$resultTitleRightIconStateFlow$4(null)), r1.isInMarkSelectMode(), new ResultTitleComponent$resultTitleRightIconStateFlow$5(this, null));
        CoroutineScope r10 = k();
        kotlinx.coroutines.flow.g1.a.getClass();
        r2 = kotlinx.coroutines.flow.e.F(r9, r10, kotlinx.coroutines.flow.g1.a.b, y((Boolean) r1.isPhotoEditable().getValue(), ((Boolean) r1.isInCropMode().getValue()).booleanValue(), ((Boolean) r1.getInFreeInputMode().getValue()).booleanValue(), n.b.a, ((Boolean) r1.getHasAccessToAIBeauty().getValue()).booleanValue(), ((Boolean) r1.isInMarkSelectMode().getValue()).booleanValue()));
        goto L9
    }

    public ResultTitleComponent() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.camera.impl.ui.component.result.general.x0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.camera.impl.ui.component.result.general.y0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.camera.impl.ui.component.result.general.z0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.camera.impl.ui.component.result.general.b1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.camera.impl.ui.component.result.general.c1, java.lang.Object] */
    public final void w(final CameraResultViewModel r4) {
        if (r4.shouldUseUnifiedResultTopStyle() == true) goto L5;
        return;
    L5:
        ?? r0 = new x0();
        Intrinsics.checkNotNullParameter(r0, "config");
        r0.invoke(h(2131388772));
        ?? r1 = new y0();
        Intrinsics.checkNotNullParameter(r1, "config");
        r1.invoke(h(2131388836));
        ?? r2 = new z0();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(h(2131388872));
        p(new a1(this, r4));
        ?? r3 = new b1(r4);
        Intrinsics.checkNotNullParameter(r3, "config");
        r3.invoke(h(2131377814));
        ?? r5 = new c1();
        Intrinsics.checkNotNullParameter(r5, "config");
        r5.invoke(h(2131384590));
    }

    public static final void s(ResultTitleComponent r1, Function1 r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(r1.h(2131388649));
    }

    public static final void t(ResultTitleComponent r1, Function1 r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(r1.h(2131384117));
    }

    public static final void u(ResultTitleComponent r1, Function1 r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(r1.h(2131384118));
    }

    public static final void v(ResultTitleComponent r1, Function1 r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "config");
        r2.invoke(r1.h(2131391854));
    }

    public static void x(TitleRightIconView r3, CameraResultViewModel r4, int r5) {
        if (r4.shouldUseUnifiedResultTopStyle() == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        if (r6 != null) goto L8;
        r6 = new ViewGroup.LayoutParams(i5.c0(), i5.c0());
    L8:
        r6.width = i5.c0();
        r6.height = i5.c0();
        r3.setLayoutParams(r6);
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(1);
        r7.setColor(ColorProtector.parseColor("#664E4E4E"));
        r3.setBackground(r7);
        r3.setGravity(17);
        LinearLayout r0 = r3.a.a;
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r0.setGravity(17);
        r3.a.b.setVisibility(8);
        ImageView r8 = r3.a.c;
        r8.setLayoutParams(new LinearLayout.LayoutParams(r5, r5));
        r8.setPadding(0, 0, 0, 0);
        r3.setIcon(new w0());
    }

    public final ay8.a y(Boolean r16, boolean r17, boolean r18, n r19, boolean r20, boolean r21) {
        boolean r7 = false;
        if ((r19 instanceof n.a) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        CameraResultViewModel r9 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r9 != null) goto L11;
    L13:
        boolean r10 = false;
    L14:
        if (r9 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        FLogger.a.i("ResultTitleComponent", "[produceResultTitleRightIconState] isPhotoEditable:" + r16 + ", isInCropMode:" + r17 + ", inFreeInputMode:" + r18 + ", isEduIntent:" + r6 + ", hasAIBeautyAccess:" + r20 + " shouldHideEditControls:" + r10 + " markSelectModeEnabled:" + r11 + " inMarkSelectMode:" + r21);
        if (r16 != null) goto L22;
        boolean r12 = true;
    L23:
        if (r11 == false) goto L36;
        if (r21 == false) goto L36;
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == false) goto L30;
        if (r17 == true) goto L30;
        if (r10 == true) goto L30;
        boolean r0 = true;
    L31:
        if (r17 == false) goto L35;
        if (r10 == true) goto L35;
        r7 = true;
    L35:
        return new ay8.a(r0, r7, 22);
    L30:
        r0 = false;
    L36:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r5) == false) goto L41;
        if (r17 == true) goto L41;
        if (r10 == true) goto L41;
        boolean r13 = true;
    L43:
        if (Intrinsics.areEqual(r16, Boolean.FALSE) == true) goto L45;
        if (r17 == true) goto L45;
    L47:
        boolean r14 = false;
    L48:
        if (r12 == false) goto L50;
    L56:
        boolean r4 = false;
    L57:
        if (r12 == true) goto L61;
        if (r18 == false) goto L61;
        if (r17 == true) goto L61;
        boolean r2 = true;
    L62:
        if (r11 == false) goto L69;
        if (Intrinsics.areEqual(r16, r5) == false) goto L69;
        if (r17 == true) goto L69;
        if (r10 == true) goto L69;
        r7 = true;
    L69:
        return new ay8.a(r13, r4, r2, r14, r7);
    L61:
        r2 = false;
        goto L62
    L50:
        if (z2.a.enableTopBeautyButton() == false) goto L56;
        if (r20 == false) goto L56;
        if (r17 == true) goto L56;
        if (r6 == true) goto L56;
        if (r10 == true) goto L56;
        r4 = true;
    L45:
        if (r10 == true) goto L47;
        r14 = true;
    L41:
        r13 = false;
        goto L43
    L22:
        r12 = false;
        goto L23
    L16:
        if (r9.shouldUseMarkSelectMode() != true) goto L18;
        r11 = true;
        goto L19
    L11:
        if (r9.currentPreviewShouldHideEditControls() != true) goto L13;
        r10 = true;
        goto L14
    L5:
        if ((((n.a) r19).a instanceof ix8.d.b) == false) goto L7;
        r6 = true;
        goto L8
    }
}
