package com.bytedance.android.livesdk.interactivity.pin.business.microapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.p;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import g42.c;
import g42.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m92.a;
import m92.b;
import m92.d;
import m92.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/microapp/PinMicroAppHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", BuildConfig.FLAVOR, "getContentHeight", "getMinHeight", "Landroid/view/View;", "m", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinMicroAppHighlightPageItemView extends FrameLayout implements e {
    public static final /* synthetic */ int n = 0;
    public Map<Integer, View> a;
    public final ArtistTextView b;
    public final TextView c;
    public final View d;
    public final View e;
    public final LottieAnimationView f;
    public final HSImageView g;
    public final TextView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final TextView k;
    public final Button l;
    public final PinMicroAppHighlightPageItemView m;

    public PinMicroAppHighlightPageItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinMicroAppHighlightPageItemView(Context r3, AttributeSet r4) {
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

    public PinMicroAppHighlightPageItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        FrameLayout.inflate(r2, 2131566738, this);
        ArtistTextView r5 = d(2131391606);
        this.b = r5;
        this.c = (TextView) d(2131391620);
        this.e = d(2131384489);
        this.f = d(2131392987);
        this.d = d(2131380072);
        this.g = d(2131376410);
        this.h = (TextView) d(2131390952);
        this.i = (TextView) d(2131390951);
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
    public final void c(DataCenter r11, c r13, HighlightItem r14) {
        Intrinsics.checkNotNullParameter(r13, "pinContainer");
        Intrinsics.checkNotNullParameter(r14, "highlightItem");
        boolean r15 = z.e(r13.getDataCenter(), false);
        OperateInfo r1 = null;
        if (r14 == null) goto L5;
        HighlightItem.e r16 = r14.getMicroAppData();
    L6:
        if (r16 != null) goto L8;
        this.b.setText(BuildConfig.FLAVOR);
        UtilityKotlinExtentionsKt.t(this.d);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.b.setText("@" + r16.e() + " 分享小程序");
        if (r16.isReviewing() == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.d);
        UtilityKotlinExtentionsKt.w(this.e);
        this.f.playAnimation();
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L34:
        PinCommon r0 = r16.a();
        if (r0 == null) goto L39;
        Text r2 = r0.getTitle();
        if (r2 == null) goto L39;
        qb2.c.a(r2, new a(this));
    L39:
        if (r0 == null) goto L41;
        r1 = r0.getOperateInfo();
    L41:
        if (r1 == null) goto L53;
        UtilityKotlinExtentionsKt.w(this.j);
        Text r3 = r1.getCreatorText();
        if (r3 == null) goto L45;
        qb2.c.a(r3, new b(this));
    L45:
        if (r15 == true) goto L52;
        String r4 = r1.getCreator();
        if (r4 != null) goto L49;
    L51:
        this.l.setOnClickListener(f.a);
        this.l.setAlpha(0.34f);
        return;
    L49:
        if (r4.equals(r13.getCurrentUserId()) != true) goto L51;
    L52:
        this.l.setOnClickListener(new m92.e(r15, r16));
        this.l.setAlpha(1.0f);
        return;
    L53:
        UtilityKotlinExtentionsKt.t(this.j);
        return;
    L11:
        UtilityKotlinExtentionsKt.t(this.e);
        this.f.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.d);
        this.h.setText(r16.d());
        this.i.setText(r16.getCommentContent());
        ImageLoader.bindImage(this.g, r16.b());
        if (r15 == false) goto L14;
        setOnLongClickListener(new m92.c(r16));
    L14:
        String r5 = r16.f();
        setOnClickListener(new d(this, r5));
        com.bytedance.android.livesdk.interactivity.api.f r6 = o.b();
        if (r6 == null) goto L21;
        j<i42.b> r7 = r6.getMiniAppPreloader();
        if (r7 == null) goto L21;
        i42.b r8 = (i42.b) r7.getValue();
        if (r8 == null) goto L21;
        r8.a(r5);
    L21:
        if (r5 == null) goto L34;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L30;
        i r10 = r9.isAnchor();
        if (r10 == null) goto L30;
        Boolean r17 = (Boolean) r10.getValue();
        if (r17 == null) goto L30;
        r17.booleanValue();
    L30:
        Pair r18 = p.b(r5, "live_other", g4.d(), "comment_pin", "comment_pin", LaunchParamConstant.Scene.c);
        if (r18 == null) goto L34;
        u.l().h("mp_show", (Map) r18.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp((String) r18.getFirst());
        goto L34
    L5:
        r16 = null;
        goto L6
    }

    public /* synthetic */ PinMicroAppHighlightPageItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
