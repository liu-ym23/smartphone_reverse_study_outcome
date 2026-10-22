package sob;

import android.app.Activity;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final boolean a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Activity r5 = ContextsKt.findActivity(r4);
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return false;
    L7:
        if (RomUtils.d[0].equals(RomUtils.e().a) == false) goto L10;
        return StringsKt.contains$default(r5.getResources().getConfiguration().toString(), "mWindowingMode=100", false, 2, null);
    L10:
        if (r5.isInMultiWindowMode() == true) goto L12;
        return false;
    L12:
        if (StringsKt.contains$default(r5.getResources().getConfiguration().toString(), "freeform", false, 2, null) == false) goto L19;
        return true;
    L19:
        return false;
    }

    public static final boolean b(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (StringsKt.trim(r3).length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> void c(MutableLiveData<T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (Intrinsics.areEqual(r1.getValue(), r2) == false) goto L5;
        return;
    L5:
        e(r1, r2);
    }

    public static final <T> void e(MutableLiveData<T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L5;
        r2.setValue(r3);
        return;
    L5:
        r2.postValue(r3);
    }

    public static final void f(ConstraintLayout r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }

    public static final void d(Object r1, String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "block");
        r3.invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("Extensions", "[safeRun][" + r2 + "] error", e);
    }
}
