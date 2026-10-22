package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusDialogSpanableBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00100\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/common_ui/dialog/SpanableDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogSpanableBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mBottomIndividualText", "mScrollViewHeight", "", "mConfirmText", "mConfirmTextColor", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mSpannaleClickListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "mMessageTestStyle", "Lcom/larus/common_ui/dialog/SpannableDialogMessageTextStyleConfig;", "mConfirmTextStyle", "Lcom/larus/common_ui/dialog/SpannableDialogButtonTextStyleConfig;", "mCancelTextStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onResume", "setUpMessageTextStyle", "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupView", "Companion", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpanableDialog extends DialogFragment {
    public static final /* synthetic */ int r = 0;
    public LarusDialogSpanableBinding d;
    public String e;
    public final boolean f;
    public CharSequence g;
    public CharSequence h;
    public int i;
    public String j;
    public p0 k;
    public String l;
    public u m;
    public k1 n;
    public j1 o;
    public i1 p;
    public i1 q;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
    }

    public SpanableDialog() {
        this.e = "";
        this.f = true;
        this.g = "";
        this.h = "";
        this.i = -1;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        System.currentTimeMillis();
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r2.width = r4;
        if (r4 <= i5.L()) goto L9;
        r2.width = i5.L();
    L9:
        r1.setAttributes(r2);
    L10:
        Dialog r5 = getDialog();
        if (r5 == null) goto L14;
        r5.setOnKeyListener(new b());
        return;
    }

    public static void S90(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        System.currentTimeMillis();
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        System.currentTimeMillis();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        LarusDialogSpanableBinding r9 = this.d;
        LarusDialogSpanableBinding r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        r9.f.setText(this.e);
        LarusDialogSpanableBinding r11 = this.d;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L8:
        AppCompatTextView r12 = r11.e;
        if (this.f == false) goto L11;
        int r1 = 0;
    L12:
        r12.setVisibility(r1);
        LarusDialogSpanableBinding r13 = this.d;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L15:
        r13.e.setUrlSpannedText(String.valueOf(this.g));
        LarusDialogSpanableBinding r14 = this.d;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L18:
        r14.e.setOnClickListener(new g1(this));
        if (this.i <= 0) goto L25;
        LarusDialogSpanableBinding r15 = this.d;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L23:
        r15.g.getLayoutParams().height = this.i;
    L25:
        if ((this.g instanceof SpannableString) == false) goto L33;
        LarusDialogSpanableBinding r16 = this.d;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L29:
        r16.e.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableBinding r17 = this.d;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L32:
        r17.e.setHighlightColor(0);
    L33:
        String r18 = this.j;
        boolean r2 = true;
        if (r18 != null) goto L36;
    L39:
        boolean r20 = true;
    L40:
        if (r20 == true) goto L45;
        LarusDialogSpanableBinding r21 = this.d;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L44:
        r21.d.setText(this.j);
    L45:
        Context r22 = getContext();
        if (r22 == null) goto L51;
        LarusDialogSpanableBinding r3 = this.d;
        if (r3 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L50:
        r3.d.setTextColor(ContextCompat.getColor(r22, v19.c.b(2130972123, r22, 2131103203)));
    L51:
        LarusDialogSpanableBinding r23 = this.d;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L54:
        r23.d.setOnClickListener(new e1(this));
        String r24 = this.l;
        if (r24 != null) goto L57;
    L60:
        boolean r25 = true;
    L61:
        if (r25 == true) goto L66;
        LarusDialogSpanableBinding r26 = this.d;
        if (r26 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L65:
        r26.c.setText(this.l);
    L66:
        LarusDialogSpanableBinding r27 = this.d;
        if (r27 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L69:
        r27.c.setOnClickListener(new f1(this));
        CharSequence r28 = this.h;
        if (r28 != null) goto L72;
    L75:
        if (r2 == true) goto L92;
        LarusDialogSpanableBinding r30 = this.d;
        if (r30 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L79:
        r30.b.setVisibility(0);
        LarusDialogSpanableBinding r31 = this.d;
        if (r31 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L82:
        r31.b.setUrlSpannedText(String.valueOf(this.h));
        LarusDialogSpanableBinding r32 = this.d;
        if (r32 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L85:
        r32.b.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableBinding r33 = this.d;
        if (r33 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L88:
        r33.b.setHighlightColor(0);
        LarusDialogSpanableBinding r34 = this.d;
        if (r34 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L91:
        r34.b.setOnClickListener(new h1(this));
    L92:
        j1 r35 = this.o;
        if (r35 == null) goto L132;
        Integer r4 = r35.a;
        if (r4 == null) goto L100;
        int r5 = r4.intValue();
        LarusDialogSpanableBinding r6 = this.d;
        if (r6 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L99:
        r6.e.setTextSize(r5);
    L100:
        Integer r36 = r35.b;
        if (r36 == null) goto L110;
        int r37 = r36.intValue();
        LarusDialogSpanableBinding r38 = this.d;
        if (r38 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L105:
        AppCompatTextView r40 = r38.e;
        Context r41 = getContext();
        if (r41 == null) goto L108;
        ColorStateList r42 = AppCompatResources.getColorStateList(r41, r37);
    L109:
        r40.setTextColor(r42);
        goto L110
    L108:
        r42 = null;
    L110:
        Typeface r43 = r35.c;
        if (r43 == null) goto L116;
        LarusDialogSpanableBinding r44 = this.d;
        if (r44 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r44 = null;
    L115:
        r44.e.setTypeface(r43);
    L116:
        Integer r45 = r35.d;
        if (r45 == null) goto L126;
        int r46 = r45.intValue();
        Context r47 = getContext();
        if (r47 == null) goto L126;
        ColorStateList r48 = AppCompatResources.getColorStateList(r47, r46);
        if (r48 == null) goto L126;
        LarusDialogSpanableBinding r50 = this.d;
        if (r50 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L125:
        r50.e.setUrlTextColor(r48);
    L126:
        Integer r51 = r35.e;
        if (r51 == null) goto L132;
        int r52 = r51.intValue();
        LarusDialogSpanableBinding r53 = this.d;
        if (r53 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r53 = null;
    L131:
        r53.e.setGravity(r52);
    L132:
        i1 r54 = this.p;
        if (r54 == null) goto L156;
        Integer r55 = r54.a;
        if (r55 == null) goto L140;
        int r56 = r55.intValue();
        LarusDialogSpanableBinding r57 = this.d;
        if (r57 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r57 = null;
    L139:
        r57.d.setTextSize(r56);
    L140:
        Integer r58 = r54.b;
        if (r58 == null) goto L150;
        int r60 = r58.intValue();
        LarusDialogSpanableBinding r61 = this.d;
        if (r61 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r61 = null;
    L145:
        TextView r62 = r61.d;
        Context r63 = getContext();
        if (r63 == null) goto L148;
        ColorStateList r64 = AppCompatResources.getColorStateList(r63, r60);
    L149:
        r62.setTextColor(r64);
        goto L150
    L148:
        r64 = null;
    L150:
        Typeface r65 = r54.c;
        if (r65 == null) goto L156;
        LarusDialogSpanableBinding r66 = this.d;
        if (r66 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r66 = null;
    L155:
        r66.d.setTypeface(r65);
    L156:
        i1 r67 = this.q;
        if (r67 == null) goto L181;
        Integer r68 = r67.a;
        if (r68 == null) goto L164;
        int r70 = r68.intValue();
        LarusDialogSpanableBinding r71 = this.d;
        if (r71 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r71 = null;
    L163:
        r71.c.setTextSize(r70);
    L164:
        Integer r72 = r67.b;
        if (r72 == null) goto L174;
        int r73 = r72.intValue();
        LarusDialogSpanableBinding r74 = this.d;
        if (r74 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r74 = null;
    L169:
        TextView r75 = r74.c;
        Context r76 = getContext();
        if (r76 == null) goto L172;
        ColorStateList r77 = AppCompatResources.getColorStateList(r76, r73);
    L173:
        r75.setTextColor(r77);
        goto L174
    L172:
        r77 = null;
    L174:
        Typeface r78 = r67.c;
        if (r78 == null) goto L181;
        LarusDialogSpanableBinding r80 = this.d;
        if (r80 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L180:
        r10.c.setTypeface(r78);
        goto L181
    L179:
        r10 = r80;
    L181:
        Dialog r81 = getDialog();
        if (r81 == null) goto L185;
        r81.setCanceledOnTouchOutside(false);
        return;
    L185:
        return;
    L72:
        if (r28.length() == 0) goto L75;
        r2 = false;
        goto L75
    L57:
        if (r24.length() == 0) goto L60;
        r25 = false;
        goto L61
    L36:
        if (r18.length() == 0) goto L39;
        r20 = false;
        goto L40
    L11:
        r1 = 8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562103, r11, false);
        int r14 = 2131364471;
        UrlSpanTextView r3 = (UrlSpanTextView) ViewBindings.findChildViewById(r13, 2131364471);
        if (r3 == null) goto L25;
        r14 = 2131365114;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131365114);
        if (r4 == null) goto L25;
        r14 = 2131367639;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131367639);
        if (r5 == null) goto L25;
        r14 = 2131368971;
        UrlSpanTextView r6 = (UrlSpanTextView) ViewBindings.findChildViewById(r13, 2131368971);
        if (r6 == null) goto L25;
        r14 = 2131368982;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131368982);
        if (r7 == null) goto L25;
        r14 = 2131385224;
        ScrollView r8 = (ScrollView) ViewBindings.findChildViewById(r13, 2131385224);
        if (r8 == null) goto L25;
        this.d = new LarusDialogSpanableBinding(r13, r3, r4, r5, r6, r7, r8);
        Dialog r15 = getDialog();
        if (r15 == null) goto L19;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L19;
        r16.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        LarusDialogSpanableBinding r17 = this.d;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L23:
        return r17.a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
