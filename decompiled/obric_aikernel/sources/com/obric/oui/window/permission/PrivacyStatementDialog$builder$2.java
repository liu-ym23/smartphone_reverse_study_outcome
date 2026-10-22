package com.obric.oui.window.permission;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/content/DialogInterface;", "dialog", "", "which", "", "invoke", "(Landroid/content/DialogInterface;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PrivacyStatementDialog$builder$2 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ a this$0;

    PrivacyStatementDialog$builder$2(a r10) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DialogInterface r10, Integer r11) {
        invoke(r10, r11.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        Function0 r12 = a.b(this.this$0);
        if (r12 == null) goto L5;
        Unit r13 = (Unit) r12.invoke();
    L5:
        r10.dismiss();
    }
}
