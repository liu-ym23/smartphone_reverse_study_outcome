package wfb;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public C0318a a;

    /* JADX INFO: renamed from: wfb.a$a, reason: collision with other inner class name */
    public final class C0318a {
        public Function3<? super Boolean, ? super String, ? super View, Unit> a;
        public Function0<Unit> b;
        public Function2<? super Boolean, ? super Boolean, Unit> c;
        public Function2<? super Boolean, ? super Boolean, Unit> d;
        public Function1<? super View, Unit> e;
        public Function2<? super Boolean, ? super Boolean, Unit> f;
        public Function2<? super Boolean, ? super Boolean, Unit> g;
        public Function1<? super Boolean, Unit> h;

        public C0318a() {
        }
    }

    public a() {
    }

    public final C0318a a() {
        C0318a r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("builder");
        return null;
    }
}
