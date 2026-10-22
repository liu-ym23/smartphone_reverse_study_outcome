package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0003J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015J\b\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "firstShadow", "Lcom/obric/oui/common/style/Shadow;", "secondShadow", "shadowCornerRadius", "", "drawShadow", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "regionRect", "Landroid/graphics/RectF;", "shadow", "onDraw", "updatePadding", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f14455b;
    private k c;
    private float d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14454a = new a(null);
    }

    public OShadowLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OShadowLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OShadowLayout(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13);
        this.f14455b = k.f13496b.j();
        this.c = k.f13496b.j();
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OShadowLayout, r13, 0);
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
        b[] r17 = ShadowTokenCore.parse(r16.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_shadow, "styleable", "OShadowLayout_oui_shadow")));
        float r18 = ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        if (r17 != null) goto L5;
        this.f14455b.a(com.obric.oui.shadow.a.f14456a.a(r16, ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowColor, "styleable", "OShadowLayout_oui_firstShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowRadius, "styleable", "OShadowLayout_oui_firstShadowRadius"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstOffsetX, "styleable", "OShadowLayout_oui_firstOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstOffsetY, "styleable", "OShadowLayout_oui_firstOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_firstShadowSpread, "styleable", "OShadowLayout_oui_firstShadowSpread")));
        this.c.a(com.obric.oui.shadow.a.f14456a.a(r16, ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowColor, "styleable", "OShadowLayout_oui_secondShadowColor"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowRadius, "styleable", "OShadowLayout_oui_secondShadowRadius"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondOffsetX, "styleable", "OShadowLayout_oui_secondOffsetX"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondOffsetY, "styleable", "OShadowLayout_oui_secondOffsetY"), ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_secondShadowSpread, "styleable", "OShadowLayout_oui_secondShadowSpread")));
    L15:
        this.d = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OShadowLayout_oui_shadowCornerRadius, "styleable", "OShadowLayout_oui_shadowCornerRadius"), 0.0f);
        r16.recycle();
        setWillNotDraw(false);
        a();
        return;
    L5:
        if (r17.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == false) goto L12;
        k r2 = this.f14455b;
        b r4 = r17[0];
        Intrinsics.checkNotNullExpressionValue(r4, "shadowToken[0]");
        r2.a(r4, r18);
    L12:
        if (r17.length <= 1) goto L15;
        k r3 = this.c;
        b r19 = r17[1];
        Intrinsics.checkNotNullExpressionValue(r19, "shadowToken[1]");
        r3.a(r19, r18);
        goto L15
    L7:
        r1 = false;
        goto L9
    }

    public /* synthetic */ OShadowLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a() {
        Math.max(Math.abs(this.f14455b.c()) + Math.abs(this.f14455b.b()), Math.abs(this.c.c()) + Math.abs(this.c.b()));
        Math.max(Math.abs(this.f14455b.d()) + Math.abs(this.f14455b.b()), Math.abs(this.c.d()) + Math.abs(this.c.b()));
    }

    private final void a(Canvas r4, Path r5, RectF r6, k r7) {
        int r0 = r4.save();
        RectF r1 = new RectF(r6);
        r1.offset(r7.c(), r7.d());
        r1.inset(-r7.e(), -r7.e());
        r4.clipOutPath(r5);
        float r3 = this.d;
        r4.drawRoundRect(r1, r3, r3, r7.f());
        r4.restoreToCount(r0);
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        super.onDraw(r12);
        Path r0 = new Path();
        int r1 = getChildCount();
        int r2 = Integer.MIN_VALUE;
        int r5 = Integer.MAX_VALUE;
        int r6 = 0;
        int r3 = Integer.MIN_VALUE;
        int r4 = Integer.MAX_VALUE;
    L3:
        if (r6 >= r1) goto L5;
        int r7 = r6 + 1;
        View r8 = getChildAt(r6);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r4 = Math.min(r4, r8.getLeft() - r10.leftMargin);
        r5 = Math.min(r5, r8.getTop() - r10.topMargin);
        r2 = Math.max(r2, r8.getRight() + r10.rightMargin);
        r3 = Math.max(r3, r8.getBottom() + r10.bottomMargin);
        r6 = r7;
        goto L3
    L5:
        RectF r11 = new RectF(r4, r5, r2, r3);
        float r13 = this.d;
        r0.addRoundRect(r11, r13, r13, Path.Direction.CW);
        RectF r14 = new RectF();
        r0.computeBounds(r14, true);
        a(r12, r0, r14, this.f14455b);
        a(r12, r0, r14, this.c);
    }
}
