package com.larus.avlink.env.diary.style;

import android.content.Context;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t implements p0 {
    public final /* synthetic */ Ref.ObjectRef<CommonDialog> a;
    public final /* synthetic */ DiaryStyleFragment b;
    public final /* synthetic */ e0 c;
    public final /* synthetic */ Context d;

    public final void confirm() {
        CommonDialog r0 = (CommonDialog) this.a.element;
        if (r0 != null) goto L12;
    L10:
        FLogger.a.i(this.b.e, "deleteStyle: " + this.c.a);
        DiaryStyleViewModel r1 = this.b.V90();
        e0 r2 = this.c;
        final Context r3 = this.d;
        r1.deleteStyle(r2, new s(r3));
        return;
    L12:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L10;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public t(Ref.ObjectRef<CommonDialog> r1, DiaryStyleFragment r2, e0 r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
