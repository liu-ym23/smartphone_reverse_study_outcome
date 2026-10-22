package htb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.OfficeSdkLarkDependencyInjector;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.webview.OfficeWebViewLarkDependencyInjector;
import com.ss.android.lark.officewebview.util.b;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final AtomicBoolean a = null;

    static {
        a = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == false) goto L13;
        OfficeSdkLarkDependencyInjector.a();
        OfficeWebViewLarkDependencyInjector.a();
        Application r0 = LarkContext.getApplication();
        WeakReference<Activity> r1 = b.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Context r2 = r0.getApplicationContext();
        if ((r2 instanceof Application) == false) goto L7;
        Application r3 = (Application) r2;
    L8:
        if (r3 == null) goto L10;
        r3.unregisterActivityLifecycleCallbacks(b.b);
    L10:
        if (r3 == null) goto L14;
        r3.registerActivityLifecycleCallbacks(b.b);
        return;
    L14:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
