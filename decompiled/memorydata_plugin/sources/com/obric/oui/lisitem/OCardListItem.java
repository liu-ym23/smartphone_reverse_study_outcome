package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.h;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 ±\u00012\u00020\u0001:\u0002±\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\u0006\u0010C\u001a\u00020AJ\u0016\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007J\u0006\u0010G\u001a\u00020\u0001J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u00020\u0001J\u0006\u0010J\u001a\u00020\u0007J\u0006\u0010K\u001a\u00020\u0015J\u0006\u0010L\u001a\u00020\u0011J\b\u0010M\u001a\u0004\u0018\u00010(J\b\u0010N\u001a\u0004\u0018\u00010(J\u0010\u0010O\u001a\u0004\u0018\u0001062\u0006\u0010P\u001a\u00020\u0007J\u0010\u0010Q\u001a\u0004\u0018\u0001062\u0006\u0010P\u001a\u00020\u0007J\u0010\u0010R\u001a\u0004\u0018\u00010(2\u0006\u0010P\u001a\u00020\u0007J\b\u0010S\u001a\u0004\u0018\u00010TJ\b\u0010U\u001a\u0004\u0018\u000106J\b\u0010V\u001a\u0004\u0018\u00010WJ\b\u0010X\u001a\u0004\u0018\u00010YJ\u0006\u0010Z\u001a\u00020,J\u0006\u0010[\u001a\u00020*J\b\u0010\\\u001a\u0004\u0018\u00010TJ\b\u0010]\u001a\u0004\u0018\u00010^J\u0006\u0010_\u001a\u000206J\u0006\u0010`\u001a\u00020:J\b\u0010a\u001a\u0004\u0018\u00010(J\u0006\u0010b\u001a\u00020,J\b\u0010c\u001a\u0004\u0018\u00010^J\u0006\u0010d\u001a\u00020?J\u0006\u0010e\u001a\u000206J\b\u0010f\u001a\u00020AH\u0014J\u0012\u0010g\u001a\u00020A2\b\u0010h\u001a\u0004\u0018\u00010iH\u0014J\b\u0010j\u001a\u00020AH\u0014J\u0010\u0010k\u001a\u00020A2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020(2\u0006\u0010n\u001a\u00020*H\u0002J\b\u0010o\u001a\u00020AH\u0002J\b\u0010p\u001a\u00020AH\u0002J\b\u0010q\u001a\u00020AH\u0002J\b\u0010r\u001a\u00020AH\u0002J\b\u0010s\u001a\u00020AH\u0002J\u0006\u0010t\u001a\u00020AJ\u0010\u0010u\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000e\u0010u\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0007J\u001a\u0010{\u001a\u00020A2\u0006\u0010|\u001a\u00020\u00072\b\b\u0002\u0010}\u001a\u00020*H\u0007J\u000e\u0010~\u001a\u00020A2\u0006\u0010\u007f\u001a\u00020\u0007J\u0010\u0010\u0080\u0001\u001a\u00020A2\u0007\u0010\u0081\u0001\u001a\u00020*J\u000f\u0010\u0082\u0001\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0015J\u000f\u0010\u0082\u0001\u001a\u00020A2\u0006\u0010z\u001a\u00020\u0007J\u0011\u0010\u0083\u0001\u001a\u00020A2\b\u0010z\u001a\u0004\u0018\u00010\u0015J\u0011\u0010\u0084\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010\u0084\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0011\u0010\u0085\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010\u0085\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J&\u0010\u0086\u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(2\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J$\u0010\u0086\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J\u0010\u0010\u0088\u0001\u001a\u00020A2\u0007\u0010\u0089\u0001\u001a\u00020\u0007J\u0010\u0010\u008a\u0001\u001a\u00020A2\u0007\u0010\u008b\u0001\u001a\u00020\u0007J%\u0010\u008c\u0001\u001a\u00020A2\u0007\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020*H\u0007J\u0010\u0010\u008e\u0001\u001a\u00020A2\u0007\u0010\u008f\u0001\u001a\u00020\u0007J\u0010\u0010\u0090\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020*J\u0010\u0010\u0092\u0001\u001a\u00020A2\u0007\u0010\u0091\u0001\u001a\u00020*J\u0011\u0010\u0093\u0001\u001a\u00020A2\u0006\u0010n\u001a\u00020*H\u0016J\u001f\u0010\u0094\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0007H\u0007J\u0011\u0010\u0097\u0001\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000f\u0010\u0097\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0013\u0010\u0098\u0001\u001a\u00020A2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001J\u0013\u0010\u009b\u0001\u001a\u00020A2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009c\u0001J\u0010\u0010\u009d\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0012\u0010\u009f\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^J\u0011\u0010 \u0001\u001a\u00020A2\b\u0010m\u001a\u0004\u0018\u00010(J\u000f\u0010 \u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0011\u0010¡\u0001\u001a\u00020A2\b\u0010v\u001a\u0004\u0018\u00010wJ\u000f\u0010¡\u0001\u001a\u00020A2\u0006\u0010x\u001a\u00020\u0007J\u0012\u0010¢\u0001\u001a\u00020A2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010^J\u0019\u0010£\u0001\u001a\u00020A2\u0007\u0010¤\u0001\u001a\u00020\u00072\u0007\u0010¥\u0001\u001a\u00020\u0007J\u0010\u0010¦\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010§\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010¨\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010©\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010ª\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010«\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0010\u0010¬\u0001\u001a\u00020A2\u0007\u0010\u009e\u0001\u001a\u00020*J\u0007\u0010\u00ad\u0001\u001a\u00020AJ\u0007\u0010®\u0001\u001a\u00020AJ\u0007\u0010¯\u0001\u001a\u00020AJ\t\u0010°\u0001\u001a\u00020AH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010.\u001a\u00020*2\u0006\u0010\u0014\u001a\u00020*8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0001"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appIcon", "Lcom/obric/oui/image/OImageAppIcon;", "bgColor", "cardContainer", "Lcom/obric/oui/layout/OUIFrameLayout;", "cardListItemPositionHelper", "Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "contentContainer", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "contentContainerBg", "Lcom/obric/oui/common/style/OStateGradientDrawable;", EventBody.KEY_VALUE, "Landroid/content/res/ColorStateList;", "contentContainerBgColor", "getContentContainerBgColor", "()Landroid/content/res/ColorStateList;", "setContentContainerBgColor", "(Landroid/content/res/ColorStateList;)V", "contentDefaultContainerBgColor", "contentMarkContainerBgColor", "currentPosition", "currentSwipeOffset", "currentType", "customDividerEnd", "customDividerStart", "customEndContainer", "customStartContainer", "customStartLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "customTitleMode", "divider", "Landroid/view/View;", "enableSwipeDivider", "", "icon", "Landroid/widget/ImageView;", "iconContainer", "isMark", "()Z", "setMark", "(Z)V", "maxTailTextWidth", "root", "showCardBg", "subTitle", "Lcom/obric/oui/text/OTextView;", "subTitleColor", "swipeContainer", "swipeLayout", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "tailIcon", "title", "titleColor", "titleContainer", "Landroid/widget/LinearLayout;", "addAppIconIfNotExist", "", "checkContentContainerListenerForBackground", "clearCustomTitleView", "customDivider", CommonConsts.APM_INNER_EVENT_COST_START, "end", "getCardContainer", "getCardPosition", "getCardRoot", "getCardType", "getContentColor", "getContentContainer", "getCustomEndView", "getCustomStartView", "getCustomTitleDetail", "index", "getCustomTitleText", "getCustomTitleView", "getEndCheckBox", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getEndDetail", "getEndMark", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getIconView", "getShowCardBg", "getStartCheckBox", "getSubTitle", "", "getSubTitleView", "getSwipeLayout", "getSwipeView", "getTailIconView", "getTitle", "getTitleContainer", "getTitleView", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "parseAttributes", "recursiveSetEnabled", "view", "enabled", "resetContentContainerBackground", "resetContentContainerCorner", "resetCustomEndDetail", "resetIconCorner", "resetTitlePadding", "revertContentColor", "setAppIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "resId", "setBgColor", TypedValues.Custom.S_COLOR, "setCardPosition", "position", "animate", "setCardType", "type", "setContentChecked", "checked", "setContentColor", "setContentMarkColor", "setCustomEndView", "setCustomStartView", "setCustomTitleView", "matchParent", "setDefaultCustomEndView", "defaultCustomEnd", "setDefaultCustomStartView", "defaultCustomStart", "setDefaultCustomTitleView", "defaultCustomTitle", "setDefaultTailIcon", "defaultTailIcon", "setEnableSwipe", "enable", "setEnableSwipeDivider", "setEnabled", "setEndDetailText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "maxWidth", "setIcon", "setOnContentClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnContentLongClickListener", "Landroid/view/View$OnLongClickListener;", "setShowCardBg", "show", "setSubTitle", "setSwipeView", "setTailIcon", "setTitle", "setTitleColor", "titleC", "subTitleC", "showCustomEnd", "showCustomStart", "showDivider", "showIcon", "showSubTitle", "showTailIcon", "showTitle", "swipeClose", "swipeOpen", "swipeToggle", "updateDividerPosition", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCardListItem extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13969b = null;
    private FrameLayout A;
    private int B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private ColorStateList H;
    private boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.oui.lisitem.a f13970a;
    private boolean c;
    private int d;
    private final FrameLayout e;
    private final OUIFrameLayout f;
    private final OUICardConstraintLayout g;
    private OStateGradientDrawable h;
    private ColorStateList i;
    private ColorStateList j;
    private final FrameLayout k;
    private final FrameLayout l;
    private final ImageView m;
    private OImageAppIcon n;
    private final LinearLayout o;
    private final OTextView p;
    private int q;
    private final OTextView r;
    private int s;
    private final FrameLayout t;
    private final ImageView u;
    private final View v;
    private View.OnLayoutChangeListener w;
    private int x;
    private int y;
    private OSwipeLayout z;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem$Companion;", "", "()V", "CUSTOM_END_CHECKBOX", "", "CUSTOM_END_DETAIL", "CUSTOM_END_HANDLE", "CUSTOM_END_MARK", "CUSTOM_END_SWITCH", "CUSTOM_START_CHECKBOX", "CUSTOM_TITLE_DETAIL", "CUSTOM_TITLE_ICON", "CUSTOM_TITLE_NONE", "DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP", "POSITION_BOTTOM", "POSITION_MIDDLE", "POSITION_SINGLE", "POSITION_TOP", "TAIL_ICON_ARROW", "TAIL_ICON_CHEVRON", "TYPE_CONTAINER", "TYPE_LARGE", "TYPE_NORMAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/lisitem/OCardListItem$resetIconCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCardListItem f13972a;

        b(OCardListItem r1) {
            this.f13972a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            int r4 = r8.getWidth();
            int r5 = r8.getHeight();
            int r10 = OCardListItem.a(this.f13972a);
            OCardListItem r7 = this.f13972a;
            if (r10 != 0) goto L5;
            View r11 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
            int r12 = 8;
        L6:
            r9.setRoundRect(0, 0, r4, r5, h.a(r11, r12));
            return;
        L5:
            r11 = (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
            r12 = 10;
            goto L6
        }
    }

    static {
        f13969b = new a(null);
    }

    public OCardListItem(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCardListItem(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OCardListItem(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        this.c = true;
        this.d = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_fill_list_item_card"));
        this.h = new OStateGradientDrawable();
        ColorStateList r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColorStateList(ZeusTransformUtils.mapRes(R.color.o_card_list_item_content_bg_color, TypedValues.Custom.S_COLOR, "o_card_list_item_content_bg_color"));
        Intrinsics.checkNotNullExpressionValue(r0, "resources.getColorStateL…st_item_content_bg_color)");
        this.i = r0;
        this.q = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        this.s = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3"));
        this.x = -1;
        this.y = -1;
        this.C = true;
        this.G = -1;
        this.H = this.i;
        this.F = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 168);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_card_list_item_layout, "layout", "o_card_list_item_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r12 = (FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.card_list_item_root, OaidModel.KEY_ID, "card_list_item_root"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.card_list_item_root)");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.memorydata.plugin");
        this.e = r14;
        r14.setClickable(true);
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.card_container, OaidModel.KEY_ID, "card_container"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.card_container)");
        OUIFrameLayout r16 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r15, OUIFrameLayout.class, "com.obric.memorydata.plugin");
        this.f = r16;
        r16.setChangeAlphaWhenPress(false);
        r16.setChangeAlphaWhenDisable(false);
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.content_container)");
        OUICardConstraintLayout r4 = (OUICardConstraintLayout) ZeusTransformUtils.preCheckCast(r3, OUICardConstraintLayout.class, "com.obric.memorydata.plugin");
        this.g = r4;
        r4.setChangeAlphaWhenPress(false);
        r4.setChangeAlphaWhenDisable(true);
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_start_container, OaidModel.KEY_ID, "custom_start_container"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.custom_start_container)");
        this.k = (FrameLayout) ZeusTransformUtils.preCheckCast(r17, FrameLayout.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.icon_container, OaidModel.KEY_ID, "icon_container"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.icon_container)");
        this.l = (FrameLayout) ZeusTransformUtils.preCheckCast(r18, FrameLayout.class, "com.obric.memorydata.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.icon, OaidModel.KEY_ID, "icon"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.icon)");
        this.m = (ImageView) ZeusTransformUtils.preCheckCast(r19, ImageView.class, "com.obric.memorydata.plugin");
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container"));
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.title_container)");
        this.o = (LinearLayout) ZeusTransformUtils.preCheckCast(r20, LinearLayout.class, "com.obric.memorydata.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.title)");
        this.p = (OTextView) ZeusTransformUtils.preCheckCast(r21, OTextView.class, "com.obric.memorydata.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.sub_title, OaidModel.KEY_ID, "sub_title"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.sub_title)");
        this.r = (OTextView) ZeusTransformUtils.preCheckCast(r22, OTextView.class, "com.obric.memorydata.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, OaidModel.KEY_ID, "custom_end_container"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.custom_end_container)");
        this.t = (FrameLayout) ZeusTransformUtils.preCheckCast(r23, FrameLayout.class, "com.obric.memorydata.plugin");
        View r24 = findViewById(ZeusTransformUtils.mapRes(R.id.tail_icon, OaidModel.KEY_ID, "tail_icon"));
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.tail_icon)");
        this.u = (ImageView) ZeusTransformUtils.preCheckCast(r24, ImageView.class, "com.obric.memorydata.plugin");
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.card_divider, OaidModel.KEY_ID, "card_divider"));
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.card_divider)");
        this.v = r25;
        this.w = new $$Lambda$OCardListItem$M214qmr89Z2dZ0b_FSdHMCKP0CM(this);
        View r26 = findViewById(ZeusTransformUtils.mapRes(R.id.swipe_layout, OaidModel.KEY_ID, "swipe_layout"));
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.swipe_layout)");
        OSwipeLayout r27 = (OSwipeLayout) ZeusTransformUtils.preCheckCast(r26, OSwipeLayout.class, "com.obric.memorydata.plugin");
        this.z = r27;
        r27.setChangeAlphaWhenPress(false);
        this.z.setChangeAlphaWhenDisable(false);
        this.z.setSwipeEnabled(false);
        this.z.a((OSwipeLayout.g) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), OSwipeLayout.g.class, "com.obric.memorydata.plugin"));
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.swip_container, OaidModel.KEY_ID, "swip_container"));
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.swip_container)");
        this.A = (FrameLayout) ZeusTransformUtils.preCheckCast(r28, FrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        a(r10);
    L9:
        d();
        setCardType(this.E);
        a(this.q, this.s);
        this.f13970a = new com.obric.oui.lisitem.a((FrameLayout) ZeusTransformUtils.preCheckCast(r16, FrameLayout.class, "com.obric.memorydata.plugin"), this.c, this.d, this.D);
    }

    public /* synthetic */ OCardListItem(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ int a(OCardListItem r0) {
        return r0.E;
    }

    private final void a(AttributeSet r27) {
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r27, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r12, R.styleable.OCardListItemContainer);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…e.OCardListItemContainer)");
    L74:
        th = move-exception;
        r13.recycle();
        throw th;
    L4:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg, "styleable", "OCardListItemContainer_ocardlistitem_showCardBg")) == false) goto L6;
        this.c = r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCardBg, "styleable", "OCardListItemContainer_ocardlistitem_showCardBg"), true);     // Catch: Throwable -> L74
    L6:
        this.d = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_bgColor, "styleable", "OCardListItemContainer_ocardlistitem_bgColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_fill_list_item_card")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList, "styleable", "OCardListItemContainer_ocardlistitem_contentColorList")) == false) goto L13;
        ColorStateList r1 = r13.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_contentColorList, "styleable", "OCardListItemContainer_ocardlistitem_contentColorList"));     // Catch: Throwable -> L74
        if (r1 != null) goto L11;
        r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColorStateList(ZeusTransformUtils.mapRes(R.color.o_card_list_item_content_bg_color, TypedValues.Custom.S_COLOR, "o_card_list_item_content_bg_color"));     // Catch: Throwable -> L74
        Intrinsics.checkNotNullExpressionValue(r1, "resources.getColorStateL…st_item_content_bg_color)");     // Catch: Throwable -> L74
    L11:
        this.i = r1;     // Catch: Throwable -> L74
        setContentContainerBgColor(r1);     // Catch: Throwable -> L74
    L13:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardType, "styleable", "OCardListItemContainer_ocardlistitem_cardType")) == false) goto L16;
        this.E = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardType, "styleable", "OCardListItemContainer_ocardlistitem_cardType"), 0);     // Catch: Throwable -> L74
    L16:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition, "styleable", "OCardListItemContainer_ocardlistitem_cardPosition")) == false) goto L19;
        this.D = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_cardPosition, "styleable", "OCardListItemContainer_ocardlistitem_cardPosition"), 0);     // Catch: Throwable -> L74
    L19:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customStart, "styleable", "OCardListItemContainer_ocardlistitem_customStart")) == false) goto L22;
        setCustomStartView(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customStart, "styleable", "OCardListItemContainer_ocardlistitem_customStart"), 0));     // Catch: Throwable -> L74
    L22:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomStart")) == false) goto L25;
        setDefaultCustomStartView(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomStart"), 0));     // Catch: Throwable -> L74
    L25:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_icon, "styleable", "OCardListItemContainer_ocardlistitem_icon")) == false) goto L28;
        setIcon(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_icon, "styleable", "OCardListItemContainer_ocardlistitem_icon"), 0));     // Catch: Throwable -> L74
    L28:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_title, "styleable", "OCardListItemContainer_ocardlistitem_title")) == false) goto L30;
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_title, "styleable", "OCardListItemContainer_ocardlistitem_title")), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L74
    L30:
        this.q = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_titleColor, "styleable", "OCardListItemContainer_ocardlistitem_titleColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitle, "styleable", "OCardListItemContainer_ocardlistitem_subTitle")) == false) goto L33;
        setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitle, "styleable", "OCardListItemContainer_ocardlistitem_subTitle")), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L74
    L33:
        this.s = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_subTitleColor, "styleable", "OCardListItemContainer_ocardlistitem_subTitleColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));     // Catch: Throwable -> L74
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomTitle")) == false) goto L37;
        a(this, r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomTitle"), 0), 0, false, 4, null);     // Catch: Throwable -> L74
    L37:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customEnd, "styleable", "OCardListItemContainer_ocardlistitem_customEnd")) == false) goto L40;
        setCustomEndView(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_customEnd, "styleable", "OCardListItemContainer_ocardlistitem_customEnd"), 0));     // Catch: Throwable -> L74
    L40:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomEnd")) == false) goto L43;
        setDefaultCustomEndView(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_defaultCustomEnd"), 0));     // Catch: Throwable -> L74
    L43:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText, "styleable", "OCardListItemContainer_ocardlistitem_endDetailText")) == false) goto L46;
        a(this, (CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_endDetailText, "styleable", "OCardListItemContainer_ocardlistitem_endDetailText")), CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L74
    L46:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon, "styleable", "OCardListItemContainer_ocardlistitem_tailIcon")) == false) goto L49;
        setTailIcon(r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_tailIcon, "styleable", "OCardListItemContainer_ocardlistitem_tailIcon"), 0));     // Catch: Throwable -> L74
    L49:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_defaultTailIcon")) == false) goto L52;
        setDefaultTailIcon(r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_defaultTailIcon"), 0));     // Catch: Throwable -> L74
    L52:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_showCustomStart")) == false) goto L55;
        a(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomStart, "styleable", "OCardListItemContainer_ocardlistitem_showCustomStart"), false));     // Catch: Throwable -> L74
    L55:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showIcon, "styleable", "OCardListItemContainer_ocardlistitem_showIcon")) == false) goto L58;
        b(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showIcon, "styleable", "OCardListItemContainer_ocardlistitem_showIcon"), false));     // Catch: Throwable -> L74
    L58:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTitle, "styleable", "OCardListItemContainer_ocardlistitem_showTitle")) == false) goto L61;
        c(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTitle, "styleable", "OCardListItemContainer_ocardlistitem_showTitle"), false));     // Catch: Throwable -> L74
    L61:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle, "styleable", "OCardListItemContainer_ocardlistitem_showSubTitle")) == false) goto L64;
        d(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showSubTitle, "styleable", "OCardListItemContainer_ocardlistitem_showSubTitle"), false));     // Catch: Throwable -> L74
    L64:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_showCustomEnd")) == false) goto L67;
        e(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, "styleable", "OCardListItemContainer_ocardlistitem_showCustomEnd"), false));     // Catch: Throwable -> L74
    L67:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_showTailIcon")) == false) goto L70;
        f(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showTailIcon, "styleable", "OCardListItemContainer_ocardlistitem_showTailIcon"), false));     // Catch: Throwable -> L74
    L70:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showDivider, "styleable", "OCardListItemContainer_ocardlistitem_showDivider")) == false) goto L72;
        g(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCardListItemContainer_ocardlistitem_showDivider, "styleable", "OCardListItemContainer_ocardlistitem_showDivider"), false));     // Catch: Throwable -> L74
    L72:
        r13.recycle();
    }

    private final void a(View r6, boolean r7) {
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L7;
        int r0 = 0;
        int r1 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L5:
        if (r0 >= r1) goto L9;
        int r3 = r0 + 1;
        View r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        r2.setEnabled(r7);
        Intrinsics.checkNotNullExpressionValue(r2, "child");
        a(r2, r7);
        r0 = r3;
        goto L5
    L9:
        return;
    }

    public static final /* synthetic */ void a(OCardListItem r0, int r1) {
        r0.B = r1;
    }

    public static /* synthetic */ void a(OCardListItem r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 4) == 0) goto L9;
        r3 = true;
        if (r1 == 1) goto L9;
        r3 = false;
    L9:
        r0.b(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCustomTitleView");
    }

    public static /* synthetic */ void a(OCardListItem r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCardPosition");
    }

    private static final void a(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.v.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        r0.j();
        return;
    L9:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static /* synthetic */ void a(OCardListItem r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.a(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomTitleView");
    }

    public static /* synthetic */ void a(OCardListItem r2, CharSequence r3, int r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = -1;
    L7:
        r2.a(r7, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEndDetailText");
    }

    public static final /* synthetic */ View b(OCardListItem r0) {
        return r0.v;
    }

    private final void c() {
        if (this.c == false) goto L5;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r1 = 12;
    L6:
        int r2 = h.a(r0, r1);
        OStateGradientDrawable r3 = this.h;
        if (r3 == null) goto L10;
        r3.setSolidColors(getContentContainerBgColor());
    L10:
        OStateGradientDrawable r4 = this.h;
        if (r4 == null) goto L14;
        r4.setCornerRadius(r2);
    L14:
        e();
        return;
    L5:
        r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r1 = 20;
        goto L6
    }

    public static final /* synthetic */ boolean c(OCardListItem r0) {
        return r0.C;
    }

    private final void d() {
        c();
        if (this.c == false) goto L5;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r1 = 12;
    L6:
        int r2 = h.a(r0, r1);
        OSwipeLayout r3 = this.z;
        boolean r4 = this.c;
        boolean r5 = false;
        if (r4 == false) goto L9;
        int r6 = r2;
    L10:
        if (r4 == true) goto L13;
        r2 = 0;
    L13:
        r3.setRadius(r6, 0, r2, 0);
        if (this.v.getVisibility() != 0) goto L16;
        r5 = true;
    L16:
        if (r5 == false) goto L19;
        j();
        return;
    L19:
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r0 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r1 = 20;
        goto L6
    }

    private static final void d(OCardListItem r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        int r0 = r10.x;
        int r1 = r10.y;
        ViewGroup.MarginLayoutParams r3 = null;
        if (r0 == (-1)) goto L5;
        if (r1 == (-1)) goto L5;
    L42:
        ViewGroup.LayoutParams r2 = r10.v.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L45;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L45:
        if (r3 == null) goto L48;
        r3.setMargins(r0, r3.topMargin, r1, r3.bottomMargin);
    L48:
        r10.v.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        ViewGroup.LayoutParams r4 = ((View) ZeusTransformUtils.preCheckCast(r10.f, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == true) goto L8;
        r4 = null;
    L8:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r5 == null) goto L11;
        int r7 = r5.leftMargin;
    L12:
        int r8 = r10.f.getPaddingLeft();
        ViewGroup.LayoutParams r9 = ((View) ZeusTransformUtils.preCheckCast(r10.f, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.MarginLayoutParams.class) == true) goto L15;
        r9 = null;
    L15:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L18;
        int r12 = r11.rightMargin;
    L19:
        int r13 = r10.f.getPaddingRight();
        r0 = r7 + r8;
        if (((View) ZeusTransformUtils.preCheckCast(r10.k, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        r0 = r0 + r10.k.getWidth();
    L26:
        if (((View) ZeusTransformUtils.preCheckCast(r10.l, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L32;
        r0 = r0 + r10.l.getWidth();
    L32:
        if (((View) ZeusTransformUtils.preCheckCast(r10.k, View.class, "com.obric.memorydata.plugin")).getVisibility() != 8) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == true) goto L37;
    L41:
        r1 = h.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), 8) + (r12 + r13);
        goto L42
    L37:
        if (((View) ZeusTransformUtils.preCheckCast(r10.l, View.class, "com.obric.memorydata.plugin")).getVisibility() != 8) goto L39;
        r6 = true;
    L39:
        if (r6 == false) goto L41;
        r0 = r0 + r10.o.getPaddingLeft();
        goto L41
    L34:
        r16 = false;
        goto L35
    L28:
        r15 = false;
        goto L29
    L22:
        r14 = false;
        goto L23
    L18:
        r12 = 0;
        goto L19
    L11:
        r7 = 0;
        goto L12
    }

    private final void e() {
        if (this.g.hasOnClickListeners() == false) goto L5;
    L8:
        this.g.setBackground((Drawable) ZeusTransformUtils.preCheckCast(this.h, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (this.g.hasOnLongClickListeners() == true) goto L8;
        this.g.setBackground(null);
    }

    private final void f() {
        this.m.setClipToOutline(true);
        this.m.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new b(this), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        this.m.invalidateOutline();
    }

    private final void g() {
        OImageAppIcon r0 = (OImageAppIcon) ZeusTransformUtils.preCheckCast(this.l.findViewById(ZeusTransformUtils.mapRes(R.id.o_list_item_app_icon, OaidModel.KEY_ID, "o_list_item_app_icon")), OImageAppIcon.class, "com.obric.memorydata.plugin");
        this.n = r0;
        if (r0 != null) goto L5;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        OImageAppIcon r1 = new OImageAppIcon(r6, null, 0, 6, null);
        r1.setId(ZeusTransformUtils.mapRes(R.id.o_list_item_app_icon, OaidModel.KEY_ID, "o_list_item_app_icon"));
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.n = r1;
        this.l.addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r0 == null) goto L10;
        r0.setVisibility(0);
        return;
    }

    private final void h() {
        boolean r3 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.k, View.class, "com.obric.memorydata.plugin")).getVisibility() != 8) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        if (ZeusTransformUtils.instanceOf(getCustomStartView(), OCheckBoxLayout.class) == true) goto L10;
    L15:
        LinearLayout r1 = this.o;
        r1.setPadding(0, r1.getPaddingTop(), this.o.getPaddingRight(), this.o.getPaddingBottom());
    L17:
        if (this.v.getVisibility() == 0) goto L20;
        r3 = false;
    L20:
        if (r3 == false) goto L22;
        j();
    L22:
        requestLayout();
        return;
    L10:
        if (((View) ZeusTransformUtils.preCheckCast(this.l, View.class, "com.obric.memorydata.plugin")).getVisibility() != 8) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        this.o.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), this.o.getPaddingTop(), this.o.getPaddingRight(), this.o.getPaddingBottom());
        goto L17
    L12:
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    private final void i() {
        boolean r1 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.t, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L41;
        View r2 = getCustomEndView();
        ViewGroup.LayoutParams r5 = this.t.getLayoutParams();
        ViewGroup.MarginLayoutParams r7 = null;
        if (ZeusTransformUtils.instanceOf(r5, ConstraintLayout.LayoutParams.class) == false) goto L11;
        ConstraintLayout.LayoutParams r6 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), FrameLayout.LayoutParams.class) == false) goto L18;
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin")).gravity = GravityCompat.END;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, OTextView.class) == true) goto L20;
    L38:
        if (r6 == null) goto L45;
        r6.T = -2;
        return;
    L45:
        return;
    L20:
        if (TextUtils.isEmpty(((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin")).getText()) == true) goto L38;
        if (r6 == null) goto L24;
        r6.T = this.F;
    L24:
        ViewGroup.LayoutParams r4 = ((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L27;
        r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L27:
        if (r7 == null) goto L37;
        int r9 = r7.leftMargin;
        int r10 = r7.topMargin;
        if (((View) ZeusTransformUtils.preCheckCast(this.u, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L33;
        r1 = false;
    L33:
        if (r1 == false) goto L35;
        int r11 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    L36:
        r7.setMargins(r9, r10, r11, r7.bottomMargin);
        goto L37
    L35:
        r11 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6);
    L37:
        ((OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin")).setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r6 = null;
        goto L12
    L41:
        FrameLayout r12 = this.t;
        ViewGroup.LayoutParams r3 = r12.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r13.T = -2;
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r0 = false;
        goto L7
    }

    private final void j() {
        this.v.post(new $$Lambda$OCardListItem$dO6SuHxwRObPEhi0_roSUgsxwg(this));
        requestLayout();
    }

    public static /* synthetic */ void lambda$M214qmr89Z2dZ0b_FSdHMCKP0CM(OCardListItem r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$dO6SuHxwRO-bPEhi0_roSUgsxwg, reason: not valid java name */
    public static /* synthetic */ void m1318lambda$dO6SuHxwRObPEhi0_roSUgsxwg(OCardListItem r0) {
        d(r0);
    }

    public final View a(int r4) {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.o, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.o.getChildAt(r4);
    L5:
        r0 = false;
        goto L6
    }

    public final void a() {
        OStateGradientDrawable r0 = this.h;
        if (r0 == null) goto L7;
        r0.setSolidColors(getContentContainerBgColor());
        return;
    }

    public final void a(int r1, int r2) {
        this.q = r1;
        this.s = r2;
        this.p.setTextColor(r1);
        this.r.setTextColor(this.s);
    }

    public final void a(int r11, int r12, boolean r13) {
        if (r11 != 0) goto L23;
        return;
    L23:
        int r3 = 0;
        a(this, ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r11, (ViewGroup) ZeusTransformUtils.preCheckCast(this.o, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin"), r12, false, 4, null);     // Catch: Exception -> L22
        LinearLayout r10 = this.o;     // Catch: Exception -> L22
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();     // Catch: Exception -> L22
        if (r14 == null) goto L20;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        if (r13 == false) goto L9;
        int r16 = 0;
    L10:
        r15.width = r16;     // Catch: Exception -> L22
        if (r13 == true) goto L13;
        boolean r1 = true;
    L14:
        r15.aa = r1;     // Catch: Exception -> L22
        if (r13 == true) goto L18;
        r3 = 1;
    L18:
        r15.P = r3;     // Catch: Exception -> L22
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L22
        return;
    L13:
        r1 = false;
        goto L14
    L9:
        r16 = -2;
        goto L10
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L22
    }

    public final void a(int r1, boolean r2) {
        this.D = r1;
        this.f13970a.a(r1, r2);
    }

    public final void a(View r1, int r2, boolean r3) {
        if (r1 == null) goto L5;
        this.o.addView(r1, r2);
        return;
    }

    public final void a(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 > 0) goto L6;
        r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 168);
    L6:
        this.F = r5;
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L9;
    L8:
        View r7 = getCustomEndView();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) ZeusTransformUtils.preCheckCast(r7, OTextView.class, "com.obric.memorydata.plugin")).setText(r6);
    L12:
        i();
        return;
    L9:
        setDefaultCustomEndView(3);
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L12;
        goto L12
    }

    public final void a(boolean r2) {
        FrameLayout r0 = this.k;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        h();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final OTextView b(int r4) {
        View r3 = a(r4);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (OTextView) ZeusTransformUtils.preCheckCast(((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_text, OaidModel.KEY_ID, "custom_title_text")), OTextView.class, "com.obric.memorydata.plugin");
    }

    public final void b() {
        View r0 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_container, OaidModel.KEY_ID, "custom_title_container"));
        if (r0 == null) goto L7;
        this.o.removeView(r0);
        return;
    }

    public final void b(int r1, int r2) {
        this.x = r1;
        this.y = r2;
    }

    public final void b(int r6, int r7, boolean r8) {
        int r0 = this.G;
        if (r0 != r6) goto L10;
        LinearLayout r5 = this.o;
        ViewGroup.LayoutParams r9 = r5.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r0 != 1) goto L7;
        r10.width = 0;
        r10.aa = false;
        r10.P = 0;
    L8:
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        r10.width = -2;
        r10.aa = true;
        r10.P = 1;
        goto L8
    L10:
        if (r0 < 0) goto L13;
        if (r0 == r6) goto L13;
        b();
    L13:
        this.G = r6;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        this.G = -1;
        b();
        LinearLayout r11 = this.o;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r13.width = -2;
        r13.aa = true;
        r13.P = 1;
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        int r14 = R.layout.o_card_list_item_custom_title_detail;
        String r1 = "o_card_list_item_custom_title_detail";
    L19:
        a(ZeusTransformUtils.mapRes(r14, "layout", r1), r7, r8);
        return;
    L18:
        r14 = R.layout.o_card_list_item_custom_title_icon;
        r1 = "o_card_list_item_custom_title_icon";
        goto L19
    }

    public final void b(boolean r2) {
        FrameLayout r0 = this.l;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        h();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final OTextView c(int r4) {
        View r3 = a(r4);
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == true) goto L5;
        return null;
    L5:
        return (OTextView) ZeusTransformUtils.preCheckCast(((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.custom_title_detail, OaidModel.KEY_ID, "custom_title_detail")), OTextView.class, "com.obric.memorydata.plugin");
    }

    public final void c(boolean r4) {
        CharSequence r0 = getTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        OTextView r3 = this.p;
        if (r2 == true) goto L15;
        if (r4 == true) goto L14;
        r1 = 8;
    L14:
        r3.setVisibility(r1);
        return;
    L15:
        r3.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void d(boolean r4) {
        CharSequence r0 = getSubTitle();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        OTextView r3 = this.r;
        if (r2 == true) goto L15;
        if (r4 == true) goto L14;
        r1 = 8;
    L14:
        r3.setVisibility(r1);
        return;
    L15:
        r3.setVisibility(8);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void e(boolean r2) {
        FrameLayout r0 = this.t;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        i();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void f(boolean r2) {
        ImageView r0 = this.u;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        i();
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void g(boolean r3) {
        View r0 = this.v;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        if (r3 == false) goto L14;
        View r4 = this.v;
        if (this.C == false) goto L11;
        float r2 = this.B;
    L12:
        r4.setTranslationX(r2);
        j();
        return;
    L11:
        r2 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final FrameLayout getCardContainer() {
        return (FrameLayout) ZeusTransformUtils.preCheckCast(this.f, FrameLayout.class, "com.obric.memorydata.plugin");
    }

    public final int getCardPosition() {
        return this.D;
    }

    public final FrameLayout getCardRoot() {
        return this.e;
    }

    public final int getCardType() {
        return this.E;
    }

    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    public final OUICardConstraintLayout getContentContainer() {
        return this.g;
    }

    public final ColorStateList getContentContainerBgColor() {
        return this.H;
    }

    public final View getCustomEndView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.t, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.t.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final View getCustomStartView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.k, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return null;
    L8:
        return this.k.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OCheckBoxLayout.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) ZeusTransformUtils.preCheckCast(r2, OCheckBoxLayout.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final OTextView getEndDetail() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OTextView.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final OCheckMark getEndMark() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OCheckMark.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
        return (OCheckMark) ZeusTransformUtils.preCheckCast(r2, OCheckMark.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if (ZeusTransformUtils.instanceOf(getCustomEndView(), OSwitch.class) == false) goto L6;
        View r2 = getCustomEndView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
        return (OSwitch) ZeusTransformUtils.preCheckCast(r2, OSwitch.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final ImageView getIconView() {
        return this.m;
    }

    public final boolean getShowCardBg() {
        return this.c;
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if (ZeusTransformUtils.instanceOf(getCustomStartView(), OCheckBoxLayout.class) == false) goto L6;
        View r2 = getCustomStartView();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
        return (OCheckBoxLayout) ZeusTransformUtils.preCheckCast(r2, OCheckBoxLayout.class, "com.obric.memorydata.plugin");
    L6:
        return null;
    }

    public final CharSequence getSubTitle() {
        return this.r.getText();
    }

    public final OTextView getSubTitleView() {
        return this.r;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.z;
    }

    public final View getSwipeView() {
        if (this.A.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.A.getChildAt(0);
    }

    public final ImageView getTailIconView() {
        return this.u;
    }

    public final CharSequence getTitle() {
        return this.p.getText();
    }

    public final LinearLayout getTitleContainer() {
        return this.o;
    }

    public final OTextView getTitleView() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r0 = this.h;
        if (r0 == null) goto L6;
        r0.endAnimation();
    L6:
        this.k.addOnLayoutChangeListener(this.w);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        this.F = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 168);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeOnLayoutChangeListener(this.w);
    }

    public final void setAppIcon(int r3) {
        this.m.setVisibility(8);
        g();
        if (r3 == 0) goto L8;
        OImageAppIcon r0 = this.n;
        if (r0 == null) goto L13;
        r0.setImageResource(r3);
    L13:
        if (this.v.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        j();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.n;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    public final void setAppIcon(Drawable r3) {
        this.m.setVisibility(8);
        g();
        if (r3 == null) goto L8;
        OImageAppIcon r0 = this.n;
        if (r0 == null) goto L13;
        r0.setImageDrawable(r3);
    L13:
        if (this.v.getVisibility() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        j();
        return;
    L19:
        return;
    L15:
        r4 = false;
        goto L16
    L8:
        OImageAppIcon r5 = this.n;
        if (r5 == null) goto L13;
        r5.setImageDrawable(null);
        goto L13
    }

    public final void setBgColor(int r1) {
        this.f13970a.a(r1);
    }

    public final void setCardPosition(int r4) {
        a(this, r4, false, 2, null);
    }

    public final void setCardType(int r9) {
        this.E = r9;
        boolean r3 = true;
        if (r9 == 0) goto L10;
        if (r9 != 1) goto L6;
        this.g.setPaddingRelative(0, 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), 0);
        this.g.setMinimumHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 60));
        this.o.setVisibility(0);
        FrameLayout r10 = this.k;
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.width = -2;
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        FrameLayout r11 = this.l;
        ViewGroup.LayoutParams r0 = r11.getLayoutParams();
        r0.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 60);
        r0.height = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 60);
        r11.setLayoutParams(r0);
        FrameLayout r12 = this.l;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r5 = 12;
    L11:
        r12.setPadding(h.a(r4, r5), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5));
    L12:
        f();
        if (this.v.getVisibility() == 0) goto L16;
        r3 = false;
    L16:
        if (r3 == false) goto L19;
        j();
        return;
    L19:
        return;
    L6:
        if (r9 != 2) goto L12;
        this.g.setPaddingRelative(0, 0, 0, 0);
        this.g.setMinimumHeight(0);
        this.o.setVisibility(8);
        FrameLayout r13 = this.k;
        ViewGroup.LayoutParams r6 = r13.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r7.width = -1;
        r13.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        a(true);
        goto L12
    L10:
        this.g.setPaddingRelative(0, 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), 0);
        this.g.setMinimumHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48));
        this.o.setVisibility(0);
        FrameLayout r14 = this.k;
        ViewGroup.LayoutParams r8 = r14.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r15.width = -2;
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        FrameLayout r16 = this.l;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        r17.width = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48);
        r17.height = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48);
        r16.setLayoutParams(r17);
        r12 = this.l;
        r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r5 = 10;
        goto L11
    }

    public final void setContentChecked(boolean r4) {
        if (r4 == false) goto L9;
        this.g.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L11;
        OStateGradientDrawable r5 = this.h;
        if (r5 == null) goto L13;
        r5.setColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed, TypedValues.Custom.S_COLOR, "oui_state_overlay_pressed")));
        return;
    L13:
        return;
    L11:
        return;
    L9:
        this.g.setSelected(false);
    }

    public final void setContentColor(int r2) {
        ColorStateList r3 = ColorStateList.valueOf(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "valueOf(color)");
        setContentColor(r3);
    }

    public final void setContentColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, TypedValues.Custom.S_COLOR);
        setContentContainerBgColor(r2);
    }

    public final void setContentContainerBgColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        if (Intrinsics.areEqual(this.H, r2) == true) goto L9;
        this.H = r2;
        OStateGradientDrawable r1 = this.h;
        if (r1 == null) goto L10;
        r1.setSolidColors(r2);
        return;
    L10:
        return;
    }

    public final void setContentMarkColor(ColorStateList r1) {
        this.j = r1;
        if (r1 != null) goto L6;
        setContentContainerBgColor(this.i);
        return;
    }

    public final void setCustomEndView(int r5) {
        this.t.removeAllViews();
        if (r5 != 0) goto L8;
    L5:
        i();
        return;
    L8:
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.t, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L7
        goto L5
    }

    public final void setCustomEndView(View r4) {
        this.t.removeAllViews();
        if (r4 != null) goto L6;
    L9:
        i();
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4.getParent(), ViewGroup.class) == false) goto L8;
        ViewParent r0 = r4.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin")).removeView(r4);
    L8:
        this.t.addView(r4);
        goto L9
    }

    public final void setCustomStartView(int r5) {
        this.k.removeAllViews();
        if (r5 == 0) goto L6;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(this.k, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L12
    L6:
        if (this.v.getVisibility() != 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L15;
        j();
        return;
    L15:
        return;
    L8:
        r6 = false;
        goto L9
    }

    public final void setCustomStartView(View r2) {
        this.k.removeAllViews();
        if (r2 == null) goto L6;
        this.k.addView(r2);
    L6:
        if (this.v.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        j();
        return;
    L12:
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final void setDefaultCustomEndView(int r3) {
        this.t.removeAllViews();
        if (r3 != 0) goto L5;
        int r4 = R.layout.o_card_list_item_custom_end_checkbox;
        String r1 = "o_card_list_item_custom_end_checkbox";
    L18:
        setCustomEndView(ZeusTransformUtils.mapRes(r4, "layout", r1));
        return;
    L5:
        if (r3 != 1) goto L7;
        r4 = R.layout.o_card_list_item_custom_end_switch;
        r1 = "o_card_list_item_custom_end_switch";
        goto L18
    L7:
        if (r3 != 2) goto L9;
        r4 = R.layout.o_card_list_item_custom_end_mark;
        r1 = "o_card_list_item_custom_end_mark";
        goto L18
    L9:
        if (r3 != 3) goto L11;
        r4 = R.layout.o_card_list_item_custom_end_detail;
        r1 = "o_card_list_item_custom_end_detail";
        goto L18
    L11:
        if (r3 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        r4 = R.layout.o_card_list_item_custom_end_handle;
        r1 = "o_card_list_item_custom_end_handle";
        goto L18
    }

    public final void setDefaultCustomStartView(int r3) {
        this.k.removeAllViews();
        if (r3 != 0) goto L6;
        setCustomStartView(ZeusTransformUtils.mapRes(R.layout.o_card_list_item_custom_start_checkbox, "layout", "o_card_list_item_custom_start_checkbox"));
    L6:
        if (this.v.getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        j();
        return;
    L12:
        return;
    L8:
        r4 = false;
        goto L9
    }

    public final void setDefaultTailIcon(int r4) {
        if (r4 != 0) goto L5;
        Resources r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r1 = R.drawable.o_card_list_item_tail_icon_arrow;
        String r2 = "o_card_list_item_tail_icon_arrow";
    L9:
        setTailIcon(r5.getDrawable(ZeusTransformUtils.mapRes(r1, "drawable", r2)));
        return;
    L5:
        if (r4 != 1) goto L11;
        r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r1 = R.drawable.o_card_list_item_tail_icon_chevron;
        r2 = "o_card_list_item_tail_icon_chevron";
        goto L9
    }

    public final void setEnableSwipe(boolean r2) {
        this.z.setSwipeEnabled(r2);
        FrameLayout r1 = this.A;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r2) {
        this.C = r2;
        if (this.v.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L13;
        View r4 = this.v;
        if (this.C == false) goto L10;
        float r1 = this.B;
    L11:
        r4.setTranslationX(r1);
        return;
    L10:
        r1 = 0.0f;
        goto L11
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        this.g.setEnabled(r4);
        this.k.setEnabled(r4);
        this.l.setEnabled(r4);
        this.m.setEnabled(r4);
        OImageAppIcon r0 = this.n;
        if (r0 == null) goto L6;
        r0.setEnabled(r4);
    L6:
        this.o.setEnabled(r4);
        this.p.setEnabled(r4);
        this.r.setEnabled(r4);
        this.t.setEnabled(r4);
        this.u.setEnabled(r4);
        this.z.setEnabled(r4);
        a((View) ZeusTransformUtils.preCheckCast(this.k, View.class, "com.obric.memorydata.plugin"), r4);
        a((View) ZeusTransformUtils.preCheckCast(this.t, View.class, "com.obric.memorydata.plugin"), r4);
        a((View) ZeusTransformUtils.preCheckCast(this.A, View.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void setEndDetailText(CharSequence r4) {
        a(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
    }

    public final void setIcon(int r4) {
        boolean r1 = false;
        this.m.setVisibility(0);
        OImageAppIcon r0 = this.n;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == 0) goto L8;
        this.m.setImageResource(r4);
    L10:
        if (this.v.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        j();
        return;
    L15:
        return;
    L8:
        this.m.setImageDrawable(null);
        goto L10
    }

    public final void setIcon(Drawable r4) {
        boolean r1 = false;
        this.m.setVisibility(0);
        OImageAppIcon r0 = this.n;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        if (r4 == null) goto L8;
        this.m.setImageDrawable(r4);
    L10:
        if (this.v.getVisibility() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        j();
        return;
    L15:
        return;
    L8:
        this.m.setImageDrawable(null);
        goto L10
    }

    public final void setMark(boolean r2) {
        if (this.I == r2) goto L12;
        this.I = r2;
        if (r2 == false) goto L9;
        ColorStateList r3 = this.j;
        if (r3 == null) goto L13;
    L10:
        setContentContainerBgColor(r3);
        return;
    L13:
        return;
    L9:
        r3 = this.i;
        goto L10
    }

    public final void setOnContentClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.g.setOnClickListener(r4);
        e();
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        this.g.setOnLongClickListener(r4);
        e();
    }

    public final void setShowCardBg(boolean r1) {
        this.c = r1;
        d();
        this.f13970a.a(this.c);
    }

    public final void setSubTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.r.setText(r4);
    }

    public final void setSwipeView(int r4) {
        this.A.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.A, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setSwipeView(View r2) {
        this.A.removeAllViews();
        if (r2 == null) goto L6;
        this.A.addView(r2);
        return;
    }

    public final void setTailIcon(int r1) {
        ImageView r0 = this.u;
        if (r1 == 0) goto L5;
        r0.setImageResource(r1);
        return;
    L5:
        r0.setImageDrawable(null);
    }

    public final void setTailIcon(Drawable r1) {
        if (r1 == null) goto L5;
        this.u.setImageDrawable(r1);
        return;
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.p.setText(r4);
    }
}
