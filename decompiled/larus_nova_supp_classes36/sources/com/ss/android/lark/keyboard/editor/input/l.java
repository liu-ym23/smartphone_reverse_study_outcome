package com.ss.android.lark.keyboard.editor.input;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends ImageEditor {
    public l() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor
    public final Object V(Context r3, hob.f r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "insertImageInfo");
        if (com.ss.android.lark.keyboard.edittext2.utils.d.a("im.keyboard.editor_support_view") == false) goto L7;
        com.ss.android.lark.keyboard.edittext2.edittors.image.a r5 = new com.ss.android.lark.keyboard.edittext2.edittors.image.a(r4.a);
        r5.b = UIUtils.dp2px(context(), 2.0f);
        r5.c = UIUtils.dp2px(context(), 1.0f);
        r5.d = r4.e;
        return r5;
    L7:
        return super.V(r3, r4);
    }
}
