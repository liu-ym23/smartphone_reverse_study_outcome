package zv8;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends Dialog {
    public final j a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(2131562010);
        b r8 = this.a.c;
        if (r8 == null) goto L12;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L12;
        WindowManager.LayoutParams r0 = r9.getAttributes();
        Resources r1 = r9.getContext().getResources();
        r0.width = (int) (((double) WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).widthPixels) * 0.9d);
        r9.setGravity(80);
        r9.setAttributes(r0);
        View r10 = r9.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L11:
        r10.setBackgroundResource(R.color.transparent);
    L12:
        final j r11 = this.a;
        r11.getClass();
        final Activity r3 = AppHost.a.a().getCurrentActivity();
        if (r3 == null) goto L74;
        b r4 = r11.c;
        Integer r5 = null;
        if (r4 == null) goto L18;
        LinearLayout r6 = (LinearLayout) r4.findViewById(2131368582);
    L19:
        r11.d = r6;
        b r12 = r11.c;
        if (r12 == null) goto L22;
        Space r13 = (Space) r12.findViewById(2131368581);
    L23:
        r11.e = r13;
        b r14 = r11.c;
        if (r14 == null) goto L26;
        TextView r15 = (TextView) r14.findViewById(2131368583);
    L27:
        r11.f = r15;
        b r16 = r11.c;
        if (r16 == null) goto L30;
        ViewStub r17 = (ViewStub) r16.findViewById(2131368580);
    L31:
        r11.g = r17;
        b r18 = r11.c;
        if (r18 == null) goto L34;
        TextView r19 = (TextView) r18.findViewById(2131368579);
    L35:
        r11.h = r19;
        TextView r20 = r11.f;
        if (r20 == null) goto L38;
        r20.setText(r11.c());
    L38:
        ViewStub r21 = r11.g;
        if (r21 == null) goto L41;
        r21.setLayoutResource(r11.h());
    L41:
        Integer r22 = -1;
        if (r22.intValue() <= 0) goto L44;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L47;
        r5 = r22;
    L47:
        if (r5 == null) goto L51;
        final int r24 = r5.intValue();
        ViewStub r25 = r11.g;
        if (r25 == null) goto L51;
        r25.setOnInflateListener(new g(r3, r24));
    L51:
        ViewStub r26 = r11.g;
        if (r26 == null) goto L54;
        r26.inflate();
    L54:
        Space r27 = r11.e;
        if (r27 == null) goto L57;
        r27.setVisibility(0);
    L57:
        Space r28 = r11.e;
        if (r28 == null) goto L60;
        r28.setClickable(true);
    L60:
        Space r29 = r11.e;
        if (r29 == null) goto L63;
        r29.setEnabled(true);
    L63:
        Space r30 = r11.e;
        if (r30 == null) goto L66;
        r30.setOnClickListener(new h(r11));
    L66:
        LinearLayout r31 = r11.d;
        if (r31 == null) goto L69;
        r31.setBackgroundResource(2131238729);
    L69:
        TextView r32 = r11.h;
        if (r32 == null) goto L73;
        r32.setOnClickListener(new i(r11));
        return;
    L73:
        return;
    L44:
        r23 = false;
        goto L45
    L34:
        r19 = null;
        goto L35
    L30:
        r17 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
        goto L23
    L18:
        r6 = null;
        goto L19
    }

    public b(Context r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dialogEntrance");
        super(r2);
        this.a = r3;
    }
}
