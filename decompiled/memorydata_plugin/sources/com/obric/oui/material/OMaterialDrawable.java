package com.obric.oui.material;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.common.oea.foundation.animation.token.Token;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b/\b\u0017\u0018\u0000 £\u00012\u00020\u0001:\u0004£\u0001¤\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020\u0001H\u0003J\u001f\u0010V\u001a\u00020P2\u0006\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0ZH\u0082\bJ\u0010\u0010[\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010\\\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0003J\u0006\u0010]\u001a\u00020PJ\u0010\u0010^\u001a\u0002022\u0006\u0010_\u001a\u000202H\u0002J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J.\u0010b\u001a\u00020P2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\f\u0010i\u001a\b\u0018\u00010jR\u00020dH\u0016J\u0010\u0010k\u001a\u00020\"2\u0006\u0010l\u001a\u00020@H\u0002J\b\u0010m\u001a\u00020\"H\u0016J\b\u0010n\u001a\u00020PH\u0016J\u0010\u0010o\u001a\u00020P2\u0006\u0010c\u001a\u00020pH\u0014J\u0010\u0010q\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0014J0\u0010r\u001a\u00020\"2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010_\u001a\u0002022\u0006\u0010x\u001a\u000204H\u0002J\u0010\u0010y\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0002J\u000e\u0010z\u001a\u00020P2\u0006\u0010{\u001a\u00020\"J\u000e\u0010|\u001a\u00020P2\u0006\u0010}\u001a\u00020\"J1\u0010~\u001a\u00020P2\u0006\u0010\u007f\u001a\u0002042\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\"H\u0007J@\u0010\u0083\u0001\u001a\u00020P2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00132\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u0082\u0001\u001a\u00020\"H\u0007¢\u0006\u0003\u0010\u0084\u0001J!\u0010\u0085\u0001\u001a\u00020P2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010x\u001a\u000204H\u0002J\u001d\u0010\u0086\u0001\u001a\u00020P2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0013¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020P2\b\u0010E\u001a\u0004\u0018\u00010FJG\u0010\u0088\u0001\u001a\u00020P2\u0007\u0010\u0089\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0010J\u0011\u0010\u008f\u0001\u001a\u00020\"2\u0006\u0010_\u001a\u000202H\u0016J\u001a\u0010\u0090\u0001\u001a\u00020P2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010FJP\u0010\u0090\u0001\u001a\u00020P2\u0007\u0010\u0091\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u00102\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0010JJ\u0010\u0092\u0001\u001a\u00020\"2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\u000f\u0010\u0094\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u0096\u0001JJ\u0010\u0097\u0001\u001a\u00020\"2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\u000f\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00132\u000f\u0010\u0099\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013H\u0002¢\u0006\u0003\u0010\u0096\u0001J\u001b\u0010\u009a\u0001\u001a\u00020P2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u009c\u0001\u001a\u00020\"H\u0002J\u001b\u0010\u009d\u0001\u001a\u00020P2\u0007\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u009c\u0001\u001a\u00020\"H\u0002J@\u0010\u009e\u0001\u001a\u00020\"2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\"2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001c2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010¡\u0001\u001a\u00020\"*\u0002022\u0007\u0010¢\u0001\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u001e\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u001e\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00130\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u00109\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010+\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010AR\u000e\u0010B\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¥\u0001"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "()V", "animDuration", "", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "animatedSolidColor", "", "animatedStrokeColor", "blendAnimatorArray", "", "Landroid/animation/ValueAnimator;", "[Landroid/animation/ValueAnimator;", "colorAnimator", "currentBlendConfigsArray", "Lcom/obric/oui/color/BlendConfig;", "[[Lcom/obric/oui/color/BlendConfig;", "currentOverlayBlendConfigsArray", "currentStrokeConfigArray", "Lcom/obric/oui/color/StrokeConfig;", "[Lcom/obric/oui/color/StrokeConfig;", "drawBlendConfigsArray", "drawOverlayBlendConfigsArray", "drawStrokeConfigArray", "enableExtraStateChange", "", "enableShadow", "enableStateChangeTransition", "getEnableStateChangeTransition", "()Z", "setEnableStateChangeTransition", "(Z)V", "envMaterialApiVersion", "getEnvMaterialApiVersion", "()I", "isCallbackInitArray", "()[Ljava/lang/Boolean;", "setCallbackInitArray", "([Ljava/lang/Boolean;)V", "[Ljava/lang/Boolean;", "lastStateSet", "", "materialConfigs", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "materialDrawMode", "materialSrcType", "overlayBlendAnimatorArray", "requireApiVersion", "getRequireApiVersion", "setRequireApiVersion", "(I)V", "shadowClipPath", "Landroid/graphics/Path;", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "shadowDrawPath", "shadowPaint", "Landroid/graphics/Paint;", "solidColors", "Landroid/content/res/ColorStateList;", "strokeAnimator", "strokeColors", "strokeWidth", "targetSolidColor", "targetStrokeColor", "tmpRectF", "Landroid/graphics/RectF;", "tmpShadowRectF", "clipOutShadowPath", "", "canvas", "Landroid/graphics/Canvas;", "path", "copyGradientInternalStateFrom", "template", "debugLog", "stage", "", "message", "Lkotlin/Function0;", "draw", "drawMultiLayerShadow", "endAnimation", "filterStateSet", "stateSet", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "inflate", "r", "Landroid/content/res/Resources;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "attrs", "Landroid/util/AttributeSet;", "theme", "Landroid/content/res/Resources$Theme;", "isShadowValid", "config", "isStateful", "jumpToCurrentState", "onBoundsChange", "Landroid/graphics/Rect;", "onStateChange", "processMaterialOnStateChange", "view", "Landroid/view/View;", "effectParams", "", "index", "material", "processSolidAndStrokeOnStateChange", "setEnableExtraStateChange", "enabled", "setEnableShadow", "enable", "setMaterialConfig", "materialConfig", "srcType", "drawMode", "applyImmediately", "setMaterialConfigs", "([Lcom/obric/oui/material/MaterialConfig;IIZ)V", "setMaterialToEffectObjectIfNotInit", "setShadowConfigs", "([Lcom/obric/oui/shadow/ShadowConfig;)V", "setSolidColors", "normal", "pressed", BuildConfig.FLAVOR, "checked", "hover", "disabled", "setState", "setStrokeConfigs", "width", "updateBlendConfigs", "enableAnimate", "fromBlendConfigs", "toBlendConfigs", "(Ljava/lang/Object;IZ[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Z", "updateOverlayBlendConfigs", "fromOverlayBlendConfigs", "toOverlayBlendConfigs", "updateSolidColor", "toColor", "animate", "updateStrokeColor", "updateStrokeConfig", "fromStrokeConfig", "toStrokeConfig", "containsState", TypedValues.AttributesType.S_TARGET, "Companion", "OMaterialDrawableState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMaterialDrawable extends GradientDrawable {
    public static final a Companion = null;
    private static boolean DEBUGGABLE = false;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int[] ENABLED_STATE_SET = null;
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
    private com.obric.oui.color.e[] currentStrokeConfigArray;
    private com.obric.oui.color.a[][] drawBlendConfigsArray;
    private com.obric.oui.color.a[][] drawOverlayBlendConfigsArray;
    private com.obric.oui.color.e[] drawStrokeConfigArray;
    private boolean enableExtraStateChange;
    private boolean enableShadow;
    private boolean enableStateChangeTransition;
    private final int envMaterialApiVersion;
    private Boolean[] isCallbackInitArray;
    private int[] lastStateSet;
    private com.obric.oui.material.c[] materialConfigs;
    private int materialDrawMode;
    private int materialSrcType;
    private ValueAnimator[] overlayBlendAnimatorArray;
    private int requireApiVersion;
    private final Path shadowClipPath;
    private com.obric.oui.shadow.a[] shadowConfigs;
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

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$Companion;", "", "()V", "DEBUGGABLE", "", "getDEBUGGABLE$annotations", "getDEBUGGABLE", "()Z", "setDEBUGGABLE", "(Z)V", "DISABLED_STATE_SET", "", "ENABLED_STATE_SET", "MAX_MATERIAL_CONFIG_COUNT", "", "TAG", "", "describeBlendConfigs", "configs", "", "Lcom/obric/oui/color/BlendConfig;", "([Lcom/obric/oui/color/BlendConfig;)Ljava/lang/String;", "describeState", "state", "describeStrokeConfig", "config", "Lcom/obric/oui/color/StrokeConfig;", "formatColor", TypedValues.Custom.S_COLOR, "formatNullableStateSet", "stateSet", "formatProgress", "progress", "", "formatStateSet", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a(float r3) {
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            String r4 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(format, *args)");
            return r4;
        }

        private final String a(int r1) {
            switch(r1) {
                case -16842910: goto L13;
                case 16842908: goto L12;
                case 16842909: goto L11;
                case 16842910: goto L10;
                case 16842912: goto L9;
                case 16842913: goto L8;
                case 16842919: goto L7;
                case 16843518: goto L6;
                case 16843547: goto L5;
                case 16843623: goto L4;
                default: goto L15;
            };
        L4:
            return "state_hovered";
        L5:
            return "state_accelerated";
        L6:
            return "state_activated";
        L7:
            return "state_pressed";
        L8:
            return "state_selected";
        L9:
            return "state_checked";
        L10:
            return "state_enabled";
        L11:
            return "state_window_focused";
        L12:
            return "state_focused";
        L13:
            return "-state_enabled";
        L15:
            return String.valueOf(r1);
        }

        private final String a(com.obric.oui.color.e r3) {
            if (r3 == null) goto L10;
            String r4 = "{width=" + r3.a() + ", color=" + OMaterialDrawable.Companion.b(r3.b()) + '}';
            if (r4 != null) goto L9;
            return "null";
        L9:
            return r4;
        L10:
            return "null";
        }

        public static final /* synthetic */ String a(a r0, float r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, com.obric.oui.color.e r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, int[] r1) {
            return r0.b(r1);
        }

        public static final /* synthetic */ String a(a r0, com.obric.oui.color.a[] r1) {
            return r0.a(r1);
        }

        private final String a(int[] r2) {
            if (r2 == null) goto L10;
            String r1 = b(r2);
            if (r1 != null) goto L9;
            return "null";
        L9:
            return r1;
        L10:
            return "null";
        }

        private final String a(com.obric.oui.color.a[] r11) {
            if (r11 == null) goto L10;
            String r12 = ArraysKt.joinToString$default(r11, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(OMaterialDrawable$Companion$describeBlendConfigs$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null);
            if (r12 != null) goto L9;
            return "null";
        L9:
            return r12;
        L10:
            return "null";
        }

        private final String b(int r3) {
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            String r4 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(format, *args)");
            return r4;
        }

        public static final /* synthetic */ String b(a r0, int r1) {
            return r0.b(r1);
        }

        public static final /* synthetic */ String b(a r0, int[] r1) {
            return r0.a(r1);
        }

        private final String b(int[] r10) {
            if (r10.length != 0) goto L5;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L10;
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        L10:
            return ArraysKt.joinToString$default(r10, null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(OMaterialDrawable$Companion$formatStateSet$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 25, null);
        L5:
            r9 = false;
            goto L6
        }

        public final void a(boolean r1) {
            OMaterialDrawable.access$setDEBUGGABLE$cp(r1);
        }

        public final boolean a() {
            return OMaterialDrawable.access$getDEBUGGABLE$cp();
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J \u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0018\u00010 R\u00020\u001eH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/material/OMaterialDrawable$OMaterialDrawableState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "baseState", "changingConfigurations", "", "enableShadow", "", "enableExtraStateChange", "solidColors", "Landroid/content/res/ColorStateList;", "strokeWidth", "strokeColors", "animDuration", "", "enableStateChangeTransition", "materialConfigs", "", "Lcom/obric/oui/material/MaterialConfig;", "materialSrcType", "materialDrawMode", "shadowConfigs", "Lcom/obric/oui/shadow/ShadowConfig;", "requireApiVersion", "(Landroid/graphics/drawable/Drawable$ConstantState;IZZLandroid/content/res/ColorStateList;ILandroid/content/res/ColorStateList;JZ[Lcom/obric/oui/material/MaterialConfig;II[Lcom/obric/oui/shadow/ShadowConfig;I)V", "[Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/shadow/ShadowConfig;", "getChangingConfigurations", "newDrawable", "Landroid/graphics/drawable/Drawable;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f13999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14000b;
        private final boolean c;
        private final boolean d;
        private final ColorStateList e;
        private final int f;
        private final ColorStateList g;
        private final long h;
        private final boolean i;
        private final com.obric.oui.material.c[] j;
        private final int k;
        private final int l;
        private final com.obric.oui.shadow.a[] m;
        private final int n;

        public b(Drawable.ConstantState r1, int r2, boolean r3, boolean r4, ColorStateList r5, int r6, ColorStateList r7, long r8, boolean r10, com.obric.oui.material.c[] r11, int r12, int r13, com.obric.oui.shadow.a[] r14, int r15) {
            this.f13999a = r1;
            this.f14000b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f14000b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return newDrawable(r2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5, Resources.Theme r6) {
            GradientDrawable r1 = null;
            Drawable.ConstantState r2 = this.f13999a;     // Catch: Exception -> L12
            if (r2 != null) goto L6;
            Drawable r7 = null;
        L21:
        L13:
            OMaterialDrawable r8 = new OMaterialDrawable();
            if (ZeusTransformUtils.instanceOf(r7, GradientDrawable.class) == false) goto L16;
            r1 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r7, GradientDrawable.class, "com.obric.memorydata.plugin");
        L16:
            if (r1 == null) goto L19;
            OMaterialDrawable.access$copyGradientInternalStateFrom(r8, r1);
        L19:
            OMaterialDrawable.access$setEnableShadow$p(r8, this.c);
            OMaterialDrawable.access$setEnableExtraStateChange$p(r8, this.d);
            r8.setAnimDuration(this.h);
            r8.setEnableStateChangeTransition(this.i);
            r8.setMaterialConfigs(this.j, this.k, this.l, false);
            r8.setShadowConfigs(this.m);
            r8.setSolidColors(this.e);
            r8.setStrokeConfigs(this.f, this.g);
            r8.setCallbackInitArray(new Boolean[]{false, false});
            r8.setRequireApiVersion(this.n);
            return (Drawable) ZeusTransformUtils.preCheckCast(r8, Drawable.class, "com.obric.memorydata.plugin");
        L6:
            if (r6 == null) goto L8;
            r7 = r2.newDrawable(r5, r6);     // Catch: Exception -> L12
            goto L21
        L8:
            if (r5 == null) goto L10;
            r7 = r2.newDrawable(r5);     // Catch: Exception -> L12
            goto L21
        L10:
            r7 = r2.newDrawable();     // Catch: Exception -> L12
        L12:
            r7 = (Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.memorydata.plugin");
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/material/OMaterialDrawable$updateBlendConfigs$5$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMaterialDrawable f14001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14002b;
        final /* synthetic */ com.obric.oui.color.a[] c;
        final /* synthetic */ com.obric.oui.color.a[] d;

        c(OMaterialDrawable r1, int r2, com.obric.oui.color.a[] r3, com.obric.oui.color.a[] r4) {
            this.f14001a = r1;
            this.f14002b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14001a;
            int r0 = this.f14002b;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][blendAnimator] " + ("index=" + r0 + " cancel, currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawBlendConfigsArray$p(r6)[r0]) + ", target=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14001a;
            int r0 = this.f14002b;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][blendAnimator] " + ("index=" + r0 + " end, currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawBlendConfigsArray$p(r6)[r0]) + ", target=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14001a;
            int r0 = this.f14002b;
            com.obric.oui.color.a[] r1 = this.c;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][blendAnimator] " + ("index=" + r0 + " start, from=" + a.a(OMaterialDrawable.Companion, r1) + ", to=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/material/OMaterialDrawable$updateOverlayBlendConfigs$5$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMaterialDrawable f14003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14004b;
        final /* synthetic */ com.obric.oui.color.a[] c;
        final /* synthetic */ com.obric.oui.color.a[] d;

        d(OMaterialDrawable r1, int r2, com.obric.oui.color.a[] r3, com.obric.oui.color.a[] r4) {
            this.f14003a = r1;
            this.f14004b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14003a;
            int r0 = this.f14004b;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][overlayAnimator] " + ("index=" + r0 + " cancel, currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawOverlayBlendConfigsArray$p(r6)[r0]) + ", target=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14003a;
            int r0 = this.f14004b;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][overlayAnimator] " + ("index=" + r0 + " end, currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawOverlayBlendConfigsArray$p(r6)[r0]) + ", target=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14003a;
            int r0 = this.f14004b;
            com.obric.oui.color.a[] r1 = this.c;
            com.obric.oui.color.a[] r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][overlayAnimator] " + ("index=" + r0 + " start, from=" + a.a(OMaterialDrawable.Companion, r1) + ", to=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/material/OMaterialDrawable$updateSolidColor$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMaterialDrawable f14005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14006b;
        final /* synthetic */ int c;

        e(OMaterialDrawable r1, int r2, int r3) {
            this.f14005a = r1;
            this.f14006b = r2;
            this.c = r3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14005a;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][solidColorAnimator] " + ("cancel, current=" + a.b(OMaterialDrawable.Companion, OMaterialDrawable.access$getAnimatedSolidColor$p(r5)) + ", target=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14005a;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][solidColorAnimator] " + ("end, current=" + a.b(OMaterialDrawable.Companion, OMaterialDrawable.access$getAnimatedSolidColor$p(r5)) + ", target=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14005a;
            int r0 = this.f14006b;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][solidColorAnimator] " + ("start, from=" + a.b(OMaterialDrawable.Companion, r0) + ", to=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/material/OMaterialDrawable$updateStrokeColor$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMaterialDrawable f14007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14008b;
        final /* synthetic */ int c;

        f(OMaterialDrawable r1, int r2, int r3) {
            this.f14007a = r1;
            this.f14008b = r2;
            this.c = r3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14007a;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][strokeColorAnimator] " + ("cancel, current=" + a.b(OMaterialDrawable.Companion, OMaterialDrawable.access$getAnimatedStrokeColor$p(r5)) + ", target=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14007a;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][strokeColorAnimator] " + ("end, current=" + a.b(OMaterialDrawable.Companion, OMaterialDrawable.access$getAnimatedStrokeColor$p(r5)) + ", target=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            OMaterialDrawable r5 = this.f14007a;
            int r0 = this.f14008b;
            int r3 = this.c;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r5) + "][strokeColorAnimator] " + ("start, from=" + a.b(OMaterialDrawable.Companion, r0) + ", to=" + a.b(OMaterialDrawable.Companion, r3)));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/obric/oui/material/OMaterialDrawable$updateStrokeConfig$4$2", "Landroid/animation/AnimatorListenerAdapter;", "cancelled", "", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMaterialDrawable f14009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14010b;
        final /* synthetic */ com.obric.oui.color.e c;
        final /* synthetic */ com.obric.oui.color.e d;
        final /* synthetic */ View e;
        private boolean f;

        g(OMaterialDrawable r1, int r2, com.obric.oui.color.e r3, com.obric.oui.color.e r4, View r5) {
            this.f14009a = r1;
            this.f14010b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            this.f = true;
            OMaterialDrawable r6 = this.f14009a;
            int r0 = this.f14010b;
            com.obric.oui.color.e r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][strokeAnimator] " + ("index=" + r0 + " cancel, currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawStrokeConfigArray$p(r6)[r0]) + ", target=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r6) {
            Intrinsics.checkNotNullParameter(r6, "animation");
            if (this.f == true) goto L5;
            com.obric.oui.color.e[] r7 = OMaterialDrawable.access$getDrawStrokeConfigArray$p(this.f14009a);
            int r0 = this.f14010b;
            com.obric.oui.color.e r1 = this.d;
            r7[r0] = r1;
            this.f14009a.setStroke(com.obric.oui.common.util.h.a(this.e, r1.a()), this.d.b());
        L5:
            OMaterialDrawable r8 = this.f14009a;
            int r2 = this.f14010b;
            com.obric.oui.color.e r3 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L9;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r8) + "][strokeAnimator] " + ("index=" + r2 + " end, cancelled=" + this.f + ", currentDraw=" + a.a(OMaterialDrawable.Companion, OMaterialDrawable.access$getDrawStrokeConfigArray$p(r8)[r2]) + ", target=" + a.a(OMaterialDrawable.Companion, r3)));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            OMaterialDrawable r6 = this.f14009a;
            int r0 = this.f14010b;
            com.obric.oui.color.e r1 = this.c;
            com.obric.oui.color.e r4 = this.d;
            if (OMaterialDrawable.Companion.a() == false) goto L6;
            Log.d(OMaterialDrawable.TAG, '[' + System.identityHashCode(r6) + "][strokeAnimator] " + ("index=" + r0 + " start, from=" + a.a(OMaterialDrawable.Companion, r1) + ", to=" + a.a(OMaterialDrawable.Companion, r4)));
            return;
        }
    }

    static {
        Companion = new a(null);
        ENABLED_STATE_SET = new int[]{R.attr.state_enabled};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    public OMaterialDrawable() {
        this.enableExtraStateChange = true;
        this.animDuration = Token.Duration.OUI_ANIMATION_DURATION_SHORT_3.getDuration();
        this.animInterpolator = new LinearInterpolator();
        this.materialSrcType = 2;
        this.materialDrawMode = 1;
        Paint r2 = new Paint(1);
        r2.setStyle(Paint.Style.FILL);
        this.shadowPaint = r2;
        this.shadowClipPath = new Path();
        this.shadowDrawPath = new Path();
        this.tmpRectF = new RectF();
        this.tmpShadowRectF = new RectF();
        this.isCallbackInitArray = new Boolean[]{false, false};
        this.requireApiVersion = 1;
        this.envMaterialApiVersion = OMaterialHelper.b();
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new com.obric.oui.color.e[2];
        this.drawStrokeConfigArray = new com.obric.oui.color.e[2];
        this.blendAnimatorArray = new ValueAnimator[2];
        this.overlayBlendAnimatorArray = new ValueAnimator[2];
        this.enableStateChangeTransition = true;
    }

    public static final /* synthetic */ void access$copyGradientInternalStateFrom(OMaterialDrawable r0, GradientDrawable r1) {
        r0.copyGradientInternalStateFrom(r1);
    }

    public static final /* synthetic */ int access$getAnimatedSolidColor$p(OMaterialDrawable r0) {
        return r0.animatedSolidColor;
    }

    public static final /* synthetic */ int access$getAnimatedStrokeColor$p(OMaterialDrawable r0) {
        return r0.animatedStrokeColor;
    }

    public static final /* synthetic */ boolean access$getDEBUGGABLE$cp() {
        return DEBUGGABLE;
    }

    public static final /* synthetic */ com.obric.oui.color.a[][] access$getDrawBlendConfigsArray$p(OMaterialDrawable r0) {
        return r0.drawBlendConfigsArray;
    }

    public static final /* synthetic */ com.obric.oui.color.a[][] access$getDrawOverlayBlendConfigsArray$p(OMaterialDrawable r0) {
        return r0.drawOverlayBlendConfigsArray;
    }

    public static final /* synthetic */ com.obric.oui.color.e[] access$getDrawStrokeConfigArray$p(OMaterialDrawable r0) {
        return r0.drawStrokeConfigArray;
    }

    public static final /* synthetic */ void access$setDEBUGGABLE$cp(boolean r0) {
        DEBUGGABLE = r0;
    }

    public static final /* synthetic */ void access$setEnableExtraStateChange$p(OMaterialDrawable r0, boolean r1) {
        r0.enableExtraStateChange = r1;
    }

    public static final /* synthetic */ void access$setEnableShadow$p(OMaterialDrawable r0, boolean r1) {
        r0.enableShadow = r1;
    }

    private final void clipOutShadowPath(Canvas r2, Path r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r2.clipOutPath(r3);
        return;
    L5:
        r2.clipPath(r3, Region.Op.DIFFERENCE);
    }

    private final boolean containsState(int[] r4, int r5) {
        int r3 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L8;
        int r2 = r4[r1];
        r1 = r1 + 1;
        if (r2 != r5) goto L3;
        return true;
    L8:
        return false;
    }

    private final void copyGradientInternalStateFrom(GradientDrawable r3) {
        Field r0 = GradientDrawable.class.getDeclaredField("mGradientState");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.set(this, r0.get(r3));     // Catch: Exception -> L4
        return;
    }

    private final void debugLog(String r4, Function0<String> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if (Companion.a() == false) goto L6;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][" + r4 + "] " + ((String) ZeusTransformUtils.preCheckCast(r6.invoke(), String.class, "com.obric.memorydata.plugin")));
        return;
    }

    private final void drawMultiLayerShadow(Canvas r17) {
        com.obric.oui.shadow.a[] r2 = this.shadowConfigs;
        int r4 = 0;
        if (r2 != null) goto L23;
        com.obric.oui.material.c[] r3 = this.materialConfigs;
        if (r3 != null) goto L7;
    L6:
        r2 = null;
    L20:
        if (r2 != null) goto L23;
        return;
    L7:
        int r6 = r3.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L16;
        com.obric.oui.material.c r8 = r3[r7];
        if (r8.i() == null) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L17;
        r7 = r7 + 1;
    L17:
        if (r8 == null) goto L6;
        r2 = r8.i();
        goto L20
    L12:
        r9 = false;
        goto L13
    L16:
        r8 = null;
    L23:
        if (r2.length != 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L28:
        Rect r11 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r11, "bounds");
        if (r11.isEmpty() == false) goto L31;
        return;
    L31:
        this.tmpRectF.set(r11);
        int r12 = getShape();
        float[] r13 = getCornerRadii();
        float r14 = getCornerRadius();
        this.shadowClipPath.reset();
        if (r12 != 1) goto L34;
        this.shadowClipPath.addOval(this.tmpRectF, Path.Direction.CW);
    L40:
        int r15 = r2.length;
    L41:
        if (r4 >= r15) goto L59;
        com.obric.oui.shadow.a r16 = r2[r4];
        r4 = r4 + 1;
        if (isShadowValid(r16) == false) goto L41;
        int r18 = r17.save();
        clipOutShadowPath(r17, this.shadowClipPath);
        this.tmpShadowRectF.set(this.tmpRectF);
        float r19 = r17.getDensity() / 160.0f;
        this.tmpShadowRectF.offset(com.obric.oui.common.util.h.a(r16.a(), r19), com.obric.oui.common.util.h.a(r16.b(), r19));
        this.tmpShadowRectF.inset(-r16.e(), -r16.e());
        this.shadowPaint.setColor(r16.d());
        Paint r5 = this.shadowPaint;
        if (r16.c() <= 0.0f) goto L48;
        Object r110 = ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r16.c(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.memorydata.plugin");
    L49:
        r5.setMaskFilter((MaskFilter) r110);
        if (r12 != 1) goto L52;
        r17.drawOval(this.tmpShadowRectF, this.shadowPaint);
    L58:
        r17.restoreToCount(r18);
        goto L41
    L52:
        if (r13 == null) goto L55;
        this.shadowDrawPath.reset();
        this.shadowDrawPath.addRoundRect(this.tmpShadowRectF, r13, Path.Direction.CW);
        r17.drawPath(this.shadowDrawPath, this.shadowPaint);
        goto L58
    L55:
        if (r14 <= 0.0f) goto L57;
        r17.drawRoundRect(this.tmpShadowRectF, r14, r14, this.shadowPaint);
        goto L58
    L57:
        r17.drawRect(this.tmpShadowRectF, this.shadowPaint);
        goto L58
    L48:
        r110 = ZeusTransformUtils.preCheckCast(null, MaskFilter.class, "com.obric.memorydata.plugin");
        goto L49
    L59:
        return;
    L34:
        if (r13 == null) goto L37;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r13, Path.Direction.CW);
        goto L40
    L37:
        if (r14 <= 0.0f) goto L39;
        this.shadowClipPath.addRoundRect(this.tmpRectF, r14, r14, Path.Direction.CW);
        goto L40
    L39:
        this.shadowClipPath.addRect(this.tmpRectF, Path.Direction.CW);
        goto L40
    L25:
        r10 = false;
        goto L26
    }

    private final int[] filterStateSet(int[] r2) {
        if (this.enableExtraStateChange == false) goto L6;
        return r2;
    L6:
        if ((!containsState(r2, -16842910)) == false) goto L9;
        return ENABLED_STATE_SET;
    L9:
        return DISABLED_STATE_SET;
    }

    public static final boolean getDEBUGGABLE() {
        return Companion.a();
    }

    private final boolean isShadowValid(com.obric.oui.shadow.a r4) {
        if (r4.d() != 0) goto L6;
        return false;
    L6:
        if (r4.a() != 0.0f) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L26;
        if (r4.b() != 0.0f) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L26;
        if (r4.c() != 0.0f) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L26;
        if (r4.e() != 0.0f) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        return false;
    L23:
        r7 = false;
        goto L24
    L18:
        r6 = false;
        goto L19
    L13:
        r5 = false;
    L26:
        return true;
    L8:
        r3 = false;
        goto L9
    }

    public static /* synthetic */ void lambda$BPWH27FWvtZz9_ZTeBLAbozJsFs(OMaterialDrawable r0, ValueAnimator r1) {
        m1325updateSolidColor$lambda61$lambda60(r0, r1);
    }

    public static /* synthetic */ void lambda$SZqD4GnqGNiuE3l6u2lYNcwgdcU(com.obric.oui.color.a[] r0, com.obric.oui.color.a[] r1, OMaterialDrawable r2, int r3, Object r4, ValueAnimator r5) {
        m1323updateBlendConfigs$lambda36$lambda35(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$WSdYi4Qwdgf17sI7PSDVYA-hX38, reason: not valid java name */
    public static /* synthetic */ void m1320lambda$WSdYi4Qwdgf17sI7PSDVYAhX38(com.obric.oui.color.e r0, com.obric.oui.color.e r1, OMaterialDrawable r2, int r3, View r4, ValueAnimator r5) {
        m1327updateStrokeConfig$lambda53$lambda52(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$h7n9QOblUXWN-vsug_GQLEZi8YQ, reason: not valid java name */
    public static /* synthetic */ void m1321lambda$h7n9QOblUXWNvsug_GQLEZi8YQ(com.obric.oui.color.a[] r0, com.obric.oui.color.a[] r1, OMaterialDrawable r2, Object r3, int r4, ValueAnimator r5) {
        m1324updateOverlayBlendConfigs$lambda45$lambda44(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$zfLLd8zVuwQ86_zeeFGWk-kO9EE, reason: not valid java name */
    public static /* synthetic */ void m1322lambda$zfLLd8zVuwQ86_zeeFGWkkO9EE(OMaterialDrawable r0, ValueAnimator r1) {
        m1326updateStrokeColor$lambda65$lambda64(r0, r1);
    }

    private final boolean processMaterialOnStateChange(View r18, Object r19, int r20, int[] r21, com.obric.oui.material.c r22) {
        setColor(0);
        this.targetSolidColor = 0;
        int[] r11 = this.lastStateSet;
        if (this.isCallbackInitArray[r20].booleanValue() == true) goto L18;
        OMaterialHelper.a(r19, this.materialSrcType, this.materialDrawMode);
        Float r0 = r22.h();
        if (r0 == null) goto L8;
        OMaterialHelper.a(r19, ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).floatValue());
    L8:
        com.obric.oui.fluid.a r1 = r22.j();
        if (r1 == null) goto L12;
        OMaterialHelper.a(r19, true, r1.a());
    L12:
        com.obric.oui.shadow.a[] r2 = r22.i();
        if (r2 == null) goto L18;
        com.obric.oui.shadow.a r3 = (com.obric.oui.shadow.a) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r2), com.obric.oui.shadow.a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        Paint r4 = this.shadowPaint;
        int[] r5 = com.obric.oui.shadow.a.f14456a.a(r3);
        OMaterialHelper.b(r4, Arrays.copyOf(r5, r5.length));
    L18:
        com.obric.oui.b.a r6 = r22.b();
        if (r6 != null) goto L21;
        com.obric.oui.color.a[] r7 = null;
    L22:
        if (r7 != null) goto L24;
        r7 = r22.c();
    L24:
        com.obric.oui.color.a[] r8 = r7;
        a r15 = Companion;
        if (r15.a() == false) goto L27;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][processMaterialOnStateChange] " + ("index=" + r20 + ", view=" + r18.getClass().getSimpleName() + ':' + r18.hashCode() + ", state=" + a.a(r15, r21) + ", fromState=" + a.b(r15, r11) + ", enableTransition=" + getEnableStateChangeTransition() + ", blendTarget=" + a.a(r15, r8) + ", currentDrawBlend=" + a.a(r15, this.drawBlendConfigsArray[r20])));
    L27:
        if (r8 == null) goto L40;
        com.obric.oui.color.a[] r10 = this.drawBlendConfigsArray[r20];
        if (this.enableStateChangeTransition == false) goto L34;
        if (r6 == null) goto L34;
        if (r11 == null) goto L34;
        if (r10 == null) goto L34;
        boolean r14 = true;
    L36:
        if (updateBlendConfigs(r19, r20, r14, r10, r8) == true) goto L38;
        boolean r9 = false;
    L39:
        boolean r12 = r9;
    L41:
        com.obric.oui.b.a r13 = r22.f();
        if (r13 != null) goto L44;
        com.obric.oui.color.a[] r16 = null;
    L46:
        if (r15.a() == false) goto L48;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][processMaterialOnStateChange] " + ("index=" + r20 + ", overlayTarget=" + a.a(r15, r16) + ", currentDrawOverlay=" + a.a(r15, this.drawOverlayBlendConfigsArray[r20])));
    L48:
        if (r16 == null) goto L61;
        com.obric.oui.color.a[] r17 = this.drawOverlayBlendConfigsArray[r20];
        if (this.enableStateChangeTransition == false) goto L54;
        if (r11 == null) goto L54;
        if (r17 == null) goto L54;
        boolean r23 = true;
    L56:
        if (updateOverlayBlendConfigs(r19, r20, r23, r17, r16) == true) goto L60;
        if (r12 == true) goto L60;
        r12 = false;
    L60:
        r12 = true;
    L54:
        r23 = false;
    L61:
        com.obric.oui.b.c r24 = r22.d();
        if (r24 != null) goto L64;
        com.obric.oui.color.e r25 = null;
    L65:
        if (r25 != null) goto L67;
        r25 = r22.e();
    L67:
        com.obric.oui.color.e r26 = r25;
        if (r15.a() == false) goto L70;
        Log.d(TAG, '[' + System.identityHashCode(this) + r2 + "processMaterialOnStateChange" + r3 + (r4 + r20 + ", strokeTarget=" + a.a(r15, r26) + ", currentDrawStroke=" + a.a(r15, this.drawStrokeConfigArray[r20])));
    L70:
        if (r26 == null) goto L84;
        com.obric.oui.color.e r27 = this.drawStrokeConfigArray[r20];
        if (this.enableStateChangeTransition == false) goto L77;
        if (r24 == null) goto L77;
        if (r11 == 0) goto L77;
        if (r27 == null) goto L77;
        boolean r28 = true;
    L79:
        if (updateStrokeConfig(r18, r19, r20, r28, r27, r26) == true) goto L83;
        if (r12 == true) goto L83;
        r12 = false;
    L83:
        r12 = true;
    L77:
        r28 = false;
    L84:
        this.isCallbackInitArray[r20] = true;
        return r12;
    L64:
        r25 = com.obric.oui.b.c.a(r24, r21, null, 2, null);
        goto L65
    L44:
        r16 = com.obric.oui.b.a.a(r13, r21, null, 2, null);
        goto L46
    L38:
        r9 = true;
    L34:
        r14 = false;
        goto L36
    L40:
        r12 = false;
        goto L41
    L21:
        r7 = com.obric.oui.b.a.a(r6, r21, null, 2, null);
        goto L22
    }

    private final boolean processSolidAndStrokeOnStateChange(int[] r14) {
        ColorStateList r0 = this.solidColors;
        boolean r1 = false;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        ColorStateList r3 = this.solidColors;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        a r5 = Companion;
        if (r5.a() == false) goto L14;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][processSolidAndStrokeOnStateChange] " + ("state=" + a.a(r5, r14) + ", solidCurrent=" + a.b(r5, this.targetSolidColor) + ", solidTarget=" + a.b(r5, r4)));
    L14:
        if (r4 == this.targetSolidColor) goto L19;
        if (r4 != r2) goto L17;
        boolean r6 = true;
    L18:
        updateSolidColor(r4, r6);
        this.targetSolidColor = r4;
        boolean r7 = true;
    L20:
        ColorStateList r8 = this.strokeColors;
        if (r8 != null) goto L23;
        int r9 = 0;
    L24:
        ColorStateList r10 = this.strokeColors;
        if (r10 != null) goto L27;
        int r11 = 0;
    L29:
        if (r5.a() == false) goto L32;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][processSolidAndStrokeOnStateChange] " + ("state=" + a.a(r5, r14) + ", strokeCurrent=" + a.b(r5, this.targetStrokeColor) + ", strokeTarget=" + a.b(r5, r11)));
    L32:
        if (r11 == this.targetStrokeColor) goto L37;
        if (r11 != r9) goto L35;
        r1 = true;
    L35:
        updateStrokeColor(r11, r1);
        this.targetStrokeColor = r11;
        return true;
    L37:
        return r7;
    L27:
        r11 = r10.getColorForState(r14, r9);
        goto L29
    L23:
        r9 = r8.getDefaultColor();
        goto L24
    L17:
        r6 = false;
        goto L18
    L19:
        r7 = false;
        goto L20
    L9:
        r4 = r3.getColorForState(r14, r2);
        goto L10
    L5:
        r2 = r0.getDefaultColor();
        goto L6
    }

    public static final void setDEBUGGABLE(boolean r1) {
        Companion.a(r1);
    }

    public static /* synthetic */ void setMaterialConfig$default(OMaterialDrawable r1, com.obric.oui.material.c r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfig(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfig");
    }

    public static /* synthetic */ void setMaterialConfigs$default(OMaterialDrawable r1, com.obric.oui.material.c[] r2, int r3, int r4, boolean r5, int r6, Object r7) {
        if (r7 != null) goto L15;
        if ((r6 & 2) == 0) goto L7;
        r3 = 2;
    L7:
        if ((r6 & 4) == 0) goto L10;
        r4 = 1;
    L10:
        if ((r6 & 8) == 0) goto L12;
        r5 = true;
    L12:
        r1.setMaterialConfigs(r2, r3, r4, r5);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialConfigs");
    }

    private final void setMaterialToEffectObjectIfNotInit(Object r4, int r5, com.obric.oui.material.c r6) {
        if (this.isCallbackInitArray[r5].booleanValue() == true) goto L20;
        OMaterialHelper.a(r4, this.materialSrcType, this.materialDrawMode);
        Float r0 = r6.h();
        if (r0 == null) goto L8;
        OMaterialHelper.a(r4, ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).floatValue());
    L8:
        com.obric.oui.fluid.a r1 = r6.j();
        if (r1 == null) goto L12;
        OMaterialHelper.a(r4, true, r1.a());
    L12:
        com.obric.oui.shadow.a[] r7 = r6.i();
        if (r7 == null) goto L18;
        com.obric.oui.shadow.a r8 = (com.obric.oui.shadow.a) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r7), com.obric.oui.shadow.a.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L18;
        Paint r9 = this.shadowPaint;
        int[] r10 = com.obric.oui.shadow.a.f14456a.a(r8);
        OMaterialHelper.b(r9, Arrays.copyOf(r10, r10.length));
    L18:
        this.isCallbackInitArray[r5] = true;
        return;
    }

    public static /* synthetic */ void setSolidColors$default(OMaterialDrawable r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L26;
        if ((r14 & 2) == 0) goto L6;
        int r2 = r8;
    L8:
        if ((r14 & 4) == 0) goto L10;
        int r3 = r8;
    L12:
        if ((r14 & 8) == 0) goto L14;
        int r4 = r3;
    L16:
        if ((r14 & 16) == 0) goto L18;
        int r5 = r2;
    L20:
        if ((r14 & 32) == 0) goto L22;
        int r6 = r8;
    L23:
        r7.setSolidColors(r8, r2, r3, r4, r5, r6);
        return;
    L22:
        r6 = r13;
        goto L23
    L18:
        r5 = r12;
        goto L20
    L14:
        r4 = r11;
        goto L16
    L10:
        r3 = r10;
        goto L12
    L6:
        r2 = r9;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSolidColors");
    }

    public static /* synthetic */ void setStrokeConfigs$default(OMaterialDrawable r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if (r18 != null) goto L26;
        if ((r17 & 4) == 0) goto L6;
        int r4 = r11;
    L8:
        if ((r17 & 8) == 0) goto L10;
        int r5 = r11;
    L12:
        if ((r17 & 16) == 0) goto L14;
        int r6 = r5;
    L16:
        if ((r17 & 32) == 0) goto L18;
        int r7 = r4;
    L20:
        if ((r17 & 64) == 0) goto L22;
        int r8 = r11;
    L23:
        r9.setStrokeConfigs(r10, r11, r4, r5, r6, r7, r8);
        return;
    L22:
        r8 = r16;
        goto L23
    L18:
        r7 = r15;
        goto L20
    L14:
        r6 = r14;
        goto L16
    L10:
        r5 = r13;
        goto L12
    L6:
        r4 = r12;
        goto L8
    L26:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStrokeConfigs");
    }

    private final boolean updateBlendConfigs(final Object r17, final int r18, boolean r19, final com.obric.oui.color.a[] r20, final com.obric.oui.color.a[] r21) {
        a r2 = Companion;
        if (r2.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + ", enableAnimate=" + r19 + ", from=" + a.a(r2, r20) + ", to=" + a.a(r2, r21)));
    L5:
        ValueAnimator r3 = this.blendAnimatorArray[r18];
        com.obric.oui.color.a[] r14 = this.currentBlendConfigsArray[r18];
        if (r14 != null) goto L9;
    L7:
        boolean r15 = false;
    L11:
        boolean r16 = !r15;
        if (r3 != null) goto L15;
    L13:
        boolean r11 = false;
    L17:
        if (r11 == false) goto L23;
        if (r16 == false) goto L23;
        if (r2.a() == false) goto L22;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + " cancel conflicting blend animator, previousTarget=" + a.a(r2, this.currentBlendConfigsArray[r18]) + ", newTarget=" + a.a(r2, r21)));
    L22:
        r3.cancel();
    L34:
        if (r20 != null) goto L36;
    L42:
        if (r21 == null) goto L44;
        if (r19 == false) goto L52;
        ValueAnimator[] r9 = this.blendAnimatorArray;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new c(this, r18, r20, r21), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r10.addUpdateListener(new $$Lambda$OMaterialDrawable$SZqD4GnqGNiuE3l6u2lYNcwgdcU(r20, r21, this, r18, r17));
        r10.start();
        Unit r0 = Unit.INSTANCE;
        r9[r18] = r10;
    L55:
        this.currentBlendConfigsArray[r18] = r21;
        return true;
    L52:
        if (r2.a() == false) goto L54;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + " apply blend immediately, target=" + a.a(r2, r21)));
    L54:
        int[] r1 = OMaterialHelper.a(r21);
        OMaterialHelper.a(r17, Arrays.copyOf(r1, r1.length));
        this.drawBlendConfigsArray[r18] = r21;
        goto L55
    L44:
        if (r2.a() == false) goto L46;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + " clear blend effect"));
    L46:
        int[] r4 = OMaterialHelper.a(new com.obric.oui.color.a[0]);
        OMaterialHelper.a(r17, Arrays.copyOf(r4, r4.length));
        this.currentBlendConfigsArray[r18] = null;
        this.drawBlendConfigsArray[r18] = null;
        return true;
    L36:
        if (Arrays.equals(r20, r21) == false) goto L42;
        this.currentBlendConfigsArray[r18] = r21;
        if (r2.a() == false) goto L41;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + " stop at target because from/to are equal"));
    L41:
        return r16;
    L23:
        if (r3 != null) goto L26;
    L24:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L34;
        if (r2.a() == false) goto L56;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateBlendConfigs] " + ("index=" + r18 + " keep running blend animator because target is unchanged"));
        return false;
    L56:
        return false;
    L26:
        if (r3.isStarted() != true) goto L24;
        r5 = true;
        goto L28
    L15:
        if (r3.isStarted() != true) goto L13;
        r11 = true;
        goto L17
    L9:
        if (Arrays.equals(r14, r21) != true) goto L7;
        r15 = true;
        goto L11
    }

    /* JADX INFO: renamed from: updateBlendConfigs$lambda-36$lambda-35, reason: not valid java name */
    private static final void m1323updateBlendConfigs$lambda36$lambda35(com.obric.oui.color.a[] r2, com.obric.oui.color.a[] r3, OMaterialDrawable r4, int r5, Object r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$effectParams");
        Intrinsics.checkNotNullParameter(r7, "animator");
        Object r8 = r7.getAnimatedValue();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.Float");
        float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue();
        com.obric.oui.b.a.C0729a r0 = com.obric.oui.b.a.f13317a;
        Intrinsics.checkNotNull(r2);
        com.obric.oui.color.a[] r10 = r0.a(r2, r3, r9);
        r4.drawBlendConfigsArray[r5] = r10;
        a r11 = Companion;
        if (r11.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(r4) + "][blendAnimator] " + ("index=" + r5 + " update, progress=" + a.a(r11, r9) + ", blended=" + a.a(r11, r10)));
    L5:
        int[] r12 = OMaterialHelper.a(r10);
        OMaterialHelper.a(r6, Arrays.copyOf(r12, r12.length));
    }

    private final boolean updateOverlayBlendConfigs(final Object r17, final int r18, boolean r19, final com.obric.oui.color.a[] r20, final com.obric.oui.color.a[] r21) {
        a r2 = Companion;
        if (r2.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + ", enableAnimate=" + r19 + ", from=" + a.a(r2, r20) + ", to=" + a.a(r2, r21)));
    L5:
        ValueAnimator r3 = this.overlayBlendAnimatorArray[r18];
        com.obric.oui.color.a[] r13 = this.currentOverlayBlendConfigsArray[r18];
        if (r13 != null) goto L9;
    L7:
        boolean r14 = false;
    L11:
        boolean r15 = !r14;
        if (r3 != null) goto L15;
    L13:
        boolean r16 = false;
    L17:
        if (r16 == false) goto L23;
        if (r15 == false) goto L23;
        if (r2.a() == false) goto L22;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + " cancel conflicting overlay animator, previousTarget=" + a.a(r2, this.currentOverlayBlendConfigsArray[r18]) + ", newTarget=" + a.a(r2, r21)));
    L22:
        r3.cancel();
    L34:
        if (r20 != null) goto L36;
    L42:
        if (r21 == null) goto L44;
        if (r19 == false) goto L51;
        ValueAnimator[] r9 = this.overlayBlendAnimatorArray;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new d(this, r18, r20, r21), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r10.addUpdateListener(new $$Lambda$OMaterialDrawable$h7n9QOblUXWNvsug_GQLEZi8YQ(r20, r21, this, r17, r18));
        r10.start();
        Unit r0 = Unit.INSTANCE;
        r9[r18] = r10;
    L55:
        this.currentOverlayBlendConfigsArray[r18] = r21;
        return true;
    L51:
        int r1 = r21[0].a();
        int r4 = r21[0].b();
        if (r2.a() == false) goto L54;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + " apply overlay immediately, target=" + a.a(r2, r21)));
    L54:
        OMaterialHelper.a(r17, r1, 1.0f, r4);
        this.drawOverlayBlendConfigsArray[r18] = r21;
        goto L55
    L44:
        if (r2.a() == false) goto L46;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + " clear overlay blend cache"));
    L46:
        this.currentOverlayBlendConfigsArray[r18] = null;
        this.drawOverlayBlendConfigsArray[r18] = null;
        return true;
    L36:
        if (Arrays.equals(r20, r21) == false) goto L42;
        this.currentOverlayBlendConfigsArray[r18] = r21;
        if (r2.a() == false) goto L41;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + " stop at target because from/to are equal"));
    L41:
        return r15;
    L23:
        if (r3 != null) goto L26;
    L24:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L34;
        if (r2.a() == false) goto L56;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateOverlayBlendConfigs] " + ("index=" + r18 + " keep running overlay animator because target is unchanged"));
        return false;
    L56:
        return false;
    L26:
        if (r3.isStarted() != true) goto L24;
        r5 = true;
        goto L28
    L15:
        if (r3.isStarted() != true) goto L13;
        r16 = true;
        goto L17
    L9:
        if (Arrays.equals(r13, r21) != true) goto L7;
        r14 = true;
        goto L11
    }

    /* JADX INFO: renamed from: updateOverlayBlendConfigs$lambda-45$lambda-44, reason: not valid java name */
    private static final void m1324updateOverlayBlendConfigs$lambda45$lambda44(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r6, OMaterialDrawable r7, Object r8, int r9, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        Intrinsics.checkNotNullParameter(r8, "$effectParams");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Float");
        float r12 = ((Float) ZeusTransformUtils.preCheckCast(r11, Float.class, "com.obric.memorydata.plugin")).floatValue();
        com.obric.oui.b.a.C0729a r0 = com.obric.oui.b.a.f13317a;
        Intrinsics.checkNotNull(r5);
        com.obric.oui.color.a[] r13 = r0.a(r5, r6, r12);
        int r1 = r13[0].a();
        int r14 = r13[0].b();
        a r2 = Companion;
        if (r2.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(r7) + "][overlayAnimator] " + ("index=" + r9 + " update, progress=" + a.a(r2, r12) + ", blended=" + a.a(r2, r13)));
    L5:
        OMaterialHelper.a(r8, r1, 1.0f, r14);
        r7.drawOverlayBlendConfigsArray[r9] = r13;
    }

    private final void updateSolidColor(int r6, boolean r7) {
        a r0 = Companion;
        if (r0.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateSolidColor] " + ("animate=" + r7 + ", from=" + a.b(r0, this.animatedSolidColor) + ", to=" + a.b(r0, r6)));
    L5:
        ValueAnimator r1 = this.colorAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (r7 == false) goto L11;
        int r8 = this.animatedSolidColor;
        ValueAnimator r2 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new ArgbEvaluator(), TypeEvaluator.class, "com.obric.memorydata.plugin"), new Object[]{Integer.valueOf(r8), Integer.valueOf(r6)});
        r2.setDuration(getAnimDuration());
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new e(this, r8, r6), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r2.addUpdateListener(new $$Lambda$OMaterialDrawable$BPWH27FWvtZz9_ZTeBLAbozJsFs(this));
        r2.start();
        this.colorAnimator = r2;
        return;
    L11:
        this.animatedSolidColor = r6;
        setColor(r6);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-61$lambda-60, reason: not valid java name */
    private static final void m1325updateSolidColor$lambda61$lambda60(OMaterialDrawable r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r2.animatedSolidColor = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
        a r5 = Companion;
        if (r5.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(r2) + "][solidColorAnimator] " + Intrinsics.stringPlus("update, color=", a.b(r5, r2.animatedSolidColor)));
    L5:
        r2.setColor(r2.animatedSolidColor);
    }

    private final void updateStrokeColor(int r6, boolean r7) {
        a r0 = Companion;
        if (r0.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeColor] " + ("animate=" + r7 + ", from=" + a.b(r0, this.animatedStrokeColor) + ", to=" + a.b(r0, r6)));
    L5:
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        if (r7 == false) goto L11;
        int r8 = this.animatedStrokeColor;
        ValueAnimator r2 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new ArgbEvaluator(), TypeEvaluator.class, "com.obric.memorydata.plugin"), new Object[]{Integer.valueOf(r8), Integer.valueOf(r6)});
        r2.setDuration(getAnimDuration());
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new f(this, r8, r6), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r2.addUpdateListener(new $$Lambda$OMaterialDrawable$zfLLd8zVuwQ86_zeeFGWkkO9EE(this));
        r2.start();
        this.strokeAnimator = r2;
        return;
    L11:
        this.animatedStrokeColor = r6;
        setStroke(this.strokeWidth, r6);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-65$lambda-64, reason: not valid java name */
    private static final void m1326updateStrokeColor$lambda65$lambda64(OMaterialDrawable r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Int");
        r2.animatedStrokeColor = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
        a r5 = Companion;
        if (r5.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(r2) + "][strokeColorAnimator] " + Intrinsics.stringPlus("update, color=", a.b(r5, r2.animatedStrokeColor)));
    L5:
        r2.setStroke(r2.strokeWidth, r2.animatedStrokeColor);
    }

    private final boolean updateStrokeConfig(final View r17, Object r18, final int r19, boolean r20, final com.obric.oui.color.e r21, final com.obric.oui.color.e r22) {
        a r1 = Companion;
        if (r1.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r19 + ", enableAnimate=" + r20 + ", from=" + a.a(r1, r21) + ", to=" + a.a(r1, r22)));
    L5:
        ValueAnimator r2 = this.strokeAnimator;
        boolean r13 = !Intrinsics.areEqual(this.currentStrokeConfigArray[r19], r22);
        if (r2 != null) goto L9;
    L7:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L17;
        if (r13 == false) goto L17;
        if (r1.a() == false) goto L16;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r19 + " cancel conflicting stroke animator, previousTarget=" + a.a(r1, this.currentStrokeConfigArray[r19]) + ", newTarget=" + a.a(r1, r22)));
    L16:
        r2.cancel();
    L28:
        if (r21 != null) goto L30;
    L36:
        if (r22 != null) goto L39;
        return false;
    L39:
        if (r20 == false) goto L42;
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.setDuration(getAnimDuration());
        r10.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(getAnimInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r10.addUpdateListener(new $$Lambda$OMaterialDrawable$WSdYi4Qwdgf17sI7PSDVYAhX38(r21, r22, this, r19, r17));
        r10.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new g(this, r19, r21, r22, r17), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r10.start();
        this.strokeAnimator = r10;
    L45:
        this.currentStrokeConfigArray[r19] = r22;
        return true;
    L42:
        if (r1.a() == false) goto L44;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r19 + " apply stroke immediately, target=" + a.a(r1, r22)));
    L44:
        setStroke(com.obric.oui.common.util.h.a(r17, r22.a()), r22.b());
        this.drawStrokeConfigArray[r19] = r22;
        goto L45
    L30:
        if (Intrinsics.areEqual(r21, r22) == false) goto L36;
        this.currentStrokeConfigArray[r19] = r22;
        if (r1.a() == false) goto L35;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r19 + " stop at target because from/to are equal"));
    L35:
        return r13;
    L17:
        if (r2 != null) goto L20;
    L18:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L28;
        if (r1.a() == false) goto L47;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][updateStrokeConfig] " + ("index=" + r19 + " keep running stroke animator because target is unchanged"));
        return false;
    L47:
        return false;
    L20:
        if (r2.isStarted() != true) goto L18;
        r3 = true;
        goto L22
    L9:
        if (r2.isStarted() != true) goto L7;
        r15 = true;
        goto L11
    }

    /* JADX INFO: renamed from: updateStrokeConfig$lambda-53$lambda-52, reason: not valid java name */
    private static final void m1327updateStrokeConfig$lambda53$lambda52(com.obric.oui.color.e r2, com.obric.oui.color.e r3, OMaterialDrawable r4, int r5, View r6, ValueAnimator r7) {
        Intrinsics.checkNotNullParameter(r3, "$targetStrokeConfig");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$view");
        Intrinsics.checkNotNullParameter(r7, "animator");
        Object r8 = r7.getAnimatedValue();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.Float");
        float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.memorydata.plugin")).floatValue();
        com.obric.oui.b.c.a r0 = com.obric.oui.b.c.f13321a;
        Intrinsics.checkNotNull(r2);
        com.obric.oui.color.e r10 = r0.a(r2, r3, r9);
        if (r10 == null) goto L7;
        r4.drawStrokeConfigArray[r5] = r10;
        r4.setStroke(com.obric.oui.common.util.h.a(r6, r10.a()), r10.b());
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        if (this.enableShadow == true) goto L5;
    L7:
        super.draw(r3);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L7;
        drawMultiLayerShadow(r3);
        goto L7
    }

    public final void endAnimation() {
        if (Companion.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][endAnimation] force end all animators");
    L5:
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L9;
        r0.end();
    L9:
        ValueAnimator r1 = this.strokeAnimator;
        if (r1 == null) goto L13;
        r1.end();
    L13:
        ValueAnimator[] r2 = this.blendAnimatorArray;
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L14:
        if (r5 >= r3) goto L20;
        ValueAnimator r6 = r2[r5];
        if (r6 == null) goto L19;
        r6.end();
    L19:
        r5 = r5 + 1;
        goto L14
    L20:
        ValueAnimator[] r7 = this.overlayBlendAnimatorArray;
        int r8 = r7.length;
    L21:
        if (r4 >= r8) goto L27;
        ValueAnimator r9 = r7[r4];
        if (r9 == null) goto L26;
        r9.end();
    L26:
        r4 = r4 + 1;
        goto L21
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return (Drawable.ConstantState) ZeusTransformUtils.preCheckCast(new b(super.getConstantState(), getChangingConfigurations(), this.enableShadow, this.enableExtraStateChange, this.solidColors, this.strokeWidth, this.strokeColors, this.animDuration, this.enableStateChangeTransition, this.materialConfigs, this.materialSrcType, this.materialDrawMode, this.shadowConfigs, this.requireApiVersion), Drawable.ConstantState.class, "com.obric.memorydata.plugin");
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
        XmlPullParser r4 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r18, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "r");
        Intrinsics.checkNotNullParameter(r4, "parser");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        if (r20 != null) goto L5;
        TypedArray r9 = null;
    L6:
        if (r9 != null) goto L8;
        r9 = r17.obtainAttributes(r6, com.obric.memorydata.plugin.R.styleable.OMaterialDrawable);
    L8:
        int r10 = -1;
        boolean r12 = true;
        this.requireApiVersion = r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetMaterialApiVersion, "styleable", "OMaterialDrawable_oui_widgetMaterialApiVersion"), 1);     // Catch: Throwable -> L52 Exception -> L54
        ColorStateList r11 = r9.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_solidColor, "styleable", "OMaterialDrawable_oui_solidColor"));     // Catch: Throwable -> L52 Exception -> L54
        ColorStateList r13 = r9.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_strokeColor, "styleable", "OMaterialDrawable_oui_strokeColor"));     // Catch: Exception -> L50 Throwable -> L52
        r10 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_strokeWidth, "styleable", "OMaterialDrawable_oui_strokeWidth"), -1);     // Catch: Exception -> L48 Throwable -> L52
        this.enableShadow = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetEnableShadow, "styleable", "OMaterialDrawable_oui_widgetEnableShadow"), false);     // Catch: Exception -> L48 Throwable -> L52
        this.enableExtraStateChange = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetExtraStateChange, "styleable", "OMaterialDrawable_oui_widgetExtraStateChange"), true);     // Catch: Exception -> L48 Throwable -> L52
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L47;
        String r14 = r9.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetMaterial, "styleable", "OMaterialDrawable_oui_widgetMaterial"));     // Catch: Exception -> L48 Throwable -> L52
        int r7 = r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetMaterialSrcType, "styleable", "OMaterialDrawable_oui_widgetMaterialSrcType"), 2);     // Catch: Exception -> L48 Throwable -> L52
        int r0 = r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OMaterialDrawable_oui_widgetMaterialDrawMode, "styleable", "OMaterialDrawable_oui_widgetMaterialDrawMode"), 1);     // Catch: Exception -> L48 Throwable -> L52
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48 Throwable -> L52
        if (r8 != null) goto L16;
    L19:
        boolean r15 = true;
    L20:
        if (r15 == false) goto L22;
        this.materialSrcType = r7;     // Catch: Exception -> L48 Throwable -> L52
        this.materialDrawMode = r0;     // Catch: Exception -> L48 Throwable -> L52
        goto L47
    L22:
        if ((r17.getConfiguration().uiMode & 48) != 32) goto L25;
        r12 = false;
    L25:
        com.obric.oui.material.c[] r16 = MaterialToken.parseSet(r14, r12);     // Catch: Exception -> L48 Throwable -> L52
        if (r16 == null) goto L28;
        setMaterialConfigs(r16, r7, r0, false);     // Catch: Exception -> L48 Throwable -> L52
    L37:
        if (r11 != null) goto L47;
        com.obric.oui.material.c[] r1 = this.materialConfigs;     // Catch: Exception -> L48 Throwable -> L52
        if (r1 != null) goto L41;
    L40:
        ColorStateList r21 = null;
    L45:
        r11 = r21;
        goto L47
    L41:
        com.obric.oui.material.c r2 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r1), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48 Throwable -> L52
        if (r2 == null) goto L40;
        r21 = r2.a();     // Catch: Exception -> L48 Throwable -> L52
        goto L45
    L28:
        com.obric.oui.material.c r22 = MaterialToken.parse(r14, r12);     // Catch: Exception -> L48 Throwable -> L52
        if (r22 != null) goto L34;
        Function1<Boolean, com.obric.oui.material.c> r23 = MaterialToken.parse(r14);     // Catch: Exception -> L48 Throwable -> L52
        if (r23 != null) goto L33;
        r22 = null;
        goto L34
    L33:
        r22 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r23.invoke(Boolean.valueOf(r12)), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L48 Throwable -> L52
    L34:
        if (r22 == null) goto L37;
        setMaterialConfig(r22, r7, r0, false);     // Catch: Exception -> L48 Throwable -> L52
        goto L37
    L16:
        if (StringsKt.isBlank(r8) == true) goto L19;
        r15 = false;
    L47:
        r9.recycle();
    L59:
        super.inflate(r17, r4, r6, r20);
        if (Build.VERSION.SDK_INT < 24) goto L64;
        if (r11 != null) goto L64;
        r11 = getColor();
    L64:
        if (r11 != null) goto L66;
        r11 = ColorStateList.valueOf(0);
    L66:
        setSolidColors(r11);
        if (r13 != null) goto L69;
        r13 = ColorStateList.valueOf(0);
    L69:
        this.strokeColors = r13;
        if (r10 < 0) goto L80;
        setStrokeConfigs(r10, r13);
        return;
    L80:
        return;
    L48:
        e = e;
        ColorStateList r24 = r11;
    L57:
        Log.d(TAG, Intrinsics.stringPlus("inflate: ", e));     // Catch: Throwable -> L52
        r9.recycle();
        r11 = r24;
    L50:
        e = e;
        r24 = r11;
    L56:
        r13 = null;
    L54:
        e = e;
        r24 = null;
    L52:
        th = move-exception;
        r9.recycle();
        throw th;
    L5:
        r9 = r20.obtainStyledAttributes(r6, com.obric.memorydata.plugin.R.styleable.OMaterialDrawable, 0, 0);
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
        if (Companion.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][jumpToCurrentState] jump requested by framework");
    L5:
        endAnimation();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "r");
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r20) {
        Intrinsics.checkNotNullParameter(r20, "stateSet");
        int[] r8 = filterStateSet(r20);
        a r0 = Companion;
        if (r0.a() == false) goto L12;
        StringBuilder r1 = new StringBuilder().append('[').append(System.identityHashCode(this)).append("][").append("onStateChange").append("] ");
        StringBuilder r2 = new StringBuilder().append("rawState=").append(a.a(r0, r20)).append(", filteredState=").append(a.a(r0, r8)).append(", last=").append(a.b(r0, this.lastStateSet)).append(", callback=");
        Drawable.Callback r3 = getCallback();
        if (r3 != null) goto L7;
    L6:
        String r4 = null;
    L11:
        Log.d(TAG, r1.append(r2.append(r4).append(", respondToOtherStateChange=").append(this.enableExtraStateChange).toString()).toString());
        goto L12
    L7:
        Class<?> r5 = r3.getClass();
        if (r5 == null) goto L6;
        r4 = r5.getSimpleName();
    L12:
        Drawable.Callback r6 = getCallback();
        if (ZeusTransformUtils.instanceOf(r6, View.class) == false) goto L15;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
    L17:
        if (r11 != null) goto L19;
    L49:
        boolean r7 = processSolidAndStrokeOnStateChange(r8);
        if (r7 == false) goto L53;
        invalidateSelf();
    L53:
        if (super.onStateChange(r20) == true) goto L64;
        if (r7 == false) goto L57;
        return true;
    L57:
        return false;
    L64:
        return true;
    L19:
        if (OMaterialHelper.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L21;
    L48:
        OMaterialHelper.a(r11, 0, this.materialDrawMode);
        goto L49
    L21:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L48;
        com.obric.oui.material.c[] r14 = this.materialConfigs;
        if (r14 == null) goto L49;
        int r15 = r14.length;
        int r9 = 0;
        boolean r16 = false;
    L26:
        if (r9 >= r15) goto L40;
        int r10 = r9 + 1;
        j r12 = OMaterialHelper.a(r11, r10);
        if (r12 != null) goto L30;
        Object r13 = null;
    L31:
        if (r13 == null) goto L38;
        int r18 = r10;
        if (processMaterialOnStateChange(r11, r13, r9, r8, r14[r9]) == true) goto L37;
        if (r16 == true) goto L37;
        r16 = false;
    L39:
        r9 = r18;
    L37:
        r16 = true;
        goto L39
    L38:
        r18 = r10;
        goto L39
    L30:
        r13 = r12.a();
        goto L31
    L40:
        if (r16 == false) goto L42;
        invalidateSelf();
    L42:
        this.lastStateSet = (int[]) ZeusTransformUtils.preCheckCast(r20.clone(), int[].class, "com.obric.memorydata.plugin");
        if (super.onStateChange(r20) == true) goto L62;
        if (r16 == false) goto L47;
        return true;
    L47:
        return false;
    L62:
        return true;
    L15:
        r11 = null;
        goto L17
    }

    public final void setAnimDuration(long r1) {
        this.animDuration = r1;
    }

    public final void setAnimInterpolator(LinearInterpolator r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.animInterpolator = r2;
    }

    public final void setCallbackInitArray(Boolean[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isCallbackInitArray = r2;
    }

    public final void setEnableExtraStateChange(boolean r3) {
        if (this.enableExtraStateChange != r3) goto L5;
        return;
    L5:
        this.enableExtraStateChange = r3;
        if (Companion.a() == false) goto L8;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][setRespondToOtherStateChange] " + Intrinsics.stringPlus("enabled=", Boolean.valueOf(r3)));
    L8:
        Drawable.Callback r4 = getCallback();
        if (ZeusTransformUtils.instanceOf(r4, View.class) == false) goto L11;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
    L12:
        if (r5 == null) goto L14;
        int[] r6 = r5.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r6, "view.drawableState");
        onStateChange(r6);
        return;
    L14:
        int[] r7 = getState();
        Intrinsics.checkNotNullExpressionValue(r7, "state");
        onStateChange(r7);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public final void setEnableShadow(boolean r1) {
        this.enableShadow = r1;
        invalidateSelf();
    }

    public final void setEnableStateChangeTransition(boolean r1) {
        this.enableStateChangeTransition = r1;
    }

    public final void setMaterialConfig(com.obric.oui.material.c r9) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, 0, 0, false, 14, null);
    }

    public final void setMaterialConfig(com.obric.oui.material.c r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, 0, false, 12, null);
    }

    public final void setMaterialConfig(com.obric.oui.material.c r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "materialConfig");
        setMaterialConfig$default(this, r9, r10, r11, false, 8, null);
    }

    public final void setMaterialConfig(com.obric.oui.material.c r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "materialConfig");
        setMaterialConfigs(new com.obric.oui.material.c[]{r3}, r4, r5, r6);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c[] r8) {
        setMaterialConfigs$default(this, r8, 0, 0, false, 14, null);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c[] r8, int r9) {
        setMaterialConfigs$default(this, r8, r9, 0, false, 12, null);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c[] r8, int r9, int r10) {
        setMaterialConfigs$default(this, r8, r9, r10, false, 8, null);
    }

    public final void setMaterialConfigs(com.obric.oui.material.c[] r6, int r7, int r8, boolean r9) {
        int r1 = 0;
        View r2 = null;
        if (Companion.a() == false) goto L16;
        StringBuilder r0 = new StringBuilder().append('[').append(System.identityHashCode(this)).append("][").append("setMaterialConfigs").append("] ");
        StringBuilder r3 = new StringBuilder().append("count=");
        if (r6 != null) goto L7;
        int r4 = 0;
    L8:
        StringBuilder r5 = r3.append(r4).append(", srcType=").append(r7).append(", drawMode=").append(r8).append(", applyImmediately=").append(r9).append(", callback=");
        Drawable.Callback r10 = getCallback();
        if (r10 != null) goto L11;
    L10:
        String r11 = null;
    L15:
        Log.d(TAG, r0.append(r5.append(r11).toString()).toString());
        goto L16
    L11:
        Class<?> r12 = r10.getClass();
        if (r12 == null) goto L10;
        r11 = r12.getSimpleName();
        goto L15
    L7:
        r4 = r6.length;
    L16:
        this.materialConfigs = r6;
        this.materialSrcType = r7;
        this.materialDrawMode = r8;
        this.currentBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.drawOverlayBlendConfigsArray = new com.obric.oui.color.a[2][];
        this.currentStrokeConfigArray = new com.obric.oui.color.e[2];
        this.drawStrokeConfigArray = new com.obric.oui.color.e[2];
        this.lastStateSet = null;
        ValueAnimator[] r13 = this.blendAnimatorArray;
        int r14 = r13.length;
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L23;
        ValueAnimator r16 = r13[r15];
        if (r16 == null) goto L22;
        r16.cancel();
    L22:
        r15 = r15 + 1;
        goto L17
    L23:
        ValueAnimator[] r17 = this.overlayBlendAnimatorArray;
        int r18 = r17.length;
    L24:
        if (r1 >= r18) goto L31;
        ValueAnimator r19 = r17[r1];
        if (r19 == null) goto L29;
        r19.cancel();
    L29:
        r1 = r1 + 1;
        goto L24
    L31:
        if (r6 == null) goto L40;
        com.obric.oui.material.c r20 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r6), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L40;
        ColorStateList r21 = r20.a();
        if (r21 == null) goto L40;
        setSolidColors(r21);
    L40:
        Drawable.Callback r22 = getCallback();
        if (ZeusTransformUtils.instanceOf(r22, View.class) == false) goto L43;
        r2 = (View) ZeusTransformUtils.preCheckCast(r22, View.class, "com.obric.memorydata.plugin");
    L43:
        if (r9 == false) goto L46;
        if (r2 == null) goto L46;
        int[] r23 = r2.getDrawableState();
        Intrinsics.checkNotNullExpressionValue(r23, "view.drawableState");
        onStateChange(r23);
    L46:
        invalidateSelf();
    }

    public final void setRequireApiVersion(int r1) {
        this.requireApiVersion = r1;
    }

    public final void setShadowConfigs(com.obric.oui.shadow.a[] r1) {
        this.shadowConfigs = r1;
        invalidateSelf();
    }

    public final void setSolidColors(int r17, int r18, int r19, int r20, int r21, int r22) {
        setSolidColors(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r20, r20, r19, r19, r19, r19, r18, r21, r19, r20, r22, r17}));
    }

    public final void setSolidColors(ColorStateList r3) {
        this.solidColors = r3;
        if (r3 == null) goto L11;
        int r4 = r3.getColorForState(getState(), r3.getDefaultColor());
        this.targetSolidColor = r4;
        this.animatedSolidColor = r4;
        ValueAnimator r5 = this.colorAnimator;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        setColor(this.targetSolidColor);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] r9) {
        Intrinsics.checkNotNullParameter(r9, "stateSet");
        int[] r0 = filterStateSet(r9);
        a r1 = Companion;
        if (r1.a() == false) goto L5;
        Log.d(TAG, '[' + System.identityHashCode(this) + "][setState] " + ("rawState=" + a.a(r1, r9) + ", filteredState=" + a.a(r1, r0) + ", respondToOtherStateChange=" + this.enableExtraStateChange));
    L5:
        Drawable.Callback r2 = getCallback();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L8;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == null) goto L52;
        int r4 = 0;
        if (OMaterialHelper.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L13;
    L34:
        OMaterialHelper.a(r3, 0, this.materialDrawMode);
        ColorStateList r5 = this.solidColors;
        if (r5 != null) goto L37;
        int r6 = 0;
    L38:
        ColorStateList r7 = this.solidColors;
        if (r7 != null) goto L41;
        int r8 = 0;
    L42:
        setColor(r8);
        ColorStateList r10 = this.strokeColors;
        if (r10 != null) goto L45;
        int r11 = 0;
    L46:
        int r12 = com.obric.oui.common.util.h.a(r3, this.strokeWidth);
        ColorStateList r13 = this.strokeColors;
        if (r13 == null) goto L50;
        r4 = r13.getColorForState(r0, r11);
    L50:
        setStroke(r12, r4);
        goto L52
    L45:
        r11 = r10.getDefaultColor();
        goto L46
    L41:
        r8 = r7.getColorForState(r0, r6);
        goto L42
    L37:
        r6 = r5.getDefaultColor();
        goto L38
    L13:
        if (this.envMaterialApiVersion < this.requireApiVersion) goto L34;
        Boolean[] r14 = this.isCallbackInitArray;
        int r15 = r14.length;
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L20;
        if (r14[r16].booleanValue() == false) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        boolean r17 = false;
    L21:
        if (r17 == true) goto L52;
        com.obric.oui.material.c[] r18 = this.materialConfigs;
        if (r18 == null) goto L52;
        int r19 = r18.length;
    L26:
        if (r4 >= r19) goto L52;
        int r20 = r4 + 1;
        j r21 = OMaterialHelper.a(r3, r20);
        if (r21 != null) goto L30;
        Object r22 = null;
    L31:
        if (r22 == null) goto L33;
        setMaterialToEffectObjectIfNotInit(r22, r4, r18[r4]);
    L33:
        r4 = r20;
        goto L26
    L30:
        r22 = r21.a();
        goto L31
    L20:
        r17 = true;
    L52:
        return super.setState(r9);
    L8:
        r3 = null;
        goto L9
    }

    public final void setStrokeConfigs(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        this.strokeWidth = r19;
        ColorStateList r2 = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new int[]{r23, r23, r22, r22, r22, r22, r21, r24, r22, r23, r25, r20});
        this.strokeColors = r2;
        setStrokeConfigs(r19, r2);
    }

    public final void setStrokeConfigs(int r1, ColorStateList r2) {
        if (r2 == null) goto L10;
        int r3 = r2.getDefaultColor();
        this.targetStrokeColor = r3;
        this.animatedStrokeColor = r3;
        ValueAnimator r4 = this.strokeAnimator;
        if (r4 == null) goto L8;
        r4.cancel();
    L8:
        setStroke(r1, this.targetStrokeColor);
        return;
    }
}
