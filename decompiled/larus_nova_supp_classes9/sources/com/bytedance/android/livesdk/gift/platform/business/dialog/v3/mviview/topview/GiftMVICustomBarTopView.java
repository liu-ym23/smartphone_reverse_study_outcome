package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCustomBuyView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCustomGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CustomData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftCustomBarViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenCustomBuyPage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICustomBarTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftCustomBarViewState, GiftAction> {
    public ImageView m;
    public HSImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public TextView s;
    public View t;
    public final Lazy u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftMVICustomBarTopView a;

        public a(GiftMVICustomBarTopView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == true) goto L6;
            ToastUtil.a(2131916122, 0);
            return;
        L6:
            this.a.o(new ClickCustomBuyView());
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ GiftMVICustomBarTopView a;

        public b(GiftMVICustomBarTopView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.o(new ClickCustomGiftIcon());
        }
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131565348;
    }

    public final void g() {
        this.m = (ImageView) r().findViewById(2131368400);
        this.n = r().findViewById(2131368399);
        this.o = (TextView) r().findViewById(2131368390);
        this.p = (TextView) r().findViewById(2131368404);
        this.q = (TextView) r().findViewById(2131368406);
        this.r = r().findViewById(2131368401);
        this.s = (TextView) r().findViewById(2131368389);
        this.t = r().findViewById(2131368405);
        TextView r0 = this.s;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(this));
    L5:
        View r1 = this.r;
        if (r1 == null) goto L9;
        r1.setOnClickListener(new b(this));
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVICustomBarTopView$bindToParent$1 r0 = GiftMVICustomBarTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof OpenCustomBuyPage) == false) goto L6;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(getContext(), ((OpenCustomBuyPage) r3).getSchemaUrl());
        return true;
    L6:
        return false;
    }

    public GiftMVICustomBarTopView(final Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.u = LazyKt.lazy(new GiftMVICustomBarTopView$lifecycleOwner$2(r2));
    }

    public final void b(com.bytedance.android.anya.k r18, MVIState r19) {
        GiftCustomBarViewState r2 = (GiftCustomBarViewState) r19;
        Intrinsics.checkNotNullParameter(r18, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r2, "state");
        r0<GiftCustomBarViewState, CustomData> r3 = r2.getCustomData();
        Object r4 = r18.c.a(r3);
        int r6 = 2131250295;
        if (r4 == null) goto L53;
        r18.b.a.invoke(r3);
        CustomData r5 = (CustomData) r4;
        q3 r7 = r5.getSubscribeGiftPackInfo();
        long r9 = r5.getLockStatus();
        String r8 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Long.valueOf(r7.getOfflineTimeSecond()));
        String r11 = getContext().getString(2131916123);
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        String r10 = String.format(r11, Arrays.copyOf(new Object[]{r8}, 1));
        TextView r14 = this.q;
        if (r14 == null) goto L8;
        r14.setText(r10);
    L8:
        if (r9 == k0.UNLOCKED) goto L25;
        TextView r15 = this.s;
        if (r15 == null) goto L12;
        r15.setText(getContext().getString(2131916110));
    L12:
        TextView r16 = this.s;
        if (r16 == null) goto L15;
        r16.setTextColor(getContext().getResources().getColor(2131107076));
    L15:
        TextView r17 = this.o;
        if (r17 == null) goto L18;
        r17.setVisibility(8);
    L18:
        ImageView r20 = this.m;
        if (r20 == null) goto L21;
        r20.setImageResource(2131250295);
    L21:
        View r21 = this.t;
        if (r21 == null) goto L53;
        r21.setVisibility(8);
        goto L53
    L25:
        if (r7.getLeftScores() <= 0) goto L35;
        ImageView r23 = this.m;
        if (r23 == null) goto L29;
        r23.setImageResource(2131250294);
    L29:
        TextView r24 = this.s;
        if (r24 == null) goto L32;
        r24.setText(getContext().getString(2131916111));
    L32:
        TextView r25 = this.s;
        if (r25 == null) goto L44;
        r25.setTextColor(getContext().getResources().getColor(2131107074));
    L44:
        TextView r26 = this.o;
        if (r26 == null) goto L47;
        r26.setVisibility(0);
    L47:
        TextView r27 = this.o;
        if (r27 == null) goto L50;
        r27.setText(String.valueOf(r7.getLeftScores()));
    L50:
        View r28 = this.t;
        if (r28 == null) goto L53;
        r28.setVisibility(0);
        goto L53
    L35:
        ImageView r29 = this.m;
        if (r29 == null) goto L38;
        r29.setImageResource(2131250295);
    L38:
        TextView r30 = this.s;
        if (r30 == null) goto L41;
        r30.setText(getContext().getString(2131916111));
    L41:
        TextView r31 = this.s;
        if (r31 == null) goto L44;
        r31.setTextColor(getContext().getResources().getColor(2131107076));
    L53:
        r0<GiftCustomBarViewState, py.k> r33 = r2.getGiftImage();
        Object r34 = r18.c.a(r33);
        if (r34 == null) goto L56;
        r18.b.a.invoke(r33);
        ImageUtil.loadImage(this.n, (py.k) r34, 0);
    L56:
        r0<GiftCustomBarViewState, String> r35 = r2.getGiftName();
        Object r36 = r18.c.a(r35);
        if (r36 == null) goto L64;
        r18.b.a.invoke(r35);
        String r37 = (String) r36;
        TextView r38 = this.p;
        if (r38 == null) goto L61;
        r38.setText(r37);
    L61:
        ArrayList r39 = new ArrayList();
        r39.add(Integer.valueOf(getContext().getResources().getColor(2131107077)));
        r39.add(Integer.valueOf(getContext().getResources().getColor(2131107080)));
        r39.add(Integer.valueOf(getContext().getResources().getColor(2131107073)));
        r39.add(Integer.valueOf(getContext().getResources().getColor(2131107075)));
        TextView r40 = this.p;
        if (r40 == null) goto L64;
        r40.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r40.getText().length() * r40.getPaint().getTextSize(), 0.0f, CollectionsKt.toIntArray(r39), null, Shader.TileMode.CLAMP));
        r40.invalidate();
    L64:
        r0<GiftCustomBarViewState, Boolean> r41 = r2.isSelected();
        Object r43 = r18.c.a(r41);
        if (r43 == null) goto L78;
        r18.b.a.invoke(r41);
        boolean r1 = ((Boolean) r43).booleanValue();
        ImageView r44 = this.m;
        if (r44 == null) goto L71;
        if (r1 == false) goto L70;
        r6 = 2131250294;
    L70:
        r44.setImageResource(r6);
    L71:
        View r45 = this.t;
        if (r45 == null) goto L79;
        if (r1 == false) goto L75;
        int r46 = 0;
    L76:
        r45.setVisibility(r46);
        return;
    L75:
        r46 = 8;
        goto L76
    L79:
        return;
    }
}
