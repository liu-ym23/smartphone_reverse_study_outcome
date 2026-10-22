package sjb;

import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BasePopupWindow {
    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (isOutsideTouchable() == true) goto L29;
        StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
        Intrinsics.checkNotNull(r0);
        boolean r2 = true;
        if (r0.length != 0) goto L7;
        boolean r1 = true;
    L9:
        if ((!r1) == false) goto L29;
        if (r0.length <= 3) goto L29;
        StackTraceElement r3 = r0[3];
        String r4 = r3.getClassName();
        String r5 = r3.getMethodName();
        String r6 = PopupWindow.class.getName();
        if (TextUtils.equals(r6.concat("$PopupDecorView"), r4) == true) goto L22;
        Intrinsics.checkNotNull(r4);
        if (r4.length() > 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L29;
        Intrinsics.checkNotNull(r6);
        if (StringsKt.contains$default(r4, r6, false, 2, null) == false) goto L29;
    L22:
        if ("dispatchKeyEvent".equals(r5) == true) goto L29;
        if ("onTouchEvent".equals(r5) == false) goto L29;
        if (isOutsideTouchable() == true) goto L29;
        return;
    L7:
        r1 = false;
    L29:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    public a(View r1, int r2, int r3) {
        super(r1, r2, r3);
    }
}
