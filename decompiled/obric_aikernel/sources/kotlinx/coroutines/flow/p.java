package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n107#2:355\n107#2:356\n107#2:357\n107#2:358\n107#2:359\n107#2:360\n107#2:361\n107#2:362\n107#2:363\n107#2:364\n107#2:365\n107#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
final /* synthetic */ class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,113:1\n136#2,2:114\n*E\n"})
    public static final class a<T> implements c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f10508c;

        public a(Object r10) {
            this.f10508c = r10;
        }

        @Override // kotlinx.coroutines.flow.c
        public Object a(d<? super T> r10, Continuation<? super Unit> r11) {
            Object r12 = r10.emit((Object) this.f10508c, r11);
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r12;
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final <T> c<T> a(@BuilderInference Function2<? super kotlinx.coroutines.channels.l<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return new CallbackFlowBuilder(r10, null, 0, null, 14, null);
    }

    public static final <T> c<T> b(@BuilderInference Function2<? super d<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return new i1(r10);
    }

    public static final <T> c<T> c(T r10) {
        return new a(r10);
    }
}
