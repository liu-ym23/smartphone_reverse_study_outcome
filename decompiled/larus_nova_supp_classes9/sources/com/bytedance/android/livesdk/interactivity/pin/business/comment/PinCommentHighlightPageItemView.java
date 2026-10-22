package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/PinCommentHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Landroid/view/View;", "j", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinCommentHighlightPageItemView extends FrameLayout implements g42.e {
    public Map<Integer, View> a;
    public final ArtistTextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final LottieAnimationView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final Button i;
    public final PinCommentHighlightPageItemView j;

    public PinCommentHighlightPageItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinCommentHighlightPageItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(54);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(2131367833)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.j;
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

    public PinCommentHighlightPageItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        FrameLayout.inflate(r2, 2131566734, this);
        ArtistTextView r5 = d(2131391606);
        this.b = r5;
        this.d = (TextView) d(2131390340);
        this.c = (TextView) d(2131391620);
        this.e = d(2131384489);
        this.f = d(2131392987);
        this.g = d(2131382314);
        this.h = (TextView) d(2131367553);
        this.i = (Button) d(2131367550);
        r5.setTextSize(s1.e(11.0f));
        r5.setTextColor(ColorProtector.parseColor("#99161823"));
        r5.setIncludeFontPadding(false);
        r5.setMaxLines(1);
        r5.setEllipsis("…");
        this.j = this;
    }

    @Override // g42.e
    public final void c(DataCenter r6, g42.c r7, HighlightItem r8) {
        Intrinsics.checkNotNullParameter(r7, "pinContainer");
        Intrinsics.checkNotNullParameter(r8, "highlightItem");
        boolean r9 = z.e(r7.getDataCenter(), false);
        OperateInfo r1 = null;
        if (r8 == null) goto L5;
        HighlightItem.c r10 = r8.getCommentData();
    L6:
        if (r10 != null) goto L8;
        this.b.setText(BuildConfig.FLAVOR);
        this.d.setText(BuildConfig.FLAVOR);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.b.setText("@" + r10.e());
        if (r10.b == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.d);
        UtilityKotlinExtentionsKt.w(this.e);
        this.f.playAnimation();
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L11:
        UtilityKotlinExtentionsKt.t(this.e);
        this.f.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.d);
        TextView r0 = this.d;
        String r2 = r10.d();
        if (r2 == null) goto L14;
        CharSequence r3 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r2, 14);
    L15:
        r0.setText(r3);
        if (r9 == false) goto L18;
        setOnLongClickListener(new c(r10));
    L18:
        PinCommon r4 = r10.c();
        if (r4 == null) goto L23;
        Text r5 = r4.getTitle();
        if (r5 == null) goto L23;
        qb2.c.a(r5, new a(this));
    L23:
        if (r4 == null) goto L25;
        r1 = r4.getOperateInfo();
    L25:
        if (r1 == null) goto L37;
        UtilityKotlinExtentionsKt.w(this.g);
        Text r11 = r1.getCreatorText();
        if (r11 == null) goto L29;
        qb2.c.a(r11, new b(this));
    L29:
        if (r9 == true) goto L36;
        String r13 = r1.getCreator();
        if (r13 != null) goto L33;
    L35:
        this.i.setOnClickListener(e.a);
        this.i.setAlpha(0.34f);
        return;
    L33:
        if (r13.equals(r7.getCurrentUserId()) != true) goto L35;
    L36:
        this.i.setOnClickListener(new d(r9, r10));
        this.i.setAlpha(1.0f);
        return;
    L37:
        UtilityKotlinExtentionsKt.t(this.g);
        return;
    L14:
        r3 = null;
        goto L15
    L5:
        r10 = null;
        goto L6
    }

    public /* synthetic */ PinCommentHighlightPageItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
