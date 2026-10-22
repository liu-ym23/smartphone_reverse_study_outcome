package kta;

import android.content.Context;
import android.content.Intent;
import com.hihonor.cloudservice.oaid.IOAIDService;
import com.ss.android.deviceregister.base.honor.HonorOAIDCallback;
import com.ss.android.deviceregister.base.honor.HonorOAIDLimitCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i extends c<IOAIDService> {
    public final HonorOAIDCallback c;
    public final HonorOAIDLimitCallback d;

    public i() {
        super("com.hihonor.id");
        this.c = new HonorOAIDCallback();
        this.d = new HonorOAIDLimitCallback();
    }

    @Override // kta.c
    public final w.b<IOAIDService, String> c() {
        return new a(this);
    }

    @Override // kta.c
    public final Intent b(Context r2) {
        Intent r3 = new Intent();
        r3.setAction("com.hihonor.id.HnOaIdService");
        r3.setPackage("com.hihonor.id");
        return r3;
    }

    @Override // kta.c, kta.o
    public final o.a getOaid(Context r5) {
        o.a r0 = new o.a();
        new w(r5, b(r5), new a(this)).a();     // Catch: Exception -> L5
        r0.a = this.c.getOaid();     // Catch: Exception -> L5
        r0.b = this.d.isLimit();     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }
}
