package com.ss.android.lark.passportc.task;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.q;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements d {
    public static final j0c.b c = null;

    @Inject
    public m a;

    @Inject
    public Set<q> b;

    public static final class a {
    }

    @Inject
    public h() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r1) {
        return e.a(this, r1);
    }

    static {
        c = new j0c.b("register_static_user_convention");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return c;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Set<q> r6 = this.b;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("staticConventions");
        r6 = null;
    L6:
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L15;
        q r1 = (q) r7.next();
        m r2 = this.a;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("userService");
        r2 = null;
    L13:
        r2.d(r1);
        goto L8
    L15:
        return Observable.just(new j0c.c(c, true, null, 12));
    }
}
