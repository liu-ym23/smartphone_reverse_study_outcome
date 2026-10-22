package com.obric.oui.dialog.alert;

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
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 *2\u00020\u0001:\u0003)*+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0010J&\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J&\u0010#\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J.\u0010$\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0012H\u0002J\u0016\u0010(\u001a\u00020\u0012*\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController;", "Lcom/obric/oui/dialog/alert/StyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "customButtonViewContainer", "Landroid/widget/FrameLayout;", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "negativeButton", "Lcom/obric/oui/button/OButton;", "neutralButton", "positiveButton", "rootView", "Landroid/view/View;", "attachToDialog", "", "attachToParent", "parent", "cancelCountDown", "getNegativeButton", "getNeutralButton", "getPositiveButton", "onStart", "setCustomNegativeButton", "view", "setNegativeButton", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "listener", "Landroid/content/DialogInterface$OnClickListener;", "textColorType", "Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "setNeutralButton", "setPositiveButton", "positiveButtonBgPrimary", "", "tryDismiss", "setTextColor", "ButtonStyle", "Companion", "TextColorType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ButtonStyleController implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13790b;
    private final int c;
    private OButton d;
    private OButton e;
    private OButton f;
    private com.obric.oui.dialog.alert.b g;
    private View h;
    private FrameLayout i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        private static final /* synthetic */ TextColorType[] $values() {
            return new TextColorType[]{TextReverse, TextReverse2, Negative};
        }

        static {
            TextReverse = new TextColorType("TextReverse", 0);
            TextReverse2 = new TextColorType("TextReverse2", 1);
            Negative = new TextColorType("Negative", 2);
            $VALUES = $values();
        }

        private TextColorType(String r1, int r2) {
            super(r1, r2);
        }

        public static TextColorType valueOf(String r2) {
            return (TextColorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextColorType.class, r2), TextColorType.class, "com.obric.memorydata.plugin");
        }

        public static TextColorType[] values() {
            return (TextColorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextColorType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/alert/ButtonStyleController$Companion;", "", "()V", "HORIZONTAL", "", "PRIMARY", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13791a = null;

        static {
            int[] r0 = new int[TextColorType.values().length];
            r0[TextColorType.Negative.ordinal()] = 1;
            r0[TextColorType.TextReverse.ordinal()] = 2;
            r0[TextColorType.TextReverse2.ordinal()] = 3;
            f13791a = r0;
        }
    }

    static {
        f13789a = new a(null);
    }

    public ButtonStyleController(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13790b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
    }

    private final void a(OButton r3, TextColorType r4) {
        if (r4 == null) goto L16;
        int r2 = b.f13791a[r4.ordinal()];
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

    private static final void a(ButtonStyleController r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        com.obric.oui.dialog.alert.b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -1);
    L8:
        r2.d();
        return;
    }

    private static final void b(ButtonStyleController r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        com.obric.oui.dialog.alert.b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -2);
    L8:
        r2.d();
        return;
    }

    private static final void c(ButtonStyleController r2, DialogInterface.OnClickListener r3, View r4) {
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        com.obric.oui.dialog.alert.b r6 = r2.g;
        if (r6 == null) goto L10;
        if (r5 == null) goto L8;
        r5.onClick((DialogInterface) ZeusTransformUtils.preCheckCast(r6, DialogInterface.class, "com.obric.memorydata.plugin"), -3);
    L8:
        r2.d();
        return;
    }

    private final void d() {
        com.obric.oui.dialog.alert.b r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        com.obric.oui.dialog.alert.b r2 = this.g;
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

    public static /* synthetic */ void lambda$GSksFnEhzVT_XSBNyXQxr_4VLWE(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$_TNTMr0Z2gl_mI9U15VvnzuPRjI(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        c(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$ciFWY8taUw9JYVnZP9Lq46PEULE(ButtonStyleController r0, DialogInterface.OnClickListener r1, View r2) {
        a(r0, r1, r2);
    }

    public final OButton a() {
        return this.d;
    }

    @Override // com.obric.oui.dialog.alert.e
    public void a(Context r6, FrameLayout r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r7, "parent");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r2 = this.c;
        if (r2 != 0) goto L5;
        int r3 = R.layout.o_dialog_button_horizontal;
        String r4 = "o_dialog_button_horizontal";
    L9:
        int r5 = ZeusTransformUtils.mapRes(r3, "layout", r4);
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), r5, (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        r7.addView(r9, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.h = r9;
        if (r9 == null) goto L13;
        r9.setVisibility(8);
    L13:
        this.d = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionPositive, OaidModel.KEY_ID, "actionPositive")), OButton.class, "com.obric.memorydata.plugin");
        this.e = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionNegative, OaidModel.KEY_ID, "actionNegative")), OButton.class, "com.obric.memorydata.plugin");
        this.f = (OButton) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.actionNeutral, OaidModel.KEY_ID, "actionNeutral")), OButton.class, "com.obric.memorydata.plugin");
        this.i = (FrameLayout) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.custom_container, OaidModel.KEY_ID, "custom_container")), FrameLayout.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r2 == 1) goto L7;
        r3 = R.layout.o_dialog_button_primary;
        r4 = "o_dialog_button_primary";
        goto L9
    L7:
        r3 = R.layout.o_dialog_button_vertical;
        r4 = "o_dialog_button_vertical";
        goto L9
    }

    public final void a(View r3) {
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

    @Override // com.obric.oui.dialog.alert.e
    public void a(com.obric.oui.dialog.alert.b r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        this.g = r2;
    }

    public final void a(CharSequence r4, DialogInterface.OnClickListener r5, TextColorType r6) {
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
        r0.setOnClickListener(new $$Lambda$ButtonStyleController$GSksFnEhzVT_XSBNyXQxr_4VLWE(this, r8));
    }

    public final void a(CharSequence r6, DialogInterface.OnClickListener r7, TextColorType r8, boolean r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        final DialogInterface.OnClickListener r11 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r7, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        OButton r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        View r1 = this.h;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
    L13:
        if (r9 == false) goto L15;
        r0.setBackgroundTintList(ContextCompat.getColorStateList(this.f13790b, ZeusTransformUtils.mapRes(R.color.oui_red_6, TypedValues.Custom.S_COLOR, "oui_red_6")));
        r0.setTextColor(ContextCompat.getColor(this.f13790b, ZeusTransformUtils.mapRes(R.color.white, TypedValues.Custom.S_COLOR, "white")));
    L15:
        r0.setText(r10);
        a(r0, r8);
        r0.setVisibility(0);
        r0.setOnClickListener(new $$Lambda$ButtonStyleController$ciFWY8taUw9JYVnZP9Lq46PEULE(this, r11));
    }

    public final OButton b() {
        return this.e;
    }

    public final void b(CharSequence r4, DialogInterface.OnClickListener r5, TextColorType r6) {
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
        r0.setOnClickListener(new $$Lambda$ButtonStyleController$_TNTMr0Z2gl_mI9U15VvnzuPRjI(this, r8));
    }

    public final void c() {
    }
}
