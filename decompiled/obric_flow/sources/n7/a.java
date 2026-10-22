package n7;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.lynx.tasm.behavior.ui.utils.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends w7.a {
    public final /* synthetic */ int d;
    public final /* synthetic */ um.a e;

    public a(e r5, long r10, long r11) {
        this.d = 0;
        this.e = r5;
        super(r10, r11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.d) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        f r5 = (f) this.e;
        ApmCpuManager.getInstance().getCpuSceneString();
        double r10 = p.s();
        r5.f20210c.add(Double.valueOf(r10));
        if (r5.e == false) goto L7;
        throw null;
    L7:
        throw null;
    L8:
        e r11 = (e) this.e;
        r11.getClass();
        ApmCpuManager.getInstance().getCpuSceneString();
        p.s();
        ((com.bytedance.geckox.c) r11.f22372b).getClass();
        if (r11.d == false) goto L11;
        throw null;
    L11:
        throw null;
    }

    public a(f r5) {
        this.d = 1;
        this.e = r5;
        super(0, 1000);
    }
}
