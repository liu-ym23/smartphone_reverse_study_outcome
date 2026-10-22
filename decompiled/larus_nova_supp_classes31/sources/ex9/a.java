package ex9;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements ax9.a {
    public final CopyOnWriteArrayList<ax9.a> a;

    @Override // ax9.a
    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.a) r0.next()).a();
        goto L4
    }

    @Override // ax9.a
    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.a) r0.next()).b();
        goto L4
    }

    @Override // ax9.a
    public final void c() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.a) r0.next()).c();
        goto L4
    }

    @Override // ax9.a
    public final int getChatInputHeight() {
        ax9.a r0 = (ax9.a) CollectionsKt.lastOrNull(this.a);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getChatInputHeight();
    }

    @Override // ax9.a
    public final void requestChatInputFocus() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ax9.a) r0.next()).requestChatInputFocus();
        goto L4
    }

    public a() {
        this.a = new CopyOnWriteArrayList();
    }
}
