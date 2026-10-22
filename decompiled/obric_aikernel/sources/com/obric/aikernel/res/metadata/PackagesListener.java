package com.obric.aikernel.res.metadata;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class PackagesListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f5009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.channels.d<Function0<Unit>> f5010b;

    /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.PackagesListener$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.res.metadata.PackagesListener$1", f = "PackagesListener.kt", i = {0}, l = {21}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PackagesListener this$0;

        AnonymousClass1(PackagesListener r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0031 -> B:12:0x0034). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            l0 r13 = (l0) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            Function0 r14 = (Function0) r10;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
            r14.invoke();     // Catch: Throwable -> L15
            Object r16 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r17 = Result.m35exceptionOrNullimpl(r16);
            if (r17 != null) goto L19;
        L9:
            kotlinx.coroutines.channels.d r18 = PackagesListener.a(this.this$0);
            this.L$0 = r13;
            this.label = 1;
            r10 = r18.t(this);
            if (r10 != r11) goto L12;
            return r11;
        L19:
            com.obric.aikernel.runtime.utils.d.f5417a.e(PackageResourceManager.TAG, "receive onPackageChanged error: " + r17);
        L15:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            r13 = (l0) this.L$0;
            goto L9
        }
    }

    public PackagesListener(l0 r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.f5009a = new ArrayList();
        this.f5010b = f.b(Integer.MAX_VALUE, null, null, 6, null);
        h.d(r10, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final /* synthetic */ kotlinx.coroutines.channels.d a(PackagesListener r10) {
        return r10.f5010b;
    }

    public static /* synthetic */ void c(PackagesListener r10, AIPackage r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        r10.b(r11, r12);
    }

    public final void b(final AIPackage r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "pkg");
        List<a> r12 = this.f5009a;
        monitor-enter(r12);
        Iterator r13 = CollectionsKt.toList(this.f5009a).iterator();     // Catch: Throwable -> L13
    L6:
        if (r13.hasNext() == false) goto L10;
        final a r14 = (a) r13.next();     // Catch: Throwable -> L13
        Object r15 = this.f5010b.E(new PackagesListener$notifyPackageChanged$1$1$1(r14, r10, r11));     // Catch: Throwable -> L13
        if ((r15 instanceof g.c) == false) goto L6;
        Throwable r16 = g.e(r15);     // Catch: Throwable -> L13
        com.obric.aikernel.runtime.utils.d.f5417a.e(PackageResourceManager.TAG, "send onPackageChanged " + r10 + ' ' + r11 + " error: " + r16);     // Catch: Throwable -> L13
        goto L6
    L10:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r12);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void d(a r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        List<a> r11 = this.f5009a;
        monitor-enter(r11);
        this.f5009a.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void e(a r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        List<a> r11 = this.f5009a;
        monitor-enter(r11);
        this.f5009a.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
