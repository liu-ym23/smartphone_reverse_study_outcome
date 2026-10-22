package com.ss.android.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f15721b;
    private long c;
    private InterfaceC0837a d;

    /* JADX INFO: renamed from: com.ss.android.token.a$a, reason: collision with other inner class name */
    public interface InterfaceC0837a {
        boolean a();
    }

    public String a() {
        return this.f15720a;
    }

    public void a(Collection<String> r3) {
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.size() <= 0) goto L9;
        this.f15721b.addAll(r4);
        return;
    }

    public long b() {
        return this.c;
    }

    public InterfaceC0837a c() {
        return this.d;
    }
}
