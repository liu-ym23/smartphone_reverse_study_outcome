package com.ss.android.lark.insets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ Ref.ObjectRef<j> b;
    public final /* synthetic */ int c;

    public d(Dialog r1, Ref.ObjectRef<j> r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r2) {
        Window r3 = this.a.getWindow();
        if (r3 == null) goto L7;
        Map<Integer, WeakReference<j>> r0 = e.r;
        e.a.a(r3);
        int r1 = h.q;
        ((j) this.b.element).a = h.a.a(r3);
        e.r.remove(Integer.valueOf(this.c));
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
