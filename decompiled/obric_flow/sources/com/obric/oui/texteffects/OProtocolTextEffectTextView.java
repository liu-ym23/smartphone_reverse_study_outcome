package com.obric.oui.texteffects;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.ai.event.MessageIndication;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import java.util.Iterator;
import js.e;
import js.f;
import js.g;
import js.h;
import js.k;
import js.l;
import js.n;
import js.r;
import js.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00158\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\u00020\u00158\u0014X\u0094D¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001a\u0010&\u001a\u00020\n8\u0014X\u0094D¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001a\u0010)\u001a\u00020\n8\u0014X\u0094D¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001fR\u0014\u0010-\u001a\u00020*8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "scale", "", "setDebugAnimationDurationScale", "(F)V", "Lls/a;", "b", "Lkotlin/Lazy;", "getBlurFilterCache", "()Lls/a;", "blurFilterCache", "", "<set-?>", "l", "Ljava/lang/String;", "getActiveEffectName", "()Ljava/lang/String;", "activeEffectName", "m", "F", "getDebugAnimationDurationScale", "()F", "debugAnimationDurationScale", "n", "getLogTag", "logTag", "o", "getMaxBlurRadiusDp", "maxBlurRadiusDp", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "getBlurFilterCacheGranularityPx", "blurFilterCacheGranularityPx", "", "getCurrentEffectPlayTimeMs", "()J", "currentEffectPlayTimeMs", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OProtocolTextEffectTextView extends TextView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f14713q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f14714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f14715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f14716c;
    public ValueAnimator d;
    public long e;
    public CharSequence f;
    public CharSequence g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f14717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ls.c f14718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ls.c f14719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ls.c f14720k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14721l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f14722m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f14723n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f14724o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f14725p;

    @JvmOverloads
    public OProtocolTextEffectTextView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(TextPaint r5, BlendSpec r10) {
        Intrinsics.checkNotNullParameter(r5, "paint");
        Intrinsics.checkNotNullParameter(r10, "blend");
        if (r10 != BlendSpec.SRC_OVER) goto L7;
        r5.setBlendMode(null);
        return;
    L7:
        switch(c.f14730b[r10.ordinal()]) {
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L26;
            case 14: goto L25;
            case 15: goto L24;
            case 16: goto L23;
            case 17: goto L22;
            case 18: goto L21;
            case 19: goto L20;
            case 20: goto L19;
            case 21: goto L18;
            case 22: goto L17;
            case 23: goto L16;
            case 24: goto L15;
            case 25: goto L14;
            case 26: goto L13;
            case 27: goto L12;
            case 28: goto L11;
            case 29: goto L10;
            default: goto L9;
        };
    L10:
        BlendMode r11 = BlendMode.LUMINOSITY;
    L39:
        r5.setBlendMode(r11);
        return;
    L11:
        r11 = BlendMode.COLOR;
        goto L39
    L12:
        r11 = BlendMode.SATURATION;
        goto L39
    L13:
        r11 = BlendMode.HUE;
        goto L39
    L14:
        r11 = BlendMode.MULTIPLY;
        goto L39
    L15:
        r11 = BlendMode.EXCLUSION;
        goto L39
    L16:
        r11 = BlendMode.DIFFERENCE;
        goto L39
    L17:
        r11 = BlendMode.SOFT_LIGHT;
        goto L39
    L18:
        r11 = BlendMode.HARD_LIGHT;
        goto L39
    L19:
        r11 = BlendMode.COLOR_BURN;
        goto L39
    L20:
        r11 = BlendMode.COLOR_DODGE;
        goto L39
    L21:
        r11 = BlendMode.LIGHTEN;
        goto L39
    L22:
        r11 = BlendMode.DARKEN;
        goto L39
    L23:
        r11 = BlendMode.OVERLAY;
        goto L39
    L24:
        r11 = BlendMode.SCREEN;
        goto L39
    L25:
        r11 = BlendMode.MODULATE;
        goto L39
    L26:
        r11 = BlendMode.PLUS;
        goto L39
    L27:
        r11 = BlendMode.XOR;
        goto L39
    L28:
        r11 = BlendMode.DST_ATOP;
        goto L39
    L29:
        r11 = BlendMode.SRC_ATOP;
        goto L39
    L30:
        r11 = BlendMode.DST_OUT;
        goto L39
    L31:
        r11 = BlendMode.SRC_OUT;
        goto L39
    L32:
        r11 = BlendMode.DST_IN;
        goto L39
    L33:
        r11 = BlendMode.SRC_IN;
        goto L39
    L34:
        r11 = BlendMode.DST_OVER;
        goto L39
    L35:
        r11 = BlendMode.SRC_OVER;
        goto L39
    L36:
        r11 = BlendMode.DST;
        goto L39
    L37:
        r11 = BlendMode.SRC;
        goto L39
    L38:
        r11 = BlendMode.CLEAR;
        goto L39
    L9:
        throw new NoWhenBranchMatchedException();
    }

    private final ls.a getBlurFilterCache() {
        return (ls.a) this.f14715b.getValue();
    }

    public static void h(Drawable r5, Canvas r10, int r11, int r12) {
        int r13 = r10.save();
        r10.translate(r11, r12);     // Catch: Throwable -> L6
        r5.draw(r10);     // Catch: Throwable -> L6
        r10.restoreToCount(r13);
        return;
    L6:
        th = move-exception;
        r10.restoreToCount(r13);
        throw th;
    }

    public static int k(Drawable r5) {
        int r10 = r5.getBounds().height();
        Integer r11 = Integer.valueOf(r10);
        if (r10 > 0) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L9;
        return RangesKt.coerceAtLeast(r5.getIntrinsicHeight(), 0);
    L9:
        return r11.intValue();
    }

    public static int l(Drawable r5) {
        int r10 = r5.getBounds().width();
        Integer r11 = Integer.valueOf(r10);
        if (r10 > 0) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L9;
        return RangesKt.coerceAtLeast(r5.getIntrinsicWidth(), 0);
    L9:
        return r11.intValue();
    }

    public static js.d m(s r5, com.obric.oui.texteffects.runtime.b r10) {
        Intrinsics.checkNotNullParameter(r5, "spec");
        Intrinsics.checkNotNullParameter(r10, "frame");
        Iterator r11 = r5.e.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((f) r12).f18462a, r10.f14741a) == false) goto L4;
    L9:
        f r13 = (f) r12;
        if (r13 != null) goto L12;
        return null;
    L12:
        Iterator r14 = r13.f18464c.iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((e) r15).a(), r10.f14742b) == false) goto L14;
    L20:
        if ((r15 instanceof js.d) == true) goto L22;
        return null;
    L22:
        return (js.d) r15;
    L18:
        r15 = null;
        goto L20
    L8:
        r12 = null;
        goto L9
    }

    public static void q(ODimPointEffectTextView r5, s r10, String r11, boolean r12, CharSequence r13, CharSequence r14, CharSequence r15, int r16) {
        int r17 = 0;
        if ((r16 & 4) == 0) goto L6;
        r12 = false;
    L6:
        if ((r16 & 8) == 0) goto L9;
        r13 = null;
    L9:
        if ((r16 & 16) == 0) goto L12;
        r14 = null;
    L12:
        if ((r16 & 32) == 0) goto L14;
        r15 = null;
    L14:
        Intrinsics.checkNotNullParameter(r10, "spec");
        Intrinsics.checkNotNullParameter(r11, "effectName");
        r5.getLogTag();
        if (r12 == true) goto L25;
        if (r5.d == null) goto L19;
        r5.getLogTag();
    L19:
        ValueAnimator r18 = r5.d;
        if (r18 == null) goto L23;
        r18.cancel();
    L23:
        r5.d = null;
        r5.e = 0;
    L32:
        r5.f14716c = r10;
        r5.f14721l = r11;
        r5.e = 0;
        r5.f = r13;
        r5.g = r14;
        r5.f14717h = r15;
        r5.f14719j = null;
        r5.f14720k = null;
        Intrinsics.checkNotNullParameter(r11, "effectName");
        Intrinsics.checkNotNullParameter(r10, "spec");
        switch(r11.hashCode()) {
            case -1253981585: goto L52;
            case -682587753: goto L48;
            case -208065901: goto L44;
            case 1101148556: goto L40;
            case 1810371957: goto L36;
            default: goto L53;
        };
    L53:
        ODimPointEffectTextView.DimPointMode r19 = ODimPointEffectTextView.DimPointMode.NONE;
    L55:
        r5.f14698r = r19;
        r5.w();
        Ref.BooleanRef r20 = new Ref.BooleanRef();
        ValueAnimator r21 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r21.setDuration(RangesKt.coerceAtLeast(MathKt.roundToInt(r10.f18480c * r5.f14722m), 1));
        r21.setInterpolator(new LinearInterpolator());
        if (Intrinsics.areEqual(r10.d, n.d) == false) goto L58;
        r17 = -1;
    L58:
        r21.setRepeatCount(r17);
        r21.setRepeatMode(1);
        r21.addUpdateListener(new com.google.android.material.appbar.b(3, r5, r10));
        r21.addListener(new d(r20, r5, r10));
        r21.start();
        r5.d = r21;
        r5.invalidate();
        return;
    L36:
        if (r11.equals("generate") == false) goto L53;
        r19 = ODimPointEffectTextView.DimPointMode.GENERATE;
        goto L55
    L40:
        if (r11.equals("rewrite") == false) goto L53;
        r19 = ODimPointEffectTextView.DimPointMode.REWRITE;
        goto L55
    L44:
        if (r11.equals("prompt_exit_to_generate") == false) goto L53;
        r19 = ODimPointEffectTextView.DimPointMode.PROMPT_EXIT_TO_GENERATE;
        goto L55
    L48:
        if (r11.equals("pending") == false) goto L53;
        r19 = ODimPointEffectTextView.DimPointMode.PENDING;
        goto L55
    L52:
        if (r11.equals("prompt_switch") == false) goto L53;
        r19 = ODimPointEffectTextView.DimPointMode.PROMPT_SWITCH;
        goto L55
    L25:
        if (r5.d == null) goto L27;
        r5.getLogTag();
    L27:
        ValueAnimator r22 = r5.d;
        if (r22 == null) goto L31;
        r22.cancel();
    L31:
        r5.d = null;
        goto L32
    }

    public final void b(TextPaint r5, fj.a r10, ls.c r11) {
        Intrinsics.checkNotNullParameter(r5, "paint");
        Intrinsics.checkNotNullParameter(r10, "fill");
        Intrinsics.checkNotNullParameter(r11, "cache");
        if (Intrinsics.areEqual(r10, l.f18471c) == false) goto L6;
        r5.setShader(null);
        r5.setColor(getCurrentTextColor());
        return;
    L6:
        if ((r10 instanceof k) == false) goto L10;
        r5.setShader(c(r11, (k) r10));
        return;
    }

    public LinearGradient c(ls.c r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, "cache");
        Intrinsics.checkNotNullParameter(r11, "fill");
        float r12 = r10.f19789h;
        if (r12 > 0.01f) goto L6;
        return null;
    L6:
        float r5 = r10.f19790i;
        int[] r13 = ks.b.f19477a;
        Shader.TileMode r14 = Shader.TileMode.CLAMP;
        return new LinearGradient(r5, 0.0f, r5 + r12, 0.0f, r13, ks.b.f19478b, r14);
    }

    public ls.c d(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        return io.reactivex.exceptions.a.k(r10, getPaint(), e(), getEllipsize(), new OProtocolTextEffectTextView$buildTextCache$1(this), OProtocolTextEffectTextView$buildTextCache$2.INSTANCE);
    }

    public final float e() {
        return RangesKt.coerceAtLeast((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), 0.0f);
    }

    public final float f(float r5) {
        float r10 = e();
        int r11 = getGravity() & 7;
        float r12 = getCompoundPaddingLeft();
        if (r11 == 1) goto L11;
        if (r11 == 5) goto L12;
        if (r11 == 8388613) goto L12;
        return r12;
    L12:
        return r12 + (r10 - r5);
    L11:
        return androidx.constraintlayout.motion.widget.a.a(r10, r5, 2.0f, r12);
    }

    public final float g(com.obric.oui.texteffects.runtime.b r5, f8.b r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        boolean r11 = r10 instanceof g;
        Function1 r12 = this.f14714a;
        if (r11 == false) goto L6;
        return ((Number) r12.invoke(Float.valueOf(((g) r10).f18465a))).floatValue();
    L6:
        if ((r10 instanceof h) == false) goto L9;
        return ((h) r10).f18466a;
    L9:
        return ((Number) r12.invoke(Float.valueOf(0.0f))).floatValue();
    }

    public final String getActiveEffectName() {
        return this.f14721l;
    }

    public float getBlurFilterCacheGranularityPx() {
        return this.f14725p;
    }

    public final long getCurrentEffectPlayTimeMs() {
        return this.e;
    }

    public final float getDebugAnimationDurationScale() {
        return this.f14722m;
    }

    public String getLogTag() {
        return this.f14723n;
    }

    public float getMaxBlurRadiusDp() {
        return this.f14724o;
    }

    public final void i(Canvas r18, TextPaint r19, ls.c r20, float r21, float r22, float r23, float r24, r r25, BlendMode r26, Xfermode r27) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        Intrinsics.checkNotNullParameter(r19, "paint");
        Intrinsics.checkNotNullParameter(r20, "cache");
        Intrinsics.checkNotNullParameter(r25, "selector");
        float r5 = r20.f19789h;
        float r12 = (r5 * r24) + r23;
        r25.getClass();
        float r10 = RangesKt.coerceAtLeast(r5 * 0.3f, ((Number) this.f14714a.invoke(Float.valueOf(16.0f))).floatValue());
        getLogTag();
        Paint r11 = ls.b.a(r19);
        float r13 = getBaseline();
        float r14 = r12 + r10;
        float r15 = getHeight();
        if (r25.e == Direction.RightToLeft) goto L6;
        boolean r16 = true;
    L5:
        boolean r17 = r16;
        Intrinsics.checkNotNullParameter(r18, "canvas");
        Intrinsics.checkNotNullParameter(r19, "paint");
        Intrinsics.checkNotNullParameter(r20, "cache");
        int r28 = r18.saveLayer(r21, 0.0f, r22, r15, r11);
        r19.setBlendMode(null);     // Catch: Throwable -> L19
        r19.setXfermode(null);     // Catch: Throwable -> L19
        r19.setMaskFilter(null);     // Catch: Throwable -> L19
        char[] r29 = r20.f19788c;     // Catch: Throwable -> L19
        int r110 = r28;
        r18.drawText(r29, 0, r29.length, r23, r13, r19);     // Catch: Throwable -> L13
        if (r17 == false) goto L15;
        LinearGradient r30 = ls.b.d;     // Catch: Throwable -> L13
    L16:
        Matrix r31 = ls.b.f19785c;     // Catch: Throwable -> L13
        r31.reset();     // Catch: Throwable -> L13
        r31.setScale(RangesKt.coerceAtLeast(r14 - r12, 0.001f), 1.0f);     // Catch: Throwable -> L13
        r31.postTranslate(r12, 0.0f);     // Catch: Throwable -> L13
        r30.setLocalMatrix(r31);     // Catch: Throwable -> L13
        Paint r32 = ls.b.f19784b;     // Catch: Throwable -> L13
        r32.setShader(r30);     // Catch: Throwable -> L13
        r18.drawRect(r21, 0.0f, r22, r15, r32);     // Catch: Throwable -> L13
        r32.setShader(null);
        r18.restoreToCount(r110);
        r19.setBlendMode(r26);
        r19.setXfermode(r27);
        return;
    L15:
        r30 = ls.b.e;     // Catch: Throwable -> L13
    L13:
        th = th;
        Shader r33 = null;
    L21:
        ls.b.f19784b.setShader(r33);
        r18.restoreToCount(r110);
        r19.setBlendMode(r26);
        r19.setXfermode(r27);
        throw th;
    L19:
        th = th;
        r33 = null;
        r110 = r28;
        goto L21
    L6:
        r16 = false;
        goto L5
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8371. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public final void j(android.graphics.Canvas r37, js.d r38, com.obric.oui.texteffects.runtime.b r39) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0055: MOVE (r15v0 ?? I:??[OBJECT, ARRAY]) = (r3v11 ls.c) A[DECLARE_VAR] in method: com.obric.oui.texteffects.OProtocolTextEffectTextView.j(android.graphics.Canvas, js.d, com.obric.oui.texteffects.runtime.b):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 837
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.texteffects.OProtocolTextEffectTextView.j(android.graphics.Canvas, js.d, com.obric.oui.texteffects.runtime.b):void");
    }

    public final BlurMaskFilter n(float r5) {
        ls.a r10 = getBlurFilterCache();
        r10.getClass();
        if (Float.isNaN(r5) == false) goto L5;
        return null;
    L5:
        if (Float.isInfinite(r5) == false) goto L7;
        return null;
    L7:
        if (r5 <= 0.01f) goto L25;
        float r11 = RangesKt.coerceAtMost(r5, r10.f19780a);
        float r12 = r10.f19781b;
        int r13 = RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(r11, r12) / r12), 1);
        SparseArray r14 = r10.f19782c;
        BlurMaskFilter r15 = (BlurMaskFilter) r14.get(r13);
        if (r15 == null) goto L20;
        return r15;
    L20:
        BlurMaskFilter r16 = new BlurMaskFilter(r13 * r12, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r16 == null) goto L26;
        r14.put(r13, r16);
        return r16;
    L26:
        return null;
    L15:
        r16 = null;
        goto L16
    L25:
        return null;
    }

    public final boolean o(ls.c r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "cache");
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        if (Intrinsics.areEqual(r5.f19786a, r10) == false) goto L11;
        float r11 = e();
        if (r5.e != r11) goto L11;
        TextUtils.TruncateAt r12 = getEllipsize();
        if (r5.f != r12) goto L11;
        float r13 = getPaint().getTextSize();
        if (r5.g != r13) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        getLogTag();
        r();
        getBlurFilterCache().f19782c.clear();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        s r5 = this.f14716c;
        if (r5 != null) goto L6;
        super.onDraw(r12);
        return;
    L6:
        LruCache r10 = com.obric.oui.texteffects.runtime.e.f14755a;
        com.obric.oui.texteffects.runtime.c r11 = com.obric.oui.texteffects.runtime.e.d(r5, this.e);
        getLogTag();
        Intrinsics.checkNotNullParameter(r12, "canvas");
        Drawable[] r13 = getCompoundDrawables();
        int r14 = getCompoundPaddingLeft();
        int r15 = getCompoundPaddingTop();
        int r16 = getWidth() - getCompoundPaddingRight();
        int r17 = getHeight() - getCompoundPaddingBottom();
        int r18 = RangesKt.coerceAtLeast(r16 - r14, 0);
        int r19 = RangesKt.coerceAtLeast(r17 - r15, 0);
        Drawable r20 = r13[0];
        if (r20 == null) goto L10;
        h(r20, r12, getPaddingLeft(), ((r19 - k(r20)) / 2) + r15);
    L10:
        Drawable r21 = r13[1];
        if (r21 == null) goto L14;
        h(r21, r12, ((r18 - l(r21)) / 2) + r14, getPaddingTop());
    L14:
        Drawable r22 = r13[2];
        if (r22 == null) goto L18;
        h(r22, r12, (getWidth() - getPaddingRight()) - l(r22), ((r19 - k(r22)) / 2) + r15);
    L18:
        Drawable r23 = r13[3];
        if (r23 == null) goto L22;
        h(r23, r12, ((r18 - l(r23)) / 2) + r14, (getHeight() - getPaddingBottom()) - k(r23));
    L22:
        int r24 = r12.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        Iterator r25 = r11.f14753c.iterator();     // Catch: Throwable -> L31
    L25:
        if (r25.hasNext() == false) goto L33;
        com.obric.oui.texteffects.runtime.b r26 = (com.obric.oui.texteffects.runtime.b) r25.next();     // Catch: Throwable -> L31
        js.d r27 = m(r5, r26);     // Catch: Throwable -> L31
        if (r27 == null) goto L25;
        j(r12, r27, r26);     // Catch: Throwable -> L31
        goto L25
    L33:
        r12.restoreToCount(r24);
        return;
    L31:
        th = move-exception;
        r12.restoreToCount(r24);
        throw th;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        getLogTag();
        this.f14718i = null;
        this.f14719j = null;
        this.f14720k = null;
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r5, int r10, int r11, int r12) {
        super.onTextChanged(r5, r10, r11, r12);
        this.f14718i = null;
    }

    public void p() {
    }

    public void r() {
        getLogTag();
        if (this.d == null) goto L5;
        getLogTag();
    L5:
        ValueAnimator r5 = this.d;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        this.d = null;
        this.f14716c = null;
        this.f14721l = "none";
        this.e = 0;
        this.f = null;
        this.g = null;
        this.f14717h = null;
        this.f14719j = null;
        this.f14720k = null;
        p();
        invalidate();
    }

    public void setDebugAnimationDurationScale(float r5) {
        if (Float.isNaN(r5) == false) goto L5;
    L8:
        float r10 = 1.0f;
    L10:
        if (this.f14722m != r10) goto L12;
        return;
    L12:
        this.f14722m = r10;
        getLogTag();
        return;
    L5:
        if (Float.isInfinite(r5) == true) goto L8;
        r10 = RangesKt.coerceIn(r5, 0.1f, 10.0f);
        goto L10
    }

    @JvmOverloads
    public OProtocolTextEffectTextView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OProtocolTextEffectTextView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14714a = new OProtocolTextEffectTextView$dp$1(this);
        this.f14715b = LazyKt.lazy(new OProtocolTextEffectTextView$blurFilterCache$2(this));
        this.f14721l = "none";
        this.f14722m = 1.0f;
        this.f14723n = "ProtocolTextEffectView";
        this.f14724o = 16.0f;
        this.f14725p = 0.5f;
    }
}
