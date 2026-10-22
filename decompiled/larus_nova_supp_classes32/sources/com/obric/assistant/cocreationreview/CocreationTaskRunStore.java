package com.obric.assistant.cocreationreview;

import com.bytedance.keva.Keva;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CocreationTaskRunStore {
    public static final Lazy<Keva> c = null;
    public final Function1<String, Boolean> a;
    public final Function1<String, Unit> b;

    public static final class a {
    }

    static {
        c = LazyKt.lazy(new r4());
    }

    public CocreationTaskRunStore(int r3) {
        Function1<String, Boolean> r4 = new s4();
        Function1<String, Unit> r0 = new t4();
        Intrinsics.checkNotNullParameter(r4, "readRun");
        Intrinsics.checkNotNullParameter(r0, "writeRun");
        this.a = r4;
        this.b = r0;
    }

    public static final String a(CocreationTaskRunStore r1, String r2, String r3) {
        r1.getClass();
        return r2.length() + ':' + r2 + ':' + r3;
    }

    public final Object b(String r4, List<e4> r5, Continuation<? super Set<String>> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CocreationTaskRunStore$loadRunIds$2(r4, r5, this, null), r6);
    }
}
