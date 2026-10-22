package com.obric.oui.sheet;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.animation.easy.b;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.j;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use com.obric.oui.sheet.v2.OSheet(context: Context, hostWindowHeight: Int) instead")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u0000 H2\u00020\u0001:\u0002HIB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020%H\u0016J\u0006\u0010,\u001a\u00020%J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\u0012\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020%H\u0014J\u0006\u00107\u001a\u00020%J\u0006\u00108\u001a\u00020%J\b\u00109\u001a\u00020%H\u0016J\u001a\u0010:\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u0012J\u0010\u0010=\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010>\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010?\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010@\u001a\u00020%H\u0003J\u000e\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u001fJ\u000e\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006J"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "setContentContainer", "(Landroid/widget/FrameLayout;)V", "footerContainer", "getFooterContainer", "setFooterContainer", "headerContainer", "getHeaderContainer", "setHeaderContainer", "hideFirstFrame", "", "mClearDimFlag", "getMClearDimFlag", "()Z", "setMClearDimFlag", "(Z)V", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "widthMode", "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "getWidthMode", "()Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "setWidthMode", "(Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;)V", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "adjustContentHeight", "dismiss", "forceHideFirstFrame", "getTargetWindowDimAmount", "", "hideAndTransparentNavigationBar", "window", "Landroid/view/Window;", "needDimAnim", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "setChildToParent", "setClearDimFlag", "dim", "setContainerView", "setFooterView", "setHeaderView", "setOnApplyWindowInsetsListener", "setRootWidth", "width", "setSheetBgColor", TypedValues.Custom.S_COLOR, "", "setupView", "show", "Companion", "PanelWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheet extends Dialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14467b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14468a;
    public FrameLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public RadiusLayout f;
    private boolean g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "", "(Ljava/lang/String;I)V", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PanelWidth extends Enum<PanelWidth> {
        private static final /* synthetic */ PanelWidth[] $VALUES = null;
        public static final PanelWidth BOARD_WIDTH = null;
        public static final PanelWidth NARROW_WIDTH = null;

        private static final /* synthetic */ PanelWidth[] $values() {
            return new PanelWidth[]{NARROW_WIDTH, BOARD_WIDTH};
        }

        static {
            NARROW_WIDTH = new PanelWidth("NARROW_WIDTH", 0);
            BOARD_WIDTH = new PanelWidth("BOARD_WIDTH", 1);
            $VALUES = $values();
        }

        private PanelWidth(String r1, int r2) {
            super(r1, r2);
        }

        public static PanelWidth valueOf(String r2) {
            return (PanelWidth) ZeusTransformUtils.preCheckCast(Enum.valueOf(PanelWidth.class, r2), PanelWidth.class, "com.obric.memorydata.plugin");
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PanelWidth[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$Companion;", "", "()V", "HORIZONTAL_MAX_CONTENT_HEIGHT", "", "HORIZONTAL_MAX_HEIGHT", "HORIZONTAL_MAX_WIDTH", "TAG", "", "getMaxWidth", "context", "Landroid/content/Context;", "expected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14467b = new a(null);
    }

    private final float a(Context r2) {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r1 = false;
        goto L6
    }

    private final void a(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.setDecorFitsSystemWindows(false);
    L10:
        if (r3 == null) goto L13;
        r3.clearFlags(134217728);
    L13:
        if (r3 == null) goto L16;
        r3.addFlags(Integer.MIN_VALUE);
    L16:
        if (r3 == null) goto L19;
        r3.setNavigationBarColor(0);
    L19:
        if (r3 == null) goto L23;
        r3.setNavigationBarDividerColor(0);
        return;
    }

    private static final void a(final OInsetSheet r17) {
        Intrinsics.checkNotNullParameter(r17, "this$0");
        DialogAnimStyle r2 = DialogAnimStyle.f13797a;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r17.d(), View.class, "com.obric.memorydata.plugin");
        Window r4 = r17.getWindow();
        boolean r5 = r17.i();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        b r6 = b.a(DialogAnimStyle.a(r2, r3, r4, r5, r17.a(r1), false, 8, null), null, null, (Function1) ZeusTransformUtils.preCheckCast(OInsetSheet$performEnterAnimation$1$anim$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 3, null);
        if (r17.g == false) goto L5;
        b.a(r6, (Function1) ZeusTransformUtils.preCheckCast(new OInsetSheet$performEnterAnimation$1$1(r17), Function1.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    L5:
        r6.b();
    }

    private final void b(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (j.f13505a.a(r8) == false) goto L13;
        d().measure(0, 0);     // Catch: Exception -> L8
        int r4 = ((h.a(r8, 296) - com.obric.oui.window.a.f14878a.b(r8)) - a().getMeasuredHeight()) - b().getMeasuredHeight();     // Catch: Exception -> L8
        c().measure(View.MeasureSpec.makeMeasureSpec(h.a(r8, UploadKeys.KeyIsEnd2EndEncryptionPublicKey), Integer.MIN_VALUE), 0);     // Catch: Exception -> L8
        int r1 = c().getMeasuredHeight();     // Catch: Exception -> L8
        int r9 = RangesKt.coerceIn(r4, 0, h.a(r8, 244));     // Catch: Exception -> L8
        if (r1 <= r9) goto L14;
        com.obric.oui.c.a.b.c("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r1 + ", final contentHeight: " + r9);     // Catch: Exception -> L8
        FrameLayout r2 = c();     // Catch: Exception -> L8
        ViewGroup.LayoutParams r6 = c().getLayoutParams();     // Catch: Exception -> L8
        r6.height = r9;     // Catch: Exception -> L8
        r2.setLayoutParams(r6);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        com.obric.oui.c.a.b.a("OInsetSheet", "adjustContentHeight error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final boolean i() {
        return !this.f14468a;
    }

    public static /* synthetic */ void lambda$V8N9g4QUxGh9Q8a2GMtlIWa390c(OInsetSheet r0) {
        a(r0);
    }

    public final FrameLayout a() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    public final FrameLayout b() {
        FrameLayout r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    public final FrameLayout c() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final RadiusLayout d() {
        RadiusLayout r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        g();
    }

    public final boolean e() {
        return this.f14468a;
    }

    public final void f() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public void g() {
        b r0 = DialogAnimStyle.a(DialogAnimStyle.f13797a, (View) ZeusTransformUtils.preCheckCast(d(), View.class, "com.obric.memorydata.plugin"), getWindow(), i(), false, 4, null);
        b.a(r0, null, (Function1) ZeusTransformUtils.preCheckCast(new OInsetSheet$performExitAnimation$1$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OInsetSheet$performExitAnimation$1$2(this), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        r0.b();
    }

    public final void h() {
        d().post(new $$Lambda$OInsetSheet$V8N9g4QUxGh9Q8a2GMtlIWa390c(this));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.g == false) goto L6;
        d().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        h();
    }

    @Override // android.app.Dialog
    public void show() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        b(r0);
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L21;
        r1.setBackgroundDrawableResource(R.color.transparent);
        a(r1);
        if (e() == false) goto L8;
        r1.clearFlags(2);
    L10:
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        float r3 = 0.5f;
    L16:
        WindowManager.LayoutParams r4 = r1.getAttributes();
        if (i() == true) goto L19;
        r4.dimAmount = r3;
    L19:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r4.gravity = 80;
        r1.setAttributes(r4);
        return;
    L15:
        r3 = 0.16f;
        goto L16
    L12:
        r2 = false;
        goto L13
    L8:
        r1.addFlags(2);
        goto L10
    }
}
