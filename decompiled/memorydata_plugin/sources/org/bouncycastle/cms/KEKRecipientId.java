package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class KEKRecipientId extends RecipientId {
    private byte[] keyIdentifier;

    public KEKRecipientId(byte[] r2) {
        super(1);
        this.keyIdentifier = r2;
    }

    @Override // org.bouncycastle.cms.RecipientId, org.bouncycastle.util.Selector
    public Object clone() {
        return new KEKRecipientId(this.keyIdentifier);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, KEKRecipientId.class) == true) goto L6;
        return false;
    L6:
        KEKRecipientId r4 = (KEKRecipientId) ZeusTransformUtils.preCheckCast(r3, KEKRecipientId.class, "com.obric.memorydata.plugin");
        return Arrays.areEqual(this.keyIdentifier, r4.keyIdentifier);
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyIdentifier);
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r4) {
        if ((r4 instanceof byte[]) == false) goto L7;
        return Arrays.areEqual(this.keyIdentifier, (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r4, KEKRecipientInformation.class) == true) goto L9;
        return false;
    L9:
        return ((KEKRecipientInformation) ZeusTransformUtils.preCheckCast(r4, KEKRecipientInformation.class, "com.obric.memorydata.plugin")).getRID().equals(this);
    }
}
