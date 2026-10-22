package com.ctc.wstx.shaded.msv_core.reader.relax;

import com.ctc.wstx.shaded.msv_core.reader.d;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends d {
    @Override // com.ctc.wstx.shaded.msv_core.reader.d
    public String a(String r1, Object[] r2) {
        String r0 = ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.relax.Messages").getString(r1);     // Catch: Exception -> L4
    L6:
        return MessageFormat.format(r0, r2);
    L4:
        r0 = ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.reader.Messages").getString(r1);
        goto L6
    }
}
