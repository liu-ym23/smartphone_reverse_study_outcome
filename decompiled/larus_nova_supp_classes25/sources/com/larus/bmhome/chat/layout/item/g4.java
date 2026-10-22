package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.larus.bmhome.chat.layout.widget.ImageCoverEditView;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.chat.common.databinding.LarusLayoutImageNonComplianceBinding;
import com.larus.common_ui.widget.CircleProgressBarView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g4 extends i {
    public static final String x = null;
    public ImageCoverEditView p;
    public Pair<Integer, Integer> q;
    public final ImageViewWithLastMotion r;
    public boolean s;
    public boolean t;
    public final FrameLayout u;
    public final CircleProgressBarView v;
    public final LarusLayoutImageNonComplianceBinding w;

    public static final class a {
        public a() {
        }
    }

    static {
        x = "SendImgBox" + new a().hashCode();
    }

    public final ImageCoverEditView getAiImageCover() {
        return this.p;
    }

    public final boolean getAiImageCreationEnable() {
        return this.s;
    }

    public final Pair<Integer, Integer> getImageSize() {
        return this.q;
    }

    public final ImageViewWithLastMotion getImgView() {
        return this.r;
    }

    public final boolean getImmersiveStyle() {
        return this.t;
    }

    public final LarusLayoutImageNonComplianceBinding getNonComplianceBinding() {
        return this.w;
    }

    public g4(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        int r0 = r12.getResources().getDimensionPixelSize(v19.c.b(2130971546, r12, 2131167462));
        com.larus.bmhome.utils.q1.a.getClass();
        this.q = com.larus.bmhome.utils.q1.e(r12);
        DraweeView r1 = new ImageViewWithLastMotion(r12, null);
        GenericDraweeHierarchyBuilder r3 = GenericDraweeHierarchyBuilder.newInstance(r1.getContext().getResources());
        ImageCoverEditView r4 = this.p;
        if (r4 == null) goto L5;
        Context r5 = r4.getContext();
    L6:
        GenericDraweeHierarchyBuilder r6 = r3.setPlaceholderImage(v19.c.b(2130970533, r5, 2131102542)).setFailureImage(2131240764).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        RoundingParams r7 = new RoundingParams();
        float r2 = r0;
        r7.setCornersRadius(r2);
        r7.setBorder(ContextCompat.getColor(r12, v19.c.b(2130972086, r12, 2131103159)), r12.getResources().getDimensionPixelSize(v19.c.b(2130971137, r12, 2131166644)));
        Unit r8 = Unit.INSTANCE;
        r1.setHierarchy(r6.setRoundingParams(r7).build());
        this.r = r1;
        FrameLayout r9 = new FrameLayout(r12);
        r9.setBackgroundColor(ContextCompat.getColor(r12, v19.c.b(2130972089, r12, 2131103169)));
        this.u = r9;
        View r10 = new CircleProgressBarView(r12, null, 6, 0);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.v = r10;
        LarusLayoutImageNonComplianceBinding r11 = LarusLayoutImageNonComplianceBinding.a(LayoutInflater.from(r12), this);
        this.w = r11;
        CardView r13 = new CardView(r12);
        r13.setId(2131365599);
        r13.setRadius(r2);
        r13.setCardElevation(0.0f);
        r13.setMaxCardElevation(0.0f);
        r13.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        r13.addView(r9, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
        r14.gravity = 17;
        r13.addView(r10, r14);
        r13.addView(r11.a, new FrameLayout.LayoutParams(-2, -2));
        addView(r13, new LinearLayout.LayoutParams(-2, -2));
        FrameLayout r15 = new FrameLayout(r12);
        ImageCoverEditView r16 = new ImageCoverEditView(r12, null, 6, 0);
        this.p = r16;
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 85;
        r17.bottomMargin = c7.b(4);
        r17.rightMargin = c7.b(4);
        r15.addView(r16, r17);
        r13.addView(r15, new LinearLayout.LayoutParams(-2, -2));
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setAiImageCover(ImageCoverEditView r1) {
        this.p = r1;
    }

    public final void setAiImageCreationEnable(boolean r1) {
        this.s = r1;
    }

    public final void setImageSize(Pair<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    public final void setImmersiveStyle(boolean r1) {
        this.t = r1;
    }

    public final void setProcess(long r2) {
        this.v.setProgress(r2);
    }

    public final void m(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        if (r2 == false) goto L7;
        com.larus.utils.e1.x(this.w.a);
        this.w.b.setText(r3);
        com.larus.utils.e1.o(this.r);
        ImageCoverEditView r4 = this.p;
        if (r4 == null) goto L15;
        com.larus.utils.e1.o(r4);
        return;
    L15:
        return;
    L7:
        com.larus.utils.e1.o(this.w.a);
        com.larus.utils.e1.x(this.r);
        ImageCoverEditView r5 = this.p;
        if (r5 != null) goto L10;
        return;
    L10:
        if (this.s == false) goto L12;
        int r6 = 0;
    L13:
        r5.setVisibility(r6);
        return;
    L12:
        r6 = 8;
        goto L13
    }
}
