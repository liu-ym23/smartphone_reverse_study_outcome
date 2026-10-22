package a2a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends Dialog {
    public final boolean a;
    public com.ss.android.update.d b;
    public TextView c;
    public TextView d;
    public TextView e;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.b.n(true);
        cancel();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.b.e0(true);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        boolean r6 = true;
        requestWindowFeature(1);
        setContentView(2131562452);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawableResource(2131248511);
        r0.setLayout(-1, -2);
        r0.setGravity(17);
        r0.setWindowAnimations(2131954912);
    L5:
        setCanceledOnTouchOutside(false);
        this.d = (TextView) findViewById(2131390018);
        this.c = (TextView) findViewById(2131364619);
        this.e = (TextView) findViewById(2131390019);
        this.b = com.ss.android.update.d.x();
        TextView r1 = this.c;
        if (r1 == null) goto L8;
        r1.setText(getContext().getResources().getString(2131910885));
    L8:
        String r2 = this.b.K();
        if (this.b.I() == null) goto L11;
        r2 = this.b.u();
    L11:
        if (r2 != null) goto L13;
    L16:
        if (r6 == true) goto L21;
        TextView r7 = this.e;
        if (r7 == null) goto L21;
        r7.setText(r2);
    L21:
        e1.d(this.d, new a2a.a(this));
        TextView r8 = this.c;
        if (r8 == null) goto L25;
        e1.b(r8, new b(this));
        return;
    L25:
        return;
    L13:
        if (r2.length() == 0) goto L16;
        r6 = false;
        goto L16
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r4) {
        super.onWindowFocusChanged(r4);
        Window r0 = getWindow();
        if (r4 == false) goto L16;
        if (r0 == null) goto L17;
        View r5 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        if (r5.getHeight() != 0) goto L13;
    L14:
        r5.requestLayout();
        Logger.d("ManualCheckUpdateDialog", "重新布局");
        return;
    L13:
        if (r5.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public c(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.a = r3;
        this.b = com.ss.android.update.d.x();
    }
}
