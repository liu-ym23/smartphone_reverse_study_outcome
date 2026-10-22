package com.ss.android.lark.coremd.base.parse;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b extends com.ss.android.lark.coremd.ext.j {
    public static final a a = null;

    public static final class a implements b {
        public static final /* synthetic */ a d = null;
        public final /* synthetic */ com.ss.android.lark.coremd.impl.parse.a c;

        static {
            d = new a();
        }

        @Override // com.ss.android.lark.coremd.base.parse.b
        public final b b(b r2) {
            Intrinsics.checkNotNullParameter(r2, "that");
            return this.c.b(r2);
        }

        @Override // com.ss.android.lark.coremd.base.parse.b
        public final b clone() {
            return this.c.clone();
        }

        @Override // com.ss.android.lark.coremd.ext.j
        public final Map<Object, Object> getValues() {
            return this.c.c;
        }

        public a() {
            this.c = new com.ss.android.lark.coremd.impl.parse.a();
        }
    }

    static {
        a = a.d;
    }

    b b(b r1);

    b clone();
}
