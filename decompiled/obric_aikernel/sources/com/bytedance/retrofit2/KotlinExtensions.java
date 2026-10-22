package com.bytedance.retrofit2;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.event.EnsureReportData;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "KotlinExtensions")
public final class KotlinExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f2419a;

        a(kotlinx.coroutines.n r10) {
            this.f2419a = r10;
        }

        @Override // com.bytedance.retrofit2.e
        public void a(com.bytedance.retrofit2.b<T> r10, a0<T> r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "response");
            if (r11.f() == false) goto L8;
            T r12 = r11.a();
            if (r12 != null) goto L7;
            Object r13 = r10.a().V(n.class);
            Intrinsics.checkNotNull(r13);
            Method r14 = ((n) r13).a();
            StringBuilder r15 = new StringBuilder();
            r15.append("Response from ");
            Intrinsics.checkNotNullExpressionValue(r14, EnsureReportData.METHOD);
            Class<?> r16 = r14.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(r16, "method.declaringClass");
            r15.append(r16.getName());
            r15.append('.');
            r15.append(r14.getName());
            r15.append(" was null but response body type was declared as non-null");
            KotlinNullPointerException r17 = new KotlinNullPointerException(r15.toString());
            kotlinx.coroutines.n r18 = this.f2419a;
            Result.Companion r19 = Result.Companion;
            Object r20 = ResultKt.createFailure(r17);
        L9:
            Object r21 = Result.m32constructorimpl(r20);
        L10:
            r18.resumeWith(r21);
            return;
        L7:
            r18 = this.f2419a;
            Result.Companion r22 = Result.Companion;
            r21 = Result.m32constructorimpl(r12);
            goto L10
        L8:
            r18 = this.f2419a;
            HttpException r23 = new HttpException(r11);
            Result.Companion r24 = Result.Companion;
            r20 = ResultKt.createFailure(r23);
            goto L9
        }

        @Override // com.bytedance.retrofit2.e
        public void b(com.bytedance.retrofit2.b<T> r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "t");
            kotlinx.coroutines.n r12 = this.f2419a;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f2420a;

        b(kotlinx.coroutines.n r10) {
            this.f2420a = r10;
        }

        @Override // com.bytedance.retrofit2.e
        public void a(com.bytedance.retrofit2.b<T> r10, a0<T> r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "response");
            boolean r12 = r11.f();
            kotlinx.coroutines.n r13 = this.f2420a;
            if (r12 == false) goto L5;
            Object r14 = r11.a();
            Result.Companion r15 = Result.Companion;
        L6:
            r13.resumeWith(Result.m32constructorimpl(r14));
            return;
        L5:
            HttpException r16 = new HttpException(r11);
            Result.Companion r17 = Result.Companion;
            r14 = ResultKt.createFailure(r16);
            goto L6
        }

        @Override // com.bytedance.retrofit2.e
        public void b(com.bytedance.retrofit2.b<T> r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "t");
            kotlinx.coroutines.n r12 = this.f2420a;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f2421a;

        c(kotlinx.coroutines.n r10) {
            this.f2421a = r10;
        }

        @Override // com.bytedance.retrofit2.e
        public void a(com.bytedance.retrofit2.b<T> r10, a0<T> r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "response");
            kotlinx.coroutines.n r12 = this.f2421a;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.m32constructorimpl(r11));
        }

        @Override // com.bytedance.retrofit2.e
        public void b(com.bytedance.retrofit2.b<T> r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(r11, "t");
            kotlinx.coroutines.n r12 = this.f2421a;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
        }
    }

    static final class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation f2422c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Exception f2423g;

        d(Continuation r10, Exception r11) {
            this.f2422c = r10;
            this.f2423g = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation r10 = IntrinsicsKt.intercepted(this.f2422c);
            Exception r11 = this.f2423g;
            Result.Companion r12 = Result.Companion;
            r10.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r11)));
        }
    }

    public static final <T> Object a(final com.bytedance.retrofit2.b<T> r10, Continuation<? super T> r11) {
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        r12.h(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(r10));
        r10.c(new a(r12));
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r13;
    }

    @JvmName(name = "awaitNullable")
    public static final <T> Object b(final com.bytedance.retrofit2.b<T> r10, Continuation<? super T> r11) {
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        r12.h(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(r10));
        r10.c(new b(r12));
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r13;
    }

    public static final <T> Object c(final com.bytedance.retrofit2.b<T> r10, Continuation<? super a0<T>> r11) {
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        r12.h(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(r10));
        r10.c(new c(r12));
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r13;
    }

    public static final Object d(Exception r10, Continuation<?> r11) {
        z0.a().dispatch(r11.getContext(), new d(r11, r10));
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L6:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r12;
    L9:
        return Unit.INSTANCE;
    }
}
