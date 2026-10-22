package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class PasswordRecipientId extends RecipientId {
    public PasswordRecipientId() {
        super(3);
    }

    @Override // org.bouncycastle.cms.RecipientId, org.bouncycastle.util.Selector
    public Object clone() {
        return new PasswordRecipientId();
    }

    public boolean equals(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, PasswordRecipientId.class) == true) goto L6;
        return false;
    L6:
        return true;
    }

    public int hashCode() {
        return 3;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, PasswordRecipientInformation.class) == false) goto L6;
        return true;
    L6:
        return false;
    }
}
