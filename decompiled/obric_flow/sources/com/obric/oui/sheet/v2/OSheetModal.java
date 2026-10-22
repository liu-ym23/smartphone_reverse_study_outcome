package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0017\u0014\r\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u0013J\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b \u0010\u0013J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010\u0013J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0010¢\u0006\u0004\b$\u0010\u0013R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020%8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b5\u0010'\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\"\u0010@\u001a\u0002098\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010G\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bH\u0010B\u001a\u0004\bI\u0010D\"\u0004\bJ\u0010FR\"\u0010O\u001a\u00020\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bL\u0010B\u001a\u0004\bM\u0010D\"\u0004\bN\u0010FR\"\u0010U\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010\u0013R\"\u0010Y\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010\u0013R\"\u0010]\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bZ\u0010Q\u001a\u0004\b[\u0010S\"\u0004\b\\\u0010\u0013R\"\u0010e\u001a\u00020^8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010m\u001a\u00020f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010o\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010Q\u001a\u0004\bo\u0010S\"\u0004\bp\u0010\u0013R\"\u0010t\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010Q\u001a\u0004\br\u0010S\"\u0004\bs\u0010\u0013R\"\u0010x\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bu\u0010Q\u001a\u0004\bv\u0010S\"\u0004\bw\u0010\u0013R#\u0010\u0080\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR&\u0010\u0084\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010\u0098\u0001\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010Q\u001a\u0005\b\u0096\u0001\u0010S\"\u0005\b\u0097\u0001\u0010\u0013R&\u0010\u009c\u0001\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010Q\u001a\u0005\b\u009a\u0001\u0010S\"\u0005\b\u009b\u0001\u0010\u0013R*\u0010¢\u0001\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0017\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0005\b¡\u0001\u0010\u001cR&\u0010¦\u0001\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010Q\u001a\u0005\b¤\u0001\u0010S\"\u0005\b¥\u0001\u0010\u0013R*\u0010®\u0001\u001a\u00030§\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R&\u0010²\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010{\u001a\u0005\b°\u0001\u0010}\"\u0005\b±\u0001\u0010\u007fR&\u0010¶\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010{\u001a\u0005\b´\u0001\u0010}\"\u0005\bµ\u0001\u0010\u007fR&\u0010º\u0001\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010Q\u001a\u0005\b¸\u0001\u0010S\"\u0005\b¹\u0001\u0010\u0013R*\u0010Â\u0001\u001a\u00030»\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R*\u0010Æ\u0001\u001a\u00030»\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010½\u0001\u001a\u0006\bÄ\u0001\u0010¿\u0001\"\u0006\bÅ\u0001\u0010Á\u0001R&\u0010Ê\u0001\u001a\u00020y8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÇ\u0001\u0010{\u001a\u0005\bÈ\u0001\u0010}\"\u0005\bÉ\u0001\u0010\u007fR\u0017\u0010Í\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001¨\u0006Î\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/sheet/v2/e;", "Landroid/content/Context;", "context", "", "setupView", "(Landroid/content/Context;)V", "setupDimView", "Lcom/obric/oui/sheet/v2/i;", "listener", "setOnShowAnimListener", "(Lcom/obric/oui/sheet/v2/i;)V", "Lcom/obric/oui/sheet/v2/h;", "setOnDismissAnimListener", "(Lcom/obric/oui/sheet/v2/h;)V", "", "enable", "setOverlayModeAutoBodyPaddingTopEnabled", "(Z)V", "Lcom/obric/oui/sheet/v2/g;", "setOnConfigurationListener", "(Lcom/obric/oui/sheet/v2/g;)V", "Lcom/obric/oui/sheet/v2/f;", "setOnCancelListener", "(Lcom/obric/oui/sheet/v2/f;)V", "appearanceLight", "setSystemInsetsAppearanceLight", "(Ljava/lang/Boolean;)V", "remove", "setRemoveOnDismiss", "cancelable", "setCancelable", "passThrough", "setPassThroughTouchOutside", "dim", "setClearDimFlag", "Landroid/view/View;", "a", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldContainer", "c", "getDimView", "setDimView", "dimView", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "d", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootContainer", "e", "Landroid/widget/FrameLayout;", "getHeaderContainer", "()Landroid/widget/FrameLayout;", "setHeaderContainer", "(Landroid/widget/FrameLayout;)V", "headerContainer", "f", "getFooterContainer", "setFooterContainer", "footerContainer", "g", "getBodyContainer", "setBodyContainer", "bodyContainer", "h", "Z", "getMClearDimFlag", "()Z", "setMClearDimFlag", "mClearDimFlag", "i", "getEnableDimAnim", "setEnableDimAnim", "enableDimAnim", "j", "getEnableEnterAnim", "setEnableEnterAnim", "enableEnterAnim", "Lcom/obric/oui/sheet/v2/m;", "k", "Lcom/obric/oui/sheet/v2/m;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/m;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/m;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "l", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "heightStyle", "m", "isContentOverlayMode", "setContentOverlayMode", "n", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "ignoreInsetBottom", "o", "getMCancelable", "setMCancelable", "mCancelable", "", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "I", "getUserWindowWidth", "()I", "setUserWindowWidth", "(I)V", "userWindowWidth", "q", "getUserWindowHeight", "setUserWindowHeight", "userWindowHeight", "Landroid/util/Size;", "r", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "fullWindowSize", "Ljp/d;", "s", "Ljp/d;", "getRunningAnim", "()Ljp/d;", "setRunningAnim", "(Ljp/d;)V", "runningAnim", "t", "getShowing", "setShowing", "showing", "u", "getEnableMaterial", "setEnableMaterial", "enableMaterial", "v", "Ljava/lang/Boolean;", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "systemInsetsAppearanceLightValue", "x", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationCallbackRegistered", "Landroid/content/ComponentCallbacks;", "y", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallback", "z", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "bodyContentPaddingTop", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingBottom", "B", "getAutoAddBodyPaddingTopWhenOverlay", "setAutoAddBodyPaddingTopWhenOverlay", "autoAddBodyPaddingTopWhenOverlay", "", "C", "F", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartX", "D", "getRootTransMoveStartY", "setRootTransMoveStartY", "rootTransMoveStartY", ExifInterface.LONGITUDE_EAST, "getBgColor", "setBgColor", "bgColor", "getSheetContext", "()Landroid/content/Context;", "sheetContext", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetModal extends FrameLayout implements e {
    public static final /* synthetic */ int F = 0;
    public int A;
    public boolean B;
    public float C;
    public float D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f14438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f14439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14440c;
    public RadiusLayout d;
    public FrameLayout e;
    public FrameLayout f;
    public FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f14444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OSheet$HeightMode f14445l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14446m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14447n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14448o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14449p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Size f14451r;
    public jp.d s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14452t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f14454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ComponentCallbacks f14457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14458z;

    @JvmOverloads
    public OSheetModal(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 30);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void a() {
        d.h(this);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean b() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getBgColor() != 0) goto L6;
        return a.a.v(getRootContainer());
    L6:
        return ym.h.j(getBgColor());
    }

    public final void c() {
        Activity r5 = com.lynx.tasm.utils.j.m(getContext());
        if (r5 == null) goto L7;
        r5.getWindow().getCallback();
        return;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean d() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final boolean e() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final View f(int r5) {
        return getContentView().findViewById(r5);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void g() {
        d.a(this, false);
        RadiusLayout r5 = getRootContainer();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.obric.oui.material.n.r(this, r5);
    }

    @Override // com.obric.oui.sheet.v2.e
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.B;
    }

    @Override // com.obric.oui.sheet.v2.e
    public int getBgColor() {
        return this.E;
    }

    @Override // com.obric.oui.sheet.v2.e
    public FrameLayout getBodyContainer() {
        FrameLayout r5 = this.g;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public int getBodyContentPaddingBottom() {
        return this.A;
    }

    @Override // com.obric.oui.sheet.v2.e
    public int getBodyContentPaddingTop() {
        return this.f14458z;
    }

    @Override // com.obric.oui.sheet.v2.e
    public ComponentCallbacks getConfigurationCallback() {
        return this.f14457y;
    }

    @Override // com.obric.oui.sheet.v2.e
    public boolean getConfigurationCallbackRegistered() {
        return this.f14456x;
    }

    public int getContentLayoutResId() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (this.f14446m == false) goto L6;
        return R$layout.o_sheet_container_overlay;
    L6:
        return R$layout.o_sheet_container;
    }

    public final View getContentView() {
        View r5 = this.f14438a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public View getDimView() {
        View r5 = this.f14440c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    public boolean getEnableDimAnim() {
        return this.f14442i;
    }

    public boolean getEnableEnterAnim() {
        return this.f14443j;
    }

    @Override // com.obric.oui.sheet.v2.e
    public boolean getEnableMaterial() {
        return this.f14453u;
    }

    public View getEndActionButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getHeaderContainer().findViewById(R$id.btn_end_action);
    }

    @Override // com.obric.oui.sheet.v2.e
    public FrameLayout getFooterContainer() {
        FrameLayout r5 = this.f;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public Size getFullWindowSize() {
        return this.f14451r;
    }

    @Override // com.obric.oui.sheet.v2.e
    public FrameLayout getHeaderContainer() {
        FrameLayout r5 = this.e;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    public OSheetTitleBar getHeaderTitleBar() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getScaffoldController().f14518m;
    }

    @Override // com.obric.oui.sheet.v2.e
    public OSheet$HeightMode getHeightStyle() {
        return this.f14445l;
    }

    @Override // com.obric.oui.sheet.v2.e
    public boolean getIgnoreInsetBottom() {
        return this.f14447n;
    }

    public boolean getMCancelable() {
        return this.f14448o;
    }

    public boolean getMClearDimFlag() {
        return this.f14441h;
    }

    public int getMaxBodyHeight() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getScaffoldController().f14514i;
    }

    public View getNegativeButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getFooterContainer().findViewById(R$id.btn_negative);
    }

    public View getPositiveButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getFooterContainer().findViewById(R$id.btn_positive);
    }

    @Override // com.obric.oui.sheet.v2.e
    public RadiusLayout getRootContainer() {
        RadiusLayout r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    public float getRootTransMoveStartX() {
        return this.C;
    }

    public float getRootTransMoveStartY() {
        return this.D;
    }

    @Override // com.obric.oui.sheet.v2.e
    public jp.d getRunningAnim() {
        return this.s;
    }

    @Override // com.obric.oui.sheet.v2.e
    public ViewGroup getScaffoldContainer() {
        ViewGroup r5 = this.f14439b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public m getScaffoldController() {
        m r5 = this.f14444k;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public Context getSheetContext() {
        return getContext();
    }

    @Override // com.obric.oui.sheet.v2.e
    public boolean getShowing() {
        return this.f14452t;
    }

    public View getStartActionButton() {
        Intrinsics.checkNotNullParameter(this, "this");
        View r5 = getHeaderContainer().findViewById(R$id.btn_start_action);
        if (r5 == null) goto L5;
        return r5;
    L5:
        return getHeaderContainer().findViewById(R$id.left_action_back);
    }

    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.f14454v;
    }

    @Override // com.obric.oui.sheet.v2.e
    public int getUserWindowHeight() {
        return this.f14450q;
    }

    @Override // com.obric.oui.sheet.v2.e
    public int getUserWindowWidth() {
        return this.f14449p;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final Window h() {
        return null;
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void i() {
        setShowing(false);
        setVisibility(8);
        Context r5 = getContext();
        ViewGroup r10 = null;
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r11 = (Activity) r5;
    L6:
        if (r11 == null) goto L9;
        r11.getWindow();
    L9:
        c();
        if (this.f14455w == false) goto L18;
        ViewParent r12 = getParent();
        if ((r12 instanceof ViewGroup) == false) goto L14;
        r10 = (ViewGroup) r12;
    L14:
        if (r10 == null) goto L19;
        r10.removeView(this);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void j() {
        d.b(this);
    }

    @Override // com.obric.oui.sheet.v2.e
    public final void k() {
        Intrinsics.checkNotNullParameter(this, "this");
        getScaffoldController().a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == true) goto L7;
        getSheetContext().registerComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(true);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == false) goto L6;
        getSheetContext().unregisterComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(false);
    L6:
        super.onDetachedFromWindow();
        c();
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r5) {
        this.B = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setBgColor(int r5) {
        this.E = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setBodyContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setBodyContentPaddingBottom(int r5) {
        this.A = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setBodyContentPaddingTop(int r5) {
        this.f14458z = r5;
    }

    public void setBodyView(View r5) {
        d.d(this, r5);
    }

    public final void setCancelable(boolean r5) {
        setMCancelable(r5);
    }

    public void setCanceledOnTouchOutside(boolean r5) {
        Intrinsics.checkNotNullParameter(this, "this");
        setMCancelable(r5);
    }

    public final void setClearDimFlag(boolean r5) {
        setMClearDimFlag(r5);
    }

    public void setConfigurationCallback(ComponentCallbacks r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14457y = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setConfigurationCallbackRegistered(boolean r5) {
        this.f14456x = r5;
    }

    public void setContentOverlayMode(boolean r5) {
        this.f14446m = r5;
    }

    public final void setContentView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14438a = r5;
    }

    public void setDimView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14440c = r5;
    }

    public void setEnableDimAnim(boolean r5) {
        this.f14442i = r5;
    }

    public void setEnableEnterAnim(boolean r5) {
        this.f14443j = r5;
    }

    public void setEnableMaterial(boolean r5) {
        this.f14453u = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setFooterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f = r5;
    }

    public void setFooterView(View r5) {
        Intrinsics.checkNotNullParameter(this, "this");
        m.c(r5, getScaffoldController().e);
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setFullWindowSize(Size r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14451r = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setHeaderContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.e = r5;
    }

    public void setHeaderView(View r5) {
        d.e(this, r5);
    }

    public void setHeightMode(OSheet$HeightMode r5) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(r5, "height");
        setHeightStyle(r5);
        m r10 = getScaffoldController();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.f14515j = r5;
        getScaffoldController().e();
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setHeightStyle(OSheet$HeightMode r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14445l = r5;
    }

    public void setIgnoreInsetBottom(boolean r5) {
        this.f14447n = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setMCancelable(boolean r5) {
        this.f14448o = r5;
    }

    public void setMClearDimFlag(boolean r5) {
        this.f14441h = r5;
    }

    public final void setOnCancelListener(f r5) {
    }

    public final void setOnConfigurationListener(g r5) {
    }

    public final void setOnDismissAnimListener(h r5) {
    }

    public final void setOnShowAnimListener(i r5) {
    }

    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r5) {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getAutoAddBodyPaddingTopWhenOverlay() == r5) goto L8;
        setAutoAddBodyPaddingTopWhenOverlay(r5);
        if (getShowing() == false) goto L9;
        d.c(this);
        return;
    L9:
        return;
    }

    public final void setPassThroughTouchOutside(boolean r5) {
    }

    public final void setRemoveOnDismiss(boolean r5) {
        this.f14455w = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setRootContainer(RadiusLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    public void setRootTransMoveStartX(float r5) {
        this.C = r5;
    }

    public void setRootTransMoveStartY(float r5) {
        this.D = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setRunningAnim(jp.d r5) {
        this.s = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setScaffoldContainer(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14439b = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setScaffoldController(m r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14444k = r5;
    }

    public void setSheetBgColor(int r5) {
        d.f(this, r5);
    }

    public void setShowing(boolean r5) {
        this.f14452t = r5;
    }

    public final void setSystemInsetsAppearanceLight(Boolean r5) {
        setSystemInsetsAppearanceLightValue(r5);
    }

    public void setSystemInsetsAppearanceLightValue(Boolean r5) {
        this.f14454v = r5;
    }

    public void setUserWindowHeight(int r5) {
        this.f14450q = r5;
    }

    public void setUserWindowWidth(int r5) {
        this.f14449p = r5;
    }

    @Override // com.obric.oui.sheet.v2.e
    public void setupDimView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        setDimView(new View(r5));
        addView(getDimView(), 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setupView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        d.g(this, r5);
        g();
    }

    @JvmOverloads
    public OSheetModal(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 28);
    }

    @JvmOverloads
    public OSheetModal(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetModal(Context r5, AttributeSet r10, int r11, int r12) {
        LifecycleOwner r13 = null;
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        boolean r14 = true;
        this.f14442i = true;
        this.f14443j = true;
        this.f14445l = OSheet$HeightMode.WRAP_HEIGHT;
        this.f14446m = false;
        this.f14448o = true;
        this.f14451r = new Size(0, 0);
        this.f14455w = true;
        this.f14457y = new com.bytedance.ies.bullet.service.preload.a(this, 3);
        this.B = true;
        this.E = -1;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.obric.oui.material.n.i(r5) == true) goto L11;
    L13:
        r14 = false;
    L14:
        setEnableMaterial(r14);
        setVisibility(8);
        setContentView(LayoutInflater.from(r5).inflate(getContentLayoutResId(), this, false));
        View r15 = getContentView();
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -2);
        r16.gravity = 80;
        Unit r17 = Unit.INSTANCE;
        addView(r15, r16);
        setupView(r5);
        if ((r5 instanceof LifecycleOwner) == false) goto L17;
        r13 = (LifecycleOwner) r5;
    L17:
        if (r13 == null) goto L24;
        Lifecycle r18 = r13.getLifecycle();
        if (r18 == null) goto L25;
        r18.addObserver(new AnonymousClass2(this));
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (com.obric.oui.material.n.k() == false) goto L13;
        goto L13
    }
}
