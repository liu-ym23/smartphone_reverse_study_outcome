package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.spec.spring.b;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.h;
import com.obric.oui.material.l;
import com.obric.oui.material.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\b&\u0018\u0000 \u0094\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0094\u0001B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\"H\u0016J\u0010\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020\tH\u0016J\u0010\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020\rH\u0014J\b\u0010W\u001a\u00020QH\u0004J\u0010\u0010X\u001a\u00020Q2\u0006\u0010Y\u001a\u00020\"H\u0002J\u0010\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0004J\u0010\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020Q2\u0006\u0010_\u001a\u00020\"H\u0002J\b\u0010`\u001a\u00020\rH\u0014J.\u0010a\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dH&J\u0018\u0010e\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010c\u001a\u00020dH\u0004J\u0018\u0010f\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010c\u001a\u00020dH\u0002J\u001a\u0010g\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010Y\u001a\u00020\"H\u0016J\u0018\u0010h\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M2\u0006\u0010i\u001a\u00020\rH\u0004J\b\u0010j\u001a\u00020QH\u0004J\b\u0010k\u001a\u00020QH\u0004J\u0012\u0010l\u001a\u00020Q2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010o\u001a\u00020Q2\b\b\u0001\u0010p\u001a\u00020\tH\u0016J\u001c\u0010q\u001a\u00020Q2\b\b\u0001\u0010r\u001a\u00020\t2\b\b\u0001\u0010s\u001a\u00020\tH\u0016JA\u0010q\u001a\u00020Q2\b\b\u0001\u0010r\u001a\u00020\t2\b\b\u0001\u0010s\u001a\u00020\t2\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<H\u0016¢\u0006\u0002\u0010vJ0\u0010q\u001a\u00020Q2\b\b\u0001\u0010r\u001a\u00020\t2\b\b\u0001\u0010s\u001a\u00020\t2\b\u0010w\u001a\u0004\u0018\u0001002\b\u0010x\u001a\u0004\u0018\u000100H\u0016J\u0010\u0010y\u001a\u00020Q2\u0006\u0010z\u001a\u00020\rH\u0004J\u0010\u0010{\u001a\u00020Q2\u0006\u0010i\u001a\u00020\rH\u0004J\u0010\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020\"H\u0016J&\u0010~\u001a\u00020Q2\b\u0010w\u001a\u0004\u0018\u0001002\b\u0010x\u001a\u0004\u0018\u0001002\b\b\u0002\u0010\u007f\u001a\u00020\"H\u0017J)\u0010\u0080\u0001\u001a\u00020Q2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010=2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010\u007f\u001a\u00020\"H\u0017J9\u0010\u0080\u0001\u001a\u00020Q2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\b\b\u0002\u0010\u007f\u001a\u00020\"H\u0017¢\u0006\u0003\u0010\u0083\u0001J\u0013\u0010\u0084\u0001\u001a\u00020Q2\b\b\u0001\u0010p\u001a\u00020\tH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020\"2\u0006\u0010_\u001a\u00020\"H\u0014J=\u0010\u0086\u0001\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\r2\u0007\u0010\u0088\u0001\u001a\u00020\r2\u000f\u0010\u0089\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020Q2\u0007\u0010\u008c\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020Q2\u0006\u0010(\u001a\u00020\"H\u0016J<\u0010\u008e\u0001\u001a\u00020Q2\u0006\u0010i\u001a\u00020\r2\u0007\u0010\u008f\u0001\u001a\u00020\r2\u000f\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010M2\u000f\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0004J\u0011\u0010\u0092\u0001\u001a\u00020Q2\u0006\u0010}\u001a\u00020\"H\u0014J\u0015\u0010\u0093\u0001\u001a\u00020N*\u00020N2\u0006\u0010i\u001a\u00020\rH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0001X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0001X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010!\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&R\u001a\u0010,\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\u001c\u00108\u001a\u0004\u0018\u000100X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00102\"\u0004\b:\u00104R$\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u0084\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u0084\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010O\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0095\u0001"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animAccuracy", "", "bgColorDisabled", "getBgColorDisabled", "()I", "setBgColorDisabled", "(I)V", "bgColorNormal", "getBgColorNormal", "setBgColorNormal", "contentContainer", "getContentContainer", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentContainer", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentView", "getContentView", "setContentView", "currentTheme", "getCurrentTheme", "setCurrentTheme", "enableMaterial", "", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "initScale", "isBackdropView", "setBackdropView", "isMaterialFromDrawable", "setMaterialFromDrawable", "materialApplied", "getMaterialApplied", "setMaterialApplied", "materialDisabledTokenString", "", "getMaterialDisabledTokenString", "()Ljava/lang/String;", "setMaterialDisabledTokenString", "(Ljava/lang/String;)V", "materialSrcType", "getMaterialSrcType", "setMaterialSrcType", "materialTokenString", "getMaterialTokenString", "setMaterialTokenString", "materials", "", "Lcom/obric/oui/material/MaterialConfig;", "getMaterials", "()[Lcom/obric/oui/material/MaterialConfig;", "setMaterials", "([Lcom/obric/oui/material/MaterialConfig;)V", "[Lcom/obric/oui/material/MaterialConfig;", "materialsDisabled", "getMaterialsDisabled", "setMaterialsDisabled", "pressAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "pressColor", "pressScale", "releaseAnim", "shadowAlphaProgress", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsPressed", "applyContentMaterial", "", "apply", "applyDynamicTheme", "themeStyle", "applyPressScaleForAnimation", "scale", "cancelPressAnimation", "checkColorfulBgMaterial", "isDarkTheme", "currentShadowSnapshot", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "doPressAnim", "pressed", "getCurrentPressScaleForAnimation", "initContent", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "initMaterials", "initShadows", "initView", "normalShadowSnapshotWithAlphaProgress", "progress", "resetPressAnimationState", "resetPressScaleForAnimation", "setBackdropTarget", "view", "Landroid/view/View;", "setBgColor", TypedValues.Custom.S_COLOR, "setBgColors", "normal", "disabled", "normalMaterialConfigs", "disabledMaterialConfigs", "(II[Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;)V", "tokenString", "disabledTokenString", "setContentSelfBlur", "radius", "setContentShadowAlphaProgress", "setEnabled", "enabled", "setMaterialByTokenString", "invalidate", "setMaterialConfigs", "material", "materialDisabled", "([Lcom/obric/oui/material/MaterialConfig;[Lcom/obric/oui/material/MaterialConfig;Z)V", "setPressColor", "shouldHandlePressAnimation", "startPressScaleAnimation", "startScale", "targetScale", "shadowsFrom", "shadowsTo", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateContentShadowAlphaTransition", "fraction", "fromShadows", "toShadows", "updateUIOnEnableChanged", "copyWithAlphaProgress", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OShadowFrame extends OUIFrameLayout implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13395b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f13396a;
    protected OUIFrameLayout c;
    protected OUIFrameLayout d;
    private d e;
    private int f;
    private int g;
    private int h;
    private final float i;
    private float j;
    private float k;
    private List<k> l;
    private List<k> m;
    private float n;
    private int o;
    private boolean p;
    private String q;
    private String r;
    private c[] s;
    private boolean t;
    private boolean u;
    private c[] v;
    private int w;
    private boolean x;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/button/OShadowFrame$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13395b = new a(null);
    }

    public OShadowFrame(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OShadowFrame(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OShadowFrame(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OShadowFrame(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r11, null, 8, null);
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 0.01f;
        this.n = 1.0f;
        boolean r15 = true;
        this.u = true;
        this.w = 2;
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        r15 = false;
    L8:
        this.p = r15;
        this.t = r15;
        a(r13, r14);
        return;
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        goto L7
    }

    public /* synthetic */ OShadowFrame(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    private final k a(k r3, float r4) {
        k r2 = r3.j();
        r2.a(ColorUtils.setAlphaComponent(r3.a(), RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(r3.a()) * r4), 0, 255)));
        return r2;
    }

    private final void a(Context r14, AttributeSet r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r0 = r16.obtainStyledAttributes(r17, R.styleable.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r0, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        if (this.p == false) goto L5;
        boolean r2 = r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetEnableMaterial, "styleable", "OShadowFrame_oui_widgetEnableMaterial"), true);
        this.p = r2;
        this.t = r2;
    L5:
        setContentView(new OUIFrameLayout(r16, null, 0, null, 14, null));
        setContentContainer(new OUIFrameLayout(r16, null, 0, null, 14, null));
        getContentView().setDuplicateParentStateEnabled(true);
        getContentContainer().setDuplicateParentStateEnabled(true);
        OUIFrameLayout r7 = null;
        this.g = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColor, "styleable", "OShadowFrame_oui_widgetBgColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_floating_button_bg_color_1, TypedValues.Custom.S_COLOR, "oui_floating_button_bg_color_1"), null));
        this.h = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, "styleable", "OShadowFrame_oui_widgetBgColorDisabled"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_floating_button_bg_color_1, TypedValues.Custom.S_COLOR, "oui_floating_button_bg_color_1"), null));
        if (this.g == 0) goto L8;
        getContentView().setBackgroundColor(this.g);
    L8:
        this.j = r0.getFloat(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressScale, "styleable", "OShadowFrame_oui_widgetPressScale"), 1.0f);
        setChangeAlphaWhenPress(false);
        int r3 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingL, "styleable", "OShadowFrame_oui_widgetPaddingL"), 0);
        int r4 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingR, "styleable", "OShadowFrame_oui_widgetPaddingR"), 0);
        int r5 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingT, "styleable", "OShadowFrame_oui_widgetPaddingT"), 0);
        int r6 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPaddingB, "styleable", "OShadowFrame_oui_widgetPaddingB"), 0);
        int r8 = r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetRadius, "styleable", "OShadowFrame_oui_widgetRadius"), 0);
        Drawable r11 = r0.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialBackground, "styleable", "OShadowFrame_oui_widgetMaterialBackground"));
        getContentView().setRadius(r8);
        getContentContainer().setPadding(r3, r5, r4, r6);
        getContentContainer().setRadius(r8);
        this.f = r0.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressColor, "styleable", "OShadowFrame_oui_widgetPressColor"), 0);
        getContentView().setOverridePressColor(this.f);
        getContentView().refreshColors("OShadowFrame");
        getContentView().addView((View) ZeusTransformUtils.preCheckCast(getContentContainer(), View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setShadowCornerRadius(r8);
        a(r16, (FrameLayout) ZeusTransformUtils.preCheckCast(getContentContainer(), FrameLayout.class, "com.obric.memorydata.plugin"), r17, r0);
        if (r11 == null) goto L11;
        boolean r18 = true;
    L12:
        this.x = r18;
        if (r18 == false) goto L15;
        getContentView().setBackground(r11);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L15:
        com.obric.oui.c.c r19 = com.obric.oui.c.c.f13403a;
        OUIFrameLayout r110 = getContentView();
        if (r110 != null) goto L19;
    L17:
        r110 = null;
    L20:
        com.obric.oui.common.style.a r111 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r110, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L24;
        r111.setChangeAlphaWhenDisable(false);
    L24:
        com.obric.oui.c.c r112 = com.obric.oui.c.c.f13403a;
        OUIFrameLayout r113 = getContentView();
        if (r113 != null) goto L28;
    L26:
        r113 = null;
    L29:
        com.obric.oui.common.style.a r114 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r113, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L33;
        r114.setChangeAlphaWhenEnabledChanged(false);
    L33:
        com.obric.oui.c.c r115 = com.obric.oui.c.c.f13403a;
        OUIFrameLayout r116 = getContentContainer();
        if (r116 != null) goto L37;
    L39:
        com.obric.oui.common.style.a r117 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L43;
        r117.setChangeAlphaWhenDisable(false);
    L43:
        setChangeAlphaWhenDisable(false);
        b(r16, r0);
        r0.recycle();
        setClipChildren(false);
        setClickable(true);
        a(isEnabled());
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r116, com.obric.oui.common.style.a.class) == false) goto L39;
        r7 = r116;
        goto L39
    L28:
        if (ZeusTransformUtils.instanceOf(r113, com.obric.oui.common.style.a.class) == false) goto L26;
    L19:
        if (ZeusTransformUtils.instanceOf(r110, com.obric.oui.common.style.a.class) == false) goto L17;
    L11:
        r18 = false;
        goto L12
    }

    public static /* synthetic */ void a(OShadowFrame r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = true;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaterialByTokenString");
    }

    private final d b(final float r17, final float r18, List<k> r19, List<k> r20) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.foundation.animation.builder.c.a r9 = new com.obric.common.oea.foundation.animation.builder.c.a();
        b r0 = com.obric.common.oea.foundation.animation.spec.b.a(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3, 0, 4, null);
        r0.a(this.k);
        Unit r1 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.builder.c.a.a(r9, r17, r18, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(r0, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new OShadowFrame$startPressScaleAnimation$2(this, r17, r18, r4, r8), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new OShadowFrame$startPressScaleAnimation$3(this, r8), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    private final void b(Context r6, TypedArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List<k> r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetShadowNormal, "styleable", "OShadowFrame_oui_widgetShadowNormal"));
        if (r0 == null) goto L5;
        this.l = r0;
        Intrinsics.checkNotNull(r0);
        k r1 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, 0), k.class, "com.obric.memorydata.plugin");
        List<k> r3 = this.l;
        Intrinsics.checkNotNull(r3);
        a(r1, (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), k.class, "com.obric.memorydata.plugin"));
    L5:
        List<k> r9 = f.a(r8, r7, ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetShadowPressed, "styleable", "OShadowFrame_oui_widgetShadowPressed"));
        if (r9 == null) goto L9;
        this.m = r9;
        return;
    }

    private final void c(boolean r6) {
        ColorUtils.setAlphaComponent(this.g, 48);
        if (com.obric.oui.color.d.c(this.g) == false) goto L9;
        c[] r0 = com.obric.oui.material.d.f14017a.a((c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r6)), c[].class, "com.obric.memorydata.plugin"), this.g);
        if (this.h == 0) goto L7;
        c[] r7 = com.obric.oui.material.d.f14017a.a((c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r6)), c[].class, "com.obric.memorydata.plugin"), this.h);
    L8:
        a(r0, r7, false);
        return;
    L7:
        r7 = null;
        goto L8
    L9:
        String r1 = this.q;
        if (r1 == null) goto L15;
        c[] r2 = MaterialToken.parseSet(r1, !r6);
        this.s = r2;
        String r3 = this.r;
        if (r3 == null) goto L14;
        this.v = MaterialToken.parseSet(r3, !r6);
        return;
    L14:
        this.v = r2;
        return;
    L15:
        a((c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r6)), c[].class, "com.obric.memorydata.plugin"), (c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating.invoke(Boolean.valueOf(!r6)), c[].class, "com.obric.memorydata.plugin"), false);
    }

    private final void d(boolean r4) {
        if (isEnabled() == true) goto L7;
        com.obric.oui.c.a.b.b("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L7:
        if (b(r4) == true) goto L10;
        g();
        return;
    L10:
        com.obric.oui.c.a.b.b("OShadowFrame", Intrinsics.stringPlus("doPressAnim: ", Boolean.valueOf(r4)));
        g();
        float r0 = getCurrentPressScaleForAnimation();
        List<k> r1 = j();
        if (r4 == false) goto L13;
        this.f13396a = b(r0, this.j, r1, this.m);
        return;
    L13:
        this.e = b(r0, this.i, r1, this.l);
    }

    public void a(float r1) {
        setScaleX(r1);
        setScaleY(r1);
    }

    public final void a(float r3, float r4, List<k> r5, List<k> r6) {
        List<k> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<k> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<k> r9 = k.f13495a.a(r4, r7, r8);
        if (r9 == null) goto L5;
        this.n = RangesKt.coerceIn(r3, 0.0f, 1.0f);
        updateShadows(r9);
        return;
    L5:
        setContentShadowAlphaProgress(r3);
    }

    public void a(int r2) {
        if (this.o == r2) goto L14;
        this.o = r2;
        String r3 = this.q;
        if (r3 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r3, !f()));
    L8:
        String r4 = this.r;
        if (r4 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r4, !f()));
    L12:
        a(isEnabled());
        return;
    }

    public void a(int r1, int r2) {
        this.g = r1;
        this.h = r2;
        boolean r3 = com.obric.oui.color.d.a(r1);
        c(r3);
        if (r3 == false) goto L5;
        int r4 = 2;
    L7:
        if (r4 == this.o) goto L10;
        a(r4);
        return;
    L10:
        a(isEnabled());
        return;
    L5:
        r4 = 1;
        goto L7
    }

    public void a(int r1, int r2, String r3, String r4) {
        this.g = r1;
        this.h = r2;
        if (r3 == null) goto L7;
        a(r3, r4, false);
    L7:
        if (com.obric.oui.color.d.a(r1) == false) goto L9;
        int r5 = 2;
    L11:
        if (r5 == this.o) goto L14;
        a(r5);
        return;
    L14:
        a(isEnabled());
        return;
    L9:
        r5 = 1;
        goto L11
    }

    public void a(int r1, int r2, c[] r3, c[] r4) {
        this.g = r1;
        this.h = r2;
        a(r3, r4, false);
        if (com.obric.oui.color.d.a(r1) == false) goto L5;
        int r5 = 2;
    L7:
        if (r5 == this.o) goto L10;
        a(r5);
        return;
    L10:
        a(isEnabled());
        return;
    L5:
        r5 = 1;
        goto L7
    }

    public final void a(Context r7, TypedArray r8) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r8, "typedArray");
        this.w = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialSrcType, "styleable", "OShadowFrame_oui_widgetMaterialSrcType"), 2);
        String r9 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterial, "styleable", "OShadowFrame_oui_widgetMaterial"));
        boolean r2 = com.obric.oui.color.d.c(this.g);
        if (r9 != null) goto L6;
        if (r2 == true) goto L6;
        r9 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));
    L6:
        this.q = r9;
        boolean r3 = f();
        if (r2 == false) goto L12;
        this.s = com.obric.oui.material.d.f14017a.a((c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r3)), c[].class, "com.obric.memorydata.plugin"), this.g);
        if (this.h == 0) goto L17;
        this.v = com.obric.oui.material.d.f14017a.a((c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Floating_Tinted.invoke(Boolean.valueOf(!r3)), c[].class, "com.obric.memorydata.plugin"), this.h);
    L17:
        if (this.s != null) goto L20;
        this.p = false;
        this.t = false;
        return;
    L20:
        return;
    L12:
        if (this.q == null) goto L17;
        this.s = MaterialToken.parseSet(r9, !r3);
        String r10 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialDisabled, "styleable", "OShadowFrame_oui_widgetMaterialDisabled"));
        this.r = r10;
        if (r10 == null) goto L17;
        this.v = MaterialToken.parseSet(r10, !r3);
        goto L17
    }

    public abstract void a(Context r1, FrameLayout r2, AttributeSet r3, TypedArray r4);

    public void a(String r4, String r5, boolean r6) {
        if ((!Intrinsics.areEqual(this.q, r4)) == false) goto L5;
        this.q = r4;
        this.s = MaterialToken.parseSet(r4, !f());
    L5:
        String r7 = this.r;
        if (r7 != null) goto L8;
        boolean r8 = true;
    L10:
        if ((!r8) == false) goto L12;
        this.r = r5;
        this.v = MaterialToken.parseSet(r5, !f());
    L12:
        if (r6 == false) goto L15;
        a(isEnabled());
        return;
    L15:
        return;
    L8:
        r8 = StringsKt.contentEquals((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    public void a(boolean r17) {
        if (this.t == true) goto L10;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        OUIFrameLayout r1 = getContentView();
        if (r17 == false) goto L7;
        int r0 = this.g;
    L8:
        r1.setBackgroundColor(r0);
        return;
    L7:
        r0 = this.h;
        goto L8
    L10:
        if (this.x == false) goto L12;
        return;
    L12:
        getContentView().setBackgroundColor(0);
        if (r17 == false) goto L18;
        c[] r3 = this.s;
        if (r3 == null) goto L25;
        l.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.memorydata.plugin"), r3, false, getMaterialSrcType(), null, 10, null);
        return;
    L25:
        return;
    L18:
        c[] r10 = this.v;
        if (r10 == null) goto L26;
        l.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.memorydata.plugin"), r10, false, getMaterialSrcType(), null, 10, null);
        return;
    }

    public void a(c[] r1, c[] r2, boolean r3) {
        this.s = r1;
        this.v = r2;
        this.q = null;
        this.r = null;
        if (r3 == false) goto L6;
        a(isEnabled());
        return;
    }

    public final List<k> b(float r6) {
        List<k> r0 = this.l;
        if (r0 != null) goto L5;
        return null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r2.add(a((k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.memorydata.plugin"), r6));
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.material.h
    public void b(int r3) {
        this.w = r3;
        l.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.memorydata.plugin"), r3);
    }

    public boolean b(boolean r1) {
        return true;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        boolean r0 = super.dispatchTouchEvent(r3);
        int r4 = r3.getAction();
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L6;
    L8:
        d(false);
    L10:
        return r0;
    L6:
        if (r4 == 3) goto L8;
    L9:
        d(true);
        goto L10
    }

    public boolean f() {
        int r0 = this.g;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (this.o != 2) goto L9;
    L12:
        return true;
    L9:
        if (com.obric.oui.color.d.a(r0) == true) goto L12;
        return false;
    }

    public final void g() {
        d r0 = this.f13396a;
        if (r0 == null) goto L6;
        d.a(r0, false, 1, null);
    L6:
        d r1 = this.e;
        if (r1 == null) goto L10;
        d.a(r1, false, 1, null);
    L10:
        this.f13396a = null;
        this.e = null;
    }

    public final int getBgColorDisabled() {
        return this.h;
    }

    public final int getBgColorNormal() {
        return this.g;
    }

    public final OUIFrameLayout getContentContainer() {
        OUIFrameLayout r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public float getCurrentPressScaleForAnimation() {
        return getScaleX();
    }

    public final int getCurrentTheme() {
        return this.o;
    }

    public final boolean getEnableMaterial() {
        return this.p;
    }

    public final boolean getMaterialApplied() {
        return this.t;
    }

    public final String getMaterialDisabledTokenString() {
        return this.r;
    }

    public final int getMaterialSrcType() {
        return this.w;
    }

    public final String getMaterialTokenString() {
        return this.q;
    }

    public final c[] getMaterials() {
        return this.s;
    }

    public final c[] getMaterialsDisabled() {
        return this.v;
    }

    public final void h() {
        a(this.i);
    }

    public final void i() {
        g();
        h();
        List<k> r0 = this.l;
        k r1 = null;
        if (r0 != null) goto L5;
        k r2 = null;
    L6:
        List<k> r3 = this.l;
        if (r3 == null) goto L10;
        r1 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), k.class, "com.obric.memorydata.plugin");
    L10:
        a(r2, r1);
        return;
    L5:
        r2 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, 0), k.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final List<k> j() {
        List<k> r4 = getCurrentShadows();
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L10;
        r0.add(((k) ZeusTransformUtils.preCheckCast(r6.next(), k.class, "com.obric.memorydata.plugin")).j());
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        l.a((View) ZeusTransformUtils.preCheckCast(getContentView(), View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setBackdropView(boolean r1) {
        this.u = r1;
    }

    public void setBgColor(int r2) {
        if (this.g == r2) goto L14;
        this.g = r2;
        this.h = r2;
        boolean r3 = com.obric.oui.color.d.a(r2);
        c(r3);
        if (r3 == false) goto L7;
        int r4 = 2;
    L9:
        if (r4 == this.o) goto L12;
        a(r4);
        return;
    L12:
        a(isEnabled());
        return;
    L7:
        r4 = 1;
        goto L9
    }

    public final void setBgColorDisabled(int r1) {
        this.h = r1;
    }

    public final void setBgColorNormal(int r1) {
        this.g = r1;
    }

    public final void setContentContainer(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setContentSelfBlur(float r6) {
        OMaterialHelper.a(getContentContainer(), 1, 0, (View) ZeusTransformUtils.preCheckCast(getContentContainer(), View.class, "com.obric.memorydata.plugin"));
        OUIFrameLayout r0 = getContentContainer();
        Float r5 = m.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6);
        if (r5 == null) goto L6;
        r6 = r5.floatValue();
    L6:
        OMaterialHelper.a(r0, r6);
    }

    public final void setContentShadowAlphaProgress(float r6) {
        float r7 = RangesKt.coerceIn(r6, 0.0f, 1.0f);
        if (this.n != r7) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.n = r7;
        List<k> r1 = this.l;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r7 < 1.0f) goto L14;
        updateShadows(r1);
        return;
    L14:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r3.add(a((k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.memorydata.plugin"), r7));
        goto L16
    L18:
        updateShadows((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setContentView(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setCurrentTheme(int r1) {
        this.o = r1;
    }

    public final void setEnableMaterial(boolean r1) {
        this.p = r1;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        getContentView().setEnabled(r2);
        getContentContainer().setEnabled(r2);
        a(r2);
    }

    public final void setMaterialApplied(boolean r1) {
        this.t = r1;
    }

    public final void setMaterialDisabledTokenString(String r1) {
        this.r = r1;
    }

    public final void setMaterialFromDrawable(boolean r1) {
        this.x = r1;
    }

    public final void setMaterialSrcType(int r1) {
        this.w = r1;
    }

    public final void setMaterialTokenString(String r1) {
        this.q = r1;
    }

    public final void setMaterials(c[] r1) {
        this.s = r1;
    }

    public final void setMaterialsDisabled(c[] r1) {
        this.v = r1;
    }

    public void setPressColor(int r2) {
        this.f = r2;
        getContentView().setOverridePressColor(this.f);
        getContentView().refreshColors("OShadowFrame");
    }
}
