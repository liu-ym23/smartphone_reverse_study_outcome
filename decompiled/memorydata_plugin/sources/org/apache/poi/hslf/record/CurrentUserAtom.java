package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hslf.exceptions.CorruptPowerPointFileException;
import org.apache.poi.hslf.exceptions.OldPowerPointFormatException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public class CurrentUserAtom {
    private static final c LOG = null;
    private static final byte[] atomHeader = null;
    private static final byte[] encHeaderToken = null;
    private static final byte[] headerToken = null;
    private byte[] _contents;
    private long currentEditOffset;
    private int docFinalVersion;
    private byte docMajorNo;
    private byte docMinorNo;
    private boolean isEncrypted;
    private String lastEditUser;
    private long releaseVersion;

    static {
        LOG = b.a(CurrentUserAtom.class);
        atomHeader = new byte[]{0, 0, -10, 15};
        headerToken = new byte[]{95, MessagePack.Code.NIL, -111, -29};
        encHeaderToken = new byte[]{MessagePack.Code.MAP32, MessagePack.Code.BIN8, MessagePack.Code.INT16, -13};
    }

    public CurrentUserAtom() {
        this._contents = new byte[0];
        this.docFinalVersion = 1012;
        this.docMajorNo = 3;
        this.docMinorNo = 0;
        this.releaseVersion = 8;
        this.currentEditOffset = 0;
        this.lastEditUser = "Apache POI";
        this.isEncrypted = false;
    }

    public CurrentUserAtom(DirectoryNode r5) {
        DocumentEntry r1 = (DocumentEntry) ZeusTransformUtils.preCheckCast(r5.getEntry("Current User"), DocumentEntry.class, "com.obric.memorydata.plugin");
        if (r1.getSize() > 131072) goto L35;
        DocumentInputStream r0 = r5.createDocumentInputStream("Current User");
        this._contents = IOUtils.toByteArray(r0, r1.getSize(), RecordAtom.getMaxRecordLength());     // Catch: Throwable -> L25
        if (r0 == null) goto L9;
        r0.close();
    L9:
        if (this._contents.length >= 28) goto L23;
        boolean r6 = r5.hasEntry("PP40");
        if (r6 == true) goto L18;
        byte[] r2 = this._contents;
        if (r2.length < 4) goto L18;
        if ((LittleEndian.getInt(r2) + 4) != this._contents.length) goto L17;
        r6 = true;
        goto L18
    L17:
        r6 = false;
    L18:
        if (r6 == false) goto L22;
        throw new OldPowerPointFormatException("Based on the Current User stream, you seem to have supplied a PowerPoint95 file, which isn't supported");
    L22:
        throw new CorruptPowerPointFileException("The Current User stream must be at least 28 bytes long, but was only " + this._contents.length);
    L23:
        init();
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r0 != null) goto L38;
    L33:
        throw th;
    L38:
        r0.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    L35:
        throw new CorruptPowerPointFileException("The Current User stream is implausably long. It's normally 28-200 bytes long, but was " + r1.getSize() + " bytes");
    }

    private void init() {
        if (LittleEndian.getInt(encHeaderToken) != LittleEndian.getInt(this._contents, 12)) goto L5;
        boolean r0 = true;
    L6:
        this.isEncrypted = r0;
        this.currentEditOffset = LittleEndian.getUInt(this._contents, 16);
        this.docFinalVersion = LittleEndian.getUShort(this._contents, 22);
        byte[] r1 = this._contents;
        this.docMajorNo = r1[24];
        this.docMinorNo = r1[25];
        long r2 = LittleEndian.getUShort(r1, 20);
        if (r2 <= 512) goto L9;
        LOG.atWarn().a("Invalid username length {} found, treating as if there was no username set", v.a(r2));
        r2 = 0;
    L9:
        byte[] r3 = this._contents;
        int r6 = (int) r2;
        int r7 = r6 + 28;
        int r8 = r7 + 4;
        if (r3.length < r8) goto L12;
        this.releaseVersion = LittleEndian.getUInt(r3, r7);
    L13:
        byte[] r4 = this._contents;
        if (r4.length < (((long) r8) + (r2 * 2))) goto L16;
        String r5 = StringUtil.getFromUnicodeLE(r4, r8, r6);
    L17:
        this.lastEditUser = r5;
        return;
    L16:
        r5 = StringUtil.getFromCompressedUnicode(r4, 28, r6);
        goto L17
    L12:
        this.releaseVersion = 0;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public long getCurrentEditOffset() {
        return this.currentEditOffset;
    }
}
