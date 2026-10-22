package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2Key implements PBKDFKey {
    private final CharToByteConverter converter;
    private final char[] password;

    public PBKDF2Key(char[] r3, CharToByteConverter r4) {
        CharToByteConverter r5 = (CharToByteConverter) ZeusTransformUtils.wrapperContextForParams(r4, CharToByteConverter.class, "com.obric.memorydata.plugin");
        this.password = Arrays.clone(r3);
        this.converter = r5;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "PBKDF2";
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
