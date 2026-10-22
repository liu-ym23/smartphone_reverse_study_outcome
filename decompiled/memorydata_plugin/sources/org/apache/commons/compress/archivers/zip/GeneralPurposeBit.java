package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class GeneralPurposeBit implements Cloneable {
    private boolean dataDescriptorFlag;
    private boolean encryptionFlag;
    private boolean languageEncodingFlag;
    private int numberOfShannonFanoTrees;
    private int slidingDictionarySize;
    private boolean strongEncryptionFlag;

    public GeneralPurposeBit() {
    }

    public static GeneralPurposeBit parse(byte[] r3, int r4) {
        int r5 = ZipShort.getValue(r3, r4);
        GeneralPurposeBit r6 = new GeneralPurposeBit();
        boolean r1 = false;
        if ((r5 & 8) == 0) goto L5;
        boolean r0 = true;
    L6:
        r6.useDataDescriptor(r0);
        if ((r5 & 2048) == 0) goto L9;
        boolean r2 = true;
    L10:
        r6.useUTF8ForNames(r2);
        if ((r5 & 64) == 0) goto L13;
        boolean r7 = true;
    L14:
        r6.useStrongEncryption(r7);
        if ((r5 & 1) == 0) goto L17;
        r1 = true;
    L17:
        r6.useEncryption(r1);
        if ((r5 & 2) == 0) goto L20;
        int r8 = 8192;
    L21:
        r6.slidingDictionarySize = r8;
        if ((r5 & 4) == 0) goto L24;
        int r9 = 3;
    L25:
        r6.numberOfShannonFanoTrees = r9;
        return r6;
    L24:
        r9 = 2;
        goto L25
    L20:
        r8 = 4096;
        goto L21
    L13:
        r7 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e);
    }

    public void encode(byte[] r4, int r5) {
        int r1 = 0;
        if (this.dataDescriptorFlag == false) goto L5;
        int r0 = 8;
    L7:
        if (this.languageEncodingFlag == false) goto L9;
        int r2 = 2048;
    L10:
        int r3 = (r0 | r2) | (this.encryptionFlag ? 1 : 0);
        if (this.strongEncryptionFlag == false) goto L13;
        r1 = 64;
    L13:
        ZipShort.putShort(r3 | r1, r4, r5);
        return;
    L9:
        r2 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GeneralPurposeBit.class) == true) goto L5;
        return false;
    L5:
        GeneralPurposeBit r5 = (GeneralPurposeBit) ZeusTransformUtils.preCheckCast(r4, GeneralPurposeBit.class, "com.obric.memorydata.plugin");
        if (r5.encryptionFlag == this.encryptionFlag) goto L8;
        return false;
    L8:
        if (r5.strongEncryptionFlag == this.strongEncryptionFlag) goto L10;
        return false;
    L10:
        if (r5.languageEncodingFlag == this.languageEncodingFlag) goto L12;
        return false;
    L12:
        if (r5.dataDescriptorFlag != this.dataDescriptorFlag) goto L18;
        return true;
    L18:
        return false;
    }

    int getNumberOfShannonFanoTrees() {
        return this.numberOfShannonFanoTrees;
    }

    int getSlidingDictionarySize() {
        return this.slidingDictionarySize;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * 17) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean r1) {
        this.dataDescriptorFlag = r1;
    }

    public void useEncryption(boolean r1) {
        this.encryptionFlag = r1;
    }

    public void useStrongEncryption(boolean r1) {
        this.strongEncryptionFlag = r1;
        if (r1 == false) goto L6;
        useEncryption(true);
        return;
    }

    public void useUTF8ForNames(boolean r1) {
        this.languageEncodingFlag = r1;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }
}
