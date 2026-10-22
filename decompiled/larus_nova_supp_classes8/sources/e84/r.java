package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IOpenID;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements m {
    public final m a;
    public final a b;

    public class a extends i84.r<Boolean> {
        public a() {
        }

        public final Object a(Object[] r6) {
            boolean r0 = false;
            PackageInfo r7 = ((Context) r6[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);     // Catch: Exception -> L15
            if (r7 != null) goto L7;
            return Boolean.FALSE;
        L7:
            if (Build.VERSION.SDK_INT < 28) goto L9;
            long r1 = r7.getLongVersionCode();     // Catch: Exception -> L15
        L11:
            if (r1 < 1) goto L19;
            r0 = true;
        L19:
            return Boolean.valueOf(r0);
        L9:
            r1 = r7.versionCode;     // Catch: Exception -> L15
            goto L11
        L16:
            return Boolean.FALSE;
        }
    }

    public class b implements u.b<IOpenID, String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ r b;

        @Override // e84.u.b
        public final String a(IOpenID r9) throws Exception {
            IOpenID r10 = r9;
            if (r10 == null) goto L37;
            r r1 = this.b;
            Context r2 = this.a;
            r1.getClass();
            PackageInfo r3 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 64);     // Catch: Exception -> L10
            if (r3 == null) goto L12;
            Signature[] r4 = r3.signatures;     // Catch: Exception -> L10
        L13:
            if (r4 != null) goto L15;
        L26:
            String r5 = null;
        L28:
            if (TextUtils.isEmpty(r5) == false) goto L30;
            return null;
        L30:
            return r10.getSerID(this.a.getPackageName(), r5, "OUID");
        L15:
            if (r4.length <= 0) goto L26;
            int r6 = 0;
            byte[] r7 = r4[0].toByteArray();
            MessageDigest r8 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L24
            if (r8 == null) goto L26;
            byte[] r11 = r8.digest(r7);     // Catch: Exception -> L24
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L24
            int r13 = r11.length;     // Catch: Exception -> L24
        L20:
            if (r6 >= r13) goto L22;
            r12.append(Integer.toHexString((r11[r6] & 255) | 256).substring(1, 3));     // Catch: Exception -> L24
            r6 = r6 + 1;     // Catch: Exception -> L24
            goto L20
        L22:
            r5 = r12.toString();     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L12:
            r4 = null;
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        L37:
            return null;
        }

        @Override // e84.u.b
        public final IOpenID b(IBinder r1) {
            return IOpenID.Stub.asInterface(r1);
        }

        public b(r r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final String getName() {
        if (this.a != null) goto L5;
        return "OnePlus/Oppo";
    L5:
        if (((Boolean) this.b.b(new Object[0])).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return this.a.getName();
    }

    public r(v r2) {
        this.b = new a();
        this.a = r2;
    }

    public final boolean a(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Boolean r0 = (Boolean) this.b.b(new Object[]{r4});
        if (this.a == null) goto L12;
        if (r0.booleanValue() == true) goto L12;
        return this.a.a(r4);
    L12:
        return r0.booleanValue();
    }

    public final m$a getOaid(Context r7) {
        if (this.a != null) goto L5;
    L8:
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r0.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        b r1 = new b(this, r7);
        CountDownLatch r2 = new CountDownLatch(1);
        String r4 = null;
        u.a r5 = new u.a(r2, r1);     // Catch: Throwable -> L19
        if (r7.bindService(r0, r5, 1) == false) goto L24;
        r2.await();     // Catch: Throwable -> L19
        r4 = r1.a(r5.c);     // Catch: Throwable -> L17
        r7.unbindService(r5);     // Catch: Throwable -> L15
    L35:
    L17:
        th = th;
    L33:
        th.printStackTrace();     // Catch: Throwable -> L26
        if (r5 == null) goto L24;
        r7.unbindService(r5);     // Catch: Throwable -> L15
    L26:
        th = move-exception;
        if (r5 != null) goto L38;
    L32:
        throw th;
    L38:
        r7.unbindService(r5);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
    L24:
        m$a r8 = new m$a();
        r8.a = r4;
        return r8;
    L15:
        th = move-exception;
        th.printStackTrace();
    L19:
        th = th;
        r5 = null;
        goto L33
    L5:
        if (((Boolean) this.b.b(new Object[0])).booleanValue() == true) goto L8;
        return this.a.getOaid(r7);
    }
}
