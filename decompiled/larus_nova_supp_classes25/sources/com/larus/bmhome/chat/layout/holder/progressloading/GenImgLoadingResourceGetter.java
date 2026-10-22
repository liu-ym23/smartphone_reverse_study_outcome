package com.larus.bmhome.chat.layout.holder.progressloading;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GenImgLoadingResourceGetter {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static String d;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
    }

    public static e a() {
        if (((Boolean) a.getValue()).booleanValue() == false) goto L10;
        if (o0.d(d) == false) goto L10;
        if (new PolarisFileWrapper(d).exists() == false) goto L10;
        return new e.b(d);
    L10:
        return (e.a) b.getValue();
    }

    public static void b() {
        if (d == null) goto L5;
        return;
    L5:
        if (o0.d((String) c.getValue()) == false) goto L9;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new GenImgLoadingResourceGetter$init$1(null), 2, null);
        return;
    }
}
