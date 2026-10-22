package com.tom_roush.pdfbox.pdmodel.encryption;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f16209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Class<? extends l>> f16210b;
    private final Map<Class<? extends f>, Class<? extends l>> c;

    static {
        f16209a = new m();
    }

    private m() {
        this.f16210b = new HashMap();
        this.c = new HashMap();
        a("Standard", p.class, o.class);
        a("Adobe.PubSec", i.class, h.class);
    }

    private l a(Class<? extends l> r1, Class<?>[] r2, Object[] r3) {
        return (l) ZeusTransformUtils.preCheckCast(r1.getDeclaredConstructor(r2).newInstance(r3), l.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public l a(String r3) {
        Class<? extends l> r4 = (Class) ZeusTransformUtils.preCheckCast(this.f16210b.get(r3), Class.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return a(r4, new Class[0], new Object[0]);
    }

    public void a(String r2, Class<? extends l> r3, Class<? extends f> r4) {
        if (this.f16210b.containsKey(r2) == true) goto L7;
        this.f16210b.put(r2, r3);
        this.c.put(r4, r3);
        return;
    L7:
        throw new IllegalStateException("The security handler name is already registered");
    }
}
