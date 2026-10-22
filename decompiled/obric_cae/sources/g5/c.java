package g5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b<MsaIdInterface> {

    public class a implements t.b<MsaIdInterface, String> {
        @Override // g5.t.b
        public final MsaIdInterface a(IBinder r8) {
            return MsaIdInterface.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(MsaIdInterface r8) {
            MsaIdInterface r10 = r8;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.b();
        }
    }

    public c() {
        super("com.mdid.msa");
    }

    @Override // g5.b, g5.m
    public final m.a a(Context r8) {
        String r10 = r8.getPackageName();
        Intent r11 = new Intent();
        r11.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        r11.setAction("com.bun.msa.action.start.service");
        r11.putExtra("com.bun.msa.param.pkgname", r10);
        r11.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        r8.startService(r11);     // Catch: Exception -> L5
    L8:
        return super.a(r8);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        r10.setAction("com.bun.msa.action.bindto.service");
        r10.putExtra("com.bun.msa.param.pkgname", r8.getPackageName());
        return r10;
    }

    @Override // g5.b
    public final t.b<MsaIdInterface, String> d() {
        return new a();
    }

    @Override // g5.m
    public final String getName() {
        return "Common";
    }
}
