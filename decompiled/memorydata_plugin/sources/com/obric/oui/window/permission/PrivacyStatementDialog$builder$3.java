package com.obric.oui.window.permission;

import android.content.DialogInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementDialog$builder$3 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ a this$0;

    PrivacyStatementDialog$builder$3(a r1) {
        this.this$0 = r1;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(DialogInterface r3, Integer r4) {
        invoke((DialogInterface) ZeusTransformUtils.preCheckCast(r3, DialogInterface.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        Function0 r1 = a.b(this.this$0);
        if (r1 == null) goto L6;
        r1.invoke();
    L6:
        r4.dismiss();
    }
}
