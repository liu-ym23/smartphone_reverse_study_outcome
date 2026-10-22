package org.jsoup.nodes;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jsoup.SerializationException;

/* JADX INFO: loaded from: classes7.dex */
public class a implements Cloneable, Map.Entry<String, String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f18256b = null;
    private static final Pattern e = null;
    private static final Pattern f = null;
    private static final Pattern g = null;
    private static final Pattern h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f18257a;
    private String c;
    private String d;

    static {
        f18256b = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", BuildConfig.FLAVOR, "sortable", "truespeed", "typemustmatch"};
        e = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
        f = Pattern.compile("[^-a-zA-Z0-9_:.]");
        g = Pattern.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
        h = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");
    }

    public a(String r1, String r2, b r3) {
        org.jsoup.helper.b.a(r1);
        String r4 = r1.trim();
        org.jsoup.helper.b.a(r4);
        this.c = r4;
        this.d = r2;
        this.f18257a = r3;
    }

    public static String a(String r4, Document.OutputSettings.Syntax r5) {
        if (r5 != Document.OutputSettings.Syntax.xml) goto L11;
        Pattern r0 = e;
        if (r0.matcher(r4).matches() == true) goto L11;
        String r6 = f.matcher(r4).replaceAll("");
        if (r0.matcher(r6).matches() == true) goto L9;
        return null;
    L9:
        return r6;
    L11:
        if (r5 != Document.OutputSettings.Syntax.html) goto L18;
        Pattern r7 = g;
        if (r7.matcher(r4).matches() == true) goto L18;
        String r8 = h.matcher(r4).replaceAll("");
        if (r7.matcher(r8).matches() == true) goto L17;
        return null;
    L17:
        return r8;
    L18:
        return r4;
    }

    public static void a(String r2, String r3, Appendable r4, Document.OutputSettings r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        String r7 = a(r2, r5.d());
        if (r7 != null) goto L5;
        return;
    L5:
        b(r7, r3, r6, r5);
    }

    public static boolean a(String r1, String r2, Document.OutputSettings r3) {
        if (r3.d() != Document.OutputSettings.Syntax.html) goto L12;
        if (r2 != null) goto L6;
    L11:
        return true;
    L6:
        if (r2.isEmpty() == true) goto L10;
        if (r2.equalsIgnoreCase(r1) == false) goto L12;
    L10:
        if (b(r1) == true) goto L11;
    L12:
        return false;
    }

    static void b(String r7, String r8, Appendable r9, Document.OutputSettings r10) {
        Appendable r11 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r9, Appendable.class, "com.obric.memorydata.plugin");
        r11.append(r7);
        if (a(r7, r8, r10) == true) goto L6;
        r11.append("=\"");
        Entities.a(r11, b.a(r8), r10, true, false, false, false);
        r11.append(Typography.quote);
        return;
    }

    public static boolean b(String r1) {
        if (Arrays.binarySearch(f18256b, org.jsoup.a.a.a(r1)) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String a() {
        return this.c;
    }

    public String a(String r4) {
        String r0 = this.d;
        b r1 = this.f18257a;
        if (r1 == null) goto L7;
        int r2 = r1.a(this.c);
        if (r2 == (-1)) goto L7;
        r0 = this.f18257a.b(this.c);
        this.f18257a.f18259b[r2] = r4;
    L7:
        this.d = r4;
        return b.a(r0);
    }

    public void a(Appendable r3, Document.OutputSettings r4) {
        Appendable r5 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
        a(this.c, this.d, r5, r4);
    }

    public String b() {
        return b.a(this.d);
    }

    public String c() {
        StringBuilder r0 = org.jsoup.a.b.a();
        a(r0, new Document("").j());     // Catch: IOException -> L6
        return org.jsoup.a.b.a(r0);
    L6:
        e = move-exception;
        throw new SerializationException(e);
    }

    public /* synthetic */ Object clone() {
        return d();
    }

    public a d() {
        return (a) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L26;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        String r2 = this.c;
        if (r2 == null) goto L16;
        if (r2.equals(r6.c) == false) goto L17;
    L18:
        String r4 = this.d;
        if (r4 == null) goto L22;
        return r4.equals(r6.d);
    L22:
        if (r6.d != null) goto L25;
        return true;
    L25:
        return false;
    L17:
        return false;
    L16:
        if (r6.c == null) goto L18;
        goto L17
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String getValue() {
        return b();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.d;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // java.util.Map.Entry
    public /* synthetic */ String setValue(String r3) {
        return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        return c();
    }
}
