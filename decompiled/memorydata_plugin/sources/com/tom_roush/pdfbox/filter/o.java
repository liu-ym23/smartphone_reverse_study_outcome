package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class o extends j {
    public o() {
    }

    private int a(int r1, int r2) {
        if (r1 < (2048 - r2)) goto L7;
        return 12;
    L7:
        if (r1 < (1024 - r2)) goto L11;
        return 11;
    L11:
        if (r1 < (512 - r2)) goto L14;
        return 10;
    L14:
        return 9;
    }

    private List<byte[]> a() {
        ArrayList r4 = new ArrayList(4096);
        int r1 = 0;
    L4:
        if (r1 >= 256) goto L6;
        r4.add(new byte[]{(byte) (r1 & 255)});
        r1 = r1 + 1;
        goto L4
    L6:
        r4.add(null);
        r4.add(null);
        return r4;
    }

    private void a(InputStream r13, OutputStream r14, int r15) {
        List<byte[]> r1 = new ArrayList();
        com.tom_roush.harmony.a.a.a.c r2 = new com.tom_roush.harmony.a.a.a.c(r13);
    L3:
        int r5 = 9;
        long r6 = -1;
    L22:
        long r8 = r2.a(r5);     // Catch: EOFException -> L19
        if (r8 == 257) goto L20;
        if (r8 == 256) goto L8;
        if (r8 < r1.size()) goto L13;
        a(r1, r6, r2);     // Catch: EOFException -> L19
        byte[] r7 = (byte[]) ZeusTransformUtils.preCheckCast(r1.get((int) r6), byte[].class, "com.obric.memorydata.plugin");     // Catch: EOFException -> L19
        byte[] r9 = Arrays.copyOf(r7, r7.length + 1);     // Catch: EOFException -> L19
        r9[r7.length] = r7[0];     // Catch: EOFException -> L19
        r14.write(r9);     // Catch: EOFException -> L19
        r1.add(r9);     // Catch: EOFException -> L19
    L17:
        r5 = a(r1.size(), r15);     // Catch: EOFException -> L19
        r6 = r8;
        goto L22
    L13:
        byte[] r10 = (byte[]) ZeusTransformUtils.preCheckCast(r1.get((int) r8), byte[].class, "com.obric.memorydata.plugin");     // Catch: EOFException -> L19
        byte r11 = r10[0];     // Catch: EOFException -> L19
        r14.write(r10);     // Catch: EOFException -> L19
        if (r6 == (-1)) goto L17;
        a(r1, r6, r2);     // Catch: EOFException -> L19
        byte[] r12 = (byte[]) ZeusTransformUtils.preCheckCast(r1.get((int) r6), byte[].class, "com.obric.memorydata.plugin");     // Catch: EOFException -> L19
        byte[] r16 = Arrays.copyOf(r12, r12.length + 1);     // Catch: EOFException -> L19
        r16[r12.length] = r11;     // Catch: EOFException -> L19
        r1.add(r16);     // Catch: EOFException -> L19
        goto L17
    L8:
        r1 = a();     // Catch: EOFException -> L19
    L20:
        r14.flush();
        return;
    L19:
        Log.w("PdfBox-Android", "Premature EOF in LZW stream, EOD code missing");
        goto L20
    }

    private void a(List<byte[]> r4, long r5, com.tom_roush.harmony.a.a.a.c r7) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 < 0) goto L10;
        if (r5 >= r3.size()) goto L8;
        return;
    L8:
        throw new IOException("array index overflow: " + r5 + " >= " + r3.size() + " near offset " + r7.d());
    L10:
        throw new IOException("negative array index: " + r5 + " near offset " + r7.d());
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r3, OutputStream r4, com.tom_roush.pdfbox.a.d r5, int r6) {
        com.tom_roush.pdfbox.a.d r7 = a(r5, r6);
        int r1 = 1;
        int r0 = r7.b(com.tom_roush.pdfbox.a.i.cr, 1);
        if (r0 == 0) goto L6;
        if (r0 == 1) goto L6;
    L7:
        a(r3, p.a(r4, r7), r1);
        return new i(r5);
    L6:
        r1 = r0;
        goto L7
    }
}
