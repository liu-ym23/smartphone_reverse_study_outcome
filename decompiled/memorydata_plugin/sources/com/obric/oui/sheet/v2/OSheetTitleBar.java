package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.h;
import com.obric.oui.material.i;
import com.obric.oui.material.l;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 ¶\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¶\u0001·\u0001B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010n\u001a\u0002042\u0006\u0010o\u001a\u00020\nJ\u0016\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\nJ\u000e\u0010t\u001a\u0002042\u0006\u0010o\u001a\u00020\nJ\u000e\u0010u\u001a\u00020q2\u0006\u0010o\u001a\u00020\nJ\u000e\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020\rJ\u0010\u0010y\u001a\u00020w2\u0006\u0010z\u001a\u00020\"H\u0016J\u0010\u0010{\u001a\u00020w2\u0006\u0010|\u001a\u00020\nH\u0016J\u0010\u0010}\u001a\u00020w2\u0006\u0010z\u001a\u00020\"H\u0016J\u001f\u0010~\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0080\u0001\u001a\u00020\nJ\u001b\u0010\u0081\u0001\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0007J \u0010\u0084\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0080\u0001\u001a\u00020\nJ\u0017\u0010\u0085\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ=\u0010\u0086\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u008b\u0001J\u0017\u0010\u008c\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ=\u0010\u008d\u0001\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020G2\u0007\u0010\u0087\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u008b\u0001J\u0017\u0010\u008e\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\u0017\u0010\u008f\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\u0017\u0010\u0090\u0001\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020GJ\t\u0010\u0091\u0001\u001a\u00020\nH\u0002J\t\u0010\u0092\u0001\u001a\u00020\rH\u0002J\u001f\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020\n2\u0006\u0010x\u001a\u00020\rH\u0002J\t\u0010\u0097\u0001\u001a\u00020\nH\u0002J\u0007\u0010\u0098\u0001\u001a\u00020*J\u0011\u0010\u0099\u0001\u001a\u00020w2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0011\u0010\u009a\u0001\u001a\u00020w2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\t\u0010\u009b\u0001\u001a\u00020\"H\u0016J\t\u0010\u009c\u0001\u001a\u00020\"H\u0002J\u0015\u0010\u009d\u0001\u001a\u00020w2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0014J6\u0010 \u0001\u001a\u00020w2\u0007\u0010¡\u0001\u001a\u00020\"2\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010£\u0001\u001a\u00020\n2\u0007\u0010¤\u0001\u001a\u00020\n2\u0007\u0010¥\u0001\u001a\u00020\nH\u0014J\u001b\u0010¦\u0001\u001a\u00020w2\u0007\u0010§\u0001\u001a\u00020\n2\u0007\u0010¨\u0001\u001a\u00020\nH\u0014J\t\u0010©\u0001\u001a\u00020wH\u0002J\u0007\u0010ª\u0001\u001a\u00020wJ\u0007\u0010«\u0001\u001a\u00020wJ\u0013\u0010¬\u0001\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u00ad\u0001\u001a\u00020w2\u0007\u0010®\u0001\u001a\u00020\nJ\u0010\u0010\u00ad\u0001\u001a\u00020w2\u0007\u0010¯\u0001\u001a\u00020\u0019J\t\u0010°\u0001\u001a\u00020wH\u0002J\u0007\u0010±\u0001\u001a\u00020wJ\u0012\u0010²\u0001\u001a\u00020w2\u0007\u0010³\u0001\u001a\u00020\nH\u0016J\u0011\u0010´\u0001\u001a\u00020w2\u0006\u0010!\u001a\u00020\"H\u0016J\t\u0010µ\u0001\u001a\u00020wH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u000e\u00101\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020=X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020H@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00120RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010T\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR(\u0010Y\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010\u001eR(\u0010\\\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u001c\"\u0004\b^\u0010\u001eR\u001a\u0010_\u001a\u00020`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006¸\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaskMaterialOwner;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backdropTarget", "Landroid/view/View;", "centerTitleGapLargeFontPx", "centerTitleGapPx", "centerTitleHorizontalPaddingPx", "currentMaskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "currentTheme", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", EventBody.KEY_VALUE, "", "desText", "getDesText", "()Ljava/lang/String;", "setDesText", "(Ljava/lang/String;)V", "fixedCenterSubTitleDefaultMaxWidth", "fixedCenterTitleDefaultMaxWidth", "isBackdropView", "", "isFixedCenterOverflow", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mDesContainerView", "mDesTextView", "Lcom/obric/oui/text/OTextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mHandleView", "Landroid/widget/ImageView;", "mIsLargeFont", "mLeftActionBack", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "mTitleBarRoot", "Landroid/view/ViewGroup;", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "maskMaterial", "Lkotlin/Function1;", "materialSrcType", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "subTitleText", "getSubTitleText", "setSubTitleText", "titleText", "getTitleText", "setTitleText", "touchStartX", "", "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartY", "getTouchStartY", "setTouchStartY", "velocityTracker", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "addLeftImageView", "drawableId", "addRightButton", "Lcom/obric/oui/button/OButton;", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "", "view", "applyContentMaterial", "apply", "applyDynamicTheme", "themeStyle", "applyMaskMaterial", "createButton", "root", "layoutResId", "createHandleView", "sheet", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "createIconButton", "createNeutralButton", "createNeutralIconButton", "iconResId", "tintColor", "Landroid/content/res/ColorStateList;", "contentDescriptionResId", "(Landroid/content/Context;Landroid/view/ViewGroup;ILandroid/content/res/ColorStateList;Ljava/lang/Integer;)Lcom/obric/oui/button/OIconButtonFloating;", "createPrimaryButton", "createPrimaryIconButton", "createPrimaryLightButton", "createTransButton", "createUnderstatedButton", "getCenterTitleGap", "getDefaultTargetView", "getFixedCenterSafeBounds", "Lkotlin/Pair;", "totalWidth", "getOccupiedWidth", "getTitleBarContentWidth", "getTitleView", CommonConsts.APM_INNER_EVENT_COST_INIT, "initAttrs", "isDarkTheme", "isFixedCenterTitleVisible", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDimensionCache", "removeAllLeftViews", "removeAllRightViews", "setBackdropTarget", "setCenterText", "resId", "title", "setDefaultBackdropTargetForChild", "sheetTitleBarStyle", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateMaterial", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheetTitleBar extends FrameLayout implements com.obric.oui.material.b, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14483a = null;
    private com.obric.oui.material.c A;
    private boolean B;
    private String C;
    private String D;
    private String E;
    private TitlePosition F;
    private float G;
    private float H;
    private VelocityTracker I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14484b;
    public LinearLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public OIconButtonFloating f;
    private ImageView g;
    private ViewGroup h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private FrameLayout m;
    private OTextView n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private View w;
    private boolean x;
    private int y;
    private Function1<? super Boolean, com.obric.oui.material.c> z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }

        private TitlePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static TitlePosition valueOf(String r2) {
            return (TitlePosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(TitlePosition.class, r2), TitlePosition.class, "com.obric.memorydata.plugin");
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TitlePosition[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$Companion;", "", "()V", "CENTER_TITLE_GAP", "", "CENTER_TITLE_GAP_IN_LARGE_FONT", "CENTER_TITLE_HORIZONTAL_PADDING", "STYLE_AREA_ONLY_ICON", "STYLE_BACK", "STYLE_CUSTOM_BACKGROUND", "STYLE_DELETE", "STYLE_HIGHLIGHT_BLUE", "STYLE_HIGHLIGHT_RED", "STYLE_MIX", "STYLE_NORMAL", "STYLE_NORMAL_WITH_ICON", "STYLE_SEARCH", "STYLE_SETTING", "STYLE_TNT_3_BLUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public static final /* synthetic */ int[] f14485a = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f14485a = r0;
        }
    }

    static {
        f14483a = new a(null);
    }

    public OSheetTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSheetTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSheetTitleBar(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r6);
        this.p = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.r = com.obric.oui.c.h.a(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getConfiguration().fontScale);
        this.x = true;
        this.y = 2;
        this.z = (Function1) ZeusTransformUtils.preCheckCast(new OSheetTitleBar$maskMaterial$1(this), Function1.class, "com.obric.memorydata.plugin");
        this.B = true;
        this.F = TitlePosition.FIXED_CENTER;
        d();
        a(r7);
        if (r8 == null) goto L5;
        a(r8);
    L5:
        b();
    }

    public /* synthetic */ OSheetTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final int a(View r4) {
        int r0 = 0;
        if (r4.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
    L15:
        return 0;
    L8:
        if (r4.getMeasuredWidth() <= 0) goto L15;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        r0 = ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).getMarginStart() + ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).getMarginEnd();
    L14:
        return r4.getMeasuredWidth() + r0;
    L5:
        r3 = false;
        goto L6
    }

    private final void a(Context r5) {
        FrameLayout.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_sheet_title_bar_container_v2, "layout", "o_sheet_title_bar_container_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_main, OaidModel.KEY_ID, "sheet_title_bar_main"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.sheet_title_bar_main)");
        this.h = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, OaidModel.KEY_ID, "center_title"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.center_title)");
        this.i = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.left_title, OaidModel.KEY_ID, "left_title"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.left_title)");
        this.j = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_left_action_container, OaidModel.KEY_ID, "ll_left_action_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.memorydata.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_right_action_container, OaidModel.KEY_ID, "ll_right_action_container"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r10, LinearLayout.class, "com.obric.memorydata.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_center_action_container, OaidModel.KEY_ID, "fl_center_action_container"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_fixed_center_action_container, OaidModel.KEY_ID, "fl_fixed_center_action_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title, OaidModel.KEY_ID, "fixed_center_title"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.fixed_center_title)");
        this.k = (TextView) ZeusTransformUtils.preCheckCast(r13, TextView.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OIconButtonFloating) ZeusTransformUtils.preCheckCast(r14, OIconButtonFloating.class, "com.obric.memorydata.plugin"));
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_sub_title, OaidModel.KEY_ID, "fixed_center_sub_title"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fixed_center_sub_title)");
        this.l = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des, OaidModel.KEY_ID, "sheet_title_bar_des"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.sheet_title_bar_des)");
        this.m = (FrameLayout) ZeusTransformUtils.preCheckCast(r16, FrameLayout.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des_text, OaidModel.KEY_ID, "sheet_title_bar_des_text"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r18 = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.memorydata.plugin");
        this.n = r18;
        TextView r0 = null;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r18 = null;
    L5:
        r18.setEnableAutoAlignLeft(true);
        TextView r19 = this.k;
        if (r19 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r19 = null;
    L8:
        this.p = r19.getMaxWidth();
        TextView r20 = this.l;
        if (r20 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L12:
        this.q = r0.getMaxWidth();
        return;
    L11:
        r0 = r20;
        goto L12
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.OCTitleBar, 0, 0);
        int r1 = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text")));     // Catch: Throwable -> L6
        setDesText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_des_text, "styleable", "OCTitleBar_oui_title_des_text")));     // Catch: Throwable -> L6
        setShowLeftBack(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true));     // Catch: Throwable -> L6
        setSubTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text")));     // Catch: Throwable -> L6
        r7.recycle();
        return;
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private static final boolean a(OSheetTitleBar r6, d r7, View r8, MotionEvent r9) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r0, "$sheet");
        if (r6.I != null) goto L5;
        r6.I = VelocityTracker.obtain();
    L5:
        VelocityTracker r10 = r6.I;
        if (r10 == null) goto L9;
        r10.addMovement(r9);
    L9:
        int r11 = r9.getAction();
        if (r11 != 0) goto L12;
        r6.G = r9.getRawX();
        r6.H = r9.getRawY();
        r6.requestFocus();
        float r1 = 0.0f;
        float r2 = 0.0f;
        boolean r3 = true;
        int r4 = 3;
        Object r5 = null;
    L35:
        d.a.a(r0, r1, r2, r3, r4, r5);
    L36:
        return true;
    L12:
        if (r11 != 1) goto L14;
    L19:
        VelocityTracker r12 = r6.I;
        if (r12 == null) goto L23;
        r12.computeCurrentVelocity(1000);
    L23:
        VelocityTracker r13 = r6.I;
        if (r13 != null) goto L26;
        float r14 = 0.0f;
    L27:
        VelocityTracker r15 = r6.I;
        if (r15 == null) goto L31;
        r15.recycle();
    L31:
        r6.I = null;
        if ((r9.getRawY() - r6.H) < 0.0f) goto L36;
        r0.a(0.0f, r14);
        goto L36
    L26:
        r14 = r13.getYVelocity();
        goto L27
    L14:
        if (r11 != 2) goto L16;
        r2 = RangesKt.coerceAtLeast(r9.getRawY() - r6.H, 0.0f);
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = 0.0f;
        goto L35
    L16:
        if (r11 == 3) goto L19;
        goto L19
    }

    private final void b() {
        this.A = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.z.invoke(Boolean.valueOf(!a())), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.material.c r1 = this.A;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r1 = null;
    L5:
        OMaterialHelper.a(r0, r1, this.y);
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        View r3 = this.w;
        if (r3 != null) goto L9;
        r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    L9:
        l.a(r2, r3);
    }

    private final Pair<Integer, Integer> c(int r8) {
        ViewGroup r0 = this.h;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r0 = null;
    L5:
        int r2 = r0.getPaddingLeft();
        ViewGroup r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L9:
        int r4 = r1.getPaddingRight();
        int r5 = getCenterTitleGap();
        int r6 = a((View) ZeusTransformUtils.preCheckCast(getMLeftContainer(), View.class, "com.obric.memorydata.plugin"));
        int r7 = a((View) ZeusTransformUtils.preCheckCast(getMRightContainer(), View.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0) goto L12;
        int r9 = (r2 + r6) + r5;
    L13:
        int r10 = r8 - r4;
        if (r7 <= 0) goto L16;
        int r11 = (r10 - r7) - r5;
    L18:
        return TuplesKt.to(Integer.valueOf(r9), Integer.valueOf(r11));
    L16:
        r11 = r10 - this.u;
        goto L18
    L12:
        r9 = r2 + this.u;
        goto L13
    L8:
        r1 = r3;
        goto L9
    }

    private final void c() {
        View r0 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r0);
    }

    private final void d() {
        this.s = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        this.t = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        this.u = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    }

    private final boolean e() {
        if (this.F != TitlePosition.FIXED_CENTER) goto L28;
        if (((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L28;
        TextView r1 = this.k;
        TextView r2 = null;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L13:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L29;
        TextView r6 = this.l;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L22:
        if (((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L28;
        return true;
    L24:
        r7 = false;
        goto L25
    L20:
        r2 = r6;
        goto L22
    L29:
        return true;
    L15:
        r3 = false;
        goto L16
    L7:
        r0 = false;
    L28:
        return false;
    }

    private final int getCenterTitleGap() {
        if (this.r == false) goto L6;
        return this.t;
    L6:
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private final View getDefaultTargetView() {
        ?? r3 = this;
        if (OMaterialHelper.c() <= 1) goto L8;
        ViewGroup r4 = this.h;
        r3 = r4;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r3 = 0;
    L8:
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r0 = this.h;
        ViewGroup r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r0 = null;
    L6:
        if (r0.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r3 = this.h;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L14:
        return r1.getMeasuredWidth();
    L10:
        r1 = r3;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    /* JADX INFO: renamed from: lambda$ZY2C35PF_0p-caOewBbwFeJIq7c, reason: not valid java name */
    public static /* synthetic */ boolean m1361lambda$ZY2C35PF_0pcaOewBbwFeJIq7c(OSheetTitleBar r0, d r1, View r2, MotionEvent r3) {
        return a(r0, r1, r2, r3);
    }

    public final ImageView a(Context r5, d r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        final d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "sheet");
        View r9 = FrameLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_handler, "layout", "o_widget_titlebar_handler"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_handler, OaidModel.KEY_ID, "title_handler"));
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(context, R.layou…wById(R.id.title_handler)");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.memorydata.plugin");
        this.g = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        r10 = null;
    L5:
        r10.setOnTouchListener(new $$Lambda$OSheetTitleBar$ZY2C35PF_0pcaOewBbwFeJIq7c(this, r8));
        ImageView r4 = this.g;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mHandleView");
        return null;
    L9:
        return r4;
    }

    public final OIconButtonFloating a(Context r2, ViewGroup r3, int r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        View r5 = FrameLayout.inflate(r1, r4, r3);
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r3.getChildCount() - 1);
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.button.OIconButtonFloating");
        return (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r6, OIconButtonFloating.class, "com.obric.memorydata.plugin");
    }

    public final OIconButtonFloating a(Context r5, ViewGroup r6, int r7, ColorStateList r8, Integer r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r6, "root");
        OIconButtonFloating r11 = a(r10, r6, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_neutral_icon_button, "layout", "o_widget_titlebar_neutral_icon_button"));
        l.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), getDefaultTargetView());
        r11.setIcon(r7);
        if (r8 == null) goto L6;
        r11.setIconTintColor(r8);
    L6:
        if (r9 == null) goto L9;
        ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        r11.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r9.intValue()), CharSequence.class, "com.obric.memorydata.plugin"));
    L9:
        return r11;
    }

    public void a(int r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
        b();
        return;
    }

    @Override // com.obric.oui.material.b
    public void a(boolean r4) {
        if (this.y == (-1)) goto L6;
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.y);
        return;
    L6:
        i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.x);
    }

    public boolean a() {
        int r0 = this.v;
        boolean r1 = false;
        if (r0 != 0) goto L5;
        TextView r2 = this.j;
        String r3 = "mLeftTitleView";
        TextView r4 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r2 = null;
    L12:
        if (((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L21;
        TextView r7 = this.j;
        if (r7 != null) goto L19;
    L18:
        Intrinsics.throwUninitializedPropertyAccessException(r3);
    L20:
        int r8 = r4.getTextColors().getDefaultColor();
    L33:
        return !com.obric.oui.color.d.a(r8);
    L19:
        r4 = r7;
        goto L20
    L21:
        TextView r6 = this.k;
        r3 = "mFixedCenterTitleView";
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r6 = null;
    L25:
        if (((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L27;
        r1 = true;
    L27:
        if (r1 == false) goto L31;
        r7 = this.k;
        if (r7 != null) goto L19;
    L31:
        r8 = ViewCompat.MEASURED_STATE_MASK;
        goto L33
    L14:
        r5 = false;
        goto L15
    L5:
        if (r0 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    public final OIconButtonFloating b(Context r5, ViewGroup r6, int r7, ColorStateList r8, Integer r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r6, "root");
        OIconButtonFloating r11 = a(r10, r6, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_primary_icon_button, "layout", "o_widget_titlebar_primary_icon_button"));
        l.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"), getDefaultTargetView());
        r11.setIcon(r7);
        if (r8 == null) goto L6;
        r11.setIconTintColor(r8);
    L6:
        if (r9 == null) goto L9;
        ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue();
        r11.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r9.intValue()), CharSequence.class, "com.obric.memorydata.plugin"));
    L9:
        return r11;
    }

    @Override // com.obric.oui.material.h
    public void b(int r4) {
        this.y = r4;
        i.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(getMLeftActionBack()), Iterable.class, "com.obric.memorydata.plugin"), r4);
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
    }

    public final int getCurrentTheme() {
        return this.v;
    }

    public final String getDesText() {
        return this.E;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.f14484b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TitlePosition getMTitlePosition() {
        return this.F;
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.F;
        int r1 = b.f14485a[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.k;
        if (r3 != null) goto L21;
        String r4 = "mFixedCenterTitleView";
    L19:
        Intrinsics.throwUninitializedPropertyAccessException(r4);
        return null;
    L21:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.i;
        if (r3 != null) goto L21;
        r4 = "mCenterTitleView";
        goto L19
    L7:
        if (r1 != 3) goto L12;
        r3 = this.j;
        if (r3 != null) goto L21;
        r4 = "mLeftTitleView";
        goto L19
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.B;
    }

    public final String getSubTitleText() {
        return this.C;
    }

    public final String getTitleText() {
        return this.D;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final float getTouchStartX() {
        return this.G;
    }

    public final float getTouchStartY() {
        return this.H;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.I;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        this.r = com.obric.oui.c.h.a(r1.fontScale);
    L6:
        d();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        if (e() == true) goto L5;
        return;
    L5:
        int r7 = getTitleBarContentWidth();
        if (r7 > 0) goto L8;
        return;
    L8:
        Pair<Integer, Integer> r8 = c(r7);
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r8.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = Math.max(0, r10 - r9);
        int r12 = getMFixedCenterContainer().getMeasuredWidth();
        int r13 = (r7 - r12) / 2;
        int r0 = r13 + r12;
        if (r12 <= r11) goto L11;
    L10:
        r13 = r9;
    L17:
        if (this.o == false) goto L20;
        if (r12 > r11) goto L20;
        r13 = r9 + ((r11 - r12) / 2);
        r10 = r13 + r12;
    L20:
        getMFixedCenterContainer().layout(r13, getMFixedCenterContainer().getTop(), r10, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r13 >= r9) goto L13;
        r10 = r9 + r12;
        goto L10
    L13:
        if (r0 <= r10) goto L15;
        r13 = r10 - r12;
        goto L17
    L15:
        r10 = r0;
        goto L17
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r0 = false;
        this.o = false;
        TextView r1 = this.k;
        TextView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r1 = null;
    L5:
        r1.setMaxWidth(this.p);
        TextView r2 = this.l;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L8:
        r2.setMaxWidth(this.q);
        super.onMeasure(r10, r11);
        if (e() == true) goto L11;
        return;
    L11:
        int r4 = getTitleBarContentWidth();
        if (r4 > 0) goto L14;
        return;
    L14:
        Pair<Integer, Integer> r5 = c(r4);
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r5.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r8 = r4 / 2;
        int r9 = Math.max(0, Math.min((r8 - r6) * 2, (r7 - r8) * 2));
        int r12 = Math.max(0, r7 - r6);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r9) goto L39;
        boolean r13 = true;
        this.o = true;
        int r14 = Math.min(this.p, r12);
        int r15 = Math.min(this.q, r12);
        TextView r16 = this.k;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L20:
        if (r16.getMaxWidth() == r14) goto L25;
        TextView r17 = this.k;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r17 = null;
    L24:
        r17.setMaxWidth(r14);
        r0 = true;
    L25:
        TextView r18 = this.l;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r18 = null;
    L29:
        if (r18.getMaxWidth() == r15) goto L35;
        TextView r19 = this.l;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L34:
        r3.setMaxWidth(r15);
    L36:
        if (r13 == false) goto L40;
        super.onMeasure(r10, r11);
        return;
    L40:
        return;
    L33:
        r3 = r19;
        goto L34
    L35:
        r13 = r0;
        goto L36
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        this.w = r3;
        if (r3 != null) goto L6;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        c();
        return;
    L6:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        i.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(getMLeftActionBack()), Iterable.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setCenterText(int r2) {
        String r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        setTitleText(r2);
    }

    public final void setCurrentTheme(int r1) {
        this.v = r1;
    }

    public final void setDesText(String r6) {
        this.E = r6;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        OTextView r4 = null;
        FrameLayout r5 = null;
        if (r1 == false) goto L16;
        FrameLayout r7 = this.m;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r5.setVisibility(8);
        return;
    L14:
        r5 = r7;
        goto L15
    L16:
        FrameLayout r2 = this.m;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r2 = null;
    L19:
        r2.setVisibility(0);
        OTextView r8 = this.n;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L23:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        r4 = r8;
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMLeftActionBack(OIconButtonFloating r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14484b = r2;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        this.F = r8;
        int r9 = b.f14485a[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.k;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L32:
        r10.setVisibility(0);
        TextView r11 = this.i;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L35:
        r11.setVisibility(8);
        TextView r12 = this.j;
        if (r12 != null) goto L38;
    L37:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L39:
        r6.setVisibility(8);
    L40:
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.D, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r6 = r12;
        goto L39
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.k;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.i;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        r12 = this.j;
        if (r12 != null) goto L38;
    L7:
        if (r9 != 3) goto L40;
        TextView r15 = this.k;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r15 = null;
    L12:
        r15.setVisibility(8);
        TextView r16 = this.i;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r16 = null;
    L15:
        r16.setVisibility(8);
        TextView r17 = this.j;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L40
    L18:
        r6 = r17;
        goto L19
    }

    public final void setShowLeftBack(boolean r3) {
        this.B = r3;
        OIconButtonFloating r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.F != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final void setSubTitleText(String r5) {
        this.C = r5;
        TextView r0 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.l;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r0.setVisibility(8);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        TextView r2 = this.l;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r6 = this.l;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        r0 = r6;
        goto L16
    }

    public final void setTitleText(String r3) {
        this.D = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setTouchStartX(float r1) {
        this.G = r1;
    }

    public final void setTouchStartY(float r1) {
        this.H = r1;
    }

    public final void setVelocityTracker(VelocityTracker r1) {
        this.I = r1;
    }
}
