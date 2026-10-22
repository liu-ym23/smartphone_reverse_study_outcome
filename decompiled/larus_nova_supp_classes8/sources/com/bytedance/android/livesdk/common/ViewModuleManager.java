package com.bytedance.android.livesdk.common;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ViewModuleManager extends Fragment {
    public static final String g = null;
    public View d;
    public final List<a> e;
    public int f;

    static {
        g = ViewModuleManager.class.getCanonicalName();
    }

    public final void onDestroy() {
        if (this.f != 6) goto L5;
        return;
    L5:
        this.f = 6;
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L7:
        if (r0.hasNext() == false) goto L33;
        a r1 = (a) r0.next();
        Iterator r2 = ((HashSet) r1.b).iterator();
    L10:
        if (r2.hasNext() == false) goto L32;
        Dialog r3 = (Dialog) r2.next();
        if (r3 == null) goto L10;
        if (r3.isShowing() == false) goto L10;
        Handler r4 = DialogLancet.resolveDialogHandler(r3);
        if (r4 == null) goto L20;
        if (Looper.myLooper() == r4.getLooper()) goto L20;
        r4.post(DialogLancet.createDismissRunnable(r3));
    L20:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r3);
        goto L10
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r5 == null) goto L29;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L32:
        ((HashSet) r1.b).clear();
        goto L7
    L33:
        ((CopyOnWriteArrayList) this.e).clear();
        super.onDestroy();
    }

    public ViewModuleManager() {
        this.e = new CopyOnWriteArrayList();
        this.f = 0;
    }

    public final void onPause() {
        super.onPause();
        this.f = 4;
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).getClass();
        goto L4
    }

    public final void onResume() {
        super.onResume();
        this.f = 3;
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).getClass();
        goto L4
    }

    public final void onStart() {
        super.onStart();
        this.f = 2;
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).getClass();
        goto L4
    }

    public final void onStop() {
        super.onStop();
        this.f = 5;
        Iterator r0 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).getClass();
        goto L4
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.f = 1;
        Iterator r4 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        a r0 = (a) r4.next();
        r0.a = this.d;
        goto L4
    }

    public final void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        Iterator r3 = ((CopyOnWriteArrayList) this.e).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((a) r3.next()).getClass();
        goto L4
    }
}
