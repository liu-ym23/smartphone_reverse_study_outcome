package com.ctc.wstx.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class WstxInputLocation implements Serializable, org.codehaus.stax2.c {
    private static final WstxInputLocation sEmptyLocation = null;
    private static final long serialVersionUID = 1;
    protected final long mCharOffset;
    protected final int mCol;
    protected final WstxInputLocation mContext;
    protected transient String mDesc;
    protected final String mPublicId;
    protected final int mRow;
    protected final String mSystemId;

    static {
        sEmptyLocation = new WstxInputLocation(null, "", "", -1, -1, -1);
    }

    public WstxInputLocation(WstxInputLocation r2, String r3, r r4, long r5, int r7, int r8) {
        this.mDesc = null;
        this.mContext = r2;
        this.mPublicId = r3;
        if (r4 != null) goto L5;
        String r6 = "N/A";
    L6:
        this.mSystemId = r6;
        this.mCharOffset = r5;
        this.mCol = r8;
        this.mRow = r7;
        return;
    L5:
        r6 = r4.toString();
        goto L6
    }

    public WstxInputLocation(WstxInputLocation r2, String r3, String r4, long r5, int r7, int r8) {
        this.mDesc = null;
        this.mContext = r2;
        this.mPublicId = r3;
        this.mSystemId = r4;
        this.mCharOffset = r5;
        this.mCol = r8;
        this.mRow = r7;
    }

    private void appendDesc(StringBuilder r4) {
        if (this.mSystemId == null) goto L6;
        r4.append("[row,col,system-id]: ");
        String r0 = this.mSystemId;
    L9:
        r4.append('[');
        r4.append(this.mRow);
        r4.append(',');
        r4.append(this.mCol);
        if (r0 == null) goto L12;
        r4.append(',');
        r4.append(Typography.quote);
        r4.append(r0);
        r4.append(Typography.quote);
    L12:
        r4.append(']');
        if (this.mContext == null) goto L16;
        com.ctc.wstx.util.i.a(r4);
        r4.append(" from ");
        this.mContext.appendDesc(r4);
        return;
    L16:
        return;
    L6:
        if (this.mPublicId == null) goto L8;
        r4.append("[row,col,public-id]: ");
        r0 = this.mPublicId;
        goto L9
    L8:
        r4.append("[row,col {unknown-source}]: ");
        r0 = null;
        goto L9
    }

    public static WstxInputLocation getEmptyLocation() {
        return sEmptyLocation;
    }

    public boolean equals(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, WstxInputLocation.class) == true) goto L5;
        return false;
    L5:
        WstxInputLocation r7 = (WstxInputLocation) ZeusTransformUtils.preCheckCast(r6, WstxInputLocation.class, "com.obric.memorydata.plugin");
        if (r7.getCharacterOffsetLong() == getCharacterOffsetLong()) goto L8;
        return false;
    L8:
        String r0 = r7.getPublicId();
        String r1 = "";
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        if (r0.equals(this.mPublicId) == true) goto L14;
        return false;
    L14:
        String r8 = r7.getSystemId();
        if (r8 == null) goto L19;
        r1 = r8;
    L19:
        return r1.equals(this.mSystemId);
    }

    @Override // javax.xml.stream.a
    public int getCharacterOffset() {
        return (int) this.mCharOffset;
    }

    public long getCharacterOffsetLong() {
        return this.mCharOffset;
    }

    @Override // javax.xml.stream.a
    public int getColumnNumber() {
        return this.mCol;
    }

    @Override // org.codehaus.stax2.c
    public org.codehaus.stax2.c getContext() {
        return this.mContext;
    }

    @Override // javax.xml.stream.a
    public int getLineNumber() {
        return this.mRow;
    }

    @Override // javax.xml.stream.a
    public String getPublicId() {
        return this.mPublicId;
    }

    @Override // javax.xml.stream.a
    public String getSystemId() {
        return this.mSystemId;
    }

    public int hashCode() {
        long r0 = this.mCharOffset;
        int r2 = (int) r0;
        int r1 = (((int) ((r0 >> 32) & (-1))) ^ r2) ^ this.mRow;
        int r5 = this.mCol;
        return (r5 + (r5 << 3)) ^ r1;
    }

    public String toString() {
        if (this.mDesc != null) goto L10;
        if (this.mContext == null) goto L7;
        StringBuilder r0 = new StringBuilder(200);
    L8:
        appendDesc(r0);
        this.mDesc = r0.toString();
        goto L10
    L7:
        r0 = new StringBuilder(80);
    L10:
        return this.mDesc;
    }
}
