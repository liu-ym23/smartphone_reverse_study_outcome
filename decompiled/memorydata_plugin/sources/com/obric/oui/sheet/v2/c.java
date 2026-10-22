package com.obric.oui.sheet.v2;

import android.content.Context;
import android.os.Build;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.c.i;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.view.e;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010E\u001a\u00020BJ\u0006\u0010F\u001a\u00020*J\u0006\u0010G\u001a\u00020$J\u000e\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020BJ\u0010\u0010L\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010M\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010\u000fJO\u0010N\u001a\u00020B2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010P\u001a\u00020$2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010T\u001a\u00020$2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010R¢\u0006\u0002\u0010VJJ\u0010N\u001a\u00020B2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010X2\b\b\u0002\u0010P\u001a\u00020$2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X2\b\b\u0002\u0010T\u001a\u00020$2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010RJ\u0010\u0010Z\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u000fJµ\u0001\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020]2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010X2\b\b\u0002\u0010b\u001a\u00020$2\b\u0010c\u001a\u0004\u0018\u00010R2\b\u0010d\u001a\u0004\u0018\u00010R2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010X2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010l¢\u0006\u0002\u0010mJ\u0010\u0010n\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010o\u001a\u00020BJ\u000e\u0010p\u001a\u00020B2\u0006\u0010I\u001a\u00020JJ\u000e\u0010q\u001a\u00020B2\u0006\u0010I\u001a\u00020JJ\u0006\u0010r\u001a\u00020BJ\u0006\u0010s\u001a\u00020BJ\u0006\u0010t\u001a\u00020BR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R,\u00109\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006u"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "", "context", "Landroid/content/Context;", "sheet", "Lcom/obric/oui/sheet/v2/OSheetBase;", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "headerContainer", "Landroid/widget/FrameLayout;", "bodyContainer", "footerContainer", "scaffoldContainer", "Landroid/view/ViewGroup;", "dimView", "Landroid/view/View;", "(Landroid/content/Context;Lcom/obric/oui/sheet/v2/OSheetBase;Lcom/obric/oui/dialog/alert/view/RadiusLayout;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Landroid/view/ViewGroup;Landroid/view/View;)V", "getBodyContainer", "()Landroid/widget/FrameLayout;", "getDimView", "()Landroid/view/View;", "getFooterContainer", "getHeaderContainer", "headerTitleBar", "Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "getHeaderTitleBar", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "setHeaderTitleBar", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar;)V", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "", "getIgnoreInsetBottom", "()Z", "setIgnoreInsetBottom", "(Z)V", "maxBodyHeight", "", "maxRootHeight", "getMaxRootHeight", "()I", "setMaxRootHeight", "(I)V", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "rootContainerOriginPaddingBottom", "getRootContainerOriginPaddingBottom", "setRootContainerOriginPaddingBottom", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "getSheet", "()Lcom/obric/oui/sheet/v2/OSheetBase;", "sheetBgMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getSheetBgMaterials", "()Lkotlin/jvm/functions/Function1;", "setSheetBgMaterials", "(Lkotlin/jvm/functions/Function1;)V", "addChildToParent", "", "parent", "child", "calculateBodyMaxHeight", "getMaxBodyHeight", "isRootContainerMaxHeight", "refreshForConfiguration", "fullWindowSize", "Landroid/util/Size;", "removeOnApplyWindowInsetsListener", "setBodyView", "setChildToParent", "setFooterButton", "negativeBtnTextResId", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "setFooterView", "setHeader", "style", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "titleResId", "subTitleResId", "title", "subTitle", "showHandleView", "startActionEvent", "endActionEvent", "startActionDesResId", "endActionDesResId", "startActionDes", "endActionDesRes", "startActionIconResId", "endActionIconResId", "handleDelegate", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "(Lcom/obric/oui/sheet/v2/OSheet$Header;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/obric/oui/sheet/v2/SheetMoveDelegate;)V", "setHeaderView", "setOnApplyWindowInsetsListener", "setupRoot", "updateMaxRootHeight", "updateRootHeight", "updateRootSize", "updateRootWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.oui.sheet.v2.a f14488b;
    private final RadiusLayout c;
    private final FrameLayout d;
    private final FrameLayout e;
    private final FrameLayout f;
    private final ViewGroup g;
    private final View h;
    private Function1<? super Boolean, com.obric.oui.material.c[]> i;
    private int j;
    private int k;
    private OSheet.HeightMode l;
    private boolean m;
    private int n;
    private OSheetTitleBar o;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14489a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14490b = null;

        static {
            int[] r0 = new int[OSheet.HeightMode.values().length];
            r0[OSheet.HeightMode.FULL_HEIGHT.ordinal()] = 1;
            r0[OSheet.HeightMode.WRAP_HEIGHT.ordinal()] = 2;
            f14489a = r0;
            int[] r1 = new int[OSheet.Header.values().length];
            r1[OSheet.Header.PAGE.ordinal()] = 1;
            r1[OSheet.Header.ACTION.ordinal()] = 2;
            r1[OSheet.Header.MODAL.ordinal()] = 3;
            r1[OSheet.Header.ONLY_TITLE.ordinal()] = 4;
            r1[OSheet.Header.PAGE_WITH_CLOSE.ordinal()] = 5;
            f14490b = r1;
        }
    }

    public c(Context r3, com.obric.oui.sheet.v2.a r4, RadiusLayout r5, FrameLayout r6, FrameLayout r7, FrameLayout r8, ViewGroup r9, View r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.sheet.v2.a r12 = (com.obric.oui.sheet.v2.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "sheet");
        Intrinsics.checkNotNullParameter(r5, "rootContainer");
        Intrinsics.checkNotNullParameter(r6, "headerContainer");
        Intrinsics.checkNotNullParameter(r7, "bodyContainer");
        Intrinsics.checkNotNullParameter(r8, "footerContainer");
        Intrinsics.checkNotNullParameter(r9, "scaffoldContainer");
        Intrinsics.checkNotNullParameter(r10, "dimView");
        this.f14487a = ZeusTransformUtils.wrapperContext(r11, "com.obric.memorydata.plugin");
        this.f14488b = r12;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = MaterialToken.OUI_Bg_Modal;
        this.l = OSheet.HeightMode.WRAP_HEIGHT;
        this.n = r5.getPaddingBottom();
    }

    private static final WindowInsets a(c r6, View r7, WindowInsets r8) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r8, "insets");
        if (r6.m == true) goto L5;
    L8:
        e r0 = e.a(r8);
        Intrinsics.checkNotNullExpressionValue(r0, "toWindowInsetsCompat(insets)");
        int r2 = r0.b(e.m.b()).e;
        if (r2 == 0) goto L11;
    L13:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "v.context");
        if (com.obric.oui.window.a.f(r3) == true) goto L18;
        if (r2 <= 0) goto L18;
        int r4 = 40;
    L19:
        int r5 = Math.max(r2, h.a(r7, r4)) + r6.n;
        int r9 = r0.a(e.m.a()).e;
        if (Build.VERSION.SDK_INT < 30) goto L22;
        int r10 = Math.max(r9, com.obric.oui.window.a.f14878a.a(r7));
    L23:
        if (r10 <= 0) goto L25;
        r7.setPadding(0, 0, 0, Math.max(r5, r10));
    L26:
        return r8;
    L25:
        i.c(r7, 0);
        r7.setPadding(0, 0, 0, r5);
        goto L26
    L22:
        r10 = 0;
    L18:
        r4 = 24;
        goto L19
    L11:
        if (r7.getRootWindowInsets() == null) goto L13;
        e r11 = e.a(r7.getRootWindowInsets());
        Intrinsics.checkNotNullExpressionValue(r11, "toWindowInsetsCompat(v.rootWindowInsets)");
        r2 = r11.b(e.m.b()).e;
        goto L13
    L5:
        if (ZeusTransformUtils.instanceOf(r6.f.getChildAt(0), OSheetFooterBtnContainer.class) == true) goto L8;
        r7.setPadding(0, 0, 0, r6.n);
        return r8;
    }

    private static final void d(View r0) {
    }

    /* JADX INFO: renamed from: lambda$2piNqOK6-FnN2KwzVvrzw-YZE8w, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1363lambda$2piNqOK6FnN2KwzVvrzwYZE8w(c r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dVzgFYGaad_d8mTShOi2nQ_wWv0(View r0) {
        d(r0);
    }

    public final com.obric.oui.sheet.v2.a a() {
        return this.f14488b;
    }

    public final void a(Size r4) {
        Intrinsics.checkNotNullParameter(r4, "fullWindowSize");
        this.c.setOnClickListener($$Lambda$c$dVzgFYGaad_d8mTShOi2nQ_wWv0.INSTANCE);
        this.g.setClipChildren(false);
        this.h.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.h.setAlpha(0.0f);
        o.b(this.h);
        b(r4);
        f();
        SheetAnimStyle.f14486a.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"));
        k();
    }

    public final void a(View r4) {
        if (ZeusTransformUtils.instanceOf(r4, OSheetTitleBar.class) == false) goto L5;
        OSheetTitleBar r0 = (OSheetTitleBar) ZeusTransformUtils.preCheckCast(r4, OSheetTitleBar.class, "com.obric.memorydata.plugin");
    L6:
        this.o = r0;
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.d, ViewGroup.class, "com.obric.memorydata.plugin"), r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void a(ViewGroup r2, View r3) {
        if (r3 == null) goto L13;
        if (r2 == null) goto L7;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r2 == null) goto L21;
        r2.addView(r3);
        return;
    L21:
        return;
    L13:
        if (r2 == null) goto L16;
        r2.removeAllViews();
    L16:
        if (r2 == null) goto L22;
        o.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void a(OSheet.Header r23, Integer r24, Integer r25, String r26, String r27, boolean r28, View.OnClickListener r29, View.OnClickListener r30, Integer r31, Integer r32, String r33, String r34, Integer r35, Integer r36, d r37) {
        View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r29, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r30, View.OnClickListener.class, "com.obric.memorydata.plugin");
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r37, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r23, "style");
        if (r24 == null) goto L5;
        String r5 = this.f14487a.getString(r24.intValue());
    L6:
        if (r25 == null) goto L8;
        String r7 = this.f14487a.getString(r25.intValue());
    L9:
        if (r31 == null) goto L11;
        String r8 = this.f14487a.getString(r31.intValue());
    L12:
        if (r32 == null) goto L14;
        String r9 = this.f14487a.getString(r32.intValue());
    L15:
        int r6 = a.f14490b[r23.ordinal()];
        if (r6 == 1) goto L73;
        d r210 = r4;
        String r211 = r8;
        String r212 = r9;
        if (r6 != 2) goto L20;
        OSheetTitleBar r10 = new OSheetTitleBar(this.f14487a, null, 0, 6, null);
        r10.setShowLeftBack(false);
        r10.setTitleText(r5);
        r10.setSubTitleText(r7);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMLeftContainer(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r35 != null) goto L58;
        int r13 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L59:
        int r38 = r13;
        OIconButtonFloating r0 = r10.a(r11, r12, r38, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, TypedValues.Custom.S_STRING, "oui_iv_close_desc")));
        r0.setId(ZeusTransformUtils.mapRes(R.id.btn_start_action, OaidModel.KEY_ID, "btn_start_action"));
        r0.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r211, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L63;
        r0.setOnClickListener(r1);
    L63:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMRightContainer(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L66;
        int r15 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_confirm, "drawable", "oui_ic_title_bar_confirm");
    L67:
        int r39 = r15;
        OIconButtonFloating r16 = r10.b(r2, r14, r39, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, TypedValues.Custom.S_COLOR, "oui_on_accent_default")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_confirm, TypedValues.Custom.S_STRING, "oui_confirm")));
        r16.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, OaidModel.KEY_ID, "btn_end_action"));
        r16.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L71;
        r16.setOnClickListener(r3);
    L71:
        c r17 = this;
    L72:
        OSheetTitleBar r18 = r10;
    L78:
        if (r18 == null) goto L87;
        r18.setClipChildren(false);
        if (r28 == false) goto L85;
        if (r210 == null) goto L85;
        r18.a(r17.f14487a, r210);
    L85:
        r17.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"));
        r18.a(a().c());
        b().setClipChildren(false);
        return;
    L87:
        return;
    L66:
        r15 = r36.intValue();
        goto L67
    L58:
        r13 = r35.intValue();
        goto L59
    L20:
        if (r6 != 3) goto L22;
        r18 = new OSheetTitleBar(this.f14487a, null, 0, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r5);
        r18.setSubTitleText(r7);
        Context r19 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r19, "context");
        ViewGroup r20 = (ViewGroup) ZeusTransformUtils.preCheckCast(r18.getMRightContainer(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L50;
        int r21 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L51:
        int r310 = r21;
        OIconButtonFloating r22 = r18.a(r19, r20, r310, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, TypedValues.Custom.S_STRING, "oui_iv_close_desc")));
        r22.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, OaidModel.KEY_ID, "btn_end_action"));
        r22.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L26;
        r22.setOnClickListener(r3);
    L26:
        r17 = this;
        goto L78
    L50:
        r21 = r36.intValue();
        goto L51
    L22:
        if (r6 != 4) goto L24;
        r18 = new OSheetTitleBar(this.f14487a, null, 0, 6, null);
        r18.setShowLeftBack(false);
        r18.setTitleText(r5);
        r18.setSubTitleText(r7);
        goto L26
    L24:
        if (r6 == 5) goto L27;
        r18 = null;
        goto L26
    L27:
        r10 = new OSheetTitleBar(this.f14487a, null, 0, 6, null);
        r10.setTitleText(r5);
        r10.setSubTitleText(r7);
        if (r1 == null) goto L34;
        View r40 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back"));
        if (r40 == null) goto L34;
        r40.setOnClickListener(r1);
    L34:
        Context r41 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r41, "context");
        ViewGroup r42 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getMRightContainer(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L37;
        int r43 = ZeusTransformUtils.mapRes(R.drawable.oui_ic_title_bar_close, "drawable", "oui_ic_title_bar_close");
    L38:
        int r311 = r43;
        OIconButtonFloating r44 = r10.a(r41, r42, r311, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColorStateList(ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1")), Integer.valueOf(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, TypedValues.Custom.S_STRING, "oui_iv_close_desc")));
        r44.setId(ZeusTransformUtils.mapRes(R.id.btn_end_action, OaidModel.KEY_ID, "btn_end_action"));
        if (r212 == null) goto L42;
        r44.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r212, CharSequence.class, "com.obric.memorydata.plugin"));
    L42:
        if (r3 == null) goto L45;
        r44.setOnClickListener(r3);
    L45:
        r17 = this;
        goto L72
    L37:
        r43 = r36.intValue();
        goto L38
    L73:
        r210 = r4;
        r17 = this;
        OSheetTitleBar r45 = new OSheetTitleBar(r17.f14487a, null, 0, 6, null);
        r45.setTitleText(r5);
        r45.setSubTitleText(r7);
        if (r1 == null) goto L77;
        r45.findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back")).setOnClickListener(r1);
    L77:
        r18 = r45;
        goto L78
    L14:
        r9 = r34;
        goto L15
    L11:
        r8 = r33;
        goto L12
    L8:
        r7 = r27;
        goto L9
    L5:
        r5 = r26;
        goto L6
    }

    public final void a(OSheet.HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void a(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.memorydata.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.memorydata.plugin");
        OSheetFooterBtnContainer r16 = new OSheetFooterBtnContainer(this.f14487a, null, 2, null);
        r16.a(r10, r11, r5, r13, r14, r8);
        c((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
    }

    public final void a(Function1<? super Boolean, com.obric.oui.material.c[]> r3) {
        Function1<? super Boolean, com.obric.oui.material.c[]> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.i = r4;
    }

    public final void a(boolean r1) {
        this.m = r1;
    }

    public final FrameLayout b() {
        return this.d;
    }

    public final void b(Size r3) {
        Intrinsics.checkNotNullParameter(r3, "fullWindowSize");
        int r0 = r3.getWidth();
        int r1 = r3.getHeight();
        float r4 = r3.getHeight();
        if (r0 <= r1) goto L5;
        float r2 = 0.84f;
    L6:
        this.j = (int) (r4 * r2);
        return;
    L5:
        r2 = 0.93f;
        goto L6
    }

    public final void b(View r4) {
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.e, ViewGroup.class, "com.obric.memorydata.plugin"), r4);
    }

    public final Function1<Boolean, com.obric.oui.material.c[]> c() {
        return this.i;
    }

    public final void c(Size r4) {
        Intrinsics.checkNotNullParameter(r4, "fullWindowSize");
        b(r4);
        f();
        SheetAnimStyle.f14486a.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"));
        k();
        this.c.requestLayout();
    }

    public final void c(View r4) {
        a((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.memorydata.plugin"), r4);
    }

    public final int d() {
        return this.j;
    }

    public final OSheetTitleBar e() {
        return this.o;
    }

    public final void f() {
        g();
        h();
    }

    public final void g() {
        int r0 = ZeusTransformUtils.getResources(this.f14487a, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
        int r1 = b.a(this.f14487a, r0);
        i.a((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), r1);
        float r2 = h.b(this.f14487a, 36);
        this.c.setRadius(r2, r2, 0.0f, 0.0f);
    }

    public final void h() {
        this.c.setMaxHeight(this.j);
        int r0 = a.f14489a[this.l.ordinal()];
        boolean r3 = false;
        if (r0 != 1) goto L5;
        i.b((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), this.j);
        int r6 = -1;
        if (ZeusTransformUtils.instanceOf(this.g, LinearLayout.class) == false) goto L14;
        ViewGroup.LayoutParams r1 = this.e.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.weight = 1.0f;
        r2.height = 0;
        FrameLayout r4 = this.e;
        ViewGroup.LayoutParams r5 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    L15:
        r4.setLayoutParams(r5);
        this.g.getLayoutParams().height = r6;
    L16:
        RadiusLayout r7 = this.c;
        if (this.l != OSheet.HeightMode.WRAP_HEIGHT) goto L19;
        r3 = true;
    L19:
        r7.setMeasureHeightUnspecified(r3);
        RadiusLayout r8 = this.c;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r10.gravity = 81;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r5 = this.e.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.height = -1;
        r4 = this.e;
        goto L15
    L5:
        if (r0 != 2) goto L16;
        r6 = -2;
        i.b((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"), -2);
        if (ZeusTransformUtils.instanceOf(this.g, LinearLayout.class) == false) goto L10;
        ViewGroup.LayoutParams r11 = this.e.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r11, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r12.weight = 0.0f;
        r12.height = -2;
        r4 = this.e;
        r5 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r12, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        goto L15
    L10:
        r5 = this.e.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r5.height = -2;
        r4 = this.e;
        goto L15
    }

    public final void i() {
        this.c.setOnApplyWindowInsetsListener(new $$Lambda$c$2piNqOK6FnN2KwzVvrzwYZE8w(this));
    }

    public final void j() {
        this.c.setOnApplyWindowInsetsListener(null);
    }

    public final void k() {
        if (this.f14488b.c() == false) goto L5;
        int r0 = 0;
    L6:
        this.k = (((this.j - r0) - this.f.getHeight()) - this.c.getPaddingTop()) - this.c.getPaddingBottom();
        return;
    L5:
        r0 = this.d.getHeight();
        goto L6
    }

    public final int l() {
        return this.k;
    }

    public final boolean m() {
        if (this.c.getHeight() < this.j) goto L5;
        return true;
    L5:
        return false;
    }
}
