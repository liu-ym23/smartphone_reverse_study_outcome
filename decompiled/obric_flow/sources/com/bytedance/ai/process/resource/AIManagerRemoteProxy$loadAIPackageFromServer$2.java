package com.bytedance.ai.process.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.process.g;
import com.bytedance.ai.resource.f0;
import com.bytedance.ai.resource.g0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/AIPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$loadAIPackageFromServer$2", f = "AIManagerRemoteProxy.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
final class AIManagerRemoteProxy$loadAIPackageFromServer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIPackage>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2436c;
    public final /* synthetic */ AIPackage.AIPackageType d;
    public final /* synthetic */ Map e;

    /* JADX INFO: renamed from: com.bytedance.ai.process.resource.AIManagerRemoteProxy$loadAIPackageFromServer$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/objects/AIPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.process.resource.AIManagerRemoteProxy$loadAIPackageFromServer$2$1", f = "AIManagerRemoteProxy.kt", i = {1}, l = {41, 226}, m = "invokeSuspend", n = {"remoteService"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nAIManagerRemoteProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIManagerRemoteProxy.kt\ncom/bytedance/ai/process/resource/AIManagerRemoteProxy$loadAIPackageFromServer$2$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,225:1\n318#2,11:226\n*S KotlinDebug\n*F\n+ 1 AIManagerRemoteProxy.kt\ncom/bytedance/ai/process/resource/AIManagerRemoteProxy$loadAIPackageFromServer$2$1\n*L\n46#1:226,11\n*E\n"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIPackage>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f2438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f2439c;
        public final /* synthetic */ AIPackage.AIPackageType d;
        public final /* synthetic */ Map e;

        public AnonymousClass1(String r5, String r10, AIPackage.AIPackageType r11, Map r12, Continuation r13) {
            this.f2438b = r5;
            this.f2439c = r10;
            this.d = r11;
            this.e = r12;
            super(2, r13);
        }

        public static final void a(AtomicReference r5, AIPackage r10) {
            j r11 = (j) r5.getAndSet(null);
            if (r11 != null) goto L6;
            return;
        L6:
            if (r11.isActive() == false) goto L9;
            r11.resumeWith(Result.m124constructorimpl(r10));
            return;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r10, Continuation r11) {
            return new AnonymousClass1(this.f2438b, this.f2439c, this.d, this.e, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super AIPackage> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v5, types: [int] */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.util.concurrent.atomic.AtomicReference] */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r25) {
            int r5 = 0;
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.f2437a;
            if (r11 == 0) goto L11;
            if (r11 == 1) goto L10;
            if (r11 != 2) goto L9;
            ResultKt.throwOnFailure(r25);
            return r25;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r25);
            Object r12 = r25;
        L14:
            g r13 = (g) r12;
            ?? r14 = "tag";
            if (r13 != null) goto L20;
            Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");
            t0.d r15 = com.bytedance.ai.utils.c.f2846a;
            if (r15 == null) goto L19;
            r15.e("AIManagerRemoteProxy", "failed to connect remote service");
        L19:
            return null;
        L20:
            String r16 = this.f2438b;
            String r17 = this.f2439c;
            AIPackage.AIPackageType r18 = this.d;
            Map r19 = this.e;
            this.f2437a = 2;
            l r20 = new l(1, IntrinsicsKt.intercepted(this));
            r20.w();
            AtomicReference r110 = new AtomicReference(r20);
            r20.y(new b(r110, r5));
            StringBuilder r111 = new StringBuilder("loadAIPackageFromServer: ");
            r111.append(r16);
            r111.append(", ");
            String r112 = androidx.room.jarjarred.org.antlr.runtime.a.v(r111, r17, "AIManagerRemoteProxy", "tag");
            t0.d r113 = com.bytedance.ai.utils.c.f2846a;
            if (r113 == null) goto L23;
            r113.d("AIManagerRemoteProxy", r112);
        L23:
            ConcurrentHashMap r114 = com.bytedance.ai.multiprocess.c.f2405a;
            Intrinsics.checkNotNullParameter(r16, "packageName");
            com.bytedance.ai.multiprocess.b r115 = (com.bytedance.ai.multiprocess.b) com.bytedance.ai.multiprocess.c.f2405a.get(r16);
            Intrinsics.checkNotNullParameter(com.bytedance.ai.resource.j.f2734a, "<this>");
            Intrinsics.checkNotNullParameter(r16, "packageName");
            Intrinsics.checkNotNullParameter(r16, "packageName");
            f0 r21 = (f0) com.bytedance.ai.resource.j.d.get(r16);
            if (r21 != null) goto L26;
            com.bytedance.ai.resource.b r22 = null;
        L31:
            if (r22 != null) goto L33;
            g0 r23 = null;
        L34:
            if (r115 == null) goto L36;
            long r24 = r115.f2403a;
        L77:
            r14 = r18.ordinal();     // Catch: Throwable -> L61
            if (r14 != 0) goto L73;
            AtomicReference r26 = r110;
            ((com.bytedance.ai.process.e) r13).f(com.bytedance.ai.process.d.f2418h, r16, r17, r24, r19, new c(r26, 0));     // Catch: Throwable -> L59
            r14 = r26;
        L74:
        L67:
            Object r27 = r20.v();
            if (r27 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L70;
            DebugProbesKt.probeCoroutineSuspended(this);
        L70:
            if (r27 != r10) goto L72;
        L71:
            return r10;
        L72:
            return r27;
        L73:
            if (r14 == 1) goto L55;
            Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", "tag");     // Catch: Throwable -> L49
            t0.d r28 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L49
            if (r28 == null) goto L51;
            r28.e("AIManagerRemoteProxy", "invalid packageType");     // Catch: Throwable -> L49
        L51:
            a(r110, null);     // Catch: Throwable -> L49
            goto L67
        L55:
            r14 = r110;
            ((com.bytedance.ai.process.e) r13).i(com.bytedance.ai.process.d.f2418h, r16, r17, r24, r19, new c(r110, 1));     // Catch: Throwable -> L59
        L49:
            th = th;
            r14 = r110;
        L63:
            String r29 = "remote load failed: " + th.getMessage();
            Intrinsics.checkNotNullParameter("AIManagerRemoteProxy", r14);
            t0.d r30 = com.bytedance.ai.utils.c.f2846a;
            if (r30 == null) goto L66;
            r30.e("AIManagerRemoteProxy", r29, th);
        L66:
            a(r14, null);
        L59:
            th = th;
        L61:
            th = th;
            r14 = r110;
            r14 = r14;
            goto L63
        L36:
            if (r23 == null) goto L38;
            r24 = r23.f2724a;
            goto L77
        L38:
            r24 = 0;
            goto L77
        L33:
            r23 = new g0(r22.f2562a, r22.f2563b);
            goto L34
        L26:
            long r31 = r21.f2721i;
            String r116 = r21.f2722j;
            if (r21.f2720h == false) goto L29;
            int r117 = r21.d.get();
        L30:
            r22 = new com.bytedance.ai.resource.b(r117, r31, r116, r21.e);
            goto L31
        L29:
            r117 = 0;
            goto L30
        L11:
            ResultKt.throwOnFailure(r25);
            com.bytedance.ai.process.d r32 = com.bytedance.ai.process.d.f2415a;
            this.f2437a = 1;
            r12 = r32.e(this);
            if (r12 != r10) goto L14;
            goto L14
        }
    }

    public AIManagerRemoteProxy$loadAIPackageFromServer$2(String r5, String r10, AIPackage.AIPackageType r11, Map r12, Continuation r13) {
        this.f2435b = r5;
        this.f2436c = r10;
        this.d = r11;
        this.e = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AIManagerRemoteProxy$loadAIPackageFromServer$2(this.f2435b, this.f2436c, this.d, this.e, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super AIPackage> r10) {
        return ((AIManagerRemoteProxy$loadAIPackageFromServer$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2434a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        AnonymousClass1 r12 = new AnonymousClass1(this.f2435b, this.f2436c, this.d, this.e, null);
        this.f2434a = 1;
        Object r13 = e2.b(12000, r12, this);
        if (r13 != r5) goto L12;
        return r5;
    L12:
        return r13;
    }
}
