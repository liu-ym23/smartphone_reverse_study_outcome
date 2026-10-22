package com.google.common.primitives;

import com.lynx.tasm.utils.k;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9333b = 0;

    static {
        String r5 = "(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)".concat("(?:[eE][+-]?\\d+#)?[fFdD]?");
        StringBuilder r10 = new StringBuilder(78);
        r10.append("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?");
        String r11 = r10.toString();
        StringBuilder r12 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(androidx.room.jarjarred.org.antlr.runtime.a.g(23, r5), r11));
        r12.append("[+-]?(?:NaN|Infinity|");
        r12.append(r5);
        r12.append("|");
        r12.append(r11);
        r12.append(")");
        Pattern.compile(r12.toString().replace("#", "+"));
    }

    public static boolean s(double r5) {
        if (Double.NEGATIVE_INFINITY < r5) goto L5;
    L7:
        return false;
    L5:
        if (r5 >= Double.POSITIVE_INFINITY) goto L7;
        return true;
    }
}
