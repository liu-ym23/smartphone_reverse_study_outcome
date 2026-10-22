package com.google.zxing.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5068a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<CharsetEncoder> f5069b = null;
    private final CharsetEncoder[] c;
    private final int d;

    static {
        f5069b = new ArrayList();
        String[] r1 = {"IBM437", "ISO-8859-2", "ISO-8859-3", "ISO-8859-4", "ISO-8859-5", "ISO-8859-6", "ISO-8859-7", "ISO-8859-8", "ISO-8859-9", "ISO-8859-10", "ISO-8859-11", "ISO-8859-13", "ISO-8859-14", "ISO-8859-15", "ISO-8859-16", "windows-1250", "windows-1251", "windows-1252", "windows-1256", "Shift_JIS"};
        int r2 = 0;
    L3:
        if (r2 >= 20) goto L8;
        String r3 = r1[r2];
        if (CharacterSetECI.getCharacterSetECIByName(r3) == null) goto L7;
        f5069b.add(Charset.forName(r3).newEncoder());     // Catch: UnsupportedCharsetException -> L9
    L7:
        r2 = r2 + 1;
        goto L3
    }

    public c(String r11, Charset r12, int r13) {
        ArrayList r0 = new ArrayList();
        r0.add(StandardCharsets.ISO_8859_1.newEncoder());
        if (r12 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        int r4 = 0;
    L10:
        if (r4 >= r11.length()) goto L31;
        Iterator r5 = r0.iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        CharsetEncoder r7 = (CharsetEncoder) ZeusTransformUtils.preCheckCast(r5.next(), CharsetEncoder.class, "com.obric.memorydata.plugin");
        char r8 = r11.charAt(r4);
        if (r8 == r13) goto L18;
        if (r7.canEncode(r8) == false) goto L13;
    L18:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L27;
        Iterator<CharsetEncoder> r9 = f5069b.iterator();
    L23:
        if (r9.hasNext() == false) goto L27;
        CharsetEncoder r10 = (CharsetEncoder) ZeusTransformUtils.preCheckCast(r9.next(), CharsetEncoder.class, "com.obric.memorydata.plugin");
        if (r10.canEncode(r11.charAt(r4)) == false) goto L23;
        r0.add(r10);
        r6 = true;
    L27:
        if (r6 == true) goto L29;
        r3 = true;
    L29:
        r4 = r4 + 1;
        goto L10
    L19:
        r6 = false;
        goto L20
    L31:
        if (r0.size() != 1) goto L34;
        if (r3 == true) goto L34;
        this.c = new CharsetEncoder[]{(CharsetEncoder) ZeusTransformUtils.preCheckCast(r0.get(0), CharsetEncoder.class, "com.obric.memorydata.plugin")};
    L39:
        int r14 = -1;
        if (r12 == null) goto L50;
        int r15 = 0;
    L42:
        CharsetEncoder[] r1 = this.c;
        if (r15 >= r1.length) goto L50;
        if (r1[r15] == null) goto L49;
        if (r12.name().equals(this.c[r15].charset().name()) == false) goto L49;
        r14 = r15;
    L49:
        r15 = r15 + 1;
    L50:
        this.d = r14;
        if (f5068a == false) goto L53;
        return;
    L53:
        if (this.c[0].charset().equals(StandardCharsets.ISO_8859_1) == false) goto L56;
        return;
    L56:
        throw new AssertionError();
    L34:
        this.c = new CharsetEncoder[r0.size() + 2];
        Iterator r16 = r0.iterator();
        int r17 = 0;
    L36:
        if (r16.hasNext() == false) goto L38;
        this.c[r17] = (CharsetEncoder) ZeusTransformUtils.preCheckCast(r16.next(), CharsetEncoder.class, "com.obric.memorydata.plugin");
        r17 = r17 + 1;
        goto L36
    L38:
        this.c[r17] = StandardCharsets.UTF_8.newEncoder();
        this.c[r17 + 1] = StandardCharsets.UTF_16BE.newEncoder();
        goto L39
    L5:
        if (r12.name().startsWith("UTF") == false) goto L7;
        r3 = true;
        goto L8
    }

    public int a() {
        return this.c.length;
    }

    public Charset a(int r2) {
        if (f5068a == true) goto L10;
        if (r2 < a()) goto L10;
        throw new AssertionError();
    L10:
        return this.c[r2].charset();
    }

    public boolean a(char r2, int r3) {
        if (f5068a == true) goto L10;
        if (r3 < a()) goto L10;
        throw new AssertionError();
    L10:
        return this.c[r3].canEncode("" + r2);
    }

    public byte[] a(String r2, int r3) {
        if (f5068a == true) goto L10;
        if (r3 < a()) goto L10;
        throw new AssertionError();
    L10:
        return r2.getBytes(this.c[r3].charset());
    }

    public int b() {
        return this.d;
    }

    public int b(int r1) {
        return CharacterSetECI.getCharacterSetECI(this.c[r1].charset()).getValue();
    }
}
