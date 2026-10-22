package kotlin.reflect.full;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KCallables")
public final class KCallables {

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspend$1, reason: invalid class name */
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0}, l = {56}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspendBy$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.reflect.full.KCallables", f = "KCallables.kt", i = {0, 0, 0}, l = {74}, m = "callSuspendBy", n = {"$this$callSuspendBy", "args", "kCallable"}, s = {"L$0", "L$1", "L$2"})
    static final class C04091<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04091(Continuation<? super C04091> r10) {
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspendBy(null, null, this);
        }
    }

    @SinceKotlin(version = "1.3")
    public static final <R> Object callSuspend(KCallable<? extends R> r10, Object[] r11, Continuation<? super R> r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r13 = (AnonymousClass1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        Object[] r18 = (Object[]) r13.L$1;
        r10 = (KCallable) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L26:
        if (Intrinsics.areEqual(r10.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L28;
    L31:
        return r15;
    L28:
        if (r10.getReturnType().isMarkedNullable() == true) goto L31;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r10.isSuspend() == true) goto L19;
        return r10.call(Arrays.copyOf(r11, r11.length));
    L19:
        if ((r10 instanceof KFunction) == false) goto L33;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        SpreadBuilder r19 = new SpreadBuilder(2);
        r19.addSpread(r11);
        r19.add(r13);
        r15 = r10.call(r19.toArray(new Object[r19.size()]));
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L23:
        if (r15 != r16) goto L26;
        return r16;
    L33:
        throw new IllegalArgumentException("Cannot callSuspend on a property " + r10 + ": suspend properties are not supported yet");
    L7:
        r13 = new AnonymousClass1(r12);
        goto L8
    }

    @SinceKotlin(version = "1.3")
    public static final <R> Object callSuspendBy(KCallable<? extends R> r10, Map<KParameter, ? extends Object> r11, Continuation<? super R> r12) {
        if ((r12 instanceof C04091) == false) goto L7;
        C04091 r13 = (C04091) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        KCallableImpl r18 = (KCallableImpl) r13.L$2;
        Map r19 = (Map) r13.L$1;
        r10 = (KCallable) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L28:
        if (Intrinsics.areEqual(r10.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) == true) goto L30;
    L33:
        return r15;
    L30:
        if (r10.getReturnType().isMarkedNullable() == true) goto L33;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r10.isSuspend() == true) goto L19;
        return r10.callBy(r11);
    L19:
        if ((r10 instanceof KFunction) == false) goto L37;
        KCallableImpl<?> r20 = UtilKt.asKCallableImpl(r10);
        if (r20 == null) goto L35;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r20;
        r13.label = 1;
        r15 = r20.callDefaultMethod$kotlin_reflection(r11, r13);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L25:
        if (r15 != r16) goto L28;
        return r16;
    L35:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + r10);
    L37:
        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + r10 + ": suspend properties are not supported yet");
    L7:
        r13 = new C04091(r12);
        goto L8
    }

    @SinceKotlin(version = "1.1")
    public static final KParameter findParameterByName(KCallable<?> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Iterator<T> r12 = r10.getParameters().iterator();
        Object r13 = null;
        boolean r14 = false;
        Object r15 = null;
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r16 = r12.next();
        if (Intrinsics.areEqual(((KParameter) r16).getName(), r11) == false) goto L4;
        if (r14 == true) goto L14;
        r14 = true;
        r15 = r16;
    L14:
        return (KParameter) r13;
    L10:
        if (r14 == false) goto L14;
        r13 = r15;
        goto L14
    }

    public static final KParameter getExtensionReceiverParameter(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getParameters().iterator();
        Object r12 = null;
        boolean r13 = false;
        Object r14 = null;
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r15 = r11.next();
        if (((KParameter) r15).getKind() != KParameter.Kind.EXTENSION_RECEIVER) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == false) goto L4;
        if (r13 == true) goto L17;
        r13 = true;
        r14 = r15;
    L17:
        return (KParameter) r12;
    L8:
        r16 = false;
        goto L9
    L13:
        if (r13 == false) goto L17;
        r12 = r14;
        goto L17
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable r10) {
    }

    public static final KParameter getInstanceParameter(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getParameters().iterator();
        Object r12 = null;
        boolean r13 = false;
        Object r14 = null;
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r15 = r11.next();
        if (((KParameter) r15).getKind() != KParameter.Kind.INSTANCE) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == false) goto L4;
        if (r13 == true) goto L17;
        r13 = true;
        r14 = r15;
    L17:
        return (KParameter) r12;
    L8:
        r16 = false;
        goto L9
    L13:
        if (r13 == false) goto L17;
        r12 = r14;
        goto L17
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getInstanceParameter$annotations(KCallable r10) {
    }

    public static final List<KParameter> getValueParameters(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<KParameter> r11 = r10.getParameters();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (((KParameter) r14).getKind() != KParameter.Kind.VALUE) goto L8;
        boolean r15 = true;
    L9:
        if (r15 == false) goto L4;
        r12.add(r14);
        goto L4
    L8:
        r15 = false;
        goto L9
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getValueParameters$annotations(KCallable r10) {
    }
}
