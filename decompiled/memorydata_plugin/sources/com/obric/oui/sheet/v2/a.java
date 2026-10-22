package com.obric.oui.sheet.v2;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0083\u0001H\u0016J\u0013\u0010\u0086\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u0003H\u0016J\u001c\u0010\u0088\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0089\u0001\u001a\u00020V2\u0007\u0010\u008a\u0001\u001a\u00020VH\u0016J\t\u0010\u008b\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010$H\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020\tH\u0016J\u000b\u0010\u0090\u0001\u001a\u0004\u0018\u00010$H\u0016J\u000b\u0010\u0091\u0001\u001a\u0004\u0018\u00010$H\u0016J\u000b\u0010\u0092\u0001\u001a\u0004\u0018\u00010$H\u0016J&\u0010\u0093\u0001\u001a\u0003H\u0094\u0001\"\t\b\u0000\u0010\u0094\u0001*\u00020$2\t\b\u0001\u0010\u0095\u0001\u001a\u00020\tH&¢\u0006\u0003\u0010\u0096\u0001J\n\u0010\u0097\u0001\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0003H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0003H\u0016J%\u0010\u009a\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u009b\u0001\u001a\u00020V2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u0003H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0003H&J\n\u0010\u009f\u0001\u001a\u00030\u0083\u0001H&J\n\u0010 \u0001\u001a\u00030\u0083\u0001H&J\n\u0010¡\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¢\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010£\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¤\u0001\u001a\u00030\u0083\u0001H&J\n\u0010¥\u0001\u001a\u00030\u0083\u0001H\u0016J\u0015\u0010¦\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020VH\u0016J\n\u0010§\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010¨\u0001\u001a\u00030\u0083\u0001H\u0016J\u0015\u0010©\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010«\u0001\u001a\u00030\u0083\u00012\u0007\u0010¬\u0001\u001a\u00020\u0003H\u0016J\\\u0010\u00ad\u0001\u001a\u00030\u0083\u00012\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0002\u0010¯\u0001\u001a\u00020\u00032\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0002\u0010³\u0001\u001a\u00020\u00032\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016¢\u0006\u0003\u0010µ\u0001JX\u0010\u00ad\u0001\u001a\u00030\u0083\u00012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010¯\u0001\u001a\u00020\u00032\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\f\b\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010³\u0001\u001a\u00020\u00032\f\b\u0002\u0010´\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u0015\u0010¹\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016JÃ\u0001\u0010º\u0001\u001a\u00030\u0083\u00012\b\u0010»\u0001\u001a\u00030¼\u00012\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010¿\u0001\u001a\u0005\u0018\u00010·\u00012\f\b\u0002\u0010À\u0001\u001a\u0005\u0018\u00010·\u00012\t\b\u0002\u0010Á\u0001\u001a\u00020\u00032\n\u0010Â\u0001\u001a\u0005\u0018\u00010±\u00012\n\u0010Ã\u0001\u001a\u0005\u0018\u00010±\u00012\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010Å\u0001\u001a\u0004\u0018\u00010\t2\f\b\u0002\u0010Æ\u0001\u001a\u0005\u0018\u00010·\u00012\f\b\u0002\u0010Ç\u0001\u001a\u0005\u0018\u00010·\u00012\u000b\b\u0002\u0010È\u0001\u001a\u0004\u0018\u00010\t2\u000b\b\u0002\u0010É\u0001\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010Ê\u0001J\u0015\u0010Ë\u0001\u001a\u00030\u0083\u00012\t\u0010ª\u0001\u001a\u0004\u0018\u00010$H\u0016J\u0013\u0010Ì\u0001\u001a\u00030\u0083\u00012\u0007\u0010Í\u0001\u001a\u00020?H\u0016J\n\u0010Î\u0001\u001a\u00030\u0083\u0001H\u0016J\u0013\u0010Ï\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ð\u0001\u001a\u00020\u0003H\u0016J\u0013\u0010Ñ\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ò\u0001\u001a\u00020\tH\u0016J(\u0010Ó\u0001\u001a\u00030\u0083\u00012\u001c\u0010Ô\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0005\u0012\u00030×\u00010Ö\u00010Õ\u0001H\u0016J\u0013\u0010Ø\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ù\u0001\u001a\u00020qH&J\u0013\u0010Ú\u0001\u001a\u00030\u0083\u00012\u0007\u0010Ù\u0001\u001a\u00020qH\u0016J\n\u0010Û\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010Ü\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010Ý\u0001\u001a\u00030\u0083\u0001H&J\t\u0010Þ\u0001\u001a\u00020\u0003H&J\f\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u0018\u0010\u001a\u001a\u00020\u001bX¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u0018\u0010/\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u0018\u00105\u001a\u000206X¦\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u0018\u0010>\u001a\u00020?X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010D\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0005\"\u0004\bF\u0010\u0007R\u0018\u0010G\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010\u0005\"\u0004\bH\u0010\u0007R\u0018\u0010I\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010\u0005\"\u0004\bK\u0010\u0007R\u0018\u0010L\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010\u0005\"\u0004\bN\u0010\u0007R\u0018\u0010O\u001a\u00020PX¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010U\u001a\u00020VX¦\u000e¢\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u00020VX¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u001a\u0010^\u001a\u0004\u0018\u00010_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u00020eX¦\u000e¢\u0006\f\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0018\u0010j\u001a\u00020kX¦\u000e¢\u0006\f\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0012\u0010p\u001a\u00020qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0018\u0010t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\bu\u0010\u0005\"\u0004\bv\u0010\u0007R\u001a\u0010w\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0018\u0010|\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b}\u0010\u000b\"\u0004\b~\u0010\rR\u001a\u0010\u007f\u001a\u00020\tX¦\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u000b\"\u0005\b\u0081\u0001\u0010\r¨\u0006á\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetBase;", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "autoAddBodyPaddingTopWhenOverlay", "", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "dimView", "Landroid/view/View;", "getDimView", "()Landroid/view/View;", "setDimView", "(Landroid/view/View;)V", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "Landroid/content/Context;", "getSheetContext", "()Landroid/content/Context;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "applyMaterial", "", "fromWindow", "calculateBodyMaxHeight", "enableIgnoreInsetBottom", "ignore", "fling", "xVelocity", "yVelocity", "getContentLayoutResId", "getEndActionButton", "getHeaderTitleBar", "Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "getMaxBodyHeight", "getNegativeButton", "getPositiveButton", "getStartActionButton", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, OaidModel.KEY_ID, "(I)Landroid/view/View;", "initBgColor", "isDarkTheme", "isRootContainerMaxHeight", "move", "dx", "dy", CommonConsts.APM_INNER_EVENT_COST_START, "needDimAnim", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onPostShow", "onShowAnimEnd", "onShowAnimStart", "performEnterAnimation", "performExitAnimation", "registerConfigurationCallbackIfNeeded", "removeOnApplyWindowInsetsListener", "setBodyView", "child", "setCanceledOnTouchOutside", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "setFooterButton", "negativeBtnTextResId", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "setFooterView", "setHeader", "style", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "titleResId", "subTitleResId", "title", "subTitle", "showHandleView", "startActionEvent", "endActionEvent", "startActionDesResId", "endActionDesResId", "startActionDes", "endActionDesRes", "startActionIconResId", "endActionIconResId", "(Lcom/obric/oui/sheet/v2/OSheet$Header;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setHeaderView", "setHeightMode", "height", "setOnApplyWindowInsetsListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setSheetBgColor", TypedValues.Custom.S_COLOR, "setSheetBgMaterials", "materials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "setupDimView", "context", "setupView", "unregisterConfigurationCallbackIfNeeded", "updateFullWindowSize", "updateMaterial", "useWindowDim", "windowForAnim", "Landroid/view/Window;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a extends d {

    /* JADX INFO: renamed from: com.obric.oui.sheet.v2.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class C0775a {
        public static int a(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            if (r3.c() == false) goto L7;
            int r4 = R.layout.o_sheet_container_overlay;
            String r1 = "o_sheet_container_overlay";
        L6:
            return ZeusTransformUtils.mapRes(r4, "layout", r1);
        L7:
            r4 = R.layout.o_sheet_container;
            r1 = "o_sheet_container";
            goto L6
        }

        public static void a(a r17, float r18) {
            final a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "this");
            com.obric.common.oea.foundation.animation.d.d r2 = r0.getRunningAnim();
            if (r2 == null) goto L6;
            com.obric.common.oea.foundation.animation.d.d.a(r2, false, 1, null);
        L6:
            r0.setRunningAnim(com.obric.common.oea.foundation.animation.builder.a.a(SheetAnimStyle.a(SheetAnimStyle.f14486a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.memorydata.plugin"), r0.i(), r0.getDimView(), r0.k(), r0.j(), r18, new $$Lambda$a$a$BJat3QW3bCBZSnIharfELGJygA(r0), null, 64, null).a((Function2) ZeusTransformUtils.preCheckCast(new OSheetBase$performExitAnimation$2(r0), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null));
            r0.n();
        }

        public static void a(a r15, float r16, float r17) {
            final a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "this");
            if (SheetAnimStyle.a(SheetAnimStyle.f14486a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.memorydata.plugin"), r17, 0.0f, 4, null) == false) goto L5;
            r0.a(r17);
            return;
        L5:
            com.obric.common.oea.foundation.animation.d.d r3 = r0.getRunningAnim();
            if (r3 == null) goto L9;
            com.obric.common.oea.foundation.animation.d.d.a(r3, false, 1, null);
        L9:
            r0.setRunningAnim(com.obric.common.oea.foundation.animation.builder.a.a(SheetAnimStyle.a(SheetAnimStyle.f14486a, (View) ZeusTransformUtils.preCheckCast(r0.getRootContainer(), View.class, "com.obric.memorydata.plugin"), r0.i(), r0.getDimView(), r0.k(), r0.j(), b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getSheetContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r17, null, 64, null).a((Function2) ZeusTransformUtils.preCheckCast(new OSheetBase$fling$1(r0), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null));
        }

        public static void a(a r2, float r3, float r4, boolean r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "this");
            if (r5 == false) goto L9;
            r6.setRootTransMoveStartX(r6.getRootContainer().getTranslationX());
            r6.setRootTransMoveStartY(r6.getRootContainer().getTranslationY());
            com.obric.common.oea.foundation.animation.d.d r7 = r6.getRunningAnim();
            if (r7 == null) goto L11;
            r7.a(true);
            return;
        L11:
            return;
        L9:
            r6.getRootContainer().setTranslationX(r6.getRootTransMoveStartX() + r3);
            r6.getRootContainer().setTranslationY(r6.getRootTransMoveStartY() + r4);
        }

        public static /* synthetic */ void a(a r2, float r3, int r4, Object r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L10;
            if ((r4 & 1) == 0) goto L7;
            r3 = 0.0f;
        L7:
            r6.a(r3);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: performExitAnimation");
        }

        public static void a(a r4, int r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "this");
            if (r6.getBgColor() == r5) goto L17;
            boolean r0 = r6.D();
            r6.setBgColor(r5);
            boolean r2 = r6.D();
            if (r6.getEnableMaterial() == true) goto L7;
            r6.getRootContainer().setBackgroundColor(r5);
        L8:
            if (r0 == r2) goto L18;
            View r7 = r6.getScaffoldController().b().getChildAt(0);
            if (ZeusTransformUtils.instanceOf(r7, OSheetTitleBar.class) == false) goto L19;
            OSheetTitleBar r8 = (OSheetTitleBar) ZeusTransformUtils.preCheckCast(r7, OSheetTitleBar.class, "com.obric.memorydata.plugin");
            if (r2 == false) goto L14;
            int r9 = 2;
        L15:
            r8.a(r9);
            return;
        L14:
            r9 = 1;
            goto L15
        L19:
            return;
        L18:
            return;
        L7:
            r6.g();
            goto L8
        }

        public static void a(a r11, Context r12) {
            a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.memorydata.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "this");
            Intrinsics.checkNotNullParameter(r3, "context");
            r13.setRootContainer((RadiusLayout) ZeusTransformUtils.preCheckCast(r13.a(ZeusTransformUtils.mapRes(R.id.root_constraint, OaidModel.KEY_ID, "root_constraint")), RadiusLayout.class, "com.obric.memorydata.plugin"));
            r13.setupDimView(r3);
            r13.setHeaderContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.a(ZeusTransformUtils.mapRes(R.id.header_container, OaidModel.KEY_ID, "header_container")), FrameLayout.class, "com.obric.memorydata.plugin"));
            r13.setBodyContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.a(ZeusTransformUtils.mapRes(R.id.body_container, OaidModel.KEY_ID, "body_container")), FrameLayout.class, "com.obric.memorydata.plugin"));
            r13.setFooterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r13.a(ZeusTransformUtils.mapRes(R.id.footer_container, OaidModel.KEY_ID, "footer_container")), FrameLayout.class, "com.obric.memorydata.plugin"));
            r13.setScaffoldContainer((ViewGroup) ZeusTransformUtils.preCheckCast(r13.a(ZeusTransformUtils.mapRes(R.id.scaffold_container, OaidModel.KEY_ID, "scaffold_container")), ViewGroup.class, "com.obric.memorydata.plugin"));
            r13.r();
            r13.setScaffoldController(new c(r3, r13, r13.getRootContainer(), r13.getHeaderContainer(), r13.getBodyContainer(), r13.getFooterContainer(), r13.getScaffoldContainer(), r13.getDimView()));
            r13.getScaffoldController().a(r13.getHeightStyle());
            r13.getScaffoldController().a(r13.getIgnoreInsetBottom());
            r13.getScaffoldController().a(r13.getFullWindowSize());
            r13.C();
        }

        public static void a(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.getScaffoldController().a(r3);
        }

        public static void a(a r19, OSheet.Header r20, Integer r21, Integer r22, String r23, String r24, boolean r25, View.OnClickListener r26, View.OnClickListener r27, Integer r28, Integer r29, String r30, String r31, Integer r32, Integer r33) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r19, a.class, "com.obric.memorydata.plugin");
            View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r26, View.OnClickListener.class, "com.obric.memorydata.plugin");
            View.OnClickListener r11 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r27, View.OnClickListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "this");
            Intrinsics.checkNotNullParameter(r20, "style");
            r0.getScaffoldController().a(r20, r21, r22, r23, r24, r25, r10, r11, r28, r29, r30, r31, r32, r33, (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void a(a r15, OSheet.Header r16, Integer r17, Integer r18, String r19, String r20, boolean r21, View.OnClickListener r22, View.OnClickListener r23, Integer r24, Integer r25, String r26, String r27, Integer r28, Integer r29, int r30, Object r31) {
            a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r15, a.class, "com.obric.memorydata.plugin");
            View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r22, View.OnClickListener.class, "com.obric.memorydata.plugin");
            View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r23, View.OnClickListener.class, "com.obric.memorydata.plugin");
            if (r31 != null) goto L51;
            Integer r5 = null;
            if ((r30 & 2) == 0) goto L7;
            Integer r4 = null;
        L9:
            if ((r30 & 4) == 0) goto L11;
            Integer r6 = null;
        L13:
            if ((r30 & 8) == 0) goto L15;
            String r7 = null;
        L17:
            if ((r30 & 16) == 0) goto L19;
            String r8 = null;
        L21:
            if ((r30 & 32) == 0) goto L23;
            boolean r9 = false;
        L25:
            if ((r30 & 256) == 0) goto L27;
            Integer r10 = null;
        L29:
            if ((r30 & 512) == 0) goto L31;
            Integer r11 = null;
        L33:
            if ((r30 & 1024) == 0) goto L35;
            String r12 = null;
        L37:
            if ((r30 & 2048) == 0) goto L39;
            String r13 = null;
        L41:
            if ((r30 & 4096) == 0) goto L43;
            Integer r14 = null;
        L45:
            if ((r30 & 8192) != 0) goto L48;
            r5 = r29;
        L48:
            r1.a(r16, r4, r6, r7, r8, r9, r3, r2, r10, r11, r12, r13, r14, r5);
            return;
        L43:
            r14 = r28;
            goto L45
        L39:
            r13 = r27;
            goto L41
        L35:
            r12 = r26;
            goto L37
        L31:
            r11 = r25;
            goto L33
        L27:
            r10 = r24;
            goto L29
        L23:
            r9 = r21;
            goto L25
        L19:
            r8 = r20;
            goto L21
        L15:
            r7 = r19;
            goto L17
        L11:
            r6 = r18;
            goto L13
        L7:
            r4 = r17;
            goto L9
        L51:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeader");
        }

        public static void a(a r2, OSheet.HeightMode r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            Intrinsics.checkNotNullParameter(r3, "height");
            r4.setHeightStyle(r3);
            r4.getScaffoldController().a(r3);
            r4.getScaffoldController().h();
        }

        public static void a(a r9, Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
            a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.memorydata.plugin");
            View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "this");
            r16.getScaffoldController().a(r10, r11, r5, r13, r14, r8);
        }

        public static void a(a r2, Function1<? super Boolean, com.obric.oui.material.c[]> r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Function1<? super Boolean, com.obric.oui.material.c[]> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            Intrinsics.checkNotNullParameter(r5, "materials");
            r4.getScaffoldController().a(r5);
            if (r4.getEnableMaterial() == false) goto L6;
            r4.g();
            return;
        }

        public static void a(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setIgnoreInsetBottom(r3);
            r4.getScaffoldController().a(r3);
        }

        public static void b(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setFullWindowSize(com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
            if (r4.getUserWindowWidth() <= 0) goto L8;
            if (r4.getUserWindowWidth() >= r4.getFullWindowSize().getWidth()) goto L8;
            r4.setFullWindowSize(new Size(r4.getUserWindowWidth(), r4.getFullWindowSize().getHeight()));
        L8:
            if (r4.getUserWindowHeight() > 0) goto L10;
            return;
        L10:
            if (r4.getUserWindowHeight() >= r4.getFullWindowSize().getHeight()) goto L14;
            r4.setFullWindowSize(new Size(r4.getFullWindowSize().getWidth(), r4.getUserWindowHeight()));
            return;
        }

        public static void b(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.getScaffoldController().b(r3);
            if (r3 == null) goto L5;
            r4.setBodyContentPaddingTop(r3.getPaddingTop());
            int r5 = r3.getPaddingBottom();
        L6:
            r4.setBodyContentPaddingBottom(r5);
            return;
        L5:
            r5 = 0;
            r4.setBodyContentPaddingTop(0);
            goto L6
        }

        public static void b(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            if (r4.getAutoAddBodyPaddingTopWhenOverlay() == r3) goto L8;
            r4.setAutoAddBodyPaddingTopWhenOverlay(r3);
            if (r4.getShowing() == false) goto L9;
            r4.y();
            return;
        L9:
            return;
        }

        public static OSheetTitleBar c(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            return r3.getScaffoldController().e();
        }

        public static void c(a r2, View r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.getScaffoldController().c(r3);
        }

        public static void c(a r2, boolean r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            r4.setMCancelable(r3);
        }

        public static int d(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            return r3.getScaffoldController().l();
        }

        public static void d(a r9, boolean r10) {
            a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "this");
            if (r11.getEnableMaterial() == false) goto L9;
            com.obric.oui.material.c[] r3 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r11.getScaffoldController().c().invoke(Boolean.valueOf(!r11.D())), com.obric.oui.material.c[].class, "com.obric.memorydata.plugin");
            r11.getRootContainer().setBackgroundColor(0);
            RadiusLayout r12 = r11.getRootContainer();
            if (r10 == false) goto L7;
            l.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), r3, false, null, 6, null);
            return;
        L7:
            l.a((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), r3, false, 0, null, 14, null);
            return;
        }

        public static boolean e(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            return r3.getScaffoldController().m();
        }

        public static View f(a r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "this");
            View r0 = r5.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_start_action, OaidModel.KEY_ID, "btn_start_action"));
            if (r0 == null) goto L5;
            return r0;
        L5:
            return r5.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back"));
        }

        public static View g(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            return r4.getHeaderContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_end_action, OaidModel.KEY_ID, "btn_end_action"));
        }

        public static View h(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            return r4.getFooterContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_negative, OaidModel.KEY_ID, "btn_negative"));
        }

        public static View i(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            return r4.getFooterContainer().findViewById(ZeusTransformUtils.mapRes(R.id.btn_positive, OaidModel.KEY_ID, "btn_positive"));
        }

        public static void j(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            r3.getScaffoldController().k();
        }

        public static void k(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            r3.getScaffoldController().i();
        }

        public static void l(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            r3.getScaffoldController().j();
        }

        public static /* synthetic */ void lambda$1LaADmbk7p1KgnCKKM5Jrpch_ZU(a r0) {
            s(r0);
        }

        /* JADX INFO: renamed from: lambda$BJat3QW3bCBZSnIharfELGJy-gA, reason: not valid java name */
        public static /* synthetic */ void m1362lambda$BJat3QW3bCBZSnIharfELGJygA(a r0) {
            t(r0);
        }

        public static void m(a r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "this");
            r8.v();
            int r2 = 0;
            View r0 = r8.getBodyContainer().getChildAt(0);
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == true) goto L6;
            r0 = null;
        L6:
            ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
            boolean r4 = true;
            if (ZeusTransformUtils.instanceOf(r8.getScaffoldContainer(), LinearLayout.class) == false) goto L18;
            r8.getBodyContainer().setPadding(0, 0, 0, 0);
            if (r1 == null) goto L12;
            r1.setClipToPadding(true);
        L12:
            if (r1 == null) goto L15;
            r1.setPadding(r1.getPaddingLeft(), r8.getBodyContentPaddingTop(), r1.getPaddingRight(), r8.getBodyContentPaddingBottom());
        L15:
            if (r1 == null) goto L43;
        L17:
            r1.requestLayout();
            return;
        L43:
            return;
        L18:
            FrameLayout r3 = r8.getBodyContainer();
            if (((View) ZeusTransformUtils.preCheckCast(r8.getFooterContainer(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L21;
            boolean r5 = true;
        L22:
            if (r5 == false) goto L24;
            int r6 = r8.getFooterContainer().getMeasuredHeight();
        L25:
            r3.setPadding(0, 0, 0, r6);
            if (r1 == null) goto L29;
            r1.setClipToPadding(false);
        L29:
            if (r1 != null) goto L32;
        L40:
            if (r1 != null) goto L17;
            return;
        L32:
            if (r8.getAutoAddBodyPaddingTopWhenOverlay() == true) goto L34;
        L39:
            r1.setPadding(r1.getPaddingLeft(), r8.getBodyContentPaddingTop() + r2, r1.getPaddingRight(), r8.getBodyContentPaddingBottom());
            goto L40
        L34:
            if (((View) ZeusTransformUtils.preCheckCast(r8.getHeaderContainer(), View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L37;
            r4 = false;
        L37:
            if (r4 == false) goto L39;
            r2 = r8.getHeaderContainer().getMeasuredHeight();
            goto L39
        L24:
            r6 = 0;
            goto L25
        L21:
            r5 = false;
            goto L22
        }

        public static void n(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            if (r4.getConfigurationCallbackRegistered() == false) goto L5;
            return;
        L5:
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).registerComponentCallbacks(r4.getConfigurationCallback());
            r4.setConfigurationCallbackRegistered(true);
        }

        public static void o(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            if (r4.getConfigurationCallbackRegistered() == true) goto L5;
            return;
        L5:
            ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getSheetContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).unregisterComponentCallbacks(r4.getConfigurationCallback());
            r4.setConfigurationCallbackRegistered(false);
        }

        public static void p(a r6) {
            final a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "this");
            com.obric.common.oea.foundation.animation.d.d r0 = r7.getRunningAnim();
            if (r0 == null) goto L7;
            com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
        L7:
            if (r7.getEnableEnterAnim() == true) goto L10;
            r7.v();
            r7.getRootContainer().setAlpha(1.0f);
            r7.getRootContainer().setTranslationY(0.0f);
            SheetAnimStyle.f14486a.a((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.id.o_dialog_anim_in, OaidModel.KEY_ID, "o_dialog_anim_in"));
            r7.setRunningAnim(null);
            r7.l();
            r7.m();
            return;
        L10:
            r7.getRootContainer().setAlpha(0.0f);
            r7.getRootContainer().post(new $$Lambda$a$a$1LaADmbk7p1KgnCKKM5Jrpch_ZU(r7));
        }

        public static void q(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "this");
            if (ZeusTransformUtils.instanceOf(r4.getRootContainer().getBackground(), ColorDrawable.class) == false) goto L7;
            Drawable r0 = r4.getRootContainer().getBackground();
            Objects.requireNonNull(r0, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
            int r1 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r0, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
        L5:
            r4.setBgColor(r1);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r4.getRootContainer().getBackground(), GradientDrawable.class) == false) goto L13;
            Drawable r2 = r4.getRootContainer().getBackground();
            Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ColorStateList r5 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r2, GradientDrawable.class, "com.obric.memorydata.plugin")).getColor();
            if (r5 != null) goto L11;
            r1 = -1;
            goto L5
        L11:
            r1 = r5.getDefaultColor();
            goto L5
        }

        public static boolean r(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this");
            if (r3.getBgColor() != 0) goto L7;
            return i.a((View) ZeusTransformUtils.preCheckCast(r3.getRootContainer(), View.class, "com.obric.memorydata.plugin"));
        L7:
            return com.obric.oui.color.d.a(r3.getBgColor());
        }

        private static void s(a r12) {
            final a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "this$0");
            r13.setRunningAnim(com.obric.common.oea.foundation.animation.builder.a.a(SheetAnimStyle.a(SheetAnimStyle.f14486a, (View) ZeusTransformUtils.preCheckCast(r13.getRootContainer(), View.class, "com.obric.memorydata.plugin"), r13.i(), r13.getDimView(), r13.k(), r13.j(), b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getSheetContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), null, 32, null).a((Function2) ZeusTransformUtils.preCheckCast(new OSheetBase$performEnterAnimation$1$animBuilder$1(r13), Function2.class, "com.obric.memorydata.plugin")).b(), null, null, 3, null));
            r13.l();
        }

        private static void t(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            com.obric.common.oea.foundation.animation.d.d r0 = r3.getRunningAnim();
            if (r0 == null) goto L6;
            r0.a(true);
        L6:
            r3.getRootContainer().setAlpha(0.0f);
        }
    }

    void C();

    boolean D();

    <T extends View> T a(int r1);

    void a(float r1);

    void a(OSheet.Header r1, Integer r2, Integer r3, String r4, String r5, boolean r6, View.OnClickListener r7, View.OnClickListener r8, Integer r9, Integer r10, String r11, String r12, Integer r13, Integer r14);

    boolean c();

    void g();

    boolean getAutoAddBodyPaddingTopWhenOverlay();

    int getBgColor();

    FrameLayout getBodyContainer();

    int getBodyContentPaddingBottom();

    int getBodyContentPaddingTop();

    ComponentCallbacks getConfigurationCallback();

    boolean getConfigurationCallbackRegistered();

    View getDimView();

    boolean getEnableEnterAnim();

    boolean getEnableMaterial();

    FrameLayout getFooterContainer();

    Size getFullWindowSize();

    FrameLayout getHeaderContainer();

    OSheet.HeightMode getHeightStyle();

    boolean getIgnoreInsetBottom();

    RadiusLayout getRootContainer();

    float getRootTransMoveStartX();

    float getRootTransMoveStartY();

    com.obric.common.oea.foundation.animation.d.d getRunningAnim();

    ViewGroup getScaffoldContainer();

    c getScaffoldController();

    Context getSheetContext();

    boolean getShowing();

    int getUserWindowHeight();

    int getUserWindowWidth();

    Window i();

    boolean j();

    boolean k();

    void l();

    void m();

    void n();

    void o();

    void p();

    void r();

    void setAutoAddBodyPaddingTopWhenOverlay(boolean r1);

    void setBgColor(int r1);

    void setBodyContainer(FrameLayout r1);

    void setBodyContentPaddingBottom(int r1);

    void setBodyContentPaddingTop(int r1);

    void setConfigurationCallbackRegistered(boolean r1);

    void setFooterContainer(FrameLayout r1);

    void setFullWindowSize(Size r1);

    void setHeaderContainer(FrameLayout r1);

    void setHeightStyle(OSheet.HeightMode r1);

    void setIgnoreInsetBottom(boolean r1);

    void setMCancelable(boolean r1);

    void setRootContainer(RadiusLayout r1);

    void setRootTransMoveStartX(float r1);

    void setRootTransMoveStartY(float r1);

    void setRunningAnim(com.obric.common.oea.foundation.animation.d.d r1);

    void setScaffoldContainer(ViewGroup r1);

    void setScaffoldController(c r1);

    void setupDimView(Context r1);

    void v();

    void y();
}
