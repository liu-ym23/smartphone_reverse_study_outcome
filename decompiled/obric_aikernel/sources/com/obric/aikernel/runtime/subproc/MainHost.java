package com.obric.aikernel.runtime.subproc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.b;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.utils.d;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes2.dex */
public final class MainHost extends Binder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AIInferRuntime f5372c;

    public static final class Proxy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f5373a;

        public static final class a extends b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ w<Unit> f5374c;

            a(w<Unit> r10) {
                this.f5374c = r10;
            }

            @Override // com.obric.aikernel.b
            public void j2(Bundle r10) {
                this.f5374c.K(Unit.INSTANCE);
            }
        }

        public Proxy(IBinder r10) {
            Intrinsics.checkNotNullParameter(r10, "remote");
            this.f5373a = r10;
        }

        public final void a(int r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            Parcel r13 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r13, "obtain()");
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
            r13.writeInterfaceToken("MainHost");     // Catch: Throwable -> L5
            r13.writeInt(r10);     // Catch: Throwable -> L5
            r13.writeString(r11);     // Catch: Throwable -> L5
            r13.writeString(r12);     // Catch: Throwable -> L5
            Object r15 = Result.m32constructorimpl(Boolean.valueOf(this.f5373a.transact(1, r13, null, 1)));     // Catch: Throwable -> L5
        L7:
            Throwable r16 = Result.m35exceptionOrNullimpl(r15);
            if (r16 == null) goto L10;
            d.f5417a.e("MainHost", "aeeLog " + ExceptionsKt.stackTraceToString(r16));
        L10:
            r13.recycle();
            return;
        L5:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void b(String r10, String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "pkg");
            Intrinsics.checkNotNullParameter(r11, "version");
            Parcel r13 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r13, "obtain()");
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L5
            r13.writeInterfaceToken("MainHost");     // Catch: Throwable -> L5
            r13.writeString(r10);     // Catch: Throwable -> L5
            r13.writeString(r11);     // Catch: Throwable -> L5
            r13.writeBoolean(r12);     // Catch: Throwable -> L5
            Object r15 = Result.m32constructorimpl(Boolean.valueOf(this.f5373a.transact(2, r13, null, 1)));     // Catch: Throwable -> L5
        L7:
            Throwable r16 = Result.m35exceptionOrNullimpl(r15);
            if (r16 == null) goto L10;
            d.f5417a.e("MainHost", "notePackageCorrupt " + ExceptionsKt.stackTraceToString(r16));
        L10:
            r13.recycle();
            return;
        L5:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final Object c(final String r12, final String r13, Continuation<? super Boolean> r14) {
            if ((r14 instanceof MainHost$Proxy$requestPackage$1) == false) goto L7;
            MainHost$Proxy$requestPackage$1 r10 = (MainHost$Proxy$requestPackage$1) r14;
            int r11 = r10.label;
            if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
            r10.label = r11 - Integer.MIN_VALUE;
        L8:
            Object r15 = r10.result;
            Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r17 = r10.label;
            if (r17 == 0) goto L14;
            if (r17 != 1) goto L13;
            r13 = (String) r10.L$1;
            r12 = (String) r10.L$0;
            ResultKt.throwOnFailure(r15);
        L28:
            boolean r18 = ((Boolean) r15).booleanValue();
            d.f5417a.c("MainHost", "requestPackage " + r12 + ':' + r13 + ' ' + r18);
            return r15;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r15);
            d.f5417a.c("MainHost", "requestPackage " + r12 + ':' + r13 + " start");
            Parcel r19 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r19, "obtain()");
            final w r20 = y.a(null);
            b.a r21 = new MainHost$Proxy$requestPackage$callback$1(r12, r13, r20);
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L20
            r19.writeInterfaceToken("MainHost");     // Catch: Throwable -> L20
            r19.writeString(r12);     // Catch: Throwable -> L20
            r19.writeString(r13);     // Catch: Throwable -> L20
            r19.writeStrongBinder(r21);     // Catch: Throwable -> L20
            if (this.f5373a.transact(4, r19, null, 1) == true) goto L18;
            r20.K(Boxing.boxBoolean(false));     // Catch: Throwable -> L20
        L18:
            Object r111 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L22:
            Throwable r112 = Result.m35exceptionOrNullimpl(r111);
            if (r112 == null) goto L25;
            d.f5417a.e("MainHost", "requestPackage " + ExceptionsKt.stackTraceToString(r112));
            r20.K(Boxing.boxBoolean(false));
        L25:
            r19.recycle();
            r10.L$0 = r12;
            r10.L$1 = r13;
            r10.label = 1;
            r15 = r20.r(r10);
            if (r15 != r16) goto L28;
            return r16;
        L20:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r111 = Result.m32constructorimpl(ResultKt.createFailure(th));
        L7:
            r10 = new MainHost$Proxy$requestPackage$1(this, r14);
            goto L8
        }

        public final Object d(String r10, String r11, String r12, Continuation<? super Unit> r13) {
            Parcel r14 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r14, "obtain()");
            w r15 = y.a(null);
            a r16 = new a(r15);
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L8
            r14.writeInterfaceToken("MainHost");     // Catch: Throwable -> L8
            r14.writeStrongBinder(r16);     // Catch: Throwable -> L8
            r14.writeString(r10);     // Catch: Throwable -> L8
            r14.writeString(r11);     // Catch: Throwable -> L8
            r14.writeString(r12);     // Catch: Throwable -> L8
            if (this.f5373a.transact(3, r14, null, 1) == true) goto L6;
            r15.G(new RuntimeException("updatePackage not handled"));     // Catch: Throwable -> L8
        L6:
            Object r18 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r19 = Result.m35exceptionOrNullimpl(r18);
            if (r19 == null) goto L13;
            d.f5417a.e("MainHost", "_updatePackage " + ExceptionsKt.stackTraceToString(r19));
            r15.G(new RuntimeException("updatePackage failed", r19));
        L13:
            r14.recycle();
            Object r20 = r15.r(r13);
            if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
            return r20;
        L17:
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L10
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.subproc.MainHost$onTransact$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.runtime.subproc.MainHost$onTransact$1", f = "MainHost.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $biz;
        final /* synthetic */ b $callback;
        final /* synthetic */ String $lora;
        int label;
        final /* synthetic */ MainHost this$0;

        AnonymousClass1(MainHost r10, String r11, String r12, b r13, Continuation<? super AnonymousClass1> r14) {
            this.this$0 = r10;
            this.$biz = r11;
            this.$lora = r12;
            this.$callback = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$biz, this.$lora, this.$callback, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            boolean r13 = ((Boolean) r10).booleanValue();
            this.$callback.j2(e8.a.w(new Bundle(), Boxing.boxBoolean(r13), 0, null, 6, null));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            MainHost r14 = this.this$0;
            String r15 = this.$biz;
            String r16 = this.$lora;
            this.label = 1;
            r10 = r14.d(r15, r16, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    static {
        new a(null);
    }

    public MainHost(AIInferRuntime r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        super("MainHost");
        this.f5372c = r10;
    }

    public final void a(int r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "content");
        d.f5417a.aeeLog(r10, r11, r12);
    }

    public final AIInferRuntime b() {
        return this.f5372c;
    }

    public final void c(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "pkg");
        Intrinsics.checkNotNullParameter(r11, "version");
        this.f5372c.i0(r10, r11, r12);
    }

    public final Object d(String r11, String r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof MainHost$requestPackage$1) == false) goto L7;
        MainHost$requestPackage$1 r10 = (MainHost$requestPackage$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        MainHost$requestPackage$1 r15 = r10;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        boolean r19 = true;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        List r110 = (List) r16;
        Object r111 = null;
        if (r110 == null) goto L26;
        Iterator r112 = r110.iterator();
    L21:
        if (r112.hasNext() == false) goto L25;
        Object r113 = r112.next();
        if (((Boolean) ((Pair) r113).getSecond()).booleanValue() == false) goto L21;
        r111 = r113;
    L25:
        r111 = (Pair) r111;
    L26:
        if (r111 != null) goto L30;
        r19 = false;
    L30:
        return Boxing.boxBoolean(r19);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        d.f5417a.c("MainHost", "requestPackage start preparePackage " + r11 + '-' + r12);
        AIInferRuntime r20 = this.f5372c;
        r15.label = 1;
        r16 = AIInferRuntime.m0(r20, r11, r12, false, null, r15, 8, null);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r10 = new MainHost$requestPackage$1(this, r13);
        goto L8
    }

    public final void e(b r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "caller");
        h.d(this.f5372c.a0(), null, null, new MainHost$updatePackage$1(r10, this, r11, r12, r13, null), 3, null);
    }

    @Override // android.os.Binder
    protected boolean onTransact(int r14, Parcel r15, Parcel r16, int r17) {
        Intrinsics.checkNotNullParameter(r15, "data");
        if (r14 != 1) goto L5;
        r15.enforceInterface("MainHost");
        int r10 = r15.readInt();
        String r11 = r15.readString();
        String r12 = "";
        if (r11 != null) goto L37;
        r11 = "";
    L37:
        String r13 = r15.readString();
        if (r13 == null) goto L41;
        r12 = r13;
    L41:
        a(r10, r11, r12);
        return true;
    L5:
        if (r14 != 2) goto L7;
        r15.enforceInterface("MainHost");
        String r18 = r15.readString();
        if (r18 == null) goto L33;
        Intrinsics.checkNotNullExpressionValue(r18, "requireNotNull(data.readString())");
        String r19 = r15.readString();
        if (r19 == null) goto L31;
        Intrinsics.checkNotNullExpressionValue(r19, "requireNotNull(data.readString())");
        c(r18, r19, r15.readBoolean());
        return true;
    L31:
        throw new IllegalArgumentException("Required value was null.".toString());
    L33:
        throw new IllegalArgumentException("Required value was null.".toString());
    L7:
        if (r14 != 3) goto L9;
        r15.enforceInterface("MainHost");
        b r20 = b.a.U0(r15.readStrongBinder());
        Intrinsics.checkNotNullExpressionValue(r20, "asInterface(data.readStrongBinder())");
        String r21 = r15.readString();
        if (r21 == null) goto L24;
        Intrinsics.checkNotNullExpressionValue(r21, "requireNotNull(data.readString())");
        String r22 = r15.readString();
        if (r22 == null) goto L22;
        Intrinsics.checkNotNullExpressionValue(r22, "requireNotNull(data.readString())");
        e(r20, r21, r22, r15.readString());
        return true;
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    L24:
        throw new IllegalArgumentException("Required value was null.".toString());
    L9:
        if (r14 != 4) goto L43;
        r15.enforceInterface("MainHost");
        String r23 = r15.readString();
        if (r23 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r23, "requireNotNull(data.readString())");
        String r24 = r15.readString();
        b r25 = b.a.U0(r15.readStrongBinder());
        h.d(this.f5372c.a0(), null, null, new AnonymousClass1(this, r23, r24, r25, null), 3, null);
        return true;
    L15:
        throw new IllegalArgumentException("Required value was null.".toString());
    L43:
        return super.onTransact(r14, r15, r16, r17);
    }
}
