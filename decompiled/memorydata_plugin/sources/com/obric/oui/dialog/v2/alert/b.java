package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.e;
import com.obric.oui.dialog.v2.alert.style.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u001bJ\u0010\u0010<\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\fJ\u0016\u0010<\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\nJ\b\u0010A\u001a\u00020BH\u0017J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\b\u0010D\u001a\u00020\u0002H\u0017J\n\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0000J\u0012\u0010J\u001a\u00020\u00002\b\b\u0002\u00105\u001a\u00020\u0007H\u0007J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u001bJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\nJ\u0010\u0010>\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\fJ\u0018\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\fH\u0007J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0007J\u0016\u0010O\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\f2\u0006\u0010M\u001a\u00020\fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010'\u001a\u00020\u00002\b\b\u0001\u0010'\u001a\u00020\fJ\u0010\u0010P\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J(\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ&\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\b\u0010S\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010.H\u0007J*\u0010Q\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ(\u0010Q\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010.H\u0007J(\u0010W\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ&\u0010W\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\b\u0010S\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010.H\u0007J*\u0010W\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ\u001a\u0010W\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010+J\u0018\u0010X\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0007H\u0017J\u0018\u0010Z\u001a\u00020B2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0007H\u0017J>\u0010[\u001a\u00020\u000026\u0010\\\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eJ(\u0010]\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ&\u0010]\u001a\u00020\u00002\u0006\u0010R\u001a\u00020(2\b\u0010S\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010.H\u0007J*\u0010]\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\u0018\u0010S\u001a\u0014\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020U0\u000eJ(\u0010]\u001a\u00020\u00002\b\b\u0001\u0010R\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010.H\u0007J\u0006\u0010^\u001a\u00020\u0000J\u0015\u0010_\u001a\u00020\u00002\b\u0010`\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010aJ\u001a\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010b\u001a\u00020\u0007J\u0010\u00106\u001a\u00020\u00002\b\b\u0001\u00106\u001a\u00020\fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010c\u001a\u0002082\b\b\u0002\u0010d\u001a\u00020\fJ\u0012\u0010e\u001a\u00020\u00002\b\b\u0002\u00105\u001a\u00020\u0007H\u0007J\u0010\u0010f\u001a\u00020\u00002\u0006\u0010g\u001a\u00020\fH\u0016J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\u0007J&\u0010i\u001a\u00020U2\b\u0010R\u001a\u0004\u0018\u00010(2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020U0kH\u0002J\f\u0010l\u001a\u00020m*\u00020nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010#\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/OAlertDialogBuilder;", "Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adaptWindowDim", "", "autoDismiss", "bodyController", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "buttonStyle", "", "customButtonStyleControllerProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "style", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "customNegativeView", "Landroid/view/View;", "forceHideCloseIcon", "forceHideFirstFrame", "iconClipToMask", "iconController", "iconStrokeEnabled", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageHeight", "Ljava/lang/Integer;", "imageLoadDelegate", "Lcom/obric/oui/dialog/v2/common/IOImageLoadDelegate;", "imageUrl", "", "imageWidth", "includeCutoutInLandscape", "Ljava/lang/Boolean;", "isBanner", "isOnlyTitle", "message", "", "messageMoreThanTwoLines", "negativeButtonClick", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonTextColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "neutralButtonClick", "neutralButtonText", "neutralButtonTextColorType", "positiveButtonClick", "positiveButtonText", "positiveButtonTextColorType", "positiveButtonWarning", "title", "topImageLoader", "Lcom/obric/oui/dialog/v2/common/IImageLoader;", "widthMatchParent", "withBodyHeightMatchParent", "enabled", "banner", "drawable", "icon", "body", "controller", "buildModal", "Lcom/obric/oui/dialog/v2/alert/OAlertDialogModal;", "clipToMask", "createDialog", "createImageStyleController", "Lcom/obric/oui/dialog/v2/alert/style/ImageStyleController;", "customNegativeButton", "customView", "force", "horizontalButton", "iconSize", "widthPixel", "heightPixel", "iconStroke", "imageSize", "multiMessage", "negativeButton", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "listener", "Landroid/content/DialogInterface;", "", "textColorType", "neutralButton", "newDialogInstance", "withHeightMatchParent", "newModalInstance", "overrideButtonStyleController", "styleControllerProvider", "positiveButton", "primaryButton", "setCutoutInLandscape", "include", "(Ljava/lang/Boolean;)Lcom/obric/oui/dialog/v2/alert/OAlertDialogBuilder;", "onlyTitle", "loader", "imageType", "verticalButton", "windowFixedHeight", "heightPx", "matchParent", "withTextValid", "block", "Lkotlin/Function1;", "toModalStyle", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends com.obric.oui.dialog.base.a<a> {
    private g A;
    private boolean B;
    private boolean C;
    private boolean D;
    private View E;
    private boolean F;
    private boolean G;
    private Boolean H;
    private Function2<? super Context, ? super Integer, ? extends ButtonStyleController> I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f13821b;
    private CharSequence c;
    private boolean d;
    private Drawable e;
    private String f;
    private com.obric.oui.dialog.v2.common.b g;
    private com.obric.oui.dialog.v2.common.a h;
    private Integer i;
    private Integer j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private CharSequence o;
    private DialogInterface.OnClickListener p;
    private ButtonStyleController.TextColorType q;
    private CharSequence r;
    private DialogInterface.OnClickListener s;
    private ButtonStyleController.TextColorType t;
    private boolean u;
    private CharSequence v;
    private DialogInterface.OnClickListener w;
    private ButtonStyleController.TextColorType x;
    private boolean y;
    private g z;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f13820a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f = "";
        this.y = true;
        super.c(false);
    }

    public static /* synthetic */ b a(b r2, int r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
        DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.a(r3, r8, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public static /* synthetic */ b a(b r2, CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.a(r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: positiveButton");
    }

    public static /* synthetic */ b a(b r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        return r2.a(r7, r4);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    public static /* synthetic */ b a(b r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.a(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: horizontalButton");
    }

    private final void a(CharSequence r2, Function1<? super CharSequence, Unit> r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r1) == true) goto L6;
        Intrinsics.checkNotNull(r1);
        r4.invoke(r1);
        return;
    }

    private static final void a(Function2 r2, DialogInterface r3, int r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$listener");
        Intrinsics.checkNotNullExpressionValue(r6, "dialog");
        r5.invoke(r6, Integer.valueOf(r4));
    }

    public static final /* synthetic */ boolean a(b r0) {
        return r0.D;
    }

    public static /* synthetic */ b b(b r2, int r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
        DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.b(r3, r8, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    public static /* synthetic */ b b(b r2, CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        return r2.b(r8, r9, r5);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: negativeButton");
    }

    private static final void b(Function2 r2, DialogInterface r3, int r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$listener");
        Intrinsics.checkNotNullExpressionValue(r6, "dialog");
        r5.invoke(r6, Integer.valueOf(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final e i() {
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        Object[] r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        r1 = false;
    L11:
        Drawable r2 = this.e;
        if (r2 != null) goto L18;
        if (r1 == true) goto L18;
        if (this.h != null) goto L18;
        return null;
    L18:
        e r3 = new e(this.f13820a, this.k ? 1 : 0);
        r3.a(this.l);
        r3.b(this.m);
        com.obric.oui.dialog.v2.common.a r4 = this.h;
        if (r4 == null) goto L21;
        Intrinsics.checkNotNull(r4);
        r3.a(r4);
    L33:
        return r3;
    L21:
        if (r2 == null) goto L24;
        r3.a(r2);
        Integer r5 = this.i;
        Integer r6 = this.j;
    L23:
        r3.a(r5, r6);
        goto L33
    L24:
        r3.a(this.f);
        com.obric.oui.dialog.v2.common.b r7 = this.g;
        if (r7 == null) goto L28;
        r3.a(r7);
    L28:
        r5 = this.i;
        if (r5 == null) goto L33;
        r6 = this.j;
        if (r6 == null) goto L33;
    L8:
        if (this.g == null) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ void lambda$AqpNbycYIA9HehCiMwwkbV8Wrx8(Function2 r0, DialogInterface r1, int r2) {
        b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$_4VjuOQ3b35qT--rRjckB-ZFtOI, reason: not valid java name */
    public static /* synthetic */ void m1288lambda$_4VjuOQ3b35qTrRjckBZFtOI(Function2 r0, DialogInterface r1, int r2) {
        a(r0, r1, r2);
    }

    public a a() {
        final a r0 = a(this.f13820a, this.B);
        if (this.d == false) goto L5;
        r0.b(this.f13821b);
    L6:
        a(this.c, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialogBuilder$createDialog$1(r0, this), Function1.class, "com.obric.memorydata.plugin"));
        g r1 = this.A;
        if (r1 != null) goto L9;
        Unit r2 = null;
    L10:
        if (r2 != null) goto L15;
        e r3 = ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).i();
        if (r3 == null) goto L15;
        r0.a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin"));
    L15:
        r0.a(this.y);
        Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r4 = this.I;
        if (r4 != null) goto L18;
        ButtonStyleController r5 = null;
    L19:
        if (r5 != null) goto L21;
        r5 = (ButtonStyleController) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.style.c(this.f13820a, this.n), ButtonStyleController.class, "com.obric.memorydata.plugin");
    L21:
        r0.b((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin"));
        g r6 = this.z;
        if (r6 == null) goto L26;
        r0.c(r6);
    L26:
        if (f() == true) goto L33;
        com.obric.oui.dialog.base.a r7 = (com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.memorydata.plugin");
        if (this.n != 2) goto L30;
        boolean r8 = true;
    L31:
        com.obric.oui.dialog.base.a.a(r7, r8, null, 2, null);
        goto L33
    L30:
        r8 = false;
    L33:
        if (this.C == false) goto L36;
        com.obric.oui.dialog.base.a.a((com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.memorydata.plugin"), false, null, 2, null);
    L36:
        if (this.F == false) goto L39;
        r0.r();
    L39:
        if (this.G == false) goto L41;
        r0.s();
    L41:
        r0.a(this.H);
        r0.setOnShowListener(e());
        r0.setOnDismissListener(c());
        r0.setOnCancelListener(d());
        r5.a(this.r, this.s, this.t, this.u);
        r5.a(this.o, this.p, this.q);
        r5.b(this.v, this.w, this.x);
        View r9 = this.E;
        if (r9 == null) goto L44;
        Intrinsics.checkNotNull(r9);
        r5.a(r9);
    L44:
        return r0;
    L18:
        r5 = (ButtonStyleController) ZeusTransformUtils.preCheckCast(r4.invoke(this.f13820a, Integer.valueOf(this.n)), ButtonStyleController.class, "com.obric.memorydata.plugin");
        goto L19
    L9:
        r0.a(r1);
        r2 = Unit.INSTANCE;
        goto L10
    L5:
        r0.a(this.f13821b);
        goto L6
    }

    public a a(Context r2, boolean r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return new a(r1, r3);
    }

    public final b a(int r4) {
        a(this, this.f13820a.getText(r4), false, 2, null);
        return this;
    }

    public final b a(int r1, int r2) {
        this.i = Integer.valueOf(r1);
        this.j = Integer.valueOf(r2);
        return this;
    }

    public final b a(int r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5) {
        DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        String r7 = this.f13820a.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(text)");
        return a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), r6, r5);
    }

    public final b a(int r3, Function2<? super DialogInterface, ? super Integer, Unit> r4) {
        Function2<? super DialogInterface, ? super Integer, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        String r6 = this.f13820a.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(text)");
        return a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), r5);
    }

    public final b a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.e = r2;
        this.k = false;
        return this;
    }

    public final b a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.z = r4;
        return this;
    }

    public final b a(CharSequence r3) {
        this.c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return this;
    }

    public final b a(CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.r = r6;
        this.s = r7;
        this.t = r5;
        return this;
    }

    public final b a(CharSequence r3, Function2<? super DialogInterface, ? super Integer, Unit> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        final Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.r = r5;
        this.s = new $$Lambda$b$_4VjuOQ3b35qTrRjckBZFtOI(r6);
        return this;
    }

    public final b a(CharSequence r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d = r4;
        this.f13821b = r5;
        return this;
    }

    public final b a(Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r3) {
        Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "styleControllerProvider");
        this.I = r4;
        return this;
    }

    public final b a(boolean r2) {
        this.n = 0;
        this.u = r2;
        return this;
    }

    @Override // com.obric.oui.dialog.base.a
    public /* synthetic */ AbstractDialog b() {
        return (AbstractDialog) ZeusTransformUtils.preCheckCast(a(), AbstractDialog.class, "com.obric.memorydata.plugin");
    }

    public final b b(int r2) {
        a(this.f13820a.getText(r2));
        return this;
    }

    public final b b(int r8, DialogInterface.OnClickListener r9, ButtonStyleController.TextColorType r10) {
        DialogInterface.OnClickListener r3 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r9, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        String r11 = this.f13820a.getString(r8);
        Intrinsics.checkNotNullExpressionValue(r11, "context.getString(text)");
        return b(this, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), r3, null, 4, null);
    }

    public final b b(int r3, Function2<? super DialogInterface, ? super Integer, Unit> r4) {
        Function2<? super DialogInterface, ? super Integer, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        String r6 = this.f13820a.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(text)");
        return b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), r5);
    }

    public final b b(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.e = r2;
        this.k = true;
        return this;
    }

    public final b b(CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.o = r6;
        this.p = r7;
        this.q = r5;
        return this;
    }

    public final b b(CharSequence r3, Function2<? super DialogInterface, ? super Integer, Unit> r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        final Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "listener");
        this.o = r5;
        this.p = new $$Lambda$b$AqpNbycYIA9HehCiMwwkbV8Wrx8(r6);
        return this;
    }

    public final b b(boolean r1) {
        this.y = r1;
        return this;
    }

    public final b c(int r2) {
        Drawable r3 = AppCompatResources.getDrawable(this.f13820a, r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullExpressionValue(r3, "getDrawable(context, icon)!!");
        return a(r3);
    }

    public final b d(int r2) {
        Drawable r3 = AppCompatResources.getDrawable(this.f13820a, r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullExpressionValue(r3, "getDrawable(context, icon)!!");
        return b(r3);
    }
}
