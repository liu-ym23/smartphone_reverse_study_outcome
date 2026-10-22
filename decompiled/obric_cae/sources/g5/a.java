package g5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b<IDidAidlInterface> {

    /* JADX INFO: renamed from: g5.a$a, reason: collision with other inner class name */
    public class C0078a implements t.b<IDidAidlInterface, String> {
        @Override // g5.t.b
        public final IDidAidlInterface a(IBinder r8) {
            return IDidAidlInterface.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IDidAidlInterface r8) {
            IDidAidlInterface r10 = r8;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.b();
        }
    }

    public a() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setAction("com.asus.msa.action.ACCESS_DID");
        r10.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r10;
    }

    @Override // g5.b
    public final t.b<IDidAidlInterface, String> d() {
        return new C0078a();
    }

    @Override // g5.m
    public final String getName() {
        return "ASUS";
    }
}
