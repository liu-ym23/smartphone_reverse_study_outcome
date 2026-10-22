package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.color.d;
import com.obric.oui.color.e;
import com.obric.oui.common.style.i;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u001f*\u0001\u001b\u0018\u0000 ¦\u00012\u00020\u0001:\b¤\u0001¥\u0001¦\u0001§\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020ZH\u0002J\"\u0010[\u001a\u00020W2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020\u0007H\u0002J\b\u0010^\u001a\u00020WH\u0002J\b\u0010_\u001a\u00020WH\u0002J\b\u0010`\u001a\u00020WH\u0002J\b\u0010a\u001a\u00020WH\u0002J\u0010\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020\u0013H\u0002J\b\u0010d\u001a\u0004\u0018\u000100J\b\u0010e\u001a\u000204H\u0002J\b\u0010f\u001a\u000204H\u0002J\b\u0010g\u001a\u000204H\u0002J\b\u0010h\u001a\u000204H\u0002J\b\u0010i\u001a\u000204H\u0002J\b\u0010j\u001a\u00020WH\u0014J\b\u0010k\u001a\u00020WH\u0002J\n\u0010l\u001a\u0004\u0018\u00010KH\u0002J\n\u0010m\u001a\u0004\u0018\u000100H\u0002J\u000e\u0010n\u001a\u00020W2\u0006\u0010o\u001a\u00020\u0010J\u0010\u0010p\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u000e\u0010r\u001a\u00020W2\u0006\u0010s\u001a\u00020\u0007J\u000e\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u0019J\u000e\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u0012\u0010x\u001a\u00020W2\b\b\u0001\u0010y\u001a\u00020\u0007H\u0016J\u000e\u0010z\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u000e\u0010{\u001a\u00020W2\u0006\u0010|\u001a\u00020\u0007J'\u0010{\u001a\u00020W2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u000f\u0010\u0081\u0001\u001a\u00020W2\u0006\u0010o\u001a\u00020+J\u0017\u0010\u0082\u0001\u001a\u00020W2\u0006\u0010c\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0083\u0001J\u0012\u0010\u0084\u0001\u001a\u00020W2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0007J4\u0010\u0086\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u0001002\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00072\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0007¢\u0006\u0003\u0010\u008a\u0001J\u0012\u0010\u008b\u0001\u001a\u00020W2\t\u0010\u008c\u0001\u001a\u0004\u0018\u000109J\u0012\u0010\u008d\u0001\u001a\u00020W2\t\u0010\u008c\u0001\u001a\u0004\u0018\u000109J\u0010\u0010\u008e\u0001\u001a\u00020W2\u0007\u0010\u008f\u0001\u001a\u00020\u0007J\u0012\u0010\u0090\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0092\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0093\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0012\u0010\u0094\u0001\u001a\u00020W2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010KJ\u0011\u0010\u0095\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0011\u0010\u0096\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u000f\u0010\u0097\u0001\u001a\u00020W2\u0006\u0010w\u001a\u000204J\u0011\u0010\u0098\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0011\u0010\u0099\u0001\u001a\u00020W2\b\u0010q\u001a\u0004\u0018\u000100J\u0012\u0010\u009a\u0001\u001a\u00020W2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u000204H\u0002J\t\u0010\u009d\u0001\u001a\u00020WH\u0002J\t\u0010\u009e\u0001\u001a\u00020WH\u0002J\t\u0010\u009f\u0001\u001a\u00020WH\u0002J\t\u0010 \u0001\u001a\u00020WH\u0002J\t\u0010¡\u0001\u001a\u00020WH\u0002J\t\u0010¢\u0001\u001a\u00020WH\u0002J\t\u0010£\u0001\u001a\u00020WH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u00106\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u00107\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010A\u001a\u0002042\u0006\u0010@\u001a\u0002048F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010E\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010FX\u0082\u000e¢\u0006\u0004\n\u0002\u0010HR\u000e\u0010I\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionFilledButton", "Lcom/obric/oui/button/OButton;", "actionNeutralTextColor", "Ljava/lang/Integer;", "actionPrimaryTextColor", "actionStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "actionTextButton", "actionTextContainer", "Landroid/view/View;", "actionTextPrimaryButton", "arrowColor", "Landroid/content/res/ColorStateList;", "arrowOffsetPx", "arrowPosition", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "arrowTriangleOutlineProvider", "com/obric/oui/coachmark/OCoachmarkView$arrowTriangleOutlineProvider$1", "Lcom/obric/oui/coachmark/OCoachmarkView$arrowTriangleOutlineProvider$1;", "arrowView", "Landroid/widget/ImageView;", "bgColor", "closeButton", "Lcom/obric/oui/button/OIconButton;", "closeIconTint", "containerView", "contentContainer", "Landroid/view/ViewGroup;", "contentPaddingBottomPx", "contentPaddingEndPx", "contentPaddingStartPx", "contentPaddingTopPx", "contentStyle", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "customContentView", "descTextAppearance", "descTextColor", "descriptionText", "", "descriptionView", "Lcom/obric/oui/text/OTextView;", "enableMaterial", "", "filledActionBackgroundColor", "filledActionTextColor", "heroContainer", "heroDrawable", "Landroid/graphics/drawable/Drawable;", "heroImage", "iconContainer", "iconDrawable", "iconTint", "iconView", "isContentPaddingCustomized", EventBody.KEY_VALUE, "isPopWindowMode", "()Z", "setPopWindowMode", "(Z)V", "materials", "", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "maxWidthPx", "primaryActionClickListener", "Landroid/view/View$OnClickListener;", "primaryActionText", "secondaryActionClickListener", "secondaryActionText", "showArrow", "showCloseIcon", "textGroup", "titleText", "titleTextAppearance", "titleTextColor", "titleView", "applyAppearance", "", "applyAppearanceAttributes", "array", "Landroid/content/res/TypedArray;", "applyAttributes", "applyContainerRadius", "radiusPx", "applyCustomContentPadding", "applyDefaults", "applyStylePadding", "applyStyledColors", "detachFromParent", "view", "getText", "hasDualTextActions", "hasPrimaryActionText", "hasSecondaryActionText", "hasVisibleActions", "isDarkTheme", "onDetachedFromWindow", "releaseCustomContentView", "resolveDisplayedActionClickListener", "resolveDisplayedActionText", "setActionStyle", "style", "setActionText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "setArrowOffset", "offsetPx", "setArrowPosition", "position", "setArrowVisible", "visible", "setBackgroundColor", TypedValues.Custom.S_COLOR, "setCloseVisible", "setContentPadding", "paddingPx", "startPx", "topPx", "endPx", "bottomPx", "setContentStyle", "setCustomContentView", "setCustomContentView$OUI_standardRelease", "setDescTextAppearance", "resId", "setDescription", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "setHeroImage", "drawable", "setIcon", "setMaxWidth", "widthPx", "setOnActionClickListener", "listener", "setOnCloseClickListener", "setOnPrimaryActionClickListener", "setOnSecondaryActionClickListener", "setPrimaryButtonText", "setSecondaryButtonText", "setShowCloseIcon", "setText", "setTitle", "setTitleTextAppearance", "updateActionTextTopMargin", "showIcon", "updateActions", "updateArrowPosition", "updateContainerPadding", "updateContent", "updateContentStyle", "updateDisplayedActionClickListener", "updateLayout", "ActionStyle", "ArrowPosition", "Companion", "ContentStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkView extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13462a = null;
    private CharSequence A;
    private Drawable B;
    private Drawable C;
    private View D;
    private View.OnClickListener E;
    private View.OnClickListener F;
    private int G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ColorStateList f13463J;
    private ColorStateList K;
    private ColorStateList L;
    private ColorStateList M;
    private ColorStateList N;
    private Integer O;
    private Integer P;
    private Integer Q;
    private Integer R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean aa;
    private boolean ab;
    private com.obric.oui.material.c[] ac;
    private boolean ad;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OUIFrameLayout f13464b;
    private final ImageView c;
    private final c d;
    private final View e;
    private final ImageView f;
    private final ViewGroup g;
    private final OUIFrameLayout h;
    private final ImageView i;
    private final OTextView j;
    private final OTextView k;
    private final View l;
    private final View m;
    private final OButton n;
    private final OButton o;
    private final OButton p;
    private final OIconButton q;
    private ActionStyle r;
    private ArrowPosition s;
    private ContentStyle t;
    private boolean u;
    private boolean v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private CharSequence z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "TEXT_ONLY", "FILLED_BUTTON", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionStyle extends Enum<ActionStyle> {
        private static final /* synthetic */ ActionStyle[] $VALUES = null;
        public static final a Companion = null;
        public static final ActionStyle FILLED_BUTTON = null;
        public static final ActionStyle NONE = null;
        public static final ActionStyle TEXT_ONLY = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ActionStyle;", EventBody.KEY_VALUE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ActionStyle a(int r6) {
                ActionStyle[] r5 = ActionStyle.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ActionStyle r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ActionStyle.NONE;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ActionStyle[] $values() {
            return new ActionStyle[]{NONE, TEXT_ONLY, FILLED_BUTTON};
        }

        static {
            NONE = new ActionStyle("NONE", 0, 0);
            TEXT_ONLY = new ActionStyle("TEXT_ONLY", 1, 1);
            FILLED_BUTTON = new ActionStyle("FILLED_BUTTON", 2, 2);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ActionStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ActionStyle valueOf(String r2) {
            return (ActionStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActionStyle.class, r2), ActionStyle.class, "com.obric.memorydata.plugin");
        }

        public static ActionStyle[] values() {
            return (ActionStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActionStyle[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP", "BOTTOM", "LEFT", "RIGHT", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ArrowPosition extends Enum<ArrowPosition> {
        private static final /* synthetic */ ArrowPosition[] $VALUES = null;
        public static final ArrowPosition BOTTOM = null;
        public static final a Companion = null;
        public static final ArrowPosition LEFT = null;
        public static final ArrowPosition RIGHT = null;
        public static final ArrowPosition TOP = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ArrowPosition;", EventBody.KEY_VALUE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ArrowPosition a(int r6) {
                ArrowPosition[] r5 = ArrowPosition.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ArrowPosition r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ArrowPosition.TOP;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ArrowPosition[] $values() {
            return new ArrowPosition[]{TOP, BOTTOM, LEFT, RIGHT};
        }

        static {
            TOP = new ArrowPosition("TOP", 0, 0);
            BOTTOM = new ArrowPosition("BOTTOM", 1, 1);
            LEFT = new ArrowPosition("LEFT", 2, 2);
            RIGHT = new ArrowPosition("RIGHT", 3, 3);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ArrowPosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ArrowPosition valueOf(String r2) {
            return (ArrowPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(ArrowPosition.class, r2), ArrowPosition.class, "com.obric.memorydata.plugin");
        }

        public static ArrowPosition[] values() {
            return (ArrowPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ArrowPosition[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "PILL", "CARD", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ContentStyle extends Enum<ContentStyle> {
        private static final /* synthetic */ ContentStyle[] $VALUES = null;
        public static final ContentStyle CARD = null;
        public static final a Companion = null;
        public static final ContentStyle PILL = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkView$ContentStyle;", EventBody.KEY_VALUE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ContentStyle a(int r6) {
                ContentStyle[] r5 = ContentStyle.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ContentStyle r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ContentStyle.PILL;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ContentStyle[] $values() {
            return new ContentStyle[]{PILL, CARD};
        }

        static {
            PILL = new ContentStyle("PILL", 0, 0);
            CARD = new ContentStyle("CARD", 1, 1);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ContentStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ContentStyle valueOf(String r2) {
            return (ContentStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContentStyle.class, r2), ContentStyle.class, "com.obric.memorydata.plugin");
        }

        public static ContentStyle[] values() {
            return (ContentStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContentStyle[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkView$Companion;", "", "()V", "CARD_CONTENT_PADDING_DP", "", "CARD_HORIZONTAL_PADDING_DP", "CARD_RADIUS_DP", "CARD_WIDTH_DP", "DEFAULT_HEIGHT_DP", "DEFAULT_ICON_GAP_DP", "DEFAULT_MAX_WIDTH_DP", "PILL_CONTENT_PADDING_DP", "PILL_HORIZONTAL_PADDING_DP", "PILL_RADIUS_DP", "SIDE_ARROW_HEIGHT_DP", "SIDE_ARROW_INTRUSION_DP", "SIDE_ARROW_WIDTH_DP", "TAG", "", "TEXT_ACTION_TOP_MARGIN_TEXT_ONLY_DP", "TEXT_ACTION_TOP_MARGIN_WITH_ICON_DP", "TITLE_DESC_GAP_DP", "TOP_BOTTOM_ARROW_HEIGHT_DP", "TOP_BOTTOM_ARROW_INTRUSION_DP", "TOP_BOTTOM_ARROW_WIDTH_DP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13465a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13466b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[ContentStyle.values().length];
            r0[ContentStyle.PILL.ordinal()] = 1;
            r0[ContentStyle.CARD.ordinal()] = 2;
            f13465a = r0;
            int[] r1 = new int[ActionStyle.values().length];
            r1[ActionStyle.TEXT_ONLY.ordinal()] = 1;
            r1[ActionStyle.FILLED_BUTTON.ordinal()] = 2;
            r1[ActionStyle.NONE.ordinal()] = 3;
            f13466b = r1;
            int[] r2 = new int[ArrowPosition.values().length];
            r2[ArrowPosition.TOP.ordinal()] = 1;
            r2[ArrowPosition.BOTTOM.ordinal()] = 2;
            r2[ArrowPosition.LEFT.ordinal()] = 3;
            r2[ArrowPosition.RIGHT.ordinal()] = 4;
            c = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/coachmark/OCoachmarkView$arrowTriangleOutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCoachmarkView f13467a;

        c(OCoachmarkView r1) {
            this.f13467a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r12, Outline r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            Intrinsics.checkNotNullParameter(r13, "outline");
            int r0 = r12.getWidth();
            int r14 = r12.getHeight();
            if (r0 <= 0) goto L22;
            if (r14 <= 0) goto L24;
            Path r8 = new Path();
            if (OCoachmarkView.b(this.f13467a) != ArrowPosition.TOP) goto L9;
        L12:
            boolean r11 = true;
        L14:
            if (r11 == false) goto L16;
            float r15 = r0 / 20.0f;
            float r16 = r14 / 8.0f;
            float r7 = r16 * 1.41421f;
            r8.moveTo(8.58579f * r15, r7);
            r8.cubicTo(9.36684f * r15, 0.633164f * r16, 10.6332f * r15, 0.633165f * r16, 11.4142f * r15, r7);
            float r17 = r16 * 8.0f;
            r8.lineTo(18.0f * r15, r17);
            float r18 = r15 * 2.0f;
        L17:
            r8.lineTo(r18, r17);
            r8.close();
            if (Build.VERSION.SDK_INT < 30) goto L20;
            r13.setPath(r8);
            return;
        L20:
            r13.setConvexPath(r8);
            return;
        L16:
            float r19 = r0 / 10.0f;
            float r110 = r14 / 20.0f;
            float r6 = r19 * 1.95217f;
            float r4 = r19 * 0.951359f;
            r8.moveTo(r6, 8.43826f * r110);
            r8.cubicTo(r4, r110 * 9.23891f, r4, r110 * 10.7611f, r6, r110 * 11.5617f);
            r18 = r19 * 10.0f;
            r8.lineTo(r18, 18.0f * r110);
            r17 = r110 * 2.0f;
            goto L17
        L9:
            if (OCoachmarkView.b(this.f13467a) == ArrowPosition.BOTTOM) goto L12;
            r11 = false;
            goto L14
        L24:
            return;
        }
    }

    static {
        f13462a = new a(null);
    }

    public OCoachmarkView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OCoachmarkView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OCoachmarkView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OCoachmarkView(Context r8, AttributeSet r9, int r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r10, new i(r12, r13, r10, r11));
        c r0 = new c(this);
        this.d = r0;
        this.r = ActionStyle.NONE;
        this.s = ArrowPosition.TOP;
        this.t = ContentStyle.PILL;
        this.u = true;
        this.S = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 320);
        this.T = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        this.U = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        this.V = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        this.W = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.ab = r3;
        ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_coachmark, "layout", "o_coachmark"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        setChangeAlphaWhenPress(false);
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_container, OaidModel.KEY_ID, "coachmark_container"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.coachmark_container)");
        OUIFrameLayout r15 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r14, OUIFrameLayout.class, "com.obric.memorydata.plugin");
        this.f13464b = r15;
        r15.setChangeAlphaWhenPress(false);
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_coachmark_arrow, OaidModel.KEY_ID, "iv_coachmark_arrow"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_coachmark_arrow)");
        ImageView r17 = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.memorydata.plugin");
        this.c = r17;
        r17.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(r0, ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_hero_container, OaidModel.KEY_ID, "coachmark_hero_container"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.coachmark_hero_container)");
        this.e = r18;
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_hero_image, OaidModel.KEY_ID, "coachmark_hero_image"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.coachmark_hero_image)");
        this.f = (ImageView) ZeusTransformUtils.preCheckCast(r19, ImageView.class, "com.obric.memorydata.plugin");
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_content_container, OaidModel.KEY_ID, "coachmark_content_container"));
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.coachmark_content_container)");
        this.g = (ViewGroup) ZeusTransformUtils.preCheckCast(r20, ViewGroup.class, "com.obric.memorydata.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_icon_container, OaidModel.KEY_ID, "coachmark_icon_container"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.coachmark_icon_container)");
        this.h = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r21, OUIFrameLayout.class, "com.obric.memorydata.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_icon, OaidModel.KEY_ID, "coachmark_icon"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.coachmark_icon)");
        this.i = (ImageView) ZeusTransformUtils.preCheckCast(r22, ImageView.class, "com.obric.memorydata.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_coachmark_title, OaidModel.KEY_ID, "tv_coachmark_title"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.tv_coachmark_title)");
        OTextView r24 = (OTextView) ZeusTransformUtils.preCheckCast(r23, OTextView.class, "com.obric.memorydata.plugin");
        this.j = r24;
        r24.getPaint().setSubpixelText(true);
        r24.setIncludeFontPadding(true);
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_coachmark_description, OaidModel.KEY_ID, "tv_coachmark_description"));
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.tv_coachmark_description)");
        OTextView r26 = (OTextView) ZeusTransformUtils.preCheckCast(r25, OTextView.class, "com.obric.memorydata.plugin");
        this.k = r26;
        r26.getPaint().setSubpixelText(true);
        r26.setIncludeFontPadding(true);
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_text_group, OaidModel.KEY_ID, "coachmark_text_group"));
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.coachmark_text_group)");
        this.l = r27;
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.coachmark_action_text_container, OaidModel.KEY_ID, "coachmark_action_text_container"));
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.coachmark_action_text_container)");
        this.m = r28;
        View r29 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_text, OaidModel.KEY_ID, "btn_coachmark_action_text"));
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.btn_coachmark_action_text)");
        this.n = (OButton) ZeusTransformUtils.preCheckCast(r29, OButton.class, "com.obric.memorydata.plugin");
        View r30 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_text_primary, OaidModel.KEY_ID, "btn_coachmark_action_text_primary"));
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.btn_co…mark_action_text_primary)");
        this.o = (OButton) ZeusTransformUtils.preCheckCast(r30, OButton.class, "com.obric.memorydata.plugin");
        View r31 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_action_filled, OaidModel.KEY_ID, "btn_coachmark_action_filled"));
        Intrinsics.checkNotNullExpressionValue(r31, "findViewById(R.id.btn_coachmark_action_filled)");
        this.p = (OButton) ZeusTransformUtils.preCheckCast(r31, OButton.class, "com.obric.memorydata.plugin");
        View r32 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_coachmark_close, OaidModel.KEY_ID, "btn_coachmark_close"));
        Intrinsics.checkNotNullExpressionValue(r32, "findViewById(R.id.btn_coachmark_close)");
        this.q = (OIconButton) ZeusTransformUtils.preCheckCast(r32, OIconButton.class, "com.obric.memorydata.plugin");
        a();
        a(r13, r10, r11);
        c();
        return;
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public /* synthetic */ OCoachmarkView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = ZeusTransformUtils.mapRes(R.attr.ocoachmarkViewStyle, "attr", "ocoachmarkViewStyle");
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = ZeusTransformUtils.mapRes(R.style.OStyleV2_OCoachmarkView_DayNight, "style", "OStyleV2_OCoachmarkView_DayNight");
    L11:
        this(r8, r9, r4, r5);
    }

    public static final /* synthetic */ ActionStyle a(OCoachmarkView r0) {
        return r0.r;
    }

    private final void a() {
        this.G = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_3_high_elevation, TypedValues.Custom.S_COLOR, "oui_bg_base_3_high_elevation"));
        this.f13464b.setMinimumHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48));
        this.f13464b.setBackgroundColor(this.G);
        this.f13464b.setOuterNormalColor(this.G);
        t();
    }

    private final void a(int r2) {
        this.f13464b.setShadowCornerRadius(r2);
        if (this.f13464b.isEnableShadowWidthRadius() == false) goto L6;
        this.f13464b.setRadius(r2);
        return;
    }

    private final void a(TypedArray r8) {
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmBackgroundColor, "styleable", "OCoachmarkView_cmBackgroundColor")) == false) goto L7;
        int r0 = r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmBackgroundColor, "styleable", "OCoachmarkView_cmBackgroundColor"), this.G);
    L5:
        this.G = r0;
    L22:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextColor, "styleable", "OCoachmarkView_cmTitleTextColor")) == false) goto L25;
        this.f13463J = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextColor, "styleable", "OCoachmarkView_cmTitleTextColor"));
    L25:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextColor, "styleable", "OCoachmarkView_cmDescTextColor")) == false) goto L28;
        this.K = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextColor, "styleable", "OCoachmarkView_cmDescTextColor"));
    L28:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIconTint, "styleable", "OCoachmarkView_cmIconTint")) == false) goto L31;
        this.L = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIconTint, "styleable", "OCoachmarkView_cmIconTint"));
    L31:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmCloseIconTint, "styleable", "OCoachmarkView_cmCloseIconTint")) == false) goto L34;
        this.M = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmCloseIconTint, "styleable", "OCoachmarkView_cmCloseIconTint"));
    L34:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowColor, "styleable", "OCoachmarkView_cmArrowColor")) == false) goto L37;
        this.N = r8.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowColor, "styleable", "OCoachmarkView_cmArrowColor"));
    L37:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionNeutralTextColor, "styleable", "OCoachmarkView_cmActionNeutralTextColor")) == false) goto L40;
        this.O = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionNeutralTextColor, "styleable", "OCoachmarkView_cmActionNeutralTextColor"), 0));
    L40:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionPrimaryTextColor, "styleable", "OCoachmarkView_cmActionPrimaryTextColor")) == false) goto L43;
        this.P = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionPrimaryTextColor, "styleable", "OCoachmarkView_cmActionPrimaryTextColor"), 0));
    L43:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionTextColor, "styleable", "OCoachmarkView_cmFilledActionTextColor")) == false) goto L46;
        this.Q = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionTextColor, "styleable", "OCoachmarkView_cmFilledActionTextColor"), 0));
    L46:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor, "styleable", "OCoachmarkView_cmFilledActionBackgroundColor")) == false) goto L49;
        this.R = Integer.valueOf(r8.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmFilledActionBackgroundColor, "styleable", "OCoachmarkView_cmFilledActionBackgroundColor"), 0));
    L49:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextAppearance, "styleable", "OCoachmarkView_cmTitleTextAppearance")) == false) goto L52;
        this.H = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitleTextAppearance, "styleable", "OCoachmarkView_cmTitleTextAppearance"), 0);
    L52:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextAppearance, "styleable", "OCoachmarkView_cmDescTextAppearance")) == false) goto L55;
        this.I = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmDescTextAppearance, "styleable", "OCoachmarkView_cmDescTextAppearance"), 0);
    L55:
        if (this.ab == false) goto L58;
        this.ab = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_oui_widgetEnableMaterial, "styleable", "OCoachmarkView_oui_widgetEnableMaterial"), true);
    L58:
        if (this.ab == false) goto L64;
        String r1 = r8.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_oui_widgetMaterial, "styleable", "OCoachmarkView_oui_widgetMaterial"));
        if (r1 != null) goto L62;
        r1 = ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_popup, TypedValues.Custom.S_STRING, "oui_material_bg_popup"));
    L62:
        this.ac = MaterialToken.parseSet(r1, !b());
        return;
    L64:
        return;
    L7:
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_background, "styleable", "OCoachmarkView_android_background")) == false) goto L22;
        Drawable r2 = r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_background, "styleable", "OCoachmarkView_android_background"));
        if (ZeusTransformUtils.instanceOf(r2, ColorDrawable.class) == false) goto L11;
        ColorDrawable r3 = (ColorDrawable) ZeusTransformUtils.preCheckCast(r2, ColorDrawable.class, "com.obric.memorydata.plugin");
    L12:
        if (r3 != null) goto L14;
        Integer r4 = null;
    L15:
        if (r4 == null) goto L17;
        r0 = r4.intValue();
        goto L5
    L17:
        com.obric.oui.c.a.b r5 = com.obric.oui.c.a.b.f13400a;
        if (r5.a(8) == true) goto L22;
        r5.a().a("OCoachmarkView", 8, "android:background is not a color; ignored. Use cmBackgroundColor for color.", null);
        goto L22
    L14:
        r4 = Integer.valueOf(r3.getColor());
        goto L15
    L11:
        r3 = null;
        goto L12
    }

    private final void a(AttributeSet r25, int r26, int r27) {
        TypedArray r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r25, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OCoachmarkView, r26, r27);
        CharSequence r4 = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_text, "styleable", "OCoachmarkView_android_text"));     // Catch: Throwable -> L72
        if (r4 == null) goto L8;
        this.y = r4;     // Catch: Throwable -> L72
    L8:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitle, "styleable", "OCoachmarkView_cmTitle")) == false) goto L11;
        this.x = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmTitle, "styleable", "OCoachmarkView_cmTitle"));     // Catch: Throwable -> L72
    L11:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIcon, "styleable", "OCoachmarkView_cmIcon")) == false) goto L14;
        this.B = r3.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmIcon, "styleable", "OCoachmarkView_cmIcon"));     // Catch: Throwable -> L72
    L14:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmHeroImage, "styleable", "OCoachmarkView_cmHeroImage")) == false) goto L17;
        int r1 = ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmHeroImage, "styleable", "OCoachmarkView_cmHeroImage");     // Catch: Throwable -> L72
    L16:
        Drawable r2 = r3.getDrawable(r1);     // Catch: Throwable -> L72
        if (r2 == null) goto L21;
        this.C = r2;     // Catch: Throwable -> L72
    L21:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentStyle, "styleable", "OCoachmarkView_cmContentStyle")) == false) goto L24;
        this.t = ContentStyle.Companion.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentStyle, "styleable", "OCoachmarkView_cmContentStyle"), ContentStyle.PILL.getValue()));     // Catch: Throwable -> L72
    L24:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowCloseIcon, "styleable", "OCoachmarkView_cmShowCloseIcon")) == false) goto L26;
        this.v = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowCloseIcon, "styleable", "OCoachmarkView_cmShowCloseIcon"), false);     // Catch: Throwable -> L72
    L26:
        e();     // Catch: Throwable -> L72
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionText, "styleable", "OCoachmarkView_cmActionText")) == false) goto L29;
        this.z = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionText, "styleable", "OCoachmarkView_cmActionText"));     // Catch: Throwable -> L72
        boolean r5 = true;
    L31:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmPrimaryButtonText, "styleable", "OCoachmarkView_cmPrimaryButtonText")) == false) goto L34;
        this.z = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmPrimaryButtonText, "styleable", "OCoachmarkView_cmPrimaryButtonText"));     // Catch: Throwable -> L72
        r5 = true;
    L34:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmSecondaryButtonText, "styleable", "OCoachmarkView_cmSecondaryButtonText")) == false) goto L37;
        this.A = r3.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmSecondaryButtonText, "styleable", "OCoachmarkView_cmSecondaryButtonText"));     // Catch: Throwable -> L72
        r5 = true;
    L37:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionStyle, "styleable", "OCoachmarkView_cmActionStyle")) == false) goto L39;
        this.r = ActionStyle.Companion.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmActionStyle, "styleable", "OCoachmarkView_cmActionStyle"), ActionStyle.NONE.getValue()));     // Catch: Throwable -> L72
        boolean r6 = true;
    L40:
        Intrinsics.checkNotNullExpressionValue(r3, "this");     // Catch: Throwable -> L72
        a(r3);     // Catch: Throwable -> L72
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmMaxWidth, "styleable", "OCoachmarkView_cmMaxWidth")) == false) goto L44;
        this.S = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmMaxWidth, "styleable", "OCoachmarkView_cmMaxWidth"), this.S);     // Catch: Throwable -> L72
    L44:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPadding, "styleable", "OCoachmarkView_cmContentPadding")) == false) goto L46;
        int r7 = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPadding, "styleable", "OCoachmarkView_cmContentPadding"), this.T);     // Catch: Throwable -> L72
        this.T = r7;     // Catch: Throwable -> L72
        this.U = r7;     // Catch: Throwable -> L72
        this.V = r7;     // Catch: Throwable -> L72
        this.W = r7;     // Catch: Throwable -> L72
        boolean r8 = true;
    L48:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingStart, "styleable", "OCoachmarkView_cmContentPaddingStart")) == false) goto L51;
        this.T = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingStart, "styleable", "OCoachmarkView_cmContentPaddingStart"), this.T);     // Catch: Throwable -> L72
        r8 = true;
    L51:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingTop, "styleable", "OCoachmarkView_cmContentPaddingTop")) == false) goto L54;
        this.U = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingTop, "styleable", "OCoachmarkView_cmContentPaddingTop"), this.U);     // Catch: Throwable -> L72
        r8 = true;
    L54:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingEnd, "styleable", "OCoachmarkView_cmContentPaddingEnd")) == false) goto L57;
        this.V = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingEnd, "styleable", "OCoachmarkView_cmContentPaddingEnd"), this.V);     // Catch: Throwable -> L72
        r8 = true;
    L57:
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingBottom, "styleable", "OCoachmarkView_cmContentPaddingBottom")) == false) goto L59;
        this.W = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmContentPaddingBottom, "styleable", "OCoachmarkView_cmContentPaddingBottom"), this.W);     // Catch: Throwable -> L72
        r8 = true;
    L59:
        if (r8 == false) goto L61;
        this.aa = true;     // Catch: Throwable -> L72
    L61:
        this.u = r3.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmShowArrow, "styleable", "OCoachmarkView_cmShowArrow"), true);     // Catch: Throwable -> L72
        o.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), this.u);     // Catch: Throwable -> L72
        this.s = ArrowPosition.Companion.a(r3.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowPosition, "styleable", "OCoachmarkView_cmArrowPosition"), ArrowPosition.TOP.getValue()));     // Catch: Throwable -> L72
        if (r3.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowOffset, "styleable", "OCoachmarkView_cmArrowOffset")) == false) goto L64;
        this.w = r3.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_cmArrowOffset, "styleable", "OCoachmarkView_cmArrowOffset"), 0);     // Catch: Throwable -> L72
    L64:
        r3.recycle();
        if (r6 == true) goto L77;
        if (r5 == false) goto L78;
        com.obric.oui.c.a.b r0 = com.obric.oui.c.a.b.f13400a;
        if (r0.a(8) == true) goto L79;
        r0.a().a("OCoachmarkView", 8, "Action text is set without cmActionStyle; action will stay hidden.", null);
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L46:
        r8 = false;
        goto L48
    L39:
        r6 = false;
        goto L40
    L29:
        r5 = false;
        goto L31
    L17:
        r1 = ZeusTransformUtils.mapRes(R.styleable.OCoachmarkView_android_src, "styleable", "OCoachmarkView_android_src");     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        r3.recycle();
        throw th;
    }

    public static /* synthetic */ void a(OCoachmarkView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.a(r7, r3, r4);
    }

    private final void a(boolean r5) {
        View r0 = this.m;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L5;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r6 = 8;
    L6:
        r3.topMargin = h.a(r4, r6);
        r0.setLayoutParams(r2);
        return;
    L5:
        r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r6 = 12;
        goto L6
    }

    private final boolean a(View r7) {
        ViewParent r0 = r7.getParent();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0 != this.g) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == true) goto L16;
        com.obric.oui.c.a.b r6 = com.obric.oui.c.a.b.f13400a;
        if (r6.a(8) == true) goto L22;
        r6.a().a("OCoachmarkView", 8, Intrinsics.stringPlus("custom content view has a non-ViewGroup parent: ", r0.getClass().getSimpleName()), null);
        return false;
    L22:
        return false;
    L16:
        com.obric.oui.c.a.b r8 = com.obric.oui.c.a.b.f13400a;
        if (r8.a(8) == true) goto L20;
        r8.a().a("OCoachmarkView", 8, "custom content view already has a parent; it will be moved into coachmark content container.", null);
    L20:
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r7);
        return true;
    }

    public static final /* synthetic */ ArrowPosition b(OCoachmarkView r0) {
        return r0.s;
    }

    private final boolean b() {
        int r0 = this.G;
        if (r0 != 0) goto L7;
        return com.obric.oui.c.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        return d.a(r0);
    }

    private final void c() {
        d();
        i();
        if (this.ac == null) goto L6;
        this.f13464b.setEnableShadowWidthRadius(true);
    L6:
        g();
        e();
        u();
        t();
    }

    private final void d() {
        this.f13464b.setWidthLimit(this.S);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f13464b, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        ContentStyle r4 = this.t;
        int r5 = b.f13465a[r4.ordinal()];
        if (r5 != 1) goto L5;
        int r6 = -2;
    L12:
        r3.width = r6;
        r0.setLayoutParams(r2);
        return;
    L5:
        if (r5 != 2) goto L10;
        int r7 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getWidth();
        r6 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 320);
        if (r6 <= r7) goto L12;
        r6 = -1;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void e() {
        if (this.aa == false) goto L6;
        return;
    L6:
        if (this.D == null) goto L9;
        f();
        return;
    L9:
        int r0 = b.f13465a[this.t.ordinal()];
        int r1 = 0;
        if (r0 != 1) goto L12;
        this.T = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        int r2 = 8;
        this.U = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        if (this.v == true) goto L33;
        r1 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
    L33:
        this.V = r1;
    L34:
        this.W = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r2);
        return;
    L12:
        if (r0 != 2) goto L36;
        boolean r3 = s();
        if (this.B != null) goto L17;
    L19:
        r2 = 16;
        if (r1 == 0) goto L23;
        if (r3 == false) goto L23;
        int r4 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
    L24:
        this.T = r4;
        this.U = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
        if (r3 == false) goto L27;
        int r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
    L28:
        this.V = r5;
        goto L34
    L27:
        r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
    L23:
        r4 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        goto L24
    L17:
        if (this.C != null) goto L19;
        r1 = 1;
        goto L19
    }

    private final void f() {
        ContentStyle r0 = this.t;
        int r1 = b.f13465a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r4 = 8;
    L9:
        int r5 = h.a(r3, r4);
        this.T = r2;
        this.U = r5;
        this.V = r2;
        this.W = r5;
        return;
    L5:
        if (r1 != 2) goto L11;
        r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r4 = 16;
        goto L9
    }

    private final void g() {
        int r0 = b.f13465a[this.t.ordinal()];
        if (r0 != 1) goto L5;
        View r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r2 = 28;
    L10:
        int r3 = h.a(r1, r2);
        a(r3);
        if (this.ab == false) goto L20;
        if (this.ac == null) goto L20;
        if (this.u == false) goto L17;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.f13464b, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.material.c[] r5 = this.ac;
        Intrinsics.checkNotNull(r5);
        l.a(r4, r5[0], false, 0, 6, null);
        OMaterialHelper.a(this.f13464b, 0.0f, 0);
        this.f13464b.setOuterNormalColor(0);
        this.f13464b.setBorderWidth(0);
    L18:
        OUIFrameLayout r6 = this.f13464b;
        GradientDrawable r7 = new GradientDrawable();
        r7.setShape(0);
        r7.setCornerRadius(r3);
        r7.setColor(0);
        r6.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r7, Drawable.class, "com.obric.memorydata.plugin"));
    L23:
        if (this.H == 0) goto L26;
        TextViewCompat.setTextAppearance((TextView) ZeusTransformUtils.preCheckCast(this.j, TextView.class, "com.obric.memorydata.plugin"), this.H);
    L26:
        if (this.I == 0) goto L28;
        TextViewCompat.setTextAppearance((TextView) ZeusTransformUtils.preCheckCast(this.k, TextView.class, "com.obric.memorydata.plugin"), this.I);
    L28:
        h();
        return;
    L17:
        View r8 = (View) ZeusTransformUtils.preCheckCast(this.f13464b, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.material.c[] r9 = this.ac;
        Intrinsics.checkNotNull(r9);
        l.a(r8, r9, false, 0, null, 14, null);
    L20:
        if (this.G == 0) goto L23;
        OUIFrameLayout r10 = this.f13464b;
        GradientDrawable r11 = new GradientDrawable();
        r11.setCornerRadius(r3);
        r11.setColor(this.G);
        r10.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r11, Drawable.class, "com.obric.memorydata.plugin"));
        this.f13464b.setOuterNormalColor(this.G);
        goto L23
    L5:
        if (r0 != 2) goto L8;
        r1 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r2 = 20;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void h() {
        ColorStateList r0 = this.f13463J;
        if (r0 == null) goto L6;
        this.j.setTextColor(r0);
    L6:
        ColorStateList r1 = this.K;
        if (r1 == null) goto L10;
        this.k.setTextColor(r1);
    L10:
        this.i.setImageTintList(this.L);
        ColorStateList r2 = this.M;
        if (r2 == null) goto L14;
        this.q.setImageTintList(r2);
    L14:
        Integer r3 = this.O;
        if (r3 == null) goto L18;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.n.setTextColor(r4);
    L18:
        Integer r5 = this.P;
        if (r5 == null) goto L22;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.o.setTextColor(r6);
    L22:
        Integer r7 = this.Q;
        if (r7 == null) goto L26;
        int r8 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.p.setTextColor(r8);
    L26:
        Integer r9 = this.R;
        if (r9 == null) goto L31;
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.p.setBackgroundTintList(ColorStateList.valueOf(r10));
        this.p.setOuterNormalColor(r10);
        return;
    }

    private final void i() {
        View r0 = this.D;
        boolean r1 = true;
        if (r0 == null) goto L9;
        if (r0 == null) goto L76;
        o.a(r0, true);
        return;
    L76:
        return;
    L9:
        if (this.C == null) goto L11;
        boolean r2 = true;
    L12:
        o.a(this.e, r2);
        ImageView r4 = this.f;
        if (r2 == false) goto L15;
        r4.setImageDrawable(this.C);
    L17:
        if (r2 == true) goto L19;
    L24:
        if (r2 == false) goto L26;
    L28:
        boolean r3 = false;
    L29:
        o.a((View) ZeusTransformUtils.preCheckCast(this.h, View.class, "com.obric.memorydata.plugin"), r3);
        ImageView r6 = this.i;
        if (r3 == false) goto L32;
        r6.setImageDrawable(this.B);
    L33:
        View r7 = this.l;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r9 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L36;
        int r11 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
    L37:
        r10.setMarginStart(r11);
        r7.setLayoutParams(r9);
        CharSequence r12 = this.x;
        if (r12 != null) goto L40;
    L43:
        boolean r13 = true;
    L44:
        boolean r14 = !r13;
        o.a((View) ZeusTransformUtils.preCheckCast(this.j, View.class, "com.obric.memorydata.plugin"), r14);
        this.j.setText(this.x);
        View r15 = (View) ZeusTransformUtils.preCheckCast(this.k, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r17 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r14 == false) goto L47;
        int r19 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
    L48:
        r18.topMargin = r19;
        r15.setLayoutParams(r17);
        this.k.setText(this.y);
        this.k.setMaxWidth(Math.min(this.S, com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getWidth()));
        CharSequence r20 = this.x;
        if (r20 != null) goto L51;
    L54:
        boolean r21 = true;
    L55:
        if (r21 == false) goto L68;
        CharSequence r22 = this.y;
        if (r22 != null) goto L59;
    L62:
        boolean r23 = true;
    L63:
        if (r23 == false) goto L68;
        com.obric.oui.c.a.b r24 = com.obric.oui.c.a.b.f13400a;
        if (r24.a(8) == true) goto L68;
        r24.a().a("OCoachmarkView", 8, "Coachmark title and description are empty.", null);
        goto L68
    L59:
        if (StringsKt.isBlank(r22) == true) goto L62;
        r23 = false;
    L68:
        l();
        a(r3);
        if (this.t == ContentStyle.PILL) goto L71;
    L73:
        r1 = false;
    L74:
        o.a((View) ZeusTransformUtils.preCheckCast(this.q, View.class, "com.obric.memorydata.plugin"), r1);
        return;
    L71:
        if (this.v == false) goto L73;
    L51:
        if (StringsKt.isBlank(r20) == true) goto L54;
        r21 = false;
        goto L55
    L47:
        r19 = 0;
        goto L48
    L40:
        if (StringsKt.isBlank(r12) == true) goto L43;
        r13 = false;
        goto L44
    L36:
        r11 = 0;
        goto L37
    L32:
        r6.setImageDrawable(null);
        goto L33
    L26:
        if (this.B == null) goto L28;
        r3 = true;
        goto L29
    L19:
        if (this.B == null) goto L24;
        com.obric.oui.c.a.b r25 = com.obric.oui.c.a.b.f13400a;
        if (r25.a(8) == true) goto L24;
        r25.a().a("OCoachmarkView", 8, "Hero image is set; cmIcon will be ignored.", null);
        goto L24
    L15:
        r4.setImageDrawable(null);
        goto L17
    L11:
        r2 = false;
        goto L12
    }

    private final void j() {
        View r0 = this.D;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        ViewGroup r2 = this.g;
        if (r1 != r2) goto L8;
        r2.removeView(r0);
    L8:
        this.D = null;
    }

    private final void l() {
        CharSequence r0 = q();
        boolean r1 = n();
        boolean r2 = o();
        boolean r3 = p();
        o.a(this.m, false);
        o.a((View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin"), false);
        o.a((View) ZeusTransformUtils.preCheckCast(this.o, View.class, "com.obric.memorydata.plugin"), false);
        o.a((View) ZeusTransformUtils.preCheckCast(this.p, View.class, "com.obric.memorydata.plugin"), false);
        this.n.setOnClickListener(null);
        this.o.setOnClickListener(null);
        this.p.setOnClickListener(null);
        if (this.E == null) goto L10;
        if (r1 == true) goto L10;
        com.obric.oui.c.a.b r4 = com.obric.oui.c.a.b.f13400a;
        if (r4.a(8) == true) goto L10;
        r4.a().a("OCoachmarkView", 8, "Primary action listener is set without primary action text.", null);
    L10:
        if (this.F == null) goto L16;
        if (r2 == true) goto L16;
        com.obric.oui.c.a.b r5 = com.obric.oui.c.a.b.f13400a;
        if (r5.a(8) == true) goto L16;
        r5.a().a("OCoachmarkView", 8, "Secondary action listener is set without secondary action text.", null);
    L16:
        if (r2 == false) goto L22;
        if (r1 == true) goto L22;
        com.obric.oui.c.a.b r6 = com.obric.oui.c.a.b.f13400a;
        if (r6.a(8) == true) goto L22;
        r6.a().a("OCoachmarkView", 8, "Secondary action text is set without primary action text; secondary action will not render by itself.", null);
    L22:
        if (r2 == true) goto L24;
    L29:
        int r7 = b.f13466b[this.r.ordinal()];
        if (r7 != 1) goto L32;
        if (r3 == false) goto L52;
        o.a(this.m, true);
        o.a((View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin"), true);
        o.a((View) ZeusTransformUtils.preCheckCast(this.o, View.class, "com.obric.memorydata.plugin"), true);
        this.n.setText(this.A);
        this.o.setText(this.z);
        this.n.setOnClickListener(this.F);
        this.o.setOnClickListener(this.E);
        return;
    L52:
        if (r0 != null) goto L58;
        com.obric.oui.c.a.b r8 = com.obric.oui.c.a.b.f13400a;
        if (r8.a(8) == true) goto L61;
        r8.a().a("OCoachmarkView", 8, "ActionStyle " + a(this) + " is set without action text.", null);
        return;
    L61:
        return;
    L58:
        o.a(this.m, true);
        o.a((View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin"), true);
        OButton r9 = this.n;
    L48:
        r9.setText(r0);
        m();
        return;
    L32:
        if (r7 != 2) goto L34;
        if (r0 != null) goto L47;
        com.obric.oui.c.a.b r10 = com.obric.oui.c.a.b.f13400a;
        if (r10.a(8) == true) goto L60;
        r10.a().a("OCoachmarkView", 8, "ActionStyle " + a(this) + " is set without action text.", null);
        return;
    L60:
        return;
    L47:
        o.a((View) ZeusTransformUtils.preCheckCast(this.p, View.class, "com.obric.memorydata.plugin"), true);
        r9 = this.p;
        goto L48
    L34:
        if (r7 != 3) goto L64;
        if (r0 == null) goto L59;
        com.obric.oui.c.a.b r11 = com.obric.oui.c.a.b.f13400a;
        if (r11.a(8) == true) goto L65;
        r11.a().a("OCoachmarkView", 8, "action text is set while ActionStyle.NONE; action will stay hidden.", null);
        return;
    L65:
        return;
    L59:
        return;
    L64:
        return;
    L24:
        if (this.r != ActionStyle.FILLED_BUTTON) goto L29;
        com.obric.oui.c.a.b r12 = com.obric.oui.c.a.b.f13400a;
        if (r12.a(8) == true) goto L29;
        r12.a().a("OCoachmarkView", 8, "Secondary action text is set with FILLED_BUTTON; filled coachmark renders only the primary action.", null);
        goto L29
    }

    private final void m() {
        if (p() == false) goto L6;
        this.n.setOnClickListener(this.F);
        this.o.setOnClickListener(this.E);
        return;
    L6:
        View.OnClickListener r0 = r();
        this.n.setOnClickListener(r0);
        this.o.setOnClickListener(null);
        this.p.setOnClickListener(r0);
    }

    private final boolean n() {
        CharSequence r1 = this.z;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean o() {
        CharSequence r1 = this.A;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final boolean p() {
        if (this.r == ActionStyle.TEXT_ONLY) goto L5;
    L9:
        return false;
    L5:
        if (n() == false) goto L9;
        if (o() == false) goto L9;
        return true;
    }

    private final CharSequence q() {
        if (n() == true) goto L7;
        return null;
    L7:
        return this.z;
    }

    private final View.OnClickListener r() {
        if (n() == true) goto L7;
        return null;
    L7:
        return this.E;
    }

    private final boolean s() {
        if (this.r != ActionStyle.NONE) goto L5;
    L7:
        return false;
    L5:
        if (q() == null) goto L7;
        return true;
    }

    private final void t() {
        if (this.s != ArrowPosition.TOP) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (this.u == false) goto L12;
        int r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L13:
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.f13464b, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r8 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r9.topMargin = 0;
        r9.bottomMargin = 0;
        r9.setMarginStart(0);
        r9.setMarginEnd(0);
        int r10 = b.c[this.s.ordinal()];
        int r13 = 81;
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L22;
        if (r10 == 3) goto L21;
        if (r10 != 4) goto L20;
        int r11 = 8388629;
    L24:
        r9.gravity = r11;
        int r12 = b.c[this.s.ordinal()];
        if (r12 == 1) goto L33;
        if (r12 == 2) goto L32;
        if (r12 == 3) goto L31;
        if (r12 != 4) goto L34;
        r9.setMarginEnd(r2);
    L34:
        r6.setLayoutParams(r8);
        if (r1 == false) goto L37;
        int r14 = R.drawable.oui_coachmark_arrow;
        String r15 = "oui_coachmark_arrow";
    L38:
        int r3 = ZeusTransformUtils.mapRes(r14, "drawable", r15);
        View r16 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L41;
        int r17 = h.a(r16, 20);
    L42:
        if (r1 == false) goto L44;
        int r18 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 9);
    L45:
        View r19 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        Objects.requireNonNull(r110, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams r20 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r110, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r20, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r111.width = r17;
        r111.height = r18;
        int r21 = b.c[this.s.ordinal()];
        if (r21 == 1) goto L54;
        if (r21 == 2) goto L55;
        if (r21 == 3) goto L53;
        if (r21 != 4) goto L52;
        r13 = 8388629;
        goto L55
    L52:
        throw new NoWhenBranchMatchedException();
    L53:
        r13 = 8388627;
    L55:
        r111.gravity = r13;
        r19.setLayoutParams(r20);
        this.c.setImageResource(r3);
        ColorStateList r4 = this.N;
        if (r4 == null) goto L59;
        this.c.setImageTintList(r4);
    L59:
        ImageView r5 = this.c;
        int r22 = b.c[this.s.ordinal()];
        float r23 = 0.0f;
        if (r22 == 1) goto L68;
        if (r22 == 2) goto L67;
        if (r22 == 3) goto L68;
        if (r22 == 4) goto L68;
        throw new NoWhenBranchMatchedException();
    L67:
        float r24 = 180.0f;
    L69:
        r5.setRotation(r24);
        ImageView r25 = this.c;
        if (this.s != ArrowPosition.RIGHT) goto L72;
        float r26 = -1.0f;
    L73:
        r25.setScaleX(r26);
        this.c.setScaleY(1.0f);
        ImageView r27 = this.c;
        if (r1 == false) goto L76;
        r23 = this.w;
    L76:
        r27.setTranslationX(r23);
        this.c.invalidateOutline();
        if (this.ab == false) goto L89;
        com.obric.oui.material.c[] r28 = this.ac;
        if (r28 == null) goto L91;
        com.obric.oui.material.c r29 = r28[0];
        l.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), r29, false, 0, 6, null);
        this.c.setBackgroundColor(0);
        this.c.setImageDrawable(null);
        e r30 = r29.e();
        if (r30 != null) goto L85;
        return;
    L85:
        if (this.c.getVisibility() != 0) goto L87;
        this.f13464b.setBorderWidth(0);
        return;
    L87:
        this.f13464b.setBorderWidth(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r30.a()));
        return;
    L91:
        return;
    L89:
        return;
    L72:
        r26 = 1.0f;
    L68:
        r24 = 0.0f;
        goto L69
    L54:
        r13 = 49;
        goto L55
    L44:
        r18 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20);
        goto L45
    L41:
        r17 = h.a(r16, 10);
        goto L42
    L37:
        r14 = R.drawable.oui_coachmark_arrow_left;
        r15 = "oui_coachmark_arrow_left";
        goto L38
    L31:
        r9.setMarginStart(r2);
        goto L34
    L32:
        r9.bottomMargin = r2;
        goto L34
    L33:
        r9.topMargin = r2;
        goto L34
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r11 = 8388627;
        goto L24
    L22:
        r11 = 81;
        goto L24
    L23:
        r11 = 49;
        goto L24
    L12:
        r2 = 0;
        goto L13
    L5:
        if (this.s == ArrowPosition.BOTTOM) goto L8;
        r1 = false;
        goto L10
    }

    private final void u() {
        this.g.setPaddingRelative(this.T, this.U, this.V, this.W);
    }

    public final void a(CharSequence r3, Integer r4, TextUtils.TruncateAt r5) {
        this.y = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.k.setMaxLines(r6);
    L6:
        if (r5 == null) goto L9;
        this.k.setEllipsize(r5);
    L9:
        c();
    }

    public final CharSequence getText() {
        CharSequence r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.k.getText();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        j();
        super.onDetachedFromWindow();
    }

    public final void setActionStyle(ActionStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.r == r2) goto L6;
        this.r = r2;
        c();
        return;
    }

    public final void setActionText(CharSequence r3) {
        setPrimaryButtonText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setArrowOffset(int r2) {
        if (this.w != r2) goto L5;
        return;
    L5:
        this.w = r2;
        t();
    }

    public final void setArrowPosition(ArrowPosition r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        if (this.s != r2) goto L5;
        return;
    L5:
        this.s = r2;
        t();
    }

    public final void setArrowVisible(boolean r3) {
        if (this.u != r3) goto L5;
        return;
    L5:
        this.u = r3;
        o.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), this.u);
        t();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        if (this.G == r2) goto L6;
        this.G = r2;
        g();
        return;
    }

    public final void setCloseVisible(boolean r1) {
        setShowCloseIcon(r1);
    }

    public final void setContentPadding(int r2) {
        this.aa = true;
        this.T = r2;
        this.U = r2;
        this.V = r2;
        this.W = r2;
        c();
    }

    public final void setContentStyle(ContentStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        if (this.t == r2) goto L6;
        this.t = r2;
        e();
        c();
        return;
    }

    public final void setCustomContentView$OUI_standardRelease(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (this.D != r4) goto L7;
        c();
        return;
    L7:
        if (a(r4) == true) goto L13;
        com.obric.oui.c.a.b r3 = com.obric.oui.c.a.b.f13400a;
        if (r3.a(8) == true) goto L15;
        r3.a().a("OCoachmarkView", 8, "custom content view ignored because it cannot be moved into coachmark content container.", null);
        return;
    L15:
        return;
    L13:
        this.g.removeAllViews();
        this.D = r4;
        this.g.addView(r4);
        c();
    }

    public final void setDescTextAppearance(int r2) {
        if (this.I == r2) goto L6;
        this.I = r2;
        g();
        return;
    }

    public final void setDescription(CharSequence r7) {
        a(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    public final void setHeroImage(Drawable r1) {
        this.C = r1;
        c();
    }

    public final void setIcon(Drawable r1) {
        this.B = r1;
        c();
    }

    public final void setMaxWidth(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (this.S == r2) goto L8;
        this.S = r2;
        c();
        return;
    }

    public final void setOnActionClickListener(View.OnClickListener r3) {
        setOnPrimaryActionClickListener((View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    public final void setOnCloseClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.q.setOnClickListener(r4);
    }

    public final void setOnPrimaryActionClickListener(View.OnClickListener r3) {
        this.E = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        m();
    }

    public final void setOnSecondaryActionClickListener(View.OnClickListener r3) {
        this.F = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        m();
    }

    public final void setPopWindowMode(boolean r2) {
        if (this.ad == r2) goto L13;
        this.ad = r2;
        if (this.ab == true) goto L7;
        return;
    L7:
        if (this.ac == null) goto L15;
        if (r2 == false) goto L10;
        OUIFrameLayout r3 = this.f13464b;
        int r0 = 3;
    L11:
        OMaterialHelper.b(r3, r0);
        OMaterialHelper.b(this.c, r0);
        return;
    L10:
        r3 = this.f13464b;
        r0 = 2;
        goto L11
    L15:
        return;
    }

    public final void setPrimaryButtonText(CharSequence r3) {
        this.z = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        c();
    }

    public final void setSecondaryButtonText(CharSequence r3) {
        this.A = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        c();
    }

    public final void setShowCloseIcon(boolean r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
        e();
        c();
        return;
    }

    public final void setText(CharSequence r7) {
        a(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    public final void setTitle(CharSequence r3) {
        this.x = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        c();
    }

    public final void setTitleTextAppearance(int r2) {
        if (this.H == r2) goto L6;
        this.H = r2;
        g();
        return;
    }
}
