package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.crypto.CharToByteConverter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2KeyWithParameters extends PBKDF2Key implements PBEKey {
    private final int iterationCount;
    private final byte[] salt;

    public PBKDF2KeyWithParameters(char[] r3, CharToByteConverter r4, byte[] r5, int r6) {
        super(r3, (CharToByteConverter) ZeusTransformUtils.wrapperContextForParams(r4, CharToByteConverter.class, "com.obric.memorydata.plugin"));
        this.salt = Arrays.clone(r5);
        this.iterationCount = r6;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.salt;
    }
}
