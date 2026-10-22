package org.bouncycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class Hex {
    private static final HexEncoder encoder = null;

    static {
        encoder = new HexEncoder();
    }

    public static byte[] decode(String r3) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        encoder.decode(r3, r0);     // Catch: Exception -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] decodeStrict(String r3) {
        return encoder.decodeStrict(r3, 0, r3.length());
    L4:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] decodeStrict(String r1, int r2, int r3) {
        return encoder.decodeStrict(r1, r2, r3);
    L4:
        e = move-exception;
        throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
    }

    public static byte[] encode(byte[] r2) {
        return encode(r2, 0, r2.length);
    }

    public static byte[] encode(byte[] r2, int r3, int r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        encoder.encode(r2, r3, r4, r0);     // Catch: Exception -> L6
        return r0.toByteArray();
    L6:
        e = move-exception;
        throw new EncoderException("exception encoding Hex string: " + e.getMessage(), e);
    }

    public static String toHexString(byte[] r2) {
        return toHexString(r2, 0, r2.length);
    }

    public static String toHexString(byte[] r0, int r1, int r2) {
        return Strings.fromByteArray(encode(r0, r1, r2));
    }
}
