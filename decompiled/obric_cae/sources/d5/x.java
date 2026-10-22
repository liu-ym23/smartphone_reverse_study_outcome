package d5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class x extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6831e;

    public x(Context r8) {
        super(true, false);
        this.f6831e = r8;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        Context r10 = this.f6831e;
        String r11 = null;
        PackageInfo r12 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (r12 == null) goto L19;
        Signature[] r13 = r12.signatures;
        if (r13 == null) goto L19;
        if (r13.length <= 0) goto L19;
        Signature r14 = r13[0];
        if (r14 == null) goto L19;
        byte[] r15 = r14.toByteArray();
        if (r15 == null) goto L19;
        if (r15.length == 0) goto L19;
        MessageDigest r16 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L23
        r16.update(r15);     // Catch: Exception -> L23
        r11 = l6.a.X0(r16.digest());     // Catch: Exception -> L23
    L19:
        if (r11 == null) goto L28;
        r8.put("sig_hash", r11);
        return true;
    L28:
        return true;
    L5:
        int r17 = x4.r.f13543a;
        r12 = null;
        goto L6
    }
}
