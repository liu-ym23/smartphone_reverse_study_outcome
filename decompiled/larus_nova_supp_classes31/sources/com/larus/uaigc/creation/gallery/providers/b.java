package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements com.larus.bmhome.share.panel.d {
    public final com.larus.bmhome.share.panel.d a;
    public final com.larus.bmhome.share.panel.d b;

    public final void f() {
        this.a.f();
        com.larus.bmhome.share.panel.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public final void onDismiss() {
        this.a.onDismiss();
        com.larus.bmhome.share.panel.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    public final void e(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        Function0 r1 = new a(r0, r3);
        this.a.e(r1);
        com.larus.bmhome.share.panel.d r4 = this.b;
        if (r4 == null) goto L6;
        r4.e(r1);
        return;
    }

    public b(com.larus.bmhome.share.panel.d r2, com.larus.bmhome.share.panel.d r3) {
        Intrinsics.checkNotNullParameter(r2, "primary");
        this.a = r2;
        this.b = r3;
    }

    public final boolean d(String r3, String r4, Boolean r5) {
        if (this.a.d(r3, r4, r5) == false) goto L10;
        com.larus.bmhome.share.panel.d r0 = this.b;
        if (r0 == null) goto L7;
        boolean r6 = r0.d(r3, r4, r5);
    L8:
        if (r6 == false) goto L10;
        return true;
    L7:
        r6 = true;
    L10:
        return false;
    }

    public final boolean b(Context r2, DialogFragment r3, View r4, jr9.a r5) {
        Intrinsics.checkNotNullParameter(r5, "shareItemConfig");
        if (this.a.b(r2, r3, r4, r5) == false) goto L6;
        return true;
    L6:
        com.larus.bmhome.share.panel.d r0 = this.b;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.b(r2, r3, r4, r5);
    }
}
