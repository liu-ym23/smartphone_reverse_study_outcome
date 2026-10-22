package com.obric.oui.material;

import ai.j0;
import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.ColorUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oui.R$styleable;
import com.obric.oui.graphic.BlendMode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u0000 ³\u00012\u00020\u0001:\u0004´\u0001µ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0018\u00010\rR\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dJO\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001f\u0010\"J\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001d\u0010*\u001a\u00020\u000f2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u000f¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020#H\u0016¢\u0006\u0004\b-\u0010.J5\u00104\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020#H\u0007¢\u0006\u0004\b4\u00105J=\u00107\u001a\u00020\u000f2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010'2\b\b\u0002\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020#H\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u000f2\u0006\u0010\b\u001a\u000209H\u0014¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u000fH\u0016¢\u0006\u0004\b@\u0010\u0003J\u0017\u0010C\u001a\u00020#2\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020#2\u0006\u0010B\u001a\u00020AH\u0014¢\u0006\u0004\bE\u0010DJ\u0017\u0010G\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u0001H\u0003¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<H\u0003¢\u0006\u0004\bI\u0010?J\u0017\u0010K\u001a\u00020#2\u0006\u0010J\u001a\u00020(H\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u0010O\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bO\u0010PJ'\u0010U\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020/H\u0002¢\u0006\u0004\bU\u0010VJ7\u0010Y\u001a\u00020#2\u0006\u0010X\u001a\u00020W2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010B\u001a\u00020A2\u0006\u0010T\u001a\u00020/H\u0002¢\u0006\u0004\bY\u0010ZJG\u0010_\u001a\u00020#2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010[\u001a\u00020#2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010'2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010'H\u0002¢\u0006\u0004\b_\u0010`JG\u0010c\u001a\u00020#2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010[\u001a\u00020#2\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010'2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010'H\u0002¢\u0006\u0004\bc\u0010`JC\u0010g\u001a\u00020#2\u0006\u0010X\u001a\u00020W2\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010[\u001a\u00020#2\b\u0010e\u001a\u0004\u0018\u00010d2\b\u0010f\u001a\u0004\u0018\u00010dH\u0002¢\u0006\u0004\bg\u0010hJ\u0017\u0010i\u001a\u00020#2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bi\u0010DJ\u001f\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00122\u0006\u0010k\u001a\u00020#H\u0002¢\u0006\u0004\bl\u0010mJ\u001f\u0010n\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00122\u0006\u0010k\u001a\u00020#H\u0002¢\u0006\u0004\bn\u0010mR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010oR\u0018\u0010!\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010oR\u0016\u0010p\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010qR\u0016\u0010s\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010qR\u0016\u0010t\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010qR\u0016\u0010u\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010qR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010xR#\u0010{\u001a\u00020z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u00106\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b6\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010qR\u0018\u0010\u008e\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010qR\u001f\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b)\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010\u0093\u0001\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0095\u0001\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R\u0018\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R/\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009a\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010\u009f\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u009f\u0001\u0010q\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¤\u0001\u001a\u00020\u00128\u0006¢\u0006\u000f\n\u0005\b¤\u0001\u0010q\u001a\u0006\b¥\u0001\u0010¡\u0001R'\u0010¦\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010'0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R'\u0010¨\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010'0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010§\u0001R'\u0010©\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010'0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010§\u0001R'\u0010ª\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010'0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010§\u0001R!\u0010«\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010d0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R!\u0010\u00ad\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010¯\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010®\u0001R'\u0010°\u0001\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b°\u0001\u0010\u008b\u0001\u001a\u0005\b±\u0001\u0010.\"\u0005\b²\u0001\u0010&¨\u0006¶\u0001"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "()V", "Landroid/graphics/drawable/Drawable$ConstantState;", "getConstantState", "()Landroid/graphics/drawable/Drawable$ConstantState;", "Landroid/content/res/Resources;", "r", "Lorg/xmlpull/v1/XmlPullParser;", "parser", "Landroid/util/AttributeSet;", "attrs", "Landroid/content/res/Resources$Theme;", "theme", "", "inflate", "(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V", "", "normal", "pressed", "selected", "checked", "hover", "disabled", "setSolidColors", "(IIIIII)V", "Landroid/content/res/ColorStateList;", "solidColors", "(Landroid/content/res/ColorStateList;)V", "width", "setStrokeConfigs", "(IIIIIII)V", "strokeColors", "(ILandroid/content/res/ColorStateList;)V", "", "enable", "setEnableShadow", "(Z)V", "", "Les/a;", "shadowConfigs", "setShadowConfigs", "([Les/a;)V", "endAnimation", "isStateful", "()Z", "Lcom/obric/oui/material/c;", "materialConfig", "srcType", "drawMode", "applyImmediately", "setMaterialConfig", "(Lcom/obric/oui/material/c;IIZ)V", "materialConfigs", "setMaterialConfigs", "([Lcom/obric/oui/material/c;IIZ)V", "Landroid/graphics/Rect;", "onBoundsChange", "(Landroid/graphics/Rect;)V", "Landroid/graphics/Canvas;", "canvas", SVGRenderEngine.DRAW, "(Landroid/graphics/Canvas;)V", "jumpToCurrentState", "", "stateSet", "setState", "([I)Z", "onStateChange", "template", "copyGradientInternalStateFrom", "(Landroid/graphics/drawable/GradientDrawable;)V", "drawMultiLayerShadow", "config", "isShadowValid", "(Les/a;)Z", "Landroid/graphics/Path;", SVGRenderEngine.PATH, "clipOutShadowPath", "(Landroid/graphics/Canvas;Landroid/graphics/Path;)V", "", "effectParams", "index", "material", "setMaterialToEffectObjectIfNotInit", "(Ljava/lang/Object;ILcom/obric/oui/material/c;)V", "Landroid/view/View;", "view", "processMaterialOnStateChange", "(Landroid/view/View;Ljava/lang/Object;I[ILcom/obric/oui/material/c;)Z", "enableAnimate", "Lcom/obric/oui/color/a;", "fromBlendConfigs", "toBlendConfigs", "updateBlendConfigs", "(Ljava/lang/Object;IZ[Lcom/obric/oui/color/a;[Lcom/obric/oui/color/a;)Z", "fromOverlayBlendConfigs", "toOverlayBlendConfigs", "updateOverlayBlendConfigs", "Lcom/obric/oui/color/d;", "fromStrokeConfig", "toStrokeConfig", "updateStrokeConfig", "(Landroid/view/View;Ljava/lang/Object;IZLcom/obric/oui/color/d;Lcom/obric/oui/color/d;)Z", "processSolidAndStrokeOnStateChange", "toColor", "animate", "updateSolidColor", "(IZ)V", "updateStrokeColor", "Landroid/content/res/ColorStateList;", "strokeWidth", "I", "targetSolidColor", "targetStrokeColor", "animatedSolidColor", "animatedStrokeColor", "Landroid/animation/ValueAnimator;", "colorAnimator", "Landroid/animation/ValueAnimator;", "strokeAnimator", "", "animDuration", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "Landroid/view/animation/LinearInterpolator;", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "lastStateSet", "[I", "enableShadow", "Z", "[Lcom/obric/oui/material/c;", "materialSrcType", "materialDrawMode", "[Les/a;", "Landroid/graphics/Paint;", "shadowPaint", "Landroid/graphics/Paint;", "shadowClipPath", "Landroid/graphics/Path;", "shadowDrawPath", "Landroid/graphics/RectF;", "tmpRectF", "Landroid/graphics/RectF;", "tmpShadowRectF", "isCallbackInitArray", "[Ljava/lang/Boolean;", "()[Ljava/lang/Boolean;", "setCallbackInitArray", "([Ljava/lang/Boolean;)V", "requireApiVersion", "getRequireApiVersion", "()I", "setRequireApiVersion", "(I)V", "envMaterialApiVersion", "getEnvMaterialApiVersion", "currentBlendConfigsArray", "[[Lcom/obric/oui/color/a;", "drawBlendConfigsArray", "currentOverlayBlendConfigsArray", "drawOverlayBlendConfigsArray", "currentStrokeConfigArray", "[Lcom/obric/oui/color/d;", "blendAnimatorArray", "[Landroid/animation/ValueAnimator;", "overlayBlendAnimatorArray", "enableStateChangeTransition", "getEnableStateChangeTransition", "setEnableStateChangeTransition", "Companion", "com/obric/oui/material/l", "com/obric/oui/material/m", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMaterialDrawable extends GradientDrawable {
    public static final l Companion = null;
    public static final boolean DEBUGGABLE = false;
    private static final int MAX_MATERIAL_CONFIG_COUNT = 2;
    public static final String TAG = "OMaterialDrawable";
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private ValueAnimator[] blendAnimatorArray;
    private ValueAnimator colorAnimator;
    private com.obric.oui.color.a[][] currentBlendConfigsArray;
    private com.obric.oui.color.a[][] currentOverlayBlendConfigsArray;
    private com.obric.oui.color.d[] currentStrokeConfigArray;
    private com.obric.oui.color.a[][] drawBlendConfigsArray;
    private com.obric.oui.color.a[][] drawOverlayBlendConfigsArray;
    private boolean enableShadow;
    private boolean enableStateChangeTransition;
    private final int envMaterialApiVersion;
    private Boolean[] isCallbackInitArray;
    private int[] lastStateSet;
    private c[] materialConfigs;
    private int materialDrawMode;
    private int materialSrcType;
    private ValueAnimator[] overlayBlendAnimatorArray;
    private int requireApiVersion;
    private final Path shadowClipPath;
    private es.a[] shadowConfigs;
    private final Path shadowDrawPath;
    private final Paint shadowPaint;
    private ColorStateList solidColors;
    private ValueAnimator strokeAnimator;
    private ColorStateList strokeColors;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;
    private final RectF tmpRectF;
    private final RectF tmpShadowRectF;

    static {
        Companion = new l();
    }

    public OMaterialDrawable() {
        this.animDuration = Token$Duration.OUI_ANIMATION_DURATION_SHORT_3.getDuration();
        this.animInterpolator = new LinearInterpolator();
        this.materialSrcType = 2;
        this.materialDrawMode = 1;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.shadowPaint = r5;
        this.shadowClipPath = new Path();
        this.shadowDrawPath = new Path();
        this.tmpRectF = new RectF();
        this.tmpShadowRectF = new RectF();
        Boolean r10 = Boolean.FALSE;
        this.isCallbackInitArray = new Boolean[]{r10, r10};
        this.requireApiVersion = 1;
        this.envMaterialApiVersion = n.f();
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new com.obric.oui.color.d[2];
        this.blendAnimatorArray = new ValueAnimator[2];
        this.overlayBlendAnimatorArray = new ValueAnimator[2];
        this.enableStateChangeTransition = true;
    }

    public static /* synthetic */ void a(com.obric.oui.color.d r5, com.obric.oui.color.d r10, OMaterialDrawable r11, View r12, ValueAnimator r13) {
        m111updateStrokeConfig$lambda29$lambda28(r5, r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$copyGradientInternalStateFrom(OMaterialDrawable r5, GradientDrawable r10) {
        r5.copyGradientInternalStateFrom(r10);
    }

    public static final /* synthetic */ void access$setEnableShadow$p(OMaterialDrawable r5, boolean r10) {
        r5.enableShadow = r10;
    }

    public static /* synthetic */ void b(OMaterialDrawable r5, ValueAnimator r10) {
        m109updateSolidColor$lambda31$lambda30(r5, r10);
    }

    public static /* synthetic */ void c(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, OMaterialDrawable r12, int r13, Object r14, ValueAnimator r15) {
        m108updateOverlayBlendConfigs$lambda26$lambda25(r10, r11, r14, r12, r13, r15);
    }

    private final void clipOutShadowPath(Canvas r5, Path r10) {
        r5.clipOutPath(r10);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void copyGradientInternalStateFrom(GradientDrawable r5) {
        Field r10 = GradientDrawable.class.getDeclaredField("mGradientState");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        r10.set(this, r10.get(r5));     // Catch: Exception -> L4
        return;
    }

    public static /* synthetic */ void d(OMaterialDrawable r5, ValueAnimator r10) {
        m110updateStrokeColor$lambda33$lambda32(r5, r10);
    }

    @RequiresApi(24)
    private final void drawMultiLayerShadow(Canvas r17) {
        es.a[] r5 = this.shadowConfigs;
        int r10 = 0;
        if (r5 != null) goto L20;
        c[] r11 = this.materialConfigs;
        if (r11 != null) goto L7;
    L6:
        r5 = null;
    L17:
        if (r5 != null) goto L20;
        return;
    L7:
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        c r14 = r11[r13];
        if (r14.f13613i != null) goto L14;
        r13 = r13 + 1;
    L14:
        if (r14 == null) goto L6;
        r5 = r14.f13613i;
        goto L17
    L13:
        r14 = null;
    L20:
        if (r5.length != 0) goto L22;
        return;
    L22:
        Rect r15 = getBounds();
        if (r15.isEmpty() == false) goto L25;
        return;
    L25:
        this.tmpRectF.set(r15);
        int r16 = getShape();
        float[] r18 = getCornerRadii();
        float r19 = getCornerRadius();
        this.shadowClipPath.reset();
        if (r16 != 1) goto L28;
        this.shadowClipPath.addOval(this.tmpRectF, Path.Direction.CW);
    L34:
        int r110 = r5.length;
    L35:
        if (r10 >= r110) goto L53;
        es.a r111 = r5[r10];
        r10 = r10 + 1;
        if (isShadowValid(r111) == false) goto L35;
        int r112 = r17.save();
        clipOutShadowPath(r17, this.shadowClipPath);
        this.tmpShadowRectF.set(this.tmpRectF);
        float r113 = r17.getDensity() / 160.0f;
        this.tmpShadowRectF.offset(com.lynx.tasm.utils.a.v(r111.f16858a, r113), com.lynx.tasm.utils.a.v(r111.f16859b, r113));
        RectF r20 = this.tmpShadowRectF;
        float r114 = r111.e;
        r20.inset(-r114, -r114);
        this.shadowPaint.setColor(r111.d);
        Paint r21 = this.shadowPaint;
        float r115 = r111.f16860c;
        if (r115 <= 0.0f) goto L42;
        BlurMaskFilter r116 = new BlurMaskFilter(r115, BlurMaskFilter.Blur.NORMAL);
    L43:
        r21.setMaskFilter(r116);
        if (r16 != 1) goto L46;
        r17.drawOval(this.tmpShadowRectF, this.shadowPaint);
    L52:
        r17.restoreToCount(r112);
        goto L35
    L46:
        if (r18 == null) goto L49;
        this.shadowDrawPath.reset();
        this.shadowDrawPath.addRoundRect(this.tmpShadowRectF, r18, Path.Direction.CW);
        r17.drawPath(this.shadowDrawPath, this.shadowPaint);
        goto L52
    L49:
        if (r19 <= 0.0f) goto L51;
        r17.drawRoundRect(this.tmpShadowRectF, r19, r19, this.shadowPaint);
        goto L52
    L51:
        r17.drawRect(this.tmpShadowRectF, this.shadowPaint);
        goto L52
    L42:
        r116 = null;
        goto L43
    L53:
        return;
    L28:
        if (r18 == null) goto L31;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r18, Path.Direction.CW);
        goto L34
    L31:
        if (r19 <= 0.0f) goto L33;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r19, r19, Path.Direction.CW);
        goto L34
    L33:
        this.shadowClipPath.addRect(this.tmpRectF, Path.Direction.CW);
        goto L34
    }

    public static /* synthetic */ void e(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10, OMaterialDrawable r11, int r12, Object r13, ValueAnimator r14) {
        m107updateBlendConfigs$lambda24$lambda23(r5, r10, r11, r12, r13, r14);
    }

    private final boolean isShadowValid(es.a r5) {
        if (r5.d != 0) goto L6;
        return false;
    L6:
        if (r5.f16858a == 0.0f) goto L8;
    L14:
        return true;
    L8:
        if (r5.f16859b != 0.0f) goto L14;
        if (r5.f16860c != 0.0f) goto L14;
        if (r5.e != 0.0f) goto L14;
        return false;
    }

    private final boolean processMaterialOnStateChange(View r15, Object r16, int r17, int[] r18, c r19) {
        setColor(0);
        this.targetSolidColor = 0;
        int[] r11 = this.lastStateSet;
        if (this.isCallbackInitArray[r17].booleanValue() == true) goto L21;
        n.q(this.materialSrcType, this.materialDrawMode, r16);
        Float r5 = r19.f13612h;
        if (r5 == null) goto L8;
        n.n(r16, r5.floatValue(), 1.0f, 0, 0, 1.0f);
    L8:
        com.obric.oui.fluid.a r10 = r19.f13614j;
        if (r10 == null) goto L12;
        n.s(r16, true, r10.f13225a);
    L12:
        es.a[] r12 = r19.f13613i;
        if (r12 == null) goto L21;
        es.a r13 = (es.a) ArraysKt.firstOrNull(r12);
        if (r13 == null) goto L21;
        Paint r14 = this.shadowPaint;
        Intrinsics.checkNotNullParameter(r13, "shadowConfig");
        es.b r20 = r13.a();
        if (r20.f != (-1)) goto L20;
        r20.f = BlendMode.SRC_OVER.getPorterDuffMode();
    L20:
        int r21 = r20.f;
        int[] r22 = {r20.d, r21};
        r13.f = r21;
        n.m(Arrays.copyOf(r22, 2), r14);
    L21:
        cs.a r23 = r19.f13610b;
        com.obric.oui.color.d r110 = null;
        if (r23 != null) goto L24;
        com.obric.oui.color.a[] r24 = null;
    L25:
        if (r24 != null) goto L27;
        r24 = r19.f13611c;
    L27:
        com.obric.oui.color.a[] r25 = r24;
        if (r25 == null) goto L37;
        com.obric.oui.color.a[] r26 = this.drawBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L35;
        if (r23 == null) goto L35;
        if (r11 == null) goto L35;
        if (r26 == null) goto L35;
        boolean r27 = true;
    L36:
        updateBlendConfigs(r16, r17, r27, r26, r25);
    L35:
        r27 = false;
    L37:
        cs.a r28 = r19.f;
        if (r28 != null) goto L40;
        com.obric.oui.color.a[] r29 = null;
    L41:
        if (r29 == null) goto L49;
        com.obric.oui.color.a[] r30 = this.drawOverlayBlendConfigsArray[r17];
        if (this.enableStateChangeTransition == false) goto L47;
        if (r11 == null) goto L47;
        if (r30 == null) goto L47;
        boolean r31 = true;
    L48:
        updateOverlayBlendConfigs(r16, r17, r31, r30, r29);
    L47:
        r31 = false;
    L49:
        cs.c r32 = r19.d;
        if (r32 == null) goto L60;
        Intrinsics.checkNotNullParameter(r18, "stateSet");
        int[][] r33 = r32.f16504a;
        int r34 = r33.length;
        int r35 = 0;
    L53:
        if (r35 >= r34) goto L59;
        int r36 = r35 + 1;
        if (StateSet.stateSetMatches(r33[r35], r18) == true) goto L56;
        r35 = r36;
        goto L53
    L56:
        com.obric.oui.color.d r37 = r32.f16505b[r35];
    L57:
        r110 = r37;
        goto L60
    L59:
        r37 = r32.f16506c;
    L60:
        if (r110 != null) goto L62;
        r110 = r19.e;
    L62:
        if (r110 == null) goto L71;
        com.obric.oui.color.d r38 = this.currentStrokeConfigArray[r17];
        if (this.enableStateChangeTransition == false) goto L69;
        if (r32 == null) goto L69;
        if (r11 == null) goto L69;
        if (r38 == null) goto L69;
        boolean r39 = true;
    L70:
        updateStrokeConfig(r15, r16, r17, r39, r38, r110);
    L69:
        r39 = false;
    L71:
        this.lastStateSet = (int[]) r18.clone();
        this.isCallbackInitArray[r17] = Boolean.TRUE;
        return false;
    L40:
        r29 = cs.a.b(r28, r18);
        goto L41
    L24:
        r24 = cs.a.b(r23, r18);
        goto L25
    }

    private final boolean processSolidAndStrokeOnStateChange(int[] r10) {
        ColorStateList r5 = this.solidColors;
        boolean r11 = false;
        if (r5 != null) goto L5;
        int r12 = 0;
    L6:
        ColorStateList r13 = this.solidColors;
        if (r13 != null) goto L9;
        int r14 = 0;
    L11:
        if (r14 == this.targetSolidColor) goto L16;
        if (r14 != r12) goto L14;
        boolean r15 = true;
    L15:
        updateSolidColor(r14, r15);
        this.targetSolidColor = r14;
        boolean r16 = true;
    L17:
        ColorStateList r17 = this.strokeColors;
        if (r17 != null) goto L20;
        int r18 = 0;
    L21:
        ColorStateList r19 = this.strokeColors;
        if (r19 != null) goto L24;
        int r20 = 0;
    L26:
        if (r20 == this.targetStrokeColor) goto L31;
        if (r20 != r18) goto L29;
        r11 = true;
    L29:
        updateStrokeColor(r20, r11);
        this.targetStrokeColor = r20;
        return true;
    L31:
        return r16;
    L24:
        r20 = r19.getColorForState(r10, r18);
        goto L26
    L20:
        r18 = r17.getDefaultColor();
        goto L21
    L14:
        r15 = false;
        goto L15
    L16:
        r16 = false;
        goto L17
    L9:
        r14 = r13.getColorForState(r10, r12);
        goto L11
    L5:
        r12 = r5.getDefaultColor();
        goto L6
    }

    public static /* synthetic */ void setMaterialConfig$default(OMaterialDrawable r5, c r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 2) == 0) goto L7;
        r11 = 2;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r12 = 1;
    L10:
        if ((r14 & 8) == 0) goto L12;
        r13 = true;
    L12:
        r5.setMaterialConfig(r10, r11, r12, r13);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfig");
    }

    public static /* synthetic */ void setMaterialConfigs$default(OMaterialDrawable r5, c[] r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 2) == 0) goto L7;
        r11 = 2;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r12 = 1;
    L10:
        if ((r14 & 8) == 0) goto L12;
        r13 = true;
    L12:
        r5.setMaterialConfigs(r10, r11, r12, r13);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    private final void setMaterialToEffectObjectIfNotInit(Object r10, int r11, c r12) {
        if (this.isCallbackInitArray[r11].booleanValue() == true) goto L23;
        n.q(this.materialSrcType, this.materialDrawMode, r10);
        Float r5 = r12.f13612h;
        if (r5 == null) goto L8;
        n.n(r10, r5.floatValue(), 1.0f, 0, 0, 1.0f);
    L8:
        com.obric.oui.fluid.a r13 = r12.f13614j;
        if (r13 == null) goto L12;
        n.s(r10, true, r13.f13225a);
    L12:
        es.a[] r14 = r12.f13613i;
        if (r14 == null) goto L21;
        es.a r15 = (es.a) ArraysKt.firstOrNull(r14);
        if (r15 == null) goto L21;
        Paint r16 = this.shadowPaint;
        Intrinsics.checkNotNullParameter(r15, "shadowConfig");
        es.b r17 = r15.a();
        if (r17.f != (-1)) goto L20;
        r17.f = BlendMode.SRC_OVER.getPorterDuffMode();
    L20:
        int r18 = r17.f;
        int[] r19 = {r17.d, r18};
        r15.f = r18;
        n.m(Arrays.copyOf(r19, 2), r16);
    L21:
        this.isCallbackInitArray[r11] = Boolean.TRUE;
        return;
    }

    public static /* synthetic */ void setSolidColors$default(OMaterialDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if (r18 != null) goto L26;
        if ((r17 & 2) == 0) goto L6;
        int r5 = r11;
    L8:
        if ((r17 & 4) == 0) goto L10;
        int r19 = r11;
    L12:
        if ((r17 & 8) == 0) goto L14;
        int r20 = r19;
    L16:
        if ((r17 & 16) == 0) goto L18;
        int r21 = r5;
    L20:
        if ((r17 & 32) == 0) goto L22;
        int r22 = r11;
    L23:
        r10.setSolidColors(r11, r5, r19, r20, r21, r22);
        return;
    L22:
        r22 = r16;
        goto L23
    L18:
        r21 = r15;
        goto L20
    L14:
        r20 = r14;
        goto L16
    L10:
        r19 = r13;
        goto L12
    L6:
        r5 = r12;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSolidColors");
    }

    public static /* synthetic */ void setStrokeConfigs$default(OMaterialDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Object r19) {
        if (r19 != null) goto L26;
        if ((r18 & 4) == 0) goto L6;
        int r5 = r12;
    L8:
        if ((r18 & 8) == 0) goto L10;
        int r20 = r12;
    L12:
        if ((r18 & 16) == 0) goto L14;
        int r21 = r20;
    L16:
        if ((r18 & 32) == 0) goto L18;
        int r22 = r5;
    L20:
        if ((r18 & 64) == 0) goto L22;
        int r23 = r12;
    L23:
        r10.setStrokeConfigs(r11, r12, r5, r20, r21, r22, r23);
        return;
    L22:
        r23 = r17;
        goto L23
    L18:
        r22 = r16;
        goto L20
    L14:
        r21 = r15;
        goto L16
    L10:
        r20 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStrokeConfigs");
    }

    private final boolean updateBlendConfigs(Object r10, int r11, boolean r12, com.obric.oui.color.a[] r13, com.obric.oui.color.a[] r14) {
        if (r13 != null) goto L5;
    L8:
        ValueAnimator r5 = this.blendAnimatorArray[r11];
        if (r5 == null) goto L13;
        r5.cancel();
    L13:
        if (r14 != null) goto L16;
        int[] r15 = n.v(new com.obric.oui.color.a[0]);
        n.l(Arrays.copyOf(r15, r15.length), r10);
        this.currentBlendConfigsArray[r11] = null;
        this.drawBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r16 = this.blendAnimatorArray;
        ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r17.setDuration(getAnimDuration());
        r17.setInterpolator(getAnimInterpolator());
        r17.addUpdateListener(new j(r13, r14, this, r11, r10));
        r17.start();
        Unit r18 = Unit.INSTANCE;
        r16[r11] = r17;
    L19:
        this.currentBlendConfigsArray[r11] = r14;
        this.drawBlendConfigsArray[r11] = r14;
        return true;
    L18:
        int[] r19 = n.v(r14);
        n.l(Arrays.copyOf(r19, r19.length), r10);
        goto L19
    L5:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateBlendConfigs$lambda-24$lambda-23, reason: not valid java name */
    private static final void m107updateBlendConfigs$lambda24$lambda23(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10, OMaterialDrawable r11, int r12, Object r13, ValueAnimator r14) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(r13, "$effectParams");
        Intrinsics.checkNotNullParameter(r14, "animator");
        Object r15 = r14.getAnimatedValue();
        if (r15 == null) goto L7;
        float r16 = ((Float) r15).floatValue();
        Intrinsics.checkNotNull(r5);
        com.obric.oui.color.a[] r17 = s6.b.f(r5, r10, r16);
        r11.drawBlendConfigsArray[r12] = r17;
        int[] r18 = n.v(r17);
        n.l(Arrays.copyOf(r18, r18.length), r13);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final boolean updateOverlayBlendConfigs(Object r10, int r11, boolean r12, com.obric.oui.color.a[] r13, com.obric.oui.color.a[] r14) {
        if (r13 != null) goto L4;
    L8:
        ValueAnimator r5 = this.overlayBlendAnimatorArray[r11];
        if (r5 == null) goto L13;
        r5.cancel();
    L13:
        if (r14 != null) goto L16;
        this.currentOverlayBlendConfigsArray[r11] = null;
        this.drawOverlayBlendConfigsArray[r11] = null;
        return true;
    L16:
        if (r12 == false) goto L18;
        ValueAnimator[] r15 = this.overlayBlendAnimatorArray;
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(getAnimDuration());
        r16.setInterpolator(getAnimInterpolator());
        r16.addUpdateListener(new j(r13, r14, r10, this, r11));
        r16.start();
        Unit r17 = Unit.INSTANCE;
        r15[r11] = r16;
    L18:
        this.currentOverlayBlendConfigsArray[r11] = r14;
        this.drawOverlayBlendConfigsArray[r11] = r14;
        return true;
    L4:
        if (Arrays.equals(r13, r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateOverlayBlendConfigs$lambda-26$lambda-25, reason: not valid java name */
    private static final void m108updateOverlayBlendConfigs$lambda26$lambda25(com.obric.oui.color.a[] r10, com.obric.oui.color.a[] r11, Object r12, OMaterialDrawable r13, int r14, ValueAnimator r15) {
        Intrinsics.checkNotNullParameter(r12, "$effectParams");
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(r15, "animator");
        Object r16 = r15.getAnimatedValue();
        if (r16 == null) goto L18;
        float r17 = ((Float) r16).floatValue();
        Intrinsics.checkNotNull(r10);
        com.obric.oui.color.a[] r18 = s6.b.f(r10, r11, r17);
        com.obric.oui.color.a r19 = r18[0];
        int r110 = r19.f12398a;
        int r20 = r19.f12399b;
        if (n.j() == false) goto L15;
        Object r21 = n.d(r12);
        HashMap r5 = n.f13678b;
        Method r22 = (Method) r5.get("setObricOverlayBlendEffect_3");
        if (r22 == null) goto L19;
    L12:
        r22.invoke(r21, new Object[]{Integer.valueOf(r110), Float.valueOf(1.0f), Integer.valueOf(r20)});     // Catch: Exception -> L10
    L10:
        e = move-exception;
        androidx.room.jarjarred.org.antlr.runtime.a.A(e, "setOverlayBlendEffect error: ", "OMaterialHelper");
        goto L15
    L19:
        Class<?> r23 = Class.forName("android.view.IExtEffect");     // Catch: Exception -> L10
        Class r24 = Integer.TYPE;     // Catch: Exception -> L10
        r22 = r23.getDeclaredMethod("setObricOverlayBlendEffect", new Class[]{r24, Float.TYPE, r24});     // Catch: Exception -> L10
        r22.setAccessible(true);     // Catch: Exception -> L10
        r5.put("setObricOverlayBlendEffect_3", r22);     // Catch: Exception -> L10
    L15:
        r13.drawOverlayBlendConfigsArray[r14] = r18;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void updateSolidColor(int r5, boolean r10) {
        ValueAnimator r11 = this.colorAnimator;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r10 == false) goto L8;
        int r12 = this.animatedSolidColor;
        ValueAnimator r13 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r12), Integer.valueOf(r5)});
        r13.setDuration(getAnimDuration());
        r13.setInterpolator(getAnimInterpolator());
        r13.addUpdateListener(new i(this, 1));
        r13.start();
        this.colorAnimator = r13;
        return;
    L8:
        this.animatedSolidColor = r5;
        setColor(r5);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-31$lambda-30, reason: not valid java name */
    private static final void m109updateSolidColor$lambda31$lambda30(OMaterialDrawable r5, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L7;
        int r12 = ((Integer) r11).intValue();
        r5.animatedSolidColor = r12;
        r5.setColor(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r5, boolean r10) {
        ValueAnimator r11 = this.strokeAnimator;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r10 == false) goto L8;
        int r12 = this.animatedStrokeColor;
        ValueAnimator r13 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r12), Integer.valueOf(r5)});
        r13.setDuration(getAnimDuration());
        r13.setInterpolator(getAnimInterpolator());
        r13.addUpdateListener(new i(this, 0));
        r13.start();
        this.strokeAnimator = r13;
        return;
    L8:
        this.animatedStrokeColor = r5;
        setStroke(this.strokeWidth, r5);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-33$lambda-32, reason: not valid java name */
    private static final void m110updateStrokeColor$lambda33$lambda32(OMaterialDrawable r5, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L7;
        int r12 = ((Integer) r11).intValue();
        r5.animatedStrokeColor = r12;
        r5.setStroke(r5.strokeWidth, r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean updateStrokeConfig(final View r5, Object r10, int r11, boolean r12, final com.obric.oui.color.d r13, final com.obric.oui.color.d r14) {
        if (r13 != null) goto L4;
    L8:
        ValueAnimator r15 = this.strokeAnimator;
        if (r15 == null) goto L12;
        r15.cancel();
    L12:
        if (r12 == false) goto L14;
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(getAnimDuration());
        r16.setInterpolator(getAnimInterpolator());
        r16.addUpdateListener(new k(r13, r14, this, r5));
        r16.start();
        this.strokeAnimator = r16;
    L15:
        com.obric.oui.color.d[] r17 = this.currentStrokeConfigArray;
        Intrinsics.checkNotNull(r14);
        r17[r11] = r14;
        return true;
    L14:
        Intrinsics.checkNotNull(r14);
        setStroke(com.lynx.tasm.utils.a.A(r14.f12423a, r5), r14.f12424b);
        goto L15
    L4:
        if (r13.equals(r14) == false) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: updateStrokeConfig$lambda-29$lambda-28, reason: not valid java name */
    private static final void m111updateStrokeConfig$lambda29$lambda28(com.obric.oui.color.d r5, com.obric.oui.color.d r10, OMaterialDrawable r11, View r12, ValueAnimator r13) {
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Intrinsics.checkNotNullParameter(r12, "$view");
        Intrinsics.checkNotNullParameter(r13, "animator");
        Object r14 = r13.getAnimatedValue();
        if (r14 == null) goto L30;
        float r15 = ((Float) r14).floatValue();
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r5, "fromConfig");
        Intrinsics.checkNotNullParameter(r10, "toConfig");
        com.obric.oui.color.d r16 = null;
        if (r5 != null) goto L7;
        com.obric.oui.color.e r17 = null;
    L8:
        if (r10 != null) goto L10;
        com.obric.oui.color.e r18 = null;
    L11:
        if (r17 != null) goto L13;
    L12:
        r17 = r18;
    L22:
        if (r17 == null) goto L25;
        r16 = new com.obric.oui.color.d(r17.f12426a, r17.f12427b, r17.f12428c);
    L25:
        if (r16 == null) goto L31;
        r11.setStroke(com.lynx.tasm.utils.a.A(r16.f12423a, r12), r16.f12424b);
        return;
    L31:
        return;
    L13:
        if (r18 == null) goto L22;
        float r19 = Math.max(0.0f, Math.min(1.0f, r15));
        if (r19 <= 0.0f) goto L22;
        if (r19 >= 1.0f) goto L12;
        float r20 = r18.f12426a;
        float r21 = r17.f12426a;
        r17 = new com.obric.oui.color.e(j0.b(r20, r21, r19, r21), ColorUtils.blendARGB(r17.f12427b, r18.f12427b, r19), r17.f12428c);
        goto L22
    L10:
        r18 = new com.obric.oui.color.e(r10.f12423a, r10.f12424b, r10.f12425c);
        goto L11
    L7:
        r17 = new com.obric.oui.color.e(r5.f12423a, r5.f12424b, r5.f12425c);
        goto L8
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.enableShadow == false) goto L5;
        drawMultiLayerShadow(r5);
    L5:
        super.draw(r5);
    }

    public final void endAnimation() {
        ValueAnimator r5 = this.colorAnimator;
        if (r5 == null) goto L6;
        r5.end();
    L6:
        ValueAnimator r10 = this.strokeAnimator;
        if (r10 == null) goto L10;
        r10.end();
    L10:
        ValueAnimator[] r11 = this.blendAnimatorArray;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r14 >= r12) goto L17;
        ValueAnimator r15 = r11[r14];
        if (r15 == null) goto L16;
        r15.end();
    L16:
        r14 = r14 + 1;
        goto L11
    L17:
        ValueAnimator[] r16 = this.overlayBlendAnimatorArray;
        int r17 = r16.length;
    L18:
        if (r13 >= r17) goto L24;
        ValueAnimator r18 = r16[r13];
        if (r18 == null) goto L23;
        r18.end();
    L23:
        r13 = r13 + 1;
        goto L18
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return new m(super.getConstantState(), getChangingConfigurations(), this.enableShadow, this.solidColors, this.strokeWidth, this.strokeColors, this.animDuration, this.enableStateChangeTransition, this.materialConfigs, this.materialSrcType, this.materialDrawMode, this.shadowConfigs, this.requireApiVersion);
    }

    public final boolean getEnableStateChangeTransition() {
        return this.enableStateChangeTransition;
    }

    public final int getEnvMaterialApiVersion() {
        return this.envMaterialApiVersion;
    }

    public final int getRequireApiVersion() {
        return this.requireApiVersion;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources r17, XmlPullParser r18, AttributeSet r19, Resources.Theme r20) {
        Intrinsics.checkNotNullParameter(r17, "r");
        Intrinsics.checkNotNullParameter(r18, "parser");
        Intrinsics.checkNotNullParameter(r19, "attrs");
        if (r20 != null) goto L5;
        TypedArray r10 = null;
    L6:
        if (r10 != null) goto L55;
        r10 = r17.obtainAttributes(r19, R$styleable.OMaterialDrawable);
    L55:
        boolean r11 = true;
        this.requireApiVersion = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialApiVersion, 1);     // Catch: Throwable -> L20
        ColorStateList r12 = r10.getColorStateList(R$styleable.OMaterialDrawable_oui_solidColor);     // Catch: Throwable -> L20
        ColorStateList r13 = r10.getColorStateList(R$styleable.OMaterialDrawable_oui_strokeColor);     // Catch: Throwable -> L20
        int r14 = r10.getDimensionPixelSize(R$styleable.OMaterialDrawable_oui_strokeWidth, -1);     // Catch: Throwable -> L20
        this.enableShadow = r10.getBoolean(R$styleable.OMaterialDrawable_oui_widgetEnableShadow, false);     // Catch: Throwable -> L20
        String r15 = r10.getString(R$styleable.OMaterialDrawable_oui_widgetMaterial);     // Catch: Throwable -> L20
        int r16 = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialSrcType, 2);     // Catch: Throwable -> L20
        int r110 = r10.getInt(R$styleable.OMaterialDrawable_oui_widgetMaterialDrawMode, 1);     // Catch: Throwable -> L20
        if (r15 != null) goto L11;
    L40:
        this.materialSrcType = r16;     // Catch: Throwable -> L20
        this.materialDrawMode = r110;     // Catch: Throwable -> L20
    L41:
        r10.recycle();
        super.inflate(r17, r18, r19, r20);
        if (r12 != null) goto L44;
        r12 = getColor();
    L44:
        if (r12 != null) goto L46;
        r12 = ColorStateList.valueOf(0);
    L46:
        setSolidColors(r12);
        if (r13 != null) goto L49;
        r13 = ColorStateList.valueOf(0);
    L49:
        this.strokeColors = r13;
        if (r14 < 0) goto L56;
        setStrokeConfigs(r14, r13);
        return;
    L56:
        return;
    L11:
        if (StringsKt.isBlank(r15) == true) goto L40;
        if ((r17.getConfiguration().uiMode & 48) != 32) goto L17;
        r11 = false;
    L17:
        c[] r5 = MaterialToken.parseSet(r15, r11);     // Catch: Throwable -> L20
        if (r5 == null) goto L22;
        setMaterialConfigs(r5, r16, r110, false);     // Catch: Throwable -> L20
    L31:
        if (r12 != null) goto L41;
        c[] r21 = this.materialConfigs;     // Catch: Throwable -> L20
        if (r21 != null) goto L35;
    L34:
        ColorStateList r22 = null;
    L39:
        r12 = r22;
        goto L41
    L35:
        c r23 = (c) ArraysKt.firstOrNull(r21);     // Catch: Throwable -> L20
        if (r23 == null) goto L34;
        r22 = r23.f13609a;     // Catch: Throwable -> L20
        goto L39
    L22:
        c r24 = MaterialToken.parse(r15, r11);     // Catch: Throwable -> L20
        if (r24 != null) goto L28;
        Function1<Boolean, c> r25 = MaterialToken.parse(r15);     // Catch: Throwable -> L20
        if (r25 != null) goto L27;
        r24 = null;
        goto L28
    L27:
        r24 = r25.invoke(Boolean.valueOf(r11));     // Catch: Throwable -> L20
    L28:
        if (r24 == null) goto L31;
        setMaterialConfig(r24, r16, r110, false);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r10.recycle();
        throw th;
    L5:
        r10 = r20.obtainStyledAttributes(r19, R$styleable.OMaterialDrawable, 0, 0);
        goto L6
    }

    public final Boolean[] isCallbackInitArray() {
        return this.isCallbackInitArray;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        endAnimation();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Intrinsics.checkNotNullParameter(r5, "r");
        super.onBoundsChange(r5);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r14) {
        Intrinsics.checkNotNullParameter(r14, "stateSet");
        Drawable.Callback r5 = getCallback();
        if ((r5 instanceof View) == false) goto L5;
        View r10 = (View) r5;
    L7:
        if (r10 != null) goto L9;
    L39:
        boolean r11 = processSolidAndStrokeOnStateChange(r14);
        if (r11 == false) goto L42;
        invalidateSelf();
    L42:
        if (r11 == false) goto L44;
        return true;
    L44:
        if (super.onStateChange(r14) == false) goto L47;
        return true;
    L47:
        return false;
    L9:
        if (n.i(r10.getContext()) == true) goto L11;
    L38:
        n.q(0, this.materialDrawMode, r10);
        goto L39
    L11:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L38;
        c[] r12 = this.materialConfigs;
        if (r12 == null) goto L39;
        int r13 = r12.length;
        boolean r15 = false;
        int r16 = 0;
    L16:
        if (r16 >= r13) goto L30;
        int r17 = r16 + 1;
        sj.k r18 = n.g(r17, r10);
        if (r18 != null) goto L20;
        Object r19 = null;
    L21:
        if (r19 == null) goto L29;
        c r20 = r12[r16];
        if (r15 == false) goto L25;
    L28:
        r15 = true;
        goto L29
    L25:
        if (processMaterialOnStateChange(r10, r19, r16, r14, r20) == true) goto L28;
        r15 = false;
    L29:
        r16 = r17;
        goto L16
    L20:
        r19 = r18.f21937a;
        goto L21
    L30:
        if (r15 == false) goto L32;
        invalidateSelf();
    L32:
        if (r15 == false) goto L34;
        return true;
    L34:
        if (super.onStateChange(r14) == false) goto L37;
        return true;
    L37:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    public final void setAnimDuration(long r5) {
        this.animDuration = r5;
    }

    public final void setAnimInterpolator(LinearInterpolator r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.animInterpolator = r5;
    }

    public final void setCallbackInitArray(Boolean[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.isCallbackInitArray = r5;
    }

    public final void setEnableShadow(boolean r5) {
        this.enableShadow = r5;
        invalidateSelf();
    }

    public final void setEnableStateChangeTransition(boolean r5) {
        this.enableStateChangeTransition = r5;
    }

    @JvmOverloads
    public final void setMaterialConfig(c r10) {
        Intrinsics.checkNotNullParameter(r10, "materialConfig");
        setMaterialConfig$default(this, r10, 0, 0, false, 14, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(c[] r10) {
        setMaterialConfigs$default(this, r10, 0, 0, false, 14, null);
    }

    public final void setRequireApiVersion(int r5) {
        this.requireApiVersion = r5;
    }

    public final void setShadowConfigs(es.a[] r5) {
        this.shadowConfigs = r5;
        invalidateSelf();
    }

    public final void setSolidColors(int r16, int r17, int r18, int r19, int r20, int r21) {
        setSolidColors(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r19, r19, r18, r18, r18, r18, r17, r20, r18, r19, r21, r16}));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "stateSet");
        Drawable.Callback r5 = getCallback();
        if ((r5 instanceof View) == false) goto L5;
        View r11 = (View) r5;
    L6:
        if (r11 == null) goto L46;
        int r12 = 0;
        if (n.i(r11.getContext()) == true) goto L10;
    L28:
        n.q(0, this.materialDrawMode, r11);
        ColorStateList r13 = this.solidColors;
        if (r13 != null) goto L31;
        int r14 = 0;
    L32:
        ColorStateList r15 = this.solidColors;
        if (r15 != null) goto L35;
        int r16 = 0;
    L36:
        setColor(r16);
        ColorStateList r17 = this.strokeColors;
        if (r17 != null) goto L39;
        int r18 = 0;
    L40:
        int r19 = com.lynx.tasm.utils.a.B(this.strokeWidth, r11);
        ColorStateList r20 = this.strokeColors;
        if (r20 == null) goto L44;
        r12 = r20.getColorForState(r10, r18);
    L44:
        setStroke(r19, r12);
        goto L46
    L39:
        r18 = r17.getDefaultColor();
        goto L40
    L35:
        r16 = r15.getColorForState(r10, r14);
        goto L36
    L31:
        r14 = r13.getDefaultColor();
        goto L32
    L10:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L28;
        Boolean[] r21 = this.isCallbackInitArray;
        int r22 = r21.length;
        int r23 = 0;
    L12:
        if (r23 >= r22) goto L46;
        if (r21[r23].booleanValue() == false) goto L15;
        r23 = r23 + 1;
        goto L12
    L15:
        c[] r24 = this.materialConfigs;
        if (r24 == null) goto L46;
        int r25 = r24.length;
    L19:
        if (r12 >= r25) goto L46;
        int r26 = r12 + 1;
        sj.k r27 = n.g(r26, r11);
        if (r27 != null) goto L23;
        Object r28 = null;
    L24:
        if (r28 == null) goto L26;
        setMaterialToEffectObjectIfNotInit(r28, r12, r24[r12]);
    L26:
        r12 = r26;
        goto L19
    L23:
        r28 = r27.f21937a;
    L46:
        return super.setState(r10);
    L5:
        r11 = null;
        goto L6
    }

    public final void setStrokeConfigs(int r18, int r19, int r20, int r21, int r22, int r23, int r24) {
        this.strokeWidth = r18;
        ColorStateList r5 = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r22, r22, r21, r21, r21, r21, r20, r23, r21, r22, r24, r19});
        this.strokeColors = r5;
        setStrokeConfigs(r18, r5);
    }

    @JvmOverloads
    public final void setMaterialConfig(c r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "materialConfig");
        setMaterialConfig$default(this, r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(c[] r10, int r11) {
        setMaterialConfigs$default(this, r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public final void setMaterialConfig(c r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "materialConfig");
        setMaterialConfig$default(this, r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public final void setMaterialConfigs(c[] r10, int r11, int r12) {
        setMaterialConfigs$default(this, r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public final void setMaterialConfig(c r5, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "materialConfig");
        setMaterialConfigs(new c[]{r5}, r10, r11, r12);
    }

    @JvmOverloads
    public final void setMaterialConfigs(c[] r5, int r10, int r11, boolean r12) {
        this.materialConfigs = r5;
        this.materialSrcType = r10;
        this.materialDrawMode = r11;
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new com.obric.oui.color.d[2];
        View r13 = null;
        this.lastStateSet = null;
        ValueAnimator[] r14 = this.blendAnimatorArray;
        int r15 = r14.length;
        int r16 = 0;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L9;
        ValueAnimator r18 = r14[r17];
        if (r18 == null) goto L8;
        r18.cancel();
    L8:
        r17 = r17 + 1;
        goto L3
    L9:
        ValueAnimator[] r19 = this.overlayBlendAnimatorArray;
        int r20 = r19.length;
    L10:
        if (r16 >= r20) goto L16;
        ValueAnimator r21 = r19[r16];
        if (r21 == null) goto L15;
        r21.cancel();
    L15:
        r16 = r16 + 1;
        goto L10
    L16:
        if (r5 == null) goto L25;
        c r22 = (c) ArraysKt.firstOrNull(r5);
        if (r22 == null) goto L25;
        ColorStateList r23 = r22.f13609a;
        if (r23 == null) goto L25;
        setSolidColors(r23);
    L25:
        Drawable.Callback r24 = getCallback();
        if ((r24 instanceof View) == false) goto L28;
        r13 = (View) r24;
    L28:
        if (r12 == false) goto L31;
        if (r13 == null) goto L31;
        onStateChange(r13.getDrawableState());
    L31:
        invalidateSelf();
    }

    public final void setSolidColors(ColorStateList r5) {
        this.solidColors = r5;
        if (r5 == null) goto L11;
        int r10 = r5.getColorForState(getState(), r5.getDefaultColor());
        this.targetSolidColor = r10;
        this.animatedSolidColor = r10;
        ValueAnimator r11 = this.colorAnimator;
        if (r11 == null) goto L9;
        r11.cancel();
    L9:
        setColor(this.targetSolidColor);
        return;
    }

    public final void setStrokeConfigs(int r5, ColorStateList r10) {
        if (r10 == null) goto L10;
        int r11 = r10.getDefaultColor();
        this.targetStrokeColor = r11;
        this.animatedStrokeColor = r11;
        ValueAnimator r12 = this.strokeAnimator;
        if (r12 == null) goto L8;
        r12.cancel();
    L8:
        setStroke(r5, this.targetStrokeColor);
        return;
    }
}
