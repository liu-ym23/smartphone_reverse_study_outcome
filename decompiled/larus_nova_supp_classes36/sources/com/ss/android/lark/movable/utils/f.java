package com.ss.android.lark.movable.utils;

import com.google.gson.Gson;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final Gson a = null;
    public static final Map<String, Long> b = null;
    public static final CoroutineScope c = null;
    public static final Map<String, Integer> d = null;

    public static final class a {
        public final long a;
        public final int b;
        public final int c;
        public final float d;
        public final float e;
        public final List<Integer> f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r9.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r9.e) == 0) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "FrameMeta(delay=" + this.a + ", docId=" + this.b + ", docVersion=" + this.c + ", width=" + this.d + ", height=" + this.e + ", islandIds=" + this.f + ')';
        }

        public a(long r2, int r4, int r5, float r6, float r7, List<Integer> r8) {
            Intrinsics.checkNotNullParameter(r8, "islandIds");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    static {
        a = new Gson();
        b = new LinkedHashMap();
        c = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("TypewriterRecorder"))).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        d = new LinkedHashMap();
    }
}
