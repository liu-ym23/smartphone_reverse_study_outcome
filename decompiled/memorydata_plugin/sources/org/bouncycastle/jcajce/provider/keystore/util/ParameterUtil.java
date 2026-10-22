package org.bouncycastle.jcajce.provider.keystore.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/* JADX INFO: loaded from: classes7.dex */
public class ParameterUtil {
    public static char[] extractPassword(KeyStore.LoadStoreParameter r3) {
        KeyStore.ProtectionParameter r4 = ((KeyStore.LoadStoreParameter) ZeusTransformUtils.wrapperContextForParams(r3, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin")).getProtectionParameter();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, KeyStore.PasswordProtection.class) == false) goto L11;
        return ((KeyStore.PasswordProtection) ZeusTransformUtils.preCheckCast(r4, KeyStore.PasswordProtection.class, "com.obric.memorydata.plugin")).getPassword();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, KeyStore.CallbackHandlerProtection.class) == false) goto L19;
        CallbackHandler r5 = ((KeyStore.CallbackHandlerProtection) ZeusTransformUtils.preCheckCast(r4, KeyStore.CallbackHandlerProtection.class, "com.obric.memorydata.plugin")).getCallbackHandler();
        PasswordCallback r0 = new PasswordCallback("password: ", false);
        r5.handle(new Callback[]{r0});     // Catch: UnsupportedCallbackException -> L15
        return r0.getPassword();
    L15:
        e = move-exception;
        throw new IllegalArgumentException("PasswordCallback not recognised: " + e.getMessage(), e);
    L19:
        throw new IllegalArgumentException("no support for protection parameter of type " + r4.getClass().getName());
    }
}
