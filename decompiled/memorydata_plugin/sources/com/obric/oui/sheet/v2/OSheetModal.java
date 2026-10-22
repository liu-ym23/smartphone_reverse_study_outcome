package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\bÍ\u0001Î\u0001Ï\u0001Ð\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\n\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\u0007\u0010 \u0001\u001a\u00020\nJ\b\u0010¡\u0001\u001a\u00030\u009f\u0001J\u0017\u0010¢\u0001\u001a\u00030\u009f\u00012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J$\u0010¥\u0001\u001a\u0003H¦\u0001\"\t\b\u0000\u0010¦\u0001*\u0002002\u0007\u0010§\u0001\u001a\u00020\bH\u0016¢\u0006\u0003\u0010¨\u0001J\n\u0010©\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010ª\u0001\u001a\u00020\nH\u0016J\n\u0010«\u0001\u001a\u00030\u009f\u0001H\u0014J\u0007\u0010¬\u0001\u001a\u00020\nJ\n\u0010\u00ad\u0001\u001a\u00030\u009f\u0001H\u0014J\n\u0010®\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010°\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010±\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010²\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010³\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u009f\u0001H\u0002J\u0011\u0010µ\u0001\u001a\u00030\u009f\u00012\u0007\u0010¶\u0001\u001a\u00020\nJ\u0011\u0010·\u0001\u001a\u00030\u009f\u00012\u0007\u0010¸\u0001\u001a\u00020\nJ\u0013\u0010¹\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010#J\u0013\u0010»\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010.J\u0013\u0010¼\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u000109J\u0014\u0010½\u0001\u001a\u00030\u009f\u00012\n\u0010º\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0013\u0010¾\u0001\u001a\u00030\u009f\u00012\u0007\u0010¿\u0001\u001a\u00020\nH\u0016J\u0011\u0010À\u0001\u001a\u00030\u009f\u00012\u0007\u0010Á\u0001\u001a\u00020\nJ\u0011\u0010Â\u0001\u001a\u00030\u009f\u00012\u0007\u0010Ã\u0001\u001a\u00020\nJ\u0019\u0010Ä\u0001\u001a\u00030\u009f\u00012\t\u0010Å\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u0096\u0001J\u0012\u0010Æ\u0001\u001a\u00030\u009f\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010Ç\u0001\u001a\u00030\u009f\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010È\u0001\u001a\u00030\u009f\u0001J\u0013\u0010È\u0001\u001a\u00030\u009f\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u007fJ\n\u0010É\u0001\u001a\u00030\u009f\u0001H\u0016J\t\u0010Ê\u0001\u001a\u00020\nH\u0016J\f\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0016R\u001a\u0010\r\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u001a\u0010=\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\u001a\u0010@\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010\u0011R\u001a\u0010C\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001a\u0010F\u001a\u00020GX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R\u001a\u0010X\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u001a\u0010Z\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R\u001a\u0010]\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0012\u0010d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0012\u0010e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0010\u0010f\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u00020jX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020pX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001e\u0010~\u001a\u00020\u007fX\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0012\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008f\u0001\u001a\u00020\nX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u000f\"\u0005\b\u0091\u0001\u0010\u0011R$\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0015\n\u0003\u0010\u0097\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0098\u0001\u001a\u00020\bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0014\"\u0005\b\u009a\u0001\u0010\u0016R\u001d\u0010\u009b\u0001\u001a\u00020\bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0014\"\u0005\b\u009d\u0001\u0010\u0016¨\u0006Ñ\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "contentOverlay", "", "userEnableMaterial", "(Landroid/content/Context;Landroid/util/AttributeSet;IZZ)V", "autoAddBodyPaddingTopWhenOverlay", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "cancelListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "dimView", "getDimView", "setDimView", "dismissAnimListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", "myWindowCallback", "Landroid/view/Window$Callback;", "originalNavigationBarAppearance", "Ljava/lang/Integer;", "originalStatusBarAppearance", "originalSystemUiVisibility", "originalWindowCallback", "passThroughTouchOutside", "removeOnDismiss", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "getSheetContext", "()Landroid/content/Context;", "showAnimListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "applySystemInsetsAppearance", "", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "dismiss", "ensureAttachedToParent", "parent", "findDecorViewParent", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, OaidModel.KEY_ID, "(I)Landroid/view/View;", "interceptBackPressed", "needDimAnim", "onAttachedToWindow", "onBackPressed", "onDetachedFromWindow", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onShowAnimEnd", "onShowAnimStart", "restoreSystemInsetsAppearance", "restoreWindowCallback", "setCancelable", "cancelable", "setClearDimFlag", "dim", "setOnCancelListener", "listener", "setOnConfigurationListener", "setOnDismissAnimListener", "setOnShowAnimListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setPassThroughTouchOutside", "passThrough", "setRemoveOnDismiss", "remove", "setSystemInsetsAppearanceLight", "appearanceLight", "setupDimView", "setupView", "show", "updateMaterial", "useWindowDim", "windowForAnim", "Landroid/view/Window;", "OnCancelListener", "OnConfigurationListener", "OnDismissAnimListener", "OnShowAnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetModal extends FrameLayout implements com.obric.oui.sheet.v2.a {
    private b A;
    private a B;
    private Integer C;
    private Integer D;
    private Integer E;
    private Window.Callback F;
    private boolean G;
    private ComponentCallbacks H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f14479J;
    private boolean K;
    private float L;
    private float M;
    private int N;
    private Window.Callback O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f14480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f14481b;
    public View c;
    public RadiusLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public FrameLayout g;
    public com.obric.oui.sheet.v2.c h;
    private boolean i;
    private boolean j;
    private boolean k;
    private OSheet.HeightMode l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private Size r;
    private com.obric.common.oea.foundation.animation.d.d s;
    private boolean t;
    private boolean u;
    private Boolean v;
    private boolean w;
    private boolean x;
    private d y;
    private c z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "", "onCancel", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "", "onConfigurationChanged", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "configuration", "Landroid/content/res/Configuration;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(OSheetModal r1, Configuration r2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "", "onDismissAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onDismissAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(OSheetModal r1);

        void b(OSheetModal r1);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "", "onShowAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onShowAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a(OSheetModal r1);

        void b(OSheetModal r1);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/sheet/v2/OSheetModal$configurationCallback$1", "Landroid/content/ComponentCallbacks;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheetModal f14482a;

        e(OSheetModal r1) {
            this.f14482a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r3) {
            Intrinsics.checkNotNullParameter(r3, "newConfig");
            this.f14482a.r();
            this.f14482a.getScaffoldController().c(this.f14482a.getFullWindowSize());
            b r0 = OSheetModal.a(this.f14482a);
            if (r0 == null) goto L7;
            r0.a(this.f14482a, r3);
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public OSheetModal(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, false, false, 30, null);
    }

    public OSheetModal(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, false, false, 28, null);
    }

    public OSheetModal(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, false, false, 24, null);
    }

    public OSheetModal(Context r3, AttributeSet r4, int r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r5);
        boolean r10 = true;
        this.j = true;
        this.k = true;
        this.l = OSheet.HeightMode.WRAP_HEIGHT;
        this.m = r6;
        this.o = true;
        this.r = new Size(0, 0);
        this.w = true;
        this.H = (ComponentCallbacks) ZeusTransformUtils.preCheckCast(new e(this), ComponentCallbacks.class, "com.obric.memorydata.plugin");
        this.K = true;
        this.N = -1;
        if (r7 == true) goto L5;
    L11:
        setVisibility(8);
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), getContentLayoutResId(), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "from(context)\n          …youtResId(), this, false)");
        setContentView(r11);
        View r12 = getContentView();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -2);
        r13.gravity = 80;
        Unit r14 = Unit.INSTANCE;
        addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        setupView(r8);
        if (ZeusTransformUtils.instanceOf(r8, LifecycleOwner.class) == false) goto L14;
        LifecycleOwner r15 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(r8, LifecycleOwner.class, "com.obric.memorydata.plugin");
    L15:
        if (r15 == null) goto L22;
        Lifecycle r16 = r15.getLifecycle();
        if (r16 == null) goto L23;
        r16.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r15 = null;
        goto L15
    L5:
        if (l.a(r8) == true) goto L7;
    L9:
        r10 = false;
    L10:
        setEnableMaterial(r10);
        goto L11
    L7:
        if (OMaterialHelper.d() == false) goto L9;
        goto L9
    }

    public /* synthetic */ OSheetModal(Context r4, AttributeSet r5, int r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        boolean r0 = false;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L16;
        r8 = true;
    L16:
        this(r11, r13, r1, r0, r8);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    public static final /* synthetic */ b a(OSheetModal r0) {
        return r0.A;
    }

    public static final /* synthetic */ void b(OSheetModal r0) {
        r0.d();
    }

    private final void d() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f14878a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").getCallback() == this.O) goto L8;
    L10:
        this.F = null;
        this.O = null;
        return;
    L8:
        if (this.F == null) goto L10;
        ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").setCallback(this.F);
        goto L10
    }

    private final void e() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L5;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        Window r2 = null;
    L9:
        if (r2 != null) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 30) goto L29;
        Integer r3 = this.C;
        if (r3 == null) goto L20;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
        WindowInsetsController r5 = r2.getInsetsController();
        if (r5 == null) goto L20;
        r5.setSystemBarsAppearance(r4, 8);
    L20:
        Integer r6 = this.D;
        if (r6 == null) goto L27;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
        WindowInsetsController r8 = r2.getInsetsController();
        if (r8 == null) goto L27;
        r8.setSystemBarsAppearance(r7, 16);
    L27:
        this.C = null;
        this.D = null;
        return;
    L29:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        Integer r9 = this.E;
        if (r9 == null) goto L34;
        r2.getDecorView().setSystemUiVisibility(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
    L34:
        this.E = null;
        return;
    L37:
        return;
    L8:
        r2 = ZeusTransformUtils.getWindow(r1, "com.obric.memorydata.plugin");
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.oui.sheet.v2.a
    public void C() {
        com.obric.oui.sheet.v2.a.C0775a.q((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean D() {
        return com.obric.oui.sheet.v2.a.C0775a.r((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public <T extends View> T a(int r1) {
        T r0 = (T) getContentView().findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "contentView.findViewById(id)");
        return r0;
    }

    public void a() {
        com.obric.oui.sheet.v2.a.C0775a.n((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void a(float r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.d
    public void a(float r3, float r4) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    @Override // com.obric.oui.sheet.v2.d
    public void a(float r3, float r4, boolean r5) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void a(OSheet.Header r18, Integer r19, Integer r20, String r21, String r22, boolean r23, View.OnClickListener r24, View.OnClickListener r25, Integer r26, Integer r27, String r28, String r29, Integer r30, Integer r31) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r25, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r18, r19, r20, r21, r22, r23, r9, r10, r26, r27, r28, r29, r30, r31);
    }

    public void a(boolean r3) {
        com.obric.oui.sheet.v2.a.C0775a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void b() {
        com.obric.oui.sheet.v2.a.C0775a.o((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean c() {
        return this.m;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void g() {
        a(false);
        l.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.K;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBgColor() {
        return this.N;
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getBodyContainer() {
        FrameLayout r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBodyContentPaddingBottom() {
        return this.f14479J;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBodyContentPaddingTop() {
        return this.I;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ComponentCallbacks getConfigurationCallback() {
        return this.H;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getConfigurationCallbackRegistered() {
        return this.G;
    }

    public int getContentLayoutResId() {
        return com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public final View getContentView() {
        View r0 = this.f14480a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public View getDimView() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    public boolean getEnableDimAnim() {
        return this.j;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableEnterAnim() {
        return this.k;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableMaterial() {
        return this.u;
    }

    public View getEndActionButton() {
        return com.obric.oui.sheet.v2.a.C0775a.g((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getFooterContainer() {
        FrameLayout r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Size getFullWindowSize() {
        return this.r;
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    public OSheetTitleBar getHeaderTitleBar() {
        return com.obric.oui.sheet.v2.a.C0775a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public OSheet.HeightMode getHeightStyle() {
        return this.l;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getIgnoreInsetBottom() {
        return this.n;
    }

    public boolean getMCancelable() {
        return this.o;
    }

    public boolean getMClearDimFlag() {
        return this.i;
    }

    public int getMaxBodyHeight() {
        return com.obric.oui.sheet.v2.a.C0775a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public View getNegativeButton() {
        return com.obric.oui.sheet.v2.a.C0775a.h((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public View getPositiveButton() {
        return com.obric.oui.sheet.v2.a.C0775a.i((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public float getRootTransMoveStartX() {
        return this.L;
    }

    @Override // com.obric.oui.sheet.v2.a
    public float getRootTransMoveStartY() {
        return this.M;
    }

    @Override // com.obric.oui.sheet.v2.a
    public com.obric.common.oea.foundation.animation.d.d getRunningAnim() {
        return this.s;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ViewGroup getScaffoldContainer() {
        ViewGroup r0 = this.f14481b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public com.obric.oui.sheet.v2.c getScaffoldController() {
        com.obric.oui.sheet.v2.c r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Context getSheetContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        return r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getShowing() {
        return this.t;
    }

    public View getStartActionButton() {
        return com.obric.oui.sheet.v2.a.C0775a.f((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.v;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowHeight() {
        return this.q;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowWidth() {
        return this.p;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Window i() {
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean j() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean k() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void l() {
        d r0 = this.y;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void m() {
        d r0 = this.y;
        if (r0 == null) goto L7;
        r0.b(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void n() {
        c r0 = this.z;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void o() {
        c r0 = this.z;
        if (r0 == null) goto L7;
        r0.b(this);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
        d();
    }

    @Override // com.obric.oui.sheet.v2.a
    public void p() {
        setShowing(false);
        setVisibility(8);
        e();
        d();
        if (this.w == false) goto L12;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L7;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L13;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.obric.oui.sheet.v2.a
    public void r() {
        com.obric.oui.sheet.v2.a.C0775a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r1) {
        this.K = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBgColor(int r1) {
        this.N = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingBottom(int r1) {
        this.f14479J = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingTop(int r1) {
        this.I = r1;
    }

    public void setBodyView(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setCancelable(boolean r1) {
        setMCancelable(r1);
    }

    public void setCanceledOnTouchOutside(boolean r3) {
        com.obric.oui.sheet.v2.a.C0775a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setClearDimFlag(boolean r1) {
        setMClearDimFlag(r1);
    }

    public void setConfigurationCallback(ComponentCallbacks r3) {
        ComponentCallbacks r4 = (ComponentCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, ComponentCallbacks.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.H = r4;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setConfigurationCallbackRegistered(boolean r1) {
        this.G = r1;
    }

    public void setContentOverlayMode(boolean r1) {
        this.m = r1;
    }

    public final void setContentView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14480a = r2;
    }

    public void setDimView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public void setEnableDimAnim(boolean r1) {
        this.j = r1;
    }

    public void setEnableEnterAnim(boolean r1) {
        this.k = r1;
    }

    public void setEnableMaterial(boolean r1) {
        this.u = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFooterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public void setFooterView(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFullWindowSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeaderContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public void setHeaderView(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void setHeightMode(OSheet.HeightMode r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeightStyle(OSheet.HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setIgnoreInsetBottom(boolean r1) {
        this.n = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setMCancelable(boolean r1) {
        this.o = r1;
    }

    public void setMClearDimFlag(boolean r1) {
        this.i = r1;
    }

    public final void setOnCancelListener(a r3) {
        this.B = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    public final void setOnConfigurationListener(b r3) {
        this.A = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setOnDismissAnimListener(c r3) {
        this.z = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setOnShowAnimListener(d r3) {
        this.y = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r3) {
        com.obric.oui.sheet.v2.a.C0775a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setPassThroughTouchOutside(boolean r1) {
        this.x = r1;
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.w = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootContainer(RadiusLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartX(float r1) {
        this.L = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartY(float r1) {
        this.M = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRunningAnim(com.obric.common.oea.foundation.animation.d.d r1) {
        this.s = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14481b = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldController(com.obric.oui.sheet.v2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public void setSheetBgColor(int r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void setSheetBgMaterials(Function1<? super Boolean, com.obric.oui.material.c[]> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r4);
    }

    public void setShowing(boolean r1) {
        this.t = r1;
    }

    public final void setSystemInsetsAppearanceLight(Boolean r1) {
        setSystemInsetsAppearanceLightValue(r1);
    }

    public void setSystemInsetsAppearanceLightValue(Boolean r1) {
        this.v = r1;
    }

    public void setUserWindowHeight(int r1) {
        this.q = r1;
    }

    public void setUserWindowWidth(int r1) {
        this.p = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setupDimView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        setDimView(new View(r5));
        addView(getDimView(), 0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    public void setupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r4);
        g();
    }

    @Override // com.obric.oui.sheet.v2.a
    public void v() {
        com.obric.oui.sheet.v2.a.C0775a.j((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void y() {
        com.obric.oui.sheet.v2.a.C0775a.m((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }
}
