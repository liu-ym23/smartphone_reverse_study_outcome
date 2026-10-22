package com.bytedance.android.livesdk.interactivity.pin.business.im;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PictureTextStyle;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g42.c;
import g42.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l92.a;
import l92.b;
import l92.d;
import l92.f;
import l92.g;
import l92.h;
import l92.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/im/PinImHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Landroid/view/View;", "b", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinImHighlightPageItemView extends FrameLayout implements e {
    public Map<Integer, View> a;
    public final PinImHighlightPageItemView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final LottieAnimationView f;
    public final ConstraintLayout g;
    public final TextView h;
    public final Button i;
    public final LinearLayout j;
    public final RelativeLayout k;
    public final HSImageView l;
    public final TextView m;
    public final TextView n;

    public PinImHighlightPageItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinImHighlightPageItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(52);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(2131367833)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.b;
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
    public final void b(c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "item");
        e.a.a(r2, r3);
    }

    @Override // g42.e
    public void update(c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
        e.a.update(this, r2, r3);
    }

    public PinImHighlightPageItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.b = this;
        FrameLayout.inflate(r2, 2131566737, this);
        this.c = (TextView) d(2131391606);
        this.d = (TextView) d(2131390392);
        this.e = (LinearLayout) d(2131384489);
        this.f = d(2131392987);
        this.j = (LinearLayout) d(2131367833);
        this.g = d(2131382314);
        this.h = (TextView) d(2131367553);
        this.i = (Button) d(2131367550);
        this.k = (RelativeLayout) d(2131387501);
        this.l = d(2131376311);
        this.m = (TextView) d(2131391574);
        this.n = (TextView) d(2131391522);
    }

    @Override // g42.e
    public final void c(DataCenter r6, c r7, HighlightItem r8) {
        Intrinsics.checkNotNullParameter(r7, "pinContainer");
        Intrinsics.checkNotNullParameter(r8, "highlightItem");
        boolean r9 = z.e(r7.getDataCenter(), false);
        OperateInfo r1 = null;
        if (r8 == null) goto L5;
        HighlightItem.d r10 = r8.getImData();
    L6:
        if (r10 != null) goto L8;
        this.c.setText(BuildConfig.FLAVOR);
        this.d.setText(BuildConfig.FLAVOR);
        this.j.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.c.setText(String.valueOf(r10.d()));
        if (r10.isReviewing() == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.d);
        UtilityKotlinExtentionsKt.w(this.e);
        this.f.playAnimation();
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L31:
        PinCommon r0 = r10.a();
        if (r0 == null) goto L36;
        Text r2 = r0.getTitle();
        if (r2 == null) goto L36;
        qb2.c.a(r2, new l92.e(this));
    L36:
        if (r0 == null) goto L38;
        r1 = r0.getOperateInfo();
    L38:
        if (r1 == null) goto L50;
        UtilityKotlinExtentionsKt.w(this.g);
        Text r3 = r1.getCreatorText();
        if (r3 == null) goto L42;
        qb2.c.a(r3, new f(this));
    L42:
        if (r9 == true) goto L49;
        String r4 = r1.getCreator();
        if (r4 != null) goto L46;
    L48:
        this.i.setOnClickListener(h.a);
        this.i.setAlpha(0.34f);
        return;
    L46:
        if (r4.equals(r7.getCurrentUserId()) != true) goto L48;
    L49:
        this.i.setOnClickListener(new g(r9, r10));
        this.i.setAlpha(1.0f);
        return;
    L50:
        UtilityKotlinExtentionsKt.t(this.g);
        return;
    L11:
        UtilityKotlinExtentionsKt.w(this.d);
        UtilityKotlinExtentionsKt.t(this.e);
        this.f.pauseAnimation();
        setClickable(true);
        PictureTextStyle r5 = r10.c();
        if (r5 == null) goto L26;
        ImageModel r11 = r5.getPicture();
        if (r11 == null) goto L16;
        ImageLoader.bindImage(this.l, r11);
    L16:
        Text r13 = r5.getText();
        if (r13 == null) goto L19;
        qb2.c.a(r13, new a(this));
    L19:
        Text r14 = r5.getSubText();
        if (r14 == null) goto L22;
        qb2.c.a(r14, new b(this));
    L22:
        String r15 = r5.getSchema();
        if (r15 == null) goto L25;
        setOnClickListener(new l92.c(r15, this));
    L25:
        UtilityKotlinExtentionsKt.w(this.k);
        UtilityKotlinExtentionsKt.t(this.d);
    L29:
        if (r9 == false) goto L31;
        setOnLongClickListener(new i(r10));
        goto L31
    L26:
        Text r16 = r10.b();
        if (r16 == null) goto L29;
        qb2.c.a(r16, new d(this));
        UtilityKotlinExtentionsKt.t(this.k);
        UtilityKotlinExtentionsKt.w(this.d);
        goto L29
    L5:
        r10 = null;
        goto L6
    }

    public /* synthetic */ PinImHighlightPageItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
