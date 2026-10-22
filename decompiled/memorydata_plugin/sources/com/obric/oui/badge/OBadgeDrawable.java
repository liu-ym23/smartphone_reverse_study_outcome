package com.obric.oui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 r2\u00020\u0001:\u0002qrB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010\\\u001a\u00020ZJ\u0010\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u0004\u0018\u00010$J\b\u0010a\u001a\u00020\u0006H\u0016J\b\u0010b\u001a\u00020ZH\u0002J\u0014\u0010c\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020\u0006H\u0016J\u0012\u0010f\u001a\u00020Z2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0010\u0010i\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010$J\u0018\u0010j\u001a\u00020/2\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0016J\u000e\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020BJ\u0018\u0010m\u001a\u00020Z2\u0006\u0010n\u001a\u00020B2\b\u0010o\u001a\u0004\u0018\u00010BJ\b\u0010p\u001a\u00020ZH\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u000e\u00109\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR\u000e\u0010G\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010N\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010U\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR\u000e\u0010X\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", EventBody.KEY_VALUE, "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "backgroundPaint", "Landroid/graphics/Paint;", "badgeCenterX", "", "badgeCenterY", "Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "badgeGravity", "getBadgeGravity", "()Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "setBadgeGravity", "(Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;)V", "badgeHeight", "badgeMinSize", "", "badgeText", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "badgeTextColor", "getBadgeTextColor", "setBadgeTextColor", "badgeWidth", "contentDescription", "", "dotDiameter", "ellipsisCircleDrawOffset", "ellipsisCircleRadius", "ellipsisColor", "getEllipsisColor", "()Ljava/lang/Integer;", "setEllipsisColor", "(Ljava/lang/Integer;)V", "ellipsisHeight", "ellipsisWidth", "", "enableFontScale", "getEnableFontScale", "()Z", "setEnableFontScale", "(Z)V", "hasCenter", "horizontalOffset", "getHorizontalOffset", "setHorizontalOffset", "horizontalPadding", "internalBadgeText", "internalEllipsisColor", "Ljava/lang/Integer;", "internalTextPaint", "Landroid/text/TextPaint;", "lastAnchorRect", "Landroid/graphics/Rect;", "lastAnchorView", "Landroid/view/View;", "lastOverlayHost", "maxNumber", "getMaxNumber", "setMaxNumber", "maxOverFlow", "needsLayout", "rectF", "Landroid/graphics/RectF;", "textPaint", "getTextPaint", "()Landroid/text/TextPaint;", "textSizeSp", "getTextSizeSp", "()F", "setTextSizeSp", "(F)V", "textWidthExtra", "tmpTextBounds", "verticalOffset", "getVerticalOffset", "setVerticalOffset", "verticalPadding", "calculateBadgeSize", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "clearText", "draw", "canvas", "Landroid/graphics/Canvas;", "getContentDescription", "getOpacity", "invalidateBadge", "parseNumber", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setContentDescription", "setVisible", "visible", "restart", "updateBadgeCoordinates", "anchor", "overlayHost", "updateBoundsInternal", "BadgeGravity", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13325a = null;
    private Integer A;
    private int B;
    private BadgeGravity C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private CharSequence f13326J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13327b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private final Paint m;
    private final TextPaint n;
    private final Rect o;
    private final RectF p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private Rect w;
    private View x;
    private View y;
    private String z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "", "(Ljava/lang/String;I)V", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum BadgeGravity extends Enum<BadgeGravity> {
        private static final /* synthetic */ BadgeGravity[] $VALUES = null;
        public static final BadgeGravity CENTER = null;
        public static final BadgeGravity TOP_END = null;
        public static final BadgeGravity TOP_START = null;

        private static final /* synthetic */ BadgeGravity[] $values() {
            return new BadgeGravity[]{TOP_START, TOP_END, CENTER};
        }

        static {
            TOP_START = new BadgeGravity("TOP_START", 0);
            TOP_END = new BadgeGravity("TOP_END", 1);
            CENTER = new BadgeGravity("CENTER", 2);
            $VALUES = $values();
        }

        private BadgeGravity(String r1, int r2) {
            super(r1, r2);
        }

        public static BadgeGravity valueOf(String r2) {
            return (BadgeGravity) ZeusTransformUtils.preCheckCast(Enum.valueOf(BadgeGravity.class, r2), BadgeGravity.class, "com.obric.memorydata.plugin");
        }

        public static BadgeGravity[] values() {
            return (BadgeGravity[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BadgeGravity[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$Companion;", "", "()V", "BADGE_HORIZONTAL_PADDING_DP", "", "BADGE_MIN_SIZE_DP", "BADGE_VERTICAL_PADDING_DP", "DEFAULT_MAX_COUNT", "", "DEFAULT_TEXT_SIZE_SP", "DOT_DIAMETER_DP", "ELLIPSIS_CIRCLE_DRAW_OFFSET_DP", "ELLIPSIS_CIRCLE_RADIUS_DP", "", "ELLIPSIS_HEIGHT_DP", "ELLIPSIS_WIDTH_DP", "MAX_OVERFLOW_DP", "TEXT_WIDTH_EXTRA_DP", "create", "Lcom/obric/oui/badge/OBadgeDrawable;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final OBadgeDrawable a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            return new OBadgeDrawable(r1, null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13328a = null;

        static {
            int[] r0 = new int[BadgeGravity.values().length];
            r0[BadgeGravity.TOP_START.ordinal()] = 1;
            r0[BadgeGravity.TOP_END.ordinal()] = 2;
            r0[BadgeGravity.CENTER.ordinal()] = 3;
            f13328a = r0;
        }
    }

    static {
        f13325a = new a(null);
    }

    private OBadgeDrawable(Context r8) {
        Context r9 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f13327b = r9;
        this.c = h.c(r9, 4.0f);
        this.d = h.c(r9, 4.0f);
        this.e = h.c(r9, 8.0f);
        this.f = h.c(r9, 5.0f);
        this.g = h.c(r9, 18.0f);
        this.h = h.a(r9, 1.5d);
        this.i = h.b(r9, 5);
        this.j = h.c(r9, 23.0f);
        this.k = h.c(r9, 18.0f);
        this.l = h.c(r9, 1.0f);
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setColor(ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.oui_red_6, TypedValues.Custom.S_COLOR, "oui_red_6")));
        this.m = r0;
        TextPaint r1 = new TextPaint(1);
        r1.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r1.setTypeface(Typeface.create(r1.getTypeface(), 500, false));
    L6:
        r1.setColor(ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.white, TypedValues.Custom.S_COLOR, "white")));
        r1.setTextSize(h.d(r9, 12.0f));
        this.n = r1;
        this.o = new Rect();
        this.p = new RectF();
        this.u = true;
        this.B = HijrahDate.MAX_VALUE_OF_ERA;
        this.C = BadgeGravity.TOP_END;
        this.F = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.oui_red_6, TypedValues.Custom.S_COLOR, "oui_red_6"));
        this.G = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.white, TypedValues.Custom.S_COLOR, "white"));
        this.H = true;
        this.I = 12.0f;
        return;
    L5:
        r1.setFakeBoldText(true);
        goto L6
    }

    public /* synthetic */ OBadgeDrawable(Context r2, DefaultConstructorMarker r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private final String b(String r4) {
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
    L13:
        return r4;
    L15:
        Integer r0 = Integer.valueOf(String.valueOf(r4));     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r0, TypedValues.Custom.S_INT);     // Catch: Exception -> L11
        if (r0.intValue() <= this.B) goto L8;
        r4 = new StringBuilder().append(this.B).append('+').toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r0.intValue() >= 0) goto L14;
        r4 = "";
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Excepted a int but get ", this.z));
    }

    private final void c(String r5) {
        if (c() == null) goto L11;
        Integer r0 = c();
        if (r0 != null) goto L8;
    L9:
        this.s = this.j;
        float r6 = this.k;
    L10:
        this.t = r6;
        return;
    L8:
        if (r0.intValue() != 0) goto L9;
    L11:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6 = this.e;
    L20:
        this.s = r6;
        goto L10
    L21:
        this.n.getTextBounds(r5, 0, r5.length(), this.o);
        float r7 = this.o.width() + this.l;
        float r3 = this.c;
        float r4 = this.g;
        float r8 = RangesKt.coerceAtLeast(r7 + (2 * r3), r4);
        if (r8 > r4) goto L24;
        r6 = Math.max(r8, r4);
        goto L20
    L24:
        this.s = r8;
        this.t = r4;
        return;
    L14:
        if (r1.length() == 0) goto L17;
        r2 = false;
        goto L18
    }

    private final void d() {
        if (this.v == true) goto L5;
        return;
    L5:
        c(this.z);
        float r0 = this.s / 2.0f;
        float r2 = this.t / 2.0f;
        int r1 = MathKt.roundToInt(this.q - r0);
        int r3 = MathKt.roundToInt(this.r - r2);
        int r4 = MathKt.roundToInt(this.q + r0);
        int r5 = MathKt.roundToInt(this.r + r2);
        Rect r6 = this.w;
        if (r6 == null) goto L21;
        float r7 = this.f;
        int r8 = b.f13328a[this.C.ordinal()];
        if (r8 != 1) goto L10;
        float r9 = r6.left - r1;
        if (r9 <= r7) goto L18;
        int r10 = MathKt.roundToInt(r9 - r7);
        r1 = r1 + r10;
        r4 = r4 + r10;
    L18:
        float r11 = r6.top - r3;
        if (r11 <= r7) goto L21;
        int r12 = MathKt.roundToInt(r11 - r7);
        r3 = r3 + r12;
        r5 = r5 + r12;
        goto L21
    L10:
        if (r8 != 2) goto L18;
        float r13 = r4 - r6.right;
        if (r13 <= r7) goto L18;
        int r14 = MathKt.roundToInt(r13 - r7);
        r1 = r1 - r14;
        r4 = r4 - r14;
    L21:
        setBounds(r1, r3, r4, r5);
        this.u = false;
    }

    private final void e() {
        this.u = true;
        invalidateSelf();
        View r0 = this.x;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        a(r0, this.y);
        return;
    }

    public final int a() {
        return this.B;
    }

    public final void a(float r4) {
        int r1 = 1;
        if (this.I != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.I = r4;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.f13327b, "com.obric.memorydata.plugin").getDisplayMetrics();
        TextPaint r2 = this.n;
        if (this.H == false) goto L11;
        r1 = 2;
    L11:
        r2.setTextSize(TypedValue.applyDimension(r1, this.I, r5));
        e();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(int r2) {
        if (r2 >= 1) goto L6;
        r2 = 1;
    L6:
        if (this.B != r2) goto L8;
        return;
    L8:
        this.B = r2;
        this.z = b(this.z);
        e();
    }

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        a(r2, null);
    }

    public final void a(View r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "anchor");
        this.x = r8;
        this.y = r9;
        Rect r0 = new Rect();
        boolean r1 = false;
        if (r9 == null) goto L5;
        int[] r4 = new int[2];
        int[] r5 = new int[2];
        r8.getLocationInWindow(r4);
        r9.getLocationInWindow(r5);
        int r10 = r4[0] - r5[0];
        int r6 = r4[1] - r5[1];
        r0.set(r10, r6, r8.getWidth() + r10, r8.getHeight() + r6);
    L6:
        this.w = new Rect(r0);
        if (ViewCompat.getLayoutDirection(r8) != 1) goto L9;
        r1 = true;
    L9:
        int r11 = b.f13328a[this.C.ordinal()];
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L16;
        if (r11 != 3) goto L15;
        int r12 = r0.right - ((r0.right - r0.left) / 2);
    L22:
        if (b.f13328a[this.C.ordinal()] != 3) goto L24;
        int r13 = r0.bottom - ((r0.bottom - r0.top) / 2);
    L25:
        this.q = r12 + this.D;
        this.r = r13 + this.E;
        this.v = true;
        this.u = true;
        d();
        return;
    L24:
        r13 = r0.top;
        goto L25
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        if (r1 == true) goto L20;
    L19:
        r12 = r0.right;
    L20:
        r12 = r0.left;
        goto L22
    L18:
        if (r1 == false) goto L20;
    L5:
        r8.getDrawingRect(r0);
        goto L6
    }

    public final void a(BadgeGravity r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        if (this.C != r2) goto L5;
        return;
    L5:
        this.C = r2;
        e();
    }

    public final void a(CharSequence r3) {
        this.f13326J = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final void a(Integer r2) {
        if (Intrinsics.areEqual(this.A, r2) == false) goto L5;
        return;
    L5:
        this.A = r2;
        this.z = null;
        e();
    }

    public final void a(String r3) {
        if (Intrinsics.areEqual(this.z, r3) == false) goto L5;
        return;
    L5:
        String r4 = b(r3);
        this.z = r4;
        if (r4 == null) goto L13;
        Intrinsics.checkNotNull(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        this.A = null;
        goto L13
    L10:
        r5 = false;
    L13:
        e();
    }

    public final void a(boolean r4) {
        if (this.H != r4) goto L5;
        return;
    L5:
        this.H = r4;
        DisplayMetrics r5 = ZeusTransformUtils.getResources(this.f13327b, "com.obric.memorydata.plugin").getDisplayMetrics();
        TextPaint r0 = this.n;
        if (this.H == false) goto L8;
        int r1 = 2;
    L9:
        r0.setTextSize(TypedValue.applyDimension(r1, this.I, r5));
        e();
        return;
    L8:
        r1 = 1;
        goto L9
    }

    public final int b() {
        return this.E;
    }

    public final void b(int r2) {
        if (this.E != r2) goto L5;
        return;
    L5:
        this.E = r2;
        e();
    }

    public final Integer c() {
        return this.A;
    }

    public final void c(int r2) {
        if (this.F != r2) goto L5;
        return;
    L5:
        this.F = r2;
        this.m.setColor(r2);
        invalidateSelf();
    }

    public final void d(int r2) {
        if (this.G != r2) goto L5;
        return;
    L5:
        this.G = r2;
        this.n.setColor(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.v == true) goto L9;
        return;
    L9:
        if (this.u == false) goto L12;
        d();
    L12:
        if (this.s > 0.0f) goto L14;
        return;
    L14:
        if (this.t <= 0.0f) goto L37;
        this.p.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r0 = this.t / 2.0f;
        r9.drawRoundRect(this.p, r0, r0, this.m);
        String r1 = this.z;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        r9.drawText(r1, this.p.centerX(), this.p.centerY() - ((this.n.ascent() + this.n.descent()) / 2.0f), (Paint) ZeusTransformUtils.preCheckCast(this.n, Paint.class, "com.obric.memorydata.plugin"));
    L26:
        if (c() == null) goto L35;
        Integer r4 = c();
        if (r4 != null) goto L31;
    L32:
        float r5 = this.p.centerX();
        float r6 = this.p.centerY();
        float r7 = this.h;
        Paint r8 = new Paint();
        Integer r10 = c();
        Intrinsics.checkNotNull(r10);
        r8.setColor(r10.intValue());
        r8.setAntiAlias(true);
        r9.drawCircle(r5, r6, r7, r8);
        r9.drawCircle(r5 - this.i, r6, r7, r8);
        r9.drawCircle(r5 + this.i, r6, r7, r8);
        return;
    L31:
        if (r4.intValue() != 0) goto L32;
        return;
    L35:
        return;
    L19:
        if (r2.length() == 0) goto L22;
        r3 = false;
        goto L23
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.m.setAlpha(r2);
        this.n.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.m.setColorFilter(r2);
        this.n.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r1, boolean r2) {
        boolean r3 = super.setVisible(r1, r2);
        if (r3 == false) goto L5;
        invalidateSelf();
    L5:
        return r3;
    }
}
