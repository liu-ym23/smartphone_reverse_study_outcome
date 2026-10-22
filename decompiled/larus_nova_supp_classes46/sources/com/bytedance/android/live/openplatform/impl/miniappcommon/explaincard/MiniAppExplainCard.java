package com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageLoader;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.vc1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/MiniAppExplainCard;", "Lcom/bytedance/android/livesdk/widget/roundcorner/RoundCornerFrameLayout;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/a;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/b;", "", "cardTitle", "", "setTitle", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "setIcon", "name", "setName", "url", "setCover", "text", "setBtn", "setTopIcon", "info", "setData", "Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/a;", "supplementInfo", "setSupplementInfo", "Lkotlin/Function0;", "n", "Lkotlin/jvm/functions/Function0;", "getOnClickBlock", "()Lkotlin/jvm/functions/Function0;", "setOnClickBlock", "(Lkotlin/jvm/functions/Function0;)V", "onClickBlock", "o", "getOnBtnClickBlock", "setOnBtnClickBlock", "onBtnClickBlock", "p", "getOnCloseBlock", "setOnCloseBlock", "onCloseBlock", "Landroid/view/View;", "getExplainCardView", "()Landroid/view/View;", "explainCardView", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppExplainCard extends RoundCornerFrameLayout implements com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<b> {
    public final View b;
    public final SimpleDraweeView c;
    public final View d;
    public final SimpleDraweeView e;
    public final SimpleDraweeView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final CardAvatarsLayout j;
    public final TextView k;
    public final NormalCardBtn l;
    public b m;
    public Function0<Unit> n;
    public Function0<Unit> o;
    public Function0<Unit> p;

    public static final class a implements Runnable {
        public final /* synthetic */ MiniAppExplainCard a;
        public final /* synthetic */ b b;

        public a(MiniAppExplainCard r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MiniAppExplainCard.a(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MiniAppExplainCard(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 0, 14);
    }

    public MiniAppExplainCard(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public MiniAppExplainCard(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public View getExplainCardView() {
        return this;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnBtnClickBlock() {
        return this.o;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnClickBlock() {
        return this.n;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnCloseBlock() {
        return this.p;
    }

    private final void setBtn(String r2) {
        NormalCardBtn r0 = this.l;
        if (r0 == null) goto L6;
        r0.setInfo(r2);
        return;
    }

    private final void setCover(String r10) {
        ImageLoader.a.b(this.e, r10, new mo0.b(ImageTag.EXPLAIN_CARD_COVER, null, false, false, 30));
    }

    private final void setIcon(ImageModel r6) {
        String r1 = null;
        boolean r2 = false;
        if (((vc1) d90.a.getValue()).a() != 1) goto L19;
        if (r6 == null) goto L9;
        List r7 = r6.getUrls();
        if (r7 == null) goto L9;
        r1 = (String) ListProtector.get(r7, 0);
    L9:
        if (r2.a(r1) == false) goto L16;
        SimpleDraweeView r8 = this.f;
        if (r8 == null) goto L13;
        r8.setVisibility(0);
    L13:
        SimpleDraweeView r9 = this.f;
        if (r9 == null) goto L51;
        r9.setImageURI(r1);
        return;
    L51:
        return;
    L16:
        SimpleDraweeView r10 = this.f;
        if (r10 == null) goto L53;
        r10.setVisibility(8);
        return;
    L53:
        return;
    L19:
        SimpleDraweeView r0 = this.f;
        if (r0 == null) goto L33;
        if (r6 == null) goto L25;
        List r4 = r6.getUrls();
        if (r4 == null) goto L25;
        String r5 = (String) ListProtector.get(r4, 0);
    L26:
        if (r5 != null) goto L28;
    L31:
        boolean r11 = true;
    L32:
        m.e(r0, Boolean.valueOf(!r11));
        goto L33
    L28:
        if (StringsKt.isBlank(r5) == true) goto L31;
        r11 = false;
    L25:
        r5 = null;
    L33:
        SimpleDraweeView r3 = this.f;
        if (r3 == null) goto L55;
        if (r6 == null) goto L39;
        List r12 = r6.getUrls();
        if (r12 == null) goto L39;
        r1 = (String) ListProtector.get(r12, 0);
    L39:
        Float r13 = Float.valueOf(UtilityKotlinExtentionsKt.h(2));
        Intrinsics.checkNotNullParameter(r3, "$this$loadRadiusUrl");
        if (r1 != null) goto L42;
    L43:
        r2 = true;
    L44:
        if (r2 == false) goto L46;
        r3.setImageResource(2131109391);
        return;
    L46:
        GenericDraweeHierarchyBuilder r14 = new GenericDraweeHierarchyBuilder(r3.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).setActualImageFocusPoint(new PointF(0.0f, 0.0f));
        if (r13 == null) goto L49;
        r14.setRoundingParams(RoundingParams.fromCornersRadius(r13.floatValue()));
    L49:
        Unit r15 = Unit.INSTANCE;
        r3.setHierarchy(r14.build());
        r3.setImageURI(r1);
        return;
    L42:
        if (r1.length() != 0) goto L44;
    }

    private final void setName(String r4) {
        TextView r0 = this.g;
        if (r0 != null) goto L5;
    L12:
        TextView r1 = this.g;
        if (r1 == null) goto L16;
        r1.setText(r4);
        return;
    L16:
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        m.e(r0, Boolean.valueOf(true ^ r2));
        goto L12
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r2 = false;
        goto L11
    }

    private final void setTitle(String r2) {
        TextView r0 = this.h;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    private final void setTopIcon(String r4) {
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L6;
        m.b(r0, r4, null, null, 126);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: setData, reason: avoid collision after fix types in other method */
    public void setData2(b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        post(new a(this, r2));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnBtnClickBlock(Function0<Unit> r1) {
        this.o = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnClickBlock(Function0<Unit> r1) {
        this.n = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnCloseBlock(Function0<Unit> r1) {
        this.p = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r4) {
        boolean r0 = true;
        if (r4 != null) goto L24;
        View r5 = this.i;
        if (r5 == null) goto L7;
        UtilityKotlinExtentionsKt.t(r5);
    L7:
        CardAvatarsLayout r6 = this.j;
        if (r6 == null) goto L10;
        r6.removeAllViews();
    L10:
        TextView r7 = this.k;
        if (r7 == null) goto L13;
        r7.setText("");
    L13:
        d90 r8 = d90.a;
        if (((vc1) r8.getValue()).a() == 1) goto L16;
        return;
    L16:
        if (((vc1) r8.getValue()).c() != 1) goto L20;
        TextView r9 = this.h;
        if (r9 == null) goto L76;
        UtilityKotlinExtentionsKt.w(r9);
        return;
    L76:
        return;
    L20:
        TextView r10 = this.h;
        if (r10 == null) goto L78;
        r10.setMaxLines(2);
        return;
    L78:
        return;
    L24:
        d90 r1 = d90.a;
        if (((vc1) r1.getValue()).a() != 0) goto L30;
        View r2 = this.i;
        if (r2 == null) goto L55;
        UtilityKotlinExtentionsKt.w(r2);
    L55:
        List r3 = r4.avatars;
        if (r3 != null) goto L58;
    L61:
        if (r0 == false) goto L65;
        CardAvatarsLayout r11 = this.j;
        if (r11 == null) goto L71;
        UtilityKotlinExtentionsKt.t(r11);
    L71:
        TextView r12 = this.k;
        if (r12 == null) goto L80;
        r12.setText(r4.context);
        return;
    L80:
        return;
    L65:
        CardAvatarsLayout r13 = this.j;
        if (r13 == null) goto L68;
        UtilityKotlinExtentionsKt.w(r13);
    L68:
        CardAvatarsLayout r14 = this.j;
        if (r14 == null) goto L71;
        r14.a(r4.avatars);
        goto L71
    L58:
        if (r3.isEmpty() == true) goto L61;
        r0 = false;
        goto L61
    L30:
        if (((vc1) r1.getValue()).c() != 1) goto L49;
        b r15 = this.m;
        if (r15 != null) goto L34;
    L42:
        TextView r16 = this.h;
        if (r16 == null) goto L45;
        UtilityKotlinExtentionsKt.w(r16);
    L45:
        View r17 = this.i;
        if (r17 == null) goto L79;
        UtilityKotlinExtentionsKt.t(r17);
        return;
    L79:
        return;
    L34:
        if (r15.b != 1) goto L42;
        TextView r18 = this.h;
        if (r18 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r18);
    L39:
        View r19 = this.i;
        if (r19 == null) goto L55;
        UtilityKotlinExtentionsKt.w(r19);
        goto L55
    L49:
        TextView r20 = this.h;
        if (r20 == null) goto L52;
        r20.setMaxLines(1);
    L52:
        View r21 = this.i;
        if (r21 == null) goto L55;
        UtilityKotlinExtentionsKt.w(r21);
        goto L55
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public /* bridge */ /* synthetic */ void setData(b r1) {
        setData2(r1);
    }

    public static final void a(final MiniAppExplainCard r4, b r5) {
        b r0 = r4.m;
        if (r0 != null) goto L6;
        r4.setBtn(r5.g);
        r4.setCover(r5.d);
        r4.setIcon(r5.e);
        r4.setName(r5.f);
        r4.setTitle(r5.c);
        r4.setTopIcon(r5.h);
    L35:
        r4.m = r5;
        d90 r1 = d90.a;
        if (((vc1) r1.getValue()).a() == 1) goto L38;
    L47:
        View r6 = r4.d;
        if (r6 == null) goto L50;
        m.c(r6, new MiniAppExplainCard$initData$1(r4));
    L50:
        View r7 = r4.b;
        if (r7 == null) goto L53;
        m.c(r7, new MiniAppExplainCard$initData$2(r4));
    L53:
        NormalCardBtn r8 = r4.l;
        if (r8 == null) goto L57;
        m.c(r8, new MiniAppExplainCard$initData$3(r4));
        return;
    L57:
        return;
    L38:
        if (((vc1) r1.getValue()).c() != 1) goto L47;
        if (r5.b == 1) goto L47;
        TextView r9 = r4.h;
        if (r9 == null) goto L44;
        UtilityKotlinExtentionsKt.w(r9);
    L44:
        View r10 = r4.i;
        if (r10 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r10);
        goto L47
    L6:
        if ((!Intrinsics.areEqual(r5.d, r0.d)) == false) goto L8;
        r4.setCover(r5.d);
    L8:
        ImageModel r2 = r5.e;
        b r3 = r4.m;
        String r11 = null;
        if (r3 == null) goto L11;
        ImageModel r12 = r3.e;
    L13:
        if ((!Intrinsics.areEqual(r2, r12)) == false) goto L15;
        r4.setIcon(r5.e);
    L15:
        String r13 = r5.f;
        b r14 = r4.m;
        if (r14 == null) goto L18;
        String r15 = r14.f;
    L20:
        if ((!Intrinsics.areEqual(r13, r15)) == false) goto L22;
        r4.setName(r5.f);
    L22:
        String r16 = r5.c;
        b r17 = r4.m;
        if (r17 == null) goto L25;
        String r18 = r17.c;
    L27:
        if ((!Intrinsics.areEqual(r16, r18)) == false) goto L29;
        r4.setTitle(r5.c);
    L29:
        String r19 = r5.h;
        b r20 = r4.m;
        if (r20 == null) goto L33;
        r11 = r20.h;
    L33:
        if ((!Intrinsics.areEqual(r19, r11)) == false) goto L35;
        r4.setTopIcon(r5.h);
        goto L35
    L25:
        r18 = null;
        goto L27
    L18:
        r15 = null;
        goto L20
    L11:
        r12 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiniAppExplainCard(Context r4, AttributeSet r5, int r6, View r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130969961});
        boolean r0 = r8.getBoolean(0, false);
        r8.recycle();
        if (r7 == null) goto L5;
        addView(r7);
    L13:
        J(UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5), UtilityKotlinExtentionsKt.i(5));
        this.b = findViewById(2131384840);
        this.c = findViewById(2131389158);
        this.d = findViewById(2131376107);
        this.e = findViewById(2131389496);
        this.f = findViewById(2131389661);
        this.g = (TextView) findViewById(2131389662);
        this.h = (TextView) findViewById(2131388772);
        this.i = findViewById(2131387736);
        this.j = (CardAvatarsLayout) findViewById(2131363704);
        this.k = (TextView) findViewById(2131387738);
        this.l = (NormalCardBtn) findViewById(2131389495);
        return;
    L5:
        LayoutInflater r9 = LayoutInflater.from(r4);
        if (r0 == true) goto L8;
        int r10 = c.b();
    L12:
        r9.inflate(r10, this);
        goto L13
    L8:
        if (((vc1) d90.a.getValue()).c() != 1) goto L10;
        r10 = 2131566958;
        goto L12
    L10:
        r10 = 2131566959;
        goto L12
    }

    public /* synthetic */ MiniAppExplainCard(Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        this(r3, r4, r5, null);
    }
}
