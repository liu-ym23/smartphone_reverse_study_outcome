package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import okio.Utf8;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public final enum FileMagic extends Enum<FileMagic> {
    private static final /* synthetic */ FileMagic[] $VALUES = null;
    public static final FileMagic BIFF2 = null;
    public static final FileMagic BIFF3 = null;
    public static final FileMagic BIFF4 = null;
    public static final FileMagic BMP = null;
    public static final FileMagic EMF = null;
    public static final FileMagic GIF = null;
    public static final FileMagic HTML = null;
    public static final FileMagic JPEG = null;
    static final int MAX_PATTERN_LENGTH = 44;
    public static final FileMagic MSWRITE = null;
    public static final FileMagic OLE2 = null;
    public static final FileMagic OOXML = null;
    public static final FileMagic PDF = null;
    public static final FileMagic PNG = null;
    public static final FileMagic RTF = null;
    public static final FileMagic TIFF = null;
    public static final FileMagic UNKNOWN = null;
    public static final FileMagic WMF = null;
    public static final FileMagic WORD2 = null;
    public static final FileMagic XML = null;
    final byte[][] magic;

    static {
        FileMagic r0 = new FileMagic("OLE2", 0, -2226271756974174256L);
        OLE2 = r0;
        FileMagic r1 = new FileMagic("OOXML", 1, new int[]{80, 75, 3, 4});
        OOXML = r1;
        FileMagic r4 = new FileMagic("XML", 2, new int[]{60, 63, 120, 109, 108});
        XML = r4;
        FileMagic r7 = new FileMagic("BIFF2", 3, new int[]{9, 0, 4, 0, 0, 0, 63, 0});
        BIFF2 = r7;
        FileMagic r10 = new FileMagic("BIFF3", 4, new int[]{9, 2, 6, 0, 0, 0, 63, 0});
        BIFF3 = r10;
        FileMagic r11 = new FileMagic("BIFF4", 5, new byte[][]{new byte[]{9, 4, 6, 0, 0, 0, Utf8.REPLACEMENT_BYTE, 0}, new byte[]{9, 4, 6, 0, 0, 0, 0, 1}});
        BIFF4 = r11;
        FileMagic r13 = new FileMagic("MSWRITE", 6, new byte[][]{new byte[]{49, -66, 0, 0}, new byte[]{50, -66, 0, 0}});
        MSWRITE = r13;
        FileMagic r14 = new FileMagic("RTF", 7, new String[]{"{\\rtf"});
        RTF = r14;
        FileMagic r5 = new FileMagic("PDF", 8, new String[]{"%PDF"});
        PDF = r5;
        FileMagic r12 = new FileMagic("HTML", 9, new String[]{"<!DOCTYP", "<html", "\n\r<html", "\r\n<html", "\r<html", "\n<html", "<HTML", "\r\n<HTML", "\n\r<HTML", "\r<HTML", "\n<HTML"});
        HTML = r12;
        FileMagic r8 = new FileMagic("WORD2", 10, new int[]{219, 165, 45, 0});
        WORD2 = r8;
        FileMagic r9 = new FileMagic("JPEG", 11, new byte[][]{new byte[]{-1, MessagePack.Code.FIXEXT16, -1, MessagePack.Code.STR32}, new byte[]{-1, MessagePack.Code.FIXEXT16, -1, MessagePack.Code.NEGFIXINT_PREFIX, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 74, 70, 73, 70, 0, 1}, new byte[]{-1, MessagePack.Code.FIXEXT16, -1, -18}, new byte[]{-1, MessagePack.Code.FIXEXT16, -1, -31, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 69, 120, 105, 102, 0, 0}});
        JPEG = r9;
        FileMagic r2 = new FileMagic("GIF", 12, new String[]{"GIF87a", "GIF89a"});
        GIF = r2;
        FileMagic r3 = new FileMagic("PNG", 13, new int[]{137, 80, 78, 71, 13, 10, 26, 10});
        PNG = r3;
        FileMagic r6 = new FileMagic("TIFF", 14, new String[]{"II*\u0000", "MM\u0000*"});
        TIFF = r6;
        FileMagic r15 = new FileMagic("WMF", 15, new int[]{215, 205, 198, 154});
        WMF = r15;
        FileMagic r16 = new FileMagic("EMF", 16, new int[]{1, 0, 0, 0, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 32, 69, 77, 70});
        EMF = r16;
        FileMagic r17 = new FileMagic("BMP", 17, new int[]{66, 77});
        BMP = r17;
        FileMagic r18 = new FileMagic("UNKNOWN", 18, new byte[][]{new byte[0]});
        UNKNOWN = r18;
        $VALUES = new FileMagic[]{r0, r1, r4, r7, r10, r11, r13, r14, r5, r12, r8, r9, r2, r3, r6, r15, r16, r17, r18};
    }

    private FileMagic(String r1, int r2, long r3) {
        super(r1, r2);
        byte[][] r4 = (byte[][]) Array.newInstance(byte.class, new int[]{1, 8});
        this.magic = r4;
        LittleEndian.putLong(r4[0], 0, r3);
    }

    private FileMagic(String r3, int r4, int... r5) {
        super(r3, r4);
        byte[] r6 = new byte[r5.length];
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r6[r0] = (byte) (r5[r0] & 255);
        r0 = r0 + 1;
        goto L4
    L6:
        this.magic = new byte[][]{r6};
    }

    private FileMagic(String r6, int r7, String... r8) {
        super(r6, r7);
        this.magic = new byte[r8.length][];
        int r9 = r8.length;
        int r10 = 0;
        int r0 = 0;
    L3:
        if (r10 >= r9) goto L5;
        this.magic[r0] = r8[r10].getBytes(LocaleUtil.CHARSET_1252);
        r10 = r10 + 1;
        r0 = r0 + 1;
        goto L3
    }

    private FileMagic(String r1, int r2, byte[]... r3) {
        super(r1, r2);
        this.magic = r3;
    }

    private static boolean findMagic(byte[] r6, byte[] r7) {
        int r0 = r6.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L10;
        byte r4 = r6[r2];
        int r5 = r3 + 1;
        if (r7[r3] == r4) goto L9;
        if (r4 == 63) goto L9;
        return false;
    L9:
        r2 = r2 + 1;
        r3 = r5;
        goto L3
    L10:
        return true;
    }

    public static InputStream prepareToCheckMagic(InputStream r1) {
        if (r1.markSupported() == false) goto L6;
        return r1;
    L6:
        return new BufferedInputStream(r1);
    }

    public static FileMagic valueOf(File r3) {
        FileInputStream r0 = new FileInputStream(r3);
        byte[] r1 = new byte[44];     // Catch: Throwable -> L11
        int r4 = IOUtils.readFully(r0, r1, 0, 44);     // Catch: Throwable -> L11
        if (r4 != (-1)) goto L8;
        FileMagic r5 = UNKNOWN;     // Catch: Throwable -> L11
        r0.close();
        return r5;
    L8:
        FileMagic r6 = valueOf(Arrays.copyOf(r1, r4));     // Catch: Throwable -> L11
        r0.close();
        return r6;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    public static FileMagic valueOf(InputStream r1) {
        if (r1.markSupported() == false) goto L7;
        return valueOf(IOUtils.peekFirstNBytes(r1, 44));
    L7:
        throw new IOException("getFileMagic() only operates on streams which support mark(int)");
    }

    public static FileMagic valueOf(String r2) {
        return (FileMagic) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileMagic.class, r2), FileMagic.class, "com.obric.memorydata.plugin");
    }

    public static FileMagic valueOf(byte[] r11) {
        FileMagic[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        FileMagic r4 = r0[r3];
        byte[][] r5 = r4.magic;
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L13;
        byte[] r8 = r5[r7];
        if (r11.length < r8.length) goto L12;
        if (findMagic(r8, r11) == false) goto L12;
        return r4;
    L12:
        r7 = r7 + 1;
        goto L5
    L13:
        r3 = r3 + 1;
        goto L3
    L15:
        return UNKNOWN;
    }

    public static FileMagic[] values() {
        return (FileMagic[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileMagic[].class, "com.obric.memorydata.plugin");
    }
}
