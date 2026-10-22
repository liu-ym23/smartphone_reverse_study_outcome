package com.ss.android.lark.passportc.convention;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.l;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "get", "()Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class MutableProxyKt$createProxy$2<T> implements Provider {
    final /* synthetic */ v $accessor;
    final /* synthetic */ Function1<l, T> $finder;
    final /* synthetic */ UserSession $session;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableProxyKt$createProxy$2(Function1<? super l, ? extends T> r1, v r2, UserSession r3) {
        this.$finder = r1;
        this.$accessor = r2;
        this.$session = r3;
    }

    public final T get() {
        Function1<l, T> r0 = this.$finder;
        v r1 = this.$accessor;
        UserSession r2 = this.$session;
        if (r2 != null) goto L6;
        r2 = ContainerConstsKt.a();
    L6:
        return (T) r0.invoke(r1.c(r2));
    }
}
