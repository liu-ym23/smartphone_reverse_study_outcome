package t2;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a extends ObjectInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<String> f12924c;

    public a(InputStream r10, Class<?>... r11) {
        super(r10);
        this.f12924c = new HashSet();
        if (r11 == null) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        Class<?> r14 = r11[r13];
        this.f12924c.add(r14.getName());
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass r10) {
        if (r10 == null) goto L13;
        if (r10.getName() == null) goto L13;
        String r11 = r10.getName();
        if (this.f12924c.contains(r11) == false) goto L11;
        return super.resolveClass(r10);
    L11:
        return Class.forName(r11, true, ClassLoader.getSystemClassLoader().getParent());
    L13:
        return super.resolveClass(r10);
    }
}
