package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.h;
import com.obric.oui.common.util.o;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0012H\u0016J&\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J.\u0010)\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0014H\u0002J\u0016\u0010-\u001a\u00020\u0014*\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/DefaultButtonStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "getContext", "()Landroid/content/Context;", "customButtonViewContainer", "Landroid/widget/FrameLayout;", "host", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "negativeButton", "Lcom/obric/oui/button/OButton;", "neutralButton", "positiveButton", "rootView", "Landroid/view/View;", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialog;", "attachToHost", "attachToParent", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "getButtonContainerLayout", "getNegativeButton", "getNeutralButton", "getPositiveButton", "setCustomNegativeButton", "view", "setNegativeButton", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonWarning", "", "tryDismiss", "setTextColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class c extends ButtonStyleController {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13823b;
    private final int c;
    private OButton d;
    private OButton e;
    private OButton f;
    private b g;
    private View h;
    private FrameLayout i;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13824a = null;

        static {
            int[] r0 = new int[ButtonStyleController.TextColorType.values().length];
            r0[ButtonStyleController.TextColorType.Negative.ordinal()] = 1;
            r0[ButtonStyleController.TextColorType.TextReverse.ordinal()] = 2;
            r0[ButtonStyleController.TextColorType.TextReverse2.ordinal()] = 3;
            f13824a = r0;
        }
    }

    public c(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13823b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private final void a(OButton r3, ButtonStyleController.TextColorType r4) {
        if (r4 == null) goto L16;
        int r2 = a.f13824a[r4.ordinal()];
        if (r2 != 1) goto L6;
        int r5 = R.color.Negative;
        String r6 = "Negative";
    L14:
        int r7 = ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_COLOR, r6);
        r3.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7));
        return;
    L6:
        if (r2 != 2) goto L8;
        r5 = R.color.TextReverse;
        r6 = "TextReverse";
        goto L14
    L8:
        if (r2 != 3) goto L11;
        r5 = R.color.TextReverse2;
        r6 = "TextReverse2";
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private static final void a(c r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -1);
    L8:
        r2.g();
        return;
    }

    private static final void b(c r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -2);
    L8:
        r2.g();
        return;
    }

    private static final void c(c r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -3);
    L8:
        r2.g();
        return;
    }

    private final void g() {
        b r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        b r2 = this.g;
        if (r2 == null) goto L15;
        r2.dismiss();
        return;
    L15:
        return;
    L6:
        if (r0.t() == true) goto L8;
        r1 = true;
        goto L8
    }

    public static /* synthetic */ void lambda$FNTbmJpBJSavY7OKfsdu7qXFkxQ(c r0, DialogInterface.OnClickListener r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$PtCqp7LF6V7UWtq39QtpJ4U5CUo(c r0, DialogInterface.OnClickListener r1, View r2) {
        c(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$av6NHMKZQjIlLxRuTpNQD1TayH0(c r0, DialogInterface.OnClickListener r1, View r2) {
        b(r0, r1, r2);
    }

    public int a(int r3) {
        if (r3 == 0) goto L10;
        if (r3 == 1) goto L14;
        int r2 = R.layout.o_dialog_button_primary;
        String r4 = "o_dialog_button_primary";
    L13:
        return ZeusTransformUtils.mapRes(r2, "layout", r4);
    L14:
        return ZeusTransformUtils.mapRes(R.layout.o_dialog_button_vertical, "layout", "o_dialog_button_vertical");
    L10:
        if (h.a(ZeusTransformUtils.getResources(this.f13823b, "com.obric.memorydata.plugin").getConfiguration().fontScale) == true) goto L14;
        r2 = R.layout.o_dialog_button_horizontal;
        r4 = "o_dialog_button_horizontal";
        goto L13
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* synthetic */ View a() {
        return (View) ZeusTransformUtils.preCheckCast(d(), View.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.g
    public void a(Context r6, d r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dialogContainer");
        FrameLayout r10 = r9.getButtonSlot();
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r2 = a(this.c);
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), r2, (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        r10.addView(r11, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.h = r11;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        this.d = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, OaidModel.KEY_ID, "actionPositive")), OButton.class, "com.obric.memorydata.plugin");
        this.e = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, OaidModel.KEY_ID, "actionNegative")), OButton.class, "com.obric.memorydata.plugin");
        this.f = (OButton) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.actionNeutral, OaidModel.KEY_ID, "actionNeutral")), OButton.class, "com.obric.memorydata.plugin");
        this.i = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, OaidModel.KEY_ID, "custom_container")), FrameLayout.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.c == 2) goto L5;
        return;
    L5:
        if (this.i == null) goto L20;
        View r0 = this.h;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        FrameLayout r1 = this.i;
        if (r1 == null) goto L14;
        r1.addView(r3);
    L14:
        FrameLayout r2 = this.i;
        if (r2 == null) goto L21;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        return;
    L21:
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController, com.obric.oui.dialog.v2.alert.style.g
    public void a(AbstractDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController, com.obric.oui.dialog.v2.alert.style.g
    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "host");
        this.g = r4;
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.dialog.v2.alert.a.class) == false) goto L6;
        a((AbstractDialog) ZeusTransformUtils.preCheckCast(r4, AbstractDialog.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void a(CharSequence r4, DialogInterface.OnClickListener r5, ButtonStyleController.TextColorType r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        final DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        OButton r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r7);
        a(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$c$av6NHMKZQjIlLxRuTpNQD1TayH0(this, r8));
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void a(CharSequence r7, DialogInterface.OnClickListener r8, ButtonStyleController.TextColorType r9, boolean r10) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        final DialogInterface.OnClickListener r12 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        OButton r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r2 = this.h;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        if (r10 == false) goto L15;
        r0.setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, TypedValues.Custom.S_COLOR, "oui_basic_fill_element_2")));
        r0.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
    L15:
        r0.setText(r11);
        a(r0, r9);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$c$FNTbmJpBJSavY7OKfsdu7qXFkxQ(this, r12));
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* synthetic */ View b() {
        return (View) ZeusTransformUtils.preCheckCast(e(), View.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public void b(CharSequence r4, DialogInterface.OnClickListener r5, ButtonStyleController.TextColorType r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        final DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        OButton r0 = this.f;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        r0.setText(r7);
        a(r0, r6);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$c$PtCqp7LF6V7UWtq39QtpJ4U5CUo(this, r8));
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public /* synthetic */ View c() {
        return (View) ZeusTransformUtils.preCheckCast(f(), View.class, "com.obric.memorydata.plugin");
    }

    public OButton d() {
        return this.d;
    }

    public OButton e() {
        return this.e;
    }

    public OButton f() {
        return this.f;
    }

    public final Context getContext() {
        return this.f13823b;
    }
}
