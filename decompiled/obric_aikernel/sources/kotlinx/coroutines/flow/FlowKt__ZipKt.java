package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,332:1\n272#1,3:334\n272#1,3:337\n261#1:340\n263#1:342\n272#1,3:343\n261#1:346\n263#1:348\n272#1,3:349\n261#1:352\n263#1:354\n272#1,3:355\n107#2:333\n107#2:341\n107#2:347\n107#2:353\n107#2:358\n107#2:359\n107#2:362\n37#3,2:360\n37#3,2:363\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n75#1:334,3\n103#1:337,3\n119#1:340\n119#1:342\n138#1:343,3\n156#1:346\n156#1:348\n177#1:349,3\n197#1:352\n197#1:354\n220#1:355,3\n32#1:333\n119#1:341\n156#1:347\n197#1:353\n237#1:358\n261#1:359\n288#1:362\n287#1:360,2\n306#1:363,2\n*E\n"})
final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,113:1\n33#2,2:114\n*E\n"})
    public static final class a<R> implements c<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f10436c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f10437g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function3 f10438h;

        public a(c r10, c r11, Function3 r12) {
            this.f10436c = r10;
            this.f10437g = r11;
            this.f10438h = r12;
        }

        @Override // kotlinx.coroutines.flow.c
        public Object a(d<? super R> r10, Continuation<? super Unit> r11) {
            Object r12 = CombineKt.a(r10, new c[]{this.f10436c, this.f10437g}, FlowKt__ZipKt.a(), new FlowKt__ZipKt$combine$1$1(this.f10438h, null), r11);
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r12;
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ Function0 a() {
        return d();
    }

    public static final <T1, T2, T3, R> c<R> b(c<? extends T1> r10, c<? extends T2> r11, c<? extends T3> r12, @BuilderInference final Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> r13) {
        final c[] r14 = {r10, r11, r12};
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1(r14, r13);
    }

    @JvmName(name = "flowCombine")
    public static final <T1, T2, R> c<R> c(c<? extends T1> r10, c<? extends T2> r11, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r12) {
        return new a(r10, r11, r12);
    }

    private static final <T> Function0<T[]> d() {
        return FlowKt__ZipKt$nullArrayFactory$1.INSTANCE;
    }
}
