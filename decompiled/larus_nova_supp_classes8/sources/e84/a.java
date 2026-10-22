package e84;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends b<IDidAidlInterface> {

    /* JADX INFO: renamed from: e84.a$a, reason: collision with other inner class name */
    public class C0381a implements u.b<IDidAidlInterface, String> {
        public C0381a() {
        }

        @Override // e84.u.b
        public final String a(IDidAidlInterface r1) throws Exception {
            IDidAidlInterface r2 = r1;
            if (r2 != null) goto L6;
            return null;
        L6:
            return r2.getOAID();
        }

        @Override // e84.u.b
        public final IDidAidlInterface b(IBinder r1) {
            return IDidAidlInterface.Stub.asInterface(r1);
        }
    }

    public final String getName() {
        return "ASUS";
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    public final u.b<IDidAidlInterface, String> c() {
        return new C0381a();
    }

    public final Intent b(Context r4) {
        Intent r5 = new Intent();
        r5.setAction("com.asus.msa.action.ACCESS_DID");
        r5.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r5;
    }
}
