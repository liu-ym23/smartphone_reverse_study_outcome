package ds9;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f extends Dialog {
    public final String a;
    public final boolean b;
    public ViewGroup c;
    public View d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public g k;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        g r0 = this.k;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public static void a(f r3) {
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
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(2131562009);
        setCanceledOnTouchOutside(false);
        this.c = (ViewGroup) findViewById(2131368418);
        this.d = findViewById(2131368416);
        this.e = (TextView) findViewById(2131368417);
        this.f = (TextView) findViewById(2131368420);
        this.g = (ImageView) findViewById(2131368421);
        this.h = (TextView) findViewById(2131368419);
        this.i = (TextView) findViewById(2131368422);
        this.j = (ImageView) findViewById(2131368415);
        LinearLayout.LayoutParams r1 = null;
        if (this.b == false) goto L21;
        ImageView r0 = this.g;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        TextView r2 = this.i;
        if (r2 == null) goto L15;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L12;
        r1 = (LinearLayout.LayoutParams) r3;
    L12:
        if (r1 == null) goto L14;
        r1.setMargins(0, i5.r0(), 0, i5.q());
    L14:
        r2.setLayoutParams(r1);
    L15:
        TextView r6 = this.f;
        if (r6 == null) goto L18;
        r6.setText(getContext().getResources().getString(2131908672));
    L18:
        TextView r7 = this.e;
        if (r7 == null) goto L39;
        r7.setText(getContext().getResources().getString(2131905639));
    L39:
        if (AppHost.a.isOversea() == true) goto L49;
        TextView r8 = this.h;
        if (r8 == null) goto L43;
        r8.setText(getContext().getResources().getString(2131908677));
    L43:
        TextView r9 = this.i;
        if (r9 == null) goto L46;
        r9.setText(getContext().getResources().getString(2131908675));
    L46:
        ImageView r10 = this.j;
        if (r10 == null) goto L58;
        r10.setImageResource(2131241151);
    L58:
        setOnShowListener(new ds9.a(this));
        setOnDismissListener(new b(this));
        View r11 = this.d;
        if (r11 == null) goto L61;
        r11.setOnClickListener(new c(this));
    L61:
        TextView r12 = this.e;
        if (r12 == null) goto L64;
        r12.setOnClickListener(new d(this));
    L64:
        TextView r13 = this.f;
        if (r13 == null) goto L68;
        r13.setOnClickListener(new e(this));
        return;
    L68:
        return;
    L49:
        TextView r14 = this.h;
        if (r14 == null) goto L52;
        r14.setText(j5.a(getContext(), 2131894310, 2131901960));
    L52:
        TextView r15 = this.i;
        if (r15 == null) goto L55;
        r15.setText(j5.a(getContext(), 2131894310, 2131901959));
    L55:
        ImageView r16 = this.j;
        if (r16 == null) goto L58;
        r16.setImageResource(2131241150);
        goto L58
    L21:
        ImageView r4 = this.g;
        if (r4 == null) goto L24;
        r4.setVisibility(0);
    L24:
        TextView r17 = this.i;
        if (r17 == null) goto L32;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if ((r18 instanceof LinearLayout.LayoutParams) == false) goto L29;
        r1 = (LinearLayout.LayoutParams) r18;
    L29:
        if (r1 == null) goto L31;
        r1.setMargins(0, i5.r0(), 0, i5.r0());
    L31:
        r17.setLayoutParams(r1);
    L32:
        TextView r19 = this.f;
        if (r19 == null) goto L35;
        r19.setText(getContext().getResources().getString(2131908674));
    L35:
        TextView r20 = this.e;
        if (r20 == null) goto L39;
        r20.setText(getContext().getResources().getString(2131908673));
        goto L39
    }

    public f(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        super(r2, 2131952510);
        this.a = r3;
        this.b = false;
    }
}
