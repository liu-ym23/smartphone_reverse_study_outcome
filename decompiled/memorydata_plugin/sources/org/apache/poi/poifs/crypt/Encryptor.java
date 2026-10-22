package org.apache.poi.poifs.crypt;

import java.util.Map;
import java.util.function.Supplier;
import javax.crypto.SecretKey;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Encryptor implements GenericRecord {
    private EncryptionInfo encryptionInfo;
    private SecretKey secretKey;

    public Encryptor() {
    }

    static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        SecretKey r1 = this.secretKey;
        if (r1 != null) goto L5;
        Supplier r2 = $$Lambda$Encryptor$oKwuGvU9ElqLV4mAGVUy49fXaoM.INSTANCE;
    L7:
        return GenericRecordUtil.getGenericProperties("secretKey", r2);
    L5:
        r1.getClass();
        r2 = new $$Lambda$SJQFim5AslTUp6TA1Y_p1iGFU(r1);
        goto L7
    }

    public void setEncryptionInfo(EncryptionInfo r1) {
        this.encryptionInfo = r1;
    }
}
