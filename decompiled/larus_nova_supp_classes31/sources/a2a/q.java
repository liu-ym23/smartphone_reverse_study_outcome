package a2a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.update.IUpdateConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q extends Dialog implements WeakHandler.IHandler {
    public final Context a;
    public final boolean b;
    public final WeakHandler c;
    public com.ss.android.update.d d;
    public IUpdateConfig e;
    public r f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public ProgressBar l;
    public yhc.a m;

    public static final class a {
    }

    static {
    }

    public final void b() {
        yhc.a r0 = this.m;
        int r1 = r0.c;
        int r2 = 100;
        if (r1 == 0) goto L34;
        if (r1 == 1) goto L34;
        if (r1 == 2) goto L23;
        if (r1 == 3) goto L11;
        return;
    L11:
        if (this.b == false) goto L13;
        a(false);
    L13:
        TextView r3 = this.g;
        if (r3 == null) goto L16;
        r3.setText(getContext().getResources().getString(2131910880));
    L16:
        TextView r4 = this.h;
        if (r4 == null) goto L19;
        r4.setText(getContext().getResources().getString(2131910888));
    L19:
        ProgressBar r5 = this.l;
        if (r5 == null) goto L63;
        r5.setProgress(100);
        return;
    L63:
        return;
    L23:
        if (this.b == false) goto L25;
        a(false);
    L25:
        TextView r6 = this.g;
        if (r6 == null) goto L28;
        r6.setText(getContext().getResources().getString(2131910881));
    L28:
        TextView r7 = this.h;
        if (r7 == null) goto L31;
        r7.setText(getContext().getResources().getString(2131910891));
    L31:
        ProgressBar r8 = this.l;
        if (r8 == null) goto L65;
        r8.setProgress(0);
        return;
    L65:
        return;
    L34:
        int r9 = r0.a;
        int r10 = r0.b;
        if (r9 < 0) goto L42;
        if (r10 <= 0) goto L42;
        int r11 = (int) ((r9 / r10) * 100);
        if (r11 > 100) goto L43;
        r2 = r11;
    L43:
        TextView r12 = this.g;
        if (r12 == null) goto L47;
        r12.setText(getContext().getResources().getString(2131910887) + ' ' + r2 + '%');
    L47:
        if (com.ss.android.update.d.x().P() == false) goto L49;
        int r13 = 2131910889;
    L51:
        if (this.b == false) goto L53;
        a(!com.ss.android.update.d.x().P());
    L53:
        TextView r14 = this.h;
        if (r14 == null) goto L56;
        r14.setText(getContext().getResources().getString(r13));
    L56:
        ProgressBar r15 = this.l;
        if (r15 != null) goto L59;
        return;
    L59:
        if (24 > Build.VERSION.SDK_INT) goto L61;
        r15.setProgress(r2, true);
        return;
    L61:
        r15.setProgress(r2);
        return;
    L49:
        r13 = 2131910485;
    L42:
        r2 = 0;
        goto L43
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        if (com.ss.android.update.d.x().P() == false) goto L12;
        IUpdateConfig r0 = this.e;
        if (r0 == null) goto L13;
        v r1 = r0.getUpdateConfig();
        if (r1 == null) goto L14;
        yhc.j r2 = r1.b();
        if (r2 == null) goto L15;
        r2.a(getContext());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void a(boolean r5) {
        LinearLayout r0 = this.k;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r5 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        TextView r2 = this.h;
        if (r2 == null) goto L14;
        if (r5 == false) goto L12;
        r1 = 8;
    L12:
        r2.setVisibility(r1);
        return;
    }

    public final void handleMsg(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r0 = r4.what;
        if (r0 != 1) goto L5;
        Object r5 = r4.obj;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
        this.m = (yhc.a) r5;
        b();
        return;
    L5:
        if (r0 != 2) goto L11;
        Object r6 = r4.obj;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
        this.m = (yhc.a) r6;
        b();
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        requestWindowFeature(1);
        setContentView(2131562451);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawableResource(2131248511);
        r0.setLayout(-1, -2);
        r0.setGravity(17);
        r0.setWindowAnimations(2131954912);
    L5:
        setCanceledOnTouchOutside(false);
        this.g = (TextView) findViewById(2131390020);
        this.h = (TextView) findViewById(2131391658);
        this.l = (ProgressBar) findViewById(2131391890);
        if (this.b == false) goto L8;
        this.i = (TextView) findViewById(2131364873);
        this.j = (TextView) findViewById(2131364875);
        this.k = (LinearLayout) findViewById(2131377669);
        a(!com.ss.android.update.d.x().P());
        setCanceledOnTouchOutside(true ^ com.ss.android.update.d.x().P());
        FLogger.a.d("ForceUpdateProcessDialog", "initUI, " + this.a + ", " + this + ", " + this.g + ", " + this.h + ", " + this.i + ", " + this.j);
    L8:
        com.ss.android.update.d r6 = com.ss.android.update.d.x();
        this.d = r6;
        this.e = f0.a;
        r r1 = new r(this);
        this.f = r1;
        monitor-enter(r6);
        List r2 = r6.g0;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        ((ArrayList) r6.g0).add(r1);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        monitor-exit(r6);     // Catch: Throwable -> L23
        setOnDismissListener(new m(this));
        if (this.b == false) goto L18;
        e1.b(this.i, new n(this));
        e1.b(this.j, new o(this));
    L18:
        e1.b(this.h, new p(this));
        this.d.h0(false);
        com.ss.android.update.d.x().E(this.m);
        b();
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
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
        Logger.d("ForceUpdateProcessDialog", "request layout again");
        return;
    L13:
        if (r5.getWidth() == 0) goto L14;
        return;
    L17:
        return;
    }

    public q(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.a = r2;
        this.b = r3;
        this.c = new WeakHandler(this);
        this.d = com.ss.android.update.d.x();
        this.m = new yhc.a();
    }
}
