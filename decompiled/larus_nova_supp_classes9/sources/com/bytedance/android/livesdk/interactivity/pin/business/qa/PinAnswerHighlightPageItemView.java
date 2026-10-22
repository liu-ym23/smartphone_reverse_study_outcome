package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/qa/PinAnswerHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Landroid/view/View;", "k", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinAnswerHighlightPageItemView extends FrameLayout implements g42.e {
    public Map<Integer, View> a;
    public final ArtistTextView b;
    public final TextView c;
    public final ArtistTextView d;
    public final TextView e;
    public final View f;
    public final LottieAnimationView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final Button j;
    public final PinAnswerHighlightPageItemView k;

    public PinAnswerHighlightPageItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinAnswerHighlightPageItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(72);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(2131367833)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.k;
    }

    @Override // g42.e
    public final void a(HighlightItem r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r2, "item");
    }

    public final View d(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // g42.e
    public final void b(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "item");
        g42.e.a.a(r2, r3);
    }

    @Override // g42.e
    public void update(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
        g42.e.a.update(this, r2, r3);
    }

    public PinAnswerHighlightPageItemView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = new LinkedHashMap();
        FrameLayout.inflate(r4, 2131566760, this);
        ArtistTextView r7 = d(2131391606);
        this.b = r7;
        this.c = (TextView) d(2131391620);
        ArtistTextView r8 = d(2131391235);
        this.d = r8;
        this.e = (TextView) d(2131390150);
        this.f = d(2131384489);
        this.g = d(2131392987);
        this.h = d(2131382314);
        this.i = (TextView) d(2131367553);
        this.j = (Button) d(2131367550);
        r7.setTextSize(s1.e(11.0f));
        r7.setTextColor(ColorProtector.parseColor("#99161823"));
        r7.setIncludeFontPadding(true);
        r7.setMaxLines(1);
        r7.setEllipsis("…");
        r8.setTextSize(s1.e(11.0f));
        r8.setTextColor(ColorProtector.parseColor("#99161823"));
        r8.setIncludeFontPadding(false);
        r8.setMaxLines(1);
        r8.setEllipsis("…”");
        this.k = this;
    }

    @Override // g42.e
    public final void c(DataCenter r10, g42.c r11, HighlightItem r13) {
        Intrinsics.checkNotNullParameter(r11, "pinContainer");
        Intrinsics.checkNotNullParameter(r13, "highlightItem");
        boolean r14 = z.e(r11.getDataCenter(), false);
        if (r13 == null) goto L5;
        final HighlightItem.a r15 = r13.getAnswerData();
    L6:
        if (r15 != null) goto L9;
        this.b.setText(BuildConfig.FLAVOR);
        this.d.setText(BuildConfig.FLAVOR);
        this.e.setText(BuildConfig.FLAVOR);
        this.e.setOnClickListener(null);
        this.e.setOnLongClickListener(null);
        this.e.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L9:
        if (r15.d() <= 1) goto L21;
        String r2 = r15.e();
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        String r4 = r15.e();
    L20:
        this.b.setEllipsis("…等" + r4 + "人问");
        this.b.setText("@" + r15.h() + 31561 + r4 + "人问");
    L22:
        SpannableStringBuilder r5 = new SpannableStringBuilder().append("“");
        String r6 = r15.i();
        if (r6 == null) goto L25;
        CharSequence r7 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r6, 11);
    L26:
        this.d.setText(r5.append(r7).append("”"));
        if (r15.b == false) goto L29;
        UtilityKotlinExtentionsKt.t(this.e);
        UtilityKotlinExtentionsKt.w(this.f);
        this.g.playAnimation();
        this.e.setOnClickListener(null);
        this.e.setOnLongClickListener(null);
        this.e.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
    L36:
        PinCommon r0 = r15.g();
        if (r0 == null) goto L41;
        Text r8 = r0.getTitle();
        if (r8 == null) goto L41;
        qb2.c.a(r8, new a(this));
    L41:
        if (r0 == null) goto L43;
        OperateInfo r1 = r0.getOperateInfo();
    L44:
        if (r1 == null) goto L60;
        UtilityKotlinExtentionsKt.w(this.h);
        Text r9 = r1.getCreatorText();
        if (r9 == null) goto L48;
        qb2.c.a(r9, new b(this));
    L48:
        if (r14 == true) goto L55;
        String r16 = r1.getCreator();
        if (r16 != null) goto L52;
    L54:
        this.j.setOnClickListener(d.a);
        this.j.setAlpha(0.34f);
        return;
    L52:
        if (r16.equals(r11.getCurrentUserId()) != true) goto L54;
    L55:
        this.j.setOnClickListener(new c(r14, r15));
        this.j.setAlpha(1.0f);
        this.e.setOnClickListener(null);
        String r17 = r1.getCreator();
        if (r17 != null) goto L58;
        return;
    L58:
        if (r17.equals(r11.getCurrentUserId()) != true) goto L65;
        this.e.setOnClickListener(x0.a(new PinAnswerHighlightPageItemView$doBindView$5(r15)));
        return;
    L65:
        return;
    L60:
        UtilityKotlinExtentionsKt.t(this.h);
        return;
    L43:
        r1 = null;
        goto L44
    L29:
        UtilityKotlinExtentionsKt.t(this.f);
        this.g.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.e);
        TextView r18 = this.e;
        String r19 = r15.a();
        if (r19 == null) goto L32;
        CharSequence r20 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r19, 14);
    L33:
        r18.setText(r20);
        if (r14 == false) goto L36;
        this.e.setOnClickListener(x0.a(new PinAnswerHighlightPageItemView$doBindView$1(r15)));
        e r21 = new e(r15);
        this.e.setOnLongClickListener(r21);
        setOnLongClickListener(r21);
        goto L36
    L32:
        r20 = null;
        goto L33
    L25:
        r7 = null;
        goto L26
    L19:
        r4 = String.valueOf(r15.d());
        goto L20
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r3 = false;
        goto L17
    L21:
        this.b.setEllipsis("… 问");
        this.b.setText("@" + r15.h() + " 问");
        goto L22
    L5:
        r15 = null;
        goto L6
    }

    public /* synthetic */ PinAnswerHighlightPageItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
