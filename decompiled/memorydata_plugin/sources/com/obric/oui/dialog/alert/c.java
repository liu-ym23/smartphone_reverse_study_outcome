package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001XB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0000J\u000e\u0010\b\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\fJ\u0016\u00102\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\nJ\b\u00107\u001a\u00020\u0002H\u0017J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u0012\u0010;\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007H\u0007J\u000e\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u00002\u0006\u00106\u001a\u00020\nJ\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u00104\u001a\u00020\fJ\u0018\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0007J\u0016\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001d\u001a\u00020\u00002\b\b\u0001\u0010\u001d\u001a\u00020\fJ\u0010\u0010@\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ(\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010A\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ(\u0010A\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J(\u0010H\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010H\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010H\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ\u001a\u0010H\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!J \u0010I\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0017J(\u0010L\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ&\u0010L\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u001e2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J*\u0010L\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020F0DJ(\u0010L\u001a\u00020\u00002\b\b\u0001\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010$H\u0007J\u0006\u0010M\u001a\u00020\u0000J\u001a\u0010,\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010N\u001a\u00020\u0007J\u0010\u0010,\u001a\u00020\u00002\b\b\u0001\u0010,\u001a\u00020\fJ\u0018\u0010-\u001a\u00020\u00002\u0006\u0010O\u001a\u00020.2\b\b\u0002\u0010P\u001a\u00020\fJ\u0012\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u0007H\u0007J\u000e\u00100\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0007J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\u0007J&\u0010T\u001a\u00020F2\b\u00104\u001a\u0004\u0018\u00010\u00132\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020F0VH\u0002J&\u0010W\u001a\u00020F2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020F0VH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialogBuilder;", "Lcom/obric/oui/dialog/base/AbstractDialogBuilder;", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adaptWindowDim", "", "autoDismiss", "bodyController", "Lcom/obric/oui/dialog/alert/StyleController;", "buttonStyle", "", "customNegativeView", "Landroid/view/View;", "forceHideCloseIcon", "forceHideFirstFrame", "iconController", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageHeight", "Ljava/lang/Integer;", "imageLoadDelegate", "Lcom/obric/oui/dialog/alert/view/IOImageLoadDelegate;", "imageUrl", "", "imageWidth", "isBanner", "isOnlyTitle", "message", "", "messageMoreThanTwoLines", "negativeButtonClick", "Landroid/content/DialogInterface$OnClickListener;", "negativeButtonText", "negativeButtonTextColorType", "Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "neutralButtonClick", "neutralButtonText", "neutralButtonTextColorType", "positiveButtonBgPrimary", "positiveButtonClick", "positiveButtonText", "positiveButtonTextColorType", "title", "topImageLoader", "Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "widthMatchParent", "withBodyHeightMatchParent", "enabled", "banner", "drawable", "icon", "body", "controller", "createDialog", "customNegativeButton", "customView", "force", "horizontalButton", "iconSize", "widthPixel", "heightPixel", "imageSize", "multiMessage", "negativeButton", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "listener", "Lkotlin/Function2;", "Landroid/content/DialogInterface;", "", "textColorType", "neutralButton", "newDialogInstance", "widthMatch", "withHeightMatchParent", "positiveButton", "primaryButton", "onlyTitle", "loader", "imageType", "verticalButton", "matchParent", "withBodyWithMatchParent", "withIconValid", "block", "Lkotlin/Function1;", "withTextValid", "IImageLoader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class c extends com.obric.oui.dialog.base.a<b> {
    private boolean A;
    private boolean B;
    private boolean C;
    private View D;
    private boolean E;
    private boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f13794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CharSequence f13795b;
    private CharSequence c;
    private boolean d;
    private Drawable e;
    private String f;
    private com.obric.oui.dialog.alert.view.a g;
    private a h;
    private Integer i;
    private Integer j;
    private boolean k;
    private int l;
    private CharSequence m;
    private DialogInterface.OnClickListener n;
    private ButtonStyleController.TextColorType o;
    private CharSequence p;
    private DialogInterface.OnClickListener q;
    private ButtonStyleController.TextColorType r;
    private boolean s;
    private CharSequence t;
    private DialogInterface.OnClickListener u;
    private ButtonStyleController.TextColorType v;
    private boolean w;
    private e x;
    private e y;
    private boolean z;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialogBuilder$IImageLoader;", "", "loadTopImg", "", "imageView", "Landroid/widget/ImageView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(ImageView r1);
    }

    public c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f13794a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.f = "";
        this.w = true;
        super.c(false);
    }

    public static /* synthetic */ c a(c r2, CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
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

    public static /* synthetic */ c a(c r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r4 = false;
    L8:
        return r2.a(r7, r4);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: title");
    }

    public static /* synthetic */ c a(c r0, boolean r1, int r2, Object r3) {
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

    public static final /* synthetic */ boolean a(c r0) {
        return r0.d;
    }

    public static /* synthetic */ c b(c r2, CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5, int r6, Object r7) {
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

    public static final /* synthetic */ boolean b(c r0) {
        return r0.C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b a() {
        final b r0 = a(this.f13794a, this.A, this.z);
        a(this.f13795b, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialogBuilder$createDialog$1(this, r0), Function1.class, "com.obric.memorydata.plugin"));
        a(this.c, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialogBuilder$createDialog$2(r0, this), Function1.class, "com.obric.memorydata.plugin"));
        e r1 = this.y;
        if (r1 != null) goto L5;
        Unit r2 = null;
    L6:
        boolean r3 = true;
        if (r2 != null) goto L38;
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.f, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L11;
        Object[] r6 = true;
    L12:
        if (r6 == true) goto L14;
    L16:
        Object[] r7 = false;
    L17:
        Drawable r8 = r4.e;
        if (r8 != null) goto L22;
        if (r7 == true) goto L22;
        if (r4.h == null) goto L38;
    L22:
        com.obric.oui.dialog.alert.a r9 = new com.obric.oui.dialog.alert.a(r4.f13794a, r4.k ? 1 : 0);
        a r10 = r4.h;
        if (r10 == null) goto L25;
        Intrinsics.checkNotNull(r10);
        r9.a(r10);
    L37:
        r0.a((e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin"));
        goto L38
    L25:
        if (r8 == null) goto L28;
        r9.a(r8);
        Integer r11 = r4.i;
        Integer r5 = r4.j;
    L27:
        r9.a(r11, r5);
        goto L37
    L28:
        r9.a(r4.f);
        com.obric.oui.dialog.alert.view.a r12 = r4.g;
        if (r12 == null) goto L32;
        r9.a(r12);
    L32:
        r11 = r4.i;
        if (r11 == null) goto L37;
        r5 = r4.j;
        if (r5 == null) goto L37;
    L14:
        if (r4.g == null) goto L16;
        r7 = true;
        goto L17
    L11:
        r6 = false;
    L38:
        r0.a(this.w);
        ButtonStyleController r13 = new ButtonStyleController(this.f13794a, this.l);
        r0.b((e) ZeusTransformUtils.preCheckCast(r13, e.class, "com.obric.memorydata.plugin"));
        e r14 = this.x;
        if (r14 == null) goto L43;
        r0.c(r14);
    L43:
        if (f() == true) goto L50;
        com.obric.oui.dialog.base.a r15 = (com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.memorydata.plugin");
        if (this.l == 2) goto L48;
        r3 = false;
    L48:
        com.obric.oui.dialog.base.a.a(r15, r3, null, 2, null);
    L50:
        if (this.B == false) goto L53;
        com.obric.oui.dialog.base.a.a((com.obric.oui.dialog.base.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.base.a.class, "com.obric.memorydata.plugin"), false, null, 2, null);
    L53:
        if (this.E == false) goto L56;
        r0.r();
    L56:
        if (this.F == false) goto L58;
        r0.s();
    L58:
        r0.setOnShowListener(e());
        r0.setOnDismissListener(c());
        r0.setOnCancelListener(d());
        r13.a(this.p, this.q, this.r, this.s);
        r13.a(this.m, this.n, this.o);
        r13.b(this.t, this.u, this.v);
        View r16 = this.D;
        if (r16 == null) goto L61;
        Intrinsics.checkNotNull(r16);
        r13.a(r16);
    L61:
        return r0;
    L5:
        r0.a(r1);
        r2 = Unit.INSTANCE;
        goto L6
    }

    public b a(Context r2, boolean r3, boolean r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        return new b(r1, r3, r4);
    }

    public final c a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "controller");
        this.x = r4;
        return this;
    }

    public final c a(CharSequence r3) {
        this.c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        return this;
    }

    public final c a(CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.p = r6;
        this.q = r7;
        this.r = r5;
        return this;
    }

    public final c a(CharSequence r3, boolean r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d = r4;
        this.f13795b = r5;
        return this;
    }

    public final c a(boolean r2) {
        this.l = 0;
        this.s = r2;
        return this;
    }

    public final c b(CharSequence r3, DialogInterface.OnClickListener r4, ButtonStyleController.TextColorType r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.m = r6;
        this.n = r7;
        this.o = r5;
        return this;
    }

    public final c b(boolean r1) {
        this.w = r1;
        return this;
    }

    @Override // com.obric.oui.dialog.base.a
    public /* synthetic */ AbstractDialog b() {
        return (AbstractDialog) ZeusTransformUtils.preCheckCast(a(), AbstractDialog.class, "com.obric.memorydata.plugin");
    }
}
