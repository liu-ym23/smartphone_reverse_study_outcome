package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(RichTextFunctionEditText r2) {
        KeyboardVoiceFGUtils r0 = KeyboardVoiceFGUtils.a;
        if (((Boolean) KeyboardVoiceFGUtils.b.getValue()).booleanValue() == false) goto L6;
        if (r2 == 0) goto L6;
        return ((d) r2.q(d.g)).m(0, r2.getEditableText().length());
    L6:
        return null;
    }
}
