package com.bumptech.glide;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, b> f553a;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, b> f554a;

        a() {
            this.f554a = new HashMap();
        }

        static /* synthetic */ Map a(a r0) {
            return r0.f554a;
        }

        a a(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.f554a.put(r4.getClass(), r4);
            return this;
        }

        f a() {
            return new f(this);
        }

        a update(b r3, boolean r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (r4 == false) goto L5;
            a(r5);
        L6:
            return this;
        L5:
            this.f554a.remove(r5.getClass());
            goto L6
        }
    }

    interface b {
    }

    f(a r2) {
        this.f553a = Collections.unmodifiableMap(new HashMap(a.a(r2)));
    }

    public boolean a(Class<? extends b> r1) {
        return this.f553a.containsKey(r1);
    }
}
