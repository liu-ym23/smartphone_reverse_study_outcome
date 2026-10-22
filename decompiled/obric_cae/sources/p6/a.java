package p6;

import android.content.Context;
import android.os.Bundle;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.keymanager.KeyManagerResult;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.KeyAgreement;
import n6.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static byte[] a(Context r8, String r10, byte[] r11) {
        Bundle r12 = new Bundle();
        r12.putInt("key_algorithm", 2);
        r12.putInt("key_length", 256);
        KeyManagerResult r13 = KeyManager.getInstance().keyAgreement(r8, r10, r11, r12);
        if (r13.getResultCode() != 0) goto L7;
        return r13.getOutData();
    L7:
        throw new c("bd keyAgreement failed, system errorCode: " + r13.getResultCode());
    }

    public static byte[] b(PrivateKey r8, PublicKey r10) {
        KeyAgreement r11 = KeyAgreement.getInstance("ECDH");
        r11.init(r8);
        r11.doPhase(r10, true);
        return r11.generateSecret();
    }
}
