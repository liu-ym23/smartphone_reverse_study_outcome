package com.larksuite.rucket.impl.base.request;

import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.core.proxymethod.BaseProxyMethod;
import com.squareup.wire.Message;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a<T extends Annotation> extends BaseProxyMethod<T> {
    public final l d;

    /* JADX INFO: renamed from: com.larksuite.rucket.impl.base.request.a$a, reason: collision with other inner class name */
    public static final class C0059a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a<T> a;
        public final /* synthetic */ IGetDataCallback<?> b;

        public b(a<T> r1, IGetDataCallback<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            x r5 = (s) r4;
            a<T> r0 = this.a;
            Intrinsics.checkNotNull(r5);
            IGetDataCallback<?> r1 = this.b;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larksuite.framework.callback.IGetDataCallback<com.squareup.wire.Message<*, *>>");
            r0.getClass();
            if ((r5 instanceof x) == false) goto L6;
            r1.onSuccess(r5.c);
            return;
        L6:
            if ((r5 instanceof c) == false) goto L10;
            r1.onError(p.a(((c) r5).c));
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public abstract d<Message<?, ?>> f(Object[] r1);

    public a(l r2, Method r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "origin");
        super(r3);
        this.d = r2;
    }

    @Override // com.larksuite.rucket.core.proxymethod.b
    public final void a(IGetDataCallback<?> r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "args");
        this.d.h(f(r3)).a().subscribe(new b(this, r2));
    }
}
