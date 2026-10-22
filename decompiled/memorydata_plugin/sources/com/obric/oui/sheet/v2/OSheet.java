package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.o;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Î\u00012\u00020\u00012\u00020\u0002:\u0006Î\u0001Ï\u0001Ð\u0001B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u009a\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100J\n\u0010\u009e\u0001\u001a\u00030\u009b\u0001H\u0016J\b\u0010\u009f\u0001\u001a\u00030\u009b\u0001J\b\u0010 \u0001\u001a\u00030\u009b\u0001J$\u0010¡\u0001\u001a\u0003H¢\u0001\"\t\b\u0000\u0010¢\u0001*\u0002002\u0007\u0010£\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¤\u0001J\t\u0010¥\u0001\u001a\u00020\tH\u0016J\u0016\u0010¦\u0001\u001a\u00030\u009b\u00012\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0014J\n\u0010©\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010ª\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010¬\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010\u00ad\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010®\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010¯\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010°\u0001\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00030\u009b\u00012\u0007\u0010²\u0001\u001a\u00020\tH\u0016J\u001e\u0010³\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100J\u0011\u0010´\u0001\u001a\u00030\u009b\u00012\u0007\u0010µ\u0001\u001a\u00020\tJ\u0011\u0010¶\u0001\u001a\u00030\u009b\u00012\u0007\u0010·\u0001\u001a\u00020\tJ\u0013\u0010¸\u0001\u001a\u00030\u009b\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010,J\u0013\u0010º\u0001\u001a\u00030\u009b\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u000106J\u0014\u0010»\u0001\u001a\u00030\u009b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u008a\u0001J\u0013\u0010¼\u0001\u001a\u00030\u009b\u00012\u0007\u0010½\u0001\u001a\u00020\tH\u0016J\u0019\u0010¾\u0001\u001a\u00030\u009b\u00012\t\u0010¿\u0001\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010À\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010Á\u0001\u001a\u00030\u009b\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J\u0016\u0010Ä\u0001\u001a\u00030\u009b\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J\u0012\u0010Å\u0001\u001a\u00030\u009b\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010Æ\u0001\u001a\u00030\u009b\u0001H\u0017J\n\u0010Ç\u0001\u001a\u00030\u009b\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010É\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u009b\u0001H\u0002J\t\u0010Ë\u0001\u001a\u00020\tH\u0016J\t\u0010Ì\u0001\u001a\u00020\tH\u0002J\f\u0010Í\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016R\u001a\u0010\f\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u001a\u0010:\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001a\u0010=\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001a\u0010@\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R\u001a\u0010C\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001a\u0010F\u001a\u00020GX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0017X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010\u0010R\u001a\u0010Y\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R\u001a\u0010[\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001a\u0010^\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000e\"\u0004\b`\u0010\u0010R$\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015R\u001a\u0010e\u001a\u00020fX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020lX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020{X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR \u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0012\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008b\u0001\u001a\u00020\tX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000e\"\u0005\b\u008d\u0001\u0010\u0010R$\u0010\u008e\u0001\u001a\u0004\u0018\u00010\tX\u0096\u000e¢\u0006\u0015\n\u0003\u0010\u0093\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010\u0094\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0013\"\u0005\b\u0096\u0001\u0010\u0015R\u001d\u0010\u0097\u0001\u001a\u00020\u0006X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0013\"\u0005\b\u0099\u0001\u0010\u0015¨\u0006Ñ\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet;", "Landroid/app/Dialog;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "context", "Landroid/content/Context;", "hostWindowHeight", "", "defStyleAttr", "contentOverlay", "", "userEnableMaterial", "(Landroid/content/Context;IIZZ)V", "autoAddBodyPaddingTopWhenOverlay", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "Landroid/widget/FrameLayout;", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnConfigurationListener;", "decorForceFullScreen", "decorFullScreen", "dimView", "Landroid/view/View;", "getDimView", "()Landroid/view/View;", "setDimView", "(Landroid/view/View;)V", "dismissAnimListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnDismissAnimListener;", "doShowAnimation", "getDoShowAnimation", "setDoShowAnimation", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "hideFirstFrame", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", EventBody.KEY_VALUE, "maxRootHeight", "getMaxRootHeight", "setMaxRootHeight", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "getSheetContext", "()Landroid/content/Context;", "showAnimListener", "Lcom/obric/oui/dialog/DialogExtInterface$OnShowAnimListener;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "addChildToParent", "", "parent", "child", "dismiss", "dismissImmediately", "forceHideFirstFrame", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, OaidModel.KEY_ID, "(I)Landroid/view/View;", "needDimAnim", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onShowAnimEnd", "onShowAnimStart", "onStart", "onStop", "originDismiss", "setCanceledOnTouchOutside", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "setChildToParent", "setClearDimFlag", "dim", "setFullScreen", "forceFullScreen", "setOnConfigurationListener", "listener", "setOnDismissAnimListener", "setOnShowAnimListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setSystemInsetsAppearanceLight", "appearanceLight", "setupDimView", "setupSystemInsets", "window", "Landroid/view/Window;", "setupSystemInsetsAppearance", "setupView", "show", "updateMaterial", "updateRootHeight", "updateRootSize", "updateRootWidth", "useWindowDim", "useWindowDimInternal", "windowForAnim", "Companion", "Header", "HeightMode", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheet extends Dialog implements com.obric.oui.sheet.v2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14473a = null;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ComponentCallbacks F;
    private float G;
    private float H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f14474J;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f14475b;
    public View c;
    public RadiusLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public FrameLayout g;
    public c h;
    private boolean i;
    private boolean j;
    private boolean k;
    private HeightMode l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private Size s;
    private Boolean t;
    private boolean u;
    private com.obric.common.oea.foundation.animation.d.d v;
    private com.obric.oui.dialog.a.c w;
    private com.obric.oui.dialog.a.b x;
    private com.obric.oui.dialog.a.InterfaceC0745a y;
    private int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Header;", "", "(Ljava/lang/String;I)V", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "PAGE_WITH_CLOSE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Header extends Enum<Header> {
        private static final /* synthetic */ Header[] $VALUES = null;
        public static final Header ACTION = null;
        public static final Header CUSTOM = null;
        public static final Header MODAL = null;
        public static final Header ONLY_TITLE = null;
        public static final Header PAGE = null;
        public static final Header PAGE_WITH_CLOSE = null;

        private static final /* synthetic */ Header[] $values() {
            return new Header[]{CUSTOM, PAGE, ACTION, MODAL, ONLY_TITLE, PAGE_WITH_CLOSE};
        }

        static {
            CUSTOM = new Header("CUSTOM", 0);
            PAGE = new Header("PAGE", 1);
            ACTION = new Header("ACTION", 2);
            MODAL = new Header("MODAL", 3);
            ONLY_TITLE = new Header("ONLY_TITLE", 4);
            PAGE_WITH_CLOSE = new Header("PAGE_WITH_CLOSE", 5);
            $VALUES = $values();
        }

        private Header(String r1, int r2) {
            super(r1, r2);
        }

        public static Header valueOf(String r2) {
            return (Header) ZeusTransformUtils.preCheckCast(Enum.valueOf(Header.class, r2), Header.class, "com.obric.memorydata.plugin");
        }

        public static Header[] values() {
            return (Header[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Header[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "", "(Ljava/lang/String;I)V", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightMode extends Enum<HeightMode> {
        private static final /* synthetic */ HeightMode[] $VALUES = null;
        public static final HeightMode FULL_HEIGHT = null;
        public static final HeightMode WRAP_HEIGHT = null;

        private static final /* synthetic */ HeightMode[] $values() {
            return new HeightMode[]{FULL_HEIGHT, WRAP_HEIGHT};
        }

        static {
            FULL_HEIGHT = new HeightMode("FULL_HEIGHT", 0);
            WRAP_HEIGHT = new HeightMode("WRAP_HEIGHT", 1);
            $VALUES = $values();
        }

        private HeightMode(String r1, int r2) {
            super(r1, r2);
        }

        public static HeightMode valueOf(String r2) {
            return (HeightMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HeightMode.class, r2), HeightMode.class, "com.obric.memorydata.plugin");
        }

        public static HeightMode[] values() {
            return (HeightMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HeightMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/sheet/v2/OSheet$configurationCallback$1", "Landroid/content/ComponentCallbacks;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSheet f14476a;

        b(OSheet r1) {
            this.f14476a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r4) {
            Intrinsics.checkNotNullParameter(r4, "newConfig");
            this.f14476a.r();
            this.f14476a.getScaffoldController().c(this.f14476a.getFullWindowSize());
            com.obric.oui.dialog.a.InterfaceC0745a r0 = OSheet.a(this.f14476a);
            if (r0 == null) goto L7;
            r0.a((Dialog) ZeusTransformUtils.preCheckCast(this.f14476a, Dialog.class, "com.obric.memorydata.plugin"), r4);
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        f14473a = new a(null);
    }

    public OSheet(Context r3, int r4, int r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8);
        this.j = true;
        this.k = true;
        this.l = HeightMode.WRAP_HEIGHT;
        this.m = r6;
        this.n = true;
        this.p = true;
        this.r = r4;
        boolean r9 = false;
        this.s = new Size(0, 0);
        this.B = true;
        this.F = (ComponentCallbacks) ZeusTransformUtils.preCheckCast(new b(this), ComponentCallbacks.class, "com.obric.memorydata.plugin");
        this.I = -1;
        if (r7 == true) goto L5;
    L10:
        Window r10 = getWindow();
        if (r10 == null) goto L14;
        r10.requestFeature(1);
    L14:
        setContentView(q());
        a(r8);
        return;
    L5:
        if (l.a(r8) == true) goto L7;
    L9:
        c(r9);
        goto L10
    L7:
        if (OMaterialHelper.d() == false) goto L9;
        r9 = true;
        goto L9
    }

    public /* synthetic */ OSheet(Context r4, int r5, int r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if ((r9 & 2) == 0) goto L5;
        int r12 = 0;
    L7:
        if ((r9 & 4) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r9 & 8) != 0) goto L15;
        r0 = r7;
    L15:
        if ((r9 & 16) == 0) goto L17;
        r8 = true;
    L17:
        this(r11, r12, r1, r0, r8);
        return;
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }

    private final boolean E() {
        return !this.n;
    }

    private final void F() {
    L6:
        e = move-exception;
        Log.e("OSheet", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L3:
        if (isShowing() == false) goto L11;
        super.dismiss();     // Catch: Exception -> L6
        return;
    }

    public static final /* synthetic */ com.obric.oui.dialog.a.InterfaceC0745a a(OSheet r0) {
        return r0.y;
    }

    private final void a(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.clearFlags(134217728);
    L10:
        if (r3 == null) goto L13;
        r3.addFlags(Integer.MIN_VALUE);
    L13:
        if (r3 == null) goto L17;
        r3.setNavigationBarColor(0);
    L17:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        if (r3 == null) goto L21;
        r3.setDecorFitsSystemWindows(false);
    L21:
        if (r3 == null) goto L26;
        r3.setNavigationBarDividerColor(0);
        return;
    L26:
        return;
    }

    private static final void a(OSheet r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.dismiss();
    }

    private final void b(Window r5) {
        Boolean r0 = e();
        int r1 = 0;
        if (r0 == null) goto L5;
        boolean r4 = r0.booleanValue();
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L31;
        if (r5 == null) goto L21;
        WindowInsetsController r2 = r5.getInsetsController();
        if (r2 == null) goto L21;
        if (r4 == false) goto L19;
        int r3 = 8;
    L20:
        r2.setSystemBarsAppearance(r3, 8);
        goto L21
    L19:
        r3 = 0;
    L21:
        if (r5 == null) goto L41;
        WindowInsetsController r6 = r5.getInsetsController();
        if (r6 != null) goto L27;
        return;
    L27:
        if (r4 == false) goto L29;
        r1 = 16;
    L29:
        r6.setSystemBarsAppearance(r1, 16);
        return;
    L41:
        return;
    L31:
        if (Build.VERSION.SDK_INT < 23) goto L40;
        if (r5 == null) goto L43;
        if (r4 == false) goto L36;
        View r7 = r5.getDecorView();
        int r8 = r5.getDecorView().getSystemUiVisibility() | 8192;
    L37:
        r7.setSystemUiVisibility(r8);
        return;
    L36:
        r7 = r5.getDecorView();
        r8 = r5.getDecorView().getSystemUiVisibility() & (-8193);
        goto L37
    L43:
        return;
    L40:
        return;
    L5:
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) == 32) goto L7;
        r4 = true;
        goto L10
    L7:
        r4 = false;
        goto L10
    }

    private static final void b(OSheet r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.y();
        if (r2.f14474J == true) goto L6;
        r2.getRootContainer().setAlpha(0.0f);
        r2.f14474J = true;
        r2.B();
        return;
    }

    public static /* synthetic */ void lambda$G68szQtyKVPeAiiikyhngWIRaIk(OSheet r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$HOpOCToMfXjnQU_28JAx3hA0f-Y, reason: not valid java name */
    public static /* synthetic */ void m1360lambda$HOpOCToMfXjnQU_28JAx3hA0fY(OSheet r0) {
        b(r0);
    }

    public void A() {
        com.obric.oui.sheet.v2.a.C0775a.o((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public void B() {
        com.obric.oui.sheet.v2.a.C0775a.p((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
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
        T r0 = (T) findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(id)");
        return r0;
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

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r4);
        g();
    }

    public void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void a(com.obric.oui.dialog.a.InterfaceC0745a r3) {
        this.y = (com.obric.oui.dialog.a.InterfaceC0745a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.a.InterfaceC0745a.class, "com.obric.memorydata.plugin");
    }

    public final void a(com.obric.oui.dialog.a.c r3) {
        this.w = (com.obric.oui.dialog.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.a.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.sheet.v2.a
    public void a(Header r18, Integer r19, Integer r20, String r21, String r22, boolean r23, View.OnClickListener r24, View.OnClickListener r25, Integer r26, Integer r27, String r28, String r29, Integer r30, Integer r31) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r25, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r18, r19, r20, r21, r22, r23, r9, r10, r26, r27, r28, r29, r30, r31);
    }

    public void a(HeightMode r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void a(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r10, r11, r5, r13, r14, r8);
    }

    public void a(boolean r1) {
        this.i = r1;
    }

    public boolean a() {
        return this.i;
    }

    public void b(int r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void b(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void b(boolean r1) {
        this.k = r1;
    }

    public boolean b() {
        return this.j;
    }

    public void c(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void c(boolean r1) {
        this.C = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean c() {
        return this.m;
    }

    public void d(View r3) {
        com.obric.oui.sheet.v2.a.C0775a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    public void d(boolean r1) {
        this.D = r1;
    }

    public boolean d() {
        return this.p;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        x();
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), 0.0f, 1, null);
        this.f14474J = false;
    }

    public Boolean e() {
        return this.t;
    }

    public final void e(boolean r1) {
        a(r1);
    }

    public final int f() {
        return getScaffoldController().d();
    }

    public void f(boolean r3) {
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void g() {
        g(true);
        l.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.memorydata.plugin"), getDimView());
    }

    public void g(boolean r3) {
        com.obric.oui.sheet.v2.a.C0775a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.B;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBgColor() {
        return this.I;
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
        return this.A;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBodyContentPaddingTop() {
        return this.z;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ComponentCallbacks getConfigurationCallback() {
        return this.F;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getConfigurationCallbackRegistered() {
        return this.E;
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

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableEnterAnim() {
        return this.k;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableMaterial() {
        return this.C;
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
        return this.s;
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

    @Override // com.obric.oui.sheet.v2.a
    public HeightMode getHeightStyle() {
        return this.l;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getIgnoreInsetBottom() {
        return this.u;
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
        return this.G;
    }

    @Override // com.obric.oui.sheet.v2.a
    public float getRootTransMoveStartY() {
        return this.H;
    }

    @Override // com.obric.oui.sheet.v2.a
    public com.obric.common.oea.foundation.animation.d.d getRunningAnim() {
        return this.v;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ViewGroup getScaffoldContainer() {
        ViewGroup r0 = this.f14475b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public c getScaffoldController() {
        c r0 = this.h;
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
        return this.D;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowHeight() {
        return this.r;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowWidth() {
        return this.q;
    }

    public final void h() {
        setRunningAnim(null);     // Catch: Exception -> L7
        setOnDismissListener(null);     // Catch: Exception -> L7
        if (isShowing() == false) goto L12;
        super.dismiss();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.e("OSheet", "dismissImmediately exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public Window i() {
        return getWindow();
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean j() {
        return E();
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean k() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void l() {
        com.obric.oui.dialog.a.c r0 = this.w;
        if (r0 == null) goto L7;
        r0.a((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void m() {
        com.obric.oui.dialog.a.c r0 = this.w;
        if (r0 == null) goto L7;
        r0.b((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void n() {
        com.obric.oui.dialog.a.b r0 = this.x;
        if (r0 == null) goto L7;
        r0.a((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void o() {
        com.obric.oui.dialog.a.b r0 = this.x;
        if (r0 == null) goto L7;
        r0.b((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L5;
        return;
    L5:
        if (getEnableEnterAnim() == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        z();
        v();
        getRootContainer().post(new $$Lambda$OSheet$HOpOCToMfXjnQU_28JAx3hA0fY(this));
    }

    @Override // android.app.Dialog
    public void onStop() {
        A();
        super.onStop();
    }

    @Override // com.obric.oui.sheet.v2.a
    public void p() {
        F();
    }

    public int q() {
        return com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void r() {
        com.obric.oui.sheet.v2.a.C0775a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public int s() {
        return com.obric.oui.sheet.v2.a.C0775a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r1) {
        this.B = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBgColor(int r1) {
        this.I = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingBottom(int r1) {
        this.A = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingTop(int r1) {
        this.z = r1;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r1) {
        super.setCanceledOnTouchOutside(r1);
        setMCancelable(r1);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setConfigurationCallbackRegistered(boolean r1) {
        this.E = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFooterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFullWindowSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.s = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeaderContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeightStyle(HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setIgnoreInsetBottom(boolean r1) {
        this.u = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setMCancelable(boolean r1) {
        this.p = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootContainer(RadiusLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartX(float r1) {
        this.G = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartY(float r1) {
        this.H = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRunningAnim(com.obric.common.oea.foundation.animation.d.d r1) {
        this.v = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14475b = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldController(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setupDimView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        a(new View(r5));
        if (ZeusTransformUtils.instanceOf(getRootContainer().getParent(), ViewGroup.class) == false) goto L6;
        ViewParent r6 = getRootContainer().getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        if (getShowing() == false) goto L5;
        r();
        getScaffoldController().c(getFullWindowSize());
    L10:
        super.show();
        w();
        Window r0 = getWindow();
        if (r0 == null) goto L50;
        r0.setSoftInputMode(48);
        r0.setBackgroundDrawableResource(R.color.transparent);
        a(r0);
        b(r0);
        if (a() == false) goto L16;
        r0.clearFlags(2);
    L17:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        float r3 = com.obric.oui.sheet.v2.b.a(r2);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        if (getHeightStyle() != HeightMode.FULL_HEIGHT) goto L20;
    L23:
        boolean r5 = true;
    L24:
        this.o = r5;
        boolean r6 = E();
        if (r6 == false) goto L27;
    L30:
        o.b(getDimView());
    L32:
        if (getShowing() == true) goto L35;
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L35:
        if (k() == true) goto L37;
    L38:
        if (r6 == false) goto L40;
        r4.dimAmount = r3;
    L42:
        if (this.o == false) goto L44;
        int r7 = -1;
    L45:
        r0.setLayout(-1, r7);
        if (this.o == false) goto L48;
        r4.setFitInsetsSides(0);
    L49:
        r4.layoutInDisplayCutoutMode = 3;
        r4.gravity = 80;
        r4.windowAnimations = 0;
        r0.setAttributes(r4);
        goto L50
    L48:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L49
    L44:
        r7 = -2;
        goto L45
    L40:
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(r3);
        goto L42
    L37:
        if (getEnableEnterAnim() == true) goto L42;
    L27:
        if (a() == true) goto L30;
        o.a(getDimView());
        goto L32
    L20:
        if (this.n == true) goto L23;
        r5 = false;
        goto L24
    L16:
        r0.addFlags(2);
    L50:
        d(true);
        return;
    L5:
        if (d() == false) goto L7;
        View r1 = getDimView();
        View.OnClickListener r8 = new $$Lambda$OSheet$G68szQtyKVPeAiiikyhngWIRaIk(this);
    L8:
        r1.setOnClickListener(r8);
        goto L10
    L7:
        r1 = getDimView();
        r8 = null;
        goto L8
    }

    public boolean t() {
        return com.obric.oui.sheet.v2.a.C0775a.e((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public View u() {
        return com.obric.oui.sheet.v2.a.C0775a.i((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void v() {
        com.obric.oui.sheet.v2.a.C0775a.j((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public void w() {
        com.obric.oui.sheet.v2.a.C0775a.k((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public void x() {
        com.obric.oui.sheet.v2.a.C0775a.l((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void y() {
        com.obric.oui.sheet.v2.a.C0775a.m((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }

    public void z() {
        com.obric.oui.sheet.v2.a.C0775a.n((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"));
    }
}
