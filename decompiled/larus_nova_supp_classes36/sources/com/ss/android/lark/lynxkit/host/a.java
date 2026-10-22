package com.ss.android.lark.lynxkit.host;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import tqb.c;
import tqb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends tqb.a implements ILarkLynxDialogHolder {
    public final FragmentActivity g;
    public String h;
    public LarkLynxDialogFragment i;

    @Override // tqb.a, tqb.g
    public final void d() {
        this.h = null;
        this.i = null;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxDialogHolder
    public final void dismiss() {
        LarkLynxCloseSource r0 = LarkLynxCloseSource.PROGRAMMATIC;
        Intrinsics.checkNotNullParameter(r0, "source");
        c r1 = this.f;
        if (r1 == null) goto L5;
        r1.K40(r0);
    L5:
        LarkLynxDialogFragment r2 = this.i;
        if (r2 == null) goto L14;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L14;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        if (this.e != null) goto L26;
        LarkLynxDialogFragment r4 = this.i;
        if (r4 == null) goto L20;
        boolean r5 = true;
        if (r4.isAdded() != true) goto L20;
    L21:
        if (r5 == true) goto L27;
        ConcurrentHashMap<String, tqb.d> r6 = f.a;
        f.c(this.h);
        this.h = null;
        this.i = null;
        return;
    L27:
        return;
    L20:
        r5 = false;
        goto L21
    }

    public final LarkLynxDialogFragment g() {
        LarkLynxDialogFragment r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if ((!isDestroyed()) == false) goto L10;
        ConcurrentHashMap<String, tqb.d> r1 = f.a;
        String r2 = f.b(this.a, this.b, false, this);
        this.h = r2;
        int r3 = LarkLynxDialogFragment.j;
        Intrinsics.checkNotNullParameter(r2, "hostId");
        LarkLynxDialogFragment r4 = new LarkLynxDialogFragment();
        Bundle r5 = new Bundle();
        r5.putString("extra_lynx_host_id", r2);
        r4.setArguments(r5);
        this.i = r4;
        return r4;
    L10:
        throw new IllegalStateException("LynxDialogHolder is destroyed".toString());
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void destroy() {
        super.destroy();
        ConcurrentHashMap<String, tqb.d> r0 = f.a;
        f.c(this.h);
        this.h = null;
        this.i = null;
    }

    @Override // tqb.a, tqb.g
    public final void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        Intrinsics.checkNotNullParameter(r2, "controller");
        this.f = r2;
        if ((r2 instanceof LarkLynxDialogFragment) == false) goto L6;
        this.i = (LarkLynxDialogFragment) r2;
        return;
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxDialogHolder
    public final DialogFragment getDialog(boolean r1) {
        if (r1 == false) goto L5;
        this.d = true;
    L5:
        return g();
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxDialogHolder
    public final boolean show(String r7) {
        if (isDestroyed() == false) goto L5;
        return false;
    L5:
        if (this.g.isFinishing() == false) goto L7;
        return false;
    L7:
        if (this.g.isDestroyed() == true) goto L39;
        int r0 = tqb.b.a;
        if (tqb.b.b(this.a) == true) goto L13;
        Log.e("LynxHostHolder", "show dialog failed, templateUrl and templatePath are empty");
        return false;
    L13:
        FragmentManager r1 = this.g.getSupportFragmentManager();
        if (r1.isStateSaved() == false) goto L16;
        return false;
    L16:
        LarkLynxDialogFragment r3 = g();
        if (r3.isAdded() == false) goto L19;
        return true;
    L19:
        this.d = true;
        if (r7 != null) goto L32;
        r7 = "LynxDialogFragment";
    L32:
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L28
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, r7, r4);     // Catch: Throwable -> L28
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r3, r4) == false) goto L34;
    L27:
        return true;
    L34:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31 Throwable -> L28
    L26:
        r3.show(r1, r7);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        ConcurrentHashMap<String, tqb.d> r2 = f.a;
        f.c(this.h);
        this.h = null;
        this.i = null;
        Log.e("LynxHostHolder", "show dialog failed", th);
        return false;
    L39:
        return false;
    }

    public a(FragmentActivity r2, LarkLynxHostParams r3, LarkLynxHostOptions r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "options");
        super(r3, r4);
        this.g = r2;
    }
}
