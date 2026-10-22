package com.ss.android.lark.keyboard.editor.input;

import android.net.Uri;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements FlowKeyboardFunctionEditText.c {
    public final /* synthetic */ BaseRichTextInputPlugin a;

    public f(BaseRichTextInputPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText.c
    public final boolean a(List<? extends Uri> r2) {
        Intrinsics.checkNotNullParameter(r2, "uris");
        wxa.a r0 = BaseRichTextInputPlugin.a(this.a);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.Y5(r2) != true) goto L7;
        return true;
    }
}
