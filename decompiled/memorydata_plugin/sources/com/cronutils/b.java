package com.cronutils;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SpecialChar[] f3398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f3399b = null;
    private final Pattern c;
    private final Pattern d;

    static {
        f3398a = new SpecialChar[]{SpecialChar.L, SpecialChar.LW, SpecialChar.W};
        f3399b = Pattern.compile("[#\\?/\\*0-9]");
    }

    public b(FieldConstraints r2) {
        this.d = b(r2.getSpecialChars());
        this.c = a(r2.getStringMappingKeySet());
    }

    public String a(String r3) {
        Matcher r4 = f3399b.matcher(r3.toUpperCase());
        Matcher r5 = this.c.matcher(r4.replaceAll(""));
        return this.d.matcher(r5.replaceAll("")).replaceAll("").replaceAll("\\s+", "").replaceAll(",", "").replaceAll("-", "");
    }

    Pattern a(Set<String> r3) {
        return c((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    Pattern b(Set<SpecialChar> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet();
        SpecialChar[] r1 = f3398a;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        SpecialChar r4 = r1[r3];
        if (r8.contains(r4) == false) goto L7;
        r0.add(r4.name());
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return c(r0);
    }

    Pattern c(Set<String> r5) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder("\\b(");
        Iterator r7 = r4.iterator();
        if (r7.hasNext() == true) goto L6;
    L4:
        r6.append(")\\b");
        return Pattern.compile(r6.toString());
    L6:
        r6.append((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if (r7.hasNext() == false) goto L4;
        r6.append("|");
        goto L6
    }
}
