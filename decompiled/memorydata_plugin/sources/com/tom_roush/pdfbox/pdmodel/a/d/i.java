package com.tom_roush.pdfbox.pdmodel.a.d;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i {
    public static final String A = "TH";
    public static final String B = "TD";
    public static final String C = "THead";
    public static final String D = "TBody";
    public static final String E = "TFoot";
    public static final String F = "Span";
    public static final String G = "Quote";
    public static final String H = "Note";
    public static final String I = "Reference";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f16174J = "BibEntry";
    public static final String K = "Code";
    public static final String L = "Link";
    public static final String M = "Annot";
    public static final String N = "Ruby";
    public static final String O = "RB";
    public static final String P = "RT";
    public static final String Q = "RP";
    public static final String R = "Warichu";
    public static final String S = "WT";
    public static final String T = "WP";
    public static final String U = "Figure";
    public static final String V = "Formula";
    public static final String W = "Form";
    public static List<String> X = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16175a = "Document";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16176b = "Part";
    public static final String c = "Art";
    public static final String d = "Sect";
    public static final String e = "Div";
    public static final String f = "BlockQuote";
    public static final String g = "Caption";
    public static final String h = "TOC";
    public static final String i = "TOCI";
    public static final String j = "Index";
    public static final String k = "NonStruct";
    public static final String l = "Private";
    public static final String m = "P";
    public static final String n = "H";
    public static final String o = "H1";
    public static final String p = "H2";
    public static final String q = "H3";
    public static final String r = "H4";
    public static final String s = "H5";
    public static final String t = "H6";
    public static final String u = "L";
    public static final String v = "LI";
    public static final String w = "Lbl";
    public static final String x = "LBody";
    public static final String y = "Table";
    public static final String z = "TR";

    static {
        X = new ArrayList();
        Field[] r1 = i.class.getFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L14;
        Field r4 = r1[r3];
        if (Modifier.isFinal(r4.getModifiers()) == false) goto L13;
        X.add(r4.get(null).toString());     // Catch: IllegalAccessException -> L8 IllegalArgumentException -> L10
    L8:
        e = move-exception;
        String r5 = e.getMessage();
        Throwable r6 = e;
    L12:
        Log.e("PdfBox-Android", r5, r6);
    L10:
        e = move-exception;
        r5 = e.getMessage();
        r6 = e;
    L13:
        r3 = r3 + 1;
        goto L3
    L14:
        Collections.sort(X);
    }

    private i() {
    }
}
