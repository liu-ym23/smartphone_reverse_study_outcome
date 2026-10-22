package o1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.applog.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<com.bytedance.applog.h> f11374a;

    public c() {
        this.f11374a = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.applog.h
    public void a(boolean r10, JSONObject r11) {
        Iterator<com.bytedance.applog.h> r12 = this.f11374a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().a(r10, r11);
        goto L4
    }

    public void b(com.bytedance.applog.h r10) {
        if (r10 == null) goto L5;
        this.f11374a.add(r10);
        return;
    }

    @Override // com.bytedance.applog.h
    public void onIdLoaded(String r10, String r11, String r12) {
        Iterator<com.bytedance.applog.h> r13 = this.f11374a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().onIdLoaded(r10, r11, r12);
        goto L4
    }

    @Override // com.bytedance.applog.h
    public void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<com.bytedance.applog.h> r10 = this.f11374a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }
}
