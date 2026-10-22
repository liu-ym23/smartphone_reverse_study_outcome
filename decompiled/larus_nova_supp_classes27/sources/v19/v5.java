package v19;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v5 {
    public final Rect a;
    public int b;

    public v5() {
        this.a = new Rect();
    }

    public final void a(final FragmentActivity r4, final View r5, final Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r6, "keyBoardHeightChange");
        if (Build.VERSION.SDK_INT >= 30) goto L18;
        Window r7 = r4.getWindow();
        if (r7 == null) goto L17;
        final View r8 = r7.getDecorView();
        if (c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L11;
        c.a(r0, "getDecorView");
    L11:
        if (r8 == null) goto L20;
        View r1 = r8.findViewById(R.id.content);
        if (r1 != null) goto L16;
        return;
    L16:
        r1.getViewTreeObserver().addOnGlobalLayoutListener(new t5(r8, this, r4, r6));
        return;
    L20:
        return;
    L17:
        return;
    L18:
        ViewExtKt.a(r5, new u5(r5, r4, this, r6));
    }
}
