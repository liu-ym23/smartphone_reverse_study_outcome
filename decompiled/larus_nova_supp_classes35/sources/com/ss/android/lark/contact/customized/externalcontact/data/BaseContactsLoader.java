package com.ss.android.lark.contact.customized.externalcontact.data;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BaseContactsLoader {
    public final CoroutineScope a;
    public final Function3<Boolean, Boolean, ErrorResult, Unit> b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public void a(long r1) {
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public abstract void e();

    /* JADX WARN: Multi-variable type inference failed */
    public BaseContactsLoader(CoroutineScope r2, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "reportPerf");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(BaseContactsLoader$syncStateStore$2.INSTANCE);
        this.d = LazyKt.lazy(BaseContactsLoader$fullSyncTtlMillis$2.INSTANCE);
    }
}
