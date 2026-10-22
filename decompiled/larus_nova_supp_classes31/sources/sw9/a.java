package sw9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements pw9.a {
    public final CopyOnWriteArrayList<pw9.a> a;

    @Override // pw9.a
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pw9.a) r0.next()).a();
        goto L4
    }

    @Override // pw9.a
    public final int b() {
        pw9.a r0 = (pw9.a) CollectionsKt.lastOrNull(this.a);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    @Override // pw9.a
    public final int getChatInputHeight() {
        pw9.a r0 = (pw9.a) CollectionsKt.lastOrNull(this.a);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getChatInputHeight();
    }

    @Override // pw9.a
    public final void requestChatInputFocus() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pw9.a) r0.next()).requestChatInputFocus();
        goto L4
    }

    public a() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // pw9.a
    public final void c(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((pw9.a) r0.next()).c(r3);
        goto L4
    }
}
