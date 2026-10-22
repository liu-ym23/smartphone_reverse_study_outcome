package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 i2\u00020\u0001:\u0002ijB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010H\u001a\u00020\tJ\u0016\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u000fJ\u0006\u0010M\u001a\u00020\tJ\u0006\u0010N\u001a\u00020\u000fJ\u0006\u0010O\u001a\u00020 J\u0006\u0010=\u001a\u00020\tJ\u0006\u0010P\u001a\u00020AJ\u0018\u0010Q\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010S\u001a\u00020RH\u0002J\u0016\u0010T\u001a\u00020R2\u0006\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\tJ\u0012\u0010W\u001a\u00020R2\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u0010\u0010Z\u001a\u00020R2\u0006\u0010[\u001a\u00020#H\u0015J\u0018\u0010\\\u001a\u00020R2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0015J\u000e\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020\tJ\u000e\u0010a\u001a\u00020R2\u0006\u0010K\u001a\u00020\tJ\u000e\u0010b\u001a\u00020R2\u0006\u0010c\u001a\u00020\tJ\u0016\u0010d\u001a\u00020R2\u0006\u0010c\u001a\u00020\t2\u0006\u0010e\u001a\u00020\u000fJ\u0010\u0010f\u001a\u00020R2\b\b\u0001\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010g\u001a\u00020R2\u0006\u0010h\u001a\u00020+R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u000e\u00103\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u000e\u0010;\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u000e\u0010?\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/¨\u0006k"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowPadding", "borderColor", "borderWidth", "cornerRadius", "", "defaultHeight", "defaultWidth", "mAdjustHeight", "getMAdjustHeight", "()I", "setMAdjustHeight", "(I)V", "mArrowPressedPaint", "Landroid/graphics/Paint;", "mBgColor", "getMBgColor", "setMBgColor", "mBitmap", "Landroid/graphics/Bitmap;", "mBubbleArrowOffset", "mBubbleArrowPath", "Landroid/graphics/Path;", "mBubbleOrientation", "mCanvas", "Landroid/graphics/Canvas;", "mFillPaint", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mNeedArrow", "", "getMNeedArrow", "()Z", "setMNeedArrow", "(Z)V", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mPath", "mPopoverGg", "Landroid/graphics/drawable/Drawable;", "mRoundRect", "Landroid/graphics/RectF;", "mWidth", "getMWidth", "setMWidth", "minArrowDistance", "padding", "getPadding", "setPadding", "pressStateColor", "shadowConfig", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$ShadowConfig;", "strokePaint", "tempArrowPath", "tempRectPath", "useDefaultView", "getUseDefaultView", "setUseDefaultView", "arrowDirection", "calculateBubbleArrowMatrix", "Landroid/graphics/Matrix;", "width", "height", "getArrowHeight", "getBubbleOffset", "getFullPath", "getShadowConfig", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "initSimpleBubbleLegPrototype", "notifyPressed", "pressed", "pressedColor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBorderColor", TypedValues.Custom.S_COLOR, "setBorderWidth", "setBubbleOrientation", "bubbleOrientation", "setBubbleParams", "bubbleArrowOffset", "setCornerRadius", "setTransparentBg", "transparent", "Companion", "ShadowConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    private static int D;
    private static float E;
    private static int F;
    private static int G;
    private static float H;
    private static int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14308a = null;
    private Paint A;
    private final Path B;
    private final Path C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14309b;
    private float c;
    private int d;
    private int e;
    private float f;
    private b g;
    private float h;
    private Paint i;
    private Path j;
    private Path k;
    private float l;
    private float m;
    private float n;
    private int o;
    private Bitmap p;
    private Canvas q;
    private Drawable r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$Companion;", "", "()V", "BOTTOM", "", "LEFT", "RIGHT", "TOP", "arrowPaddingDp", "getArrowPaddingDp", "()I", "setArrowPaddingDp", "(I)V", "cornerRadiusDp", "", "getCornerRadiusDp", "()F", "setCornerRadiusDp", "(F)V", "defaultHeightDp", "getDefaultHeightDp", "setDefaultHeightDp", "defaultPaddingDp", "getDefaultPaddingDp", "setDefaultPaddingDp", "defaultWidthDp", "getDefaultWidthDp", "setDefaultWidthDp", "minArrowDistanceDp", "getMinArrowDistanceDp", "setMinArrowDistanceDp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$ShadowConfig;", "", "radius", "", "dx", "dy", TypedValues.Custom.S_COLOR, "", "(FFFI)V", "getColor", "()I", "setColor", "(I)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "getRadius", "setRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f14310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f14311b;
        private float c;
        private int d;

        public b() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public b(float r1, float r2, float r3, int r4) {
            this.f14310a = r1;
            this.f14311b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ b(float r2, float r3, float r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 2.0f;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 2.0f;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 5.0f;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = ViewCompat.MEASURED_STATE_MASK;
        L14:
            this(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14310a), Float.valueOf(r6.f14310a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f14311b), Float.valueOf(r6.f14311b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f14310a) * 31) + Float.hashCode(this.f14311b)) * 31) + Float.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f14310a + ", dx=" + this.f14311b + ", dy=" + this.c + ", color=" + this.d + ')';
        }
    }

    static {
        f14308a = new a(null);
        D = 9;
        E = 18.0f;
        F = 42;
        G = 42;
        H = Integer.min(42, 42) / 2.0f;
        I = 12;
    }

    public OMiddleArrowPopoverLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null);
    }

    public OMiddleArrowPopoverLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r6, 0);
    }

    public OMiddleArrowPopoverLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r11);
        this.g = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.n = 0.75f;
        this.o = 1;
        this.u = true;
        this.v = true;
        this.B = new Path();
        this.C = new Path();
        a(r12, r13);
    }

    private final void a() {
        float r0 = this.f14309b;
        float r1 = this.m;
        float r2 = (r0 + (r1 / 2.0f)) - ((r1 / 2.0f) / 1.63f);
        float r3 = (r1 / 2.0f) / 1.56f;
        Path r4 = this.k;
        Path r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r4 = null;
    L5:
        r4.reset();
        Path r6 = this.k;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r6 = null;
    L8:
        r6.moveTo(0.0f, 0.0f);
        Path r7 = this.k;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r7 = null;
    L11:
        r7.lineTo(r2, -r3);
        Path r8 = this.k;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r8 = null;
    L14:
        r8.lineTo(r2, r3);
        Path r9 = this.k;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r9 = null;
    L17:
        r9.lineTo(0.0f, 0.0f);
        Path r10 = this.k;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L21:
        r5.close();
        return;
    L20:
        r5 = r10;
        goto L21
    }

    public final void a(Context r6, AttributeSet r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        this.f14309b = h.a(r8, D);
        this.c = h.c(r8, E);
        this.d = h.a(r8, F);
        this.e = h.a(r8, G);
        this.f = h.c(r8, H);
        this.h = h.b(r8, I);
        this.i = new Paint();
        this.j = new Path();
        this.k = new Path();
        Paint r10 = this.i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L5:
        r10.setStyle(Paint.Style.FILL);
        Paint r11 = this.i;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L8:
        r11.setStrokeCap(Paint.Cap.BUTT);
        Paint r12 = this.i;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L11:
        r12.setAntiAlias(true);
        Paint r13 = this.i;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L14:
        r13.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.s = ContextCompat.getColor(r8, ZeusTransformUtils.mapRes(R.color.SDPrimary, TypedValues.Custom.S_COLOR, "SDPrimary"));
    L17:
        Paint r14 = this.i;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r14 = null;
    L20:
        r14.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.r = r8.getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_bg_middle_arrow_popover, "drawable", "o_bg_middle_arrow_popover"));
    }

    public final int getArrowHeight() {
        return this.f14309b;
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.n, this.c);
        int r1 = this.o;
        if (r1 != 0) goto L5;
    L12:
        float r2 = this.l;
    L14:
        return Math.min(r0, (r2 - this.f14309b) - this.c);
    L5:
        if (r1 != 1) goto L7;
    L11:
        r2 = this.m;
        goto L14
    L7:
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L12;
        return 0.0f;
    }

    public final Path getFullPath() {
        Path r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r0;
    }

    public final int getMAdjustHeight() {
        return this.w;
    }

    public final int getMBgColor() {
        int r0 = this.x;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.s;
    }

    public final float getMHeight() {
        return this.m;
    }

    public final boolean getMNeedArrow() {
        return this.u;
    }

    public final boolean getMNeedShadow() {
        return this.t;
    }

    public final float getMWidth() {
        return this.l;
    }

    public final float getPadding() {
        return this.h;
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m1336getPadding() {
        return this.f14309b / 2;
    }

    public final b getShadowConfig() {
        return this.g;
    }

    public final boolean getUseDefaultView() {
        return this.v;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        this.f14309b = h.a(r5, D);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        this.c = h.c(r6, E);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        this.d = h.a(r7, F);
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "context");
        this.e = h.a(r8, G);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "context");
        this.f = h.c(r9, H);
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        this.h = h.b(r10, I);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.p != null) goto L5;
        this.p = Bitmap.createBitmap(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r1 = this.p;
        Intrinsics.checkNotNull(r1);
        this.q = new Canvas(r1);
    L5:
        Paint r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L8:
        r0.setColor(getMBgColor());
        Drawable r2 = this.r;
        if (r2 == null) goto L34;
        int r3 = this.o;
        if (r3 != 0) goto L14;
        float r4 = 270.0f;
    L21:
        int r5 = this.f14309b + ((int) getPadding());
        int r6 = this.f14309b;
        int r7 = (getHeight() - ((int) ((((getWidth() - r5) - r6) * r2.getIntrinsicHeight()) / r2.getIntrinsicWidth()))) / 2;
        r2.setBounds(r5, r7, getWidth() - r6, getHeight() - r7);
        Canvas r8 = this.q;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r8 = null;
    L24:
        r8.save();
        Canvas r9 = this.q;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r9 = null;
    L27:
        r9.rotate(r4, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r11 = this.q;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r11 = null;
    L30:
        r2.draw(r11);
        Canvas r12 = this.q;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r12 = null;
    L33:
        r12.restore();
        goto L34
    L14:
        if (r3 != 1) goto L16;
        r4 = 180.0f;
        goto L21
    L16:
        if (r3 == 3) goto L18;
        r4 = 0.0f;
        goto L21
    L18:
        r4 = 90.0f;
    L34:
        Bitmap r13 = this.p;
        Intrinsics.checkNotNull(r13);
        r10.drawBitmap(r13, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if (ZeusTransformUtils.instanceOf(getChildAt(0), TextView.class) == false) goto L5;
        View r1 = getChildAt(0);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.TextView");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
    L6:
        int r3 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        int r4 = View.MeasureSpec.getMode(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (r2 == null) goto L13;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        int r6 = h.a(r5, 276);
        if (((int) r2.getPaint().measureText(r2.getText().toString())) > r6) goto L12;
        r6 = (int) r2.getPaint().measureText(r2.getText().toString());
    L12:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L15:
        if (this.v == false) goto L20;
        int r0 = this.d;
        if (r7 <= r0) goto L19;
        r0 = (((int) this.h) * 2) + r7;
    L19:
        int r12 = this.f14309b;
        int r13 = this.y;
        int r14 = (r0 + (r12 * 2)) + (r13 * 2);
        int r15 = (this.e + (r12 * 2)) + (r13 * 2);
    L22:
        if (r3 != Integer.MIN_VALUE) goto L25;
        if (r4 != Integer.MIN_VALUE) goto L25;
        setMeasuredDimension(r14, r15);
    L29:
        this.l = getMeasuredWidth();
        this.m = getMeasuredHeight();
        a();
        return;
    L25:
        if (r3 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r14, r11);
        goto L29
    L27:
        if (r4 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r10, r15);
        goto L29
    L20:
        PopupWindow r16 = new PopupWindow(getChildAt(0), -2, -2, true);
        r16.getContentView().measure(0, 0);
        r14 = r16.getContentView().getMeasuredWidth() + (D * 2);
        r15 = r16.getContentView().getMeasuredHeight() + (D * 2);
        goto L22
    L13:
        r7 = getMeasuredWidth();
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    public final void setBorderColor(int r1) {
        this.z = r1;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.y = r4;
        if (this.A != null) goto L7;
        this.A = new Paint();
    L7:
        Paint r5 = this.A;
        if (r5 == null) goto L11;
        r5.setStyle(Paint.Style.STROKE);
    L11:
        Paint r6 = this.A;
        if (r6 == null) goto L15;
        r6.setStrokeWidth(this.y);
    L15:
        Paint r7 = this.A;
        if (r7 == null) goto L19;
        r7.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r8 = this.A;
        if (r8 == null) goto L23;
        r8.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r9 = this.A;
        if (r9 == null) goto L27;
        r9.setAntiAlias(true);
    L27:
        Paint r10 = this.A;
        if (r10 == null) goto L31;
        r10.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER), Xfermode.class, "com.obric.memorydata.plugin"));
    L31:
        Paint r11 = this.A;
        if (r11 == null) goto L35;
        r11.setColor(this.z);
    L35:
        Paint r12 = this.i;
        Paint r0 = null;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L38:
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = this.i;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r0.setStrokeWidth(this.y);
        return;
    L41:
        r0 = r13;
        goto L42
    }

    public final void setBubbleOrientation(int r1) {
        this.o = r1;
    }

    public final void setCornerRadius(float r1) {
        this.f = r1;
    }

    public final void setMAdjustHeight(int r1) {
        this.w = r1;
    }

    public final void setMBgColor(int r1) {
        this.s = r1;
    }

    public final void setMHeight(float r1) {
        this.m = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.u = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.t = r1;
    }

    public final void setMWidth(float r1) {
        this.l = r1;
    }

    public final void setPadding(float r1) {
        this.h = r1;
    }

    public final void setTransparentBg(boolean r3) {
        if (r3 == false) goto L5;
        this.s = 0;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r1) {
        this.v = r1;
    }
}
