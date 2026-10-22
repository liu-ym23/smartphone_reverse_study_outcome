package n0;

import com.bytedance.apm.internal.ApmDelegate;
import i0.c;
import o0.b;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public a() {
    }

    @Override // o0.b
    public boolean a(String r10, String r11) {
        return c.a().c(r10, r11);
    }

    @Override // o0.b
    public boolean b(String r10) {
        return ApmDelegate.j().l(r10);
    }

    @Override // o0.b
    public boolean c(String r10) {
        return c.a().d(r10);
    }

    @Override // o0.b
    public boolean d(String r10) {
        return c.a().b(r10);
    }

    @Override // o0.b
    public boolean getLogTypeSwitch(String r10) {
        return ApmDelegate.j().k(r10);
    }

    @Override // o0.b
    public boolean getServiceSwitch(String r10) {
        return ApmDelegate.j().m(r10);
    }
}
