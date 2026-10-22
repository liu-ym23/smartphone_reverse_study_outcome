package com.larus.common_ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j extends Dialog {
    public final b a;
    public WeakReference<View> b;

    public static final class a {
        public final Context a;
        public String b;
        public CharSequence c;
        public String d;
        public Integer e;
        public boolean f;
        public p0 g;
        public String h;
        public Integer i;
        public boolean j;
        public u k;
        public boolean l;
        public View m;
        public final float n;

        public final j a() {
            return new j(this.a, new b(this.b, this.c, null, this.d, null, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null, null, this.m, this.n));
        }

        public final void f() {
            Context r0 = this.a;
            if ((r0 instanceof Activity) == false) goto L5;
            Activity r1 = (Activity) r0;
        L6:
            if (r1 != null) goto L8;
        L12:
            j r2 = a();
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L19;
            DialogLancet.handleBlockedDialogShow(r2);
            return;
        L19:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L16:
            DialogLancet.beforeDialogShow(r2);
            r2.show();
            DialogLancet.afterDialogShow(r2);
            return;
        L8:
            if (r1.isFinishing() == false) goto L10;
            return;
        L10:
            if (r1.isDestroyed() == false) goto L12;
            return;
        L5:
            r1 = null;
            goto L6
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = "";
            this.c = "";
            this.l = true;
            this.n = 0.2f;
        }

        public final void d(CharSequence r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.c = r2;
        }

        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.b = r2;
        }

        public static void b(a r1, u r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            Intrinsics.checkNotNullParameter(r3, "text");
            r1.k = r2;
            r1.h = r3;
            r1.j = false;
        }

        public final void c(p0 r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.g = r2;
            this.d = r3;
            this.f = r4;
        }
    }

    public static final class b {
        public final String a;
        public final CharSequence b;
        public final Integer c;
        public final Integer d;
        public final String e;
        public final Integer f;
        public final Integer g;
        public final boolean h;
        public final p0 i;
        public final String j;
        public final Integer k;
        public final boolean l;
        public final u m;
        public final boolean n;
        public final Function0<Boolean> o;
        public final l1 p;
        public final View q;
        public final float r;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
            return false;
        L60:
            if (Float.compare(this.r, r6.r) == 0) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            CharSequence r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Integer r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            Integer r20 = this.g;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r18 + r21) * 31;
            int r23 = 1231;
            if (this.h == false) goto L33;
            int r24 = 1231;
        L34:
            int r25 = (r22 + r24) * 31;
            p0 r26 = this.i;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r30 = this.j;
            if (r30 != null) goto L41;
            int r31 = 0;
        L42:
            int r32 = (r28 + r31) * 31;
            Integer r33 = this.k;
            if (r33 != null) goto L45;
            int r34 = 0;
        L46:
            int r35 = (r32 + r34) * 31;
            if (this.l == false) goto L49;
            int r36 = 1231;
        L50:
            int r37 = (r35 + r36) * 31;
            u r38 = this.m;
            if (r38 != null) goto L53;
            int r40 = 0;
        L54:
            int r41 = (r37 + r40) * 31;
            if (this.n == true) goto L58;
            r23 = 1237;
        L58:
            int r42 = (r41 + r23) * 31;
            Function0<Boolean> r43 = this.o;
            if (r43 != null) goto L61;
            int r44 = 0;
        L62:
            int r45 = (r42 + r44) * 31;
            l1 r46 = this.p;
            if (r46 != null) goto L65;
            int r47 = 0;
        L66:
            int r48 = (r45 + r47) * 31;
            View r50 = this.q;
            if (r50 == null) goto L71;
            r1 = r50.hashCode();
        L71:
            return ((r48 + r1) * 31) + Float.floatToIntBits(this.r);
        L65:
            r47 = r46.hashCode();
            goto L66
        L61:
            r44 = r43.hashCode();
            goto L62
        L53:
            r40 = r38.hashCode();
            goto L54
        L49:
            r36 = 1237;
            goto L50
        L45:
            r34 = r33.hashCode();
            goto L46
        L41:
            r31 = r30.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = 1237;
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Model(title=" + this.a + ", message=" + this.b + ", messageColor=" + this.c + ", linkTextColor=" + this.d + ", confirmText=" + this.e + ", confirmTextColor=" + this.f + ", confirmButtonColor=" + this.g + ", confirmBold=" + this.h + ", confirmClickListener=" + this.i + ", cancelText=" + this.j + ", cancelTextColor=" + this.k + ", cancelBold=" + this.l + ", cancelClickListener=" + this.m + ", canceledOnTouchOutside=" + this.n + ", backListener=" + this.o + ", whiteClickListener=" + this.p + ", alignTargetView=" + this.q + ", dimAmount=" + this.r + ')';
        }

        public b(String r3, CharSequence r4, Integer r5, String r6, Integer r7, Integer r8, boolean r9, p0 r10, String r11, Integer r12, boolean r13, u r14, boolean r15, Function0 r16, l1 r17, View r18, float r110) {
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = null;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
            this.o = r16;
            this.p = r17;
            this.q = r18;
            this.r = r110;
        }
    }

    public static void a(j r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r18) {
        super.onCreate(r18);
        setContentView(2131562047);
        Window r1 = getWindow();
        if (r1 == null) goto L5;
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        Window r2 = getWindow();
        if (r2 == null) goto L8;
        r2.addFlags(2);
    L8:
        Window r3 = getWindow();
        if (r3 == null) goto L11;
        r3.setDimAmount(this.a.r);
    L11:
        setCanceledOnTouchOutside(this.a.n);
        setOnKeyListener(new f(this));
        Window r4 = getWindow();
        if (r4 == null) goto L20;
        View r5 = r4.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");
    L18:
        if (r5 == null) goto L20;
        r5.setOnTouchListener(new g(this));
    L20:
        TextView r7 = (TextView) findViewById(2131368982);
        TextView r8 = (TextView) findViewById(2131368971);
        TextView r9 = (TextView) findViewById(2131367639);
        TextView r10 = (TextView) findViewById(2131365114);
        r7.setText(this.a.a);
        String r11 = this.a.a;
        if (r11 != null) goto L23;
    L26:
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        int r13 = 8;
    L31:
        r7.setVisibility(r13);
        r8.setText(this.a.b);
        CharSequence r14 = this.a.b;
        if (r14 != null) goto L34;
    L37:
        boolean r15 = true;
    L38:
        if (r15 == false) goto L40;
        int r16 = 8;
    L41:
        r8.setVisibility(r16);
        if ((this.a.b instanceof SpannableString) == false) goto L44;
        r8.setMovementMethod(LinkMovementMethod.getInstance());
        r8.setHighlightColor(0);
    L44:
        Integer r17 = this.a.d;
        if (r17 == null) goto L47;
        r8.setLinkTextColor(r17.intValue());
    L47:
        Integer r20 = this.a.c;
        if (r20 == null) goto L50;
        r8.setTextColor(r20.intValue());
    L50:
        r9.setText(this.a.e);
        Integer r21 = this.a.f;
        if (r21 == null) goto L53;
        r9.setTextColor(r21.intValue());
    L53:
        Integer r22 = this.a.g;
        if (r22 == null) goto L57;
        r9.setBackgroundTintList(ColorStateList.valueOf(r22.intValue()));
    L57:
        if (this.a.h == false) goto L59;
        r9.setTypeface(Typeface.DEFAULT_BOLD);
    L59:
        r9.setOnClickListener(new h(this));
        b r23 = this.a;
        if (r23.m == null) goto L77;
        String r24 = r23.j;
        if (r24 != null) goto L64;
    L67:
        boolean r25 = true;
    L68:
        if (r25 == true) goto L77;
        r10.setText(this.a.j);
        Integer r26 = this.a.k;
        if (r26 == null) goto L74;
        r10.setTextColor(r26.intValue());
    L74:
        if (this.a.l == false) goto L76;
        r10.setTypeface(Typeface.DEFAULT_BOLD);
    L76:
        r10.setOnClickListener(new i(this));
    L84:
        if (this.a.q != null) goto L86;
        WeakReference<View> r27 = null;
    L87:
        this.b = r27;
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        WeakReference<View> r28 = this.b;
        if (r28 == null) goto L90;
        View r30 = r28.get();
    L91:
        Window r31 = getWindow();
        if (r31 == null) goto L124;
        Resources r32 = getContext().getResources();
        int r33 = Math.min(WindowDisplayMetricsOverride.apply(r32, r32.getDisplayMetrics()).widthPixels - (r32.getDimensionPixelSize(v19.c.b(2130971390, null, 2131167150)) * 2), r32.getDimensionPixelSize(v19.c.b(2130971482, null, 2131167333)));
        if (r30 != null) goto L97;
    L121:
        WindowManager.LayoutParams r34 = r31.getAttributes();
        r34.width = r33;
        r34.height = -2;
        r34.gravity = 17;
        r31.setAttributes(r34);
        return;
    L97:
        if (r30.isShown() == false) goto L121;
        if (r30.getWindowToken() == null) goto L121;
        Resources r110 = getContext().getResources();
        int[] r111 = new int[2];
        r30.getLocationOnScreen(r111);
        float r112 = r111[1] + (r30.getHeight() / 2.0f);
        int r35 = r33 - (r110.getDimensionPixelSize(v19.c.b(2130971299, null, 2131166968)) * 2);
        String r113 = this.a.a;
        if (r113 != null) goto L104;
    L107:
        boolean r114 = true;
    L108:
        float r115 = 0.0f;
        if (r114 == true) goto L111;
        int r116 = r110.getDimensionPixelSize(v19.c.b(2130971299, null, 2131166968));
        r7.measure(View.MeasureSpec.makeMeasureSpec(r35, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r115 = (r116 + r7.getMeasuredHeight()) + 0.0f;
    L111:
        CharSequence r36 = this.a.b;
        if (r36 != null) goto L114;
    L117:
        boolean r37 = true;
    L118:
        if (r37 == true) goto L120;
        int r38 = r110.getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462));
        r8.measure(View.MeasureSpec.makeMeasureSpec(r35, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r115 = r115 + (r38 + r8.getMeasuredHeight());
    L120:
        float r117 = (r115 + r110.getDimensionPixelSize(v19.c.b(2130971299, null, 2131166968))) + (r110.getDimensionPixelSize(v19.c.b(2130971512, null, 2131167393)) / 2.0f);
        com.larus.utils.i0.a.getClass();
        int r40 = MathKt.roundToInt((r112 - com.larus.utils.i0.g()) - r117);
        WindowManager.LayoutParams r41 = r31.getAttributes();
        r41.width = r33;
        r41.height = -2;
        r41.gravity = 49;
        r41.y = r40;
        r31.setAttributes(r41);
        return;
    L114:
        if (r36.length() == 0) goto L117;
        r37 = false;
        goto L118
    L104:
        if (r113.length() == 0) goto L107;
        r114 = false;
        goto L108
    L124:
        return;
    L90:
        r30 = null;
        goto L91
    L86:
        r27 = new WeakReference(this.a.q);
        goto L87
    L64:
        if (r24.length() == 0) goto L67;
        r25 = false;
    L77:
        r10.setVisibility(8);
        ViewGroup.LayoutParams r42 = r9.getLayoutParams();
        if ((r42 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        ViewGroup.MarginLayoutParams r43 = (ViewGroup.MarginLayoutParams) r42;
    L81:
        if (r43 == null) goto L84;
        r43.bottomMargin = getContext().getResources().getDimensionPixelSize(v19.c.b(2130971208, getContext(), 2131166786));
        r9.setLayoutParams(r43);
        goto L84
    L80:
        r43 = null;
        goto L81
    L40:
        r16 = 0;
        goto L41
    L34:
        if (r14.length() == 0) goto L37;
        r15 = false;
        goto L38
    L30:
        r13 = 0;
        goto L31
    L23:
        if (r11.length() == 0) goto L26;
        r12 = false;
        goto L28
    }

    public j(Context r1, b r2) {
        super(r1);
        this.a = r2;
        requestWindowFeature(1);
        setCancelable(true);
    }
}
