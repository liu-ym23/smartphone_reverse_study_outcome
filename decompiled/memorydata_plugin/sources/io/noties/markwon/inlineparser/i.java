package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected l f16626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Node f16627b;
    protected String c;
    protected int d;

    public i() {
    }

    public abstract char a();

    public String a(Pattern r3) {
        this.f16626a.a(this.d);
        String r4 = this.f16626a.a(r3);
        this.d = this.f16626a.e();
        return r4;
    }

    public Node a(l r3) {
        l r4 = (l) ZeusTransformUtils.wrapperContextForParams(r3, l.class, "com.obric.memorydata.plugin");
        this.f16626a = r4;
        this.f16627b = r4.c();
        this.c = r4.d();
        this.d = r4.e();
        Node r0 = b();
        r4.a(this.d);
        return r0;
    }

    public Text a(String r1) {
        return this.f16626a.a(r1);
    }

    public Text a(String r1, int r2, int r3) {
        return this.f16626a.a(r1, r2, r3);
    }

    public void a(Bracket r1) {
        this.f16626a.a(r1);
    }

    public void a(Delimiter r3) {
        this.f16626a.a(this.d);
        this.f16626a.a(r3);
        this.d = this.f16626a.e();
    }

    public abstract Node b();

    public Bracket c() {
        return this.f16626a.f();
    }

    public Delimiter d() {
        return this.f16626a.g();
    }

    public void e() {
        this.f16626a.h();
    }

    public void f() {
        this.f16626a.a(this.d);
        this.f16626a.i();
        this.d = this.f16626a.e();
    }

    public String g() {
        this.f16626a.a(this.d);
        String r0 = this.f16626a.j();
        this.d = this.f16626a.e();
        return r0;
    }

    public String h() {
        this.f16626a.a(this.d);
        String r0 = this.f16626a.k();
        this.d = this.f16626a.e();
        return r0;
    }

    public int i() {
        this.f16626a.a(this.d);
        int r0 = this.f16626a.l();
        this.d = this.f16626a.e();
        return r0;
    }

    public char j() {
        this.f16626a.a(this.d);
        return this.f16626a.b();
    }
}
