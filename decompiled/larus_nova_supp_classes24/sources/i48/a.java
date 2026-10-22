package i48;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends Dialog {
    public final float a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        requestWindowFeature(1);
        setContentView(2131558438);
        Window r7 = getWindow();
        if (r7 == null) goto L5;
        WindowManager.LayoutParams r0 = r7.getAttributes();
    L6:
        if (r0 == null) goto L9;
        r0.width = -1;
        r0.height = -1;
        r0.gravity = 17;
    L9:
        if (r7 == null) goto L17;
        View r1 = r7.getDecorView();
        if (c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == c.a) goto L15;
        c.a(r2, "getDecorView");
    L15:
        if (r1 == null) goto L17;
        r1.setPadding(0, 0, 0, 0);
    L17:
        if (r7 == null) goto L19;
        r7.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        if (r7 == null) goto L21;
        r7.addFlags(LKBaseResponseModel.DEFAULT_ERROR_CODE);
    L21:
        if (r7 == null) goto L24;
        r7.setStatusBarColor(0);
    L24:
        if (r7 == null) goto L27;
        r7.setNavigationBarColor(0);
    L27:
        if (r7 == null) goto L30;
        r7.setDimAmount(this.a);
        return;
    L30:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public a(FragmentActivity r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
        setCancelable(false);
    }
}
