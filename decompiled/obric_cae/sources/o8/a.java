package o8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.security.keymanager.KeyManager;
import com.bytedance.security.keymanager.KeyManagerResult;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f9760a;

    public a() {
    }

    public static void a(Context r8, String r10) {
        int r11 = KeyManager.getInstance().deleteKey(r8, r10, new Bundle());
        if (r11 != 0) goto L5;
        Log.i("a", "Deleted attest key successfully: ".concat(r10));
        return;
    L5:
        Log.e("a", "Failed to delete attest key: " + r10 + ", ret: " + r11);
    }

    public static int b(Context r8, String r10, Bundle r11) {
        int r12 = KeyManager.getInstance().generateKeyPair(r8, r10, r11);
        if (r12 == 0) goto L6;
        Log.e("a", "Generate key pair failed! ret:" + r12);
        return r12;
    L6:
        return 0;
    }

    public static List c(Context r8, String r10, Bundle r11, Bundle r12) {
        String r13 = p8.a.c();
        if (TextUtils.isEmpty(r13) == false) goto L6;
        Log.e("a", "Request challenge failed!!");
        return new ArrayList();
    L6:
        int r14 = b(r8, "ocean_location_attestation", r11);
        if (r14 == 0) goto L10;
        Log.e("a", "Generate attestation key pair failed! ret:" + r14);
        return new ArrayList();
    L10:
        r12.putString("challenge", r13 + BdimCategoryConstants.SEPARATOR_COLON + r10 + ":ocean_location");
        KeyManagerResult r15 = KeyManager.getInstance().keyAttestation(r8, "ocean_location_attestation", r12);
        if (r15.getResultCode() == 0) goto L13;
        Log.e("a", "Attest key with ids failed! ret:" + r15.getResultCode());
        List r16 = new ArrayList();
    L21:
        if (r16.isEmpty() == false) goto L24;
        Log.e("a", "attestKeyWithIds failed, delete keyAlias: ocean_location_attestation");
        a(r8, "ocean_location_attestation");
        return new ArrayList();
    L24:
        return r16;
    L13:
        r16 = r15.getCertChain();
        if (r16 != null) goto L16;
    L19:
        Log.e("a", "keyAttestation result certChain invalid for keyAlias=ocean_location_attestation");
        r16 = new ArrayList();
        goto L21
    L16:
        if (r16.isEmpty() == true) goto L19;
        r16.size();
        goto L21
    }

    public static a d() {
        if (f9760a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9760a != null) goto L9;
        f9760a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9760a;
    }
}
