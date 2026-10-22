package ue;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.ec.adapter.impl.converter.c;
import com.bytedance.android.ec.adapter.impl.converter.i;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Application.ActivityLifecycleCallbacks {
    public a() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Class<? super Object> r0 = r10.getClass().getSuperclass();
        Context r1 = null;
        if (r0 == null) goto L7;
        Class<? super Object> r11 = r0.getSuperclass();
        if (r11 == null) goto L7;
        String r12 = r11.getSimpleName();
    L9:
        if (TextUtils.equals(r12, "GenerateProxyAppCompatActivity") == false) goto L11;
    L45:
        Object r13 = com.bytedance.android.ec.adapter.impl.utils.a.a(r10);     // Catch: Exception -> L23
        if (r13 == null) goto L22;
        Activity r14 = (Activity) r13;     // Catch: Exception -> L23
    L26:
        r14.hashCode();
        int r15 = r14.hashCode();
        Integer r16 = b.a;
        if (r16 != null) goto L30;
        return;
    L30:
        if (r15 != r16.intValue()) goto L47;
        b.a = null;
        Iterator<T> r17 = c.a.iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        ((i) r17.next()).clear();
        goto L33
    L35:
        Context r18 = r10.getApplicationContext();
        if ((r18 instanceof Application) == false) goto L39;
        r1 = r18;
    L39:
        Application r19 = (Application) r1;
        if (r19 == null) goto L48;
        r19.unregisterActivityLifecycleCallbacks(this);
        return;
    L48:
        return;
    L47:
        return;
    L19:
        Exception e = e;
    L25:
        e.printStackTrace();
        goto L26
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e = e;
        r14 = r10;
        goto L25
    L11:
        if (TextUtils.equals(r12, "GenerateProxyActivity") == true) goto L45;
        r14 = r10;
    L7:
        r12 = null;
        goto L9
    }
}
