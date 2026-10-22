package e84;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends b<MsaIdInterface> {

    public class a implements u.b<MsaIdInterface, String> {
        public a() {
        }

        @Override // e84.u.b
        public final String a(MsaIdInterface r1) throws Exception {
            MsaIdInterface r2 = r1;
            if (r2 != null) goto L6;
            return null;
        L6:
            return r2.getOAID();
        }

        @Override // e84.u.b
        public final MsaIdInterface b(IBinder r1) {
            return MsaIdInterface.Stub.asInterface(r1);
        }
    }

    public final String getName() {
        return "Common";
    }

    public c() {
        super("com.mdid.msa");
    }

    public final u.b<MsaIdInterface, String> c() {
        return new a();
    }

    public final Intent b(Context r4) {
        Intent r0 = new Intent();
        r0.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r0.setAction("com.bun.msa.action.bindto.service");
        r0.putExtra("com.bun.msa.param.pkgname", r4.getPackageName());
        return r0;
    }

    public final m$a getOaid(Context r5) {
        String r0 = r5.getPackageName();
        Intent r1 = new Intent();
        r1.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        r1.setAction("com.bun.msa.action.start.service");
        r1.putExtra("com.bun.msa.param.pkgname", r0);
        r1.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        r5.startService(r1);     // Catch: Exception -> L5
    L8:
        return super.getOaid(r5);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
