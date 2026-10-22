package org.apache.poi.poifs.crypt;

import java.util.function.Supplier;
import javax.crypto.SecretKey;

/* JADX INFO: renamed from: org.apache.poi.poifs.crypt.-$$Lambda$S-JQFim5AslT-Up6TA1Y_p1iGFU, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$SJQFim5AslTUp6TA1Y_p1iGFU implements Supplier {
    public final /* synthetic */ SecretKey f$0;

    public /* synthetic */ $$Lambda$SJQFim5AslTUp6TA1Y_p1iGFU(SecretKey r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.getEncoded();
    }
}
