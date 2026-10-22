package g0c;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.g0;
import com.ss.android.lark.passportc.internal.y;
import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.passportc.task.j;
import e0c.l;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements g {
    public final y a;
    public final com.ss.android.lark.passportc.task.g b;

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final List<j0c.b> f() {
        return this.b.f();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final List<j0c.b> g() {
        return this.b.g();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final void a(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.a.a(r2);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final Set<com.ss.android.lark.passportc.task.c> b(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        l r3 = this.a.g(r2);
        if (r3 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.c> r4 = ((j) r3).g();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final Set<d> c(UserSession r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        l r3 = this.a.g(r2);
        if (r3 == null) goto L7;
        Set<d> r4 = ((j) r3).R();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final void e(g0 r2) {
        Intrinsics.checkNotNullParameter(r2, "userDelegate");
        this.a.i(r2);
    }

    @Inject
    public a(y r2, com.ss.android.lark.passportc.task.g r3) {
        Intrinsics.checkNotNullParameter(r2, "userComponentManager");
        Intrinsics.checkNotNullParameter(r3, "taskOrder");
        this.a = r2;
        this.b = r3;
    }
}
