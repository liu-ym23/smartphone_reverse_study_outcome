package m3;

import com.bytedance.lego.init.model.ExecutionPeriod;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f11043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11044c;

    public ExecutionPeriod a() {
        return ExecutionPeriod.from(this.f11044c);
    }

    public e b() {
        return this.f11043b;
    }

    public String c() {
        return this.f11042a;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.f11042a);
        r10.append(", " + this.f11043b);
        r10.append(", " + this.f11044c);
        return r10.toString();
    }
}
