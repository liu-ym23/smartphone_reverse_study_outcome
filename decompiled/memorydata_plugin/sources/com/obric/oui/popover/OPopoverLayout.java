package com.obric.oui.popover;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.loc.o;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.m;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 {2\u00020\u0001:\u0002{|B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010N\u001a\u00020\tJ\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001eJ\u0006\u0010S\u001a\u00020\tJ\u0006\u0010T\u001a\u00020\u001eJ\u0006\u0010U\u001a\u00020\u001eJ\u0006\u0010V\u001a\u00020 J\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020GJ\u0018\u0010Y\u001a\u00020Z2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010^\u001a\u00020Z2\u0006\u0010_\u001a\u00020,2\u0006\u0010`\u001a\u00020\tJ\u0010\u0010a\u001a\u00020Z2\u0006\u0010b\u001a\u00020#H\u0015J\u0018\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020\t2\u0006\u0010e\u001a\u00020\tH\u0015J(\u0010f\u001a\u00020Z2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\tH\u0014J\b\u0010k\u001a\u00020ZH\u0002J\u000e\u0010l\u001a\u00020Z2\u0006\u0010m\u001a\u00020\tJ\u000e\u0010n\u001a\u00020Z2\u0006\u0010Q\u001a\u00020\tJ\u000e\u0010o\u001a\u00020Z2\u0006\u0010p\u001a\u00020\tJ\u0016\u0010q\u001a\u00020Z2\u0006\u0010p\u001a\u00020\t2\u0006\u0010r\u001a\u00020\u001eJ\u0010\u0010s\u001a\u00020Z2\b\b\u0001\u0010t\u001a\u00020\u001eJ\u000e\u0010u\u001a\u00020Z2\u0006\u0010v\u001a\u00020\tJ\u000e\u0010w\u001a\u00020Z2\u0006\u0010x\u001a\u00020;J\u000e\u0010y\u001a\u00020Z2\u0006\u0010z\u001a\u00020,R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u00020\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0013\"\u0004\b6\u0010\u0015R\u000e\u00107\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u000e\u0010C\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010.\"\u0004\bM\u00100¨\u0006}"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "additionalHeight", "arrowPadding", "borderColor", "borderWidth", "defaultHeight", "defaultWidth", "mAdjustHeight", "getMAdjustHeight", "()I", "setMAdjustHeight", "(I)V", "mArrowPressedPaint", "Landroid/graphics/Paint;", "mBgColor", "getMBgColor", "setMBgColor", "mBitmap", "Landroid/graphics/Bitmap;", "mBubbleArrowOffset", "", "mBubbleArrowPath", "Landroid/graphics/Path;", "mBubbleOrientation", "mCanvas", "Landroid/graphics/Canvas;", "mCornerRadius", "mFillPaint", "mHeight", "getMHeight", "()F", "setMHeight", "(F)V", "mNeedArrow", "", "getMNeedArrow", "()Z", "setMNeedArrow", "(Z)V", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mPadding", "getMPadding", "setMPadding", "mPath", "mRoundRect", "Landroid/graphics/RectF;", "mSubTitle", "", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "(Ljava/lang/String;)V", "mWidth", "getMWidth", "setMWidth", "maxWidth", "minArrowDistance", "pressStateColor", "shadowConfig", "Lcom/obric/oui/popover/OPopoverLayout$ShadowConfig;", "strokePaint", "tempArrowPath", "tempRectPath", "useDefaultView", "getUseDefaultView", "setUseDefaultView", "arrowDirection", "calculateBubbleArrowMatrix", "Landroid/graphics/Matrix;", "width", "height", "getArrowHeight", "getBubbleOffset", "getCornerRadius", "getFullPath", "getPadding", "getShadowConfig", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "measureTextViewWidth", "textView", "Landroid/widget/TextView;", "notifyPressed", "pressed", "pressedColor", "onDraw", "canvas", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", o.g, "oldw", "oldh", "renderBubbleLegPrototype", "setBorderColor", TypedValues.Custom.S_COLOR, "setBorderWidth", "setBubbleOrientation", "bubbleOrientation", "setBubbleParams", "bubbleArrowOffset", "setCornerRadius", "cornerRadius", "setCornerRadiusDp", "cornerRadiusDp", "setSubText", "str", "setTransparentBg", "transparent", "Companion", "ShadowConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {
    private static int H;
    private static int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f14312J;
    private static int K;
    private static int L;
    private static int M;
    private static int N;
    private static int O;
    private static int P;
    private static int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14313a = null;
    private final Path A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14314b;
    private b c;
    private int d;
    private Paint e;
    private Path f;
    private Path g;
    private RectF h;
    private Paint i;
    private float j;
    private float k;
    private float l;
    private int m;
    private Bitmap n;
    private Canvas o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private float v;
    private int w;
    private int x;
    private Paint y;
    private final Path z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout$Companion;", "", "()V", "ADDITIONAL_HEIGHT_DP", "", "getADDITIONAL_HEIGHT_DP", "()I", "setADDITIONAL_HEIGHT_DP", "(I)V", "ARROW_PADDING_DP", "getARROW_PADDING_DP", "setARROW_PADDING_DP", "BOTTOM", "CORNER_RADIUS_DOUBLE_DP", "getCORNER_RADIUS_DOUBLE_DP", "setCORNER_RADIUS_DOUBLE_DP", "CORNER_RADIUS_DP", "getCORNER_RADIUS_DP", "setCORNER_RADIUS_DP", "CORNER_RADIUS_SINGLE_DP", "getCORNER_RADIUS_SINGLE_DP", "setCORNER_RADIUS_SINGLE_DP", "DEFAULT_HEIGHT_DP", "getDEFAULT_HEIGHT_DP", "setDEFAULT_HEIGHT_DP", "DEFAULT_PADDING_DP", "getDEFAULT_PADDING_DP", "setDEFAULT_PADDING_DP", "DEFAULT_WIDTH_DP", "getDEFAULT_WIDTH_DP", "setDEFAULT_WIDTH_DP", "LEFT", "MAX_WIDTH_DP", "getMAX_WIDTH_DP", "setMAX_WIDTH_DP", "MIN_ARROW_DISTANCE_DP", "getMIN_ARROW_DISTANCE_DP", "setMIN_ARROW_DISTANCE_DP", "RIGHT", "TAG", "", "TOP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return OPopoverLayout.b();
        }

        public final int b() {
            return OPopoverLayout.c();
        }

        public final int c() {
            return OPopoverLayout.d();
        }

        public final int d() {
            return OPopoverLayout.e();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout$ShadowConfig;", "", "radius", "", "dx", "dy", TypedValues.Custom.S_COLOR, "", "(FFFI)V", "getColor", "()I", "setColor", "(I)V", "getDx", "()F", "setDx", "(F)V", "getDy", "setDy", "getRadius", "setRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f14315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f14316b;
        private float c;
        private int d;

        public b() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public b(float r1, float r2, float r3, int r4) {
            this.f14315a = r1;
            this.f14316b = r2;
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

        public final float a() {
            return this.f14315a;
        }

        public final void a(float r1) {
            this.f14315a = r1;
        }

        public final void a(int r1) {
            this.d = r1;
        }

        public final float b() {
            return this.f14316b;
        }

        public final void b(float r1) {
            this.f14316b = r1;
        }

        public final float c() {
            return this.c;
        }

        public final void c(float r1) {
            this.c = r1;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14315a), Float.valueOf(r6.f14315a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f14316b), Float.valueOf(r6.f14316b)) == true) goto L15;
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
            return (((((Float.hashCode(this.f14315a) * 31) + Float.hashCode(this.f14316b)) * 31) + Float.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f14315a + ", dx=" + this.f14316b + ", dy=" + this.c + ", color=" + this.d + ')';
        }
    }

    static {
        f14313a = new a(null);
        H = 7;
        I = 28;
        f14312J = 99;
        K = 12;
        L = 18;
        M = 40;
        N = 36;
        O = 20;
        P = 12;
        Q = 276;
    }

    public OPopoverLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null);
    }

    public OPopoverLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r6, 0);
    }

    public OPopoverLayout(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r10);
        this.f14314b = "";
        this.c = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.l = 0.75f;
        this.m = 1;
        this.r = true;
        this.s = true;
        this.z = new Path();
        this.A = new Path();
        a(r11, r12);
    }

    private final int a(TextView r14) {
        String r13 = r14.getText().toString();
        TextPaint r15 = r14.getPaint();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.text.TextPaint");
        int r6 = 0;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
        Iterator r16 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"\n"}, false, 0, 6, null).iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        int r0 = (int) r15.measureText((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin"));
        if (r0 <= r6) goto L8;
        r6 = r0;
        goto L8
    L12:
        return r6;
    L5:
        return (int) r15.measureText(r13);
    }

    public static final /* synthetic */ int b() {
        return H;
    }

    public static final /* synthetic */ int c() {
        return I;
    }

    public static final /* synthetic */ int d() {
        return f14312J;
    }

    public static final /* synthetic */ int e() {
        return K;
    }

    private final void f() {
        Path r0 = this.g;
        Path r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r0 = null;
    L5:
        r0.moveTo(0.0f, 0.0f);
        float r2 = this.B / 7.0f;
        Path r5 = this.g;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r6 = null;
    L9:
        float r13 = r2 * 0.0f;
        float r3 = r2 * 7.0f;
        r6.cubicTo(r13, r2 * (-2.5f), r3, r2 * (-4.0f), r3, r2 * (-10.0f));
        Path r4 = this.g;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r4 = null;
    L12:
        r4.lineTo(r3, 10.0f * r2);
        Path r7 = this.g;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r8 = null;
    L16:
        r8.cubicTo(r3, r2 * 4.0f, r13, r2 * 2.5f, r13, r13);
        Path r14 = this.g;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L20:
        r1.close();
        return;
    L19:
        r1 = r14;
        goto L20
    L15:
        r8 = r7;
        goto L16
    L8:
        r6 = r5;
        goto L9
    }

    public final int a() {
        return this.m;
    }

    public final Matrix a(float r9, float r10) {
        float r0 = Math.max(this.l, this.C + this.B);
        Matrix r1 = new Matrix();
        int r2 = this.w;
        int r3 = r2 / 2;
        int r4 = this.m;
        float r5 = 0.0f;
        if (r4 != 0) goto L5;
        r5 = Math.min(r0, (r9 - this.B) - this.C);
        float r11 = this.w;
        r1.postRotate(90.0f);
        setPadding(0, r3, 0, 0);
    L15:
        setGravity(17);
        int r6 = this.B;
        int r7 = this.w;
        this.h = new RectF(r6 + (r7 / 2), r6 + (r7 / 2), (this.j - r6) - r7, (this.k - r6) - r7);
        r1.postTranslate(r5, r11);
        Path r12 = this.f;
        Path r8 = null;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r12 = null;
    L18:
        r12.reset();
        this.z.reset();
        m r13 = m.f13498a;
        Path r14 = this.z;
        RectF r15 = this.h;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r15 = null;
    L21:
        r13.a(r14, r15, this.v);
        if (this.r == false) goto L27;
        this.A.reset();
        Path r16 = this.A;
        Path r17 = this.g;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r17 = null;
    L26:
        r16.addPath(r17, r1);
        this.z.op(this.A, Path.Op.UNION);
    L27:
        Path r18 = this.f;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L31:
        r8.addPath(this.z);
        return r1;
    L30:
        r8 = r18;
        goto L31
    L5:
        if (r4 != 1) goto L7;
        r5 = r2;
        r11 = Math.min(r0, (r10 - this.B) - this.C);
        setPadding(r3, 0, 0, 0);
        goto L15
    L7:
        if (r4 != 2) goto L9;
        r5 = r9 - r2;
        r11 = Math.min(r0, (r10 - this.B) - this.C);
        r1.postRotate(180.0f);
        setPadding(0, 0, r3, 0);
        goto L15
    L9:
        if (r4 == 3) goto L11;
        r11 = 0.0f;
        goto L15
    L11:
        r5 = Math.min(r0, (r9 - this.B) - this.C);
        r11 = r10 - this.w;
        r1.postRotate(270.0f);
        setPadding(0, 0, 0, r3);
        goto L15
    }

    public final void a(int r1, float r2) {
        this.l = r2;
        this.m = r1;
    }

    public final void a(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        this.B = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), H);
        this.C = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), L);
        this.D = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), M);
        this.E = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), N);
        this.F = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), O);
        this.d = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), P);
        this.G = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), Q);
        this.e = new Paint();
        this.f = new Path();
        this.g = new Path();
        Paint r9 = this.e;
        Paint r0 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r9 = null;
    L5:
        r9.setStyle(Paint.Style.FILL);
        Paint r10 = this.e;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L8:
        r10.setStrokeCap(Paint.Cap.BUTT);
        Paint r11 = this.e;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L11:
        r11.setAntiAlias(true);
        Paint r12 = this.e;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L14:
        r12.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.p = ContextCompat.getColor(r7, ZeusTransformUtils.mapRes(R.color.SDPrimary, TypedValues.Custom.S_COLOR, "SDPrimary"));
    L17:
        Paint r13 = this.e;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r0.setColor(getMBgColor());
        f();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L20:
        r0 = r13;
        goto L21
    }

    public final void a(boolean r2, int r3) {
        if (r2 == true) goto L4;
        Paint r1 = this.i;
        if (r1 == null) goto L32;
        r1.setColor(0);
        return;
    L32:
        return;
    L4:
        if (this.i != null) goto L21;
        Paint r4 = new Paint();
        this.i = r4;
        if (r4 == null) goto L9;
        r4.setStyle(Paint.Style.FILL);
    L9:
        Paint r5 = this.i;
        if (r5 == null) goto L13;
        r5.setStrokeCap(Paint.Cap.BUTT);
    L13:
        Paint r6 = this.i;
        if (r6 == null) goto L17;
        r6.setStrokeJoin(Paint.Join.MITER);
    L17:
        Paint r7 = this.i;
        if (r7 == null) goto L21;
        r7.setAntiAlias(true);
    L21:
        Paint r8 = this.i;
        if (r8 == null) goto L31;
        r8.setColor(r3);
        return;
    }

    public final int getArrowHeight() {
        return this.B;
    }

    public final float getBubbleOffset() {
        float r0 = Math.max(this.l, this.C);
        int r1 = this.m;
        if (r1 != 0) goto L5;
    L12:
        float r2 = this.j;
    L14:
        return Math.min(r0, (r2 - this.B) - this.C);
    L5:
        if (r1 != 1) goto L7;
    L11:
        r2 = this.k;
        goto L14
    L7:
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L12;
        return 0.0f;
    }

    public final float getCornerRadius() {
        return this.v;
    }

    public final Path getFullPath() {
        Path r0 = this.f;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r0;
    }

    public final int getMAdjustHeight() {
        return this.t;
    }

    public final int getMBgColor() {
        int r0 = this.u;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this.p;
    }

    public final float getMHeight() {
        return this.k;
    }

    public final boolean getMNeedArrow() {
        return this.r;
    }

    public final boolean getMNeedShadow() {
        return this.q;
    }

    public final int getMPadding() {
        return this.d;
    }

    public final String getMSubTitle() {
        return this.f14314b;
    }

    public final float getMWidth() {
        return this.j;
    }

    public final int getPadding() {
        return this.B / 2;
    }

    public final b getShadowConfig() {
        return this.c;
    }

    public final boolean getUseDefaultView() {
        return this.s;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.n != null) goto L5;
        this.n = Bitmap.createBitmap(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r1 = this.n;
        Intrinsics.checkNotNull(r1);
        this.o = new Canvas(r1);
    L5:
        Paint r0 = this.e;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r0 = null;
    L8:
        r0.setColor(getMBgColor());
        a(this.j, this.k);
        if (this.q == false) goto L14;
        Paint r2 = this.e;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r2 = null;
    L13:
        r2.setShadowLayer(this.c.a(), this.c.b(), this.c.c(), this.c.d());
    L14:
        Canvas r3 = this.o;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r3 = null;
    L17:
        Path r4 = this.f;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r4 = null;
    L20:
        Paint r6 = this.e;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r6 = null;
    L23:
        r3.drawPath(r4, r6);
        if (this.y == null) goto L35;
        if (this.w <= 0) goto L35;
        Canvas r5 = this.o;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r5 = null;
    L30:
        Path r7 = this.f;
        if (r7 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r7 = null;
    L33:
        Paint r9 = this.y;
        Intrinsics.checkNotNull(r9);
        r5.drawPath(r7, r9);
    L35:
        if (this.i == null) goto L40;
        Canvas r10 = this.o;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r10 = null;
    L39:
        Path r11 = this.A;
        Paint r12 = this.i;
        Intrinsics.checkNotNull(r12);
        r10.drawPath(r11, r12);
    L40:
        Bitmap r13 = this.n;
        Intrinsics.checkNotNull(r13);
        r8.drawBitmap(r13, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        int r0 = 0;
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
        int r5 = a(r2);
        int r6 = this.G;
        if (r5 > r6) goto L12;
        r6 = a(r2);
    L12:
        int r7 = (r6 + r2.getPaddingLeft()) + r2.getPaddingRight();
    L15:
        if (this.s == false) goto L24;
        int r12 = this.D;
        if (r7 <= r12) goto L19;
        r12 = (this.d * 2) + r7;
    L19:
        int r13 = this.B;
        int r14 = this.w;
        int r15 = (r12 + (r13 * 2)) + (r14 * 2);
        int r16 = (this.E + (r13 * 2)) + (r14 * 2);
        if (Intrinsics.areEqual(this.f14314b, "") == true) goto L23;
        r0 = this.F;
    L23:
        int r17 = r16 + r0;
    L26:
        if (r3 != Integer.MIN_VALUE) goto L29;
        if (r4 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r15, r17);
    L34:
        this.j = getMeasuredWidth();
        this.k = getMeasuredHeight();
        return;
    L29:
        if (r3 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r15, r11);
        goto L34
    L31:
        if (r4 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r10, r17);
        goto L34
    L33:
        setMeasuredDimension(r10, r11);
        goto L34
    L24:
        PopupWindow r18 = new PopupWindow(getChildAt(0), -2, -2, true);
        r18.getContentView().measure(0, 0);
        r15 = (this.B * 2) + r18.getContentView().getMeasuredWidth();
        r17 = r18.getContentView().getMeasuredHeight() + (this.B * 2);
        goto L26
    L13:
        r7 = getMeasuredWidth();
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.View
    public void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        if (r5 <= 0) goto L17;
        if (r6 <= 0) goto L18;
        Bitmap r0 = this.n;
        if (r0 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r0.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Bitmap r1 = Bitmap.createBitmap(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.o = new Canvas(r1);
        this.n = r1;
        com.obric.oui.c.a.b.d("OPopoverLayout", "onSizeChanged, init new bg, w: " + r5 + ", h: " + r6 + ", oldw: " + r7 + ", oldh: " + r8);
        return;
    L14:
        if (r0.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r1) {
        this.x = r1;
    }

    public final void setBorderWidth(int r4) {
        if (r4 > 0) goto L4;
        return;
    L4:
        this.w = r4;
        if (this.y != null) goto L7;
        this.y = new Paint();
    L7:
        Paint r5 = this.y;
        if (r5 == null) goto L11;
        r5.setStyle(Paint.Style.STROKE);
    L11:
        Paint r6 = this.y;
        if (r6 == null) goto L15;
        r6.setStrokeWidth(this.w);
    L15:
        Paint r7 = this.y;
        if (r7 == null) goto L19;
        r7.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r8 = this.y;
        if (r8 == null) goto L23;
        r8.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r9 = this.y;
        if (r9 == null) goto L27;
        r9.setAntiAlias(true);
    L27:
        Paint r10 = this.y;
        if (r10 == null) goto L31;
        r10.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER), Xfermode.class, "com.obric.memorydata.plugin"));
    L31:
        Paint r11 = this.y;
        if (r11 == null) goto L35;
        r11.setColor(this.x);
    L35:
        Paint r12 = this.e;
        Paint r0 = null;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L38:
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r13 = this.e;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r0.setStrokeWidth(this.w);
        return;
    L41:
        r0 = r13;
        goto L42
    }

    public final void setBubbleOrientation(int r1) {
        this.m = r1;
    }

    public final void setCornerRadius(float r1) {
        this.v = r1;
    }

    public final void setCornerRadiusDp(int r3) {
        this.v = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setMAdjustHeight(int r1) {
        this.t = r1;
    }

    public final void setMBgColor(int r1) {
        this.p = r1;
    }

    public final void setMHeight(float r1) {
        this.k = r1;
    }

    public final void setMNeedArrow(boolean r1) {
        this.r = r1;
    }

    public final void setMNeedShadow(boolean r1) {
        this.q = r1;
    }

    public final void setMPadding(int r1) {
        this.d = r1;
    }

    public final void setMSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14314b = r2;
    }

    public final void setMWidth(float r1) {
        this.j = r1;
    }

    public final void setSubText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        this.f14314b = r2;
    }

    public final void setTransparentBg(boolean r1) {
        if (r1 == false) goto L5;
        this.p = 0;
        return;
    }

    public final void setUseDefaultView(boolean r1) {
        this.s = r1;
    }
}
