package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j extends RecyclerView.ViewHolder implements com.obric.assistant.omnidetailpage.localmedia.y {
    public static final /* synthetic */ int q = 0;
    public final Context a;
    public final com.obric.assistant.omnidetailpage.localmedia.w b;
    public final Object c;
    public final CoroutineScope d;
    public final SimpleDraweeView e;
    public final VideoPlayView f;
    public final SimpleDraweeView g;
    public final ImageView h;
    public final ImageView i;
    public ifa.c j;
    public ifa.c.b k;
    public IVideoController l;
    public Job m;
    public boolean n;
    public boolean o;
    public boolean p;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void R3() {
        if (this.k == null) goto L5;
        this.g.setVisibility(0);
    L5:
        VideoPlayView.z(this.f, 0, 2);
        this.n = false;
    }

    public final void T3() {
        IVideoController r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        IVideoController r3 = null;
        IVideoController r2 = q3.b("OmniDetailLocalVideo", null, 6);
        if (r2 == null) goto L13;
        com.larus.video.impl.sdk.o r4 = (com.larus.video.impl.sdk.o) r2;
        r4.I(true);
        r4.C(true);
        r3 = r2;
    L13:
        this.l = r3;
        return;
    L5:
        if (r0.isReleased() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void i3() {
        Job r0 = this.m;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.m = null;
        this.f.N();
        this.f.setVideoEngineCallback(null);
        IVideoController r1 = this.l;
        if (r1 != null) goto L14;
    L12:
        this.l = null;
        this.k = null;
        this.j = null;
        this.n = false;
        this.o = false;
        this.p = false;
        this.g.setVisibility(0);
        return;
    L14:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        r1.stop();     // Catch: Throwable -> L9
        r1.release();     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Result.box-impl(r3);
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final void r0() {
        if (this.k != null) goto L5;
        return;
    L5:
        T3();
        this.f.setIsMuted(true);
        if (this.k == null) goto L9;
        this.g.setVisibility(0);
    L9:
        if (this.o == false) goto L19;
        IVideoController r0 = this.l;
        if (r0 == null) goto L13;
        IVideoController.PlayType r1 = r0.d();
    L15:
        if (r1 != IVideoController.PlayType.PAUSE) goto L19;
        VideoPlayView.H(this.f, 0, 2);
        if (this.p == false) goto L21;
        this.g.post(new d(this));
        return;
    L21:
        return;
    L13:
        r1 = null;
    L19:
        this.f.M();
    }

    @Override // com.obric.assistant.omnidetailpage.localmedia.y
    public final View H0() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public static void U3(ImageView r3, String r4) {
        int r5 = r3.getContext().getResources().getIdentifier(r4, "drawable", r3.getContext().getPackageName());
        if (r5 == 0) goto L5;
        r3.setImageResource(r5);
        return;
    L5:
        int r6 = ColorProtector.parseColor("#99000000");
        float r0 = i5.h();
        GradientDrawable r1 = new GradientDrawable();
        r1.setColor(r6);
        r1.setCornerRadius(r0);
        r3.setBackground(r1);
    }

    public j(Context r6, com.obric.assistant.omnidetailpage.localmedia.w r7, Object r8, CoroutineScope r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "autoPlayManager");
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r9, "scope");
        FrameLayout r0 = new FrameLayout(r6);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        int r2 = ColorProtector.parseColor("#F5F6F7");
        float r3 = i5.r0();
        GradientDrawable r4 = new GradientDrawable();
        r4.setColor(r2);
        r4.setCornerRadius(r3);
        r0.setBackground(r4);
        r0.setClipToOutline(true);
        super(r0);
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        View r10 = new SimpleDraweeView(r6);
        r10.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        this.e = r10;
        VideoPlayView r11 = new VideoPlayView(r6, null, 6, 0);
        r11.setIsMuted(true);
        r11.setShowCoverWhenPause(false);
        r11.setBanInnerDismiss(true);
        r11.setIgnoreClick(true);
        r11.setEnableCreationPreviewCoverLoadOpt(true);
        r11.setForceRefreshSurface(true);
        this.f = r11;
        SimpleDraweeView r12 = new SimpleDraweeView(r6);
        r12.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        int r1 = ColorProtector.parseColor("#F5F6F7");
        float r5 = i5.r0();
        GradientDrawable r13 = new GradientDrawable();
        r13.setColor(r1);
        r13.setCornerRadius(r5);
        r12.setBackground(r13);
        this.g = r12;
        ImageView r14 = new ImageView(r6);
        r14.setScaleType(ImageView.ScaleType.CENTER);
        U3(r14, "larus_action_button_icon");
        this.h = r14;
        ImageView r15 = new ImageView(r6);
        U3(r15, "larus_ic_download_white_shadow");
        int r16 = r15.getContext().getResources().getIdentifier("larus_bg_gray_btn_radius_8", "drawable", r15.getContext().getPackageName());
        if (r16 == 0) goto L5;
        r15.setBackgroundResource(r16);
    L6:
        this.i = r15;
        View r17 = ((RecyclerView.ViewHolder) this).itemView;
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r18 = (FrameLayout) r17;
        r18.addView(r10, new FrameLayout.LayoutParams(-1, -1));
        r18.addView(r11, new FrameLayout.LayoutParams(-1, -1));
        r18.addView(r12, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(i5.O(), i5.O(), 8388661);
        r19.topMargin = i5.h();
        r19.setMarginEnd(i5.h());
        Unit r20 = Unit.INSTANCE;
        r18.addView(r14, r19);
        FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(i5.O(), i5.O(), 8388691);
        r21.leftMargin = i5.r0();
        r21.bottomMargin = i5.r0();
        r18.addView(r15, r21);
        r14.setOnClickListener(new e(this));
        r15.setOnClickListener(new f(this));
        r11.setOnClickListener(new g(this));
        return;
    L5:
        int r22 = ColorProtector.parseColor("#99000000");
        float r23 = i5.r0();
        GradientDrawable r24 = new GradientDrawable();
        r24.setColor(r22);
        r24.setCornerRadius(r23);
        r15.setBackground(r24);
        goto L6
    }
}
