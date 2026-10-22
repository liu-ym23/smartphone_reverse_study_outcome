package org.bouncycastle.jcajce.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public class BCJcaJceHelper extends ProviderJcaJceHelper {
    private static volatile Provider bcProvider;

    public BCJcaJceHelper() {
        super(getBouncyCastleProvider());
    }

    private static synchronized Provider getBouncyCastleProvider() {
        monitor-enter(BCJcaJceHelper.class);
        Provider r1 = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r1, BouncyCastleProvider.class) == false) goto L9;
        monitor-exit(BCJcaJceHelper.class);
        return r1;
    L9:
        if (bcProvider == null) goto L13;
        Provider r2 = bcProvider;     // Catch: Throwable -> L16
        monitor-exit(BCJcaJceHelper.class);
        return r2;
    L13:
        bcProvider = new BouncyCastleProvider();     // Catch: Throwable -> L16
        Provider r3 = bcProvider;     // Catch: Throwable -> L16
        monitor-exit(BCJcaJceHelper.class);
        return r3;
    L16:
        th = move-exception;
        throw th;
    }
}
