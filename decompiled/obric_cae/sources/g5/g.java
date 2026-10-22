package g5;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.honor.HonorOAIDCallback;
import com.bytedance.bdinstall.honor.HonorOAIDLimitCallback;
import com.bytedance.bdinstall.oaid.impl.IOAIDService;

/* JADX INFO: loaded from: classes.dex */
public final class g extends b<IOAIDService> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HonorOAIDCallback f7650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HonorOAIDLimitCallback f7651d;

    public class a implements t.b<IOAIDService, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f7652a;

        public a(g r8) {
            this.f7652a = r8;
        }

        @Override // g5.t.b
        public final IOAIDService a(IBinder r8) {
            return IOAIDService.Stub.H2(r8);
        }

        @Override // g5.t.b
        public final String b(IOAIDService r8) {
            IOAIDService r10 = r8;
            if (r10 != null) goto L5;
            int r11 = x4.r.f13543a;
            return null;
        L5:
            g r12 = this.f7652a;
            r10.K(r12.f7650c);
            r10.h1(r12.f7651d);
            return "";
        }
    }

    public g() {
        super("com.hihonor.id");
        this.f7650c = new HonorOAIDCallback();
        this.f7651d = new HonorOAIDLimitCallback();
    }

    @Override // g5.b, g5.m
    public final m.a a(Context r8) {
        m.a r10 = new m.a();
        new t(r8, c(r8), new a(this)).a();     // Catch: Exception -> L5
        r10.f7667a = this.f7650c.f3792a;     // Catch: Exception -> L5
        r10.f7668b = this.f7651d.f3793a;     // Catch: Exception -> L5
        int r11 = x4.r.f13543a;     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    @Override // g5.b
    public final Intent c(Context r8) {
        Intent r10 = new Intent();
        r10.setAction("com.hihonor.id.HnOaIdService");
        r10.setPackage("com.hihonor.id");
        return r10;
    }

    @Override // g5.b
    public final t.b<IOAIDService, String> d() {
        return new a(this);
    }

    @Override // g5.m
    public final String getName() {
        return "HONOR";
    }
}
