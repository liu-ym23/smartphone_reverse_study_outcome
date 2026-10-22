package pq1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends Dialog {
    public HSImageView a;
    public TextView b;
    public TextView c;
    public View d;

    /* JADX INFO: renamed from: pq1.a$a, reason: collision with other inner class name */
    public static final class C0411a {
        public final d a;

        public final void b(int r2) {
            Context r0 = this.a.b;
            if (r0 == null) goto L5;
            CharSequence r3 = r0.getText(r2);
        L6:
            this.a.d = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }

        public C0411a(Context r2, int r3) {
            d r0 = new d();
            this.a = r0;
            r0.b = r2;
            r0.a = r3;
        }

        public final void a(int r3, int r4, DialogInterface.OnClickListener r5) {
            Context r0 = this.a.b;
            if (r0 == null) goto L6;
            CharSequence r6 = r0.getText(r4);
            if (r6 == null) goto L6;
        L8:
            if (r3 > 4) goto L15;
            b[] r1 = this.a.e;
            b r2 = r1[r3];
            if (r2 != null) goto L13;
            r2 = new b();
            r1[r3] = r2;
        L13:
            r2.a = r6;
            r2.b = r5;
            return;
        L15:
            return;
        L6:
            r6 = "";
            goto L8
        }
    }

    public static final class b {
        public CharSequence a;
        public DialogInterface.OnClickListener b;

        public b() {
        }
    }

    public static final class c {
    }

    public static final class d {
        public int a;
        public Context b;
        public CharSequence c;
        public CharSequence d;
        public final b[] e;
        public boolean f;

        public d() {
            this.e = new b[5];
            this.f = true;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;

        public e(a r1, b r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            DialogInterface.OnClickListener r4 = this.b.b;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4 == null) goto L8;
            r4.onClick(this.a, this.c);
            return;
        }
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        int r1 = pq1.b.a - 1;
        pq1.b.a = r1;
        if (r1 >= 0) goto L26;
        pq1.b.a = 0;
        return;
    L26:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        pq1.b.a++;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void b(d r7) {
        this.a = findViewById(2131384317);
        this.b = (TextView) findViewById(2131384320);
        this.c = (TextView) findViewById(2131384319);
        r7.getClass();
        HSImageView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        findViewById(2131384318).setVisibility(8);
        CharSequence r1 = r7.c;
        if (r1 == null) goto L13;
        TextView r4 = this.b;
        if (r4 == null) goto L10;
        r4.setText(r1);
    L10:
        TextView r2 = this.b;
        if (r2 == null) goto L17;
        r2.setVisibility(0);
    L17:
        CharSequence r3 = r7.d;
        if (r3 == null) goto L22;
        TextView r5 = this.c;
        if (r5 == null) goto L26;
        r5.setText(r3);
    L26:
        int r6 = r7.a;
        if (r6 != 0) goto L29;
    L30:
        b[] r8 = r7.e;
        if (r8[0] == null) goto L33;
    L36:
        boolean r9 = true;
    L38:
        if (r9 == true) goto L40;
        findViewById(2131384314).setVisibility(8);
    L41:
        setCancelable(r7.f);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(null);
        setOnDismissListener(null);
        setOnShowListener(null);
        return;
    L40:
        a((Button) findViewById(2131384312), 0, null, r7);
        a((Button) findViewById(2131384313), 1, findViewById(2131384315), r7);
        this.d = findViewById(2131384321);
        goto L41
    L33:
        if (r8[1] != null) goto L36;
    L35:
        r9 = false;
        goto L38
    L29:
        if (4 != r6) goto L35;
    L22:
        TextView r10 = this.c;
        if (r10 == null) goto L25;
        r10.setVisibility(8);
    L25:
        findViewById(2131384321).setVisibility(8);
        goto L26
    L13:
        TextView r11 = this.b;
        if (r11 == null) goto L16;
        r11.setVisibility(8);
    L16:
        findViewById(2131384321).setVisibility(8);
        goto L17
    }

    @Override // android.app.Dialog
    public final void setTitle(int r2) {
        setTitle(getContext().getText(r2));
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r2) {
        TextView r0 = this.b;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.setText(r2);
        return;
    L8:
        return;
    }

    public a(Context r3, d r4) {
        super(r3, 2131954781);
        if (r4.a != 4) goto L5;
        setContentView(LayoutInflater.from(getContext()).inflate(2131567305, null));
        b(r4);
        return;
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(2131567303, null));
        b(r4);
    }

    public final void a(Button r1, int r2, View r3, d r4) {
        b r5 = r4.e[r2];
        if (r5 == null) goto L11;
        if (r1 == null) goto L6;
        r1.setText(r5.a);
    L6:
        if (r1 == null) goto L8;
        r1.setOnClickListener(new e(this, r5, r2));
    L8:
        if (r1 == null) goto L16;
        r1.setTypeface(null, 0);
        return;
    L16:
        return;
    L11:
        if (r1 == null) goto L13;
        r1.setVisibility(8);
    L13:
        if (r3 == null) goto L18;
        r3.setVisibility(8);
        return;
    }
}
