package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.loading.ECLoadMoreView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u001f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u0012\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\u0019R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010!0 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00060"}, d2 = {"Lcom/bytedance/android/ec/core/widget/LoadMoreStatusView;", "Landroid/widget/FrameLayout;", "Loj/b;", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "", "setECStatus", "", "<set-?>", "a", "Ljava/lang/String;", "getLottieFileName", "()Ljava/lang/String;", "getLottieFileName$annotations", "()V", "lottieFileName", "Landroid/widget/FrameLayout$LayoutParams;", "b", "Landroid/widget/FrameLayout$LayoutParams;", "getLoadLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "loadLayoutParams", "d", "I", "getRepeatMode", "()I", "getRepeatMode$annotations", "repeatMode", "e", "getRepeatCount", "getRepeatCount$annotations", "repeatCount", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreStatusView extends FrameLayout implements oj.b {
    public static final /* synthetic */ int h = 0;
    public String a;
    public FrameLayout.LayoutParams b;
    public final FrameLayout.LayoutParams c;
    public int d;
    public int e;
    public Map<Integer, View> f;
    public int g;

    public static final class a {
        public a() {
        }

        public static LoadMoreStatusView a(Context r10, String r11, FrameLayout.LayoutParams r12) {
            int r0 = LoadMoreStatusView.h;
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "lottieFileName");
            Intrinsics.checkNotNullParameter(r12, "loadLayoutParams");
            AttributeSet r13 = null;
            LoadMoreStatusView r1 = new LoadMoreStatusView(r10, r13, 6, 0);
            r1.a = r11;
            r1.b = r12;
            r1.d = 1;
            r1.e = -1;
            return r1;
        }
    }

    static {
        new a();
    }

    public LoadMoreStatusView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public LoadMoreStatusView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    @Deprecated(message = "如无必要，不要传这个lottie文件名，默认会有加载更多的动画ECLoadMoreView")
    public static /* synthetic */ void getLottieFileName$annotations() {
    }

    @Deprecated(message = "如无必要，请使用默认的ECLoadMoreView")
    public static /* synthetic */ void getRepeatCount$annotations() {
    }

    @Deprecated(message = "如无必要，请使用默认的ECLoadMoreView")
    public static /* synthetic */ void getRepeatMode$annotations() {
    }

    public final void a() {
        setVisibility(0);
        setECStatus(0);
    }

    public final void d() {
        setVisibility(0);
        setECStatus(1);
    }

    public final void e() {
        setVisibility(0);
        setECStatus(2);
    }

    public final void b() {
        if (this.g != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r0 = this.f.get(Integer.valueOf(this.g));
        if (r0 == null) goto L8;
        r0.setVisibility(4);
    L8:
        this.g = -1;
    }

    public final FrameLayout.LayoutParams getLoadLayoutParams() {
        return this.b;
    }

    public final String getLottieFileName() {
        return this.a;
    }

    public final int getRepeatCount() {
        return this.e;
    }

    public final int getRepeatMode() {
        return this.d;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f;
    }

    public void setECStatus(int r10) {
        int r0 = this.g;
        if (r0 < 0) goto L7;
        View r1 = this.f.get(Integer.valueOf(r0));
        if (r1 == null) goto L7;
        r1.setVisibility(4);
    L7:
        View r11 = this.f.get(Integer.valueOf(r10));
        if (r11 == null) goto L20;
        r11.setVisibility(0);
        this.g = r10;
        if (r10 == 0) goto L12;
        return;
    L12:
        if (this.a.length() <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == false) goto L22;
        LottieAnimationView r13 = (ECLottieAnimationView) r11.findViewById(2131386335);
        if (r13 == null) goto L23;
        r13.setLayoutParams(this.b);
        r13.setVisibility(0);
        r13.setAnimation(this.a);
        r13.setRepeatMode(this.d);
        r13.setRepeatCount(this.e);
        r13.playAnimation();
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r12 = false;
        goto L15
    }

    public final void setStatusViews(Map<Integer, View> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f = r10;
    }

    public LoadMoreStatusView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = "";
        this.b = new FrameLayout.LayoutParams(-2, -2);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        Unit r14 = Unit.INSTANCE;
        this.c = r13;
        this.d = 1;
        this.e = -1;
        this.f = new LinkedHashMap();
        this.g = -1;
        f(null, null, null);
    }

    public final void c(Context r10, View r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        f(null, r11, r12);
    }

    public final void f(View r11, View r12, View r13) {
        this.f.clear();
        Map<Integer, View> r0 = this.f;
        Object r14 = r11;
        if (r11 == null) goto L5;
    L11:
        r0.put(0, (View) r14);
        this.f.put(1, r12);
        this.f.put(2, r13);
        removeAllViews();
        Iterator<Integer> r15 = this.f.keySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L18;
        int r16 = r15.next().intValue();
        View r17 = this.f.get(Integer.valueOf(r16));
        if (r17 == null) goto L13;
        r17.setVisibility(4);
        addView(r17);
        goto L13
    L18:
        return;
    L5:
        if (this.a.length() != 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L10;
        ECLoadMoreView r19 = new ECLoadMoreView(getContext(), null, 0, 6, null);
        r19.setLayoutParams(this.c);
        r19.setVisibility(0);
        r14 = r19;
        goto L11
    L10:
        ShoppingAsyncInflater.a r110 = ShoppingAsyncInflater.e;
        Context r10 = getContext();
        r110.getClass();
        View r111 = ShoppingAsyncInflater.a.a(r10).aU(2131564730, this, false);
        LottieAnimationView r20 = (ECLottieAnimationView) r111.findViewById(2131386335);
        r20.setLayoutParams(this.b);
        r20.setVisibility(0);
        r20.setAnimation(this.a);
        r20.setRepeatMode(this.d);
        r20.setRepeatCount(this.e);
        r20.playAnimation();
        r14 = r111;
        goto L11
    L7:
        r18 = false;
        goto L8
    }

    public /* synthetic */ LoadMoreStatusView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
