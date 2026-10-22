package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/widget/DoubleColorBallStatusView;", "Landroid/widget/FrameLayout;", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "", "setECStatus", "", "Landroid/view/View;", "a", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleColorBallStatusView extends FrameLayout {
    public Map<Integer, View> a;
    public int b;

    public static final class a {
    }

    static {
    }

    public DoubleColorBallStatusView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public DoubleColorBallStatusView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void a() {
        if (this.b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r0 = this.a.get(Integer.valueOf(this.b));
        if (r0 == null) goto L8;
        r0.setVisibility(4);
    L8:
        this.b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.a;
    }

    public final void setECStatus(int r10) {
        int r0 = this.b;
        if (r0 < 0) goto L7;
        View r1 = this.a.get(Integer.valueOf(r0));
        if (r1 == null) goto L7;
        r1.setVisibility(4);
    L7:
        View r11 = this.a.get(Integer.valueOf(r10));
        if (r11 == null) goto L20;
        r11.setVisibility(0);
        this.b = r10;
        if (r10 != 0) goto L21;
        ECDuxLoadingAnimationView r12 = r11.findViewById(2131386348);
        if (r12 != null) goto L14;
        return;
    L14:
        if ((!r12.isAnimating()) == true) goto L17;
        r12 = null;
    L17:
        if (r12 == null) goto L23;
        r12.startAnimate();
        return;
    L23:
        return;
    L21:
        return;
    }

    public final void setStatusViews(Map<Integer, View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.a = r10;
    }

    public DoubleColorBallStatusView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        LinkedHashMap r15 = new LinkedHashMap();
        this.a = r15;
        this.b = -1;
        r15.clear();
        Map<Integer, View> r16 = this.a;
        ECLoadingConfig r1 = ECLoadingConfig.INSTANCE;
        if (r1.isDecided() == true) goto L5;
        r1.decideUsePersistentCache(ECSettingKeys.E());
    L5:
        View r10 = th.a.c(getContext(), 2131564714, this, false);
        Lazy r11 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L9;
        r10.findViewById(2131386348).setVisibility(0);
    L11:
        r16.put(0, r10);
        this.a.put(1, null);
        this.a.put(2, null);
        removeAllViews();
        Iterator<Integer> r17 = this.a.keySet().iterator();
    L13:
        if (r17.hasNext() == false) goto L18;
        int r18 = r17.next().intValue();
        View r19 = this.a.get(Integer.valueOf(r18));
        if (r19 == null) goto L13;
        r19.setVisibility(4);
        addView(r19);
        goto L13
    L18:
        return;
    L9:
        if (we.a.a == false) goto L11;
        ((FrameLayout) r10.findViewById(2131386302)).setVisibility(0);
        ImageView r110 = (ImageView) r10.findViewById(2131386314);
        RotateAnimation r20 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r20.setInterpolator(new LinearInterpolator());
        r20.setDuration(1000);
        r20.setRepeatCount(-1);
        r20.setFillAfter(true);
        r20.setStartOffset(0);
        Unit r111 = Unit.INSTANCE;
        r110.startAnimation(r20);
        goto L11
    }

    public /* synthetic */ DoubleColorBallStatusView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
