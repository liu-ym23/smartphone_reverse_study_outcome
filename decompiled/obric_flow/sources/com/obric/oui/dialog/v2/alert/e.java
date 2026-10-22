package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ai.event.MessageIndication;
import com.obric.oui.dialog.base.AbstractDialog$CloseIconStyle;
import com.obric.oui.dialog.base.AbstractDialogModal$CloseIconStyle;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController$TextColorType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.obric.oui.dialog.base.e {
    public final Context f;
    public CharSequence g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f13158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f13160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f13161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f13162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DialogInterface.OnClickListener f13163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ButtonStyleController$TextColorType f13164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13165o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DialogInterface.OnClickListener f13166p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ButtonStyleController$TextColorType f13167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13168r;
    public boolean s;

    public e(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f13118c = true;
        this.d = AbstractDialog$CloseIconStyle.DARK;
        this.e = TuplesKt.to(null, null);
        this.f = r5;
        this.f13161k = "";
        this.s = true;
        this.f13118c = false;
    }

    public static void f(e r5, String r10, DialogInterface.OnClickListener r11) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        r5.f13162l = r10;
        r5.f13163m = r11;
        r5.f13164n = null;
    }

    public static void h(e r5, String r10, DialogInterface.OnClickListener r11) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, MessageIndication.CONTENT_TYPE_TEXT);
        r5.f13165o = r10;
        r5.f13166p = r11;
        r5.f13167q = null;
    }

    @Override // com.obric.oui.dialog.base.e
    public final b b() {
        Context r5 = this.f;
        Intrinsics.checkNotNullParameter(r5, "context");
        final b r10 = new b(r5);
        int r11 = 0;
        if (this.f13159i == false) goto L11;
        CharSequence r12 = this.g;
        if (r12 == null) goto L28;
        TextView r13 = r10.f13150v;
        if (r13 == null) goto L28;
        r13.setVisibility(0);
        r13.setText(r12);
        r13.setPadding(0, com.lynx.tasm.utils.a.B(19, r13), 0, com.lynx.tasm.utils.a.B(19, r13));
    L28:
        String r14 = this.f13158h;
        Function1<CharSequence, Unit> r15 = new OAlertDialogBuilder$createDialog$1(r10, this);
        if (TextUtils.isEmpty(r14) == true) goto L31;
        Intrinsics.checkNotNull(r14);
        r15.invoke(r14);
    L31:
        com.lynx.animax.player.b r16 = d();
        if (r16 == null) goto L35;
        Intrinsics.checkNotNullParameter(r16, "controller");
        r10.f13149u = r16;
        r16.a(r10.getContext(), r10);
    L35:
        r10.e = this.s;
        nr.e r17 = new nr.e(r5);
        Intrinsics.checkNotNullParameter(r17, "controller");
        r10.f13153y = r17;
        r17.a(r10.getContext(), r10);
        this.f13117b = null;
        r10.setOnShowListener(null);
        r10.setOnDismissListener(this.f13116a);
        r10.setOnCancelListener(null);
        r17.e(this.f13165o, this.f13166p, this.f13167q, this.f13168r);
        r17.c(this.f13162l, this.f13163m, this.f13164n);
        r17.d();
        return r10;
    L11:
        CharSequence r18 = this.g;
        boolean r19 = TextUtils.isEmpty(r18);
        TextView r20 = r10.f13150v;
        if (r20 == null) goto L18;
        if (r19 == false) goto L16;
        int r21 = 8;
    L17:
        r20.setVisibility(r21);
        r20.setText(r18);
        r20.setPadding(0, 0, 0, 0);
        goto L18
    L16:
        r21 = 0;
    L18:
        TextView r22 = r10.f13151w;
        if (r22 == null) goto L28;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L38;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r19 == true) goto L27;
        r11 = com.lynx.tasm.utils.a.B(8, r22);
    L27:
        r24.topMargin = r11;
        goto L28
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final f c() {
        Context r5 = this.f;
        Intrinsics.checkNotNullParameter(r5, "context");
        final f r10 = new f(r5);
        if (this.f13159i == false) goto L5;
        r10.setOnlyTitleText(this.g);
    L6:
        String r11 = this.f13158h;
        Function1<CharSequence, Unit> r12 = new OAlertDialogBuilder$buildModal$1(r10, this);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        Intrinsics.checkNotNull(r11);
        r12.invoke(r11);
    L9:
        com.lynx.animax.player.b r13 = d();
        if (r13 == null) goto L13;
        r10.setTopImageStyleController(r13);
    L13:
        r10.setCompleteShowListener(null);
        r10.setAutoDismiss(this.s);
        r10.d(this.f13117b);
        r10.setCancelable(this.f13118c);
        int r14 = d.f13157a[this.d.ordinal()];
        if (r14 != 1) goto L16;
        AbstractDialogModal$CloseIconStyle r15 = AbstractDialogModal$CloseIconStyle.DARK;
    L24:
        Pair r16 = this.e;
        Integer r17 = (Integer) r16.getFirst();
        Integer r18 = (Integer) r16.getSecond();
        Intrinsics.checkNotNullParameter(r15, "style");
        nr.e r19 = new nr.e(r5);
        r10.setButtonStyleController(r19);
        r10.d(this.f13117b);
        r10.setIncludeCutoutInLandscape(null);
        r10.setOnShowListener(null);
        r10.setOnDismissListener(this.f13116a);
        r10.setOnCancelListener(null);
        r19.e(this.f13165o, this.f13166p, this.f13167q, this.f13168r);
        r19.c(this.f13162l, this.f13163m, this.f13164n);
        r19.d();
        return r10;
    L16:
        if (r14 != 2) goto L18;
        r15 = AbstractDialogModal$CloseIconStyle.LIGHT;
        goto L24
    L18:
        if (r14 != 3) goto L21;
        r15 = AbstractDialogModal$CloseIconStyle.CUSTOM;
        goto L24
    L21:
        throw new NoWhenBranchMatchedException();
    L5:
        r10.setTitleText(this.g);
        goto L6
    }

    public final com.lynx.animax.player.b d() {
        this.f13161k.getClass();
        Drawable r5 = this.f13160j;
        if (r5 != null) goto L6;
        return null;
    L6:
        com.lynx.animax.player.b r10 = new com.lynx.animax.player.b(this.f);
        Intrinsics.checkNotNullParameter(r5, "drawable");
        r10.f9658c = r5;
        return r10;
    }

    public final void e(String r5, DialogInterface.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        f(this, r5, r10);
    }

    public final void g(String r5, DialogInterface.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        h(this, r5, r10);
    }
}
