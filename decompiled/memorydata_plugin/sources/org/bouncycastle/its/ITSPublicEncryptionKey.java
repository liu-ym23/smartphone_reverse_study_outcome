package org.bouncycastle.its;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.SymmAlgorithm;

/* JADX INFO: loaded from: classes7.dex */
public class ITSPublicEncryptionKey {

    public static final enum symmAlgorithm extends Enum<symmAlgorithm> {
        private static final /* synthetic */ symmAlgorithm[] $VALUES = null;
        public static final symmAlgorithm aes128Ccm = null;
        private final int tagValue;

        static {
            symmAlgorithm r0 = new symmAlgorithm("aes128Ccm", 0, SymmAlgorithm.aes128Ccm.intValueExact());
            aes128Ccm = r0;
            $VALUES = new symmAlgorithm[]{r0};
        }

        private symmAlgorithm(String r1, int r2, int r3) {
            super(r1, r2);
            this.tagValue = r3;
        }

        public static symmAlgorithm valueOf(String r2) {
            return (symmAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(symmAlgorithm.class, r2), symmAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static symmAlgorithm[] values() {
            return (symmAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), symmAlgorithm[].class, "com.obric.memorydata.plugin");
        }
    }
}
