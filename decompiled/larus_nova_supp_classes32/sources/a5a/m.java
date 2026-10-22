package a5a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public final WeakReference<Context> a;
    public final WeakReference<l> b;
    public final Map<LogBoxLogLevel, a> c;
    public final Map<LogBoxLogLevel, Boolean> d;
    public Dialog e;
    public LinearLayout f;

    public class a {
        public final TextView a;
        public final TextView b;
        public final View c;
        public final LogBoxLogLevel d;
        public final /* synthetic */ m e;

        /* JADX INFO: renamed from: a5a.m$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0003a implements View.OnClickListener {
            public final /* synthetic */ a a;

            public ViewOnClickListenerC0003a(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r5) {
                a r6 = this.a;
                m r0 = r6.e;
                LogBoxLogLevel r7 = r6.d;
                l r1 = r0.b.get();
                if (r1 == null) goto L11;
                l.a r2 = (l.a) ((HashMap) r1.b).get(r7);
                if (r2 == null) goto L11;
                Iterator r3 = ((ArrayList) r2.b).iterator();
            L8:
                if (r3.hasNext() == false) goto L10;
                ((LogBoxProxy) r3.next()).clearLogsWithLevel(r7);
                goto L8
            L10:
                ((ArrayList) r2.b).clear();
                r2.d = 0;
                r2.c = 0;
            L11:
                r0.b(r7);
            }
        }

        public class b implements View.OnClickListener {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r5) {
                a r6 = this.a;
                m r0 = r6.e;
                LogBoxLogLevel r7 = r6.d;
                l r1 = r0.b.get();
                if (r1 == null) goto L24;
                Context r2 = r1.a.get();
                if (r2 != null) goto L8;
                return;
            L8:
                if (r1.d != null) goto L10;
                r1.d = new a5a.b(r2, r1, new k(r1, r7));
            L12:
                if ((r2 instanceof Activity) == true) goto L14;
                return;
            L14:
                if (((Activity) r2).isFinishing() == true) goto L26;
                a5a.b r3 = r1.d;
                r3.d = r7;
                if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L22;
                DialogLancet.handleBlockedDialogShow(r3);
                return;
            L22:
                DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
            L19:
                DialogLancet.beforeDialogShow(r3);
                r3.show();
                DialogLancet.afterDialogShow(r3);
                return;
            L26:
                return;
            L10:
                r1.d(-1, r7);
                goto L12
            }
        }

        public a(m r3, Context r4, ViewGroup r5, LogBoxLogLevel r6) {
            this.e = r3;
            View r7 = LayoutInflater.from(r4).inflate(2131560025, r5, false);
            this.c = r7;
            TextView r8 = (TextView) r7.findViewById(2131381059);
            this.a = r8;
            this.b = (TextView) r7.findViewById(2131381060);
            this.d = r6;
            r7.findViewById(2131381042).setOnClickListener(new ViewOnClickListenerC0003a(this));
            r8.setOnClickListener(new b(this));
            r8.setSingleLine();
            GradientDrawable r9 = (GradientDrawable) ((ImageView) r7.findViewById(2131381064)).getDrawable();
            if (r6 != LogBoxLogLevel.Error) goto L6;
            r9.setColor(r4.getResources().getColor(2131103558));
            return;
        L6:
            if (r6 != LogBoxLogLevel.Warn) goto L10;
            r9.setColor(r4.getResources().getColor(2131103561));
            return;
        }
    }

    public static void a(Dialog r3) {
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

    public final void b(LogBoxLogLevel r2) {
        if (this.e != null) goto L5;
        return;
    L5:
        a r3 = (a) ((HashMap) this.c).get(r2);
        if (r3 == null) goto L9;
        this.f.removeView(r3.c);
    L9:
        if (this.f.getChildCount() == 0) goto L11;
        return;
    L11:
        if (this.e.isShowing() == false) goto L15;
        a(this.e);
        return;
    }

    public m(Context r2, l r3) {
        this.e = null;
        this.f = null;
        this.a = new WeakReference(r2);
        this.b = new WeakReference(r3);
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public final void c(LogBoxLogLevel r6, String r7, int r8) {
        ((HashMap) this.d).put(r6, Boolean.FALSE);
        Context r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 > 0) goto L9;
        b(r6);
        return;
    L9:
        if (this.e != null) goto L13;
        Dialog r1 = new Dialog(r0);
        this.e = r1;
        r1.requestWindowFeature(1);
        LinearLayout r2 = new LinearLayout(r0);
        this.f = r2;
        r2.setOrientation(1);
        this.e.setContentView(this.f);
        this.e.setCancelable(false);
        if (this.e.getWindow() == null) goto L13;
        this.e.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.e.getWindow().setDimAmount(0.0f);
        this.e.getWindow().setLayout(-1, -2);
        this.e.getWindow().setGravity(80);
        this.e.getWindow().addFlags(32);
        this.e.getWindow().addFlags(8);
        this.e.getWindow().addFlags(131072);
        this.e.getWindow().addFlags(256);
    L13:
        a r3 = (a) ((HashMap) this.c).get(r6);
        if (r3 != null) goto L16;
        r3 = new a(this, r0, this.f, r6);
        ((HashMap) this.c).put(r6, r3);
    L16:
        r3.a.setText(r7);
        String r9 = String.valueOf(r8);
        if (r9.length() <= 2) goto L19;
        r9 = r9.charAt(0) + "...";
    L19:
        r3.b.setText(r9);
        View r10 = r3.c;
        if (this.f == r10.getParent()) goto L32;
        this.f.addView(r10);
        if (this.e.isShowing() == true) goto L33;
        Dialog r11 = this.e;
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L27:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L33:
        return;
    }
}
