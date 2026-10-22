package com.lynx.canvas;

import android.util.Pair;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonUniformLayoutSTD140Fix {
    public KryptonUniformLayoutSTD140Fix() {
    }

    public static String polyfill(String r7) {
        if (PatternProtector.compile("^\\\\s*#version\\\\s+300\\\\s+es").matcher(r7).matches() == false) goto L5;
        return r7;
    L5:
        Matcher r0 = PatternProtector.compile("(es|;)\\s*uniform\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s+\\{").matcher(r7);
        ArrayList r1 = new ArrayList();
    L7:
        if (r0.find() == false) goto L12;
        String r2 = ";\n layout(std140) uniform " + r0.group(2) + " {";
        if (Objects.equals(r0.group(1), "es") == false) goto L11;
        r2 = "es\n layout(std140) uniform " + r0.group(2) + " {";
    L11:
        r1.add(new Pair(r0.group(), r2));
        goto L7
    L12:
        Iterator r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        Pair r4 = (Pair) r3.next();
        r7 = r7.replace((CharSequence) r4.first, (CharSequence) r4.second);
        goto L14
    L16:
        return r7;
    }
}
