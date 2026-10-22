package d5;

import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f8497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f8498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f8499c;

    public c() {
        this.f8497a = new CopyOnWriteArraySet();
        this.f8498b = new CopyOnWriteArraySet();
        this.f8499c = new CopyOnWriteArraySet();
    }

    private boolean c(Set<String> r10, String r11, n4.c.a r12, int r13, int r14) {
        if (TTHttpCallPriorityControl.k(r10, r11) == false) goto L6;
        r12.c(r13);
        r12.d(r14);
        return true;
    L6:
        return false;
    }

    public void a(JSONObject r10) {
        this.f8497a = TTHttpCallPriorityControl.j(r10, "high");
        this.f8498b = TTHttpCallPriorityControl.j(r10, "normal");
        this.f8499c = TTHttpCallPriorityControl.j(r10, "low");
    }

    public n4.c b(n4.c r10) {
        n4.c.a r11 = r10.O();
        if (c(this.f8497a, r10.A(), r11, 3, 4) == false) goto L7;
        return r11.a();
    L7:
        if (c(this.f8499c, r10.A(), r11, -1, 1) == true) goto L9;
        int r12 = r10.B();
        if (r12 < 3) goto L14;
        r12 = 1;
    L14:
        if (r12 > (-1)) goto L16;
        r12 = 0;
    L16:
        int r13 = r12;
        int r14 = r10.E();
        if (r14 < 4) goto L19;
        r14 = 3;
    L19:
        if (r14 < 1) goto L22;
        r14 = 2;
    L22:
        if (c(this.f8498b, r10.A(), r11, r13, r14) == false) goto L26;
        return r11.a();
    L26:
        return r11.c(1).d(3).a();
    L9:
        return r11.a();
    }
}
