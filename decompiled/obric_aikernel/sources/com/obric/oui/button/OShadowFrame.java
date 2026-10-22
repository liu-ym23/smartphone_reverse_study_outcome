package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.layout.OUIFrameLayout;
import ea.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import n8.d;
import o9.k;
import o9.p;
import u8.c;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0019B1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "enabled", "", "setEnabled", "", TypedValues.Custom.S_COLOR, "setBgColor", "setPressColor", "t", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OShadowFrame extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f6276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private d f6277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f6281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f6282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f6283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected OUIFrameLayout f6284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private List<p> f6285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<p> f6286v;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OShadowFrame(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OShadowFrame(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OShadowFrame(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OShadowFrame(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        this.f6281q = 1.0f;
        this.f6282r = 1.0f;
        this.f6283s = 0.01f;
        l(r10, r11);
    }

    public /* synthetic */ OShadowFrame(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ float c(OShadowFrame r10) {
        return r10.f6281q;
    }

    public static final /* synthetic */ List d(OShadowFrame r10, float r11, float r12, float r13, List r14, List r15) {
        return r10.i(r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ float e(OShadowFrame r10) {
        return r10.f6282r;
    }

    public static final /* synthetic */ List f(OShadowFrame r10) {
        return r10.f6285u;
    }

    public static final /* synthetic */ List g(OShadowFrame r10) {
        return r10.f6286v;
    }

    private final void h(boolean r25) {
        if (isEnabled() == true) goto L6;
        b.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        b.a("OShadowFrame", "doPressAnim: " + r25);
        d r10 = this.f6276l;
        if (r10 == null) goto L9;
        d.c(r10, false, 1, null);
    L9:
        d r11 = this.f6277m;
        if (r11 == null) goto L12;
        d.c(r11, false, 1, null);
    L12:
        com.obric.common.oea.foundation.animation.builder.a.C0123a r12 = com.obric.common.oea.foundation.animation.builder.b.b(this, 0.0f, 1, null);
        AnimationProperty$FloatProperty r13 = AnimationProperty$FloatProperty.SCALE_X;
        if (r25 == false) goto L15;
        Float r14 = Float.valueOf(getScaleX());
        float r15 = this.f6282r;
        Token$Bounce r16 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r17 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r18 = o8.b.b(r16, r17, 0, 4, null);
        r18.j(this.f6283s);
        Unit r19 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r110 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r14, r15, r18, null, 16, null);
        AnimationProperty$FloatProperty r111 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r112 = Float.valueOf(getScaleY());
        float r20 = this.f6282r;
        com.obric.common.oea.foundation.animation.spec.spring.b r21 = o8.b.b(r16, r17, 0, 4, null);
        r21.j(this.f6283s);
        this.f6276l = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r110, r111, r112, r20, r21, null, 16, null).e(new OShadowFrame$doPressAnim$$inlined$let$lambda$1(this)).b(), null, null, 3, null);
        return;
    L15:
        Float r113 = Float.valueOf(getScaleX());
        float r114 = this.f6281q;
        Token$Bounce r22 = Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4;
        Token$Duration r23 = Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3;
        com.obric.common.oea.foundation.animation.spec.spring.b r115 = o8.b.b(r22, r23, 0, 4, null);
        r115.j(this.f6283s);
        Unit r24 = Unit.INSTANCE;
        com.obric.common.oea.foundation.animation.builder.a.C0123a r116 = com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r12, r13, r113, r114, r115, null, 16, null);
        AnimationProperty$FloatProperty r117 = AnimationProperty$FloatProperty.SCALE_Y;
        Float r118 = Float.valueOf(getScaleY());
        float r26 = this.f6281q;
        com.obric.common.oea.foundation.animation.spec.spring.b r27 = o8.b.b(r22, r23, 0, 4, null);
        r27.j(this.f6283s);
        this.f6277m = com.obric.common.oea.foundation.animation.builder.a.b(com.obric.common.oea.foundation.animation.builder.a.C0123a.d(r116, r117, r118, r26, r27, null, 16, null).e(new OShadowFrame$doPressAnim$$inlined$let$lambda$2(this)).b(), null, null, 3, null);
    }

    private final List<p> i(float r17, float r18, float r19, List<p> r20, List<p> r21) {
        float r10 = RangesKt.coerceIn((r17 - r18) / (r19 - r18), 0.0f, 1.0f);
        if (r20 == null) goto L17;
        if (r21 != null) goto L6;
        return r20;
    L6:
        if (r20.size() != r21.size()) goto L19;
        Iterator<T> r11 = r20.iterator();
        Iterator<T> r12 = r21.iterator();
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r20, 10), CollectionsKt.collectionSizeOrDefault(r21, 10)));
    L9:
        if (r11.hasNext() == false) goto L14;
        if (r12.hasNext() == false) goto L14;
        Object r14 = r11.next();
        p r15 = (p) r12.next();
        p r16 = (p) r14;
        com.obric.oui.button.a r22 = com.obric.oui.button.a.f6287a;
        r13.add(new p(r22.a(r10, r16.a(), r15.a()), r22.b(r16.f(), r15.f(), r10), r22.b(r16.c(), r15.c(), r10), r22.b(r16.d(), r15.d(), r10), r22.b(r16.g(), r15.g(), r10), null, 0.0f, 96, null));
    L14:
        return r13;
    L19:
        return r20;
    L17:
        return r20;
    }

    private final void k(Context r10, TypedArray r11) {
        int r12 = r11.getResourceId(l.OShadowFrame_oui_widgetShadowNormal, 0);
        int r13 = r11.getResourceId(l.OShadowFrame_oui_widgetShadowPressed, 0);
        if (r12 == 0) goto L5;
        List<p> r14 = k.v(r10, r12);
        List<p> r15 = CollectionsKt.listOf(new p[]{r14.get(0), r14.get(1)});
        this.f6285u = r15;
        Intrinsics.checkNotNull(r15);
        p r16 = (p) CollectionsKt.getOrNull(r15, 0);
        List<p> r17 = this.f6285u;
        Intrinsics.checkNotNull(r17);
        setShadow(r16, (p) CollectionsKt.getOrNull(r17, 1));
    L5:
        if (r13 == 0) goto L8;
        List<p> r18 = k.v(r10, r13);
        this.f6286v = CollectionsKt.listOf(new p[]{r18.get(0), r18.get(1)});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(Context r11, AttributeSet r12) {
        TypedArray r10 = r11.obtainStyledAttributes(r12, l.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        OUIFrameLayout r13 = null;
        Object[] r14 = 0 == true ? 1 : 0;
        this.f6284t = new OUIFrameLayout(r11, r14, 0, null, 14, null);
        int r15 = l.OShadowFrame_oui_widgetBgColor;
        Resources r16 = getResources();
        int r17 = c.oui_floating_button_bg_color_1;
        this.f6279o = r10.getColor(r15, r16.getColor(r17, null));
        this.f6280p = r10.getColor(l.OShadowFrame_oui_widgetBgColorDisabled, getResources().getColor(r17, null));
        if (this.f6279o == 0) goto L8;
        OUIFrameLayout r18 = this.f6284t;
        if (r18 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L7:
        r18.setBackgroundColor(this.f6279o);
    L8:
        this.f6282r = r10.getFloat(l.OShadowFrame_oui_widgetPressScale, 1.0f);
        setChangeAlphaWhenPress(false);
        int r19 = r10.getDimensionPixelSize(l.OShadowFrame_oui_widgetPaddingL, 0);
        int r20 = r10.getDimensionPixelSize(l.OShadowFrame_oui_widgetPaddingR, 0);
        int r21 = r10.getDimensionPixelSize(l.OShadowFrame_oui_widgetPaddingT, 0);
        int r22 = r10.getDimensionPixelSize(l.OShadowFrame_oui_widgetPaddingB, 0);
        int r23 = r10.getDimensionPixelSize(l.OShadowFrame_oui_widgetRadius, 0);
        OUIFrameLayout r24 = this.f6284t;
        if (r24 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L11:
        r24.setPadding(r19, r21, r20, r22);
        OUIFrameLayout r25 = this.f6284t;
        if (r25 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L14:
        r25.setRadius(r23);
        this.f6278n = r10.getColor(l.OShadowFrame_oui_widgetPressColor, 0);
        OUIFrameLayout r26 = this.f6284t;
        if (r26 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L17:
        r26.setOverridePressColor(this.f6278n);
        OUIFrameLayout r27 = this.f6284t;
        if (r27 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L20:
        r27.refreshColors("OShadowFrame");
        OUIFrameLayout r28 = this.f6284t;
        if (r28 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L23:
        addView(r28, new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r23);
        OUIFrameLayout r29 = this.f6284t;
        if (r29 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L26:
        j(r11, r29, r12, r10);
        da.c r110 = da.c.f8520a;
        OUIFrameLayout r111 = this.f6284t;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L29:
        if (r111 == null) goto L32;
        r13 = r111;
    L32:
        if (r13 == null) goto L34;
        r13.setChangeAlphaWhenDisable(false);
    L34:
        setChangeAlphaWhenDisable(false);
        k(r11, r10);
        r10.recycle();
        setClipChildren(false);
        setClickable(true);
        n(isEnabled());
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        boolean r11 = super.dispatchTouchEvent(r10);
        int r12 = r10.getAction();
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L6;
    L8:
        h(false);
    L10:
        return r11;
    L6:
        if (r12 == 3) goto L8;
    L9:
        h(true);
        goto L10
    }

    protected final OUIFrameLayout getContentView() {
        OUIFrameLayout r10 = this.f6284t;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r10;
    }

    public abstract void j(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13);

    public final void m(@ColorInt int r10, @ColorInt int r11) {
        this.f6279o = r10;
        this.f6280p = r11;
        n(isEnabled());
    }

    protected void n(boolean r10) {
        if (r10 == false) goto L8;
        OUIFrameLayout r11 = this.f6284t;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L7:
        int r12 = this.f6279o;
    L12:
        r11.setBackgroundColor(r12);
        return;
    L8:
        r11 = this.f6284t;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L11:
        r12 = this.f6280p;
        goto L12
    }

    public final void setBgColor(@ColorInt int r10) {
        this.f6279o = r10;
        n(isEnabled());
    }

    protected final void setContentView(OUIFrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6284t = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        n(r10);
    }

    public final void setPressColor(@ColorInt int r10) {
        this.f6278n = r10;
        OUIFrameLayout r11 = this.f6284t;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        r11.setOverridePressColor(this.f6278n);
        OUIFrameLayout r12 = this.f6284t;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L8:
        r12.refreshColors("OShadowFrame");
    }
}
