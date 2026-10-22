package c1;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(com.bytedance.applog.c r10, HashSet<String> r11, HashMap<String, HashSet<String>> r12) {
        super(r10, r11, r12);
    }

    @Override // c1.a
    protected boolean c(String r10) {
        return this.f608a.contains(r10);
    }

    @Override // c1.a
    protected boolean d(HashSet<String> r10, String r11) {
        return r10.contains(r11);
    }
}
