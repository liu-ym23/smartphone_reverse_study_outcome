package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.task.d;
import gy7.p;
import gy7.q;
import gy7.w;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class KmpOnlineTask implements d {
    public static final j0c.b a = null;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ KmpOnlineTask a;

        public b(KmpOnlineTask r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Throwable r6 = (Throwable) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            Log.e("PassportKmpOnlineTask", "execute online tasks failed: " + ExceptionsKt.stackTraceToString(r6));
            this.a.getClass();
            j0c.b r1 = KmpOnlineTask.a;
            String r7 = r6.getMessage();
            if (r7 != null) goto L6;
            r7 = "execute KMP online tasks failed";
        L6:
            return new c(r1, false, r7, 4);
        }
    }

    @Inject
    public KmpOnlineTask() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final boolean G() {
        return true;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(e r1) {
        return com.ss.android.lark.passportc.task.e.a(this, r1);
    }

    static {
        a = new j0c.b("Kmp UserState online Task");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return a;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<c> I(final e r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r0 = com.ss.android.lark.passportc.ffi.b.a;
        final p r5 = com.ss.android.lark.passportc.ffi.b.b(r8.a);
        if (r5 == null) goto L5;
        com.lark.kmp.containerization.b r2 = iy7.a.a();
        if (r2 == null) goto L14;
        Object r1 = r2.a(Reflection.getOrCreateKotlinClass(w.class));
        if (r1 == null) goto L13;
        final w r3 = (w) r1;
        UserSession r4 = r8.a.b;
        final q r6 = new q(r4.b, r4.a);
        return Observable.fromCallable(new KmpOnlineTask$execute$1(this, r3, r6, r5, r8)).onErrorReturn(new b(this));
    L13:
        throw new IllegalArgumentException("No instance of " + Reflection.getOrCreateKotlinClass(w.class).getSimpleName() + " found");
    L14:
        Log.e("PassportKmpOnlineTask", "execute skipped: KMP task executor not found");
        return Observable.just(new c(a, false, "KMP task executor not found", 4));
    L5:
        return Observable.just(new c(a, false, "KMP user payload is null", 4));
    }
}
