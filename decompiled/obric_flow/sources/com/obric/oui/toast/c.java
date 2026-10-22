package com.obric.oui.toast;

import android.content.Context;
import android.os.DeadObjectException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f14889m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14892c;
    public final boolean d;
    public final Boolean e;
    public final int f;
    public final b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14894i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14895j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f14896k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OButton f14897l;

    static {
        new WeakReference(null);
    }

    public c(Context r10, String r11, int r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r12 = 80;
    L5:
        Intrinsics.checkNotNullParameter(r10, "mContext");
        Intrinsics.checkNotNullParameter(r11, "msg");
        this.f14890a = r10;
        this.f14891b = r11;
        this.f14892c = r12;
        this.d = true;
        this.e = null;
        this.f = 0;
        b r5 = new b();
        WindowManager.LayoutParams r14 = new WindowManager.LayoutParams();
        r5.e = r14;
        r5.g = new bb.b(r5);
        r5.f14883c = 2000;
        r5.d = true;
        r14.height = -2;
        r14.width = -2;
        r14.format = -3;
        Intrinsics.checkNotNullParameter("style", "type");
        int r15 = Class.forName(Intrinsics.stringPlus("com.android.internal.R$", "style")).getField("Animation_Toast").getInt(null);     // Catch: Exception -> L8
    L10:
        r14.windowAnimations = r15;
        r14.type = 2;
        r14.flags = 168;
        r14.setTitle("ObricCustomToast");
        this.g = r5;
        int r16 = com.lynx.tasm.utils.a.p(73, r10);
        this.f14893h = com.lynx.tasm.utils.a.p(28, r10);
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r10.getResources().getConfiguration().orientation != 2) goto L17;
        int r17 = com.lynx.tasm.utils.a.p(288, r10);
    L18:
        this.f14894i = r17;
        this.f14895j = r17;
        View r18 = LayoutInflater.from(r10).inflate(R$layout.o_toast, null);
        this.f14896k = r18;
        if (r12 == 80) goto L21;
        this.f14892c = 80;
        ps.a.g("OToast", "custom position is not supported! position 80!");
    L21:
        r5.f14882b = 96;
        r5.f14881a = this.f14892c;
        ((TextView) r18.findViewById(R$id.tv_msg)).setText(r11);
        this.f14897l = (OButton) r18.findViewById(R$id.right_button);
        a();
        return;
    L17:
        r17 = com.lynx.tasm.utils.a.x(r10) - r16;
    L15:
        e = move-exception;
        ps.a.b(e, "ResourceUtils", "isLandscape error");
    L8:
        e = move-exception;
        e.printStackTrace();
        r15 = 0;
        goto L10
    }

    public final void a() {
        int r5 = R$id.iv_icon;
        View r10 = this.f14896k;
        boolean r11 = d.q(r10.findViewById(r5));
        int r12 = this.f14894i;
        if (r11 == true) goto L5;
    L6:
        r12 = r12 - this.f14893h;
    L7:
        this.f14895j = r12;
        ((TextView) r10.findViewById(R$id.tv_msg)).setMaxWidth(this.f14895j);
        return;
    L5:
        if (d.q(r10.findViewById(R$id.toast_progress)) == true) goto L7;
        goto L6
    }

    public final void b() {
        OButton r5 = this.f14897l;
        View r10 = this.f14896k;
        int r11 = this.f;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        Context r12 = this.f14890a;
        if (r11 == 0) goto L8;
    L23:
        Log.d("OToast", "show toast by ocean");     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        int r13 = this.f14892c;
        if (r13 != 17) goto L27;
    L30:
        int r14 = 0;
    L34:
        ((TextView) r10.findViewById(R$id.tv_msg)).setMaxWidth(this.f14895j);     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r10.measure(0, 0);     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        if ((r10 instanceof ToastBackgroundView) == false) goto L37;
        View r15 = r10;
    L38:
        ToastBackgroundView r16 = (ToastBackgroundView) r15;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        if (r16 == null) goto L42;
        ToastBackgroundView.a(r16, r10.getMeasuredHeight());     // Catch: DeadObjectException -> L14 RuntimeException -> L16
    L42:
        b r17 = this.g;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.f14885i = r10;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.f14886j = r12;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.f14881a = r13;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.f14882b = r14;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.f = this.e;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        r17.c();     // Catch: DeadObjectException -> L14 RuntimeException -> L16
    L43:
        Unit r18 = Unit.INSTANCE;     // Catch: DeadObjectException -> L14 RuntimeException -> L16
    L51:
        return;
    L37:
        r15 = null;
        goto L38
    L27:
        if (r13 != 48) goto L29;
        r14 = com.lynx.tasm.utils.a.p(20, r12);     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        goto L34
    L29:
        if (r13 != 80) goto L30;
        r14 = com.lynx.tasm.utils.a.p(96, r12);     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        goto L34
    L8:
        if (this.d == true) goto L23;
        if (d.q(r5) == false) goto L12;
    L18:
        Log.d("OToast", "show toast by system");     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        Context r19 = r12.getApplicationContext();     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        if (r19 == null) goto L22;
        r12 = r19;
    L22:
        Toast.makeText(r12, this.f14891b, 0).show();     // Catch: DeadObjectException -> L14 RuntimeException -> L16
        goto L43
    L12:
        if (r5.isClickable() == true) goto L23;
    L14:
        e = move-exception;
        com.lynx.tasm.utils.b.q(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
    L46:
        com.lynx.tasm.utils.b.q(Intrinsics.stringPlus("OToast", ", showAsDropDown exception occur, try showAtLocation"));
        return;
    L16:
        e = move-exception;
        com.lynx.tasm.utils.b.q(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
        goto L46
    }
}
