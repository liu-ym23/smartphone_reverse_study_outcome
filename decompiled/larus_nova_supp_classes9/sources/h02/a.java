package h02;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.e;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.revenue.service.interact.d;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import jy0.b;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends Dialog {
    public FrameLayout a;
    public final Activity b;

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        r0.clearFlags(2);
    L10:
        WindowManager.LayoutParams r2 = null;
        if (((List) e.E.getValue(null, e.a[29])).contains(Integer.valueOf(c.b(d.class).getCurrentScene())) == false) goto L24;
        Window r1 = getWindow();
        if (r1 == null) goto L15;
        r2 = r1.getAttributes();
    L15:
        if (r2 == null) goto L17;
        r2.height = s1.j(2131168682);
    L17:
        Window r3 = getWindow();
        if (r3 == null) goto L25;
        r3.setAttributes(r2);
        return;
    L25:
        return;
    L24:
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final Activity getActivity() {
        return this.b;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawableResource(R.color.transparent);
    L5:
        Window r1 = getWindow();
        if (r1 == null) goto L9;
        r1.clearFlags(2);
    L9:
        if ((r3 instanceof Activity) == false) goto L11;
        Activity r4 = (Activity) r3;
    L12:
        this.b = r4;
        return;
    L11:
        r4 = null;
        goto L12
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r5) {
        if (Build.VERSION.SDK_INT <= 23) goto L7;
        Window r0 = getWindow();
        if (r0 == null) goto L7;
        r0.requestFeature(1);
    L7:
        super.onCreate(r5);
        setContentView(2131566140);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams r3 = null;
        if (((Boolean) e.s.getValue(null, e.a[17])).booleanValue() == false) goto L12;
        Window r1 = getWindow();
        if (r1 == null) goto L15;
        r1.setType(IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L15:
        Window r2 = getWindow();
        if (r2 == null) goto L18;
        r2.addFlags(8);
    L18:
        Window r4 = getWindow();
        if (r4 == null) goto L22;
        r4.setFlags(1024, 1024);
    L22:
        if (this.b != null) goto L26;
        Window r6 = getWindow();
        if (r6 == null) goto L26;
        r6.addFlags(16);
    L26:
        Window r7 = getWindow();
        if (r7 == null) goto L29;
        r3 = r7.getAttributes();
    L29:
        if (r3 == null) goto L31;
        r3.width = -1;
    L31:
        if (r3 == null) goto L33;
        r3.height = s1.j(2131168681);
    L33:
        if (r3 == null) goto L35;
        r3.gravity = 80;
    L35:
        Window r8 = getWindow();
        if (r8 == null) goto L38;
        r8.setAttributes(r3);
    L38:
        Window r9 = getWindow();
        if (r9 == null) goto L47;
        View r10 = r9.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L45;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r11 = ThreadMethodProxy.currentThread();
        if (r11 == com.larus.home.impl.utils.c.a) goto L45;
        com.larus.home.impl.utils.c.a(r11, "getDecorView");
    L45:
        if (r10 == null) goto L47;
        r10.setPadding(0, 0, 0, 0);
    L47:
        this.a = (FrameLayout) findViewById(2131389373);
        return;
    L12:
        Window r13 = getWindow();
        if (r13 == null) goto L15;
        r13.setType(1);
        goto L15
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r19) {
        Intrinsics.checkNotNullParameter(r19, "ev");
        if (super.onTouchEvent(r19) == true) goto L22;
        if (r19.getPointerCount() < 2) goto L24;
        boolean r0 = false;
    L19:
        if (r0 == true) goto L22;
        return false;
    L24:
        MotionEvent r1 = MotionEvent.obtain(r19.getDownTime(), r19.getEventTime(), r19.getAction(), r19.getRawX(), r19.getRawY(), r19.getPressure(), r19.getSize(), r19.getMetaState(), r19.getXPrecision(), r19.getYPrecision(), r19.getDeviceId(), r19.getEdgeFlags());     // Catch: Exception -> L16
        Activity r2 = this.b;     // Catch: Exception -> L14
        if (r2 == null) goto L13;
        r0 = r2.dispatchTouchEvent(r1);     // Catch: Exception -> L14
    L13:
        r0 = false;
    L14:
        e = e;
    L18:
        b.a("GiftTrayDialog", "passThroughEvent error " + e);
    L16:
        e = e;
    L22:
        return true;
    }
}
