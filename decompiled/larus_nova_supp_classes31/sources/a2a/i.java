package a2a;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.update.IUpdateConfig;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.j0;
import yhc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i extends Dialog {
    public final boolean a;
    public final boolean b;
    public com.ss.android.update.d c;
    public SharedPreferences d;
    public IUpdateConfig e;
    public TextView f;
    public TextView g;
    public TextView h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        this.c.n(this.a);
        cancel();
        if (this.c.P() == false) goto L12;
        IUpdateConfig r0 = this.e;
        if (r0 == null) goto L14;
        v r1 = r0.getUpdateConfig();
        if (r1 == null) goto L15;
        yhc.j r2 = r1.b();
        if (r2 == null) goto L16;
        r2.a(getContext());
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L12:
        j0.a.a.b();
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        SharedPreferences r0 = this.d;
        if (r0 == null) goto L10;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putLong("last_show_timestamp", System.currentTimeMillis());
        r1.apply();
    L10:
        this.c.e0(true);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a();
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
        this.g = (TextView) findViewById(2131390018);
        this.f = (TextView) findViewById(2131364619);
        this.h = (TextView) findViewById(2131390019);
        this.c = com.ss.android.update.d.x();
        this.e = f0.a;
        this.d = getContext().getSharedPreferences("upgrade_dialog.prefs", 0);
        TextView r1 = this.f;
        if (r1 == null) goto L8;
        r1.setText(getContext().getResources().getString(2131910885));
    L8:
        String r2 = this.c.K();
        if (this.c.I() == null) goto L11;
        r2 = this.c.u();
    L11:
        if (r2 != null) goto L13;
    L16:
        if (r6 == true) goto L21;
        TextView r7 = this.h;
        if (r7 == null) goto L21;
        r7.setText(r2);
    L21:
        e1.d(this.g, new g(this));
        TextView r8 = this.f;
        if (r8 == null) goto L25;
        e1.d(r8, new h(this));
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
        Logger.d("UpdateDialog", "重新布局");
        return;
    L13:
        if (r5.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public i(Context r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = com.ss.android.update.d.x();
    }
}
