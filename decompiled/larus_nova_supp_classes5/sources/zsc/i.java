package zsc;

import java.util.regex.Pattern;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class i {
    public k a;
    public uvc.b b;
    public String c;
    public int d;

    public i() {
    }

    public abstract uvc.b b();

    public abstract char d();

    public final char c() {
        k r0 = this.a;
        ((j) r0).h = this.d;
        return ((j) r0).d();
    }

    public final void e() {
        k r0 = this.a;
        ((j) r0).h = this.d;
        ((j) r0).c(j.l);
        this.d = ((j) this.a).h;
    }

    public final String a(Pattern r4) {
        k r0 = this.a;
        ((j) r0).h = this.d;
        String r5 = ((j) r0).c(r4);
        this.d = ((j) this.a).h;
        return r5;
    }

    public final Text f(String r2) {
        ((j) this.a).getClass();
        return new Text(r2);
    }
}
