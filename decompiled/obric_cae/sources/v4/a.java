package v4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements r3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet<r3.g> f12719a;

    public a() {
        this.f12719a = new CopyOnWriteArraySet();
    }

    @Override // r3.g
    public final void onIdLoaded(String r8, String r10, String r11) {
        Iterator<r3.g> r12 = this.f12719a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onIdLoaded(r8, r10, r11);
        goto L4
    }

    @Override // r3.g
    public final void onRemoteConfigGet(boolean r8, JSONObject r10) {
        Iterator<r3.g> r11 = this.f12719a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onRemoteConfigGet(r8, r10);
        goto L4
    }

    @Override // r3.g
    public final void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<r3.g> r8 = this.f12719a.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        r8.next().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }
}
