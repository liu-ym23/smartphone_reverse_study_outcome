package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o0 implements ActionMode.Callback {
    public final /* synthetic */ Function1<Boolean, Boolean> a;
    public final /* synthetic */ Function0<Boolean> b;

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r1, Menu r2) {
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r1) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Function1<? super Boolean, Boolean> r1, Function0<Boolean> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
        if (r6 == null) goto L4;
        Integer r7 = Integer.valueOf(r6.getItemId());
    L6:
        if (r7 != null) goto L9;
    L16:
        if (r7 != null) goto L19;
    L25:
        if (r7 != null) goto L28;
    L15:
        boolean r8 = false;
    L34:
        if (r8 == true) goto L36;
        return false;
    L36:
        if (r5 == null) goto L38;
        r5.finish();
    L38:
        return true;
    L28:
        if (r7.intValue() != 16908322) goto L15;
        Function0<Boolean> r9 = this.b;
        if (r9 == null) goto L15;
        if (((Boolean) r9.invoke()).booleanValue() != true) goto L15;
    L14:
        r8 = true;
        goto L34
    L19:
        if (r7.intValue() != 16908320) goto L25;
        Function1<Boolean, Boolean> r10 = this.a;
        if (r10 == null) goto L15;
        if (((Boolean) r10.invoke(Boolean.TRUE)).booleanValue() != true) goto L15;
    L9:
        if (r7.intValue() != 16908321) goto L16;
        Function1<Boolean, Boolean> r11 = this.a;
        if (r11 == null) goto L15;
        if (((Boolean) r11.invoke(Boolean.FALSE)).booleanValue() != true) goto L15;
    L4:
        r7 = null;
        goto L6
    }
}
