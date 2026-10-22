package qyb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final Activity a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Context r2 = r1.getContext();
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L10;
        if ((r2 instanceof Activity) == true) goto L8;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L4
    L8:
        return (Activity) r2;
    L10:
        return null;
    }

    public static final LifecycleRegistry b(View r1, LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "owner");
        LifecycleRegistry r0 = new LifecycleRegistry(r2);
        if (r1.isAttachedToWindow() == false) goto L5;
        r0.setCurrentState(Lifecycle.State.RESUMED);
    L5:
        r1.addOnAttachStateChangeListener(new c(r0));
        return r0;
    }

    public static void c(View r4, int r5) {
        int r0 = r4.getPaddingLeft();
        int r1 = r4.getPaddingTop();
        int r2 = r4.getPaddingRight();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.setPadding(r0, r1, r2, r5);
    }
}
