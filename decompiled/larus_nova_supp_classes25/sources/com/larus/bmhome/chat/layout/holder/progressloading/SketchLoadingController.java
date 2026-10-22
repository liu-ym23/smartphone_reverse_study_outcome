package com.larus.bmhome.chat.layout.holder.progressloading;

import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.chat.common.databinding.LarusSketchProgressLoadingBinding;
import com.larus.common_ui.view.b0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SketchLoadingController implements ISketchLoadingController {
    public final ViewStub a;
    public final Lazy b;
    public b c;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final ImageLoadingDrawPartType b;
        public final int c;

        public b(boolean r1, ImageLoadingDrawPartType r2) {
            this.a = r1;
            this.b = r2;
            this.c = 1;
        }
    }

    static {
    }

    public final b0<LarusSketchProgressLoadingBinding> d() {
        return (b0) this.b.getValue();
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void hide() {
        FLogger.a.i("SketchLoadingController", "hide " + hashCode());
        d().a();
        this.c = null;
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final Boolean isVisible() {
        LarusSketchProgressLoadingBinding r0 = d().c;
        if (r0 == null) goto L11;
        MaterialCardView r1 = r0.a;
        if (r1 == null) goto L11;
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L13:
        return Boolean.valueOf(r2);
    L9:
        r2 = false;
    L11:
        return null;
    }

    public SketchLoadingController(ViewStub r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new i(this));
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        LarusSketchProgressLoadingBinding r0 = d().c;
        if (r0 == null) goto L8;
        TextView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void setProgress(int r3) {
        LarusSketchProgressLoadingBinding r0 = d().c;
        if (r0 == null) goto L13;
        TextView r1 = r0.c;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L15;
        StringBuilder r4 = new StringBuilder();
        r4.append(r3);
        r4.append('%');
        r1.setText(r4.toString());
        return;
    L15:
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void a(String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        LarusSketchProgressLoadingBinding r6 = d().c;
        if (r6 == null) goto L21;
        TextView r7 = r6.b;
        if (r7 == null) goto L22;
        e1.o(r7);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        LarusSketchProgressLoadingBinding r1 = d().c;
        if (r1 == null) goto L24;
        TextView r2 = r1.b;
        if (r2 == null) goto L25;
        e1.x(r2);
        r2.setText(r3);
        r2.setTextSize(0, r4);
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        if (r8 == null) goto L20;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r9.topMargin = r5;
        r2.setLayoutParams(r9);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController
    public final void b(boolean r6, ImageLoadingDrawPartType r7, int r8) {
        b r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L30;
        LarusSketchProgressLoadingBinding r3 = d().c;
        if (r3 == null) goto L27;
        MaterialCardView r4 = r3.a;
        if (r4 == null) goto L27;
        if (r4.getVisibility() != 0) goto L24;
        boolean r5 = true;
    L25:
        if (r5 != true) goto L27;
        r1 = true;
        goto L27
    L24:
        r5 = false;
    L27:
        if (r1 == false) goto L30;
        FLogger.a.i("SketchLoadingController", "show() return because viewData not change");
        return;
    L30:
        FLogger.a.i("SketchLoadingController", " show " + hashCode());
        this.c = new b(r6, r7);
        d().b();
        LarusSketchProgressLoadingBinding r9 = d().c;
        if (r9 == null) goto L39;
        LottieAdapterView r10 = r9.e;
        if (r10 == null) goto L39;
        r10.setRepeatMode(1);
        r10.setRepeatCount(-1);
        if (r8 != 2) goto L37;
        String r11 = "lottie/ai_video_loading.json";
    L38:
        r10.setAnimation(r11);
        r10.playAnimation();
        goto L39
    L37:
        r11 = "lottie/ai_img_loading.json";
    L39:
        e r12 = GenImgLoadingResourceGetter.a();
        LarusSketchProgressLoadingBinding r13 = d().c;
        if (r13 == null) goto L45;
        ImageWebpLoadingBgView r14 = r13.d;
        if (r14 == null) goto L46;
        r14.f(r12, r6, r7, "gen_image_loading_bg");
        return;
    L46:
        return;
    L45:
        return;
    L5:
        if (r0.a == r6) goto L7;
    L11:
        boolean r15 = false;
    L12:
        if (r15 != true) goto L14;
        r2 = true;
        goto L16
    L7:
        if (r0.b != r7) goto L11;
        if (r0.c != r8) goto L11;
        r15 = true;
        goto L12
    }

    public static void e(SketchLoadingController r2, float r3, float r4, float r5, float r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = 0.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0.0f;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0.0f;
    L14:
        LarusSketchProgressLoadingBinding r8 = r2.d().c;
        if (r8 == null) goto L20;
        RadiusCardView r9 = r8.a;
        if (r9 == null) goto L21;
        r9.a(r3, r4, r5, r6);
        return;
    L21:
        return;
    }
}
