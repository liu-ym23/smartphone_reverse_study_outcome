package com.obric.oui.window.permission;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createClickableSpan$1$onClick$2 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    public static final PrivacyStatementActivity$createClickableSpan$1$onClick$2 INSTANCE = null;

    static {
        INSTANCE = new PrivacyStatementActivity$createClickableSpan$1$onClick$2();
    }

    public PrivacyStatementActivity$createClickableSpan$1$onClick$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(DialogInterface r5, Integer r10) {
        invoke(r5, r10.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r5.dismiss();
    }
}
