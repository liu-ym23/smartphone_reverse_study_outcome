package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.coremd.base.parse.q;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements p {
    public final Map<Class<?>, q<s>> a;

    public static final class a {
        public final Map<Class<?>, q<s>> a;

        public a() {
            this.a = new LinkedHashMap();
        }

        public final a a(Class r2, q r3) {
            Intrinsics.checkNotNullParameter(r2, "clazz");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.a.put(r2, r3);
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Map<Class<?>, ? extends q<s>> r2) {
        Intrinsics.checkNotNullParameter(r2, "spanFactoryMap");
        this.a = r2;
    }

    @Override // com.ss.android.lark.coremd.base.parse.p
    public final Object a(com.ss.android.lark.coremd.base.parse.i r3, s r4) {
        Intrinsics.checkNotNullParameter(r3, "parseContext");
        Intrinsics.checkNotNullParameter(r4, "node");
        q<s> r0 = this.a.get(r4.getClass());
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(new i(r3, r4));
    }
}
