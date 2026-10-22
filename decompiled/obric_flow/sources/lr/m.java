package lr;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f19773a;

    public final void a(int r5, l r10) {
        HashMap r11 = this.f19773a;
        HashSet r12 = (HashSet) r11.get(Integer.valueOf(r5));
        if (r12 != null) goto L5;
        r12 = new HashSet();
        r11.put(Integer.valueOf(r5), r12);
    L5:
        r12.add(new WeakReference(r10));
    }
}
