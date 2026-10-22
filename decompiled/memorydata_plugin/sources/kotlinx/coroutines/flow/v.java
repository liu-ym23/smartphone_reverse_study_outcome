package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080H¢\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aE\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\u0010\u0011\u001a0\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a$\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aE\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\u0002\u0010\u0011\u001am\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\u0001\u0010\u001b\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u0013\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001c¢\u0006\u0002\b\u001d¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"collectWhile", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", CommonConsts.COUNT_TYPE, "", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "ownershipMarker", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class v {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f17510a;

        public a(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
            this.f17510a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__LimitKt$collectWhile$collector$1$emit$1.class) == false) goto L7;
            FlowKt__LimitKt$collectWhile$collector$1$emit$1 r0 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__LimitKt$collectWhile$collector$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
            return Unit.INSTANCE;
        L22:
            throw new AbortFlowException(this);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            Function2<T, Continuation<? super Boolean>, Object> r10 = this.f17510a;
            r0.L$0 = this;
            r0.label = 1;
            r9 = r10.invoke(r6, r0);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r8);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17512b;

        public b(kotlinx.coroutines.flow.i r3, int r4) {
            this.f17511a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f17512b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r5, Continuation<? super Unit> r6) {
            j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            Ref.IntRef r0 = new Ref.IntRef();
            Object r4 = this.f17511a.collect((j) ZeusTransformUtils.preCheckCast(new c(r0, this.f17512b, r7), j.class, "com.obric.memorydata.plugin"), r8);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class c<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f17513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17514b;
        final /* synthetic */ j<T> c;

        c(Ref.IntRef r3, int r4, j<? super T> r5) {
            j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
            this.f17513a = r3;
            this.f17514b = r4;
            this.c = r6;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, FlowKt__LimitKt$drop$2$1$emit$1.class) == false) goto L7;
            FlowKt__LimitKt$drop$2$1$emit$1 r0 = (FlowKt__LimitKt$drop$2$1$emit$1) ZeusTransformUtils.preCheckCast(r7, FlowKt__LimitKt$drop$2$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L20:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            if (this.f17513a.element < this.f17514b) goto L21;
            j<T> r4 = this.c;
            r0.label = 1;
            if (r4.emit(r5, r0) != r1) goto L20;
            return r1;
        L21:
            this.f17513a.element++;
            int r9 = this.f17513a.element;
            return Unit.INSTANCE;
        L7:
            r0 = new FlowKt__LimitKt$drop$2$1$emit$1(this, r7);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17516b;

        public d(kotlinx.coroutines.flow.i r3, Function2 r4) {
            kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.f17515a = r5;
            this.f17516b = r6;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r5, Continuation<? super Unit> r6) {
            j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            Ref.BooleanRef r0 = new Ref.BooleanRef();
            Object r4 = this.f17515a.collect((j) ZeusTransformUtils.preCheckCast(new e(r0, r7, this.f17516b), j.class, "com.obric.memorydata.plugin"), r8);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class e<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f17517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<T> f17518b;
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> c;

        e(Ref.BooleanRef r3, j<? super T> r4, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r5) {
            j<T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            Function2<T, Continuation<? super Boolean>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            this.f17517a = r3;
            this.f17518b = r6;
            this.c = r7;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r8, Continuation<? super Unit> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__LimitKt$dropWhile$1$1$emit$1.class) == false) goto L7;
            FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (FlowKt__LimitKt$dropWhile$1$1$emit$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__LimitKt$dropWhile$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L17;
            if (r3 == 2) goto L16;
            if (r3 != 3) goto L15;
            ResultKt.throwOnFailure(r11);
        L34:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r8 = (T) r0.L$1;
            e<T> this = (e) ZeusTransformUtils.preCheckCast(r0.L$0, e.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L29:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L36;
            this.f17517a.element = true;
            j<T> r7 = this.f17518b;
            r0.L$0 = null;
            r0.L$1 = null;
            r0.label = 3;
            if (r7.emit(r8, r0) != r2) goto L34;
            return r2;
        L36:
            return Unit.INSTANCE;
        L17:
            ResultKt.throwOnFailure(r11);
        L24:
            return Unit.INSTANCE;
        L18:
            ResultKt.throwOnFailure(r11);
            if (this.f17517a.element == false) goto L25;
            j<T> r12 = this.f17518b;
            r0.label = 1;
            if (r12.emit(r8, r0) != r2) goto L24;
            return r2;
        L25:
            Function2<T, Continuation<? super Boolean>, Object> r13 = this.c;
            r0.L$0 = this;
            r0.L$1 = r8;
            r0.label = 2;
            r11 = r13.invoke(r8, r0);
            if (r11 != r2) goto L29;
            return r2;
        L7:
            r0 = new FlowKt__LimitKt$dropWhile$1$1$emit$1(this, r10);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class f<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17520b;

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r8, Continuation<? super Unit> r9) {
            j r10 = (j) ZeusTransformUtils.wrapperContextForParams(r8, j.class, "com.obric.memorydata.plugin");
            Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r11, FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r11, FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            Object r7 = r0.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: AbortFlowException -> L14
        L26:
            return Unit.INSTANCE;
        L14:
            e = e;
        L24:
            kotlinx.coroutines.flow.internal.o.a(e, r7);
            goto L26
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r12);
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Object r14 = new Object();
            Ref.IntRef r4 = new Ref.IntRef();
            kotlinx.coroutines.flow.i r5 = this.f17519a;     // Catch: AbortFlowException -> L22
            j<? super T> r15 = (j) ZeusTransformUtils.preCheckCast(new g(r4, this.f17520b, r10, r14), j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L22
            r0.L$0 = r14;     // Catch: AbortFlowException -> L22
            r0.label = 1;     // Catch: AbortFlowException -> L22
            if (r5.collect(r15, r0) != r2) goto L26;
            return r2;
        L22:
            e = e;
            r7 = r14;
        L7:
            r0 = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1(this, r11);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class g<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f17521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f17522b;
        final /* synthetic */ j<T> c;
        final /* synthetic */ Object d;

        g(Ref.IntRef r3, int r4, j<? super T> r5, Object r6) {
            j<T> r7 = (j) ZeusTransformUtils.wrapperContextForParams(r5, j.class, "com.obric.memorydata.plugin");
            this.f17521a = r3;
            this.f17522b = r4;
            this.c = r7;
            this.d = r6;
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__LimitKt$take$2$1$emit$1.class) == false) goto L7;
            FlowKt__LimitKt$take$2$1$emit$1 r0 = (FlowKt__LimitKt$take$2$1$emit$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__LimitKt$take$2$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 != 2) goto L14;
            ResultKt.throwOnFailure(r9);
        L27:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r9);
        L22:
            return Unit.INSTANCE;
        L16:
            ResultKt.throwOnFailure(r9);
            this.f17521a.element++;
            if (this.f17521a.element >= this.f17522b) goto L23;
            j<T> r5 = this.c;
            r0.label = 1;
            if (r5.emit(r6, r0) != r1) goto L22;
            return r1;
        L23:
            j<T> r10 = this.c;
            Object r11 = this.d;
            r0.label = 2;
            if (v.a(r10, r6, r11, r0) != r1) goto L27;
            return r1;
        L7:
            r0 = new FlowKt__LimitKt$take$2$1$emit$1(this, r8);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class h<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f17523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2 f17524b;

        public h(kotlinx.coroutines.flow.i r3, Function2 r4) {
            kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.f17523a = r5;
            this.f17524b = r6;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super T> r6, Continuation<? super Unit> r7) {
            j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r9, FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.class) == false) goto L7;
            FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1 r0 = (FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            i r5 = (i) ZeusTransformUtils.preCheckCast(r0.L$0, i.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);     // Catch: AbortFlowException -> L14
        L26:
            return Unit.INSTANCE;
        L14:
            e = e;
        L24:
            kotlinx.coroutines.flow.internal.o.a(e, r5);
            goto L26
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r10);
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.flow.i r12 = this.f17523a;
            i r4 = new i(this.f17524b, r8);
            j<? super T> r13 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L22
            r0.L$0 = r4;     // Catch: AbortFlowException -> L22
            r0.label = 1;     // Catch: AbortFlowException -> L22
            if (r12.collect(r13, r0) != r2) goto L26;
            return r2;
        L22:
            e = e;
            r5 = r4;
        L7:
            r0 = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1(this, r9);
            goto L8
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class i<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f17525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f17526b;

        public i(Function2 r3, j r4) {
            Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            this.f17525a = r5;
            this.f17526b = r6;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r8, Continuation<? super Unit> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1.class) == false) goto L7;
            FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1 r1 = (FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1.class, "com.obric.memorydata.plugin");
            if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
            r1.label -= Integer.MIN_VALUE;
        L8:
            Object r11 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            boolean r6 = true;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            i<T> this = (i) ZeusTransformUtils.preCheckCast(r1.L$0, i.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L25:
            if (r6 == false) goto L29;
            return Unit.INSTANCE;
        L29:
            throw new AbortFlowException(this);
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r8 = (T) r1.L$1;
            this = (i) ZeusTransformUtils.preCheckCast(r1.L$0, i.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L20:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
            j r12 = this.f17526b;
            r1.L$0 = this;
            r1.L$1 = null;
            r1.label = 2;
            if (r12.emit(r8, r1) != r3) goto L25;
            return r3;
        L24:
            r6 = false;
            goto L25
        L16:
            ResultKt.throwOnFailure(r11);
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
            Function2 r14 = this.f17525a;
            r1.L$0 = this;
            r1.L$1 = r8;
            r1.label = 1;
            InlineMarker.mark(6);
            r11 = r14.invoke(r8, r1);
            InlineMarker.mark(7);
            if (r11 != r3) goto L20;
            return r3;
        L7:
            r1 = new FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$1(this, r10);
            goto L8
        }
    }

    public static final <T> Object a(kotlinx.coroutines.flow.i<? extends T> r5, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r6, Continuation<? super Unit> r7) {
        kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, FlowKt__LimitKt$collectWhile$1.class) == false) goto L7;
        FlowKt__LimitKt$collectWhile$1 r0 = (FlowKt__LimitKt$collectWhile$1) ZeusTransformUtils.preCheckCast(r10, FlowKt__LimitKt$collectWhile$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: AbortFlowException -> L14
    L26:
        return Unit.INSTANCE;
    L14:
        e = e;
    L24:
        kotlinx.coroutines.flow.internal.o.a(e, r12);
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        a r13 = new a(r9);
        j<? super T> r14 = (j) ZeusTransformUtils.preCheckCast(r13, j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L22
        r0.L$0 = r13;     // Catch: AbortFlowException -> L22
        r0.label = 1;     // Catch: AbortFlowException -> L22
        if (r8.collect(r14, r0) != r2) goto L26;
        return r2;
    L22:
        e = e;
        r12 = r13;
    L7:
        r0 = new FlowKt__LimitKt$collectWhile$1(r10);
        goto L8
    }

    public static final /* synthetic */ Object a(j r2, Object r3, Object r4, Continuation r5) {
        return b((j) ZeusTransformUtils.wrapperContextForParams(r2, j.class, "com.obric.memorydata.plugin"), r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(kotlinx.coroutines.flow.i<? extends T> r2, int r3) {
        kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new b(r4, r3), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    L10:
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> kotlinx.coroutines.flow.i<T> a(kotlinx.coroutines.flow.i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Object b(j<? super T> r4, T r5, Object r6, Continuation<? super Unit> r7) {
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, FlowKt__LimitKt$emitAbort$1.class) == false) goto L7;
        FlowKt__LimitKt$emitAbort$1 r0 = (FlowKt__LimitKt$emitAbort$1) ZeusTransformUtils.preCheckCast(r9, FlowKt__LimitKt$emitAbort$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L12;
        r6 = r0.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        throw new AbortFlowException(r6);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = r6;
        r0.label = 1;
        if (r8.emit(r5, r0) != r1) goto L18;
        return r1;
    L7:
        r0 = new FlowKt__LimitKt$emitAbort$1(r9);
        goto L8
    }

    public static final <T> kotlinx.coroutines.flow.i<T> b(kotlinx.coroutines.flow.i<? extends T> r2, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new h((kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }
}
