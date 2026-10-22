package com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(String r2, Object r3) {
        return a(r2, new Object[]{r3});
    }

    public static String a(String r1, Object[] r2) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax.Messages").getString(r1), r2);
    }
}
