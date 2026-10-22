package com.larus.search.impl.global.view.aggregate.kmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.payload.MixedFeedPayload;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarView;
import com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.flow.common.utils.FlowTagBuilder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0014\u0010\"\u001a\u00020\u0019*\u00020\u00152\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0014\u0010$\u001a\u00020\u0006*\u00020\u00152\u0006\u0010%\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/search/impl/global/view/aggregate/kmp/KmpMixedFeedCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/search/impl/global/view/aggregate/kmp/KmpMixedFeedCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "avatarContainer", "Landroid/widget/FrameLayout;", "avatarView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "larkAvatarView", "Lcom/larus/extension/aggregate_search_ui/api/ILarkAvatarView;", "titleView", "Landroid/widget/TextView;", "tagContainer", "dateView", "previewView", "pinView", "Landroid/view/View;", "boundData", "Lcom/bytedance/flow/search/kmp/api/model/payload/MixedFeedPayload;", "onViewCreated", "", "view", "onBindView", "state", "position", "bindTag", "payload", "bindAvatar", "bindStyle", "updateSize", "size", "dp", "value", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpMixedFeedCell extends BaseSearchListCell<m> {
    public static final /* synthetic */ int k = 0;
    public final int a;
    public FrameLayout b;
    public SimpleDraweeView c;
    public ILarkAvatarView d;
    public TextView e;
    public FrameLayout f;
    public TextView g;
    public TextView h;
    public View i;
    public MixedFeedPayload j;

    public static final class a {
    }

    static {
    }

    public KmpMixedFeedCell() {
        this.a = 2131562652;
    }

    public final int getLayoutId() {
        return this.a;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        this.b = (FrameLayout) r6.findViewById(2131385540);
        this.c = r6.findViewById(2131375062);
        this.e = (TextView) r6.findViewById(2131388496);
        this.f = (FrameLayout) r6.findViewById(2131385542);
        this.g = (TextView) r6.findViewById(2131388494);
        this.h = (TextView) r6.findViewById(2131388495);
        this.i = r6.findViewById(2131385541);
        ILarkAvatarViewProvider r0 = (ILarkAvatarViewProvider) ServiceManager.get().getService(ILarkAvatarViewProvider.class);
        if (r0 == null) goto L19;
        FrameLayout r1 = this.b;
        FrameLayout r3 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r1 = null;
    L7:
        ILarkAvatarView r2 = r0.getView(r1.getContext());
        if (r2 == null) goto L19;
        this.d = r2;
        if ((r2 instanceof View) == false) goto L12;
        View r4 = (View) r2;
    L13:
        if (r4 == null) goto L19;
        r4.setVisibility(8);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout r5 = this.b;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
    L18:
        r3.addView(r4);
        goto L19
    L17:
        r3 = r5;
        goto L18
    L12:
        r4 = null;
    L19:
        r6.setOnClickListener(new k(this));
        r6.setOnLongClickListener(new l());
    }

    public final int b(View r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    public final void onBindView(View r8, ei9.f r9, int r10) {
        m r11 = (m) r9;
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r11, "state");
        MixedFeedPayload r12 = r11.a;
        this.j = r12;
        TextView r13 = this.e;
        View r1 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r13 = null;
    L5:
        r13.setText(r12.j);
        FrameLayout r14 = this.f;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tagContainer");
        r14 = null;
    L8:
        r14.removeAllViews();
        int r15 = o.a;
        FrameLayout r16 = this.f;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tagContainer");
        r16 = null;
    L11:
        Context r17 = r16.getContext();
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r12, "payload");
        if (r12.r == false) goto L14;
        View r18 = null;
    L15:
        FrameLayout r3 = this.f;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tagContainer");
        r3 = null;
    L19:
        if (r18 != null) goto L21;
        int r6 = 8;
    L22:
        r3.setVisibility(r6);
        if (r18 == null) goto L28;
        FrameLayout r4 = this.f;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("tagContainer");
        r4 = null;
    L27:
        r4.addView(r18);
    L28:
        TextView r19 = this.g;
        if (r19 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("dateView");
        r19 = null;
    L31:
        int r2 = b7.a;
        r19.setText(b7.a(r12.l));
        if (r12.r == false) goto L55;
        r8.setMinimumHeight(b(r8, 72));
        FrameLayout r110 = this.b;
        if (r110 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r110 = null;
    L36:
        int r20 = b(r8, 48);
        ViewGroup.LayoutParams r5 = r110.getLayoutParams();
        if (r5 != null) goto L40;
    L45:
        TextView r21 = this.e;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r21 = null;
    L48:
        r21.setTypeface(Typeface.DEFAULT, 0);
        TextView r22 = this.h;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("previewView");
        r22 = null;
    L51:
        r22.setText(r12.k);
        TextView r23 = this.h;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("previewView");
        r23 = null;
    L54:
        r23.setVisibility(0);
    L74:
        View r24 = this.i;
        if (r24 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("pinView");
        r24 = null;
    L78:
        if (r12.q == false) goto L80;
        int r111 = 0;
    L81:
        r24.setVisibility(r111);
        String r25 = r12.u;
        if (StringsKt.isBlank(r25) == false) goto L85;
        r25 = r12.t;
    L85:
        if (r12.r == false) goto L87;
    L104:
        View r26 = this.d;
        if ((r26 instanceof View) == false) goto L107;
        View r27 = r26;
    L108:
        if (r27 == null) goto L110;
        r27.setVisibility(8);
    L110:
        ILarkAvatarView r28 = this.d;
        if (r28 == null) goto L113;
        r28.clearDrawable();
    L113:
        ImageView r29 = this.c;
        if (r29 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r29 = null;
    L116:
        r29.setVisibility(0);
        DraweeView r30 = this.c;
        if (r30 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r30 = null;
    L119:
        GenericDraweeHierarchy r31 = r30.getHierarchy();
        DraweeView r112 = this.c;
        if (r112 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r112 = null;
    L122:
        RoundingParams r113 = r112.getHierarchy().getRoundingParams();
        if (r113 != null) goto L125;
        r113 = new RoundingParams();
    L125:
        r31.setRoundingParams(r113.setRoundAsCircle(!r12.p));
        if ((!StringsKt.isBlank(r12.i)) == false) goto L132;
        View r32 = this.c;
        if (r32 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
    L131:
        ImageLoaderKt.s(r1, UriProtector.parse(r12.i), "aggregate_search_mixed_feed");
        return;
    L130:
        r1 = r32;
        goto L131
    L132:
        SimpleDraweeView r33 = this.c;
        if (r33 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r33 = null;
    L135:
        ImageLoaderKt.e(r33);
        Uri r34 = new Uri.Builder().scheme("res").path(String.valueOf(2131240119)).build();
        View r35 = this.c;
        if (r35 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
    L139:
        ImageLoaderKt.s(r1, r34, "aggregate_search_mixed_feed");
        return;
    L138:
        r1 = r35;
        goto L139
    L107:
        r27 = null;
        goto L108
    L87:
        if ((!StringsKt.isBlank(r12.s)) == false) goto L104;
        if ((!StringsKt.isBlank(r25)) == false) goto L104;
        ImageView r114 = this.c;
        if (r114 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r114 = null;
    L93:
        r114.setVisibility(8);
        SimpleDraweeView r115 = this.c;
        if (r115 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        r115 = null;
    L96:
        ImageLoaderKt.e(r115);
        View r116 = this.d;
        if ((r116 instanceof View) == false) goto L99;
        r1 = r116;
    L99:
        if (r1 == null) goto L101;
        r1.setVisibility(0);
    L101:
        ILarkAvatarView r117 = this.d;
        if (r117 == null) goto L141;
        r117.bind(r12.s, r25);
        return;
    L141:
        return;
    L80:
        r111 = 8;
        goto L81
    L40:
        if (r5.width == r20) goto L42;
    L44:
        r5.width = r20;
        r5.height = r20;
        r110.setLayoutParams(r5);
        goto L45
    L42:
        if (r5.height != r20) goto L44;
    L55:
        r8.setMinimumHeight(b(r8, 40));
        FrameLayout r118 = this.b;
        if (r118 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        r118 = null;
    L58:
        int r36 = b(r8, 28);
        ViewGroup.LayoutParams r7 = r118.getLayoutParams();
        if (r7 != null) goto L62;
    L67:
        TextView r37 = this.e;
        if (r37 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r37 = null;
    L70:
        r37.setTypeface(Typeface.DEFAULT, 0);
        TextView r38 = this.h;
        if (r38 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("previewView");
        r38 = null;
    L73:
        r38.setVisibility(8);
        goto L74
    L62:
        if (r7.width == r36) goto L64;
    L66:
        r7.width = r36;
        r7.height = r36;
        r118.setLayoutParams(r7);
        goto L67
    L64:
        if (r7.height != r36) goto L66;
    L21:
        r6 = 0;
        goto L22
    L14:
        FlowTagBuilder r39 = new FlowTagBuilder(r17);
        r39.c = r12.v;
        r39.d = r12.w;
        r39.e = r12.x;
        r39.f = r12.y;
        r39.g = r12.z;
        r39.h = r12.A;
        r39.i = r12.B;
        r39.j = r12.C;
        r18 = r39.b();
        goto L15
    }
}
