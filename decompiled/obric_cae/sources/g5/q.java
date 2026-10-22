package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IOpenID;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f7678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7679b;

    public class a extends k5.l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            boolean r10 = false;
            PackageInfo r11 = ((Context) r8[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);     // Catch: Exception -> L11
            if (r11 != null) goto L7;
            Boolean r12 = Boolean.FALSE;     // Catch: Exception -> L11
        L13:
            return r12;
        L7:
            if (r11.getLongVersionCode() < 1) goto L9;
            r10 = true;
        L9:
            r12 = Boolean.valueOf(r10);     // Catch: Exception -> L11
        L16:
            return Boolean.FALSE;
        }
    }

    public class b implements t.b<IOpenID, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f7681b;

        public b(q r8, Context r10) {
            this.f7681b = r8;
            this.f7680a = r10;
        }

        @Override // g5.t.b
        public final IOpenID a(IBinder r8) {
            return IOpenID.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IOpenID r10) {
            IOpenID r11 = r10;
            Context r8 = this.f7680a;
            if (r11 == null) goto L37;
            this.f7681b.getClass();
            PackageInfo r12 = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 64);     // Catch: Exception -> L10
            if (r12 == null) goto L12;
            Signature[] r13 = r12.signatures;     // Catch: Exception -> L10
        L13:
            if (r13 != null) goto L15;
        L26:
            String r14 = null;
        L28:
            if (TextUtils.isEmpty(r14) == false) goto L30;
            return null;
        L30:
            return r11.a(r8.getPackageName(), r14, "OUID");
        L15:
            if (r13.length <= 0) goto L26;
            int r15 = 0;
            byte[] r16 = r13[0].toByteArray();
            MessageDigest r17 = MessageDigest.getInstance("SHA1");     // Catch: Exception -> L24
            if (r17 == null) goto L26;
            byte[] r18 = r17.digest(r16);     // Catch: Exception -> L24
            StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L24
            int r20 = r18.length;     // Catch: Exception -> L24
        L20:
            if (r15 >= r20) goto L22;
            r19.append(Integer.toHexString((r18[r15] & 255) | 256).substring(1, 3));     // Catch: Exception -> L24
            r15 = r15 + 1;     // Catch: Exception -> L24
            goto L20
        L22:
            r14 = r19.toString();     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L12:
            r13 = null;
        L10:
            e = move-exception;
            e.printStackTrace();
            goto L12
        L37:
            return null;
        }
    }

    public q(u r8) {
        this.f7679b = new a();
        this.f7678a = r8;
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        m r10 = this.f7678a;
        if (r10 == null) goto L8;
        a r11 = this.f7679b;
        if (r11.b(new Object[0]).booleanValue() == true) goto L8;
        return r10.a(r8);
    L8:
        Intent r12 = new Intent();
        r12.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        r12.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String r13 = (String) new t(r8, r12, new b(this, r8)).a();
        m.a r14 = new m.a();
        r14.f7667a = r13;
        return r14;
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        Boolean r10 = this.f7679b.b(new Object[]{r8});
        m r11 = this.f7678a;
        if (r11 == null) goto L12;
        if (r10.booleanValue() == true) goto L12;
        return r11.b(r8);
    L12:
        return r10.booleanValue();
    }

    @Override // g5.m
    public final String getName() {
        m r8 = this.f7678a;
        if (r8 == null) goto L8;
        a r10 = this.f7679b;
        if (r10.b(new Object[0]).booleanValue() == false) goto L7;
        return "OnePlus/Oppo";
    L7:
        return r8.getName();
    L8:
        return "OnePlus/Oppo";
    }
}
