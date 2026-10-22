package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickActivityBtn;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopActivityState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PageProgressBarData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIActivityTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopActivityState, GiftAction> {
    public TextView m;
    public TextView n;
    public HSImageView o;
    public TextView p;
    public HSImageView q;
    public HSImageView r;
    public ProgressBar s;
    public String t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftMVIActivityTopView a;

        public a(GiftMVIActivityTopView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            GiftMVIActivityTopView r4 = this.a;
            r4.o(new ClickActivityBtn(r4.t));
        }
    }

    public final void g() {
        this.p = (TextView) r().findViewById(2131387550);
        this.n = (TextView) r().findViewById(2131388920);
        this.o = r().findViewById(2131388879);
        this.m = (TextView) r().findViewById(2131368885);
        this.q = r().findViewById(2131363812);
        TextView r0 = this.m;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(this));
    L5:
        this.r = r().findViewById(2131377776);
        this.s = (ProgressBar) r().findViewById(2131383297);
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L6;
        return 2131566114;
    L6:
        return 2131566113;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIActivityTopView$bindToParent$1 r0 = GiftMVIActivityTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r8, MVIState r9) {
        GiftTopActivityState r10 = (GiftTopActivityState) r9;
        Intrinsics.checkNotNullParameter(r8, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        r0<GiftTopActivityState, String> r0 = r10.getTitle();
        Object r1 = r8.c.a(r0);
        if (r1 == null) goto L13;
        r8.b.a.invoke(r0);
        String r2 = (String) r1;
        HSImageView r3 = this.o;
        if (r3 == null) goto L7;
        UtilityKotlinExtentionsKt.u(r3);
    L7:
        TextView r4 = this.n;
        if (r4 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r4);
    L10:
        TextView r5 = this.n;
        if (r5 == null) goto L13;
        r5.setText(r2);
    L13:
        r0<GiftTopActivityState, String> r6 = r10.getText();
        Object r7 = r8.c.a(r6);
        if (r7 == null) goto L18;
        r8.b.a.invoke(r6);
        String r11 = (String) r7;
        TextView r13 = this.p;
        if (r13 == null) goto L18;
        r13.setText(r11);
    L18:
        r0<GiftTopActivityState, String> r14 = r10.getButtonText();
        Object r15 = r8.c.a(r14);
        if (r15 == null) goto L23;
        r8.b.a.invoke(r14);
        String r16 = (String) r15;
        TextView r17 = this.m;
        if (r17 == null) goto L23;
        r17.setText(r16);
    L23:
        r0<GiftTopActivityState, py.k> r18 = r10.getTitleImg();
        Object r19 = r8.c.a(r18);
        if (r19 == null) goto L34;
        r8.b.a.invoke(r18);
        py.k r20 = (py.k) r19;
        if ((!Intrinsics.areEqual(r20, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L34;
        TextView r21 = this.n;
        if (r21 == null) goto L30;
        UtilityKotlinExtentionsKt.u(r21);
    L30:
        HSImageView r23 = this.o;
        if (r23 == null) goto L33;
        UtilityKotlinExtentionsKt.w(r23);
    L33:
        ImageLoader.bindImage(this.o, r20, (int) com.bytedance.android.live.revenue.common.i.a(15), (int) com.bytedance.android.live.revenue.common.i.a(91), new b(this));
    L34:
        r0<GiftTopActivityState, py.k> r24 = r10.getBackgroundImg();
        Object r25 = r8.c.a(r24);
        Drawable r26 = null;
        if (r25 == null) goto L47;
        r8.b.a.invoke(r24);
        py.k r27 = (py.k) r25;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L39;
        return;
    L39:
        if (this.q != null) goto L42;
        return;
    L42:
        if ((!Intrinsics.areEqual(r27, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L44;
        ImageLoader.bindImage(this.q, r27);
        goto L47
    L44:
        HSImageView r28 = this.q;
        if (r28 == null) goto L47;
        r28.setController(null);
        r28.setBackground(s1.m(2131248751));
    L47:
        r0<GiftTopActivityState, py.k> r29 = r10.getIconImage();
        Object r30 = r8.c.a(r29);
        int r31 = 0;
        if (r30 == null) goto L62;
        r8.b.a.invoke(r29);
        py.k r33 = (py.k) r30;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L62;
        if (this.r == null) goto L62;
        if ((!Intrinsics.areEqual(r33, GiftTopActivityState.Companion.getDefaultImg())) == false) goto L59;
        HSImageView r34 = this.r;
        if (r34 == null) goto L58;
        r34.setVisibility(0);
    L58:
        float r35 = 32;
        ImageLoader.bindImage(this.r, r33, (int) com.bytedance.android.live.revenue.common.i.a(r35), (int) com.bytedance.android.live.revenue.common.i.a(r35));
        goto L62
    L59:
        HSImageView r36 = this.r;
        if (r36 == null) goto L62;
        r36.setVisibility(8);
    L62:
        r0<GiftTopActivityState, String> r37 = r10.getCurrentPageName();
        Object r38 = r8.c.a(r37);
        if (r38 == null) goto L65;
        r8.b.a.invoke(r37);
        this.t = (String) r38;
    L65:
        r0<GiftTopActivityState, PageProgressBarData> r39 = r10.getProgressBarData();
        Object r40 = r8.c.a(r39);
        if (r40 == null) goto L100;
        r8.b.a.invoke(r39);
        PageProgressBarData r41 = (PageProgressBarData) r40;
        ProgressBar r43 = this.s;
        if (r43 != null) goto L70;
        return;
    L70:
        if (r41.getShow() == true) goto L73;
        r31 = 8;
    L73:
        r43.setVisibility(r31);
        r43.setProgress((int) (100 * r41.getPercentage()));
        int r44 = r41.getColor();
        ProgressBar r45 = this.s;
        if (r45 == null) goto L76;
        Drawable r46 = r45.getProgressDrawable();
    L78:
        if ((r46 instanceof LayerDrawable) == true) goto L80;
        r46 = null;
    L80:
        LayerDrawable r47 = (LayerDrawable) r46;
        if (r47 == null) goto L83;
        Drawable r48 = r47.findDrawableByLayerId(R.id.progress);
    L85:
        if ((r48 instanceof ScaleDrawable) == true) goto L87;
        r48 = null;
    L87:
        ScaleDrawable r49 = (ScaleDrawable) r48;
        if (r49 == null) goto L90;
        Drawable r50 = r49.getDrawable();
    L92:
        if ((r50 instanceof GradientDrawable) == false) goto L95;
        r26 = r50;
    L95:
        GradientDrawable r51 = (GradientDrawable) r26;
        if (r51 == null) goto L102;
        r51.setColor(r44);
        return;
    L102:
        return;
    L90:
        r50 = null;
        goto L92
    L83:
        r48 = null;
        goto L85
    L76:
        r46 = null;
        goto L78
    }

    public GiftMVIActivityTopView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.t = BuildConfig.FLAVOR;
    }
}
