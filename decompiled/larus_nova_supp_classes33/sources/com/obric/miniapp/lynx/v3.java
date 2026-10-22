package com.obric.miniapp.lynx;

import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import com.larus.utils.logger.FLogger;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v3 implements Runnable {
    public final /* synthetic */ LynxOUISearchBarUI a;
    public final /* synthetic */ OSearchBar b;
    public final /* synthetic */ OEditText c;

    public /* synthetic */ v3(LynxOUISearchBarUI r1, OSearchBar r2, OEditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxOUISearchBarUI r0 = this.a;
        OSearchBar r1 = this.b;
        OEditText r2 = this.c;
        int r3 = LynxOUISearchBarUI.i;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        r1.clearFocus();     // Catch: Throwable -> L20
        r2.clearFocus();     // Catch: Throwable -> L20
        e6 r5 = r0.b;     // Catch: Throwable -> L20
        if (r5 == null) goto L6;
        r5.requestFocus();     // Catch: Throwable -> L20
    L6:
        IBinder r6 = r2.getWindowToken();     // Catch: Throwable -> L20
        Boolean r7 = null;
        if (r6 != null) goto L12;
        e6 r8 = r0.b;     // Catch: Throwable -> L20
        if (r8 == null) goto L11;
        r6 = r8.getWindowToken();     // Catch: Throwable -> L20
        goto L12
    L11:
        r6 = null;
    L12:
        Object r9 = r2.getContext().getSystemService("input_method");     // Catch: Throwable -> L20
        if ((r9 instanceof InputMethodManager) == false) goto L15;
        InputMethodManager r10 = (InputMethodManager) r9;     // Catch: Throwable -> L20
    L16:
        if (r10 == null) goto L18;
        r7 = Boolean.valueOf(r10.hideSoftInputFromWindow(r6, 0));     // Catch: Throwable -> L20
    L18:
        Object r11 = Result.constructor-impl(r7);     // Catch: Throwable -> L20
    L22:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L28;
        FLogger.a.w("LynxOUISearchBarUI", "clearFocusAndHideIme failed", r12);
        return;
    L28:
        return;
    L15:
        r10 = null;
    L20:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
