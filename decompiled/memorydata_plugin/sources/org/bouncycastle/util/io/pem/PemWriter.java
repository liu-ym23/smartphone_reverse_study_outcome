package org.bouncycastle.util.io.pem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Iterator;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes7.dex */
public class PemWriter extends BufferedWriter {
    private char[] buf;
    private final int nlLength;

    public PemWriter(Writer r1) {
        super(r1);
        this.buf = new char[64];
        String r2 = Strings.lineSeparator();
        if (r2 == null) goto L5;
        int r3 = r2.length();
    L6:
        this.nlLength = r3;
        return;
    L5:
        r3 = 2;
        goto L6
    }

    private void writeEncoded(byte[] r7) {
        byte[] r8 = Base64.encode(r7);
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L13;
        int r2 = 0;
    L6:
        char[] r3 = this.buf;
        if (r2 == r3.length) goto L12;
        int r4 = r1 + r2;
        if (r4 >= r8.length) goto L12;
        r3[r2] = (char) r8[r4];
        r2 = r2 + 1;
    L12:
        write(r3, 0, r2);
        newLine();
        r1 = r1 + this.buf.length;
        goto L4
    }

    private void writePostEncapsulationBoundary(String r3) {
        write("-----END " + r3 + "-----");
        newLine();
    }

    private void writePreEncapsulationBoundary(String r3) {
        write("-----BEGIN " + r3 + "-----");
        newLine();
    }

    public void writeObject(PemObjectGenerator r5) {
        PemObject r6 = ((PemObjectGenerator) ZeusTransformUtils.wrapperContextForParams(r5, PemObjectGenerator.class, "com.obric.memorydata.plugin")).generate();
        writePreEncapsulationBoundary(r6.getType());
        if (r6.getHeaders().isEmpty() == true) goto L9;
        Iterator r0 = r6.getHeaders().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        PemHeader r2 = (PemHeader) ZeusTransformUtils.preCheckCast(r0.next(), PemHeader.class, "com.obric.memorydata.plugin");
        write(r2.getName());
        write(": ");
        write(r2.getValue());
        newLine();
        goto L6
    L8:
        newLine();
    L9:
        writeEncoded(r6.getContent());
        writePostEncapsulationBoundary(r6.getType());
    }
}
