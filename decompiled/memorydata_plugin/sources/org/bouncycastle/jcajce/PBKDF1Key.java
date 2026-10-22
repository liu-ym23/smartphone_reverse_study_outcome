package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CharToByteConverter;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF1Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF1Key(char[] r3, CharToByteConverter r4) {
        CharToByteConverter r5 = (CharToByteConverter) ZeusTransformUtils.wrapperContextForParams(r4, CharToByteConverter.class, "com.obric.memorydata.plugin");
        char[] r0 = new char[r3.length];
        this.password = r0;
        this.converter = r5;
        System.arraycopy(r3, 0, r0, 0, r3.length);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF1";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.converter.convert(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.converter.getType();
    }

    public char[] getPassword() {
        return this.password;
    }
}
