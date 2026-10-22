package zfb;

import android.view.View;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final void a(BaseFragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        View r0 = r4.getWindow().getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == c.a) goto L7;
        c.a(r1, "getDecorView");
    L7:
        ViewTreeLifecycleOwner.set(r0, r4);
        ViewTreeViewModelStoreOwner.set(r0, r4);
        ViewTreeSavedStateRegistryOwner.set(r0, r4);
    }
}
