package com.obric.oui.dialog.alert;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.j;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.ss.bduploader.UploadKeys;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u0004\u0018\u00010\u0014J\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010'\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010!J\b\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u0004\u0018\u00010\u0014J\u0012\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u0017H\u0014J\u0006\u0010/\u001a\u00020\u0017J\b\u00100\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\u0017H\u0016J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020\u00172\u0006\u00103\u001a\u00020\rJ\u0018\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020!2\b\b\u0002\u00107\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020!J\u000e\u0010:\u001a\u00020\u00172\u0006\u00109\u001a\u00020!J\u000e\u0010;\u001a\u00020\u00172\u0006\u00103\u001a\u00020\rJ\b\u0010<\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/oui/dialog/alert/OAlertDialog;", "Lcom/obric/oui/dialog/base/AbstractDialog;", "context", "Landroid/content/Context;", "widthMatch", "", "withHeightMatchParent", "(Landroid/content/Context;ZZ)V", "TAG", "", "bodyPanel", "Landroid/widget/FrameLayout;", "bodyStyleController", "Lcom/obric/oui/dialog/alert/StyleController;", "buttonPanel", "buttonStyleController", "iconPanel", "iconStyleController", "messageMoreThanTwoLines", "messageTextView", "Landroid/widget/TextView;", "titleTextView", "adjustContentHeight", "", "allowMoreThanTwoLinesMessage", "cancelCountDown", "dismiss", "getBodyMarginSpace", "", "getButtonVerticalSpace", "getIconPanelVerticalSpace", "getLayout", "getMessageStr", "", "getMessageVerticalSpace", "getMessageView", "getNegativeButton", "Lcom/obric/oui/button/OButton;", "getNeutralButton", "getPositiveButton", "getTitleStr", "getTitleVerticalSpace", "getTitleView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "setBodyStyleController", "controller", "setButtonStyleController", "setMessage", "message", "moreThanTwoLines", "setOnlyTitleText", "title", "setTitleText", "setTopImageStyleController", "show", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class b extends AbstractDialog {
    private final String d;
    private FrameLayout e;
    private e f;
    private TextView g;
    private TextView h;
    private FrameLayout i;
    private e j;
    private FrameLayout k;
    private e l;

    public b(Context r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r6, r7);
        this.d = "OAlertDialog";
        this.e = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iconPanel, OaidModel.KEY_ID, "iconPanel")), FrameLayout.class, "com.obric.memorydata.plugin");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textTitle, OaidModel.KEY_ID, "textTitle")), TextView.class, "com.obric.memorydata.plugin");
        OTextView r0 = null;
        if (r9 != null) goto L6;
        r9 = null;
    L12:
        this.g = r9;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.textSubTitle, OaidModel.KEY_ID, "textSubTitle"));
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OTextView.class) == false) goto L15;
        r0 = (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.memorydata.plugin");
    L15:
        if (r0 == null) goto L18;
        r0.setEnableAutoAlignLeft(true);
    L18:
        this.h = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
        this.i = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.button_container, OaidModel.KEY_ID, "button_container")), FrameLayout.class, "com.obric.memorydata.plugin");
        this.k = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.body_container, OaidModel.KEY_ID, "body_container")), FrameLayout.class, "com.obric.memorydata.plugin");
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OTextView.class) == false) goto L8;
        OTextView r3 = (OTextView) ZeusTransformUtils.preCheckCast(r9, OTextView.class, "com.obric.memorydata.plugin");
    L9:
        if (r3 == null) goto L12;
        r3.setEnableAutoAlignLeft(true);
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    private static final void a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        TextView r0 = r2.h;
        if (r0 == null) goto L9;
        Layout r1 = r0.getLayout();
        if (r1 == null) goto L9;
        r1.getLineCount();
    L9:
        TextView r3 = r2.h;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public static /* synthetic */ void a(b r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = false;
    L7:
        r2.a(r7, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    private final void b(Context r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        FrameLayout r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L8;
        return;
    L8:
        if (j.f13505a.a(r15) == false) goto L25;
        int r2 = com.obric.oui.window.a.f14878a.b(r15);     // Catch: Exception -> L19
        if (h() == false) goto L12;
        r2 = r2 - h.a(r15, 16);     // Catch: Exception -> L19
    L12:
        int r3 = u();     // Catch: Exception -> L19
        int r4 = v();     // Catch: Exception -> L19
        int r5 = w();     // Catch: Exception -> L19
        int r6 = x();     // Catch: Exception -> L19
        int r7 = y();     // Catch: Exception -> L19
        int r8 = h.b(r15);     // Catch: Exception -> L19
        int r9 = h.a(r15, 300);     // Catch: Exception -> L19
        int r10 = h.a(r15, UploadKeys.KeyIsEnd2EndEncryptionPublicKey);     // Catch: Exception -> L19
        if (r8 <= r9) goto L15;
        r9 = r8 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L19
    L15:
        int r11 = (((((r9 - r2) - r3) - r4) - r5) - r6) - r7;     // Catch: Exception -> L19
        int r16 = RangesKt.coerceIn(r11, 0, r9 - h.a(r15, 52));     // Catch: Exception -> L19
        r0.measure(View.MeasureSpec.makeMeasureSpec(r10, Integer.MIN_VALUE), 0);     // Catch: Exception -> L19
        int r12 = r0.getMeasuredHeight();     // Catch: Exception -> L19
        com.obric.oui.c.a.b.b(this.d, "adjustContentHeight, maxHeight: " + r9 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r11 + ", measured BodyHeight: " + r12 + ", maxBodyHeight: " + r16 + ", iconPanelVerticalSpace: " + r3 + ", titleVerticalSpace: " + r4 + ", messageVerticalSpace: " + r5 + ", buttonVerticalSpace: " + r6 + ", bodyMarginSpace: " + r7);     // Catch: Exception -> L19
        if (r12 <= r16) goto L26;
        com.obric.oui.c.a.b.c(this.d, "adjustContentHeight, from: " + r12 + " to: " + r16);     // Catch: Exception -> L19
        ViewGroup.LayoutParams r13 = r0.getLayoutParams();     // Catch: Exception -> L19
        r13.height = r16;     // Catch: Exception -> L19
        r0.setLayoutParams(r13);     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        com.obric.oui.c.a.b.a(this.d, "adjustContentHeight error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void b(final b r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.f13797a;
        View r2 = r10.j();
        Window r3 = r10.getWindow();
        boolean r4 = !r10.l();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        com.obric.oui.animation.easy.b r5 = DialogAnimStyle.a(r1, r2, r3, r4, r10.a(r0), false, 8, null).b();
        if (r10.k() == false) goto L5;
        r5.a((Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$1(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$2(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$3(r10), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        com.obric.oui.animation.easy.b.a(r5, null, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$4(r10), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performEnterAnimation$1$5(r10), Function1.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static /* synthetic */ void lambda$vnSXWtfK6gyr83B7bm4mYnx4nnc(b r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$xKYkqCXkWlAwR_yMRpts0JruFtE(b r0) {
        b(r0);
    }

    private final int u() {
        FrameLayout r0 = this.e;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.e;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.e;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.c.c r5 = com.obric.oui.c.c.f13403a;
        FrameLayout r6 = this.e;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int v() {
        TextView r0 = this.g;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        TextView r2 = this.g;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.g;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.c.c r5 = com.obric.oui.c.c.f13403a;
        TextView r6 = this.g;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int w() {
        TextView r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        TextView r2 = this.h;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.h;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.c.c r5 = com.obric.oui.c.c.f13403a;
        TextView r6 = this.h;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int x() {
        FrameLayout r0 = this.i;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.i;
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.i;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.c.c r5 = com.obric.oui.c.c.f13403a;
        FrameLayout r6 = this.i;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int y() {
        if (this.k != null) goto L5;
        return 0;
    L5:
        com.obric.oui.c.c r0 = com.obric.oui.c.c.f13403a;
        FrameLayout r3 = this.k;
        Intrinsics.checkNotNull(r3);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L9;
    L7:
        r4 = null;
    L10:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        return 0;
    L14:
        return r5.topMargin;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        goto L7
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int a() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog, "layout", "o_alert_dialog");
    }

    public final void a(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.f = r5;
        FrameLayout r0 = this.e;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        r5.a(r3, r0);
        return;
    }

    public final void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "title");
        TextView r2 = this.g;
        if (r2 == null) goto L7;
        r2.setVisibility(0);
        r2.setText(r4);
        r2.setPadding(0, 0, 0, 0);
        return;
    }

    public final void a(CharSequence r2, boolean r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "message");
        TextView r5 = this.h;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
        r5.setText(r4);
    L6:
        TextView r1 = this.h;
        if (r1 == null) goto L11;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void b() {
        TextView r1 = this.h;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void b(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "controller");
        this.j = r5;
        FrameLayout r0 = this.i;
        if (r0 == null) goto L7;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        r5.a(r3, r0);
        return;
    }

    public final void b(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "title");
        TextView r4 = this.g;
        if (r4 == null) goto L7;
        r4.setVisibility(0);
        r4.setText(r6);
        r4.setPadding(0, h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 19), 0, h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 19));
        return;
    }

    public void c() {
        com.obric.oui.animation.easy.b r0 = DialogAnimStyle.a(DialogAnimStyle.f13797a, j(), getWindow(), !l(), false, 4, null);
        com.obric.oui.animation.easy.b.a(r0, null, (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performExitAnimation$1$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OAlertDialog$performExitAnimation$1$2(this), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        r0.b();
    }

    public final void c(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "controller");
        this.l = r6;
        FrameLayout r0 = this.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (i() == false) goto L8;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = 0;
        r0.setLayoutParams(r2);
    L8:
        r0.setVisibility(0);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        r6.a(r4, r0);
    }

    public void d() {
        j().post(new $$Lambda$b$xKYkqCXkWlAwR_yMRpts0JruFtE(this));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        c();
    }

    public final void e() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final OButton f() {
        e r0 = this.j;
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, ButtonStyleController.class) == false) goto L8;
        e r3 = this.j;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        return ((ButtonStyleController) ZeusTransformUtils.preCheckCast(r3, ButtonStyleController.class, "com.obric.memorydata.plugin")).a();
    L8:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.memorydata.plugin");
    }

    public final OButton g() {
        e r0 = this.j;
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, ButtonStyleController.class) == false) goto L8;
        e r3 = this.j;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        return ((ButtonStyleController) ZeusTransformUtils.preCheckCast(r3, ButtonStyleController.class, "com.obric.memorydata.plugin")).b();
    L8:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.memorydata.plugin");
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        if (k() == false) goto L5;
        j().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        e r4 = this.f;
        if (r4 == null) goto L9;
        r4.a(this);
    L9:
        e r5 = this.j;
        if (r5 == null) goto L13;
        r5.a(this);
    L13:
        e r6 = this.l;
        if (r6 == null) goto L18;
        r6.a(this);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        d();
        if (ZeusTransformUtils.instanceOf(this.j, ButtonStyleController.class) == false) goto L5;
        e r0 = this.j;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        ((ButtonStyleController) ZeusTransformUtils.preCheckCast(r0, ButtonStyleController.class, "com.obric.memorydata.plugin")).c();
    L5:
        TextView r1 = this.h;
        if (r1 == null) goto L10;
        r1.postDelayed(new $$Lambda$b$vnSXWtfK6gyr83B7bm4mYnx4nnc(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        b(r0);
    }
}
