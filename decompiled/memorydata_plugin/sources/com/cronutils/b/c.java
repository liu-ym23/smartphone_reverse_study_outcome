package com.cronutils.b;

import androidx.exifinterface.media.ExifInterface;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f3404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f3405b = null;
    private static final Pattern c = null;
    private final FieldConstraints d;

    static {
        f3404a = new char[]{'/', '-', ','};
        f3405b = Pattern.compile("[0-9]L", 2);
        c = Pattern.compile("[0-9]W", 2);
    }

    public c(FieldConstraints r3) {
        this.d = (FieldConstraints) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r3, "FieldConstraints must not be null"), FieldConstraints.class, "com.obric.memorydata.plugin");
    }

    private FieldExpression a(String r4, String r5) {
        String r0 = r4.trim();
        if ("*".equals(r0) == false) goto L9;
        if (r5.equals("1") == false) goto L9;
        return k(r4);
    L9:
        if ("*".equals(r0) == true) goto L16;
        if ("".equals(r4.trim()) == true) goto L16;
        return new Every(new On(h(r4)), new IntegerFieldValue(Integer.parseInt(r5)));
    L16:
        return new Every(new IntegerFieldValue(Integer.parseInt(r5)));
    }

    private FieldExpression a(String r3, String[] r4) {
        if (r4.length <= 1) goto L7;
        return a(r4);
    L7:
        return b(r3, r3.split("/"));
    }

    private FieldExpression b(String r4, String[] r5) {
        if (r5.length != 2) goto L7;
        return a(r5[0], r5[1]);
    L7:
        if (r5.length != 1) goto L11;
        throw new IllegalArgumentException("Missing steps for expression: " + r4);
    L11:
        throw new IllegalArgumentException("Invalid expression: " + r4);
    }

    private FieldExpression b(String[] r5) {
        And r0 = new And();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.and(a(r5[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private FieldExpression k(String r2) {
        if ("*".equals(r2) == false) goto L7;
        return FieldExpression.always();
    L7:
        if ("?".equals(r2) == false) goto L11;
        return FieldExpression.questionMark();
    L11:
        return b(r2);
    }

    public int a(Integer r1) {
        Integer r0 = this.d.getIntMappingValue(r1);
        if (r0 == null) goto L7;
        return r0.intValue();
    L7:
        return r1.intValue();
    }

    public FieldExpression a(String r6) {
        if (com.cronutils.utils.c.a(r6, f3404a) == false) goto L5;
        String[] r0 = r6.split(",");
        if (r0.length > 1) goto L16;
        String[] r1 = r6.split("-");
        if (r6.contains("-") == false) goto L25;
        if (r1.length == 2) goto L25;
        throw new IllegalArgumentException("Missing values for range: " + r6);
    L25:
        if (r1[0].equalsIgnoreCase(i.u) == false) goto L28;
        return a(r1[0], h(r1[1]));
    L28:
        return a(r6, r1);
    L16:
        return b(r0);
    L5:
        if (r6.contains("?") == false) goto L12;
        if (this.d.getSpecialChars().contains(SpecialChar.QUESTION_MARK) == true) goto L12;
        throw new IllegalArgumentException("Invalid expression: " + r6);
    L12:
        return k(r6);
    }

    public FieldExpression a(String[] r6) {
        if (r6[0].isEmpty() == true) goto L13;
        if (r6[1].isEmpty() == true) goto L13;
        if (r6[1].contains("/") == false) goto L11;
        String[] r1 = r6[1].split("/");
        return new Every(new Between(i(r6[0]), i(r1[0])), h(r1[1]));
    L11:
        return new Between(i(r6[0]), i(r6[1]));
    L13:
        throw new IllegalArgumentException(String.format("Invalid expression! Expression: %s-%s does not describe a range. Negative numbers are not allowed.", new Object[]{r6[0], r6[1]}));
    }

    public On a(String r5, IntegerFieldValue r6) {
        SpecialCharFieldValue r0 = new SpecialCharFieldValue(SpecialChar.L);
        String r7 = r5.replace(i.u, "");
        IntegerFieldValue r1 = new IntegerFieldValue(-1);
        if ("".equals(r7) == true) goto L6;
        r1 = h(r7);
    L6:
        return new On(r1, r0, r6);
    }

    public On b(String r4) {
        if ("?".equals(r4) == false) goto L7;
        return d(r4);
    L7:
        if (r4.contains("#") == false) goto L11;
        return c(r4);
    L11:
        if (r4.contains("LW") == false) goto L15;
        return e(r4);
    L15:
        if (f3405b.matcher(r4).find() == true) goto L26;
        if (r4.equalsIgnoreCase(i.u) == true) goto L26;
        if (c.matcher(r4).find() == false) goto L24;
        return g(r4);
    L24:
        return new On(h(r4), new SpecialCharFieldValue(SpecialChar.NONE), new IntegerFieldValue(-1));
    L26:
        return f(r4);
    }

    public On c(String r5) {
        if (this.d.getSpecialChars().contains(SpecialChar.HASH) == false) goto L15;
        SpecialCharFieldValue r0 = new SpecialCharFieldValue(SpecialChar.HASH);
        String[] r6 = r5.split("#");
        if (r6.length == 0) goto L13;
        IntegerFieldValue r1 = h(r6[1]);
        if (r6[0].isEmpty() == true) goto L11;
        return new On(h(r6[0]), r0, r1);
    L11:
        throw new IllegalArgumentException("Time should be specified!");
    L13:
        throw new IllegalArgumentException("Invalid Position of # Character!");
    L15:
        throw new IllegalArgumentException("Invalid expression: " + r5);
    }

    public On d(String r4) {
        SpecialCharFieldValue r3 = new SpecialCharFieldValue(SpecialChar.QUESTION_MARK);
        String r5 = r4.replace("?", "");
        if ("".equals(r5) == false) goto L7;
        return new On(new IntegerFieldValue(-1), r3, new IntegerFieldValue(-1));
    L7:
        throw new IllegalArgumentException(String.format("Expected: '?', found: %s", new Object[]{r5}));
    }

    public On e(String r4) {
        SpecialCharFieldValue r3 = new SpecialCharFieldValue(SpecialChar.LW);
        String r5 = r4.replace("LW", "");
        if ("".equals(r5) == false) goto L7;
        return new On(new IntegerFieldValue(-1), r3, new IntegerFieldValue(-1));
    L7:
        throw new IllegalArgumentException(String.format("Expected: LW, found: %s", new Object[]{r5}));
    }

    public On f(String r3) {
        return a(r3, new IntegerFieldValue(-1));
    }

    public On g(String r4) {
        return new On(h(r4.replace(ExifInterface.LONGITUDE_WEST, "")), new SpecialCharFieldValue(SpecialChar.W), new IntegerFieldValue(-1));
    }

    public IntegerFieldValue h(String r3) {
        return new IntegerFieldValue(a(Integer.valueOf(j(r3))));
    L5:
        throw new IllegalArgumentException(String.format("Invalid value. Expected some integer, found %s", new Object[]{r3}));
    }

    public FieldValue<?> i(String r6) {
        SpecialChar[] r0 = SpecialChar.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        SpecialChar r3 = r0[r2];
        if (r3.toString().equals(r6) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return new SpecialCharFieldValue(r3);
    L10:
        return new IntegerFieldValue(j(r6));
    }

    public int j(String r4) {
        Integer r0 = this.d.getStringMappingValue(r4);
        if (r0 != null) goto L5;
        return Integer.parseInt(r4);
    L9:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r4, new com.cronutils.b(this.d).a(r4)}));
    L5:
        return r0.intValue();
    }
}
