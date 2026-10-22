package com.bytedance.android.live.room.navi.userinfo_p;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;
import sh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UserInfoContextExtKt {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(c.b((b) r2));
        }
    }

    public static final <T> p<n<T>> a(DataContext r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$directMutable");
        return q.b(r1, UserInfoContextExtKt$directMutable$1.INSTANCE);
    }

    public static final <T> Disposable b(n<T> r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$notNullStickySubscribe");
        Intrinsics.checkNotNullParameter(r2, "observer");
        Object r0 = r1.getValue();
        if (r0 == null) goto L6;
        r2.invoke(r0);
    L6:
        return r1.a().subscribe(new a(r2));
    }
}
