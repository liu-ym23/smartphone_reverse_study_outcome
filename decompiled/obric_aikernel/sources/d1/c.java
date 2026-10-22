package d1;

import com.bytedance.applog.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<m> f8442a;

    public c() {
        this.f8442a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.m
    public void a(long r10, String r11, JSONObject r12) {
        Iterator<m> r13 = this.f8442a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().a(r10, r11, r12);
        goto L4
    }

    @Override // com.bytedance.applog.m
    public void b(long r10, String r11) {
        Iterator<m> r12 = this.f8442a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().b(r10, r11);
        goto L4
    }

    @Override // com.bytedance.applog.m
    public void c(long r10, String r11, JSONObject r12) {
        Iterator<m> r13 = this.f8442a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().c(r10, r11, r12);
        goto L4
    }
}
