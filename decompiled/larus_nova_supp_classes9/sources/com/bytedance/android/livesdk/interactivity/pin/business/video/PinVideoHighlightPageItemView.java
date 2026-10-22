package com.bytedance.android.livesdk.interactivity.pin.business.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import g42.e;
import hd0.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n92.a;
import n92.b;
import n92.d;
import n92.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/video/PinVideoHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Landroid/view/View;", "m", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinVideoHighlightPageItemView extends FrameLayout implements e {
    public Map<Integer, View> a;
    public final ArtistTextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final LottieAnimationView f;
    public final HSImageView g;
    public final FrameLayout h;
    public final LinearLayout i;
    public final ConstraintLayout j;
    public final TextView k;
    public final Button l;
    public final PinVideoHighlightPageItemView m;

    public PinVideoHighlightPageItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinVideoHighlightPageItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(74);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(2131367833)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.m;
    }

    @Override // g42.e
    public final void a(HighlightItem r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        HighlightItem.f r0 = r6.getVideoData();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isReviewing() == true) goto L20;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L14;
        i r2 = r1.isAnchor();
        if (r2 == null) goto L14;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L14;
        String r3 = "anchor";
    L17:
        PinAppLogger.g(String.valueOf(r6.getItemId()), r3);
        return;
    L14:
        if (c.f().h() == false) goto L16;
        r3 = "guest";
        goto L17
    L16:
        r3 = "audience";
        goto L17
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
        e.a.a(r2, r3);
    }

    @Override // g42.e
    public void update(g42.c r2, HighlightItem r3) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        Intrinsics.checkNotNullParameter(r3, "highlightItem");
        e.a.update(this, r2, r3);
    }

    public PinVideoHighlightPageItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        FrameLayout.inflate(r2, 2131566740, this);
        ArtistTextView r5 = d(2131392400);
        this.b = r5;
        this.c = (TextView) d(2131391620);
        this.d = (TextView) d(2131392285);
        this.e = d(2131384489);
        this.f = d(2131392987);
        this.g = d(2131392289);
        this.i = (LinearLayout) d(2131367833);
        this.h = (FrameLayout) d(2131392290);
        this.j = d(2131382314);
        this.k = (TextView) d(2131367553);
        this.l = (Button) d(2131367550);
        r5.setTextSize(s1.e(11.0f));
        r5.setTextColor(ColorProtector.parseColor("#99161823"));
        r5.setIncludeFontPadding(false);
        r5.setMaxLines(1);
        r5.setEllipsis("…");
        this.m = this;
    }

    @Override // g42.e
    public final void c(DataCenter r8, g42.c r9, HighlightItem r10) {
        Intrinsics.checkNotNullParameter(r9, "pinContainer");
        Intrinsics.checkNotNullParameter(r10, "highlightItem");
        boolean r0 = false;
        boolean r11 = z.e(r9.getDataCenter(), false);
        OperateInfo r1 = null;
        if (r10 == null) goto L5;
        HighlightItem.f r13 = r10.getVideoData();
    L6:
        if (r13 != null) goto L8;
        this.b.setText(BuildConfig.FLAVOR);
        this.d.setText(BuildConfig.FLAVOR);
        this.i.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.b.setEllipsis("… 分享视频");
        this.b.setText("@" + r13.c() + " 分享视频");
        ImageModel r2 = new ImageModel();
        ArrayList r3 = new ArrayList();
        String r4 = r13.f();
        if (r4 == null) goto L11;
        r3.add(r4);
    L11:
        r2.setUrls(r3);
        ImageUtil.loadImage(this.g, r2, 0);
        if (r13.isReviewing() == false) goto L14;
        UtilityKotlinExtentionsKt.w(this.e);
        this.f.playAnimation();
        this.d.setMaxLines(1);
        this.d.setAlpha(0.34f);
        this.h.setAlpha(0.34f);
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L18:
        String r5 = r13.e();
        if (r5 != null) goto L21;
    L22:
        r0 = true;
    L23:
        if (r0 == false) goto L25;
        r5 = s1.B(2131921374);
    L25:
        this.d.setText(r5);
        PinCommon r6 = r13.a();
        if (r6 == null) goto L30;
        Text r7 = r6.getTitle();
        if (r7 == null) goto L30;
        qb2.c.a(r7, new a(this));
    L30:
        if (r6 == null) goto L32;
        r1 = r6.getOperateInfo();
    L32:
        if (r1 == null) goto L44;
        UtilityKotlinExtentionsKt.w(this.j);
        Text r14 = r1.getCreatorText();
        if (r14 == null) goto L36;
        qb2.c.a(r14, new b(this));
    L36:
        if (r11 == true) goto L43;
        String r15 = r1.getCreator();
        if (r15 != null) goto L40;
    L42:
        this.l.setOnClickListener(d.a);
        this.l.setAlpha(0.34f);
        return;
    L40:
        if (r15.equals(r9.getCurrentUserId()) != true) goto L42;
    L43:
        this.l.setOnClickListener(new n92.c(r11, r13));
        this.l.setAlpha(1.0f);
        return;
    L44:
        UtilityKotlinExtentionsKt.t(this.j);
        return;
    L21:
        if (r5.length() != 0) goto L23;
    L14:
        UtilityKotlinExtentionsKt.t(this.e);
        this.d.setMaxLines(2);
        this.d.setAlpha(1.0f);
        this.h.setAlpha(1.0f);
        this.f.pauseAnimation();
        setClickable(true);
        if (r11 == false) goto L17;
        setOnLongClickListener(new f(r13));
    L17:
        setOnClickListener(new n92.e(r13));
        goto L18
    L5:
        r13 = null;
        goto L6
    }

    public /* synthetic */ PinVideoHighlightPageItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
